package c3;

import java.util.concurrent.atomic.AtomicReference;
import u2.h;

public final class a<T> implements h<T> {

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReference<C0058a<T>> f3080e = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference<C0058a<T>> f3081f = new AtomicReference<>();

    /* renamed from: c3.a$a  reason: collision with other inner class name */
    static final class C0058a<E> extends AtomicReference<C0058a<E>> {

        /* renamed from: e  reason: collision with root package name */
        private E f3082e;

        C0058a() {
        }

        C0058a(E e5) {
            e(e5);
        }

        public E a() {
            E b5 = b();
            e((Object) null);
            return b5;
        }

        public E b() {
            return this.f3082e;
        }

        public C0058a<E> c() {
            return (C0058a) get();
        }

        public void d(C0058a<E> aVar) {
            lazySet(aVar);
        }

        public void e(E e5) {
            this.f3082e = e5;
        }
    }

    public a() {
        C0058a aVar = new C0058a();
        d(aVar);
        e(aVar);
    }

    /* access modifiers changed from: package-private */
    public C0058a<T> a() {
        return this.f3081f.get();
    }

    /* access modifiers changed from: package-private */
    public C0058a<T> b() {
        return this.f3081f.get();
    }

    /* access modifiers changed from: package-private */
    public C0058a<T> c() {
        return this.f3080e.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.poll()
            if (r0 == 0) goto L_0x000d
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.a.clear():void");
    }

    /* access modifiers changed from: package-private */
    public void d(C0058a<T> aVar) {
        this.f3081f.lazySet(aVar);
    }

    /* access modifiers changed from: package-private */
    public C0058a<T> e(C0058a<T> aVar) {
        return this.f3080e.getAndSet(aVar);
    }

    public boolean isEmpty() {
        return b() == c();
    }

    public boolean offer(T t5) {
        if (t5 != null) {
            C0058a aVar = new C0058a(t5);
            e(aVar).d(aVar);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T poll() {
        C0058a a5 = a();
        C0058a c5 = a5.c();
        if (c5 == null) {
            if (a5 == c()) {
                return null;
            }
            do {
                c5 = a5.c();
            } while (c5 == null);
        }
        T a6 = c5.a();
        d(c5);
        return a6;
    }
}
