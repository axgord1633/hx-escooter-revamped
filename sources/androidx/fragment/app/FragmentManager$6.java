package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import androidx.lifecycle.j;

class FragmentManager$6 implements h {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f2171e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ s f2172f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ f f2173g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ n f2174h;

    public void a(j jVar, f.a aVar) {
        Bundle bundle;
        if (aVar == f.a.ON_START && (bundle = (Bundle) this.f2174h.f2338j.get(this.f2171e)) != null) {
            this.f2172f.a(this.f2171e, bundle);
            this.f2174h.r(this.f2171e);
        }
        if (aVar == f.a.ON_DESTROY) {
            this.f2173g.c(this);
            this.f2174h.f2339k.remove(this.f2171e);
        }
    }
}
