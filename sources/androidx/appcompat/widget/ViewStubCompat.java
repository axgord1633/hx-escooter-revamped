package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import d.j;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {

    /* renamed from: e  reason: collision with root package name */
    private int f1123e;

    /* renamed from: f  reason: collision with root package name */
    private int f1124f;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<View> f1125g;

    /* renamed from: h  reason: collision with root package name */
    private LayoutInflater f1126h;

    /* renamed from: i  reason: collision with root package name */
    private a f1127i;

    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f1123e = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.E3, i5, 0);
        this.f1124f = obtainStyledAttributes.getResourceId(j.H3, -1);
        this.f1123e = obtainStyledAttributes.getResourceId(j.G3, 0);
        setId(obtainStyledAttributes.getResourceId(j.F3, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1123e != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater layoutInflater = this.f1126h;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f1123e, viewGroup, false);
            int i5 = this.f1124f;
            if (i5 != -1) {
                inflate.setId(i5);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1125g = new WeakReference<>(inflate);
            a aVar = this.f1127i;
            if (aVar != null) {
                aVar.a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f1124f;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1126h;
    }

    public int getLayoutResource() {
        return this.f1123e;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i5) {
        this.f1124f = i5;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1126h = layoutInflater;
    }

    public void setLayoutResource(int i5) {
        this.f1123e = i5;
    }

    public void setOnInflateListener(a aVar) {
        this.f1127i = aVar;
    }

    public void setVisibility(int i5) {
        WeakReference<View> weakReference = this.f1125g;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i5);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i5);
        if (i5 == 0 || i5 == 4) {
            a();
        }
    }
}
