package android.graphics;

import android.annotation.NonNull;
import android.util.Size;
import java.io.IOException;
import java.nio.ByteBuffer;

public final /* synthetic */ class ImageDecoder implements AutoCloseable {

    public /* synthetic */ class ImageInfo {
        static {
            throw new NoClassDefFoundError();
        }

        @NonNull
        public native /* synthetic */ Size getSize();
    }

    public /* synthetic */ interface OnHeaderDecodedListener {
        static {
            throw new NoClassDefFoundError();
        }
    }

    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public static native /* synthetic */ Source createSource(@NonNull ByteBuffer byteBuffer);

    @NonNull
    public static native /* synthetic */ Bitmap decodeBitmap(@NonNull Source source, @NonNull OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    public native /* synthetic */ void setAllocator(int i5);

    public native /* synthetic */ void setTargetColorSpace(ColorSpace colorSpace);
}
