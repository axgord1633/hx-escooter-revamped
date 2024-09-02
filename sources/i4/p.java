package i4;

import j4.c;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final c0 f5132a;

    /* renamed from: b  reason: collision with root package name */
    private final g f5133b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Certificate> f5134c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Certificate> f5135d;

    private p(c0 c0Var, g gVar, List<Certificate> list, List<Certificate> list2) {
        this.f5132a = c0Var;
        this.f5133b = gVar;
        this.f5134c = list;
        this.f5135d = list2;
    }

    public static p b(SSLSession sSLSession) {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            g a5 = g.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                c0 c5 = c0.c(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                List s5 = certificateArr != null ? c.s(certificateArr) : Collections.emptyList();
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                return new p(c5, a5, s5, localCertificates != null ? c.s(localCertificates) : Collections.emptyList());
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public g a() {
        return this.f5133b;
    }

    public List<Certificate> c() {
        return this.f5134c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f5132a.equals(pVar.f5132a) && this.f5133b.equals(pVar.f5133b) && this.f5134c.equals(pVar.f5134c) && this.f5135d.equals(pVar.f5135d);
    }

    public int hashCode() {
        return ((((((527 + this.f5132a.hashCode()) * 31) + this.f5133b.hashCode()) * 31) + this.f5134c.hashCode()) * 31) + this.f5135d.hashCode();
    }
}
