package w0;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import t0.d;
import u0.a;
import u0.f;
import v0.c;

public abstract class h<T extends IInterface> extends c<T> implements a.f {
    private final e F;
    private final Set G;
    private final Account H;

    @Deprecated
    protected h(Context context, Looper looper, int i5, e eVar, f.a aVar, f.b bVar) {
        this(context, looper, i5, eVar, (c) aVar, (v0.h) bVar);
    }

    protected h(Context context, Looper looper, int i5, e eVar, c cVar, v0.h hVar) {
        this(context, looper, i.b(context), d.k(), i5, eVar, (c) p.g(cVar), (v0.h) p.g(hVar));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected h(android.content.Context r11, android.os.Looper r12, w0.i r13, t0.d r14, int r15, w0.e r16, v0.c r17, v0.h r18) {
        /*
            r10 = this;
            r9 = r10
            r0 = r17
            r1 = r18
            r2 = 0
            if (r0 != 0) goto L_0x000a
            r6 = r2
            goto L_0x0010
        L_0x000a:
            w0.f0 r3 = new w0.f0
            r3.<init>(r0)
            r6 = r3
        L_0x0010:
            if (r1 != 0) goto L_0x0014
            r7 = r2
            goto L_0x001a
        L_0x0014:
            w0.g0 r0 = new w0.g0
            r0.<init>(r1)
            r7 = r0
        L_0x001a:
            java.lang.String r8 = r16.h()
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            r9.F = r0
            android.accounts.Account r1 = r16.a()
            r9.H = r1
            java.util.Set r0 = r16.c()
            java.util.Set r0 = r10.i0(r0)
            r9.G = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.h.<init>(android.content.Context, android.os.Looper, w0.i, t0.d, int, w0.e, v0.c, v0.h):void");
    }

    private final Set i0(Set set) {
        Set<Scope> h02 = h0(set);
        for (Scope contains : h02) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return h02;
    }

    /* access modifiers changed from: protected */
    public final Set<Scope> B() {
        return this.G;
    }

    public Set<Scope> c() {
        return o() ? this.G : Collections.emptySet();
    }

    /* access modifiers changed from: protected */
    public Set<Scope> h0(Set<Scope> set) {
        return set;
    }

    public final Account t() {
        return this.H;
    }

    /* access modifiers changed from: protected */
    public final Executor v() {
        return null;
    }
}
