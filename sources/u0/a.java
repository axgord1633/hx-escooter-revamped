package u0;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import u0.a.d;
import u0.f;
import v0.h;
import w0.c;
import w0.j;
import w0.p;

public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    private final C0113a f7069a;

    /* renamed from: b  reason: collision with root package name */
    private final g f7070b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7071c;

    /* renamed from: u0.a$a  reason: collision with other inner class name */
    public static abstract class C0113a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T a(Context context, Looper looper, w0.e eVar, O o5, f.a aVar, f.b bVar) {
            return b(context, looper, eVar, o5, aVar, bVar);
        }

        public T b(Context context, Looper looper, w0.e eVar, O o5, v0.c cVar, h hVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f7072a = new c((n) null);

        /* renamed from: u0.a$d$a  reason: collision with other inner class name */
        public interface C0114a extends d {
            Account a();
        }

        public interface b extends d {
            GoogleSignInAccount b();
        }

        public static final class c implements d {
            private c() {
            }

            /* synthetic */ c(n nVar) {
            }
        }
    }

    public static abstract class e<T extends b, O> {
    }

    public interface f extends b {
        boolean a();

        void b(c.C0119c cVar);

        Set<Scope> c();

        void d(c.e eVar);

        void e(String str);

        boolean f();

        void g(j jVar, Set<Scope> set);

        int h();

        boolean i();

        t0.c[] j();

        String k();

        String l();

        void n();

        boolean o();
    }

    public static final class g<C extends f> extends c<C> {
    }

    public <C extends f> a(String str, C0113a<C, O> aVar, g<C> gVar) {
        p.h(aVar, "Cannot construct an Api with a null ClientBuilder");
        p.h(gVar, "Cannot construct an Api with a null ClientKey");
        this.f7071c = str;
        this.f7069a = aVar;
        this.f7070b = gVar;
    }

    public final C0113a a() {
        return this.f7069a;
    }

    public final String b() {
        return this.f7071c;
    }
}
