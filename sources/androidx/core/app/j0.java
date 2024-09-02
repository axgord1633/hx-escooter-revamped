package androidx.core.app;

import a.a;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j0 {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1544c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static String f1545d;

    /* renamed from: e  reason: collision with root package name */
    private static Set<String> f1546e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private static final Object f1547f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static e f1548g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f1549a;

    /* renamed from: b  reason: collision with root package name */
    private final NotificationManager f1550b;

    static class a {
        static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    static class b {
        static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        static void b(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }

        static void c(NotificationManager notificationManager, List<NotificationChannelGroup> list) {
            notificationManager.createNotificationChannelGroups(list);
        }

        static void d(NotificationManager notificationManager, List<NotificationChannel> list) {
            notificationManager.createNotificationChannels(list);
        }

        static void e(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannel(str);
        }

        static void f(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannelGroup(str);
        }

        static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        static String h(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        static NotificationChannel i(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannel(str);
        }

        static List<NotificationChannelGroup> j(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannelGroups();
        }

        static List<NotificationChannel> k(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    private static class c implements f {

        /* renamed from: a  reason: collision with root package name */
        final String f1551a;

        /* renamed from: b  reason: collision with root package name */
        final int f1552b;

        /* renamed from: c  reason: collision with root package name */
        final String f1553c;

        /* renamed from: d  reason: collision with root package name */
        final Notification f1554d;

        c(String str, int i5, String str2, Notification notification) {
            this.f1551a = str;
            this.f1552b = i5;
            this.f1553c = str2;
            this.f1554d = notification;
        }

        public void a(a.a aVar) {
            aVar.t(this.f1551a, this.f1552b, this.f1553c, this.f1554d);
        }

        public String toString() {
            return "NotifyTask[" + "packageName:" + this.f1551a + ", id:" + this.f1552b + ", tag:" + this.f1553c + "]";
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f1555a;

        /* renamed from: b  reason: collision with root package name */
        final IBinder f1556b;

        d(ComponentName componentName, IBinder iBinder) {
            this.f1555a = componentName;
            this.f1556b = iBinder;
        }
    }

    private static class e implements Handler.Callback, ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1557a;

        /* renamed from: b  reason: collision with root package name */
        private final HandlerThread f1558b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f1559c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<ComponentName, a> f1560d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private Set<String> f1561e = new HashSet();

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            final ComponentName f1562a;

            /* renamed from: b  reason: collision with root package name */
            boolean f1563b = false;

            /* renamed from: c  reason: collision with root package name */
            a.a f1564c;

            /* renamed from: d  reason: collision with root package name */
            ArrayDeque<f> f1565d = new ArrayDeque<>();

            /* renamed from: e  reason: collision with root package name */
            int f1566e = 0;

            a(ComponentName componentName) {
                this.f1562a = componentName;
            }
        }

        e(Context context) {
            this.f1557a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f1558b = handlerThread;
            handlerThread.start();
            this.f1559c = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(a aVar) {
            if (aVar.f1563b) {
                return true;
            }
            boolean bindService = this.f1557a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f1562a), this, 33);
            aVar.f1563b = bindService;
            if (bindService) {
                aVar.f1566e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f1562a);
                this.f1557a.unbindService(this);
            }
            return aVar.f1563b;
        }

        private void b(a aVar) {
            if (aVar.f1563b) {
                this.f1557a.unbindService(this);
                aVar.f1563b = false;
            }
            aVar.f1564c = null;
        }

        private void c(f fVar) {
            j();
            for (a next : this.f1560d.values()) {
                next.f1565d.add(fVar);
                g(next);
            }
        }

        private void d(ComponentName componentName) {
            a aVar = this.f1560d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f1560d.get(componentName);
            if (aVar != null) {
                aVar.f1564c = a.C0000a.a(iBinder);
                aVar.f1566e = 0;
                g(aVar);
            }
        }

        private void f(ComponentName componentName) {
            a aVar = this.f1560d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f1562a + ", " + aVar.f1565d.size() + " queued tasks");
            }
            if (!aVar.f1565d.isEmpty()) {
                if (!a(aVar) || aVar.f1564c == null) {
                    i(aVar);
                    return;
                }
                while (true) {
                    f peek = aVar.f1565d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.a(aVar.f1564c);
                        aVar.f1565d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.f1562a);
                        }
                    } catch (RemoteException e5) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f1562a, e5);
                    }
                }
                if (!aVar.f1565d.isEmpty()) {
                    i(aVar);
                }
            }
        }

        private void i(a aVar) {
            if (!this.f1559c.hasMessages(3, aVar.f1562a)) {
                int i5 = aVar.f1566e + 1;
                aVar.f1566e = i5;
                if (i5 > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + aVar.f1565d.size() + " tasks to " + aVar.f1562a + " after " + aVar.f1566e + " retries");
                    aVar.f1565d.clear();
                    return;
                }
                int i6 = (1 << (i5 - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i6 + " ms");
                }
                this.f1559c.sendMessageDelayed(this.f1559c.obtainMessage(3, aVar.f1562a), (long) i6);
            }
        }

        private void j() {
            Set<String> d5 = j0.d(this.f1557a);
            if (!d5.equals(this.f1561e)) {
                this.f1561e = d5;
                List<ResolveInfo> queryIntentServices = this.f1557a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet<ComponentName> hashSet = new HashSet<>();
                for (ResolveInfo next : queryIntentServices) {
                    if (d5.contains(next.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = next.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (next.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f1560d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f1560d.put(componentName2, new a(componentName2));
                    }
                }
                Iterator<Map.Entry<ComponentName, a>> it = this.f1560d.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next2 = it.next();
                    if (!hashSet.contains(next2.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + next2.getKey());
                        }
                        b((a) next2.getValue());
                        it.remove();
                    }
                }
            }
        }

        public void h(f fVar) {
            this.f1559c.obtainMessage(0, fVar).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == 0) {
                c((f) message.obj);
                return true;
            } else if (i5 == 1) {
                d dVar = (d) message.obj;
                e(dVar.f1555a, dVar.f1556b);
                return true;
            } else if (i5 == 2) {
                f((ComponentName) message.obj);
                return true;
            } else if (i5 != 3) {
                return false;
            } else {
                d((ComponentName) message.obj);
                return true;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f1559c.obtainMessage(1, new d(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f1559c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    private interface f {
        void a(a.a aVar);
    }

    private j0(Context context) {
        this.f1549a = context;
        this.f1550b = (NotificationManager) context.getSystemService("notification");
    }

    public static j0 c(Context context) {
        return new j0(context);
    }

    public static Set<String> d(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f1544c) {
            if (string != null) {
                if (!string.equals(f1545d)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    f1546e = hashSet;
                    f1545d = string;
                }
            }
            set = f1546e;
        }
        return set;
    }

    private void g(f fVar) {
        synchronized (f1547f) {
            if (f1548g == null) {
                f1548g = new e(this.f1549a.getApplicationContext());
            }
            f1548g.h(fVar);
        }
    }

    private static boolean h(Notification notification) {
        Bundle a5 = l.a(notification);
        return a5 != null && a5.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(this.f1550b);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f1549a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f1549a.getApplicationInfo();
        String packageName = this.f1549a.getApplicationContext().getPackageName();
        int i5 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i5), packageName})).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void b(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.a(this.f1550b, notificationChannel);
        }
    }

    public void e(int i5, Notification notification) {
        f((String) null, i5, notification);
    }

    public void f(String str, int i5, Notification notification) {
        if (h(notification)) {
            g(new c(this.f1549a.getPackageName(), i5, str, notification));
            this.f1550b.cancel(str, i5);
            return;
        }
        this.f1550b.notify(str, i5, notification);
    }
}
