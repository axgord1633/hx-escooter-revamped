package p4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class h<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f6585a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6586b;

    /* renamed from: c  reason: collision with root package name */
    private final Class[] f6587c;

    h(Class<?> cls, String str, Class... clsArr) {
        this.f6585a = cls;
        this.f6586b = str;
        this.f6587c = clsArr;
    }

    private Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f6586b;
        if (str == null) {
            return null;
        }
        Method b5 = b(cls, str, this.f6587c);
        if (b5 == null || (cls2 = this.f6585a) == null || cls2.isAssignableFrom(b5.getReturnType())) {
            return b5;
        }
        return null;
    }

    private static Method b(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public Object c(T t5, Object... objArr) {
        Method a5 = a(t5.getClass());
        if (a5 != null) {
            try {
                return a5.invoke(t5, objArr);
            } catch (IllegalAccessException e5) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a5);
                assertionError.initCause(e5);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f6586b + " not supported for object " + t5);
        }
    }

    public Object d(T t5, Object... objArr) {
        Method a5 = a(t5.getClass());
        if (a5 == null) {
            return null;
        }
        try {
            return a5.invoke(t5, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object e(T t5, Object... objArr) {
        try {
            return d(t5, objArr);
        } catch (InvocationTargetException e5) {
            Throwable targetException = e5.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object f(T t5, Object... objArr) {
        try {
            return c(t5, objArr);
        } catch (InvocationTargetException e5) {
            Throwable targetException = e5.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public boolean g(T t5) {
        return a(t5.getClass()) != null;
    }
}
