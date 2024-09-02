package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.g1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class e implements o.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    private final Context f868a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f869b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f870c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f871d;

    /* renamed from: e  reason: collision with root package name */
    private a f872e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<g> f873f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<g> f874g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f875h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<g> f876i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<g> f877j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f878k;

    /* renamed from: l  reason: collision with root package name */
    private int f879l = 0;

    /* renamed from: m  reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f880m;

    /* renamed from: n  reason: collision with root package name */
    CharSequence f881n;

    /* renamed from: o  reason: collision with root package name */
    Drawable f882o;

    /* renamed from: p  reason: collision with root package name */
    View f883p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f884q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f885r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f886s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f887t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f888u = false;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList<g> f889v = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<j>> f890w = new CopyOnWriteArrayList<>();

    /* renamed from: x  reason: collision with root package name */
    private g f891x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f892y = false;

    /* renamed from: z  reason: collision with root package name */
    private boolean f893z;

    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.f868a = context;
        this.f869b = context.getResources();
        this.f873f = new ArrayList<>();
        this.f874g = new ArrayList<>();
        this.f875h = true;
        this.f876i = new ArrayList<>();
        this.f877j = new ArrayList<>();
        this.f878k = true;
        b0(true);
    }

    private static int B(int i5) {
        int i6 = (-65536 & i5) >> 16;
        if (i6 >= 0) {
            int[] iArr = A;
            if (i6 < iArr.length) {
                return (i5 & 65535) | (iArr[i6] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void N(int i5, boolean z4) {
        if (i5 >= 0 && i5 < this.f873f.size()) {
            this.f873f.remove(i5);
            if (z4) {
                K(true);
            }
        }
    }

    private void W(int i5, CharSequence charSequence, int i6, Drawable drawable, View view) {
        Resources C = C();
        if (view != null) {
            this.f883p = view;
            this.f881n = null;
            this.f882o = null;
        } else {
            if (i5 > 0) {
                this.f881n = C.getText(i5);
            } else if (charSequence != null) {
                this.f881n = charSequence;
            }
            if (i6 > 0) {
                this.f882o = androidx.core.content.a.c(u(), i6);
            } else if (drawable != null) {
                this.f882o = drawable;
            }
            this.f883p = null;
        }
        K(false);
    }

    private void b0(boolean z4) {
        boolean z5 = true;
        if (!z4 || this.f869b.getConfiguration().keyboard == 1 || !g1.b(ViewConfiguration.get(this.f868a), this.f868a)) {
            z5 = false;
        }
        this.f871d = z5;
    }

    private g g(int i5, int i6, int i7, int i8, CharSequence charSequence, int i9) {
        return new g(this, i5, i6, i7, i8, charSequence, i9);
    }

    private void i(boolean z4) {
        if (!this.f890w.isEmpty()) {
            d0();
            Iterator<WeakReference<j>> it = this.f890w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                j jVar = (j) next.get();
                if (jVar == null) {
                    this.f890w.remove(next);
                } else {
                    jVar.e(z4);
                }
            }
            c0();
        }
    }

    private boolean j(m mVar, j jVar) {
        boolean z4 = false;
        if (this.f890w.isEmpty()) {
            return false;
        }
        if (jVar != null) {
            z4 = jVar.d(mVar);
        }
        Iterator<WeakReference<j>> it = this.f890w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            j jVar2 = (j) next.get();
            if (jVar2 == null) {
                this.f890w.remove(next);
            } else if (!z4) {
                z4 = jVar2.d(mVar);
            }
        }
        return z4;
    }

    private static int n(ArrayList<g> arrayList, int i5) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i5) {
                return size + 1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.f887t;
    }

    /* access modifiers changed from: package-private */
    public Resources C() {
        return this.f869b;
    }

    public e D() {
        return this;
    }

    public ArrayList<g> E() {
        if (!this.f875h) {
            return this.f874g;
        }
        this.f874g.clear();
        int size = this.f873f.size();
        for (int i5 = 0; i5 < size; i5++) {
            g gVar = this.f873f.get(i5);
            if (gVar.isVisible()) {
                this.f874g.add(gVar);
            }
        }
        this.f875h = false;
        this.f878k = true;
        return this.f874g;
    }

    public boolean F() {
        return this.f892y;
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        return this.f870c;
    }

    public boolean H() {
        return this.f871d;
    }

    /* access modifiers changed from: package-private */
    public void I(g gVar) {
        this.f878k = true;
        K(true);
    }

    /* access modifiers changed from: package-private */
    public void J(g gVar) {
        this.f875h = true;
        K(true);
    }

    public void K(boolean z4) {
        if (!this.f884q) {
            if (z4) {
                this.f875h = true;
                this.f878k = true;
            }
            i(z4);
            return;
        }
        this.f885r = true;
        if (z4) {
            this.f886s = true;
        }
    }

    public boolean L(MenuItem menuItem, int i5) {
        return M(menuItem, (j) null, i5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r1 != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if ((r9 & 1) == 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        if (r1 == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean M(android.view.MenuItem r7, androidx.appcompat.view.menu.j r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.g r7 = (androidx.appcompat.view.menu.g) r7
            r0 = 0
            if (r7 == 0) goto L_0x006c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto L_0x000c
            goto L_0x006c
        L_0x000c:
            boolean r1 = r7.k()
            androidx.core.view.b r2 = r7.b()
            r3 = 1
            if (r2 == 0) goto L_0x001f
            boolean r4 = r2.a()
            if (r4 == 0) goto L_0x001f
            r4 = r3
            goto L_0x0020
        L_0x001f:
            r4 = r0
        L_0x0020:
            boolean r5 = r7.j()
            if (r5 == 0) goto L_0x0031
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L_0x006b
        L_0x002d:
            r6.e(r3)
            goto L_0x006b
        L_0x0031:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L_0x003f
            if (r4 == 0) goto L_0x003a
            goto L_0x003f
        L_0x003a:
            r7 = r9 & 1
            if (r7 != 0) goto L_0x006b
            goto L_0x002d
        L_0x003f:
            r9 = r9 & 4
            if (r9 != 0) goto L_0x0046
            r6.e(r0)
        L_0x0046:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L_0x0058
            androidx.appcompat.view.menu.m r9 = new androidx.appcompat.view.menu.m
            android.content.Context r0 = r6.u()
            r9.<init>(r0, r6, r7)
            r7.x(r9)
        L_0x0058:
            android.view.SubMenu r7 = r7.getSubMenu()
            androidx.appcompat.view.menu.m r7 = (androidx.appcompat.view.menu.m) r7
            if (r4 == 0) goto L_0x0063
            r2.f(r7)
        L_0x0063:
            boolean r7 = r6.j(r7, r8)
            r1 = r1 | r7
            if (r1 != 0) goto L_0x006b
            goto L_0x002d
        L_0x006b:
            return r1
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.M(android.view.MenuItem, androidx.appcompat.view.menu.j, int):boolean");
    }

    public void O(j jVar) {
        Iterator<WeakReference<j>> it = this.f890w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            j jVar2 = (j) next.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.f890w.remove(next);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(t());
            int size = size();
            for (int i5 = 0; i5 < size; i5++) {
                MenuItem item = getItem(i5);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((m) item.getSubMenu()).P(bundle);
                }
            }
            int i6 = bundle.getInt("android:menu:expandedactionview");
            if (i6 > 0 && (findItem = findItem(i6)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = getItem(i5);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(a aVar) {
        this.f872e = aVar;
    }

    public e S(int i5) {
        this.f879l = i5;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void T(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f873f.size();
        d0();
        for (int i5 = 0; i5 < size; i5++) {
            g gVar = this.f873f.get(i5);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        c0();
    }

    /* access modifiers changed from: protected */
    public e U(int i5) {
        W(0, (CharSequence) null, i5, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public e V(Drawable drawable) {
        W(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public e X(int i5) {
        W(i5, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public e Y(CharSequence charSequence) {
        W(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public e Z(View view) {
        W(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i5, int i6, int i7, CharSequence charSequence) {
        int B = B(i7);
        g g5 = g(i5, i6, i7, B, charSequence, this.f879l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f880m;
        if (contextMenuInfo != null) {
            g5.v(contextMenuInfo);
        }
        ArrayList<g> arrayList = this.f873f;
        arrayList.add(n(arrayList, B), g5);
        K(true);
        return g5;
    }

    public void a0(boolean z4) {
        this.f893z = z4;
    }

    public MenuItem add(int i5) {
        return a(0, 0, 0, this.f869b.getString(i5));
    }

    public MenuItem add(int i5, int i6, int i7, int i8) {
        return a(i5, i6, i7, this.f869b.getString(i8));
    }

    public MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        return a(i5, i6, i7, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        int i9;
        PackageManager packageManager = this.f868a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i8 & 1) == 0) {
            removeGroup(i5);
        }
        for (int i10 = 0; i10 < size; i10++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i10);
            int i11 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i11 < 0 ? intent : intentArr[i11]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i5, i6, i7, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i9 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i9] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i5) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f869b.getString(i5));
    }

    public SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return addSubMenu(i5, i6, i7, (CharSequence) this.f869b.getString(i8));
    }

    public SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        g gVar = (g) a(i5, i6, i7, charSequence);
        m mVar = new m(this.f868a, this, gVar);
        gVar.x(mVar);
        return mVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(j jVar) {
        c(jVar, this.f868a);
    }

    public void c(j jVar, Context context) {
        this.f890w.add(new WeakReference(jVar));
        jVar.c(context, this);
        this.f878k = true;
    }

    public void c0() {
        this.f884q = false;
        if (this.f885r) {
            this.f885r = false;
            K(this.f886s);
        }
    }

    public void clear() {
        g gVar = this.f891x;
        if (gVar != null) {
            f(gVar);
        }
        this.f873f.clear();
        K(true);
    }

    public void clearHeader() {
        this.f882o = null;
        this.f881n = null;
        this.f883p = null;
        K(false);
    }

    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f872e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        if (!this.f884q) {
            this.f884q = true;
            this.f885r = false;
            this.f886s = false;
        }
    }

    public final void e(boolean z4) {
        if (!this.f888u) {
            this.f888u = true;
            Iterator<WeakReference<j>> it = this.f890w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                j jVar = (j) next.get();
                if (jVar == null) {
                    this.f890w.remove(next);
                } else {
                    jVar.a(this, z4);
                }
            }
            this.f888u = false;
        }
    }

    public boolean f(g gVar) {
        boolean z4 = false;
        if (!this.f890w.isEmpty() && this.f891x == gVar) {
            d0();
            Iterator<WeakReference<j>> it = this.f890w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                j jVar = (j) next.get();
                if (jVar == null) {
                    this.f890w.remove(next);
                } else {
                    z4 = jVar.h(this, gVar);
                    if (z4) {
                        break;
                    }
                }
            }
            c0();
            if (z4) {
                this.f891x = null;
            }
        }
        return z4;
    }

    public MenuItem findItem(int i5) {
        MenuItem findItem;
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = this.f873f.get(i6);
            if (gVar.getItemId() == i5) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (findItem = gVar.getSubMenu().findItem(i5)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public MenuItem getItem(int i5) {
        return this.f873f.get(i5);
    }

    /* access modifiers changed from: package-private */
    public boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.f872e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    public boolean hasVisibleItems() {
        if (this.f893z) {
            return true;
        }
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f873f.get(i5).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        return p(i5, keyEvent) != null;
    }

    public boolean k(g gVar) {
        boolean z4 = false;
        if (this.f890w.isEmpty()) {
            return false;
        }
        d0();
        Iterator<WeakReference<j>> it = this.f890w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            j jVar = (j) next.get();
            if (jVar == null) {
                this.f890w.remove(next);
            } else {
                z4 = jVar.i(this, gVar);
                if (z4) {
                    break;
                }
            }
        }
        c0();
        if (z4) {
            this.f891x = gVar;
        }
        return z4;
    }

    public int l(int i5) {
        return m(i5, 0);
    }

    public int m(int i5, int i6) {
        int size = size();
        if (i6 < 0) {
            i6 = 0;
        }
        while (i6 < size) {
            if (this.f873f.get(i6).getGroupId() == i5) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public int o(int i5) {
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            if (this.f873f.get(i6).getItemId() == i5) {
                return i6;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public g p(int i5, KeyEvent keyEvent) {
        ArrayList<g> arrayList = this.f889v;
        arrayList.clear();
        q(arrayList, i5, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean G = G();
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = arrayList.get(i6);
            char alphabeticShortcut = G ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (G && alphabeticShortcut == 8 && i5 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i5, int i6) {
        return L(findItem(i5), i6);
    }

    public boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        g p5 = p(i5, keyEvent);
        boolean L = p5 != null ? L(p5, i6) : false;
        if ((i6 & 2) != 0) {
            e(true);
        }
        return L;
    }

    /* access modifiers changed from: package-private */
    public void q(List<g> list, int i5, KeyEvent keyEvent) {
        boolean G = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i5 == 67) {
            int size = this.f873f.size();
            for (int i6 = 0; i6 < size; i6++) {
                g gVar = this.f873f.get(i6);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).q(list, i5, keyEvent);
                }
                char alphabeticShortcut = G ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if (((modifiers & 69647) == ((G ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (G && alphabeticShortcut == 8 && i5 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList<g> E = E();
        if (this.f878k) {
            Iterator<WeakReference<j>> it = this.f890w.iterator();
            boolean z4 = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                j jVar = (j) next.get();
                if (jVar == null) {
                    this.f890w.remove(next);
                } else {
                    z4 |= jVar.g();
                }
            }
            if (z4) {
                this.f876i.clear();
                this.f877j.clear();
                int size = E.size();
                for (int i5 = 0; i5 < size; i5++) {
                    g gVar = E.get(i5);
                    (gVar.l() ? this.f876i : this.f877j).add(gVar);
                }
            } else {
                this.f876i.clear();
                this.f877j.clear();
                this.f877j.addAll(E());
            }
            this.f878k = false;
        }
    }

    public void removeGroup(int i5) {
        int l5 = l(i5);
        if (l5 >= 0) {
            int size = this.f873f.size() - l5;
            int i6 = 0;
            while (true) {
                int i7 = i6 + 1;
                if (i6 >= size || this.f873f.get(l5).getGroupId() != i5) {
                    K(true);
                } else {
                    N(l5, false);
                    i6 = i7;
                }
            }
            K(true);
        }
    }

    public void removeItem(int i5) {
        N(o(i5), true);
    }

    public ArrayList<g> s() {
        r();
        return this.f876i;
    }

    public void setGroupCheckable(int i5, boolean z4, boolean z5) {
        int size = this.f873f.size();
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = this.f873f.get(i6);
            if (gVar.getGroupId() == i5) {
                gVar.t(z5);
                gVar.setCheckable(z4);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z4) {
        this.f892y = z4;
    }

    public void setGroupEnabled(int i5, boolean z4) {
        int size = this.f873f.size();
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = this.f873f.get(i6);
            if (gVar.getGroupId() == i5) {
                gVar.setEnabled(z4);
            }
        }
    }

    public void setGroupVisible(int i5, boolean z4) {
        int size = this.f873f.size();
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = this.f873f.get(i6);
            if (gVar.getGroupId() == i5 && gVar.y(z4)) {
                z5 = true;
            }
        }
        if (z5) {
            K(true);
        }
    }

    public void setQwertyMode(boolean z4) {
        this.f870c = z4;
        K(false);
    }

    public int size() {
        return this.f873f.size();
    }

    /* access modifiers changed from: protected */
    public String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f868a;
    }

    public g v() {
        return this.f891x;
    }

    public Drawable w() {
        return this.f882o;
    }

    public CharSequence x() {
        return this.f881n;
    }

    public View y() {
        return this.f883p;
    }

    public ArrayList<g> z() {
        r();
        return this.f877j;
    }
}
