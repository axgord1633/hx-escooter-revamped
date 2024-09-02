package com.signify.hue.flutterreactiveble.ble;

import java.util.List;
import kotlin.jvm.internal.k;
import l3.a;

public final class ConnectionQueue {
    private final a<List<String>> queueSubject;

    public ConnectionQueue() {
        a<List<String>> R0 = a.R0(n.d());
        k.d(R0, "createDefault(listOf<String>())");
        this.queueSubject = R0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addToQueue(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "deviceId"
            kotlin.jvm.internal.k.e(r5, r0)
            l3.a<java.util.List<java.lang.String>> r0 = r4.queueSubject
            java.lang.Object r0 = r0.S0()
            java.util.List r0 = (java.util.List) r0
            r1 = 0
            if (r0 == 0) goto L_0x002a
            java.util.Iterator r0 = r0.iterator()
        L_0x0014:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0028
            java.lang.Object r2 = r0.next()
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = kotlin.jvm.internal.k.a(r3, r5)
            if (r3 == 0) goto L_0x0014
            r1 = r2
        L_0x0028:
            java.lang.String r1 = (java.lang.String) r1
        L_0x002a:
            if (r1 != 0) goto L_0x0042
            l3.a<java.util.List<java.lang.String>> r0 = r4.queueSubject
            java.lang.Object r0 = r0.S0()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0042
            java.util.List r0 = n3.v.x(r0)
            r0.add(r5)
            l3.a<java.util.List<java.lang.String>> r5 = r4.queueSubject
            r5.d(r0)
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.signify.hue.flutterreactiveble.ble.ConnectionQueue.addToQueue(java.lang.String):void");
    }

    public final List<String> getCurrentQueue$reactive_ble_mobile_release() {
        return this.queueSubject.S0();
    }

    public final a<List<String>> observeQueue() {
        return this.queueSubject;
    }

    public final void removeFromQueue(String str) {
        k.e(str, "deviceId");
        List S0 = this.queueSubject.S0();
        if (S0 != null) {
            List x4 = v.x(S0);
            x4.remove(str);
            this.queueSubject.d(x4);
        }
    }
}
