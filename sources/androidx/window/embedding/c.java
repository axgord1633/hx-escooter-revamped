package androidx.window.embedding;

import android.app.Activity;
import java.util.Set;
import java.util.function.Predicate;

public final /* synthetic */ class c implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Set f2824a;

    public /* synthetic */ c(Set set) {
        this.f2824a = set;
    }

    public final boolean test(Object obj) {
        return EmbeddingAdapter.m2translateActivityPredicates$lambda6(this.f2824a, (Activity) obj);
    }
}
