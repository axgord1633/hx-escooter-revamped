package s1;

import java.lang.ref.WeakReference;
import r1.b;

class d extends WeakReference<b> {

    public interface a {
        d a(b bVar);
    }

    d(b bVar) {
        super(bVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(Object obj) {
        b bVar = (b) get();
        return (obj instanceof b) && bVar != null && bVar.a() == ((b) obj).a();
    }

    public boolean b() {
        return get() == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WeakReference)) {
            return false;
        }
        b bVar = (b) get();
        Object obj2 = ((WeakReference) obj).get();
        return bVar != null && (obj2 instanceof b) && bVar.a().equals(((b) obj2).a());
    }

    public int hashCode() {
        if (get() != null) {
            return ((b) get()).hashCode();
        }
        return 0;
    }
}
