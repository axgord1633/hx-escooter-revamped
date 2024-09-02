package kotlinx.coroutines.internal;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f5613a = new b0("CONDITION_FALSE");

    /* renamed from: b  reason: collision with root package name */
    private static final Object f5614b = new b0("LIST_EMPTY");

    public static final Object a() {
        return f5613a;
    }

    public static final o b(Object obj) {
        o oVar;
        x xVar = obj instanceof x ? (x) obj : null;
        return (xVar == null || (oVar = xVar.f5639a) == null) ? (o) obj : oVar;
    }
}
