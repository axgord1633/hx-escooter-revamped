package io.flutter.plugin.editing;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets$Builder;
import android.view.WindowInsets$Type;
import android.view.WindowInsetsAnimation;
import androidx.core.view.k0;
import androidx.core.view.o1;
import java.util.List;

class ImeSyncDeferringInsetsCallback {
    /* access modifiers changed from: private */
    public boolean animating = false;
    private AnimationCallback animationCallback;
    /* access modifiers changed from: private */
    public final int deferredInsetTypes = WindowInsets$Type.ime();
    /* access modifiers changed from: private */
    public ImeVisibleListener imeVisibleListener;
    private InsetsListener insetsListener;
    /* access modifiers changed from: private */
    public WindowInsets lastWindowInsets;
    /* access modifiers changed from: private */
    public boolean needsSave = false;
    /* access modifiers changed from: private */
    public View view;

    private class AnimationCallback extends WindowInsetsAnimation.Callback {
        AnimationCallback() {
            super(1);
        }

        public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
            if (ImeSyncDeferringInsetsCallback.this.animating && (windowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                boolean unused = ImeSyncDeferringInsetsCallback.this.animating = false;
                if (ImeSyncDeferringInsetsCallback.this.lastWindowInsets != null && ImeSyncDeferringInsetsCallback.this.view != null) {
                    ImeSyncDeferringInsetsCallback.this.view.dispatchApplyWindowInsets(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
                }
            }
        }

        public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
            boolean unused = ImeSyncDeferringInsetsCallback.this.needsSave = true;
            if ((windowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                boolean unused2 = ImeSyncDeferringInsetsCallback.this.animating = true;
            }
        }

        public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
            if (ImeSyncDeferringInsetsCallback.this.animating && !ImeSyncDeferringInsetsCallback.this.needsSave) {
                boolean z4 = false;
                for (WindowInsetsAnimation typeMask : list) {
                    if ((typeMask.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                        z4 = true;
                    }
                }
                if (!z4) {
                    return windowInsets;
                }
                int windowSystemUiVisibility = ImeSyncDeferringInsetsCallback.this.view.getWindowSystemUiVisibility();
                int i5 = ((windowSystemUiVisibility & 512) == 0 && (windowSystemUiVisibility & 2) == 0) ? windowInsets.getInsets(WindowInsets$Type.navigationBars()).bottom : 0;
                WindowInsets$Builder windowInsets$Builder = new WindowInsets$Builder(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
                WindowInsets$Builder unused = windowInsets$Builder.setInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes, Insets.of(0, 0, 0, Math.max(windowInsets.getInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes).bottom - i5, 0)));
                ImeSyncDeferringInsetsCallback.this.view.onApplyWindowInsets(windowInsets$Builder.build());
            }
            return windowInsets;
        }

        public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
            o1 t5 = k0.t(ImeSyncDeferringInsetsCallback.this.view);
            if (!(t5 == null || ImeSyncDeferringInsetsCallback.this.imeVisibleListener == null)) {
                ImeSyncDeferringInsetsCallback.this.imeVisibleListener.onImeVisibleChanged(t5.o(o1.m.a()));
            }
            return super.onStart(windowInsetsAnimation, bounds);
        }
    }

    public interface ImeVisibleListener {
        void onImeVisibleChanged(boolean z4);
    }

    private class InsetsListener implements View.OnApplyWindowInsetsListener {
        private InsetsListener() {
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            View unused = ImeSyncDeferringInsetsCallback.this.view = view;
            if (ImeSyncDeferringInsetsCallback.this.needsSave) {
                WindowInsets unused2 = ImeSyncDeferringInsetsCallback.this.lastWindowInsets = windowInsets;
                boolean unused3 = ImeSyncDeferringInsetsCallback.this.needsSave = false;
            }
            return ImeSyncDeferringInsetsCallback.this.animating ? WindowInsets.CONSUMED : view.onApplyWindowInsets(windowInsets);
        }
    }

    ImeSyncDeferringInsetsCallback(View view2) {
        this.view = view2;
        this.animationCallback = new AnimationCallback();
        this.insetsListener = new InsetsListener();
    }

    /* access modifiers changed from: package-private */
    public WindowInsetsAnimation.Callback getAnimationCallback() {
        return this.animationCallback;
    }

    /* access modifiers changed from: package-private */
    public ImeVisibleListener getImeVisibleListener() {
        return this.imeVisibleListener;
    }

    /* access modifiers changed from: package-private */
    public View.OnApplyWindowInsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    /* access modifiers changed from: package-private */
    public void install() {
        this.view.setWindowInsetsAnimationCallback(this.animationCallback);
        this.view.setOnApplyWindowInsetsListener(this.insetsListener);
    }

    /* access modifiers changed from: package-private */
    public void remove() {
        this.view.setWindowInsetsAnimationCallback((WindowInsetsAnimation.Callback) null);
        this.view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
    }

    /* access modifiers changed from: package-private */
    public void setImeVisibleListener(ImeVisibleListener imeVisibleListener2) {
        this.imeVisibleListener = imeVisibleListener2;
    }
}
