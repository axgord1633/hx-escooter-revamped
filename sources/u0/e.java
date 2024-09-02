package u0;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.r;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import l1.g;
import l1.h;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import u0.a;
import u0.a.d;
import v0.b;
import v0.c0;
import v0.j;
import v0.o;
import w0.e;
import w0.p;

public abstract class e<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7075a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7076b;

    /* renamed from: c  reason: collision with root package name */
    private final a f7077c;

    /* renamed from: d  reason: collision with root package name */
    private final a.d f7078d;

    /* renamed from: e  reason: collision with root package name */
    private final b f7079e;

    /* renamed from: f  reason: collision with root package name */
    private final Looper f7080f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7081g;
    @NotOnlyInitialized

    /* renamed from: h  reason: collision with root package name */
    private final f f7082h;

    /* renamed from: i  reason: collision with root package name */
    private final j f7083i;

    /* renamed from: j  reason: collision with root package name */
    protected final com.google.android.gms.common.api.internal.b f7084j;

    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final a f7085c = new C0115a().a();

        /* renamed from: a  reason: collision with root package name */
        public final j f7086a;

        /* renamed from: b  reason: collision with root package name */
        public final Looper f7087b;

        /* renamed from: u0.e$a$a  reason: collision with other inner class name */
        public static class C0115a {

            /* renamed from: a  reason: collision with root package name */
            private j f7088a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f7089b;

            public a a() {
                if (this.f7088a == null) {
                    this.f7088a = new v0.a();
                }
                if (this.f7089b == null) {
                    this.f7089b = Looper.getMainLooper();
                }
                return new a(this.f7088a, this.f7089b);
            }
        }

        private a(j jVar, Account account, Looper looper) {
            this.f7086a = jVar;
            this.f7087b = looper;
        }
    }

    private e(Context context, Activity activity, a aVar, a.d dVar, a aVar2) {
        p.h(context, "Null context is not permitted.");
        p.h(aVar, "Api must not be null.");
        p.h(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f7075a = context.getApplicationContext();
        String str = null;
        if (a1.e.i()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.f7076b = str;
        this.f7077c = aVar;
        this.f7078d = dVar;
        this.f7080f = aVar2.f7087b;
        b a5 = b.a(aVar, dVar, str);
        this.f7079e = a5;
        this.f7082h = new o(this);
        com.google.android.gms.common.api.internal.b x4 = com.google.android.gms.common.api.internal.b.x(this.f7075a);
        this.f7084j = x4;
        this.f7081g = x4.m();
        this.f7083i = aVar2.f7086a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            k.u(activity, x4, a5);
        }
        x4.b(this);
    }

    public e(Context context, a<O> aVar, O o5, a aVar2) {
        this(context, (Activity) null, aVar, o5, aVar2);
    }

    private final g p(int i5, com.google.android.gms.common.api.internal.g gVar) {
        h hVar = new h();
        this.f7084j.F(this, i5, gVar, hVar, this.f7083i);
        return hVar.a();
    }

    /* access modifiers changed from: protected */
    public e.a f() {
        Account account;
        GoogleSignInAccount b5;
        GoogleSignInAccount b6;
        e.a aVar = new e.a();
        a.d dVar = this.f7078d;
        if (!(dVar instanceof a.d.b) || (b6 = ((a.d.b) dVar).b()) == null) {
            a.d dVar2 = this.f7078d;
            account = dVar2 instanceof a.d.C0114a ? ((a.d.C0114a) dVar2).a() : null;
        } else {
            account = b6.a();
        }
        aVar.d(account);
        a.d dVar3 = this.f7078d;
        aVar.c((!(dVar3 instanceof a.d.b) || (b5 = ((a.d.b) dVar3).b()) == null) ? Collections.emptySet() : b5.i());
        aVar.e(this.f7075a.getClass().getName());
        aVar.b(this.f7075a.getPackageName());
        return aVar;
    }

    public <TResult, A extends a.b> g<TResult> g(com.google.android.gms.common.api.internal.g<A, TResult> gVar) {
        return p(2, gVar);
    }

    public <TResult, A extends a.b> g<TResult> h(com.google.android.gms.common.api.internal.g<A, TResult> gVar) {
        return p(0, gVar);
    }

    public <A extends a.b> g<Void> i(f<A, ?> fVar) {
        p.g(fVar);
        p.h(fVar.f3343a.b(), "Listener has already been released.");
        p.h(fVar.f3344b.a(), "Listener has already been released.");
        return this.f7084j.z(this, fVar.f3343a, fVar.f3344b, fVar.f3345c);
    }

    public g<Boolean> j(c.a<?> aVar, int i5) {
        p.h(aVar, "Listener key cannot be null.");
        return this.f7084j.A(this, aVar, i5);
    }

    public final b<O> k() {
        return this.f7079e;
    }

    /* access modifiers changed from: protected */
    public String l() {
        return this.f7076b;
    }

    public final int m() {
        return this.f7081g;
    }

    public final a.f n(Looper looper, r rVar) {
        Looper looper2 = looper;
        a.f a5 = ((a.C0113a) p.g(this.f7077c.a())).a(this.f7075a, looper2, f().a(), this.f7078d, rVar, rVar);
        String l5 = l();
        if (l5 != null && (a5 instanceof w0.c)) {
            ((w0.c) a5).O(l5);
        }
        if (l5 != null && (a5 instanceof v0.g)) {
            ((v0.g) a5).r(l5);
        }
        return a5;
    }

    public final c0 o(Context context, Handler handler) {
        return new c0(context, handler, f().a());
    }
}
