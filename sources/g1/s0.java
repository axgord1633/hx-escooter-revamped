package g1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

public abstract class s0 extends p0 implements List, RandomAccess {

    /* renamed from: f  reason: collision with root package name */
    private static final v0 f4718f = new q0(t0.f4721i, 0);

    s0() {
    }

    static s0 p(Object[] objArr, int i5) {
        return i5 == 0 ? t0.f4721i : new t0(objArr, i5);
    }

    public static s0 q(Collection collection) {
        if (collection instanceof p0) {
            s0 i5 = ((p0) collection).i();
            if (!i5.m()) {
                return i5;
            }
            Object[] array = i5.toArray();
            return p(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        int i6 = 0;
        while (i6 < length) {
            if (array2[i6] != null) {
                i6++;
            } else {
                throw new NullPointerException("at index " + i6);
            }
        }
        return p(array2, length);
    }

    public static s0 r() {
        return t0.f4721i;
    }

    @Deprecated
    public final void add(int i5, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i5, Collection collection) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i5) {
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            objArr[i6] = get(i6);
        }
        return size;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i5 = 0;
                    while (i5 < size) {
                        if (l0.a(get(i5), list.get(i5))) {
                            i5++;
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!l0.a(it.next(), it2.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int size = size();
        int i5 = 1;
        for (int i6 = 0; i6 < size; i6++) {
            i5 = (i5 * 31) + get(i6).hashCode();
        }
        return i5;
    }

    @Deprecated
    public final s0 i() {
        return this;
    }

    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (obj.equals(get(i5))) {
                return i5;
            }
        }
        return -1;
    }

    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final u0 l() {
        return listIterator(0);
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    /* renamed from: o */
    public s0 subList(int i5, int i6) {
        m0.c(i5, i6, size());
        int i7 = i6 - i5;
        return i7 == size() ? this : i7 == 0 ? t0.f4721i : new r0(this, i5, i7);
    }

    @Deprecated
    public final Object remove(int i5) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: s */
    public final v0 listIterator(int i5) {
        m0.b(i5, size(), "index");
        return isEmpty() ? f4718f : new q0(this, i5);
    }

    @Deprecated
    public final Object set(int i5, Object obj) {
        throw new UnsupportedOperationException();
    }
}
