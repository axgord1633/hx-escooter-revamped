package y3;

import kotlin.jvm.internal.g;
import n3.a0;
import q3.c;

public class a implements Iterable<Integer> {

    /* renamed from: h  reason: collision with root package name */
    public static final C0127a f7824h = new C0127a((g) null);

    /* renamed from: e  reason: collision with root package name */
    private final int f7825e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7826f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7827g;

    /* renamed from: y3.a$a  reason: collision with other inner class name */
    public static final class C0127a {
        private C0127a() {
        }

        public /* synthetic */ C0127a(g gVar) {
            this();
        }

        public final a a(int i5, int i6, int i7) {
            return new a(i5, i6, i7);
        }
    }

    public a(int i5, int i6, int i7) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i7 != Integer.MIN_VALUE) {
            this.f7825e = i5;
            this.f7826f = c.b(i5, i6, i7);
            this.f7827g = i7;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int c() {
        return this.f7825e;
    }

    public final int e() {
        return this.f7826f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (!(this.f7825e == aVar.f7825e && this.f7826f == aVar.f7826f && this.f7827g == aVar.f7827g)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f7827g;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f7825e * 31) + this.f7826f) * 31) + this.f7827g;
    }

    /* renamed from: i */
    public a0 iterator() {
        return new b(this.f7825e, this.f7826f, this.f7827g);
    }

    public boolean isEmpty() {
        if (this.f7827g > 0) {
            if (this.f7825e > this.f7826f) {
                return true;
            }
        } else if (this.f7825e < this.f7826f) {
            return true;
        }
        return false;
    }

    public String toString() {
        int i5;
        StringBuilder sb;
        if (this.f7827g > 0) {
            sb = new StringBuilder();
            sb.append(this.f7825e);
            sb.append("..");
            sb.append(this.f7826f);
            sb.append(" step ");
            i5 = this.f7827g;
        } else {
            sb = new StringBuilder();
            sb.append(this.f7825e);
            sb.append(" downTo ");
            sb.append(this.f7826f);
            sb.append(" step ");
            i5 = -this.f7827g;
        }
        sb.append(i5);
        return sb.toString();
    }
}
