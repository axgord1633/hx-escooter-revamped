package com.signify.hue.flutterreactiveble.converters;

import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class UuidConverter {
    public static final Companion Companion = new Companion((g) null);
    private static final int byteBufferSize = 16;
    private static final int byteSize16Bit = 2;
    private static final int byteSize32Bit = 4;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    private final UUID convert128BitNotationToUuid(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    private final UUID convert16BitToUuid(byte[] bArr) {
        return convert128BitNotationToUuid(new byte[]{0, 0, bArr[0], bArr[1], 0, 0, 16, 0, Byte.MIN_VALUE, 0, 0, Byte.MIN_VALUE, 95, -101, 52, -5});
    }

    private final UUID convert32BitToUuid(byte[] bArr) {
        return convert128BitNotationToUuid(new byte[]{bArr[0], bArr[1], bArr[2], bArr[3], 0, 0, 16, 0, Byte.MIN_VALUE, 0, 0, Byte.MIN_VALUE, 95, -101, 52, -5});
    }

    public final byte[] byteArrayFromUuid(UUID uuid) {
        k.e(uuid, "uuid");
        ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        byte[] array = wrap.array();
        k.d(array, "bb.array()");
        return array;
    }

    public final UUID uuidFromByteArray(byte[] bArr) {
        k.e(bArr, "bytes");
        int length = bArr.length;
        return length != 2 ? length != 4 ? convert128BitNotationToUuid(bArr) : convert32BitToUuid(bArr) : convert16BitToUuid(bArr);
    }
}
