package p4;

import i4.v;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;

public class e extends i {
    private e() {
    }

    public static e u() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (!Conscrypt.isAvailable()) {
                return null;
            }
            return new e();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private Provider v() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    public void f(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    public void g(SSLSocket sSLSocket, String str, List<v> list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) i.b(list).toArray(new String[0]));
            return;
        }
        super.g(sSLSocket, str, list);
    }

    public SSLContext m() {
        try {
            return SSLContext.getInstance("TLSv1.3", v());
        } catch (NoSuchAlgorithmException e5) {
            try {
                return SSLContext.getInstance("TLS", v());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e5);
            }
        }
    }

    @Nullable
    public String n(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.n(sSLSocket);
    }
}
