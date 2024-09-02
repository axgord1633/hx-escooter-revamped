package g0;

import h0.a;

public final class b<T> implements a<T>, f0.a<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f4660c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile a<T> f4661a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f4662b = f4660c;

    private b(a<T> aVar) {
        this.f4661a = aVar;
    }

    public static <P extends a<T>, T> f0.a<T> a(P p5) {
        return p5 instanceof f0.a ? (f0.a) p5 : new b((a) e.b(p5));
    }

    public static <P extends a<T>, T> a<T> b(P p5) {
        e.b(p5);
        return p5 instanceof b ? p5 : new b(p5);
    }

    private static Object c(Object obj, Object obj2) {
        if (!(obj != f4660c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t5 = this.f4662b;
        T t6 = f4660c;
        if (t5 == t6) {
            synchronized (this) {
                t5 = this.f4662b;
                if (t5 == t6) {
                    t5 = this.f4661a.get();
                    this.f4662b = c(this.f4662b, t5);
                    this.f4661a = null;
                }
            }
        }
        return t5;
    }
}
