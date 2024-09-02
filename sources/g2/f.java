package g2;

import android.app.Activity;
import g2.a;
import kotlin.jvm.internal.k;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private Activity f4737a;

    private final boolean a() {
        Activity activity = this.f4737a;
        k.b(activity);
        return (activity.getWindow().getAttributes().flags & 128) != 0;
    }

    public final a.C0079a b() {
        if (this.f4737a != null) {
            a.C0079a aVar = new a.C0079a();
            aVar.b(Boolean.valueOf(a()));
            return aVar;
        }
        throw new e();
    }

    public final void c(Activity activity) {
        this.f4737a = activity;
    }

    public final void d(a.b bVar) {
        k.e(bVar, "message");
        Activity activity = this.f4737a;
        if (activity != null) {
            k.b(activity);
            boolean a5 = a();
            Boolean b5 = bVar.b();
            k.b(b5);
            if (b5.booleanValue()) {
                if (!a5) {
                    activity.getWindow().addFlags(128);
                }
            } else if (a5) {
                activity.getWindow().clearFlags(128);
            }
        } else {
            throw new e();
        }
    }
}
