package d2;

final class k {

    /* renamed from: a  reason: collision with root package name */
    private final j f4288a;

    /* renamed from: b  reason: collision with root package name */
    final Runnable f4289b;

    k(j jVar, Runnable runnable) {
        this.f4288a = jVar;
        this.f4289b = runnable;
    }

    public Integer a() {
        j jVar = this.f4288a;
        if (jVar != null) {
            return Integer.valueOf(jVar.a());
        }
        return null;
    }

    public boolean b() {
        j jVar = this.f4288a;
        return jVar != null && jVar.b();
    }
}
