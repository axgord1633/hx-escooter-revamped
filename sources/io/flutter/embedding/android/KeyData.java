package io.flutter.embedding.android;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class KeyData {
    private static final int BYTES_PER_FIELD = 8;
    public static final String CHANNEL = "flutter/keydata";
    private static final int FIELD_COUNT = 5;
    private static final String TAG = "KeyData";
    String character;
    long logicalKey;
    long physicalKey;
    boolean synthesized;
    long timestamp;
    Type type;

    public enum Type {
        kDown(0),
        kUp(1),
        kRepeat(2);
        
        private long value;

        private Type(long j5) {
            this.value = j5;
        }

        static Type fromLong(long j5) {
            int i5 = (int) j5;
            if (i5 == 0) {
                return kDown;
            }
            if (i5 == 1) {
                return kUp;
            }
            if (i5 == 2) {
                return kRepeat;
            }
            throw new AssertionError("Unexpected Type value");
        }

        public long getValue() {
            return this.value;
        }
    }

    public KeyData() {
    }

    public KeyData(ByteBuffer byteBuffer) {
        long j5 = byteBuffer.getLong();
        this.timestamp = byteBuffer.getLong();
        this.type = Type.fromLong(byteBuffer.getLong());
        this.physicalKey = byteBuffer.getLong();
        this.logicalKey = byteBuffer.getLong();
        this.synthesized = byteBuffer.getLong() != 0;
        if (((long) byteBuffer.remaining()) == j5) {
            this.character = null;
            if (j5 != 0) {
                int i5 = (int) j5;
                byte[] bArr = new byte[i5];
                byteBuffer.get(bArr, 0, i5);
                try {
                    this.character = new String(bArr, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    throw new AssertionError("UTF-8 unsupported");
                }
            }
        } else {
            throw new AssertionError(String.format("Unexpected char length: charSize is %d while buffer has position %d, capacity %d, limit %d", new Object[]{Long.valueOf(j5), Integer.valueOf(byteBuffer.position()), Integer.valueOf(byteBuffer.capacity()), Integer.valueOf(byteBuffer.limit())}));
        }
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer toBytes() {
        try {
            String str = this.character;
            byte[] bytes = str == null ? null : str.getBytes("UTF-8");
            int length = bytes == null ? 0 : bytes.length;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length + 48);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong((long) length);
            allocateDirect.putLong(this.timestamp);
            allocateDirect.putLong(this.type.getValue());
            allocateDirect.putLong(this.physicalKey);
            allocateDirect.putLong(this.logicalKey);
            allocateDirect.putLong(this.synthesized ? 1 : 0);
            if (bytes != null) {
                allocateDirect.put(bytes);
            }
            return allocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }
}
