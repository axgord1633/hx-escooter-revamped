package com.signify.hue.flutterreactiveble.debugutils;

import java.util.Arrays;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.t;

final class HexStringConversionKt$toHexString$1 extends l implements v3.l<Byte, CharSequence> {
    public static final HexStringConversionKt$toHexString$1 INSTANCE = new HexStringConversionKt$toHexString$1();

    HexStringConversionKt$toHexString$1() {
        super(1);
    }

    public final CharSequence invoke(byte b5) {
        t tVar = t.f5574a;
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b5)}, 1));
        k.d(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).byteValue());
    }
}
