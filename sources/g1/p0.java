package g1;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.CheckForNull;

public abstract class p0 extends AbstractCollection implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    private static final Object[] f4710e = new Object[0];

    p0() {
    }

    @Deprecated
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i5) {
        throw null;
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        throw null;
    }

    public s0 i() {
        throw null;
    }

    /* renamed from: l */
    public abstract u0 iterator();

    /* access modifiers changed from: package-private */
    public abstract boolean m();

    /* access modifiers changed from: package-private */
    @CheckForNull
    public Object[] n() {
        throw null;
    }

    @Deprecated
    public final boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(f4710e);
    }

    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int size = size();
        int length = objArr.length;
        if (length < size) {
            Object[] n5 = n();
            if (n5 != null) {
                return Arrays.copyOfRange(n5, f(), e(), objArr.getClass());
            }
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
        } else if (length > size) {
            objArr[size] = null;
        }
        c(objArr, 0);
        return objArr;
    }
}
