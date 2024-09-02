package k1;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import j1.f;
import t0.g;
import u0.f;
import w0.c;
import w0.e;
import w0.h;
import w0.j0;
import w0.l0;
import w0.p;

public class a extends h<g> implements f {
    public static final /* synthetic */ int M = 0;
    private final boolean I = true;
    private final e J;
    private final Bundle K;
    private final Integer L;

    public a(Context context, Looper looper, boolean z4, e eVar, Bundle bundle, f.a aVar, f.b bVar) {
        super(context, looper, 44, eVar, aVar, bVar);
        this.J = eVar;
        this.K = bundle;
        this.L = eVar.g();
    }

    public static Bundle j0(e eVar) {
        eVar.f();
        Integer g5 = eVar.g();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", eVar.a());
        if (g5 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", g5.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", (String) null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public final String D() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.signin.service.START";
    }

    public final int h() {
        return g.f6825a;
    }

    public final void m(f fVar) {
        p.h(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account b5 = this.J.b();
            ((g) C()).z(new j(1, new j0(b5, ((Integer) p.g(this.L)).intValue(), "<<default account>>".equals(b5.name) ? r0.a.a(x()).b() : null)), fVar);
        } catch (RemoteException e5) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                fVar.s(new l(1, new t0.a(8, (PendingIntent) null), (l0) null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e5);
            }
        }
    }

    public final boolean o() {
        return this.I;
    }

    public final void p() {
        b(new c.d());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof g ? (g) queryLocalInterface : new g(iBinder);
    }

    /* access modifiers changed from: protected */
    public final Bundle z() {
        if (!x().getPackageName().equals(this.J.d())) {
            this.K.putString("com.google.android.gms.signin.internal.realClientPackageName", this.J.d());
        }
        return this.K;
    }
}
