package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import kotlin.jvm.internal.k;

public final class SplitPairFilter {
    private final ComponentName primaryActivityName;
    private final String secondaryActivityIntentAction;
    private final ComponentName secondaryActivityName;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0148  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SplitPairFilter(android.content.ComponentName r18, android.content.ComponentName r19, java.lang.String r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = "primaryActivityName"
            kotlin.jvm.internal.k.e(r1, r3)
            java.lang.String r3 = "secondaryActivityName"
            kotlin.jvm.internal.k.e(r2, r3)
            r17.<init>()
            r0.primaryActivityName = r1
            r0.secondaryActivityName = r2
            r3 = r20
            r0.secondaryActivityIntentAction = r3
            java.lang.String r7 = r18.getPackageName()
            java.lang.String r3 = "primaryActivityName.packageName"
            kotlin.jvm.internal.k.d(r7, r3)
            java.lang.String r14 = r18.getClassName()
            java.lang.String r1 = "primaryActivityName.className"
            kotlin.jvm.internal.k.d(r14, r1)
            java.lang.String r15 = r19.getPackageName()
            java.lang.String r1 = "secondaryActivityName.packageName"
            kotlin.jvm.internal.k.d(r15, r1)
            java.lang.String r13 = r19.getClassName()
            java.lang.String r1 = "secondaryActivityName.className"
            kotlin.jvm.internal.k.d(r13, r1)
            int r1 = r7.length()
            r16 = 1
            r12 = 0
            if (r1 != 0) goto L_0x004b
            r1 = r16
            goto L_0x004c
        L_0x004b:
            r1 = r12
        L_0x004c:
            if (r1 != 0) goto L_0x005d
            int r1 = r15.length()
            if (r1 != 0) goto L_0x0057
            r1 = r16
            goto L_0x0058
        L_0x0057:
            r1 = r12
        L_0x0058:
            if (r1 != 0) goto L_0x005d
            r1 = r16
            goto L_0x005e
        L_0x005d:
            r1 = r12
        L_0x005e:
            if (r1 == 0) goto L_0x0148
            int r1 = r14.length()
            if (r1 != 0) goto L_0x0069
            r1 = r16
            goto L_0x006a
        L_0x0069:
            r1 = r12
        L_0x006a:
            if (r1 != 0) goto L_0x007b
            int r1 = r13.length()
            if (r1 != 0) goto L_0x0075
            r1 = r16
            goto L_0x0076
        L_0x0075:
            r1 = r12
        L_0x0076:
            if (r1 != 0) goto L_0x007b
            r1 = r16
            goto L_0x007c
        L_0x007b:
            r1 = r12
        L_0x007c:
            if (r1 == 0) goto L_0x013c
            java.lang.String r11 = "*"
            r10 = 2
            r9 = 0
            boolean r1 = b4.n.r(r7, r11, r12, r10, r9)
            if (r1 == 0) goto L_0x009e
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.lang.String r2 = "*"
            r1 = r7
            int r1 = b4.n.A(r1, r2, r3, r4, r5, r6)
            int r2 = r7.length()
            int r2 = r2 + -1
            if (r1 != r2) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r1 = r12
            goto L_0x00a0
        L_0x009e:
            r1 = r16
        L_0x00a0:
            java.lang.String r2 = "Wildcard in package name is only allowed at the end."
            if (r1 == 0) goto L_0x0132
            boolean r1 = b4.n.r(r14, r11, r12, r10, r9)
            if (r1 == 0) goto L_0x00ca
            r1 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            java.lang.String r6 = "*"
            r8 = r14
            r7 = r9
            r9 = r6
            r6 = r10
            r10 = r1
            r1 = r11
            r11 = r3
            r3 = r12
            r12 = r4
            r4 = r13
            r13 = r5
            int r5 = b4.n.A(r8, r9, r10, r11, r12, r13)
            int r8 = r14.length()
            int r8 = r8 + -1
            if (r5 != r8) goto L_0x00c8
            goto L_0x00cf
        L_0x00c8:
            r12 = r3
            goto L_0x00d1
        L_0x00ca:
            r7 = r9
            r6 = r10
            r1 = r11
            r3 = r12
            r4 = r13
        L_0x00cf:
            r12 = r16
        L_0x00d1:
            java.lang.String r5 = "Wildcard in class name is only allowed at the end."
            if (r12 == 0) goto L_0x0128
            boolean r8 = b4.n.r(r15, r1, r3, r6, r7)
            if (r8 == 0) goto L_0x00f1
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            java.lang.String r9 = "*"
            r8 = r15
            int r8 = b4.n.A(r8, r9, r10, r11, r12, r13)
            int r9 = r15.length()
            int r9 = r9 + -1
            if (r8 != r9) goto L_0x00ef
            goto L_0x00f1
        L_0x00ef:
            r12 = r3
            goto L_0x00f3
        L_0x00f1:
            r12 = r16
        L_0x00f3:
            if (r12 == 0) goto L_0x011e
            boolean r1 = b4.n.r(r4, r1, r3, r6, r7)
            if (r1 == 0) goto L_0x0111
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            java.lang.String r9 = "*"
            r8 = r4
            int r1 = b4.n.A(r8, r9, r10, r11, r12, r13)
            int r2 = r4.length()
            int r2 = r2 + -1
            if (r1 != r2) goto L_0x010f
            goto L_0x0111
        L_0x010f:
            r16 = r3
        L_0x0111:
            if (r16 == 0) goto L_0x0114
            return
        L_0x0114:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r5.toString()
            r1.<init>(r2)
            throw r1
        L_0x011e:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0128:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r5.toString()
            r1.<init>(r2)
            throw r1
        L_0x0132:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x013c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Activity class name must not be empty."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0148:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Package name must not be empty"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SplitPairFilter.<init>(android.content.ComponentName, android.content.ComponentName, java.lang.String):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairFilter)) {
            return false;
        }
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        return k.a(this.primaryActivityName, splitPairFilter.primaryActivityName) && k.a(this.secondaryActivityName, splitPairFilter.secondaryActivityName) && k.a(this.secondaryActivityIntentAction, splitPairFilter.secondaryActivityIntentAction);
    }

    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public int hashCode() {
        int hashCode = ((this.primaryActivityName.hashCode() * 31) + this.secondaryActivityName.hashCode()) * 31;
        String str = this.secondaryActivityIntentAction;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean matchesActivityIntentPair(Activity activity, Intent intent) {
        k.e(activity, "primaryActivity");
        k.e(intent, "secondaryActivityIntent");
        ComponentName componentName = activity.getComponentName();
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        if (!matcherUtils.areComponentsMatching$window_release(componentName, this.primaryActivityName) || !matcherUtils.areComponentsMatching$window_release(intent.getComponent(), this.secondaryActivityName)) {
            return false;
        }
        String str = this.secondaryActivityIntentAction;
        return str == null || k.a(str, intent.getAction());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        if (matchesActivityIntentPair(r6, r7) != false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean matchesActivityPair(android.app.Activity r6, android.app.Activity r7) {
        /*
            r5 = this;
            java.lang.String r0 = "primaryActivity"
            kotlin.jvm.internal.k.e(r6, r0)
            java.lang.String r0 = "secondaryActivity"
            kotlin.jvm.internal.k.e(r7, r0)
            androidx.window.embedding.MatcherUtils r0 = androidx.window.embedding.MatcherUtils.INSTANCE
            android.content.ComponentName r1 = r6.getComponentName()
            android.content.ComponentName r2 = r5.primaryActivityName
            boolean r1 = r0.areComponentsMatching$window_release(r1, r2)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0028
            android.content.ComponentName r1 = r7.getComponentName()
            android.content.ComponentName r4 = r5.secondaryActivityName
            boolean r0 = r0.areComponentsMatching$window_release(r1, r4)
            if (r0 == 0) goto L_0x0028
            r0 = r2
            goto L_0x0029
        L_0x0028:
            r0 = r3
        L_0x0029:
            android.content.Intent r1 = r7.getIntent()
            if (r1 == 0) goto L_0x0043
            if (r0 == 0) goto L_0x0041
            android.content.Intent r7 = r7.getIntent()
            java.lang.String r0 = "secondaryActivity.intent"
            kotlin.jvm.internal.k.d(r7, r0)
            boolean r6 = r5.matchesActivityIntentPair(r6, r7)
            if (r6 == 0) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r2 = r3
        L_0x0042:
            r0 = r2
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SplitPairFilter.matchesActivityPair(android.app.Activity, android.app.Activity):boolean");
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + this.secondaryActivityIntentAction + '}';
    }
}
