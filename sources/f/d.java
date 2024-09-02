package f;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import f.b;

class d extends b {

    /* renamed from: q  reason: collision with root package name */
    private a f4595q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f4596r;

    static class a extends b.d {
        int[][] J;

        a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[f()][];
            }
        }

        /* access modifiers changed from: package-private */
        public int A(int[] iArr) {
            int[][] iArr2 = this.J;
            int h5 = h();
            for (int i5 = 0; i5 < h5; i5++) {
                if (StateSet.stateSetMatches(iArr2[i5], iArr)) {
                    return i5;
                }
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new d(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }

        public void o(int i5, int i6) {
            super.o(i5, i6);
            int[][] iArr = new int[i6][];
            System.arraycopy(this.J, 0, iArr, 0, i5);
            this.J = iArr;
        }

        /* access modifiers changed from: package-private */
        public void r() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[] iArr3 = this.J[length];
                iArr2[length] = iArr3 != null ? (int[]) iArr3.clone() : null;
            }
            this.J = iArr2;
        }

        /* access modifiers changed from: package-private */
        public int z(int[] iArr, Drawable drawable) {
            int a5 = a(drawable);
            this.J[a5] = iArr;
            return a5;
        }
    }

    d(a aVar) {
        if (aVar != null) {
            h(aVar);
        }
    }

    d(a aVar, Resources resources) {
        h(new a(aVar, this, resources));
        onStateChange(getState());
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    public void h(b.d dVar) {
        super.h(dVar);
        if (dVar instanceof a) {
            this.f4595q = (a) dVar;
        }
    }

    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public a b() {
        return new a(this.f4595q, this, (Resources) null);
    }

    /* access modifiers changed from: package-private */
    public int[] k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i5 = 0;
        for (int i6 = 0; i6 < attributeCount; i6++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i6);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i7 = i5 + 1;
                if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i5] = attributeNameResource;
                i5 = i7;
            }
        }
        return StateSet.trimStateSet(iArr, i5);
    }

    public Drawable mutate() {
        if (!this.f4596r && super.mutate() == this) {
            this.f4595q.r();
            this.f4596r = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int A = this.f4595q.A(iArr);
        if (A < 0) {
            A = this.f4595q.A(StateSet.WILD_CARD);
        }
        return g(A) || onStateChange;
    }
}
