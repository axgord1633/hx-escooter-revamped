package androidx.loader.app;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.e0;
import androidx.lifecycle.j;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import m.h;

class b extends a {

    /* renamed from: c  reason: collision with root package name */
    static boolean f2625c = false;

    /* renamed from: a  reason: collision with root package name */
    private final j f2626a;

    /* renamed from: b  reason: collision with root package name */
    private final C0045b f2627b;

    public static class a<D> extends o<D> {

        /* renamed from: l  reason: collision with root package name */
        private final int f2628l;

        /* renamed from: m  reason: collision with root package name */
        private final Bundle f2629m;

        /* renamed from: n  reason: collision with root package name */
        private j f2630n;

        /* access modifiers changed from: protected */
        public void f() {
            if (b.f2625c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            throw null;
        }

        /* access modifiers changed from: protected */
        public void g() {
            if (b.f2625c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            throw null;
        }

        public void h(p<? super D> pVar) {
            super.h(pVar);
            this.f2630n = null;
        }

        public void i(D d5) {
            super.i(d5);
        }

        /* access modifiers changed from: package-private */
        public x.a<D> j(boolean z4) {
            if (b.f2625c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            throw null;
        }

        public void k(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f2628l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f2629m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("  ");
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void l() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f2628l);
            sb.append(" : ");
            androidx.core.util.b.a((Object) null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: androidx.loader.app.b$b  reason: collision with other inner class name */
    static class C0045b extends a0 {

        /* renamed from: f  reason: collision with root package name */
        private static final b0.b f2631f = new a();

        /* renamed from: d  reason: collision with root package name */
        private h<a> f2632d = new h<>();

        /* renamed from: e  reason: collision with root package name */
        private boolean f2633e = false;

        /* renamed from: androidx.loader.app.b$b$a */
        static class a implements b0.b {
            a() {
            }

            public <T extends a0> T a(Class<T> cls) {
                return new C0045b();
            }

            public /* synthetic */ a0 b(Class cls, w.a aVar) {
                return c0.b(this, cls, aVar);
            }
        }

        C0045b() {
        }

        static C0045b g(e0 e0Var) {
            return (C0045b) new b0(e0Var, f2631f).a(C0045b.class);
        }

        /* access modifiers changed from: protected */
        public void d() {
            super.d();
            int j5 = this.f2632d.j();
            for (int i5 = 0; i5 < j5; i5++) {
                this.f2632d.k(i5).j(true);
            }
            this.f2632d.b();
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f2632d.j() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i5 = 0; i5 < this.f2632d.j(); i5++) {
                    a k5 = this.f2632d.k(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f2632d.h(i5));
                    printWriter.print(": ");
                    printWriter.println(k5.toString());
                    k5.k(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            int j5 = this.f2632d.j();
            for (int i5 = 0; i5 < j5; i5++) {
                this.f2632d.k(i5).l();
            }
        }
    }

    b(j jVar, e0 e0Var) {
        this.f2626a = jVar;
        this.f2627b = C0045b.g(e0Var);
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f2627b.f(str, fileDescriptor, printWriter, strArr);
    }

    public void c() {
        this.f2627b.h();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.util.b.a(this.f2626a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
