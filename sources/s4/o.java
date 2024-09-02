package s4;

import javax.annotation.Nullable;

final class o {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f6789a;

    /* renamed from: b  reason: collision with root package name */
    int f6790b;

    /* renamed from: c  reason: collision with root package name */
    int f6791c;

    /* renamed from: d  reason: collision with root package name */
    boolean f6792d;

    /* renamed from: e  reason: collision with root package name */
    boolean f6793e;

    /* renamed from: f  reason: collision with root package name */
    o f6794f;

    /* renamed from: g  reason: collision with root package name */
    o f6795g;

    o() {
        this.f6789a = new byte[8192];
        this.f6793e = true;
        this.f6792d = false;
    }

    o(byte[] bArr, int i5, int i6, boolean z4, boolean z5) {
        this.f6789a = bArr;
        this.f6790b = i5;
        this.f6791c = i6;
        this.f6792d = z4;
        this.f6793e = z5;
    }

    public final void a() {
        o oVar = this.f6795g;
        if (oVar == this) {
            throw new IllegalStateException();
        } else if (oVar.f6793e) {
            int i5 = this.f6791c - this.f6790b;
            if (i5 <= (8192 - oVar.f6791c) + (oVar.f6792d ? 0 : oVar.f6790b)) {
                f(oVar, i5);
                b();
                p.a(this);
            }
        }
    }

    @Nullable
    public final o b() {
        o oVar = this.f6794f;
        o oVar2 = oVar != this ? oVar : null;
        o oVar3 = this.f6795g;
        oVar3.f6794f = oVar;
        this.f6794f.f6795g = oVar3;
        this.f6794f = null;
        this.f6795g = null;
        return oVar2;
    }

    public final o c(o oVar) {
        oVar.f6795g = this;
        oVar.f6794f = this.f6794f;
        this.f6794f.f6795g = oVar;
        this.f6794f = oVar;
        return oVar;
    }

    /* access modifiers changed from: package-private */
    public final o d() {
        this.f6792d = true;
        return new o(this.f6789a, this.f6790b, this.f6791c, true, false);
    }

    public final o e(int i5) {
        o oVar;
        if (i5 <= 0 || i5 > this.f6791c - this.f6790b) {
            throw new IllegalArgumentException();
        }
        if (i5 >= 1024) {
            oVar = d();
        } else {
            oVar = p.b();
            System.arraycopy(this.f6789a, this.f6790b, oVar.f6789a, 0, i5);
        }
        oVar.f6791c = oVar.f6790b + i5;
        this.f6790b += i5;
        this.f6795g.c(oVar);
        return oVar;
    }

    public final void f(o oVar, int i5) {
        if (oVar.f6793e) {
            int i6 = oVar.f6791c;
            if (i6 + i5 > 8192) {
                if (!oVar.f6792d) {
                    int i7 = oVar.f6790b;
                    if ((i6 + i5) - i7 <= 8192) {
                        byte[] bArr = oVar.f6789a;
                        System.arraycopy(bArr, i7, bArr, 0, i6 - i7);
                        oVar.f6791c -= oVar.f6790b;
                        oVar.f6790b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f6789a, this.f6790b, oVar.f6789a, oVar.f6791c, i5);
            oVar.f6791c += i5;
            this.f6790b += i5;
            return;
        }
        throw new IllegalArgumentException();
    }
}
