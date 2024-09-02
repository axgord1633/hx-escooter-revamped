package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import l1.h;
import u0.b;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final Map f3369a = Collections.synchronizedMap(new WeakHashMap());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map f3370b = Collections.synchronizedMap(new WeakHashMap());

    private final void f(boolean z4, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f3369a) {
            hashMap = new HashMap(this.f3369a);
        }
        synchronized (this.f3370b) {
            hashMap2 = new HashMap(this.f3370b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z4 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).b(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z4 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((h) entry2.getKey()).d(new b(status));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(h hVar, boolean z4) {
        this.f3370b.put(hVar, Boolean.valueOf(z4));
        hVar.a().b(new i(this, hVar));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(int r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The connection to Google Play services was lost"
            r0.<init>(r1)
            r1 = 1
            if (r4 != r1) goto L_0x0010
            java.lang.String r4 = " due to service disconnection."
        L_0x000c:
            r0.append(r4)
            goto L_0x0016
        L_0x0010:
            r2 = 3
            if (r4 != r2) goto L_0x0016
            java.lang.String r4 = " due to dead object exception."
            goto L_0x000c
        L_0x0016:
            if (r5 == 0) goto L_0x0020
            java.lang.String r4 = " Last reason for disconnect: "
            r0.append(r4)
            r0.append(r5)
        L_0x0020:
            com.google.android.gms.common.api.Status r4 = new com.google.android.gms.common.api.Status
            r5 = 20
            java.lang.String r0 = r0.toString()
            r4.<init>((int) r5, (java.lang.String) r0)
            r3.f(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.j.c(int, java.lang.String):void");
    }

    public final void d() {
        f(false, b.f3308r);
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        return !this.f3369a.isEmpty() || !this.f3370b.isEmpty();
    }
}
