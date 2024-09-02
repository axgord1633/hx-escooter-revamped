package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.a;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import m3.q;

public final class SplitController {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static volatile SplitController globalInstance = null;
    /* access modifiers changed from: private */
    public static final ReentrantLock globalLock = new ReentrantLock();
    public static final boolean sDebug = false;
    private final EmbeddingBackend embeddingBackend;
    private Set<? extends EmbeddingRule> staticSplitRules;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final SplitController getInstance() {
            if (SplitController.globalInstance == null) {
                ReentrantLock access$getGlobalLock$cp = SplitController.globalLock;
                access$getGlobalLock$cp.lock();
                try {
                    if (SplitController.globalInstance == null) {
                        SplitController.globalInstance = new SplitController((g) null);
                    }
                    q qVar = q.f5904a;
                } finally {
                    access$getGlobalLock$cp.unlock();
                }
            }
            SplitController access$getGlobalInstance$cp = SplitController.globalInstance;
            k.b(access$getGlobalInstance$cp);
            return access$getGlobalInstance$cp;
        }

        public final void initialize(Context context, int i5) {
            k.e(context, "context");
            Set<EmbeddingRule> parseSplitRules$window_release = new SplitRuleParser().parseSplitRules$window_release(context, i5);
            SplitController instance = getInstance();
            if (parseSplitRules$window_release == null) {
                parseSplitRules$window_release = j0.b();
            }
            instance.setStaticSplitRules(parseSplitRules$window_release);
        }
    }

    private SplitController() {
        this.embeddingBackend = ExtensionEmbeddingBackend.Companion.getInstance();
        this.staticSplitRules = j0.b();
    }

    public /* synthetic */ SplitController(g gVar) {
        this();
    }

    public static final SplitController getInstance() {
        return Companion.getInstance();
    }

    public static final void initialize(Context context, int i5) {
        Companion.initialize(context, i5);
    }

    /* access modifiers changed from: private */
    public final void setStaticSplitRules(Set<? extends EmbeddingRule> set) {
        this.staticSplitRules = set;
        this.embeddingBackend.setSplitRules(set);
    }

    public final void addSplitListener(Activity activity, Executor executor, a<List<SplitInfo>> aVar) {
        k.e(activity, "activity");
        k.e(executor, "executor");
        k.e(aVar, "consumer");
        this.embeddingBackend.registerSplitListenerForActivity(activity, executor, aVar);
    }

    public final void clearRegisteredRules() {
        this.embeddingBackend.setSplitRules(this.staticSplitRules);
    }

    public final Set<EmbeddingRule> getSplitRules() {
        return v.y(this.embeddingBackend.getSplitRules());
    }

    public final boolean isSplitSupported() {
        return this.embeddingBackend.isSplitSupported();
    }

    public final void registerRule(EmbeddingRule embeddingRule) {
        k.e(embeddingRule, "rule");
        this.embeddingBackend.registerRule(embeddingRule);
    }

    public final void removeSplitListener(a<List<SplitInfo>> aVar) {
        k.e(aVar, "consumer");
        this.embeddingBackend.unregisterSplitListenerForActivity(aVar);
    }

    public final void unregisterRule(EmbeddingRule embeddingRule) {
        k.e(embeddingRule, "rule");
        this.embeddingBackend.unregisterRule(embeddingRule);
    }
}
