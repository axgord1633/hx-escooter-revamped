package j3;

import d3.n;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import m2.h;
import m2.i;
import m2.k;
import m2.p;
import m2.q;
import m2.r;
import m2.t;
import q2.c;
import q2.d;
import r2.b;
import r2.e;
import r2.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile e<? super Throwable> f5453a;

    /* renamed from: b  reason: collision with root package name */
    static volatile f<? super Runnable, ? extends Runnable> f5454b;

    /* renamed from: c  reason: collision with root package name */
    static volatile f<? super Callable<q>, ? extends q> f5455c;

    /* renamed from: d  reason: collision with root package name */
    static volatile f<? super Callable<q>, ? extends q> f5456d;

    /* renamed from: e  reason: collision with root package name */
    static volatile f<? super Callable<q>, ? extends q> f5457e;

    /* renamed from: f  reason: collision with root package name */
    static volatile f<? super Callable<q>, ? extends q> f5458f;

    /* renamed from: g  reason: collision with root package name */
    static volatile f<? super q, ? extends q> f5459g;

    /* renamed from: h  reason: collision with root package name */
    static volatile f<? super q, ? extends q> f5460h;

    /* renamed from: i  reason: collision with root package name */
    static volatile f<? super m2.f, ? extends m2.f> f5461i;

    /* renamed from: j  reason: collision with root package name */
    static volatile f<? super k, ? extends k> f5462j;

    /* renamed from: k  reason: collision with root package name */
    static volatile f<? super h3.a, ? extends h3.a> f5463k;

    /* renamed from: l  reason: collision with root package name */
    static volatile f<? super h, ? extends h> f5464l;

    /* renamed from: m  reason: collision with root package name */
    static volatile f<? super r, ? extends r> f5465m;

    /* renamed from: n  reason: collision with root package name */
    static volatile f<? super m2.a, ? extends m2.a> f5466n;

    /* renamed from: o  reason: collision with root package name */
    static volatile b<? super m2.f, ? super u4.b, ? extends u4.b> f5467o;

    /* renamed from: p  reason: collision with root package name */
    static volatile b<? super h, ? super i, ? extends i> f5468p;

    /* renamed from: q  reason: collision with root package name */
    static volatile b<? super k, ? super p, ? extends p> f5469q;

    /* renamed from: r  reason: collision with root package name */
    static volatile b<? super r, ? super t, ? extends t> f5470r;

    /* renamed from: s  reason: collision with root package name */
    static volatile b<? super m2.a, ? super m2.b, ? extends m2.b> f5471s;

    /* renamed from: t  reason: collision with root package name */
    static volatile boolean f5472t;

    static void A(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    static <T, U, R> R a(b<T, U, R> bVar, T t5, U u5) {
        try {
            return bVar.apply(t5, u5);
        } catch (Throwable th) {
            throw g3.f.d(th);
        }
    }

    static <T, R> R b(f<T, R> fVar, T t5) {
        try {
            return fVar.apply(t5);
        } catch (Throwable th) {
            throw g3.f.d(th);
        }
    }

    static q c(f<? super Callable<q>, ? extends q> fVar, Callable<q> callable) {
        return (q) t2.b.e(b(fVar, callable), "Scheduler Callable result can't be null");
    }

    static q d(Callable<q> callable) {
        try {
            return (q) t2.b.e(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw g3.f.d(th);
        }
    }

    public static q e(ThreadFactory threadFactory) {
        return new n((ThreadFactory) t2.b.e(threadFactory, "threadFactory is null"));
    }

    public static q f(Callable<q> callable) {
        t2.b.e(callable, "Scheduler Callable can't be null");
        f<? super Callable<q>, ? extends q> fVar = f5455c;
        return fVar == null ? d(callable) : c(fVar, callable);
    }

    public static q g(Callable<q> callable) {
        t2.b.e(callable, "Scheduler Callable can't be null");
        f<? super Callable<q>, ? extends q> fVar = f5457e;
        return fVar == null ? d(callable) : c(fVar, callable);
    }

    public static q h(Callable<q> callable) {
        t2.b.e(callable, "Scheduler Callable can't be null");
        f<? super Callable<q>, ? extends q> fVar = f5458f;
        return fVar == null ? d(callable) : c(fVar, callable);
    }

    public static q i(Callable<q> callable) {
        t2.b.e(callable, "Scheduler Callable can't be null");
        f<? super Callable<q>, ? extends q> fVar = f5456d;
        return fVar == null ? d(callable) : c(fVar, callable);
    }

    static boolean j(Throwable th) {
        return (th instanceof d) || (th instanceof c) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof q2.a);
    }

    public static <T> h3.a<T> k(h3.a<T> aVar) {
        f<? super h3.a, ? extends h3.a> fVar = f5463k;
        return fVar != null ? (h3.a) b(fVar, aVar) : aVar;
    }

    public static m2.a l(m2.a aVar) {
        f<? super m2.a, ? extends m2.a> fVar = f5466n;
        return fVar != null ? (m2.a) b(fVar, aVar) : aVar;
    }

    public static <T> m2.f<T> m(m2.f<T> fVar) {
        f<? super m2.f, ? extends m2.f> fVar2 = f5461i;
        return fVar2 != null ? (m2.f) b(fVar2, fVar) : fVar;
    }

    public static <T> h<T> n(h<T> hVar) {
        f<? super h, ? extends h> fVar = f5464l;
        return fVar != null ? (h) b(fVar, hVar) : hVar;
    }

    public static <T> k<T> o(k<T> kVar) {
        f<? super k, ? extends k> fVar = f5462j;
        return fVar != null ? (k) b(fVar, kVar) : kVar;
    }

    public static <T> r<T> p(r<T> rVar) {
        f<? super r, ? extends r> fVar = f5465m;
        return fVar != null ? (r) b(fVar, rVar) : rVar;
    }

    public static q q(q qVar) {
        f<? super q, ? extends q> fVar = f5459g;
        return fVar == null ? qVar : (q) b(fVar, qVar);
    }

    public static void r(Throwable th) {
        e<? super Throwable> eVar = f5453a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!j(th)) {
            th = new q2.f(th);
        }
        if (eVar != null) {
            try {
                eVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                A(th2);
            }
        }
        th.printStackTrace();
        A(th);
    }

    public static Runnable s(Runnable runnable) {
        t2.b.e(runnable, "run is null");
        f<? super Runnable, ? extends Runnable> fVar = f5454b;
        return fVar == null ? runnable : (Runnable) b(fVar, runnable);
    }

    public static q t(q qVar) {
        f<? super q, ? extends q> fVar = f5460h;
        return fVar == null ? qVar : (q) b(fVar, qVar);
    }

    public static m2.b u(m2.a aVar, m2.b bVar) {
        b<? super m2.a, ? super m2.b, ? extends m2.b> bVar2 = f5471s;
        return bVar2 != null ? (m2.b) a(bVar2, aVar, bVar) : bVar;
    }

    public static <T> i<? super T> v(h<T> hVar, i<? super T> iVar) {
        b<? super h, ? super i, ? extends i> bVar = f5468p;
        return bVar != null ? (i) a(bVar, hVar, iVar) : iVar;
    }

    public static <T> p<? super T> w(k<T> kVar, p<? super T> pVar) {
        b<? super k, ? super p, ? extends p> bVar = f5469q;
        return bVar != null ? (p) a(bVar, kVar, pVar) : pVar;
    }

    public static <T> t<? super T> x(r<T> rVar, t<? super T> tVar) {
        b<? super r, ? super t, ? extends t> bVar = f5470r;
        return bVar != null ? (t) a(bVar, rVar, tVar) : tVar;
    }

    public static <T> u4.b<? super T> y(m2.f<T> fVar, u4.b<? super T> bVar) {
        b<? super m2.f, ? super u4.b, ? extends u4.b> bVar2 = f5467o;
        return bVar2 != null ? (u4.b) a(bVar2, fVar, bVar) : bVar;
    }

    public static void z(e<? super Throwable> eVar) {
        if (!f5472t) {
            f5453a = eVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }
}
