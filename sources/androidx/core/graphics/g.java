package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface$Builder;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.e;
import androidx.core.provider.g;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

public class g extends e {

    /* renamed from: g  reason: collision with root package name */
    protected final Class<?> f1723g;

    /* renamed from: h  reason: collision with root package name */
    protected final Constructor<?> f1724h;

    /* renamed from: i  reason: collision with root package name */
    protected final Method f1725i;

    /* renamed from: j  reason: collision with root package name */
    protected final Method f1726j;

    /* renamed from: k  reason: collision with root package name */
    protected final Method f1727k;

    /* renamed from: l  reason: collision with root package name */
    protected final Method f1728l;

    /* renamed from: m  reason: collision with root package name */
    protected final Method f1729m;

    public g() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> v5 = v();
            constructor = w(v5);
            method4 = s(v5);
            method3 = t(v5);
            method2 = x(v5);
            method = r(v5);
            Class<?> cls2 = v5;
            method5 = u(v5);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e5) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e5.getClass().getName(), e5);
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f1723g = cls;
        this.f1724h = constructor;
        this.f1725i = method4;
        this.f1726j = method3;
        this.f1727k = method2;
        this.f1728l = method;
        this.f1729m = method5;
    }

    private Object l() {
        try {
            return this.f1724h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void m(Object obj) {
        try {
            this.f1728l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean n(Context context, Object obj, String str, int i5, int i6, int i7, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f1725i.invoke(obj, new Object[]{context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean o(Object obj, ByteBuffer byteBuffer, int i5, int i6, int i7) {
        try {
            return ((Boolean) this.f1726j.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i5), null, Integer.valueOf(i6), Integer.valueOf(i7)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean p(Object obj) {
        try {
            return ((Boolean) this.f1727k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean q() {
        if (this.f1725i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f1725i != null;
    }

    public Typeface a(Context context, e.c cVar, Resources resources, int i5) {
        if (!q()) {
            return super.a(context, cVar, resources, i5);
        }
        Object l5 = l();
        if (l5 == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            if (!n(context, l5, dVar.a(), dVar.c(), dVar.e(), dVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d()))) {
                m(l5);
                return null;
            }
        }
        if (!p(l5)) {
            return null;
        }
        return i(l5);
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i5) {
        Typeface i6;
        ParcelFileDescriptor openFileDescriptor;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!q()) {
            g.b g5 = g(bVarArr, i5);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(g5.d(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface$Builder(openFileDescriptor.getFileDescriptor()).setWeight(g5.e()).setItalic(g5.f()).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            Map<Uri, ByteBuffer> h5 = k.h(context, bVarArr, cancellationSignal);
            Object l5 = l();
            if (l5 == null) {
                return null;
            }
            boolean z4 = false;
            for (g.b bVar : bVarArr) {
                ByteBuffer byteBuffer = h5.get(bVar.d());
                if (byteBuffer != null) {
                    if (!o(l5, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                        m(l5);
                        return null;
                    }
                    z4 = true;
                }
            }
            if (!z4) {
                m(l5);
                return null;
            } else if (p(l5) && (i6 = i(l5)) != null) {
                return Typeface.create(i6, i5);
            } else {
                return null;
            }
        }
        throw th;
    }

    public Typeface d(Context context, Resources resources, int i5, String str, int i6) {
        if (!q()) {
            return super.d(context, resources, i5, str, i6);
        }
        Object l5 = l();
        if (l5 == null) {
            return null;
        }
        if (!n(context, l5, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            m(l5);
            return null;
        } else if (!p(l5)) {
            return null;
        } else {
            return i(l5);
        }
    }

    /* access modifiers changed from: protected */
    public Typeface i(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f1723g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f1729m.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Method r(Class<?> cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method s(Class<?> cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }

    /* access modifiers changed from: protected */
    public Method t(Class<?> cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    /* access modifiers changed from: protected */
    public Method u(Class<?> cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    /* access modifiers changed from: protected */
    public Class<?> v() {
        return Class.forName("android.graphics.FontFamily");
    }

    /* access modifiers changed from: protected */
    public Constructor<?> w(Class<?> cls) {
        return cls.getConstructor(new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method x(Class<?> cls) {
        return cls.getMethod("freeze", new Class[0]);
    }
}
