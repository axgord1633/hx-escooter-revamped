package d4;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.jvm.internal.g;
import m3.k;
import m3.l;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final d f4444a;
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        d dVar = null;
        try {
            k.a aVar = k.f5898e;
            obj = k.a(new c(a(Looper.getMainLooper(), true), (String) null, 2, (g) null));
        } catch (Throwable th) {
            k.a aVar2 = k.f5898e;
            obj = k.a(l.a(th));
        }
        if (!k.c(obj)) {
            dVar = obj;
        }
        f4444a = dVar;
    }

    public static final Handler a(Looper looper, boolean z4) {
        if (!z4) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke((Object) null, new Object[]{looper});
            if (invoke != null) {
                return (Handler) invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
