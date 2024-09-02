package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowInsets$Type;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import androidx.core.util.a;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.editing.SpellCheckPlugin;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlutterView extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate, KeyboardManager.ViewDelegate {
    private static final String TAG = "FlutterView";
    private AccessibilityBridge accessibilityBridge;
    private AndroidTouchProcessor androidTouchProcessor;
    /* access modifiers changed from: private */
    public FlutterEngine flutterEngine;
    private final Set<FlutterEngineAttachmentListener> flutterEngineAttachmentListeners;
    /* access modifiers changed from: private */
    public FlutterImageView flutterImageView;
    private FlutterSurfaceView flutterSurfaceView;
    private FlutterTextureView flutterTextureView;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    /* access modifiers changed from: private */
    public final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
    /* access modifiers changed from: private */
    public boolean isFlutterUiDisplayed;
    private KeyboardManager keyboardManager;
    private LocalizationPlugin localizationPlugin;
    private MouseCursorPlugin mouseCursorPlugin;
    private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    private RenderSurface previousRenderSurface;
    RenderSurface renderSurface;
    private SpellCheckPlugin spellCheckPlugin;
    private final ContentObserver systemSettingsObserver;
    private TextInputPlugin textInputPlugin;
    private TextServicesManager textServicesManager;
    private final FlutterRenderer.ViewportMetrics viewportMetrics;
    private final a<WindowLayoutInfo> windowInfoListener;
    private WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepo;

    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    private enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterView(Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
    }

    public FlutterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterImageView flutterImageView2) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z4, boolean z5) {
                FlutterView.this.resetWillNotDraw(z4, z5);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
            public boolean deliverSelfNotifications() {
                return true;
            }

            public void onChange(boolean z4) {
                super.onChange(z4);
                if (FlutterView.this.flutterEngine != null) {
                    Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                    FlutterView.this.sendUserSettingsToFlutter();
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new a<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.flutterImageView = flutterImageView2;
        this.renderSurface = flutterImageView2;
        init();
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterSurfaceView flutterSurfaceView2) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z4, boolean z5) {
                FlutterView.this.resetWillNotDraw(z4, z5);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
            public boolean deliverSelfNotifications() {
                return true;
            }

            public void onChange(boolean z4) {
                super.onChange(z4);
                if (FlutterView.this.flutterEngine != null) {
                    Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                    FlutterView.this.sendUserSettingsToFlutter();
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new a<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.flutterSurfaceView = flutterSurfaceView2;
        this.renderSurface = flutterSurfaceView2;
        init();
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterTextureView flutterTextureView2) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z4, boolean z5) {
                FlutterView.this.resetWillNotDraw(z4, z5);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
            public boolean deliverSelfNotifications() {
                return true;
            }

            public void onChange(boolean z4) {
                super.onChange(z4);
                if (FlutterView.this.flutterEngine != null) {
                    Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                    FlutterView.this.sendUserSettingsToFlutter();
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new a<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.flutterTextureView = flutterTextureView2;
        this.renderSurface = flutterTextureView2;
        init();
    }

    public FlutterView(Context context, FlutterImageView flutterImageView2) {
        this(context, (AttributeSet) null, flutterImageView2);
    }

    public FlutterView(Context context, FlutterSurfaceView flutterSurfaceView2) {
        this(context, (AttributeSet) null, flutterSurfaceView2);
    }

    public FlutterView(Context context, FlutterTextureView flutterTextureView2) {
        this(context, (AttributeSet) null, flutterTextureView2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: io.flutter.embedding.android.FlutterTextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: io.flutter.embedding.android.FlutterSurfaceView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: io.flutter.embedding.android.FlutterTextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: io.flutter.embedding.android.FlutterTextureView} */
    /* JADX WARNING: Multi-variable type inference failed */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlutterView(android.content.Context r4, io.flutter.embedding.android.RenderMode r5) {
        /*
            r3 = this;
            r0 = 0
            r3.<init>(r4, r0)
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r3.flutterUiDisplayListeners = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r3.flutterEngineAttachmentListeners = r0
            io.flutter.embedding.engine.renderer.FlutterRenderer$ViewportMetrics r0 = new io.flutter.embedding.engine.renderer.FlutterRenderer$ViewportMetrics
            r0.<init>()
            r3.viewportMetrics = r0
            io.flutter.embedding.android.FlutterView$1 r0 = new io.flutter.embedding.android.FlutterView$1
            r0.<init>()
            r3.onAccessibilityChangeListener = r0
            io.flutter.embedding.android.FlutterView$2 r0 = new io.flutter.embedding.android.FlutterView$2
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            r0.<init>(r1)
            r3.systemSettingsObserver = r0
            io.flutter.embedding.android.FlutterView$3 r0 = new io.flutter.embedding.android.FlutterView$3
            r0.<init>()
            r3.flutterUiDisplayListener = r0
            io.flutter.embedding.android.FlutterView$4 r0 = new io.flutter.embedding.android.FlutterView$4
            r0.<init>()
            r3.windowInfoListener = r0
            io.flutter.embedding.android.RenderMode r0 = io.flutter.embedding.android.RenderMode.surface
            if (r5 != r0) goto L_0x004c
            io.flutter.embedding.android.FlutterSurfaceView r5 = new io.flutter.embedding.android.FlutterSurfaceView
            r5.<init>(r4)
            r3.flutterSurfaceView = r5
        L_0x0049:
            r3.renderSurface = r5
            goto L_0x0058
        L_0x004c:
            io.flutter.embedding.android.RenderMode r0 = io.flutter.embedding.android.RenderMode.texture
            if (r5 != r0) goto L_0x005c
            io.flutter.embedding.android.FlutterTextureView r5 = new io.flutter.embedding.android.FlutterTextureView
            r5.<init>(r4)
            r3.flutterTextureView = r5
            goto L_0x0049
        L_0x0058:
            r3.init()
            return
        L_0x005c:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r5
            java.lang.String r5 = "RenderMode not supported with this constructor: %s"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterView.<init>(android.content.Context, io.flutter.embedding.android.RenderMode):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: io.flutter.embedding.android.FlutterTextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: io.flutter.embedding.android.FlutterSurfaceView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: io.flutter.embedding.android.FlutterTextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: io.flutter.embedding.android.FlutterTextureView} */
    /* JADX WARNING: Multi-variable type inference failed */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlutterView(android.content.Context r4, io.flutter.embedding.android.RenderMode r5, io.flutter.embedding.android.TransparencyMode r6) {
        /*
            r3 = this;
            r0 = 0
            r3.<init>(r4, r0)
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r3.flutterUiDisplayListeners = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r3.flutterEngineAttachmentListeners = r0
            io.flutter.embedding.engine.renderer.FlutterRenderer$ViewportMetrics r0 = new io.flutter.embedding.engine.renderer.FlutterRenderer$ViewportMetrics
            r0.<init>()
            r3.viewportMetrics = r0
            io.flutter.embedding.android.FlutterView$1 r0 = new io.flutter.embedding.android.FlutterView$1
            r0.<init>()
            r3.onAccessibilityChangeListener = r0
            io.flutter.embedding.android.FlutterView$2 r0 = new io.flutter.embedding.android.FlutterView$2
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            r0.<init>(r1)
            r3.systemSettingsObserver = r0
            io.flutter.embedding.android.FlutterView$3 r0 = new io.flutter.embedding.android.FlutterView$3
            r0.<init>()
            r3.flutterUiDisplayListener = r0
            io.flutter.embedding.android.FlutterView$4 r0 = new io.flutter.embedding.android.FlutterView$4
            r0.<init>()
            r3.windowInfoListener = r0
            io.flutter.embedding.android.RenderMode r0 = io.flutter.embedding.android.RenderMode.surface
            r1 = 0
            r2 = 1
            if (r5 != r0) goto L_0x0051
            io.flutter.embedding.android.FlutterSurfaceView r5 = new io.flutter.embedding.android.FlutterSurfaceView
            io.flutter.embedding.android.TransparencyMode r0 = io.flutter.embedding.android.TransparencyMode.transparent
            if (r6 != r0) goto L_0x004b
            r1 = r2
        L_0x004b:
            r5.<init>((android.content.Context) r4, (boolean) r1)
            r3.flutterSurfaceView = r5
            goto L_0x005c
        L_0x0051:
            io.flutter.embedding.android.RenderMode r6 = io.flutter.embedding.android.RenderMode.texture
            if (r5 != r6) goto L_0x0062
            io.flutter.embedding.android.FlutterTextureView r5 = new io.flutter.embedding.android.FlutterTextureView
            r5.<init>(r4)
            r3.flutterTextureView = r5
        L_0x005c:
            r3.renderSurface = r5
            r3.init()
            return
        L_0x0062:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r6[r1] = r5
            java.lang.String r5 = "RenderMode not supported with this constructor: %s"
            java.lang.String r5 = java.lang.String.format(r5, r6)
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterView.<init>(android.content.Context, io.flutter.embedding.android.RenderMode, io.flutter.embedding.android.TransparencyMode):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView(Context context, TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
    }

    private ZeroSides calculateShouldZeroSides() {
        Context context = getContext();
        int i5 = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i5 == 2) {
            if (rotation == 1) {
                return ZeroSides.RIGHT;
            }
            if (rotation == 3) {
                return ZeroSides.LEFT;
            }
            if (rotation == 0 || rotation == 2) {
                return ZeroSides.BOTH;
            }
        }
        return ZeroSides.NONE;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View findViewByAccessibilityIdRootedAtCurrentView(int r6, android.view.View r7) {
        /*
            r5 = this;
            r0 = 0
            java.lang.Class<android.view.View> r1 = android.view.View.class
            java.lang.String r2 = "getAccessibilityViewId"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch:{  }
            r2 = 1
            r1.setAccessible(r2)
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x003c }
            java.lang.Object r1 = r1.invoke(r7, r2)     // Catch:{ NoSuchMethodException -> 0x003c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ NoSuchMethodException -> 0x003c }
            boolean r1 = r1.equals(r2)     // Catch:{ NoSuchMethodException -> 0x003c }
            if (r1 == 0) goto L_0x0021
            return r7
        L_0x0021:
            boolean r1 = r7 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x003c
        L_0x0025:
            r1 = r7
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            int r2 = r1.getChildCount()
            if (r3 >= r2) goto L_0x003c
            android.view.View r1 = r1.getChildAt(r3)
            android.view.View r1 = r5.findViewByAccessibilityIdRootedAtCurrentView(r6, r1)
            if (r1 == 0) goto L_0x0039
            return r1
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0025
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterView.findViewByAccessibilityIdRootedAtCurrentView(int, android.view.View):android.view.View");
    }

    private int guessBottomKeyboardInset(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private void init() {
        View view;
        Log.v(TAG, "Initializing FlutterView");
        if (this.flutterSurfaceView != null) {
            Log.v(TAG, "Internally using a FlutterSurfaceView.");
            view = this.flutterSurfaceView;
        } else if (this.flutterTextureView != null) {
            Log.v(TAG, "Internally using a FlutterTextureView.");
            view = this.flutterTextureView;
        } else {
            Log.v(TAG, "Internally using a FlutterImageView.");
            view = this.flutterImageView;
        }
        addView(view);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
    }

    /* access modifiers changed from: private */
    public void releaseImageView() {
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 != null) {
            flutterImageView2.closeImageReader();
            removeView(this.flutterImageView);
            this.flutterImageView = null;
        }
    }

    /* access modifiers changed from: private */
    public void resetWillNotDraw(boolean z4, boolean z5) {
        boolean z6 = false;
        if (!this.flutterEngine.getRenderer().isSoftwareRenderingEnabled() && !z4 && !z5) {
            z6 = true;
        }
        setWillNotDraw(z6);
    }

    private void sendViewportMetricsToFlutter() {
        if (!isAttachedToFlutterEngine()) {
            Log.w(TAG, "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.viewportMetrics.physicalTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
    }

    public boolean acquireLatestImageViewFrame() {
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 != null) {
            return flutterImageView2.acquireLatestImage();
        }
        return false;
    }

    public void addFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.flutterEngineAttachmentListeners.add(flutterEngineAttachmentListener);
    }

    public void addOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener2) {
        this.flutterUiDisplayListeners.add(flutterUiDisplayListener2);
    }

    public void attachOverlaySurfaceToRender(FlutterImageView flutterImageView2) {
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            flutterImageView2.attachToRenderer(flutterEngine2.getRenderer());
        }
    }

    public void attachToFlutterEngine(FlutterEngine flutterEngine2) {
        Log.v(TAG, "Attaching to a FlutterEngine: " + flutterEngine2);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine2 == this.flutterEngine) {
                Log.v(TAG, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.v(TAG, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        this.flutterEngine = flutterEngine2;
        FlutterRenderer renderer = flutterEngine2.getRenderer();
        this.isFlutterUiDisplayed = renderer.isDisplayingFlutterUi();
        this.renderSurface.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        if (Build.VERSION.SDK_INT >= 24) {
            this.mouseCursorPlugin = new MouseCursorPlugin(this, this.flutterEngine.getMouseCursorChannel());
        }
        this.textInputPlugin = new TextInputPlugin(this, this.flutterEngine.getTextInputChannel(), this.flutterEngine.getPlatformViewsController());
        try {
            TextServicesManager textServicesManager2 = (TextServicesManager) getContext().getSystemService("textservices");
            this.textServicesManager = textServicesManager2;
            this.spellCheckPlugin = new SpellCheckPlugin(textServicesManager2, this.flutterEngine.getSpellCheckChannel());
        } catch (Exception unused) {
            Log.e(TAG, "TextServicesManager not supported by device, spell check disabled.");
        }
        this.localizationPlugin = this.flutterEngine.getLocalizationPlugin();
        this.keyboardManager = new KeyboardManager(this);
        this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer(), false);
        AccessibilityBridge accessibilityBridge2 = new AccessibilityBridge(this, flutterEngine2.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
        this.accessibilityBridge = accessibilityBridge2;
        accessibilityBridge2.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
        resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
        this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
        this.flutterEngine.getPlatformViewsController().attachToFlutterRenderer(this.flutterEngine.getRenderer());
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        sendUserSettingsToFlutter();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("show_password"), false, this.systemSettingsObserver);
        sendViewportMetricsToFlutter();
        flutterEngine2.getPlatformViewsController().attachToView(this);
        for (FlutterEngineAttachmentListener onFlutterEngineAttachedToFlutterView : this.flutterEngineAttachmentListeners) {
            onFlutterEngineAttachedToFlutterView.onFlutterEngineAttachedToFlutterView(flutterEngine2);
        }
        if (this.isFlutterUiDisplayed) {
            this.flutterUiDisplayListener.onFlutterUiDisplayed();
        }
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.textInputPlugin.autofill(sparseArray);
    }

    public boolean checkInputConnectionProxy(View view) {
        FlutterEngine flutterEngine2 = this.flutterEngine;
        return flutterEngine2 != null ? flutterEngine2.getPlatformViewsController().checkInputConnectionProxy(view) : super.checkInputConnectionProxy(view);
    }

    public void convertToImageView() {
        this.renderSurface.pause();
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 == null) {
            FlutterImageView createImageView = createImageView();
            this.flutterImageView = createImageView;
            addView(createImageView);
        } else {
            flutterImageView2.resizeIfNeeded(getWidth(), getHeight());
        }
        this.previousRenderSurface = this.renderSurface;
        FlutterImageView flutterImageView3 = this.flutterImageView;
        this.renderSurface = flutterImageView3;
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            flutterImageView3.attachToRenderer(flutterEngine2.getRenderer());
        }
    }

    public FlutterImageView createImageView() {
        return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    }

    /* access modifiers changed from: protected */
    public WindowInfoRepositoryCallbackAdapterWrapper createWindowInfoRepo() {
        try {
            return new WindowInfoRepositoryCallbackAdapterWrapper(new WindowInfoTrackerCallbackAdapter(WindowInfoTracker.Companion.getOrCreate(getContext())));
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public void detachFromFlutterEngine() {
        Log.v(TAG, "Detaching from a FlutterEngine: " + this.flutterEngine);
        if (!isAttachedToFlutterEngine()) {
            Log.v(TAG, "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (FlutterEngineAttachmentListener onFlutterEngineDetachedFromFlutterView : this.flutterEngineAttachmentListeners) {
            onFlutterEngineDetachedFromFlutterView.onFlutterEngineDetachedFromFlutterView();
        }
        getContext().getContentResolver().unregisterContentObserver(this.systemSettingsObserver);
        this.flutterEngine.getPlatformViewsController().detachFromView();
        this.flutterEngine.getPlatformViewsController().detachAccessibilityBridge();
        this.accessibilityBridge.release();
        this.accessibilityBridge = null;
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        this.textInputPlugin.destroy();
        this.keyboardManager.destroy();
        SpellCheckPlugin spellCheckPlugin2 = this.spellCheckPlugin;
        if (spellCheckPlugin2 != null) {
            spellCheckPlugin2.destroy();
        }
        MouseCursorPlugin mouseCursorPlugin2 = this.mouseCursorPlugin;
        if (mouseCursorPlugin2 != null) {
            mouseCursorPlugin2.destroy();
        }
        FlutterRenderer renderer = this.flutterEngine.getRenderer();
        this.isFlutterUiDisplayed = false;
        renderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        RenderSurface renderSurface2 = this.previousRenderSurface;
        if (renderSurface2 != null && this.renderSurface == this.flutterImageView) {
            this.renderSurface = renderSurface2;
        }
        this.renderSurface.detachFromRenderer();
        releaseImageView();
        this.previousRenderSurface = null;
        this.flutterEngine = null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (isAttachedToFlutterEngine() && this.keyboardManager.handleEvent(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findViewByAccessibilityIdTraversal(int r8) {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x000b
            android.view.View r8 = r7.findViewByAccessibilityIdRootedAtCurrentView(r8, r7)
            return r8
        L_0x000b:
            r0 = 0
            java.lang.Class<android.view.View> r1 = android.view.View.class
            java.lang.String r2 = "findViewByAccessibilityIdTraversal"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{  }
            r6 = 0
            r4[r6] = r5     // Catch:{  }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch:{  }
            r1.setAccessible(r3)
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x002e }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NoSuchMethodException -> 0x002e }
            r2[r6] = r8     // Catch:{ NoSuchMethodException -> 0x002e }
            java.lang.Object r8 = r1.invoke(r7, r2)     // Catch:{ NoSuchMethodException -> 0x002e }
            android.view.View r8 = (android.view.View) r8     // Catch:{ NoSuchMethodException -> 0x002e }
            return r8
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterView.findViewByAccessibilityIdTraversal(int):android.view.View");
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge2 = this.accessibilityBridge;
        if (accessibilityBridge2 == null || !accessibilityBridge2.isAccessibilityEnabled()) {
            return null;
        }
        return this.accessibilityBridge;
    }

    public FlutterEngine getAttachedFlutterEngine() {
        return this.flutterEngine;
    }

    public BinaryMessenger getBinaryMessenger() {
        return this.flutterEngine.getDartExecutor();
    }

    public FlutterImageView getCurrentImageSurface() {
        return this.flutterImageView;
    }

    public PointerIcon getSystemPointerIcon(int i5) {
        return PointerIcon.getSystemIcon(getContext(), i5);
    }

    public boolean hasRenderedFirstFrame() {
        return this.isFlutterUiDisplayed;
    }

    public boolean isAttachedToFlutterEngine() {
        FlutterEngine flutterEngine2 = this.flutterEngine;
        return flutterEngine2 != null && flutterEngine2.getRenderer() == this.renderSurface.getAttachedRenderer();
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 == 29) {
            Insets a5 = windowInsets.getSystemGestureInsets();
            FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
            viewportMetrics2.systemGestureInsetTop = a5.top;
            viewportMetrics2.systemGestureInsetRight = a5.right;
            viewportMetrics2.systemGestureInsetBottom = a5.bottom;
            viewportMetrics2.systemGestureInsetLeft = a5.left;
        }
        boolean z4 = true;
        int i6 = 0;
        boolean z5 = (getWindowSystemUiVisibility() & 4) == 0;
        if ((getWindowSystemUiVisibility() & 2) != 0) {
            z4 = false;
        }
        if (i5 >= 30) {
            if (z4) {
                i6 = 0 | WindowInsets$Type.navigationBars();
            }
            if (z5) {
                i6 |= WindowInsets$Type.statusBars();
            }
            Insets a6 = windowInsets.getInsets(i6);
            FlutterRenderer.ViewportMetrics viewportMetrics3 = this.viewportMetrics;
            viewportMetrics3.viewPaddingTop = a6.top;
            viewportMetrics3.viewPaddingRight = a6.right;
            viewportMetrics3.viewPaddingBottom = a6.bottom;
            viewportMetrics3.viewPaddingLeft = a6.left;
            Insets a7 = windowInsets.getInsets(WindowInsets$Type.ime());
            FlutterRenderer.ViewportMetrics viewportMetrics4 = this.viewportMetrics;
            viewportMetrics4.viewInsetTop = a7.top;
            viewportMetrics4.viewInsetRight = a7.right;
            viewportMetrics4.viewInsetBottom = a7.bottom;
            viewportMetrics4.viewInsetLeft = a7.left;
            Insets a8 = windowInsets.getInsets(WindowInsets$Type.systemGestures());
            FlutterRenderer.ViewportMetrics viewportMetrics5 = this.viewportMetrics;
            viewportMetrics5.systemGestureInsetTop = a8.top;
            viewportMetrics5.systemGestureInsetRight = a8.right;
            viewportMetrics5.systemGestureInsetBottom = a8.bottom;
            viewportMetrics5.systemGestureInsetLeft = a8.left;
            DisplayCutout a9 = windowInsets.getDisplayCutout();
            if (a9 != null) {
                Insets a10 = a9.getWaterfallInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics6 = this.viewportMetrics;
                viewportMetrics6.viewPaddingTop = Math.max(Math.max(viewportMetrics6.viewPaddingTop, a10.top), a9.getSafeInsetTop());
                FlutterRenderer.ViewportMetrics viewportMetrics7 = this.viewportMetrics;
                viewportMetrics7.viewPaddingRight = Math.max(Math.max(viewportMetrics7.viewPaddingRight, a10.right), a9.getSafeInsetRight());
                FlutterRenderer.ViewportMetrics viewportMetrics8 = this.viewportMetrics;
                viewportMetrics8.viewPaddingBottom = Math.max(Math.max(viewportMetrics8.viewPaddingBottom, a10.bottom), a9.getSafeInsetBottom());
                FlutterRenderer.ViewportMetrics viewportMetrics9 = this.viewportMetrics;
                viewportMetrics9.viewPaddingLeft = Math.max(Math.max(viewportMetrics9.viewPaddingLeft, a10.left), a9.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z4) {
                zeroSides = calculateShouldZeroSides();
            }
            this.viewportMetrics.viewPaddingTop = z5 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.viewportMetrics.viewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.viewportMetrics.viewPaddingBottom = (!z4 || guessBottomKeyboardInset(windowInsets) != 0) ? 0 : windowInsets.getSystemWindowInsetBottom();
            this.viewportMetrics.viewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            FlutterRenderer.ViewportMetrics viewportMetrics10 = this.viewportMetrics;
            viewportMetrics10.viewInsetTop = 0;
            viewportMetrics10.viewInsetRight = 0;
            viewportMetrics10.viewInsetBottom = guessBottomKeyboardInset(windowInsets);
            this.viewportMetrics.viewInsetLeft = 0;
        }
        Log.v(TAG, "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.viewportMetrics.viewPaddingTop + ", Left: " + this.viewportMetrics.viewPaddingLeft + ", Right: " + this.viewportMetrics.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight + "System Gesture Insets - Left: " + this.viewportMetrics.systemGestureInsetLeft + ", Top: " + this.viewportMetrics.systemGestureInsetTop + ", Right: " + this.viewportMetrics.systemGestureInsetRight + ", Bottom: " + this.viewportMetrics.viewInsetBottom);
        sendViewportMetricsToFlutter();
        return onApplyWindowInsets;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.windowInfoRepo = createWindowInfoRepo();
        Activity activity = ViewUtils.getActivity(getContext());
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.windowInfoRepo;
        if (windowInfoRepositoryCallbackAdapterWrapper != null && activity != null) {
            windowInfoRepositoryCallbackAdapterWrapper.addWindowLayoutInfoListener(activity, androidx.core.content.a.f(getContext()), this.windowInfoListener);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.flutterEngine != null) {
            Log.v(TAG, "Configuration changed. Sending locales and user settings to Flutter.");
            this.localizationPlugin.sendLocalesToFlutter(configuration);
            sendUserSettingsToFlutter();
            ViewUtils.calculateMaximumDisplayMetrics(getContext(), this.flutterEngine);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return !isAttachedToFlutterEngine() ? super.onCreateInputConnection(editorInfo) : this.textInputPlugin.createInputConnection(this, this.keyboardManager, editorInfo);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.windowInfoRepo;
        if (windowInfoRepositoryCallbackAdapterWrapper != null) {
            windowInfoRepositoryCallbackAdapterWrapper.removeWindowLayoutInfoListener(this.windowInfoListener);
        }
        this.windowInfoRepo = null;
        super.onDetachedFromWindow();
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (isAttachedToFlutterEngine() && this.androidTouchProcessor.onGenericMotionEvent(motionEvent, getContext())) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        return !isAttachedToFlutterEngine() ? super.onHoverEvent(motionEvent) : this.accessibilityBridge.onAccessibilityHoverEvent(motionEvent);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i5) {
        super.onProvideAutofillVirtualStructure(viewStructure, i5);
        this.textInputPlugin.onProvideAutofillVirtualStructure(viewStructure, i5);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        Log.v(TAG, "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i7 + " x " + i8 + ", it is now " + i5 + " x " + i6);
        FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
        viewportMetrics2.width = i5;
        viewportMetrics2.height = i6;
        sendViewportMetricsToFlutter();
    }

    public boolean onTextInputKeyEvent(KeyEvent keyEvent) {
        return this.textInputPlugin.handleKeyEvent(keyEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onTouchEvent(motionEvent);
        }
        requestUnbufferedDispatch(motionEvent);
        return this.androidTouchProcessor.onTouchEvent(motionEvent);
    }

    public void redispatch(KeyEvent keyEvent) {
        getRootView().dispatchKeyEvent(keyEvent);
    }

    public void removeFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.flutterEngineAttachmentListeners.remove(flutterEngineAttachmentListener);
    }

    public void removeOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener2) {
        this.flutterUiDisplayListeners.remove(flutterUiDisplayListener2);
    }

    public void revertImageView(final Runnable runnable) {
        if (this.flutterImageView == null) {
            Log.v(TAG, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface2 = this.previousRenderSurface;
        if (renderSurface2 == null) {
            Log.v(TAG, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.renderSurface = renderSurface2;
        this.previousRenderSurface = null;
        final FlutterRenderer renderer = this.flutterEngine.getRenderer();
        if (this.flutterEngine == null || renderer == null) {
            this.flutterImageView.detachFromRenderer();
            releaseImageView();
            runnable.run();
            return;
        }
        this.renderSurface.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                renderer.removeIsDisplayingFlutterUiListener(this);
                runnable.run();
                FlutterView flutterView = FlutterView.this;
                if (!(flutterView.renderSurface instanceof FlutterImageView) && flutterView.flutterImageView != null) {
                    FlutterView.this.flutterImageView.detachFromRenderer();
                    FlutterView.this.releaseImageView();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        if (r3 != false) goto L_0x0041;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendUserSettingsToFlutter() {
        /*
            r6 = this;
            android.content.res.Resources r0 = r6.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & 48
            r1 = 0
            r2 = 1
            r3 = 32
            if (r0 != r3) goto L_0x0014
            r0 = r2
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            io.flutter.embedding.engine.systemchannels.SettingsChannel$PlatformBrightness r0 = io.flutter.embedding.engine.systemchannels.SettingsChannel.PlatformBrightness.dark
            goto L_0x001c
        L_0x001a:
            io.flutter.embedding.engine.systemchannels.SettingsChannel$PlatformBrightness r0 = io.flutter.embedding.engine.systemchannels.SettingsChannel.PlatformBrightness.light
        L_0x001c:
            android.view.textservice.TextServicesManager r3 = r6.textServicesManager
            if (r3 == 0) goto L_0x0043
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r4 < r5) goto L_0x0041
            java.util.List r3 = r3.getEnabledSpellCheckerInfos()
            java.util.stream.Stream r3 = r3.stream()
            io.flutter.embedding.android.j r4 = new io.flutter.embedding.android.j
            r4.<init>()
            boolean r3 = r3.anyMatch(r4)
            android.view.textservice.TextServicesManager r4 = r6.textServicesManager
            boolean r4 = r4.isSpellCheckerEnabled()
            if (r4 == 0) goto L_0x0043
            if (r3 == 0) goto L_0x0043
        L_0x0041:
            r3 = r2
            goto L_0x0044
        L_0x0043:
            r3 = r1
        L_0x0044:
            io.flutter.embedding.engine.FlutterEngine r4 = r6.flutterEngine
            io.flutter.embedding.engine.systemchannels.SettingsChannel r4 = r4.getSettingsChannel()
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r4 = r4.startMessage()
            android.content.res.Resources r5 = r6.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            float r5 = r5.fontScale
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r4 = r4.setTextScaleFactor(r5)
            android.content.res.Resources r5 = r6.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r4 = r4.setDisplayMetrics(r5)
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r3 = r4.setNativeSpellCheckServiceDefined(r3)
            android.content.Context r4 = r6.getContext()
            android.content.ContentResolver r4 = r4.getContentResolver()
            java.lang.String r5 = "show_password"
            int r4 = android.provider.Settings.System.getInt(r4, r5, r2)
            if (r4 != r2) goto L_0x007d
            r1 = r2
        L_0x007d:
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r1 = r3.setBrieflyShowPassword(r1)
            android.content.Context r2 = r6.getContext()
            boolean r2 = android.text.format.DateFormat.is24HourFormat(r2)
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r1 = r1.setUse24HourFormat(r2)
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r0 = r1.setPlatformBrightness(r0)
            r0.send()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterView.sendUserSettingsToFlutter():void");
    }

    public void setVisibility(int i5) {
        super.setVisibility(i5);
        RenderSurface renderSurface2 = this.renderSurface;
        if (renderSurface2 instanceof FlutterSurfaceView) {
            ((FlutterSurfaceView) renderSurface2).setVisibility(i5);
        }
    }

    /* access modifiers changed from: protected */
    public void setWindowInfoListenerDisplayFeatures(WindowLayoutInfo windowLayoutInfo) {
        WindowInsets rootWindowInsets;
        DisplayCutout a5;
        List<DisplayFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        ArrayList arrayList = new ArrayList();
        for (DisplayFeature next : displayFeatures) {
            Log.v(TAG, "WindowInfoTracker Display Feature reported with bounds = " + next.getBounds().toString() + " and type = " + next.getClass().getSimpleName());
            if (next instanceof FoldingFeature) {
                FoldingFeature foldingFeature = (FoldingFeature) next;
                arrayList.add(new FlutterRenderer.DisplayFeature(next.getBounds(), foldingFeature.getOcclusionType() == FoldingFeature.OcclusionType.FULL ? FlutterRenderer.DisplayFeatureType.HINGE : FlutterRenderer.DisplayFeatureType.FOLD, foldingFeature.getState() == FoldingFeature.State.FLAT ? FlutterRenderer.DisplayFeatureState.POSTURE_FLAT : foldingFeature.getState() == FoldingFeature.State.HALF_OPENED ? FlutterRenderer.DisplayFeatureState.POSTURE_HALF_OPENED : FlutterRenderer.DisplayFeatureState.UNKNOWN));
            } else {
                arrayList.add(new FlutterRenderer.DisplayFeature(next.getBounds(), FlutterRenderer.DisplayFeatureType.UNKNOWN, FlutterRenderer.DisplayFeatureState.UNKNOWN));
            }
        }
        if (!(Build.VERSION.SDK_INT < 28 || (rootWindowInsets = getRootWindowInsets()) == null || (a5 = rootWindowInsets.getDisplayCutout()) == null)) {
            for (Rect next2 : a5.getBoundingRects()) {
                Log.v(TAG, "DisplayCutout area reported with bounds = " + next2.toString());
                arrayList.add(new FlutterRenderer.DisplayFeature(next2, FlutterRenderer.DisplayFeatureType.CUTOUT));
            }
        }
        this.viewportMetrics.displayFeatures = arrayList;
        sendViewportMetricsToFlutter();
    }
}
