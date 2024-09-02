package w1;

import q1.m;
import y1.f0;
import y1.w;

public class t implements s {

    /* renamed from: a  reason: collision with root package name */
    final f0 f7532a;

    /* renamed from: b  reason: collision with root package name */
    final w f7533b;

    public t(f0 f0Var, w wVar) {
        this.f7532a = f0Var;
        this.f7533b = wVar;
    }

    public void a(boolean z4) {
        if (!this.f7532a.b()) {
            throw new m(2);
        } else if (!this.f7532a.c()) {
            throw new m(1);
        } else if (!this.f7533b.a()) {
            throw new m(3);
        } else if (z4 && !this.f7533b.b()) {
            throw new m(4);
        }
    }
}
