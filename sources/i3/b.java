package i3;

import g3.d;
import java.util.concurrent.atomic.AtomicReference;
import m2.t;
import p2.c;

public abstract class b<T> implements t<T>, c {

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<c> f4954e = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public void a() {
    }

    public final void c(c cVar) {
        if (d.c(this.f4954e, cVar, getClass())) {
            a();
        }
    }

    public final void dispose() {
        s2.c.c(this.f4954e);
    }

    public final boolean f() {
        return this.f4954e.get() == s2.c.DISPOSED;
    }
}
