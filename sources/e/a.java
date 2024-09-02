package e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.a1;
import java.util.WeakHashMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f4445a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<Object>> f4446b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f4447c = new Object();

    public static ColorStateList a(Context context, int i5) {
        return context.getColorStateList(i5);
    }

    public static Drawable b(Context context, int i5) {
        return a1.h().j(context, i5);
    }
}
