package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

public class c {

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1696a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1697b;

        a() {
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public char f1698a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f1699b;

        b(char c5, float[] fArr) {
            this.f1698a = c5;
            this.f1699b = fArr;
        }

        b(b bVar) {
            this.f1698a = bVar.f1698a;
            float[] fArr = bVar.f1699b;
            this.f1699b = c.c(fArr, 0, fArr.length);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x022b, code lost:
            if (r12[r7 + 4] == com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) goto L_0x0230;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x022d, code lost:
            r23 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0230, code lost:
            r23 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x0232, code lost:
            r24 = r7;
            c(r25, r9, r8, r3, r4, r5, r6, r15, r22, r23);
            r9 = r9 + r12[r13];
            r8 = r8 + r12[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x024c, code lost:
            r24 = r7;
            r7 = r24 + 0;
            r10.lineTo(r9, r12[r7]);
            r8 = r12[r7];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x025a, code lost:
            r24 = r7;
            r7 = r24 + 0;
            r1 = r24 + 1;
            r3 = r24 + 2;
            r5 = r24 + 3;
            r10.quadTo(r12[r7], r12[r1], r12[r3], r12[r5]);
            r0 = r12[r7];
            r1 = r12[r1];
            r9 = r12[r3];
            r8 = r12[r5];
            r2 = r0;
            r3 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x027b, code lost:
            r24 = r7;
            r7 = r24 + 0;
            r10.lineTo(r12[r7], r8);
            r9 = r12[r7];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0289, code lost:
            r24 = r7;
            r7 = r24 + 2;
            r8 = r24 + 3;
            r9 = r24 + 4;
            r11 = r24 + 5;
            r25.cubicTo(r12[r24 + 0], r12[r24 + 1], r12[r7], r12[r8], r12[r9], r12[r11]);
            r9 = r12[r9];
            r0 = r12[r11];
            r1 = r12[r7];
            r2 = r12[r8];
            r8 = r0;
            r3 = r2;
            r2 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x02b4, code lost:
            r24 = r7;
            r15 = r8;
            r11 = r9;
            r13 = r24 + 5;
            r3 = r12[r13];
            r14 = r24 + 6;
            r4 = r12[r14];
            r5 = r12[r24 + 0];
            r6 = r12[r24 + 1];
            r7 = r12[r24 + 2];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x02d3, code lost:
            if (r12[r24 + 3] == com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) goto L_0x02d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x02d5, code lost:
            r8 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x02d7, code lost:
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x02de, code lost:
            if (r12[r24 + 4] == com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) goto L_0x02e2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x02e0, code lost:
            r9 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x02e2, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x02e3, code lost:
            c(r25, r11, r15, r3, r4, r5, r6, r7, r8, r9);
            r9 = r12[r13];
            r8 = r12[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x02ee, code lost:
            r3 = r8;
            r2 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x02f0, code lost:
            r7 = r24 + r19;
            r0 = r28;
            r11 = r0;
            r13 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x02fa, code lost:
            r26[r13] = r9;
            r26[1] = r8;
            r26[2] = r2;
            r26[3] = r3;
            r26[4] = r20;
            r26[5] = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
            if (r7 >= r12.length) goto L_0x02fa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x030b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
            if (r11 == 'A') goto L_0x02b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
            if (r11 == 'C') goto L_0x0289;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
            if (r11 == 'H') goto L_0x027b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
            if (r11 == 'Q') goto L_0x025a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
            if (r11 == 'V') goto L_0x024c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
            if (r11 == 'a') goto L_0x01ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005d, code lost:
            if (r11 == 'c') goto L_0x01d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
            if (r11 == 'h') goto L_0x01c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
            if (r11 == 'q') goto L_0x01a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x001e, code lost:
            r19 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
            if (r11 == 'v') goto L_0x019a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006d, code lost:
            if (r11 == 'L') goto L_0x0189;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0071, code lost:
            if (r11 == 'M') goto L_0x016f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0079, code lost:
            if (r11 == 'S') goto L_0x013c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x007f, code lost:
            if (r11 == 'T') goto L_0x0117;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0083, code lost:
            if (r11 == 'l') goto L_0x0104;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0087, code lost:
            if (r11 == 'm') goto L_0x00ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0089, code lost:
            if (r11 == 's') goto L_0x00b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x008b, code lost:
            if (r11 == 't') goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x008d, code lost:
            r24 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0091, code lost:
            if (r0 == 'q') goto L_0x009d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0093, code lost:
            if (r0 == 't') goto L_0x009d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0095, code lost:
            if (r0 == 'Q') goto L_0x009d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0097, code lost:
            if (r0 != 'T') goto L_0x009a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x009a, code lost:
            r0 = com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO;
            r4 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x009d, code lost:
            r4 = r9 - r2;
            r0 = r8 - r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a1, code lost:
            r1 = r7 + 0;
            r3 = r7 + 1;
            r10.rQuadTo(r4, r0, r12[r1], r12[r3]);
            r4 = r4 + r9;
            r0 = r0 + r8;
            r9 = r9 + r12[r1];
            r8 = r8 + r12[r3];
            r3 = r0;
            r2 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b7, code lost:
            if (r0 == 'c') goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b9, code lost:
            if (r0 == 's') goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bd, code lost:
            if (r0 == 'C') goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c1, code lost:
            if (r0 != 'S') goto L_0x00c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c4, code lost:
            r1 = com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO;
            r2 = com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c7, code lost:
            r0 = r9 - r2;
            r2 = r8 - r3;
            r1 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00cd, code lost:
            r13 = r7 + 0;
            r14 = r7 + 1;
            r15 = r7 + 2;
            r22 = r7 + 3;
            r25.rCubicTo(r1, r2, r12[r13], r12[r14], r12[r15], r12[r22]);
            r0 = r12[r13] + r9;
            r1 = r12[r14] + r8;
            r9 = r9 + r12[r15];
            r2 = r12[r22];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ef, code lost:
            r0 = r12[r7 + 0];
            r9 = r9 + r0;
            r1 = r12[r7 + 1];
            r8 = r8 + r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f9, code lost:
            if (r7 <= 0) goto L_0x00ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00fb, code lost:
            r10.rLineTo(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ff, code lost:
            r10.rMoveTo(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0104, code lost:
            r0 = r7 + 0;
            r4 = r7 + 1;
            r10.rLineTo(r12[r0], r12[r4]);
            r9 = r9 + r12[r0];
            r0 = r12[r4];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0114, code lost:
            r8 = r8 + r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0117, code lost:
            if (r0 == 'q') goto L_0x011f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0119, code lost:
            if (r0 == 't') goto L_0x011f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x011b, code lost:
            if (r0 == 'Q') goto L_0x011f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x011d, code lost:
            if (r0 != 'T') goto L_0x0125;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x011f, code lost:
            r9 = (r9 * 2.0f) - r2;
            r8 = (r8 * 2.0f) - r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0125, code lost:
            r0 = r7 + 0;
            r2 = r7 + 1;
            r10.quadTo(r9, r8, r12[r0], r12[r2]);
            r0 = r12[r0];
            r1 = r12[r2];
            r24 = r7;
            r3 = r8;
            r2 = r9;
            r9 = r0;
            r8 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x013c, code lost:
            if (r0 == 'c') goto L_0x0148;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x013e, code lost:
            if (r0 == 's') goto L_0x0148;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0142, code lost:
            if (r0 == 'C') goto L_0x0148;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0146, code lost:
            if (r0 != 'S') goto L_0x014e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0148, code lost:
            r9 = (r9 * 2.0f) - r2;
            r8 = (r8 * 2.0f) - r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x014e, code lost:
            r2 = r8;
            r8 = r7 + 0;
            r9 = r7 + 1;
            r13 = r7 + 2;
            r14 = r7 + 3;
            r25.cubicTo(r9, r2, r12[r8], r12[r9], r12[r13], r12[r14]);
            r0 = r12[r8];
            r1 = r12[r9];
            r9 = r12[r13];
            r8 = r12[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x016f, code lost:
            r9 = r12[r7 + 0];
            r8 = r12[r7 + 1];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0177, code lost:
            if (r7 <= 0) goto L_0x017e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0179, code lost:
            r10.lineTo(r9, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x017e, code lost:
            r10.moveTo(r9, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0181, code lost:
            r24 = r7;
            r21 = r8;
            r20 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x0189, code lost:
            r0 = r7 + 0;
            r4 = r7 + 1;
            r10.lineTo(r12[r0], r12[r4]);
            r9 = r12[r0];
            r8 = r12[r4];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x019a, code lost:
            r0 = r7 + 0;
            r10.rLineTo(com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO, r12[r0]);
            r0 = r12[r0];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            r19 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a6, code lost:
            r0 = r7 + 0;
            r2 = r7 + 1;
            r4 = r7 + 2;
            r6 = r7 + 3;
            r10.rQuadTo(r12[r0], r12[r2], r12[r4], r12[r6]);
            r0 = r12[r0] + r9;
            r1 = r12[r2] + r8;
            r9 = r9 + r12[r4];
            r2 = r12[r6];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x01c5, code lost:
            r0 = r7 + 0;
            r10.rLineTo(r12[r0], com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO);
            r9 = r9 + r12[r0];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x01d2, code lost:
            r13 = r7 + 2;
            r14 = r7 + 3;
            r15 = r7 + 4;
            r22 = r7 + 5;
            r25.rCubicTo(r12[r7 + 0], r12[r7 + 1], r12[r13], r12[r14], r12[r15], r12[r22]);
            r0 = r12[r13] + r9;
            r1 = r12[r14] + r8;
            r9 = r9 + r12[r15];
            r2 = r12[r22];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x01fa, code lost:
            r8 = r8 + r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x01fb, code lost:
            r2 = r0;
            r3 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x01ff, code lost:
            r13 = r7 + 5;
            r3 = r12[r13] + r9;
            r14 = r7 + 6;
            r4 = r12[r14] + r8;
            r5 = r12[r7 + 0];
            r6 = r12[r7 + 1];
            r15 = r12[r7 + 2];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x021e, code lost:
            if (r12[r7 + 3] == com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) goto L_0x0223;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0220, code lost:
            r22 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0223, code lost:
            r22 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
            r9 = r0;
            r8 = r1;
            r20 = r4;
            r21 = r5;
            r7 = 0;
            r0 = r27;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void a(android.graphics.Path r25, float[] r26, char r27, char r28, float[] r29) {
            /*
                r10 = r25
                r11 = r28
                r12 = r29
                r13 = 0
                r0 = r26[r13]
                r14 = 1
                r1 = r26[r14]
                r15 = 2
                r2 = r26[r15]
                r16 = 3
                r3 = r26[r16]
                r17 = 4
                r4 = r26[r17]
                r18 = 5
                r5 = r26[r18]
                switch(r11) {
                    case 65: goto L_0x0034;
                    case 67: goto L_0x0032;
                    case 72: goto L_0x002f;
                    case 76: goto L_0x001e;
                    case 77: goto L_0x001e;
                    case 81: goto L_0x002c;
                    case 83: goto L_0x002c;
                    case 84: goto L_0x001e;
                    case 86: goto L_0x002f;
                    case 90: goto L_0x0021;
                    case 97: goto L_0x0034;
                    case 99: goto L_0x0032;
                    case 104: goto L_0x002f;
                    case 108: goto L_0x001e;
                    case 109: goto L_0x001e;
                    case 113: goto L_0x002c;
                    case 115: goto L_0x002c;
                    case 116: goto L_0x001e;
                    case 118: goto L_0x002f;
                    case 122: goto L_0x0021;
                    default: goto L_0x001e;
                }
            L_0x001e:
                r19 = r15
                goto L_0x0037
            L_0x0021:
                r25.close()
                r10.moveTo(r4, r5)
                r0 = r4
                r2 = r0
                r1 = r5
                r3 = r1
                goto L_0x001e
            L_0x002c:
                r19 = r17
                goto L_0x0037
            L_0x002f:
                r19 = r14
                goto L_0x0037
            L_0x0032:
                r6 = 6
                goto L_0x0035
            L_0x0034:
                r6 = 7
            L_0x0035:
                r19 = r6
            L_0x0037:
                r9 = r0
                r8 = r1
                r20 = r4
                r21 = r5
                r7 = r13
                r0 = r27
            L_0x0040:
                int r1 = r12.length
                if (r7 >= r1) goto L_0x02fa
                r1 = 65
                if (r11 == r1) goto L_0x02b4
                r1 = 67
                if (r11 == r1) goto L_0x0289
                r5 = 72
                if (r11 == r5) goto L_0x027b
                r5 = 81
                if (r11 == r5) goto L_0x025a
                r6 = 86
                if (r11 == r6) goto L_0x024c
                r6 = 97
                if (r11 == r6) goto L_0x01ff
                r6 = 99
                if (r11 == r6) goto L_0x01d2
                r15 = 104(0x68, float:1.46E-43)
                if (r11 == r15) goto L_0x01c5
                r15 = 113(0x71, float:1.58E-43)
                if (r11 == r15) goto L_0x01a6
                r14 = 118(0x76, float:1.65E-43)
                if (r11 == r14) goto L_0x019a
                r14 = 76
                if (r11 == r14) goto L_0x0189
                r14 = 77
                if (r11 == r14) goto L_0x016f
                r14 = 115(0x73, float:1.61E-43)
                r13 = 83
                r22 = 1073741824(0x40000000, float:2.0)
                if (r11 == r13) goto L_0x013c
                r4 = 116(0x74, float:1.63E-43)
                r13 = 84
                if (r11 == r13) goto L_0x0117
                r1 = 108(0x6c, float:1.51E-43)
                if (r11 == r1) goto L_0x0104
                r1 = 109(0x6d, float:1.53E-43)
                if (r11 == r1) goto L_0x00ef
                if (r11 == r14) goto L_0x00b7
                if (r11 == r4) goto L_0x0091
            L_0x008d:
                r24 = r7
                goto L_0x02f0
            L_0x0091:
                if (r0 == r15) goto L_0x009d
                if (r0 == r4) goto L_0x009d
                if (r0 == r5) goto L_0x009d
                if (r0 != r13) goto L_0x009a
                goto L_0x009d
            L_0x009a:
                r0 = 0
                r4 = 0
                goto L_0x00a1
            L_0x009d:
                float r4 = r9 - r2
                float r0 = r8 - r3
            L_0x00a1:
                int r1 = r7 + 0
                r2 = r12[r1]
                int r3 = r7 + 1
                r5 = r12[r3]
                r10.rQuadTo(r4, r0, r2, r5)
                float r4 = r4 + r9
                float r0 = r0 + r8
                r1 = r12[r1]
                float r9 = r9 + r1
                r1 = r12[r3]
                float r8 = r8 + r1
                r3 = r0
                r2 = r4
                goto L_0x008d
            L_0x00b7:
                if (r0 == r6) goto L_0x00c7
                if (r0 == r14) goto L_0x00c7
                r1 = 67
                if (r0 == r1) goto L_0x00c7
                r1 = 83
                if (r0 != r1) goto L_0x00c4
                goto L_0x00c7
            L_0x00c4:
                r1 = 0
                r2 = 0
                goto L_0x00cd
            L_0x00c7:
                float r0 = r9 - r2
                float r1 = r8 - r3
                r2 = r1
                r1 = r0
            L_0x00cd:
                int r13 = r7 + 0
                r3 = r12[r13]
                int r14 = r7 + 1
                r4 = r12[r14]
                int r15 = r7 + 2
                r5 = r12[r15]
                int r22 = r7 + 3
                r6 = r12[r22]
                r0 = r25
                r0.rCubicTo(r1, r2, r3, r4, r5, r6)
                r0 = r12[r13]
                float r0 = r0 + r9
                r1 = r12[r14]
                float r1 = r1 + r8
                r2 = r12[r15]
                float r9 = r9 + r2
                r2 = r12[r22]
                goto L_0x01fa
            L_0x00ef:
                int r0 = r7 + 0
                r0 = r12[r0]
                float r9 = r9 + r0
                int r1 = r7 + 1
                r1 = r12[r1]
                float r8 = r8 + r1
                if (r7 <= 0) goto L_0x00ff
                r10.rLineTo(r0, r1)
                goto L_0x008d
            L_0x00ff:
                r10.rMoveTo(r0, r1)
                goto L_0x0181
            L_0x0104:
                int r0 = r7 + 0
                r1 = r12[r0]
                int r4 = r7 + 1
                r5 = r12[r4]
                r10.rLineTo(r1, r5)
                r0 = r12[r0]
                float r9 = r9 + r0
                r0 = r12[r4]
            L_0x0114:
                float r8 = r8 + r0
                goto L_0x008d
            L_0x0117:
                if (r0 == r15) goto L_0x011f
                if (r0 == r4) goto L_0x011f
                if (r0 == r5) goto L_0x011f
                if (r0 != r13) goto L_0x0125
            L_0x011f:
                float r9 = r9 * r22
                float r9 = r9 - r2
                float r8 = r8 * r22
                float r8 = r8 - r3
            L_0x0125:
                int r0 = r7 + 0
                r1 = r12[r0]
                int r2 = r7 + 1
                r3 = r12[r2]
                r10.quadTo(r9, r8, r1, r3)
                r0 = r12[r0]
                r1 = r12[r2]
                r24 = r7
                r3 = r8
                r2 = r9
                r9 = r0
                r8 = r1
                goto L_0x02f0
            L_0x013c:
                if (r0 == r6) goto L_0x0148
                if (r0 == r14) goto L_0x0148
                r1 = 67
                if (r0 == r1) goto L_0x0148
                r1 = 83
                if (r0 != r1) goto L_0x014e
            L_0x0148:
                float r9 = r9 * r22
                float r9 = r9 - r2
                float r8 = r8 * r22
                float r8 = r8 - r3
            L_0x014e:
                r2 = r8
                r1 = r9
                int r8 = r7 + 0
                r3 = r12[r8]
                int r9 = r7 + 1
                r4 = r12[r9]
                int r13 = r7 + 2
                r5 = r12[r13]
                int r14 = r7 + 3
                r6 = r12[r14]
                r0 = r25
                r0.cubicTo(r1, r2, r3, r4, r5, r6)
                r0 = r12[r8]
                r1 = r12[r9]
                r9 = r12[r13]
                r8 = r12[r14]
                goto L_0x01fb
            L_0x016f:
                int r0 = r7 + 0
                r9 = r12[r0]
                int r0 = r7 + 1
                r8 = r12[r0]
                if (r7 <= 0) goto L_0x017e
                r10.lineTo(r9, r8)
                goto L_0x008d
            L_0x017e:
                r10.moveTo(r9, r8)
            L_0x0181:
                r24 = r7
                r21 = r8
                r20 = r9
                goto L_0x02f0
            L_0x0189:
                int r0 = r7 + 0
                r1 = r12[r0]
                int r4 = r7 + 1
                r5 = r12[r4]
                r10.lineTo(r1, r5)
                r9 = r12[r0]
                r8 = r12[r4]
                goto L_0x008d
            L_0x019a:
                int r0 = r7 + 0
                r1 = r12[r0]
                r4 = 0
                r10.rLineTo(r4, r1)
                r0 = r12[r0]
                goto L_0x0114
            L_0x01a6:
                int r0 = r7 + 0
                r1 = r12[r0]
                int r2 = r7 + 1
                r3 = r12[r2]
                int r4 = r7 + 2
                r5 = r12[r4]
                int r6 = r7 + 3
                r13 = r12[r6]
                r10.rQuadTo(r1, r3, r5, r13)
                r0 = r12[r0]
                float r0 = r0 + r9
                r1 = r12[r2]
                float r1 = r1 + r8
                r2 = r12[r4]
                float r9 = r9 + r2
                r2 = r12[r6]
                goto L_0x01fa
            L_0x01c5:
                int r0 = r7 + 0
                r1 = r12[r0]
                r4 = 0
                r10.rLineTo(r1, r4)
                r0 = r12[r0]
                float r9 = r9 + r0
                goto L_0x008d
            L_0x01d2:
                int r0 = r7 + 0
                r1 = r12[r0]
                int r0 = r7 + 1
                r2 = r12[r0]
                int r13 = r7 + 2
                r3 = r12[r13]
                int r14 = r7 + 3
                r4 = r12[r14]
                int r15 = r7 + 4
                r5 = r12[r15]
                int r22 = r7 + 5
                r6 = r12[r22]
                r0 = r25
                r0.rCubicTo(r1, r2, r3, r4, r5, r6)
                r0 = r12[r13]
                float r0 = r0 + r9
                r1 = r12[r14]
                float r1 = r1 + r8
                r2 = r12[r15]
                float r9 = r9 + r2
                r2 = r12[r22]
            L_0x01fa:
                float r8 = r8 + r2
            L_0x01fb:
                r2 = r0
                r3 = r1
                goto L_0x008d
            L_0x01ff:
                int r13 = r7 + 5
                r0 = r12[r13]
                float r3 = r0 + r9
                int r14 = r7 + 6
                r0 = r12[r14]
                float r4 = r0 + r8
                int r0 = r7 + 0
                r5 = r12[r0]
                int r0 = r7 + 1
                r6 = r12[r0]
                int r0 = r7 + 2
                r15 = r12[r0]
                int r0 = r7 + 3
                r0 = r12[r0]
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x0223
                r22 = 1
                goto L_0x0225
            L_0x0223:
                r22 = 0
            L_0x0225:
                int r0 = r7 + 4
                r0 = r12[r0]
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x0230
                r23 = 1
                goto L_0x0232
            L_0x0230:
                r23 = 0
            L_0x0232:
                r0 = r25
                r1 = r9
                r2 = r8
                r24 = r7
                r7 = r15
                r15 = r8
                r8 = r22
                r11 = r9
                r9 = r23
                c(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r0 = r12[r13]
                float r9 = r11 + r0
                r0 = r12[r14]
                float r8 = r15 + r0
                goto L_0x02ee
            L_0x024c:
                r24 = r7
                r11 = r9
                int r7 = r24 + 0
                r0 = r12[r7]
                r10.lineTo(r11, r0)
                r8 = r12[r7]
                goto L_0x02f0
            L_0x025a:
                r24 = r7
                int r7 = r24 + 0
                r0 = r12[r7]
                int r1 = r24 + 1
                r2 = r12[r1]
                int r3 = r24 + 2
                r4 = r12[r3]
                int r5 = r24 + 3
                r6 = r12[r5]
                r10.quadTo(r0, r2, r4, r6)
                r0 = r12[r7]
                r1 = r12[r1]
                r9 = r12[r3]
                r8 = r12[r5]
                r2 = r0
                r3 = r1
                goto L_0x02f0
            L_0x027b:
                r24 = r7
                r15 = r8
                int r7 = r24 + 0
                r0 = r12[r7]
                r10.lineTo(r0, r15)
                r9 = r12[r7]
                goto L_0x02f0
            L_0x0289:
                r24 = r7
                int r7 = r24 + 0
                r1 = r12[r7]
                int r7 = r24 + 1
                r2 = r12[r7]
                int r7 = r24 + 2
                r3 = r12[r7]
                int r8 = r24 + 3
                r4 = r12[r8]
                int r9 = r24 + 4
                r5 = r12[r9]
                int r11 = r24 + 5
                r6 = r12[r11]
                r0 = r25
                r0.cubicTo(r1, r2, r3, r4, r5, r6)
                r9 = r12[r9]
                r0 = r12[r11]
                r1 = r12[r7]
                r2 = r12[r8]
                r8 = r0
                r3 = r2
                r2 = r1
                goto L_0x02f0
            L_0x02b4:
                r24 = r7
                r15 = r8
                r11 = r9
                int r13 = r24 + 5
                r3 = r12[r13]
                int r14 = r24 + 6
                r4 = r12[r14]
                int r7 = r24 + 0
                r5 = r12[r7]
                int r7 = r24 + 1
                r6 = r12[r7]
                int r7 = r24 + 2
                r7 = r12[r7]
                int r0 = r24 + 3
                r0 = r12[r0]
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x02d7
                r8 = 1
                goto L_0x02d8
            L_0x02d7:
                r8 = 0
            L_0x02d8:
                int r0 = r24 + 4
                r0 = r12[r0]
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x02e2
                r9 = 1
                goto L_0x02e3
            L_0x02e2:
                r9 = 0
            L_0x02e3:
                r0 = r25
                r1 = r11
                r2 = r15
                c(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r9 = r12[r13]
                r8 = r12[r14]
            L_0x02ee:
                r3 = r8
                r2 = r9
            L_0x02f0:
                int r7 = r24 + r19
                r0 = r28
                r11 = r0
                r13 = 0
                r14 = 1
                r15 = 2
                goto L_0x0040
            L_0x02fa:
                r15 = r8
                r11 = r9
                r0 = r13
                r26[r0] = r11
                r0 = 1
                r26[r0] = r15
                r0 = 2
                r26[r0] = r2
                r26[r16] = r3
                r26[r17] = r20
                r26[r18] = r21
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.c.b.a(android.graphics.Path, float[], char, char, float[]):void");
        }

        private static void b(Path path, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
            double d14 = d7;
            int ceil = (int) Math.ceil(Math.abs((d13 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d11);
            double sin = Math.sin(d11);
            double cos2 = Math.cos(d12);
            double sin2 = Math.sin(d12);
            double d15 = -d14;
            double d16 = d15 * cos;
            double d17 = d8 * sin;
            double d18 = (d16 * sin2) - (d17 * cos2);
            double d19 = d15 * sin;
            double d20 = d8 * cos;
            double d21 = (sin2 * d19) + (cos2 * d20);
            double d22 = d13 / ((double) ceil);
            double d23 = d21;
            double d24 = d18;
            int i5 = 0;
            double d25 = d9;
            double d26 = d10;
            double d27 = d12;
            while (i5 < ceil) {
                double d28 = d27 + d22;
                double sin3 = Math.sin(d28);
                double cos3 = Math.cos(d28);
                double d29 = (d5 + ((d14 * cos) * cos3)) - (d17 * sin3);
                double d30 = d6 + (d14 * sin * cos3) + (d20 * sin3);
                double d31 = (d16 * sin3) - (d17 * cos3);
                double d32 = (sin3 * d19) + (cos3 * d20);
                double d33 = d28 - d27;
                double tan = Math.tan(d33 / 2.0d);
                double sin4 = (Math.sin(d33) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d34 = d25 + (d24 * sin4);
                double d35 = sin;
                path.rLineTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                path.cubicTo((float) d34, (float) (d26 + (d23 * sin4)), (float) (d29 - (sin4 * d31)), (float) (d30 - (sin4 * d32)), (float) d29, (float) d30);
                i5++;
                d22 = d22;
                sin = d35;
                d25 = d29;
                d19 = d19;
                cos = cos;
                d27 = d28;
                d23 = d32;
                d24 = d31;
                ceil = ceil;
                d26 = d30;
                d14 = d7;
            }
        }

        private static void c(Path path, float f5, float f6, float f7, float f8, float f9, float f10, float f11, boolean z4, boolean z5) {
            double d5;
            double d6;
            float f12 = f5;
            float f13 = f7;
            float f14 = f9;
            boolean z6 = z5;
            double radians = Math.toRadians((double) f11);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d7 = (double) f12;
            double d8 = d7 * cos;
            double d9 = d7;
            double d10 = (double) f6;
            double d11 = (double) f14;
            double d12 = (d8 + (d10 * sin)) / d11;
            double d13 = (((double) (-f12)) * sin) + (d10 * cos);
            double d14 = d10;
            double d15 = (double) f10;
            double d16 = d13 / d15;
            double d17 = (double) f8;
            double d18 = ((((double) f13) * cos) + (d17 * sin)) / d11;
            double d19 = d11;
            double d20 = ((((double) (-f13)) * sin) + (d17 * cos)) / d15;
            double d21 = d12 - d18;
            double d22 = d16 - d20;
            double d23 = (d12 + d18) / 2.0d;
            double d24 = (d16 + d20) / 2.0d;
            double d25 = sin;
            double d26 = (d21 * d21) + (d22 * d22);
            if (d26 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d27 = (1.0d / d26) - 0.25d;
            if (d27 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d26);
                float sqrt = (float) (Math.sqrt(d26) / 1.99999d);
                c(path, f5, f6, f7, f8, f14 * sqrt, f10 * sqrt, f11, z4, z5);
                return;
            }
            double sqrt2 = Math.sqrt(d27);
            double d28 = d21 * sqrt2;
            double d29 = sqrt2 * d22;
            boolean z7 = z5;
            if (z4 == z7) {
                d6 = d23 - d29;
                d5 = d24 + d28;
            } else {
                d6 = d23 + d29;
                d5 = d24 - d28;
            }
            double atan2 = Math.atan2(d16 - d5, d12 - d6);
            double atan22 = Math.atan2(d20 - d5, d18 - d6) - atan2;
            int i5 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z7 != (i5 >= 0)) {
                atan22 = i5 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d30 = d6 * d19;
            double d31 = d5 * d15;
            b(path, (d30 * cos) - (d31 * d25), (d30 * d25) + (d31 * cos), d19, d15, d9, d14, radians, atan2, atan22);
        }

        public static void e(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c5 = 'm';
            for (int i5 = 0; i5 < bVarArr.length; i5++) {
                b bVar = bVarArr[i5];
                a(path, fArr, c5, bVar.f1698a, bVar.f1699b);
                c5 = bVarArr[i5].f1698a;
            }
        }

        public void d(b bVar, b bVar2, float f5) {
            this.f1698a = bVar.f1698a;
            int i5 = 0;
            while (true) {
                float[] fArr = bVar.f1699b;
                if (i5 < fArr.length) {
                    this.f1699b[i5] = (fArr[i5] * (1.0f - f5)) + (bVar2.f1699b[i5] * f5);
                    i5++;
                } else {
                    return;
                }
            }
        }
    }

    private static void a(ArrayList<b> arrayList, char c5, float[] fArr) {
        arrayList.add(new b(c5, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < bVarArr.length; i5++) {
            b bVar = bVarArr[i5];
            char c5 = bVar.f1698a;
            b bVar2 = bVarArr2[i5];
            if (c5 != bVar2.f1698a || bVar.f1699b.length != bVar2.f1699b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i5, int i6) {
        if (i5 <= i6) {
            int length = fArr.length;
            if (i5 < 0 || i5 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i7 = i6 - i5;
            int min = Math.min(i7, length - i5);
            float[] fArr2 = new float[i7];
            System.arraycopy(fArr, i5, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static b[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i5 = 1;
        int i6 = 0;
        while (i5 < str.length()) {
            int i7 = i(str, i5);
            String trim = str.substring(i6, i7).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i6 = i7;
            i5 = i7 + 1;
        }
        if (i5 - i6 == 1 && i6 < str.length()) {
            a(arrayList, str.charAt(i6), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        b[] d5 = d(str);
        if (d5 == null) {
            return null;
        }
        try {
            b.e(d5, path);
            return path;
        } catch (RuntimeException e5) {
            throw new RuntimeException("Error in parsing " + str, e5);
        }
    }

    public static b[] f(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i5 = 0; i5 < bVarArr.length; i5++) {
            bVarArr2[i5] = new b(bVarArr[i5]);
        }
        return bVarArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r10.f1697b = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r2 == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A[LOOP:0: B:1:0x0007->B:19:0x0038, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void g(java.lang.String r8, int r9, androidx.core.graphics.c.a r10) {
        /*
            r0 = 0
            r10.f1697b = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L_0x0007:
            int r5 = r8.length()
            if (r1 >= r5) goto L_0x003b
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L_0x0033
            r6 = 69
            if (r5 == r6) goto L_0x0031
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0031
            switch(r5) {
                case 44: goto L_0x0033;
                case 45: goto L_0x002a;
                case 46: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x002f
        L_0x0022:
            if (r3 != 0) goto L_0x0027
            r2 = r0
            r3 = r7
            goto L_0x0035
        L_0x0027:
            r10.f1697b = r7
            goto L_0x0033
        L_0x002a:
            if (r1 == r9) goto L_0x002f
            if (r2 != 0) goto L_0x002f
            goto L_0x0027
        L_0x002f:
            r2 = r0
            goto L_0x0035
        L_0x0031:
            r2 = r7
            goto L_0x0035
        L_0x0033:
            r2 = r0
            r4 = r7
        L_0x0035:
            if (r4 == 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x003b:
            r10.f1696a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.c.g(java.lang.String, int, androidx.core.graphics.c$a):void");
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i5 = 1;
            int i6 = 0;
            while (i5 < length) {
                g(str, i5, aVar);
                int i7 = aVar.f1696a;
                if (i5 < i7) {
                    fArr[i6] = Float.parseFloat(str.substring(i5, i7));
                    i6++;
                }
                i5 = aVar.f1697b ? i7 : i7 + 1;
            }
            return c(fArr, 0, i6);
        } catch (NumberFormatException e5) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e5);
        }
    }

    private static int i(String str, int i5) {
        while (i5 < str.length()) {
            char charAt = str.charAt(i5);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i5;
            }
            i5++;
        }
        return i5;
    }

    public static void j(b[] bVarArr, b[] bVarArr2) {
        for (int i5 = 0; i5 < bVarArr2.length; i5++) {
            bVarArr[i5].f1698a = bVarArr2[i5].f1698a;
            int i6 = 0;
            while (true) {
                float[] fArr = bVarArr2[i5].f1699b;
                if (i6 >= fArr.length) {
                    break;
                }
                bVarArr[i5].f1699b[i6] = fArr[i6];
                i6++;
            }
        }
    }
}
