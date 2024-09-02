package e4;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.o;
import m3.i;
import m3.q;
import v3.l;

public class d<E> extends a<E> {

    /* renamed from: e  reason: collision with root package name */
    private final int f4522e;

    /* renamed from: f  reason: collision with root package name */
    private final e f4523f;

    /* renamed from: g  reason: collision with root package name */
    private final ReentrantLock f4524g;

    /* renamed from: h  reason: collision with root package name */
    private Object[] f4525h;

    /* renamed from: i  reason: collision with root package name */
    private int f4526i;
    private volatile /* synthetic */ int size;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4527a;

        static {
            int[] iArr = new int[e.values().length];
            iArr[e.SUSPEND.ordinal()] = 1;
            iArr[e.DROP_LATEST.ordinal()] = 2;
            iArr[e.DROP_OLDEST.ordinal()] = 3;
            f4527a = iArr;
        }
    }

    public d(int i5, e eVar, l<? super E, q> lVar) {
        super(lVar);
        this.f4522e = i5;
        this.f4523f = eVar;
        if (i5 < 1 ? false : true) {
            this.f4524g = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i5, 8)];
            i.g(objArr, b.f4512a, 0, 0, 6, (Object) null);
            this.f4525h = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i5 + " was specified").toString());
    }

    private final void x(int i5, E e5) {
        if (i5 < this.f4522e) {
            y(i5);
            Object[] objArr = this.f4525h;
            objArr[(this.f4526i + i5) % objArr.length] = e5;
            return;
        }
        Object[] objArr2 = this.f4525h;
        int i6 = this.f4526i;
        objArr2[i6 % objArr2.length] = null;
        objArr2[(i5 + i6) % objArr2.length] = e5;
        this.f4526i = (i6 + 1) % objArr2.length;
    }

    private final void y(int i5) {
        Object[] objArr = this.f4525h;
        if (i5 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f4522e);
            Object[] objArr2 = new Object[min];
            for (int i6 = 0; i6 < i5; i6++) {
                Object[] objArr3 = this.f4525h;
                objArr2[i6] = objArr3[(this.f4526i + i6) % objArr3.length];
            }
            i.f(objArr2, b.f4512a, i5, min);
            this.f4525h = objArr2;
            this.f4526i = 0;
        }
    }

    private final b0 z(int i5) {
        if (i5 < this.f4522e) {
            this.size = i5 + 1;
            return null;
        }
        int i6 = a.f4527a[this.f4523f.ordinal()];
        if (i6 == 1) {
            return b.f4514c;
        }
        if (i6 == 2) {
            return b.f4513b;
        }
        if (i6 == 3) {
            return null;
        }
        throw new i();
    }

    /* access modifiers changed from: protected */
    public String c() {
        return "(buffer:capacity=" + this.f4522e + ",size=" + this.size + ')';
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public Object i(E e5) {
        q l5;
        ReentrantLock reentrantLock = this.f4524g;
        reentrantLock.lock();
        int i5 = this.size;
        j<?> d5 = d();
        if (d5 != null) {
            reentrantLock.unlock();
            return d5;
        }
        b0 z4 = z(i5);
        if (z4 != null) {
            reentrantLock.unlock();
            return z4;
        }
        if (i5 == 0) {
            do {
                try {
                    l5 = l();
                    if (l5 != null) {
                        if (l5 instanceof j) {
                            this.size = i5;
                            reentrantLock.unlock();
                            return l5;
                        }
                        k.b(l5);
                    }
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } while (l5.d(e5, (o.b) null) == null);
            this.size = i5;
            q qVar = q.f5904a;
            reentrantLock.unlock();
            l5.a(e5);
            return l5.c();
        }
        x(i5, e5);
        b0 b0Var = b.f4513b;
        reentrantLock.unlock();
        return b0Var;
    }

    /* access modifiers changed from: protected */
    public boolean q(o<? super E> oVar) {
        ReentrantLock reentrantLock = this.f4524g;
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
        return this.size == 0;
    }

    /* access modifiers changed from: protected */
    public Object v() {
        ReentrantLock reentrantLock = this.f4524g;
        reentrantLock.lock();
        try {
            int i5 = this.size;
            if (i5 == 0) {
                Object d5 = d();
                if (d5 == null) {
                    d5 = b.f4515d;
                }
                return d5;
            }
            Object[] objArr = this.f4525h;
            int i6 = this.f4526i;
            Object obj = objArr[i6];
            s sVar = null;
            objArr[i6] = null;
            this.size = i5 - 1;
            Object obj2 = b.f4515d;
            boolean z4 = false;
            if (i5 == this.f4522e) {
                s sVar2 = null;
                while (true) {
                    s m5 = m();
                    if (m5 == null) {
                        sVar = sVar2;
                        break;
                    }
                    k.b(m5);
                    if (m5.y((o.b) null) != null) {
                        obj2 = m5.x();
                        z4 = true;
                        sVar = m5;
                        break;
                    }
                    m5.z();
                    sVar2 = m5;
                }
            }
            if (obj2 != b.f4515d && !(obj2 instanceof j)) {
                this.size = i5;
                Object[] objArr2 = this.f4525h;
                objArr2[(this.f4526i + i5) % objArr2.length] = obj2;
            }
            this.f4526i = (this.f4526i + 1) % this.f4525h.length;
            q qVar = q.f5904a;
            reentrantLock.unlock();
            if (z4) {
                k.b(sVar);
                sVar.w();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}
