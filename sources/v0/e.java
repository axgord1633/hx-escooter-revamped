package v0;

import android.app.Activity;
import w0.p;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7120a;

    public e(Activity activity) {
        p.h(activity, "Activity must not be null");
        this.f7120a = activity;
    }

    public final Activity a() {
        return (Activity) this.f7120a;
    }

    public final androidx.fragment.app.e b() {
        return (androidx.fragment.app.e) this.f7120a;
    }

    public final boolean c() {
        return this.f7120a instanceof Activity;
    }

    public final boolean d() {
        return this.f7120a instanceof androidx.fragment.app.e;
    }
}
