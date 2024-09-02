package androidx.profileinstaller;

import androidx.profileinstaller.j;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ j.c f2665e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f2666f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f2667g;

    public /* synthetic */ i(j.c cVar, int i5, Object obj) {
        this.f2665e = cVar;
        this.f2666f = i5;
        this.f2667g = obj;
    }

    public final void run() {
        this.f2665e.b(this.f2666f, this.f2667g);
    }
}
