package n3;

import com.yalantis.ucrop.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.k;
import m3.j;
import m3.n;
import v3.l;

class v extends u {
    public static <T> T k(List<? extends T> list) {
        k.e(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T l(List<? extends T> list) {
        k.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T, A extends Appendable> A m(Iterable<? extends T> iterable, A a5, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l<? super T, ? extends CharSequence> lVar) {
        k.e(iterable, "<this>");
        k.e(a5, "buffer");
        k.e(charSequence, "separator");
        k.e(charSequence2, "prefix");
        k.e(charSequence3, "postfix");
        k.e(charSequence4, "truncated");
        a5.append(charSequence2);
        int i6 = 0;
        for (Object next : iterable) {
            i6++;
            if (i6 > 1) {
                a5.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            e.a(a5, next, lVar);
        }
        if (i5 >= 0 && i6 > i5) {
            a5.append(charSequence4);
        }
        a5.append(charSequence3);
        return a5;
    }

    public static /* synthetic */ Appendable n(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        String str = (i6 & 2) != 0 ? ", " : charSequence;
        int i7 = i6 & 4;
        CharSequence charSequence5 = BuildConfig.FLAVOR;
        CharSequence charSequence6 = i7 != 0 ? charSequence5 : charSequence2;
        if ((i6 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return m(iterable, appendable, str, charSequence6, charSequence5, (i6 & 16) != 0 ? -1 : i5, (i6 & 32) != 0 ? "..." : charSequence4, (i6 & 64) != 0 ? null : lVar);
    }

    public static final <T> String o(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l<? super T, ? extends CharSequence> lVar) {
        k.e(iterable, "<this>");
        k.e(charSequence, "separator");
        k.e(charSequence2, "prefix");
        k.e(charSequence3, "postfix");
        k.e(charSequence4, "truncated");
        String sb = ((StringBuilder) m(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
        k.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String p(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        int i7 = i6 & 2;
        CharSequence charSequence5 = BuildConfig.FLAVOR;
        CharSequence charSequence6 = i7 != 0 ? charSequence5 : charSequence2;
        if ((i6 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        int i8 = i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        return o(iterable, charSequence, charSequence6, charSequence5, i8, charSequence7, lVar);
    }

    public static <T extends Comparable<? super T>> T q(Iterable<? extends T> iterable) {
        k.e(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t5 = (Comparable) it.next();
        while (it.hasNext()) {
            T t6 = (Comparable) it.next();
            if (t5.compareTo(t6) > 0) {
                t5 = t6;
            }
        }
        return t5;
    }

    public static <T> T r(Iterable<? extends T> iterable) {
        k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return s((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T s(List<? extends T> list) {
        k.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static byte[] t(Collection<Byte> collection) {
        k.e(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        int i5 = 0;
        for (Byte byteValue : collection) {
            bArr[i5] = byteValue.byteValue();
            i5++;
        }
        return bArr;
    }

    public static final <T, C extends Collection<? super T>> C u(Iterable<? extends T> iterable, C c5) {
        k.e(iterable, "<this>");
        k.e(c5, "destination");
        for (Object add : iterable) {
            c5.add(add);
        }
        return c5;
    }

    public static <T> List<T> v(Iterable<? extends T> iterable) {
        k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return n.g(w(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return n.d();
        }
        if (size != 1) {
            return x(collection);
        }
        return m.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> w(Iterable<? extends T> iterable) {
        k.e(iterable, "<this>");
        return iterable instanceof Collection ? x((Collection) iterable) : (List) u(iterable, new ArrayList());
    }

    public static <T> List<T> x(Collection<? extends T> collection) {
        k.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> y(Iterable<? extends T> iterable) {
        k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return j0.c((Set) u(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return j0.b();
        }
        if (size != 1) {
            return (Set) u(iterable, new LinkedHashSet(d0.a(collection.size())));
        }
        return i0.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static <T, R> List<j<T, R>> z(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        k.e(iterable, "<this>");
        k.e(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(o.i(iterable, 10), o.i(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(n.a(it.next(), it2.next()));
        }
        return arrayList;
    }
}
