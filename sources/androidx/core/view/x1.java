package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import m.g;

public final class x1 {

    /* renamed from: a  reason: collision with root package name */
    private final e f1993a;

    private static class a extends e {

        /* renamed from: a  reason: collision with root package name */
        protected final Window f1994a;

        /* renamed from: b  reason: collision with root package name */
        private final View f1995b;

        a(Window window, View view) {
            this.f1994a = window;
            this.f1995b = view;
        }

        /* access modifiers changed from: protected */
        public void c(int i5) {
            View decorView = this.f1994a.getDecorView();
            decorView.setSystemUiVisibility(i5 | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void d(int i5) {
            this.f1994a.addFlags(i5);
        }

        /* access modifiers changed from: protected */
        public void e(int i5) {
            View decorView = this.f1994a.getDecorView();
            decorView.setSystemUiVisibility((~i5) & decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void f(int i5) {
            this.f1994a.clearFlags(i5);
        }
    }

    private static class b extends a {
        b(Window window, View view) {
            super(window, view);
        }

        public void b(boolean z4) {
            if (z4) {
                f(67108864);
                d(Integer.MIN_VALUE);
                c(8192);
                return;
            }
            e(8192);
        }
    }

    private static class c extends b {
        c(Window window, View view) {
            super(window, view);
        }

        public void a(boolean z4) {
            if (z4) {
                f(134217728);
                d(Integer.MIN_VALUE);
                c(16);
                return;
            }
            e(16);
        }
    }

    private static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final x1 f1996a;

        /* renamed from: b  reason: collision with root package name */
        final WindowInsetsController f1997b;

        /* renamed from: c  reason: collision with root package name */
        private final g<Object, WindowInsetsController.OnControllableInsetsChangedListener> f1998c;

        /* renamed from: d  reason: collision with root package name */
        protected Window f1999d;

        d(Window window, x1 x1Var) {
            this(window.getInsetsController(), x1Var);
            this.f1999d = window;
        }

        d(WindowInsetsController windowInsetsController, x1 x1Var) {
            this.f1998c = new g<>();
            this.f1997b = windowInsetsController;
            this.f1996a = x1Var;
        }

        public void a(boolean z4) {
            if (z4) {
                if (this.f1999d != null) {
                    c(16);
                }
                this.f1997b.setSystemBarsAppearance(16, 16);
                return;
            }
            if (this.f1999d != null) {
                d(16);
            }
            this.f1997b.setSystemBarsAppearance(0, 16);
        }

        public void b(boolean z4) {
            if (z4) {
                if (this.f1999d != null) {
                    c(8192);
                }
                this.f1997b.setSystemBarsAppearance(8, 8);
                return;
            }
            if (this.f1999d != null) {
                d(8192);
            }
            this.f1997b.setSystemBarsAppearance(0, 8);
        }

        /* access modifiers changed from: protected */
        public void c(int i5) {
            View decorView = this.f1999d.getDecorView();
            decorView.setSystemUiVisibility(i5 | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void d(int i5) {
            View decorView = this.f1999d.getDecorView();
            decorView.setSystemUiVisibility((~i5) & decorView.getSystemUiVisibility());
        }
    }

    private static class e {
        e() {
        }

        public void a(boolean z4) {
        }

        public void b(boolean z4) {
            throw null;
        }
    }

    public x1(Window window, View view) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            this.f1993a = new d(window, this);
        } else {
            this.f1993a = i5 >= 26 ? new c(window, view) : new b(window, view);
        }
    }

    public void a(boolean z4) {
        this.f1993a.a(z4);
    }

    public void b(boolean z4) {
        this.f1993a.b(z4);
    }
}
