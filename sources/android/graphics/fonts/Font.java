package android.graphics.fonts;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.content.res.Resources;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public final /* synthetic */ class Font {

    public final /* synthetic */ class Builder {
        static {
            throw new NoClassDefFoundError();
        }

        public /* synthetic */ Builder(@NonNull Resources resources, int i5) {
        }

        public /* synthetic */ Builder(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        }

        @NonNull
        public native /* synthetic */ Font build() throws IOException;

        @NonNull
        public native /* synthetic */ Builder setFontVariationSettings(@Nullable String str);

        @NonNull
        public native /* synthetic */ Builder setSlant(int i5);

        @NonNull
        public native /* synthetic */ Builder setTtcIndex(int i5);

        @NonNull
        public native /* synthetic */ Builder setWeight(int i5);
    }

    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public native /* synthetic */ FontStyle getStyle();
}
