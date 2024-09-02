package androidx.window.embedding;

import android.view.WindowMetrics;
import java.util.function.Predicate;

public final /* synthetic */ class d implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplitRule f2825a;

    public /* synthetic */ d(SplitRule splitRule) {
        this.f2825a = splitRule;
    }

    public final boolean test(Object obj) {
        return EmbeddingAdapter.m4translateParentMetricsPredicate$lambda4(this.f2825a, (WindowMetrics) obj);
    }
}
