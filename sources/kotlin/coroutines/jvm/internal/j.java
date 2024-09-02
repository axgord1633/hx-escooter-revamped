package kotlin.coroutines.jvm.internal;

import o3.d;
import o3.g;
import o3.h;

public abstract class j extends a {
    public j(d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.getContext() == h.f6161e)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    public g getContext() {
        return h.f6161e;
    }
}
