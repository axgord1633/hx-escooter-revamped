package o4;

import i4.q;
import s4.f;

public final class c {

    /* renamed from: d  reason: collision with root package name */
    public static final f f6175d = f.o(":");

    /* renamed from: e  reason: collision with root package name */
    public static final f f6176e = f.o(":status");

    /* renamed from: f  reason: collision with root package name */
    public static final f f6177f = f.o(":method");

    /* renamed from: g  reason: collision with root package name */
    public static final f f6178g = f.o(":path");

    /* renamed from: h  reason: collision with root package name */
    public static final f f6179h = f.o(":scheme");

    /* renamed from: i  reason: collision with root package name */
    public static final f f6180i = f.o(":authority");

    /* renamed from: a  reason: collision with root package name */
    public final f f6181a;

    /* renamed from: b  reason: collision with root package name */
    public final f f6182b;

    /* renamed from: c  reason: collision with root package name */
    final int f6183c;

    interface a {
        void a(q qVar);
    }

    public c(String str, String str2) {
        this(f.o(str), f.o(str2));
    }

    public c(f fVar, String str) {
        this(fVar, f.o(str));
    }

    public c(f fVar, f fVar2) {
        this.f6181a = fVar;
        this.f6182b = fVar2;
        this.f6183c = fVar.w() + 32 + fVar2.w();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f6181a.equals(cVar.f6181a) && this.f6182b.equals(cVar.f6182b);
    }

    public int hashCode() {
        return ((527 + this.f6181a.hashCode()) * 31) + this.f6182b.hashCode();
    }

    public String toString() {
        return j4.c.p("%s: %s", this.f6181a.B(), this.f6182b.B());
    }
}
