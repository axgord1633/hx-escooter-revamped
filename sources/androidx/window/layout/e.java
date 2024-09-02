package androidx.window.layout;

import android.content.Context;
import androidx.window.layout.WindowInfoTracker;

public final /* synthetic */ class e {
    static {
        WindowInfoTracker.Companion companion = WindowInfoTracker.Companion;
    }

    public static WindowInfoTracker a(Context context) {
        return WindowInfoTracker.Companion.getOrCreate(context);
    }

    public static void b(WindowInfoTrackerDecorator windowInfoTrackerDecorator) {
        WindowInfoTracker.Companion.overrideDecorator(windowInfoTrackerDecorator);
    }

    public static void c() {
        WindowInfoTracker.Companion.reset();
    }
}
