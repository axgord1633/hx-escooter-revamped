package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import java.lang.reflect.Method;

public class z0 extends w0 implements x0 {
    private static Method O;
    private x0 N;

    public static class a extends p0 {

        /* renamed from: s  reason: collision with root package name */
        final int f1482s;

        /* renamed from: t  reason: collision with root package name */
        final int f1483t;

        /* renamed from: u  reason: collision with root package name */
        private x0 f1484u;

        /* renamed from: v  reason: collision with root package name */
        private MenuItem f1485v;

        public a(Context context, boolean z4) {
            super(context, z4);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f1482s = 21;
                this.f1483t = 22;
                return;
            }
            this.f1482s = 22;
            this.f1483t = 21;
        }

        public /* bridge */ /* synthetic */ int d(int i5, int i6, int i7, int i8, int i9) {
            return super.d(i5, i6, i7, i8, i9);
        }

        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i5) {
            return super.e(motionEvent, i5);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i5;
            int pointToPosition;
            int i6;
            if (this.f1484u != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i5 = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    i5 = 0;
                }
                d dVar = (d) adapter;
                g gVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i6 = pointToPosition - i5) >= 0 && i6 < dVar.getCount()) {
                    gVar = dVar.getItem(i6);
                }
                MenuItem menuItem = this.f1485v;
                if (menuItem != gVar) {
                    e b5 = dVar.b();
                    if (menuItem != null) {
                        this.f1484u.d(b5, menuItem);
                    }
                    this.f1485v = gVar;
                    if (gVar != null) {
                        this.f1484u.a(b5, gVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i5, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i5 == this.f1482s) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i5 != this.f1483t) {
                return super.onKeyDown(i5, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                }
                ((d) adapter).b().e(false);
                return true;
            }
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(x0 x0Var) {
            this.f1484u = x0Var;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                O = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public z0(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }

    public void M(Object obj) {
        this.J.setEnterTransition((Transition) obj);
    }

    public void N(Object obj) {
        this.J.setExitTransition((Transition) obj);
    }

    public void O(x0 x0Var) {
        this.N = x0Var;
    }

    public void P(boolean z4) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = O;
            if (method != null) {
                try {
                    method.invoke(this.J, new Object[]{Boolean.valueOf(z4)});
                } catch (Exception unused) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.J.setTouchModal(z4);
        }
    }

    public void a(e eVar, MenuItem menuItem) {
        x0 x0Var = this.N;
        if (x0Var != null) {
            x0Var.a(eVar, menuItem);
        }
    }

    public void d(e eVar, MenuItem menuItem) {
        x0 x0Var = this.N;
        if (x0Var != null) {
            x0Var.d(eVar, menuItem);
        }
    }

    /* access modifiers changed from: package-private */
    public p0 r(Context context, boolean z4) {
        a aVar = new a(context, z4);
        aVar.setHoverListener(this);
        return aVar;
    }
}
