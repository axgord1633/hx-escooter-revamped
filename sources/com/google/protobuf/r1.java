package com.google.protobuf;

class r1 extends p1<q1, q1> {
    r1() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public q1 g(Object obj) {
        return ((z) obj).unknownFields;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public int h(q1 q1Var) {
        return q1Var.d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public int i(q1 q1Var) {
        return q1Var.e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public q1 k(q1 q1Var, q1 q1Var2) {
        return q1Var2.equals(q1.c()) ? q1Var : q1.m(q1Var, q1Var2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public q1 n() {
        return q1.n();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public void o(Object obj, q1 q1Var) {
        p(obj, q1Var);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public void p(Object obj, q1 q1Var) {
        ((z) obj).unknownFields = q1Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public q1 r(q1 q1Var) {
        q1Var.h();
        return q1Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public void s(q1 q1Var, w1 w1Var) {
        q1Var.s(w1Var);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public void t(q1 q1Var, w1 w1Var) {
        q1Var.u(w1Var);
    }

    /* access modifiers changed from: package-private */
    public void j(Object obj) {
        g(obj).h();
    }

    /* access modifiers changed from: package-private */
    public boolean q(h1 h1Var) {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void a(q1 q1Var, int i5, int i6) {
        q1Var.q(v1.c(i5, 5), Integer.valueOf(i6));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void b(q1 q1Var, int i5, long j5) {
        q1Var.q(v1.c(i5, 1), Long.valueOf(j5));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void c(q1 q1Var, int i5, q1 q1Var2) {
        q1Var.q(v1.c(i5, 3), q1Var2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void d(q1 q1Var, int i5, i iVar) {
        q1Var.q(v1.c(i5, 2), iVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void e(q1 q1Var, int i5, long j5) {
        q1Var.q(v1.c(i5, 0), Long.valueOf(j5));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public q1 f(Object obj) {
        q1 A = g(obj);
        if (A != q1.c()) {
            return A;
        }
        q1 n5 = q1.n();
        p(obj, n5);
        return n5;
    }
}
