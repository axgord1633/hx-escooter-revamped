package android.view.autofill;

import android.annotation.NonNull;
import android.graphics.Rect;
import android.view.View;

public final /* synthetic */ class AutofillManager {
    static {
        throw new NoClassDefFoundError();
    }

    public native /* synthetic */ void cancel();

    public native /* synthetic */ void commit();

    public native /* synthetic */ void notifyValueChanged(View view, int i5, AutofillValue autofillValue);

    public native /* synthetic */ void notifyViewEntered(@NonNull View view, int i5, @NonNull Rect rect);

    public native /* synthetic */ void notifyViewExited(@NonNull View view, int i5);
}
