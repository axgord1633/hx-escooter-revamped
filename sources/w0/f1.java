package w0;

import a1.e;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

final class f1 implements ServiceConnection, j1 {

    /* renamed from: a  reason: collision with root package name */
    private final Map f7354a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f7355b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7356c;

    /* renamed from: d  reason: collision with root package name */
    private IBinder f7357d;

    /* renamed from: e  reason: collision with root package name */
    private final d1 f7358e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f7359f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ i1 f7360g;

    public f1(i1 i1Var, d1 d1Var) {
        this.f7360g = i1Var;
        this.f7358e = d1Var;
    }

    public final int a() {
        return this.f7355b;
    }

    public final ComponentName b() {
        return this.f7359f;
    }

    public final IBinder c() {
        return this.f7357d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f7354a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        this.f7355b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (e.j()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            i1 i1Var = this.f7360g;
            boolean c5 = i1Var.f7390j.c(i1Var.f7387g, str, this.f7358e.c(i1Var.f7387g), this, this.f7358e.a(), executor);
            this.f7356c = c5;
            if (c5) {
                this.f7360g.f7388h.sendMessageDelayed(this.f7360g.f7388h.obtainMessage(1, this.f7358e), this.f7360g.f7392l);
            } else {
                this.f7355b = 2;
                try {
                    i1 i1Var2 = this.f7360g;
                    i1Var2.f7390j.b(i1Var2.f7387g, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f7354a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f7360g.f7388h.removeMessages(1, this.f7358e);
        i1 i1Var = this.f7360g;
        i1Var.f7390j.b(i1Var.f7387g, this);
        this.f7356c = false;
        this.f7355b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f7354a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f7354a.isEmpty();
    }

    public final boolean j() {
        return this.f7356c;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f7360g.f7386f) {
            this.f7360g.f7388h.removeMessages(1, this.f7358e);
            this.f7357d = iBinder;
            this.f7359f = componentName;
            for (ServiceConnection onServiceConnected : this.f7354a.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f7355b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f7360g.f7386f) {
            this.f7360g.f7388h.removeMessages(1, this.f7358e);
            this.f7357d = null;
            this.f7359f = componentName;
            for (ServiceConnection onServiceDisconnected : this.f7354a.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f7355b = 2;
        }
    }
}
