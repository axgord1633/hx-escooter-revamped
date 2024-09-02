package y1;

import android.os.ParcelUuid;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.UUID;

public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final UUID f7744a = UUID.fromString("00000000-0000-1000-8000-00805F9B34FB");

    private byte[] a(byte[] bArr, int i5, int i6) {
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, i5, bArr2, 0, i6);
        return bArr2;
    }

    private int c(byte[] bArr, int i5, int i6, int i7, List<ParcelUuid> list) {
        while (i6 > 0) {
            list.add(e(a(bArr, i5, i7)));
            i6 -= i7;
            i5 += i7;
        }
        return i5;
    }

    private int d(byte[] bArr, int i5, int i6, int i7, List<ParcelUuid> list) {
        while (i6 > 0) {
            list.add(e(a(bArr, i5, i7)));
            i6 -= i7;
            i5 += i7;
        }
        return i5;
    }

    private static ParcelUuid e(byte[] bArr) {
        long j5;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                throw new IllegalArgumentException("uuidBytes length invalid - " + length);
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                if (length == 2) {
                    j5 = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
                } else {
                    j5 = ((long) ((bArr[3] & 255) << 24)) + ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16));
                }
                UUID uuid = f7744a;
                return new ParcelUuid(new UUID(uuid.getMostSignificantBits() + (j5 << 32), uuid.getLeastSignificantBits()));
            }
        } else {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e A[Catch:{ Exception -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[Catch:{ Exception -> 0x010a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z1.e b(byte[] r19) {
        /*
            r18 = this;
            r7 = r18
            r15 = r19
            r0 = 0
            if (r15 != 0) goto L_0x0008
            return r0
        L_0x0008:
            r1 = -1
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            android.util.SparseArray r11 = new android.util.SparseArray
            r11.<init>()
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            r17 = 0
            r16 = r0
            r13 = r1
            r14 = r2
            r1 = r17
        L_0x0027:
            int r2 = r15.length     // Catch:{ Exception -> 0x010a }
            if (r1 >= r2) goto L_0x00f6
            int r2 = r1 + 1
            byte r1 = r15[r1]     // Catch:{ Exception -> 0x010a }
            r3 = 255(0xff, float:3.57E-43)
            r1 = r1 & r3
            if (r1 != 0) goto L_0x0035
            goto L_0x00f6
        L_0x0035:
            int r9 = r1 + -1
            int r6 = r2 + 1
            byte r1 = r15[r2]     // Catch:{ Exception -> 0x010a }
            r1 = r1 & r3
            if (r1 == r3) goto L_0x00da
            switch(r1) {
                case 1: goto L_0x00d4;
                case 2: goto L_0x00c7;
                case 3: goto L_0x00c7;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00ba;
                case 6: goto L_0x00ac;
                case 7: goto L_0x00ac;
                case 8: goto L_0x009f;
                case 9: goto L_0x009f;
                case 10: goto L_0x009a;
                default: goto L_0x0041;
            }     // Catch:{ Exception -> 0x010a }
        L_0x0041:
            switch(r1) {
                case 20: goto L_0x008c;
                case 21: goto L_0x007d;
                case 22: goto L_0x004a;
                default: goto L_0x0044;
            }     // Catch:{ Exception -> 0x010a }
        L_0x0044:
            switch(r1) {
                case 31: goto L_0x004c;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                default: goto L_0x0047;
            }     // Catch:{ Exception -> 0x010a }
        L_0x0047:
            r0 = r6
            goto L_0x00f1
        L_0x004a:
            r0 = r6
            goto L_0x005a
        L_0x004c:
            r5 = 4
            r1 = r18
            r2 = r19
            r3 = r6
            r4 = r9
            r0 = r6
            r6 = r10
            r1.c(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x005a:
            r2 = 32
            if (r1 != r2) goto L_0x0060
            r1 = 4
            goto L_0x0068
        L_0x0060:
            r2 = 33
            if (r1 != r2) goto L_0x0067
            r1 = 16
            goto L_0x0068
        L_0x0067:
            r1 = 2
        L_0x0068:
            byte[] r2 = r7.a(r15, r0, r1)     // Catch:{ Exception -> 0x010a }
            android.os.ParcelUuid r2 = e(r2)     // Catch:{ Exception -> 0x010a }
            int r6 = r0 + r1
            int r1 = r9 - r1
            byte[] r1 = r7.a(r15, r6, r1)     // Catch:{ Exception -> 0x010a }
            r12.put(r2, r1)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x007d:
            r0 = r6
            r5 = 16
            r1 = r18
            r2 = r19
            r3 = r0
            r4 = r9
            r6 = r10
            r1.c(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x008c:
            r0 = r6
            r5 = 2
            r1 = r18
            r2 = r19
            r3 = r0
            r4 = r9
            r6 = r10
            r1.c(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x009a:
            r0 = r6
            byte r14 = r15[r0]     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x009f:
            r0 = r6
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x010a }
            byte[] r2 = r7.a(r15, r0, r9)     // Catch:{ Exception -> 0x010a }
            r1.<init>(r2)     // Catch:{ Exception -> 0x010a }
            r16 = r1
            goto L_0x00f1
        L_0x00ac:
            r0 = r6
            r5 = 16
            r1 = r18
            r2 = r19
            r3 = r0
            r4 = r9
            r6 = r8
            r1.d(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x00ba:
            r0 = r6
            r5 = 4
            r1 = r18
            r2 = r19
            r3 = r0
            r4 = r9
            r6 = r8
            r1.d(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x00c7:
            r0 = r6
            r5 = 2
            r1 = r18
            r2 = r19
            r3 = r0
            r4 = r9
            r6 = r8
            r1.d(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x00d4:
            r0 = r6
            byte r1 = r15[r0]     // Catch:{ Exception -> 0x010a }
            r13 = r1 & 255(0xff, float:3.57E-43)
            goto L_0x00f1
        L_0x00da:
            r0 = r6
            int r6 = r0 + 1
            byte r1 = r15[r6]     // Catch:{ Exception -> 0x010a }
            r1 = r1 & r3
            int r1 = r1 << 8
            byte r2 = r15[r0]     // Catch:{ Exception -> 0x010a }
            r2 = r2 & r3
            int r1 = r1 + r2
            int r6 = r0 + 2
            int r2 = r9 + -2
            byte[] r2 = r7.a(r15, r6, r2)     // Catch:{ Exception -> 0x010a }
            r11.put(r1, r2)     // Catch:{ Exception -> 0x010a }
        L_0x00f1:
            int r1 = r0 + r9
            r0 = 0
            goto L_0x0027
        L_0x00f6:
            boolean r0 = r8.isEmpty()     // Catch:{ Exception -> 0x010a }
            if (r0 == 0) goto L_0x00fe
            r9 = 0
            goto L_0x00ff
        L_0x00fe:
            r9 = r8
        L_0x00ff:
            w1.x r0 = new w1.x     // Catch:{ Exception -> 0x010a }
            r8 = r0
            r15 = r16
            r16 = r19
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x010a }
            return r0
        L_0x010a:
            r0 = move-exception
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = u1.b.a(r19)
            r1[r17] = r2
            java.lang.String r2 = "Unable to parse scan record: %s"
            r1.q.e(r0, r2, r1)
            w1.x r0 = new w1.x
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = -1
            r14 = -2147483648(0xffffffff80000000, float:-0.0)
            r15 = 0
            r8 = r0
            r16 = r19
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.h0.b(byte[]):z1.e");
    }
}
