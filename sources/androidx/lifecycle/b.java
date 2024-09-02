package androidx.lifecycle;

import androidx.lifecycle.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
final class b {

    /* renamed from: c  reason: collision with root package name */
    static b f2554c = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, a> f2555a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f2556b = new HashMap();

    @Deprecated
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map<f.a, List<C0039b>> f2557a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<C0039b, f.a> f2558b;

        a(Map<C0039b, f.a> map) {
            this.f2558b = map;
            for (Map.Entry next : map.entrySet()) {
                f.a aVar = (f.a) next.getValue();
                List list = this.f2557a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f2557a.put(aVar, list);
                }
                list.add((C0039b) next.getKey());
            }
        }

        private static void b(List<C0039b> list, j jVar, f.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(jVar, aVar, obj);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(j jVar, f.a aVar, Object obj) {
            b(this.f2557a.get(aVar), jVar, aVar, obj);
            b(this.f2557a.get(f.a.ON_ANY), jVar, aVar, obj);
        }
    }

    @Deprecated
    /* renamed from: androidx.lifecycle.b$b  reason: collision with other inner class name */
    static final class C0039b {

        /* renamed from: a  reason: collision with root package name */
        final int f2559a;

        /* renamed from: b  reason: collision with root package name */
        final Method f2560b;

        C0039b(int i5, Method method) {
            this.f2559a = i5;
            this.f2560b = method;
            method.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        public void a(j jVar, f.a aVar, Object obj) {
            try {
                int i5 = this.f2559a;
                if (i5 == 0) {
                    this.f2560b.invoke(obj, new Object[0]);
                } else if (i5 == 1) {
                    this.f2560b.invoke(obj, new Object[]{jVar});
                } else if (i5 == 2) {
                    this.f2560b.invoke(obj, new Object[]{jVar, aVar});
                }
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Failed to call observer method", e5.getCause());
            } catch (IllegalAccessException e6) {
                throw new RuntimeException(e6);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0039b)) {
                return false;
            }
            C0039b bVar = (C0039b) obj;
            return this.f2559a == bVar.f2559a && this.f2560b.getName().equals(bVar.f2560b.getName());
        }

        public int hashCode() {
            return (this.f2559a * 31) + this.f2560b.getName().hashCode();
        }
    }

    b() {
    }

    private a a(Class<?> cls, Method[] methodArr) {
        int i5;
        a c5;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (c5 = c(superclass)) == null)) {
            hashMap.putAll(c5.f2558b);
        }
        for (Class c6 : cls.getInterfaces()) {
            for (Map.Entry next : c(c6).f2558b.entrySet()) {
                e(hashMap, (C0039b) next.getKey(), (f.a) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z4 = false;
        for (Method method : methodArr) {
            q qVar = (q) method.getAnnotation(q.class);
            if (qVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i5 = 0;
                } else if (j.class.isAssignableFrom(parameterTypes[0])) {
                    i5 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                f.a value = qVar.value();
                if (parameterTypes.length > 1) {
                    if (!f.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == f.a.ON_ANY) {
                        i5 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new C0039b(i5, method), value, cls);
                    z4 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f2555a.put(cls, aVar);
        this.f2556b.put(cls, Boolean.valueOf(z4));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e5) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e5);
        }
    }

    private void e(Map<C0039b, f.a> map, C0039b bVar, f.a aVar, Class<?> cls) {
        f.a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f2560b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public a c(Class<?> cls) {
        a aVar = this.f2555a.get(cls);
        return aVar != null ? aVar : a(cls, (Method[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f2556b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b5 = b(cls);
        for (Method annotation : b5) {
            if (((q) annotation.getAnnotation(q.class)) != null) {
                a(cls, b5);
                return true;
            }
        }
        this.f2556b.put(cls, Boolean.FALSE);
        return false;
    }
}
