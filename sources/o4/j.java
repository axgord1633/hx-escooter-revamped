package o4;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import o4.d;
import s4.c;
import s4.d;

final class j implements Closeable {

    /* renamed from: k  reason: collision with root package name */
    private static final Logger f6318k = Logger.getLogger(e.class.getName());

    /* renamed from: e  reason: collision with root package name */
    private final d f6319e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6320f;

    /* renamed from: g  reason: collision with root package name */
    private final c f6321g;

    /* renamed from: h  reason: collision with root package name */
    private int f6322h = 16384;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6323i;

    /* renamed from: j  reason: collision with root package name */
    final d.b f6324j;

    j(s4.d dVar, boolean z4) {
        this.f6319e = dVar;
        this.f6320f = z4;
        c cVar = new c();
        this.f6321g = cVar;
        this.f6324j = new d.b(cVar);
    }

    private static void B(s4.d dVar, int i5) {
        dVar.writeByte((i5 >>> 16) & 255);
        dVar.writeByte((i5 >>> 8) & 255);
        dVar.writeByte(i5 & 255);
    }

    private void z(int i5, long j5) {
        while (j5 > 0) {
            int min = (int) Math.min((long) this.f6322h, j5);
            long j6 = (long) min;
            j5 -= j6;
            g(i5, min, (byte) 9, j5 == 0 ? (byte) 4 : 0);
            this.f6319e.G(this.f6321g, j6);
        }
    }

    public synchronized void b(m mVar) {
        if (!this.f6323i) {
            this.f6322h = mVar.f(this.f6322h);
            if (mVar.c() != -1) {
                this.f6324j.e(mVar.c());
            }
            g(0, 0, (byte) 4, (byte) 1);
            this.f6319e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void close() {
        this.f6323i = true;
        this.f6319e.close();
    }

    public synchronized void d() {
        if (this.f6323i) {
            throw new IOException("closed");
        } else if (this.f6320f) {
            Logger logger = f6318k;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(j4.c.p(">> CONNECTION %s", e.f6204a.q()));
            }
            this.f6319e.write(e.f6204a.A());
            this.f6319e.flush();
        }
    }

    public synchronized void e(boolean z4, int i5, c cVar, int i6) {
        if (!this.f6323i) {
            byte b5 = 0;
            if (z4) {
                b5 = (byte) 1;
            }
            f(i5, b5, cVar, i6);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int i5, byte b5, c cVar, int i6) {
        g(i5, i6, (byte) 0, b5);
        if (i6 > 0) {
            this.f6319e.G(cVar, (long) i6);
        }
    }

    public synchronized void flush() {
        if (!this.f6323i) {
            this.f6319e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public void g(int i5, int i6, byte b5, byte b6) {
        Logger logger = f6318k;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.b(false, i5, i6, b5, b6));
        }
        int i7 = this.f6322h;
        if (i6 > i7) {
            throw e.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i7), Integer.valueOf(i6));
        } else if ((Integer.MIN_VALUE & i5) == 0) {
            B(this.f6319e, i6);
            this.f6319e.writeByte(b5 & 255);
            this.f6319e.writeByte(b6 & 255);
            this.f6319e.writeInt(i5 & Integer.MAX_VALUE);
        } else {
            throw e.c("reserved bit set: %s", Integer.valueOf(i5));
        }
    }

    public synchronized void h(int i5, b bVar, byte[] bArr) {
        if (this.f6323i) {
            throw new IOException("closed");
        } else if (bVar.f6174e != -1) {
            g(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f6319e.writeInt(i5);
            this.f6319e.writeInt(bVar.f6174e);
            if (bArr.length > 0) {
                this.f6319e.write(bArr);
            }
            this.f6319e.flush();
        } else {
            throw e.c("errorCode.httpCode == -1", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public void j(boolean z4, int i5, List<c> list) {
        if (!this.f6323i) {
            this.f6324j.g(list);
            long size = this.f6321g.size();
            int min = (int) Math.min((long) this.f6322h, size);
            long j5 = (long) min;
            int i6 = (size > j5 ? 1 : (size == j5 ? 0 : -1));
            byte b5 = i6 == 0 ? (byte) 4 : 0;
            if (z4) {
                b5 = (byte) (b5 | 1);
            }
            g(i5, min, (byte) 1, b5);
            this.f6319e.G(this.f6321g, j5);
            if (i6 > 0) {
                z(i5, size - j5);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public int l() {
        return this.f6322h;
    }

    public synchronized void m(boolean z4, int i5, int i6) {
        if (!this.f6323i) {
            g(0, 8, (byte) 6, z4 ? (byte) 1 : 0);
            this.f6319e.writeInt(i5);
            this.f6319e.writeInt(i6);
            this.f6319e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void n(int i5, int i6, List<c> list) {
        if (!this.f6323i) {
            this.f6324j.g(list);
            long size = this.f6321g.size();
            int min = (int) Math.min((long) (this.f6322h - 4), size);
            long j5 = (long) min;
            int i7 = (size > j5 ? 1 : (size == j5 ? 0 : -1));
            g(i5, min + 4, (byte) 5, i7 == 0 ? (byte) 4 : 0);
            this.f6319e.writeInt(i6 & Integer.MAX_VALUE);
            this.f6319e.G(this.f6321g, j5);
            if (i7 > 0) {
                z(i5, size - j5);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void p(int i5, b bVar) {
        if (this.f6323i) {
            throw new IOException("closed");
        } else if (bVar.f6174e != -1) {
            g(i5, 4, (byte) 3, (byte) 0);
            this.f6319e.writeInt(bVar.f6174e);
            this.f6319e.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void q(m mVar) {
        if (!this.f6323i) {
            int i5 = 0;
            g(0, mVar.j() * 6, (byte) 4, (byte) 0);
            while (i5 < 10) {
                if (mVar.g(i5)) {
                    this.f6319e.writeShort(i5 == 4 ? 3 : i5 == 7 ? 4 : i5);
                    this.f6319e.writeInt(mVar.b(i5));
                }
                i5++;
            }
            this.f6319e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void v(boolean z4, int i5, int i6, List<c> list) {
        if (!this.f6323i) {
            j(z4, i5, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void w(int i5, long j5) {
        if (this.f6323i) {
            throw new IOException("closed");
        } else if (j5 == 0 || j5 > 2147483647L) {
            throw e.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j5));
        } else {
            g(i5, 4, (byte) 8, (byte) 0);
            this.f6319e.writeInt((int) j5);
            this.f6319e.flush();
        }
    }
}
