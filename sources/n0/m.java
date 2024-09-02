package n0;

import android.content.Context;
import m0.a;
import m0.b;

public class m {
    public n a(Context context, a aVar) {
        if (androidx.core.content.a.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return n.precise;
        }
        if (androidx.core.content.a.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return n.reduced;
        }
        aVar.a(b.permissionDenied);
        return null;
    }
}
