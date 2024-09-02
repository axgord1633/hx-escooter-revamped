package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import d.d;
import d.f;
import d.g;
import d.i;

class p1 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1374a;

    /* renamed from: b  reason: collision with root package name */
    private final View f1375b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f1376c;

    /* renamed from: d  reason: collision with root package name */
    private final WindowManager.LayoutParams f1377d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f1378e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final int[] f1379f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    private final int[] f1380g = new int[2];

    p1(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1377d = layoutParams;
        this.f1374a = context;
        View inflate = LayoutInflater.from(context).inflate(g.f4082s, (ViewGroup) null);
        this.f1375b = inflate;
        this.f1376c = (TextView) inflate.findViewById(f.f4056s);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.f4096a;
        layoutParams.flags = 24;
    }

    private void a(View view, int i5, int i6, boolean z4, WindowManager.LayoutParams layoutParams) {
        int i7;
        int i8;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1374a.getResources().getDimensionPixelOffset(d.f4009m);
        if (view.getWidth() < dimensionPixelOffset) {
            i5 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1374a.getResources().getDimensionPixelOffset(d.f4008l);
            i8 = i6 + dimensionPixelOffset2;
            i7 = i6 - dimensionPixelOffset2;
        } else {
            i8 = view.getHeight();
            i7 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1374a.getResources().getDimensionPixelOffset(z4 ? d.f4011o : d.f4010n);
        View b5 = b(view);
        if (b5 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b5.getWindowVisibleDisplayFrame(this.f1378e);
        Rect rect = this.f1378e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1374a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1378e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b5.getLocationOnScreen(this.f1380g);
        view.getLocationOnScreen(this.f1379f);
        int[] iArr = this.f1379f;
        int i9 = iArr[0];
        int[] iArr2 = this.f1380g;
        int i10 = i9 - iArr2[0];
        iArr[0] = i10;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i10 + i5) - (b5.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1375b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1375b.getMeasuredHeight();
        int i11 = this.f1379f[1];
        int i12 = ((i7 + i11) - dimensionPixelOffset3) - measuredHeight;
        int i13 = i11 + i8 + dimensionPixelOffset3;
        if (!z4 ? measuredHeight + i13 > this.f1378e.height() : i12 >= 0) {
            layoutParams.y = i12;
        } else {
            layoutParams.y = i13;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (d()) {
            ((WindowManager) this.f1374a.getSystemService("window")).removeView(this.f1375b);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f1375b.getParent() != null;
    }

    /* access modifiers changed from: package-private */
    public void e(View view, int i5, int i6, boolean z4, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f1376c.setText(charSequence);
        a(view, i5, i6, z4, this.f1377d);
        ((WindowManager) this.f1374a.getSystemService("window")).addView(this.f1375b, this.f1377d);
    }
}
