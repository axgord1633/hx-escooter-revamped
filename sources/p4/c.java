package p4;

import android.net.ssl.SSLSockets;
import i4.v;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

class c extends d {
    c(Class<?> cls) {
        super(cls, (h<Socket>) null, (h<Socket>) null, (h<Socket>) null, (h<Socket>) null);
    }

    @Nullable
    public static i w() {
        if (!i.p()) {
            return null;
        }
        try {
            if (d.x() >= 29) {
                return new c(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (ClassNotFoundException unused) {
        }
        return null;
    }

    private void z(SSLSocket sSLSocket) {
        if (SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    public void g(SSLSocket sSLSocket, String str, List<v> list) {
        try {
            z(sSLSocket);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) i.b(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e5) {
            throw new IOException("Android internal error", e5);
        }
    }

    @Nullable
    public String n(SSLSocket sSLSocket) {
        String a5 = sSLSocket.getApplicationProtocol();
        if (a5 == null || a5.isEmpty()) {
            return null;
        }
        return a5;
    }
}
