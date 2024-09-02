package w0;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static int f7381a = 4225;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f7382b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static i1 f7383c = null;

    /* renamed from: d  reason: collision with root package name */
    static HandlerThread f7384d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f7385e = false;

    public static int a() {
        return f7381a;
    }

    public static i b(Context context) {
        synchronized (f7382b) {
            if (f7383c == null) {
                f7383c = new i1(context.getApplicationContext(), f7385e ? c().getLooper() : context.getMainLooper());
            }
        }
        return f7383c;
    }

    public static HandlerThread c() {
        synchronized (f7382b) {
            HandlerThread handlerThread = f7384d;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            f7384d = handlerThread2;
            handlerThread2.start();
            HandlerThread handlerThread3 = f7384d;
            return handlerThread3;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void d(d1 d1Var, ServiceConnection serviceConnection, String str);

    public final void e(String str, String str2, int i5, ServiceConnection serviceConnection, String str3, boolean z4) {
        d(new d1(str, str2, i5, z4), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean f(d1 d1Var, ServiceConnection serviceConnection, String str, Executor executor);
}
