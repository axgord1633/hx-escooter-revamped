package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.k;

public final class z {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final List<Class<?>> f2623a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final List<Class<?>> f2624b;

    static {
        Class<u> cls = u.class;
        f2623a = n.f(Application.class, cls);
        f2624b = m.b(cls);
    }

    public static final <T> Constructor<T> c(Class<T> cls, List<? extends Class<?>> list) {
        k.e(cls, "modelClass");
        k.e(list, "signature");
        Constructor<T>[] constructors = cls.getConstructors();
        k.d(constructors, "modelClass.constructors");
        int length = constructors.length;
        int i5 = 0;
        while (i5 < length) {
            Constructor<T> constructor = constructors[i5];
            Class[] parameterTypes = constructor.getParameterTypes();
            k.d(parameterTypes, "constructor.parameterTypes");
            List v5 = j.v(parameterTypes);
            if (k.a(list, v5)) {
                k.c(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            } else if (list.size() != v5.size() || !v5.containsAll(list)) {
                i5++;
            } else {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends a0> T d(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        k.e(cls, "modelClass");
        k.e(constructor, "constructor");
        k.e(objArr, "params");
        try {
            return (a0) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Failed to access " + cls, e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e7.getCause());
        }
    }
}
