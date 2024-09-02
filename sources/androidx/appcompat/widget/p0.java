package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.k1;
import androidx.core.widget.h;
import f.c;
import java.lang.reflect.Field;

class p0 extends ListView {

    /* renamed from: e  reason: collision with root package name */
    private final Rect f1358e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private int f1359f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f1360g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f1361h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f1362i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f1363j;

    /* renamed from: k  reason: collision with root package name */
    private Field f1364k;

    /* renamed from: l  reason: collision with root package name */
    private a f1365l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1366m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1367n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1368o;

    /* renamed from: p  reason: collision with root package name */
    private k1 f1369p;

    /* renamed from: q  reason: collision with root package name */
    private h f1370q;

    /* renamed from: r  reason: collision with root package name */
    b f1371r;

    private static class a extends c {

        /* renamed from: f  reason: collision with root package name */
        private boolean f1372f = true;

        a(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z4) {
            this.f1372f = z4;
        }

        public void draw(Canvas canvas) {
            if (this.f1372f) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f5, float f6) {
            if (this.f1372f) {
                super.setHotspot(f5, f6);
            }
        }

        public void setHotspotBounds(int i5, int i6, int i7, int i8) {
            if (this.f1372f) {
                super.setHotspotBounds(i5, i6, i7, i8);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.f1372f) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z4, boolean z5) {
            if (this.f1372f) {
                return super.setVisible(z4, z5);
            }
            return false;
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void a() {
            p0 p0Var = p0.this;
            p0Var.f1371r = null;
            p0Var.removeCallbacks(this);
        }

        public void b() {
            p0.this.post(this);
        }

        public void run() {
            p0 p0Var = p0.this;
            p0Var.f1371r = null;
            p0Var.drawableStateChanged();
        }
    }

    p0(Context context, boolean z4) {
        super(context, (AttributeSet) null, d.a.f3987z);
        this.f1367n = z4;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1364k = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
        }
    }

    private void a() {
        this.f1368o = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1363j - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        k1 k1Var = this.f1369p;
        if (k1Var != null) {
            k1Var.c();
            this.f1369p = null;
        }
    }

    private void b(View view, int i5) {
        performItemClick(view, i5, getItemIdAtPosition(i5));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (!this.f1358e.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1358e);
            selector.draw(canvas);
        }
    }

    private void f(int i5, View view) {
        Rect rect = this.f1358e;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1359f;
        rect.top -= this.f1360g;
        rect.right += this.f1361h;
        rect.bottom += this.f1362i;
        try {
            boolean z4 = this.f1364k.getBoolean(this);
            if (view.isEnabled() != z4) {
                this.f1364k.set(this, Boolean.valueOf(!z4));
                if (i5 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        }
    }

    private void g(int i5, View view) {
        Drawable selector = getSelector();
        boolean z4 = true;
        boolean z5 = (selector == null || i5 == -1) ? false : true;
        if (z5) {
            selector.setVisible(false, false);
        }
        f(i5, view);
        if (z5) {
            Rect rect = this.f1358e;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z4 = false;
            }
            selector.setVisible(z4, false);
            androidx.core.graphics.drawable.a.j(selector, exactCenterX, exactCenterY);
        }
    }

    private void h(int i5, View view, float f5, float f6) {
        g(i5, view);
        Drawable selector = getSelector();
        if (selector != null && i5 != -1) {
            androidx.core.graphics.drawable.a.j(selector, f5, f6);
        }
    }

    private void i(View view, int i5, float f5, float f6) {
        View childAt;
        this.f1368o = true;
        drawableHotspotChanged(f5, f6);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i6 = this.f1363j;
        if (!(i6 == -1 || (childAt = getChildAt(i6 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.f1363j = i5;
        view.drawableHotspotChanged(f5 - ((float) view.getLeft()), f6 - ((float) view.getTop()));
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i5, view, f5, f6);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean j() {
        return this.f1368o;
    }

    private void k() {
        Drawable selector = getSelector();
        if (selector != null && j() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void setSelectorEnabled(boolean z4) {
        a aVar = this.f1365l;
        if (aVar != null) {
            aVar.c(z4);
        }
    }

    public int d(int i5, int i6, int i7, int i8, int i9) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i10 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i10;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        View view = null;
        while (i11 < count) {
            int itemViewType = adapter.getItemViewType(i11);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            view = adapter.getView(i11, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i14 = layoutParams.height;
            view.measure(i5, i14 > 0 ? View.MeasureSpec.makeMeasureSpec(i14, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i11 > 0) {
                i10 += dividerHeight;
            }
            i10 += view.getMeasuredHeight();
            if (i10 >= i8) {
                return (i9 < 0 || i11 <= i9 || i13 <= 0 || i10 == i8) ? i8 : i13;
            }
            if (i9 >= 0 && i11 >= i9) {
                i13 = i10;
            }
            i11++;
        }
        return i10;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.f1371r == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            k();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r9 = 3
            if (r0 == r9) goto L_0x0011
        L_0x000e:
            r9 = r1
            r3 = r2
            goto L_0x0046
        L_0x0011:
            r9 = r1
            r3 = r9
            goto L_0x0046
        L_0x0014:
            r3 = r2
            goto L_0x0017
        L_0x0016:
            r3 = r1
        L_0x0017:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x001e
            goto L_0x0011
        L_0x001e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x0031
            r9 = r2
            goto L_0x0046
        L_0x0031:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r2) goto L_0x000e
            r7.b(r3, r5)
            goto L_0x000e
        L_0x0046:
            if (r3 == 0) goto L_0x004a
            if (r9 == 0) goto L_0x004d
        L_0x004a:
            r7.a()
        L_0x004d:
            if (r3 == 0) goto L_0x0065
            androidx.core.widget.h r9 = r7.f1370q
            if (r9 != 0) goto L_0x005a
            androidx.core.widget.h r9 = new androidx.core.widget.h
            r9.<init>(r7)
            r7.f1370q = r9
        L_0x005a:
            androidx.core.widget.h r9 = r7.f1370q
            r9.m(r2)
            androidx.core.widget.h r9 = r7.f1370q
            r9.onTouch(r7, r8)
            goto L_0x006c
        L_0x0065:
            androidx.core.widget.h r8 = r7.f1370q
            if (r8 == 0) goto L_0x006c
            r8.m(r1)
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.p0.e(android.view.MotionEvent, int):boolean");
    }

    public boolean hasFocus() {
        return this.f1367n || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f1367n || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f1367n || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f1367n && this.f1366m) || super.isInTouchMode();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f1371r = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1371r == null) {
            b bVar = new b();
            this.f1371r = bVar;
            bVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                k();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1363j = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.f1371r;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z4) {
        this.f1366m = z4;
    }

    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f1365l = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1359f = rect.left;
        this.f1360g = rect.top;
        this.f1361h = rect.right;
        this.f1362i = rect.bottom;
    }
}
