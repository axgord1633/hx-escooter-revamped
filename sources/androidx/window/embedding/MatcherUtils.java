package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import kotlin.jvm.internal.k;

public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = new MatcherUtils();
    public static final boolean sDebugMatchers = false;
    public static final String sMatchersTag = "SplitRuleResolution";

    private MatcherUtils() {
    }

    private final boolean wildcardMatch(String str, String str2) {
        if (!n.r(str2, "*", false, 2, (Object) null)) {
            return false;
        }
        if (k.a(str2, "*")) {
            return true;
        }
        String str3 = str2;
        if (n.A(str3, "*", 0, false, 6, (Object) null) == n.F(str3, "*", 0, false, 6, (Object) null) && m.i(str2, "*", false, 2, (Object) null)) {
            String substring = str2.substring(0, str2.length() - 1);
            k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return m.o(str, substring, false, 2, (Object) null);
        }
        throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end".toString());
    }

    public final boolean areActivityOrIntentComponentsMatching$window_release(Activity activity, ComponentName componentName) {
        ComponentName component;
        k.e(activity, "activity");
        k.e(componentName, "ruleComponent");
        if (areComponentsMatching$window_release(activity.getComponentName(), componentName)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent == null || (component = intent.getComponent()) == null) {
            return false;
        }
        return INSTANCE.areComponentsMatching$window_release(component, componentName);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008a A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean areComponentsMatching$window_release(android.content.ComponentName r7, android.content.ComponentName r8) {
        /*
            r6 = this;
            java.lang.String r0 = "ruleComponent"
            kotlin.jvm.internal.k.e(r8, r0)
            java.lang.String r0 = "*"
            r1 = 1
            r2 = 0
            if (r7 != 0) goto L_0x0022
            java.lang.String r7 = r8.getPackageName()
            boolean r7 = kotlin.jvm.internal.k.a(r7, r0)
            if (r7 == 0) goto L_0x0020
            java.lang.String r7 = r8.getClassName()
            boolean r7 = kotlin.jvm.internal.k.a(r7, r0)
            if (r7 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r1 = r2
        L_0x0021:
            return r1
        L_0x0022:
            java.lang.String r3 = r7.toString()
            java.lang.String r4 = "activityComponent.toString()"
            kotlin.jvm.internal.k.d(r3, r4)
            r4 = 2
            r5 = 0
            boolean r0 = b4.n.r(r3, r0, r2, r4, r5)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x008f
            java.lang.String r0 = r7.getPackageName()
            java.lang.String r3 = r8.getPackageName()
            boolean r0 = kotlin.jvm.internal.k.a(r0, r3)
            if (r0 != 0) goto L_0x005d
            java.lang.String r0 = r7.getPackageName()
            java.lang.String r3 = "activityComponent.packageName"
            kotlin.jvm.internal.k.d(r0, r3)
            java.lang.String r3 = r8.getPackageName()
            java.lang.String r4 = "ruleComponent.packageName"
            kotlin.jvm.internal.k.d(r3, r4)
            boolean r0 = r6.wildcardMatch(r0, r3)
            if (r0 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r0 = r2
            goto L_0x005e
        L_0x005d:
            r0 = r1
        L_0x005e:
            java.lang.String r3 = r7.getClassName()
            java.lang.String r4 = r8.getClassName()
            boolean r3 = kotlin.jvm.internal.k.a(r3, r4)
            if (r3 != 0) goto L_0x0087
            java.lang.String r7 = r7.getClassName()
            java.lang.String r3 = "activityComponent.className"
            kotlin.jvm.internal.k.d(r7, r3)
            java.lang.String r8 = r8.getClassName()
            java.lang.String r3 = "ruleComponent.className"
            kotlin.jvm.internal.k.d(r8, r3)
            boolean r7 = r6.wildcardMatch(r7, r8)
            if (r7 == 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            r7 = r2
            goto L_0x0088
        L_0x0087:
            r7 = r1
        L_0x0088:
            if (r0 == 0) goto L_0x008d
            if (r7 == 0) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            r1 = r2
        L_0x008e:
            return r1
        L_0x008f:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Wildcard can only be part of the rule."
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.MatcherUtils.areComponentsMatching$window_release(android.content.ComponentName, android.content.ComponentName):boolean");
    }
}
