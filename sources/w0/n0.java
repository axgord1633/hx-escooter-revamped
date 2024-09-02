package w0;

import android.os.Bundle;
import t0.a;

abstract class n0 extends u0 {

    /* renamed from: d  reason: collision with root package name */
    public final int f7417d;

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f7418e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ c f7419f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected n0(c cVar, int i5, Bundle bundle) {
        super(cVar, Boolean.TRUE);
        this.f7419f = cVar;
        this.f7417d = i5;
        this.f7418e = bundle;
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [android.os.Parcelable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void a(java.lang.Object r3) {
        /*
            r2 = this;
            int r3 = r2.f7417d
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L_0x001c
            boolean r3 = r2.g()
            if (r3 != 0) goto L_0x001b
            w0.c r3 = r2.f7419f
            r3.g0(r0, (android.os.IInterface) null)
            t0.a r3 = new t0.a
            r0 = 8
            r3.<init>(r0, r1)
        L_0x0018:
            r2.f(r3)
        L_0x001b:
            return
        L_0x001c:
            w0.c r3 = r2.f7419f
            r3.g0(r0, (android.os.IInterface) null)
            android.os.Bundle r3 = r2.f7418e
            if (r3 == 0) goto L_0x002e
            java.lang.String r0 = "pendingIntent"
            android.os.Parcelable r3 = r3.getParcelable(r0)
            r1 = r3
            android.app.PendingIntent r1 = (android.app.PendingIntent) r1
        L_0x002e:
            t0.a r3 = new t0.a
            int r0 = r2.f7417d
            r3.<init>(r0, r1)
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.n0.a(java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public final void b() {
    }

    /* access modifiers changed from: protected */
    public abstract void f(a aVar);

    /* access modifiers changed from: protected */
    public abstract boolean g();
}
