package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.f;
import androidx.core.provider.g;

class a {

    /* renamed from: a  reason: collision with root package name */
    private final g.c f1797a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f1798b;

    /* renamed from: androidx.core.provider.a$a  reason: collision with other inner class name */
    class C0028a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g.c f1799e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Typeface f1800f;

        C0028a(g.c cVar, Typeface typeface) {
            this.f1799e = cVar;
            this.f1800f = typeface;
        }

        public void run() {
            this.f1799e.b(this.f1800f);
        }
    }

    class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g.c f1802e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f1803f;

        b(g.c cVar, int i5) {
            this.f1802e = cVar;
            this.f1803f = i5;
        }

        public void run() {
            this.f1802e.a(this.f1803f);
        }
    }

    a(g.c cVar, Handler handler) {
        this.f1797a = cVar;
        this.f1798b = handler;
    }

    private void a(int i5) {
        this.f1798b.post(new b(this.f1797a, i5));
    }

    private void c(Typeface typeface) {
        this.f1798b.post(new C0028a(this.f1797a, typeface));
    }

    /* access modifiers changed from: package-private */
    public void b(f.e eVar) {
        if (eVar.a()) {
            c(eVar.f1826a);
        } else {
            a(eVar.f1827b);
        }
    }
}
