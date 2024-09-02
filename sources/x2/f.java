package x2;

import u4.a;
import u4.b;

public final class f<T, U> extends m2.f<U> {

    /* renamed from: f  reason: collision with root package name */
    final a<T> f7670f;

    /* renamed from: g  reason: collision with root package name */
    final r2.f<? super T, ? extends a<? extends U>> f7671g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f7672h;

    /* renamed from: i  reason: collision with root package name */
    final int f7673i;

    /* renamed from: j  reason: collision with root package name */
    final int f7674j;

    public f(a<T> aVar, r2.f<? super T, ? extends a<? extends U>> fVar, boolean z4, int i5, int i6) {
        this.f7670f = aVar;
        this.f7671g = fVar;
        this.f7672h = z4;
        this.f7673i = i5;
        this.f7674j = i6;
    }

    /* access modifiers changed from: protected */
    public void j(b<? super U> bVar) {
        if (!j.a(this.f7670f, bVar, this.f7671g)) {
            this.f7670f.a(e.k(bVar, this.f7671g, this.f7672h, this.f7673i, this.f7674j));
        }
    }
}
