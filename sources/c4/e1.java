package c4;

import java.util.concurrent.Executor;

public final class e1 {
    public static final c0 a(Executor executor) {
        c0 c0Var;
        s0 s0Var = executor instanceof s0 ? (s0) executor : null;
        return (s0Var == null || (c0Var = s0Var.f3156e) == null) ? new d1(executor) : c0Var;
    }
}
