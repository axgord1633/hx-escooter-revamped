package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ProfileInstallerInitializer f2670e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f2671f;

    public /* synthetic */ k(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f2670e = profileInstallerInitializer;
        this.f2671f = context;
    }

    public final void run() {
        this.f2670e.i(this.f2671f);
    }
}
