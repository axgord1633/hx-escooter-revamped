package c4;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import m3.q;
import v3.l;

final class u {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3176a;

    /* renamed from: b  reason: collision with root package name */
    public final i f3177b;

    /* renamed from: c  reason: collision with root package name */
    public final l<Throwable, q> f3178c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f3179d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f3180e;

    public u(Object obj, i iVar, l<? super Throwable, q> lVar, Object obj2, Throwable th) {
        this.f3176a = obj;
        this.f3177b = iVar;
        this.f3178c = lVar;
        this.f3179d = obj2;
        this.f3180e = th;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(Object obj, i iVar, l lVar, Object obj2, Throwable th, int i5, g gVar) {
        this(obj, (i5 & 2) != 0 ? null : iVar, (i5 & 4) != 0 ? null : lVar, (i5 & 8) != 0 ? null : obj2, (i5 & 16) != 0 ? null : th);
    }

    public static /* synthetic */ u b(u uVar, Object obj, i iVar, l<Throwable, q> lVar, Object obj2, Throwable th, int i5, Object obj3) {
        if ((i5 & 1) != 0) {
            obj = uVar.f3176a;
        }
        if ((i5 & 2) != 0) {
            iVar = uVar.f3177b;
        }
        i iVar2 = iVar;
        if ((i5 & 4) != 0) {
            lVar = uVar.f3178c;
        }
        l<Throwable, q> lVar2 = lVar;
        if ((i5 & 8) != 0) {
            obj2 = uVar.f3179d;
        }
        Object obj4 = obj2;
        if ((i5 & 16) != 0) {
            th = uVar.f3180e;
        }
        return uVar.a(obj, iVar2, lVar2, obj4, th);
    }

    public final u a(Object obj, i iVar, l<? super Throwable, q> lVar, Object obj2, Throwable th) {
        return new u(obj, iVar, lVar, obj2, th);
    }

    public final boolean c() {
        return this.f3180e != null;
    }

    public final void d(l<?> lVar, Throwable th) {
        i iVar = this.f3177b;
        if (iVar != null) {
            lVar.l(iVar, th);
        }
        l<Throwable, q> lVar2 = this.f3178c;
        if (lVar2 != null) {
            lVar.n(lVar2, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return k.a(this.f3176a, uVar.f3176a) && k.a(this.f3177b, uVar.f3177b) && k.a(this.f3178c, uVar.f3178c) && k.a(this.f3179d, uVar.f3179d) && k.a(this.f3180e, uVar.f3180e);
    }

    public int hashCode() {
        Object obj = this.f3176a;
        int i5 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        i iVar = this.f3177b;
        int hashCode2 = (hashCode + (iVar == null ? 0 : iVar.hashCode())) * 31;
        l<Throwable, q> lVar = this.f3178c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f3179d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f3180e;
        if (th != null) {
            i5 = th.hashCode();
        }
        return hashCode4 + i5;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f3176a + ", cancelHandler=" + this.f3177b + ", onCancellation=" + this.f3178c + ", idempotentResume=" + this.f3179d + ", cancelCause=" + this.f3180e + ')';
    }
}
