package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.d;
import androidx.savedstate.a;
import f4.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import m3.n;

public final class u {

    /* renamed from: f  reason: collision with root package name */
    public static final a f2601f = new a((g) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Class<? extends Object>[] f2602g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f2603a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, a.c> f2604b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object> f2605c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, f<Object>> f2606d;

    /* renamed from: e  reason: collision with root package name */
    private final a.c f2607e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final u a(Bundle bundle, Bundle bundle2) {
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
                if ((parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) ? false : true) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int size = parcelableArrayList.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        Object obj = parcelableArrayList.get(i5);
                        k.c(obj, "null cannot be cast to non-null type kotlin.String");
                        linkedHashMap.put((String) obj, parcelableArrayList2.get(i5));
                    }
                    return new u(linkedHashMap);
                }
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            } else if (bundle2 == null) {
                return new u();
            } else {
                HashMap hashMap = new HashMap();
                for (String next : bundle2.keySet()) {
                    k.d(next, "key");
                    hashMap.put(next, bundle2.get(next));
                }
                return new u(hashMap);
            }
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : u.f2602g) {
                k.b(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    public u() {
        this.f2603a = new LinkedHashMap();
        this.f2604b = new LinkedHashMap();
        this.f2605c = new LinkedHashMap();
        this.f2606d = new LinkedHashMap();
        this.f2607e = new t(this);
    }

    public u(Map<String, ? extends Object> map) {
        k.e(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f2603a = linkedHashMap;
        this.f2604b = new LinkedHashMap();
        this.f2605c = new LinkedHashMap();
        this.f2606d = new LinkedHashMap();
        this.f2607e = new t(this);
        linkedHashMap.putAll(map);
    }

    /* access modifiers changed from: private */
    public static final Bundle d(u uVar) {
        k.e(uVar, "this$0");
        for (Map.Entry entry : e0.k(uVar.f2604b).entrySet()) {
            uVar.e((String) entry.getKey(), ((a.c) entry.getValue()).a());
        }
        Set<String> keySet = uVar.f2603a.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String next : keySet) {
            arrayList.add(next);
            arrayList2.add(uVar.f2603a.get(next));
        }
        return d.a(n.a("keys", arrayList), n.a("values", arrayList2));
    }

    public final a.c c() {
        return this.f2607e;
    }

    public final <T> void e(String str, T t5) {
        k.e(str, "key");
        if (f2601f.b(t5)) {
            Object obj = this.f2605c.get(str);
            o oVar = obj instanceof o ? (o) obj : null;
            if (oVar != null) {
                oVar.i(t5);
            } else {
                this.f2603a.put(str, t5);
            }
            f fVar = this.f2606d.get(str);
            if (fVar != null) {
                fVar.setValue(t5);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't put value with type ");
        k.b(t5);
        sb.append(t5.getClass());
        sb.append(" into saved state");
        throw new IllegalArgumentException(sb.toString());
    }
}
