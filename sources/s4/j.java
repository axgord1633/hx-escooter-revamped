package s4;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class j implements s {

    /* renamed from: e  reason: collision with root package name */
    private int f6768e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final e f6769f;

    /* renamed from: g  reason: collision with root package name */
    private final Inflater f6770g;

    /* renamed from: h  reason: collision with root package name */
    private final k f6771h;

    /* renamed from: i  reason: collision with root package name */
    private final CRC32 f6772i = new CRC32();

    public j(s sVar) {
        if (sVar != null) {
            Inflater inflater = new Inflater(true);
            this.f6770g = inflater;
            e b5 = l.b(sVar);
            this.f6769f = b5;
            this.f6771h = new k(b5, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void b(String str, int i5, int i6) {
        if (i6 != i5) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i6), Integer.valueOf(i5)}));
        }
    }

    private void d() {
        this.f6769f.H(10);
        byte j5 = this.f6769f.a().j(3);
        boolean z4 = ((j5 >> 1) & 1) == 1;
        if (z4) {
            f(this.f6769f.a(), 0, 10);
        }
        b("ID1ID2", 8075, this.f6769f.readShort());
        this.f6769f.skip(8);
        if (((j5 >> 2) & 1) == 1) {
            this.f6769f.H(2);
            if (z4) {
                f(this.f6769f.a(), 0, 2);
            }
            long x4 = (long) this.f6769f.a().x();
            this.f6769f.H(x4);
            if (z4) {
                f(this.f6769f.a(), 0, x4);
            }
            this.f6769f.skip(x4);
        }
        if (((j5 >> 3) & 1) == 1) {
            long J = this.f6769f.J((byte) 0);
            if (J != -1) {
                if (z4) {
                    f(this.f6769f.a(), 0, J + 1);
                }
                this.f6769f.skip(J + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((j5 >> 4) & 1) == 1) {
            long J2 = this.f6769f.J((byte) 0);
            if (J2 != -1) {
                if (z4) {
                    f(this.f6769f.a(), 0, J2 + 1);
                }
                this.f6769f.skip(J2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z4) {
            b("FHCRC", this.f6769f.x(), (short) ((int) this.f6772i.getValue()));
            this.f6772i.reset();
        }
    }

    private void e() {
        b("CRC", this.f6769f.s(), (int) this.f6772i.getValue());
        b("ISIZE", this.f6769f.s(), (int) this.f6770g.getBytesWritten());
    }

    private void f(c cVar, long j5, long j6) {
        o oVar = cVar.f6758e;
        while (true) {
            int i5 = oVar.f6791c;
            int i6 = oVar.f6790b;
            if (j5 < ((long) (i5 - i6))) {
                break;
            }
            j5 -= (long) (i5 - i6);
            oVar = oVar.f6794f;
        }
        while (j6 > 0) {
            int i7 = (int) (((long) oVar.f6790b) + j5);
            int min = (int) Math.min((long) (oVar.f6791c - i7), j6);
            this.f6772i.update(oVar.f6789a, i7, min);
            j6 -= (long) min;
            oVar = oVar.f6794f;
            j5 = 0;
        }
    }

    public long K(c cVar, long j5) {
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j5);
        } else if (i5 == 0) {
            return 0;
        } else {
            if (this.f6768e == 0) {
                d();
                this.f6768e = 1;
            }
            if (this.f6768e == 1) {
                long j6 = cVar.f6759f;
                long K = this.f6771h.K(cVar, j5);
                if (K != -1) {
                    f(cVar, j6, K);
                    return K;
                }
                this.f6768e = 2;
            }
            if (this.f6768e == 2) {
                e();
                this.f6768e = 3;
                if (!this.f6769f.t()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public t c() {
        return this.f6769f.c();
    }

    public void close() {
        this.f6771h.close();
    }
}
