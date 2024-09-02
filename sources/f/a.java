package f;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.a1;
import androidx.core.content.res.l;
import com.yalantis.ucrop.view.CropImageView;
import f.b;
import f.d;
import m.h;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a extends d {

    /* renamed from: x  reason: collision with root package name */
    private static final String f4541x = a.class.getSimpleName();

    /* renamed from: s  reason: collision with root package name */
    private c f4542s;

    /* renamed from: t  reason: collision with root package name */
    private g f4543t;

    /* renamed from: u  reason: collision with root package name */
    private int f4544u;

    /* renamed from: v  reason: collision with root package name */
    private int f4545v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f4546w;

    private static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f4547a;

        b(Animatable animatable) {
            super();
            this.f4547a = animatable;
        }

        public void c() {
            this.f4547a.start();
        }

        public void d() {
            this.f4547a.stop();
        }
    }

    static class c extends d.a {
        m.d<Long> K;
        h<Integer> L;

        c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            h<Integer> hVar;
            if (cVar != null) {
                this.K = cVar.K;
                hVar = cVar.L;
            } else {
                this.K = new m.d<>();
                hVar = new h<>();
            }
            this.L = hVar;
        }

        private static long D(int i5, int i6) {
            return ((long) i6) | (((long) i5) << 32);
        }

        /* access modifiers changed from: package-private */
        public int B(int[] iArr, Drawable drawable, int i5) {
            int z4 = super.z(iArr, drawable);
            this.L.i(z4, Integer.valueOf(i5));
            return z4;
        }

        /* access modifiers changed from: package-private */
        public int C(int i5, int i6, Drawable drawable, boolean z4) {
            int a5 = super.a(drawable);
            long D = D(i5, i6);
            long j5 = z4 ? 8589934592L : 0;
            long j6 = (long) a5;
            this.K.a(D, Long.valueOf(j6 | j5));
            if (z4) {
                this.K.a(D(i6, i5), Long.valueOf(4294967296L | j6 | j5));
            }
            return a5;
        }

        /* access modifiers changed from: package-private */
        public int E(int i5) {
            if (i5 < 0) {
                return 0;
            }
            return this.L.g(i5, 0).intValue();
        }

        /* access modifiers changed from: package-private */
        public int F(int[] iArr) {
            int A = super.A(iArr);
            return A >= 0 ? A : super.A(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        public int G(int i5, int i6) {
            return (int) this.K.g(D(i5, i6), -1L).longValue();
        }

        /* access modifiers changed from: package-private */
        public boolean H(int i5, int i6) {
            return (this.K.g(D(i5, i6), -1L).longValue() & 4294967296L) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean I(int i5, int i6) {
            return (this.K.g(D(i5, i6), -1L).longValue() & 8589934592L) != 0;
        }

        public Drawable newDrawable() {
            return new a(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }

        /* access modifiers changed from: package-private */
        public void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }
    }

    private static class d extends g {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.vectordrawable.graphics.drawable.b f4548a;

        d(androidx.vectordrawable.graphics.drawable.b bVar) {
            super();
            this.f4548a = bVar;
        }

        public void c() {
            this.f4548a.start();
        }

        public void d() {
            this.f4548a.stop();
        }
    }

    private static class e extends g {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f4549a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f4550b;

        e(AnimationDrawable animationDrawable, boolean z4, boolean z5) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i5 = z4 ? numberOfFrames - 1 : 0;
            int i6 = z4 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z4);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i5, i6});
            ofInt.setAutoCancel(true);
            ofInt.setDuration((long) fVar.a());
            ofInt.setInterpolator(fVar);
            this.f4550b = z5;
            this.f4549a = ofInt;
        }

        public boolean a() {
            return this.f4550b;
        }

        public void b() {
            this.f4549a.reverse();
        }

        public void c() {
            this.f4549a.start();
        }

        public void d() {
            this.f4549a.cancel();
        }
    }

    private static class f implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f4551a;

        /* renamed from: b  reason: collision with root package name */
        private int f4552b;

        /* renamed from: c  reason: collision with root package name */
        private int f4553c;

        f(AnimationDrawable animationDrawable, boolean z4) {
            b(animationDrawable, z4);
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f4553c;
        }

        /* access modifiers changed from: package-private */
        public int b(AnimationDrawable animationDrawable, boolean z4) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f4552b = numberOfFrames;
            int[] iArr = this.f4551a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f4551a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f4551a;
            int i5 = 0;
            for (int i6 = 0; i6 < numberOfFrames; i6++) {
                int duration = animationDrawable.getDuration(z4 ? (numberOfFrames - i6) - 1 : i6);
                iArr2[i6] = duration;
                i5 += duration;
            }
            this.f4553c = i5;
            return i5;
        }

        public float getInterpolation(float f5) {
            int i5 = (int) ((f5 * ((float) this.f4553c)) + 0.5f);
            int i6 = this.f4552b;
            int[] iArr = this.f4551a;
            int i7 = 0;
            while (i7 < i6) {
                int i8 = iArr[i7];
                if (i5 < i8) {
                    break;
                }
                i5 -= i8;
                i7++;
            }
            return (((float) i7) / ((float) i6)) + (i7 < i6 ? ((float) i5) / ((float) this.f4553c) : CropImageView.DEFAULT_ASPECT_RATIO);
        }
    }

    private static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this((c) null, (Resources) null);
    }

    a(c cVar, Resources resources) {
        super((d.a) null);
        this.f4544u = -1;
        this.f4545v = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.n(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        q(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        r(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void p() {
        onStateChange(getState());
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray k5 = l.k(resources, theme, attributeSet, g.b.f4644h);
        int resourceId = k5.getResourceId(g.b.f4645i, 0);
        int resourceId2 = k5.getResourceId(g.b.f4646j, -1);
        Drawable j5 = resourceId2 > 0 ? a1.h().j(context, resourceId2) : null;
        k5.recycle();
        int[] k6 = k(attributeSet);
        if (j5 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                j5 = xmlPullParser.getName().equals("vector") ? androidx.vectordrawable.graphics.drawable.g.c(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (j5 != null) {
            return this.f4542s.B(k6, j5, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int r(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray k5 = l.k(resources, theme, attributeSet, g.b.f4647k);
        int resourceId = k5.getResourceId(g.b.f4650n, -1);
        int resourceId2 = k5.getResourceId(g.b.f4649m, -1);
        int resourceId3 = k5.getResourceId(g.b.f4648l, -1);
        Drawable j5 = resourceId3 > 0 ? a1.h().j(context, resourceId3) : null;
        boolean z4 = k5.getBoolean(g.b.f4651o, false);
        k5.recycle();
        if (j5 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                j5 = xmlPullParser.getName().equals("animated-vector") ? androidx.vectordrawable.graphics.drawable.b.a(context, resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (j5 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f4542s.C(resourceId, resourceId2, j5, z4);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    private boolean s(int i5) {
        int i6;
        int G;
        g gVar;
        g gVar2 = this.f4543t;
        if (gVar2 == null) {
            i6 = c();
        } else if (i5 == this.f4544u) {
            return true;
        } else {
            if (i5 != this.f4545v || !gVar2.a()) {
                i6 = this.f4544u;
                gVar2.d();
            } else {
                gVar2.b();
                this.f4544u = this.f4545v;
                this.f4545v = i5;
                return true;
            }
        }
        this.f4543t = null;
        this.f4545v = -1;
        this.f4544u = -1;
        c cVar = this.f4542s;
        int E = cVar.E(i6);
        int E2 = cVar.E(i5);
        if (E2 == 0 || E == 0 || (G = cVar.G(E, E2)) < 0) {
            return false;
        }
        boolean I = cVar.I(E, E2);
        g(G);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            gVar = new e((AnimationDrawable) current, cVar.H(E, E2), I);
        } else if (current instanceof androidx.vectordrawable.graphics.drawable.b) {
            gVar = new d((androidx.vectordrawable.graphics.drawable.b) current);
        } else {
            if (current instanceof Animatable) {
                gVar = new b((Animatable) current);
            }
            return false;
        }
        gVar.c();
        this.f4543t = gVar;
        this.f4545v = i6;
        this.f4544u = i5;
        return true;
    }

    private void t(TypedArray typedArray) {
        c cVar = this.f4542s;
        cVar.f4571d |= typedArray.getChangingConfigurations();
        cVar.x(typedArray.getBoolean(g.b.f4640d, cVar.f4576i));
        cVar.t(typedArray.getBoolean(g.b.f4641e, cVar.f4579l));
        cVar.u(typedArray.getInt(g.b.f4642f, cVar.A));
        cVar.v(typedArray.getInt(g.b.f4643g, cVar.B));
        setDither(typedArray.getBoolean(g.b.f4638b, cVar.f4591x));
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    public void h(b.d dVar) {
        super.h(dVar);
        if (dVar instanceof c) {
            this.f4542s = (c) dVar;
        }
    }

    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f4543t;
        if (gVar != null) {
            gVar.d();
            this.f4543t = null;
            g(this.f4544u);
            this.f4544u = -1;
            this.f4545v = -1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public c j() {
        return new c(this.f4542s, this, (Resources) null);
    }

    public Drawable mutate() {
        if (!this.f4546w && super.mutate() == this) {
            this.f4542s.r();
            this.f4546w = true;
        }
        return this;
    }

    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray k5 = l.k(resources, theme, attributeSet, g.b.f4637a);
        setVisible(k5.getBoolean(g.b.f4639c, true), true);
        t(k5);
        i(resources);
        k5.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i5) {
        return super.onLayoutDirectionChanged(i5);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int F = this.f4542s.F(iArr);
        boolean z4 = F != c() && (s(F) || g(F));
        Drawable current = getCurrent();
        return current != null ? z4 | current.setState(iArr) : z4;
    }

    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        super.scheduleDrawable(drawable, runnable, j5);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i5) {
        super.setAlpha(i5);
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z4) {
        super.setAutoMirrored(z4);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void setDither(boolean z4) {
        super.setDither(z4);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f5, float f6) {
        super.setHotspot(f5, f6);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i5, int i6, int i7, int i8) {
        super.setHotspotBounds(i5, i6, i7, i8);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    public boolean setVisible(boolean z4, boolean z5) {
        boolean visible = super.setVisible(z4, z5);
        g gVar = this.f4543t;
        if (gVar != null && (visible || z5)) {
            if (z4) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }
}
