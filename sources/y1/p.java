package y1;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private final n f7765a;

    /* renamed from: b  reason: collision with root package name */
    private final String[][] f7766b;

    p(n nVar, String[][] strArr) {
        this.f7765a = nVar;
        this.f7766b = strArr;
    }

    public boolean a() {
        boolean z4 = true;
        for (String[] a5 : this.f7766b) {
            z4 &= this.f7765a.a(a5);
        }
        return z4;
    }
}
