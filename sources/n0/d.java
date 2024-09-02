package n0;

import java.util.Map;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f6000a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6001b;

    /* renamed from: c  reason: collision with root package name */
    private final a f6002c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f6003d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f6004e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6005f;

    private d(String str, String str2, a aVar, boolean z4, boolean z5, boolean z6) {
        this.f6000a = str;
        this.f6001b = str2;
        this.f6002c = aVar;
        this.f6003d = z4;
        this.f6004e = z5;
        this.f6005f = z6;
    }

    public static d g(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new d((String) map.get("notificationTitle"), (String) map.get("notificationText"), a.c((Map) map.get("notificationIcon")), ((Boolean) map.get("enableWifiLock")).booleanValue(), ((Boolean) map.get("enableWakeLock")).booleanValue(), ((Boolean) map.get("setOngoing")).booleanValue());
    }

    public a a() {
        return this.f6002c;
    }

    public String b() {
        return this.f6001b;
    }

    public String c() {
        return this.f6000a;
    }

    public boolean d() {
        return this.f6004e;
    }

    public boolean e() {
        return this.f6003d;
    }

    public boolean f() {
        return this.f6005f;
    }
}
