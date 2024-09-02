package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.l;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class m implements k {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1610a;

    /* renamed from: b  reason: collision with root package name */
    private final Notification.Builder f1611b;

    /* renamed from: c  reason: collision with root package name */
    private final l.d f1612c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f1613d;

    /* renamed from: e  reason: collision with root package name */
    private RemoteViews f1614e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Bundle> f1615f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f1616g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    private int f1617h;

    /* renamed from: i  reason: collision with root package name */
    private RemoteViews f1618i;

    static class a {
        static Notification a(Notification.Builder builder) {
            return builder.build();
        }

        static Notification.Builder b(Notification.Builder builder, int i5) {
            return builder.setPriority(i5);
        }

        static Notification.Builder c(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSubText(charSequence);
        }

        static Notification.Builder d(Notification.Builder builder, boolean z4) {
            return builder.setUsesChronometer(z4);
        }
    }

    static class b {
        static Notification.Builder a(Notification.Builder builder, boolean z4) {
            return builder.setShowWhen(z4);
        }
    }

    static class c {
        static Notification.Builder a(Notification.Builder builder, Bundle bundle) {
            return builder.setExtras(bundle);
        }
    }

    static class d {
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Action.Builder e(int i5, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i5, charSequence, pendingIntent);
        }

        static String f(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder h(Notification.Builder builder, boolean z4) {
            return builder.setGroupSummary(z4);
        }

        static Notification.Builder i(Notification.Builder builder, boolean z4) {
            return builder.setLocalOnly(z4);
        }

        static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    static class e {
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i5) {
            return builder.setColor(i5);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i5) {
            return builder.setVisibility(i5);
        }
    }

    static class f {
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    static class g {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z4) {
            return builder.setAllowGeneratedReplies(z4);
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    static class h {
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i5) {
            return builder.setBadgeIconType(i5);
        }

        static Notification.Builder c(Notification.Builder builder, boolean z4) {
            return builder.setColorized(z4);
        }

        static Notification.Builder d(Notification.Builder builder, int i5) {
            return builder.setGroupAlertBehavior(i5);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        static Notification.Builder g(Notification.Builder builder, long j5) {
            return builder.setTimeoutAfter(j5);
        }
    }

    static class i {
        static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, int i5) {
            return builder.setSemanticAction(i5);
        }
    }

    static class j {
        static Notification.Builder a(Notification.Builder builder, boolean z4) {
            return builder.setAllowSystemGeneratedContextualActions(z4);
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z4) {
            return builder.setContextual(z4);
        }

        static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    static class k {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z4) {
            return builder.setAuthenticationRequired(z4);
        }

        static Notification.Builder b(Notification.Builder builder, int i5) {
            return builder.setForegroundServiceBehavior(i5);
        }
    }

    m(l.d dVar) {
        int i5;
        this.f1612c = dVar;
        Context context = dVar.f1580a;
        this.f1610a = context;
        this.f1611b = Build.VERSION.SDK_INT >= 26 ? h.a(context, dVar.K) : new Notification.Builder(dVar.f1580a);
        Notification notification = dVar.R;
        this.f1611b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f1588i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f1584e).setContentText(dVar.f1585f).setContentInfo(dVar.f1590k).setContentIntent(dVar.f1586g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f1587h, (notification.flags & 128) != 0).setLargeIcon(dVar.f1589j).setNumber(dVar.f1591l).setProgress(dVar.f1599t, dVar.f1600u, dVar.f1601v);
        a.b(a.d(a.c(this.f1611b, dVar.f1596q), dVar.f1594o), dVar.f1592m);
        Iterator<l.a> it = dVar.f1581b.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        Bundle bundle = dVar.D;
        if (bundle != null) {
            this.f1616g.putAll(bundle);
        }
        int i6 = Build.VERSION.SDK_INT;
        this.f1613d = dVar.H;
        this.f1614e = dVar.I;
        b.a(this.f1611b, dVar.f1593n);
        d.i(this.f1611b, dVar.f1605z);
        d.g(this.f1611b, dVar.f1602w);
        d.j(this.f1611b, dVar.f1604y);
        d.h(this.f1611b, dVar.f1603x);
        this.f1617h = dVar.O;
        e.b(this.f1611b, dVar.C);
        e.c(this.f1611b, dVar.E);
        e.f(this.f1611b, dVar.F);
        e.d(this.f1611b, dVar.G);
        e.e(this.f1611b, notification.sound, notification.audioAttributes);
        List<String> e5 = i6 < 28 ? e(f(dVar.f1582c), dVar.U) : dVar.U;
        if (e5 != null && !e5.isEmpty()) {
            for (String a5 : e5) {
                e.a(this.f1611b, a5);
            }
        }
        this.f1618i = dVar.J;
        if (dVar.f1583d.size() > 0) {
            Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i7 = 0; i7 < dVar.f1583d.size(); i7++) {
                bundle4.putBundle(Integer.toString(i7), g0.a(dVar.f1583d.get(i7)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
            this.f1616g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i8 = Build.VERSION.SDK_INT;
        Object obj = dVar.T;
        if (obj != null) {
            f.b(this.f1611b, obj);
        }
        if (i8 >= 24) {
            c.a(this.f1611b, dVar.D);
            g.e(this.f1611b, dVar.f1598s);
            RemoteViews remoteViews = dVar.H;
            if (remoteViews != null) {
                g.c(this.f1611b, remoteViews);
            }
            RemoteViews remoteViews2 = dVar.I;
            if (remoteViews2 != null) {
                g.b(this.f1611b, remoteViews2);
            }
            RemoteViews remoteViews3 = dVar.J;
            if (remoteViews3 != null) {
                g.d(this.f1611b, remoteViews3);
            }
        }
        if (i8 >= 26) {
            h.b(this.f1611b, dVar.L);
            h.e(this.f1611b, dVar.f1597r);
            h.f(this.f1611b, dVar.M);
            h.g(this.f1611b, dVar.N);
            h.d(this.f1611b, dVar.O);
            if (dVar.B) {
                h.c(this.f1611b, dVar.A);
            }
            if (!TextUtils.isEmpty(dVar.K)) {
                this.f1611b.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (i8 >= 28) {
            Iterator<t0> it2 = dVar.f1582c.iterator();
            while (it2.hasNext()) {
                i.a(this.f1611b, it2.next().h());
            }
        }
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 29) {
            j.a(this.f1611b, dVar.Q);
            j.b(this.f1611b, l.c.a((l.c) null));
        }
        if (i9 >= 31 && (i5 = dVar.P) != 0) {
            k.b(this.f1611b, i5);
        }
        if (dVar.S) {
            if (this.f1612c.f1603x) {
                this.f1617h = 2;
            } else {
                this.f1617h = 1;
            }
            this.f1611b.setVibrate((long[]) null);
            this.f1611b.setSound((Uri) null);
            int i10 = notification.defaults & -2 & -3;
            notification.defaults = i10;
            this.f1611b.setDefaults(i10);
            if (i9 >= 26) {
                if (TextUtils.isEmpty(this.f1612c.f1602w)) {
                    d.g(this.f1611b, "silent");
                }
                h.d(this.f1611b, this.f1617h);
            }
        }
    }

    private void b(l.a aVar) {
        IconCompat d5 = aVar.d();
        Notification.Action.Builder a5 = f.a(d5 != null ? d5.o() : null, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput c5 : v0.b(aVar.e())) {
                d.c(a5, c5);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 24) {
            g.a(a5, aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i5 >= 28) {
            i.b(a5, aVar.f());
        }
        if (i5 >= 29) {
            j.c(a5, aVar.j());
        }
        if (i5 >= 31) {
            k.a(a5, aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        d.b(a5, bundle);
        d.a(this.f1611b, d.d(a5));
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        m.b bVar = new m.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> f(List<t0> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (t0 g5 : list) {
            arrayList.add(g5.g());
        }
        return arrayList;
    }

    private void g(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & -2 & -3;
    }

    public Notification.Builder a() {
        return this.f1611b;
    }

    public Notification c() {
        Bundle a5;
        RemoteViews f5;
        RemoteViews d5;
        l.e eVar = this.f1612c.f1595p;
        if (eVar != null) {
            eVar.b(this);
        }
        RemoteViews e5 = eVar != null ? eVar.e(this) : null;
        Notification d6 = d();
        if (!(e5 == null && (e5 = this.f1612c.H) == null)) {
            d6.contentView = e5;
        }
        if (!(eVar == null || (d5 = eVar.d(this)) == null)) {
            d6.bigContentView = d5;
        }
        if (!(eVar == null || (f5 = this.f1612c.f1595p.f(this)) == null)) {
            d6.headsUpContentView = f5;
        }
        if (!(eVar == null || (a5 = l.a(d6)) == null)) {
            eVar.a(a5);
        }
        return d6;
    }

    /* access modifiers changed from: protected */
    public Notification d() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            return a.a(this.f1611b);
        }
        if (i5 >= 24) {
            Notification a5 = a.a(this.f1611b);
            if (this.f1617h != 0) {
                if (!(d.f(a5) == null || (a5.flags & 512) == 0 || this.f1617h != 2)) {
                    g(a5);
                }
                if (d.f(a5) != null && (a5.flags & 512) == 0 && this.f1617h == 1) {
                    g(a5);
                }
            }
            return a5;
        }
        c.a(this.f1611b, this.f1616g);
        Notification a6 = a.a(this.f1611b);
        RemoteViews remoteViews = this.f1613d;
        if (remoteViews != null) {
            a6.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f1614e;
        if (remoteViews2 != null) {
            a6.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f1618i;
        if (remoteViews3 != null) {
            a6.headsUpContentView = remoteViews3;
        }
        if (this.f1617h != 0) {
            if (!(d.f(a6) == null || (a6.flags & 512) == 0 || this.f1617h != 2)) {
                g(a6);
            }
            if (d.f(a6) != null && (a6.flags & 512) == 0 && this.f1617h == 1) {
                g(a6);
            }
        }
        return a6;
    }
}
