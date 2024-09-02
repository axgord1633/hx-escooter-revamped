package b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import b0.l;

public abstract class n0 extends l {
    private static final String[] N = {"android:visibility:visibility", "android:visibility:parent"};
    private int M = 3;

    class a extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2936a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2937b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2938c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.f2936a = viewGroup;
            this.f2937b = view;
            this.f2938c = view2;
        }

        public void b(l lVar) {
            this.f2938c.setTag(i.f2890a, (Object) null);
            x.a(this.f2936a).c(this.f2937b);
            lVar.Q(this);
        }

        public void c(l lVar) {
            if (this.f2937b.getParent() == null) {
                x.a(this.f2936a).a(this.f2937b);
            } else {
                n0.this.g();
            }
        }

        public void d(l lVar) {
            x.a(this.f2936a).c(this.f2937b);
        }
    }

    private static class b extends AnimatorListenerAdapter implements l.f {

        /* renamed from: a  reason: collision with root package name */
        private final View f2940a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2941b;

        /* renamed from: c  reason: collision with root package name */
        private final ViewGroup f2942c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f2943d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2944e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2945f = false;

        b(View view, int i5, boolean z4) {
            this.f2940a = view;
            this.f2941b = i5;
            this.f2942c = (ViewGroup) view.getParent();
            this.f2943d = z4;
            g(true);
        }

        private void f() {
            if (!this.f2945f) {
                a0.h(this.f2940a, this.f2941b);
                ViewGroup viewGroup = this.f2942c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z4) {
            ViewGroup viewGroup;
            if (this.f2943d && this.f2944e != z4 && (viewGroup = this.f2942c) != null) {
                this.f2944e = z4;
                x.c(viewGroup, z4);
            }
        }

        public void a(l lVar) {
        }

        public void b(l lVar) {
            f();
            lVar.Q(this);
        }

        public void c(l lVar) {
            g(true);
        }

        public void d(l lVar) {
            g(false);
        }

        public void e(l lVar) {
        }

        public void onAnimationCancel(Animator animator) {
            this.f2945f = true;
        }

        public void onAnimationEnd(Animator animator) {
            f();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f2945f) {
                a0.h(this.f2940a, this.f2941b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f2945f) {
                a0.h(this.f2940a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f2946a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2947b;

        /* renamed from: c  reason: collision with root package name */
        int f2948c;

        /* renamed from: d  reason: collision with root package name */
        int f2949d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f2950e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f2951f;

        c() {
        }
    }

    private void d0(s sVar) {
        sVar.f2959a.put("android:visibility:visibility", Integer.valueOf(sVar.f2960b.getVisibility()));
        sVar.f2959a.put("android:visibility:parent", sVar.f2960b.getParent());
        int[] iArr = new int[2];
        sVar.f2960b.getLocationOnScreen(iArr);
        sVar.f2959a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        if (r9 == 0) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
        if (r0.f2950e == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0091, code lost:
        if (r0.f2948c == 0) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private b0.n0.c e0(b0.s r8, b0.s r9) {
        /*
            r7 = this;
            b0.n0$c r0 = new b0.n0$c
            r0.<init>()
            r1 = 0
            r0.f2946a = r1
            r0.f2947b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f2959a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f2959a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f2948c = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f2959a
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f2950e = r6
            goto L_0x0037
        L_0x0033:
            r0.f2948c = r4
            r0.f2950e = r3
        L_0x0037:
            if (r9 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Object> r6 = r9.f2959a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f2959a
            java.lang.Object r3 = r3.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.f2949d = r3
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f2959a
            java.lang.Object r2 = r3.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f2951f = r2
            goto L_0x005e
        L_0x005a:
            r0.f2949d = r4
            r0.f2951f = r3
        L_0x005e:
            r2 = 1
            if (r8 == 0) goto L_0x0082
            if (r9 == 0) goto L_0x0082
            int r8 = r0.f2948c
            int r9 = r0.f2949d
            if (r8 != r9) goto L_0x0070
            android.view.ViewGroup r3 = r0.f2950e
            android.view.ViewGroup r4 = r0.f2951f
            if (r3 != r4) goto L_0x0070
            return r0
        L_0x0070:
            if (r8 == r9) goto L_0x0078
            if (r8 != 0) goto L_0x0075
            goto L_0x0093
        L_0x0075:
            if (r9 != 0) goto L_0x0096
            goto L_0x0088
        L_0x0078:
            android.view.ViewGroup r8 = r0.f2951f
            if (r8 != 0) goto L_0x007d
            goto L_0x0093
        L_0x007d:
            android.view.ViewGroup r8 = r0.f2950e
            if (r8 != 0) goto L_0x0096
            goto L_0x0088
        L_0x0082:
            if (r8 != 0) goto L_0x008d
            int r8 = r0.f2949d
            if (r8 != 0) goto L_0x008d
        L_0x0088:
            r0.f2947b = r2
        L_0x008a:
            r0.f2946a = r2
            goto L_0x0096
        L_0x008d:
            if (r9 != 0) goto L_0x0096
            int r8 = r0.f2948c
            if (r8 != 0) goto L_0x0096
        L_0x0093:
            r0.f2947b = r1
            goto L_0x008a
        L_0x0096:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.n0.e0(b0.s, b0.s):b0.n0$c");
    }

    public String[] E() {
        return N;
    }

    public boolean G(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.f2959a.containsKey("android:visibility:visibility") != sVar.f2959a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c e02 = e0(sVar, sVar2);
        if (e02.f2946a) {
            return e02.f2948c == 0 || e02.f2949d == 0;
        }
        return false;
    }

    public abstract Animator f0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public Animator g0(ViewGroup viewGroup, s sVar, int i5, s sVar2, int i6) {
        if ((this.M & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f2960b.getParent();
            if (e0(u(view, false), F(view, false)).f2946a) {
                return null;
            }
        }
        return f0(viewGroup, sVar2.f2960b, sVar, sVar2);
    }

    public void h(s sVar) {
        d0(sVar);
    }

    public abstract Animator h0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (r0.f2918z != false) goto L_0x008b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator i0(android.view.ViewGroup r18, b0.s r19, int r20, b0.s r21, int r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r21
            r4 = r22
            int r5 = r0.M
            r6 = 2
            r5 = r5 & r6
            r7 = 0
            if (r5 == r6) goto L_0x0012
            return r7
        L_0x0012:
            if (r2 != 0) goto L_0x0015
            return r7
        L_0x0015:
            android.view.View r5 = r2.f2960b
            if (r3 == 0) goto L_0x001c
            android.view.View r8 = r3.f2960b
            goto L_0x001d
        L_0x001c:
            r8 = r7
        L_0x001d:
            int r9 = b0.i.f2890a
            java.lang.Object r10 = r5.getTag(r9)
            android.view.View r10 = (android.view.View) r10
            r11 = 0
            r12 = 1
            if (r10 == 0) goto L_0x002d
            r8 = r7
            r13 = r12
            goto L_0x0095
        L_0x002d:
            if (r8 == 0) goto L_0x0040
            android.view.ViewParent r10 = r8.getParent()
            if (r10 != 0) goto L_0x0036
            goto L_0x0040
        L_0x0036:
            r10 = 4
            if (r4 != r10) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            if (r5 != r8) goto L_0x0045
        L_0x003c:
            r10 = r8
            r13 = r11
            r8 = r7
            goto L_0x0048
        L_0x0040:
            if (r8 == 0) goto L_0x0045
            r10 = r7
            r13 = r11
            goto L_0x0048
        L_0x0045:
            r8 = r7
            r10 = r8
            r13 = r12
        L_0x0048:
            if (r13 == 0) goto L_0x008f
            android.view.ViewParent r13 = r5.getParent()
            if (r13 != 0) goto L_0x0051
            goto L_0x008b
        L_0x0051:
            android.view.ViewParent r13 = r5.getParent()
            boolean r13 = r13 instanceof android.view.View
            if (r13 == 0) goto L_0x008f
            android.view.ViewParent r13 = r5.getParent()
            android.view.View r13 = (android.view.View) r13
            b0.s r14 = r0.F(r13, r12)
            b0.s r15 = r0.u(r13, r12)
            b0.n0$c r14 = r0.e0(r14, r15)
            boolean r14 = r14.f2946a
            if (r14 != 0) goto L_0x0074
            android.view.View r8 = b0.r.a(r1, r5, r13)
            goto L_0x008f
        L_0x0074:
            int r14 = r13.getId()
            android.view.ViewParent r13 = r13.getParent()
            if (r13 != 0) goto L_0x008f
            r13 = -1
            if (r14 == r13) goto L_0x008f
            android.view.View r13 = r1.findViewById(r14)
            if (r13 == 0) goto L_0x008f
            boolean r13 = r0.f2918z
            if (r13 == 0) goto L_0x008f
        L_0x008b:
            r8 = r10
            r13 = r11
            r10 = r5
            goto L_0x0095
        L_0x008f:
            r13 = r11
            r16 = r10
            r10 = r8
            r8 = r16
        L_0x0095:
            if (r10 == 0) goto L_0x00e5
            if (r13 != 0) goto L_0x00c9
            java.util.Map<java.lang.String, java.lang.Object> r4 = r2.f2959a
            java.lang.String r7 = "android:visibility:screenLocation"
            java.lang.Object r4 = r4.get(r7)
            int[] r4 = (int[]) r4
            r7 = r4[r11]
            r4 = r4[r12]
            int[] r6 = new int[r6]
            r1.getLocationOnScreen(r6)
            r8 = r6[r11]
            int r7 = r7 - r8
            int r8 = r10.getLeft()
            int r7 = r7 - r8
            r10.offsetLeftAndRight(r7)
            r6 = r6[r12]
            int r4 = r4 - r6
            int r6 = r10.getTop()
            int r4 = r4 - r6
            r10.offsetTopAndBottom(r4)
            b0.v r4 = b0.x.a(r18)
            r4.a(r10)
        L_0x00c9:
            android.animation.Animator r2 = r0.h0(r1, r10, r2, r3)
            if (r13 != 0) goto L_0x00e4
            if (r2 != 0) goto L_0x00d9
            b0.v r1 = b0.x.a(r18)
            r1.c(r10)
            goto L_0x00e4
        L_0x00d9:
            r5.setTag(r9, r10)
            b0.n0$a r3 = new b0.n0$a
            r3.<init>(r1, r10, r5)
            r0.a(r3)
        L_0x00e4:
            return r2
        L_0x00e5:
            if (r8 == 0) goto L_0x0107
            int r5 = r8.getVisibility()
            b0.a0.h(r8, r11)
            android.animation.Animator r1 = r0.h0(r1, r8, r2, r3)
            if (r1 == 0) goto L_0x0103
            b0.n0$b r2 = new b0.n0$b
            r2.<init>(r8, r4, r12)
            r1.addListener(r2)
            b0.a.a(r1, r2)
            r0.a(r2)
            goto L_0x0106
        L_0x0103:
            b0.a0.h(r8, r5)
        L_0x0106:
            return r1
        L_0x0107:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.n0.i0(android.view.ViewGroup, b0.s, int, b0.s, int):android.animation.Animator");
    }

    public void j0(int i5) {
        if ((i5 & -4) == 0) {
            this.M = i5;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public void k(s sVar) {
        d0(sVar);
    }

    public Animator o(ViewGroup viewGroup, s sVar, s sVar2) {
        c e02 = e0(sVar, sVar2);
        if (!e02.f2946a) {
            return null;
        }
        if (e02.f2950e == null && e02.f2951f == null) {
            return null;
        }
        if (e02.f2947b) {
            return g0(viewGroup, sVar, e02.f2948c, sVar2, e02.f2949d);
        }
        return i0(viewGroup, sVar, e02.f2948c, sVar2, e02.f2949d);
    }
}
