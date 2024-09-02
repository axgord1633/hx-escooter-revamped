package o1;

import r2.h;

class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f6116a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f6117b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f6118c;

    /* renamed from: d  reason: collision with root package name */
    private int f6119d;

    /* renamed from: o1.a$a  reason: collision with other inner class name */
    public interface C0093a<T> extends h<T> {
        boolean test(T t5);
    }

    a(int i5) {
        this.f6116a = i5;
        Object[] objArr = new Object[(i5 + 1)];
        this.f6117b = objArr;
        this.f6118c = objArr;
    }

    /* access modifiers changed from: package-private */
    public void a(d<? super T> dVar) {
        int i5 = this.f6116a;
        for (Object[] objArr = this.f6117b; objArr != null; objArr = objArr[i5]) {
            for (int i6 = 0; i6 < i5; i6++) {
                Object[] objArr2 = objArr[i6];
                if (objArr2 == null) {
                    break;
                }
                dVar.accept(objArr2);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(T r4) {
        /*
            r3 = this;
            int r0 = r3.f6116a
            int r1 = r3.f6119d
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f6118c
            r2[r0] = r1
            r3.f6118c = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f6118c
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f6119d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.a.b(java.lang.Object):void");
    }

    /* access modifiers changed from: package-private */
    public void c(C0093a<? super T> aVar) {
        int i5 = this.f6116a;
        for (Object[] objArr = this.f6117b; objArr != null; objArr = objArr[i5]) {
            for (int i6 = 0; i6 < i5; i6++) {
                Object[] objArr2 = objArr[i6];
                if (objArr2 == null || aVar.test(objArr2)) {
                    break;
                }
            }
        }
    }
}
