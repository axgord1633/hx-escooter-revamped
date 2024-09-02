package com.google.protobuf;

final class g1 implements q0 {

    /* renamed from: a  reason: collision with root package name */
    private final s0 f3529a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3530b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f3531c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3532d;

    g1(s0 s0Var, String str, Object[] objArr) {
        char charAt;
        this.f3529a = s0Var;
        this.f3530b = str;
        this.f3531c = objArr;
        char charAt2 = str.charAt(0);
        if (charAt2 >= 55296) {
            char c5 = charAt2 & 8191;
            int i5 = 13;
            int i6 = 1;
            while (true) {
                int i7 = i6 + 1;
                charAt = str.charAt(i6);
                if (charAt < 55296) {
                    break;
                }
                c5 |= (charAt & 8191) << i5;
                i5 += 13;
                i6 = i7;
            }
            charAt2 = c5 | (charAt << i5);
        }
        this.f3532d = charAt2;
    }

    public boolean a() {
        return (this.f3532d & 2) == 2;
    }

    public d1 b() {
        return (this.f3532d & 1) == 1 ? d1.PROTO2 : d1.PROTO3;
    }

    public s0 c() {
        return this.f3529a;
    }

    /* access modifiers changed from: package-private */
    public Object[] d() {
        return this.f3531c;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return this.f3530b;
    }
}
