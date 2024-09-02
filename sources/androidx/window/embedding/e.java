package androidx.window.embedding;

import android.content.Intent;
import java.util.Set;
import java.util.function.Predicate;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Set f2826a;

    public /* synthetic */ e(Set set) {
        this.f2826a = set;
    }

    public final boolean test(Object obj) {
        return EmbeddingAdapter.m3translateIntentPredicates$lambda8(this.f2826a, (Intent) obj);
    }
}
