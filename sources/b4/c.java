package b4;

import a4.b;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.k;
import m3.j;
import v3.p;

final class c implements b<y3.c> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f3049a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f3050b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f3051c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final p<CharSequence, Integer, j<Integer, Integer>> f3052d;

    public static final class a implements Iterator<y3.c> {

        /* renamed from: e  reason: collision with root package name */
        private int f3053e = -1;

        /* renamed from: f  reason: collision with root package name */
        private int f3054f;

        /* renamed from: g  reason: collision with root package name */
        private int f3055g;

        /* renamed from: h  reason: collision with root package name */
        private y3.c f3056h;

        /* renamed from: i  reason: collision with root package name */
        private int f3057i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ c f3058j;

        a(c cVar) {
            this.f3058j = cVar;
            int e5 = f.e(cVar.f3050b, 0, cVar.f3049a.length());
            this.f3054f = e5;
            this.f3055g = e5;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
            if (r0 < b4.c.c(r6.f3058j)) goto L_0x0023;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void b() {
            /*
                r6 = this;
                int r0 = r6.f3055g
                r1 = 0
                if (r0 >= 0) goto L_0x000c
                r6.f3053e = r1
                r0 = 0
                r6.f3056h = r0
                goto L_0x0099
            L_0x000c:
                b4.c r0 = r6.f3058j
                int r0 = r0.f3051c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0023
                int r0 = r6.f3057i
                int r0 = r0 + r3
                r6.f3057i = r0
                b4.c r4 = r6.f3058j
                int r4 = r4.f3051c
                if (r0 >= r4) goto L_0x0031
            L_0x0023:
                int r0 = r6.f3055g
                b4.c r4 = r6.f3058j
                java.lang.CharSequence r4 = r4.f3049a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x0047
            L_0x0031:
                y3.c r0 = new y3.c
                int r1 = r6.f3054f
                b4.c r4 = r6.f3058j
                java.lang.CharSequence r4 = r4.f3049a
                int r4 = b4.n.u(r4)
                r0.<init>(r1, r4)
            L_0x0042:
                r6.f3056h = r0
            L_0x0044:
                r6.f3055g = r2
                goto L_0x0097
            L_0x0047:
                b4.c r0 = r6.f3058j
                v3.p r0 = r0.f3052d
                b4.c r4 = r6.f3058j
                java.lang.CharSequence r4 = r4.f3049a
                int r5 = r6.f3055g
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                m3.j r0 = (m3.j) r0
                if (r0 != 0) goto L_0x0073
                y3.c r0 = new y3.c
                int r1 = r6.f3054f
                b4.c r4 = r6.f3058j
                java.lang.CharSequence r4 = r4.f3049a
                int r4 = b4.n.u(r4)
                r0.<init>(r1, r4)
                goto L_0x0042
            L_0x0073:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f3054f
                y3.c r4 = y3.f.g(r4, r2)
                r6.f3056h = r4
                int r2 = r2 + r0
                r6.f3054f = r2
                if (r0 != 0) goto L_0x0095
                r1 = r3
            L_0x0095:
                int r2 = r2 + r1
                goto L_0x0044
            L_0x0097:
                r6.f3053e = r3
            L_0x0099:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b4.c.a.b():void");
        }

        /* renamed from: c */
        public y3.c next() {
            if (this.f3053e == -1) {
                b();
            }
            if (this.f3053e != 0) {
                y3.c cVar = this.f3056h;
                k.c(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f3056h = null;
                this.f3053e = -1;
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f3053e == -1) {
                b();
            }
            return this.f3053e == 1;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public c(CharSequence charSequence, int i5, int i6, p<? super CharSequence, ? super Integer, j<Integer, Integer>> pVar) {
        k.e(charSequence, "input");
        k.e(pVar, "getNextMatch");
        this.f3049a = charSequence;
        this.f3050b = i5;
        this.f3051c = i6;
        this.f3052d = pVar;
    }

    public Iterator<y3.c> iterator() {
        return new a(this);
    }
}
