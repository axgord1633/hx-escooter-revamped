package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.j;
import com.yalantis.ucrop.R;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f2638a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f2639b;

    /* renamed from: c  reason: collision with root package name */
    private final j.c f2640c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f2641d;

    /* renamed from: e  reason: collision with root package name */
    private final File f2642e;

    /* renamed from: f  reason: collision with root package name */
    private final String f2643f;

    /* renamed from: g  reason: collision with root package name */
    private final String f2644g;

    /* renamed from: h  reason: collision with root package name */
    private final String f2645h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2646i = false;

    /* renamed from: j  reason: collision with root package name */
    private e[] f2647j;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f2648k;

    public d(AssetManager assetManager, Executor executor, j.c cVar, String str, String str2, String str3, File file) {
        this.f2638a = assetManager;
        this.f2639b = executor;
        this.f2640c = cVar;
        this.f2643f = str;
        this.f2644g = str2;
        this.f2645h = str3;
        this.f2642e = file;
        this.f2641d = d();
    }

    private d b(e[] eVarArr, byte[] bArr) {
        j.c cVar;
        int i5;
        InputStream h5;
        try {
            h5 = h(this.f2638a, this.f2645h);
            if (h5 != null) {
                this.f2647j = o.q(h5, o.o(h5, o.f2676b), bArr, eVarArr);
                h5.close();
                return this;
            }
            if (h5 != null) {
                h5.close();
            }
            return null;
        } catch (FileNotFoundException e5) {
            e = e5;
            cVar = this.f2640c;
            i5 = 9;
            cVar.b(i5, e);
            return null;
        } catch (IOException e6) {
            e = e6;
            cVar = this.f2640c;
            i5 = 7;
            cVar.b(i5, e);
            return null;
        } catch (IllegalStateException e7) {
            e = e7;
            this.f2647j = null;
            cVar = this.f2640c;
            i5 = 8;
            cVar.b(i5, e);
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private void c() {
        if (!this.f2646i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 24 || i5 > 33) {
            return null;
        }
        switch (i5) {
            case 24:
            case 25:
                return q.f2691e;
            case 26:
                return q.f2690d;
            case 27:
                return q.f2689c;
            case 28:
            case 29:
            case R.styleable.AppCompatTheme_actionModeTheme /*30*/:
                return q.f2688b;
            case R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*31*/:
            case R.styleable.AppCompatTheme_actionOverflowButtonStyle /*32*/:
            case R.styleable.AppCompatTheme_actionOverflowMenuStyle /*33*/:
                return q.f2687a;
            default:
                return null;
        }
    }

    private InputStream f(AssetManager assetManager) {
        int i5;
        j.c cVar;
        try {
            return h(assetManager, this.f2644g);
        } catch (FileNotFoundException e5) {
            e = e5;
            cVar = this.f2640c;
            i5 = 6;
            cVar.b(i5, e);
            return null;
        } catch (IOException e6) {
            e = e6;
            cVar = this.f2640c;
            i5 = 7;
            cVar.b(i5, e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(int i5, Object obj) {
        this.f2640c.b(i5, obj);
    }

    private InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e5) {
            String message = e5.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.f2640c.a(5, (Object) null);
            return null;
        }
    }

    private e[] j(InputStream inputStream) {
        try {
            e[] w4 = o.w(inputStream, o.o(inputStream, o.f2675a), this.f2643f);
            try {
                inputStream.close();
                return w4;
            } catch (IOException e5) {
                this.f2640c.b(7, e5);
                return w4;
            }
        } catch (IOException e6) {
            this.f2640c.b(7, e6);
            inputStream.close();
            return null;
        } catch (IllegalStateException e7) {
            this.f2640c.b(8, e7);
            try {
                inputStream.close();
            } catch (IOException e8) {
                this.f2640c.b(7, e8);
            }
            return null;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e9) {
                this.f2640c.b(7, e9);
            }
            throw th;
        }
    }

    private static boolean k() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 24 || i5 > 33) {
            return false;
        }
        if (!(i5 == 24 || i5 == 25)) {
            switch (i5) {
                case R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*31*/:
                case R.styleable.AppCompatTheme_actionOverflowButtonStyle /*32*/:
                case R.styleable.AppCompatTheme_actionOverflowMenuStyle /*33*/:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private void l(int i5, Object obj) {
        this.f2639b.execute(new c(this, i5, obj));
    }

    public boolean e() {
        int i5;
        Integer num;
        if (this.f2641d == null) {
            i5 = 3;
            num = Integer.valueOf(Build.VERSION.SDK_INT);
        } else if (!this.f2642e.canWrite()) {
            i5 = 4;
            num = null;
        } else {
            this.f2646i = true;
            return true;
        }
        l(i5, num);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r0 = b(r0, r2.f2641d);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.profileinstaller.d i() {
        /*
            r2 = this;
            r2.c()
            byte[] r0 = r2.f2641d
            if (r0 != 0) goto L_0x0008
            return r2
        L_0x0008:
            android.content.res.AssetManager r0 = r2.f2638a
            java.io.InputStream r0 = r2.f(r0)
            if (r0 == 0) goto L_0x0016
            androidx.profileinstaller.e[] r0 = r2.j(r0)
            r2.f2647j = r0
        L_0x0016:
            androidx.profileinstaller.e[] r0 = r2.f2647j
            if (r0 == 0) goto L_0x0029
            boolean r1 = k()
            if (r1 == 0) goto L_0x0029
            byte[] r1 = r2.f2641d
            androidx.profileinstaller.d r0 = r2.b(r0, r1)
            if (r0 == 0) goto L_0x0029
            return r0
        L_0x0029:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.d.i():androidx.profileinstaller.d");
    }

    public d m() {
        int i5;
        j.c cVar;
        ByteArrayOutputStream byteArrayOutputStream;
        e[] eVarArr = this.f2647j;
        byte[] bArr = this.f2641d;
        if (!(eVarArr == null || bArr == null)) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                o.E(byteArrayOutputStream, bArr);
                if (!o.B(byteArrayOutputStream, bArr, eVarArr)) {
                    this.f2640c.b(5, (Object) null);
                    this.f2647j = null;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.f2648k = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                this.f2647j = null;
            } catch (IOException e5) {
                e = e5;
                cVar = this.f2640c;
                i5 = 7;
            } catch (IllegalStateException e6) {
                e = e6;
                cVar = this.f2640c;
                i5 = 8;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        return this;
        cVar.b(i5, e);
        this.f2647j = null;
        return this;
        throw th;
    }

    public boolean n() {
        FileOutputStream fileOutputStream;
        byte[] bArr = this.f2648k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                fileOutputStream = new FileOutputStream(this.f2642e);
                f.l(byteArrayInputStream, fileOutputStream);
                l(1, (Object) null);
                fileOutputStream.close();
                byteArrayInputStream.close();
                this.f2648k = null;
                this.f2647j = null;
                return true;
            } catch (Throwable th) {
                byteArrayInputStream.close();
                throw th;
            }
        } catch (FileNotFoundException e5) {
            l(6, e5);
            this.f2648k = null;
            this.f2647j = null;
            return false;
        } catch (IOException e6) {
            try {
                l(7, e6);
                this.f2648k = null;
                this.f2647j = null;
                return false;
            } catch (Throwable th2) {
                this.f2648k = null;
                this.f2647j = null;
                throw th2;
            }
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
        throw th;
    }
}
