package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class v {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Fragment> f2415a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, u> f2416b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private q f2417c;

    v() {
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (!this.f2415a.contains(fragment)) {
            synchronized (this.f2415a) {
                this.f2415a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f2416b.values().removeAll(Collections.singleton((Object) null));
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str) {
        return this.f2416b.get(str) != null;
    }

    /* access modifiers changed from: package-private */
    public void d(int i5) {
        for (u next : this.f2416b.values()) {
            if (next != null) {
                next.t(i5);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f2416b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (u next : this.f2416b.values()) {
                printWriter.print(str);
                if (next != null) {
                    Fragment k5 = next.k();
                    printWriter.println(k5);
                    k5.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f2415a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i5 = 0; i5 < size; i5++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(this.f2415a.get(i5).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment f(String str) {
        u uVar = this.f2416b.get(str);
        if (uVar != null) {
            return uVar.k();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment g(int i5) {
        for (int size = this.f2415a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f2415a.get(size);
            if (fragment != null && fragment.mFragmentId == i5) {
                return fragment;
            }
        }
        for (u next : this.f2416b.values()) {
            if (next != null) {
                Fragment k5 = next.k();
                if (k5.mFragmentId == i5) {
                    return k5;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f2415a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f2415a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (u next : this.f2416b.values()) {
            if (next != null) {
                Fragment k5 = next.k();
                if (str.equals(k5.mTag)) {
                    return k5;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment i(String str) {
        Fragment findFragmentByWho;
        for (u next : this.f2416b.values()) {
            if (next != null && (findFragmentByWho = next.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f2415a.indexOf(fragment);
        for (int i5 = indexOf - 1; i5 >= 0; i5--) {
            Fragment fragment2 = this.f2415a.get(i5);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f2415a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f2415a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<u> k() {
        ArrayList arrayList = new ArrayList();
        for (u next : this.f2416b.values()) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        Iterator<u> it = this.f2416b.values().iterator();
        while (it.hasNext()) {
            u next = it.next();
            arrayList.add(next != null ? next.k() : null);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public u m(String str) {
        return this.f2416b.get(str);
    }

    /* access modifiers changed from: package-private */
    public List<Fragment> n() {
        ArrayList arrayList;
        if (this.f2415a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2415a) {
            arrayList = new ArrayList(this.f2415a);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public q o() {
        return this.f2417c;
    }

    /* access modifiers changed from: package-private */
    public void p(u uVar) {
        Fragment k5 = uVar.k();
        if (!c(k5.mWho)) {
            this.f2416b.put(k5.mWho, uVar);
            if (k5.mRetainInstanceChangedWhileDetached) {
                if (k5.mRetainInstance) {
                    this.f2417c.f(k5);
                } else {
                    this.f2417c.n(k5);
                }
                k5.mRetainInstanceChangedWhileDetached = false;
            }
            if (n.F0(2)) {
                Log.v("FragmentManager", "Added fragment to active set " + k5);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q(u uVar) {
        Fragment k5 = uVar.k();
        if (k5.mRetainInstance) {
            this.f2417c.n(k5);
        }
        if (this.f2416b.put(k5.mWho, (Object) null) != null && n.F0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k5);
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        Iterator<Fragment> it = this.f2415a.iterator();
        while (it.hasNext()) {
            u uVar = this.f2416b.get(it.next().mWho);
            if (uVar != null) {
                uVar.m();
            }
        }
        for (u next : this.f2416b.values()) {
            if (next != null) {
                next.m();
                Fragment k5 = next.k();
                if (k5.mRemoving && !k5.isInBackStack()) {
                    q(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s(Fragment fragment) {
        synchronized (this.f2415a) {
            this.f2415a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        this.f2416b.clear();
    }

    /* access modifiers changed from: package-private */
    public void u(List<String> list) {
        this.f2415a.clear();
        if (list != null) {
            for (String next : list) {
                Fragment f5 = f(next);
                if (f5 != null) {
                    if (n.F0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + next + "): " + f5);
                    }
                    a(f5);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + next + ")");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<t> v() {
        ArrayList<t> arrayList = new ArrayList<>(this.f2416b.size());
        for (u next : this.f2416b.values()) {
            if (next != null) {
                Fragment k5 = next.k();
                t r5 = next.r();
                arrayList.add(r5);
                if (n.F0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k5 + ": " + r5.f2406q);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> w() {
        synchronized (this.f2415a) {
            if (this.f2415a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f2415a.size());
            Iterator<Fragment> it = this.f2415a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (n.F0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: package-private */
    public void x(q qVar) {
        this.f2417c = qVar;
    }
}
