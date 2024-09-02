package w0;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import f1.e;
import java.util.HashMap;
import java.util.concurrent.Executor;
import z0.b;

final class i1 extends i {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f7386f = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Context f7387g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public volatile Handler f7388h;

    /* renamed from: i  reason: collision with root package name */
    private final h1 f7389i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final b f7390j;

    /* renamed from: k  reason: collision with root package name */
    private final long f7391k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final long f7392l;

    i1(Context context, Looper looper) {
        h1 h1Var = new h1(this, (g1) null);
        this.f7389i = h1Var;
        this.f7387g = context.getApplicationContext();
        this.f7388h = new e(looper, h1Var);
        this.f7390j = b.a();
        this.f7391k = 5000;
        this.f7392l = 300000;
    }

    /* access modifiers changed from: protected */
    public final void d(d1 d1Var, ServiceConnection serviceConnection, String str) {
        p.h(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f7386f) {
            f1 f1Var = (f1) this.f7386f.get(d1Var);
            if (f1Var == null) {
                String obj = d1Var.toString();
                throw new IllegalStateException("Nonexistent connection status for service config: " + obj);
            } else if (f1Var.h(serviceConnection)) {
                f1Var.f(serviceConnection, str);
                if (f1Var.i()) {
                    this.f7388h.sendMessageDelayed(this.f7388h.obtainMessage(0, d1Var), this.f7391k);
                }
            } else {
                String obj2 = d1Var.toString();
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + obj2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean f(d1 d1Var, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean j5;
        p.h(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f7386f) {
            f1 f1Var = (f1) this.f7386f.get(d1Var);
            if (f1Var == null) {
                f1Var = new f1(this, d1Var);
                f1Var.d(serviceConnection, serviceConnection, str);
                f1Var.e(str, executor);
                this.f7386f.put(d1Var, f1Var);
            } else {
                this.f7388h.removeMessages(0, d1Var);
                if (!f1Var.h(serviceConnection)) {
                    f1Var.d(serviceConnection, serviceConnection, str);
                    int a5 = f1Var.a();
                    if (a5 == 1) {
                        serviceConnection.onServiceConnected(f1Var.b(), f1Var.c());
                    } else if (a5 == 2) {
                        f1Var.e(str, executor);
                    }
                } else {
                    String obj = d1Var.toString();
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + obj);
                }
            }
            j5 = f1Var.j();
        }
        return j5;
    }
}
