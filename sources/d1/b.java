package d1;

import android.os.IBinder;
import d1.a;
import java.lang.reflect.Field;
import w0.p;

public final class b<T> extends a.C0070a {

    /* renamed from: b  reason: collision with root package name */
    private final Object f4232b;

    private b(Object obj) {
        this.f4232b = obj;
    }

    public static <T> T c(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f4232b;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i5 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i5++;
                field = field2;
            }
        }
        if (i5 == 1) {
            p.g(field);
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return field.get(asBinder);
                } catch (NullPointerException e5) {
                    throw new IllegalArgumentException("Binder object is null.", e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e6);
                }
            } else {
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
        } else {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
    }

    public static <T> a e(T t5) {
        return new b(t5);
    }
}
