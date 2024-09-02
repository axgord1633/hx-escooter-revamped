package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import w.a;

public class b0 {

    /* renamed from: a  reason: collision with root package name */
    private final e0 f2561a;

    /* renamed from: b  reason: collision with root package name */
    private final b f2562b;

    /* renamed from: c  reason: collision with root package name */
    private final w.a f2563c;

    public static class a extends c {

        /* renamed from: e  reason: collision with root package name */
        public static final C0040a f2564e = new C0040a((g) null);
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static a f2565f;

        /* renamed from: g  reason: collision with root package name */
        public static final a.b<Application> f2566g = C0040a.C0041a.f2568a;

        /* renamed from: d  reason: collision with root package name */
        private final Application f2567d;

        /* renamed from: androidx.lifecycle.b0$a$a  reason: collision with other inner class name */
        public static final class C0040a {

            /* renamed from: androidx.lifecycle.b0$a$a$a  reason: collision with other inner class name */
            private static final class C0041a implements a.b<Application> {

                /* renamed from: a  reason: collision with root package name */
                public static final C0041a f2568a = new C0041a();

                private C0041a() {
                }
            }

            private C0040a() {
            }

            public /* synthetic */ C0040a(g gVar) {
                this();
            }

            public final a a(Application application) {
                k.e(application, "application");
                if (a.f2565f == null) {
                    a.f2565f = new a(application);
                }
                a e5 = a.f2565f;
                k.b(e5);
                return e5;
            }
        }

        public a() {
            this((Application) null, 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            k.e(application, "application");
        }

        private a(Application application, int i5) {
            this.f2567d = application;
        }

        private final <T extends a0> T g(Class<T> cls, Application application) {
            if (!a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                T t5 = (a0) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{application});
                k.d(t5, "{\n                try {\n…          }\n            }");
                return t5;
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            } catch (IllegalAccessException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            } catch (InstantiationException e7) {
                throw new RuntimeException("Cannot create an instance of " + cls, e7);
            } catch (InvocationTargetException e8) {
                throw new RuntimeException("Cannot create an instance of " + cls, e8);
            }
        }

        public <T extends a0> T a(Class<T> cls) {
            k.e(cls, "modelClass");
            Application application = this.f2567d;
            if (application != null) {
                return g(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        public <T extends a0> T b(Class<T> cls, w.a aVar) {
            k.e(cls, "modelClass");
            k.e(aVar, "extras");
            if (this.f2567d != null) {
                return a(cls);
            }
            Application application = (Application) aVar.a(f2566g);
            if (application != null) {
                return g(cls, application);
            }
            if (!a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
    }

    public interface b {
        <T extends a0> T a(Class<T> cls);

        <T extends a0> T b(Class<T> cls, w.a aVar);
    }

    public static class c implements b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f2569a = new a((g) null);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static c f2570b;

        /* renamed from: c  reason: collision with root package name */
        public static final a.b<String> f2571c = a.C0042a.f2572a;

        public static final class a {

            /* renamed from: androidx.lifecycle.b0$c$a$a  reason: collision with other inner class name */
            private static final class C0042a implements a.b<String> {

                /* renamed from: a  reason: collision with root package name */
                public static final C0042a f2572a = new C0042a();

                private C0042a() {
                }
            }

            private a() {
            }

            public /* synthetic */ a(g gVar) {
                this();
            }

            public final c a() {
                if (c.f2570b == null) {
                    c.f2570b = new c();
                }
                c c5 = c.f2570b;
                k.b(c5);
                return c5;
            }
        }

        public <T extends a0> T a(Class<T> cls) {
            k.e(cls, "modelClass");
            try {
                T newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                k.d(newInstance, "{\n                modelC…wInstance()\n            }");
                return (a0) newInstance;
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            } catch (InstantiationException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            } catch (IllegalAccessException e7) {
                throw new RuntimeException("Cannot create an instance of " + cls, e7);
            }
        }

        public /* synthetic */ a0 b(Class cls, w.a aVar) {
            return c0.b(this, cls, aVar);
        }
    }

    public static class d {
        public void c(a0 a0Var) {
            k.e(a0Var, "viewModel");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b0(e0 e0Var, b bVar) {
        this(e0Var, bVar, (w.a) null, 4, (g) null);
        k.e(e0Var, "store");
        k.e(bVar, "factory");
    }

    public b0(e0 e0Var, b bVar, w.a aVar) {
        k.e(e0Var, "store");
        k.e(bVar, "factory");
        k.e(aVar, "defaultCreationExtras");
        this.f2561a = e0Var;
        this.f2562b = bVar;
        this.f2563c = aVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(e0 e0Var, b bVar, w.a aVar, int i5, g gVar) {
        this(e0Var, bVar, (i5 & 4) != 0 ? a.C0118a.f7283b : aVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b0(f0 f0Var, b bVar) {
        this(f0Var.getViewModelStore(), bVar, d0.a(f0Var));
        k.e(f0Var, "owner");
        k.e(bVar, "factory");
    }

    public <T extends a0> T a(Class<T> cls) {
        k.e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends a0> T b(String str, Class<T> cls) {
        T t5;
        k.e(str, "key");
        k.e(cls, "modelClass");
        T b5 = this.f2561a.b(str);
        if (cls.isInstance(b5)) {
            b bVar = this.f2562b;
            d dVar = bVar instanceof d ? (d) bVar : null;
            if (dVar != null) {
                k.b(b5);
                dVar.c(b5);
            }
            k.c(b5, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return b5;
        }
        w.d dVar2 = new w.d(this.f2563c);
        dVar2.c(c.f2571c, str);
        try {
            t5 = this.f2562b.b(cls, dVar2);
        } catch (AbstractMethodError unused) {
            t5 = this.f2562b.a(cls);
        }
        this.f2561a.d(str, t5);
        return t5;
    }
}
