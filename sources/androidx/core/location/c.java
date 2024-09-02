package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.os.g;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    static final WeakHashMap<C0026c, WeakReference<d>> f1732a = new WeakHashMap<>();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Class<?> f1733a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f1734b;

        static boolean a(LocationManager locationManager, String str, m mVar, b bVar, Looper looper) {
            try {
                if (f1733a == null) {
                    f1733a = Class.forName("android.location.LocationRequest");
                }
                if (f1734b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{f1733a, LocationListener.class, Looper.class});
                    f1734b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest i5 = mVar.i(str);
                if (i5 != null) {
                    f1734b.invoke(locationManager, new Object[]{i5, bVar, looper});
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }

        static boolean b(LocationManager locationManager, String str, m mVar, d dVar) {
            try {
                if (f1733a == null) {
                    f1733a = Class.forName("android.location.LocationRequest");
                }
                if (f1734b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{f1733a, LocationListener.class, Looper.class});
                    f1734b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest i5 = mVar.i(str);
                if (i5 != null) {
                    synchronized (c.f1732a) {
                        f1734b.invoke(locationManager, new Object[]{i5, dVar, Looper.getMainLooper()});
                        c.a(locationManager, dVar);
                    }
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }
    }

    private static class b {
        static boolean a(LocationManager locationManager, String str) {
            return locationManager.hasProvider(str);
        }

        static boolean b(LocationManager locationManager, Executor executor, GnssMeasurementsEvent.Callback callback) {
            return locationManager.registerGnssMeasurementsCallback(executor, callback);
        }

        static void c(LocationManager locationManager, String str, LocationRequest locationRequest, Executor executor, LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }
    }

    /* renamed from: androidx.core.location.c$c  reason: collision with other inner class name */
    private static class C0026c {

        /* renamed from: a  reason: collision with root package name */
        final String f1735a;

        /* renamed from: b  reason: collision with root package name */
        final b f1736b;

        public boolean equals(Object obj) {
            if (!(obj instanceof C0026c)) {
                return false;
            }
            C0026c cVar = (C0026c) obj;
            return this.f1735a.equals(cVar.f1735a) && this.f1736b.equals(cVar.f1736b);
        }

        public int hashCode() {
            return androidx.core.util.c.b(this.f1735a, this.f1736b);
        }
    }

    private static class d implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        volatile C0026c f1737a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f1738b;

        /* access modifiers changed from: private */
        public /* synthetic */ void h(int i5) {
            C0026c cVar = this.f1737a;
            if (cVar != null) {
                cVar.f1736b.onFlushComplete(i5);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i(Location location) {
            C0026c cVar = this.f1737a;
            if (cVar != null) {
                cVar.f1736b.onLocationChanged(location);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(List list) {
            C0026c cVar = this.f1737a;
            if (cVar != null) {
                cVar.f1736b.onLocationChanged(list);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(String str) {
            C0026c cVar = this.f1737a;
            if (cVar != null) {
                cVar.f1736b.onProviderDisabled(str);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(String str) {
            C0026c cVar = this.f1737a;
            if (cVar != null) {
                cVar.f1736b.onProviderEnabled(str);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(String str, int i5, Bundle bundle) {
            C0026c cVar = this.f1737a;
            if (cVar != null) {
                cVar.f1736b.onStatusChanged(str, i5, bundle);
            }
        }

        public C0026c g() {
            return (C0026c) androidx.core.util.c.c(this.f1737a);
        }

        public void n() {
            this.f1737a = null;
        }

        public void onFlushComplete(int i5) {
            if (this.f1737a != null) {
                this.f1738b.execute(new h(this, i5));
            }
        }

        public void onLocationChanged(Location location) {
            if (this.f1737a != null) {
                this.f1738b.execute(new k(this, location));
            }
        }

        public void onLocationChanged(List<Location> list) {
            if (this.f1737a != null) {
                this.f1738b.execute(new i(this, list));
            }
        }

        public void onProviderDisabled(String str) {
            if (this.f1737a != null) {
                this.f1738b.execute(new j(this, str));
            }
        }

        public void onProviderEnabled(String str) {
            if (this.f1737a != null) {
                this.f1738b.execute(new g(this, str));
            }
        }

        public void onStatusChanged(String str, int i5, Bundle bundle) {
            if (this.f1737a != null) {
                this.f1738b.execute(new l(this, str, i5, bundle));
            }
        }
    }

    static void a(LocationManager locationManager, d dVar) {
        WeakReference put = f1732a.put(dVar.g(), new WeakReference(dVar));
        d dVar2 = put != null ? (d) put.get() : null;
        if (dVar2 != null) {
            dVar2.n();
            locationManager.removeUpdates(dVar2);
        }
    }

    public static void b(LocationManager locationManager, String str, m mVar, b bVar, Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            b.c(locationManager, str, mVar.h(), g.a(new Handler(looper)), bVar);
        } else if (!a.a(locationManager, str, mVar, bVar, looper)) {
            locationManager.requestLocationUpdates(str, mVar.b(), mVar.e(), bVar, looper);
        }
    }
}
