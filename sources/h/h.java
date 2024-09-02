package h;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.k1;
import androidx.core.view.l1;
import androidx.core.view.m1;
import java.util.ArrayList;
import java.util.Iterator;

public class h {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<k1> f4826a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private long f4827b = -1;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f4828c;

    /* renamed from: d  reason: collision with root package name */
    l1 f4829d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4830e;

    /* renamed from: f  reason: collision with root package name */
    private final m1 f4831f = new a();

    class a extends m1 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4832a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f4833b = 0;

        a() {
        }

        public void b(View view) {
            int i5 = this.f4833b + 1;
            this.f4833b = i5;
            if (i5 == h.this.f4826a.size()) {
                l1 l1Var = h.this.f4829d;
                if (l1Var != null) {
                    l1Var.b((View) null);
                }
                d();
            }
        }

        public void c(View view) {
            if (!this.f4832a) {
                this.f4832a = true;
                l1 l1Var = h.this.f4829d;
                if (l1Var != null) {
                    l1Var.c((View) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f4833b = 0;
            this.f4832a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f4830e) {
            Iterator<k1> it = this.f4826a.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            this.f4830e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f4830e = false;
    }

    public h c(k1 k1Var) {
        if (!this.f4830e) {
            this.f4826a.add(k1Var);
        }
        return this;
    }

    public h d(k1 k1Var, k1 k1Var2) {
        this.f4826a.add(k1Var);
        k1Var2.j(k1Var.d());
        this.f4826a.add(k1Var2);
        return this;
    }

    public h e(long j5) {
        if (!this.f4830e) {
            this.f4827b = j5;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f4830e) {
            this.f4828c = interpolator;
        }
        return this;
    }

    public h g(l1 l1Var) {
        if (!this.f4830e) {
            this.f4829d = l1Var;
        }
        return this;
    }

    public void h() {
        if (!this.f4830e) {
            Iterator<k1> it = this.f4826a.iterator();
            while (it.hasNext()) {
                k1 next = it.next();
                long j5 = this.f4827b;
                if (j5 >= 0) {
                    next.f(j5);
                }
                Interpolator interpolator = this.f4828c;
                if (interpolator != null) {
                    next.g(interpolator);
                }
                if (this.f4829d != null) {
                    next.h(this.f4831f);
                }
                next.l();
            }
            this.f4830e = true;
        }
    }
}
