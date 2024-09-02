package io.flutter.view;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Choreographer;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

public class VsyncWaiter {
    private static VsyncWaiter instance;
    private static DisplayListener listener;
    private final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate() {
        private Choreographer.FrameCallback obtainFrameCallback(long j5) {
            if (VsyncWaiter.this.frameCallback == null) {
                return new FrameCallback(j5);
            }
            long unused = VsyncWaiter.this.frameCallback.cookie = j5;
            FrameCallback access$200 = VsyncWaiter.this.frameCallback;
            FrameCallback unused2 = VsyncWaiter.this.frameCallback = null;
            return access$200;
        }

        public void asyncWaitForVsync(long j5) {
            Choreographer.getInstance().postFrameCallback(obtainFrameCallback(j5));
        }
    };
    /* access modifiers changed from: private */
    public FlutterJNI flutterJNI;
    /* access modifiers changed from: private */
    public FrameCallback frameCallback = new FrameCallback(0);
    /* access modifiers changed from: private */
    public long refreshPeriodNanos = -1;

    class DisplayListener implements DisplayManager.DisplayListener {
        private DisplayManager displayManager;

        DisplayListener(DisplayManager displayManager2) {
            this.displayManager = displayManager2;
        }

        public void onDisplayAdded(int i5) {
        }

        public void onDisplayChanged(int i5) {
            if (i5 == 0) {
                float refreshRate = this.displayManager.getDisplay(0).getRefreshRate();
                long unused = VsyncWaiter.this.refreshPeriodNanos = (long) (1.0E9d / ((double) refreshRate));
                VsyncWaiter.this.flutterJNI.setRefreshRateFPS(refreshRate);
            }
        }

        public void onDisplayRemoved(int i5) {
        }

        /* access modifiers changed from: package-private */
        public void register() {
            this.displayManager.registerDisplayListener(this, (Handler) null);
        }
    }

    private class FrameCallback implements Choreographer.FrameCallback {
        /* access modifiers changed from: private */
        public long cookie;

        FrameCallback(long j5) {
            this.cookie = j5;
        }

        public void doFrame(long j5) {
            long nanoTime = System.nanoTime() - j5;
            VsyncWaiter.this.flutterJNI.onVsync(nanoTime < 0 ? 0 : nanoTime, VsyncWaiter.this.refreshPeriodNanos, this.cookie);
            FrameCallback unused = VsyncWaiter.this.frameCallback = this;
        }
    }

    private VsyncWaiter(FlutterJNI flutterJNI2) {
        this.flutterJNI = flutterJNI2;
    }

    public static VsyncWaiter getInstance(float f5, FlutterJNI flutterJNI2) {
        if (instance == null) {
            instance = new VsyncWaiter(flutterJNI2);
        }
        flutterJNI2.setRefreshRateFPS(f5);
        VsyncWaiter vsyncWaiter = instance;
        vsyncWaiter.refreshPeriodNanos = (long) (1.0E9d / ((double) f5));
        return vsyncWaiter;
    }

    public static VsyncWaiter getInstance(DisplayManager displayManager, FlutterJNI flutterJNI2) {
        if (instance == null) {
            instance = new VsyncWaiter(flutterJNI2);
        }
        if (listener == null) {
            VsyncWaiter vsyncWaiter = instance;
            Objects.requireNonNull(vsyncWaiter);
            DisplayListener displayListener = new DisplayListener(displayManager);
            listener = displayListener;
            displayListener.register();
        }
        if (instance.refreshPeriodNanos == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            instance.refreshPeriodNanos = (long) (1.0E9d / ((double) refreshRate));
            flutterJNI2.setRefreshRateFPS(refreshRate);
        }
        return instance;
    }

    public static void reset() {
        instance = null;
        listener = null;
    }

    public void init() {
        this.flutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
    }
}
