package androidx.core.location;

import androidx.core.location.c;
import java.util.List;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ c.d f1743e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ List f1744f;

    public /* synthetic */ i(c.d dVar, List list) {
        this.f1743e = dVar;
        this.f1744f = list;
    }

    public final void run() {
        this.f1743e.j(this.f1744f);
    }
}
