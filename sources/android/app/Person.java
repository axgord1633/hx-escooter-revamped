package android.app;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.graphics.drawable.Icon;
import android.os.Parcelable;

public final /* synthetic */ class Person implements Parcelable {

    public /* synthetic */ class Builder {
        static {
            throw new NoClassDefFoundError();
        }

        @NonNull
        public native /* synthetic */ Person build();

        @NonNull
        public native /* synthetic */ Builder setBot(boolean z4);

        @NonNull
        public native /* synthetic */ Builder setIcon(@Nullable Icon icon);

        @NonNull
        public native /* synthetic */ Builder setImportant(boolean z4);

        @NonNull
        public native /* synthetic */ Builder setKey(@Nullable String str);

        @NonNull
        public native /* synthetic */ Builder setName(@Nullable CharSequence charSequence);

        @NonNull
        public native /* synthetic */ Builder setUri(@Nullable String str);
    }

    static {
        throw new NoClassDefFoundError();
    }

    @Nullable
    public native /* synthetic */ Icon getIcon();

    @Nullable
    public native /* synthetic */ String getKey();

    @Nullable
    public native /* synthetic */ CharSequence getName();

    @Nullable
    public native /* synthetic */ String getUri();

    public native /* synthetic */ boolean isBot();

    public native /* synthetic */ boolean isImportant();
}
