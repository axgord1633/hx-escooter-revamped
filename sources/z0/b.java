package z0;

import a1.e;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import c1.d;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import w0.j1;
import w0.p;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f7834b = new Object();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static volatile b f7835c;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f7836a = new ConcurrentHashMap();

    private b() {
    }

    public static b a() {
        if (f7835c == null) {
            synchronized (f7834b) {
                if (f7835c == null) {
                    f7835c = new b();
                }
            }
        }
        b bVar = f7835c;
        p.g(bVar);
        return bVar;
    }

    private static void d(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean e(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i5, boolean z4, @Nullable Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((d.a(context).a(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!f(serviceConnection)) {
            return g(context, intent, serviceConnection, i5, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f7836a.putIfAbsent(serviceConnection, serviceConnection);
        if (!(serviceConnection2 == null || serviceConnection == serviceConnection2)) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", new Object[]{serviceConnection, str, intent.getAction()}));
        }
        try {
            boolean g5 = g(context, intent, serviceConnection, i5, executor);
            if (g5) {
                return g5;
            }
            return false;
        } finally {
            this.f7836a.remove(serviceConnection, serviceConnection);
        }
    }

    private static boolean f(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof j1);
    }

    private static final boolean g(Context context, Intent intent, ServiceConnection serviceConnection, int i5, @Nullable Executor executor) {
        return (!e.h() || executor == null) ? context.bindService(intent, serviceConnection, i5) : context.bindService(intent, i5, executor, serviceConnection);
    }

    public void b(Context context, ServiceConnection serviceConnection) {
        if (!f(serviceConnection) || !this.f7836a.containsKey(serviceConnection)) {
            d(context, serviceConnection);
            return;
        }
        try {
            d(context, (ServiceConnection) this.f7836a.get(serviceConnection));
        } finally {
            this.f7836a.remove(serviceConnection);
        }
    }

    public final boolean c(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i5, @Nullable Executor executor) {
        return e(context, str, intent, serviceConnection, i5, true, executor);
    }
}
