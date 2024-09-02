package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.k;
import o3.e;
import o3.g;

public abstract class d extends a {
    private final g _context;
    private transient o3.d<Object> intercepted;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(o3.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }

    public d(o3.d<Object> dVar, g gVar) {
        super(dVar);
        this._context = gVar;
    }

    public g getContext() {
        g gVar = this._context;
        k.b(gVar);
        return gVar;
    }

    public final o3.d<Object> intercepted() {
        o3.d<Object> dVar = this.intercepted;
        if (dVar == null) {
            e eVar = (e) getContext().d(e.f6158d);
            if (eVar == null || (dVar = eVar.C(this)) == null) {
                dVar = this;
            }
            this.intercepted = dVar;
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
        o3.d<Object> dVar = this.intercepted;
        if (!(dVar == null || dVar == this)) {
            g.b d5 = getContext().d(e.f6158d);
            k.b(d5);
            ((e) d5).v(dVar);
        }
        this.intercepted = c.f5550e;
    }
}
