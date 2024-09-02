package e4;

import c4.k0;
import c4.m;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.o;

public final class j<E> extends s implements q<E> {

    /* renamed from: h  reason: collision with root package name */
    public final Throwable f4538h;

    /* renamed from: A */
    public j<E> c() {
        return this;
    }

    /* renamed from: B */
    public j<E> x() {
        return this;
    }

    public final Throwable C() {
        Throwable th = this.f4538h;
        return th == null ? new k("Channel was closed") : th;
    }

    public final Throwable D() {
        Throwable th = this.f4538h;
        return th == null ? new l("Channel was closed") : th;
    }

    public void a(E e5) {
    }

    public b0 d(E e5, o.b bVar) {
        return m.f3144a;
    }

    public String toString() {
        return "Closed@" + k0.b(this) + '[' + this.f4538h + ']';
    }

    public void w() {
    }

    public b0 y(o.b bVar) {
        return m.f3144a;
    }
}
