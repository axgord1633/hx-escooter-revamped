package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import androidx.core.util.d;
import java.util.concurrent.Executor;

public class g {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f1828a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f1829b;

        @Deprecated
        public a(int i5, b[] bVarArr) {
            this.f1828a = i5;
            this.f1829b = bVarArr;
        }

        static a a(int i5, b[] bVarArr) {
            return new a(i5, bVarArr);
        }

        public b[] b() {
            return this.f1829b;
        }

        public int c() {
            return this.f1828a;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f1830a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1831b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1832c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f1833d;

        /* renamed from: e  reason: collision with root package name */
        private final int f1834e;

        @Deprecated
        public b(Uri uri, int i5, int i6, boolean z4, int i7) {
            this.f1830a = (Uri) d.h(uri);
            this.f1831b = i5;
            this.f1832c = i6;
            this.f1833d = z4;
            this.f1834e = i7;
        }

        static b a(Uri uri, int i5, int i6, boolean z4, int i7) {
            return new b(uri, i5, i6, z4, i7);
        }

        public int b() {
            return this.f1834e;
        }

        public int c() {
            return this.f1831b;
        }

        public Uri d() {
            return this.f1830a;
        }

        public int e() {
            return this.f1832c;
        }

        public boolean f() {
            return this.f1833d;
        }
    }

    public static class c {
        public void a(int i5) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, e eVar, int i5, boolean z4, int i6, Handler handler, c cVar) {
        a aVar = new a(cVar, handler);
        return z4 ? f.e(context, eVar, aVar, i5, i6) : f.d(context, eVar, i5, (Executor) null, aVar);
    }
}
