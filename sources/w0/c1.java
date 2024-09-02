package w0;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import x0.b;
import x0.c;

public final class c1 implements Parcelable.Creator {
    static void a(g gVar, Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, gVar.f7363e);
        c.g(parcel, 2, gVar.f7364f);
        c.g(parcel, 3, gVar.f7365g);
        c.k(parcel, 4, gVar.f7366h, false);
        c.f(parcel, 5, gVar.f7367i, false);
        c.m(parcel, 6, gVar.f7368j, i5, false);
        c.d(parcel, 7, gVar.f7369k, false);
        c.j(parcel, 8, gVar.f7370l, i5, false);
        c.m(parcel, 10, gVar.f7371m, i5, false);
        c.m(parcel, 11, gVar.f7372n, i5, false);
        c.c(parcel, 12, gVar.f7373o);
        c.g(parcel, 13, gVar.f7374p);
        c.c(parcel, 14, gVar.f7375q);
        c.k(parcel, 15, gVar.a(), false);
        c.b(parcel, a5);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int r5 = b.r(parcel);
        Scope[] scopeArr = g.f7361s;
        Bundle bundle = new Bundle();
        t0.c[] cVarArr = g.f7362t;
        t0.c[] cVarArr2 = cVarArr;
        String str = null;
        IBinder iBinder = null;
        Account account = null;
        String str2 = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z4 = false;
        int i8 = 0;
        boolean z5 = false;
        while (parcel.dataPosition() < r5) {
            int l5 = b.l(parcel);
            switch (b.i(l5)) {
                case 1:
                    i5 = b.n(parcel2, l5);
                    break;
                case 2:
                    i6 = b.n(parcel2, l5);
                    break;
                case 3:
                    i7 = b.n(parcel2, l5);
                    break;
                case 4:
                    str = b.d(parcel2, l5);
                    break;
                case 5:
                    iBinder = b.m(parcel2, l5);
                    break;
                case 6:
                    scopeArr = (Scope[]) b.f(parcel2, l5, Scope.CREATOR);
                    break;
                case 7:
                    bundle = b.a(parcel2, l5);
                    break;
                case 8:
                    account = (Account) b.c(parcel2, l5, Account.CREATOR);
                    break;
                case 10:
                    cVarArr = (t0.c[]) b.f(parcel2, l5, t0.c.CREATOR);
                    break;
                case 11:
                    cVarArr2 = (t0.c[]) b.f(parcel2, l5, t0.c.CREATOR);
                    break;
                case 12:
                    z4 = b.j(parcel2, l5);
                    break;
                case 13:
                    i8 = b.n(parcel2, l5);
                    break;
                case 14:
                    z5 = b.j(parcel2, l5);
                    break;
                case 15:
                    str2 = b.d(parcel2, l5);
                    break;
                default:
                    b.q(parcel2, l5);
                    break;
            }
        }
        b.h(parcel2, r5);
        return new g(i5, i6, i7, str, iBinder, scopeArr, bundle, account, cVarArr, cVarArr2, z4, i8, z5, str2);
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new g[i5];
    }
}
