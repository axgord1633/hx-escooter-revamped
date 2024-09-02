package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.c;

class i {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f1267a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1268b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1269c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1270d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1271e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1272f;

    i(CompoundButton compoundButton) {
        this.f1267a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable a5 = c.a(this.f1267a);
        if (a5 == null) {
            return;
        }
        if (this.f1270d || this.f1271e) {
            Drawable mutate = a.p(a5).mutate();
            if (this.f1270d) {
                a.n(mutate, this.f1268b);
            }
            if (this.f1271e) {
                a.o(mutate, this.f1269c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1267a.getDrawableState());
            }
            this.f1267a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    public int b(int i5) {
        return i5;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f1268b;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.f1269c;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d A[SYNTHETIC, Splitter:B:12:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[Catch:{ all -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071 A[Catch:{ all -> 0x0084 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CompoundButton r0 = r9.f1267a
            android.content.Context r0 = r0.getContext()
            int[] r3 = d.j.R0
            r8 = 0
            androidx.appcompat.widget.k1 r0 = androidx.appcompat.widget.k1.u(r0, r10, r3, r11, r8)
            android.widget.CompoundButton r1 = r9.f1267a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.q()
            r7 = 0
            r4 = r10
            r6 = r11
            androidx.core.view.k0.M(r1, r2, r3, r4, r5, r6, r7)
            int r10 = d.j.T0     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.r(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x003a
            int r10 = r0.m(r10, r8)     // Catch:{ all -> 0x0084 }
            if (r10 == 0) goto L_0x003a
            android.widget.CompoundButton r11 = r9.f1267a     // Catch:{ NotFoundException -> 0x003a }
            android.content.Context r1 = r11.getContext()     // Catch:{ NotFoundException -> 0x003a }
            android.graphics.drawable.Drawable r10 = e.a.b(r1, r10)     // Catch:{ NotFoundException -> 0x003a }
            r11.setButtonDrawable(r10)     // Catch:{ NotFoundException -> 0x003a }
            r10 = 1
            goto L_0x003b
        L_0x003a:
            r10 = r8
        L_0x003b:
            if (r10 != 0) goto L_0x0058
            int r10 = d.j.S0     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.r(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0058
            int r10 = r0.m(r10, r8)     // Catch:{ all -> 0x0084 }
            if (r10 == 0) goto L_0x0058
            android.widget.CompoundButton r11 = r9.f1267a     // Catch:{ all -> 0x0084 }
            android.content.Context r1 = r11.getContext()     // Catch:{ all -> 0x0084 }
            android.graphics.drawable.Drawable r10 = e.a.b(r1, r10)     // Catch:{ all -> 0x0084 }
            r11.setButtonDrawable(r10)     // Catch:{ all -> 0x0084 }
        L_0x0058:
            int r10 = d.j.U0     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.r(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0069
            android.widget.CompoundButton r11 = r9.f1267a     // Catch:{ all -> 0x0084 }
            android.content.res.ColorStateList r10 = r0.c(r10)     // Catch:{ all -> 0x0084 }
            androidx.core.widget.c.b(r11, r10)     // Catch:{ all -> 0x0084 }
        L_0x0069:
            int r10 = d.j.V0     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.r(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0080
            android.widget.CompoundButton r11 = r9.f1267a     // Catch:{ all -> 0x0084 }
            r1 = -1
            int r10 = r0.j(r10, r1)     // Catch:{ all -> 0x0084 }
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.o0.c(r10, r1)     // Catch:{ all -> 0x0084 }
            androidx.core.widget.c.c(r11, r10)     // Catch:{ all -> 0x0084 }
        L_0x0080:
            r0.v()
            return
        L_0x0084:
            r10 = move-exception
            r0.v()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i.e(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.f1272f) {
            this.f1272f = false;
            return;
        }
        this.f1272f = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void g(ColorStateList colorStateList) {
        this.f1268b = colorStateList;
        this.f1270d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void h(PorterDuff.Mode mode) {
        this.f1269c = mode;
        this.f1271e = true;
        a();
    }
}
