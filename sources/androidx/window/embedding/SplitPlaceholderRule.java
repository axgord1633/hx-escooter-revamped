package androidx.window.embedding;

import android.content.Intent;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class SplitPlaceholderRule extends SplitRule {
    private final Set<ActivityFilter> filters;
    private final Intent placeholderIntent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplitPlaceholderRule(Set<ActivityFilter> set, Intent intent, int i5, int i6, float f5, int i7) {
        super(i5, i6, f5, i7);
        k.e(set, "filters");
        k.e(intent, "placeholderIntent");
        this.placeholderIntent = intent;
        this.filters = v.y(set);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SplitPlaceholderRule(Set set, Intent intent, int i5, int i6, float f5, int i7, int i8, g gVar) {
        this(set, intent, (i8 & 4) != 0 ? 0 : i5, (i8 & 8) != 0 ? 0 : i6, (i8 & 16) != 0 ? 0.5f : f5, (i8 & 32) != 0 ? 3 : i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPlaceholderRule) || !super.equals(obj) || !super.equals(obj)) {
            return false;
        }
        SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) obj;
        return k.a(this.filters, splitPlaceholderRule.filters) && k.a(this.placeholderIntent, splitPlaceholderRule.placeholderIntent);
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public final Intent getPlaceholderIntent() {
        return this.placeholderIntent;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + this.filters.hashCode()) * 31) + this.placeholderIntent.hashCode();
    }

    public final SplitPlaceholderRule plus$window_release(ActivityFilter activityFilter) {
        k.e(activityFilter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(activityFilter);
        return new SplitPlaceholderRule(v.y(linkedHashSet), this.placeholderIntent, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }
}
