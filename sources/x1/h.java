package x1;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

class h {

    /* renamed from: a  reason: collision with root package name */
    private final PriorityBlockingQueue<g> f7621a = new PriorityBlockingQueue<>();

    h() {
    }

    public void a(g gVar) {
        this.f7621a.add(gVar);
    }

    public boolean b() {
        return this.f7621a.isEmpty();
    }

    public boolean c(g gVar) {
        Iterator<g> it = this.f7621a.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next == gVar) {
                return this.f7621a.remove(next);
            }
        }
        return false;
    }

    public g<?> d() {
        return this.f7621a.take();
    }

    public g<?> e() {
        return this.f7621a.poll();
    }
}
