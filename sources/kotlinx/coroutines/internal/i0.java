package kotlinx.coroutines.internal;

import c4.b2;
import kotlin.jvm.internal.k;
import o3.g;

final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public final g f5604a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f5605b;

    /* renamed from: c  reason: collision with root package name */
    private final b2<Object>[] f5606c;

    /* renamed from: d  reason: collision with root package name */
    private int f5607d;

    public i0(g gVar, int i5) {
        this.f5604a = gVar;
        this.f5605b = new Object[i5];
        this.f5606c = new b2[i5];
    }

    public final void a(b2<?> b2Var, Object obj) {
        Object[] objArr = this.f5605b;
        int i5 = this.f5607d;
        objArr[i5] = obj;
        b2<Object>[] b2VarArr = this.f5606c;
        this.f5607d = i5 + 1;
        b2VarArr[i5] = b2Var;
    }

    public final void b(g gVar) {
        int length = this.f5606c.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                b2<Object> b2Var = this.f5606c[length];
                k.b(b2Var);
                b2Var.g(gVar, this.f5605b[length]);
                if (i5 >= 0) {
                    length = i5;
                } else {
                    return;
                }
            }
        }
    }
}
