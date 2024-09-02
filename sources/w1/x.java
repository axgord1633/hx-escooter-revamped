package w1;

import android.os.ParcelUuid;
import android.util.SparseArray;
import java.util.List;
import java.util.Map;
import z1.e;

public class x implements e {

    /* renamed from: a  reason: collision with root package name */
    private final int f7542a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ParcelUuid> f7543b;

    /* renamed from: c  reason: collision with root package name */
    private final List<ParcelUuid> f7544c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray<byte[]> f7545d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<ParcelUuid, byte[]> f7546e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7547f;

    /* renamed from: g  reason: collision with root package name */
    private final String f7548g;

    /* renamed from: h  reason: collision with root package name */
    private final byte[] f7549h;

    public x(List<ParcelUuid> list, List<ParcelUuid> list2, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i5, int i6, String str, byte[] bArr) {
        this.f7543b = list;
        this.f7544c = list2;
        this.f7545d = sparseArray;
        this.f7546e = map;
        this.f7548g = str;
        this.f7542a = i5;
        this.f7547f = i6;
        this.f7549h = bArr;
    }

    public String a() {
        return this.f7548g;
    }

    public List<ParcelUuid> b() {
        return this.f7543b;
    }

    public byte[] c() {
        return this.f7549h;
    }

    public Map<ParcelUuid, byte[]> d() {
        return this.f7546e;
    }

    public byte[] e(ParcelUuid parcelUuid) {
        if (parcelUuid == null) {
            return null;
        }
        return this.f7546e.get(parcelUuid);
    }

    public byte[] f(int i5) {
        return this.f7545d.get(i5);
    }

    public List<ParcelUuid> g() {
        return this.f7544c;
    }

    public SparseArray<byte[]> h() {
        return this.f7545d;
    }
}
