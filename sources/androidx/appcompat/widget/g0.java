package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.content.res.h;
import androidx.core.view.k0;
import com.yalantis.ucrop.view.CropImageView;
import d.j;
import java.lang.ref.WeakReference;

class g0 {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1240a;

    /* renamed from: b  reason: collision with root package name */
    private i1 f1241b;

    /* renamed from: c  reason: collision with root package name */
    private i1 f1242c;

    /* renamed from: d  reason: collision with root package name */
    private i1 f1243d;

    /* renamed from: e  reason: collision with root package name */
    private i1 f1244e;

    /* renamed from: f  reason: collision with root package name */
    private i1 f1245f;

    /* renamed from: g  reason: collision with root package name */
    private i1 f1246g;

    /* renamed from: h  reason: collision with root package name */
    private i1 f1247h;

    /* renamed from: i  reason: collision with root package name */
    private final i0 f1248i;

    /* renamed from: j  reason: collision with root package name */
    private int f1249j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f1250k = -1;

    /* renamed from: l  reason: collision with root package name */
    private Typeface f1251l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1252m;

    class a extends h.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1253a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1254b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WeakReference f1255c;

        a(int i5, int i6, WeakReference weakReference) {
            this.f1253a = i5;
            this.f1254b = i6;
            this.f1255c = weakReference;
        }

        public void h(int i5) {
        }

        public void i(Typeface typeface) {
            int i5;
            if (Build.VERSION.SDK_INT >= 28 && (i5 = this.f1253a) != -1) {
                typeface = Typeface.create(typeface, i5, (this.f1254b & 2) != 0);
            }
            g0.this.n(this.f1255c, typeface);
        }
    }

    class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ TextView f1257e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Typeface f1258f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f1259g;

        b(TextView textView, Typeface typeface, int i5) {
            this.f1257e = textView;
            this.f1258f = typeface;
            this.f1259g = i5;
        }

        public void run() {
            this.f1257e.setTypeface(this.f1258f, this.f1259g);
        }
    }

    g0(TextView textView) {
        this.f1240a = textView;
        this.f1248i = new i0(textView);
    }

    private void B(int i5, float f5) {
        this.f1248i.u(i5, f5);
    }

    private void C(Context context, k1 k1Var) {
        String n5;
        Typeface typeface;
        Typeface typeface2;
        this.f1249j = k1Var.j(j.M2, this.f1249j);
        int i5 = Build.VERSION.SDK_INT;
        boolean z4 = false;
        if (i5 >= 28) {
            int j5 = k1Var.j(j.O2, -1);
            this.f1250k = j5;
            if (j5 != -1) {
                this.f1249j = (this.f1249j & 2) | 0;
            }
        }
        int i6 = j.N2;
        if (k1Var.r(i6) || k1Var.r(j.P2)) {
            this.f1251l = null;
            int i7 = j.P2;
            if (k1Var.r(i7)) {
                i6 = i7;
            }
            int i8 = this.f1250k;
            int i9 = this.f1249j;
            if (!context.isRestricted()) {
                try {
                    Typeface i10 = k1Var.i(i6, this.f1249j, new a(i8, i9, new WeakReference(this.f1240a)));
                    if (i10 != null) {
                        if (i5 >= 28 && this.f1250k != -1) {
                            i10 = Typeface.create(Typeface.create(i10, 0), this.f1250k, (this.f1249j & 2) != 0);
                        }
                        this.f1251l = i10;
                    }
                    this.f1252m = this.f1251l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1251l == null && (n5 = k1Var.n(i6)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f1250k == -1) {
                    typeface = Typeface.create(n5, this.f1249j);
                } else {
                    Typeface create = Typeface.create(n5, 0);
                    int i11 = this.f1250k;
                    if ((this.f1249j & 2) != 0) {
                        z4 = true;
                    }
                    typeface = Typeface.create(create, i11, z4);
                }
                this.f1251l = typeface;
                return;
            }
            return;
        }
        int i12 = j.L2;
        if (k1Var.r(i12)) {
            this.f1252m = false;
            int j6 = k1Var.j(i12, 1);
            if (j6 == 1) {
                typeface2 = Typeface.SANS_SERIF;
            } else if (j6 == 2) {
                typeface2 = Typeface.SERIF;
            } else if (j6 == 3) {
                typeface2 = Typeface.MONOSPACE;
            } else {
                return;
            }
            this.f1251l = typeface2;
        }
    }

    private void a(Drawable drawable, i1 i1Var) {
        if (drawable != null && i1Var != null) {
            j.i(drawable, i1Var, this.f1240a.getDrawableState());
        }
    }

    private static i1 d(Context context, j jVar, int i5) {
        ColorStateList f5 = jVar.f(context, i5);
        if (f5 == null) {
            return null;
        }
        i1 i1Var = new i1();
        i1Var.f1290d = true;
        i1Var.f1287a = f5;
        return i1Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f1240a.getCompoundDrawablesRelative();
            TextView textView = this.f1240a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] compoundDrawablesRelative2 = this.f1240a.getCompoundDrawablesRelative();
            Drawable drawable7 = compoundDrawablesRelative2[0];
            if (drawable7 == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.f1240a.getCompoundDrawables();
                TextView textView2 = this.f1240a;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            TextView textView3 = this.f1240a;
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            Drawable drawable8 = compoundDrawablesRelative2[2];
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
        }
    }

    private void z() {
        i1 i1Var = this.f1247h;
        this.f1241b = i1Var;
        this.f1242c = i1Var;
        this.f1243d = i1Var;
        this.f1244e = i1Var;
        this.f1245f = i1Var;
        this.f1246g = i1Var;
    }

    /* access modifiers changed from: package-private */
    public void A(int i5, float f5) {
        if (!androidx.core.widget.b.f2053a && !l()) {
            B(i5, f5);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!(this.f1241b == null && this.f1242c == null && this.f1243d == null && this.f1244e == null)) {
            Drawable[] compoundDrawables = this.f1240a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1241b);
            a(compoundDrawables[1], this.f1242c);
            a(compoundDrawables[2], this.f1243d);
            a(compoundDrawables[3], this.f1244e);
        }
        if (this.f1245f != null || this.f1246g != null) {
            Drawable[] compoundDrawablesRelative = this.f1240a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f1245f);
            a(compoundDrawablesRelative[2], this.f1246g);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f1248i.a();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f1248i.g();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f1248i.h();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f1248i.i();
    }

    /* access modifiers changed from: package-private */
    public int[] h() {
        return this.f1248i.j();
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f1248i.k();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList j() {
        i1 i1Var = this.f1247h;
        if (i1Var != null) {
            return i1Var.f1287a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        i1 i1Var = this.f1247h;
        if (i1Var != null) {
            return i1Var.f1288b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f1248i.o();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x020a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(android.util.AttributeSet r20, int r21) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r21
            android.widget.TextView r0 = r7.f1240a
            android.content.Context r10 = r0.getContext()
            androidx.appcompat.widget.j r11 = androidx.appcompat.widget.j.b()
            int[] r2 = d.j.f4101a0
            r12 = 0
            androidx.appcompat.widget.k1 r13 = androidx.appcompat.widget.k1.u(r10, r8, r2, r9, r12)
            android.widget.TextView r0 = r7.f1240a
            android.content.Context r1 = r0.getContext()
            android.content.res.TypedArray r4 = r13.q()
            r6 = 0
            r3 = r20
            r5 = r21
            androidx.core.view.k0.M(r0, r1, r2, r3, r4, r5, r6)
            int r0 = d.j.f4106b0
            r14 = -1
            int r0 = r13.m(r0, r14)
            int r1 = d.j.f4121e0
            boolean r2 = r13.r(r1)
            if (r2 == 0) goto L_0x0042
            int r1 = r13.m(r1, r12)
            androidx.appcompat.widget.i1 r1 = d(r10, r11, r1)
            r7.f1241b = r1
        L_0x0042:
            int r1 = d.j.f4111c0
            boolean r2 = r13.r(r1)
            if (r2 == 0) goto L_0x0054
            int r1 = r13.m(r1, r12)
            androidx.appcompat.widget.i1 r1 = d(r10, r11, r1)
            r7.f1242c = r1
        L_0x0054:
            int r1 = d.j.f4126f0
            boolean r2 = r13.r(r1)
            if (r2 == 0) goto L_0x0066
            int r1 = r13.m(r1, r12)
            androidx.appcompat.widget.i1 r1 = d(r10, r11, r1)
            r7.f1243d = r1
        L_0x0066:
            int r1 = d.j.f4116d0
            boolean r2 = r13.r(r1)
            if (r2 == 0) goto L_0x0078
            int r1 = r13.m(r1, r12)
            androidx.appcompat.widget.i1 r1 = d(r10, r11, r1)
            r7.f1244e = r1
        L_0x0078:
            int r1 = android.os.Build.VERSION.SDK_INT
            int r2 = d.j.f4131g0
            boolean r3 = r13.r(r2)
            if (r3 == 0) goto L_0x008c
            int r2 = r13.m(r2, r12)
            androidx.appcompat.widget.i1 r2 = d(r10, r11, r2)
            r7.f1245f = r2
        L_0x008c:
            int r2 = d.j.f4136h0
            boolean r3 = r13.r(r2)
            if (r3 == 0) goto L_0x009e
            int r2 = r13.m(r2, r12)
            androidx.appcompat.widget.i1 r2 = d(r10, r11, r2)
            r7.f1246g = r2
        L_0x009e:
            r13.v()
            android.widget.TextView r2 = r7.f1240a
            android.text.method.TransformationMethod r2 = r2.getTransformationMethod()
            boolean r2 = r2 instanceof android.text.method.PasswordTransformationMethod
            r3 = 26
            if (r0 == r14) goto L_0x00ea
            int[] r5 = d.j.J2
            androidx.appcompat.widget.k1 r0 = androidx.appcompat.widget.k1.s(r10, r0, r5)
            if (r2 != 0) goto L_0x00c3
            int r5 = d.j.R2
            boolean r6 = r0.r(r5)
            if (r6 == 0) goto L_0x00c3
            boolean r5 = r0.a(r5, r12)
            r6 = 1
            goto L_0x00c5
        L_0x00c3:
            r5 = r12
            r6 = r5
        L_0x00c5:
            r7.C(r10, r0)
            int r15 = d.j.S2
            boolean r16 = r0.r(r15)
            if (r16 == 0) goto L_0x00d5
            java.lang.String r15 = r0.n(r15)
            goto L_0x00d6
        L_0x00d5:
            r15 = 0
        L_0x00d6:
            if (r1 < r3) goto L_0x00e5
            int r4 = d.j.Q2
            boolean r17 = r0.r(r4)
            if (r17 == 0) goto L_0x00e5
            java.lang.String r4 = r0.n(r4)
            goto L_0x00e6
        L_0x00e5:
            r4 = 0
        L_0x00e6:
            r0.v()
            goto L_0x00ee
        L_0x00ea:
            r5 = r12
            r6 = r5
            r4 = 0
            r15 = 0
        L_0x00ee:
            int[] r0 = d.j.J2
            androidx.appcompat.widget.k1 r0 = androidx.appcompat.widget.k1.u(r10, r8, r0, r9, r12)
            if (r2 != 0) goto L_0x0105
            int r13 = d.j.R2
            boolean r18 = r0.r(r13)
            if (r18 == 0) goto L_0x0105
            boolean r5 = r0.a(r13, r12)
            r16 = 1
            goto L_0x0107
        L_0x0105:
            r16 = r6
        L_0x0107:
            int r6 = d.j.S2
            boolean r13 = r0.r(r6)
            if (r13 == 0) goto L_0x0113
            java.lang.String r15 = r0.n(r6)
        L_0x0113:
            if (r1 < r3) goto L_0x0121
            int r3 = d.j.Q2
            boolean r6 = r0.r(r3)
            if (r6 == 0) goto L_0x0121
            java.lang.String r4 = r0.n(r3)
        L_0x0121:
            r3 = 28
            if (r1 < r3) goto L_0x0139
            int r3 = d.j.K2
            boolean r6 = r0.r(r3)
            if (r6 == 0) goto L_0x0139
            int r3 = r0.e(r3, r14)
            if (r3 != 0) goto L_0x0139
            android.widget.TextView r3 = r7.f1240a
            r6 = 0
            r3.setTextSize(r12, r6)
        L_0x0139:
            r7.C(r10, r0)
            r0.v()
            if (r2 != 0) goto L_0x0146
            if (r16 == 0) goto L_0x0146
            r7.s(r5)
        L_0x0146:
            android.graphics.Typeface r0 = r7.f1251l
            if (r0 == 0) goto L_0x015b
            int r2 = r7.f1250k
            if (r2 != r14) goto L_0x0156
            android.widget.TextView r2 = r7.f1240a
            int r3 = r7.f1249j
            r2.setTypeface(r0, r3)
            goto L_0x015b
        L_0x0156:
            android.widget.TextView r2 = r7.f1240a
            r2.setTypeface(r0)
        L_0x015b:
            if (r4 == 0) goto L_0x0162
            android.widget.TextView r0 = r7.f1240a
            boolean unused = r0.setFontVariationSettings(r4)
        L_0x0162:
            if (r15 == 0) goto L_0x0185
            r0 = 24
            if (r1 < r0) goto L_0x0172
            android.widget.TextView r0 = r7.f1240a
            android.os.LocaleList r1 = android.os.LocaleList.forLanguageTags(r15)
            r0.setTextLocales(r1)
            goto L_0x0185
        L_0x0172:
            r0 = 44
            int r0 = r15.indexOf(r0)
            java.lang.String r0 = r15.substring(r12, r0)
            android.widget.TextView r1 = r7.f1240a
            java.util.Locale r0 = java.util.Locale.forLanguageTag(r0)
            r1.setTextLocale(r0)
        L_0x0185:
            androidx.appcompat.widget.i0 r0 = r7.f1248i
            r0.p(r8, r9)
            boolean r0 = androidx.core.widget.b.f2053a
            if (r0 == 0) goto L_0x01c9
            androidx.appcompat.widget.i0 r0 = r7.f1248i
            int r0 = r0.k()
            if (r0 == 0) goto L_0x01c9
            androidx.appcompat.widget.i0 r0 = r7.f1248i
            int[] r0 = r0.j()
            int r1 = r0.length
            if (r1 <= 0) goto L_0x01c9
            android.widget.TextView r1 = r7.f1240a
            int r1 = r1.getAutoSizeStepGranularity()
            float r1 = (float) r1
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x01c4
            android.widget.TextView r0 = r7.f1240a
            androidx.appcompat.widget.i0 r1 = r7.f1248i
            int r1 = r1.h()
            androidx.appcompat.widget.i0 r2 = r7.f1248i
            int r2 = r2.g()
            androidx.appcompat.widget.i0 r3 = r7.f1248i
            int r3 = r3.i()
            r0.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r12)
            goto L_0x01c9
        L_0x01c4:
            android.widget.TextView r1 = r7.f1240a
            r1.setAutoSizeTextTypeUniformWithPresetSizes(r0, r12)
        L_0x01c9:
            int[] r0 = d.j.f4141i0
            androidx.appcompat.widget.k1 r8 = androidx.appcompat.widget.k1.t(r10, r8, r0)
            int r0 = d.j.f4181q0
            int r0 = r8.m(r0, r14)
            if (r0 == r14) goto L_0x01dd
            android.graphics.drawable.Drawable r0 = r11.c(r10, r0)
            r1 = r0
            goto L_0x01de
        L_0x01dd:
            r1 = 0
        L_0x01de:
            int r0 = d.j.f4206v0
            int r0 = r8.m(r0, r14)
            if (r0 == r14) goto L_0x01ec
            android.graphics.drawable.Drawable r0 = r11.c(r10, r0)
            r2 = r0
            goto L_0x01ed
        L_0x01ec:
            r2 = 0
        L_0x01ed:
            int r0 = d.j.f4186r0
            int r0 = r8.m(r0, r14)
            if (r0 == r14) goto L_0x01fb
            android.graphics.drawable.Drawable r0 = r11.c(r10, r0)
            r3 = r0
            goto L_0x01fc
        L_0x01fb:
            r3 = 0
        L_0x01fc:
            int r0 = d.j.f4171o0
            int r0 = r8.m(r0, r14)
            if (r0 == r14) goto L_0x020a
            android.graphics.drawable.Drawable r0 = r11.c(r10, r0)
            r4 = r0
            goto L_0x020b
        L_0x020a:
            r4 = 0
        L_0x020b:
            int r0 = d.j.f4191s0
            int r0 = r8.m(r0, r14)
            if (r0 == r14) goto L_0x0219
            android.graphics.drawable.Drawable r0 = r11.c(r10, r0)
            r5 = r0
            goto L_0x021a
        L_0x0219:
            r5 = 0
        L_0x021a:
            int r0 = d.j.f4176p0
            int r0 = r8.m(r0, r14)
            if (r0 == r14) goto L_0x0228
            android.graphics.drawable.Drawable r0 = r11.c(r10, r0)
            r6 = r0
            goto L_0x0229
        L_0x0228:
            r6 = 0
        L_0x0229:
            r0 = r19
            r0.y(r1, r2, r3, r4, r5, r6)
            int r0 = d.j.f4196t0
            boolean r1 = r8.r(r0)
            if (r1 == 0) goto L_0x023f
            android.content.res.ColorStateList r0 = r8.c(r0)
            android.widget.TextView r1 = r7.f1240a
            androidx.core.widget.k.f(r1, r0)
        L_0x023f:
            int r0 = d.j.f4201u0
            boolean r1 = r8.r(r0)
            if (r1 == 0) goto L_0x0255
            int r0 = r8.j(r0, r14)
            r1 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.o0.c(r0, r1)
            android.widget.TextView r1 = r7.f1240a
            androidx.core.widget.k.g(r1, r0)
        L_0x0255:
            int r0 = d.j.f4211w0
            int r0 = r8.e(r0, r14)
            int r1 = d.j.f4216x0
            int r1 = r8.e(r1, r14)
            int r2 = d.j.f4221y0
            int r2 = r8.e(r2, r14)
            r8.v()
            if (r0 == r14) goto L_0x0271
            android.widget.TextView r3 = r7.f1240a
            androidx.core.widget.k.h(r3, r0)
        L_0x0271:
            if (r1 == r14) goto L_0x0278
            android.widget.TextView r0 = r7.f1240a
            androidx.core.widget.k.i(r0, r1)
        L_0x0278:
            if (r2 == r14) goto L_0x027f
            android.widget.TextView r0 = r7.f1240a
            androidx.core.widget.k.j(r0, r2)
        L_0x027f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.g0.m(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f1252m) {
            this.f1251l = typeface;
            TextView textView = weakReference.get();
            if (textView == null) {
                return;
            }
            if (k0.A(textView)) {
                textView.post(new b(textView, typeface, this.f1249j));
            } else {
                textView.setTypeface(typeface, this.f1249j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z4, int i5, int i6, int i7, int i8) {
        if (!androidx.core.widget.b.f2053a) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* access modifiers changed from: package-private */
    public void q(Context context, int i5) {
        String n5;
        k1 s5 = k1.s(context, i5, j.J2);
        int i6 = j.R2;
        if (s5.r(i6)) {
            s(s5.a(i6, false));
        }
        int i7 = Build.VERSION.SDK_INT;
        int i8 = j.K2;
        if (s5.r(i8) && s5.e(i8, -1) == 0) {
            this.f1240a.setTextSize(0, CropImageView.DEFAULT_ASPECT_RATIO);
        }
        C(context, s5);
        if (i7 >= 26) {
            int i9 = j.Q2;
            if (s5.r(i9) && (n5 = s5.n(i9)) != null) {
                boolean unused = this.f1240a.setFontVariationSettings(n5);
            }
        }
        s5.v();
        Typeface typeface = this.f1251l;
        if (typeface != null) {
            this.f1240a.setTypeface(typeface, this.f1249j);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            r.b.f(editorInfo, textView.getText());
        }
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z4) {
        this.f1240a.setAllCaps(z4);
    }

    /* access modifiers changed from: package-private */
    public void t(int i5, int i6, int i7, int i8) {
        this.f1248i.q(i5, i6, i7, i8);
    }

    /* access modifiers changed from: package-private */
    public void u(int[] iArr, int i5) {
        this.f1248i.r(iArr, i5);
    }

    /* access modifiers changed from: package-private */
    public void v(int i5) {
        this.f1248i.s(i5);
    }

    /* access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        if (this.f1247h == null) {
            this.f1247h = new i1();
        }
        i1 i1Var = this.f1247h;
        i1Var.f1287a = colorStateList;
        i1Var.f1290d = colorStateList != null;
        z();
    }

    /* access modifiers changed from: package-private */
    public void x(PorterDuff.Mode mode) {
        if (this.f1247h == null) {
            this.f1247h = new i1();
        }
        i1 i1Var = this.f1247h;
        i1Var.f1288b = mode;
        i1Var.f1289c = mode != null;
        z();
    }
}
