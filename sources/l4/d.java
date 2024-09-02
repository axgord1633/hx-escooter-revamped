package l4;

import i4.b0;
import java.util.LinkedHashSet;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Set<b0> f5789a = new LinkedHashSet();

    public synchronized void a(b0 b0Var) {
        this.f5789a.remove(b0Var);
    }

    public synchronized void b(b0 b0Var) {
        this.f5789a.add(b0Var);
    }

    public synchronized boolean c(b0 b0Var) {
        return this.f5789a.contains(b0Var);
    }
}
