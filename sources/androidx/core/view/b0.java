package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

public class b0 {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f1890a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f1891b;

    /* renamed from: c  reason: collision with root package name */
    private final View f1892c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1893d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f1894e;

    public b0(View view) {
        this.f1892c = view;
    }

    private boolean f(int i5, int i6, int i7, int i8, int[] iArr, int i9, int[] iArr2) {
        ViewParent g5;
        int i10;
        int i11;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!j() || (g5 = g(i9)) == null) {
            return false;
        }
        if (i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.f1892c.getLocationInWindow(iArr4);
            i11 = iArr4[0];
            i10 = iArr4[1];
        } else {
            i11 = 0;
            i10 = 0;
        }
        if (iArr2 == null) {
            int[] h5 = h();
            h5[0] = 0;
            h5[1] = 0;
            iArr3 = h5;
        } else {
            iArr3 = iArr2;
        }
        i1.d(g5, this.f1892c, i5, i6, i7, i8, i9, iArr3);
        if (iArr4 != null) {
            this.f1892c.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i11;
            iArr4[1] = iArr4[1] - i10;
        }
        return true;
    }

    private ViewParent g(int i5) {
        if (i5 == 0) {
            return this.f1890a;
        }
        if (i5 != 1) {
            return null;
        }
        return this.f1891b;
    }

    private int[] h() {
        if (this.f1894e == null) {
            this.f1894e = new int[2];
        }
        return this.f1894e;
    }

    private void l(int i5, ViewParent viewParent) {
        if (i5 == 0) {
            this.f1890a = viewParent;
        } else if (i5 == 1) {
            this.f1891b = viewParent;
        }
    }

    public boolean a(float f5, float f6, boolean z4) {
        ViewParent g5;
        if (!j() || (g5 = g(0)) == null) {
            return false;
        }
        return i1.a(g5, this.f1892c, f5, f6, z4);
    }

    public boolean b(float f5, float f6) {
        ViewParent g5;
        if (!j() || (g5 = g(0)) == null) {
            return false;
        }
        return i1.b(g5, this.f1892c, f5, f6);
    }

    public boolean c(int i5, int i6, int[] iArr, int[] iArr2, int i7) {
        ViewParent g5;
        int i8;
        int i9;
        if (!j() || (g5 = g(i7)) == null) {
            return false;
        }
        if (i5 != 0 || i6 != 0) {
            if (iArr2 != null) {
                this.f1892c.getLocationInWindow(iArr2);
                i9 = iArr2[0];
                i8 = iArr2[1];
            } else {
                i9 = 0;
                i8 = 0;
            }
            if (iArr == null) {
                iArr = h();
            }
            iArr[0] = 0;
            iArr[1] = 0;
            i1.c(g5, this.f1892c, i5, i6, iArr, i7);
            if (iArr2 != null) {
                this.f1892c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i9;
                iArr2[1] = iArr2[1] - i8;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public void d(int i5, int i6, int i7, int i8, int[] iArr, int i9, int[] iArr2) {
        f(i5, i6, i7, i8, iArr, i9, iArr2);
    }

    public boolean e(int i5, int i6, int i7, int i8, int[] iArr) {
        return f(i5, i6, i7, i8, iArr, 0, (int[]) null);
    }

    public boolean i(int i5) {
        return g(i5) != null;
    }

    public boolean j() {
        return this.f1893d;
    }

    public void k(boolean z4) {
        if (this.f1893d) {
            k0.b0(this.f1892c);
        }
        this.f1893d = z4;
    }

    public boolean m(int i5, int i6) {
        if (i(i6)) {
            return true;
        }
        if (!j()) {
            return false;
        }
        View view = this.f1892c;
        for (ViewParent parent = this.f1892c.getParent(); parent != null; parent = parent.getParent()) {
            if (i1.f(parent, view, this.f1892c, i5, i6)) {
                l(i6, parent);
                i1.e(parent, view, this.f1892c, i5, i6);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void n(int i5) {
        ViewParent g5 = g(i5);
        if (g5 != null) {
            i1.g(g5, this.f1892c, i5);
            l(i5, (ViewParent) null);
        }
    }
}
