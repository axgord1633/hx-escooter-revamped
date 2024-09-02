package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import kotlin.jvm.internal.k;

public final class ActivityFilter {
    private final ComponentName componentName;
    private final String intentAction;

    public ActivityFilter(ComponentName componentName2, String str) {
        k.e(componentName2, "componentName");
        this.componentName = componentName2;
        this.intentAction = str;
        String packageName = componentName2.getPackageName();
        k.d(packageName, "componentName.packageName");
        String className = componentName2.getClassName();
        k.d(className, "componentName.className");
        boolean z4 = true;
        if (packageName.length() > 0) {
            if (className.length() > 0) {
                if (!n.r(packageName, "*", false, 2, (Object) null) || n.A(packageName, "*", 0, false, 6, (Object) null) == packageName.length() - 1) {
                    if (n.r(className, "*", false, 2, (Object) null) && n.A(className, "*", 0, false, 6, (Object) null) != className.length() - 1) {
                        z4 = false;
                    }
                    if (!z4) {
                        throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
                    }
                    return;
                }
                throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
            }
            throw new IllegalArgumentException("Activity class name must not be empty.".toString());
        }
        throw new IllegalArgumentException("Package name must not be empty".toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityFilter)) {
            return false;
        }
        ActivityFilter activityFilter = (ActivityFilter) obj;
        return k.a(this.componentName, activityFilter.componentName) && k.a(this.intentAction, activityFilter.intentAction);
    }

    public final ComponentName getComponentName() {
        return this.componentName;
    }

    public final String getIntentAction() {
        return this.intentAction;
    }

    public int hashCode() {
        int hashCode = this.componentName.hashCode() * 31;
        String str = this.intentAction;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean matchesActivity(Activity activity) {
        k.e(activity, "activity");
        if (MatcherUtils.INSTANCE.areActivityOrIntentComponentsMatching$window_release(activity, this.componentName)) {
            String str = this.intentAction;
            if (str != null) {
                Intent intent = activity.getIntent();
                if (k.a(str, intent == null ? null : intent.getAction())) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean matchesIntent(Intent intent) {
        k.e(intent, "intent");
        if (!MatcherUtils.INSTANCE.areComponentsMatching$window_release(intent.getComponent(), this.componentName)) {
            return false;
        }
        String str = this.intentAction;
        return str == null || k.a(str, intent.getAction());
    }

    public String toString() {
        return "ActivityFilter(componentName=" + this.componentName + ", intentAction=" + this.intentAction + ')';
    }
}
