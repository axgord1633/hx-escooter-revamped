package s1;

import java.util.Map;
import r1.b;

class a implements Map.Entry<String, b> {

    /* renamed from: e  reason: collision with root package name */
    private final String f6731e;

    /* renamed from: f  reason: collision with root package name */
    private final d f6732f;

    a(String str, d dVar) {
        this.f6731e = str;
        this.f6732f = dVar;
    }

    /* renamed from: a */
    public String getKey() {
        return this.f6731e;
    }

    /* renamed from: b */
    public b getValue() {
        return (b) this.f6732f.get();
    }

    /* renamed from: c */
    public b setValue(b bVar) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f6731e.equals(aVar.getKey()) && this.f6732f.equals(aVar.f6732f);
    }

    public int hashCode() {
        return (this.f6731e.hashCode() * 31) + this.f6732f.hashCode();
    }
}
