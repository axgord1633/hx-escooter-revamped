package a4;

import java.util.Iterator;
import kotlin.jvm.internal.k;
import v3.l;

public final class i<T, R> implements b<R> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b<T> f456a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final l<T, R> f457b;

    public static final class a implements Iterator<R> {

        /* renamed from: e  reason: collision with root package name */
        private final Iterator<T> f458e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ i<T, R> f459f;

        a(i<T, R> iVar) {
            this.f459f = iVar;
            this.f458e = iVar.f456a.iterator();
        }

        public boolean hasNext() {
            return this.f458e.hasNext();
        }

        public R next() {
            return this.f459f.f457b.invoke(this.f458e.next());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public i(b<? extends T> bVar, l<? super T, ? extends R> lVar) {
        k.e(bVar, "sequence");
        k.e(lVar, "transformer");
        this.f456a = bVar;
        this.f457b = lVar;
    }

    public Iterator<R> iterator() {
        return new a(this);
    }
}
