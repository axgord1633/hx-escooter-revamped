package androidx.window.embedding;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class ActivityRule extends EmbeddingRule {
    private final boolean alwaysExpand;
    private final Set<ActivityFilter> filters;

    public ActivityRule(Set<ActivityFilter> set, boolean z4) {
        k.e(set, "filters");
        this.alwaysExpand = z4;
        this.filters = v.y(set);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActivityRule(Set set, boolean z4, int i5, g gVar) {
        this(set, (i5 & 2) != 0 ? false : z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRule)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) obj;
        return k.a(this.filters, activityRule.filters) && this.alwaysExpand == activityRule.alwaysExpand;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return (this.filters.hashCode() * 31) + a.a(this.alwaysExpand);
    }

    public final ActivityRule plus$window_release(ActivityFilter activityFilter) {
        k.e(activityFilter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(activityFilter);
        return new ActivityRule(v.y(linkedHashSet), this.alwaysExpand);
    }
}
