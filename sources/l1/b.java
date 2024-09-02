package l1;

public final class b extends IllegalStateException {
    private b(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(g<?> gVar) {
        if (!gVar.i()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception f5 = gVar.f();
        return new b("Complete with: ".concat(f5 != null ? "failure" : gVar.j() ? "result ".concat(String.valueOf(gVar.g())) : gVar.h() ? "cancellation" : "unknown issue"), f5);
    }
}
