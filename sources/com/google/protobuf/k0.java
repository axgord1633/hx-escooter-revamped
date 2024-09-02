package com.google.protobuf;

final class k0 implements j1 {

    /* renamed from: b  reason: collision with root package name */
    private static final r0 f3589b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final r0 f3590a;

    static class a implements r0 {
        a() {
        }

        public q0 a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        public boolean b(Class<?> cls) {
            return false;
        }
    }

    private static class b implements r0 {

        /* renamed from: a  reason: collision with root package name */
        private r0[] f3591a;

        b(r0... r0VarArr) {
            this.f3591a = r0VarArr;
        }

        public q0 a(Class<?> cls) {
            for (r0 r0Var : this.f3591a) {
                if (r0Var.b(cls)) {
                    return r0Var.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        public boolean b(Class<?> cls) {
            for (r0 b5 : this.f3591a) {
                if (b5.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public k0() {
        this(b());
    }

    private k0(r0 r0Var) {
        this.f3590a = (r0) b0.b(r0Var, "messageInfoFactory");
    }

    private static r0 b() {
        return new b(y.c(), c());
    }

    private static r0 c() {
        try {
            return (r0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f3589b;
        }
    }

    private static boolean d(q0 q0Var) {
        return q0Var.b() == d1.PROTO2;
    }

    private static <T> i1<T> e(Class<T> cls, q0 q0Var) {
        if (z.class.isAssignableFrom(cls)) {
            if (d(q0Var)) {
                return v0.Q(cls, q0Var, z0.b(), i0.b(), k1.M(), t.b(), p0.b());
            }
            return v0.Q(cls, q0Var, z0.b(), i0.b(), k1.M(), (r<?>) null, p0.b());
        } else if (d(q0Var)) {
            return v0.Q(cls, q0Var, z0.a(), i0.a(), k1.H(), t.a(), p0.a());
        } else {
            return v0.Q(cls, q0Var, z0.a(), i0.a(), k1.I(), (r<?>) null, p0.a());
        }
    }

    public <T> i1<T> a(Class<T> cls) {
        p1<?, ?> H;
        r<?> a5;
        k1.J(cls);
        q0 a6 = this.f3590a.a(cls);
        if (!a6.a()) {
            return e(cls, a6);
        }
        if (z.class.isAssignableFrom(cls)) {
            H = k1.M();
            a5 = t.b();
        } else {
            H = k1.H();
            a5 = t.a();
        }
        return w0.m(H, a5, a6.c());
    }
}
