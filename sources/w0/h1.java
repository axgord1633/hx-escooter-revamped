package w0;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

final class h1 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i1 f7380a;

    /* synthetic */ h1(i1 i1Var, g1 g1Var) {
        this.f7380a = i1Var;
    }

    public final boolean handleMessage(Message message) {
        int i5 = message.what;
        if (i5 == 0) {
            synchronized (this.f7380a.f7386f) {
                d1 d1Var = (d1) message.obj;
                f1 f1Var = (f1) this.f7380a.f7386f.get(d1Var);
                if (f1Var != null && f1Var.i()) {
                    if (f1Var.j()) {
                        f1Var.g("GmsClientSupervisor");
                    }
                    this.f7380a.f7386f.remove(d1Var);
                }
            }
            return true;
        } else if (i5 != 1) {
            return false;
        } else {
            synchronized (this.f7380a.f7386f) {
                d1 d1Var2 = (d1) message.obj;
                f1 f1Var2 = (f1) this.f7380a.f7386f.get(d1Var2);
                if (f1Var2 != null && f1Var2.a() == 3) {
                    String valueOf = String.valueOf(d1Var2);
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + valueOf, new Exception());
                    ComponentName b5 = f1Var2.b();
                    if (b5 == null) {
                        b5 = d1Var2.b();
                    }
                    if (b5 == null) {
                        String d5 = d1Var2.d();
                        p.g(d5);
                        b5 = new ComponentName(d5, "unknown");
                    }
                    f1Var2.onServiceDisconnected(b5);
                }
            }
            return true;
        }
    }
}
