package com.google.protobuf;

abstract class p1<T, B> {
    p1() {
    }

    /* access modifiers changed from: package-private */
    public abstract void a(B b5, int i5, int i6);

    /* access modifiers changed from: package-private */
    public abstract void b(B b5, int i5, long j5);

    /* access modifiers changed from: package-private */
    public abstract void c(B b5, int i5, T t5);

    /* access modifiers changed from: package-private */
    public abstract void d(B b5, int i5, i iVar);

    /* access modifiers changed from: package-private */
    public abstract void e(B b5, int i5, long j5);

    /* access modifiers changed from: package-private */
    public abstract B f(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T g(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int h(T t5);

    /* access modifiers changed from: package-private */
    public abstract int i(T t5);

    /* access modifiers changed from: package-private */
    public abstract void j(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T k(T t5, T t6);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000d, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(B r3, com.google.protobuf.h1 r4) {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r4.t()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x000f
            boolean r0 = r2.m(r3, r4)
            if (r0 != 0) goto L_0x0000
        L_0x000f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.p1.l(java.lang.Object, com.google.protobuf.h1):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean m(B b5, h1 h1Var) {
        int c5 = h1Var.c();
        int a5 = v1.a(c5);
        int b6 = v1.b(c5);
        if (b6 == 0) {
            e(b5, a5, h1Var.L());
            return true;
        } else if (b6 == 1) {
            b(b5, a5, h1Var.f());
            return true;
        } else if (b6 == 2) {
            d(b5, a5, h1Var.B());
            return true;
        } else if (b6 == 3) {
            Object n5 = n();
            int c6 = v1.c(a5, 4);
            l(n5, h1Var);
            if (c6 == h1Var.c()) {
                c(b5, a5, r(n5));
                return true;
            }
            throw c0.b();
        } else if (b6 == 4) {
            return false;
        } else {
            if (b6 == 5) {
                a(b5, a5, h1Var.p());
                return true;
            }
            throw c0.e();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract B n();

    /* access modifiers changed from: package-private */
    public abstract void o(Object obj, B b5);

    /* access modifiers changed from: package-private */
    public abstract void p(Object obj, T t5);

    /* access modifiers changed from: package-private */
    public abstract boolean q(h1 h1Var);

    /* access modifiers changed from: package-private */
    public abstract T r(B b5);

    /* access modifiers changed from: package-private */
    public abstract void s(T t5, w1 w1Var);

    /* access modifiers changed from: package-private */
    public abstract void t(T t5, w1 w1Var);
}
