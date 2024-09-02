package g3;

public final class j {
    public static int a(int i5) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i5 - 1));
    }
}
