package t0;

import android.os.RemoteException;
import android.util.Log;
import d1.a;
import d1.b;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import w0.n1;
import w0.o1;
import w0.p;

abstract class r extends n1 {

    /* renamed from: b  reason: collision with root package name */
    private final int f6835b;

    protected r(byte[] bArr) {
        p.a(bArr.length == 25);
        this.f6835b = Arrays.hashCode(bArr);
    }

    protected static byte[] c(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }

    public final a b() {
        return b.e(e());
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] e();

    public final boolean equals(Object obj) {
        a b5;
        if (obj != null && (obj instanceof o1)) {
            try {
                o1 o1Var = (o1) obj;
                if (o1Var.v() != this.f6835b || (b5 = o1Var.b()) == null) {
                    return false;
                }
                return Arrays.equals(e(), (byte[]) b.c(b5));
            } catch (RemoteException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f6835b;
    }

    public final int v() {
        return this.f6835b;
    }
}
