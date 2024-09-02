package androidx.window.layout;

import kotlin.jvm.internal.k;

final class EmptyDecorator implements WindowInfoTrackerDecorator {
    public static final EmptyDecorator INSTANCE = new EmptyDecorator();

    private EmptyDecorator() {
    }

    public WindowInfoTracker decorate(WindowInfoTracker windowInfoTracker) {
        k.e(windowInfoTracker, "tracker");
        return windowInfoTracker;
    }
}
