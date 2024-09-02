package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.res.l;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class b extends f implements Animatable {

    /* renamed from: f  reason: collision with root package name */
    private C0048b f2725f;

    /* renamed from: g  reason: collision with root package name */
    private Context f2726g;

    /* renamed from: h  reason: collision with root package name */
    private ArgbEvaluator f2727h;

    /* renamed from: i  reason: collision with root package name */
    private Animator.AnimatorListener f2728i;

    /* renamed from: j  reason: collision with root package name */
    ArrayList<Object> f2729j;

    /* renamed from: k  reason: collision with root package name */
    final Drawable.Callback f2730k;

    class a implements Drawable.Callback {
        a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
            b.this.scheduleSelf(runnable, j5);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.b$b  reason: collision with other inner class name */
    private static class C0048b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f2732a;

        /* renamed from: b  reason: collision with root package name */
        g f2733b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f2734c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f2735d;

        /* renamed from: e  reason: collision with root package name */
        m.a<Animator, String> f2736e;

        public C0048b(Context context, C0048b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.f2732a = bVar.f2732a;
                g gVar = bVar.f2733b;
                if (gVar != null) {
                    Drawable.ConstantState constantState = gVar.getConstantState();
                    this.f2733b = (g) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    g gVar2 = (g) this.f2733b.mutate();
                    this.f2733b = gVar2;
                    gVar2.setCallback(callback);
                    this.f2733b.setBounds(bVar.f2733b.getBounds());
                    this.f2733b.h(false);
                }
                ArrayList<Animator> arrayList = bVar.f2735d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f2735d = new ArrayList<>(size);
                    this.f2736e = new m.a<>(size);
                    for (int i5 = 0; i5 < size; i5++) {
                        Animator animator = bVar.f2735d.get(i5);
                        Animator clone = animator.clone();
                        String str = bVar.f2736e.get(animator);
                        clone.setTarget(this.f2733b.d(str));
                        this.f2735d.add(clone);
                        this.f2736e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f2734c == null) {
                this.f2734c = new AnimatorSet();
            }
            this.f2734c.playTogether(this.f2735d);
        }

        public int getChangingConfigurations() {
            return this.f2732a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    private static class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f2737a;

        public c(Drawable.ConstantState constantState) {
            this.f2737a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f2737a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f2737a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            b bVar = new b();
            Drawable newDrawable = this.f2737a.newDrawable();
            bVar.f2740e = newDrawable;
            newDrawable.setCallback(bVar.f2730k);
            return bVar;
        }

        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            Drawable newDrawable = this.f2737a.newDrawable(resources);
            bVar.f2740e = newDrawable;
            newDrawable.setCallback(bVar.f2730k);
            return bVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            Drawable newDrawable = this.f2737a.newDrawable(resources, theme);
            bVar.f2740e = newDrawable;
            newDrawable.setCallback(bVar.f2730k);
            return bVar;
        }
    }

    b() {
        this((Context) null, (C0048b) null, (Resources) null);
    }

    private b(Context context) {
        this(context, (C0048b) null, (Resources) null);
    }

    private b(Context context, C0048b bVar, Resources resources) {
        this.f2727h = null;
        this.f2728i = null;
        this.f2729j = null;
        a aVar = new a();
        this.f2730k = aVar;
        this.f2726g = context;
        if (bVar != null) {
            this.f2725f = bVar;
        } else {
            this.f2725f = new C0048b(context, bVar, aVar, resources);
        }
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f2725f.f2733b.d(str));
        C0048b bVar = this.f2725f;
        if (bVar.f2735d == null) {
            bVar.f2735d = new ArrayList<>();
            this.f2725f.f2736e = new m.a<>();
        }
        this.f2725f.f2735d.add(animator);
        this.f2725f.f2736e.put(animator, str);
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f2725f.f2733b.draw(canvas);
        if (this.f2725f.f2734c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f2740e;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.f2725f.f2733b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f2725f.f2732a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f2740e;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f2725f.f2733b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f2740e == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f2740e.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f2725f.f2733b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f2725f.f2733b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.getOpacity() : this.f2725f.f2733b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = l.k(resources, theme, attributeSet, a.f2717e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        g b5 = g.b(resources, resourceId, theme);
                        b5.h(false);
                        b5.setCallback(this.f2730k);
                        g gVar = this.f2725f.f2733b;
                        if (gVar != null) {
                            gVar.setCallback((Drawable.Callback) null);
                        }
                        this.f2725f.f2733b = b5;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, a.f2718f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f2726g;
                        if (context != null) {
                            b(string, d.i(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.f2725f.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f2740e;
        return drawable != null ? androidx.core.graphics.drawable.a.g(drawable) : this.f2725f.f2733b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f2740e;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f2725f.f2734c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.isStateful() : this.f2725f.f2733b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f2725f.f2733b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i5) {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.setLevel(i5) : this.f2725f.f2733b.setLevel(i5);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2740e;
        return drawable != null ? drawable.setState(iArr) : this.f2725f.f2733b.setState(iArr);
    }

    public void setAlpha(int i5) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.setAlpha(i5);
        } else {
            this.f2725f.f2733b.setAlpha(i5);
        }
    }

    public void setAutoMirrored(boolean z4) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.i(drawable, z4);
        } else {
            this.f2725f.f2733b.setAutoMirrored(z4);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i5) {
        super.setChangingConfigurations(i5);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i5, PorterDuff.Mode mode) {
        super.setColorFilter(i5, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2725f.f2733b.setColorFilter(colorFilter);
        }
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z4) {
        super.setFilterBitmap(z4);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f5, float f6) {
        super.setHotspot(f5, f6);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i5, int i6, int i7, int i8) {
        super.setHotspotBounds(i5, i6, i7, i8);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i5) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.m(drawable, i5);
        } else {
            this.f2725f.f2733b.setTint(i5);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, colorStateList);
        } else {
            this.f2725f.f2733b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, mode);
        } else {
            this.f2725f.f2733b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z4, boolean z5) {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            return drawable.setVisible(z4, z5);
        }
        this.f2725f.f2733b.setVisible(z4, z5);
        return super.setVisible(z4, z5);
    }

    public void start() {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f2725f.f2734c.isStarted()) {
            this.f2725f.f2734c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f2740e;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f2725f.f2734c.end();
        }
    }
}
