package com.signify.hue.flutterreactiveble.debugutils;

import com.yalantis.ucrop.BuildConfig;
import kotlin.jvm.internal.k;

public final class HexStringConversionKt {
    public static final String toHexString(byte[] bArr) {
        k.e(bArr, "<this>");
        return j.r(bArr, BuildConfig.FLAVOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, HexStringConversionKt$toHexString$1.INSTANCE, 30, (Object) null);
    }
}
