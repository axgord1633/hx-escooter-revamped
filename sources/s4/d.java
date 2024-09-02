package s4;

import java.nio.channels.WritableByteChannel;

public interface d extends r, WritableByteChannel {
    d I(String str);

    c a();

    void flush();

    d i(long j5);

    d write(byte[] bArr);

    d write(byte[] bArr, int i5, int i6);

    d writeByte(int i5);

    d writeInt(int i5);

    d writeShort(int i5);

    d y();
}
