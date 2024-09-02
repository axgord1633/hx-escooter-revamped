package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.jvm.internal.k;
import m3.k;
import m3.l;
import m3.q;
import o3.d;

public abstract class a implements d<Object>, e, Serializable {
    private final d<Object> completion;

    public a(d<Object> dVar) {
        this.completion = dVar;
    }

    public d<q> create(Object obj, d<?> dVar) {
        k.e(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public d<q> create(d<?> dVar) {
        k.e(dVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public e getCallerFrame() {
        d<Object> dVar = this.completion;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public final d<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    /* access modifiers changed from: protected */
    public abstract Object invokeSuspend(Object obj);

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
    }

    public final void resumeWith(Object obj) {
        d dVar = this;
        while (true) {
            h.b(dVar);
            a aVar = (a) dVar;
            d dVar2 = aVar.completion;
            k.b(dVar2);
            try {
                Object invokeSuspend = aVar.invokeSuspend(obj);
                if (invokeSuspend != d.c()) {
                    obj = m3.k.a(invokeSuspend);
                    aVar.releaseIntercepted();
                    if (dVar2 instanceof a) {
                        dVar = dVar2;
                    } else {
                        dVar2.resumeWith(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                k.a aVar2 = m3.k.f5898e;
                obj = m3.k.a(l.a(th));
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }
}
