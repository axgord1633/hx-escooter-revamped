package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.k0;
import androidx.fragment.app.c0;
import androidx.lifecycle.f;
import androidx.lifecycle.f0;
import com.yalantis.ucrop.view.CropImageView;

class u {

    /* renamed from: a  reason: collision with root package name */
    private final m f2407a;

    /* renamed from: b  reason: collision with root package name */
    private final v f2408b;

    /* renamed from: c  reason: collision with root package name */
    private final Fragment f2409c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2410d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f2411e = -1;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f2412e;

        a(View view) {
            this.f2412e = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.f2412e.removeOnAttachStateChangeListener(this);
            k0.L(this.f2412e);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2414a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.lifecycle.f$b[] r0 = androidx.lifecycle.f.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2414a = r0
                androidx.lifecycle.f$b r1 = androidx.lifecycle.f.b.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2414a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.f$b r1 = androidx.lifecycle.f.b.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2414a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.f$b r1 = androidx.lifecycle.f.b.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2414a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.f$b r1 = androidx.lifecycle.f.b.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.u.b.<clinit>():void");
        }
    }

    u(m mVar, v vVar, Fragment fragment) {
        this.f2407a = mVar;
        this.f2408b = vVar;
        this.f2409c = fragment;
    }

    u(m mVar, v vVar, Fragment fragment, t tVar) {
        this.f2407a = mVar;
        this.f2408b = vVar;
        this.f2409c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = tVar.f2406q;
        fragment.mSavedFragmentState = bundle == null ? new Bundle() : bundle;
    }

    u(m mVar, v vVar, ClassLoader classLoader, j jVar, t tVar) {
        this.f2407a = mVar;
        this.f2408b = vVar;
        Fragment a5 = jVar.a(classLoader, tVar.f2394e);
        this.f2409c = a5;
        Bundle bundle = tVar.f2403n;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a5.setArguments(tVar.f2403n);
        a5.mWho = tVar.f2395f;
        a5.mFromLayout = tVar.f2396g;
        a5.mRestored = true;
        a5.mFragmentId = tVar.f2397h;
        a5.mContainerId = tVar.f2398i;
        a5.mTag = tVar.f2399j;
        a5.mRetainInstance = tVar.f2400k;
        a5.mRemoving = tVar.f2401l;
        a5.mDetached = tVar.f2402m;
        a5.mHidden = tVar.f2404o;
        a5.mMaxState = f.b.values()[tVar.f2405p];
        Bundle bundle2 = tVar.f2406q;
        a5.mSavedFragmentState = bundle2 == null ? new Bundle() : bundle2;
        if (n.F0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a5);
        }
    }

    private boolean l(View view) {
        if (view == this.f2409c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f2409c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f2409c.performSaveInstanceState(bundle);
        this.f2407a.j(this.f2409c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f2409c.mView != null) {
            s();
        }
        if (this.f2409c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f2409c.mSavedViewState);
        }
        if (this.f2409c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f2409c.mSavedViewRegistryState);
        }
        if (!this.f2409c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f2409c.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (n.F0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f2409c);
        }
        Fragment fragment = this.f2409c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        m mVar = this.f2407a;
        Fragment fragment2 = this.f2409c;
        mVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int j5 = this.f2408b.j(this.f2409c);
        Fragment fragment = this.f2409c;
        fragment.mContainer.addView(fragment.mView, j5);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (n.F0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f2409c);
        }
        Fragment fragment = this.f2409c;
        Fragment fragment2 = fragment.mTarget;
        u uVar = null;
        if (fragment2 != null) {
            u m5 = this.f2408b.m(fragment2.mWho);
            if (m5 != null) {
                Fragment fragment3 = this.f2409c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                uVar = m5;
            } else {
                throw new IllegalStateException("Fragment " + this.f2409c + " declared target fragment " + this.f2409c.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (uVar = this.f2408b.m(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f2409c + " declared target fragment " + this.f2409c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (uVar != null && (n.P || uVar.k().mState < 1)) {
            uVar.m();
        }
        Fragment fragment4 = this.f2409c;
        fragment4.mHost = fragment4.mFragmentManager.t0();
        Fragment fragment5 = this.f2409c;
        fragment5.mParentFragment = fragment5.mFragmentManager.w0();
        this.f2407a.g(this.f2409c, false);
        this.f2409c.performAttach();
        this.f2407a.b(this.f2409c, false);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f2409c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i5 = this.f2411e;
        int i6 = b.f2414a[fragment2.mMaxState.ordinal()];
        if (i6 != 1) {
            i5 = i6 != 2 ? i6 != 3 ? i6 != 4 ? Math.min(i5, -1) : Math.min(i5, 0) : Math.min(i5, 1) : Math.min(i5, 5);
        }
        Fragment fragment3 = this.f2409c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i5 = Math.max(this.f2411e, 2);
                View view = this.f2409c.mView;
                if (view != null && view.getParent() == null) {
                    i5 = Math.min(i5, 2);
                }
            } else {
                i5 = this.f2411e < 4 ? Math.min(i5, fragment3.mState) : Math.min(i5, 1);
            }
        }
        if (!this.f2409c.mAdded) {
            i5 = Math.min(i5, 1);
        }
        c0.e.b bVar = null;
        if (n.P && (viewGroup = fragment.mContainer) != null) {
            bVar = c0.n(viewGroup, (fragment = this.f2409c).getParentFragmentManager()).l(this);
        }
        if (bVar == c0.e.b.ADDING) {
            i5 = Math.min(i5, 6);
        } else if (bVar == c0.e.b.REMOVING) {
            i5 = Math.max(i5, 3);
        } else {
            Fragment fragment4 = this.f2409c;
            if (fragment4.mRemoving) {
                i5 = fragment4.isInBackStack() ? Math.min(i5, 1) : Math.min(i5, -1);
            }
        }
        Fragment fragment5 = this.f2409c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i5 = Math.min(i5, 4);
        }
        if (n.F0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i5 + " for " + this.f2409c);
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (n.F0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f2409c);
        }
        Fragment fragment = this.f2409c;
        if (!fragment.mIsCreated) {
            this.f2407a.h(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.f2409c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            m mVar = this.f2407a;
            Fragment fragment3 = this.f2409c;
            mVar.c(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.f2409c.mState = 1;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        String str;
        if (!this.f2409c.mFromLayout) {
            if (n.F0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f2409c);
            }
            Fragment fragment = this.f2409c;
            LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
            ViewGroup viewGroup = null;
            Fragment fragment2 = this.f2409c;
            ViewGroup viewGroup2 = fragment2.mContainer;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i5 = fragment2.mContainerId;
                if (i5 != 0) {
                    if (i5 != -1) {
                        viewGroup = (ViewGroup) fragment2.mFragmentManager.o0().c(this.f2409c.mContainerId);
                        if (viewGroup == null) {
                            Fragment fragment3 = this.f2409c;
                            if (!fragment3.mRestored) {
                                try {
                                    str = fragment3.getResources().getResourceName(this.f2409c.mContainerId);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f2409c.mContainerId) + " (" + str + ") for fragment " + this.f2409c);
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create fragment " + this.f2409c + " for a container view with no id");
                    }
                }
            }
            Fragment fragment4 = this.f2409c;
            fragment4.mContainer = viewGroup;
            fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
            View view = this.f2409c.mView;
            if (view != null) {
                boolean z4 = false;
                view.setSaveFromParentEnabled(false);
                Fragment fragment5 = this.f2409c;
                fragment5.mView.setTag(u.b.f7054a, fragment5);
                if (viewGroup != null) {
                    b();
                }
                Fragment fragment6 = this.f2409c;
                if (fragment6.mHidden) {
                    fragment6.mView.setVisibility(8);
                }
                if (k0.A(this.f2409c.mView)) {
                    k0.L(this.f2409c.mView);
                } else {
                    View view2 = this.f2409c.mView;
                    view2.addOnAttachStateChangeListener(new a(view2));
                }
                this.f2409c.performViewCreated();
                m mVar = this.f2407a;
                Fragment fragment7 = this.f2409c;
                mVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
                int visibility = this.f2409c.mView.getVisibility();
                float alpha = this.f2409c.mView.getAlpha();
                if (n.P) {
                    this.f2409c.setPostOnViewCreatedAlpha(alpha);
                    Fragment fragment8 = this.f2409c;
                    if (fragment8.mContainer != null && visibility == 0) {
                        View findFocus = fragment8.mView.findFocus();
                        if (findFocus != null) {
                            this.f2409c.setFocusedView(findFocus);
                            if (n.F0(2)) {
                                Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f2409c);
                            }
                        }
                        this.f2409c.mView.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                    }
                } else {
                    Fragment fragment9 = this.f2409c;
                    if (visibility == 0 && fragment9.mContainer != null) {
                        z4 = true;
                    }
                    fragment9.mIsNewlyAdded = z4;
                }
            }
            this.f2409c.mState = 2;
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        Fragment f5;
        if (n.F0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f2409c);
        }
        Fragment fragment = this.f2409c;
        boolean z4 = true;
        boolean z5 = fragment.mRemoving && !fragment.isInBackStack();
        if (z5 || this.f2408b.o().p(this.f2409c)) {
            k<?> kVar = this.f2409c.mHost;
            if (kVar instanceof f0) {
                z4 = this.f2408b.o().m();
            } else if (kVar.f() instanceof Activity) {
                z4 = true ^ ((Activity) kVar.f()).isChangingConfigurations();
            }
            if (z5 || z4) {
                this.f2408b.o().g(this.f2409c);
            }
            this.f2409c.performDestroy();
            this.f2407a.d(this.f2409c, false);
            for (u next : this.f2408b.k()) {
                if (next != null) {
                    Fragment k5 = next.k();
                    if (this.f2409c.mWho.equals(k5.mTargetWho)) {
                        k5.mTarget = this.f2409c;
                        k5.mTargetWho = null;
                    }
                }
            }
            Fragment fragment2 = this.f2409c;
            String str = fragment2.mTargetWho;
            if (str != null) {
                fragment2.mTarget = this.f2408b.f(str);
            }
            this.f2408b.q(this);
            return;
        }
        String str2 = this.f2409c.mTargetWho;
        if (!(str2 == null || (f5 = this.f2408b.f(str2)) == null || !f5.mRetainInstance)) {
            this.f2409c.mTarget = f5;
        }
        this.f2409c.mState = 0;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        View view;
        if (n.F0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f2409c);
        }
        Fragment fragment = this.f2409c;
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        this.f2409c.performDestroyView();
        this.f2407a.n(this.f2409c, false);
        Fragment fragment2 = this.f2409c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.i(null);
        this.f2409c.mInLayout = false;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (n.F0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f2409c);
        }
        this.f2409c.performDetach();
        boolean z4 = false;
        this.f2407a.e(this.f2409c, false);
        Fragment fragment = this.f2409c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z4 = true;
        }
        if (z4 || this.f2408b.o().p(this.f2409c)) {
            if (n.F0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f2409c);
            }
            this.f2409c.initState();
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        Fragment fragment = this.f2409c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (n.F0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f2409c);
            }
            Fragment fragment2 = this.f2409c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), (ViewGroup) null, this.f2409c.mSavedFragmentState);
            View view = this.f2409c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f2409c;
                fragment3.mView.setTag(u.b.f7054a, fragment3);
                Fragment fragment4 = this.f2409c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f2409c.performViewCreated();
                m mVar = this.f2407a;
                Fragment fragment5 = this.f2409c;
                mVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f2409c.mState = 2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment k() {
        return this.f2409c;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.f2410d) {
            boolean z4 = false;
            z4 = true;
            try {
                while (true) {
                    int d5 = d();
                    Fragment fragment = this.f2409c;
                    int i5 = fragment.mState;
                    if (d5 != i5) {
                        if (d5 <= i5) {
                            switch (i5 - 1) {
                                case -1:
                                    i();
                                    break;
                                case 0:
                                    g();
                                    break;
                                case 1:
                                    h();
                                    this.f2409c.mState = z4 ? 1 : 0;
                                    break;
                                case 2:
                                    fragment.mInLayout = z4;
                                    fragment.mState = 2;
                                    break;
                                case 3:
                                    if (n.F0(3)) {
                                        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f2409c);
                                    }
                                    Fragment fragment2 = this.f2409c;
                                    if (fragment2.mView != null && fragment2.mSavedViewState == null) {
                                        s();
                                    }
                                    Fragment fragment3 = this.f2409c;
                                    if (!(fragment3.mView == null || (viewGroup2 = fragment3.mContainer) == null)) {
                                        c0.n(viewGroup2, fragment3.getParentFragmentManager()).d(this);
                                    }
                                    this.f2409c.mState = 3;
                                    break;
                                case 4:
                                    v();
                                    break;
                                case 5:
                                    fragment.mState = 5;
                                    break;
                                case 6:
                                    n();
                                    break;
                            }
                        } else {
                            switch (i5 + 1) {
                                case 0:
                                    c();
                                    break;
                                case 1:
                                    e();
                                    break;
                                case 2:
                                    j();
                                    f();
                                    break;
                                case 3:
                                    a();
                                    break;
                                case 4:
                                    if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                        c0.n(viewGroup3, fragment.getParentFragmentManager()).b(c0.e.c.f(this.f2409c.mView.getVisibility()), this);
                                    }
                                    this.f2409c.mState = 4;
                                    break;
                                case 5:
                                    u();
                                    break;
                                case 6:
                                    fragment.mState = 6;
                                    break;
                                case 7:
                                    p();
                                    break;
                            }
                        }
                    } else {
                        if (n.P && fragment.mHiddenChanged) {
                            if (!(fragment.mView == null || (viewGroup = fragment.mContainer) == null)) {
                                c0 n5 = c0.n(viewGroup, fragment.getParentFragmentManager());
                                if (this.f2409c.mHidden) {
                                    n5.c(this);
                                } else {
                                    n5.e(this);
                                }
                            }
                            Fragment fragment4 = this.f2409c;
                            n nVar = fragment4.mFragmentManager;
                            if (nVar != null) {
                                nVar.D0(fragment4);
                            }
                            Fragment fragment5 = this.f2409c;
                            fragment5.mHiddenChanged = z4;
                            fragment5.onHiddenChanged(fragment5.mHidden);
                        }
                        this.f2410d = z4;
                        return;
                    }
                }
            } finally {
                this.f2410d = z4;
            }
        } else if (n.F0(2)) {
            Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        if (n.F0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f2409c);
        }
        this.f2409c.performPause();
        this.f2407a.f(this.f2409c, false);
    }

    /* access modifiers changed from: package-private */
    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f2409c.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.f2409c;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f2409c;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
            Fragment fragment3 = this.f2409c;
            fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
            Fragment fragment4 = this.f2409c;
            if (fragment4.mTargetWho != null) {
                fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            Fragment fragment5 = this.f2409c;
            Boolean bool = fragment5.mSavedUserVisibleHint;
            if (bool != null) {
                fragment5.mUserVisibleHint = bool.booleanValue();
                this.f2409c.mSavedUserVisibleHint = null;
            } else {
                fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment6 = this.f2409c;
            if (!fragment6.mUserVisibleHint) {
                fragment6.mDeferStart = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        if (n.F0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f2409c);
        }
        View focusedView = this.f2409c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (n.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f2409c);
                sb.append(" resulting in focused view ");
                sb.append(this.f2409c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f2409c.setFocusedView((View) null);
        this.f2409c.performResume();
        this.f2407a.i(this.f2409c, false);
        Fragment fragment = this.f2409c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    /* access modifiers changed from: package-private */
    public t r() {
        t tVar = new t(this.f2409c);
        Fragment fragment = this.f2409c;
        if (fragment.mState <= -1 || tVar.f2406q != null) {
            tVar.f2406q = fragment.mSavedFragmentState;
        } else {
            Bundle q5 = q();
            tVar.f2406q = q5;
            if (this.f2409c.mTargetWho != null) {
                if (q5 == null) {
                    tVar.f2406q = new Bundle();
                }
                tVar.f2406q.putString("android:target_state", this.f2409c.mTargetWho);
                int i5 = this.f2409c.mTargetRequestCode;
                if (i5 != 0) {
                    tVar.f2406q.putInt("android:target_req_state", i5);
                }
            }
        }
        return tVar;
    }

    /* access modifiers changed from: package-private */
    public void s() {
        if (this.f2409c.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f2409c.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f2409c.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f2409c.mViewLifecycleOwner.e(bundle);
            if (!bundle.isEmpty()) {
                this.f2409c.mSavedViewRegistryState = bundle;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t(int i5) {
        this.f2411e = i5;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        if (n.F0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f2409c);
        }
        this.f2409c.performStart();
        this.f2407a.k(this.f2409c, false);
    }

    /* access modifiers changed from: package-private */
    public void v() {
        if (n.F0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f2409c);
        }
        this.f2409c.performStop();
        this.f2407a.l(this.f2409c, false);
    }
}
