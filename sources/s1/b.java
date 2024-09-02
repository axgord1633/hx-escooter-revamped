package s1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import s1.d;

public class b implements Map<String, r1.b> {

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, d> f6733e;

    /* renamed from: f  reason: collision with root package name */
    private final d.a f6734f;

    class a implements d.a {
        a() {
        }

        public d a(r1.b bVar) {
            return new d(bVar);
        }
    }

    public b() {
        this(new a());
    }

    b(d.a aVar) {
        this.f6733e = new HashMap<>();
        this.f6734f = aVar;
    }

    private void a() {
        Iterator<Map.Entry<String, d>> it = this.f6733e.entrySet().iterator();
        while (it.hasNext()) {
            if (((d) it.next().getValue()).b()) {
                it.remove();
            }
        }
    }

    /* renamed from: b */
    public r1.b get(Object obj) {
        d dVar = this.f6733e.get(obj);
        if (dVar != null) {
            return (r1.b) dVar.get();
        }
        return null;
    }

    /* renamed from: c */
    public r1.b put(String str, r1.b bVar) {
        this.f6733e.put(str, this.f6734f.a(bVar));
        a();
        return bVar;
    }

    public void clear() {
        this.f6733e.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f6733e.containsKey(obj) && get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        for (d a5 : this.f6733e.values()) {
            if (a5.a(obj)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public r1.b remove(Object obj) {
        d remove = this.f6733e.remove(obj);
        a();
        if (remove != null) {
            return (r1.b) remove.get();
        }
        return null;
    }

    public Set<Map.Entry<String, r1.b>> entrySet() {
        HashSet hashSet = new HashSet();
        for (Map.Entry next : this.f6733e.entrySet()) {
            d dVar = (d) next.getValue();
            if (!dVar.b()) {
                hashSet.add(new a((String) next.getKey(), this.f6734f.a((r1.b) dVar.get())));
            }
        }
        return hashSet;
    }

    public boolean isEmpty() {
        a();
        return this.f6733e.isEmpty();
    }

    public Set<String> keySet() {
        return this.f6733e.keySet();
    }

    public void putAll(Map<? extends String, ? extends r1.b> map) {
        for (Map.Entry next : map.entrySet()) {
            put((String) next.getKey(), (r1.b) next.getValue());
        }
    }

    public int size() {
        a();
        return this.f6733e.size();
    }

    public Collection<r1.b> values() {
        ArrayList arrayList = new ArrayList();
        for (d next : this.f6733e.values()) {
            if (!next.b()) {
                arrayList.add((r1.b) next.get());
            }
        }
        return arrayList;
    }
}
