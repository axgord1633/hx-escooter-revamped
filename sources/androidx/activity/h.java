package androidx.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.k;
import m3.q;
import v3.a;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f503a;

    /* renamed from: b  reason: collision with root package name */
    private final a<q> f504b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f505c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private int f506d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f507e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f508f;

    /* renamed from: g  reason: collision with root package name */
    private final List<a<q>> f509g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f510h = new g(this);

    public h(Executor executor, a<q> aVar) {
        k.e(executor, "executor");
        k.e(aVar, "reportFullyDrawn");
        this.f503a = executor;
        this.f504b = aVar;
    }

    /* access modifiers changed from: private */
    public static final void d(h hVar) {
        k.e(hVar, "this$0");
        synchronized (hVar.f505c) {
            hVar.f507e = false;
            if (hVar.f506d == 0 && !hVar.f508f) {
                hVar.f504b.invoke();
                hVar.b();
            }
            q qVar = q.f5904a;
        }
    }

    public final void b() {
        synchronized (this.f505c) {
            this.f508f = true;
            for (a invoke : this.f509g) {
                invoke.invoke();
            }
            this.f509g.clear();
            q qVar = q.f5904a;
        }
    }

    public final boolean c() {
        boolean z4;
        synchronized (this.f505c) {
            z4 = this.f508f;
        }
        return z4;
    }
}
