package c4;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;

public final class m1 extends CancellationException {

    /* renamed from: e  reason: collision with root package name */
    public final transient l1 f3147e;

    public m1(String str, Throwable th, l1 l1Var) {
        super(str);
        this.f3147e = l1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof m1) {
                m1 m1Var = (m1) obj;
                if (!k.a(m1Var.getMessage(), getMessage()) || !k.a(m1Var.f3147e, this.f3147e) || !k.a(m1Var.getCause(), getCause())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        k.b(message);
        int hashCode = ((message.hashCode() * 31) + this.f3147e.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    public String toString() {
        return super.toString() + "; job=" + this.f3147e;
    }
}
