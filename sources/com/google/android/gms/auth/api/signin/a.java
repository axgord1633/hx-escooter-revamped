package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import x0.b;

public final class a implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int r5 = b.r(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList<Scope> arrayList = null;
        String str7 = null;
        String str8 = null;
        int i5 = 0;
        long j5 = 0;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            switch (b.i(l5)) {
                case 1:
                    i5 = b.n(parcel2, l5);
                    break;
                case 2:
                    str = b.d(parcel2, l5);
                    break;
                case 3:
                    str2 = b.d(parcel2, l5);
                    break;
                case 4:
                    str3 = b.d(parcel2, l5);
                    break;
                case 5:
                    str4 = b.d(parcel2, l5);
                    break;
                case 6:
                    uri = (Uri) b.c(parcel2, l5, Uri.CREATOR);
                    break;
                case 7:
                    str5 = b.d(parcel2, l5);
                    break;
                case 8:
                    j5 = b.o(parcel2, l5);
                    break;
                case 9:
                    str6 = b.d(parcel2, l5);
                    break;
                case 10:
                    arrayList = b.g(parcel2, l5, Scope.CREATOR);
                    break;
                case 11:
                    str7 = b.d(parcel2, l5);
                    break;
                case 12:
                    str8 = b.d(parcel2, l5);
                    break;
                default:
                    b.q(parcel2, l5);
                    break;
            }
        }
        b.h(parcel2, r5);
        return new GoogleSignInAccount(i5, str, str2, str3, str4, uri, str5, j5, str6, arrayList, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new GoogleSignInAccount[i5];
    }
}
