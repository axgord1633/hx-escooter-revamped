package k3;

import d3.n;
import d3.o;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import m2.q;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final q f5521a = j3.a.i(new h());

    /* renamed from: b  reason: collision with root package name */
    static final q f5522b = j3.a.f(new b());

    /* renamed from: c  reason: collision with root package name */
    static final q f5523c = j3.a.g(new c());

    /* renamed from: d  reason: collision with root package name */
    static final q f5524d = o.g();

    /* renamed from: e  reason: collision with root package name */
    static final q f5525e = j3.a.h(new f());

    /* renamed from: k3.a$a  reason: collision with other inner class name */
    static final class C0084a {

        /* renamed from: a  reason: collision with root package name */
        static final q f5526a = new d3.b();
    }

    static final class b implements Callable<q> {
        b() {
        }

        /* renamed from: a */
        public q call() {
            return C0084a.f5526a;
        }
    }

    static final class c implements Callable<q> {
        c() {
        }

        /* renamed from: a */
        public q call() {
            return d.f5527a;
        }
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        static final q f5527a = new d3.f();
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        static final q f5528a = new d3.g();
    }

    static final class f implements Callable<q> {
        f() {
        }

        /* renamed from: a */
        public q call() {
            return e.f5528a;
        }
    }

    static final class g {

        /* renamed from: a  reason: collision with root package name */
        static final q f5529a = new n();
    }

    static final class h implements Callable<q> {
        h() {
        }

        /* renamed from: a */
        public q call() {
            return g.f5529a;
        }
    }

    public static q a() {
        return j3.a.q(f5522b);
    }

    public static q b(Executor executor) {
        return new d3.d(executor, false);
    }

    public static q c() {
        return j3.a.t(f5521a);
    }

    public static q d() {
        return f5524d;
    }
}
