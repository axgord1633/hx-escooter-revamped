package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.h0;
import androidx.appcompat.widget.n1;
import androidx.appcompat.widget.r0;
import d.j;

public class ActionMenuItemView extends h0 implements k.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: e  reason: collision with root package name */
    g f778e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f779f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f780g;

    /* renamed from: h  reason: collision with root package name */
    e.b f781h;

    /* renamed from: i  reason: collision with root package name */
    private r0 f782i;

    /* renamed from: j  reason: collision with root package name */
    b f783j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f784k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f785l;

    /* renamed from: m  reason: collision with root package name */
    private int f786m;

    /* renamed from: n  reason: collision with root package name */
    private int f787n;

    /* renamed from: o  reason: collision with root package name */
    private int f788o;

    private class a extends r0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        public i.e b() {
            b bVar = ActionMenuItemView.this.f783j;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
            r0 = b();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c() {
            /*
                r3 = this;
                androidx.appcompat.view.menu.ActionMenuItemView r0 = androidx.appcompat.view.menu.ActionMenuItemView.this
                androidx.appcompat.view.menu.e$b r1 = r0.f781h
                r2 = 0
                if (r1 == 0) goto L_0x001c
                androidx.appcompat.view.menu.g r0 = r0.f778e
                boolean r0 = r1.a(r0)
                if (r0 == 0) goto L_0x001c
                i.e r0 = r3.b()
                if (r0 == 0) goto L_0x001c
                boolean r0 = r0.b()
                if (r0 == 0) goto L_0x001c
                r2 = 1
            L_0x001c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ActionMenuItemView.a.c():boolean");
        }
    }

    public static abstract class b {
        public abstract i.e a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        Resources resources = context.getResources();
        this.f784k = f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f4205v, i5, 0);
        this.f786m = obtainStyledAttributes.getDimensionPixelSize(j.f4210w, 0);
        obtainStyledAttributes.recycle();
        this.f788o = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f787n = -1;
        setSaveEnabled(false);
    }

    private boolean f() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i5 = configuration.screenWidthDp;
        return i5 >= 480 || (i5 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void g() {
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f779f);
        if (this.f780g != null && (!this.f778e.B() || (!this.f784k && !this.f785l))) {
            z4 = false;
        }
        boolean z6 = z5 & z4;
        CharSequence charSequence = null;
        setText(z6 ? this.f779f : null);
        CharSequence contentDescription = this.f778e.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z6 ? null : this.f778e.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.f778e.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z6) {
                charSequence = this.f778e.getTitle();
            }
            n1.a(this, charSequence);
            return;
        }
        n1.a(this, tooltipText);
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return e();
    }

    public boolean c() {
        return e() && this.f778e.getIcon() == null;
    }

    public void d(g gVar, int i5) {
        this.f778e = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f782i == null) {
            this.f782i = new a();
        }
    }

    public boolean e() {
        return !TextUtils.isEmpty(getText());
    }

    public g getItemData() {
        return this.f778e;
    }

    public void onClick(View view) {
        e.b bVar = this.f781h;
        if (bVar != null) {
            bVar.a(this.f778e);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f784k = f();
        g();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7;
        boolean e5 = e();
        if (e5 && (i7 = this.f787n) >= 0) {
            super.setPadding(i7, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i5, i6);
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f786m) : this.f786m;
        if (mode != 1073741824 && this.f786m > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i6);
        }
        if (!e5 && this.f780g != null) {
            super.setPadding((getMeasuredWidth() - this.f780g.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        r0 r0Var;
        if (!this.f778e.hasSubMenu() || (r0Var = this.f782i) == null || !r0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z4) {
    }

    public void setChecked(boolean z4) {
    }

    public void setExpandedFormat(boolean z4) {
        if (this.f785l != z4) {
            this.f785l = z4;
            g gVar = this.f778e;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f780g = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i5 = this.f788o;
            if (intrinsicWidth > i5) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i5) / ((float) intrinsicWidth)));
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > i5) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i5) / ((float) intrinsicHeight)));
            } else {
                i5 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i5);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        g();
    }

    public void setItemInvoker(e.b bVar) {
        this.f781h = bVar;
    }

    public void setPadding(int i5, int i6, int i7, int i8) {
        this.f787n = i5;
        super.setPadding(i5, i6, i7, i8);
    }

    public void setPopupCallback(b bVar) {
        this.f783j = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f779f = charSequence;
        g();
    }
}
