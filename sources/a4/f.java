package a4;

import java.util.Iterator;
import kotlin.jvm.internal.k;

class f extends e {

    public static final class a implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f455a;

        public a(Iterator it) {
            this.f455a = it;
        }

        public Iterator<T> iterator() {
            return this.f455a;
        }
    }

    public static <T> b<T> a(Iterator<? extends T> it) {
        k.e(it, "<this>");
        return b(new a(it));
    }

    public static final <T> b<T> b(b<? extends T> bVar) {
        k.e(bVar, "<this>");
        return bVar instanceof a ? bVar : new a(bVar);
    }
}
