package t2;

import java.util.Comparator;
import java.util.concurrent.Callable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final r2.f<Object, Object> f7032a = new i();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f7033b = new f();

    /* renamed from: c  reason: collision with root package name */
    public static final r2.a f7034c = new c();

    /* renamed from: d  reason: collision with root package name */
    static final r2.e<Object> f7035d = new d();

    /* renamed from: e  reason: collision with root package name */
    public static final r2.e<Throwable> f7036e = new g();

    /* renamed from: f  reason: collision with root package name */
    public static final r2.e<Throwable> f7037f = new n();

    /* renamed from: g  reason: collision with root package name */
    public static final r2.g f7038g = new e();

    /* renamed from: h  reason: collision with root package name */
    static final r2.h<Object> f7039h = new o();

    /* renamed from: i  reason: collision with root package name */
    static final r2.h<Object> f7040i = new h();

    /* renamed from: j  reason: collision with root package name */
    static final Callable<Object> f7041j = new m();

    /* renamed from: k  reason: collision with root package name */
    static final Comparator<Object> f7042k = new l();

    /* renamed from: l  reason: collision with root package name */
    public static final r2.e<u4.c> f7043l = new k();

    /* renamed from: t2.a$a  reason: collision with other inner class name */
    static final class C0112a<T> implements r2.e<T> {

        /* renamed from: e  reason: collision with root package name */
        final r2.a f7044e;

        C0112a(r2.a aVar) {
            this.f7044e = aVar;
        }

        public void accept(T t5) {
            this.f7044e.run();
        }
    }

    static final class b<T, U> implements r2.f<T, U> {

        /* renamed from: e  reason: collision with root package name */
        final Class<U> f7045e;

        b(Class<U> cls) {
            this.f7045e = cls;
        }

        public U apply(T t5) {
            return this.f7045e.cast(t5);
        }
    }

    static final class c implements r2.a {
        c() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class d implements r2.e<Object> {
        d() {
        }

        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class e implements r2.g {
        e() {
        }
    }

    static final class f implements Runnable {
        f() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class g implements r2.e<Throwable> {
        g() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            j3.a.r(th);
        }
    }

    static final class h implements r2.h<Object> {
        h() {
        }

        public boolean test(Object obj) {
            return false;
        }
    }

    static final class i implements r2.f<Object, Object> {
        i() {
        }

        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class j<T, U> implements Callable<U>, r2.f<T, U> {

        /* renamed from: e  reason: collision with root package name */
        final U f7046e;

        j(U u5) {
            this.f7046e = u5;
        }

        public U apply(T t5) {
            return this.f7046e;
        }

        public U call() {
            return this.f7046e;
        }
    }

    static final class k implements r2.e<u4.c> {
        k() {
        }

        /* renamed from: a */
        public void accept(u4.c cVar) {
            cVar.f(Long.MAX_VALUE);
        }
    }

    static final class l implements Comparator<Object> {
        l() {
        }

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class m implements Callable<Object> {
        m() {
        }

        public Object call() {
            return null;
        }
    }

    static final class n implements r2.e<Throwable> {
        n() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            j3.a.r(new q2.d(th));
        }
    }

    static final class o implements r2.h<Object> {
        o() {
        }

        public boolean test(Object obj) {
            return true;
        }
    }

    public static <T> r2.e<T> a(r2.a aVar) {
        return new C0112a(aVar);
    }

    public static <T> r2.h<T> b() {
        return f7039h;
    }

    public static <T, U> r2.f<T, U> c(Class<U> cls) {
        return new b(cls);
    }

    public static <T> r2.e<T> d() {
        return f7035d;
    }

    public static <T> r2.f<T, T> e() {
        return f7032a;
    }

    public static <T> Callable<T> f(T t5) {
        return new j(t5);
    }
}
