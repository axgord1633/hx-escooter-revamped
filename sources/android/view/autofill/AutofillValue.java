package android.view.autofill;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.os.Parcelable;

public final /* synthetic */ class AutofillValue implements Parcelable {
    static {
        throw new NoClassDefFoundError();
    }

    public static native /* synthetic */ AutofillValue forText(@Nullable CharSequence charSequence);

    @NonNull
    public native /* synthetic */ CharSequence getTextValue();
}
