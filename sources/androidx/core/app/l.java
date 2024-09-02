package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import com.yalantis.ucrop.BuildConfig;
import java.util.ArrayList;

public class l {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f1567a;

        /* renamed from: b  reason: collision with root package name */
        private IconCompat f1568b;

        /* renamed from: c  reason: collision with root package name */
        private final v0[] f1569c;

        /* renamed from: d  reason: collision with root package name */
        private final v0[] f1570d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1571e;

        /* renamed from: f  reason: collision with root package name */
        boolean f1572f;

        /* renamed from: g  reason: collision with root package name */
        private final int f1573g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f1574h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public int f1575i;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f1576j;

        /* renamed from: k  reason: collision with root package name */
        public PendingIntent f1577k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f1578l;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(int i5, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i5 != 0 ? IconCompat.g((Resources) null, BuildConfig.FLAVOR, i5) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (v0[]) null, (v0[]) null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, v0[] v0VarArr, v0[] v0VarArr2, boolean z4, int i5, boolean z5, boolean z6, boolean z7) {
            this.f1572f = true;
            this.f1568b = iconCompat;
            if (iconCompat != null && iconCompat.j() == 2) {
                this.f1575i = iconCompat.h();
            }
            this.f1576j = d.d(charSequence);
            this.f1577k = pendingIntent;
            this.f1567a = bundle == null ? new Bundle() : bundle;
            this.f1569c = v0VarArr;
            this.f1570d = v0VarArr2;
            this.f1571e = z4;
            this.f1573g = i5;
            this.f1572f = z5;
            this.f1574h = z6;
            this.f1578l = z7;
        }

        public PendingIntent a() {
            return this.f1577k;
        }

        public boolean b() {
            return this.f1571e;
        }

        public Bundle c() {
            return this.f1567a;
        }

        public IconCompat d() {
            int i5;
            if (this.f1568b == null && (i5 = this.f1575i) != 0) {
                this.f1568b = IconCompat.g((Resources) null, BuildConfig.FLAVOR, i5);
            }
            return this.f1568b;
        }

        public v0[] e() {
            return this.f1569c;
        }

        public int f() {
            return this.f1573g;
        }

        public boolean g() {
            return this.f1572f;
        }

        public CharSequence h() {
            return this.f1576j;
        }

        public boolean i() {
            return this.f1578l;
        }

        public boolean j() {
            return this.f1574h;
        }
    }

    public static class b extends e {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f1579e;

        static class a {
            static Notification.BigTextStyle a(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.bigText(charSequence);
            }

            static Notification.BigTextStyle b(Notification.Builder builder) {
                return new Notification.BigTextStyle(builder);
            }

            static Notification.BigTextStyle c(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setBigContentTitle(charSequence);
            }

            static Notification.BigTextStyle d(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setSummaryText(charSequence);
            }
        }

        public void a(Bundle bundle) {
            super.a(bundle);
        }

        public void b(k kVar) {
            Notification.BigTextStyle a5 = a.a(a.c(a.b(kVar.a()), this.f1607b), this.f1579e);
            if (this.f1609d) {
                a.d(a5, this.f1608c);
            }
        }

        /* access modifiers changed from: protected */
        public String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.f1579e = d.d(charSequence);
            return this;
        }
    }

    public static final class c {
        public static Notification.BubbleMetadata a(c cVar) {
            return null;
        }
    }

    public static class d {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        Notification R;
        boolean S;
        Object T;
        @Deprecated
        public ArrayList<String> U;

        /* renamed from: a  reason: collision with root package name */
        public Context f1580a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f1581b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<t0> f1582c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<a> f1583d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f1584e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f1585f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f1586g;

        /* renamed from: h  reason: collision with root package name */
        PendingIntent f1587h;

        /* renamed from: i  reason: collision with root package name */
        RemoteViews f1588i;

        /* renamed from: j  reason: collision with root package name */
        Bitmap f1589j;

        /* renamed from: k  reason: collision with root package name */
        CharSequence f1590k;

        /* renamed from: l  reason: collision with root package name */
        int f1591l;

        /* renamed from: m  reason: collision with root package name */
        int f1592m;

        /* renamed from: n  reason: collision with root package name */
        boolean f1593n;

        /* renamed from: o  reason: collision with root package name */
        boolean f1594o;

        /* renamed from: p  reason: collision with root package name */
        e f1595p;

        /* renamed from: q  reason: collision with root package name */
        CharSequence f1596q;

        /* renamed from: r  reason: collision with root package name */
        CharSequence f1597r;

        /* renamed from: s  reason: collision with root package name */
        CharSequence[] f1598s;

        /* renamed from: t  reason: collision with root package name */
        int f1599t;

        /* renamed from: u  reason: collision with root package name */
        int f1600u;

        /* renamed from: v  reason: collision with root package name */
        boolean f1601v;

        /* renamed from: w  reason: collision with root package name */
        String f1602w;

        /* renamed from: x  reason: collision with root package name */
        boolean f1603x;

        /* renamed from: y  reason: collision with root package name */
        String f1604y;

        /* renamed from: z  reason: collision with root package name */
        boolean f1605z;

        @Deprecated
        public d(Context context) {
            this(context, (String) null);
        }

        public d(Context context, String str) {
            this.f1581b = new ArrayList<>();
            this.f1582c = new ArrayList<>();
            this.f1583d = new ArrayList<>();
            this.f1593n = true;
            this.f1605z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.R = notification;
            this.f1580a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.f1592m = 0;
            this.U = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void j(int i5, boolean z4) {
            Notification notification;
            int i6;
            if (z4) {
                notification = this.R;
                i6 = i5 | notification.flags;
            } else {
                notification = this.R;
                i6 = (~i5) & notification.flags;
            }
            notification.flags = i6;
        }

        public d a(int i5, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f1581b.add(new a(i5, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new m(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public d e(boolean z4) {
            j(16, z4);
            return this;
        }

        public d f(String str) {
            this.K = str;
            return this;
        }

        public d g(PendingIntent pendingIntent) {
            this.f1586g = pendingIntent;
            return this;
        }

        public d h(CharSequence charSequence) {
            this.f1585f = d(charSequence);
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f1584e = d(charSequence);
            return this;
        }

        public d k(boolean z4) {
            this.f1605z = z4;
            return this;
        }

        public d l(boolean z4) {
            j(2, z4);
            return this;
        }

        public d m(int i5) {
            this.f1592m = i5;
            return this;
        }

        public d n(int i5) {
            this.R.icon = i5;
            return this;
        }

        public d o(e eVar) {
            if (this.f1595p != eVar) {
                this.f1595p = eVar;
                if (eVar != null) {
                    eVar.g(this);
                }
            }
            return this;
        }

        public d p(CharSequence charSequence) {
            this.R.tickerText = d(charSequence);
            return this;
        }

        public d q(long j5) {
            this.R.when = j5;
            return this;
        }
    }

    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        protected d f1606a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f1607b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f1608c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1609d = false;

        public void a(Bundle bundle) {
            if (this.f1609d) {
                bundle.putCharSequence("android.summaryText", this.f1608c);
            }
            CharSequence charSequence = this.f1607b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c5 = c();
            if (c5 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c5);
            }
        }

        public abstract void b(k kVar);

        /* access modifiers changed from: protected */
        public abstract String c();

        public RemoteViews d(k kVar) {
            return null;
        }

        public RemoteViews e(k kVar) {
            return null;
        }

        public RemoteViews f(k kVar) {
            return null;
        }

        public void g(d dVar) {
            if (this.f1606a != dVar) {
                this.f1606a = dVar;
                if (dVar != null) {
                    dVar.o(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }
}
