package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class e {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f1521a;

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f1522b = b();

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f1523c = f();

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f1524d;

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f1525e;

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f1526f;

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f1527g = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d f1528e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Object f1529f;

        a(d dVar, Object obj) {
            this.f1528e = dVar;
            this.f1529f = obj;
        }

        public void run() {
            this.f1528e.f1534e = this.f1529f;
        }
    }

    class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Application f1530e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ d f1531f;

        b(Application application, d dVar) {
            this.f1530e = application;
            this.f1531f = dVar;
        }

        public void run() {
            this.f1530e.unregisterActivityLifecycleCallbacks(this.f1531f);
        }
    }

    class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f1532e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Object f1533f;

        c(Object obj, Object obj2) {
            this.f1532e = obj;
            this.f1533f = obj2;
        }

        public void run() {
            try {
                Method method = e.f1524d;
                if (method != null) {
                    method.invoke(this.f1532e, new Object[]{this.f1533f, Boolean.FALSE, "AppCompat recreation"});
                    return;
                }
                e.f1525e.invoke(this.f1532e, new Object[]{this.f1533f, Boolean.FALSE});
            } catch (RuntimeException e5) {
                if (e5.getClass() == RuntimeException.class && e5.getMessage() != null && e5.getMessage().startsWith("Unable to stop")) {
                    throw e5;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    private static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: e  reason: collision with root package name */
        Object f1534e;

        /* renamed from: f  reason: collision with root package name */
        private Activity f1535f;

        /* renamed from: g  reason: collision with root package name */
        private final int f1536g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f1537h = false;

        /* renamed from: i  reason: collision with root package name */
        private boolean f1538i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f1539j = false;

        d(Activity activity) {
            this.f1535f = activity;
            this.f1536g = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f1535f == activity) {
                this.f1535f = null;
                this.f1538i = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f1538i && !this.f1539j && !this.f1537h && e.h(this.f1534e, this.f1536g, activity)) {
                this.f1539j = true;
                this.f1534e = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f1535f == activity) {
                this.f1537h = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a5 = a();
        f1521a = a5;
        f1524d = d(a5);
        f1525e = c(a5);
        f1526f = e(a5);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i5 = Build.VERSION.SDK_INT;
        return i5 == 26 || i5 == 27;
    }

    protected static boolean h(Object obj, int i5, Activity activity) {
        try {
            Object obj2 = f1523c.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i5) {
                    f1527g.postAtFrontOfQueue(new c(f1522b.get(activity), obj2));
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(Activity activity) {
        Object obj;
        Application application;
        d dVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f1526f == null) {
            return false;
        } else {
            if (f1525e == null && f1524d == null) {
                return false;
            }
            try {
                Object obj2 = f1523c.get(activity);
                if (obj2 == null || (obj = f1522b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                dVar = new d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                Handler handler = f1527g;
                handler.post(new a(dVar, obj2));
                if (g()) {
                    Method method = f1526f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, new Object[]{obj2, null, null, 0, bool, null, null, bool, bool});
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
