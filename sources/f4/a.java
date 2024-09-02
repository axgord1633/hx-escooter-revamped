package f4;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import m3.q;

public abstract class a<T> implements b<T> {

    @f(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    /* renamed from: f4.a$a  reason: collision with other inner class name */
    static final class C0078a extends d {

        /* renamed from: e  reason: collision with root package name */
        Object f4631e;

        /* renamed from: f  reason: collision with root package name */
        /* synthetic */ Object f4632f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ a<T> f4633g;

        /* renamed from: h  reason: collision with root package name */
        int f4634h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0078a(a<T> aVar, o3.d<? super C0078a> dVar) {
            super(dVar);
            this.f4633g = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f4632f = obj;
            this.f4634h |= Integer.MIN_VALUE;
            return this.f4633g.a((c) null, this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(f4.c<? super T> r6, o3.d<? super m3.q> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof f4.a.C0078a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            f4.a$a r0 = (f4.a.C0078a) r0
            int r1 = r0.f4634h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4634h = r1
            goto L_0x0018
        L_0x0013:
            f4.a$a r0 = new f4.a$a
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f4632f
            java.lang.Object r1 = p3.d.c()
            int r2 = r0.f4634h
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r6 = r0.f4631e
            g4.c r6 = (g4.c) r6
            m3.l.b(r7)     // Catch:{ all -> 0x002d }
            goto L_0x004f
        L_0x002d:
            r7 = move-exception
            goto L_0x0059
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0037:
            m3.l.b(r7)
            g4.c r7 = new g4.c
            o3.g r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f4631e = r7     // Catch:{ all -> 0x0055 }
            r0.f4634h = r3     // Catch:{ all -> 0x0055 }
            java.lang.Object r6 = r5.b(r7, r0)     // Catch:{ all -> 0x0055 }
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r6 = r7
        L_0x004f:
            r6.releaseIntercepted()
            m3.q r6 = m3.q.f5904a
            return r6
        L_0x0055:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x0059:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: f4.a.a(f4.c, o3.d):java.lang.Object");
    }

    public abstract Object b(c<? super T> cVar, o3.d<? super q> dVar);
}
