package i4;

import i4.w;
import j4.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f5122a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f5123b = 5;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Runnable f5124c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f5125d;

    /* renamed from: e  reason: collision with root package name */
    private final Deque<w.b> f5126e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    private final Deque<w.b> f5127f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    private final Deque<w> f5128g = new ArrayDeque();

    private <T> void f(Deque<T> deque, T t5) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t5)) {
                runnable = this.f5124c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!g() && runnable != null) {
            runnable.run();
        }
    }

    private boolean g() {
        int i5;
        boolean z4;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<w.b> it = this.f5126e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                w.b next = it.next();
                if (this.f5127f.size() >= this.f5122a) {
                    break;
                } else if (i(next) < this.f5123b) {
                    it.remove();
                    arrayList.add(next);
                    this.f5127f.add(next);
                }
            }
            z4 = h() > 0;
        }
        int size = arrayList.size();
        for (i5 = 0; i5 < size; i5++) {
            ((w.b) arrayList.get(i5)).l(c());
        }
        return z4;
    }

    private int i(w.b bVar) {
        int i5 = 0;
        for (w.b next : this.f5127f) {
            if (!next.m().f5217j && next.n().equals(bVar.n())) {
                i5++;
            }
        }
        return i5;
    }

    public synchronized void a() {
        for (w.b m5 : this.f5126e) {
            m5.m().b();
        }
        for (w.b m6 : this.f5127f) {
            m6.m().b();
        }
        for (w b5 : this.f5128g) {
            b5.b();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void b(w wVar) {
        this.f5128g.add(wVar);
    }

    public synchronized ExecutorService c() {
        if (this.f5125d == null) {
            this.f5125d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.E("OkHttp Dispatcher", false));
        }
        return this.f5125d;
    }

    /* access modifiers changed from: package-private */
    public void d(w.b bVar) {
        f(this.f5127f, bVar);
    }

    /* access modifiers changed from: package-private */
    public void e(w wVar) {
        f(this.f5128g, wVar);
    }

    public synchronized int h() {
        return this.f5127f.size() + this.f5128g.size();
    }
}
