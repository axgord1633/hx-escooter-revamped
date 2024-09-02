package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.k1;
import androidx.core.view.k0;
import d.a;
import d.f;
import d.g;
import d.j;

public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: e  reason: collision with root package name */
    private g f793e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f794f;

    /* renamed from: g  reason: collision with root package name */
    private RadioButton f795g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f796h;

    /* renamed from: i  reason: collision with root package name */
    private CheckBox f797i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f798j;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f799k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView f800l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f801m;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f802n;

    /* renamed from: o  reason: collision with root package name */
    private int f803o;

    /* renamed from: p  reason: collision with root package name */
    private Context f804p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f805q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f806r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f807s;

    /* renamed from: t  reason: collision with root package name */
    private LayoutInflater f808t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f809u;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet);
        k1 u5 = k1.u(getContext(), attributeSet, j.W1, i5, 0);
        this.f802n = u5.f(j.Y1);
        this.f803o = u5.m(j.X1, -1);
        this.f805q = u5.a(j.Z1, false);
        this.f804p = context;
        this.f806r = u5.f(j.f4103a2);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, a.f3987z, 0);
        this.f807s = obtainStyledAttributes.hasValue(0);
        u5.v();
        obtainStyledAttributes.recycle();
    }

    private void b(View view) {
        c(view, -1);
    }

    private void c(View view, int i5) {
        LinearLayout linearLayout = this.f801m;
        if (linearLayout != null) {
            linearLayout.addView(view, i5);
        } else {
            addView(view, i5);
        }
    }

    private void e() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(g.f4071h, this, false);
        this.f797i = checkBox;
        b(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(g.f4072i, this, false);
        this.f794f = imageView;
        c(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(g.f4074k, this, false);
        this.f795g = radioButton;
        b(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f808t == null) {
            this.f808t = LayoutInflater.from(getContext());
        }
        return this.f808t;
    }

    private void setSubMenuArrowVisible(boolean z4) {
        ImageView imageView = this.f799k;
        if (imageView != null) {
            imageView.setVisibility(z4 ? 0 : 8);
        }
    }

    public boolean a() {
        return false;
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f800l;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f800l.getLayoutParams();
            rect.top += this.f800l.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public void d(g gVar, int i5) {
        this.f793e = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        h(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    public g getItemData() {
        return this.f793e;
    }

    public void h(boolean z4, char c5) {
        int i5 = (!z4 || !this.f793e.A()) ? 8 : 0;
        if (i5 == 0) {
            this.f798j.setText(this.f793e.h());
        }
        if (this.f798j.getVisibility() != i5) {
            this.f798j.setVisibility(i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        k0.P(this, this.f802n);
        TextView textView = (TextView) findViewById(f.M);
        this.f796h = textView;
        int i5 = this.f803o;
        if (i5 != -1) {
            textView.setTextAppearance(this.f804p, i5);
        }
        this.f798j = (TextView) findViewById(f.F);
        ImageView imageView = (ImageView) findViewById(f.I);
        this.f799k = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f806r);
        }
        this.f800l = (ImageView) findViewById(f.f4055r);
        this.f801m = (LinearLayout) findViewById(f.f4049l);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        if (this.f794f != null && this.f805q) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f794f.getLayoutParams();
            int i7 = layoutParams.height;
            if (i7 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i7;
            }
        }
        super.onMeasure(i5, i6);
    }

    public void setCheckable(boolean z4) {
        View view;
        CompoundButton compoundButton;
        if (z4 || this.f795g != null || this.f797i != null) {
            if (this.f793e.m()) {
                if (this.f795g == null) {
                    g();
                }
                compoundButton = this.f795g;
                view = this.f797i;
            } else {
                if (this.f797i == null) {
                    e();
                }
                compoundButton = this.f797i;
                view = this.f795g;
            }
            if (z4) {
                compoundButton.setChecked(this.f793e.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f797i;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f795g;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z4) {
        CompoundButton compoundButton;
        if (this.f793e.m()) {
            if (this.f795g == null) {
                g();
            }
            compoundButton = this.f795g;
        } else {
            if (this.f797i == null) {
                e();
            }
            compoundButton = this.f797i;
        }
        compoundButton.setChecked(z4);
    }

    public void setForceShowIcon(boolean z4) {
        this.f809u = z4;
        this.f805q = z4;
    }

    public void setGroupDividerEnabled(boolean z4) {
        ImageView imageView = this.f800l;
        if (imageView != null) {
            imageView.setVisibility((this.f807s || !z4) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z4 = this.f793e.z() || this.f809u;
        if (z4 || this.f805q) {
            ImageView imageView = this.f794f;
            if (imageView != null || drawable != null || this.f805q) {
                if (imageView == null) {
                    f();
                }
                if (drawable != null || this.f805q) {
                    ImageView imageView2 = this.f794f;
                    if (!z4) {
                        drawable = null;
                    }
                    imageView2.setImageDrawable(drawable);
                    if (this.f794f.getVisibility() != 0) {
                        this.f794f.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f794f.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView;
        int i5;
        if (charSequence != null) {
            this.f796h.setText(charSequence);
            if (this.f796h.getVisibility() != 0) {
                textView = this.f796h;
                i5 = 0;
            } else {
                return;
            }
        } else {
            i5 = 8;
            if (this.f796h.getVisibility() != 8) {
                textView = this.f796h;
            } else {
                return;
            }
        }
        textView.setVisibility(i5);
    }
}
