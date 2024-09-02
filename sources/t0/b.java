package t0;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import w0.p;

public class b extends DialogFragment {

    /* renamed from: e  reason: collision with root package name */
    private Dialog f6812e;

    /* renamed from: f  reason: collision with root package name */
    private DialogInterface.OnCancelListener f6813f;

    /* renamed from: g  reason: collision with root package name */
    private Dialog f6814g;

    public static b a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        b bVar = new b();
        Dialog dialog2 = (Dialog) p.h(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        bVar.f6812e = dialog2;
        if (onCancelListener != null) {
            bVar.f6813f = onCancelListener;
        }
        return bVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f6813f;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f6812e;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f6814g == null) {
            this.f6814g = new AlertDialog.Builder((Context) p.g(getActivity())).create();
        }
        return this.f6814g;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
