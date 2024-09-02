package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.l;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.d;
import androidx.core.app.b;
import androidx.core.app.w0;
import androidx.lifecycle.e0;
import androidx.lifecycle.f;
import androidx.lifecycle.f0;
import androidx.lifecycle.k;
import androidx.savedstate.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class e extends ComponentActivity implements b.g {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final k mFragmentLifecycleRegistry = new k(this);
    final i mFragments = i.b(new c());
    boolean mResumed;
    boolean mStopped = true;

    class a implements a.c {
        a() {
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            e.this.markFragmentsCreated();
            e.this.mFragmentLifecycleRegistry.h(f.a.ON_STOP);
            Parcelable x4 = e.this.mFragments.x();
            if (x4 != null) {
                bundle.putParcelable(e.FRAGMENTS_TAG, x4);
            }
            return bundle;
        }
    }

    class b implements b.b {
        b() {
        }

        public void a(Context context) {
            e.this.mFragments.a((Fragment) null);
            Bundle b5 = e.this.getSavedStateRegistry().b(e.FRAGMENTS_TAG);
            if (b5 != null) {
                e.this.mFragments.w(b5.getParcelable(e.FRAGMENTS_TAG));
            }
        }
    }

    class c extends k<e> implements f0, l, d, r {
        public c() {
            super(e.this);
        }

        public void a(n nVar, Fragment fragment) {
            e.this.onAttachFragment(fragment);
        }

        public View c(int i5) {
            return e.this.findViewById(i5);
        }

        public boolean d() {
            Window window = e.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public ActivityResultRegistry getActivityResultRegistry() {
            return e.this.getActivityResultRegistry();
        }

        public f getLifecycle() {
            return e.this.mFragmentLifecycleRegistry;
        }

        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return e.this.getOnBackPressedDispatcher();
        }

        public e0 getViewModelStore() {
            return e.this.getViewModelStore();
        }

        public LayoutInflater i() {
            return e.this.getLayoutInflater().cloneInContext(e.this);
        }

        public boolean k(Fragment fragment) {
            return !e.this.isFinishing();
        }

        public boolean l(String str) {
            return androidx.core.app.b.r(e.this, str);
        }

        public void o() {
            e.this.supportInvalidateOptionsMenu();
        }

        /* renamed from: p */
        public e h() {
            return e.this;
        }
    }

    public e() {
        init();
    }

    public e(int i5) {
        super(i5);
        init();
    }

    private void init() {
        getSavedStateRegistry().h(FRAGMENTS_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private static boolean markState(n nVar, f.b bVar) {
        boolean z4 = false;
        for (Fragment next : nVar.s0()) {
            if (next != null) {
                if (next.getHost() != null) {
                    z4 |= markState(next.getChildFragmentManager(), bVar);
                }
                a0 a0Var = next.mViewLifecycleOwner;
                if (a0Var != null && a0Var.getLifecycle().b().f(f.b.STARTED)) {
                    next.mViewLifecycleOwner.f(bVar);
                    z4 = true;
                }
                if (next.mLifecycleRegistry.b().f(f.b.STARTED)) {
                    next.mLifecycleRegistry.n(bVar);
                    z4 = true;
                }
            }
        }
        return z4;
    }

    /* access modifiers changed from: package-private */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.v(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.t().X(str, fileDescriptor, printWriter, strArr);
    }

    public n getSupportFragmentManager() {
        return this.mFragments.t();
    }

    @Deprecated
    public androidx.loader.app.a getSupportLoaderManager() {
        return androidx.loader.app.a.b(this);
    }

    /* access modifiers changed from: package-private */
    public void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), f.b.CREATED));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i5, int i6, Intent intent) {
        this.mFragments.u();
        super.onActivityResult(i5, i6, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.u();
        this.mFragments.d(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(f.a.ON_CREATE);
        this.mFragments.f();
    }

    public boolean onCreatePanelMenu(int i5, Menu menu) {
        return i5 == 0 ? super.onCreatePanelMenu(i5, menu) | this.mFragments.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i5, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView((View) null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.h(f.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.i();
    }

    public boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        if (i5 == 0) {
            return this.mFragments.k(menuItem);
        }
        if (i5 != 6) {
            return false;
        }
        return this.mFragments.e(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z4) {
        this.mFragments.j(z4);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.u();
    }

    public void onPanelClosed(int i5, Menu menu) {
        if (i5 == 0) {
            this.mFragments.l(menu);
        }
        super.onPanelClosed(i5, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.m();
        this.mFragmentLifecycleRegistry.h(f.a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z4) {
        this.mFragments.n(z4);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i5, View view, Menu menu) {
        return i5 == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.o(menu) : super.onPreparePanel(i5, view, menu);
    }

    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        this.mFragments.u();
        super.onRequestPermissionsResult(i5, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.u();
        this.mFragments.s();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(f.a.ON_RESUME);
        this.mFragments.p();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.u();
        this.mFragments.s();
        this.mFragmentLifecycleRegistry.h(f.a.ON_START);
        this.mFragments.q();
    }

    public void onStateNotSaved() {
        this.mFragments.u();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.r();
        this.mFragmentLifecycleRegistry.h(f.a.ON_STOP);
    }

    public void setEnterSharedElementCallback(w0 w0Var) {
        androidx.core.app.b.p(this, w0Var);
    }

    public void setExitSharedElementCallback(w0 w0Var) {
        androidx.core.app.b.q(this, w0Var);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i5) {
        startActivityFromFragment(fragment, intent, i5, (Bundle) null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i5, Bundle bundle) {
        if (i5 == -1) {
            androidx.core.app.b.s(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i5, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        if (i5 == -1) {
            androidx.core.app.b.t(this, intentSender, i5, intent, i6, i7, i8, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.b.k(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.b.m(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.b.u(this);
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i5) {
    }
}
