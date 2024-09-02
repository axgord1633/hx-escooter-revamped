package w3;

import java.util.Random;
import kotlin.jvm.internal.k;

public final class b extends a {

    /* renamed from: g  reason: collision with root package name */
    private final a f7583g = new a();

    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    public Random c() {
        Object obj = this.f7583g.get();
        k.d(obj, "implStorage.get()");
        return (Random) obj;
    }
}
