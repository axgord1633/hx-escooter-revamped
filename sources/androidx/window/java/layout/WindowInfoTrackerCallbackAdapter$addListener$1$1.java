package androidx.window.java.layout;

import androidx.core.util.a;
import c4.g0;
import f4.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import m3.l;
import m3.q;
import o3.d;
import v3.p;

@f(c = "androidx.window.java.layout.WindowInfoTrackerCallbackAdapter$addListener$1$1", f = "WindowInfoTrackerCallbackAdapter.kt", l = {96}, m = "invokeSuspend")
final class WindowInfoTrackerCallbackAdapter$addListener$1$1 extends k implements p<g0, d<? super q>, Object> {
    final /* synthetic */ a<T> $consumer;
    final /* synthetic */ b<T> $flow;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowInfoTrackerCallbackAdapter$addListener$1$1(b<? extends T> bVar, a<T> aVar, d<? super WindowInfoTrackerCallbackAdapter$addListener$1$1> dVar) {
        super(2, dVar);
        this.$flow = bVar;
        this.$consumer = aVar;
    }

    public final d<q> create(Object obj, d<?> dVar) {
        return new WindowInfoTrackerCallbackAdapter$addListener$1$1(this.$flow, this.$consumer, dVar);
    }

    public final Object invoke(g0 g0Var, d<? super q> dVar) {
        return ((WindowInfoTrackerCallbackAdapter$addListener$1$1) create(g0Var, dVar)).invokeSuspend(q.f5904a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = d.c();
        int i5 = this.label;
        if (i5 == 0) {
            l.b(obj);
            b<T> bVar = this.$flow;
            WindowInfoTrackerCallbackAdapter$addListener$1$1$invokeSuspend$$inlined$collect$1 windowInfoTrackerCallbackAdapter$addListener$1$1$invokeSuspend$$inlined$collect$1 = new WindowInfoTrackerCallbackAdapter$addListener$1$1$invokeSuspend$$inlined$collect$1(this.$consumer);
            this.label = 1;
            if (bVar.a(windowInfoTrackerCallbackAdapter$addListener$1$1$invokeSuspend$$inlined$collect$1, this) == c5) {
                return c5;
            }
        } else if (i5 == 1) {
            l.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return q.f5904a;
    }
}
