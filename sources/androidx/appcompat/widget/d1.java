package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.s0;

public class d1 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: n  reason: collision with root package name */
    private static final Interpolator f1183n = new DecelerateInterpolator();

    /* renamed from: e  reason: collision with root package name */
    Runnable f1184e;

    /* renamed from: f  reason: collision with root package name */
    private c f1185f;

    /* renamed from: g  reason: collision with root package name */
    s0 f1186g;

    /* renamed from: h  reason: collision with root package name */
    private Spinner f1187h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1188i;

    /* renamed from: j  reason: collision with root package name */
    int f1189j;

    /* renamed from: k  reason: collision with root package name */
    int f1190k;

    /* renamed from: l  reason: collision with root package name */
    private int f1191l;

    /* renamed from: m  reason: collision with root package name */
    private int f1192m;

    class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f1193e;

        a(View view) {
            this.f1193e = view;
        }

        public void run() {
            d1.this.smoothScrollTo(this.f1193e.getLeft() - ((d1.this.getWidth() - this.f1193e.getWidth()) / 2), 0);
            d1.this.f1184e = null;
        }
    }

    private class b extends BaseAdapter {
        b() {
        }

        public int getCount() {
            return d1.this.f1186g.getChildCount();
        }

        public Object getItem(int i5) {
            return ((d) d1.this.f1186g.getChildAt(i5)).b();
        }

        public long getItemId(int i5) {
            return (long) i5;
        }

        public View getView(int i5, View view, ViewGroup viewGroup) {
            if (view == null) {
                return d1.this.c((a.c) getItem(i5), true);
            }
            ((d) view).a((a.c) getItem(i5));
            return view;
        }
    }

    private class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = d1.this.f1186g.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = d1.this.f1186g.getChildAt(i5);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class d extends LinearLayout {

        /* renamed from: e  reason: collision with root package name */
        private final int[] f1197e;

        /* renamed from: f  reason: collision with root package name */
        private a.c f1198f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f1199g;

        /* renamed from: h  reason: collision with root package name */
        private ImageView f1200h;

        /* renamed from: i  reason: collision with root package name */
        private View f1201i;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(android.content.Context r6, androidx.appcompat.app.a.c r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.d1.this = r5
                int r5 = d.a.f3965d
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.f1197e = r1
                r4.f1198f = r7
                androidx.appcompat.widget.k1 r5 = androidx.appcompat.widget.k1.u(r6, r0, r1, r5, r3)
                boolean r6 = r5.r(r3)
                if (r6 == 0) goto L_0x0026
                android.graphics.drawable.Drawable r6 = r5.f(r3)
                r4.setBackgroundDrawable(r6)
            L_0x0026:
                r5.v()
                if (r8 == 0) goto L_0x0031
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L_0x0031:
                r4.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.d1.d.<init>(androidx.appcompat.widget.d1, android.content.Context, androidx.appcompat.app.a$c, boolean):void");
        }

        public void a(a.c cVar) {
            this.f1198f = cVar;
            c();
        }

        public a.c b() {
            return this.f1198f;
        }

        public void c() {
            a.c cVar = this.f1198f;
            View b5 = cVar.b();
            CharSequence charSequence = null;
            if (b5 != null) {
                ViewParent parent = b5.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b5);
                    }
                    addView(b5);
                }
                this.f1201i = b5;
                TextView textView = this.f1199g;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1200h;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1200h.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.f1201i;
            if (view != null) {
                removeView(view);
                this.f1201i = null;
            }
            Drawable c5 = cVar.c();
            CharSequence d5 = cVar.d();
            if (c5 != null) {
                if (this.f1200h == null) {
                    o oVar = new o(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    oVar.setLayoutParams(layoutParams);
                    addView(oVar, 0);
                    this.f1200h = oVar;
                }
                this.f1200h.setImageDrawable(c5);
                this.f1200h.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1200h;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1200h.setImageDrawable((Drawable) null);
                }
            }
            boolean z4 = !TextUtils.isEmpty(d5);
            if (z4) {
                if (this.f1199g == null) {
                    h0 h0Var = new h0(getContext(), (AttributeSet) null, d.a.f3966e);
                    h0Var.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    h0Var.setLayoutParams(layoutParams2);
                    addView(h0Var);
                    this.f1199g = h0Var;
                }
                this.f1199g.setText(d5);
                this.f1199g.setVisibility(0);
            } else {
                TextView textView2 = this.f1199g;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1199g.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1200h;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            if (!z4) {
                charSequence = cVar.a();
            }
            n1.a(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i5, int i6) {
            int i7;
            super.onMeasure(i5, i6);
            if (d1.this.f1189j > 0 && getMeasuredWidth() > (i7 = d1.this.f1189j)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), i6);
            }
        }

        public void setSelected(boolean z4) {
            boolean z5 = isSelected() != z4;
            super.setSelected(z4);
            if (z5 && z4) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private Spinner b() {
        y yVar = new y(getContext(), (AttributeSet) null, d.a.f3969h);
        yVar.setLayoutParams(new s0.a(-2, -1));
        yVar.setOnItemSelectedListener(this);
        return yVar;
    }

    private boolean d() {
        Spinner spinner = this.f1187h;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (!d()) {
            if (this.f1187h == null) {
                this.f1187h = b();
            }
            removeView(this.f1186g);
            addView(this.f1187h, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1187h.getAdapter() == null) {
                this.f1187h.setAdapter(new b());
            }
            Runnable runnable = this.f1184e;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f1184e = null;
            }
            this.f1187h.setSelection(this.f1192m);
        }
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f1187h);
        addView(this.f1186g, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1187h.getSelectedItemPosition());
        return false;
    }

    public void a(int i5) {
        View childAt = this.f1186g.getChildAt(i5);
        Runnable runnable = this.f1184e;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f1184e = aVar;
        post(aVar);
    }

    /* access modifiers changed from: package-private */
    public d c(a.c cVar, boolean z4) {
        d dVar = new d(getContext(), cVar, z4);
        if (z4) {
            dVar.setBackgroundDrawable((Drawable) null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1191l));
        } else {
            dVar.setFocusable(true);
            if (this.f1185f == null) {
                this.f1185f = new c();
            }
            dVar.setOnClickListener(this.f1185f);
        }
        return dVar;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1184e;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h.a b5 = h.a.b(getContext());
        setContentHeight(b5.f());
        this.f1190k = b5.e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1184e;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i5, long j5) {
        ((d) view).b().e();
    }

    public void onMeasure(int i5, int i6) {
        int i7;
        int mode = View.MeasureSpec.getMode(i5);
        boolean z4 = true;
        boolean z5 = mode == 1073741824;
        setFillViewport(z5);
        int childCount = this.f1186g.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i7 = -1;
        } else {
            if (childCount > 2) {
                this.f1189j = (int) (((float) View.MeasureSpec.getSize(i5)) * 0.4f);
            } else {
                this.f1189j = View.MeasureSpec.getSize(i5) / 2;
            }
            i7 = Math.min(this.f1189j, this.f1190k);
        }
        this.f1189j = i7;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1191l, 1073741824);
        if (z5 || !this.f1188i) {
            z4 = false;
        }
        if (z4) {
            this.f1186g.measure(0, makeMeasureSpec);
            if (this.f1186g.getMeasuredWidth() > View.MeasureSpec.getSize(i5)) {
                e();
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i5, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (z5 && measuredWidth != measuredWidth2) {
                    setTabSelected(this.f1192m);
                    return;
                }
            }
        }
        f();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i5, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (z5) {
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z4) {
        this.f1188i = z4;
    }

    public void setContentHeight(int i5) {
        this.f1191l = i5;
        requestLayout();
    }

    public void setTabSelected(int i5) {
        this.f1192m = i5;
        int childCount = this.f1186g.getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = this.f1186g.getChildAt(i6);
            boolean z4 = i6 == i5;
            childAt.setSelected(z4);
            if (z4) {
                a(i5);
            }
            i6++;
        }
        Spinner spinner = this.f1187h;
        if (spinner != null && i5 >= 0) {
            spinner.setSelection(i5);
        }
    }
}
