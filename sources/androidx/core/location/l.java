package androidx.core.location;

import android.os.Bundle;
import androidx.core.location.c;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ c.d f1749e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f1750f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f1751g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Bundle f1752h;

    public /* synthetic */ l(c.d dVar, String str, int i5, Bundle bundle) {
        this.f1749e = dVar;
        this.f1750f = str;
        this.f1751g = i5;
        this.f1752h = bundle;
    }

    public final void run() {
        this.f1749e.m(this.f1750f, this.f1751g, this.f1752h);
    }
}
