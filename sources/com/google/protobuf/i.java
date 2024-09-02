package com.google.protobuf;

import com.yalantis.ucrop.BuildConfig;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

public abstract class i implements Iterable<Byte>, Serializable {

    /* renamed from: f  reason: collision with root package name */
    public static final i f3533f = new j(b0.f3471c);

    /* renamed from: g  reason: collision with root package name */
    private static final f f3534g = (d.c() ? new k((a) null) : new d((a) null));

    /* renamed from: h  reason: collision with root package name */
    private static final Comparator<i> f3535h = new b();

    /* renamed from: e  reason: collision with root package name */
    private int f3536e = 0;

    class a extends c {

        /* renamed from: e  reason: collision with root package name */
        private int f3537e = 0;

        /* renamed from: f  reason: collision with root package name */
        private final int f3538f;

        a() {
            this.f3538f = i.this.size();
        }

        public byte a() {
            int i5 = this.f3537e;
            if (i5 < this.f3538f) {
                this.f3537e = i5 + 1;
                return i.this.q(i5);
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.f3537e < this.f3538f;
        }
    }

    static class b implements Comparator<i> {
        b() {
        }

        /* renamed from: a */
        public int compare(i iVar, i iVar2) {
            g s5 = iVar.iterator();
            g s6 = iVar2.iterator();
            while (s5.hasNext() && s6.hasNext()) {
                int compare = Integer.compare(i.z(s5.a()), i.z(s6.a()));
                if (compare != 0) {
                    return compare;
                }
            }
            return Integer.compare(iVar.size(), iVar2.size());
        }
    }

    static abstract class c implements g {
        c() {
        }

        /* renamed from: b */
        public final Byte next() {
            return Byte.valueOf(a());
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class d implements f {
        private d() {
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        public byte[] a(byte[] bArr, int i5, int i6) {
            return Arrays.copyOfRange(bArr, i5, i6 + i5);
        }
    }

    private static final class e extends j {

        /* renamed from: j  reason: collision with root package name */
        private final int f3540j;

        /* renamed from: k  reason: collision with root package name */
        private final int f3541k;

        e(byte[] bArr, int i5, int i6) {
            super(bArr);
            i.l(i5, i5 + i6, bArr.length);
            this.f3540j = i5;
            this.f3541k = i6;
        }

        /* access modifiers changed from: protected */
        public int J() {
            return this.f3540j;
        }

        public byte f(int i5) {
            i.i(i5, size());
            return this.f3544i[this.f3540j + i5];
        }

        /* access modifiers changed from: protected */
        public void p(byte[] bArr, int i5, int i6, int i7) {
            System.arraycopy(this.f3544i, J() + i5, bArr, i6, i7);
        }

        /* access modifiers changed from: package-private */
        public byte q(int i5) {
            return this.f3544i[this.f3540j + i5];
        }

        public int size() {
            return this.f3541k;
        }
    }

    private interface f {
        byte[] a(byte[] bArr, int i5, int i6);
    }

    public interface g extends Iterator<Byte> {
        byte a();
    }

    static final class h {

        /* renamed from: a  reason: collision with root package name */
        private final l f3542a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f3543b;

        private h(int i5) {
            byte[] bArr = new byte[i5];
            this.f3543b = bArr;
            this.f3542a = l.h0(bArr);
        }

        /* synthetic */ h(int i5, a aVar) {
            this(i5);
        }

        public i a() {
            this.f3542a.d();
            return new j(this.f3543b);
        }

        public l b() {
            return this.f3542a;
        }
    }

    /* renamed from: com.google.protobuf.i$i  reason: collision with other inner class name */
    static abstract class C0065i extends i {
        C0065i() {
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return i.super.iterator();
        }
    }

    private static class j extends C0065i {

        /* renamed from: i  reason: collision with root package name */
        protected final byte[] f3544i;

        j(byte[] bArr) {
            bArr.getClass();
            this.f3544i = bArr;
        }

        /* access modifiers changed from: protected */
        public final String B(Charset charset) {
            return new String(this.f3544i, J(), size(), charset);
        }

        /* access modifiers changed from: package-private */
        public final void H(h hVar) {
            hVar.b(this.f3544i, J(), size());
        }

        /* access modifiers changed from: package-private */
        public final boolean I(i iVar, int i5, int i6) {
            if (i6 <= iVar.size()) {
                int i7 = i5 + i6;
                if (i7 > iVar.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i5 + ", " + i6 + ", " + iVar.size());
                } else if (!(iVar instanceof j)) {
                    return iVar.x(i5, i7).equals(x(0, i6));
                } else {
                    j jVar = (j) iVar;
                    byte[] bArr = this.f3544i;
                    byte[] bArr2 = jVar.f3544i;
                    int J = J() + i6;
                    int J2 = J();
                    int J3 = jVar.J() + i5;
                    while (J2 < J) {
                        if (bArr[J2] != bArr2[J3]) {
                            return false;
                        }
                        J2++;
                        J3++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i6 + size());
            }
        }

        /* access modifiers changed from: protected */
        public int J() {
            return 0;
        }

        public final ByteBuffer e() {
            return ByteBuffer.wrap(this.f3544i, J(), size()).asReadOnlyBuffer();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof i) || size() != ((i) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof j)) {
                return obj.equals(this);
            }
            j jVar = (j) obj;
            int w4 = w();
            int w5 = jVar.w();
            if (w4 == 0 || w5 == 0 || w4 == w5) {
                return I(jVar, 0, size());
            }
            return false;
        }

        public byte f(int i5) {
            return this.f3544i[i5];
        }

        /* access modifiers changed from: protected */
        public void p(byte[] bArr, int i5, int i6, int i7) {
            System.arraycopy(this.f3544i, i5, bArr, i6, i7);
        }

        /* access modifiers changed from: package-private */
        public byte q(int i5) {
            return this.f3544i[i5];
        }

        public final boolean r() {
            int J = J();
            return u1.t(this.f3544i, J, size() + J);
        }

        public int size() {
            return this.f3544i.length;
        }

        public final j u() {
            return j.l(this.f3544i, J(), size(), true);
        }

        /* access modifiers changed from: protected */
        public final int v(int i5, int i6, int i7) {
            return b0.i(i5, this.f3544i, J() + i6, i7);
        }

        public final i x(int i5, int i6) {
            int l5 = i.l(i5, i6, size());
            return l5 == 0 ? i.f3533f : new e(this.f3544i, J() + i5, l5);
        }
    }

    private static final class k implements f {
        private k() {
        }

        /* synthetic */ k(a aVar) {
            this();
        }

        public byte[] a(byte[] bArr, int i5, int i6) {
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i5, bArr2, 0, i6);
            return bArr2;
        }
    }

    i() {
    }

    private String D() {
        if (size() <= 50) {
            return n1.a(this);
        }
        return n1.a(x(0, 47)) + "...";
    }

    static i E(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new a1(byteBuffer);
        }
        return G(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    static i F(byte[] bArr) {
        return new j(bArr);
    }

    static i G(byte[] bArr, int i5, int i6) {
        return new e(bArr, i5, i6);
    }

    static void i(int i5, int i6) {
        if (((i6 - (i5 + 1)) | i5) >= 0) {
            return;
        }
        if (i5 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i5);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i5 + ", " + i6);
    }

    static int l(int i5, int i6, int i7) {
        int i8 = i6 - i5;
        if ((i5 | i6 | i8 | (i7 - i6)) >= 0) {
            return i8;
        }
        if (i5 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i5 + " < 0");
        } else if (i6 < i5) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i5 + ", " + i6);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i6 + " >= " + i7);
        }
    }

    public static i m(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    public static i n(byte[] bArr, int i5, int i6) {
        l(i5, i5 + i6, bArr.length);
        return new j(f3534g.a(bArr, i5, i6));
    }

    public static i o(String str) {
        return new j(str.getBytes(b0.f3469a));
    }

    static h t(int i5) {
        return new h(i5, (a) null);
    }

    /* access modifiers changed from: private */
    public static int z(byte b5) {
        return b5 & 255;
    }

    public final String A(Charset charset) {
        return size() == 0 ? BuildConfig.FLAVOR : B(charset);
    }

    /* access modifiers changed from: protected */
    public abstract String B(Charset charset);

    public final String C() {
        return A(b0.f3469a);
    }

    /* access modifiers changed from: package-private */
    public abstract void H(h hVar);

    public abstract ByteBuffer e();

    public abstract boolean equals(Object obj);

    public abstract byte f(int i5);

    public final int hashCode() {
        int i5 = this.f3536e;
        if (i5 == 0) {
            int size = size();
            i5 = v(size, 0, size);
            if (i5 == 0) {
                i5 = 1;
            }
            this.f3536e = i5;
        }
        return i5;
    }

    /* access modifiers changed from: protected */
    public abstract void p(byte[] bArr, int i5, int i6, int i7);

    /* access modifiers changed from: package-private */
    public abstract byte q(int i5);

    public abstract boolean r();

    /* renamed from: s */
    public g iterator() {
        return new a();
    }

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), D()});
    }

    public abstract j u();

    /* access modifiers changed from: protected */
    public abstract int v(int i5, int i6, int i7);

    /* access modifiers changed from: protected */
    public final int w() {
        return this.f3536e;
    }

    public abstract i x(int i5, int i6);

    public final byte[] y() {
        int size = size();
        if (size == 0) {
            return b0.f3471c;
        }
        byte[] bArr = new byte[size];
        p(bArr, 0, 0, size);
        return bArr;
    }
}
