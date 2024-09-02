package t0;

import android.content.Context;
import android.util.Log;
import com.google.errorprone.annotations.CheckReturnValue;

@CheckReturnValue
final class v {

    /* renamed from: a  reason: collision with root package name */
    static final t f6840a = new n(r.c("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));

    /* renamed from: b  reason: collision with root package name */
    static final t f6841b = new o(r.c("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));

    /* renamed from: c  reason: collision with root package name */
    static final t f6842c = new p(r.c("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));

    /* renamed from: d  reason: collision with root package name */
    static final t f6843d = new q(r.c("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));

    /* renamed from: e  reason: collision with root package name */
    private static final Object f6844e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static Context f6845f;

    static synchronized void a(Context context) {
        synchronized (v.class) {
            if (f6845f != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f6845f = context.getApplicationContext();
            }
        }
    }
}
