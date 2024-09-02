package kotlin.jvm.internal;

public final class m implements d {

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f5568e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5569f;

    public m(Class<?> cls, String str) {
        k.e(cls, "jClass");
        k.e(str, "moduleName");
        this.f5568e = cls;
        this.f5569f = str;
    }

    public Class<?> b() {
        return this.f5568e;
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && k.a(b(), ((m) obj).b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
