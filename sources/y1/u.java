package y1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import m2.k;
import m2.l;
import m2.m;
import r2.d;

public class u {

    /* renamed from: a  reason: collision with root package name */
    final Context f7785a;

    /* renamed from: b  reason: collision with root package name */
    final w f7786b;

    class a implements m<Boolean> {

        /* renamed from: y1.u$a$a  reason: collision with other inner class name */
        class C0124a extends BroadcastReceiver {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f7788a;

            C0124a(l lVar) {
                this.f7788a = lVar;
            }

            public void onReceive(Context context, Intent intent) {
                this.f7788a.d(Boolean.valueOf(u.this.f7786b.b()));
            }
        }

        class b implements d {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ BroadcastReceiver f7790e;

            b(BroadcastReceiver broadcastReceiver) {
                this.f7790e = broadcastReceiver;
            }

            public void cancel() {
                u.this.f7785a.unregisterReceiver(this.f7790e);
            }
        }

        a() {
        }

        public void a(l<Boolean> lVar) {
            boolean b5 = u.this.f7786b.b();
            C0124a aVar = new C0124a(lVar);
            lVar.d(Boolean.valueOf(b5));
            u.this.f7785a.registerReceiver(aVar, new IntentFilter("android.location.MODE_CHANGED"));
            lVar.g(new b(aVar));
        }
    }

    u(Context context, w wVar) {
        this.f7785a = context;
        this.f7786b = wVar;
    }

    public k<Boolean> a() {
        return k.m(new a()).t().w0(k3.a.d()).K0(k3.a.d());
    }
}
