package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.c;
import androidx.core.view.k0;

public class y extends Spinner {

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f1456m = {16843505};

    /* renamed from: e  reason: collision with root package name */
    private final e f1457e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f1458f;

    /* renamed from: g  reason: collision with root package name */
    private r0 f1459g;

    /* renamed from: h  reason: collision with root package name */
    private SpinnerAdapter f1460h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f1461i;

    /* renamed from: j  reason: collision with root package name */
    private g f1462j;

    /* renamed from: k  reason: collision with root package name */
    int f1463k;

    /* renamed from: l  reason: collision with root package name */
    final Rect f1464l;

    class a extends r0 {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ e f1465n;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(View view, e eVar) {
            super(view);
            this.f1465n = eVar;
        }

        public i.e b() {
            return this.f1465n;
        }

        public boolean c() {
            if (y.this.getInternalPopup().b()) {
                return true;
            }
            y.this.b();
            return true;
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        public void onGlobalLayout() {
            if (!y.this.getInternalPopup().b()) {
                y.this.b();
            }
            ViewTreeObserver viewTreeObserver = y.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    class c implements g, DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        androidx.appcompat.app.c f1468e;

        /* renamed from: f  reason: collision with root package name */
        private ListAdapter f1469f;

        /* renamed from: g  reason: collision with root package name */
        private CharSequence f1470g;

        c() {
        }

        public boolean b() {
            androidx.appcompat.app.c cVar = this.f1468e;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        public int c() {
            return 0;
        }

        public void dismiss() {
            androidx.appcompat.app.c cVar = this.f1468e;
            if (cVar != null) {
                cVar.dismiss();
                this.f1468e = null;
            }
        }

        public Drawable e() {
            return null;
        }

        public void g(CharSequence charSequence) {
            this.f1470g = charSequence;
        }

        public void h(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public void i(int i5) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void j(int i5) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        public void k(int i5) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public void l(int i5, int i6) {
            if (this.f1469f != null) {
                c.a aVar = new c.a(y.this.getPopupContext());
                CharSequence charSequence = this.f1470g;
                if (charSequence != null) {
                    aVar.h(charSequence);
                }
                androidx.appcompat.app.c a5 = aVar.g(this.f1469f, y.this.getSelectedItemPosition(), this).a();
                this.f1468e = a5;
                ListView e5 = a5.e();
                e5.setTextDirection(i5);
                e5.setTextAlignment(i6);
                this.f1468e.show();
            }
        }

        public int m() {
            return 0;
        }

        public CharSequence n() {
            return this.f1470g;
        }

        public void o(ListAdapter listAdapter) {
            this.f1469f = listAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i5) {
            y.this.setSelection(i5);
            if (y.this.getOnItemClickListener() != null) {
                y.this.performItemClick((View) null, i5, this.f1469f.getItemId(i5));
            }
            dismiss();
        }
    }

    private static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: e  reason: collision with root package name */
        private SpinnerAdapter f1472e;

        /* renamed from: f  reason: collision with root package name */
        private ListAdapter f1473f;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1472e = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1473f = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof g1) {
                g1 g1Var = (g1) spinnerAdapter;
                if (g1Var.getDropDownViewTheme() == null) {
                    g1Var.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1473f;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1472e;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i5, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1472e;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i5, view, viewGroup);
        }

        public Object getItem(int i5) {
            SpinnerAdapter spinnerAdapter = this.f1472e;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i5);
        }

        public long getItemId(int i5) {
            SpinnerAdapter spinnerAdapter = this.f1472e;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i5);
        }

        public int getItemViewType(int i5) {
            return 0;
        }

        public View getView(int i5, View view, ViewGroup viewGroup) {
            return getDropDownView(i5, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1472e;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i5) {
            ListAdapter listAdapter = this.f1473f;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i5);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1472e;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1472e;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    class e extends w0 implements g {
        private CharSequence N;
        ListAdapter O;
        private final Rect P = new Rect();
        private int Q;

        class a implements AdapterView.OnItemClickListener {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ y f1474e;

            a(y yVar) {
                this.f1474e = yVar;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                y.this.setSelection(i5);
                if (y.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    y.this.performItemClick(view, i5, eVar.O.getItemId(i5));
                }
                e.this.dismiss();
            }
        }

        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.P(y.this)) {
                    e.this.dismiss();
                    return;
                }
                e.this.N();
                e.super.show();
            }
        }

        class c implements PopupWindow.OnDismissListener {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1477e;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1477e = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = y.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1477e);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i5) {
            super(context, attributeSet, i5);
            y(y.this);
            E(true);
            J(0);
            G(new a(y.this));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x009a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void N() {
            /*
                r8 = this;
                android.graphics.drawable.Drawable r0 = r8.e()
                r1 = 0
                if (r0 == 0) goto L_0x0026
                androidx.appcompat.widget.y r1 = androidx.appcompat.widget.y.this
                android.graphics.Rect r1 = r1.f1464l
                r0.getPadding(r1)
                androidx.appcompat.widget.y r0 = androidx.appcompat.widget.y.this
                boolean r0 = androidx.appcompat.widget.r1.b(r0)
                if (r0 == 0) goto L_0x001d
                androidx.appcompat.widget.y r0 = androidx.appcompat.widget.y.this
                android.graphics.Rect r0 = r0.f1464l
                int r0 = r0.right
                goto L_0x0024
            L_0x001d:
                androidx.appcompat.widget.y r0 = androidx.appcompat.widget.y.this
                android.graphics.Rect r0 = r0.f1464l
                int r0 = r0.left
                int r0 = -r0
            L_0x0024:
                r1 = r0
                goto L_0x002e
            L_0x0026:
                androidx.appcompat.widget.y r0 = androidx.appcompat.widget.y.this
                android.graphics.Rect r0 = r0.f1464l
                r0.right = r1
                r0.left = r1
            L_0x002e:
                androidx.appcompat.widget.y r0 = androidx.appcompat.widget.y.this
                int r0 = r0.getPaddingLeft()
                androidx.appcompat.widget.y r2 = androidx.appcompat.widget.y.this
                int r2 = r2.getPaddingRight()
                androidx.appcompat.widget.y r3 = androidx.appcompat.widget.y.this
                int r3 = r3.getWidth()
                androidx.appcompat.widget.y r4 = androidx.appcompat.widget.y.this
                int r5 = r4.f1463k
                r6 = -2
                if (r5 != r6) goto L_0x0078
                android.widget.ListAdapter r5 = r8.O
                android.widget.SpinnerAdapter r5 = (android.widget.SpinnerAdapter) r5
                android.graphics.drawable.Drawable r6 = r8.e()
                int r4 = r4.a(r5, r6)
                androidx.appcompat.widget.y r5 = androidx.appcompat.widget.y.this
                android.content.Context r5 = r5.getContext()
                android.content.res.Resources r5 = r5.getResources()
                android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
                int r5 = r5.widthPixels
                androidx.appcompat.widget.y r6 = androidx.appcompat.widget.y.this
                android.graphics.Rect r6 = r6.f1464l
                int r7 = r6.left
                int r5 = r5 - r7
                int r6 = r6.right
                int r5 = r5 - r6
                if (r4 <= r5) goto L_0x0070
                r4 = r5
            L_0x0070:
                int r5 = r3 - r0
                int r5 = r5 - r2
                int r4 = java.lang.Math.max(r4, r5)
                goto L_0x007e
            L_0x0078:
                r4 = -1
                if (r5 != r4) goto L_0x0082
                int r4 = r3 - r0
                int r4 = r4 - r2
            L_0x007e:
                r8.A(r4)
                goto L_0x0085
            L_0x0082:
                r8.A(r5)
            L_0x0085:
                androidx.appcompat.widget.y r4 = androidx.appcompat.widget.y.this
                boolean r4 = androidx.appcompat.widget.r1.b(r4)
                if (r4 == 0) goto L_0x009a
                int r3 = r3 - r2
                int r0 = r8.u()
                int r3 = r3 - r0
                int r0 = r8.O()
                int r3 = r3 - r0
                int r1 = r1 + r3
                goto L_0x00a0
            L_0x009a:
                int r2 = r8.O()
                int r0 = r0 + r2
                int r1 = r1 + r0
            L_0x00a0:
                r8.k(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.y.e.N():void");
        }

        public int O() {
            return this.Q;
        }

        /* access modifiers changed from: package-private */
        public boolean P(View view) {
            return k0.A(view) && view.getGlobalVisibleRect(this.P);
        }

        public void g(CharSequence charSequence) {
            this.N = charSequence;
        }

        public void j(int i5) {
            this.Q = i5;
        }

        public void l(int i5, int i6) {
            ViewTreeObserver viewTreeObserver;
            boolean b5 = b();
            N();
            D(2);
            super.show();
            ListView f5 = f();
            f5.setChoiceMode(1);
            f5.setTextDirection(i5);
            f5.setTextAlignment(i6);
            K(y.this.getSelectedItemPosition());
            if (!b5 && (viewTreeObserver = y.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                F(new c(bVar));
            }
        }

        public CharSequence n() {
            return this.N;
        }

        public void o(ListAdapter listAdapter) {
            super.o(listAdapter);
            this.O = listAdapter;
        }
    }

    static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        boolean f1479e;

        class a implements Parcelable.Creator<f> {
            a() {
            }

            /* renamed from: a */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            /* renamed from: b */
            public f[] newArray(int i5) {
                return new f[i5];
            }
        }

        f(Parcel parcel) {
            super(parcel);
            this.f1479e = parcel.readByte() != 0;
        }

        f(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeByte(this.f1479e ? (byte) 1 : 0);
        }
    }

    interface g {
        boolean b();

        int c();

        void dismiss();

        Drawable e();

        void g(CharSequence charSequence);

        void h(Drawable drawable);

        void i(int i5);

        void j(int i5);

        void k(int i5);

        void l(int i5, int i6);

        int m();

        CharSequence n();

        void o(ListAdapter listAdapter);
    }

    public y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.I);
    }

    public y(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, -1);
    }

    public y(Context context, AttributeSet attributeSet, int i5, int i6) {
        this(context, attributeSet, i5, i6, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r11 != null) goto L_0x004d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d A[SYNTHETIC, Splitter:B:10:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public y(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.f1464l = r0
            android.content.Context r0 = r6.getContext()
            androidx.appcompat.widget.f1.a(r6, r0)
            int[] r0 = d.j.A2
            r1 = 0
            androidx.appcompat.widget.k1 r0 = androidx.appcompat.widget.k1.u(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.e r2 = new androidx.appcompat.widget.e
            r2.<init>(r6)
            r6.f1457e = r2
            if (r11 == 0) goto L_0x0029
            h.d r2 = new h.d
            r2.<init>((android.content.Context) r7, (android.content.res.Resources.Theme) r11)
        L_0x0026:
            r6.f1458f = r2
            goto L_0x0039
        L_0x0029:
            int r11 = d.j.F2
            int r11 = r0.m(r11, r1)
            if (r11 == 0) goto L_0x0037
            h.d r2 = new h.d
            r2.<init>((android.content.Context) r7, (int) r11)
            goto L_0x0026
        L_0x0037:
            r6.f1458f = r7
        L_0x0039:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L_0x0069
            int[] r11 = f1456m     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            boolean r3 = r11.hasValue(r1)     // Catch:{ Exception -> 0x0051 }
            if (r3 == 0) goto L_0x004d
            int r10 = r11.getInt(r1, r1)     // Catch:{ Exception -> 0x0051 }
        L_0x004d:
            r11.recycle()
            goto L_0x0069
        L_0x0051:
            r3 = move-exception
            goto L_0x0057
        L_0x0053:
            r7 = move-exception
            goto L_0x0063
        L_0x0055:
            r3 = move-exception
            r11 = r2
        L_0x0057:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch:{ all -> 0x0061 }
            if (r11 == 0) goto L_0x0069
            goto L_0x004d
        L_0x0061:
            r7 = move-exception
            r2 = r11
        L_0x0063:
            if (r2 == 0) goto L_0x0068
            r2.recycle()
        L_0x0068:
            throw r7
        L_0x0069:
            r11 = 1
            if (r10 == 0) goto L_0x00a6
            if (r10 == r11) goto L_0x006f
            goto L_0x00b6
        L_0x006f:
            androidx.appcompat.widget.y$e r10 = new androidx.appcompat.widget.y$e
            android.content.Context r3 = r6.f1458f
            r10.<init>(r3, r8, r9)
            android.content.Context r3 = r6.f1458f
            int[] r4 = d.j.A2
            androidx.appcompat.widget.k1 r1 = androidx.appcompat.widget.k1.u(r3, r8, r4, r9, r1)
            int r3 = d.j.E2
            r4 = -2
            int r3 = r1.l(r3, r4)
            r6.f1463k = r3
            int r3 = d.j.C2
            android.graphics.drawable.Drawable r3 = r1.f(r3)
            r10.h(r3)
            int r3 = d.j.D2
            java.lang.String r3 = r0.n(r3)
            r10.g(r3)
            r1.v()
            r6.f1462j = r10
            androidx.appcompat.widget.y$a r1 = new androidx.appcompat.widget.y$a
            r1.<init>(r6, r10)
            r6.f1459g = r1
            goto L_0x00b6
        L_0x00a6:
            androidx.appcompat.widget.y$c r10 = new androidx.appcompat.widget.y$c
            r10.<init>()
            r6.f1462j = r10
            int r1 = d.j.D2
            java.lang.String r1 = r0.n(r1)
            r10.g(r1)
        L_0x00b6:
            int r10 = d.j.B2
            java.lang.CharSequence[] r10 = r0.p(r10)
            if (r10 == 0) goto L_0x00ce
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r7, r3, r10)
            int r7 = d.g.f4083t
            r1.setDropDownViewResource(r7)
            r6.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00ce:
            r0.v()
            r6.f1461i = r11
            android.widget.SpinnerAdapter r7 = r6.f1460h
            if (r7 == 0) goto L_0x00dc
            r6.setAdapter((android.widget.SpinnerAdapter) r7)
            r6.f1460h = r2
        L_0x00dc:
            androidx.appcompat.widget.e r7 = r6.f1457e
            r7.e(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.y.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    /* access modifiers changed from: package-private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i5 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i6 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i6 = Math.max(i6, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i6;
        }
        drawable.getPadding(this.f1464l);
        Rect rect = this.f1464l;
        return i6 + rect.left + rect.right;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f1462j.l(getTextDirection(), getTextAlignment());
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1457e;
        if (eVar != null) {
            eVar.b();
        }
    }

    public int getDropDownHorizontalOffset() {
        g gVar = this.f1462j;
        return gVar != null ? gVar.c() : super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        g gVar = this.f1462j;
        return gVar != null ? gVar.m() : super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        return this.f1462j != null ? this.f1463k : super.getDropDownWidth();
    }

    /* access modifiers changed from: package-private */
    public final g getInternalPopup() {
        return this.f1462j;
    }

    public Drawable getPopupBackground() {
        g gVar = this.f1462j;
        return gVar != null ? gVar.e() : super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.f1458f;
    }

    public CharSequence getPrompt() {
        g gVar = this.f1462j;
        return gVar != null ? gVar.n() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1457e;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1457e;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f1462j;
        if (gVar != null && gVar.b()) {
            this.f1462j.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.f1462j != null && View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i5)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        if (fVar.f1479e && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b());
        }
    }

    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        g gVar = this.f1462j;
        fVar.f1479e = gVar != null && gVar.b();
        return fVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        r0 r0Var = this.f1459g;
        if (r0Var == null || !r0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        g gVar = this.f1462j;
        if (gVar == null) {
            return super.performClick();
        }
        if (gVar.b()) {
            return true;
        }
        b();
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1461i) {
            this.f1460h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1462j != null) {
            Context context = this.f1458f;
            if (context == null) {
                context = getContext();
            }
            this.f1462j.o(new d(spinnerAdapter, context.getTheme()));
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1457e;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        e eVar = this.f1457e;
        if (eVar != null) {
            eVar.g(i5);
        }
    }

    public void setDropDownHorizontalOffset(int i5) {
        g gVar = this.f1462j;
        if (gVar != null) {
            gVar.j(i5);
            this.f1462j.k(i5);
            return;
        }
        super.setDropDownHorizontalOffset(i5);
    }

    public void setDropDownVerticalOffset(int i5) {
        g gVar = this.f1462j;
        if (gVar != null) {
            gVar.i(i5);
        } else {
            super.setDropDownVerticalOffset(i5);
        }
    }

    public void setDropDownWidth(int i5) {
        if (this.f1462j != null) {
            this.f1463k = i5;
        } else {
            super.setDropDownWidth(i5);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.f1462j;
        if (gVar != null) {
            gVar.h(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i5) {
        setPopupBackgroundDrawable(e.a.b(getPopupContext(), i5));
    }

    public void setPrompt(CharSequence charSequence) {
        g gVar = this.f1462j;
        if (gVar != null) {
            gVar.g(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1457e;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1457e;
        if (eVar != null) {
            eVar.j(mode);
        }
    }
}
