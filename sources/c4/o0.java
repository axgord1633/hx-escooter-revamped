package c4;

import o3.g;

final class o0 extends RuntimeException {

    /* renamed from: e  reason: collision with root package name */
    private final g f3149e;

    public o0(g gVar) {
        this.f3149e = gVar;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public String getLocalizedMessage() {
        return this.f3149e.toString();
    }
}
