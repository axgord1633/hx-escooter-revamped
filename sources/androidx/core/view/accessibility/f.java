package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.i;
import com.yalantis.ucrop.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class f {

    /* renamed from: d  reason: collision with root package name */
    private static int f1855d;

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f1856a;

    /* renamed from: b  reason: collision with root package name */
    public int f1857b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f1858c = -1;

    public static class a {
        public static final a A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
        public static final a B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, (CharSequence) null, (i) null, i.e.class);
        public static final a C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 16908344, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
        public static final a D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
        public static final a E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
        public static final a F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;
        public static final a R;
        public static final a S;
        public static final a T;
        public static final a U;

        /* renamed from: e  reason: collision with root package name */
        public static final a f1859e = new a(1, (CharSequence) null);

        /* renamed from: f  reason: collision with root package name */
        public static final a f1860f = new a(2, (CharSequence) null);

        /* renamed from: g  reason: collision with root package name */
        public static final a f1861g = new a(4, (CharSequence) null);

        /* renamed from: h  reason: collision with root package name */
        public static final a f1862h = new a(8, (CharSequence) null);

        /* renamed from: i  reason: collision with root package name */
        public static final a f1863i = new a(16, (CharSequence) null);

        /* renamed from: j  reason: collision with root package name */
        public static final a f1864j = new a(32, (CharSequence) null);

        /* renamed from: k  reason: collision with root package name */
        public static final a f1865k = new a(64, (CharSequence) null);

        /* renamed from: l  reason: collision with root package name */
        public static final a f1866l = new a(128, (CharSequence) null);

        /* renamed from: m  reason: collision with root package name */
        public static final a f1867m;

        /* renamed from: n  reason: collision with root package name */
        public static final a f1868n;

        /* renamed from: o  reason: collision with root package name */
        public static final a f1869o;

        /* renamed from: p  reason: collision with root package name */
        public static final a f1870p;

        /* renamed from: q  reason: collision with root package name */
        public static final a f1871q = new a(4096, (CharSequence) null);

        /* renamed from: r  reason: collision with root package name */
        public static final a f1872r = new a(8192, (CharSequence) null);

        /* renamed from: s  reason: collision with root package name */
        public static final a f1873s = new a(16384, (CharSequence) null);

        /* renamed from: t  reason: collision with root package name */
        public static final a f1874t = new a(32768, (CharSequence) null);

        /* renamed from: u  reason: collision with root package name */
        public static final a f1875u = new a(65536, (CharSequence) null);

        /* renamed from: v  reason: collision with root package name */
        public static final a f1876v = new a(131072, (CharSequence) null, i.g.class);

        /* renamed from: w  reason: collision with root package name */
        public static final a f1877w = new a(262144, (CharSequence) null);

        /* renamed from: x  reason: collision with root package name */
        public static final a f1878x = new a(524288, (CharSequence) null);

        /* renamed from: y  reason: collision with root package name */
        public static final a f1879y = new a(1048576, (CharSequence) null);

        /* renamed from: z  reason: collision with root package name */
        public static final a f1880z = new a(2097152, (CharSequence) null, i.h.class);

        /* renamed from: a  reason: collision with root package name */
        final Object f1881a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1882b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<? extends i.a> f1883c;

        /* renamed from: d  reason: collision with root package name */
        protected final i f1884d;

        static {
            Class<i.c> cls = i.c.class;
            Class<i.b> cls2 = i.b.class;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            f1867m = new a(256, (CharSequence) null, cls2);
            f1868n = new a(512, (CharSequence) null, cls2);
            f1869o = new a(1024, (CharSequence) null, cls);
            f1870p = new a(2048, (CharSequence) null, cls);
            int i5 = Build.VERSION.SDK_INT;
            G = new a(i5 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
            H = new a(i5 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
            I = new a(i5 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
            J = new a(i5 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
            L = new a(i5 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, (CharSequence) null, (i) null, i.f.class);
            M = new a(i5 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, (CharSequence) null, (i) null, i.d.class);
            N = new a(i5 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
            O = new a(i5 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
            P = new a(i5 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
            Q = new a(i5 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
            R = new a(i5 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, 16908373, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
            S = new a(i5 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, 16908374, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
            T = new a(i5 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, 16908375, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
            if (i5 >= 33) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            }
            U = new a(accessibilityAction, 16908376, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
        }

        public a(int i5, CharSequence charSequence) {
            this((Object) null, i5, charSequence, (i) null, (Class<? extends i.a>) null);
        }

        private a(int i5, CharSequence charSequence, Class<? extends i.a> cls) {
            this((Object) null, i5, charSequence, (i) null, cls);
        }

        a(Object obj) {
            this(obj, 0, (CharSequence) null, (i) null, (Class<? extends i.a>) null);
        }

        a(Object obj, int i5, CharSequence charSequence, i iVar, Class<? extends i.a> cls) {
            this.f1882b = i5;
            this.f1884d = iVar;
            this.f1881a = obj == null ? new AccessibilityNodeInfo.AccessibilityAction(i5, charSequence) : obj;
            this.f1883c = cls;
        }

        public int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f1881a).getId();
        }

        public CharSequence b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f1881a).getLabel();
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                androidx.core.view.accessibility.i r0 = r4.f1884d
                r1 = 0
                if (r0 == 0) goto L_0x0049
                r0 = 0
                java.lang.Class<? extends androidx.core.view.accessibility.i$a> r2 = r4.f1883c
                if (r2 == 0) goto L_0x0042
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r1 = r2.newInstance(r1)     // Catch:{ Exception -> 0x0020 }
                androidx.core.view.accessibility.i$a r1 = (androidx.core.view.accessibility.i.a) r1     // Catch:{ Exception -> 0x0020 }
                r1.a(r6)     // Catch:{ Exception -> 0x001d }
                r0 = r1
                goto L_0x0042
            L_0x001d:
                r6 = move-exception
                r0 = r1
                goto L_0x0021
            L_0x0020:
                r6 = move-exception
            L_0x0021:
                java.lang.Class<? extends androidx.core.view.accessibility.i$a> r1 = r4.f1883c
                if (r1 != 0) goto L_0x0028
                java.lang.String r1 = "null"
                goto L_0x002c
            L_0x0028:
                java.lang.String r1 = r1.getName()
            L_0x002c:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.String r2 = "A11yActionCompat"
                android.util.Log.e(r2, r1, r6)
            L_0x0042:
                androidx.core.view.accessibility.i r6 = r4.f1884d
                boolean r5 = r6.a(r5, r0)
                return r5
            L_0x0049:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.accessibility.f.a.c(android.view.View, android.os.Bundle):boolean");
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = this.f1881a;
            Object obj3 = ((a) obj).f1881a;
            return obj2 == null ? obj3 == null : obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f1881a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String g5 = f.g(this.f1882b);
            if (g5.equals("ACTION_UNKNOWN") && b() != null) {
                g5 = b().toString();
            }
            sb.append(g5);
            return sb.toString();
        }
    }

    private static class b {
        public static Bundle a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtras();
        }
    }

    private f(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1856a = accessibilityNodeInfo;
    }

    private void G(View view) {
        SparseArray<WeakReference<ClickableSpan>> p5 = p(view);
        if (p5 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < p5.size(); i5++) {
                if (p5.valueAt(i5).get() == null) {
                    arrayList.add(Integer.valueOf(i5));
                }
            }
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                p5.remove(((Integer) arrayList.get(i6)).intValue());
            }
        }
    }

    private void H(int i5, boolean z4) {
        Bundle m5 = m();
        if (m5 != null) {
            int i6 = m5.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i5);
            if (!z4) {
                i5 = 0;
            }
            m5.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i5 | i6);
        }
    }

    public static f P(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new f(accessibilityNodeInfo);
    }

    private void b(ClickableSpan clickableSpan, Spanned spanned, int i5) {
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i5));
    }

    private void d() {
        b.a(this.f1856a).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        b.a(this.f1856a).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        b.a(this.f1856a).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        b.a(this.f1856a).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List<Integer> e(String str) {
        ArrayList<Integer> integerArrayList = b.a(this.f1856a).getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        b.a(this.f1856a).putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    static String g(int i5) {
        if (i5 == 1) {
            return "ACTION_FOCUS";
        }
        if (i5 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i5) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case R.styleable.AppCompatTheme_actionOverflowButtonStyle /*32*/:
                return "ACTION_LONG_CLICK";
            case R.styleable.AppCompatTheme_dividerHorizontal /*64*/:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i5) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i5) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i5) {
                                    case 16908372:
                                        return "ACTION_IME_ENTER";
                                    case 16908373:
                                        return "ACTION_DRAG_START";
                                    case 16908374:
                                        return "ACTION_DRAG_DROP";
                                    case 16908375:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static ClickableSpan[] k(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> n(View view) {
        SparseArray<WeakReference<ClickableSpan>> p5 = p(view);
        if (p5 != null) {
            return p5;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(n.b.I, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> p(View view) {
        return (SparseArray) view.getTag(n.b.I);
    }

    private boolean t() {
        return !e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int u(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i5 = 0; i5 < sparseArray.size(); i5++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i5).get())) {
                    return sparseArray.keyAt(i5);
                }
            }
        }
        int i6 = f1855d;
        f1855d = i6 + 1;
        return i6;
    }

    public boolean A() {
        return this.f1856a.isFocused();
    }

    public boolean B() {
        return this.f1856a.isLongClickable();
    }

    public boolean C() {
        return this.f1856a.isPassword();
    }

    public boolean D() {
        return this.f1856a.isScrollable();
    }

    public boolean E() {
        return this.f1856a.isSelected();
    }

    public boolean F(int i5, Bundle bundle) {
        return this.f1856a.performAction(i5, bundle);
    }

    public void I(CharSequence charSequence) {
        this.f1856a.setClassName(charSequence);
    }

    public void J(boolean z4) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1856a.setHeading(z4);
        } else {
            H(2, z4);
        }
    }

    public void K(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1856a.setPaneTitle(charSequence);
        } else {
            b.a(this.f1856a).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void L(boolean z4) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1856a.setScreenReaderFocusable(z4);
        } else {
            H(1, z4);
        }
    }

    public void M(boolean z4) {
        this.f1856a.setScrollable(z4);
    }

    public void N(CharSequence charSequence) {
        if (androidx.core.os.a.b()) {
            this.f1856a.setStateDescription(charSequence);
        } else {
            b.a(this.f1856a).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public AccessibilityNodeInfo O() {
        return this.f1856a;
    }

    public void a(a aVar) {
        this.f1856a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f1881a);
    }

    public void c(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            d();
            G(view);
            ClickableSpan[] k5 = k(charSequence);
            if (k5 != null && k5.length > 0) {
                m().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", n.b.f5939a);
                SparseArray<WeakReference<ClickableSpan>> n5 = n(view);
                for (int i5 = 0; i5 < k5.length; i5++) {
                    int u5 = u(k5[i5], n5);
                    n5.put(u5, new WeakReference(k5[i5]));
                    b(k5[i5], (Spanned) charSequence, u5);
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1856a;
        if (accessibilityNodeInfo == null) {
            if (fVar.f1856a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(fVar.f1856a)) {
            return false;
        }
        return this.f1858c == fVar.f1858c && this.f1857b == fVar.f1857b;
    }

    public List<a> f() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f1856a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(new a(actionList.get(i5)));
        }
        return arrayList;
    }

    @Deprecated
    public void h(Rect rect) {
        this.f1856a.getBoundsInParent(rect);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1856a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i(Rect rect) {
        this.f1856a.getBoundsInScreen(rect);
    }

    public CharSequence j() {
        return this.f1856a.getClassName();
    }

    public CharSequence l() {
        return this.f1856a.getContentDescription();
    }

    public Bundle m() {
        return b.a(this.f1856a);
    }

    public CharSequence o() {
        return this.f1856a.getPackageName();
    }

    public CharSequence q() {
        if (!t()) {
            return this.f1856a.getText();
        }
        List<Integer> e5 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> e6 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> e7 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> e8 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f1856a.getText(), 0, this.f1856a.getText().length()));
        for (int i5 = 0; i5 < e5.size(); i5++) {
            spannableString.setSpan(new a(e8.get(i5).intValue(), this, m().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), e5.get(i5).intValue(), e6.get(i5).intValue(), e7.get(i5).intValue());
        }
        return spannableString;
    }

    public String r() {
        return androidx.core.os.a.c() ? this.f1856a.getUniqueId() : b.a(this.f1856a).getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public String s() {
        return this.f1856a.getViewIdResourceName();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        h(rect);
        sb.append("; boundsInParent: " + rect);
        i(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(o());
        sb.append("; className: ");
        sb.append(j());
        sb.append("; text: ");
        sb.append(q());
        sb.append("; contentDescription: ");
        sb.append(l());
        sb.append("; viewId: ");
        sb.append(s());
        sb.append("; uniqueId: ");
        sb.append(r());
        sb.append("; checkable: ");
        sb.append(v());
        sb.append("; checked: ");
        sb.append(w());
        sb.append("; focusable: ");
        sb.append(z());
        sb.append("; focused: ");
        sb.append(A());
        sb.append("; selected: ");
        sb.append(E());
        sb.append("; clickable: ");
        sb.append(x());
        sb.append("; longClickable: ");
        sb.append(B());
        sb.append("; enabled: ");
        sb.append(y());
        sb.append("; password: ");
        sb.append(C());
        sb.append("; scrollable: " + D());
        sb.append("; [");
        List<a> f5 = f();
        for (int i5 = 0; i5 < f5.size(); i5++) {
            a aVar = f5.get(i5);
            String g5 = g(aVar.a());
            if (g5.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                g5 = aVar.b().toString();
            }
            sb.append(g5);
            if (i5 != f5.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean v() {
        return this.f1856a.isCheckable();
    }

    public boolean w() {
        return this.f1856a.isChecked();
    }

    public boolean x() {
        return this.f1856a.isClickable();
    }

    public boolean y() {
        return this.f1856a.isEnabled();
    }

    public boolean z() {
        return this.f1856a.isFocusable();
    }
}
