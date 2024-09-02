package kotlinx.coroutines.internal;

final /* synthetic */ class d0 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f5585a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f5585a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
