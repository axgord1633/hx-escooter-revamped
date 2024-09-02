package n0;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.yalantis.ucrop.R;
import i1.e;
import i1.f;
import i1.g;
import i1.h;
import java.security.SecureRandom;
import java.util.Objects;
import u0.i;

class j implements p {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6024a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final e f6025b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final i1.b f6026c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final f0 f6027d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6028e = s();

    /* renamed from: f  reason: collision with root package name */
    private final z f6029f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public m0.a f6030g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public g0 f6031h;

    class a extends e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f6032a;

        a(Context context) {
            this.f6032a = context;
        }

        public synchronized void a(LocationAvailability locationAvailability) {
            if (!locationAvailability.a() && !j.this.r(this.f6032a) && j.this.f6030g != null) {
                j.this.f6030g.a(m0.b.locationServicesDisabled);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void b(com.google.android.gms.location.LocationResult r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                n0.j r0 = n0.j.this     // Catch:{ all -> 0x004c }
                n0.g0 r0 = r0.f6031h     // Catch:{ all -> 0x004c }
                if (r0 != 0) goto L_0x0034
                java.lang.String r2 = "FlutterGeolocator"
                java.lang.String r0 = "LocationCallback was called with empty locationResult or no positionChangedCallback was registered."
                android.util.Log.e(r2, r0)     // Catch:{ all -> 0x004c }
                n0.j r2 = n0.j.this     // Catch:{ all -> 0x004c }
                i1.b r2 = r2.f6026c     // Catch:{ all -> 0x004c }
                n0.j r0 = n0.j.this     // Catch:{ all -> 0x004c }
                i1.e r0 = r0.f6025b     // Catch:{ all -> 0x004c }
                r2.d(r0)     // Catch:{ all -> 0x004c }
                n0.j r2 = n0.j.this     // Catch:{ all -> 0x004c }
                m0.a r2 = r2.f6030g     // Catch:{ all -> 0x004c }
                if (r2 == 0) goto L_0x0032
                n0.j r2 = n0.j.this     // Catch:{ all -> 0x004c }
                m0.a r2 = r2.f6030g     // Catch:{ all -> 0x004c }
                m0.b r0 = m0.b.errorWhileAcquiringPosition     // Catch:{ all -> 0x004c }
                r2.a(r0)     // Catch:{ all -> 0x004c }
            L_0x0032:
                monitor-exit(r1)
                return
            L_0x0034:
                android.location.Location r2 = r2.a()     // Catch:{ all -> 0x004c }
                n0.j r0 = n0.j.this     // Catch:{ all -> 0x004c }
                n0.f0 r0 = r0.f6027d     // Catch:{ all -> 0x004c }
                r0.b(r2)     // Catch:{ all -> 0x004c }
                n0.j r0 = n0.j.this     // Catch:{ all -> 0x004c }
                n0.g0 r0 = r0.f6031h     // Catch:{ all -> 0x004c }
                r0.a(r2)     // Catch:{ all -> 0x004c }
                monitor-exit(r1)
                return
            L_0x004c:
                r2 = move-exception
                monitor-exit(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: n0.j.a.b(com.google.android.gms.location.LocationResult):void");
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6034a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                n0.l[] r0 = n0.l.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6034a = r0
                n0.l r1 = n0.l.lowest     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6034a     // Catch:{ NoSuchFieldError -> 0x001d }
                n0.l r1 = n0.l.low     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6034a     // Catch:{ NoSuchFieldError -> 0x0028 }
                n0.l r1 = n0.l.medium     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: n0.j.b.<clinit>():void");
        }
    }

    public j(Context context, z zVar) {
        this.f6024a = context;
        this.f6026c = f.a(context);
        this.f6029f = zVar;
        this.f6027d = new f0(context, zVar);
        this.f6025b = new a(context);
    }

    private static LocationRequest o(z zVar) {
        if (Build.VERSION.SDK_INT < 33) {
            return p(zVar);
        }
        LocationRequest.a aVar = new LocationRequest.a(0);
        if (zVar != null) {
            aVar.g(y(zVar.a()));
            aVar.c(zVar.c());
            aVar.f(zVar.c());
            aVar.e((float) zVar.b());
        }
        return aVar.a();
    }

    private static LocationRequest p(z zVar) {
        LocationRequest a5 = LocationRequest.a();
        if (zVar != null) {
            a5.p(y(zVar.a()));
            a5.o(zVar.c());
            a5.n(zVar.c() / 2);
            a5.q((float) zVar.b());
        }
        return a5;
    }

    private static g q(LocationRequest locationRequest) {
        g.a aVar = new g.a();
        aVar.a(locationRequest);
        return aVar.b();
    }

    private synchronized int s() {
        return new SecureRandom().nextInt(65536);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void t(m0.a aVar, Exception exc) {
        Log.e("Geolocator", "Error trying to get last the last known GPS location");
        if (aVar != null) {
            aVar.a(m0.b.errorWhileAcquiringPosition);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void u(a0 a0Var, l1.g gVar) {
        if (!gVar.j()) {
            a0Var.a(m0.b.locationServicesDisabled);
        }
        h hVar = (h) gVar.g();
        if (hVar != null) {
            i1.j b5 = hVar.b();
            boolean z4 = true;
            boolean z5 = b5 != null && b5.d();
            boolean z6 = b5 != null && b5.f();
            if (!z5 && !z6) {
                z4 = false;
            }
            a0Var.b(z4);
            return;
        }
        a0Var.a(m0.b.locationServicesDisabled);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(h hVar) {
        x(this.f6029f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(Activity activity, m0.a aVar, Exception exc) {
        if (exc instanceof i) {
            if (activity == null) {
                aVar.a(m0.b.locationServicesDisabled);
                return;
            }
            i iVar = (i) exc;
            if (iVar.b() == 6) {
                try {
                    iVar.c(activity, this.f6028e);
                    return;
                } catch (IntentSender.SendIntentException unused) {
                }
            }
        } else if (((u0.b) exc).b() == 8502) {
            x(this.f6029f);
            return;
        }
        aVar.a(m0.b.locationServicesDisabled);
    }

    private void x(z zVar) {
        LocationRequest o5 = o(zVar);
        this.f6027d.d();
        this.f6026c.e(o5, this.f6025b, Looper.getMainLooper());
    }

    private static int y(l lVar) {
        int i5 = b.f6034a[lVar.ordinal()];
        if (i5 == 1) {
            return R.styleable.AppCompatTheme_textAppearanceListItemSmall;
        }
        if (i5 == 2) {
            return R.styleable.AppCompatTheme_textAppearanceListItemSecondary;
        }
        if (i5 != 3) {
            return 100;
        }
        return R.styleable.AppCompatTheme_textAppearanceLargePopupMenu;
    }

    public boolean a(int i5, int i6) {
        if (i5 == this.f6028e) {
            if (i6 == -1) {
                z zVar = this.f6029f;
                if (zVar == null || this.f6031h == null || this.f6030g == null) {
                    return false;
                }
                x(zVar);
                return true;
            }
            m0.a aVar = this.f6030g;
            if (aVar != null) {
                aVar.a(m0.b.locationServicesDisabled);
            }
        }
        return false;
    }

    public void b(a0 a0Var) {
        f.b(this.f6024a).c(new g.a().b()).b(new e(a0Var));
    }

    public void c(g0 g0Var, m0.a aVar) {
        l1.g<Location> b5 = this.f6026c.b();
        Objects.requireNonNull(g0Var);
        b5.d(new f(g0Var)).c(new g(aVar));
    }

    public void d() {
        this.f6027d.e();
        this.f6026c.d(this.f6025b);
    }

    public void e(Activity activity, g0 g0Var, m0.a aVar) {
        this.f6031h = g0Var;
        this.f6030g = aVar;
        f.b(this.f6024a).c(q(o(this.f6029f))).d(new h(this)).c(new i(this, activity, aVar));
    }

    public /* synthetic */ boolean r(Context context) {
        return o.a(this, context);
    }
}
