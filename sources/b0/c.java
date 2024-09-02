package b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.k0;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Map;

public class c extends l {
    private static final String[] P = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> Q = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> R = new C0050c(PointF.class, "topLeft");
    private static final Property<k, PointF> S = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> T = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> U = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> V = new g(PointF.class, "position");
    private static j W = new j();
    private int[] M = new int[2];
    private boolean N = false;
    private boolean O = false;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2839a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f2840b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2841c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f2842d;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f5) {
            this.f2839a = viewGroup;
            this.f2840b = bitmapDrawable;
            this.f2841c = view;
            this.f2842d = f5;
        }

        public void onAnimationEnd(Animator animator) {
            a0.b(this.f2839a).d(this.f2840b);
            a0.g(this.f2841c, this.f2842d);
        }
    }

    class b extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f2844a = new Rect();

        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f2844a);
            Rect rect = this.f2844a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f2844a);
            this.f2844a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f2844a);
        }
    }

    /* renamed from: b0.c$c  reason: collision with other inner class name */
    class C0050c extends Property<k, PointF> {
        C0050c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            a0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            a0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            a0.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f2845a;
        private k mViewBounds;

        h(k kVar) {
            this.f2845a = kVar;
            this.mViewBounds = kVar;
        }
    }

    class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2847a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2848b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f2849c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2850d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f2851e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f2852f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f2853g;

        i(View view, Rect rect, int i5, int i6, int i7, int i8) {
            this.f2848b = view;
            this.f2849c = rect;
            this.f2850d = i5;
            this.f2851e = i6;
            this.f2852f = i7;
            this.f2853g = i8;
        }

        public void onAnimationCancel(Animator animator) {
            this.f2847a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f2847a) {
                k0.S(this.f2848b, this.f2849c);
                a0.f(this.f2848b, this.f2850d, this.f2851e, this.f2852f, this.f2853g);
            }
        }
    }

    class j extends m {

        /* renamed from: a  reason: collision with root package name */
        boolean f2855a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2856b;

        j(ViewGroup viewGroup) {
            this.f2856b = viewGroup;
        }

        public void b(l lVar) {
            if (!this.f2855a) {
                x.c(this.f2856b, false);
            }
            lVar.Q(this);
        }

        public void c(l lVar) {
            x.c(this.f2856b, true);
        }

        public void d(l lVar) {
            x.c(this.f2856b, false);
        }

        public void e(l lVar) {
            x.c(this.f2856b, false);
            this.f2855a = true;
        }
    }

    private static class k {

        /* renamed from: a  reason: collision with root package name */
        private int f2858a;

        /* renamed from: b  reason: collision with root package name */
        private int f2859b;

        /* renamed from: c  reason: collision with root package name */
        private int f2860c;

        /* renamed from: d  reason: collision with root package name */
        private int f2861d;

        /* renamed from: e  reason: collision with root package name */
        private View f2862e;

        /* renamed from: f  reason: collision with root package name */
        private int f2863f;

        /* renamed from: g  reason: collision with root package name */
        private int f2864g;

        k(View view) {
            this.f2862e = view;
        }

        private void b() {
            a0.f(this.f2862e, this.f2858a, this.f2859b, this.f2860c, this.f2861d);
            this.f2863f = 0;
            this.f2864g = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f2860c = Math.round(pointF.x);
            this.f2861d = Math.round(pointF.y);
            int i5 = this.f2864g + 1;
            this.f2864g = i5;
            if (this.f2863f == i5) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(PointF pointF) {
            this.f2858a = Math.round(pointF.x);
            this.f2859b = Math.round(pointF.y);
            int i5 = this.f2863f + 1;
            this.f2863f = i5;
            if (i5 == this.f2864g) {
                b();
            }
        }
    }

    private void d0(s sVar) {
        View view = sVar.f2960b;
        if (k0.B(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            sVar.f2959a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            sVar.f2959a.put("android:changeBounds:parent", sVar.f2960b.getParent());
            if (this.O) {
                sVar.f2960b.getLocationInWindow(this.M);
                sVar.f2959a.put("android:changeBounds:windowX", Integer.valueOf(this.M[0]));
                sVar.f2959a.put("android:changeBounds:windowY", Integer.valueOf(this.M[1]));
            }
            if (this.N) {
                sVar.f2959a.put("android:changeBounds:clip", k0.n(view));
            }
        }
    }

    private boolean e0(View view, View view2) {
        if (!this.O) {
            return true;
        }
        s u5 = u(view, true);
        if (u5 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == u5.f2960b) {
            return true;
        }
        return false;
    }

    public String[] E() {
        return P;
    }

    public void h(s sVar) {
        d0(sVar);
    }

    public void k(s sVar) {
        d0(sVar);
    }

    public Animator o(ViewGroup viewGroup, s sVar, s sVar2) {
        int i5;
        View view;
        Animator animator;
        int i6;
        Rect rect;
        ObjectAnimator objectAnimator;
        Property<View, PointF> property;
        Path path;
        s sVar3 = sVar;
        s sVar4 = sVar2;
        if (sVar3 == null || sVar4 == null) {
            return null;
        }
        Map<String, Object> map = sVar3.f2959a;
        Map<String, Object> map2 = sVar4.f2959a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar4.f2960b;
        if (e0(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) sVar3.f2959a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) sVar4.f2959a.get("android:changeBounds:bounds");
            int i7 = rect2.left;
            int i8 = rect3.left;
            int i9 = rect2.top;
            int i10 = rect3.top;
            int i11 = rect2.right;
            int i12 = rect3.right;
            int i13 = rect2.bottom;
            int i14 = rect3.bottom;
            int i15 = i11 - i7;
            int i16 = i13 - i9;
            int i17 = i12 - i8;
            int i18 = i14 - i10;
            View view3 = view2;
            Rect rect4 = (Rect) sVar3.f2959a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) sVar4.f2959a.get("android:changeBounds:clip");
            if ((i15 == 0 || i16 == 0) && (i17 == 0 || i18 == 0)) {
                i5 = 0;
            } else {
                i5 = (i7 == i8 && i9 == i10) ? 0 : 1;
                if (!(i11 == i12 && i13 == i14)) {
                    i5++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i5++;
            }
            if (i5 <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            Rect rect7 = rect4;
            if (!this.N) {
                view = view3;
                a0.f(view, i7, i9, i11, i13);
                if (i5 == 2) {
                    if (i15 == i17 && i16 == i18) {
                        path = w().a((float) i7, (float) i9, (float) i8, (float) i10);
                        property = V;
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator a5 = f.a(kVar, R, w().a((float) i7, (float) i9, (float) i8, (float) i10));
                        ObjectAnimator a6 = f.a(kVar, S, w().a((float) i11, (float) i13, (float) i12, (float) i14));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a5, a6});
                        animatorSet.addListener(new h(kVar));
                        animator = animatorSet;
                    }
                } else if (i7 == i8 && i9 == i10) {
                    path = w().a((float) i11, (float) i13, (float) i12, (float) i14);
                    property = T;
                } else {
                    path = w().a((float) i7, (float) i9, (float) i8, (float) i10);
                    property = U;
                }
                animator = f.a(view, property, path);
            } else {
                view = view3;
                a0.f(view, i7, i9, Math.max(i15, i17) + i7, Math.max(i16, i18) + i9);
                ObjectAnimator a7 = (i7 == i8 && i9 == i10) ? null : f.a(view, V, w().a((float) i7, (float) i9, (float) i8, (float) i10));
                if (rect7 == null) {
                    i6 = 0;
                    rect = new Rect(0, 0, i15, i16);
                } else {
                    i6 = 0;
                    rect = rect7;
                }
                Rect rect8 = rect6 == null ? new Rect(i6, i6, i17, i18) : rect6;
                if (!rect.equals(rect8)) {
                    k0.S(view, rect);
                    j jVar = W;
                    Object[] objArr = new Object[2];
                    objArr[i6] = rect;
                    objArr[1] = rect8;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", jVar, objArr);
                    ofObject.addListener(new i(view, rect6, i8, i10, i12, i14));
                    objectAnimator = ofObject;
                } else {
                    objectAnimator = null;
                }
                animator = r.c(a7, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                x.c(viewGroup4, true);
                a(new j(viewGroup4));
            }
            return animator;
        }
        int intValue = ((Integer) sVar3.f2959a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) sVar3.f2959a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) sVar4.f2959a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) sVar4.f2959a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.M);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c5 = a0.c(view2);
        a0.g(view2, CropImageView.DEFAULT_ASPECT_RATIO);
        a0.b(viewGroup).b(bitmapDrawable);
        g w4 = w();
        int[] iArr = this.M;
        int i19 = iArr[0];
        int i20 = iArr[1];
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{h.a(Q, w4.a((float) (intValue - i19), (float) (intValue2 - i20), (float) (intValue3 - i19), (float) (intValue4 - i20)))});
        ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, c5));
        return ofPropertyValuesHolder;
    }
}
