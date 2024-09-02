package c4;

final class v0 implements g1 {

    /* renamed from: e  reason: collision with root package name */
    private final boolean f3184e;

    public v0(boolean z4) {
        this.f3184e = z4;
    }

    public boolean b() {
        return this.f3184e;
    }

    public w1 e() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(b() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
