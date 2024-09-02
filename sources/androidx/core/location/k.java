package androidx.core.location;

import android.location.Location;
import androidx.core.location.c;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ c.d f1747e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Location f1748f;

    public /* synthetic */ k(c.d dVar, Location location) {
        this.f1747e = dVar;
        this.f1748f = location;
    }

    public final void run() {
        this.f1747e.i(this.f1748f);
    }
}
