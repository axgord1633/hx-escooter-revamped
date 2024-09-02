package n0;

import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f5991a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5992b;

    private a(String str, String str2) {
        this.f5991a = str;
        this.f5992b = str2;
    }

    public static a c(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new a((String) map.get("name"), (String) map.get("defType"));
    }

    public String a() {
        return this.f5992b;
    }

    public String b() {
        return this.f5991a;
    }
}
