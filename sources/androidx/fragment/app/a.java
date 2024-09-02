package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import java.io.PrintWriter;
import java.util.ArrayList;

final class a extends w implements n.C0038n {

    /* renamed from: t  reason: collision with root package name */
    final n f2175t;

    /* renamed from: u  reason: collision with root package name */
    boolean f2176u;

    /* renamed from: v  reason: collision with root package name */
    int f2177v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    a(n nVar) {
        super(nVar.q0(), nVar.t0() != null ? nVar.t0().f().getClassLoader() : null);
        this.f2177v = -1;
        this.f2175t = nVar;
    }

    private static boolean w(w.a aVar) {
        Fragment fragment = aVar.f2438b;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    /* access modifiers changed from: package-private */
    public Fragment A(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f2420c.size() - 1; size >= 0; size--) {
            w.a aVar = this.f2420c.get(size);
            int i5 = aVar.f2437a;
            if (i5 != 1) {
                if (i5 != 3) {
                    switch (i5) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f2438b;
                            break;
                        case 10:
                            aVar.f2444h = aVar.f2443g;
                            break;
                    }
                }
                arrayList.add(aVar.f2438b);
            }
            arrayList.remove(aVar.f2438b);
        }
        return fragment;
    }

    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (n.F0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f2426i) {
            return true;
        }
        this.f2175t.e(this);
        return true;
    }

    public int f() {
        return n(false);
    }

    public int g() {
        return n(true);
    }

    public void h() {
        i();
        this.f2175t.c0(this, true);
    }

    /* access modifiers changed from: package-private */
    public void j(int i5, Fragment fragment, String str, int i6) {
        super.j(i5, fragment, str, i6);
        fragment.mFragmentManager = this.f2175t;
    }

    public w k(Fragment fragment) {
        n nVar = fragment.mFragmentManager;
        if (nVar == null || nVar == this.f2175t) {
            return super.k(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    public void m(int i5) {
        if (this.f2426i) {
            if (n.F0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i5);
            }
            int size = this.f2420c.size();
            for (int i6 = 0; i6 < size; i6++) {
                w.a aVar = this.f2420c.get(i6);
                Fragment fragment = aVar.f2438b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i5;
                    if (n.F0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f2438b + " to " + aVar.f2438b.mBackStackNesting);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int n(boolean z4) {
        if (!this.f2176u) {
            if (n.F0(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new b0("FragmentManager"));
                o("  ", printWriter);
                printWriter.close();
            }
            this.f2176u = true;
            this.f2177v = this.f2426i ? this.f2175t.j() : -1;
            this.f2175t.Z(this, z4);
            return this.f2177v;
        }
        throw new IllegalStateException("commit already called");
    }

    public void o(String str, PrintWriter printWriter) {
        p(str, printWriter, true);
    }

    public void p(String str, PrintWriter printWriter, boolean z4) {
        String str2;
        if (z4) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2428k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2177v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2176u);
            if (this.f2425h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2425h));
            }
            if (!(this.f2421d == 0 && this.f2422e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2421d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2422e));
            }
            if (!(this.f2423f == 0 && this.f2424g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2423f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2424g));
            }
            if (!(this.f2429l == 0 && this.f2430m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2429l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2430m);
            }
            if (!(this.f2431n == 0 && this.f2432o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2431n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2432o);
            }
        }
        if (!this.f2420c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f2420c.size();
            for (int i5 = 0; i5 < size; i5++) {
                w.a aVar = this.f2420c.get(i5);
                switch (aVar.f2437a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f2437a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f2438b);
                if (z4) {
                    if (!(aVar.f2439c == 0 && aVar.f2440d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2439c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2440d));
                    }
                    if (aVar.f2441e != 0 || aVar.f2442f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2441e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2442f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q() {
        int size = this.f2420c.size();
        for (int i5 = 0; i5 < size; i5++) {
            w.a aVar = this.f2420c.get(i5);
            Fragment fragment = aVar.f2438b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f2425h);
                fragment.setSharedElementNames(this.f2433p, this.f2434q);
            }
            switch (aVar.f2437a) {
                case 1:
                    fragment.setAnimations(aVar.f2439c, aVar.f2440d, aVar.f2441e, aVar.f2442f);
                    this.f2175t.k1(fragment, false);
                    this.f2175t.g(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f2439c, aVar.f2440d, aVar.f2441e, aVar.f2442f);
                    this.f2175t.c1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f2439c, aVar.f2440d, aVar.f2441e, aVar.f2442f);
                    this.f2175t.C0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f2439c, aVar.f2440d, aVar.f2441e, aVar.f2442f);
                    this.f2175t.k1(fragment, false);
                    this.f2175t.o1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f2439c, aVar.f2440d, aVar.f2441e, aVar.f2442f);
                    this.f2175t.y(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f2439c, aVar.f2440d, aVar.f2441e, aVar.f2442f);
                    this.f2175t.k1(fragment, false);
                    this.f2175t.l(fragment);
                    break;
                case 8:
                    this.f2175t.m1(fragment);
                    break;
                case 9:
                    this.f2175t.m1((Fragment) null);
                    break;
                case 10:
                    this.f2175t.l1(fragment, aVar.f2444h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2437a);
            }
            if (!this.f2435r && aVar.f2437a != 1 && fragment != null && !n.P) {
                this.f2175t.P0(fragment);
            }
        }
        if (!this.f2435r && !n.P) {
            n nVar = this.f2175t;
            nVar.Q0(nVar.f2345q, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(boolean z4) {
        for (int size = this.f2420c.size() - 1; size >= 0; size--) {
            w.a aVar = this.f2420c.get(size);
            Fragment fragment = aVar.f2438b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(n.h1(this.f2425h));
                fragment.setSharedElementNames(this.f2434q, this.f2433p);
            }
            switch (aVar.f2437a) {
                case 1:
                    fragment.setAnimations(aVar.f2439c, aVar.f2440d, aVar.f2441e, aVar.f2442f);
                    this.f2175t.k1(fragment, true);
                    this.f2175t.c1(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f2439c, aVar.f2440d, aVar.f2441e, aVar.f2442f);
                    this.f2175t.g(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f2439c, aVar.f2440d, aVar.f2441e, aVar.f2442f);
                    this.f2175t.o1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f2439c, aVar.f2440d, aVar.f2441e, aVar.f2442f);
                    this.f2175t.k1(fragment, true);
                    this.f2175t.C0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f2439c, aVar.f2440d, aVar.f2441e, aVar.f2442f);
                    this.f2175t.l(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f2439c, aVar.f2440d, aVar.f2441e, aVar.f2442f);
                    this.f2175t.k1(fragment, true);
                    this.f2175t.y(fragment);
                    break;
                case 8:
                    this.f2175t.m1((Fragment) null);
                    break;
                case 9:
                    this.f2175t.m1(fragment);
                    break;
                case 10:
                    this.f2175t.l1(fragment, aVar.f2443g);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2437a);
            }
            if (!this.f2435r && aVar.f2437a != 3 && fragment != null && !n.P) {
                this.f2175t.P0(fragment);
            }
        }
        if (!this.f2435r && z4 && !n.P) {
            n nVar = this.f2175t;
            nVar.Q0(nVar.f2345q, true);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment s(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i5 = 0;
        while (i5 < this.f2420c.size()) {
            w.a aVar = this.f2420c.get(i5);
            int i6 = aVar.f2437a;
            if (i6 != 1) {
                if (i6 == 2) {
                    Fragment fragment3 = aVar.f2438b;
                    int i7 = fragment3.mContainerId;
                    boolean z4 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList2.get(size);
                        if (fragment4.mContainerId == i7) {
                            if (fragment4 == fragment3) {
                                z4 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f2420c.add(i5, new w.a(9, fragment4));
                                    i5++;
                                    fragment2 = null;
                                }
                                w.a aVar2 = new w.a(3, fragment4);
                                aVar2.f2439c = aVar.f2439c;
                                aVar2.f2441e = aVar.f2441e;
                                aVar2.f2440d = aVar.f2440d;
                                aVar2.f2442f = aVar.f2442f;
                                this.f2420c.add(i5, aVar2);
                                arrayList2.remove(fragment4);
                                i5++;
                            }
                        }
                    }
                    if (z4) {
                        this.f2420c.remove(i5);
                        i5--;
                    } else {
                        aVar.f2437a = 1;
                        arrayList2.add(fragment3);
                    }
                } else if (i6 == 3 || i6 == 6) {
                    arrayList2.remove(aVar.f2438b);
                    Fragment fragment5 = aVar.f2438b;
                    if (fragment5 == fragment2) {
                        this.f2420c.add(i5, new w.a(9, fragment5));
                        i5++;
                        fragment2 = null;
                    }
                } else if (i6 != 7) {
                    if (i6 == 8) {
                        this.f2420c.add(i5, new w.a(9, fragment2));
                        i5++;
                        fragment2 = aVar.f2438b;
                    }
                }
                i5++;
            }
            arrayList2.add(aVar.f2438b);
            i5++;
        }
        return fragment2;
    }

    public String t() {
        return this.f2428k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2177v >= 0) {
            sb.append(" #");
            sb.append(this.f2177v);
        }
        if (this.f2428k != null) {
            sb.append(" ");
            sb.append(this.f2428k);
        }
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public boolean u(int i5) {
        int size = this.f2420c.size();
        for (int i6 = 0; i6 < size; i6++) {
            Fragment fragment = this.f2420c.get(i6).f2438b;
            int i7 = fragment != null ? fragment.mContainerId : 0;
            if (i7 != 0 && i7 == i5) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean v(ArrayList<a> arrayList, int i5, int i6) {
        if (i6 == i5) {
            return false;
        }
        int size = this.f2420c.size();
        int i7 = -1;
        for (int i8 = 0; i8 < size; i8++) {
            Fragment fragment = this.f2420c.get(i8).f2438b;
            int i9 = fragment != null ? fragment.mContainerId : 0;
            if (!(i9 == 0 || i9 == i7)) {
                for (int i10 = i5; i10 < i6; i10++) {
                    a aVar = arrayList.get(i10);
                    int size2 = aVar.f2420c.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        Fragment fragment2 = aVar.f2420c.get(i11).f2438b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i9) {
                            return true;
                        }
                    }
                }
                i7 = i9;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        for (int i5 = 0; i5 < this.f2420c.size(); i5++) {
            if (w(this.f2420c.get(i5))) {
                return true;
            }
        }
        return false;
    }

    public void y() {
        if (this.f2436s != null) {
            for (int i5 = 0; i5 < this.f2436s.size(); i5++) {
                this.f2436s.get(i5).run();
            }
            this.f2436s = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void z(Fragment.l lVar) {
        for (int i5 = 0; i5 < this.f2420c.size(); i5++) {
            w.a aVar = this.f2420c.get(i5);
            if (w(aVar)) {
                aVar.f2438b.setOnStartEnterTransitionListener(lVar);
            }
        }
    }
}
