package com.google.android.gms.common.api.internal;

import android.os.Looper;
import java.util.concurrent.Executor;
import w0.p;

public final class c<L> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3330a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f3331b;

    /* renamed from: c  reason: collision with root package name */
    private volatile a f3332c;

    public static final class a<L> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f3333a;

        /* renamed from: b  reason: collision with root package name */
        private final String f3334b;

        a(L l5, String str) {
            this.f3333a = l5;
            this.f3334b = str;
        }

        public String a() {
            String str = this.f3334b;
            int identityHashCode = System.identityHashCode(this.f3333a);
            return str + "@" + identityHashCode;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3333a == aVar.f3333a && this.f3334b.equals(aVar.f3334b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.f3333a) * 31) + this.f3334b.hashCode();
        }
    }

    public interface b<L> {
        void a(L l5);

        void b();
    }

    c(Looper looper, L l5, String str) {
        this.f3330a = new b1.a(looper);
        this.f3331b = p.h(l5, "Listener must not be null");
        this.f3332c = new a(l5, p.e(str));
    }

    public void a() {
        this.f3331b = null;
        this.f3332c = null;
    }

    public a<L> b() {
        return this.f3332c;
    }

    public void c(b<? super L> bVar) {
        p.h(bVar, "Notifier must not be null");
        this.f3330a.execute(new v(this, bVar));
    }

    /* access modifiers changed from: package-private */
    public final void d(b bVar) {
        Object obj = this.f3331b;
        if (obj == null) {
            bVar.b();
            return;
        }
        try {
            bVar.a(obj);
        } catch (RuntimeException e5) {
            bVar.b();
            throw e5;
        }
    }
}
