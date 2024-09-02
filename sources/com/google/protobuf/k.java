package com.google.protobuf;

import com.google.protobuf.l0;
import java.util.List;
import java.util.Map;

final class k implements h1 {

    /* renamed from: a  reason: collision with root package name */
    private final j f3585a;

    /* renamed from: b  reason: collision with root package name */
    private int f3586b;

    /* renamed from: c  reason: collision with root package name */
    private int f3587c;

    /* renamed from: d  reason: collision with root package name */
    private int f3588d = 0;

    private k(j jVar) {
        j jVar2 = (j) b0.b(jVar, "input");
        this.f3585a = jVar2;
        jVar2.f3552d = this;
    }

    public static k Q(j jVar) {
        k kVar = jVar.f3552d;
        return kVar != null ? kVar : new k(jVar);
    }

    private <T> T R(i1<T> i1Var, q qVar) {
        int i5 = this.f3587c;
        this.f3587c = v1.c(v1.a(this.f3586b), 4);
        try {
            T i6 = i1Var.i();
            i1Var.e(i6, this, qVar);
            i1Var.c(i6);
            if (this.f3586b == this.f3587c) {
                return i6;
            }
            throw c0.h();
        } finally {
            this.f3587c = i5;
        }
    }

    private <T> T S(i1<T> i1Var, q qVar) {
        int F = this.f3585a.F();
        j jVar = this.f3585a;
        if (jVar.f3549a < jVar.f3550b) {
            int n5 = jVar.n(F);
            T i5 = i1Var.i();
            this.f3585a.f3549a++;
            i1Var.e(i5, this, qVar);
            i1Var.c(i5);
            this.f3585a.a(0);
            j jVar2 = this.f3585a;
            jVar2.f3549a--;
            jVar2.m(n5);
            return i5;
        }
        throw c0.i();
    }

    private void U(int i5) {
        if (this.f3585a.d() != i5) {
            throw c0.m();
        }
    }

    private void V(int i5) {
        if (v1.b(this.f3586b) != i5) {
            throw c0.e();
        }
    }

    private void W(int i5) {
        if ((i5 & 3) != 0) {
            throw c0.h();
        }
    }

    private void X(int i5) {
        if ((i5 & 7) != 0) {
            throw c0.h();
        }
    }

    public <T> T A(i1<T> i1Var, q qVar) {
        V(3);
        return R(i1Var, qVar);
    }

    public i B() {
        V(2);
        return this.f3585a.p();
    }

    public void C(List<Float> list) {
        int E;
        int E2;
        if (list instanceof x) {
            x xVar = (x) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 2) {
                int F = this.f3585a.F();
                W(F);
                int d5 = this.f3585a.d() + F;
                do {
                    xVar.i(this.f3585a.u());
                } while (this.f3585a.d() < d5);
            } else if (b5 == 5) {
                do {
                    xVar.i(this.f3585a.u());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 2) {
                int F2 = this.f3585a.F();
                W(F2);
                int d6 = this.f3585a.d() + F2;
                do {
                    list.add(Float.valueOf(this.f3585a.u()));
                } while (this.f3585a.d() < d6);
            } else if (b6 == 5) {
                do {
                    list.add(Float.valueOf(this.f3585a.u()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
            } else {
                throw c0.e();
            }
        }
    }

    public int D() {
        V(0);
        return this.f3585a.F();
    }

    public int E() {
        V(0);
        return this.f3585a.v();
    }

    public boolean F() {
        int i5;
        if (this.f3585a.e() || (i5 = this.f3586b) == this.f3587c) {
            return false;
        }
        return this.f3585a.H(i5);
    }

    public int G() {
        V(5);
        return this.f3585a.y();
    }

    public void H(List<i> list) {
        int E;
        if (v1.b(this.f3586b) == 2) {
            do {
                list.add(B());
                if (!this.f3585a.e()) {
                    E = this.f3585a.E();
                } else {
                    return;
                }
            } while (E == this.f3586b);
            this.f3588d = E;
            return;
        }
        throw c0.e();
    }

    public void I(List<Double> list) {
        int E;
        int E2;
        if (list instanceof n) {
            n nVar = (n) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 1) {
                do {
                    nVar.i(this.f3585a.q());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
            } else if (b5 == 2) {
                int F = this.f3585a.F();
                X(F);
                int d5 = this.f3585a.d() + F;
                do {
                    nVar.i(this.f3585a.q());
                } while (this.f3585a.d() < d5);
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 1) {
                do {
                    list.add(Double.valueOf(this.f3585a.q()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
            } else if (b6 == 2) {
                int F2 = this.f3585a.F();
                X(F2);
                int d6 = this.f3585a.d() + F2;
                do {
                    list.add(Double.valueOf(this.f3585a.q()));
                } while (this.f3585a.d() < d6);
            } else {
                throw c0.e();
            }
        }
    }

    public void J(List<Long> list) {
        int i5;
        int E;
        int E2;
        if (list instanceof j0) {
            j0 j0Var = (j0) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 0) {
                do {
                    j0Var.l(this.f3585a.w());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
                return;
            } else if (b5 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    j0Var.l(this.f3585a.w());
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 0) {
                do {
                    list.add(Long.valueOf(this.f3585a.w()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
                return;
            } else if (b6 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    list.add(Long.valueOf(this.f3585a.w()));
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        }
        U(i5);
    }

    public void K(List<Long> list) {
        int E;
        int E2;
        if (list instanceof j0) {
            j0 j0Var = (j0) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 1) {
                do {
                    j0Var.l(this.f3585a.z());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
            } else if (b5 == 2) {
                int F = this.f3585a.F();
                X(F);
                int d5 = this.f3585a.d() + F;
                do {
                    j0Var.l(this.f3585a.z());
                } while (this.f3585a.d() < d5);
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 1) {
                do {
                    list.add(Long.valueOf(this.f3585a.z()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
            } else if (b6 == 2) {
                int F2 = this.f3585a.F();
                X(F2);
                int d6 = this.f3585a.d() + F2;
                do {
                    list.add(Long.valueOf(this.f3585a.z()));
                } while (this.f3585a.d() < d6);
            } else {
                throw c0.e();
            }
        }
    }

    public long L() {
        V(0);
        return this.f3585a.w();
    }

    public String M() {
        V(2);
        return this.f3585a.D();
    }

    public void N(List<Long> list) {
        int E;
        int E2;
        if (list instanceof j0) {
            j0 j0Var = (j0) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 1) {
                do {
                    j0Var.l(this.f3585a.t());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
            } else if (b5 == 2) {
                int F = this.f3585a.F();
                X(F);
                int d5 = this.f3585a.d() + F;
                do {
                    j0Var.l(this.f3585a.t());
                } while (this.f3585a.d() < d5);
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 1) {
                do {
                    list.add(Long.valueOf(this.f3585a.t()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
            } else if (b6 == 2) {
                int F2 = this.f3585a.F();
                X(F2);
                int d6 = this.f3585a.d() + F2;
                do {
                    list.add(Long.valueOf(this.f3585a.t()));
                } while (this.f3585a.d() < d6);
            } else {
                throw c0.e();
            }
        }
    }

    public void O(List<Integer> list) {
        int i5;
        int E;
        int E2;
        if (list instanceof a0) {
            a0 a0Var = (a0) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 0) {
                do {
                    a0Var.i(this.f3585a.v());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
                return;
            } else if (b5 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    a0Var.i(this.f3585a.v());
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3585a.v()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
                return;
            } else if (b6 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    list.add(Integer.valueOf(this.f3585a.v()));
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        }
        U(i5);
    }

    public void P(List<Integer> list) {
        int i5;
        int E;
        int E2;
        if (list instanceof a0) {
            a0 a0Var = (a0) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 0) {
                do {
                    a0Var.i(this.f3585a.r());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
                return;
            } else if (b5 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    a0Var.i(this.f3585a.r());
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3585a.r()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
                return;
            } else if (b6 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    list.add(Integer.valueOf(this.f3585a.r()));
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        }
        U(i5);
    }

    public void T(List<String> list, boolean z4) {
        int E;
        int E2;
        if (v1.b(this.f3586b) != 2) {
            throw c0.e();
        } else if (!(list instanceof h0) || z4) {
            do {
                list.add(z4 ? M() : o());
                if (!this.f3585a.e()) {
                    E = this.f3585a.E();
                } else {
                    return;
                }
            } while (E == this.f3586b);
            this.f3588d = E;
        } else {
            h0 h0Var = (h0) list;
            do {
                h0Var.d(B());
                if (!this.f3585a.e()) {
                    E2 = this.f3585a.E();
                } else {
                    return;
                }
            } while (E2 == this.f3586b);
            this.f3588d = E2;
        }
    }

    public void a(List<Integer> list) {
        int i5;
        int E;
        int E2;
        if (list instanceof a0) {
            a0 a0Var = (a0) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 0) {
                do {
                    a0Var.i(this.f3585a.A());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
                return;
            } else if (b5 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    a0Var.i(this.f3585a.A());
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3585a.A()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
                return;
            } else if (b6 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    list.add(Integer.valueOf(this.f3585a.A()));
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        }
        U(i5);
    }

    public int b() {
        V(0);
        return this.f3585a.r();
    }

    public int c() {
        return this.f3586b;
    }

    public long d() {
        V(0);
        return this.f3585a.G();
    }

    public void e(List<Integer> list) {
        int E;
        int E2;
        if (list instanceof a0) {
            a0 a0Var = (a0) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 2) {
                int F = this.f3585a.F();
                W(F);
                int d5 = this.f3585a.d() + F;
                do {
                    a0Var.i(this.f3585a.s());
                } while (this.f3585a.d() < d5);
            } else if (b5 == 5) {
                do {
                    a0Var.i(this.f3585a.s());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 2) {
                int F2 = this.f3585a.F();
                W(F2);
                int d6 = this.f3585a.d() + F2;
                do {
                    list.add(Integer.valueOf(this.f3585a.s()));
                } while (this.f3585a.d() < d6);
            } else if (b6 == 5) {
                do {
                    list.add(Integer.valueOf(this.f3585a.s()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
            } else {
                throw c0.e();
            }
        }
    }

    public long f() {
        V(1);
        return this.f3585a.t();
    }

    public void g(List<Integer> list) {
        int E;
        int E2;
        if (list instanceof a0) {
            a0 a0Var = (a0) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 2) {
                int F = this.f3585a.F();
                W(F);
                int d5 = this.f3585a.d() + F;
                do {
                    a0Var.i(this.f3585a.y());
                } while (this.f3585a.d() < d5);
            } else if (b5 == 5) {
                do {
                    a0Var.i(this.f3585a.y());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 2) {
                int F2 = this.f3585a.F();
                W(F2);
                int d6 = this.f3585a.d() + F2;
                do {
                    list.add(Integer.valueOf(this.f3585a.y()));
                } while (this.f3585a.d() < d6);
            } else if (b6 == 5) {
                do {
                    list.add(Integer.valueOf(this.f3585a.y()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
            } else {
                throw c0.e();
            }
        }
    }

    public int h() {
        V(0);
        return this.f3585a.A();
    }

    public void i(List<Long> list) {
        int i5;
        int E;
        int E2;
        if (list instanceof j0) {
            j0 j0Var = (j0) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 0) {
                do {
                    j0Var.l(this.f3585a.B());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
                return;
            } else if (b5 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    j0Var.l(this.f3585a.B());
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 0) {
                do {
                    list.add(Long.valueOf(this.f3585a.B()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
                return;
            } else if (b6 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    list.add(Long.valueOf(this.f3585a.B()));
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        }
        U(i5);
    }

    public <T> void j(List<T> list, i1<T> i1Var, q qVar) {
        int E;
        if (v1.b(this.f3586b) == 3) {
            int i5 = this.f3586b;
            do {
                list.add(R(i1Var, qVar));
                if (!this.f3585a.e() && this.f3588d == 0) {
                    E = this.f3585a.E();
                } else {
                    return;
                }
            } while (E == i5);
            this.f3588d = E;
            return;
        }
        throw c0.e();
    }

    public long k() {
        V(0);
        return this.f3585a.B();
    }

    public void l(List<Integer> list) {
        int i5;
        int E;
        int E2;
        if (list instanceof a0) {
            a0 a0Var = (a0) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 0) {
                do {
                    a0Var.i(this.f3585a.F());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
                return;
            } else if (b5 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    a0Var.i(this.f3585a.F());
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3585a.F()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
                return;
            } else if (b6 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    list.add(Integer.valueOf(this.f3585a.F()));
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        }
        U(i5);
    }

    public <T> T m(Class<T> cls, q qVar) {
        V(2);
        return S(e1.a().d(cls), qVar);
    }

    public void n(List<Boolean> list) {
        int i5;
        int E;
        int E2;
        if (list instanceof g) {
            g gVar = (g) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 0) {
                do {
                    gVar.l(this.f3585a.o());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
                return;
            } else if (b5 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    gVar.l(this.f3585a.o());
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f3585a.o()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
                return;
            } else if (b6 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    list.add(Boolean.valueOf(this.f3585a.o()));
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        }
        U(i5);
    }

    public String o() {
        V(2);
        return this.f3585a.C();
    }

    public int p() {
        V(5);
        return this.f3585a.s();
    }

    public <T> T q(Class<T> cls, q qVar) {
        V(3);
        return R(e1.a().d(cls), qVar);
    }

    public boolean r() {
        V(0);
        return this.f3585a.o();
    }

    public double readDouble() {
        V(1);
        return this.f3585a.q();
    }

    public float readFloat() {
        V(5);
        return this.f3585a.u();
    }

    public <T> void s(List<T> list, i1<T> i1Var, q qVar) {
        int E;
        if (v1.b(this.f3586b) == 2) {
            int i5 = this.f3586b;
            do {
                list.add(S(i1Var, qVar));
                if (!this.f3585a.e() && this.f3588d == 0) {
                    E = this.f3585a.E();
                } else {
                    return;
                }
            } while (E == i5);
            this.f3588d = E;
            return;
        }
        throw c0.e();
    }

    public int t() {
        int i5 = this.f3588d;
        if (i5 != 0) {
            this.f3586b = i5;
            this.f3588d = 0;
        } else {
            this.f3586b = this.f3585a.E();
        }
        int i6 = this.f3586b;
        if (i6 == 0 || i6 == this.f3587c) {
            return Integer.MAX_VALUE;
        }
        return v1.a(i6);
    }

    public void u(List<String> list) {
        T(list, false);
    }

    public long v() {
        V(1);
        return this.f3585a.z();
    }

    public <T> T w(i1<T> i1Var, q qVar) {
        V(2);
        return S(i1Var, qVar);
    }

    public <K, V> void x(Map<K, V> map, l0.a<K, V> aVar, q qVar) {
        V(2);
        this.f3585a.n(this.f3585a.F());
        throw null;
    }

    public void y(List<Long> list) {
        int i5;
        int E;
        int E2;
        if (list instanceof j0) {
            j0 j0Var = (j0) list;
            int b5 = v1.b(this.f3586b);
            if (b5 == 0) {
                do {
                    j0Var.l(this.f3585a.G());
                    if (!this.f3585a.e()) {
                        E2 = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E2 == this.f3586b);
                this.f3588d = E2;
                return;
            } else if (b5 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    j0Var.l(this.f3585a.G());
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        } else {
            int b6 = v1.b(this.f3586b);
            if (b6 == 0) {
                do {
                    list.add(Long.valueOf(this.f3585a.G()));
                    if (!this.f3585a.e()) {
                        E = this.f3585a.E();
                    } else {
                        return;
                    }
                } while (E == this.f3586b);
                this.f3588d = E;
                return;
            } else if (b6 == 2) {
                i5 = this.f3585a.d() + this.f3585a.F();
                do {
                    list.add(Long.valueOf(this.f3585a.G()));
                } while (this.f3585a.d() < i5);
            } else {
                throw c0.e();
            }
        }
        U(i5);
    }

    public void z(List<String> list) {
        T(list, true);
    }
}
