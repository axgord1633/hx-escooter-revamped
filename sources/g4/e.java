package g4;

import c4.l1;
import kotlin.jvm.internal.l;
import kotlinx.coroutines.internal.z;
import o3.g;
import v3.p;

public final class e {

    static final class a extends l implements p<Integer, g.b, Integer> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c<?> f4769e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c<?> cVar) {
            super(2);
            this.f4769e = cVar;
        }

        public final Integer a(int i5, g.b bVar) {
            g.c key = bVar.getKey();
            g.b d5 = this.f4769e.f4762f.d(key);
            if (key != l1.f3142c) {
                return Integer.valueOf(bVar != d5 ? Integer.MIN_VALUE : i5 + 1);
            }
            l1 l1Var = (l1) d5;
            l1 b5 = e.b((l1) bVar, l1Var);
            if (b5 == l1Var) {
                if (l1Var != null) {
                    i5++;
                }
                return Integer.valueOf(i5);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b5 + ", expected child of " + l1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (g.b) obj2);
        }
    }

    public static final void a(c<?> cVar, g gVar) {
        if (((Number) gVar.q(0, new a(cVar))).intValue() != cVar.f4763g) {
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + cVar.f4762f + ",\n\t\tbut emission happened in " + gVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
        }
    }

    public static final l1 b(l1 l1Var, l1 l1Var2) {
        while (l1Var != null) {
            if (l1Var == l1Var2 || !(l1Var instanceof z)) {
                return l1Var;
            }
            l1Var = ((z) l1Var).D0();
        }
        return null;
    }
}
