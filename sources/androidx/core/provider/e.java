package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.d;
import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f1806a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1807b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1808c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f1809d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1810e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final String f1811f;

    public e(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f1806a = (String) d.h(str);
        this.f1807b = (String) d.h(str2);
        this.f1808c = (String) d.h(str3);
        this.f1809d = (List) d.h(list);
        this.f1811f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f1809d;
    }

    public int c() {
        return this.f1810e;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return this.f1811f;
    }

    public String e() {
        return this.f1806a;
    }

    public String f() {
        return this.f1807b;
    }

    public String g() {
        return this.f1808c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1806a + ", mProviderPackage: " + this.f1807b + ", mQuery: " + this.f1808c + ", mCertificates:");
        for (int i5 = 0; i5 < this.f1809d.size(); i5++) {
            sb.append(" [");
            List list = this.f1809d.get(i5);
            for (int i6 = 0; i6 < list.size(); i6++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i6), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1810e);
        return sb.toString();
    }
}
