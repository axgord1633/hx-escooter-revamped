package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.f;
import androidx.core.view.accessibility.g;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final View.AccessibilityDelegate f1848c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    private final View.AccessibilityDelegate f1849a;

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f1850b;

    /* renamed from: androidx.core.view.a$a  reason: collision with other inner class name */
    static final class C0030a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final a f1851a;

        C0030a(a aVar) {
            this.f1851a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f1851a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            g b5 = this.f1851a.b(view);
            if (b5 != null) {
                return (AccessibilityNodeProvider) b5.a();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1851a.f(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            f P = f.P(accessibilityNodeInfo);
            P.L(k0.C(view));
            P.J(k0.z(view));
            P.K(k0.k(view));
            P.N(k0.u(view));
            this.f1851a.g(view, P);
            P.c(accessibilityNodeInfo.getText(), view);
            List<f.a> c5 = a.c(view);
            for (int i5 = 0; i5 < c5.size(); i5++) {
                P.a(c5.get(i5));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1851a.h(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f1851a.i(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
            return this.f1851a.j(view, i5, bundle);
        }

        public void sendAccessibilityEvent(View view, int i5) {
            this.f1851a.l(view, i5);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f1851a.m(view, accessibilityEvent);
        }
    }

    static class b {
        static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i5, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i5, bundle);
        }
    }

    public a() {
        this(f1848c);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f1849a = accessibilityDelegate;
        this.f1850b = new C0030a(this);
    }

    static List<f.a> c(View view) {
        List<f.a> list = (List) view.getTag(n.b.H);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] k5 = f.k(view.createAccessibilityNodeInfo().getText());
            int i5 = 0;
            while (k5 != null && i5 < k5.length) {
                if (clickableSpan.equals(k5[i5])) {
                    return true;
                }
                i5++;
            }
        }
        return false;
    }

    private boolean k(int i5, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(n.b.I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i5)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f1849a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public g b(View view) {
        AccessibilityNodeProvider a5 = b.a(this.f1849a, view);
        if (a5 != null) {
            return new g(a5);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate d() {
        return this.f1850b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f1849a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, f fVar) {
        this.f1849a.onInitializeAccessibilityNodeInfo(view, fVar.O());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f1849a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f1849a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i5, Bundle bundle) {
        List<f.a> c5 = c(view);
        boolean z4 = false;
        int i6 = 0;
        while (true) {
            if (i6 >= c5.size()) {
                break;
            }
            f.a aVar = c5.get(i6);
            if (aVar.a() == i5) {
                z4 = aVar.c(view, bundle);
                break;
            }
            i6++;
        }
        if (!z4) {
            z4 = b.b(this.f1849a, view, i5, bundle);
        }
        return (z4 || i5 != n.b.f5939a || bundle == null) ? z4 : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i5) {
        this.f1849a.sendAccessibilityEvent(view, i5);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f1849a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
