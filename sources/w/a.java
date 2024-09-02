package w;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<b<?>, Object> f7282a = new LinkedHashMap();

    /* renamed from: w.a$a  reason: collision with other inner class name */
    public static final class C0118a extends a {

        /* renamed from: b  reason: collision with root package name */
        public static final C0118a f7283b = new C0118a();

        private C0118a() {
        }

        public <T> T a(b<T> bVar) {
            k.e(bVar, "key");
            return null;
        }
    }

    public interface b<T> {
    }

    public abstract <T> T a(b<T> bVar);

    public final Map<b<?>, Object> b() {
        return this.f7282a;
    }
}
