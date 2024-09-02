package u0;

import android.text.TextUtils;
import java.util.ArrayList;
import m.a;
import v0.b;
import w0.p;

public class c extends Exception {

    /* renamed from: e  reason: collision with root package name */
    private final a f7074e;

    public c(a aVar) {
        this.f7074e = aVar;
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z4 = true;
        for (b bVar : this.f7074e.keySet()) {
            t0.a aVar = (t0.a) p.g((t0.a) this.f7074e.get(bVar));
            z4 &= !aVar.e();
            arrayList.add(bVar.b() + ": " + String.valueOf(aVar));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(z4 ? "None of the queried APIs are available. " : "Some of the queried APIs are unavailable. ");
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }
}
