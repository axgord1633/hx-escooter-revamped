package s4;

import java.util.Arrays;

final class q extends f {

    /* renamed from: j  reason: collision with root package name */
    final transient byte[][] f6798j;

    /* renamed from: k  reason: collision with root package name */
    final transient int[] f6799k;

    q(c cVar, int i5) {
        super((byte[]) null);
        u.b(cVar.f6759f, 0, (long) i5);
        o oVar = cVar.f6758e;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            int i9 = oVar.f6791c;
            int i10 = oVar.f6790b;
            if (i9 != i10) {
                i7 += i9 - i10;
                i8++;
                oVar = oVar.f6794f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f6798j = new byte[i8][];
        this.f6799k = new int[(i8 * 2)];
        o oVar2 = cVar.f6758e;
        int i11 = 0;
        while (i6 < i5) {
            byte[][] bArr = this.f6798j;
            bArr[i11] = oVar2.f6789a;
            int i12 = oVar2.f6791c;
            int i13 = oVar2.f6790b;
            i6 += i12 - i13;
            if (i6 > i5) {
                i6 = i5;
            }
            int[] iArr = this.f6799k;
            iArr[i11] = i6;
            iArr[bArr.length + i11] = i13;
            oVar2.f6792d = true;
            i11++;
            oVar2 = oVar2.f6794f;
        }
    }

    private int D(int i5) {
        int binarySearch = Arrays.binarySearch(this.f6799k, 0, this.f6798j.length, i5 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    private f E() {
        return new f(A());
    }

    public byte[] A() {
        int[] iArr = this.f6799k;
        byte[][] bArr = this.f6798j;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int[] iArr2 = this.f6799k;
            int i7 = iArr2[length + i5];
            int i8 = iArr2[i5];
            System.arraycopy(this.f6798j[i5], i7, bArr2, i6, i8 - i6);
            i5++;
            i6 = i8;
        }
        return bArr2;
    }

    public String B() {
        return E().B();
    }

    /* access modifiers changed from: package-private */
    public void C(c cVar) {
        int length = this.f6798j.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int[] iArr = this.f6799k;
            int i7 = iArr[length + i5];
            int i8 = iArr[i5];
            o oVar = new o(this.f6798j[i5], i7, (i7 + i8) - i6, true, false);
            o oVar2 = cVar.f6758e;
            if (oVar2 == null) {
                oVar.f6795g = oVar;
                oVar.f6794f = oVar;
                cVar.f6758e = oVar;
            } else {
                oVar2.f6795g.c(oVar);
            }
            i5++;
            i6 = i8;
        }
        cVar.f6759f += (long) i6;
    }

    public String c() {
        return E().c();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.w() == w() && s(0, fVar, 0, w())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i5 = this.f6763f;
        if (i5 != 0) {
            return i5;
        }
        int length = this.f6798j.length;
        int i6 = 0;
        int i7 = 1;
        int i8 = 0;
        while (i6 < length) {
            byte[] bArr = this.f6798j[i6];
            int[] iArr = this.f6799k;
            int i9 = iArr[length + i6];
            int i10 = iArr[i6];
            int i11 = (i10 - i8) + i9;
            while (i9 < i11) {
                i7 = (i7 * 31) + bArr[i9];
                i9++;
            }
            i6++;
            i8 = i10;
        }
        this.f6763f = i7;
        return i7;
    }

    public byte p(int i5) {
        u.b((long) this.f6799k[this.f6798j.length - 1], (long) i5, 1);
        int D = D(i5);
        int i6 = D == 0 ? 0 : this.f6799k[D - 1];
        int[] iArr = this.f6799k;
        byte[][] bArr = this.f6798j;
        return bArr[D][(i5 - i6) + iArr[bArr.length + D]];
    }

    public String q() {
        return E().q();
    }

    public boolean s(int i5, f fVar, int i6, int i7) {
        if (i5 < 0 || i5 > w() - i7) {
            return false;
        }
        int D = D(i5);
        while (i7 > 0) {
            int i8 = D == 0 ? 0 : this.f6799k[D - 1];
            int min = Math.min(i7, ((this.f6799k[D] - i8) + i8) - i5);
            int[] iArr = this.f6799k;
            byte[][] bArr = this.f6798j;
            if (!fVar.t(i6, bArr[D], (i5 - i8) + iArr[bArr.length + D], min)) {
                return false;
            }
            i5 += min;
            i6 += min;
            i7 -= min;
            D++;
        }
        return true;
    }

    public boolean t(int i5, byte[] bArr, int i6, int i7) {
        if (i5 < 0 || i5 > w() - i7 || i6 < 0 || i6 > bArr.length - i7) {
            return false;
        }
        int D = D(i5);
        while (i7 > 0) {
            int i8 = D == 0 ? 0 : this.f6799k[D - 1];
            int min = Math.min(i7, ((this.f6799k[D] - i8) + i8) - i5);
            int[] iArr = this.f6799k;
            byte[][] bArr2 = this.f6798j;
            if (!u.a(bArr2[D], (i5 - i8) + iArr[bArr2.length + D], bArr, i6, min)) {
                return false;
            }
            i5 += min;
            i6 += min;
            i7 -= min;
            D++;
        }
        return true;
    }

    public String toString() {
        return E().toString();
    }

    public f u() {
        return E().u();
    }

    public f v() {
        return E().v();
    }

    public int w() {
        return this.f6799k[this.f6798j.length - 1];
    }

    public f y(int i5, int i6) {
        return E().y(i5, i6);
    }

    public f z() {
        return E().z();
    }
}
