package p1;

import java.util.concurrent.TimeUnit;

public class z {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6543a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6544b;

    /* renamed from: c  reason: collision with root package name */
    public final r0 f6545c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f6546a = false;

        /* renamed from: b  reason: collision with root package name */
        private boolean f6547b = false;

        /* renamed from: c  reason: collision with root package name */
        private r0 f6548c = new r0(30, TimeUnit.SECONDS);

        public z a() {
            return new z(this.f6546a, this.f6547b, this.f6548c);
        }

        public a b(boolean z4) {
            this.f6546a = z4;
            return this;
        }

        public a c(boolean z4) {
            this.f6547b = z4;
            return this;
        }
    }

    z(boolean z4, boolean z5, r0 r0Var) {
        this.f6543a = z4;
        this.f6544b = z5;
        this.f6545c = r0Var;
    }
}
