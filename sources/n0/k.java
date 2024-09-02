package n0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import io.flutter.plugin.common.PluginRegistry;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import m0.a;
import m0.b;
import t0.d;

public class k implements PluginRegistry.ActivityResultListener {

    /* renamed from: e  reason: collision with root package name */
    private final List<p> f6035e = new CopyOnWriteArrayList();

    private boolean c(Context context) {
        try {
            return d.k().e(context) == 0;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public p a(Context context, boolean z4, z zVar) {
        return z4 ? new q(context, zVar) : c(context) ? new j(context, zVar) : new q(context, zVar);
    }

    public void b(Context context, boolean z4, g0 g0Var, a aVar) {
        a(context, z4, (z) null).c(g0Var, aVar);
    }

    public void d(Context context, a0 a0Var) {
        if (context == null) {
            a0Var.a(b.locationServicesDisabled);
        }
        a(context, false, (z) null).b(a0Var);
    }

    public void e(p pVar, Activity activity, g0 g0Var, a aVar) {
        this.f6035e.add(pVar);
        pVar.e(activity, g0Var, aVar);
    }

    public void f(p pVar) {
        this.f6035e.remove(pVar);
        pVar.d();
    }

    public boolean onActivityResult(int i5, int i6, Intent intent) {
        for (p a5 : this.f6035e) {
            if (a5.a(i5, i6)) {
                return true;
            }
        }
        return false;
    }
}
