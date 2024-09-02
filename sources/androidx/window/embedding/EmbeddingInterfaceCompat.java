package androidx.window.embedding;

import java.util.List;
import java.util.Set;

public interface EmbeddingInterfaceCompat {

    public interface EmbeddingCallbackInterface {
        void onSplitInfoChanged(List<SplitInfo> list);
    }

    void setEmbeddingCallback(EmbeddingCallbackInterface embeddingCallbackInterface);

    void setSplitRules(Set<? extends EmbeddingRule> set);
}
