package w0;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import m.b;

public final class e {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Account f7332a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f7333b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f7334c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f7335d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7336e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final View f7337f;

    /* renamed from: g  reason: collision with root package name */
    private final String f7338g;

    /* renamed from: h  reason: collision with root package name */
    private final String f7339h;

    /* renamed from: i  reason: collision with root package name */
    private final j1.a f7340i;

    /* renamed from: j  reason: collision with root package name */
    private Integer f7341j;

    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Account f7342a;

        /* renamed from: b  reason: collision with root package name */
        private b f7343b;

        /* renamed from: c  reason: collision with root package name */
        private String f7344c;

        /* renamed from: d  reason: collision with root package name */
        private String f7345d;

        /* renamed from: e  reason: collision with root package name */
        private j1.a f7346e = j1.a.f5432k;

        public e a() {
            return new e(this.f7342a, this.f7343b, (Map) null, 0, (View) null, this.f7344c, this.f7345d, this.f7346e, false);
        }

        public a b(String str) {
            this.f7344c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.f7343b == null) {
                this.f7343b = new b();
            }
            this.f7343b.addAll(collection);
            return this;
        }

        public final a d(@Nullable Account account) {
            this.f7342a = account;
            return this;
        }

        public final a e(String str) {
            this.f7345d = str;
            return this;
        }
    }

    public e(@Nullable Account account, Set set, Map map, int i5, @Nullable View view, String str, String str2, @Nullable j1.a aVar, boolean z4) {
        this.f7332a = account;
        Set emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f7333b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f7335d = map;
        this.f7337f = view;
        this.f7336e = i5;
        this.f7338g = str;
        this.f7339h = str2;
        this.f7340i = aVar == null ? j1.a.f5432k : aVar;
        HashSet hashSet = new HashSet(emptySet);
        for (a0 a0Var : map.values()) {
            hashSet.addAll(a0Var.f7289a);
        }
        this.f7334c = Collections.unmodifiableSet(hashSet);
    }

    public Account a() {
        return this.f7332a;
    }

    public Account b() {
        Account account = this.f7332a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public Set<Scope> c() {
        return this.f7334c;
    }

    public String d() {
        return this.f7338g;
    }

    public Set<Scope> e() {
        return this.f7333b;
    }

    public final j1.a f() {
        return this.f7340i;
    }

    public final Integer g() {
        return this.f7341j;
    }

    public final String h() {
        return this.f7339h;
    }

    public final void i(Integer num) {
        this.f7341j = num;
    }
}
