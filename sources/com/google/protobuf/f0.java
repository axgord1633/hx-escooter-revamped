package com.google.protobuf;

public class f0 {

    /* renamed from: e  reason: collision with root package name */
    private static final q f3515e = q.b();

    /* renamed from: a  reason: collision with root package name */
    private i f3516a;

    /* renamed from: b  reason: collision with root package name */
    private q f3517b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile s0 f3518c;

    /* renamed from: d  reason: collision with root package name */
    private volatile i f3519d;

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.f3518c = r4;
        r3.f3519d = com.google.protobuf.i.f3533f;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.google.protobuf.s0 r4) {
        /*
            r3 = this;
            com.google.protobuf.s0 r0 = r3.f3518c
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            com.google.protobuf.s0 r0 = r3.f3518c     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0032 }
            return
        L_0x000c:
            com.google.protobuf.i r0 = r3.f3516a     // Catch:{ c0 -> 0x002a }
            if (r0 == 0) goto L_0x0025
            com.google.protobuf.b1 r0 = r4.getParserForType()     // Catch:{ c0 -> 0x002a }
            com.google.protobuf.i r1 = r3.f3516a     // Catch:{ c0 -> 0x002a }
            com.google.protobuf.q r2 = r3.f3517b     // Catch:{ c0 -> 0x002a }
            java.lang.Object r0 = r0.a(r1, r2)     // Catch:{ c0 -> 0x002a }
            com.google.protobuf.s0 r0 = (com.google.protobuf.s0) r0     // Catch:{ c0 -> 0x002a }
            r3.f3518c = r0     // Catch:{ c0 -> 0x002a }
            com.google.protobuf.i r0 = r3.f3516a     // Catch:{ c0 -> 0x002a }
        L_0x0022:
            r3.f3519d = r0     // Catch:{ c0 -> 0x002a }
            goto L_0x0030
        L_0x0025:
            r3.f3518c = r4     // Catch:{ c0 -> 0x002a }
            com.google.protobuf.i r0 = com.google.protobuf.i.f3533f     // Catch:{ c0 -> 0x002a }
            goto L_0x0022
        L_0x002a:
            r3.f3518c = r4     // Catch:{ all -> 0x0032 }
            com.google.protobuf.i r4 = com.google.protobuf.i.f3533f     // Catch:{ all -> 0x0032 }
            r3.f3519d = r4     // Catch:{ all -> 0x0032 }
        L_0x0030:
            monitor-exit(r3)     // Catch:{ all -> 0x0032 }
            return
        L_0x0032:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0032 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.f0.a(com.google.protobuf.s0):void");
    }

    public int b() {
        if (this.f3519d != null) {
            return this.f3519d.size();
        }
        i iVar = this.f3516a;
        if (iVar != null) {
            return iVar.size();
        }
        if (this.f3518c != null) {
            return this.f3518c.getSerializedSize();
        }
        return 0;
    }

    public s0 c(s0 s0Var) {
        a(s0Var);
        return this.f3518c;
    }

    public s0 d(s0 s0Var) {
        s0 s0Var2 = this.f3518c;
        this.f3516a = null;
        this.f3519d = null;
        this.f3518c = s0Var;
        return s0Var2;
    }

    public i e() {
        if (this.f3519d != null) {
            return this.f3519d;
        }
        i iVar = this.f3516a;
        if (iVar != null) {
            return iVar;
        }
        synchronized (this) {
            if (this.f3519d != null) {
                i iVar2 = this.f3519d;
                return iVar2;
            }
            this.f3519d = this.f3518c == null ? i.f3533f : this.f3518c.toByteString();
            i iVar3 = this.f3519d;
            return iVar3;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        s0 s0Var = this.f3518c;
        s0 s0Var2 = f0Var.f3518c;
        return (s0Var == null && s0Var2 == null) ? e().equals(f0Var.e()) : (s0Var == null || s0Var2 == null) ? s0Var != null ? s0Var.equals(f0Var.c(s0Var.getDefaultInstanceForType())) : c(s0Var2.getDefaultInstanceForType()).equals(s0Var2) : s0Var.equals(s0Var2);
    }

    public int hashCode() {
        return 1;
    }
}
