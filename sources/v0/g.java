package v0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;
import u0.a;
import w0.c;
import w0.i;
import w0.j;
import w0.p;

public final class g implements a.f, ServiceConnection {

    /* renamed from: l  reason: collision with root package name */
    private static final String f7126l = g.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final String f7127a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7128b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f7129c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f7130d;

    /* renamed from: e  reason: collision with root package name */
    private final c f7131e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f7132f;

    /* renamed from: g  reason: collision with root package name */
    private final h f7133g;

    /* renamed from: h  reason: collision with root package name */
    private IBinder f7134h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7135i;

    /* renamed from: j  reason: collision with root package name */
    private String f7136j;

    /* renamed from: k  reason: collision with root package name */
    private String f7137k;

    private final void s() {
        if (Thread.currentThread() != this.f7132f.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    public final boolean a() {
        s();
        return this.f7134h != null;
    }

    public final void b(c.C0119c cVar) {
        s();
        String.valueOf(this.f7134h);
        if (a()) {
            try {
                e("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.f7129c;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.f7127a).setAction(this.f7128b);
            }
            boolean bindService = this.f7130d.bindService(intent, this, i.a());
            this.f7135i = bindService;
            if (!bindService) {
                this.f7134h = null;
                this.f7133g.a(new t0.a(16));
            }
            String.valueOf(this.f7134h);
        } catch (SecurityException e5) {
            this.f7135i = false;
            this.f7134h = null;
            throw e5;
        }
    }

    public final Set<Scope> c() {
        return Collections.emptySet();
    }

    public final void d(c.e eVar) {
    }

    public final void e(String str) {
        s();
        this.f7136j = str;
        n();
    }

    public final boolean f() {
        return false;
    }

    public final void g(j jVar, Set<Scope> set) {
    }

    public final int h() {
        return 0;
    }

    public final boolean i() {
        s();
        return this.f7135i;
    }

    public final t0.c[] j() {
        return new t0.c[0];
    }

    public final String k() {
        String str = this.f7127a;
        if (str != null) {
            return str;
        }
        p.g(this.f7129c);
        return this.f7129c.getPackageName();
    }

    public final String l() {
        return this.f7136j;
    }

    public final void n() {
        s();
        String.valueOf(this.f7134h);
        try {
            this.f7130d.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.f7135i = false;
        this.f7134h = null;
    }

    public final boolean o() {
        return false;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f7132f.post(new t(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f7132f.post(new s(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void p() {
        this.f7135i = false;
        this.f7134h = null;
        this.f7131e.c(1);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void q(IBinder iBinder) {
        this.f7135i = false;
        this.f7134h = iBinder;
        String.valueOf(iBinder);
        this.f7131e.e(new Bundle());
    }

    public final void r(String str) {
        this.f7137k = str;
    }
}
