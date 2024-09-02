package h2;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.k;

public final class b {
    public static final byte[] a(Bitmap bitmap) {
        k.e(bitmap, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        k.d(byteArray, "stream.toByteArray()");
        return byteArray;
    }
}
