package f2;

import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    final Map<String, Object> f4601a;

    /* renamed from: b  reason: collision with root package name */
    final a f4602b = new a();

    /* renamed from: c  reason: collision with root package name */
    final boolean f4603c;

    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        Object f4604a;

        /* renamed from: b  reason: collision with root package name */
        String f4605b;

        /* renamed from: c  reason: collision with root package name */
        String f4606c;

        /* renamed from: d  reason: collision with root package name */
        Object f4607d;

        public a() {
        }

        public void error(String str, String str2, Object obj) {
            this.f4605b = str;
            this.f4606c = str2;
            this.f4607d = obj;
        }

        public void success(Object obj) {
            this.f4604a = obj;
        }
    }

    public c(Map<String, Object> map, boolean z4) {
        this.f4601a = map;
        this.f4603c = z4;
    }

    public <T> T a(String str) {
        return this.f4601a.get(str);
    }

    public boolean c() {
        return this.f4603c;
    }

    public boolean g(String str) {
        return this.f4601a.containsKey(str);
    }

    public String getMethod() {
        return (String) this.f4601a.get("method");
    }

    public f l() {
        return this.f4602b;
    }

    public Map<String, Object> m() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("code", this.f4602b.f4605b);
        hashMap2.put("message", this.f4602b.f4606c);
        hashMap2.put("data", this.f4602b.f4607d);
        hashMap.put("error", hashMap2);
        return hashMap;
    }

    public Map<String, Object> n() {
        HashMap hashMap = new HashMap();
        hashMap.put("result", this.f4602b.f4604a);
        return hashMap;
    }

    public void o(MethodChannel.Result result) {
        a aVar = this.f4602b;
        result.error(aVar.f4605b, aVar.f4606c, aVar.f4607d);
    }

    public void p(List<Map<String, Object>> list) {
        if (!c()) {
            list.add(m());
        }
    }

    public void q(List<Map<String, Object>> list) {
        if (!c()) {
            list.add(n());
        }
    }
}
