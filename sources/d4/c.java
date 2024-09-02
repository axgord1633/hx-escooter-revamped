package d4;

import android.os.Handler;
import android.os.Looper;
import c4.p1;
import c4.t0;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class c extends d {
    private volatile c _immediate;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f4440g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4441h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f4442i;

    /* renamed from: j  reason: collision with root package name */
    private final c f4443j;

    public c(Handler handler, String str) {
        this(handler, str, false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Handler handler, String str, int i5, g gVar) {
        this(handler, (i5 & 2) != 0 ? null : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private c(Handler handler, String str, boolean z4) {
        super((g) null);
        c cVar = null;
        this.f4440g = handler;
        this.f4441h = str;
        this.f4442i = z4;
        this._immediate = z4 ? this : cVar;
        c cVar2 = this._immediate;
        if (cVar2 == null) {
            cVar2 = new c(handler, str, true);
            this._immediate = cVar2;
        }
        this.f4443j = cVar2;
    }

    private final void R(o3.g gVar, Runnable runnable) {
        p1.c(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        t0.b().M(gVar, runnable);
    }

    public void M(o3.g gVar, Runnable runnable) {
        if (!this.f4440g.post(runnable)) {
            R(gVar, runnable);
        }
    }

    public boolean N(o3.g gVar) {
        return !this.f4442i || !k.a(Looper.myLooper(), this.f4440g.getLooper());
    }

    /* renamed from: S */
    public c P() {
        return this.f4443j;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).f4440g == this.f4440g;
    }

    public int hashCode() {
        return System.identityHashCode(this.f4440g);
    }

    public String toString() {
        String Q = Q();
        if (Q != null) {
            return Q;
        }
        String str = this.f4441h;
        if (str == null) {
            str = this.f4440g.toString();
        }
        if (!this.f4442i) {
            return str;
        }
        return str + ".immediate";
    }
}
