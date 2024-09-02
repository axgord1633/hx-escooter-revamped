package androidx.window.java.layout;

import androidx.core.util.a;
import f4.c;
import m3.q;
import o3.d;

public final class WindowInfoTrackerCallbackAdapter$addListener$1$1$invokeSuspend$$inlined$collect$1 implements c<T> {
    final /* synthetic */ a $consumer$inlined;

    public WindowInfoTrackerCallbackAdapter$addListener$1$1$invokeSuspend$$inlined$collect$1(a aVar) {
        this.$consumer$inlined = aVar;
    }

    public Object emit(T t5, d<? super q> dVar) {
        this.$consumer$inlined.accept(t5);
        return q.f5904a;
    }
}
