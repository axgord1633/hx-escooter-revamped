package w1;

import java.util.Arrays;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final r[] f7497a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7498b;

    public f(r... rVarArr) {
        this.f7497a = rVarArr;
        boolean z4 = false;
        if (rVarArr != null && rVarArr.length != 0) {
            int length = rVarArr.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                } else if (!rVarArr[i5].b()) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        z4 = true;
        this.f7498b = z4;
    }

    public boolean a() {
        return this.f7498b;
    }

    public boolean b(q qVar) {
        r[] rVarArr = this.f7497a;
        if (rVarArr == null || rVarArr.length == 0) {
            return true;
        }
        for (r a5 : rVarArr) {
            if (a5.a(qVar)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "emulatedFilters=" + Arrays.toString(this.f7497a);
    }
}
