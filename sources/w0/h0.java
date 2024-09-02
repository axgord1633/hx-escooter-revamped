package w0;

import android.content.Context;
import android.util.SparseIntArray;
import t0.e;
import u0.a;

public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f7378a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private e f7379b;

    public h0(e eVar) {
        p.g(eVar);
        this.f7379b = eVar;
    }

    public final int a(Context context, int i5) {
        return this.f7378a.get(i5, -1);
    }

    public final int b(Context context, a.f fVar) {
        p.g(context);
        p.g(fVar);
        int i5 = 0;
        if (!fVar.f()) {
            return 0;
        }
        int h5 = fVar.h();
        int a5 = a(context, h5);
        if (a5 == -1) {
            int i6 = 0;
            while (true) {
                if (i6 >= this.f7378a.size()) {
                    i5 = -1;
                    break;
                }
                int keyAt = this.f7378a.keyAt(i6);
                if (keyAt > h5 && this.f7378a.get(keyAt) == 0) {
                    break;
                }
                i6++;
            }
            a5 = i5 == -1 ? this.f7379b.f(context, h5) : i5;
            this.f7378a.put(h5, a5);
        }
        return a5;
    }

    public final void c() {
        this.f7378a.clear();
    }
}
