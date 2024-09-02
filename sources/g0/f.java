package g0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<T> f4665a;

    private f(int i5) {
        this.f4665a = new ArrayList(i5);
    }

    public static <T> f<T> c(int i5) {
        return new f<>(i5);
    }

    public f<T> a(T t5) {
        this.f4665a.add(e.c(t5, "Set contributions cannot be null"));
        return this;
    }

    public Set<T> b() {
        return this.f4665a.isEmpty() ? Collections.emptySet() : this.f4665a.size() == 1 ? Collections.singleton(this.f4665a.get(0)) : Collections.unmodifiableSet(new HashSet(this.f4665a));
    }
}
