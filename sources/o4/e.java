package o4;

import com.yalantis.ucrop.BuildConfig;
import j4.c;
import java.io.IOException;
import s4.f;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    static final f f6204a = f.o("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f6205b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c  reason: collision with root package name */
    static final String[] f6206c = new String[64];

    /* renamed from: d  reason: collision with root package name */
    static final String[] f6207d = new String[256];

    static {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            String[] strArr = f6207d;
            if (i6 >= strArr.length) {
                break;
            }
            strArr[i6] = c.p("%8s", Integer.toBinaryString(i6)).replace(' ', '0');
            i6++;
        }
        String[] strArr2 = f6206c;
        strArr2[0] = BuildConfig.FLAVOR;
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i7 = 0; i7 < 1; i7++) {
            int i8 = iArr[i7];
            String[] strArr3 = f6206c;
            strArr3[i8 | 8] = strArr3[i8] + "|PADDED";
        }
        String[] strArr4 = f6206c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i9 = 0; i9 < 3; i9++) {
            int i10 = iArr2[i9];
            for (int i11 = 0; i11 < 1; i11++) {
                int i12 = iArr[i11];
                String[] strArr5 = f6206c;
                int i13 = i12 | i10;
                strArr5[i13] = strArr5[i12] + '|' + strArr5[i10];
                strArr5[i13 | 8] = strArr5[i12] + '|' + strArr5[i10] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = f6206c;
            if (i5 < strArr6.length) {
                if (strArr6[i5] == null) {
                    strArr6[i5] = f6207d[i5];
                }
                i5++;
            } else {
                return;
            }
        }
    }

    private e() {
    }

    static String a(byte b5, byte b6) {
        if (b6 == 0) {
            return BuildConfig.FLAVOR;
        }
        if (!(b5 == 2 || b5 == 3)) {
            if (b5 == 4 || b5 == 6) {
                return b6 == 1 ? "ACK" : f6207d[b6];
            }
            if (!(b5 == 7 || b5 == 8)) {
                String[] strArr = f6206c;
                String str = b6 < strArr.length ? strArr[b6] : f6207d[b6];
                return (b5 != 5 || (b6 & 4) == 0) ? (b5 != 0 || (b6 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f6207d[b6];
    }

    static String b(boolean z4, int i5, int i6, byte b5, byte b6) {
        String[] strArr = f6205b;
        String p5 = b5 < strArr.length ? strArr[b5] : c.p("0x%02x", Byte.valueOf(b5));
        String a5 = a(b5, b6);
        Object[] objArr = new Object[5];
        objArr[0] = z4 ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i5);
        objArr[2] = Integer.valueOf(i6);
        objArr[3] = p5;
        objArr[4] = a5;
        return c.p("%s 0x%08x %5d %-13s %s", objArr);
    }

    static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(c.p(str, objArr));
    }

    static IOException d(String str, Object... objArr) {
        throw new IOException(c.p(str, objArr));
    }
}
