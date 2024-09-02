package kotlinx.coroutines.scheduling;

import c4.k0;

public final class k extends h {

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f5680g;

    public k(Runnable runnable, long j5, i iVar) {
        super(j5, iVar);
        this.f5680g = runnable;
    }

    public void run() {
        try {
            this.f5680g.run();
        } finally {
            this.f5678f.a();
        }
    }

    public String toString() {
        return "Task[" + k0.a(this.f5680g) + '@' + k0.b(this.f5680g) + ", " + this.f5677e + ", " + this.f5678f + ']';
    }
}
