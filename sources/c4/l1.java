package c4;

import java.util.concurrent.CancellationException;
import m3.q;
import o3.g;
import v3.l;
import v3.p;

public interface l1 extends g.b {

    /* renamed from: c  reason: collision with root package name */
    public static final b f3142c = b.f3143e;

    public static final class a {
        public static /* synthetic */ void a(l1 l1Var, CancellationException cancellationException, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 1) != 0) {
                    cancellationException = null;
                }
                l1Var.F(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R b(l1 l1Var, R r5, p<? super R, ? super g.b, ? extends R> pVar) {
            return g.b.a.a(l1Var, r5, pVar);
        }

        public static <E extends g.b> E c(l1 l1Var, g.c<E> cVar) {
            return g.b.a.b(l1Var, cVar);
        }

        public static /* synthetic */ u0 d(l1 l1Var, boolean z4, boolean z5, l lVar, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 1) != 0) {
                    z4 = false;
                }
                if ((i5 & 2) != 0) {
                    z5 = true;
                }
                return l1Var.e(z4, z5, lVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static g e(l1 l1Var, g.c<?> cVar) {
            return g.b.a.c(l1Var, cVar);
        }

        public static g f(l1 l1Var, g gVar) {
            return g.b.a.d(l1Var, gVar);
        }
    }

    public static final class b implements g.c<l1> {

        /* renamed from: e  reason: collision with root package name */
        static final /* synthetic */ b f3143e = new b();

        private b() {
        }
    }

    q B(s sVar);

    void F(CancellationException cancellationException);

    boolean b();

    u0 e(boolean z4, boolean z5, l<? super Throwable, q> lVar);

    boolean start();

    CancellationException z();
}
