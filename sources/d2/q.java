package d2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

class q implements o {

    /* renamed from: a  reason: collision with root package name */
    final String f4302a;

    /* renamed from: b  reason: collision with root package name */
    final int f4303b;

    /* renamed from: c  reason: collision with root package name */
    final int f4304c;

    /* renamed from: d  reason: collision with root package name */
    private final LinkedList<k> f4305d = new LinkedList<>();

    /* renamed from: e  reason: collision with root package name */
    private final Set<m> f4306e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private final Set<m> f4307f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private final Map<Integer, m> f4308g = new HashMap();

    q(String str, int i5, int i6) {
        this.f4302a = str;
        this.f4303b = i5;
        this.f4304c = i6;
    }

    private synchronized k f(m mVar) {
        k next;
        ListIterator<k> listIterator = this.f4305d.listIterator();
        while (true) {
            m mVar2 = null;
            if (!listIterator.hasNext()) {
                return null;
            }
            next = listIterator.next();
            if (next.a() != null) {
                mVar2 = this.f4308g.get(next.a());
            }
            if (mVar2 == null || mVar2 == mVar) {
                listIterator.remove();
            }
        }
        listIterator.remove();
        return next;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public synchronized void g(m mVar) {
        HashSet<m> hashSet = new HashSet<>(this.f4306e);
        this.f4307f.remove(mVar);
        this.f4306e.add(mVar);
        if (!mVar.b() && mVar.d() != null) {
            this.f4308g.remove(mVar.d());
        }
        i(mVar);
        for (m i5 : hashSet) {
            i(i5);
        }
    }

    private synchronized void i(m mVar) {
        k f5 = f(mVar);
        if (f5 != null) {
            this.f4307f.add(mVar);
            this.f4306e.remove(mVar);
            if (f5.a() != null) {
                this.f4308g.put(f5.a(), mVar);
            }
            mVar.e(f5);
        }
    }

    public /* synthetic */ void a(i iVar, Runnable runnable) {
        n.a(this, iVar, runnable);
    }

    public synchronized void b() {
        for (m f5 : this.f4306e) {
            f5.f();
        }
        for (m f6 : this.f4307f) {
            f6.f();
        }
    }

    public synchronized void c(k kVar) {
        this.f4305d.add(kVar);
        for (m i5 : new HashSet(this.f4306e)) {
            i(i5);
        }
    }

    /* access modifiers changed from: protected */
    public m e(String str, int i5) {
        return new m(str, i5);
    }

    public synchronized void start() {
        for (int i5 = 0; i5 < this.f4303b; i5++) {
            m e5 = e(this.f4302a + i5, this.f4304c);
            e5.g(new p(this, e5));
            this.f4306e.add(e5);
        }
    }
}
