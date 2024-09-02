package androidx.window.embedding;

import android.util.Pair;
import java.util.Set;
import java.util.function.Predicate;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmbeddingAdapter f2822a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f2823b;

    public /* synthetic */ b(EmbeddingAdapter embeddingAdapter, Set set) {
        this.f2822a = embeddingAdapter;
        this.f2823b = set;
    }

    public final boolean test(Object obj) {
        return EmbeddingAdapter.m0translateActivityIntentPredicates$lambda3(this.f2822a, this.f2823b, (Pair) obj);
    }
}
