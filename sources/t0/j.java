package t0;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.d;
import androidx.fragment.app.n;
import w0.p;

public class j extends d {

    /* renamed from: u  reason: collision with root package name */
    private Dialog f6830u;

    /* renamed from: v  reason: collision with root package name */
    private DialogInterface.OnCancelListener f6831v;

    /* renamed from: w  reason: collision with root package name */
    private Dialog f6832w;

    public static j p(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        j jVar = new j();
        Dialog dialog2 = (Dialog) p.h(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        jVar.f6830u = dialog2;
        if (onCancelListener != null) {
            jVar.f6831v = onCancelListener;
        }
        return jVar;
    }

    public Dialog i(Bundle bundle) {
        Dialog dialog = this.f6830u;
        if (dialog != null) {
            return dialog;
        }
        m(false);
        if (this.f6832w == null) {
            this.f6832w = new AlertDialog.Builder((Context) p.g(getContext())).create();
        }
        return this.f6832w;
    }

    public void o(n nVar, String str) {
        super.o(nVar, str);
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f6831v;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
