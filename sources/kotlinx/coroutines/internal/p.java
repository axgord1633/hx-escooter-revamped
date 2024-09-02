package kotlinx.coroutines.internal;

import androidx.concurrent.futures.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class p<E> {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f5620a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public p(boolean z4) {
        this._cur = new q(8, z4);
    }

    public final boolean a(E e5) {
        while (true) {
            q qVar = (q) this._cur;
            int a5 = qVar.a(e5);
            if (a5 == 0) {
                return true;
            }
            if (a5 == 1) {
                b.a(f5620a, this, qVar, qVar.i());
            } else if (a5 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            q qVar = (q) this._cur;
            if (!qVar.d()) {
                b.a(f5620a, this, qVar, qVar.i());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((q) this._cur).f();
    }

    public final E d() {
        while (true) {
            q qVar = (q) this._cur;
            E j5 = qVar.j();
            if (j5 != q.f5624h) {
                return j5;
            }
            b.a(f5620a, this, qVar, qVar.i());
        }
    }
}
