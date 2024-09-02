package androidx.window.layout;

import android.app.Activity;
import f4.b;
import f4.d;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public final WindowBackend windowBackend;
    private final WindowMetricsCalculator windowMetricsCalculator;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator2, WindowBackend windowBackend2) {
        k.e(windowMetricsCalculator2, "windowMetricsCalculator");
        k.e(windowBackend2, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator2;
        this.windowBackend = windowBackend2;
    }

    public b<WindowLayoutInfo> windowLayoutInfo(Activity activity) {
        k.e(activity, "activity");
        return d.a(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, activity, (o3.d<? super WindowInfoTrackerImpl$windowLayoutInfo$1>) null));
    }
}
