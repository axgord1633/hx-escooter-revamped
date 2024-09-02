package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import u0.g;
import u0.h;
import u0.k;
import u0.l;
import v0.g0;
import w0.p;

public abstract class BasePendingResult<R extends k> extends g<R> {

    /* renamed from: o  reason: collision with root package name */
    static final ThreadLocal f3286o = new l0();

    /* renamed from: a  reason: collision with root package name */
    private final Object f3287a = new Object();

    /* renamed from: b  reason: collision with root package name */
    protected final a f3288b = new a(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    protected final WeakReference f3289c = new WeakReference((Object) null);

    /* renamed from: d  reason: collision with root package name */
    private final CountDownLatch f3290d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList f3291e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private l f3292f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference f3293g = new AtomicReference();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public k f3294h;

    /* renamed from: i  reason: collision with root package name */
    private Status f3295i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f3296j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3297k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3298l;

    /* renamed from: m  reason: collision with root package name */
    private w0.k f3299m;
    private m0 mResultGuardian;

    /* renamed from: n  reason: collision with root package name */
    private boolean f3300n = false;

    public static class a<R extends k> extends e1.k {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(l lVar, k kVar) {
            ThreadLocal threadLocal = BasePendingResult.f3286o;
            sendMessage(obtainMessage(1, new Pair((l) p.g(lVar), kVar)));
        }

        public final void handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == 1) {
                Pair pair = (Pair) message.obj;
                l lVar = (l) pair.first;
                k kVar = (k) pair.second;
                try {
                    lVar.a(kVar);
                } catch (RuntimeException e5) {
                    BasePendingResult.h(kVar);
                    throw e5;
                }
            } else if (i5 != 2) {
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + i5, new Exception());
            } else {
                ((BasePendingResult) message.obj).b(Status.f3277n);
            }
        }
    }

    @Deprecated
    BasePendingResult() {
    }

    private final k e() {
        k kVar;
        synchronized (this.f3287a) {
            p.j(!this.f3296j, "Result has already been consumed.");
            p.j(c(), "Result is not ready.");
            kVar = this.f3294h;
            this.f3294h = null;
            this.f3292f = null;
            this.f3296j = true;
        }
        if (((c0) this.f3293g.getAndSet((Object) null)) == null) {
            return (k) p.g(kVar);
        }
        throw null;
    }

    private final void f(k kVar) {
        this.f3294h = kVar;
        this.f3295i = kVar.getStatus();
        this.f3299m = null;
        this.f3290d.countDown();
        if (this.f3297k) {
            this.f3292f = null;
        } else {
            l lVar = this.f3292f;
            if (lVar != null) {
                this.f3288b.removeMessages(2);
                this.f3288b.a(lVar, e());
            } else if (this.f3294h instanceof h) {
                this.mResultGuardian = new m0(this, (g0) null);
            }
        }
        ArrayList arrayList = this.f3291e;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((g.a) arrayList.get(i5)).a(this.f3295i);
        }
        this.f3291e.clear();
    }

    public static void h(k kVar) {
        if (kVar instanceof h) {
            try {
                ((h) kVar).release();
            } catch (RuntimeException e5) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(kVar)), e5);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract R a(Status status);

    @Deprecated
    public final void b(Status status) {
        synchronized (this.f3287a) {
            if (!c()) {
                d(a(status));
                this.f3298l = true;
            }
        }
    }

    public final boolean c() {
        return this.f3290d.getCount() == 0;
    }

    public final void d(R r5) {
        synchronized (this.f3287a) {
            if (this.f3298l || this.f3297k) {
                h(r5);
                return;
            }
            c();
            p.j(!c(), "Results have already been set");
            p.j(!this.f3296j, "Result has already been consumed");
            f(r5);
        }
    }
}
