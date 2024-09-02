package o1;

import m2.p;

final class e<T> extends d<T> {

    /* renamed from: e  reason: collision with root package name */
    private final d<T> f6139e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6140f;

    /* renamed from: g  reason: collision with root package name */
    private a<T> f6141g;

    e(d<T> dVar) {
        this.f6139e = dVar;
    }

    private void Q0() {
        a<T> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f6141g;
                if (aVar == null) {
                    this.f6140f = false;
                    return;
                }
                this.f6141g = null;
            }
            aVar.a(this.f6139e);
        }
        while (true) {
        }
    }

    public boolean O0() {
        return this.f6139e.O0();
    }

    public void accept(T t5) {
        synchronized (this) {
            if (this.f6140f) {
                a<T> aVar = this.f6141g;
                if (aVar == null) {
                    aVar = new a<>(4);
                    this.f6141g = aVar;
                }
                aVar.b(t5);
                return;
            }
            this.f6140f = true;
            this.f6139e.accept(t5);
            Q0();
        }
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super T> pVar) {
        this.f6139e.g(pVar);
    }
}
