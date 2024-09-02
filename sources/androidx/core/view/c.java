package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import com.yalantis.ucrop.BuildConfig;
import java.util.Objects;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final f f1895a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final C0032c f1896a;

        public a(ClipData clipData, int i5) {
            this.f1896a = Build.VERSION.SDK_INT >= 31 ? new b(clipData, i5) : new d(clipData, i5);
        }

        public c a() {
            return this.f1896a.build();
        }

        public a b(Bundle bundle) {
            this.f1896a.setExtras(bundle);
            return this;
        }

        public a c(int i5) {
            this.f1896a.b(i5);
            return this;
        }

        public a d(Uri uri) {
            this.f1896a.a(uri);
            return this;
        }
    }

    private static final class b implements C0032c {

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo.Builder f1897a;

        b(ClipData clipData, int i5) {
            this.f1897a = new ContentInfo.Builder(clipData, i5);
        }

        public void a(Uri uri) {
            this.f1897a.setLinkUri(uri);
        }

        public void b(int i5) {
            this.f1897a.setFlags(i5);
        }

        public c build() {
            return new c(new e(this.f1897a.build()));
        }

        public void setExtras(Bundle bundle) {
            this.f1897a.setExtras(bundle);
        }
    }

    /* renamed from: androidx.core.view.c$c  reason: collision with other inner class name */
    private interface C0032c {
        void a(Uri uri);

        void b(int i5);

        c build();

        void setExtras(Bundle bundle);
    }

    private static final class d implements C0032c {

        /* renamed from: a  reason: collision with root package name */
        ClipData f1898a;

        /* renamed from: b  reason: collision with root package name */
        int f1899b;

        /* renamed from: c  reason: collision with root package name */
        int f1900c;

        /* renamed from: d  reason: collision with root package name */
        Uri f1901d;

        /* renamed from: e  reason: collision with root package name */
        Bundle f1902e;

        d(ClipData clipData, int i5) {
            this.f1898a = clipData;
            this.f1899b = i5;
        }

        public void a(Uri uri) {
            this.f1901d = uri;
        }

        public void b(int i5) {
            this.f1900c = i5;
        }

        public c build() {
            return new c(new g(this));
        }

        public void setExtras(Bundle bundle) {
            this.f1902e = bundle;
        }
    }

    private static final class e implements f {

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo f1903a;

        e(ContentInfo contentInfo) {
            this.f1903a = (ContentInfo) androidx.core.util.d.h(contentInfo);
        }

        public ClipData a() {
            return this.f1903a.getClip();
        }

        public int b() {
            return this.f1903a.getFlags();
        }

        public ContentInfo c() {
            return this.f1903a;
        }

        public int d() {
            return this.f1903a.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f1903a + "}";
        }
    }

    private interface f {
        ClipData a();

        int b();

        ContentInfo c();

        int d();
    }

    private static final class g implements f {

        /* renamed from: a  reason: collision with root package name */
        private final ClipData f1904a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1905b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1906c;

        /* renamed from: d  reason: collision with root package name */
        private final Uri f1907d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f1908e;

        g(d dVar) {
            this.f1904a = (ClipData) androidx.core.util.d.h(dVar.f1898a);
            this.f1905b = androidx.core.util.d.d(dVar.f1899b, 0, 5, "source");
            this.f1906c = androidx.core.util.d.g(dVar.f1900c, 1);
            this.f1907d = dVar.f1901d;
            this.f1908e = dVar.f1902e;
        }

        public ClipData a() {
            return this.f1904a;
        }

        public int b() {
            return this.f1906c;
        }

        public ContentInfo c() {
            return null;
        }

        public int d() {
            return this.f1905b;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f1904a.getDescription());
            sb.append(", source=");
            sb.append(c.e(this.f1905b));
            sb.append(", flags=");
            sb.append(c.a(this.f1906c));
            Uri uri = this.f1907d;
            String str2 = BuildConfig.FLAVOR;
            if (uri == null) {
                str = str2;
            } else {
                str = ", hasLinkUri(" + this.f1907d.toString().length() + ")";
            }
            sb.append(str);
            if (this.f1908e != null) {
                str2 = ", hasExtras";
            }
            sb.append(str2);
            sb.append("}");
            return sb.toString();
        }
    }

    c(f fVar) {
        this.f1895a = fVar;
    }

    static String a(int i5) {
        return (i5 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i5);
    }

    static String e(int i5) {
        return i5 != 0 ? i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? i5 != 5 ? String.valueOf(i5) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static c g(ContentInfo contentInfo) {
        return new c(new e(contentInfo));
    }

    public ClipData b() {
        return this.f1895a.a();
    }

    public int c() {
        return this.f1895a.b();
    }

    public int d() {
        return this.f1895a.d();
    }

    public ContentInfo f() {
        ContentInfo c5 = this.f1895a.c();
        Objects.requireNonNull(c5);
        ContentInfo contentInfo = c5;
        return c5;
    }

    public String toString() {
        return this.f1895a.toString();
    }
}
