package f2;

import d2.d0;
import java.util.HashMap;
import java.util.Map;

public class h {
    public static Map<String, Object> a(e eVar) {
        d0 b5 = eVar.b();
        if (b5 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sql", b5.c());
        hashMap.put("arguments", b5.b());
        return hashMap;
    }
}
