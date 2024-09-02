package c4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.g;

public class v {

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3182b = AtomicIntegerFieldUpdater.newUpdater(v.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f3183a;

    public v(Throwable th, boolean z4) {
        this.f3183a = th;
        this._handled = z4 ? 1 : 0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(Throwable th, boolean z4, int i5, g gVar) {
        this(th, (i5 & 2) != 0 ? false : z4);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f3182b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return k0.a(this) + '[' + this.f3183a + ']';
    }
}
