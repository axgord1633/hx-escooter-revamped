package androidx.window.embedding;

import android.util.Pair;
import java.util.Set;
import java.util.function.Predicate;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmbeddingAdapter f2827a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f2828b;

    public /* synthetic */ f(EmbeddingAdapter embeddingAdapter, Set set) {
        this.f2827a = embeddingAdapter;
        this.f2828b = set;
    }

    public final boolean test(Object obj) {
        return EmbeddingAdapter.m1translateActivityPairPredicates$lambda1(this.f2827a, this.f2828b, (Pair) obj);
    }
}
