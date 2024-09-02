package g2;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: g2.a$a  reason: collision with other inner class name */
    public static class C0079a {

        /* renamed from: a  reason: collision with root package name */
        private Boolean f4732a;

        static C0079a a(Map<String, Object> map) {
            C0079a aVar = new C0079a();
            aVar.f4732a = (Boolean) map.get("enabled");
            return aVar;
        }

        public void b(Boolean bool) {
            this.f4732a = bool;
        }

        /* access modifiers changed from: package-private */
        public Map<String, Object> c() {
            HashMap hashMap = new HashMap();
            hashMap.put("enabled", this.f4732a);
            return hashMap;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private Boolean f4733a;

        static b a(Map<String, Object> map) {
            b bVar = new b();
            bVar.f4733a = (Boolean) map.get("enable");
            return bVar;
        }

        public Boolean b() {
            return this.f4733a;
        }

        /* access modifiers changed from: package-private */
        public Map<String, Object> c() {
            HashMap hashMap = new HashMap();
            hashMap.put("enable", this.f4733a);
            return hashMap;
        }
    }

    public interface c {
        void a(b bVar);

        C0079a isEnabled();
    }

    private static class d extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final d f4734a = new d();

        private d() {
        }

        /* access modifiers changed from: protected */
        public Object readValueOfType(byte b5, ByteBuffer byteBuffer) {
            return b5 != Byte.MIN_VALUE ? b5 != -127 ? super.readValueOfType(b5, byteBuffer) : b.a((Map) readValue(byteBuffer)) : C0079a.a((Map) readValue(byteBuffer));
        }

        /* access modifiers changed from: protected */
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            Map<String, Object> c5;
            if (obj instanceof C0079a) {
                byteArrayOutputStream.write(128);
                c5 = ((C0079a) obj).c();
            } else if (obj instanceof b) {
                byteArrayOutputStream.write(129);
                c5 = ((b) obj).c();
            } else {
                super.writeValue(byteArrayOutputStream, obj);
                return;
            }
            writeValue(byteArrayOutputStream, c5);
        }
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> b(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
