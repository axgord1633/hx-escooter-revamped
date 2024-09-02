package androidx.window.java.layout;

import android.app.Activity;
import androidx.core.util.a;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import c4.e1;
import c4.h0;
import c4.i0;
import c4.l1;
import f4.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;
import m3.q;
import o3.d;
import o3.g;

public final class WindowInfoTrackerCallbackAdapter implements WindowInfoTracker {
    private final Map<a<?>, l1> consumerToJobMap = new LinkedHashMap();
    private final ReentrantLock lock = new ReentrantLock();
    private final WindowInfoTracker tracker;

    public WindowInfoTrackerCallbackAdapter(WindowInfoTracker windowInfoTracker) {
        k.e(windowInfoTracker, "tracker");
        this.tracker = windowInfoTracker;
    }

    private final <T> void addListener(Executor executor, a<T> aVar, b<? extends T> bVar) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.consumerToJobMap.get(aVar) == null) {
                this.consumerToJobMap.put(aVar, h.b(h0.a(e1.a(executor)), (g) null, (i0) null, new WindowInfoTrackerCallbackAdapter$addListener$1$1(bVar, aVar, (d<? super WindowInfoTrackerCallbackAdapter$addListener$1$1>) null), 3, (Object) null));
            }
            q qVar = q.f5904a;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void removeListener(a<?> aVar) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            l1 l1Var = this.consumerToJobMap.get(aVar);
            if (l1Var != null) {
                l1.a.a(l1Var, (CancellationException) null, 1, (Object) null);
            }
            l1 remove = this.consumerToJobMap.remove(aVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void addWindowLayoutInfoListener(Activity activity, Executor executor, a<WindowLayoutInfo> aVar) {
        k.e(activity, "activity");
        k.e(executor, "executor");
        k.e(aVar, "consumer");
        addListener(executor, aVar, this.tracker.windowLayoutInfo(activity));
    }

    public final void removeWindowLayoutInfoListener(a<WindowLayoutInfo> aVar) {
        k.e(aVar, "consumer");
        removeListener(aVar);
    }

    public b<WindowLayoutInfo> windowLayoutInfo(Activity activity) {
        k.e(activity, "activity");
        return this.tracker.windowLayoutInfo(activity);
    }
}
