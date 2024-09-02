package p1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import m2.k;
import m2.l;
import m2.m;
import m2.p;
import r1.q;
import r2.d;

public class e0 extends k<b> {

    /* renamed from: e  reason: collision with root package name */
    private final k<b> f6440e;

    class a implements m<b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f6441a;

        /* renamed from: p1.e0$a$a  reason: collision with other inner class name */
        class C0100a extends BroadcastReceiver {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f6443a;

            C0100a(l lVar) {
                this.f6443a = lVar;
            }

            public void onReceive(Context context, Intent intent) {
                b O0 = e0.O0(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1));
                q.k("Adapter state changed: %s", O0);
                this.f6443a.d(O0);
            }
        }

        class b implements d {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ BroadcastReceiver f6445e;

            b(BroadcastReceiver broadcastReceiver) {
                this.f6445e = broadcastReceiver;
            }

            public void cancel() {
                a.this.f6441a.unregisterReceiver(this.f6445e);
            }
        }

        a(Context context) {
            this.f6441a = context;
        }

        public void a(l<b> lVar) {
            C0100a aVar = new C0100a(lVar);
            this.f6441a.registerReceiver(aVar, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            lVar.g(new b(aVar));
        }
    }

    public static class b {

        /* renamed from: c  reason: collision with root package name */
        public static final b f6447c = new b(true, "STATE_ON");

        /* renamed from: d  reason: collision with root package name */
        public static final b f6448d = new b(false, "STATE_OFF");

        /* renamed from: e  reason: collision with root package name */
        public static final b f6449e = new b(false, "STATE_TURNING_ON");

        /* renamed from: f  reason: collision with root package name */
        public static final b f6450f = new b(false, "STATE_TURNING_OFF");

        /* renamed from: a  reason: collision with root package name */
        private final boolean f6451a;

        /* renamed from: b  reason: collision with root package name */
        private final String f6452b;

        private b(boolean z4, String str) {
            this.f6451a = z4;
            this.f6452b = str;
        }

        public boolean a() {
            return this.f6451a;
        }

        public String toString() {
            return this.f6452b;
        }
    }

    public e0(Context context) {
        this.f6440e = k.m(new a(context)).w0(k3.a.d()).K0(k3.a.d()).p0();
    }

    static b O0(int i5) {
        switch (i5) {
            case 11:
                return b.f6449e;
            case 12:
                return b.f6447c;
            case 13:
                return b.f6450f;
            default:
                return b.f6448d;
        }
    }

    /* access modifiers changed from: protected */
    public void v0(p<? super b> pVar) {
        this.f6440e.g(pVar);
    }
}
