package y1;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final n f7754a;

    /* renamed from: b  reason: collision with root package name */
    private final String[][] f7755b;

    j(n nVar, String[][] strArr) {
        this.f7754a = nVar;
        this.f7755b = strArr;
    }

    public boolean a() {
        boolean z4 = true;
        for (String[] a5 : this.f7755b) {
            z4 &= this.f7754a.a(a5);
        }
        return z4;
    }
}
