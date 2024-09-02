package androidx.window.embedding;

import android.app.Activity;
import androidx.core.util.a;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public interface EmbeddingBackend {
    Set<EmbeddingRule> getSplitRules();

    boolean isSplitSupported();

    void registerRule(EmbeddingRule embeddingRule);

    void registerSplitListenerForActivity(Activity activity, Executor executor, a<List<SplitInfo>> aVar);

    void setSplitRules(Set<? extends EmbeddingRule> set);

    void unregisterRule(EmbeddingRule embeddingRule);

    void unregisterSplitListenerForActivity(a<List<SplitInfo>> aVar);
}
