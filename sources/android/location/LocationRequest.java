package android.location;

import android.annotation.NonNull;
import android.os.Parcelable;

public final /* synthetic */ class LocationRequest implements Parcelable {

    public final /* synthetic */ class Builder {
        static {
            throw new NoClassDefFoundError();
        }

        public /* synthetic */ Builder(long j5) {
        }

        @NonNull
        public native /* synthetic */ LocationRequest build();

        @NonNull
        public native /* synthetic */ Builder setDurationMillis(long j5);

        @NonNull
        public native /* synthetic */ Builder setMaxUpdateDelayMillis(long j5);

        @NonNull
        public native /* synthetic */ Builder setMaxUpdates(int i5);

        @NonNull
        public native /* synthetic */ Builder setMinUpdateDistanceMeters(float f5);

        @NonNull
        public native /* synthetic */ Builder setMinUpdateIntervalMillis(long j5);

        @NonNull
        public native /* synthetic */ Builder setQuality(int i5);
    }

    static {
        throw new NoClassDefFoundError();
    }
}
