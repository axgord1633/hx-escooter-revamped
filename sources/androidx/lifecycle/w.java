package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.a;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import m3.e;

public final class w implements a.c {

    /* renamed from: a  reason: collision with root package name */
    private final androidx.savedstate.a f2612a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2613b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f2614c;

    /* renamed from: d  reason: collision with root package name */
    private final e f2615d;

    static final class a extends l implements v3.a<x> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ f0 f2616e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(f0 f0Var) {
            super(0);
            this.f2616e = f0Var;
        }

        /* renamed from: a */
        public final x invoke() {
            return v.e(this.f2616e);
        }
    }

    public w(androidx.savedstate.a aVar, f0 f0Var) {
        k.e(aVar, "savedStateRegistry");
        k.e(f0Var, "viewModelStoreOwner");
        this.f2612a = aVar;
        this.f2615d = g.a(new a(f0Var));
    }

    private final x c() {
        return (x) this.f2615d.getValue();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2614c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry next : c().f().entrySet()) {
            String str = (String) next.getKey();
            Bundle a5 = ((u) next.getValue()).c().a();
            if (!k.a(a5, Bundle.EMPTY)) {
                bundle.putBundle(str, a5);
            }
        }
        this.f2613b = false;
        return bundle;
    }

    public final Bundle b(String str) {
        k.e(str, "key");
        d();
        Bundle bundle = this.f2614c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f2614c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f2614c;
        boolean z4 = true;
        if (bundle4 == null || !bundle4.isEmpty()) {
            z4 = false;
        }
        if (z4) {
            this.f2614c = null;
        }
        return bundle2;
    }

    public final void d() {
        if (!this.f2613b) {
            this.f2614c = this.f2612a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
            this.f2613b = true;
            c();
        }
    }
}
