package l4;

import i4.j;
import j4.a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<j> f5771a;

    /* renamed from: b  reason: collision with root package name */
    private int f5772b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5773c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5774d;

    public b(List<j> list) {
        this.f5771a = list;
    }

    private boolean c(SSLSocket sSLSocket) {
        for (int i5 = this.f5772b; i5 < this.f5771a.size(); i5++) {
            if (this.f5771a.get(i5).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public j a(SSLSocket sSLSocket) {
        j jVar;
        int i5 = this.f5772b;
        int size = this.f5771a.size();
        while (true) {
            if (i5 >= size) {
                jVar = null;
                break;
            }
            jVar = this.f5771a.get(i5);
            i5++;
            if (jVar.c(sSLSocket)) {
                this.f5772b = i5;
                break;
            }
        }
        if (jVar != null) {
            this.f5773c = c(sSLSocket);
            a.f5473a.c(jVar, sSLSocket, this.f5774d);
            return jVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f5774d + ", modes=" + this.f5771a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f5774d = true;
        if (!this.f5773c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z4 = iOException instanceof SSLHandshakeException;
        if ((!z4 || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return z4 || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
        }
        return false;
    }
}
