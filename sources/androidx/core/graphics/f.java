package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.e;
import androidx.core.provider.g;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

class f extends j {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f1719b;

    /* renamed from: c  reason: collision with root package name */
    private static final Constructor<?> f1720c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f1721d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f1722e;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class cls2 = Integer.TYPE;
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e5) {
            Log.e("TypefaceCompatApi24Impl", e5.getClass().getName(), e5);
            cls = null;
            method2 = null;
            method = null;
        }
        f1720c = constructor;
        f1719b = cls;
        f1721d = method;
        f1722e = method2;
    }

    f() {
    }

    private static boolean h(Object obj, ByteBuffer byteBuffer, int i5, int i6, boolean z4) {
        try {
            return ((Boolean) f1721d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i5), null, Integer.valueOf(i6), Boolean.valueOf(z4)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface i(Object obj) {
        try {
            Object newInstance = Array.newInstance(f1719b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f1722e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean j() {
        Method method = f1721d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object k() {
        try {
            return f1720c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Typeface a(Context context, e.c cVar, Resources resources, int i5) {
        Object k5 = k();
        if (k5 == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            ByteBuffer b5 = k.b(context, resources, dVar.b());
            if (b5 == null || !h(k5, b5, dVar.c(), dVar.e(), dVar.f())) {
                return null;
            }
        }
        return i(k5);
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i5) {
        Object k5 = k();
        if (k5 == null) {
            return null;
        }
        m.g gVar = new m.g();
        for (g.b bVar : bVarArr) {
            Uri d5 = bVar.d();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(d5);
            if (byteBuffer == null) {
                byteBuffer = k.f(context, cancellationSignal, d5);
                gVar.put(d5, byteBuffer);
            }
            if (byteBuffer == null || !h(k5, byteBuffer, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface i6 = i(k5);
        if (i6 == null) {
            return null;
        }
        return Typeface.create(i6, i5);
    }
}
