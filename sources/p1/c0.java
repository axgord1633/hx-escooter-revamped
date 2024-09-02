package p1;

public class c0 {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f6422a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f6423b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f6424c;

    /* renamed from: d  reason: collision with root package name */
    private final Boolean f6425d;

    /* renamed from: e  reason: collision with root package name */
    private final Boolean f6426e;

    /* renamed from: f  reason: collision with root package name */
    private final b f6427f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f6428a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f6429b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f6430c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f6431d;

        /* renamed from: e  reason: collision with root package name */
        private Boolean f6432e;

        /* renamed from: f  reason: collision with root package name */
        private b f6433f;

        public c0 a() {
            return new c0(this.f6428a, this.f6429b, this.f6430c, this.f6431d, this.f6432e, this.f6433f);
        }

        public a b(Integer num) {
            this.f6428a = num;
            return this;
        }

        public a c(Integer num) {
            this.f6429b = num;
            return this;
        }

        public a d(Boolean bool) {
            this.f6431d = bool;
            return this;
        }

        public a e(Integer num) {
            this.f6430c = num;
            return this;
        }
    }

    public interface b {
        void a(int i5, String str, String str2);
    }

    c0(Integer num, Integer num2, Integer num3, Boolean bool, Boolean bool2, b bVar) {
        this.f6422a = num;
        this.f6423b = num2;
        this.f6424c = num3;
        this.f6425d = bool;
        this.f6426e = bool2;
        this.f6427f = bVar;
    }

    public Integer a() {
        return this.f6422a;
    }

    public b b() {
        return this.f6427f;
    }

    public Integer c() {
        return this.f6423b;
    }

    public Boolean d() {
        return this.f6425d;
    }

    public Boolean e() {
        return this.f6426e;
    }

    public Integer f() {
        return this.f6424c;
    }

    public String toString() {
        return "LogOptions{logLevel=" + this.f6422a + ", macAddressLogSetting=" + this.f6423b + ", uuidLogSetting=" + this.f6424c + ", shouldLogAttributeValues=" + this.f6425d + ", shouldLogScannedPeripherals=" + this.f6426e + ", logger=" + this.f6427f + '}';
    }
}
