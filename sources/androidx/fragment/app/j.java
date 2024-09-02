package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import m.g;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final g<ClassLoader, g<String, Class<?>>> f2317a = new g<>();

    static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class<?> c(ClassLoader classLoader, String str) {
        g<ClassLoader, g<String, Class<?>>> gVar = f2317a;
        g gVar2 = gVar.get(classLoader);
        if (gVar2 == null) {
            gVar2 = new g();
            gVar.put(classLoader, gVar2);
        }
        Class<?> cls = (Class) gVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        gVar2.put(str, cls2);
        return cls2;
    }

    public static Class<? extends Fragment> d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassNotFoundException e5) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class name exists", e5);
        } catch (ClassCastException e6) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e6);
        }
    }

    public Fragment a(ClassLoader classLoader, String str) {
        throw null;
    }
}
