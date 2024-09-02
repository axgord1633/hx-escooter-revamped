package r;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final c f6664a;

    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        final InputContentInfo f6665a;

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f6665a = new InputContentInfo(uri, clipDescription, uri2);
        }

        a(Object obj) {
            this.f6665a = (InputContentInfo) obj;
        }

        public Object a() {
            return this.f6665a;
        }

        public Uri b() {
            return this.f6665a.getContentUri();
        }

        public void c() {
            this.f6665a.requestPermission();
        }

        public Uri d() {
            return this.f6665a.getLinkUri();
        }

        public ClipDescription getDescription() {
            return this.f6665a.getDescription();
        }
    }

    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f6666a;

        /* renamed from: b  reason: collision with root package name */
        private final ClipDescription f6667b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f6668c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f6666a = uri;
            this.f6667b = clipDescription;
            this.f6668c = uri2;
        }

        public Object a() {
            return null;
        }

        public Uri b() {
            return this.f6666a;
        }

        public void c() {
        }

        public Uri d() {
            return this.f6668c;
        }

        public ClipDescription getDescription() {
            return this.f6667b;
        }
    }

    private interface c {
        Object a();

        Uri b();

        void c();

        Uri d();

        ClipDescription getDescription();
    }

    public d(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f6664a = Build.VERSION.SDK_INT >= 25 ? new a(uri, clipDescription, uri2) : new b(uri, clipDescription, uri2);
    }

    private d(c cVar) {
        this.f6664a = cVar;
    }

    public static d f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new d(new a(obj));
        }
        return null;
    }

    public Uri a() {
        return this.f6664a.b();
    }

    public ClipDescription b() {
        return this.f6664a.getDescription();
    }

    public Uri c() {
        return this.f6664a.d();
    }

    public void d() {
        this.f6664a.c();
    }

    public Object e() {
        return this.f6664a.a();
    }
}
