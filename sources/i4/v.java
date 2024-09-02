package i4;

import java.io.IOException;

public enum v {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    

    /* renamed from: e  reason: collision with root package name */
    private final String f5211e;

    private v(String str) {
        this.f5211e = str;
    }

    public static v c(String str) {
        v vVar = HTTP_1_0;
        if (str.equals(vVar.f5211e)) {
            return vVar;
        }
        v vVar2 = HTTP_1_1;
        if (str.equals(vVar2.f5211e)) {
            return vVar2;
        }
        v vVar3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(vVar3.f5211e)) {
            return vVar3;
        }
        v vVar4 = HTTP_2;
        if (str.equals(vVar4.f5211e)) {
            return vVar4;
        }
        v vVar5 = SPDY_3;
        if (str.equals(vVar5.f5211e)) {
            return vVar5;
        }
        v vVar6 = QUIC;
        if (str.equals(vVar6.f5211e)) {
            return vVar6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.f5211e;
    }
}
