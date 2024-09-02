package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f2672e;

    public /* synthetic */ l(Context context) {
        this.f2672e = context;
    }

    public final void run() {
        ProfileInstallerInitializer.l(this.f2672e);
    }
}
