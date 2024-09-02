package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final m.a<String, Method> f2811a;

    /* renamed from: b  reason: collision with root package name */
    protected final m.a<String, Method> f2812b;

    /* renamed from: c  reason: collision with root package name */
    protected final m.a<String, Class> f2813c;

    public a(m.a<String, Method> aVar, m.a<String, Method> aVar2, m.a<String, Class> aVar3) {
        this.f2811a = aVar;
        this.f2812b = aVar2;
        this.f2813c = aVar3;
    }

    private void N(c0.a aVar) {
        try {
            I(c(aVar.getClass()).getName());
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(aVar.getClass().getSimpleName() + " does not have a Parcelizer", e5);
        }
    }

    private Class c(Class<? extends c0.a> cls) {
        Class cls2 = this.f2813c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f2813c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) {
        Class<a> cls = a.class;
        Method method = this.f2811a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.f2811a.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method e(Class cls) {
        Method method = this.f2812b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c5 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c5.getDeclaredMethod("write", new Class[]{cls, a.class});
        this.f2812b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* access modifiers changed from: protected */
    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i5) {
        w(i5);
        A(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i5) {
        w(i5);
        C(charSequence);
    }

    /* access modifiers changed from: protected */
    public abstract void E(int i5);

    public void F(int i5, int i6) {
        w(i6);
        E(i5);
    }

    /* access modifiers changed from: protected */
    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i5) {
        w(i5);
        G(parcelable);
    }

    /* access modifiers changed from: protected */
    public abstract void I(String str);

    public void J(String str, int i5) {
        w(i5);
        I(str);
    }

    /* access modifiers changed from: protected */
    public <T extends c0.a> void K(T t5, a aVar) {
        try {
            e(t5.getClass()).invoke((Object) null, new Object[]{t5, aVar});
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e8);
        }
    }

    /* access modifiers changed from: protected */
    public void L(c0.a aVar) {
        if (aVar == null) {
            I((String) null);
            return;
        }
        N(aVar);
        a b5 = b();
        K(aVar, b5);
        b5.a();
    }

    public void M(c0.a aVar, int i5) {
        w(i5);
        L(aVar);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract a b();

    public boolean f() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean g();

    public boolean h(boolean z4, int i5) {
        return !m(i5) ? z4 : g();
    }

    /* access modifiers changed from: protected */
    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i5) {
        return !m(i5) ? bArr : i();
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i5) {
        return !m(i5) ? charSequence : k();
    }

    /* access modifiers changed from: protected */
    public abstract boolean m(int i5);

    /* access modifiers changed from: protected */
    public <T extends c0.a> T n(String str, a aVar) {
        try {
            return (c0.a) d(str).invoke((Object) null, new Object[]{aVar});
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e8);
        }
    }

    /* access modifiers changed from: protected */
    public abstract int o();

    public int p(int i5, int i6) {
        return !m(i6) ? i5 : o();
    }

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t5, int i5) {
        return !m(i5) ? t5 : q();
    }

    /* access modifiers changed from: protected */
    public abstract String s();

    public String t(String str, int i5) {
        return !m(i5) ? str : s();
    }

    /* access modifiers changed from: protected */
    public <T extends c0.a> T u() {
        String s5 = s();
        if (s5 == null) {
            return null;
        }
        return n(s5, b());
    }

    public <T extends c0.a> T v(T t5, int i5) {
        return !m(i5) ? t5 : u();
    }

    /* access modifiers changed from: protected */
    public abstract void w(int i5);

    public void x(boolean z4, boolean z5) {
    }

    /* access modifiers changed from: protected */
    public abstract void y(boolean z4);

    public void z(boolean z4, int i5) {
        w(i5);
        y(z4);
    }
}
