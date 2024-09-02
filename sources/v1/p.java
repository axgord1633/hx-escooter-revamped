package v1;

import android.os.DeadObjectException;
import m2.l;
import q1.f;
import q1.m;
import r1.j;
import r1.q;
import r2.d;
import x1.i;
import y1.f0;

public abstract class p<SCAN_RESULT_TYPE, SCAN_CALLBACK_TYPE> extends j<SCAN_RESULT_TYPE> {

    /* renamed from: e  reason: collision with root package name */
    final f0 f7231e;

    class a implements d {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f7232e;

        a(Object obj) {
            this.f7232e = obj;
        }

        public void cancel() {
            q.k("Scan operation is requested to stop.", new Object[0]);
            p pVar = p.this;
            pVar.n(pVar.f7231e, this.f7232e);
        }
    }

    p(f0 f0Var) {
        this.f7231e = f0Var;
    }

    /* access modifiers changed from: protected */
    public final void f(l<SCAN_RESULT_TYPE> lVar, i iVar) {
        Object l5 = l(lVar);
        try {
            lVar.g(new a(l5));
            q.k("Scan operation is requested to start.", new Object[0]);
            if (!m(this.f7231e, l5)) {
                lVar.e(new m(0));
            }
        } catch (Throwable th) {
            iVar.release();
            throw th;
        }
        iVar.release();
    }

    /* access modifiers changed from: protected */
    public f i(DeadObjectException deadObjectException) {
        return new m(1, (Throwable) deadObjectException);
    }

    /* access modifiers changed from: package-private */
    public abstract SCAN_CALLBACK_TYPE l(l<SCAN_RESULT_TYPE> lVar);

    /* access modifiers changed from: package-private */
    public abstract boolean m(f0 f0Var, SCAN_CALLBACK_TYPE scan_callback_type);

    /* access modifiers changed from: package-private */
    public abstract void n(f0 f0Var, SCAN_CALLBACK_TYPE scan_callback_type);
}
