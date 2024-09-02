package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
import android.view.inputmethod.InputMethodManager;
import io.flutter.Log;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.common.ActivityLifecycleListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.a;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Deprecated
public class FlutterView extends SurfaceView implements BinaryMessenger, TextureRegistry, MouseCursorPlugin.MouseCursorViewDelegate, KeyboardManager.ViewDelegate {
    private static final String TAG = "FlutterView";
    private final AndroidTouchProcessor androidTouchProcessor;
    private final DartExecutor dartExecutor;
    private boolean didRenderFirstFrame;
    private final FlutterRenderer flutterRenderer;
    private final LifecycleChannel lifecycleChannel;
    private final LocalizationChannel localizationChannel;
    private AccessibilityBridge mAccessibilityNodeProvider;
    private final List<ActivityLifecycleListener> mActivityLifecycleListeners;
    private final List<FirstFrameListener> mFirstFrameListeners;
    private final InputMethodManager mImm;
    private boolean mIsSoftwareRenderingEnabled;
    private final KeyboardManager mKeyboardManager;
    private final LocalizationPlugin mLocalizationPlugin;
    private final ViewportMetrics mMetrics;
    private final MouseCursorPlugin mMouseCursorPlugin;
    /* access modifiers changed from: private */
    public FlutterNativeView mNativeView;
    private final SurfaceHolder.Callback mSurfaceCallback;
    private final TextInputPlugin mTextInputPlugin;
    private final NavigationChannel navigationChannel;
    private final AtomicLong nextTextureId;
    private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    private final PlatformChannel platformChannel;
    private final SettingsChannel settingsChannel;
    private final SystemChannel systemChannel;

    public interface FirstFrameListener {
        void onFirstFrame();
    }

    public interface Provider {
        FlutterView getFlutterView();
    }

    final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        /* access modifiers changed from: private */
        public final long id;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (!SurfaceTextureRegistryEntry.this.released && FlutterView.this.mNativeView != null) {
                    FlutterView.this.mNativeView.getFlutterJNI().markTextureFrameAvailable(SurfaceTextureRegistryEntry.this.id);
                }
            }
        };
        /* access modifiers changed from: private */
        public boolean released;
        private final SurfaceTextureWrapper textureWrapper;

        SurfaceTextureRegistryEntry(long j5, SurfaceTexture surfaceTexture) {
            this.id = j5;
            this.textureWrapper = new SurfaceTextureWrapper(surfaceTexture);
            surfaceTexture().setOnFrameAvailableListener(this.onFrameListener, new Handler());
        }

        public long id() {
            return this.id;
        }

        public void release() {
            if (!this.released) {
                this.released = true;
                surfaceTexture().setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                this.textureWrapper.release();
                FlutterView.this.mNativeView.getFlutterJNI().unregisterTexture(this.id);
            }
        }

        public /* synthetic */ void setOnFrameConsumedListener(TextureRegistry.OnFrameConsumedListener onFrameConsumedListener) {
            o.a(this, onFrameConsumedListener);
        }

        public /* synthetic */ void setOnTrimMemoryListener(TextureRegistry.OnTrimMemoryListener onTrimMemoryListener) {
            o.b(this, onTrimMemoryListener);
        }

        public SurfaceTexture surfaceTexture() {
            return this.textureWrapper.surfaceTexture();
        }

        public SurfaceTextureWrapper textureWrapper() {
            return this.textureWrapper;
        }
    }

    static final class ViewportMetrics {
        float devicePixelRatio = 1.0f;
        int physicalHeight = 0;
        int physicalTouchSlop = -1;
        int physicalViewInsetBottom = 0;
        int physicalViewInsetLeft = 0;
        int physicalViewInsetRight = 0;
        int physicalViewInsetTop = 0;
        int physicalViewPaddingBottom = 0;
        int physicalViewPaddingLeft = 0;
        int physicalViewPaddingRight = 0;
        int physicalViewPaddingTop = 0;
        int physicalWidth = 0;
        int systemGestureInsetBottom = 0;
        int systemGestureInsetLeft = 0;
        int systemGestureInsetRight = 0;
        int systemGestureInsetTop = 0;

        ViewportMetrics() {
        }
    }

    private enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlutterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (FlutterNativeView) null);
    }

    public FlutterView(Context context, AttributeSet attributeSet, FlutterNativeView flutterNativeView) {
        super(context, attributeSet);
        this.nextTextureId = new AtomicLong(0);
        this.mIsSoftwareRenderingEnabled = false;
        this.didRenderFirstFrame = false;
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z4, boolean z5) {
                FlutterView.this.resetWillNotDraw(z4, z5);
            }
        };
        Activity activity = ViewUtils.getActivity(getContext());
        if (activity != null) {
            this.mNativeView = flutterNativeView == null ? new FlutterNativeView(activity.getApplicationContext()) : flutterNativeView;
            DartExecutor dartExecutor2 = this.mNativeView.getDartExecutor();
            this.dartExecutor = dartExecutor2;
            FlutterRenderer flutterRenderer2 = new FlutterRenderer(this.mNativeView.getFlutterJNI());
            this.flutterRenderer = flutterRenderer2;
            this.mIsSoftwareRenderingEnabled = this.mNativeView.getFlutterJNI().getIsSoftwareRenderingEnabled();
            ViewportMetrics viewportMetrics = new ViewportMetrics();
            this.mMetrics = viewportMetrics;
            viewportMetrics.devicePixelRatio = context.getResources().getDisplayMetrics().density;
            viewportMetrics.physicalTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            setFocusable(true);
            setFocusableInTouchMode(true);
            this.mNativeView.attachViewAndActivity(this, activity);
            AnonymousClass2 r22 = new SurfaceHolder.Callback() {
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i5, int i6, int i7) {
                    FlutterView.this.assertAttached();
                    FlutterView.this.mNativeView.getFlutterJNI().onSurfaceChanged(i6, i7);
                }

                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    FlutterView.this.assertAttached();
                    FlutterView.this.mNativeView.getFlutterJNI().onSurfaceCreated(surfaceHolder.getSurface());
                }

                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    FlutterView.this.assertAttached();
                    FlutterView.this.mNativeView.getFlutterJNI().onSurfaceDestroyed();
                }
            };
            this.mSurfaceCallback = r22;
            getHolder().addCallback(r22);
            this.mActivityLifecycleListeners = new ArrayList();
            this.mFirstFrameListeners = new ArrayList();
            this.navigationChannel = new NavigationChannel(dartExecutor2);
            this.lifecycleChannel = new LifecycleChannel(dartExecutor2);
            LocalizationChannel localizationChannel2 = new LocalizationChannel(dartExecutor2);
            this.localizationChannel = localizationChannel2;
            PlatformChannel platformChannel2 = new PlatformChannel(dartExecutor2);
            this.platformChannel = platformChannel2;
            this.systemChannel = new SystemChannel(dartExecutor2);
            this.settingsChannel = new SettingsChannel(dartExecutor2);
            final PlatformPlugin platformPlugin = new PlatformPlugin(activity, platformChannel2);
            addActivityLifecycleListener(new ActivityLifecycleListener() {
                public void onPostResume() {
                    platformPlugin.updateSystemUiOverlays();
                }
            });
            this.mImm = (InputMethodManager) getContext().getSystemService("input_method");
            PlatformViewsController platformViewsController = this.mNativeView.getPluginRegistry().getPlatformViewsController();
            TextInputPlugin textInputPlugin = new TextInputPlugin(this, new TextInputChannel(dartExecutor2), platformViewsController);
            this.mTextInputPlugin = textInputPlugin;
            this.mKeyboardManager = new KeyboardManager(this);
            if (Build.VERSION.SDK_INT >= 24) {
                this.mMouseCursorPlugin = new MouseCursorPlugin(this, new MouseCursorChannel(dartExecutor2));
            } else {
                this.mMouseCursorPlugin = null;
            }
            LocalizationPlugin localizationPlugin = new LocalizationPlugin(context, localizationChannel2);
            this.mLocalizationPlugin = localizationPlugin;
            this.androidTouchProcessor = new AndroidTouchProcessor(flutterRenderer2, false);
            platformViewsController.attachToFlutterRenderer(flutterRenderer2);
            this.mNativeView.getPluginRegistry().getPlatformViewsController().attachTextInputPlugin(textInputPlugin);
            this.mNativeView.getFlutterJNI().setLocalizationPlugin(localizationPlugin);
            localizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
            sendUserPlatformSettingsToDart();
            return;
        }
        throw new IllegalArgumentException("Bad context");
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

    private int guessBottomKeyboardInset(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private boolean isAttached() {
        FlutterNativeView flutterNativeView = this.mNativeView;
        return flutterNativeView != null && flutterNativeView.isAttached();
    }

    private void postRun() {
    }

    private void preRun() {
        resetAccessibilityTree();
    }

    private void releaseAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.mAccessibilityNodeProvider;
        if (accessibilityBridge != null) {
            accessibilityBridge.release();
            this.mAccessibilityNodeProvider = null;
        }
    }

    /* access modifiers changed from: private */
    public void resetWillNotDraw(boolean z4, boolean z5) {
        boolean z6 = false;
        if (!this.mIsSoftwareRenderingEnabled && !z4 && !z5) {
            z6 = true;
        }
        setWillNotDraw(z6);
    }

    private void sendUserPlatformSettingsToDart() {
        this.settingsChannel.startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness((getResources().getConfiguration().uiMode & 48) == 32 ? SettingsChannel.PlatformBrightness.dark : SettingsChannel.PlatformBrightness.light).send();
    }

    private void updateViewportMetrics() {
        if (isAttached()) {
            FlutterJNI flutterJNI = this.mNativeView.getFlutterJNI();
            ViewportMetrics viewportMetrics = this.mMetrics;
            flutterJNI.setViewportMetrics(viewportMetrics.devicePixelRatio, viewportMetrics.physicalWidth, viewportMetrics.physicalHeight, viewportMetrics.physicalViewPaddingTop, viewportMetrics.physicalViewPaddingRight, viewportMetrics.physicalViewPaddingBottom, viewportMetrics.physicalViewPaddingLeft, viewportMetrics.physicalViewInsetTop, viewportMetrics.physicalViewInsetRight, viewportMetrics.physicalViewInsetBottom, viewportMetrics.physicalViewInsetLeft, viewportMetrics.systemGestureInsetTop, viewportMetrics.systemGestureInsetRight, viewportMetrics.systemGestureInsetBottom, viewportMetrics.systemGestureInsetLeft, viewportMetrics.physicalTouchSlop, new int[0], new int[0], new int[0]);
        }
    }

    public void addActivityLifecycleListener(ActivityLifecycleListener activityLifecycleListener) {
        this.mActivityLifecycleListeners.add(activityLifecycleListener);
    }

    public void addFirstFrameListener(FirstFrameListener firstFrameListener) {
        this.mFirstFrameListeners.add(firstFrameListener);
    }

    /* access modifiers changed from: package-private */
    public void assertAttached() {
        if (!isAttached()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.mTextInputPlugin.autofill(sparseArray);
    }

    public boolean checkInputConnectionProxy(View view) {
        return this.mNativeView.getPluginRegistry().getPlatformViewsController().checkInputConnectionProxy(view);
    }

    public TextureRegistry.ImageTextureEntry createImageTexture() {
        throw new UnsupportedOperationException("Image textures are not supported in this mode.");
    }

    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        return registerSurfaceTexture(new SurfaceTexture(0));
    }

    public void destroy() {
        if (isAttached()) {
            getHolder().removeCallback(this.mSurfaceCallback);
            releaseAccessibilityNodeProvider();
            this.mNativeView.destroy();
            this.mNativeView = null;
        }
    }

    public FlutterNativeView detach() {
        if (!isAttached()) {
            return null;
        }
        getHolder().removeCallback(this.mSurfaceCallback);
        this.mNativeView.detachFromFlutterView();
        FlutterNativeView flutterNativeView = this.mNativeView;
        this.mNativeView = null;
        return flutterNativeView;
    }

    public void disableBufferingIncomingMessages() {
    }

    public void disableTransparentBackground() {
        setZOrderOnTop(false);
        getHolder().setFormat(-1);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Log.e(TAG, "dispatchKeyEvent: " + keyEvent.toString());
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (isAttached() && this.mKeyboardManager.handleEvent(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    public void enableBufferingIncomingMessages() {
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.mAccessibilityNodeProvider;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.mAccessibilityNodeProvider;
    }

    public BinaryMessenger getBinaryMessenger() {
        return this;
    }

    public Bitmap getBitmap() {
        assertAttached();
        return this.mNativeView.getFlutterJNI().getBitmap();
    }

    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    /* access modifiers changed from: package-private */
    public float getDevicePixelRatio() {
        return this.mMetrics.devicePixelRatio;
    }

    public FlutterNativeView getFlutterNativeView() {
        return this.mNativeView;
    }

    public String getLookupKeyForAsset(String str) {
        return FlutterMain.getLookupKeyForAsset(str);
    }

    public String getLookupKeyForAsset(String str, String str2) {
        return FlutterMain.getLookupKeyForAsset(str, str2);
    }

    public FlutterPluginRegistry getPluginRegistry() {
        return this.mNativeView.getPluginRegistry();
    }

    public PointerIcon getSystemPointerIcon(int i5) {
        return PointerIcon.getSystemIcon(getContext(), i5);
    }

    public boolean hasRenderedFirstFrame() {
        return this.didRenderFirstFrame;
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return a.c(this);
    }

    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        return null;
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 == 29) {
            Insets a5 = windowInsets.getSystemGestureInsets();
            ViewportMetrics viewportMetrics = this.mMetrics;
            viewportMetrics.systemGestureInsetTop = a5.top;
            viewportMetrics.systemGestureInsetRight = a5.right;
            viewportMetrics.systemGestureInsetBottom = a5.bottom;
            viewportMetrics.systemGestureInsetLeft = a5.left;
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
            ViewportMetrics viewportMetrics2 = this.mMetrics;
            viewportMetrics2.physicalViewPaddingTop = a6.top;
            viewportMetrics2.physicalViewPaddingRight = a6.right;
            viewportMetrics2.physicalViewPaddingBottom = a6.bottom;
            viewportMetrics2.physicalViewPaddingLeft = a6.left;
            Insets a7 = windowInsets.getInsets(WindowInsets$Type.ime());
            ViewportMetrics viewportMetrics3 = this.mMetrics;
            viewportMetrics3.physicalViewInsetTop = a7.top;
            viewportMetrics3.physicalViewInsetRight = a7.right;
            viewportMetrics3.physicalViewInsetBottom = a7.bottom;
            viewportMetrics3.physicalViewInsetLeft = a7.left;
            Insets a8 = windowInsets.getInsets(WindowInsets$Type.systemGestures());
            ViewportMetrics viewportMetrics4 = this.mMetrics;
            viewportMetrics4.systemGestureInsetTop = a8.top;
            viewportMetrics4.systemGestureInsetRight = a8.right;
            viewportMetrics4.systemGestureInsetBottom = a8.bottom;
            viewportMetrics4.systemGestureInsetLeft = a8.left;
            DisplayCutout a9 = windowInsets.getDisplayCutout();
            if (a9 != null) {
                Insets a10 = a9.getWaterfallInsets();
                ViewportMetrics viewportMetrics5 = this.mMetrics;
                viewportMetrics5.physicalViewPaddingTop = Math.max(Math.max(viewportMetrics5.physicalViewPaddingTop, a10.top), a9.getSafeInsetTop());
                ViewportMetrics viewportMetrics6 = this.mMetrics;
                viewportMetrics6.physicalViewPaddingRight = Math.max(Math.max(viewportMetrics6.physicalViewPaddingRight, a10.right), a9.getSafeInsetRight());
                ViewportMetrics viewportMetrics7 = this.mMetrics;
                viewportMetrics7.physicalViewPaddingBottom = Math.max(Math.max(viewportMetrics7.physicalViewPaddingBottom, a10.bottom), a9.getSafeInsetBottom());
                ViewportMetrics viewportMetrics8 = this.mMetrics;
                viewportMetrics8.physicalViewPaddingLeft = Math.max(Math.max(viewportMetrics8.physicalViewPaddingLeft, a10.left), a9.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z4) {
                zeroSides = calculateShouldZeroSides();
            }
            this.mMetrics.physicalViewPaddingTop = z5 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.mMetrics.physicalViewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.mMetrics.physicalViewPaddingBottom = (!z4 || guessBottomKeyboardInset(windowInsets) != 0) ? 0 : windowInsets.getSystemWindowInsetBottom();
            this.mMetrics.physicalViewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            ViewportMetrics viewportMetrics9 = this.mMetrics;
            viewportMetrics9.physicalViewInsetTop = 0;
            viewportMetrics9.physicalViewInsetRight = 0;
            viewportMetrics9.physicalViewInsetBottom = guessBottomKeyboardInset(windowInsets);
            this.mMetrics.physicalViewInsetLeft = 0;
        }
        updateViewportMetrics();
        return super.onApplyWindowInsets(windowInsets);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, new AccessibilityChannel(this.dartExecutor, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), getPluginRegistry().getPlatformViewsController());
        this.mAccessibilityNodeProvider = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
        resetWillNotDraw(this.mAccessibilityNodeProvider.isAccessibilityEnabled(), this.mAccessibilityNodeProvider.isTouchExplorationEnabled());
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mLocalizationPlugin.sendLocalesToFlutter(configuration);
        sendUserPlatformSettingsToDart();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.mTextInputPlugin.createInputConnection(this, this.mKeyboardManager, editorInfo);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        releaseAccessibilityNodeProvider();
    }

    public void onFirstFrame() {
        this.didRenderFirstFrame = true;
        for (FirstFrameListener onFirstFrame : new ArrayList(this.mFirstFrameListeners)) {
            onFirstFrame.onFirstFrame();
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (isAttached() && this.androidTouchProcessor.onGenericMotionEvent(motionEvent, getContext())) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        return !isAttached() ? super.onHoverEvent(motionEvent) : this.mAccessibilityNodeProvider.onAccessibilityHoverEvent(motionEvent);
    }

    public void onMemoryPressure() {
        this.mNativeView.getFlutterJNI().notifyLowMemoryWarning();
        this.systemChannel.sendMemoryPressureWarning();
    }

    public void onPause() {
        this.lifecycleChannel.appIsInactive();
    }

    public void onPostResume() {
        for (ActivityLifecycleListener onPostResume : this.mActivityLifecycleListeners) {
            onPostResume.onPostResume();
        }
        this.lifecycleChannel.appIsResumed();
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i5) {
        super.onProvideAutofillVirtualStructure(viewStructure, i5);
        this.mTextInputPlugin.onProvideAutofillVirtualStructure(viewStructure, i5);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        ViewportMetrics viewportMetrics = this.mMetrics;
        viewportMetrics.physicalWidth = i5;
        viewportMetrics.physicalHeight = i6;
        updateViewportMetrics();
        super.onSizeChanged(i5, i6, i7, i8);
    }

    public void onStart() {
        this.lifecycleChannel.appIsInactive();
    }

    public void onStop() {
        this.lifecycleChannel.appIsPaused();
    }

    public boolean onTextInputKeyEvent(KeyEvent keyEvent) {
        return this.mTextInputPlugin.handleKeyEvent(keyEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isAttached()) {
            return super.onTouchEvent(motionEvent);
        }
        requestUnbufferedDispatch(motionEvent);
        return this.androidTouchProcessor.onTouchEvent(motionEvent);
    }

    public /* synthetic */ void onTrimMemory(int i5) {
        n.a(this, i5);
    }

    public void popRoute() {
        this.navigationChannel.popRoute();
    }

    public void pushRoute(String str) {
        this.navigationChannel.pushRoute(str);
    }

    public void redispatch(KeyEvent keyEvent) {
        getRootView().dispatchKeyEvent(keyEvent);
    }

    public TextureRegistry.SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), surfaceTexture);
        this.mNativeView.getFlutterJNI().registerTexture(surfaceTextureRegistryEntry.id(), surfaceTextureRegistryEntry.textureWrapper());
        return surfaceTextureRegistryEntry;
    }

    public void removeFirstFrameListener(FirstFrameListener firstFrameListener) {
        this.mFirstFrameListeners.remove(firstFrameListener);
    }

    /* access modifiers changed from: package-private */
    public void resetAccessibilityTree() {
        AccessibilityBridge accessibilityBridge = this.mAccessibilityNodeProvider;
        if (accessibilityBridge != null) {
            accessibilityBridge.reset();
        }
    }

    public void runFromBundle(FlutterRunArguments flutterRunArguments) {
        assertAttached();
        preRun();
        this.mNativeView.runFromBundle(flutterRunArguments);
        postRun();
    }

    public void send(String str, ByteBuffer byteBuffer) {
        send(str, byteBuffer, (BinaryMessenger.BinaryReply) null);
    }

    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        if (!isAttached()) {
            Log.d(TAG, "FlutterView.send called on a detached view, channel=" + str);
            return;
        }
        this.mNativeView.send(str, byteBuffer, binaryReply);
    }

    public void setInitialRoute(String str) {
        this.navigationChannel.setInitialRoute(str);
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        this.mNativeView.setMessageHandler(str, binaryMessageHandler);
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler, BinaryMessenger.TaskQueue taskQueue) {
        this.mNativeView.setMessageHandler(str, binaryMessageHandler, taskQueue);
    }
}
