package i3;

import g3.d;
import java.util.concurrent.atomic.AtomicReference;
import m2.p;
import p2.c;

public abstract class a<T> implements p<T>, c {

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<c> f4953e = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public void b() {
    }

    public final void c(c cVar) {
        if (d.c(this.f4953e, cVar, getClass())) {
            b();
        }
    }

    public final void dispose() {
        s2.c.c(this.f4953e);
    }

    public final boolean f() {
        return this.f4953e.get() == s2.c.DISPOSED;
    }
}
