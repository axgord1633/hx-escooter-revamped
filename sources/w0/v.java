package w0;

import android.os.Bundle;
import u0.a;

public class v implements a.d {

    /* renamed from: c  reason: collision with root package name */
    public static final v f7441c = c().a();

    /* renamed from: b  reason: collision with root package name */
    private final String f7442b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f7443a;

        /* synthetic */ a(y yVar) {
        }

        public v a() {
            return new v(this.f7443a, (z) null);
        }
    }

    /* synthetic */ v(String str, z zVar) {
        this.f7442b = str;
    }

    public static a c() {
        return new a((y) null);
    }

    public final Bundle d() {
        Bundle bundle = new Bundle();
        String str = this.f7442b;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        return o.a(this.f7442b, ((v) obj).f7442b);
    }

    public final int hashCode() {
        return o.b(this.f7442b);
    }
}
