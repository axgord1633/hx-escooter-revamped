package w;

import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import kotlin.jvm.internal.k;

public final class b implements b0.b {

    /* renamed from: a  reason: collision with root package name */
    private final f<?>[] f7284a;

    public b(f<?>... fVarArr) {
        k.e(fVarArr, "initializers");
        this.f7284a = fVarArr;
    }

    public /* synthetic */ a0 a(Class cls) {
        return c0.a(this, cls);
    }

    public <T extends a0> T b(Class<T> cls, a aVar) {
        k.e(cls, "modelClass");
        k.e(aVar, "extras");
        T t5 = null;
        for (f<?> fVar : this.f7284a) {
            if (k.a(fVar.a(), cls)) {
                T invoke = fVar.b().invoke(aVar);
                t5 = invoke instanceof a0 ? (a0) invoke : null;
            }
        }
        if (t5 != null) {
            return t5;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }
}
