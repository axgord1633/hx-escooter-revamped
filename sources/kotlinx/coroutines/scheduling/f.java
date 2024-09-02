package kotlinx.coroutines.scheduling;

import c4.c1;
import o3.g;

public class f extends c1 {

    /* renamed from: h  reason: collision with root package name */
    private final int f5672h;

    /* renamed from: i  reason: collision with root package name */
    private final int f5673i;

    /* renamed from: j  reason: collision with root package name */
    private final long f5674j;

    /* renamed from: k  reason: collision with root package name */
    private final String f5675k;

    /* renamed from: l  reason: collision with root package name */
    private a f5676l = P();

    public f(int i5, int i6, long j5, String str) {
        this.f5672h = i5;
        this.f5673i = i6;
        this.f5674j = j5;
        this.f5675k = str;
    }

    private final a P() {
        return new a(this.f5672h, this.f5673i, this.f5674j, this.f5675k);
    }

    public void M(g gVar, Runnable runnable) {
        a.j(this.f5676l, runnable, (i) null, false, 6, (Object) null);
    }

    public final void Q(Runnable runnable, i iVar, boolean z4) {
        this.f5676l.h(runnable, iVar, z4);
    }
}
