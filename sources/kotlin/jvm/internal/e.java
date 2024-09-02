package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import v3.b;
import v3.d;
import v3.f;
import v3.g;
import v3.h;
import v3.i;
import v3.j;
import v3.k;
import v3.l;
import v3.m;
import v3.n;
import v3.o;
import v3.p;
import v3.q;
import v3.r;
import v3.s;
import v3.t;
import v3.u;
import v3.v;
import v3.w;
import z3.c;

public final class e implements c<Object>, d {

    /* renamed from: f  reason: collision with root package name */
    public static final a f5560f = new a((g) null);

    /* renamed from: g  reason: collision with root package name */
    private static final Map<Class<? extends m3.c<?>>, Integer> f5561g;

    /* renamed from: h  reason: collision with root package name */
    private static final HashMap<String, String> f5562h;

    /* renamed from: i  reason: collision with root package name */
    private static final HashMap<String, String> f5563i;

    /* renamed from: j  reason: collision with root package name */
    private static final HashMap<String, String> f5564j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Map<String, String> f5565k;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f5566e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a(Class<?> cls) {
            String str;
            k.e(cls, "jClass");
            String str2 = null;
            if (!cls.isAnonymousClass()) {
                if (cls.isLocalClass()) {
                    String simpleName = cls.getSimpleName();
                    Method enclosingMethod = cls.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        k.d(simpleName, "name");
                        String T = n.T(simpleName, enclosingMethod.getName() + '$', (String) null, 2, (Object) null);
                        if (T != null) {
                            return T;
                        }
                    }
                    Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                    k.d(simpleName, "name");
                    if (enclosingConstructor == null) {
                        return n.S(simpleName, '$', (String) null, 2, (Object) null);
                    }
                    return n.T(simpleName, enclosingConstructor.getName() + '$', (String) null, 2, (Object) null);
                } else if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) e.f5565k.get(componentType.getName())) != null) {
                        str2 = str + "Array";
                    }
                    if (str2 == null) {
                        return "Array";
                    }
                } else {
                    String str3 = (String) e.f5565k.get(cls.getName());
                    return str3 == null ? cls.getSimpleName() : str3;
                }
            }
            return str2;
        }
    }

    static {
        int i5 = 0;
        List f5 = n.f(v3.a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, b.class, v3.c.class, d.class, v3.e.class, f.class, g.class, h.class, i.class, j.class, k.class, m.class, n.class, o.class);
        ArrayList arrayList = new ArrayList(o.i(f5, 10));
        for (Object next : f5) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                n.h();
            }
            arrayList.add(m3.n.a((Class) next, Integer.valueOf(i5)));
            i5 = i6;
        }
        f5561g = e0.i(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f5562h = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f5563i = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        k.d(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            k.d(str, "kotlinName");
            sb.append(n.V(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            m3.j a5 = m3.n.a(sb2, str + ".Companion");
            hashMap3.put(a5.e(), a5.f());
        }
        for (Map.Entry next2 : f5561g.entrySet()) {
            int intValue = ((Number) next2.getValue()).intValue();
            String name = ((Class) next2.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        f5564j = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(d0.a(hashMap3.size()));
        for (Map.Entry entry : hashMap3.entrySet()) {
            linkedHashMap.put(entry.getKey(), n.V((String) entry.getValue(), '.', (String) null, 2, (Object) null));
        }
        f5565k = linkedHashMap;
    }

    public e(Class<?> cls) {
        k.e(cls, "jClass");
        this.f5566e = cls;
    }

    public String a() {
        return f5560f.a(b());
    }

    public Class<?> b() {
        return this.f5566e;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && k.a(u3.a.b(this), u3.a.b((c) obj));
    }

    public int hashCode() {
        return u3.a.b(this).hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
