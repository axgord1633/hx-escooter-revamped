package androidx.lifecycle;

import androidx.lifecycle.f;
import j.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.g;

public class k extends f {

    /* renamed from: j  reason: collision with root package name */
    public static final a f2583j = new a((g) null);

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2584b;

    /* renamed from: c  reason: collision with root package name */
    private k.a<i, b> f2585c;

    /* renamed from: d  reason: collision with root package name */
    private f.b f2586d;

    /* renamed from: e  reason: collision with root package name */
    private final WeakReference<j> f2587e;

    /* renamed from: f  reason: collision with root package name */
    private int f2588f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2589g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2590h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<f.b> f2591i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final f.b a(f.b bVar, f.b bVar2) {
            kotlin.jvm.internal.k.e(bVar, "state1");
            return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private f.b f2592a;

        /* renamed from: b  reason: collision with root package name */
        private h f2593b;

        public b(i iVar, f.b bVar) {
            kotlin.jvm.internal.k.e(bVar, "initialState");
            kotlin.jvm.internal.k.b(iVar);
            this.f2593b = m.f(iVar);
            this.f2592a = bVar;
        }

        public final void a(j jVar, f.a aVar) {
            kotlin.jvm.internal.k.e(aVar, "event");
            f.b i5 = aVar.i();
            this.f2592a = k.f2583j.a(this.f2592a, i5);
            h hVar = this.f2593b;
            kotlin.jvm.internal.k.b(jVar);
            hVar.a(jVar, aVar);
            this.f2592a = i5;
        }

        public final f.b b() {
            return this.f2592a;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public k(j jVar) {
        this(jVar, true);
        kotlin.jvm.internal.k.e(jVar, "provider");
    }

    private k(j jVar, boolean z4) {
        this.f2584b = z4;
        this.f2585c = new k.a<>();
        this.f2586d = f.b.INITIALIZED;
        this.f2591i = new ArrayList<>();
        this.f2587e = new WeakReference<>(jVar);
    }

    private final void d(j jVar) {
        Iterator<Map.Entry<i, b>> descendingIterator = this.f2585c.descendingIterator();
        kotlin.jvm.internal.k.d(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.f2590h) {
            Map.Entry next = descendingIterator.next();
            kotlin.jvm.internal.k.d(next, "next()");
            i iVar = (i) next.getKey();
            b bVar = (b) next.getValue();
            while (bVar.b().compareTo(this.f2586d) > 0 && !this.f2590h && this.f2585c.contains(iVar)) {
                f.a a5 = f.a.Companion.a(bVar.b());
                if (a5 != null) {
                    m(a5.i());
                    bVar.a(jVar, a5);
                    l();
                } else {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r4 = r4.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.lifecycle.f.b e(androidx.lifecycle.i r4) {
        /*
            r3 = this;
            k.a<androidx.lifecycle.i, androidx.lifecycle.k$b> r0 = r3.f2585c
            java.util.Map$Entry r4 = r0.o(r4)
            r0 = 0
            if (r4 == 0) goto L_0x0016
            java.lang.Object r4 = r4.getValue()
            androidx.lifecycle.k$b r4 = (androidx.lifecycle.k.b) r4
            if (r4 == 0) goto L_0x0016
            androidx.lifecycle.f$b r4 = r4.b()
            goto L_0x0017
        L_0x0016:
            r4 = r0
        L_0x0017:
            java.util.ArrayList<androidx.lifecycle.f$b> r1 = r3.f2591i
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x002f
            java.util.ArrayList<androidx.lifecycle.f$b> r0 = r3.f2591i
            int r1 = r0.size()
            int r1 = r1 + -1
            java.lang.Object r0 = r0.get(r1)
            androidx.lifecycle.f$b r0 = (androidx.lifecycle.f.b) r0
        L_0x002f:
            androidx.lifecycle.k$a r1 = f2583j
            androidx.lifecycle.f$b r2 = r3.f2586d
            androidx.lifecycle.f$b r4 = r1.a(r2, r4)
            androidx.lifecycle.f$b r4 = r1.a(r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.k.e(androidx.lifecycle.i):androidx.lifecycle.f$b");
    }

    private final void f(String str) {
        if (this.f2584b && !c.f().b()) {
            throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
        }
    }

    private final void g(j jVar) {
        k.b<K, V>.d f5 = this.f2585c.f();
        kotlin.jvm.internal.k.d(f5, "observerMap.iteratorWithAdditions()");
        while (f5.hasNext() && !this.f2590h) {
            Map.Entry entry = (Map.Entry) f5.next();
            i iVar = (i) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f2586d) < 0 && !this.f2590h && this.f2585c.contains(iVar)) {
                m(bVar.b());
                f.a b5 = f.a.Companion.b(bVar.b());
                if (b5 != null) {
                    bVar.a(jVar, b5);
                    l();
                } else {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
            }
        }
    }

    private final boolean i() {
        if (this.f2585c.size() == 0) {
            return true;
        }
        Map.Entry<i, b> c5 = this.f2585c.c();
        kotlin.jvm.internal.k.b(c5);
        f.b b5 = c5.getValue().b();
        Map.Entry<i, b> i5 = this.f2585c.i();
        kotlin.jvm.internal.k.b(i5);
        f.b b6 = i5.getValue().b();
        return b5 == b6 && this.f2586d == b6;
    }

    private final void k(f.b bVar) {
        f.b bVar2 = this.f2586d;
        if (bVar2 != bVar) {
            if ((bVar2 == f.b.INITIALIZED && bVar == f.b.DESTROYED) ? false : true) {
                this.f2586d = bVar;
                if (this.f2589g || this.f2588f != 0) {
                    this.f2590h = true;
                    return;
                }
                this.f2589g = true;
                o();
                this.f2589g = false;
                if (this.f2586d == f.b.DESTROYED) {
                    this.f2585c = new k.a<>();
                    return;
                }
                return;
            }
            throw new IllegalStateException(("no event down from " + this.f2586d + " in component " + this.f2587e.get()).toString());
        }
    }

    private final void l() {
        ArrayList<f.b> arrayList = this.f2591i;
        arrayList.remove(arrayList.size() - 1);
    }

    private final void m(f.b bVar) {
        this.f2591i.add(bVar);
    }

    private final void o() {
        j jVar = this.f2587e.get();
        if (jVar != null) {
            while (true) {
                boolean i5 = i();
                this.f2590h = false;
                if (!i5) {
                    f.b bVar = this.f2586d;
                    Map.Entry<i, b> c5 = this.f2585c.c();
                    kotlin.jvm.internal.k.b(c5);
                    if (bVar.compareTo(c5.getValue().b()) < 0) {
                        d(jVar);
                    }
                    Map.Entry<i, b> i6 = this.f2585c.i();
                    if (!this.f2590h && i6 != null && this.f2586d.compareTo(i6.getValue().b()) > 0) {
                        g(jVar);
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
    }

    public void a(i iVar) {
        j jVar;
        kotlin.jvm.internal.k.e(iVar, "observer");
        f("addObserver");
        f.b bVar = this.f2586d;
        f.b bVar2 = f.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = f.b.INITIALIZED;
        }
        b bVar3 = new b(iVar, bVar2);
        if (this.f2585c.m(iVar, bVar3) == null && (jVar = this.f2587e.get()) != null) {
            boolean z4 = this.f2588f != 0 || this.f2589g;
            f.b e5 = e(iVar);
            this.f2588f++;
            while (bVar3.b().compareTo(e5) < 0 && this.f2585c.contains(iVar)) {
                m(bVar3.b());
                f.a b5 = f.a.Companion.b(bVar3.b());
                if (b5 != null) {
                    bVar3.a(jVar, b5);
                    l();
                    e5 = e(iVar);
                } else {
                    throw new IllegalStateException("no event up from " + bVar3.b());
                }
            }
            if (!z4) {
                o();
            }
            this.f2588f--;
        }
    }

    public f.b b() {
        return this.f2586d;
    }

    public void c(i iVar) {
        kotlin.jvm.internal.k.e(iVar, "observer");
        f("removeObserver");
        this.f2585c.n(iVar);
    }

    public void h(f.a aVar) {
        kotlin.jvm.internal.k.e(aVar, "event");
        f("handleLifecycleEvent");
        k(aVar.i());
    }

    public void j(f.b bVar) {
        kotlin.jvm.internal.k.e(bVar, "state");
        f("markState");
        n(bVar);
    }

    public void n(f.b bVar) {
        kotlin.jvm.internal.k.e(bVar, "state");
        f("setCurrentState");
        k(bVar);
    }
}
