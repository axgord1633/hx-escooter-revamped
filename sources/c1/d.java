package c1;

import android.content.Context;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f3078b = new d();

    /* renamed from: a  reason: collision with root package name */
    private c f3079a = null;

    public static c a(Context context) {
        return f3078b.b(context);
    }

    public final synchronized c b(Context context) {
        if (this.f3079a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f3079a = new c(context);
        }
        return this.f3079a;
    }
}
