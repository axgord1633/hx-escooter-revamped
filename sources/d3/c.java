package d3;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class c implements Future<Object> {

    /* renamed from: e  reason: collision with root package name */
    final p2.c f4357e;

    c(p2.c cVar) {
        this.f4357e = cVar;
    }

    public boolean cancel(boolean z4) {
        this.f4357e.dispose();
        return false;
    }

    public Object get() {
        return null;
    }

    public Object get(long j5, TimeUnit timeUnit) {
        return null;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }
}
