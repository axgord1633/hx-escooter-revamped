package r4;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import p4.i;

public abstract class c {
    public static c b(X509TrustManager x509TrustManager) {
        return i.l().c(x509TrustManager);
    }

    public abstract List<Certificate> a(List<Certificate> list, String str);
}
