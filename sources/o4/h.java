package o4;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import o4.d;
import s4.c;
import s4.e;
import s4.f;
import s4.s;
import s4.t;

final class h implements Closeable {

    /* renamed from: i  reason: collision with root package name */
    static final Logger f6284i = Logger.getLogger(e.class.getName());

    /* renamed from: e  reason: collision with root package name */
    private final e f6285e;

    /* renamed from: f  reason: collision with root package name */
    private final a f6286f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f6287g;

    /* renamed from: h  reason: collision with root package name */
    final d.a f6288h;

    static final class a implements s {

        /* renamed from: e  reason: collision with root package name */
        private final e f6289e;

        /* renamed from: f  reason: collision with root package name */
        int f6290f;

        /* renamed from: g  reason: collision with root package name */
        byte f6291g;

        /* renamed from: h  reason: collision with root package name */
        int f6292h;

        /* renamed from: i  reason: collision with root package name */
        int f6293i;

        /* renamed from: j  reason: collision with root package name */
        short f6294j;

        a(e eVar) {
            this.f6289e = eVar;
        }

        private void b() {
            int i5 = this.f6292h;
            int l5 = h.l(this.f6289e);
            this.f6293i = l5;
            this.f6290f = l5;
            byte readByte = (byte) (this.f6289e.readByte() & 255);
            this.f6291g = (byte) (this.f6289e.readByte() & 255);
            Logger logger = h.f6284i;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.b(true, this.f6292h, this.f6290f, readByte, this.f6291g));
            }
            int readInt = this.f6289e.readInt() & Integer.MAX_VALUE;
            this.f6292h = readInt;
            if (readByte != 9) {
                throw e.d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (readInt != i5) {
                throw e.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public long K(c cVar, long j5) {
            while (true) {
                int i5 = this.f6293i;
                if (i5 == 0) {
                    this.f6289e.skip((long) this.f6294j);
                    this.f6294j = 0;
                    if ((this.f6291g & 4) != 0) {
                        return -1;
                    }
                    b();
                } else {
                    long K = this.f6289e.K(cVar, Math.min(j5, (long) i5));
                    if (K == -1) {
                        return -1;
                    }
                    this.f6293i = (int) (((long) this.f6293i) - K);
                    return K;
                }
            }
        }

        public t c() {
            return this.f6289e.c();
        }

        public void close() {
        }
    }

    interface b {
        void a();

        void b(boolean z4, m mVar);

        void c(boolean z4, int i5, int i6);

        void d(int i5, int i6, int i7, boolean z4);

        void e(boolean z4, int i5, e eVar, int i6);

        void f(int i5, b bVar);

        void g(boolean z4, int i5, int i6, List<c> list);

        void h(int i5, long j5);

        void i(int i5, int i6, List<c> list);

        void j(int i5, b bVar, f fVar);
    }

    h(e eVar, boolean z4) {
        this.f6285e = eVar;
        this.f6287g = z4;
        a aVar = new a(eVar);
        this.f6286f = aVar;
        this.f6288h = new d.a(4096, aVar);
    }

    static int b(int i5, byte b5, short s5) {
        if ((b5 & 8) != 0) {
            i5--;
        }
        if (s5 <= i5) {
            return (short) (i5 - s5);
        }
        throw e.d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s5), Integer.valueOf(i5));
    }

    private void f(b bVar, int i5, byte b5, int i6) {
        short s5 = 0;
        if (i6 != 0) {
            boolean z4 = true;
            boolean z5 = (b5 & 1) != 0;
            if ((b5 & 32) == 0) {
                z4 = false;
            }
            if (!z4) {
                if ((b5 & 8) != 0) {
                    s5 = (short) (this.f6285e.readByte() & 255);
                }
                bVar.e(z5, i6, this.f6285e, b(i5, b5, s5));
                this.f6285e.skip((long) s5);
                return;
            }
            throw e.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw e.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void g(b bVar, int i5, byte b5, int i6) {
        if (i5 < 8) {
            throw e.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i5));
        } else if (i6 == 0) {
            int readInt = this.f6285e.readInt();
            int readInt2 = this.f6285e.readInt();
            int i7 = i5 - 8;
            b c5 = b.c(readInt2);
            if (c5 != null) {
                f fVar = f.f6761i;
                if (i7 > 0) {
                    fVar = this.f6285e.k((long) i7);
                }
                bVar.j(readInt, c5, fVar);
                return;
            }
            throw e.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        } else {
            throw e.d("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private List<c> h(int i5, short s5, byte b5, int i6) {
        a aVar = this.f6286f;
        aVar.f6293i = i5;
        aVar.f6290f = i5;
        aVar.f6294j = s5;
        aVar.f6291g = b5;
        aVar.f6292h = i6;
        this.f6288h.k();
        return this.f6288h.e();
    }

    private void j(b bVar, int i5, byte b5, int i6) {
        short s5 = 0;
        if (i6 != 0) {
            boolean z4 = (b5 & 1) != 0;
            if ((b5 & 8) != 0) {
                s5 = (short) (this.f6285e.readByte() & 255);
            }
            if ((b5 & 32) != 0) {
                n(bVar, i6);
                i5 -= 5;
            }
            bVar.g(z4, i6, -1, h(b(i5, b5, s5), s5, b5, i6));
            return;
        }
        throw e.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    static int l(e eVar) {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    private void m(b bVar, int i5, byte b5, int i6) {
        boolean z4 = false;
        if (i5 != 8) {
            throw e.d("TYPE_PING length != 8: %s", Integer.valueOf(i5));
        } else if (i6 == 0) {
            int readInt = this.f6285e.readInt();
            int readInt2 = this.f6285e.readInt();
            if ((b5 & 1) != 0) {
                z4 = true;
            }
            bVar.c(z4, readInt, readInt2);
        } else {
            throw e.d("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void n(b bVar, int i5) {
        int readInt = this.f6285e.readInt();
        bVar.d(i5, readInt & Integer.MAX_VALUE, (this.f6285e.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void p(b bVar, int i5, byte b5, int i6) {
        if (i5 != 5) {
            throw e.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i5));
        } else if (i6 != 0) {
            n(bVar, i6);
        } else {
            throw e.d("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void q(b bVar, int i5, byte b5, int i6) {
        short s5 = 0;
        if (i6 != 0) {
            if ((b5 & 8) != 0) {
                s5 = (short) (this.f6285e.readByte() & 255);
            }
            bVar.i(i6, this.f6285e.readInt() & Integer.MAX_VALUE, h(b(i5 - 4, b5, s5), s5, b5, i6));
            return;
        }
        throw e.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void v(b bVar, int i5, byte b5, int i6) {
        if (i5 != 4) {
            throw e.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i5));
        } else if (i6 != 0) {
            int readInt = this.f6285e.readInt();
            b c5 = b.c(readInt);
            if (c5 != null) {
                bVar.f(i6, c5);
            } else {
                throw e.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            }
        } else {
            throw e.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void w(b bVar, int i5, byte b5, int i6) {
        if (i6 != 0) {
            throw e.d("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b5 & 1) != 0) {
            if (i5 == 0) {
                bVar.a();
                return;
            }
            throw e.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i5 % 6 == 0) {
            m mVar = new m();
            for (int i7 = 0; i7 < i5; i7 += 6) {
                short readShort = this.f6285e.readShort() & 65535;
                int readInt = this.f6285e.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            throw e.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        throw e.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    throw e.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                mVar.i(readShort, readInt);
            }
            bVar.b(false, mVar);
        } else {
            throw e.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i5));
        }
    }

    private void z(b bVar, int i5, byte b5, int i6) {
        if (i5 == 4) {
            long readInt = ((long) this.f6285e.readInt()) & 2147483647L;
            if (readInt != 0) {
                bVar.h(i6, readInt);
            } else {
                throw e.d("windowSizeIncrement was 0", Long.valueOf(readInt));
            }
        } else {
            throw e.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i5));
        }
    }

    public void close() {
        this.f6285e.close();
    }

    public boolean d(boolean z4, b bVar) {
        try {
            this.f6285e.H(9);
            int l5 = l(this.f6285e);
            if (l5 < 0 || l5 > 16384) {
                throw e.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(l5));
            }
            byte readByte = (byte) (this.f6285e.readByte() & 255);
            if (!z4 || readByte == 4) {
                byte readByte2 = (byte) (this.f6285e.readByte() & 255);
                int readInt = this.f6285e.readInt() & Integer.MAX_VALUE;
                Logger logger = f6284i;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(e.b(true, readInt, l5, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        f(bVar, l5, readByte2, readInt);
                        break;
                    case 1:
                        j(bVar, l5, readByte2, readInt);
                        break;
                    case 2:
                        p(bVar, l5, readByte2, readInt);
                        break;
                    case 3:
                        v(bVar, l5, readByte2, readInt);
                        break;
                    case 4:
                        w(bVar, l5, readByte2, readInt);
                        break;
                    case 5:
                        q(bVar, l5, readByte2, readInt);
                        break;
                    case 6:
                        m(bVar, l5, readByte2, readInt);
                        break;
                    case 7:
                        g(bVar, l5, readByte2, readInt);
                        break;
                    case 8:
                        z(bVar, l5, readByte2, readInt);
                        break;
                    default:
                        this.f6285e.skip((long) l5);
                        break;
                }
                return true;
            }
            throw e.d("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException unused) {
            return false;
        }
    }

    public void e(b bVar) {
        if (!this.f6287g) {
            e eVar = this.f6285e;
            f fVar = e.f6204a;
            f k5 = eVar.k((long) fVar.w());
            Logger logger = f6284i;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(j4.c.p("<< CONNECTION %s", k5.q()));
            }
            if (!fVar.equals(k5)) {
                throw e.d("Expected a connection header but was %s", k5.B());
            }
        } else if (!d(true, bVar)) {
            throw e.d("Required SETTINGS preface not received", new Object[0]);
        }
    }
}
