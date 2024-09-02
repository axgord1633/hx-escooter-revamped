package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.api.internal.b;
import t0.a;
import t0.d;
import w0.p;

public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: e  reason: collision with root package name */
    protected int f3270e = 0;

    public static Intent a(Context context, PendingIntent pendingIntent, int i5, boolean z4) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i5);
        intent.putExtra("notify_manager", z4);
        return intent;
    }

    private final void b() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, (Intent) null, 0, 0, 0);
                this.f3270e = 1;
            } catch (ActivityNotFoundException e5) {
                if (extras.getBoolean("notify_manager", true)) {
                    b.x(this).H(new a(22, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String str = "Activity not found while launching " + pendingIntent.toString() + ".";
                    if (Build.FINGERPRINT.contains("generic")) {
                        str = str.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                    Log.e("GoogleApiActivity", str, e5);
                }
                this.f3270e = 1;
                finish();
            } catch (IntentSender.SendIntentException e6) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e6);
                finish();
            }
        } else {
            d.k().l(this, ((Integer) p.g(num)).intValue(), 2, this);
            this.f3270e = 1;
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        if (i5 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f3270e = 0;
            setResult(i6, intent);
            if (booleanExtra) {
                b x4 = b.x(this);
                if (i6 == -1) {
                    x4.a();
                } else if (i6 == 0) {
                    x4.H(new a(13, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i5 == 2) {
            this.f3270e = 0;
            setResult(i6, intent);
        }
        finish();
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f3270e = 0;
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f3270e = bundle.getInt("resolution");
        }
        if (this.f3270e != 1) {
            b();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f3270e);
        super.onSaveInstanceState(bundle);
    }
}
