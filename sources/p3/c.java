package p3;

import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.j;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.u;
import m3.l;
import m3.q;
import o3.d;
import o3.g;
import v3.p;

class c {

    public static final class a extends j {

        /* renamed from: e  reason: collision with root package name */
        private int f6556e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ p f6557f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Object f6558g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, p pVar, Object obj) {
            super(dVar);
            this.f6557f = pVar;
            this.f6558g = obj;
            k.c(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* access modifiers changed from: protected */
        public Object invokeSuspend(Object obj) {
            int i5 = this.f6556e;
            if (i5 == 0) {
                this.f6556e = 1;
                l.b(obj);
                k.c(this.f6557f, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) u.a(this.f6557f, 2)).invoke(this.f6558g, this);
            } else if (i5 == 1) {
                this.f6556e = 2;
                l.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: e  reason: collision with root package name */
        private int f6559e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ p f6560f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Object f6561g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d dVar, g gVar, p pVar, Object obj) {
            super(dVar, gVar);
            this.f6560f = pVar;
            this.f6561g = obj;
            k.c(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* access modifiers changed from: protected */
        public Object invokeSuspend(Object obj) {
            int i5 = this.f6559e;
            if (i5 == 0) {
                this.f6559e = 1;
                l.b(obj);
                k.c(this.f6560f, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) u.a(this.f6560f, 2)).invoke(this.f6561g, this);
            } else if (i5 == 1) {
                this.f6559e = 2;
                l.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    public static <R, T> d<q> a(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r5, d<? super T> dVar) {
        k.e(pVar, "<this>");
        k.e(dVar, "completion");
        d<? super T> a5 = h.a(dVar);
        if (pVar instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) pVar).create(r5, a5);
        }
        g context = a5.getContext();
        return context == o3.h.f6161e ? new a(a5, pVar, r5) : new b(a5, context, pVar, r5);
    }

    public static <T> d<T> b(d<? super T> dVar) {
        d<Object> intercepted;
        k.e(dVar, "<this>");
        kotlin.coroutines.jvm.internal.d dVar2 = dVar instanceof kotlin.coroutines.jvm.internal.d ? (kotlin.coroutines.jvm.internal.d) dVar : null;
        return (dVar2 == null || (intercepted = dVar2.intercepted()) == null) ? dVar : intercepted;
    }
}
