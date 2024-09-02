package kotlin.jvm.internal;

import z3.b;
import z3.g;

public abstract class p extends c implements g {

    /* renamed from: e  reason: collision with root package name */
    private final boolean f5570e;

    public p() {
        this.f5570e = false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(Object obj, Class cls, String str, String str2, int i5) {
        super(obj, cls, str, str2, (i5 & 1) == 1);
        boolean z4 = false;
        this.f5570e = (i5 & 2) == 2 ? true : z4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public g getReflected() {
        if (!this.f5570e) {
            return (g) super.getReflected();
        }
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
    }

    public b compute() {
        return this.f5570e ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return getOwner().equals(pVar.getOwner()) && getName().equals(pVar.getName()) && getSignature().equals(pVar.getSignature()) && k.a(getBoundReceiver(), pVar.getBoundReceiver());
        } else if (obj instanceof g) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
