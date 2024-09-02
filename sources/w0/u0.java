package w0;

import android.util.Log;

public abstract class u0 {

    /* renamed from: a  reason: collision with root package name */
    private Object f7438a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7439b = false;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ c f7440c;

    public u0(c cVar, Object obj) {
        this.f7440c = cVar;
        this.f7438a = obj;
    }

    /* access modifiers changed from: protected */
    public abstract void a(Object obj);

    /* access modifiers changed from: protected */
    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            obj = this.f7438a;
            if (this.f7439b) {
                String obj2 = toString();
                Log.w("GmsClient", "Callback proxy " + obj2 + " being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                a(obj);
            } catch (RuntimeException e5) {
                throw e5;
            }
        }
        synchronized (this) {
            this.f7439b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f7438a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f7440c.f7309r) {
            this.f7440c.f7309r.remove(this);
        }
    }
}
