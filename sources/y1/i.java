package y1;

import com.yalantis.ucrop.BuildConfig;
import r1.q;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f7745a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7746b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7747c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7748d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7749e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7750f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7751g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f7752h = a();

    public i(int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.f7745a = i5;
        this.f7746b = i6;
        this.f7747c = i7;
        this.f7748d = i8;
        this.f7749e = i9;
        this.f7750f = i10;
        this.f7751g = i11;
    }

    private int[] a() {
        return new int[]{this.f7745a, this.f7746b, this.f7747c, this.f7748d, this.f7749e, this.f7750f, this.f7751g};
    }

    private static boolean b(int i5, int i6) {
        return (i5 & i6) != 0;
    }

    private String d(int i5) {
        if (i5 == this.f7746b) {
            return "READ";
        }
        if (i5 == this.f7748d) {
            return "WRITE";
        }
        if (i5 == this.f7747c) {
            return "WRITE_NO_RESPONSE";
        }
        if (i5 == this.f7751g) {
            return "SIGNED_WRITE";
        }
        if (i5 == this.f7750f) {
            return "INDICATE";
        }
        if (i5 == this.f7745a) {
            return "BROADCAST";
        }
        if (i5 == this.f7749e) {
            return "NOTIFY";
        }
        if (i5 == 0) {
            return BuildConfig.FLAVOR;
        }
        q.d("Unknown property specified (%d)", Integer.valueOf(i5));
        return "UNKNOWN (" + i5 + " -> check android.bluetooth.BluetoothGattCharacteristic)";
    }

    public String c(int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i6 : this.f7752h) {
            if (b(i5, i6)) {
                sb.append(d(i6));
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
