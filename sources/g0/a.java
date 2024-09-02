package g0;

public final class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    private h0.a<T> f4659a;

    public static <T> void a(h0.a<T> aVar, h0.a<T> aVar2) {
        e.b(aVar2);
        a aVar3 = (a) aVar;
        if (aVar3.f4659a == null) {
            aVar3.f4659a = aVar2;
            return;
        }
        throw new IllegalStateException();
    }

    public T get() {
        h0.a<T> aVar = this.f4659a;
        if (aVar != null) {
            return aVar.get();
        }
        throw new IllegalStateException();
    }
}
