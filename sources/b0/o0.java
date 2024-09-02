package b0;

import android.view.View;
import android.view.WindowId;

class o0 implements p0 {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f2952a;

    o0(View view) {
        this.f2952a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof o0) && ((o0) obj).f2952a.equals(this.f2952a);
    }

    public int hashCode() {
        return this.f2952a.hashCode();
    }
}
