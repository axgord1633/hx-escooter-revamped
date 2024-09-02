package f2;

import com.yalantis.ucrop.BuildConfig;
import d2.d0;
import java.util.List;

public abstract class b implements e {
    private Boolean h(String str) {
        Object a5 = a(str);
        if (a5 instanceof Boolean) {
            return (Boolean) a5;
        }
        return null;
    }

    private String j() {
        return (String) a("sql");
    }

    private List<Object> k() {
        return (List) a("arguments");
    }

    public d0 b() {
        return new d0(j(), k());
    }

    public boolean c() {
        return Boolean.TRUE.equals(a("noResult"));
    }

    public Boolean d() {
        return h("inTransaction");
    }

    public Integer e() {
        return (Integer) a("transactionId");
    }

    public boolean f() {
        return g("transactionId") && e() == null;
    }

    public boolean i() {
        return Boolean.TRUE.equals(a("continueOnError"));
    }

    public String toString() {
        return BuildConfig.FLAVOR + getMethod() + " " + j() + " " + k();
    }
}
