package g4;

import c4.p1;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import m3.q;
import o3.g;
import o3.h;
import v3.p;

public final class c<T> extends d implements f4.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final f4.c<T> f4761e;

    /* renamed from: f  reason: collision with root package name */
    public final g f4762f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4763g;

    /* renamed from: h  reason: collision with root package name */
    private g f4764h;

    /* renamed from: i  reason: collision with root package name */
    private o3.d<? super q> f4765i;

    static final class a extends l implements p<Integer, g.b, Integer> {

        /* renamed from: e  reason: collision with root package name */
        public static final a f4766e = new a();

        a() {
            super(2);
        }

        public final Integer a(int i5, g.b bVar) {
            return Integer.valueOf(i5 + 1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (g.b) obj2);
        }
    }

    public c(f4.c<? super T> cVar, g gVar) {
        super(b.f4759e, h.f6161e);
        this.f4761e = cVar;
        this.f4762f = gVar;
        this.f4763g = ((Number) gVar.q(0, a.f4766e)).intValue();
    }

    private final void b(g gVar, g gVar2, T t5) {
        if (gVar2 instanceof a) {
            e((a) gVar2, t5);
        }
        e.a(this, gVar);
    }

    private final Object d(o3.d<? super q> dVar, T t5) {
        g context = dVar.getContext();
        p1.f(context);
        g gVar = this.f4764h;
        if (gVar != context) {
            b(context, gVar, t5);
            this.f4764h = context;
        }
        this.f4765i = dVar;
        Object invoke = d.f4767a.invoke(this.f4761e, t5, this);
        if (!k.a(invoke, d.c())) {
            this.f4765i = null;
        }
        return invoke;
    }

    private final void e(a aVar, Object obj) {
        throw new IllegalStateException(f.e("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + aVar.f4757e + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    public Object emit(T t5, o3.d<? super q> dVar) {
        try {
            Object d5 = d(dVar, t5);
            if (d5 == d.c()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return d5 == d.c() ? d5 : q.f5904a;
        } catch (Throwable th) {
            this.f4764h = new a(th, dVar.getContext());
            throw th;
        }
    }

    public e getCallerFrame() {
        o3.d<? super q> dVar = this.f4765i;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public g getContext() {
        g gVar = this.f4764h;
        return gVar == null ? h.f6161e : gVar;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public Object invokeSuspend(Object obj) {
        Throwable b5 = m3.k.b(obj);
        if (b5 != null) {
            this.f4764h = new a(b5, getContext());
        }
        o3.d<? super q> dVar = this.f4765i;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        return d.c();
    }

    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
