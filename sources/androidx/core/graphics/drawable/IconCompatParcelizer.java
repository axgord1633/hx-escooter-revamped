package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1704a = aVar.p(iconCompat.f1704a, 1);
        iconCompat.f1706c = aVar.j(iconCompat.f1706c, 2);
        iconCompat.f1707d = aVar.r(iconCompat.f1707d, 3);
        iconCompat.f1708e = aVar.p(iconCompat.f1708e, 4);
        iconCompat.f1709f = aVar.p(iconCompat.f1709f, 5);
        iconCompat.f1710g = (ColorStateList) aVar.r(iconCompat.f1710g, 6);
        iconCompat.f1712i = aVar.t(iconCompat.f1712i, 7);
        iconCompat.f1713j = aVar.t(iconCompat.f1713j, 8);
        iconCompat.m();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.n(aVar.f());
        int i5 = iconCompat.f1704a;
        if (-1 != i5) {
            aVar.F(i5, 1);
        }
        byte[] bArr = iconCompat.f1706c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f1707d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i6 = iconCompat.f1708e;
        if (i6 != 0) {
            aVar.F(i6, 4);
        }
        int i7 = iconCompat.f1709f;
        if (i7 != 0) {
            aVar.F(i7, 5);
        }
        ColorStateList colorStateList = iconCompat.f1710g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f1712i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f1713j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
