package androidx.core.util;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final float f1844a;

    /* renamed from: b  reason: collision with root package name */
    private final float f1845b;

    public e(float f5, float f6) {
        this.f1844a = d.b(f5, "width");
        this.f1845b = d.b(f6, "height");
    }

    public float a() {
        return this.f1845b;
    }

    public float b() {
        return this.f1844a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return eVar.f1844a == this.f1844a && eVar.f1845b == this.f1845b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f1844a) ^ Float.floatToIntBits(this.f1845b);
    }

    public String toString() {
        return this.f1844a + "x" + this.f1845b;
    }
}
