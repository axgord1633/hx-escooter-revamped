package e4;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.j0;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.v;
import m3.q;
import v3.l;

public class m<E> extends a<E> {

    /* renamed from: e  reason: collision with root package name */
    private final ReentrantLock f4539e = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    private Object f4540f = b.f4512a;

    public m(l<? super E, q> lVar) {
        super(lVar);
    }

    private final j0 x(Object obj) {
        l<E, q> lVar;
        Object obj2 = this.f4540f;
        j0 j0Var = null;
        if (!(obj2 == b.f4512a || (lVar = this.f4519b) == null)) {
            j0Var = v.d(lVar, obj2, (j0) null, 2, (Object) null);
        }
        this.f4540f = obj;
        return j0Var;
    }

    /* access modifiers changed from: protected */
    public String c() {
        ReentrantLock reentrantLock = this.f4539e;
        reentrantLock.lock();
        try {
            return "(value=" + this.f4540f + ')';
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object i(E e5) {
        q l5;
        ReentrantLock reentrantLock = this.f4539e;
        reentrantLock.lock();
        try {
            j<?> d5 = d();
            if (d5 != null) {
                return d5;
            }
            if (this.f4540f == b.f4512a) {
                do {
                    l5 = l();
                    if (l5 != null) {
                        if (l5 instanceof j) {
                            reentrantLock.unlock();
                            return l5;
                        }
                        k.b(l5);
                    }
                } while (l5.d(e5, (o.b) null) == null);
                q qVar = q.f5904a;
                reentrantLock.unlock();
                l5.a(e5);
                return l5.c();
            }
            j0 x4 = x(e5);
            if (x4 == null) {
                b0 b0Var = b.f4513b;
                reentrantLock.unlock();
                return b0Var;
            }
            throw x4;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public boolean q(o<? super E> oVar) {
        ReentrantLock reentrantLock = this.f4539e;
        reentrantLock.lock();
        try {
            return super.q(oVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean r() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean s() {
        ReentrantLock reentrantLock = this.f4539e;
        reentrantLock.lock();
        try {
            return this.f4540f == b.f4512a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object v() {
        ReentrantLock reentrantLock = this.f4539e;
        reentrantLock.lock();
        try {
            Object obj = this.f4540f;
            b0 b0Var = b.f4512a;
            if (obj == b0Var) {
                Object d5 = d();
                if (d5 == null) {
                    d5 = b.f4515d;
                }
                return d5;
            }
            this.f4540f = b0Var;
            q qVar = q.f5904a;
            reentrantLock.unlock();
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}
