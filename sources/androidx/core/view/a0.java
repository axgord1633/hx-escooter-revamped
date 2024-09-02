package androidx.core.view;

import android.view.MotionEvent;

public final class a0 {
    public static boolean a(MotionEvent motionEvent, int i5) {
        return (motionEvent.getSource() & i5) == i5;
    }
}
