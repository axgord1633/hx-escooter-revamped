package android.content.pm;

import android.os.Parcelable;

public final /* synthetic */ class SigningInfo implements Parcelable {
    static {
        throw new NoClassDefFoundError();
    }

    public native /* synthetic */ Signature[] getApkContentsSigners();

    public native /* synthetic */ Signature[] getSigningCertificateHistory();

    public native /* synthetic */ boolean hasMultipleSigners();
}
