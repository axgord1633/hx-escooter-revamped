package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.f;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class w {

    /* renamed from: a  reason: collision with root package name */
    private final j f2418a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassLoader f2419b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<a> f2420c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    int f2421d;

    /* renamed from: e  reason: collision with root package name */
    int f2422e;

    /* renamed from: f  reason: collision with root package name */
    int f2423f;

    /* renamed from: g  reason: collision with root package name */
    int f2424g;

    /* renamed from: h  reason: collision with root package name */
    int f2425h;

    /* renamed from: i  reason: collision with root package name */
    boolean f2426i;

    /* renamed from: j  reason: collision with root package name */
    boolean f2427j = true;

    /* renamed from: k  reason: collision with root package name */
    String f2428k;

    /* renamed from: l  reason: collision with root package name */
    int f2429l;

    /* renamed from: m  reason: collision with root package name */
    CharSequence f2430m;

    /* renamed from: n  reason: collision with root package name */
    int f2431n;

    /* renamed from: o  reason: collision with root package name */
    CharSequence f2432o;

    /* renamed from: p  reason: collision with root package name */
    ArrayList<String> f2433p;

    /* renamed from: q  reason: collision with root package name */
    ArrayList<String> f2434q;

    /* renamed from: r  reason: collision with root package name */
    boolean f2435r = false;

    /* renamed from: s  reason: collision with root package name */
    ArrayList<Runnable> f2436s;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f2437a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f2438b;

        /* renamed from: c  reason: collision with root package name */
        int f2439c;

        /* renamed from: d  reason: collision with root package name */
        int f2440d;

        /* renamed from: e  reason: collision with root package name */
        int f2441e;

        /* renamed from: f  reason: collision with root package name */
        int f2442f;

        /* renamed from: g  reason: collision with root package name */
        f.b f2443g;

        /* renamed from: h  reason: collision with root package name */
        f.b f2444h;

        a() {
        }

        a(int i5, Fragment fragment) {
            this.f2437a = i5;
            this.f2438b = fragment;
            f.b bVar = f.b.RESUMED;
            this.f2443g = bVar;
            this.f2444h = bVar;
        }
    }

    w(j jVar, ClassLoader classLoader) {
        this.f2418a = jVar;
        this.f2419b = classLoader;
    }

    public w b(int i5, Fragment fragment, String str) {
        j(i5, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public w c(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return b(viewGroup.getId(), fragment, str);
    }

    public w d(Fragment fragment, String str) {
        j(0, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void e(a aVar) {
        this.f2420c.add(aVar);
        aVar.f2439c = this.f2421d;
        aVar.f2440d = this.f2422e;
        aVar.f2441e = this.f2423f;
        aVar.f2442f = this.f2424g;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public w i() {
        if (!this.f2426i) {
            this.f2427j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* access modifiers changed from: package-private */
    public void j(int i5, Fragment fragment, String str, int i6) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 == null || str.equals(str2)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i5 != 0) {
            if (i5 != -1) {
                int i7 = fragment.mFragmentId;
                if (i7 == 0 || i7 == i5) {
                    fragment.mFragmentId = i5;
                    fragment.mContainerId = i5;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i5);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        e(new a(i6, fragment));
    }

    public w k(Fragment fragment) {
        e(new a(3, fragment));
        return this;
    }

    public w l(boolean z4) {
        this.f2435r = z4;
        return this;
    }
}
