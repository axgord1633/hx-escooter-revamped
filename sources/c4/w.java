package c4;

import kotlin.jvm.internal.k;
import m3.q;
import v3.l;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3185a;

    /* renamed from: b  reason: collision with root package name */
    public final l<Throwable, q> f3186b;

    public w(Object obj, l<? super Throwable, q> lVar) {
        this.f3185a = obj;
        this.f3186b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return k.a(this.f3185a, wVar.f3185a) && k.a(this.f3186b, wVar.f3186b);
    }

    public int hashCode() {
        Object obj = this.f3185a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f3186b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f3185a + ", onCancellation=" + this.f3186b + ')';
    }
}
