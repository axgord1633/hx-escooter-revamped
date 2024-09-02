package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.w0;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.e0;
import androidx.lifecycle.f;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;
import androidx.lifecycle.o;
import androidx.lifecycle.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.j, f0, androidx.lifecycle.e, y.d {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    i mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    n mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    b0.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    n mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    k<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.k mLifecycleRegistry;
    f.b mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<k> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    y.c mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    a0 mViewLifecycleOwner;
    o<androidx.lifecycle.j> mViewLifecycleOwnerLiveData;
    String mWho;

    class a implements Runnable {
        a() {
        }

        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            Fragment.this.callStartTransitionListener(false);
        }
    }

    class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c0 f2133e;

        c(c0 c0Var) {
            this.f2133e = c0Var;
        }

        public void run() {
            this.f2133e.g();
        }
    }

    class d extends g {
        d() {
        }

        public View c(int i5) {
            View view = Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i5);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        public boolean d() {
            return Fragment.this.mView != null;
        }
    }

    class e implements l.a<Void, ActivityResultRegistry> {
        e() {
        }

        /* renamed from: a */
        public ActivityResultRegistry apply(Void voidR) {
            Fragment fragment = Fragment.this;
            k<?> kVar = fragment.mHost;
            return kVar instanceof androidx.activity.result.d ? ((androidx.activity.result.d) kVar).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
        }
    }

    class f implements l.a<Void, ActivityResultRegistry> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActivityResultRegistry f2137a;

        f(ActivityResultRegistry activityResultRegistry) {
            this.f2137a = activityResultRegistry;
        }

        /* renamed from: a */
        public ActivityResultRegistry apply(Void voidR) {
            return this.f2137a;
        }
    }

    class g extends k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l.a f2139a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicReference f2140b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c.a f2141c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ androidx.activity.result.b f2142d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(l.a aVar, AtomicReference atomicReference, c.a aVar2, androidx.activity.result.b bVar) {
            super((a) null);
            this.f2139a = aVar;
            this.f2140b = atomicReference;
            this.f2141c = aVar2;
            this.f2142d = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2140b.set(((ActivityResultRegistry) this.f2139a.apply(null)).i(Fragment.this.generateActivityResultKey(), Fragment.this, this.f2141c, this.f2142d));
        }
    }

    class h extends androidx.activity.result.c<I> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicReference f2144a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c.a f2145b;

        h(AtomicReference atomicReference, c.a aVar) {
            this.f2144a = atomicReference;
            this.f2145b = aVar;
        }

        public void b(I i5, androidx.core.app.d dVar) {
            androidx.activity.result.c cVar = (androidx.activity.result.c) this.f2144a.get();
            if (cVar != null) {
                cVar.b(i5, dVar);
                return;
            }
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }

        public void c() {
            androidx.activity.result.c cVar = (androidx.activity.result.c) this.f2144a.getAndSet((Object) null);
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    static class i {

        /* renamed from: a  reason: collision with root package name */
        View f2147a;

        /* renamed from: b  reason: collision with root package name */
        Animator f2148b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2149c;

        /* renamed from: d  reason: collision with root package name */
        int f2150d;

        /* renamed from: e  reason: collision with root package name */
        int f2151e;

        /* renamed from: f  reason: collision with root package name */
        int f2152f;

        /* renamed from: g  reason: collision with root package name */
        int f2153g;

        /* renamed from: h  reason: collision with root package name */
        int f2154h;

        /* renamed from: i  reason: collision with root package name */
        ArrayList<String> f2155i;

        /* renamed from: j  reason: collision with root package name */
        ArrayList<String> f2156j;

        /* renamed from: k  reason: collision with root package name */
        Object f2157k = null;

        /* renamed from: l  reason: collision with root package name */
        Object f2158l;

        /* renamed from: m  reason: collision with root package name */
        Object f2159m;

        /* renamed from: n  reason: collision with root package name */
        Object f2160n;

        /* renamed from: o  reason: collision with root package name */
        Object f2161o;

        /* renamed from: p  reason: collision with root package name */
        Object f2162p;

        /* renamed from: q  reason: collision with root package name */
        Boolean f2163q;

        /* renamed from: r  reason: collision with root package name */
        Boolean f2164r;

        /* renamed from: s  reason: collision with root package name */
        float f2165s;

        /* renamed from: t  reason: collision with root package name */
        View f2166t;

        /* renamed from: u  reason: collision with root package name */
        boolean f2167u;

        /* renamed from: v  reason: collision with root package name */
        l f2168v;

        /* renamed from: w  reason: collision with root package name */
        boolean f2169w;

        i() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.f2158l = obj;
            this.f2159m = null;
            this.f2160n = obj;
            this.f2161o = null;
            this.f2162p = obj;
            this.f2165s = 1.0f;
            this.f2166t = null;
        }
    }

    public static class j extends RuntimeException {
        public j(String str, Exception exc) {
            super(str, exc);
        }
    }

    private static abstract class k {
        private k() {
        }

        /* synthetic */ k(a aVar) {
            this();
        }

        /* access modifiers changed from: package-private */
        public abstract void a();
    }

    interface l {
        void a();

        void b();
    }

    public static class m implements Parcelable {
        public static final Parcelable.Creator<m> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        final Bundle f2170e;

        class a implements Parcelable.ClassLoaderCreator<m> {
            a() {
            }

            /* renamed from: a */
            public m createFromParcel(Parcel parcel) {
                return new m(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public m createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new m(parcel, classLoader);
            }

            /* renamed from: c */
            public m[] newArray(int i5) {
                return new m[i5];
            }
        }

        m(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f2170e = readBundle;
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeBundle(this.f2170e);
        }
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new o();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new a();
        this.mMaxState = f.b.RESUMED;
        this.mViewLifecycleOwnerLiveData = new o<>();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList<>();
        initLifecycle();
    }

    public Fragment(int i5) {
        this();
        this.mContentLayoutId = i5;
    }

    private i ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new i();
        }
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        f.b bVar = this.mMaxState;
        return (bVar == f.b.INITIALIZED || this.mParentFragment == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new androidx.lifecycle.k(this);
        this.mSavedStateRegistryController = y.c.a(this);
        this.mDefaultFactory = null;
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, (Bundle) null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) j.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (InstantiationException e5) {
            throw new j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e5);
        } catch (IllegalAccessException e6) {
            throw new j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e6);
        } catch (NoSuchMethodException e7) {
            throw new j("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e7);
        } catch (InvocationTargetException e8) {
            throw new j("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e8);
        }
    }

    private <I, O> androidx.activity.result.c<I> prepareCallInternal(c.a<I, O> aVar, l.a<Void, ActivityResultRegistry> aVar2, androidx.activity.result.b<O> bVar) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            registerOnPreAttachListener(new g(aVar2, atomicReference, aVar, bVar));
            return new h(atomicReference, aVar);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void registerOnPreAttachListener(k kVar) {
        if (this.mState >= 0) {
            kVar.a();
        } else {
            this.mOnPreAttachedListeners.add(kVar);
        }
    }

    private void restoreViewState() {
        if (n.F0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    /* access modifiers changed from: package-private */
    public void callStartTransitionListener(boolean z4) {
        ViewGroup viewGroup;
        n nVar;
        i iVar = this.mAnimationInfo;
        l lVar = null;
        if (iVar != null) {
            iVar.f2167u = false;
            l lVar2 = iVar.f2168v;
            iVar.f2168v = null;
            lVar = lVar2;
        }
        if (lVar != null) {
            lVar.a();
        } else if (n.P && this.mView != null && (viewGroup = this.mContainer) != null && (nVar = this.mFragmentManager) != null) {
            c0 n5 = c0.n(viewGroup, nVar);
            n5.p();
            if (z4) {
                this.mHost.g().post(new c(n5));
            } else {
                n5.g();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public g createFragmentContainer() {
        return new d();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        n nVar = this.mChildFragmentManager;
        nVar.X(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: package-private */
    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.j0(str);
    }

    /* access modifiers changed from: package-private */
    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final e getActivity() {
        k<?> kVar = this.mHost;
        if (kVar == null) {
            return null;
        }
        return (e) kVar.e();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.f2164r) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.f2163q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public View getAnimatingAway() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f2147a;
    }

    /* access modifiers changed from: package-private */
    public Animator getAnimator() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f2148b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final n getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        k<?> kVar = this.mHost;
        if (kVar == null) {
            return null;
        }
        return kVar.f();
    }

    public /* synthetic */ w.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.d.a(this);
    }

    public b0.b getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager != null) {
            if (this.mDefaultFactory == null) {
                Application application = null;
                Context context = requireContext().getApplicationContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else if (context instanceof Application) {
                        application = (Application) context;
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                if (application == null && n.F0(3)) {
                    Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                }
                this.mDefaultFactory = new y(application, this, getArguments());
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    /* access modifiers changed from: package-private */
    public int getEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f2150d;
    }

    public Object getEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f2157k;
    }

    /* access modifiers changed from: package-private */
    public w0 getEnterTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        iVar.getClass();
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f2151e;
    }

    public Object getExitTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f2159m;
    }

    /* access modifiers changed from: package-private */
    public w0 getExitTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        iVar.getClass();
        return null;
    }

    /* access modifiers changed from: package-private */
    public View getFocusedView() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f2166t;
    }

    @Deprecated
    public final n getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        k<?> kVar = this.mHost;
        if (kVar == null) {
            return null;
        }
        return kVar.h();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater((Bundle) null) : layoutInflater;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        k<?> kVar = this.mHost;
        if (kVar != null) {
            LayoutInflater i5 = kVar.i();
            androidx.core.view.g.a(i5, this.mChildFragmentManager.u0());
            return i5;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public androidx.lifecycle.f getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public androidx.loader.app.a getLoaderManager() {
        return androidx.loader.app.a.b(this);
    }

    /* access modifiers changed from: package-private */
    public int getNextTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f2154h;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final n getParentFragmentManager() {
        n nVar = this.mFragmentManager;
        if (nVar != null) {
            return nVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    /* access modifiers changed from: package-private */
    public boolean getPopDirection() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f2149c;
    }

    /* access modifiers changed from: package-private */
    public int getPopEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f2152f;
    }

    /* access modifiers changed from: package-private */
    public int getPopExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f2153g;
    }

    /* access modifiers changed from: package-private */
    public float getPostOnViewCreatedAlpha() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.f2165s;
    }

    public Object getReenterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f2160n;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f2158l;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    public Object getSharedElementEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f2161o;
    }

    public Object getSharedElementReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f2162p;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.f2155i;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.lang.String> getSharedElementSourceNames() {
        /*
            r1 = this;
            androidx.fragment.app.Fragment$i r0 = r1.mAnimationInfo
            if (r0 == 0) goto L_0x000a
            java.util.ArrayList<java.lang.String> r0 = r0.f2155i
            if (r0 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            return r0
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Fragment.getSharedElementSourceNames():java.util.ArrayList");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.f2156j;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.lang.String> getSharedElementTargetNames() {
        /*
            r1 = this;
            androidx.fragment.app.Fragment$i r0 = r1.mAnimationInfo
            if (r0 == 0) goto L_0x000a
            java.util.ArrayList<java.lang.String> r0 = r0.f2156j
            if (r0 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            return r0
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Fragment.getSharedElementTargetNames():java.util.ArrayList");
    }

    public final String getString(int i5) {
        return getResources().getString(i5);
    }

    public final String getString(int i5, Object... objArr) {
        return getResources().getString(i5, objArr);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        n nVar = this.mFragmentManager;
        if (nVar == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return nVar.g0(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i5) {
        return getResources().getText(i5);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public androidx.lifecycle.j getViewLifecycleOwner() {
        a0 a0Var = this.mViewLifecycleOwner;
        if (a0Var != null) {
            return a0Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<androidx.lifecycle.j> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    public e0 getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        } else if (getMinimumMaxLifecycleState() != f.b.INITIALIZED.ordinal()) {
            return this.mFragmentManager.A0(this);
        } else {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    public void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new o();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    /* access modifiers changed from: package-private */
    public boolean isHideReplaced() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f2169w;
    }

    /* access modifiers changed from: package-private */
    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.mFragmentManager;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isMenuVisible() {
        /*
            r2 = this;
            boolean r0 = r2.mMenuVisible
            if (r0 == 0) goto L_0x0012
            androidx.fragment.app.n r0 = r2.mFragmentManager
            if (r0 == 0) goto L_0x0010
            androidx.fragment.app.Fragment r1 = r2.mParentFragment
            boolean r0 = r0.H0(r1)
            if (r0 == 0) goto L_0x0012
        L_0x0010:
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Fragment.isMenuVisible():boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean isPostponed() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f2167u;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    /* access modifiers changed from: package-private */
    public final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        n nVar = this.mFragmentManager;
        if (nVar == null) {
            return false;
        }
        return nVar.K0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r1.mView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isVisible() {
        /*
            r1 = this;
            boolean r0 = r1.isAdded()
            if (r0 == 0) goto L_0x0020
            boolean r0 = r1.isHidden()
            if (r0 != 0) goto L_0x0020
            android.view.View r0 = r1.mView
            if (r0 == 0) goto L_0x0020
            android.os.IBinder r0 = r0.getWindowToken()
            if (r0 == 0) goto L_0x0020
            android.view.View r0 = r1.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Fragment.isVisible():boolean");
    }

    /* access modifiers changed from: package-private */
    public void noteStateNotSaved() {
        this.mChildFragmentManager.T0();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i5, int i6, Intent intent) {
        if (n.F0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i5 + " resultCode: " + i6 + " data: " + intent);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        k<?> kVar = this.mHost;
        Activity e5 = kVar == null ? null : kVar.e();
        if (e5 != null) {
            this.mCalled = false;
            onAttach(e5);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (!this.mChildFragmentManager.J0(1)) {
            this.mChildFragmentManager.D();
        }
    }

    public Animation onCreateAnimation(int i5, boolean z4, int i6) {
        return null;
    }

    public Animator onCreateAnimator(int i5, boolean z4, int i6) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i5 = this.mContentLayoutId;
        if (i5 != 0) {
            return layoutInflater.inflate(i5, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z4) {
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        k<?> kVar = this.mHost;
        Activity e5 = kVar == null ? null : kVar.e();
        if (e5 != null) {
            this.mCalled = false;
            onInflate(e5, attributeSet, bundle);
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z4) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z4) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z4) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    /* access modifiers changed from: package-private */
    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.T0();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            restoreViewState();
            this.mChildFragmentManager.z();
            return;
        }
        throw new e0("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* access modifiers changed from: package-private */
    public void performAttach() {
        Iterator<k> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.k(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.f());
        if (this.mCalled) {
            this.mFragmentManager.J(this);
            this.mChildFragmentManager.A();
            return;
        }
        throw new e0("Fragment " + this + " did not call through to super.onAttach()");
    }

    /* access modifiers changed from: package-private */
    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.B(configuration);
    }

    /* access modifiers changed from: package-private */
    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.C(menuItem);
    }

    /* access modifiers changed from: package-private */
    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.T0();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new androidx.lifecycle.h() {
            public void a(androidx.lifecycle.j jVar, f.a aVar) {
                View view;
                if (aVar == f.a.ON_STOP && (view = Fragment.this.mView) != null) {
                    view.cancelPendingInputEvents();
                }
            }
        });
        this.mSavedStateRegistryController.d(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.h(f.a.ON_CREATE);
            return;
        }
        throw new e0("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* access modifiers changed from: package-private */
    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z4 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z4 = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z4 | this.mChildFragmentManager.E(menu, menuInflater);
    }

    /* access modifiers changed from: package-private */
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.T0();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new a0(this, getViewModelStore());
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView != null) {
            this.mViewLifecycleOwner.b();
            g0.a(this.mView, this.mViewLifecycleOwner);
            h0.a(this.mView, this.mViewLifecycleOwner);
            y.e.a(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.i(this.mViewLifecycleOwner);
        } else if (!this.mViewLifecycleOwner.c()) {
            this.mViewLifecycleOwner = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    /* access modifiers changed from: package-private */
    public void performDestroy() {
        this.mChildFragmentManager.F();
        this.mLifecycleRegistry.h(f.a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new e0("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    /* access modifiers changed from: package-private */
    public void performDestroyView() {
        this.mChildFragmentManager.G();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().b().f(f.b.CREATED)) {
            this.mViewLifecycleOwner.a(f.a.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            androidx.loader.app.a.b(this).c();
            this.mPerformedCreateView = false;
            return;
        }
        throw new e0("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* access modifiers changed from: package-private */
    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new e0("Fragment " + this + " did not call through to super.onDetach()");
        } else if (!this.mChildFragmentManager.E0()) {
            this.mChildFragmentManager.F();
            this.mChildFragmentManager = new o();
        }
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    /* access modifiers changed from: package-private */
    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.H();
    }

    /* access modifiers changed from: package-private */
    public void performMultiWindowModeChanged(boolean z4) {
        onMultiWindowModeChanged(z4);
        this.mChildFragmentManager.I(z4);
    }

    /* access modifiers changed from: package-private */
    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (!this.mHasMenu || !this.mMenuVisible || !onOptionsItemSelected(menuItem)) {
            return this.mChildFragmentManager.K(menuItem);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.L(menu);
        }
    }

    /* access modifiers changed from: package-private */
    public void performPause() {
        this.mChildFragmentManager.N();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(f.a.ON_PAUSE);
        }
        this.mLifecycleRegistry.h(f.a.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new e0("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* access modifiers changed from: package-private */
    public void performPictureInPictureModeChanged(boolean z4) {
        onPictureInPictureModeChanged(z4);
        this.mChildFragmentManager.O(z4);
    }

    /* access modifiers changed from: package-private */
    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z4 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z4 = true;
            onPrepareOptionsMenu(menu);
        }
        return z4 | this.mChildFragmentManager.P(menu);
    }

    /* access modifiers changed from: package-private */
    public void performPrimaryNavigationFragmentChanged() {
        boolean I0 = this.mFragmentManager.I0(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != I0) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(I0);
            onPrimaryNavigationFragmentChanged(I0);
            this.mChildFragmentManager.Q();
        }
    }

    /* access modifiers changed from: package-private */
    public void performResume() {
        this.mChildFragmentManager.T0();
        this.mChildFragmentManager.b0(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            androidx.lifecycle.k kVar = this.mLifecycleRegistry;
            f.a aVar = f.a.ON_RESUME;
            kVar.h(aVar);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(aVar);
            }
            this.mChildFragmentManager.R();
            return;
        }
        throw new e0("Fragment " + this + " did not call through to super.onResume()");
    }

    /* access modifiers changed from: package-private */
    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
        Parcelable i12 = this.mChildFragmentManager.i1();
        if (i12 != null) {
            bundle.putParcelable("android:support:fragments", i12);
        }
    }

    /* access modifiers changed from: package-private */
    public void performStart() {
        this.mChildFragmentManager.T0();
        this.mChildFragmentManager.b0(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            androidx.lifecycle.k kVar = this.mLifecycleRegistry;
            f.a aVar = f.a.ON_START;
            kVar.h(aVar);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(aVar);
            }
            this.mChildFragmentManager.S();
            return;
        }
        throw new e0("Fragment " + this + " did not call through to super.onStart()");
    }

    /* access modifiers changed from: package-private */
    public void performStop() {
        this.mChildFragmentManager.U();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(f.a.ON_STOP);
        }
        this.mLifecycleRegistry.h(f.a.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new e0("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    /* access modifiers changed from: package-private */
    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.V();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().f2167u = true;
    }

    public final void postponeEnterTransition(long j5, TimeUnit timeUnit) {
        ensureAnimationInfo().f2167u = true;
        n nVar = this.mFragmentManager;
        Handler g5 = nVar != null ? nVar.t0().g() : new Handler(Looper.getMainLooper());
        g5.removeCallbacks(this.mPostponedDurationRunnable);
        g5.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j5));
    }

    public final <I, O> androidx.activity.result.c<I> registerForActivityResult(c.a<I, O> aVar, ActivityResultRegistry activityResultRegistry, androidx.activity.result.b<O> bVar) {
        return prepareCallInternal(aVar, new f(activityResultRegistry), bVar);
    }

    public final <I, O> androidx.activity.result.c<I> registerForActivityResult(c.a<I, O> aVar, androidx.activity.result.b<O> bVar) {
        return prepareCallInternal(aVar, new e(), bVar);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i5) {
        if (this.mHost != null) {
            getParentFragmentManager().L0(this, strArr, i5);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final e requireActivity() {
        e activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Deprecated
    public final n requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    /* access modifiers changed from: package-private */
    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.mChildFragmentManager.g1(parcelable);
            this.mChildFragmentManager.D();
        }
    }

    /* access modifiers changed from: package-private */
    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.d(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new e0("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.mView != null) {
            this.mViewLifecycleOwner.a(f.a.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z4) {
        ensureAnimationInfo().f2164r = Boolean.valueOf(z4);
    }

    public void setAllowReturnTransitionOverlap(boolean z4) {
        ensureAnimationInfo().f2163q = Boolean.valueOf(z4);
    }

    /* access modifiers changed from: package-private */
    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f2147a = view;
    }

    /* access modifiers changed from: package-private */
    public void setAnimations(int i5, int i6, int i7, int i8) {
        if (this.mAnimationInfo != null || i5 != 0 || i6 != 0 || i7 != 0 || i8 != 0) {
            ensureAnimationInfo().f2150d = i5;
            ensureAnimationInfo().f2151e = i6;
            ensureAnimationInfo().f2152f = i7;
            ensureAnimationInfo().f2153g = i8;
        }
    }

    /* access modifiers changed from: package-private */
    public void setAnimator(Animator animator) {
        ensureAnimationInfo().f2148b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager == null || !isStateSaved()) {
            this.mArguments = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(w0 w0Var) {
        ensureAnimationInfo().getClass();
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().f2157k = obj;
    }

    public void setExitSharedElementCallback(w0 w0Var) {
        ensureAnimationInfo().getClass();
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().f2159m = obj;
    }

    /* access modifiers changed from: package-private */
    public void setFocusedView(View view) {
        ensureAnimationInfo().f2166t = view;
    }

    public void setHasOptionsMenu(boolean z4) {
        if (this.mHasMenu != z4) {
            this.mHasMenu = z4;
            if (isAdded() && !isHidden()) {
                this.mHost.o();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setHideReplaced(boolean z4) {
        ensureAnimationInfo().f2169w = z4;
    }

    public void setInitialSavedState(m mVar) {
        Bundle bundle;
        if (this.mFragmentManager == null) {
            if (mVar == null || (bundle = mVar.f2170e) == null) {
                bundle = null;
            }
            this.mSavedFragmentState = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean z4) {
        if (this.mMenuVisible != z4) {
            this.mMenuVisible = z4;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.o();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setNextTransition(int i5) {
        if (this.mAnimationInfo != null || i5 != 0) {
            ensureAnimationInfo();
            this.mAnimationInfo.f2154h = i5;
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnStartEnterTransitionListener(l lVar) {
        ensureAnimationInfo();
        i iVar = this.mAnimationInfo;
        l lVar2 = iVar.f2168v;
        if (lVar != lVar2) {
            if (lVar == null || lVar2 == null) {
                if (iVar.f2167u) {
                    iVar.f2168v = lVar;
                }
                if (lVar != null) {
                    lVar.b();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    /* access modifiers changed from: package-private */
    public void setPopDirection(boolean z4) {
        if (this.mAnimationInfo != null) {
            ensureAnimationInfo().f2149c = z4;
        }
    }

    /* access modifiers changed from: package-private */
    public void setPostOnViewCreatedAlpha(float f5) {
        ensureAnimationInfo().f2165s = f5;
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().f2160n = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z4) {
        this.mRetainInstance = z4;
        n nVar = this.mFragmentManager;
        if (nVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z4) {
            nVar.i(this);
        } else {
            nVar.e1(this);
        }
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().f2158l = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().f2161o = obj;
    }

    /* access modifiers changed from: package-private */
    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ensureAnimationInfo();
        i iVar = this.mAnimationInfo;
        iVar.f2155i = arrayList;
        iVar.f2156j = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().f2162p = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i5) {
        n nVar = this.mFragmentManager;
        n nVar2 = fragment != null ? fragment.mFragmentManager : null;
        if (nVar == null || nVar2 == null || nVar == nVar2) {
            Fragment fragment2 = fragment;
            while (fragment2 != null) {
                if (!fragment2.equals(this)) {
                    fragment2 = fragment2.getTargetFragment();
                } else {
                    throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
                }
            }
            if (fragment == null) {
                this.mTargetWho = null;
            } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
                this.mTargetWho = null;
                this.mTarget = fragment;
                this.mTargetRequestCode = i5;
                return;
            } else {
                this.mTargetWho = fragment.mWho;
            }
            this.mTarget = null;
            this.mTargetRequestCode = i5;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
    }

    @Deprecated
    public void setUserVisibleHint(boolean z4) {
        if (!this.mUserVisibleHint && z4 && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            n nVar = this.mFragmentManager;
            nVar.V0(nVar.w(this));
        }
        this.mUserVisibleHint = z4;
        this.mDeferStart = this.mState < 5 && !z4;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z4);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        k<?> kVar = this.mHost;
        if (kVar != null) {
            return kVar.l(str);
        }
        return false;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, (Bundle) null);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        k<?> kVar = this.mHost;
        if (kVar != null) {
            kVar.m(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i5) {
        startActivityForResult(intent, i5, (Bundle) null);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i5, Bundle bundle) {
        if (this.mHost != null) {
            getParentFragmentManager().M0(this, intent, i5, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        if (this.mHost != null) {
            if (n.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(this);
                sb.append(" received the following in startIntentSenderForResult() requestCode: ");
                int i9 = i5;
                sb.append(i5);
                sb.append(" IntentSender: ");
                IntentSender intentSender2 = intentSender;
                sb.append(intentSender);
                sb.append(" fillInIntent: ");
                Intent intent2 = intent;
                sb.append(intent);
                sb.append(" options: ");
                sb.append(bundle);
                Log.v("FragmentManager", sb.toString());
            } else {
                IntentSender intentSender3 = intentSender;
                int i10 = i5;
                Intent intent3 = intent;
                Bundle bundle2 = bundle;
            }
            getParentFragmentManager().N0(this, intentSender, i5, intent, i6, i7, i8, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null && ensureAnimationInfo().f2167u) {
            if (this.mHost == null) {
                ensureAnimationInfo().f2167u = false;
            } else if (Looper.myLooper() != this.mHost.g().getLooper()) {
                this.mHost.g().postAtFrontOfQueue(new b());
            } else {
                callStartTransitionListener(true);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) null);
    }
}
