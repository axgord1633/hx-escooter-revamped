package s4;

import javax.annotation.Nullable;

final class p {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    static o f6796a;

    /* renamed from: b  reason: collision with root package name */
    static long f6797b;

    private p() {
    }

    static void a(o oVar) {
        if (oVar.f6794f != null || oVar.f6795g != null) {
            throw new IllegalArgumentException();
        } else if (!oVar.f6792d) {
            synchronized (p.class) {
                long j5 = f6797b;
                if (j5 + 8192 <= 65536) {
                    f6797b = j5 + 8192;
                    oVar.f6794f = f6796a;
                    oVar.f6791c = 0;
                    oVar.f6790b = 0;
                    f6796a = oVar;
                }
            }
        }
    }

    static o b() {
        synchronized (p.class) {
            o oVar = f6796a;
            if (oVar == null) {
                return new o();
            }
            f6796a = oVar.f6794f;
            oVar.f6794f = null;
            f6797b -= 8192;
            return oVar;
        }
    }
}
