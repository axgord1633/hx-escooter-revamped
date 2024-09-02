package m4;

import com.yalantis.ucrop.BuildConfig;
import i4.v;
import java.net.ProtocolException;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final v f5933a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5934b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5935c;

    public k(v vVar, int i5, String str) {
        this.f5933a = vVar;
        this.f5934b = i5;
        this.f5935c = str;
    }

    public static k a(String str) {
        v vVar;
        String str2;
        int i5 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                vVar = v.HTTP_1_0;
            } else if (charAt == 1) {
                vVar = v.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            vVar = v.HTTP_1_0;
            i5 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i6 = i5 + 3;
        if (str.length() >= i6) {
            try {
                int parseInt = Integer.parseInt(str.substring(i5, i6));
                if (str.length() <= i6) {
                    str2 = BuildConfig.FLAVOR;
                } else if (str.charAt(i6) == ' ') {
                    str2 = str.substring(i5 + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new k(vVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5933a == v.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f5934b);
        if (this.f5935c != null) {
            sb.append(' ');
            sb.append(this.f5935c);
        }
        return sb.toString();
    }
}
