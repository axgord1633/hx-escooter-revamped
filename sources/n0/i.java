package n0;

import android.app.Activity;
import l1.d;
import m0.a;

public final /* synthetic */ class i implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f6021a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f6022b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f6023c;

    public /* synthetic */ i(j jVar, Activity activity, a aVar) {
        this.f6021a = jVar;
        this.f6022b = activity;
        this.f6023c = aVar;
    }

    public final void onFailure(Exception exc) {
        this.f6021a.w(this.f6022b, this.f6023c, exc);
    }
}
