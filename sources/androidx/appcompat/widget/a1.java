package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import m.h;
import org.xmlpull.v1.XmlPullParser;

public final class a1 {

    /* renamed from: h  reason: collision with root package name */
    private static final PorterDuff.Mode f1139h = PorterDuff.Mode.SRC_IN;

    /* renamed from: i  reason: collision with root package name */
    private static a1 f1140i;

    /* renamed from: j  reason: collision with root package name */
    private static final c f1141j = new c(6);

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap<Context, h<ColorStateList>> f1142a;

    /* renamed from: b  reason: collision with root package name */
    private m.g<String, e> f1143b;

    /* renamed from: c  reason: collision with root package name */
    private h<String> f1144c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakHashMap<Context, m.d<WeakReference<Drawable.ConstantState>>> f1145d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f1146e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1147f;

    /* renamed from: g  reason: collision with root package name */
    private f f1148g;

    static class a implements e {
        a() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return f.a.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e5) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e5);
                return null;
            }
        }
    }

    private static class b implements e {
        b() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e5) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e5);
                return null;
            }
        }
    }

    private static class c extends m.e<Integer, PorterDuffColorFilter> {
        public c(int i5) {
            super(i5);
        }

        private static int h(int i5, PorterDuff.Mode mode) {
            return ((i5 + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter i(int i5, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) c(Integer.valueOf(h(i5, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter j(int i5, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) d(Integer.valueOf(h(i5, mode)), porterDuffColorFilter);
        }
    }

    static class d implements e {
        d() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    drawable.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e5) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e5);
                }
            }
            return null;
        }
    }

    private interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface f {
        boolean a(Context context, int i5, Drawable drawable);

        PorterDuff.Mode b(int i5);

        Drawable c(a1 a1Var, Context context, int i5);

        ColorStateList d(Context context, int i5);

        boolean e(Context context, int i5, Drawable drawable);
    }

    private static class g implements e {
        g() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.g.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e5) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e5);
                return null;
            }
        }
    }

    private void a(String str, e eVar) {
        if (this.f1143b == null) {
            this.f1143b = new m.g<>();
        }
        this.f1143b.put(str, eVar);
    }

    private synchronized boolean b(Context context, long j5, Drawable drawable) {
        boolean z4;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            m.d dVar = this.f1145d.get(context);
            if (dVar == null) {
                dVar = new m.d();
                this.f1145d.put(context, dVar);
            }
            dVar.j(j5, new WeakReference(constantState));
            z4 = true;
        } else {
            z4 = false;
        }
        return z4;
    }

    private void c(Context context, int i5, ColorStateList colorStateList) {
        if (this.f1142a == null) {
            this.f1142a = new WeakHashMap<>();
        }
        h hVar = this.f1142a.get(context);
        if (hVar == null) {
            hVar = new h();
            this.f1142a.put(context, hVar);
        }
        hVar.a(i5, colorStateList);
    }

    private void d(Context context) {
        if (!this.f1147f) {
            this.f1147f = true;
            Drawable j5 = j(context, g.a.f4636a);
            if (j5 == null || !q(j5)) {
                this.f1147f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable f(Context context, int i5) {
        if (this.f1146e == null) {
            this.f1146e = new TypedValue();
        }
        TypedValue typedValue = this.f1146e;
        context.getResources().getValue(i5, typedValue, true);
        long e5 = e(typedValue);
        Drawable i6 = i(context, e5);
        if (i6 != null) {
            return i6;
        }
        f fVar = this.f1148g;
        Drawable c5 = fVar == null ? null : fVar.c(this, context, i5);
        if (c5 != null) {
            c5.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e5, c5);
        }
        return c5;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized a1 h() {
        a1 a1Var;
        synchronized (a1.class) {
            if (f1140i == null) {
                a1 a1Var2 = new a1();
                f1140i = a1Var2;
                p(a1Var2);
            }
            a1Var = f1140i;
        }
        return a1Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable i(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, m.d<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.f1145d     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            m.d r0 = (m.d) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.f(r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.k(r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.a1.i(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static synchronized PorterDuffColorFilter l(int i5, PorterDuff.Mode mode) {
        PorterDuffColorFilter i6;
        synchronized (a1.class) {
            c cVar = f1141j;
            i6 = cVar.i(i5, mode);
            if (i6 == null) {
                i6 = new PorterDuffColorFilter(i5, mode);
                cVar.j(i5, mode, i6);
            }
        }
        return i6;
    }

    private ColorStateList n(Context context, int i5) {
        h hVar;
        WeakHashMap<Context, h<ColorStateList>> weakHashMap = this.f1142a;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.f(i5);
    }

    private static void p(a1 a1Var) {
        if (Build.VERSION.SDK_INT < 24) {
            a1Var.a("vector", new g());
            a1Var.a("animated-vector", new b());
            a1Var.a("animated-selector", new a());
            a1Var.a("drawable", new d());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.g) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x00a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable r(android.content.Context r11, int r12) {
        /*
            r10 = this;
            m.g<java.lang.String, androidx.appcompat.widget.a1$e> r0 = r10.f1143b
            r1 = 0
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b2
            m.h<java.lang.String> r0 = r10.f1144c
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.f(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            m.g<java.lang.String, androidx.appcompat.widget.a1$e> r3 = r10.f1143b
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            m.h r0 = new m.h
            r0.<init>()
            r10.f1144c = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.f1146e
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.f1146e = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.f1146e
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = e(r0)
            android.graphics.drawable.Drawable r6 = r10.i(r11, r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00aa
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00aa
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x00a2 }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a2 }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x00a2 }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009a
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x00a2 }
            m.h<java.lang.String> r8 = r10.f1144c     // Catch:{ Exception -> 0x00a2 }
            r8.a(r12, r3)     // Catch:{ Exception -> 0x00a2 }
            m.g<java.lang.String, androidx.appcompat.widget.a1$e> r8 = r10.f1143b     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.appcompat.widget.a1$e r3 = (androidx.appcompat.widget.a1.e) r3     // Catch:{ Exception -> 0x00a2 }
            if (r3 == 0) goto L_0x008f
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x00a2 }
            android.graphics.drawable.Drawable r1 = r3.a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x00a2 }
            r6 = r1
        L_0x008f:
            if (r6 == 0) goto L_0x00aa
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a2 }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a2 }
            r10.b(r11, r4, r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00aa
        L_0x009a:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x00a2 }
            throw r11     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            r11 = move-exception
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00aa:
            if (r6 != 0) goto L_0x00b1
            m.h<java.lang.String> r11 = r10.f1144c
            r11.a(r12, r2)
        L_0x00b1:
            return r6
        L_0x00b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.a1.r(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private Drawable v(Context context, int i5, boolean z4, Drawable drawable) {
        ColorStateList m5 = m(context, i5);
        if (m5 != null) {
            if (o0.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable p5 = androidx.core.graphics.drawable.a.p(drawable);
            androidx.core.graphics.drawable.a.n(p5, m5);
            PorterDuff.Mode o5 = o(i5);
            if (o5 == null) {
                return p5;
            }
            androidx.core.graphics.drawable.a.o(p5, o5);
            return p5;
        }
        f fVar = this.f1148g;
        if ((fVar == null || !fVar.e(context, i5, drawable)) && !x(context, i5, drawable) && z4) {
            return null;
        }
        return drawable;
    }

    static void w(Drawable drawable, i1 i1Var, int[] iArr) {
        if (!o0.a(drawable) || drawable.mutate() == drawable) {
            boolean z4 = i1Var.f1290d;
            if (z4 || i1Var.f1289c) {
                drawable.setColorFilter(g(z4 ? i1Var.f1287a : null, i1Var.f1289c ? i1Var.f1288b : f1139h, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    public synchronized Drawable j(Context context, int i5) {
        return k(context, i5, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable k(Context context, int i5, boolean z4) {
        Drawable r5;
        d(context);
        r5 = r(context, i5);
        if (r5 == null) {
            r5 = f(context, i5);
        }
        if (r5 == null) {
            r5 = androidx.core.content.a.c(context, i5);
        }
        if (r5 != null) {
            r5 = v(context, i5, z4, r5);
        }
        if (r5 != null) {
            o0.b(r5);
        }
        return r5;
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList m(Context context, int i5) {
        ColorStateList n5;
        n5 = n(context, i5);
        if (n5 == null) {
            f fVar = this.f1148g;
            n5 = fVar == null ? null : fVar.d(context, i5);
            if (n5 != null) {
                c(context, i5, n5);
            }
        }
        return n5;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode o(int i5) {
        f fVar = this.f1148g;
        if (fVar == null) {
            return null;
        }
        return fVar.b(i5);
    }

    public synchronized void s(Context context) {
        m.d dVar = this.f1145d.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable t(Context context, q1 q1Var, int i5) {
        Drawable r5 = r(context, i5);
        if (r5 == null) {
            r5 = q1Var.d(i5);
        }
        if (r5 == null) {
            return null;
        }
        return v(context, i5, false, r5);
    }

    public synchronized void u(f fVar) {
        this.f1148g = fVar;
    }

    /* access modifiers changed from: package-private */
    public boolean x(Context context, int i5, Drawable drawable) {
        f fVar = this.f1148g;
        return fVar != null && fVar.a(context, i5, drawable);
    }
}
