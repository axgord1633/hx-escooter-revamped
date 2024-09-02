package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.SingleViewPresentation;

class VirtualDisplayController {
    private static String TAG = "VirtualDisplayController";
    private final AccessibilityEventsDelegate accessibilityEventsDelegate;
    private final Context context;
    private final int densityDpi;
    private final View.OnFocusChangeListener focusChangeListener;
    SingleViewPresentation presentation;
    private final PlatformViewRenderTarget renderTarget;
    private final int viewId;
    private VirtualDisplay virtualDisplay;

    static class OneTimeOnDrawListener implements ViewTreeObserver.OnDrawListener {
        Runnable mOnDrawRunnable;
        final View mView;

        OneTimeOnDrawListener(View view, Runnable runnable) {
            this.mView = view;
            this.mOnDrawRunnable = runnable;
        }

        static void schedule(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new OneTimeOnDrawListener(view, runnable));
        }

        public void onDraw() {
            Runnable runnable = this.mOnDrawRunnable;
            if (runnable != null) {
                runnable.run();
                this.mOnDrawRunnable = null;
                this.mView.post(new Runnable() {
                    public void run() {
                        OneTimeOnDrawListener.this.mView.getViewTreeObserver().removeOnDrawListener(OneTimeOnDrawListener.this);
                    }
                });
            }
        }
    }

    private VirtualDisplayController(Context context2, AccessibilityEventsDelegate accessibilityEventsDelegate2, VirtualDisplay virtualDisplay2, PlatformView platformView, PlatformViewRenderTarget platformViewRenderTarget, View.OnFocusChangeListener onFocusChangeListener, int i5, Object obj) {
        this.context = context2;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate2;
        this.renderTarget = platformViewRenderTarget;
        this.focusChangeListener = onFocusChangeListener;
        this.viewId = i5;
        this.virtualDisplay = virtualDisplay2;
        this.densityDpi = context2.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context2, this.virtualDisplay.getDisplay(), platformView, accessibilityEventsDelegate2, i5, onFocusChangeListener);
        this.presentation = singleViewPresentation;
        singleViewPresentation.show();
    }

    public static VirtualDisplayController create(Context context2, AccessibilityEventsDelegate accessibilityEventsDelegate2, PlatformView platformView, PlatformViewRenderTarget platformViewRenderTarget, int i5, int i6, int i7, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        if (i5 == 0 || i6 == 0) {
            return null;
        }
        Context context3 = context2;
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        platformViewRenderTarget.resize(i5, i6);
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context2.getSystemService("display")).createVirtualDisplay("flutter-vd#" + i7, i5, i6, displayMetrics.densityDpi, platformViewRenderTarget.getSurface(), 0);
        if (createVirtualDisplay == null) {
            return null;
        }
        return new VirtualDisplayController(context2, accessibilityEventsDelegate2, createVirtualDisplay, platformView, platformViewRenderTarget, onFocusChangeListener, i7, obj);
    }

    public void dispatchTouchEvent(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null) {
            singleViewPresentation.dispatchTouchEvent(motionEvent);
        }
    }

    public void dispose() {
        this.presentation.cancel();
        this.presentation.detachState();
        this.virtualDisplay.release();
        this.renderTarget.release();
    }

    public int getRenderTargetHeight() {
        PlatformViewRenderTarget platformViewRenderTarget = this.renderTarget;
        if (platformViewRenderTarget != null) {
            return platformViewRenderTarget.getHeight();
        }
        return 0;
    }

    public int getRenderTargetWidth() {
        PlatformViewRenderTarget platformViewRenderTarget = this.renderTarget;
        if (platformViewRenderTarget != null) {
            return platformViewRenderTarget.getWidth();
        }
        return 0;
    }

    public View getView() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }

    /* access modifiers changed from: package-private */
    public void onFlutterViewAttached(View view) {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onFlutterViewAttached(view);
        }
    }

    /* access modifiers changed from: package-private */
    public void onFlutterViewDetached() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onFlutterViewDetached();
        }
    }

    /* access modifiers changed from: package-private */
    public void onInputConnectionLocked() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onInputConnectionLocked();
        }
    }

    /* access modifiers changed from: package-private */
    public void onInputConnectionUnlocked() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onInputConnectionUnlocked();
        }
    }

    public void resize(int i5, int i6, Runnable runnable) {
        boolean isFocused = getView().isFocused();
        SingleViewPresentation.PresentationState detachState = this.presentation.detachState();
        this.virtualDisplay.setSurface((Surface) null);
        this.virtualDisplay.release();
        this.renderTarget.resize(i5, i6);
        this.virtualDisplay = ((DisplayManager) this.context.getSystemService("display")).createVirtualDisplay("flutter-vd#" + this.viewId, i5, i6, this.densityDpi, this.renderTarget.getSurface(), 0);
        final View view = getView();
        final Runnable runnable2 = runnable;
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
                OneTimeOnDrawListener.schedule(view, new Runnable() {
                    public void run() {
                        AnonymousClass1 r02 = AnonymousClass1.this;
                        view.postDelayed(runnable2, 128);
                    }
                });
                view.removeOnAttachStateChangeListener(this);
            }

            public void onViewDetachedFromWindow(View view) {
            }
        });
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.context, this.virtualDisplay.getDisplay(), this.accessibilityEventsDelegate, detachState, this.focusChangeListener, isFocused);
        singleViewPresentation.show();
        this.presentation.cancel();
        this.presentation = singleViewPresentation;
    }
}
