package androidx.window.embedding;

import android.util.Log;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class EmbeddingCompat implements EmbeddingInterfaceCompat {
    public static final Companion Companion = new Companion((g) null);
    public static final boolean DEBUG = true;
    private static final String TAG = "EmbeddingCompat";
    private final EmbeddingAdapter adapter;
    private final ActivityEmbeddingComponent embeddingExtension;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final ActivityEmbeddingComponent embeddingComponent() {
            EmptyEmbeddingComponent emptyEmbeddingComponent;
            if (isEmbeddingAvailable()) {
                ActivityEmbeddingComponent activityEmbeddingComponent = WindowExtensionsProvider.getWindowExtensions().getActivityEmbeddingComponent();
                if (activityEmbeddingComponent != null) {
                    return activityEmbeddingComponent;
                }
                emptyEmbeddingComponent = new EmptyEmbeddingComponent();
            } else {
                emptyEmbeddingComponent = new EmptyEmbeddingComponent();
            }
            return (ActivityEmbeddingComponent) emptyEmbeddingComponent;
        }

        public final Integer getExtensionApiLevel() {
            String str;
            try {
                return Integer.valueOf(WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel());
            } catch (NoClassDefFoundError unused) {
                str = "Embedding extension version not found";
                Log.d(EmbeddingCompat.TAG, str);
                return null;
            } catch (UnsupportedOperationException unused2) {
                str = "Stub Extension";
                Log.d(EmbeddingCompat.TAG, str);
                return null;
            }
        }

        public final boolean isEmbeddingAvailable() {
            String str;
            try {
                return WindowExtensionsProvider.getWindowExtensions().getActivityEmbeddingComponent() != null;
            } catch (NoClassDefFoundError unused) {
                str = "Embedding extension version not found";
                Log.d(EmbeddingCompat.TAG, str);
                return false;
            } catch (UnsupportedOperationException unused2) {
                str = "Stub Extension";
                Log.d(EmbeddingCompat.TAG, str);
                return false;
            }
        }
    }

    public EmbeddingCompat() {
        this(Companion.embeddingComponent(), new EmbeddingAdapter());
    }

    public EmbeddingCompat(ActivityEmbeddingComponent activityEmbeddingComponent, EmbeddingAdapter embeddingAdapter) {
        k.e(activityEmbeddingComponent, "embeddingExtension");
        k.e(embeddingAdapter, "adapter");
        this.embeddingExtension = activityEmbeddingComponent;
        this.adapter = embeddingAdapter;
    }

    public void setEmbeddingCallback(EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallbackInterface) {
        k.e(embeddingCallbackInterface, "embeddingCallback");
        this.embeddingExtension.setSplitInfoCallback(new EmbeddingTranslatingCallback(embeddingCallbackInterface, this.adapter));
    }

    public void setSplitRules(Set<? extends EmbeddingRule> set) {
        k.e(set, "rules");
        this.embeddingExtension.setEmbeddingRules(this.adapter.translate(set));
    }
}
