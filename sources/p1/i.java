package p1;

import android.content.ContentResolver;
import android.content.Context;
import g0.c;
import g0.e;
import h0.a;
import p1.a;

public final class i implements c<ContentResolver> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f6466a;

    public i(a<Context> aVar) {
        this.f6466a = aVar;
    }

    public static i a(a<Context> aVar) {
        return new i(aVar);
    }

    public static ContentResolver c(Context context) {
        return (ContentResolver) e.d(a.c.h(context));
    }

    /* renamed from: b */
    public ContentResolver get() {
        return c(this.f6466a.get());
    }
}
