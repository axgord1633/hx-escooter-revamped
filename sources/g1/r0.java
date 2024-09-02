package g1;

import java.util.List;
import javax.annotation.CheckForNull;

final class r0 extends s0 {

    /* renamed from: g  reason: collision with root package name */
    final transient int f4714g;

    /* renamed from: h  reason: collision with root package name */
    final transient int f4715h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ s0 f4716i;

    r0(s0 s0Var, int i5, int i6) {
        this.f4716i = s0Var;
        this.f4714g = i5;
        this.f4715h = i6;
    }

    /* access modifiers changed from: package-private */
    public final int e() {
        return this.f4716i.f() + this.f4714g + this.f4715h;
    }

    /* access modifiers changed from: package-private */
    public final int f() {
        return this.f4716i.f() + this.f4714g;
    }

    public final Object get(int i5) {
        m0.a(i5, this.f4715h, "index");
        return this.f4716i.get(i5 + this.f4714g);
    }

    /* access modifiers changed from: package-private */
    public final boolean m() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final Object[] n() {
        return this.f4716i.n();
    }

    public final s0 o(int i5, int i6) {
        m0.c(i5, i6, this.f4715h);
        s0 s0Var = this.f4716i;
        int i7 = this.f4714g;
        return s0Var.subList(i5 + i7, i6 + i7);
    }

    public final int size() {
        return this.f4715h;
    }

    public final /* bridge */ /* synthetic */ List subList(int i5, int i6) {
        return subList(i5, i6);
    }
}
