package androidx.window.layout;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import m3.q;

public final class SidecarCompat implements ExtensionInterfaceCompat {
    public static final Companion Companion = new Companion((g) null);
    private static final String TAG = "SidecarCompat";
    private final Map<Activity, ComponentCallbacks> componentCallbackMap;
    /* access modifiers changed from: private */
    public ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback;
    private final SidecarInterface sidecar;
    /* access modifiers changed from: private */
    public final SidecarAdapter sidecarAdapter;
    /* access modifiers changed from: private */
    public final Map<IBinder, Activity> windowListenerRegisteredContexts;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final IBinder getActivityWindowToken$window_release(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final Version getSidecarVersion() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (!TextUtils.isEmpty(apiVersion)) {
                    return Version.Companion.parse(apiVersion);
                }
                return null;
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    private static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        private final WeakHashMap<Activity, WindowLayoutInfo> activityWindowLayoutInfo = new WeakHashMap<>();
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface;
        private final ReentrantLock lock = new ReentrantLock();

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
            k.e(extensionCallbackInterface, "callbackInterface");
            this.callbackInterface = extensionCallbackInterface;
        }

        public void onWindowLayoutChanged(Activity activity, WindowLayoutInfo windowLayoutInfo) {
            k.e(activity, "activity");
            k.e(windowLayoutInfo, "newLayout");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!k.a(windowLayoutInfo, this.activityWindowLayoutInfo.get(activity))) {
                    WindowLayoutInfo put = this.activityWindowLayoutInfo.put(activity, windowLayoutInfo);
                    reentrantLock.unlock();
                    this.callbackInterface.onWindowLayoutChanged(activity, windowLayoutInfo);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {
        private final SidecarInterface.SidecarCallback callbackInterface;
        private SidecarDeviceState lastDeviceState;
        private final ReentrantLock lock = new ReentrantLock();
        private final WeakHashMap<IBinder, SidecarWindowLayoutInfo> mActivityWindowLayoutInfo = new WeakHashMap<>();
        private final SidecarAdapter sidecarAdapter;

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter2, SidecarInterface.SidecarCallback sidecarCallback) {
            k.e(sidecarAdapter2, "sidecarAdapter");
            k.e(sidecarCallback, "callbackInterface");
            this.sidecarAdapter = sidecarAdapter2;
            this.callbackInterface = sidecarCallback;
        }

        public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
            k.e(sidecarDeviceState, "newDeviceState");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.sidecarAdapter.isEqualSidecarDeviceState(this.lastDeviceState, sidecarDeviceState)) {
                    this.lastDeviceState = sidecarDeviceState;
                    this.callbackInterface.onDeviceStateChanged(sidecarDeviceState);
                    q qVar = q.f5904a;
                    reentrantLock.unlock();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            k.e(iBinder, "token");
            k.e(sidecarWindowLayoutInfo, "newLayout");
            synchronized (this.lock) {
                if (!this.sidecarAdapter.isEqualSidecarWindowLayoutInfo(this.mActivityWindowLayoutInfo.get(iBinder), sidecarWindowLayoutInfo)) {
                    SidecarWindowLayoutInfo put = this.mActivityWindowLayoutInfo.put(iBinder, sidecarWindowLayoutInfo);
                    this.callbackInterface.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
                }
            }
        }
    }

    private static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {
        private final WeakReference<Activity> activityWeakReference;
        private final SidecarCompat sidecarCompat;

        public FirstAttachAdapter(SidecarCompat sidecarCompat2, Activity activity) {
            k.e(sidecarCompat2, "sidecarCompat");
            k.e(activity, "activity");
            this.sidecarCompat = sidecarCompat2;
            this.activityWeakReference = new WeakReference<>(activity);
        }

        public void onViewAttachedToWindow(View view) {
            k.e(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.activityWeakReference.get();
            IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
            if (activity != null && activityWindowToken$window_release != null) {
                this.sidecarCompat.register(activityWindowToken$window_release, activity);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            k.e(view, "view");
        }
    }

    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        final /* synthetic */ SidecarCompat this$0;

        public TranslatingCallback(SidecarCompat sidecarCompat) {
            k.e(sidecarCompat, "this$0");
            this.this$0 = sidecarCompat;
        }

        public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
            SidecarInterface sidecar;
            k.e(sidecarDeviceState, "newDeviceState");
            Collection<Activity> values = this.this$0.windowListenerRegisteredContexts.values();
            SidecarCompat sidecarCompat = this.this$0;
            for (Activity activity : values) {
                IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (!(activityWindowToken$window_release == null || (sidecar = sidecarCompat.getSidecar()) == null)) {
                    sidecarWindowLayoutInfo = sidecar.getWindowLayoutInfo(activityWindowToken$window_release);
                }
                ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p = sidecarCompat.extensionCallback;
                if (access$getExtensionCallback$p != null) {
                    access$getExtensionCallback$p.onWindowLayoutChanged(activity, sidecarCompat.sidecarAdapter.translate(sidecarWindowLayoutInfo, sidecarDeviceState));
                }
            }
        }

        public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            k.e(iBinder, "windowToken");
            k.e(sidecarWindowLayoutInfo, "newLayout");
            Activity activity = (Activity) this.this$0.windowListenerRegisteredContexts.get(iBinder);
            if (activity == null) {
                Log.w(SidecarCompat.TAG, "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter access$getSidecarAdapter$p = this.this$0.sidecarAdapter;
            SidecarInterface sidecar = this.this$0.getSidecar();
            SidecarDeviceState deviceState = sidecar == null ? null : sidecar.getDeviceState();
            if (deviceState == null) {
                deviceState = new SidecarDeviceState();
            }
            WindowLayoutInfo translate = access$getSidecarAdapter$p.translate(sidecarWindowLayoutInfo, deviceState);
            ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p = this.this$0.extensionCallback;
            if (access$getExtensionCallback$p != null) {
                access$getExtensionCallback$p.onWindowLayoutChanged(activity, translate);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(SidecarProvider.getSidecarImpl(context.getApplicationContext()), new SidecarAdapter());
        k.e(context, "context");
    }

    public SidecarCompat(SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter2) {
        k.e(sidecarAdapter2, "sidecarAdapter");
        this.sidecar = sidecarInterface;
        this.sidecarAdapter = sidecarAdapter2;
        this.windowListenerRegisteredContexts = new LinkedHashMap();
        this.componentCallbackMap = new LinkedHashMap();
    }

    private final void registerConfigurationChangeListener(Activity activity) {
        if (this.componentCallbackMap.get(activity) == null) {
            SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1 sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1 = new SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1(this, activity);
            this.componentCallbackMap.put(activity, sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1);
            activity.registerComponentCallbacks(sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1);
        }
    }

    private final void unregisterComponentCallback(Activity activity) {
        activity.unregisterComponentCallbacks(this.componentCallbackMap.get(activity));
        this.componentCallbackMap.remove(activity);
    }

    public final SidecarInterface getSidecar() {
        return this.sidecar;
    }

    public final WindowLayoutInfo getWindowLayoutInfo(Activity activity) {
        k.e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            return new WindowLayoutInfo(n.d());
        }
        SidecarInterface sidecarInterface = this.sidecar;
        SidecarDeviceState sidecarDeviceState = null;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(activityWindowToken$window_release);
        SidecarAdapter sidecarAdapter2 = this.sidecarAdapter;
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarDeviceState = sidecarInterface2.getDeviceState();
        }
        if (sidecarDeviceState == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return sidecarAdapter2.translate(windowLayoutInfo, sidecarDeviceState);
    }

    public void onWindowLayoutChangeListenerAdded(Activity activity) {
        k.e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release != null) {
            register(activityWindowToken$window_release, activity);
            return;
        }
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
    }

    public void onWindowLayoutChangeListenerRemoved(Activity activity) {
        SidecarInterface sidecarInterface;
        k.e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release != null) {
            SidecarInterface sidecarInterface2 = this.sidecar;
            if (sidecarInterface2 != null) {
                sidecarInterface2.onWindowLayoutChangeListenerRemoved(activityWindowToken$window_release);
            }
            unregisterComponentCallback(activity);
            boolean z4 = this.windowListenerRegisteredContexts.size() == 1;
            this.windowListenerRegisteredContexts.remove(activityWindowToken$window_release);
            if (z4 && (sidecarInterface = this.sidecar) != null) {
                sidecarInterface.onDeviceStateListenersChanged(true);
            }
        }
    }

    public final void register(IBinder iBinder, Activity activity) {
        SidecarInterface sidecarInterface;
        k.e(iBinder, "windowToken");
        k.e(activity, "activity");
        this.windowListenerRegisteredContexts.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (this.windowListenerRegisteredContexts.size() == 1 && (sidecarInterface = this.sidecar) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.extensionCallback;
        if (extensionCallbackInterface != null) {
            extensionCallbackInterface.onWindowLayoutChanged(activity, getWindowLayoutInfo(activity));
        }
        registerConfigurationChangeListener(activity);
    }

    public void setExtensionCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
        k.e(extensionCallbackInterface, "extensionCallback");
        this.extensionCallback = new DistinctElementCallback(extensionCallbackInterface);
        SidecarInterface sidecarInterface = this.sidecar;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.sidecarAdapter, new TranslatingCallback(this)));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:58|59|60|61|69|70|71|72|73|(2:75|(2:77|97)(2:78|79))(2:80|81)) */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        return true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x0112 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0080 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008e A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a9 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00aa A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b6 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0141 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0152 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x016a A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0176 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0182 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x018e A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x019a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean validateExtensionInterface() {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            androidx.window.sidecar.SidecarInterface r2 = r8.sidecar     // Catch:{ all -> 0x019a }
            r3 = 0
            if (r2 != 0) goto L_0x0009
        L_0x0007:
            r2 = r3
            goto L_0x001c
        L_0x0009:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0010
            goto L_0x0007
        L_0x0010:
            java.lang.String r4 = "setSidecarCallback"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x019a }
            java.lang.Class<androidx.window.sidecar.SidecarInterface$SidecarCallback> r6 = androidx.window.sidecar.SidecarInterface.SidecarCallback.class
            r5[r1] = r6     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x019a }
        L_0x001c:
            if (r2 != 0) goto L_0x0020
            r2 = r3
            goto L_0x0024
        L_0x0020:
            java.lang.Class r2 = r2.getReturnType()     // Catch:{ all -> 0x019a }
        L_0x0024:
            java.lang.Class r4 = java.lang.Void.TYPE     // Catch:{ all -> 0x019a }
            boolean r4 = kotlin.jvm.internal.k.a(r2, r4)     // Catch:{ all -> 0x019a }
            if (r4 == 0) goto L_0x018e
            androidx.window.sidecar.SidecarInterface r2 = r8.sidecar     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0031
            goto L_0x0034
        L_0x0031:
            r2.getDeviceState()     // Catch:{ all -> 0x019a }
        L_0x0034:
            androidx.window.sidecar.SidecarInterface r2 = r8.sidecar     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0039
            goto L_0x003c
        L_0x0039:
            r2.onDeviceStateListenersChanged(r0)     // Catch:{ all -> 0x019a }
        L_0x003c:
            androidx.window.sidecar.SidecarInterface r2 = r8.sidecar     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0042
        L_0x0040:
            r2 = r3
            goto L_0x0055
        L_0x0042:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0049
            goto L_0x0040
        L_0x0049:
            java.lang.String r4 = "getWindowLayoutInfo"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x019a }
            java.lang.Class<android.os.IBinder> r6 = android.os.IBinder.class
            r5[r1] = r6     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x019a }
        L_0x0055:
            if (r2 != 0) goto L_0x0059
            r2 = r3
            goto L_0x005d
        L_0x0059:
            java.lang.Class r2 = r2.getReturnType()     // Catch:{ all -> 0x019a }
        L_0x005d:
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r4 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            boolean r4 = kotlin.jvm.internal.k.a(r2, r4)     // Catch:{ all -> 0x019a }
            if (r4 == 0) goto L_0x0182
            androidx.window.sidecar.SidecarInterface r2 = r8.sidecar     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x006b
        L_0x0069:
            r2 = r3
            goto L_0x007e
        L_0x006b:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0072
            goto L_0x0069
        L_0x0072:
            java.lang.String r4 = "onWindowLayoutChangeListenerAdded"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x019a }
            java.lang.Class<android.os.IBinder> r6 = android.os.IBinder.class
            r5[r1] = r6     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x019a }
        L_0x007e:
            if (r2 != 0) goto L_0x0082
            r2 = r3
            goto L_0x0086
        L_0x0082:
            java.lang.Class r2 = r2.getReturnType()     // Catch:{ all -> 0x019a }
        L_0x0086:
            java.lang.Class r4 = java.lang.Void.TYPE     // Catch:{ all -> 0x019a }
            boolean r4 = kotlin.jvm.internal.k.a(r2, r4)     // Catch:{ all -> 0x019a }
            if (r4 == 0) goto L_0x0176
            androidx.window.sidecar.SidecarInterface r2 = r8.sidecar     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x0094
        L_0x0092:
            r2 = r3
            goto L_0x00a7
        L_0x0094:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x019a }
            if (r2 != 0) goto L_0x009b
            goto L_0x0092
        L_0x009b:
            java.lang.String r4 = "onWindowLayoutChangeListenerRemoved"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x019a }
            java.lang.Class<android.os.IBinder> r6 = android.os.IBinder.class
            r5[r1] = r6     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x019a }
        L_0x00a7:
            if (r2 != 0) goto L_0x00aa
            goto L_0x00ae
        L_0x00aa:
            java.lang.Class r3 = r2.getReturnType()     // Catch:{ all -> 0x019a }
        L_0x00ae:
            java.lang.Class r2 = java.lang.Void.TYPE     // Catch:{ all -> 0x019a }
            boolean r2 = kotlin.jvm.internal.k.a(r3, r2)     // Catch:{ all -> 0x019a }
            if (r2 == 0) goto L_0x016a
            androidx.window.sidecar.SidecarDeviceState r2 = new androidx.window.sidecar.SidecarDeviceState     // Catch:{ all -> 0x019a }
            r2.<init>()     // Catch:{ all -> 0x019a }
            r3 = 3
            r2.posture = r3     // Catch:{ NoSuchFieldError -> 0x00bf }
            goto L_0x00f2
        L_0x00bf:
            java.lang.Class<androidx.window.sidecar.SidecarDeviceState> r4 = androidx.window.sidecar.SidecarDeviceState.class
            java.lang.String r5 = "setPosture"
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x019a }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x019a }
            r6[r1] = r7     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ all -> 0x019a }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x019a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x019a }
            r5[r1] = r6     // Catch:{ all -> 0x019a }
            r4.invoke(r2, r5)     // Catch:{ all -> 0x019a }
            java.lang.Class<androidx.window.sidecar.SidecarDeviceState> r4 = androidx.window.sidecar.SidecarDeviceState.class
            java.lang.String r5 = "getPosture"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ all -> 0x019a }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x019a }
            java.lang.Object r2 = r4.invoke(r2, r5)     // Catch:{ all -> 0x019a }
            if (r2 == 0) goto L_0x0162
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x019a }
            int r2 = r2.intValue()     // Catch:{ all -> 0x019a }
            if (r2 != r3) goto L_0x015a
        L_0x00f2:
            androidx.window.sidecar.SidecarDisplayFeature r2 = new androidx.window.sidecar.SidecarDisplayFeature     // Catch:{ all -> 0x019a }
            r2.<init>()     // Catch:{ all -> 0x019a }
            android.graphics.Rect r3 = r2.getRect()     // Catch:{ all -> 0x019a }
            java.lang.String r4 = "displayFeature.rect"
            kotlin.jvm.internal.k.d(r3, r4)     // Catch:{ all -> 0x019a }
            r2.setRect(r3)     // Catch:{ all -> 0x019a }
            r2.getType()     // Catch:{ all -> 0x019a }
            r2.setType(r0)     // Catch:{ all -> 0x019a }
            androidx.window.sidecar.SidecarWindowLayoutInfo r3 = new androidx.window.sidecar.SidecarWindowLayoutInfo     // Catch:{ all -> 0x019a }
            r3.<init>()     // Catch:{ all -> 0x019a }
            java.util.List r1 = r3.displayFeatures     // Catch:{ NoSuchFieldError -> 0x0112 }
            goto L_0x019b
        L_0x0112:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x019a }
            r4.<init>()     // Catch:{ all -> 0x019a }
            r4.add(r2)     // Catch:{ all -> 0x019a }
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r2 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r5 = "setDisplayFeatures"
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x019a }
            java.lang.Class<java.util.List> r7 = java.util.List.class
            r6[r1] = r7     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r2 = r2.getMethod(r5, r6)     // Catch:{ all -> 0x019a }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x019a }
            r5[r1] = r4     // Catch:{ all -> 0x019a }
            r2.invoke(r3, r5)     // Catch:{ all -> 0x019a }
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r2 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r5 = "getDisplayFeatures"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ all -> 0x019a }
            java.lang.reflect.Method r2 = r2.getMethod(r5, r6)     // Catch:{ all -> 0x019a }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x019a }
            java.lang.Object r2 = r2.invoke(r3, r5)     // Catch:{ all -> 0x019a }
            if (r2 == 0) goto L_0x0152
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x019a }
            boolean r2 = kotlin.jvm.internal.k.a(r4, r2)     // Catch:{ all -> 0x019a }
            if (r2 == 0) goto L_0x014a
            goto L_0x019b
        L_0x014a:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x019a }
            java.lang.String r2 = "Invalid display feature getter/setter"
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x0152:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x019a }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>"
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x015a:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x019a }
            java.lang.String r2 = "Invalid device posture getter/setter"
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x0162:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x019a }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x016a:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x019a }
            java.lang.String r2 = "Illegal return type for 'onWindowLayoutChangeListenerRemoved': "
            java.lang.String r2 = kotlin.jvm.internal.k.j(r2, r3)     // Catch:{ all -> 0x019a }
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x0176:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x019a }
            java.lang.String r3 = "Illegal return type for 'onWindowLayoutChangeListenerAdded': "
            java.lang.String r2 = kotlin.jvm.internal.k.j(r3, r2)     // Catch:{ all -> 0x019a }
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x0182:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x019a }
            java.lang.String r3 = "Illegal return type for 'getWindowLayoutInfo': "
            java.lang.String r2 = kotlin.jvm.internal.k.j(r3, r2)     // Catch:{ all -> 0x019a }
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x018e:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x019a }
            java.lang.String r3 = "Illegal return type for 'setSidecarCallback': "
            java.lang.String r2 = kotlin.jvm.internal.k.j(r3, r2)     // Catch:{ all -> 0x019a }
            r0.<init>(r2)     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x019a:
            r0 = r1
        L_0x019b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.validateExtensionInterface():boolean");
    }
}
