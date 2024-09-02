package o4;

import com.yalantis.ucrop.R;
import java.io.ByteArrayOutputStream;
import s4.f;

class k {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f6325b = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, R.styleable.AppCompatTheme_switchStyle, R.styleable.AppCompatTheme_textAppearanceLargePopupMenu, R.styleable.AppCompatTheme_textAppearanceListItem, R.styleable.AppCompatTheme_textAppearanceListItemSecondary, R.styleable.AppCompatTheme_textAppearanceListItemSmall, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader, R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle, R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu, R.styleable.AppCompatTheme_textColorAlertDialogListItem, R.styleable.AppCompatTheme_textColorSearchUrl, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, R.styleable.AppCompatTheme_toolbarStyle, R.styleable.AppCompatTheme_tooltipForegroundColor, 252, R.styleable.AppCompatTheme_tooltipFrameBackground, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f6326c = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};

    /* renamed from: d  reason: collision with root package name */
    private static final k f6327d = new k();

    /* renamed from: a  reason: collision with root package name */
    private final a f6328a = new a();

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        final a[] f6329a;

        /* renamed from: b  reason: collision with root package name */
        final int f6330b;

        /* renamed from: c  reason: collision with root package name */
        final int f6331c;

        a() {
            this.f6329a = new a[256];
            this.f6330b = 0;
            this.f6331c = 0;
        }

        a(int i5, int i6) {
            this.f6329a = null;
            this.f6330b = i5;
            int i7 = i6 & 7;
            this.f6331c = i7 == 0 ? 8 : i7;
        }
    }

    private k() {
        b();
    }

    private void a(int i5, int i6, byte b5) {
        a aVar = new a(i5, b5);
        a aVar2 = this.f6328a;
        while (b5 > 8) {
            b5 = (byte) (b5 - 8);
            int i7 = (i6 >>> b5) & 255;
            a[] aVarArr = aVar2.f6329a;
            if (aVarArr != null) {
                if (aVarArr[i7] == null) {
                    aVarArr[i7] = new a();
                }
                aVar2 = aVar2.f6329a[i7];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i8 = 8 - b5;
        int i9 = (i6 << i8) & 255;
        int i10 = 1 << i8;
        for (int i11 = i9; i11 < i9 + i10; i11++) {
            aVar2.f6329a[i11] = aVar;
        }
    }

    private void b() {
        int i5 = 0;
        while (true) {
            byte[] bArr = f6326c;
            if (i5 < bArr.length) {
                a(i5, f6325b[i5], bArr[i5]);
                i5++;
            } else {
                return;
            }
        }
    }

    public static k f() {
        return f6327d;
    }

    /* access modifiers changed from: package-private */
    public byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = this.f6328a;
        byte b5 = 0;
        int i5 = 0;
        for (byte b6 : bArr) {
            b5 = (b5 << 8) | (b6 & 255);
            i5 += 8;
            while (i5 >= 8) {
                aVar = aVar.f6329a[(b5 >>> (i5 - 8)) & 255];
                if (aVar.f6329a == null) {
                    byteArrayOutputStream.write(aVar.f6330b);
                    i5 -= aVar.f6331c;
                    aVar = this.f6328a;
                } else {
                    i5 -= 8;
                }
            }
        }
        while (i5 > 0) {
            a aVar2 = aVar.f6329a[(b5 << (8 - i5)) & 255];
            if (aVar2.f6329a != null || aVar2.f6331c > i5) {
                break;
            }
            byteArrayOutputStream.write(aVar2.f6330b);
            i5 -= aVar2.f6331c;
            aVar = this.f6328a;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(s4.f r8, s4.d r9) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            r2 = r1
            r1 = r0
        L_0x0005:
            int r4 = r8.w()
            r5 = 255(0xff, float:3.57E-43)
            if (r0 >= r4) goto L_0x002e
            byte r4 = r8.p(r0)
            r4 = r4 & r5
            int[] r5 = f6325b
            r5 = r5[r4]
            byte[] r6 = f6326c
            byte r4 = r6[r4]
            long r2 = r2 << r4
            long r5 = (long) r5
            long r2 = r2 | r5
            int r1 = r1 + r4
        L_0x001e:
            r4 = 8
            if (r1 < r4) goto L_0x002b
            int r1 = r1 + -8
            long r4 = r2 >> r1
            int r4 = (int) r4
            r9.writeByte(r4)
            goto L_0x001e
        L_0x002b:
            int r0 = r0 + 1
            goto L_0x0005
        L_0x002e:
            if (r1 <= 0) goto L_0x003b
            int r8 = 8 - r1
            long r2 = r2 << r8
            int r8 = r5 >>> r1
            long r0 = (long) r8
            long r0 = r0 | r2
            int r8 = (int) r0
            r9.writeByte(r8)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.k.d(s4.f, s4.d):void");
    }

    /* access modifiers changed from: package-private */
    public int e(f fVar) {
        long j5 = 0;
        for (int i5 = 0; i5 < fVar.w(); i5++) {
            j5 += (long) f6326c[fVar.p(i5) & 255];
        }
        return (int) ((j5 + 7) >> 3);
    }
}
