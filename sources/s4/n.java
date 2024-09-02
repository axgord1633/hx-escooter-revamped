package s4;

import java.io.EOFException;
import java.nio.ByteBuffer;

final class n implements e {

    /* renamed from: e  reason: collision with root package name */
    public final c f6786e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final s f6787f;

    /* renamed from: g  reason: collision with root package name */
    boolean f6788g;

    n(s sVar) {
        if (sVar != null) {
            this.f6787f = sVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public String A(long j5) {
        if (j5 >= 0) {
            long j6 = j5 == Long.MAX_VALUE ? Long.MAX_VALUE : j5 + 1;
            long b5 = b((byte) 10, 0, j6);
            if (b5 != -1) {
                return this.f6786e.w(b5);
            }
            if (j6 < Long.MAX_VALUE && d(j6) && this.f6786e.j(j6 - 1) == 13 && d(1 + j6) && this.f6786e.j(j6) == 10) {
                return this.f6786e.w(j6);
            }
            c cVar = new c();
            c cVar2 = this.f6786e;
            cVar2.g(cVar, 0, Math.min(32, cVar2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f6786e.size(), j5) + " content=" + cVar.n().q() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j5);
    }

    public void H(long j5) {
        if (!d(j5)) {
            throw new EOFException();
        }
    }

    public long J(byte b5) {
        return b(b5, 0, Long.MAX_VALUE);
    }

    public long K(c cVar, long j5) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j5 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j5);
        } else if (!this.f6788g) {
            c cVar2 = this.f6786e;
            if (cVar2.f6759f == 0 && this.f6787f.K(cVar2, 8192) == -1) {
                return -1;
            }
            return this.f6786e.K(cVar, Math.min(j5, this.f6786e.f6759f));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public long L() {
        H(1);
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (!d((long) i6)) {
                break;
            }
            byte j5 = this.f6786e.j((long) i5);
            if ((j5 >= 48 && j5 <= 57) || ((j5 >= 97 && j5 <= 102) || (j5 >= 65 && j5 <= 70))) {
                i5 = i6;
            } else if (i5 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(j5)}));
            }
        }
        return this.f6786e.L();
    }

    public c a() {
        return this.f6786e;
    }

    public long b(byte b5, long j5, long j6) {
        if (this.f6788g) {
            throw new IllegalStateException("closed");
        } else if (j5 < 0 || j6 < j5) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j5), Long.valueOf(j6)}));
        } else {
            while (j5 < j6) {
                long l5 = this.f6786e.l(b5, j5, j6);
                if (l5 == -1) {
                    c cVar = this.f6786e;
                    long j7 = cVar.f6759f;
                    if (j7 >= j6 || this.f6787f.K(cVar, 8192) == -1) {
                        break;
                    }
                    j5 = Math.max(j5, j7);
                } else {
                    return l5;
                }
            }
            return -1;
        }
    }

    public t c() {
        return this.f6787f.c();
    }

    public void close() {
        if (!this.f6788g) {
            this.f6788g = true;
            this.f6787f.close();
            this.f6786e.b();
        }
    }

    public boolean d(long j5) {
        c cVar;
        if (j5 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j5);
        } else if (!this.f6788g) {
            do {
                cVar = this.f6786e;
                if (cVar.f6759f >= j5) {
                    return true;
                }
            } while (this.f6787f.K(cVar, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public boolean isOpen() {
        return !this.f6788g;
    }

    public f k(long j5) {
        H(j5);
        return this.f6786e.k(j5);
    }

    public long o(r rVar) {
        if (rVar != null) {
            long j5 = 0;
            while (this.f6787f.K(this.f6786e, 8192) != -1) {
                long f5 = this.f6786e.f();
                if (f5 > 0) {
                    j5 += f5;
                    rVar.G(this.f6786e, f5);
                }
            }
            if (this.f6786e.size() <= 0) {
                return j5;
            }
            long size = j5 + this.f6786e.size();
            c cVar = this.f6786e;
            rVar.G(cVar, cVar.size());
            return size;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public String r() {
        return A(Long.MAX_VALUE);
    }

    public int read(ByteBuffer byteBuffer) {
        c cVar = this.f6786e;
        if (cVar.f6759f == 0 && this.f6787f.K(cVar, 8192) == -1) {
            return -1;
        }
        return this.f6786e.read(byteBuffer);
    }

    public byte readByte() {
        H(1);
        return this.f6786e.readByte();
    }

    public void readFully(byte[] bArr) {
        try {
            H((long) bArr.length);
            this.f6786e.readFully(bArr);
        } catch (EOFException e5) {
            int i5 = 0;
            while (true) {
                c cVar = this.f6786e;
                long j5 = cVar.f6759f;
                if (j5 > 0) {
                    int read = cVar.read(bArr, i5, (int) j5);
                    if (read != -1) {
                        i5 += read;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e5;
                }
            }
        }
    }

    public int readInt() {
        H(4);
        return this.f6786e.readInt();
    }

    public short readShort() {
        H(2);
        return this.f6786e.readShort();
    }

    public int s() {
        H(4);
        return this.f6786e.s();
    }

    public void skip(long j5) {
        if (!this.f6788g) {
            while (j5 > 0) {
                c cVar = this.f6786e;
                if (cVar.f6759f == 0 && this.f6787f.K(cVar, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j5, this.f6786e.size());
                this.f6786e.skip(min);
                j5 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean t() {
        if (!this.f6788g) {
            return this.f6786e.t() && this.f6787f.K(this.f6786e, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public String toString() {
        return "buffer(" + this.f6787f + ")";
    }

    public byte[] u(long j5) {
        H(j5);
        return this.f6786e.u(j5);
    }

    public short x() {
        H(2);
        return this.f6786e.x();
    }
}
