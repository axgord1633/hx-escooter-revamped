package y1;

import java.util.concurrent.atomic.AtomicBoolean;
import m2.l;
import m2.p;
import p2.c;
import r2.d;
import x1.i;

public class e0<T> implements p<T>, d {

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f7735e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final l<T> f7736f;

    /* renamed from: g  reason: collision with root package name */
    private final i f7737g;

    public e0(l<T> lVar, i iVar) {
        this.f7736f = lVar;
        this.f7737g = iVar;
        lVar.g(this);
    }

    public void a() {
        this.f7737g.release();
        this.f7736f.a();
    }

    public void c(c cVar) {
    }

    public synchronized void cancel() {
        this.f7735e.set(true);
    }

    public void d(T t5) {
        this.f7736f.d(t5);
    }

    public void onError(Throwable th) {
        this.f7737g.release();
        this.f7736f.e(th);
    }
}
