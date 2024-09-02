package androidx.profileinstaller;

import android.view.Choreographer;

public final /* synthetic */ class n implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f2674a;

    public /* synthetic */ n(Runnable runnable) {
        this.f2674a = runnable;
    }

    public final void doFrame(long j5) {
        this.f2674a.run();
    }
}
