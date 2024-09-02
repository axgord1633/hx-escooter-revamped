package kotlin.jvm.internal;

import z3.b;
import z3.e;

public class i extends c implements h, e {
    private final int arity;
    private final int flags;

    public i(int i5) {
        this(i5, c.NO_RECEIVER, (Class) null, (String) null, (String) null, 0);
    }

    public i(int i5, Object obj) {
        this(i5, obj, (Class) null, (String) null, (String) null, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(int i5, Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, (i6 & 1) == 1);
        this.arity = i5;
        this.flags = i6 >> 1;
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return r.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return getName().equals(iVar.getName()) && getSignature().equals(iVar.getSignature()) && this.flags == iVar.flags && this.arity == iVar.arity && k.a(getBoundReceiver(), iVar.getBoundReceiver()) && k.a(getOwner(), iVar.getOwner());
        } else if (obj instanceof e) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int getArity() {
        return this.arity;
    }

    /* access modifiers changed from: protected */
    public e getReflected() {
        return (e) super.getReflected();
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public boolean isExternal() {
        return getReflected().isExternal();
    }

    public boolean isInfix() {
        return getReflected().isInfix();
    }

    public boolean isInline() {
        return getReflected().isInline();
    }

    public boolean isOperator() {
        return getReflected().isOperator();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
