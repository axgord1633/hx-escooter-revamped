package r0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import w0.p;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f6669c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private static a f6670d;

    /* renamed from: a  reason: collision with root package name */
    private final Lock f6671a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f6672b;

    a(Context context) {
        this.f6672b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        p.g(context);
        Lock lock = f6669c;
        lock.lock();
        try {
            if (f6670d == null) {
                f6670d = new a(context.getApplicationContext());
            }
            a aVar = f6670d;
            lock.unlock();
            return aVar;
        } catch (Throwable th) {
            f6669c.unlock();
            throw th;
        }
    }

    private static final String d(String str, String str2) {
        return str + ":" + str2;
    }

    public GoogleSignInAccount b() {
        String c5;
        String c6 = c("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(c6) || (c5 = c(d("googleSignInAccount", c6))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.l(c5);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final String c(String str) {
        this.f6671a.lock();
        try {
            return this.f6672b.getString(str, (String) null);
        } finally {
            this.f6671a.unlock();
        }
    }
}
