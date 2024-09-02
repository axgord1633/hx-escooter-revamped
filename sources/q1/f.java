package q1;

public class f extends RuntimeException {
    public f() {
    }

    public f(String str) {
        super(str);
    }

    public f(String str, Throwable th) {
        super(str, th);
    }
}
