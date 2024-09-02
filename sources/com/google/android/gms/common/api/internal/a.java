package com.google.android.gms.common.api.internal;

import a1.e;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: i  reason: collision with root package name */
    private static final a f3302i = new a();

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f3303e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f3304f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList f3305g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private boolean f3306h = false;

    /* renamed from: com.google.android.gms.common.api.internal.a$a  reason: collision with other inner class name */
    public interface C0062a {
        void a(boolean z4);
    }

    private a() {
    }

    public static a b() {
        return f3302i;
    }

    public static void c(Application application) {
        a aVar = f3302i;
        synchronized (aVar) {
            if (!aVar.f3306h) {
                application.registerActivityLifecycleCallbacks(aVar);
                application.registerComponentCallbacks(aVar);
                aVar.f3306h = true;
            }
        }
    }

    private final void f(boolean z4) {
        synchronized (f3302i) {
            Iterator it = this.f3305g.iterator();
            while (it.hasNext()) {
                ((C0062a) it.next()).a(z4);
            }
        }
    }

    public void a(C0062a aVar) {
        synchronized (f3302i) {
            this.f3305g.add(aVar);
        }
    }

    public boolean d() {
        return this.f3303e.get();
    }

    public boolean e(boolean z4) {
        if (!this.f3304f.get()) {
            if (!e.a()) {
                return z4;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f3304f.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f3303e.set(true);
            }
        }
        return d();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f3303e.compareAndSet(true, false);
        this.f3304f.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f3303e.compareAndSet(true, false);
        this.f3304f.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i5) {
        if (i5 == 20 && this.f3303e.compareAndSet(false, true)) {
            this.f3304f.set(true);
            f(true);
        }
    }
}
