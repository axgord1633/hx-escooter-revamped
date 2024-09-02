package s4;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class k implements s {

    /* renamed from: e  reason: collision with root package name */
    private final e f6773e;

    /* renamed from: f  reason: collision with root package name */
    private final Inflater f6774f;

    /* renamed from: g  reason: collision with root package name */
    private int f6775g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6776h;

    k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f6773e = eVar;
            this.f6774f = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    private void d() {
        int i5 = this.f6775g;
        if (i5 != 0) {
            int remaining = i5 - this.f6774f.getRemaining();
            this.f6775g -= remaining;
            this.f6773e.skip((long) remaining);
        }
    }

    public long K(c cVar, long j5) {
        o C;
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j5);
        } else if (this.f6776h) {
            throw new IllegalStateException("closed");
        } else if (i5 == 0) {
            return 0;
        } else {
            while (true) {
                boolean b5 = b();
                try {
                    C = cVar.C(1);
                    int inflate = this.f6774f.inflate(C.f6789a, C.f6791c, (int) Math.min(j5, (long) (8192 - C.f6791c)));
                    if (inflate > 0) {
                        C.f6791c += inflate;
                        long j6 = (long) inflate;
                        cVar.f6759f += j6;
                        return j6;
                    } else if (this.f6774f.finished()) {
                        break;
                    } else if (this.f6774f.needsDictionary()) {
                        break;
                    } else if (b5) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e5) {
                    throw new IOException(e5);
                }
            }
            d();
            if (C.f6790b != C.f6791c) {
                return -1;
            }
            cVar.f6758e = C.b();
            p.a(C);
            return -1;
        }
    }

    public final boolean b() {
        if (!this.f6774f.needsInput()) {
            return false;
        }
        d();
        if (this.f6774f.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f6773e.t()) {
            return true;
        } else {
            o oVar = this.f6773e.a().f6758e;
            int i5 = oVar.f6791c;
            int i6 = oVar.f6790b;
            int i7 = i5 - i6;
            this.f6775g = i7;
            this.f6774f.setInput(oVar.f6789a, i6, i7);
            return false;
        }
    }

    public t c() {
        return this.f6773e.c();
    }

    public void close() {
        if (!this.f6776h) {
            this.f6774f.end();
            this.f6776h = true;
            this.f6773e.close();
        }
    }
}
