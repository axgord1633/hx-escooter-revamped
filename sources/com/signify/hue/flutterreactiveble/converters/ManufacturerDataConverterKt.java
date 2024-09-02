package com.signify.hue.flutterreactiveble.converters;

import android.util.SparseArray;
import java.util.ArrayList;
import kotlin.jvm.internal.k;

public final class ManufacturerDataConverterKt {
    public static final byte[] extractManufacturerData(SparseArray<byte[]> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (sparseArray != null && sparseArray.size() > 0) {
            int keyAt = sparseArray.keyAt(0);
            byte[] bArr = sparseArray.get(keyAt);
            arrayList.add(Byte.valueOf((byte) keyAt));
            arrayList.add(Byte.valueOf((byte) (keyAt >> 8)));
            k.d(bArr, "payload");
            arrayList.addAll(2, i.b(bArr));
        }
        return v.t(arrayList);
    }
}
