package io.flutter.plugin.platform;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import io.flutter.embedding.android.FlutterImageView;

public class PlatformOverlayView extends FlutterImageView {
    private AccessibilityEventsDelegate accessibilityDelegate;

    public PlatformOverlayView(Context context) {
        this(context, 1, 1, (AccessibilityEventsDelegate) null);
    }

    public PlatformOverlayView(Context context, int i5, int i6, AccessibilityEventsDelegate accessibilityEventsDelegate) {
        super(context, i5, i6, FlutterImageView.SurfaceKind.overlay);
        this.accessibilityDelegate = accessibilityEventsDelegate;
    }

    public PlatformOverlayView(Context context, AttributeSet attributeSet) {
        this(context, 1, 1, (AccessibilityEventsDelegate) null);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        AccessibilityEventsDelegate accessibilityEventsDelegate = this.accessibilityDelegate;
        if (accessibilityEventsDelegate == null || !accessibilityEventsDelegate.onAccessibilityHoverEvent(motionEvent, true)) {
            return super.onHoverEvent(motionEvent);
        }
        return true;
    }
}
