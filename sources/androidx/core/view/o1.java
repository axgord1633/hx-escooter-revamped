package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets$Builder;
import android.view.WindowInsets$Type;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class o1 {

    /* renamed from: b  reason: collision with root package name */
    public static final o1 f1959b = (Build.VERSION.SDK_INT >= 30 ? k.f1989q : l.f1990b);

    /* renamed from: a  reason: collision with root package name */
    private final l f1960a;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Field f1961a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f1962b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f1963c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f1964d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f1961a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f1962b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f1963c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e5) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e5.getMessage(), e5);
            }
        }

        public static o1 a(View view) {
            if (f1964d && view.isAttachedToWindow()) {
                try {
                    Object obj = f1961a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f1962b.get(obj);
                        Rect rect2 = (Rect) f1963c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            o1 a5 = new b().b(androidx.core.graphics.b.c(rect)).c(androidx.core.graphics.b.c(rect2)).a();
                            a5.s(a5);
                            a5.d(view.getRootView());
                            return a5;
                        }
                    }
                } catch (IllegalAccessException e5) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e5.getMessage(), e5);
                }
            }
            return null;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final f f1965a;

        public b() {
            int i5 = Build.VERSION.SDK_INT;
            this.f1965a = i5 >= 30 ? new e() : i5 >= 29 ? new d() : new c();
        }

        public b(o1 o1Var) {
            int i5 = Build.VERSION.SDK_INT;
            this.f1965a = i5 >= 30 ? new e(o1Var) : i5 >= 29 ? new d(o1Var) : new c(o1Var);
        }

        public o1 a() {
            return this.f1965a.b();
        }

        @Deprecated
        public b b(androidx.core.graphics.b bVar) {
            this.f1965a.d(bVar);
            return this;
        }

        @Deprecated
        public b c(androidx.core.graphics.b bVar) {
            this.f1965a.f(bVar);
            return this;
        }
    }

    private static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private static Field f1966e = null;

        /* renamed from: f  reason: collision with root package name */
        private static boolean f1967f = false;

        /* renamed from: g  reason: collision with root package name */
        private static Constructor<WindowInsets> f1968g = null;

        /* renamed from: h  reason: collision with root package name */
        private static boolean f1969h = false;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsets f1970c;

        /* renamed from: d  reason: collision with root package name */
        private androidx.core.graphics.b f1971d;

        c() {
            this.f1970c = h();
        }

        c(o1 o1Var) {
            super(o1Var);
            this.f1970c = o1Var.u();
        }

        private static WindowInsets h() {
            if (!f1967f) {
                try {
                    f1966e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e5);
                }
                f1967f = true;
            }
            Field field = f1966e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e6) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e6);
                }
            }
            if (!f1969h) {
                try {
                    f1968g = WindowInsets.class.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException e7) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e7);
                }
                f1969h = true;
            }
            Constructor<WindowInsets> constructor = f1968g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException e8) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e8);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public o1 b() {
            a();
            o1 v5 = o1.v(this.f1970c);
            v5.q(this.f1974b);
            v5.t(this.f1971d);
            return v5;
        }

        /* access modifiers changed from: package-private */
        public void d(androidx.core.graphics.b bVar) {
            this.f1971d = bVar;
        }

        /* access modifiers changed from: package-private */
        public void f(androidx.core.graphics.b bVar) {
            WindowInsets windowInsets = this.f1970c;
            if (windowInsets != null) {
                this.f1970c = windowInsets.replaceSystemWindowInsets(bVar.f1692a, bVar.f1693b, bVar.f1694c, bVar.f1695d);
            }
        }
    }

    private static class d extends f {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets$Builder f1972c;

        d() {
            this.f1972c = new WindowInsets$Builder();
        }

        d(o1 o1Var) {
            super(o1Var);
            WindowInsets$Builder windowInsets$Builder;
            WindowInsets u5 = o1Var.u();
            if (u5 == null) {
                windowInsets$Builder = new WindowInsets$Builder();
            }
            this.f1972c = windowInsets$Builder;
        }

        /* access modifiers changed from: package-private */
        public o1 b() {
            a();
            o1 v5 = o1.v(this.f1972c.build());
            v5.q(this.f1974b);
            return v5;
        }

        /* access modifiers changed from: package-private */
        public void c(androidx.core.graphics.b bVar) {
            this.f1972c.setMandatorySystemGestureInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        public void d(androidx.core.graphics.b bVar) {
            this.f1972c.setStableInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        public void e(androidx.core.graphics.b bVar) {
            this.f1972c.setSystemGestureInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        public void f(androidx.core.graphics.b bVar) {
            this.f1972c.setSystemWindowInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        public void g(androidx.core.graphics.b bVar) {
            this.f1972c.setTappableElementInsets(bVar.e());
        }
    }

    private static class e extends d {
        e() {
        }

        e(o1 o1Var) {
            super(o1Var);
        }
    }

    private static class f {

        /* renamed from: a  reason: collision with root package name */
        private final o1 f1973a;

        /* renamed from: b  reason: collision with root package name */
        androidx.core.graphics.b[] f1974b;

        f() {
            this(new o1((o1) null));
        }

        f(o1 o1Var) {
            this.f1973a = o1Var;
        }

        /* access modifiers changed from: protected */
        public final void a() {
            androidx.core.graphics.b[] bVarArr = this.f1974b;
            if (bVarArr != null) {
                androidx.core.graphics.b bVar = bVarArr[m.b(1)];
                androidx.core.graphics.b bVar2 = this.f1974b[m.b(2)];
                if (bVar2 == null) {
                    bVar2 = this.f1973a.f(2);
                }
                if (bVar == null) {
                    bVar = this.f1973a.f(1);
                }
                f(androidx.core.graphics.b.a(bVar, bVar2));
                androidx.core.graphics.b bVar3 = this.f1974b[m.b(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                androidx.core.graphics.b bVar4 = this.f1974b[m.b(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                androidx.core.graphics.b bVar5 = this.f1974b[m.b(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public o1 b() {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void c(androidx.core.graphics.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void d(androidx.core.graphics.b bVar) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void e(androidx.core.graphics.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void f(androidx.core.graphics.b bVar) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void g(androidx.core.graphics.b bVar) {
        }
    }

    private static class g extends l {

        /* renamed from: h  reason: collision with root package name */
        private static boolean f1975h = false;

        /* renamed from: i  reason: collision with root package name */
        private static Method f1976i;

        /* renamed from: j  reason: collision with root package name */
        private static Class<?> f1977j;

        /* renamed from: k  reason: collision with root package name */
        private static Field f1978k;

        /* renamed from: l  reason: collision with root package name */
        private static Field f1979l;

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f1980c;

        /* renamed from: d  reason: collision with root package name */
        private androidx.core.graphics.b[] f1981d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.core.graphics.b f1982e;

        /* renamed from: f  reason: collision with root package name */
        private o1 f1983f;

        /* renamed from: g  reason: collision with root package name */
        androidx.core.graphics.b f1984g;

        g(o1 o1Var, WindowInsets windowInsets) {
            super(o1Var);
            this.f1982e = null;
            this.f1980c = windowInsets;
        }

        g(o1 o1Var, g gVar) {
            this(o1Var, new WindowInsets(gVar.f1980c));
        }

        private androidx.core.graphics.b u(int i5, boolean z4) {
            androidx.core.graphics.b bVar = androidx.core.graphics.b.f1691e;
            for (int i6 = 1; i6 <= 256; i6 <<= 1) {
                if ((i5 & i6) != 0) {
                    bVar = androidx.core.graphics.b.a(bVar, v(i6, z4));
                }
            }
            return bVar;
        }

        private androidx.core.graphics.b w() {
            o1 o1Var = this.f1983f;
            return o1Var != null ? o1Var.g() : androidx.core.graphics.b.f1691e;
        }

        private androidx.core.graphics.b x(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f1975h) {
                    z();
                }
                Method method = f1976i;
                if (!(method == null || f1977j == null || f1978k == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f1978k.get(f1979l.get(invoke));
                        if (rect != null) {
                            return androidx.core.graphics.b.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e5) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e5.getMessage(), e5);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        private static void z() {
            try {
                f1976i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f1977j = cls;
                f1978k = cls.getDeclaredField("mVisibleInsets");
                f1979l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f1978k.setAccessible(true);
                f1979l.setAccessible(true);
            } catch (ReflectiveOperationException e5) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e5.getMessage(), e5);
            }
            f1975h = true;
        }

        /* access modifiers changed from: package-private */
        public void d(View view) {
            androidx.core.graphics.b x4 = x(view);
            if (x4 == null) {
                x4 = androidx.core.graphics.b.f1691e;
            }
            r(x4);
        }

        /* access modifiers changed from: package-private */
        public void e(o1 o1Var) {
            o1Var.s(this.f1983f);
            o1Var.r(this.f1984g);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f1984g, ((g) obj).f1984g);
        }

        public androidx.core.graphics.b g(int i5) {
            return u(i5, false);
        }

        /* access modifiers changed from: package-private */
        public final androidx.core.graphics.b k() {
            if (this.f1982e == null) {
                this.f1982e = androidx.core.graphics.b.b(this.f1980c.getSystemWindowInsetLeft(), this.f1980c.getSystemWindowInsetTop(), this.f1980c.getSystemWindowInsetRight(), this.f1980c.getSystemWindowInsetBottom());
            }
            return this.f1982e;
        }

        /* access modifiers changed from: package-private */
        public o1 m(int i5, int i6, int i7, int i8) {
            b bVar = new b(o1.v(this.f1980c));
            bVar.c(o1.m(k(), i5, i6, i7, i8));
            bVar.b(o1.m(i(), i5, i6, i7, i8));
            return bVar.a();
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return this.f1980c.isRound();
        }

        /* access modifiers changed from: package-private */
        public boolean p(int i5) {
            for (int i6 = 1; i6 <= 256; i6 <<= 1) {
                if ((i5 & i6) != 0 && !y(i6)) {
                    return false;
                }
            }
            return true;
        }

        public void q(androidx.core.graphics.b[] bVarArr) {
            this.f1981d = bVarArr;
        }

        /* access modifiers changed from: package-private */
        public void r(androidx.core.graphics.b bVar) {
            this.f1984g = bVar;
        }

        /* access modifiers changed from: package-private */
        public void s(o1 o1Var) {
            this.f1983f = o1Var;
        }

        /* access modifiers changed from: protected */
        public androidx.core.graphics.b v(int i5, boolean z4) {
            int i6;
            if (i5 == 1) {
                return z4 ? androidx.core.graphics.b.b(0, Math.max(w().f1693b, k().f1693b), 0, 0) : androidx.core.graphics.b.b(0, k().f1693b, 0, 0);
            }
            androidx.core.graphics.b bVar = null;
            if (i5 != 2) {
                if (i5 == 8) {
                    androidx.core.graphics.b[] bVarArr = this.f1981d;
                    if (bVarArr != null) {
                        bVar = bVarArr[m.b(8)];
                    }
                    if (bVar != null) {
                        return bVar;
                    }
                    androidx.core.graphics.b k5 = k();
                    androidx.core.graphics.b w4 = w();
                    int i7 = k5.f1695d;
                    if (i7 > w4.f1695d) {
                        return androidx.core.graphics.b.b(0, 0, 0, i7);
                    }
                    androidx.core.graphics.b bVar2 = this.f1984g;
                    return (bVar2 == null || bVar2.equals(androidx.core.graphics.b.f1691e) || (i6 = this.f1984g.f1695d) <= w4.f1695d) ? androidx.core.graphics.b.f1691e : androidx.core.graphics.b.b(0, 0, 0, i6);
                } else if (i5 == 16) {
                    return j();
                } else {
                    if (i5 == 32) {
                        return h();
                    }
                    if (i5 == 64) {
                        return l();
                    }
                    if (i5 != 128) {
                        return androidx.core.graphics.b.f1691e;
                    }
                    o1 o1Var = this.f1983f;
                    d e5 = o1Var != null ? o1Var.e() : f();
                    return e5 != null ? androidx.core.graphics.b.b(e5.b(), e5.d(), e5.c(), e5.a()) : androidx.core.graphics.b.f1691e;
                }
            } else if (z4) {
                androidx.core.graphics.b w5 = w();
                androidx.core.graphics.b i8 = i();
                return androidx.core.graphics.b.b(Math.max(w5.f1692a, i8.f1692a), 0, Math.max(w5.f1694c, i8.f1694c), Math.max(w5.f1695d, i8.f1695d));
            } else {
                androidx.core.graphics.b k6 = k();
                o1 o1Var2 = this.f1983f;
                if (o1Var2 != null) {
                    bVar = o1Var2.g();
                }
                int i9 = k6.f1695d;
                if (bVar != null) {
                    i9 = Math.min(i9, bVar.f1695d);
                }
                return androidx.core.graphics.b.b(k6.f1692a, 0, k6.f1694c, i9);
            }
        }

        /* access modifiers changed from: protected */
        public boolean y(int i5) {
            if (!(i5 == 1 || i5 == 2)) {
                if (i5 == 4) {
                    return false;
                }
                if (!(i5 == 8 || i5 == 128)) {
                    return true;
                }
            }
            return !v(i5, false).equals(androidx.core.graphics.b.f1691e);
        }
    }

    private static class h extends g {

        /* renamed from: m  reason: collision with root package name */
        private androidx.core.graphics.b f1985m = null;

        h(o1 o1Var, WindowInsets windowInsets) {
            super(o1Var, windowInsets);
        }

        h(o1 o1Var, h hVar) {
            super(o1Var, (g) hVar);
            this.f1985m = hVar.f1985m;
        }

        /* access modifiers changed from: package-private */
        public o1 b() {
            return o1.v(this.f1980c.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        public o1 c() {
            return o1.v(this.f1980c.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        public final androidx.core.graphics.b i() {
            if (this.f1985m == null) {
                this.f1985m = androidx.core.graphics.b.b(this.f1980c.getStableInsetLeft(), this.f1980c.getStableInsetTop(), this.f1980c.getStableInsetRight(), this.f1980c.getStableInsetBottom());
            }
            return this.f1985m;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return this.f1980c.isConsumed();
        }

        public void t(androidx.core.graphics.b bVar) {
            this.f1985m = bVar;
        }
    }

    private static class i extends h {
        i(o1 o1Var, WindowInsets windowInsets) {
            super(o1Var, windowInsets);
        }

        i(o1 o1Var, i iVar) {
            super(o1Var, (h) iVar);
        }

        /* access modifiers changed from: package-private */
        public o1 a() {
            return o1.v(this.f1980c.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f1980c, iVar.f1980c) && Objects.equals(this.f1984g, iVar.f1984g);
        }

        /* access modifiers changed from: package-private */
        public d f() {
            return d.e(this.f1980c.getDisplayCutout());
        }

        public int hashCode() {
            return this.f1980c.hashCode();
        }
    }

    private static class j extends i {

        /* renamed from: n  reason: collision with root package name */
        private androidx.core.graphics.b f1986n = null;

        /* renamed from: o  reason: collision with root package name */
        private androidx.core.graphics.b f1987o = null;

        /* renamed from: p  reason: collision with root package name */
        private androidx.core.graphics.b f1988p = null;

        j(o1 o1Var, WindowInsets windowInsets) {
            super(o1Var, windowInsets);
        }

        j(o1 o1Var, j jVar) {
            super(o1Var, (i) jVar);
        }

        /* access modifiers changed from: package-private */
        public androidx.core.graphics.b h() {
            if (this.f1987o == null) {
                this.f1987o = androidx.core.graphics.b.d(this.f1980c.getMandatorySystemGestureInsets());
            }
            return this.f1987o;
        }

        /* access modifiers changed from: package-private */
        public androidx.core.graphics.b j() {
            if (this.f1986n == null) {
                this.f1986n = androidx.core.graphics.b.d(this.f1980c.getSystemGestureInsets());
            }
            return this.f1986n;
        }

        /* access modifiers changed from: package-private */
        public androidx.core.graphics.b l() {
            if (this.f1988p == null) {
                this.f1988p = androidx.core.graphics.b.d(this.f1980c.getTappableElementInsets());
            }
            return this.f1988p;
        }

        /* access modifiers changed from: package-private */
        public o1 m(int i5, int i6, int i7, int i8) {
            return o1.v(this.f1980c.inset(i5, i6, i7, i8));
        }

        public void t(androidx.core.graphics.b bVar) {
        }
    }

    private static class k extends j {

        /* renamed from: q  reason: collision with root package name */
        static final o1 f1989q = o1.v(WindowInsets.CONSUMED);

        k(o1 o1Var, WindowInsets windowInsets) {
            super(o1Var, windowInsets);
        }

        k(o1 o1Var, k kVar) {
            super(o1Var, (j) kVar);
        }

        /* access modifiers changed from: package-private */
        public final void d(View view) {
        }

        public androidx.core.graphics.b g(int i5) {
            return androidx.core.graphics.b.d(this.f1980c.getInsets(n.a(i5)));
        }

        public boolean p(int i5) {
            return this.f1980c.isVisible(n.a(i5));
        }
    }

    private static class l {

        /* renamed from: b  reason: collision with root package name */
        static final o1 f1990b = new b().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        final o1 f1991a;

        l(o1 o1Var) {
            this.f1991a = o1Var;
        }

        /* access modifiers changed from: package-private */
        public o1 a() {
            return this.f1991a;
        }

        /* access modifiers changed from: package-private */
        public o1 b() {
            return this.f1991a;
        }

        /* access modifiers changed from: package-private */
        public o1 c() {
            return this.f1991a;
        }

        /* access modifiers changed from: package-private */
        public void d(View view) {
        }

        /* access modifiers changed from: package-private */
        public void e(o1 o1Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && androidx.core.util.c.a(k(), lVar.k()) && androidx.core.util.c.a(i(), lVar.i()) && androidx.core.util.c.a(f(), lVar.f());
        }

        /* access modifiers changed from: package-private */
        public d f() {
            return null;
        }

        /* access modifiers changed from: package-private */
        public androidx.core.graphics.b g(int i5) {
            return androidx.core.graphics.b.f1691e;
        }

        /* access modifiers changed from: package-private */
        public androidx.core.graphics.b h() {
            return k();
        }

        public int hashCode() {
            return androidx.core.util.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        /* access modifiers changed from: package-private */
        public androidx.core.graphics.b i() {
            return androidx.core.graphics.b.f1691e;
        }

        /* access modifiers changed from: package-private */
        public androidx.core.graphics.b j() {
            return k();
        }

        /* access modifiers changed from: package-private */
        public androidx.core.graphics.b k() {
            return androidx.core.graphics.b.f1691e;
        }

        /* access modifiers changed from: package-private */
        public androidx.core.graphics.b l() {
            return k();
        }

        /* access modifiers changed from: package-private */
        public o1 m(int i5, int i6, int i7, int i8) {
            return f1990b;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean p(int i5) {
            return true;
        }

        public void q(androidx.core.graphics.b[] bVarArr) {
        }

        /* access modifiers changed from: package-private */
        public void r(androidx.core.graphics.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void s(o1 o1Var) {
        }

        public void t(androidx.core.graphics.b bVar) {
        }
    }

    public static final class m {
        public static int a() {
            return 8;
        }

        static int b(int i5) {
            if (i5 == 1) {
                return 0;
            }
            if (i5 == 2) {
                return 1;
            }
            if (i5 == 4) {
                return 2;
            }
            if (i5 == 8) {
                return 3;
            }
            if (i5 == 16) {
                return 4;
            }
            if (i5 == 32) {
                return 5;
            }
            if (i5 == 64) {
                return 6;
            }
            if (i5 == 128) {
                return 7;
            }
            if (i5 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i5);
        }
    }

    private static final class n {
        static int a(int i5) {
            int i6;
            int i7 = 0;
            for (int i8 = 1; i8 <= 256; i8 <<= 1) {
                if ((i5 & i8) != 0) {
                    if (i8 == 1) {
                        i6 = WindowInsets$Type.statusBars();
                    } else if (i8 == 2) {
                        i6 = WindowInsets$Type.navigationBars();
                    } else if (i8 == 4) {
                        i6 = WindowInsets$Type.captionBar();
                    } else if (i8 == 8) {
                        i6 = WindowInsets$Type.ime();
                    } else if (i8 == 16) {
                        i6 = WindowInsets$Type.systemGestures();
                    } else if (i8 == 32) {
                        i6 = WindowInsets$Type.mandatorySystemGestures();
                    } else if (i8 == 64) {
                        i6 = WindowInsets$Type.tappableElement();
                    } else if (i8 == 128) {
                        i6 = WindowInsets$Type.displayCutout();
                    }
                    i7 |= i6;
                }
            }
            return i7;
        }
    }

    private o1(WindowInsets windowInsets) {
        int i5 = Build.VERSION.SDK_INT;
        this.f1960a = i5 >= 30 ? new k(this, windowInsets) : i5 >= 29 ? new j(this, windowInsets) : i5 >= 28 ? new i(this, windowInsets) : new h(this, windowInsets);
    }

    public o1(o1 o1Var) {
        if (o1Var != null) {
            l lVar = o1Var.f1960a;
            int i5 = Build.VERSION.SDK_INT;
            this.f1960a = (i5 < 30 || !(lVar instanceof k)) ? (i5 < 29 || !(lVar instanceof j)) ? (i5 < 28 || !(lVar instanceof i)) ? lVar instanceof h ? new h(this, (h) lVar) : lVar instanceof g ? new g(this, (g) lVar) : new l(this) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
            lVar.e(this);
            return;
        }
        this.f1960a = new l(this);
    }

    static androidx.core.graphics.b m(androidx.core.graphics.b bVar, int i5, int i6, int i7, int i8) {
        int max = Math.max(0, bVar.f1692a - i5);
        int max2 = Math.max(0, bVar.f1693b - i6);
        int max3 = Math.max(0, bVar.f1694c - i7);
        int max4 = Math.max(0, bVar.f1695d - i8);
        return (max == i5 && max2 == i6 && max3 == i7 && max4 == i8) ? bVar : androidx.core.graphics.b.b(max, max2, max3, max4);
    }

    public static o1 v(WindowInsets windowInsets) {
        return w(windowInsets, (View) null);
    }

    public static o1 w(WindowInsets windowInsets, View view) {
        o1 o1Var = new o1((WindowInsets) androidx.core.util.d.h(windowInsets));
        if (view != null && k0.A(view)) {
            o1Var.s(k0.t(view));
            o1Var.d(view.getRootView());
        }
        return o1Var;
    }

    @Deprecated
    public o1 a() {
        return this.f1960a.a();
    }

    @Deprecated
    public o1 b() {
        return this.f1960a.b();
    }

    @Deprecated
    public o1 c() {
        return this.f1960a.c();
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        this.f1960a.d(view);
    }

    public d e() {
        return this.f1960a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1)) {
            return false;
        }
        return androidx.core.util.c.a(this.f1960a, ((o1) obj).f1960a);
    }

    public androidx.core.graphics.b f(int i5) {
        return this.f1960a.g(i5);
    }

    @Deprecated
    public androidx.core.graphics.b g() {
        return this.f1960a.i();
    }

    @Deprecated
    public int h() {
        return this.f1960a.k().f1695d;
    }

    public int hashCode() {
        l lVar = this.f1960a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f1960a.k().f1692a;
    }

    @Deprecated
    public int j() {
        return this.f1960a.k().f1694c;
    }

    @Deprecated
    public int k() {
        return this.f1960a.k().f1693b;
    }

    public o1 l(int i5, int i6, int i7, int i8) {
        return this.f1960a.m(i5, i6, i7, i8);
    }

    public boolean n() {
        return this.f1960a.n();
    }

    public boolean o(int i5) {
        return this.f1960a.p(i5);
    }

    @Deprecated
    public o1 p(int i5, int i6, int i7, int i8) {
        return new b(this).c(androidx.core.graphics.b.b(i5, i6, i7, i8)).a();
    }

    /* access modifiers changed from: package-private */
    public void q(androidx.core.graphics.b[] bVarArr) {
        this.f1960a.q(bVarArr);
    }

    /* access modifiers changed from: package-private */
    public void r(androidx.core.graphics.b bVar) {
        this.f1960a.r(bVar);
    }

    /* access modifiers changed from: package-private */
    public void s(o1 o1Var) {
        this.f1960a.s(o1Var);
    }

    /* access modifiers changed from: package-private */
    public void t(androidx.core.graphics.b bVar) {
        this.f1960a.t(bVar);
    }

    public WindowInsets u() {
        l lVar = this.f1960a;
        if (lVar instanceof g) {
            return ((g) lVar).f1980c;
        }
        return null;
    }
}
