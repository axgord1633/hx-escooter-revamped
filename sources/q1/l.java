package q1;

public class l {

    /* renamed from: b  reason: collision with root package name */
    public static final l f6637b = new l("CONNECTION_STATE");

    /* renamed from: c  reason: collision with root package name */
    public static final l f6638c = new l("SERVICE_DISCOVERY");

    /* renamed from: d  reason: collision with root package name */
    public static final l f6639d = new l("CHARACTERISTIC_READ");

    /* renamed from: e  reason: collision with root package name */
    public static final l f6640e = new l("CHARACTERISTIC_WRITE");

    /* renamed from: f  reason: collision with root package name */
    public static final l f6641f = new l("CHARACTERISTIC_LONG_WRITE");

    /* renamed from: g  reason: collision with root package name */
    public static final l f6642g = new l("CHARACTERISTIC_CHANGED");

    /* renamed from: h  reason: collision with root package name */
    public static final l f6643h = new l("DESCRIPTOR_READ");

    /* renamed from: i  reason: collision with root package name */
    public static final l f6644i = new l("DESCRIPTOR_WRITE");

    /* renamed from: j  reason: collision with root package name */
    public static final l f6645j = new l("RELIABLE_WRITE_COMPLETED");

    /* renamed from: k  reason: collision with root package name */
    public static final l f6646k = new l("READ_RSSI");

    /* renamed from: l  reason: collision with root package name */
    public static final l f6647l = new l("ON_MTU_CHANGED");

    /* renamed from: m  reason: collision with root package name */
    public static final l f6648m = new l("CONNECTION_PRIORITY_CHANGE");

    /* renamed from: a  reason: collision with root package name */
    private final String f6649a;

    private l(String str) {
        this.f6649a = str;
    }

    public String toString() {
        return "BleGattOperation{description='" + this.f6649a + '\'' + '}';
    }
}
