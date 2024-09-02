package androidx.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.h;
import androidx.core.app.i;
import androidx.core.app.u0;
import androidx.core.view.z;
import androidx.lifecycle.b0;
import androidx.lifecycle.e0;
import androidx.lifecycle.f;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;
import androidx.lifecycle.j;
import androidx.lifecycle.k;
import androidx.lifecycle.r;
import androidx.lifecycle.v;
import androidx.lifecycle.y;
import c.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import m3.q;

public class ComponentActivity extends h implements f0, androidx.lifecycle.e, y.d, l, androidx.activity.result.d, i {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final b.a mContextAwareHelper;
    private b0.b mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final h mFullyDrawnReporter;
    private final k mLifecycleRegistry;
    private final androidx.core.view.k mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<androidx.core.util.a<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<i>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<u0>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<Integer>> mOnTrimMemoryListeners;
    final f mReportFullyDrawnExecutor;
    final y.c mSavedStateRegistryController;
    private e0 mViewModelStore;

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e5) {
                if (!TextUtils.equals(e5.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e5;
                }
            }
        }
    }

    class b extends ActivityResultRegistry {

        class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f465e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ a.C0056a f466f;

            a(int i5, a.C0056a aVar) {
                this.f465e = i5;
                this.f466f = aVar;
            }

            public void run() {
                b.this.c(this.f465e, this.f466f.a());
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b  reason: collision with other inner class name */
        class C0011b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f468e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f469f;

            C0011b(int i5, IntentSender.SendIntentException sendIntentException) {
                this.f468e = i5;
                this.f469f = sendIntentException;
            }

            public void run() {
                b.this.b(this.f468e, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f469f));
            }
        }

        b() {
        }

        public <I, O> void f(int i5, c.a<I, O> aVar, I i6, androidx.core.app.d dVar) {
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0056a<O> b5 = aVar.b(componentActivity, i6);
            if (b5 != null) {
                new Handler(Looper.getMainLooper()).post(new a(i5, b5));
                return;
            }
            Intent a5 = aVar.a(componentActivity, i6);
            Bundle bundle = null;
            if (a5.getExtras() != null && a5.getExtras().getClassLoader() == null) {
                a5.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a5.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = a5.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a5.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            }
            Bundle bundle2 = bundle;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a5.getAction())) {
                String[] stringArrayExtra = a5.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.b.o(componentActivity, stringArrayExtra, i5);
            } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a5.getAction())) {
                androidx.activity.result.e eVar = (androidx.activity.result.e) a5.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    androidx.core.app.b.t(componentActivity, eVar.d(), i5, eVar.a(), eVar.b(), eVar.c(), 0, bundle2);
                } catch (IntentSender.SendIntentException e5) {
                    new Handler(Looper.getMainLooper()).post(new C0011b(i5, e5));
                }
            } else {
                androidx.core.app.b.s(componentActivity, a5, i5, bundle2);
            }
        }
    }

    static class c {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    static class d {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        Object f471a;

        /* renamed from: b  reason: collision with root package name */
        e0 f472b;

        e() {
        }
    }

    private interface f extends Executor {
        void f();

        void p(View view);
    }

    class g implements f, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: e  reason: collision with root package name */
        final long f473e = (SystemClock.uptimeMillis() + 10000);

        /* renamed from: f  reason: collision with root package name */
        Runnable f474f;

        /* renamed from: g  reason: collision with root package name */
        boolean f475g = false;

        g() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            Runnable runnable = this.f474f;
            if (runnable != null) {
                runnable.run();
                this.f474f = null;
            }
        }

        public void execute(Runnable runnable) {
            this.f474f = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.f475g) {
                decorView.postOnAnimation(new f(this));
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        public void f() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        public void onDraw() {
            Runnable runnable = this.f474f;
            if (runnable != null) {
                runnable.run();
                this.f474f = null;
                if (!ComponentActivity.this.mFullyDrawnReporter.c()) {
                    return;
                }
            } else if (SystemClock.uptimeMillis() <= this.f473e) {
                return;
            }
            this.f475g = false;
            ComponentActivity.this.getWindow().getDecorView().post(this);
        }

        public void p(View view) {
            if (!this.f475g) {
                this.f475g = true;
                view.getViewTreeObserver().addOnDrawListener(this);
            }
        }

        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new b.a();
        this.mMenuHostHelper = new androidx.core.view.k(new b(this));
        this.mLifecycleRegistry = new k(this);
        y.c a5 = y.c.a(this);
        this.mSavedStateRegistryController = a5;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        f createFullyDrawnExecutor = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = createFullyDrawnExecutor;
        this.mFullyDrawnReporter = new h(createFullyDrawnExecutor, new c(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() != null) {
            int i5 = Build.VERSION.SDK_INT;
            getLifecycle().a(new androidx.lifecycle.h() {
                public void a(j jVar, f.a aVar) {
                    if (aVar == f.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            c.a(peekDecorView);
                        }
                    }
                }
            });
            getLifecycle().a(new androidx.lifecycle.h() {
                public void a(j jVar, f.a aVar) {
                    if (aVar == f.a.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.b();
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().a();
                        }
                        ComponentActivity.this.mReportFullyDrawnExecutor.f();
                    }
                }
            });
            getLifecycle().a(new androidx.lifecycle.h() {
                public void a(j jVar, f.a aVar) {
                    ComponentActivity.this.ensureViewModelStore();
                    ComponentActivity.this.getLifecycle().c(this);
                }
            });
            a5.c();
            v.c(this);
            if (i5 <= 23) {
                getLifecycle().a(new ImmLeaksCleaner(this));
            }
            getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new d(this));
            addOnContextAvailableListener(new e(this));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public ComponentActivity(int i5) {
        this();
        this.mContentLayoutId = i5;
    }

    private f createFullyDrawnExecutor() {
        return new g();
    }

    private void initViewTreeOwners() {
        g0.a(getWindow().getDecorView(), this);
        h0.a(getWindow().getDecorView(), this);
        y.e.a(getWindow().getDecorView(), this);
        o.a(getWindow().getDecorView(), this);
        n.a(getWindow().getDecorView(), this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ q lambda$new$0() {
        reportFullyDrawn();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$new$1() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(Context context) {
        Bundle b5 = getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (b5 != null) {
            this.mActivityResultRegistry.g(b5);
        }
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.p(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(z zVar) {
        this.mMenuHostHelper.c(zVar);
    }

    public void addMenuProvider(z zVar, j jVar) {
        this.mMenuHostHelper.d(zVar, jVar);
    }

    public void addMenuProvider(z zVar, j jVar, f.b bVar) {
        this.mMenuHostHelper.e(zVar, jVar, bVar);
    }

    public final void addOnConfigurationChangedListener(androidx.core.util.a<Configuration> aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(b.b bVar) {
        this.mContextAwareHelper.a(bVar);
    }

    public final void addOnMultiWindowModeChangedListener(androidx.core.util.a<i> aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(androidx.core.util.a<Intent> aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    public final void addOnPictureInPictureModeChangedListener(androidx.core.util.a<u0> aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    public final void addOnTrimMemoryListener(androidx.core.util.a<Integer> aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.mViewModelStore = eVar.f472b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new e0();
            }
        }
    }

    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public w.a getDefaultViewModelCreationExtras() {
        w.d dVar = new w.d();
        if (getApplication() != null) {
            dVar.c(b0.a.f2566g, getApplication());
        }
        dVar.c(v.f2608a, this);
        dVar.c(v.f2609b, this);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            dVar.c(v.f2610c, getIntent().getExtras());
        }
        return dVar;
    }

    public b0.b getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new y(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    public h getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        e eVar = (e) getLastNonConfigurationInstance();
        if (eVar != null) {
            return eVar.f471a;
        }
        return null;
    }

    public androidx.lifecycle.f getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    public e0 getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onActivityResult(int i5, int i6, Intent intent) {
        if (!this.mActivityResultRegistry.b(i5, i6, intent)) {
            super.onActivityResult(i5, i6, intent);
        }
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.e();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<androidx.core.util.a<Configuration>> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        r.e(this);
        if (androidx.core.os.a.c()) {
            this.mOnBackPressedDispatcher.f(d.a(this));
        }
        int i5 = this.mContentLayoutId;
        if (i5 != 0) {
            setContentView(i5);
        }
    }

    public boolean onCreatePanelMenu(int i5, Menu menu) {
        if (i5 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i5, menu);
        this.mMenuHostHelper.h(menu, getMenuInflater());
        return true;
    }

    public boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        if (i5 == 0) {
            return this.mMenuHostHelper.j(menuItem);
        }
        return false;
    }

    public void onMultiWindowModeChanged(boolean z4) {
        if (!this.mDispatchingOnMultiWindowModeChanged) {
            Iterator<androidx.core.util.a<i>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new i(z4));
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void onMultiWindowModeChanged(boolean z4, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z4, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<androidx.core.util.a<i>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new i(z4, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<androidx.core.util.a<Intent>> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    public void onPanelClosed(int i5, Menu menu) {
        this.mMenuHostHelper.i(menu);
        super.onPanelClosed(i5, menu);
    }

    public void onPictureInPictureModeChanged(boolean z4) {
        if (!this.mDispatchingOnPictureInPictureModeChanged) {
            Iterator<androidx.core.util.a<u0>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new u0(z4));
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void onPictureInPictureModeChanged(boolean z4, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z4, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<androidx.core.util.a<u0>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new u0(z4, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public boolean onPreparePanel(int i5, View view, Menu menu) {
        if (i5 != 0) {
            return true;
        }
        super.onPreparePanel(i5, view, menu);
        this.mMenuHostHelper.k(menu);
        return true;
    }

    @Deprecated
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        if (!this.mActivityResultRegistry.b(i5, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            super.onRequestPermissionsResult(i5, strArr, iArr);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        e0 e0Var = this.mViewModelStore;
        if (e0Var == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            e0Var = eVar.f472b;
        }
        if (e0Var == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f471a = onRetainCustomNonConfigurationInstance;
        eVar2.f472b = e0Var;
        return eVar2;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.f lifecycle = getLifecycle();
        if (lifecycle instanceof k) {
            ((k) lifecycle).n(f.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    public void onTrimMemory(int i5) {
        super.onTrimMemory(i5);
        Iterator<androidx.core.util.a<Integer>> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i5));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> androidx.activity.result.c<I> registerForActivityResult(c.a<I, O> aVar, ActivityResultRegistry activityResultRegistry, androidx.activity.result.b<O> bVar) {
        return activityResultRegistry.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, bVar);
    }

    public final <I, O> androidx.activity.result.c<I> registerForActivityResult(c.a<I, O> aVar, androidx.activity.result.b<O> bVar) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, bVar);
    }

    public void removeMenuProvider(z zVar) {
        this.mMenuHostHelper.l(zVar);
    }

    public final void removeOnConfigurationChangedListener(androidx.core.util.a<Configuration> aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(b.b bVar) {
        this.mContextAwareHelper.e(bVar);
    }

    public final void removeOnMultiWindowModeChangedListener(androidx.core.util.a<i> aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(androidx.core.util.a<Intent> aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    public final void removeOnPictureInPictureModeChangedListener(androidx.core.util.a<u0> aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    public final void removeOnTrimMemoryListener(androidx.core.util.a<Integer> aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    public void reportFullyDrawn() {
        try {
            if (a0.b.h()) {
                a0.b.c("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.mFullyDrawnReporter.b();
        } finally {
            a0.b.f();
        }
    }

    public void setContentView(int i5) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.p(getWindow().getDecorView());
        super.setContentView(i5);
    }

    public void setContentView(View view) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.p(getWindow().getDecorView());
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.p(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i5) {
        super.startActivityForResult(intent, i5);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i5, Bundle bundle) {
        super.startActivityForResult(intent, i5, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8) {
        super.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
    }
}
