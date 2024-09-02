package r1;

import android.os.DeadObjectException;
import m2.k;
import m2.l;
import m2.m;
import q1.f;
import x1.i;

public abstract class j<T> implements v1.j<T> {

    class a implements m<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f6686a;

        a(i iVar) {
            this.f6686a = iVar;
        }

        public void a(l<T> lVar) {
            try {
                j.this.f(lVar, this.f6686a);
            } catch (DeadObjectException e5) {
                lVar.e(j.this.i(e5));
                q.e(e5, "QueueOperation terminated with a DeadObjectException", new Object[0]);
            } catch (Throwable th) {
                lVar.e(th);
                q.e(th, "QueueOperation terminated with an unexpected exception", new Object[0]);
            }
        }
    }

    /* renamed from: c */
    public int compareTo(v1.j jVar) {
        return jVar.e().f6685a - e().f6685a;
    }

    public i e() {
        return i.f6683c;
    }

    /* access modifiers changed from: protected */
    public abstract void f(l<T> lVar, i iVar);

    public final k<T> h(i iVar) {
        return k.m(new a(iVar));
    }

    /* access modifiers changed from: protected */
    public abstract f i(DeadObjectException deadObjectException);
}
