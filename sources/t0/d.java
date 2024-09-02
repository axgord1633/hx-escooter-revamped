package t0;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.l;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.yalantis.ucrop.BuildConfig;
import e1.e;
import e1.i;
import e1.j;
import s0.a;
import s0.b;
import v0.f;
import v0.p;
import v0.q;
import w0.b0;
import w0.e0;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {e1.d.class, e.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
public class d extends e {

    /* renamed from: d  reason: collision with root package name */
    public static final int f6818d = e.f6822a;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f6819e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static final d f6820f = new d();

    /* renamed from: c  reason: collision with root package name */
    private String f6821c;

    public static d k() {
        return f6820f;
    }

    public Intent a(Context context, int i5, String str) {
        return super.a(context, i5, str);
    }

    public PendingIntent b(Context context, int i5, int i6) {
        return super.b(context, i5, i6);
    }

    public final String d(int i5) {
        return super.d(i5);
    }

    public int e(Context context) {
        return super.e(context);
    }

    public int f(Context context, int i5) {
        return super.f(context, i5);
    }

    public final boolean h(int i5) {
        return super.h(i5);
    }

    public Dialog i(Activity activity, int i5, int i6, DialogInterface.OnCancelListener onCancelListener) {
        return n(activity, i5, e0.b(activity, a(activity, i5, "d"), i6), onCancelListener);
    }

    public PendingIntent j(Context context, a aVar) {
        return aVar.d() ? aVar.c() : b(context, aVar.a(), 0);
    }

    public boolean l(Activity activity, int i5, int i6, DialogInterface.OnCancelListener onCancelListener) {
        Dialog i7 = i(activity, i5, i6, onCancelListener);
        if (i7 == null) {
            return false;
        }
        q(activity, i7, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void m(Context context, int i5) {
        r(context, i5, (String) null, c(context, i5, 0, "n"));
    }

    /* access modifiers changed from: package-private */
    public final Dialog n(Context context, int i5, e0 e0Var, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i5 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(b0.d(context, i5));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c5 = b0.c(context, i5);
        if (c5 != null) {
            builder.setPositiveButton(c5, e0Var);
        }
        String g5 = b0.g(context, i5);
        if (g5 != null) {
            builder.setTitle(g5);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", new Object[]{Integer.valueOf(i5)}), new IllegalArgumentException());
        return builder.create();
    }

    public final Dialog o(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(b0.d(activity, 18));
        builder.setPositiveButton(BuildConfig.FLAVOR, (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        q(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final q p(Context context, p pVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        q qVar = new q(pVar);
        i.i(context, qVar, intentFilter);
        qVar.a(context);
        if (g(context, "com.google.android.gms")) {
            return qVar;
        }
        pVar.a();
        qVar.b();
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void q(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof androidx.fragment.app.e) {
                j.p(dialog, onCancelListener).o(((androidx.fragment.app.e) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* access modifiers changed from: package-private */
    public final void r(Context context, int i5, String str, PendingIntent pendingIntent) {
        int i6;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[]{Integer.valueOf(i5), null}), new IllegalArgumentException());
        if (i5 == 18) {
            s(context);
        } else if (pendingIntent != null) {
            String f5 = b0.f(context, i5);
            String e5 = b0.e(context, i5);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) w0.p.g(context.getSystemService("notification"));
            l.d o5 = new l.d(context).k(true).e(true).i(f5).o(new l.b().h(e5));
            if (a1.d.b(context)) {
                w0.p.i(a1.e.c());
                o5.n(context.getApplicationInfo().icon).m(2);
                if (a1.d.c(context)) {
                    o5.a(a.common_full_open_on_phone, resources.getString(b.common_open_on_phone), pendingIntent);
                } else {
                    o5.g(pendingIntent);
                }
            } else {
                o5.n(17301642).p(resources.getString(b.common_google_play_services_notification_ticker)).q(System.currentTimeMillis()).g(pendingIntent).h(e5);
            }
            if (a1.e.f()) {
                w0.p.i(a1.e.f());
                synchronized (f6819e) {
                    str2 = this.f6821c;
                }
                if (str2 == null) {
                    str2 = "com.google.android.gms.availability";
                    NotificationChannel a5 = notificationManager.getNotificationChannel(str2);
                    String b5 = b0.b(context);
                    if (a5 == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel(str2, b5, 4));
                    } else if (!b5.contentEquals(a5.getName())) {
                        a5.setName(b5);
                        notificationManager.createNotificationChannel(a5);
                    }
                }
                o5.f(str2);
            }
            Notification b6 = o5.b();
            if (i5 == 1 || i5 == 2 || i5 == 3) {
                g.f6826b.set(false);
                i6 = 10436;
            } else {
                i6 = 39789;
            }
            notificationManager.notify(i6, b6);
        } else if (i5 == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void s(Context context) {
        new k(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public final boolean t(Activity activity, f fVar, int i5, int i6, DialogInterface.OnCancelListener onCancelListener) {
        Dialog n5 = n(activity, i5, e0.c(fVar, a(activity, i5, "d"), 2), onCancelListener);
        if (n5 == null) {
            return false;
        }
        q(activity, n5, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean u(Context context, a aVar, int i5) {
        PendingIntent j5;
        if (c1.b.a(context) || (j5 = j(context, aVar)) == null) {
            return false;
        }
        r(context, aVar.a(), (String) null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, j5, i5, true), j.f4495a | 134217728));
        return true;
    }
}
