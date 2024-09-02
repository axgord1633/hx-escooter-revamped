package androidx.startup;

import a0.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import z.c;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f2708d;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f2709e = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Map<Class<?>, Object> f2710a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Set<Class<? extends z.a<?>>> f2711b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    final Context f2712c;

    a(Context context) {
        this.f2712c = context.getApplicationContext();
    }

    private <T> T c(Class<? extends z.a<?>> cls, Set<Class<?>> set) {
        T t5;
        if (b.h()) {
            try {
                b.c(cls.getSimpleName());
            } catch (Throwable th) {
                b.f();
                throw th;
            }
        }
        if (!set.contains(cls)) {
            if (!this.f2710a.containsKey(cls)) {
                set.add(cls);
                z.a aVar = (z.a) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends z.a<?>>> a5 = aVar.a();
                if (!a5.isEmpty()) {
                    for (Class next : a5) {
                        if (!this.f2710a.containsKey(next)) {
                            c(next, set);
                        }
                    }
                }
                t5 = aVar.b(this.f2712c);
                set.remove(cls);
                this.f2710a.put(cls, t5);
            } else {
                t5 = this.f2710a.get(cls);
            }
            b.f();
            return t5;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
    }

    public static a d(Context context) {
        if (f2708d == null) {
            synchronized (f2709e) {
                if (f2708d == null) {
                    f2708d = new a(context);
                }
            }
        }
        return f2708d;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        try {
            b.c("Startup");
            b(this.f2712c.getPackageManager().getProviderInfo(new ComponentName(this.f2712c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            b.f();
        } catch (PackageManager.NameNotFoundException e5) {
            throw new c((Throwable) e5);
        } catch (Throwable th) {
            b.f();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Bundle bundle) {
        String string = this.f2712c.getString(z.b.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String next : bundle.keySet()) {
                    if (string.equals(bundle.getString(next, (String) null))) {
                        Class<?> cls = Class.forName(next);
                        if (z.a.class.isAssignableFrom(cls)) {
                            this.f2711b.add(cls);
                        }
                    }
                }
                for (Class<? extends z.a<?>> c5 : this.f2711b) {
                    c(c5, hashSet);
                }
            } catch (ClassNotFoundException e5) {
                throw new c((Throwable) e5);
            }
        }
    }
}
