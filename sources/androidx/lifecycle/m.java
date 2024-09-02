package androidx.lifecycle;

import com.yalantis.ucrop.BuildConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f2594a = new m();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<?>, Integer> f2595b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<?>, List<Constructor<? extends c>>> f2596c = new HashMap();

    private m() {
    }

    private final c a(Constructor<? extends c> constructor, Object obj) {
        try {
            Object newInstance = constructor.newInstance(new Object[]{obj});
            k.d(newInstance, "{\n            constructo…tance(`object`)\n        }");
            return (c) newInstance;
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException(e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    private final Constructor<? extends c> b(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : BuildConfig.FLAVOR;
            k.d(name, "fullPackage");
            if (!(name.length() == 0)) {
                k.d(canonicalName, "name");
                canonicalName = canonicalName.substring(name.length() + 1);
                k.d(canonicalName, "this as java.lang.String).substring(startIndex)");
            }
            k.d(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String c5 = c(canonicalName);
            if (!(name.length() == 0)) {
                c5 = name + '.' + c5;
            }
            Class<?> cls2 = Class.forName(c5);
            k.c(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(new Class[]{cls});
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException(e5);
        }
    }

    public static final String c(String str) {
        k.e(str, "className");
        return m.m(str, ".", "_", false, 4, (Object) null) + "_LifecycleAdapter";
    }

    private final int d(Class<?> cls) {
        Map<Class<?>, Integer> map = f2595b;
        Integer num = map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g5 = g(cls);
        map.put(cls, Integer.valueOf(g5));
        return g5;
    }

    private final boolean e(Class<?> cls) {
        return cls != null && i.class.isAssignableFrom(cls);
    }

    public static final h f(Object obj) {
        k.e(obj, "object");
        boolean z4 = obj instanceof h;
        boolean z5 = obj instanceof DefaultLifecycleObserver;
        if (z4 && z5) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) obj, (h) obj);
        }
        if (z5) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) obj, (h) null);
        }
        if (z4) {
            return (h) obj;
        }
        Class<?> cls = obj.getClass();
        m mVar = f2594a;
        if (mVar.d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends c>> list = f2596c.get(cls);
        k.b(list);
        List list2 = list;
        if (list2.size() == 1) {
            return new SingleGeneratedAdapterObserver(mVar.a((Constructor) list2.get(0), obj));
        }
        int size = list2.size();
        c[] cVarArr = new c[size];
        for (int i5 = 0; i5 < size; i5++) {
            cVarArr[i5] = f2594a.a((Constructor) list2.get(i5), obj);
        }
        return new CompositeGeneratedAdaptersObserver(cVarArr);
    }

    private final int g(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends c> b5 = b(cls);
        if (b5 != null) {
            f2596c.put(cls, m.b(b5));
            return 2;
        } else if (b.f2554c.d(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (e(superclass)) {
                k.d(superclass, "superclass");
                if (d(superclass) == 1) {
                    return 1;
                }
                List<Constructor<? extends c>> list = f2596c.get(superclass);
                k.b(list);
                arrayList = new ArrayList(list);
            }
            Class[] interfaces = cls.getInterfaces();
            k.d(interfaces, "klass.interfaces");
            for (Class cls2 : interfaces) {
                if (e(cls2)) {
                    k.d(cls2, "intrface");
                    if (d(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    List<Constructor<? extends c>> list2 = f2596c.get(cls2);
                    k.b(list2);
                    arrayList.addAll(list2);
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f2596c.put(cls, arrayList);
            return 2;
        }
    }
}
