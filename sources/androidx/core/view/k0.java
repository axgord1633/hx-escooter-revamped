package androidx.core.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.a;
import androidx.core.view.o1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class k0 {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f1932a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private static WeakHashMap<View, k1> f1933b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Field f1934c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f1935d = false;

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f1936e = {n.b.f5940b, n.b.f5941c, n.b.f5952n, n.b.f5963y, n.b.B, n.b.C, n.b.D, n.b.E, n.b.F, n.b.G, n.b.f5942d, n.b.f5943e, n.b.f5944f, n.b.f5945g, n.b.f5946h, n.b.f5947i, n.b.f5948j, n.b.f5949k, n.b.f5950l, n.b.f5951m, n.b.f5953o, n.b.f5954p, n.b.f5955q, n.b.f5956r, n.b.f5957s, n.b.f5958t, n.b.f5959u, n.b.f5960v, n.b.f5961w, n.b.f5962x, n.b.f5964z, n.b.A};

    /* renamed from: f  reason: collision with root package name */
    private static final h0 f1937f = new j0();

    /* renamed from: g  reason: collision with root package name */
    private static final e f1938g = new e();

    class a extends f<Boolean> {
        a(int i5, Class cls, int i6) {
            super(i5, cls, i6);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public Boolean c(View view) {
            return Boolean.valueOf(o.d(view));
        }
    }

    class b extends f<CharSequence> {
        b(int i5, Class cls, int i6, int i7) {
            super(i5, cls, i6, i7);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public CharSequence c(View view) {
            return o.b(view);
        }
    }

    class c extends f<CharSequence> {
        c(int i5, Class cls, int i6, int i7) {
            super(i5, cls, i6, i7);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public CharSequence c(View view) {
            return q.a(view);
        }
    }

    class d extends f<Boolean> {
        d(int i5, Class cls, int i6) {
            super(i5, cls, i6);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public Boolean c(View view) {
            return Boolean.valueOf(o.c(view));
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: e  reason: collision with root package name */
        private final WeakHashMap<View, Boolean> f1939e = new WeakHashMap<>();

        e() {
        }

        private void a(View view, boolean z4) {
            boolean z5 = view.isShown() && view.getWindowVisibility() == 0;
            if (z4 != z5) {
                k0.E(view, z5 ? 16 : 32);
                this.f1939e.put(view, Boolean.valueOf(z5));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry next : this.f1939e.entrySet()) {
                    a((View) next.getKey(), ((Boolean) next.getValue()).booleanValue());
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f1940a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f1941b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1942c;

        /* renamed from: d  reason: collision with root package name */
        private final int f1943d;

        f(int i5, Class<T> cls, int i6) {
            this(i5, cls, 0, i6);
        }

        f(int i5, Class<T> cls, int i6, int i7) {
            this.f1940a = i5;
            this.f1941b = cls;
            this.f1943d = i6;
            this.f1942c = i7;
        }

        private boolean a() {
            return true;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.f1942c;
        }

        /* access modifiers changed from: package-private */
        public abstract T c(View view);

        /* access modifiers changed from: package-private */
        public T d(View view) {
            if (b()) {
                return c(view);
            }
            if (!a()) {
                return null;
            }
            T tag = view.getTag(this.f1940a);
            if (this.f1941b.isInstance(tag)) {
                return tag;
            }
            return null;
        }
    }

    static class g {
        static boolean a(View view) {
            return view.hasOnClickListeners();
        }
    }

    static class h {
        static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        static int c(View view) {
            return view.getImportantForAccessibility();
        }

        static int d(View view) {
            return view.getMinimumHeight();
        }

        static int e(View view) {
            return view.getMinimumWidth();
        }

        static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        static boolean i(View view) {
            return view.hasTransientState();
        }

        static boolean j(View view, int i5, Bundle bundle) {
            return view.performAccessibilityAction(i5, bundle);
        }

        static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        static void l(View view, int i5, int i6, int i7, int i8) {
            view.postInvalidateOnAnimation(i5, i6, i7, i8);
        }

        static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        static void n(View view, Runnable runnable, long j5) {
            view.postOnAnimationDelayed(runnable, j5);
        }

        static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        static void p(View view) {
            view.requestFitSystemWindows();
        }

        static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        static void r(View view, boolean z4) {
            view.setHasTransientState(z4);
        }

        static void s(View view, int i5) {
            view.setImportantForAccessibility(i5);
        }
    }

    static class i {
        static int a() {
            return View.generateViewId();
        }

        static Display b(View view) {
            return view.getDisplay();
        }

        static int c(View view) {
            return view.getLabelFor();
        }

        static int d(View view) {
            return view.getLayoutDirection();
        }

        static int e(View view) {
            return view.getPaddingEnd();
        }

        static int f(View view) {
            return view.getPaddingStart();
        }

        static boolean g(View view) {
            return view.isPaddingRelative();
        }

        static void h(View view, int i5) {
            view.setLabelFor(i5);
        }

        static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        static void j(View view, int i5) {
            view.setLayoutDirection(i5);
        }

        static void k(View view, int i5, int i6, int i7, int i8) {
            view.setPaddingRelative(i5, i6, i7, i8);
        }
    }

    static class j {
        static Rect a(View view) {
            return view.getClipBounds();
        }

        static boolean b(View view) {
            return view.isInLayout();
        }

        static void c(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static class k {
        static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        static boolean b(View view) {
            return view.isAttachedToWindow();
        }

        static boolean c(View view) {
            return view.isLaidOut();
        }

        static boolean d(View view) {
            return view.isLayoutDirectionResolved();
        }

        static void e(ViewParent viewParent, View view, View view2, int i5) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i5);
        }

        static void f(View view, int i5) {
            view.setAccessibilityLiveRegion(i5);
        }

        static void g(AccessibilityEvent accessibilityEvent, int i5) {
            accessibilityEvent.setContentChangeTypes(i5);
        }
    }

    static class l {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    private static class m {

        class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            o1 f1944a = null;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f1945b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ f0 f1946c;

            a(View view, f0 f0Var) {
                this.f1945b = view;
                this.f1946c = f0Var;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                o1 w4 = o1.w(windowInsets, view);
                int i5 = Build.VERSION.SDK_INT;
                if (i5 < 30) {
                    m.a(windowInsets, this.f1945b);
                    if (w4.equals(this.f1944a)) {
                        return this.f1946c.a(view, w4).u();
                    }
                }
                this.f1944a = w4;
                o1 a5 = this.f1946c.a(view, w4);
                if (i5 >= 30) {
                    return a5.u();
                }
                k0.L(view);
                return a5.u();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(n.b.S);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static o1 b(View view, o1 o1Var, Rect rect) {
            WindowInsets u5 = o1Var.u();
            if (u5 != null) {
                return o1.w(view.computeSystemWindowInsets(u5, rect), view);
            }
            rect.setEmpty();
            return o1Var;
        }

        static boolean c(View view, float f5, float f6, boolean z4) {
            return view.dispatchNestedFling(f5, f6, z4);
        }

        static boolean d(View view, float f5, float f6) {
            return view.dispatchNestedPreFling(f5, f6);
        }

        static boolean e(View view, int i5, int i6, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i5, i6, iArr, iArr2);
        }

        static boolean f(View view, int i5, int i6, int i7, int i8, int[] iArr) {
            return view.dispatchNestedScroll(i5, i6, i7, i8, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static o1 j(View view) {
            return o1.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f5) {
            view.setElevation(f5);
        }

        static void t(View view, boolean z4) {
            view.setNestedScrollingEnabled(z4);
        }

        static void u(View view, f0 f0Var) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(n.b.L, f0Var);
            }
            if (f0Var == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(n.b.S));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, f0Var));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f5) {
            view.setTranslationZ(f5);
        }

        static void x(View view, float f5) {
            view.setZ(f5);
        }

        static boolean y(View view, int i5) {
            return view.startNestedScroll(i5);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    private static class n {
        public static o1 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            o1 v5 = o1.v(rootWindowInsets);
            v5.s(v5);
            v5.d(view.getRootView());
            return v5;
        }

        static int b(View view) {
            return view.getScrollIndicators();
        }

        static void c(View view, int i5) {
            view.setScrollIndicators(i5);
        }

        static void d(View view, int i5, int i6) {
            view.setScrollIndicators(i5, i6);
        }
    }

    static class o {
        static void a(View view, t tVar) {
            int i5 = n.b.R;
            m.g gVar = (m.g) view.getTag(i5);
            if (gVar == null) {
                gVar = new m.g();
                view.setTag(i5, gVar);
            }
            Objects.requireNonNull(tVar);
            u0 u0Var = new u0(tVar);
            gVar.put(tVar, u0Var);
            view.addOnUnhandledKeyEventListener(u0Var);
        }

        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        static void e(View view, t tVar) {
            View$OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener;
            m.g gVar = (m.g) view.getTag(n.b.R);
            if (gVar != null && (view$OnUnhandledKeyEventListener = (View$OnUnhandledKeyEventListener) gVar.get(tVar)) != null) {
                view.removeOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener);
            }
        }

        static <T> T f(View view, int i5) {
            return view.requireViewById(i5);
        }

        static void g(View view, boolean z4) {
            view.setAccessibilityHeading(z4);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        static void i(View view, boolean z4) {
            view.setScreenReaderFocusable(z4);
        }
    }

    private static class p {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static List<Rect> b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void c(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i5, int i6) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i5, i6);
        }

        static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    private static class q {
        static CharSequence a(View view) {
            return view.getStateDescription();
        }

        static void b(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    private static final class r {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static c b(View view, c cVar) {
            ContentInfo f5 = cVar.f();
            ContentInfo a5 = view.performReceiveContent(f5);
            if (a5 == null) {
                return null;
            }
            return a5 == f5 ? cVar : c.g(a5);
        }

        public static void c(View view, String[] strArr, g0 g0Var) {
            if (g0Var == null) {
                view.setOnReceiveContentListener(strArr, (OnReceiveContentListener) null);
            } else {
                view.setOnReceiveContentListener(strArr, new s(g0Var));
            }
        }
    }

    private static final class s implements OnReceiveContentListener {

        /* renamed from: a  reason: collision with root package name */
        private final g0 f1947a;

        s(g0 g0Var) {
            this.f1947a = g0Var;
        }

        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            c g5 = c.g(contentInfo);
            c a5 = this.f1947a.a(view, g5);
            if (a5 == null) {
                return null;
            }
            return a5 == g5 ? contentInfo : a5.f();
        }
    }

    public interface t {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    static class u {

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f1948d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f1949a = null;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f1950b = null;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<KeyEvent> f1951c = null;

        u() {
        }

        static u a(View view) {
            int i5 = n.b.Q;
            u uVar = (u) view.getTag(i5);
            if (uVar != null) {
                return uVar;
            }
            u uVar2 = new u();
            view.setTag(i5, uVar2);
            return uVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f1949a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c5 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c5 != null) {
                            return c5;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f1950b == null) {
                this.f1950b = new SparseArray<>();
            }
            return this.f1950b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(n.b.R);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((t) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f1949a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f1948d;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    if (this.f1949a == null) {
                        this.f1949a = new WeakHashMap<>();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList<WeakReference<View>> arrayList2 = f1948d;
                        View view = (View) arrayList2.get(size).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f1949a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f1949a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c5 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c5 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(c5));
                }
            }
            return c5 != null;
        }

        /* access modifiers changed from: package-private */
        public boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f1951c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f1951c = new WeakReference<>(keyEvent);
            WeakReference weakReference2 = null;
            SparseArray<WeakReference<View>> d5 = d();
            if (keyEvent.getAction() == 1 && (indexOfKey = d5.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = d5.valueAt(indexOfKey);
                d5.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = d5.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = (View) weakReference2.get();
            if (view != null && k0.A(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    public static boolean A(View view) {
        return k.b(view);
    }

    public static boolean B(View view) {
        return k.c(view);
    }

    public static boolean C(View view) {
        Boolean d5 = N().d(view);
        return d5 != null && d5.booleanValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ c D(c cVar) {
        return cVar;
    }

    static void E(View view, int i5) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z4 = k(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            int i6 = 32;
            if (j(view) != 0 || z4) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z4) {
                    i6 = 2048;
                }
                obtain.setEventType(i6);
                k.g(obtain, i5);
                if (z4) {
                    obtain.getText().add(k(view));
                    Z(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i5 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                k.g(obtain2, i5);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(k(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    k.e(view.getParent(), view, view, i5);
                } catch (AbstractMethodError e5) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e5);
                }
            }
        }
    }

    public static o1 F(View view, o1 o1Var) {
        WindowInsets u5 = o1Var.u();
        if (u5 != null) {
            WindowInsets b5 = l.b(view, u5);
            if (!b5.equals(u5)) {
                return o1.w(b5, view);
            }
        }
        return o1Var;
    }

    private static f<CharSequence> G() {
        return new b(n.b.K, CharSequence.class, 8, 28);
    }

    public static c H(View view, c cVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + cVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return r.b(view, cVar);
        }
        g0 g0Var = (g0) view.getTag(n.b.M);
        if (g0Var == null) {
            return o(view).a(cVar);
        }
        c a5 = g0Var.a(view, cVar);
        if (a5 == null) {
            return null;
        }
        return o(view).a(a5);
    }

    public static void I(View view) {
        h.k(view);
    }

    public static void J(View view, Runnable runnable) {
        h.m(view, runnable);
    }

    public static void K(View view, Runnable runnable, long j5) {
        h.n(view, runnable, j5);
    }

    public static void L(View view) {
        l.c(view);
    }

    public static void M(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i5, int i6) {
        if (Build.VERSION.SDK_INT >= 29) {
            p.c(view, context, iArr, attributeSet, typedArray, i5, i6);
        }
    }

    private static f<Boolean> N() {
        return new a(n.b.O, Boolean.class, 28);
    }

    public static void O(View view, a aVar) {
        if (aVar == null && (h(view) instanceof a.C0030a)) {
            aVar = new a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    public static void P(View view, Drawable drawable) {
        h.q(view, drawable);
    }

    public static void Q(View view, ColorStateList colorStateList) {
        m.q(view, colorStateList);
    }

    public static void R(View view, PorterDuff.Mode mode) {
        m.r(view, mode);
    }

    public static void S(View view, Rect rect) {
        j.c(view, rect);
    }

    public static void T(View view, float f5) {
        m.s(view, f5);
    }

    public static void U(View view, boolean z4) {
        h.r(view, z4);
    }

    public static void V(View view, int i5) {
        h.s(view, i5);
    }

    public static void W(View view, f0 f0Var) {
        m.u(view, f0Var);
    }

    public static void X(View view, int i5, int i6) {
        n.d(view, i5, i6);
    }

    public static void Y(View view, String str) {
        m.v(view, str);
    }

    private static void Z(View view) {
        if (p(view) == 0) {
            V(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (p((View) parent) == 4) {
                V(view, 2);
                return;
            }
        }
    }

    private static f<CharSequence> a0() {
        return new c(n.b.P, CharSequence.class, 64, 30);
    }

    private static f<Boolean> b() {
        return new d(n.b.J, Boolean.class, 28);
    }

    public static void b0(View view) {
        m.z(view);
    }

    public static k1 c(View view) {
        if (f1933b == null) {
            f1933b = new WeakHashMap<>();
        }
        k1 k1Var = f1933b.get(view);
        if (k1Var != null) {
            return k1Var;
        }
        k1 k1Var2 = new k1(view);
        f1933b.put(view, k1Var2);
        return k1Var2;
    }

    public static o1 d(View view, o1 o1Var, Rect rect) {
        return m.b(view, o1Var, rect);
    }

    public static o1 e(View view, o1 o1Var) {
        WindowInsets u5 = o1Var.u();
        if (u5 != null) {
            WindowInsets a5 = l.a(view, u5);
            if (!a5.equals(u5)) {
                return o1.w(a5, view);
            }
        }
        return o1Var;
    }

    static boolean f(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return u.a(view).b(view, keyEvent);
    }

    static boolean g(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return u.a(view).f(keyEvent);
    }

    private static View.AccessibilityDelegate h(View view) {
        return Build.VERSION.SDK_INT >= 29 ? p.a(view) : i(view);
    }

    private static View.AccessibilityDelegate i(View view) {
        if (f1935d) {
            return null;
        }
        if (f1934c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f1934c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1935d = true;
                return null;
            }
        }
        try {
            Object obj = f1934c.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f1935d = true;
            return null;
        }
    }

    public static int j(View view) {
        return k.a(view);
    }

    public static CharSequence k(View view) {
        return G().d(view);
    }

    public static ColorStateList l(View view) {
        return m.g(view);
    }

    public static PorterDuff.Mode m(View view) {
        return m.h(view);
    }

    public static Rect n(View view) {
        return j.a(view);
    }

    private static h0 o(View view) {
        return view instanceof h0 ? (h0) view : f1937f;
    }

    public static int p(View view) {
        return h.c(view);
    }

    public static int q(View view) {
        return i.d(view);
    }

    public static int r(View view) {
        return h.d(view);
    }

    public static String[] s(View view) {
        return Build.VERSION.SDK_INT >= 31 ? r.a(view) : (String[]) view.getTag(n.b.N);
    }

    public static o1 t(View view) {
        return n.a(view);
    }

    public static CharSequence u(View view) {
        return a0().d(view);
    }

    public static String v(View view) {
        return m.k(view);
    }

    @Deprecated
    public static int w(View view) {
        return h.g(view);
    }

    public static boolean x(View view) {
        return g.a(view);
    }

    public static boolean y(View view) {
        return h.h(view);
    }

    public static boolean z(View view) {
        Boolean d5 = b().d(view);
        return d5 != null && d5.booleanValue();
    }
}
