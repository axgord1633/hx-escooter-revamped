package b0;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class f {
    static <T> ObjectAnimator a(T t5, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t5, property, (TypeConverter) null, path);
    }
}
