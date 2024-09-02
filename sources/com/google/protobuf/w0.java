package com.google.protobuf;

import com.google.protobuf.e0;
import com.google.protobuf.v;
import com.google.protobuf.v1;
import java.util.Iterator;
import java.util.Map;

final class w0<T> implements i1<T> {

    /* renamed from: a  reason: collision with root package name */
    private final s0 f3795a;

    /* renamed from: b  reason: collision with root package name */
    private final p1<?, ?> f3796b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3797c;

    /* renamed from: d  reason: collision with root package name */
    private final r<?> f3798d;

    private w0(p1<?, ?> p1Var, r<?> rVar, s0 s0Var) {
        this.f3796b = p1Var;
        this.f3797c = rVar.e(s0Var);
        this.f3798d = rVar;
        this.f3795a = s0Var;
    }

    private <UT, UB> int k(p1<UT, UB> p1Var, T t5) {
        return p1Var.i(p1Var.g(t5));
    }

    private <UT, UB, ET extends v.b<ET>> void l(p1<UT, UB> p1Var, r<ET> rVar, T t5, h1 h1Var, q qVar) {
        UB f5 = p1Var.f(t5);
        v<ET> d5 = rVar.d(t5);
        do {
            try {
                if (h1Var.t() == Integer.MAX_VALUE) {
                    p1Var.o(t5, f5);
                    return;
                }
            } finally {
                p1Var.o(t5, f5);
            }
        } while (n(h1Var, qVar, rVar, d5, p1Var, f5));
    }

    static <T> w0<T> m(p1<?, ?> p1Var, r<?> rVar, s0 s0Var) {
        return new w0<>(p1Var, rVar, s0Var);
    }

    private <UT, UB, ET extends v.b<ET>> boolean n(h1 h1Var, q qVar, r<ET> rVar, v<ET> vVar, p1<UT, UB> p1Var, UB ub) {
        int c5 = h1Var.c();
        if (c5 == v1.f3718a) {
            int i5 = 0;
            Object obj = null;
            i iVar = null;
            while (h1Var.t() != Integer.MAX_VALUE) {
                int c6 = h1Var.c();
                if (c6 == v1.f3720c) {
                    i5 = h1Var.D();
                    obj = rVar.b(qVar, this.f3795a, i5);
                } else if (c6 == v1.f3721d) {
                    if (obj != null) {
                        rVar.h(h1Var, obj, qVar, vVar);
                    } else {
                        iVar = h1Var.B();
                    }
                } else if (!h1Var.F()) {
                    break;
                }
            }
            if (h1Var.c() == v1.f3719b) {
                if (iVar != null) {
                    if (obj != null) {
                        rVar.i(iVar, obj, qVar, vVar);
                    } else {
                        p1Var.d(ub, i5, iVar);
                    }
                }
                return true;
            }
            throw c0.b();
        } else if (v1.b(c5) != 2) {
            return h1Var.F();
        } else {
            Object b5 = rVar.b(qVar, this.f3795a, v1.a(c5));
            if (b5 == null) {
                return p1Var.m(ub, h1Var);
            }
            rVar.h(h1Var, b5, qVar, vVar);
            return true;
        }
    }

    private <UT, UB> void o(p1<UT, UB> p1Var, T t5, w1 w1Var) {
        p1Var.s(p1Var.g(t5), w1Var);
    }

    public void a(T t5, T t6) {
        k1.G(this.f3796b, t5, t6);
        if (this.f3797c) {
            k1.E(this.f3798d, t5, t6);
        }
    }

    public void b(T t5, w1 w1Var) {
        Iterator<Map.Entry<?, Object>> r5 = this.f3798d.c(t5).r();
        while (r5.hasNext()) {
            Map.Entry next = r5.next();
            v.b bVar = (v.b) next.getKey();
            if (bVar.j() != v1.c.MESSAGE || bVar.b() || bVar.k()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            w1Var.h(bVar.a(), next instanceof e0.b ? ((e0.b) next).a().e() : next.getValue());
        }
        o(this.f3796b, t5, w1Var);
    }

    public void c(T t5) {
        this.f3796b.j(t5);
        this.f3798d.f(t5);
    }

    public final boolean d(T t5) {
        return this.f3798d.c(t5).o();
    }

    public void e(T t5, h1 h1Var, q qVar) {
        l(this.f3796b, this.f3798d, t5, h1Var, qVar);
    }

    public boolean f(T t5, T t6) {
        if (!this.f3796b.g(t5).equals(this.f3796b.g(t6))) {
            return false;
        }
        if (this.f3797c) {
            return this.f3798d.c(t5).equals(this.f3798d.c(t6));
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.google.protobuf.z$e} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(T r11, byte[] r12, int r13, int r14, com.google.protobuf.e.b r15) {
        /*
            r10 = this;
            r0 = r11
            com.google.protobuf.z r0 = (com.google.protobuf.z) r0
            com.google.protobuf.q1 r1 = r0.unknownFields
            com.google.protobuf.q1 r2 = com.google.protobuf.q1.c()
            if (r1 != r2) goto L_0x0011
            com.google.protobuf.q1 r1 = com.google.protobuf.q1.n()
            r0.unknownFields = r1
        L_0x0011:
            com.google.protobuf.z$c r11 = (com.google.protobuf.z.c) r11
            com.google.protobuf.v r11 = r11.a()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00d7
            int r4 = com.google.protobuf.e.I(r12, r13, r15)
            int r13 = r15.f3498a
            int r3 = com.google.protobuf.v1.f3718a
            r5 = 2
            if (r13 == r3) goto L_0x006b
            int r3 = com.google.protobuf.v1.b(r13)
            if (r3 != r5) goto L_0x0066
            com.google.protobuf.r<?> r2 = r10.f3798d
            com.google.protobuf.q r3 = r15.f3501d
            com.google.protobuf.s0 r5 = r10.f3795a
            int r6 = com.google.protobuf.v1.a(r13)
            java.lang.Object r2 = r2.b(r3, r5, r6)
            r8 = r2
            com.google.protobuf.z$e r8 = (com.google.protobuf.z.e) r8
            if (r8 == 0) goto L_0x005b
            com.google.protobuf.e1 r13 = com.google.protobuf.e1.a()
            com.google.protobuf.s0 r2 = r8.c()
            java.lang.Class r2 = r2.getClass()
            com.google.protobuf.i1 r13 = r13.d(r2)
            int r13 = com.google.protobuf.e.p(r13, r12, r4, r14, r15)
            com.google.protobuf.z$d r2 = r8.f3816d
            java.lang.Object r3 = r15.f3500c
            r11.w(r2, r3)
            goto L_0x0064
        L_0x005b:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.protobuf.e.G(r2, r3, r4, r5, r6, r7)
        L_0x0064:
            r2 = r8
            goto L_0x0019
        L_0x0066:
            int r13 = com.google.protobuf.e.N(r13, r12, r4, r14, r15)
            goto L_0x0019
        L_0x006b:
            r13 = 0
            r3 = r0
        L_0x006d:
            if (r4 >= r14) goto L_0x00cb
            int r4 = com.google.protobuf.e.I(r12, r4, r15)
            int r6 = r15.f3498a
            int r7 = com.google.protobuf.v1.a(r6)
            int r8 = com.google.protobuf.v1.b(r6)
            if (r7 == r5) goto L_0x00ac
            r9 = 3
            if (r7 == r9) goto L_0x0083
            goto L_0x00c1
        L_0x0083:
            if (r2 == 0) goto L_0x00a1
            com.google.protobuf.e1 r6 = com.google.protobuf.e1.a()
            com.google.protobuf.s0 r7 = r2.c()
            java.lang.Class r7 = r7.getClass()
            com.google.protobuf.i1 r6 = r6.d(r7)
            int r4 = com.google.protobuf.e.p(r6, r12, r4, r14, r15)
            com.google.protobuf.z$d r6 = r2.f3816d
            java.lang.Object r7 = r15.f3500c
            r11.w(r6, r7)
            goto L_0x006d
        L_0x00a1:
            if (r8 != r5) goto L_0x00c1
            int r4 = com.google.protobuf.e.b(r12, r4, r15)
            java.lang.Object r3 = r15.f3500c
            com.google.protobuf.i r3 = (com.google.protobuf.i) r3
            goto L_0x006d
        L_0x00ac:
            if (r8 != 0) goto L_0x00c1
            int r4 = com.google.protobuf.e.I(r12, r4, r15)
            int r13 = r15.f3498a
            com.google.protobuf.r<?> r2 = r10.f3798d
            com.google.protobuf.q r6 = r15.f3501d
            com.google.protobuf.s0 r7 = r10.f3795a
            java.lang.Object r2 = r2.b(r6, r7, r13)
            com.google.protobuf.z$e r2 = (com.google.protobuf.z.e) r2
            goto L_0x006d
        L_0x00c1:
            int r7 = com.google.protobuf.v1.f3719b
            if (r6 != r7) goto L_0x00c6
            goto L_0x00cb
        L_0x00c6:
            int r4 = com.google.protobuf.e.N(r6, r12, r4, r14, r15)
            goto L_0x006d
        L_0x00cb:
            if (r3 == 0) goto L_0x00d4
            int r13 = com.google.protobuf.v1.c(r13, r5)
            r1.q(r13, r3)
        L_0x00d4:
            r13 = r4
            goto L_0x0019
        L_0x00d7:
            if (r13 != r14) goto L_0x00da
            return
        L_0x00da:
            com.google.protobuf.c0 r11 = com.google.protobuf.c0.h()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.w0.g(java.lang.Object, byte[], int, int, com.google.protobuf.e$b):void");
    }

    public int h(T t5) {
        int k5 = k(this.f3796b, t5) + 0;
        return this.f3797c ? k5 + this.f3798d.c(t5).j() : k5;
    }

    public T i() {
        return this.f3795a.newBuilderForType().buildPartial();
    }

    public int j(T t5) {
        int hashCode = this.f3796b.g(t5).hashCode();
        return this.f3797c ? (hashCode * 53) + this.f3798d.c(t5).hashCode() : hashCode;
    }
}
