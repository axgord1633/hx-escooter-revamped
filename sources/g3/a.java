package g3;

import m2.p;
import r2.h;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f4739a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f4740b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f4741c;

    /* renamed from: d  reason: collision with root package name */
    int f4742d;

    /* renamed from: g3.a$a  reason: collision with other inner class name */
    public interface C0080a<T> extends h<T> {
        boolean test(T t5);
    }

    public a(int i5) {
        this.f4739a = i5;
        Object[] objArr = new Object[(i5 + 1)];
        this.f4740b = objArr;
        this.f4741c = objArr;
    }

    public <U> boolean a(p<? super U> pVar) {
        Object[] objArr = this.f4740b;
        int i5 = this.f4739a;
        while (true) {
            int i6 = 0;
            if (objArr == null) {
                return false;
            }
            while (i6 < i5) {
                Object[] objArr2 = objArr[i6];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (h.f(objArr2, pVar)) {
                    return true;
                } else {
                    i6++;
                }
            }
            objArr = objArr[i5];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(T r4) {
        /*
            r3 = this;
            int r0 = r3.f4739a
            int r1 = r3.f4742d
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f4741c
            r2[r0] = r1
            r3.f4741c = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f4741c
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f4742d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.a.b(java.lang.Object):void");
    }

    public void c(C0080a<? super T> aVar) {
        int i5 = this.f4739a;
        for (Object[] objArr = this.f4740b; objArr != null; objArr = objArr[i5]) {
            int i6 = 0;
            while (i6 < i5) {
                Object[] objArr2 = objArr[i6];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!aVar.test(objArr2)) {
                    i6++;
                } else {
                    return;
                }
            }
        }
    }

    public void d(T t5) {
        this.f4740b[0] = t5;
    }
}
