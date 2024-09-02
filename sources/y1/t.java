package y1;

import m2.l;
import m2.s;

public class t {

    class a extends i3.b<T> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ s f7783f;

        a(s sVar) {
            this.f7783f = sVar;
        }

        public void b(T t5) {
            this.f7783f.b(t5);
        }

        public void onError(Throwable th) {
            this.f7783f.e(th);
        }
    }

    class b extends i3.b<T> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ l f7784f;

        b(l lVar) {
            this.f7784f = lVar;
        }

        public void b(T t5) {
            this.f7784f.d(t5);
            this.f7784f.a();
        }

        public void onError(Throwable th) {
            this.f7784f.e(th);
        }
    }

    public static <T> i3.b<T> a(l<T> lVar) {
        return new b(lVar);
    }

    public static <T> i3.b<T> b(s<T> sVar) {
        return new a(sVar);
    }
}
