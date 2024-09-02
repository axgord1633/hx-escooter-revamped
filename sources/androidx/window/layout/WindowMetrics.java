package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import kotlin.jvm.internal.k;

public final class WindowMetrics {
    private final Bounds _bounds;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WindowMetrics(Rect rect) {
        this(new Bounds(rect));
        k.e(rect, "bounds");
    }

    public WindowMetrics(Bounds bounds) {
        k.e(bounds, "_bounds");
        this._bounds = bounds;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !k.a(WindowMetrics.class, obj.getClass())) {
            return false;
        }
        return k.a(this._bounds, ((WindowMetrics) obj)._bounds);
    }

    public final Rect getBounds() {
        return this._bounds.toRect();
    }

    public int hashCode() {
        return this._bounds.hashCode();
    }

    public String toString() {
        return "WindowMetrics { bounds: " + getBounds() + " }";
    }
}
