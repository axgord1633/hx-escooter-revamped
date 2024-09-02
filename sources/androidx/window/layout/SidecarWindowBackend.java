package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.a;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import m3.q;

public final class SidecarWindowBackend implements WindowBackend {
    public static final Companion Companion = new Companion((g) null);
    public static final boolean DEBUG = false;
    private static final String TAG = "WindowServer";
    /* access modifiers changed from: private */
    public static volatile SidecarWindowBackend globalInstance;
    /* access modifiers changed from: private */
    public static final ReentrantLock globalLock = new ReentrantLock();
    private ExtensionInterfaceCompat windowExtension;
    private final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> windowLayoutChangeCallbacks = new CopyOnWriteArrayList<>();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final SidecarWindowBackend getInstance(Context context) {
            k.e(context, "context");
            if (SidecarWindowBackend.globalInstance == null) {
                ReentrantLock access$getGlobalLock$cp = SidecarWindowBackend.globalLock;
                access$getGlobalLock$cp.lock();
                try {
                    if (SidecarWindowBackend.globalInstance == null) {
                        SidecarWindowBackend.globalInstance = new SidecarWindowBackend(SidecarWindowBackend.Companion.initAndVerifyExtension(context));
                    }
                    q qVar = q.f5904a;
                } finally {
                    access$getGlobalLock$cp.unlock();
                }
            }
            SidecarWindowBackend access$getGlobalInstance$cp = SidecarWindowBackend.globalInstance;
            k.b(access$getGlobalInstance$cp);
            return access$getGlobalInstance$cp;
        }

        public final ExtensionInterfaceCompat initAndVerifyExtension(Context context) {
            k.e(context, "context");
            try {
                if (!isSidecarVersionSupported(SidecarCompat.Companion.getSidecarVersion())) {
                    return null;
                }
                SidecarCompat sidecarCompat = new SidecarCompat(context);
                if (!sidecarCompat.validateExtensionInterface()) {
                    return null;
                }
                return sidecarCompat;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final boolean isSidecarVersionSupported(Version version) {
            return version != null && version.compareTo(Version.Companion.getVERSION_0_1()) >= 0;
        }

        public final void resetInstance() {
            SidecarWindowBackend.globalInstance = null;
        }
    }

    public final class ExtensionListenerImpl implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        final /* synthetic */ SidecarWindowBackend this$0;

        public ExtensionListenerImpl(SidecarWindowBackend sidecarWindowBackend) {
            k.e(sidecarWindowBackend, "this$0");
            this.this$0 = sidecarWindowBackend;
        }

        public void onWindowLayoutChanged(Activity activity, WindowLayoutInfo windowLayoutInfo) {
            k.e(activity, "activity");
            k.e(windowLayoutInfo, "newLayout");
            Iterator<WindowLayoutChangeCallbackWrapper> it = this.this$0.getWindowLayoutChangeCallbacks().iterator();
            while (it.hasNext()) {
                WindowLayoutChangeCallbackWrapper next = it.next();
                if (k.a(next.getActivity(), activity)) {
                    next.accept(windowLayoutInfo);
                }
            }
        }
    }

    public static final class WindowLayoutChangeCallbackWrapper {
        private final Activity activity;
        private final a<WindowLayoutInfo> callback;
        private final Executor executor;
        private WindowLayoutInfo lastInfo;

        public WindowLayoutChangeCallbackWrapper(Activity activity2, Executor executor2, a<WindowLayoutInfo> aVar) {
            k.e(activity2, "activity");
            k.e(executor2, "executor");
            k.e(aVar, "callback");
            this.activity = activity2;
            this.executor = executor2;
            this.callback = aVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: accept$lambda-0  reason: not valid java name */
        public static final void m6accept$lambda0(WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
            k.e(windowLayoutChangeCallbackWrapper, "this$0");
            k.e(windowLayoutInfo, "$newLayoutInfo");
            windowLayoutChangeCallbackWrapper.getCallback().accept(windowLayoutInfo);
        }

        public final void accept(WindowLayoutInfo windowLayoutInfo) {
            k.e(windowLayoutInfo, "newLayoutInfo");
            this.lastInfo = windowLayoutInfo;
            this.executor.execute(new d(this, windowLayoutInfo));
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final a<WindowLayoutInfo> getCallback() {
            return this.callback;
        }

        public final WindowLayoutInfo getLastInfo() {
            return this.lastInfo;
        }

        public final void setLastInfo(WindowLayoutInfo windowLayoutInfo) {
            this.lastInfo = windowLayoutInfo;
        }
    }

    public SidecarWindowBackend(ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.windowExtension = extensionInterfaceCompat;
        ExtensionInterfaceCompat extensionInterfaceCompat2 = this.windowExtension;
        if (extensionInterfaceCompat2 != null) {
            extensionInterfaceCompat2.setExtensionCallback(new ExtensionListenerImpl(this));
        }
    }

    private final void callbackRemovedForActivity(Activity activity) {
        ExtensionInterfaceCompat extensionInterfaceCompat;
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.windowLayoutChangeCallbacks;
        boolean z4 = false;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (k.a(((WindowLayoutChangeCallbackWrapper) it.next()).getActivity(), activity)) {
                        z4 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (!z4 && (extensionInterfaceCompat = this.windowExtension) != null) {
            extensionInterfaceCompat.onWindowLayoutChangeListenerRemoved(activity);
        }
    }

    public static /* synthetic */ void getWindowLayoutChangeCallbacks$annotations() {
    }

    private final boolean isActivityRegistered(Activity activity) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.windowLayoutChangeCallbacks;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (WindowLayoutChangeCallbackWrapper activity2 : copyOnWriteArrayList) {
            if (k.a(activity2.getActivity(), activity)) {
                return true;
            }
        }
        return false;
    }

    public final ExtensionInterfaceCompat getWindowExtension() {
        return this.windowExtension;
    }

    public final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> getWindowLayoutChangeCallbacks() {
        return this.windowLayoutChangeCallbacks;
    }

    public void registerLayoutChangeCallback(Activity activity, Executor executor, a<WindowLayoutInfo> aVar) {
        WindowLayoutInfo windowLayoutInfo;
        T t5;
        k.e(activity, "activity");
        k.e(executor, "executor");
        k.e(aVar, "callback");
        ReentrantLock reentrantLock = globalLock;
        reentrantLock.lock();
        try {
            ExtensionInterfaceCompat windowExtension2 = getWindowExtension();
            if (windowExtension2 == null) {
                aVar.accept(new WindowLayoutInfo(n.d()));
                return;
            }
            boolean isActivityRegistered = isActivityRegistered(activity);
            WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = new WindowLayoutChangeCallbackWrapper(activity, executor, aVar);
            getWindowLayoutChangeCallbacks().add(windowLayoutChangeCallbackWrapper);
            if (!isActivityRegistered) {
                windowExtension2.onWindowLayoutChangeListenerAdded(activity);
            } else {
                Iterator<T> it = getWindowLayoutChangeCallbacks().iterator();
                while (true) {
                    windowLayoutInfo = null;
                    if (!it.hasNext()) {
                        t5 = null;
                        break;
                    }
                    t5 = it.next();
                    if (k.a(activity, ((WindowLayoutChangeCallbackWrapper) t5).getActivity())) {
                        break;
                    }
                }
                WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper2 = (WindowLayoutChangeCallbackWrapper) t5;
                if (windowLayoutChangeCallbackWrapper2 != null) {
                    windowLayoutInfo = windowLayoutChangeCallbackWrapper2.getLastInfo();
                }
                if (windowLayoutInfo != null) {
                    windowLayoutChangeCallbackWrapper.accept(windowLayoutInfo);
                }
            }
            q qVar = q.f5904a;
            reentrantLock.unlock();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void setWindowExtension(ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.windowExtension = extensionInterfaceCompat;
    }

    public void unregisterLayoutChangeCallback(a<WindowLayoutInfo> aVar) {
        k.e(aVar, "callback");
        synchronized (globalLock) {
            if (getWindowExtension() != null) {
                ArrayList<WindowLayoutChangeCallbackWrapper> arrayList = new ArrayList<>();
                Iterator<WindowLayoutChangeCallbackWrapper> it = getWindowLayoutChangeCallbacks().iterator();
                while (it.hasNext()) {
                    WindowLayoutChangeCallbackWrapper next = it.next();
                    if (next.getCallback() == aVar) {
                        k.d(next, "callbackWrapper");
                        arrayList.add(next);
                    }
                }
                getWindowLayoutChangeCallbacks().removeAll(arrayList);
                for (WindowLayoutChangeCallbackWrapper activity : arrayList) {
                    callbackRemovedForActivity(activity.getActivity());
                }
                q qVar = q.f5904a;
            }
        }
    }
}
