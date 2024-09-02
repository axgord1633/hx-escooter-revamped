package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Object[] f5567a = new Object[0];

    public static final Object[] a(Collection<?> collection) {
        k.e(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr = new Object[size];
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    objArr[i5] = it.next();
                    if (i6 >= objArr.length) {
                        if (!it.hasNext()) {
                            return objArr;
                        }
                        int i7 = ((i6 * 3) + 1) >>> 1;
                        if (i7 <= i6) {
                            if (i6 < 2147483645) {
                                i7 = 2147483645;
                            } else {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr = Arrays.copyOf(objArr, i7);
                        k.d(objArr, "copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i6);
                        k.d(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i5 = i6;
                }
            }
        }
        return f5567a;
    }

    public static final Object[] b(Collection<?> collection, Object[] objArr) {
        Object[] objArr2;
        k.e(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i5 = 0;
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArr2 = objArr;
                } else {
                    Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    k.c(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    objArr2 = (Object[]) newInstance;
                }
                while (true) {
                    int i6 = i5 + 1;
                    objArr2[i5] = it.next();
                    if (i6 >= objArr2.length) {
                        if (!it.hasNext()) {
                            return objArr2;
                        }
                        int i7 = ((i6 * 3) + 1) >>> 1;
                        if (i7 <= i6) {
                            if (i6 < 2147483645) {
                                i7 = 2147483645;
                            } else {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr2 = Arrays.copyOf(objArr2, i7);
                        k.d(objArr2, "copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        if (objArr2 == objArr) {
                            objArr[i6] = null;
                            return objArr;
                        }
                        Object[] copyOf = Arrays.copyOf(objArr2, i6);
                        k.d(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i5 = i6;
                }
            } else if (objArr.length <= 0) {
                return objArr;
            } else {
                objArr[0] = null;
                return objArr;
            }
        } else if (objArr.length <= 0) {
            return objArr;
        } else {
            objArr[0] = null;
            return objArr;
        }
    }
}
