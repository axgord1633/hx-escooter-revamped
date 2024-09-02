package androidx.core.content.res;

import android.graphics.Typeface;
import androidx.core.content.res.h;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h.b f1675e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Typeface f1676f;

    public /* synthetic */ i(h.b bVar, Typeface typeface) {
        this.f1675e = bVar;
        this.f1676f = typeface;
    }

    public final void run() {
        this.f1675e.g(this.f1676f);
    }
}
