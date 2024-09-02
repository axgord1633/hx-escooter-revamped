package io.flutter.embedding.engine.dart;

import java.nio.ByteBuffer;

public interface PlatformMessageHandler {
    void handleMessageFromDart(String str, ByteBuffer byteBuffer, int i5, long j5);

    void handlePlatformMessageResponse(int i5, ByteBuffer byteBuffer);
}
