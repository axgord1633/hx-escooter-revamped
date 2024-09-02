package androidx.lifecycle;

import androidx.lifecycle.b;
import androidx.lifecycle.f;

@Deprecated
class ReflectiveGenericLifecycleObserver implements h {

    /* renamed from: e  reason: collision with root package name */
    private final Object f2544e;

    /* renamed from: f  reason: collision with root package name */
    private final b.a f2545f;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2544e = obj;
        this.f2545f = b.f2554c.c(obj.getClass());
    }

    public void a(j jVar, f.a aVar) {
        this.f2545f.a(jVar, aVar, this.f2544e);
    }
}
