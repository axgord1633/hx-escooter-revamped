package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

public class e0 {

    /* renamed from: a  reason: collision with root package name */
    private int f1910a;

    /* renamed from: b  reason: collision with root package name */
    private int f1911b;

    public e0(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f1910a | this.f1911b;
    }

    public void b(View view, View view2, int i5) {
        c(view, view2, i5, 0);
    }

    public void c(View view, View view2, int i5, int i6) {
        if (i6 == 1) {
            this.f1911b = i5;
        } else {
            this.f1910a = i5;
        }
    }

    public void d(View view, int i5) {
        if (i5 == 1) {
            this.f1911b = 0;
        } else {
            this.f1910a = 0;
        }
    }
}
