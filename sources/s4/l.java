package s4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f6777a = Logger.getLogger(l.class.getName());

    class a implements r {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ t f6778e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ OutputStream f6779f;

        a(t tVar, OutputStream outputStream) {
            this.f6778e = tVar;
            this.f6779f = outputStream;
        }

        public void G(c cVar, long j5) {
            u.b(cVar.f6759f, 0, j5);
            while (j5 > 0) {
                this.f6778e.f();
                o oVar = cVar.f6758e;
                int min = (int) Math.min(j5, (long) (oVar.f6791c - oVar.f6790b));
                this.f6779f.write(oVar.f6789a, oVar.f6790b, min);
                int i5 = oVar.f6790b + min;
                oVar.f6790b = i5;
                long j6 = (long) min;
                j5 -= j6;
                cVar.f6759f -= j6;
                if (i5 == oVar.f6791c) {
                    cVar.f6758e = oVar.b();
                    p.a(oVar);
                }
            }
        }

        public t c() {
            return this.f6778e;
        }

        public void close() {
            this.f6779f.close();
        }

        public void flush() {
            this.f6779f.flush();
        }

        public String toString() {
            return "sink(" + this.f6779f + ")";
        }
    }

    class b implements s {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ t f6780e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ InputStream f6781f;

        b(t tVar, InputStream inputStream) {
            this.f6780e = tVar;
            this.f6781f = inputStream;
        }

        public long K(c cVar, long j5) {
            int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
            if (i5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (i5 == 0) {
                return 0;
            } else {
                try {
                    this.f6780e.f();
                    o C = cVar.C(1);
                    int read = this.f6781f.read(C.f6789a, C.f6791c, (int) Math.min(j5, (long) (8192 - C.f6791c)));
                    if (read == -1) {
                        return -1;
                    }
                    C.f6791c += read;
                    long j6 = (long) read;
                    cVar.f6759f += j6;
                    return j6;
                } catch (AssertionError e5) {
                    if (l.c(e5)) {
                        throw new IOException(e5);
                    }
                    throw e5;
                }
            }
        }

        public t c() {
            return this.f6780e;
        }

        public void close() {
            this.f6781f.close();
        }

        public String toString() {
            return "source(" + this.f6781f + ")";
        }
    }

    class c extends a {

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Socket f6782k;

        c(Socket socket) {
            this.f6782k = socket;
        }

        /* access modifiers changed from: protected */
        public IOException o(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Exception} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.AssertionError} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Exception} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Exception} */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void t() {
            /*
                r5 = this;
                java.lang.String r0 = "Failed to close timed out socket "
                java.net.Socket r1 = r5.f6782k     // Catch:{ Exception -> 0x001a, AssertionError -> 0x0008 }
                r1.close()     // Catch:{ Exception -> 0x001a, AssertionError -> 0x0008 }
                goto L_0x0033
            L_0x0008:
                r1 = move-exception
                boolean r2 = s4.l.c(r1)
                if (r2 == 0) goto L_0x0019
                java.util.logging.Logger r2 = s4.l.f6777a
                java.util.logging.Level r3 = java.util.logging.Level.WARNING
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                goto L_0x0024
            L_0x0019:
                throw r1
            L_0x001a:
                r1 = move-exception
                java.util.logging.Logger r2 = s4.l.f6777a
                java.util.logging.Level r3 = java.util.logging.Level.WARNING
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
            L_0x0024:
                r4.append(r0)
                java.net.Socket r0 = r5.f6782k
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r2.log(r3, r0, r1)
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s4.l.c.t():void");
        }
    }

    private l() {
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    public static e b(s sVar) {
        return new n(sVar);
    }

    static boolean c(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static r d(OutputStream outputStream) {
        return e(outputStream, new t());
    }

    private static r e(OutputStream outputStream, t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (tVar != null) {
            return new a(tVar, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static r f(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            a j5 = j(socket);
            return j5.r(e(socket.getOutputStream(), j5));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static s g(InputStream inputStream) {
        return h(inputStream, new t());
    }

    private static s h(InputStream inputStream, t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (tVar != null) {
            return new b(tVar, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static s i(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            a j5 = j(socket);
            return j5.s(h(socket.getInputStream(), j5));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    private static a j(Socket socket) {
        return new c(socket);
    }
}
