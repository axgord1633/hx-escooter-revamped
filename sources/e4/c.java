package e4;

import c4.k0;
import com.yalantis.ucrop.BuildConfig;
import e4.i;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.j;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.o;
import m3.q;
import v3.l;

public abstract class c<E> implements t<E> {

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f4518d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");

    /* renamed from: b  reason: collision with root package name */
    protected final l<E, q> f4519b;

    /* renamed from: c  reason: collision with root package name */
    private final m f4520c = new m();
    private volatile /* synthetic */ Object onCloseHandler = null;

    public static final class a<E> extends s {

        /* renamed from: h  reason: collision with root package name */
        public final E f4521h;

        public a(E e5) {
            this.f4521h = e5;
        }

        public String toString() {
            return "SendBuffered@" + k0.b(this) + '(' + this.f4521h + ')';
        }

        public void w() {
        }

        public Object x() {
            return this.f4521h;
        }

        public b0 y(o.b bVar) {
            return c4.m.f3144a;
        }
    }

    public c(l<? super E, q> lVar) {
        this.f4519b = lVar;
    }

    private final int b() {
        m mVar = this.f4520c;
        int i5 = 0;
        for (o oVar = (o) mVar.m(); !k.a(oVar, mVar); oVar = oVar.n()) {
            if (oVar instanceof o) {
                i5++;
            }
        }
        return i5;
    }

    private final String f() {
        String str;
        o n5 = this.f4520c.n();
        if (n5 == this.f4520c) {
            return "EmptyQueue";
        }
        if (n5 instanceof j) {
            str = n5.toString();
        } else if (n5 instanceof o) {
            str = "ReceiveQueued";
        } else if (n5 instanceof s) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + n5;
        }
        o o5 = this.f4520c.o();
        if (o5 == n5) {
            return str;
        }
        String str2 = str + ",queueSize=" + b();
        if (!(o5 instanceof j)) {
            return str2;
        }
        return str2 + ",closedForSend=" + o5;
    }

    private final void g(j<?> jVar) {
        Object b5 = j.b((Object) null, 1, (g) null);
        while (true) {
            o o5 = jVar.o();
            o oVar = o5 instanceof o ? (o) o5 : null;
            if (oVar == null) {
                break;
            } else if (!oVar.s()) {
                oVar.p();
            } else {
                b5 = j.c(b5, oVar);
            }
        }
        if (b5 != null) {
            if (!(b5 instanceof ArrayList)) {
                ((o) b5).x(jVar);
            } else {
                ArrayList arrayList = (ArrayList) b5;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    ((o) arrayList.get(size)).x(jVar);
                }
            }
        }
        j(jVar);
    }

    private final Throwable h(j<?> jVar) {
        g(jVar);
        return jVar.D();
    }

    public final Object a(E e5) {
        j<?> jVar;
        i.b bVar;
        Object i5 = i(e5);
        if (i5 == b.f4513b) {
            return i.f4535a.c(q.f5904a);
        }
        if (i5 == b.f4514c) {
            jVar = d();
            if (jVar == null) {
                return i.f4535a.b();
            }
            bVar = i.f4535a;
        } else if (i5 instanceof j) {
            bVar = i.f4535a;
            jVar = (j) i5;
        } else {
            throw new IllegalStateException(("trySend returned " + i5).toString());
        }
        return bVar.a(h(jVar));
    }

    /* access modifiers changed from: protected */
    public String c() {
        return BuildConfig.FLAVOR;
    }

    /* access modifiers changed from: protected */
    public final j<?> d() {
        o o5 = this.f4520c.o();
        j<?> jVar = o5 instanceof j ? (j) o5 : null;
        if (jVar == null) {
            return null;
        }
        g(jVar);
        return jVar;
    }

    /* access modifiers changed from: protected */
    public final m e() {
        return this.f4520c;
    }

    /* access modifiers changed from: protected */
    public Object i(E e5) {
        q l5;
        do {
            l5 = l();
            if (l5 == null) {
                return b.f4514c;
            }
        } while (l5.d(e5, (o.b) null) == null);
        l5.a(e5);
        return l5.c();
    }

    /* access modifiers changed from: protected */
    public void j(o oVar) {
    }

    /* access modifiers changed from: protected */
    public final q<?> k(E e5) {
        o o5;
        m mVar = this.f4520c;
        a aVar = new a(e5);
        do {
            o5 = mVar.o();
            if (o5 instanceof q) {
                return (q) o5;
            }
        } while (!o5.h(aVar, mVar));
        return null;
    }

    /* access modifiers changed from: protected */
    public q<E> l() {
        o oVar;
        o t5;
        m mVar = this.f4520c;
        while (true) {
            oVar = (o) mVar.m();
            if (oVar != mVar && (oVar instanceof q)) {
                if (((((q) oVar) instanceof j) && !oVar.r()) || (t5 = oVar.t()) == null) {
                    break;
                }
                t5.q();
            }
        }
        oVar = null;
        return (q) oVar;
    }

    /* access modifiers changed from: protected */
    public final s m() {
        o oVar;
        o t5;
        m mVar = this.f4520c;
        while (true) {
            oVar = (o) mVar.m();
            if (oVar != mVar && (oVar instanceof s)) {
                if (((((s) oVar) instanceof j) && !oVar.r()) || (t5 = oVar.t()) == null) {
                    break;
                }
                t5.q();
            }
        }
        oVar = null;
        return (s) oVar;
    }

    public String toString() {
        return k0.a(this) + '@' + k0.b(this) + '{' + f() + '}' + c();
    }
}
