package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;
import androidx.lifecycle.j;
import androidx.lifecycle.p;

public class d extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: e  reason: collision with root package name */
    private Handler f2269e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f2270f = new a();

    /* renamed from: g  reason: collision with root package name */
    private DialogInterface.OnCancelListener f2271g = new b();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public DialogInterface.OnDismissListener f2272h = new c();

    /* renamed from: i  reason: collision with root package name */
    private int f2273i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f2274j = 0;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2275k = true;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f2276l = true;

    /* renamed from: m  reason: collision with root package name */
    private int f2277m = -1;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2278n;

    /* renamed from: o  reason: collision with root package name */
    private p<j> f2279o = new C0037d();
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public Dialog f2280p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f2281q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f2282r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f2283s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f2284t = false;

    class a implements Runnable {
        a() {
        }

        public void run() {
            d.this.f2272h.onDismiss(d.this.f2280p);
        }
    }

    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (d.this.f2280p != null) {
                d dVar = d.this;
                dVar.onCancel(dVar.f2280p);
            }
        }
    }

    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (d.this.f2280p != null) {
                d dVar = d.this;
                dVar.onDismiss(dVar.f2280p);
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$d  reason: collision with other inner class name */
    class C0037d implements p<j> {
        C0037d() {
        }

        /* renamed from: b */
        public void a(j jVar) {
            if (jVar != null && d.this.f2276l) {
                View requireView = d.this.requireView();
                if (requireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                } else if (d.this.f2280p != null) {
                    if (n.F0(3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + d.this.f2280p);
                    }
                    d.this.f2280p.setContentView(requireView);
                }
            }
        }
    }

    class e extends g {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g f2289e;

        e(g gVar) {
            this.f2289e = gVar;
        }

        public View c(int i5) {
            return this.f2289e.d() ? this.f2289e.c(i5) : d.this.j(i5);
        }

        public boolean d() {
            return this.f2289e.d() || d.this.k();
        }
    }

    private void g(boolean z4, boolean z5) {
        if (!this.f2282r) {
            this.f2282r = true;
            this.f2283s = false;
            Dialog dialog = this.f2280p;
            if (dialog != null) {
                dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
                this.f2280p.dismiss();
                if (!z5) {
                    if (Looper.myLooper() == this.f2269e.getLooper()) {
                        onDismiss(this.f2280p);
                    } else {
                        this.f2269e.post(this.f2270f);
                    }
                }
            }
            this.f2281q = true;
            if (this.f2277m >= 0) {
                getParentFragmentManager().W0(this.f2277m, 1);
                this.f2277m = -1;
                return;
            }
            w m5 = getParentFragmentManager().m();
            m5.k(this);
            if (z4) {
                m5.g();
            } else {
                m5.f();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private void l(Bundle bundle) {
        if (this.f2276l && !this.f2284t) {
            try {
                this.f2278n = true;
                Dialog i5 = i(bundle);
                this.f2280p = i5;
                if (this.f2276l) {
                    n(i5, this.f2273i);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.f2280p.setOwnerActivity((Activity) context);
                    }
                    this.f2280p.setCancelable(this.f2275k);
                    this.f2280p.setOnCancelListener(this.f2271g);
                    this.f2280p.setOnDismissListener(this.f2272h);
                    this.f2284t = true;
                } else {
                    this.f2280p = null;
                }
                this.f2278n = false;
            } catch (Throwable th) {
                this.f2278n = false;
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public g createFragmentContainer() {
        return new e(super.createFragmentContainer());
    }

    public int h() {
        return this.f2274j;
    }

    public Dialog i(Bundle bundle) {
        if (n.F0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(requireContext(), h());
    }

    /* access modifiers changed from: package-private */
    public View j(int i5) {
        Dialog dialog = this.f2280p;
        if (dialog != null) {
            return dialog.findViewById(i5);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.f2284t;
    }

    public void m(boolean z4) {
        this.f2276l = z4;
    }

    public void n(Dialog dialog, int i5) {
        if (!(i5 == 1 || i5 == 2)) {
            if (i5 == 3) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                }
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void o(n nVar, String str) {
        this.f2282r = false;
        this.f2283s = true;
        w m5 = nVar.m();
        m5.d(this, str);
        m5.f();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().e(this.f2279o);
        if (!this.f2283s) {
            this.f2282r = false;
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2269e = new Handler();
        this.f2276l = this.mContainerId == 0;
        if (bundle != null) {
            this.f2273i = bundle.getInt("android:style", 0);
            this.f2274j = bundle.getInt("android:theme", 0);
            this.f2275k = bundle.getBoolean("android:cancelable", true);
            this.f2276l = bundle.getBoolean("android:showsDialog", this.f2276l);
            this.f2277m = bundle.getInt("android:backStackId", -1);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f2280p;
        if (dialog != null) {
            this.f2281q = true;
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
            this.f2280p.dismiss();
            if (!this.f2282r) {
                onDismiss(this.f2280p);
            }
            this.f2280p = null;
            this.f2284t = false;
        }
    }

    public void onDetach() {
        super.onDetach();
        if (!this.f2283s && !this.f2282r) {
            this.f2282r = true;
        }
        getViewLifecycleOwnerLiveData().h(this.f2279o);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f2281q) {
            if (n.F0(3)) {
                Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
            }
            g(true, true);
        }
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        String str;
        StringBuilder sb;
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (!this.f2276l || this.f2278n) {
            if (n.F0(2)) {
                String str2 = "getting layout inflater for DialogFragment " + this;
                if (!this.f2276l) {
                    sb = new StringBuilder();
                    str = "mShowsDialog = false: ";
                } else {
                    sb = new StringBuilder();
                    str = "mCreatingDialog = true: ";
                }
                sb.append(str);
                sb.append(str2);
                Log.d("FragmentManager", sb.toString());
            }
            return onGetLayoutInflater;
        }
        l(bundle);
        if (n.F0(2)) {
            Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        Dialog dialog = this.f2280p;
        return dialog != null ? onGetLayoutInflater.cloneInContext(dialog.getContext()) : onGetLayoutInflater;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.f2280p;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i5 = this.f2273i;
        if (i5 != 0) {
            bundle.putInt("android:style", i5);
        }
        int i6 = this.f2274j;
        if (i6 != 0) {
            bundle.putInt("android:theme", i6);
        }
        boolean z4 = this.f2275k;
        if (!z4) {
            bundle.putBoolean("android:cancelable", z4);
        }
        boolean z5 = this.f2276l;
        if (!z5) {
            bundle.putBoolean("android:showsDialog", z5);
        }
        int i7 = this.f2277m;
        if (i7 != -1) {
            bundle.putInt("android:backStackId", i7);
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.f2280p;
        if (dialog != null) {
            this.f2281q = false;
            dialog.show();
            View decorView = this.f2280p.getWindow().getDecorView();
            g0.a(decorView, this);
            h0.a(decorView, this);
            y.e.a(decorView, this);
        }
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.f2280p;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.f2280p != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f2280p.onRestoreInstanceState(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView == null && this.f2280p != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f2280p.onRestoreInstanceState(bundle2);
        }
    }
}
