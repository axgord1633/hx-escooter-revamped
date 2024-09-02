package s4;

import java.io.UnsupportedEncodingException;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f6755a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f6756b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    public static String a(byte[] bArr) {
        return b(bArr, f6755a);
    }

    private static String b(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6 += 3) {
            int i7 = i5 + 1;
            bArr3[i5] = bArr2[(bArr[i6] & 255) >> 2];
            int i8 = i7 + 1;
            int i9 = i6 + 1;
            bArr3[i7] = bArr2[((bArr[i6] & 3) << 4) | ((bArr[i9] & 255) >> 4)];
            int i10 = i8 + 1;
            int i11 = i6 + 2;
            bArr3[i8] = bArr2[((bArr[i9] & 15) << 2) | ((bArr[i11] & 255) >> 6)];
            i5 = i10 + 1;
            bArr3[i10] = bArr2[bArr[i11] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i12 = i5 + 1;
            bArr3[i5] = bArr2[(bArr[length] & 255) >> 2];
            int i13 = i12 + 1;
            bArr3[i12] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i13] = 61;
            bArr3[i13 + 1] = 61;
        } else if (length2 == 2) {
            int i14 = i5 + 1;
            bArr3[i5] = bArr2[(bArr[length] & 255) >> 2];
            int i15 = i14 + 1;
            int i16 = length + 1;
            bArr3[i14] = bArr2[((bArr[i16] & 255) >> 4) | ((bArr[length] & 3) << 4)];
            bArr3[i15] = bArr2[(bArr[i16] & 15) << 2];
            bArr3[i15 + 1] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }
}
