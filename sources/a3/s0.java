package a3;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import m2.k;
import m2.n;
import m2.p;
import r2.f;
import u2.d;

public final class s0 {

    public static final class a<T> extends AtomicInteger implements d<T>, Runnable {

        /* renamed from: e  reason: collision with root package name */
        final p<? super T> f351e;

        /* renamed from: f  reason: collision with root package name */
        final T f352f;

        public a(p<? super T> pVar, T t5) {
            this.f351e = pVar;
            this.f352f = t5;
        }

        public void clear() {
            lazySet(3);
        }

        public void dispose() {
            set(3);
        }

        public boolean f() {
            return get() == 3;
        }

        public int i(int i5) {
            if ((i5 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        public boolean isEmpty() {
            return get() != 1;
        }

        public boolean offer(T t5) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public T poll() {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.f352f;
        }

        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f351e.d(this.f352f);
                if (get() == 2) {
                    lazySet(3);
                    this.f351e.a();
                }
            }
        }
    }

    static final class b<T, R> extends k<R> {

        /* renamed from: e  reason: collision with root package name */
        final T f353e;

        /* renamed from: f  reason: collision with root package name */
        final f<? super T, ? extends n<? extends R>> f354f;

        b(T t5, f<? super T, ? extends n<? extends R>> fVar) {
            this.f353e = t5;
            this.f354f = fVar;
        }

        public void v0(p<? super R> pVar) {
            try {
                n nVar = (n) t2.b.e(this.f354f.apply(this.f353e), "The mapper returned a null ObservableSource");
                if (nVar instanceof Callable) {
                    try {
                        Object call = ((Callable) nVar).call();
                        if (call == null) {
                            s2.d.c(pVar);
                            return;
                        }
                        a aVar = new a(pVar, call);
                        pVar.c(aVar);
                        aVar.run();
                    } catch (Throwable th) {
                        q2.b.b(th);
                        s2.d.m(th, pVar);
                    }
                } else {
                    nVar.g(pVar);
                }
            } catch (Throwable th2) {
                s2.d.m(th2, pVar);
            }
        }
    }

    public static <T, U> k<U> a(T t5, f<? super T, ? extends n<? extends U>> fVar) {
        return j3.a.o(new b(t5, fVar));
    }

    public static <T, R> boolean b(n<T> nVar, p<? super R> pVar, f<? super T, ? extends n<? extends R>> fVar) {
        if (!(nVar instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) nVar).call();
            if (call == null) {
                s2.d.c(pVar);
                return true;
            }
            n nVar2 = (n) t2.b.e(fVar.apply(call), "The mapper returned a null ObservableSource");
            if (nVar2 instanceof Callable) {
                Object call2 = ((Callable) nVar2).call();
                if (call2 == null) {
                    s2.d.c(pVar);
                    return true;
                }
                a aVar = new a(pVar, call2);
                pVar.c(aVar);
                aVar.run();
            } else {
                nVar2.g(pVar);
            }
            return true;
        } catch (Throwable th) {
            q2.b.b(th);
            s2.d.m(th, pVar);
            return true;
        }
    }
}
