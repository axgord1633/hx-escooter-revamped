package s4;

import java.nio.ByteBuffer;

final class m implements d {

    /* renamed from: e  reason: collision with root package name */
    public final c f6783e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final r f6784f;

    /* renamed from: g  reason: collision with root package name */
    boolean f6785g;

    m(r rVar) {
        if (rVar != null) {
            this.f6784f = rVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public void G(c cVar, long j5) {
        if (!this.f6785g) {
            this.f6783e.G(cVar, j5);
            y();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public d I(String str) {
        if (!this.f6785g) {
            this.f6783e.I(str);
            return y();
        }
        throw new IllegalStateException("closed");
    }

    public c a() {
        return this.f6783e;
    }

    public t c() {
        return this.f6784f.c();
    }

    public void close() {
        if (!this.f6785g) {
            Throwable th = null;
            try {
                c cVar = this.f6783e;
                long j5 = cVar.f6759f;
                if (j5 > 0) {
                    this.f6784f.G(cVar, j5);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f6784f.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f6785g = true;
            if (th != null) {
                u.e(th);
            }
        }
    }

    public void flush() {
        if (!this.f6785g) {
            c cVar = this.f6783e;
            long j5 = cVar.f6759f;
            if (j5 > 0) {
                this.f6784f.G(cVar, j5);
            }
            this.f6784f.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public d i(long j5) {
        if (!this.f6785g) {
            this.f6783e.i(j5);
            return y();
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f6785g;
    }

    public String toString() {
        return "buffer(" + this.f6784f + ")";
    }

    public int write(ByteBuffer byteBuffer) {
        if (!this.f6785g) {
            int write = this.f6783e.write(byteBuffer);
            y();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    public d write(byte[] bArr) {
        if (!this.f6785g) {
            this.f6783e.write(bArr);
            return y();
        }
        throw new IllegalStateException("closed");
    }

    public d write(byte[] bArr, int i5, int i6) {
        if (!this.f6785g) {
            this.f6783e.write(bArr, i5, i6);
            return y();
        }
        throw new IllegalStateException("closed");
    }

    public d writeByte(int i5) {
        if (!this.f6785g) {
            this.f6783e.writeByte(i5);
            return y();
        }
        throw new IllegalStateException("closed");
    }

    public d writeInt(int i5) {
        if (!this.f6785g) {
            this.f6783e.writeInt(i5);
            return y();
        }
        throw new IllegalStateException("closed");
    }

    public d writeShort(int i5) {
        if (!this.f6785g) {
            this.f6783e.writeShort(i5);
            return y();
        }
        throw new IllegalStateException("closed");
    }

    public d y() {
        if (!this.f6785g) {
            long f5 = this.f6783e.f();
            if (f5 > 0) {
                this.f6784f.G(this.f6783e, f5);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
