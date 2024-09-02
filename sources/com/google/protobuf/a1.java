package com.google.protobuf;

import com.google.protobuf.i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

final class a1 extends i.C0065i {

    /* renamed from: i  reason: collision with root package name */
    private final ByteBuffer f3467i;

    a1(ByteBuffer byteBuffer) {
        b0.b(byteBuffer, "buffer");
        this.f3467i = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private ByteBuffer I(int i5, int i6) {
        if (i5 < this.f3467i.position() || i6 > this.f3467i.limit() || i5 > i6) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6)}));
        }
        ByteBuffer slice = this.f3467i.slice();
        slice.position(i5 - this.f3467i.position());
        slice.limit(i6 - this.f3467i.position());
        return slice;
    }

    /* access modifiers changed from: protected */
    public String B(Charset charset) {
        int i5;
        int i6;
        byte[] bArr;
        if (this.f3467i.hasArray()) {
            bArr = this.f3467i.array();
            i6 = this.f3467i.arrayOffset() + this.f3467i.position();
            i5 = this.f3467i.remaining();
        } else {
            bArr = y();
            i6 = 0;
            i5 = bArr.length;
        }
        return new String(bArr, i6, i5, charset);
    }

    /* access modifiers changed from: package-private */
    public void H(h hVar) {
        hVar.a(this.f3467i.slice());
    }

    public ByteBuffer e() {
        return this.f3467i.asReadOnlyBuffer();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (size() != iVar.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        return obj instanceof a1 ? this.f3467i.equals(((a1) obj).f3467i) : this.f3467i.equals(iVar.e());
    }

    public byte f(int i5) {
        try {
            return this.f3467i.get(i5);
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw e5;
        } catch (IndexOutOfBoundsException e6) {
            throw new ArrayIndexOutOfBoundsException(e6.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void p(byte[] bArr, int i5, int i6, int i7) {
        ByteBuffer slice = this.f3467i.slice();
        slice.position(i5);
        slice.get(bArr, i6, i7);
    }

    public byte q(int i5) {
        return f(i5);
    }

    public boolean r() {
        return u1.r(this.f3467i);
    }

    public int size() {
        return this.f3467i.remaining();
    }

    public j u() {
        return j.i(this.f3467i, true);
    }

    /* access modifiers changed from: protected */
    public int v(int i5, int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            i5 = (i5 * 31) + this.f3467i.get(i8);
        }
        return i5;
    }

    public i x(int i5, int i6) {
        try {
            return new a1(I(i5, i6));
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw e5;
        } catch (IndexOutOfBoundsException e6) {
            throw new ArrayIndexOutOfBoundsException(e6.getMessage());
        }
    }
}
