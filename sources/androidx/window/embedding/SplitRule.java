package androidx.window.embedding;

import android.graphics.Rect;
import android.os.Build;
import android.view.WindowMetrics;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public class SplitRule extends EmbeddingRule {
    private final int layoutDirection;
    private final int minSmallestWidth;
    private final int minWidth;
    private final float splitRatio;

    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        public final Rect getBounds(WindowMetrics windowMetrics) {
            k.e(windowMetrics, "windowMetrics");
            Rect bounds = windowMetrics.getBounds();
            k.d(bounds, "windowMetrics.bounds");
            return bounds;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutDir {
    }

    public SplitRule() {
        this(0, 0, CropImageView.DEFAULT_ASPECT_RATIO, 0, 15, (g) null);
    }

    public SplitRule(int i5, int i6, float f5, int i7) {
        this.minWidth = i5;
        this.minSmallestWidth = i6;
        this.splitRatio = f5;
        this.layoutDirection = i7;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SplitRule(int i5, int i6, float f5, int i7, int i8, g gVar) {
        this((i8 & 1) != 0 ? 0 : i5, (i8 & 2) != 0 ? 0 : i6, (i8 & 4) != 0 ? 0.5f : f5, (i8 & 8) != 0 ? 3 : i7);
    }

    public final boolean checkParentMetrics(WindowMetrics windowMetrics) {
        k.e(windowMetrics, "parentMetrics");
        if (Build.VERSION.SDK_INT <= 30) {
            return false;
        }
        Rect bounds = Api30Impl.INSTANCE.getBounds(windowMetrics);
        return (this.minWidth == 0 || bounds.width() >= this.minWidth) && (this.minSmallestWidth == 0 || Math.min(bounds.width(), bounds.height()) >= this.minSmallestWidth);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitRule)) {
            return false;
        }
        SplitRule splitRule = (SplitRule) obj;
        if (this.minWidth != splitRule.minWidth || this.minSmallestWidth != splitRule.minSmallestWidth) {
            return false;
        }
        return ((this.splitRatio > splitRule.splitRatio ? 1 : (this.splitRatio == splitRule.splitRatio ? 0 : -1)) == 0) && this.layoutDirection == splitRule.layoutDirection;
    }

    public final int getLayoutDirection() {
        return this.layoutDirection;
    }

    public final int getMinSmallestWidth() {
        return this.minSmallestWidth;
    }

    public final int getMinWidth() {
        return this.minWidth;
    }

    public final float getSplitRatio() {
        return this.splitRatio;
    }

    public int hashCode() {
        return (((((this.minWidth * 31) + this.minSmallestWidth) * 31) + Float.floatToIntBits(this.splitRatio)) * 31) + this.layoutDirection;
    }
}
