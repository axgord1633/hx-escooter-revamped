package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProfileInstallerInitializer implements z.a<c> {

    private static class a {
        public static void c(Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new n(runnable));
        }
    }

    private static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class c {
    }

    /* access modifiers changed from: private */
    public static void l(Context context) {
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new m(context));
    }

    public List<Class<? extends z.a<?>>> a() {
        return Collections.emptyList();
    }

    /* renamed from: f */
    public c b(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new c();
        }
        g(context.getApplicationContext());
        return new c();
    }

    /* access modifiers changed from: package-private */
    public void g(Context context) {
        a.c(new k(this, context));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void i(Context context) {
        (Build.VERSION.SDK_INT >= 28 ? b.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new l(context), (long) (new Random().nextInt(Math.max(1000, 1)) + 5000));
    }
}
