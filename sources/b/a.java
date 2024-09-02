package b;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f2834a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private volatile Context f2835b;

    public final void a(b bVar) {
        k.e(bVar, "listener");
        Context context = this.f2835b;
        if (context != null) {
            bVar.a(context);
        }
        this.f2834a.add(bVar);
    }

    public final void b() {
        this.f2835b = null;
    }

    public final void c(Context context) {
        k.e(context, "context");
        this.f2835b = context;
        for (b a5 : this.f2834a) {
            a5.a(context);
        }
    }

    public final Context d() {
        return this.f2835b;
    }

    public final void e(b bVar) {
        k.e(bVar, "listener");
        this.f2834a.remove(bVar);
    }
}
