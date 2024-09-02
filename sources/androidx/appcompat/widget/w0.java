package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.core.view.k0;
import d.j;
import java.lang.reflect.Method;

public class w0 implements i.e {
    private static Method K;
    private static Method L;
    private static Method M;
    final g A;
    private final f B;
    private final e C;
    private final c D;
    private Runnable E;
    final Handler F;
    private final Rect G;
    private Rect H;
    private boolean I;
    PopupWindow J;

    /* renamed from: e  reason: collision with root package name */
    private Context f1421e;

    /* renamed from: f  reason: collision with root package name */
    private ListAdapter f1422f;

    /* renamed from: g  reason: collision with root package name */
    p0 f1423g;

    /* renamed from: h  reason: collision with root package name */
    private int f1424h;

    /* renamed from: i  reason: collision with root package name */
    private int f1425i;

    /* renamed from: j  reason: collision with root package name */
    private int f1426j;

    /* renamed from: k  reason: collision with root package name */
    private int f1427k;

    /* renamed from: l  reason: collision with root package name */
    private int f1428l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1429m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1430n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1431o;

    /* renamed from: p  reason: collision with root package name */
    private int f1432p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1433q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1434r;

    /* renamed from: s  reason: collision with root package name */
    int f1435s;

    /* renamed from: t  reason: collision with root package name */
    private View f1436t;

    /* renamed from: u  reason: collision with root package name */
    private int f1437u;

    /* renamed from: v  reason: collision with root package name */
    private DataSetObserver f1438v;

    /* renamed from: w  reason: collision with root package name */
    private View f1439w;

    /* renamed from: x  reason: collision with root package name */
    private Drawable f1440x;

    /* renamed from: y  reason: collision with root package name */
    private AdapterView.OnItemClickListener f1441y;

    /* renamed from: z  reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f1442z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            View s5 = w0.this.s();
            if (s5 != null && s5.getWindowToken() != null) {
                w0.this.show();
            }
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i5, long j5) {
            p0 p0Var;
            if (i5 != -1 && (p0Var = w0.this.f1423g) != null) {
                p0Var.setListSelectionHidden(false);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private class c implements Runnable {
        c() {
        }

        public void run() {
            w0.this.q();
        }
    }

    private class d extends DataSetObserver {
        d() {
        }

        public void onChanged() {
            if (w0.this.b()) {
                w0.this.show();
            }
        }

        public void onInvalidated() {
            w0.this.dismiss();
        }
    }

    private class e implements AbsListView.OnScrollListener {
        e() {
        }

        public void onScroll(AbsListView absListView, int i5, int i6, int i7) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i5) {
            if (i5 == 1 && !w0.this.v() && w0.this.J.getContentView() != null) {
                w0 w0Var = w0.this;
                w0Var.F.removeCallbacks(w0Var.A);
                w0.this.A.run();
            }
        }
    }

    private class f implements View.OnTouchListener {
        f() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x4 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = w0.this.J) != null && popupWindow.isShowing() && x4 >= 0 && x4 < w0.this.J.getWidth() && y4 >= 0 && y4 < w0.this.J.getHeight()) {
                w0 w0Var = w0.this;
                w0Var.F.postDelayed(w0Var.A, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                w0 w0Var2 = w0.this;
                w0Var2.F.removeCallbacks(w0Var2.A);
                return false;
            }
        }
    }

    private class g implements Runnable {
        g() {
        }

        public void run() {
            p0 p0Var = w0.this.f1423g;
            if (p0Var != null && k0.A(p0Var) && w0.this.f1423g.getCount() > w0.this.f1423g.getChildCount()) {
                int childCount = w0.this.f1423g.getChildCount();
                w0 w0Var = w0.this;
                if (childCount <= w0Var.f1435s) {
                    w0Var.J.setInputMethodMode(2);
                    w0.this.show();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                K = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                M = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            Class<PopupWindow> cls2 = PopupWindow.class;
            try {
                L = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public w0(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public w0(Context context, AttributeSet attributeSet, int i5, int i6) {
        this.f1424h = -2;
        this.f1425i = -2;
        this.f1428l = 1002;
        this.f1432p = 0;
        this.f1433q = false;
        this.f1434r = false;
        this.f1435s = Integer.MAX_VALUE;
        this.f1437u = 0;
        this.A = new g();
        this.B = new f();
        this.C = new e();
        this.D = new c();
        this.G = new Rect();
        this.f1421e = context;
        this.F = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f4172o1, i5, i6);
        this.f1426j = obtainStyledAttributes.getDimensionPixelOffset(j.f4177p1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(j.f4182q1, 0);
        this.f1427k = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1429m = true;
        }
        obtainStyledAttributes.recycle();
        q qVar = new q(context, attributeSet, i5, i6);
        this.J = qVar;
        qVar.setInputMethodMode(1);
    }

    private void I(boolean z4) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = K;
            if (method != null) {
                try {
                    method.invoke(this.J, new Object[]{Boolean.valueOf(z4)});
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.J.setIsClippedToScreen(z4);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.p0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.p0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.appcompat.widget.p0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int p() {
        /*
            r12 = this;
            androidx.appcompat.widget.p0 r0 = r12.f1423g
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00be
            android.content.Context r0 = r12.f1421e
            androidx.appcompat.widget.w0$a r5 = new androidx.appcompat.widget.w0$a
            r5.<init>()
            r12.E = r5
            boolean r5 = r12.I
            r5 = r5 ^ r3
            androidx.appcompat.widget.p0 r5 = r12.r(r0, r5)
            r12.f1423g = r5
            android.graphics.drawable.Drawable r6 = r12.f1440x
            if (r6 == 0) goto L_0x0022
            r5.setSelector(r6)
        L_0x0022:
            androidx.appcompat.widget.p0 r5 = r12.f1423g
            android.widget.ListAdapter r6 = r12.f1422f
            r5.setAdapter(r6)
            androidx.appcompat.widget.p0 r5 = r12.f1423g
            android.widget.AdapterView$OnItemClickListener r6 = r12.f1441y
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.p0 r5 = r12.f1423g
            r5.setFocusable(r3)
            androidx.appcompat.widget.p0 r5 = r12.f1423g
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.p0 r5 = r12.f1423g
            androidx.appcompat.widget.w0$b r6 = new androidx.appcompat.widget.w0$b
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.p0 r5 = r12.f1423g
            androidx.appcompat.widget.w0$e r6 = r12.C
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.f1442z
            if (r5 == 0) goto L_0x0054
            androidx.appcompat.widget.p0 r6 = r12.f1423g
            r6.setOnItemSelectedListener(r5)
        L_0x0054:
            androidx.appcompat.widget.p0 r5 = r12.f1423g
            android.view.View r6 = r12.f1436t
            if (r6 == 0) goto L_0x00b7
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.f1437u
            if (r8 == 0) goto L_0x008f
            if (r8 == r3) goto L_0x0088
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.f1437u
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0095
        L_0x0088:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0095
        L_0x008f:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0095:
            int r0 = r12.f1425i
            if (r0 < 0) goto L_0x009b
            r5 = r1
            goto L_0x009d
        L_0x009b:
            r0 = r4
            r5 = r0
        L_0x009d:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00b8
        L_0x00b7:
            r0 = r4
        L_0x00b8:
            android.widget.PopupWindow r6 = r12.J
            r6.setContentView(r5)
            goto L_0x00dc
        L_0x00be:
            android.widget.PopupWindow r0 = r12.J
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.f1436t
            if (r0 == 0) goto L_0x00db
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00dc
        L_0x00db:
            r0 = r4
        L_0x00dc:
            android.widget.PopupWindow r5 = r12.J
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00f8
            android.graphics.Rect r6 = r12.G
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.G
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.f1429m
            if (r7 != 0) goto L_0x00fe
            int r6 = -r6
            r12.f1427k = r6
            goto L_0x00fe
        L_0x00f8:
            android.graphics.Rect r5 = r12.G
            r5.setEmpty()
            r5 = r4
        L_0x00fe:
            android.widget.PopupWindow r6 = r12.J
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0108
            goto L_0x0109
        L_0x0108:
            r3 = r4
        L_0x0109:
            android.view.View r4 = r12.s()
            int r6 = r12.f1427k
            int r3 = r12.t(r4, r6, r3)
            boolean r4 = r12.f1433q
            if (r4 != 0) goto L_0x0161
            int r4 = r12.f1424h
            if (r4 != r2) goto L_0x011c
            goto L_0x0161
        L_0x011c:
            int r4 = r12.f1425i
            r6 = -2
            if (r4 == r6) goto L_0x012a
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x012a
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
            goto L_0x0142
        L_0x012a:
            android.content.Context r2 = r12.f1421e
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.G
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
        L_0x0142:
            r7 = r1
            androidx.appcompat.widget.p0 r6 = r12.f1423g
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.d(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x015f
            androidx.appcompat.widget.p0 r2 = r12.f1423g
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.p0 r3 = r12.f1423g
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x015f:
            int r1 = r1 + r0
            return r1
        L_0x0161:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w0.p():int");
    }

    private int t(View view, int i5, boolean z4) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.J.getMaxAvailableHeight(view, i5, z4);
        }
        Method method = L;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.J, new Object[]{view, Integer.valueOf(i5), Boolean.valueOf(z4)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.J.getMaxAvailableHeight(view, i5);
    }

    private void x() {
        View view = this.f1436t;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1436t);
            }
        }
    }

    public void A(int i5) {
        Drawable background = this.J.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            Rect rect = this.G;
            this.f1425i = rect.left + rect.right + i5;
            return;
        }
        L(i5);
    }

    public void B(int i5) {
        this.f1432p = i5;
    }

    public void C(Rect rect) {
        this.H = rect != null ? new Rect(rect) : null;
    }

    public void D(int i5) {
        this.J.setInputMethodMode(i5);
    }

    public void E(boolean z4) {
        this.I = z4;
        this.J.setFocusable(z4);
    }

    public void F(PopupWindow.OnDismissListener onDismissListener) {
        this.J.setOnDismissListener(onDismissListener);
    }

    public void G(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1441y = onItemClickListener;
    }

    public void H(boolean z4) {
        this.f1431o = true;
        this.f1430n = z4;
    }

    public void J(int i5) {
        this.f1437u = i5;
    }

    public void K(int i5) {
        p0 p0Var = this.f1423g;
        if (b() && p0Var != null) {
            p0Var.setListSelectionHidden(false);
            p0Var.setSelection(i5);
            if (p0Var.getChoiceMode() != 0) {
                p0Var.setItemChecked(i5, true);
            }
        }
    }

    public void L(int i5) {
        this.f1425i = i5;
    }

    public boolean b() {
        return this.J.isShowing();
    }

    public int c() {
        return this.f1426j;
    }

    public void dismiss() {
        this.J.dismiss();
        x();
        this.J.setContentView((View) null);
        this.f1423g = null;
        this.F.removeCallbacks(this.A);
    }

    public Drawable e() {
        return this.J.getBackground();
    }

    public ListView f() {
        return this.f1423g;
    }

    public void h(Drawable drawable) {
        this.J.setBackgroundDrawable(drawable);
    }

    public void i(int i5) {
        this.f1427k = i5;
        this.f1429m = true;
    }

    public void k(int i5) {
        this.f1426j = i5;
    }

    public int m() {
        if (!this.f1429m) {
            return 0;
        }
        return this.f1427k;
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1438v;
        if (dataSetObserver == null) {
            this.f1438v = new d();
        } else {
            ListAdapter listAdapter2 = this.f1422f;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1422f = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1438v);
        }
        p0 p0Var = this.f1423g;
        if (p0Var != null) {
            p0Var.setAdapter(this.f1422f);
        }
    }

    public void q() {
        p0 p0Var = this.f1423g;
        if (p0Var != null) {
            p0Var.setListSelectionHidden(true);
            p0Var.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public p0 r(Context context, boolean z4) {
        return new p0(context, z4);
    }

    public View s() {
        return this.f1439w;
    }

    public void show() {
        int p5 = p();
        boolean v5 = v();
        androidx.core.widget.j.b(this.J, this.f1428l);
        boolean z4 = true;
        if (!this.J.isShowing()) {
            int i5 = this.f1425i;
            if (i5 == -1) {
                i5 = -1;
            } else if (i5 == -2) {
                i5 = s().getWidth();
            }
            int i6 = this.f1424h;
            if (i6 == -1) {
                p5 = -1;
            } else if (i6 != -2) {
                p5 = i6;
            }
            this.J.setWidth(i5);
            this.J.setHeight(p5);
            I(true);
            this.J.setOutsideTouchable(!this.f1434r && !this.f1433q);
            this.J.setTouchInterceptor(this.B);
            if (this.f1431o) {
                androidx.core.widget.j.a(this.J, this.f1430n);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = M;
                if (method != null) {
                    try {
                        method.invoke(this.J, new Object[]{this.H});
                    } catch (Exception e5) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e5);
                    }
                }
            } else {
                this.J.setEpicenterBounds(this.H);
            }
            androidx.core.widget.j.c(this.J, s(), this.f1426j, this.f1427k, this.f1432p);
            this.f1423g.setSelection(-1);
            if (!this.I || this.f1423g.isInTouchMode()) {
                q();
            }
            if (!this.I) {
                this.F.post(this.D);
            }
        } else if (k0.A(s())) {
            int i7 = this.f1425i;
            if (i7 == -1) {
                i7 = -1;
            } else if (i7 == -2) {
                i7 = s().getWidth();
            }
            int i8 = this.f1424h;
            if (i8 == -1) {
                if (!v5) {
                    p5 = -1;
                }
                if (v5) {
                    this.J.setWidth(this.f1425i == -1 ? -1 : 0);
                    this.J.setHeight(0);
                } else {
                    this.J.setWidth(this.f1425i == -1 ? -1 : 0);
                    this.J.setHeight(-1);
                }
            } else if (i8 != -2) {
                p5 = i8;
            }
            PopupWindow popupWindow = this.J;
            if (this.f1434r || this.f1433q) {
                z4 = false;
            }
            popupWindow.setOutsideTouchable(z4);
            this.J.update(s(), this.f1426j, this.f1427k, i7 < 0 ? -1 : i7, p5 < 0 ? -1 : p5);
        }
    }

    public int u() {
        return this.f1425i;
    }

    public boolean v() {
        return this.J.getInputMethodMode() == 2;
    }

    public boolean w() {
        return this.I;
    }

    public void y(View view) {
        this.f1439w = view;
    }

    public void z(int i5) {
        this.J.setAnimationStyle(i5);
    }
}
