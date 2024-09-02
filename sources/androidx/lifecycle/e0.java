package androidx.lifecycle;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.k;

public class e0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a0> f2573a = new LinkedHashMap();

    public final void a() {
        for (a0 a5 : this.f2573a.values()) {
            a5.a();
        }
        this.f2573a.clear();
    }

    public final a0 b(String str) {
        k.e(str, "key");
        return this.f2573a.get(str);
    }

    public final Set<String> c() {
        return new HashSet(this.f2573a.keySet());
    }

    public final void d(String str, a0 a0Var) {
        k.e(str, "key");
        k.e(a0Var, "viewModel");
        a0 put = this.f2573a.put(str, a0Var);
        if (put != null) {
            put.d();
        }
    }
}
