package g0;

import f0.a;

public final class d<T> implements c<T>, a<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final d<Object> f4663b = new d<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    private final T f4664a;

    private d(T t5) {
        this.f4664a = t5;
    }

    public static <T> c<T> a(T t5) {
        return new d(e.c(t5, "instance cannot be null"));
    }

    public T get() {
        return this.f4664a;
    }
}
