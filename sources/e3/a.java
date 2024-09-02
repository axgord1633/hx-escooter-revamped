package e3;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m2.g;
import u4.b;
import u4.c;

public class a<T> extends AtomicInteger implements g<T>, c {

    /* renamed from: e  reason: collision with root package name */
    final b<? super T> f4499e;

    /* renamed from: f  reason: collision with root package name */
    final g3.b f4500f = new g3.b();

    /* renamed from: g  reason: collision with root package name */
    final AtomicLong f4501g = new AtomicLong();

    /* renamed from: h  reason: collision with root package name */
    final AtomicReference<c> f4502h = new AtomicReference<>();

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f4503i = new AtomicBoolean();

    /* renamed from: j  reason: collision with root package name */
    volatile boolean f4504j;

    public a(b<? super T> bVar) {
        this.f4499e = bVar;
    }

    public void a() {
        this.f4504j = true;
        g3.g.b(this.f4499e, this, this.f4500f);
    }

    public void cancel() {
        if (!this.f4504j) {
            f3.g.c(this.f4502h);
        }
    }

    public void d(T t5) {
        g3.g.f(this.f4499e, t5, this, this.f4500f);
    }

    public void e(c cVar) {
        if (this.f4503i.compareAndSet(false, true)) {
            this.f4499e.e(this);
            f3.g.l(this.f4502h, this.f4501g, cVar);
            return;
        }
        cVar.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void f(long j5) {
        if (j5 <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j5));
            return;
        }
        f3.g.i(this.f4502h, this.f4501g, j5);
    }

    public void onError(Throwable th) {
        this.f4504j = true;
        g3.g.d(this.f4499e, th, this, this.f4500f);
    }
}
