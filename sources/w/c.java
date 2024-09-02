package w;

import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.k;
import u3.a;
import v3.l;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<f<?>> f7285a = new ArrayList();

    public final <T extends a0> void a(z3.c<T> cVar, l<? super a, ? extends T> lVar) {
        k.e(cVar, "clazz");
        k.e(lVar, "initializer");
        this.f7285a.add(new f(a.a(cVar), lVar));
    }

    public final b0.b b() {
        f[] fVarArr = (f[]) this.f7285a.toArray(new f[0]);
        return new b((f[]) Arrays.copyOf(fVarArr, fVarArr.length));
    }
}
