package io.flutter.plugin.common;

import java.nio.ByteBuffer;

public final class BinaryCodec implements MessageCodec<ByteBuffer> {
    public static final BinaryCodec INSTANCE = new BinaryCodec();
    public static final BinaryCodec INSTANCE_DIRECT = new BinaryCodec(true);
    private final boolean returnsDirectByteBufferFromDecoding;

    private BinaryCodec() {
        this.returnsDirectByteBufferFromDecoding = false;
    }

    private BinaryCodec(boolean z4) {
        this.returnsDirectByteBufferFromDecoding = z4;
    }

    public ByteBuffer decodeMessage(ByteBuffer byteBuffer) {
        if (byteBuffer == null || this.returnsDirectByteBufferFromDecoding) {
            return byteBuffer;
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
        allocate.put(byteBuffer);
        allocate.rewind();
        return allocate;
    }

    public ByteBuffer encodeMessage(ByteBuffer byteBuffer) {
        return byteBuffer;
    }
}
