package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.TypedValue;
import android.view.Surface;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.PlatformMessageHandler;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.util.Preconditions;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.TextureRegistry;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = null;
    private static float displayDensity = -1.0f;
    private static float displayHeight = -1.0f;
    private static float displayWidth = -1.0f;
    private static boolean initCalled = false;
    private static boolean loadLibraryCalled = false;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static float refreshRateFPS = 60.0f;
    private static String vmServiceUri;
    private AccessibilityDelegate accessibilityDelegate;
    private DeferredComponentManager deferredComponentManager;
    private final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners = new CopyOnWriteArraySet();
    private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    private LocalizationPlugin localizationPlugin;
    private final Looper mainLooper = Looper.getMainLooper();
    private Long nativeShellHolderId;
    private PlatformMessageHandler platformMessageHandler;
    private PlatformViewsController platformViewsController;
    private ReentrantReadWriteLock shellHolderLock = new ReentrantReadWriteLock();

    public interface AccessibilityDelegate {
        void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr);

        void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr);
    }

    public interface AsyncWaitForVsyncDelegate {
        void asyncWaitForVsync(long j5);
    }

    public static class Factory {
        public FlutterJNI provideFlutterJNI() {
            return new FlutterJNI();
        }
    }

    private static void asyncWaitForVsync(long j5) {
        AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2 = asyncWaitForVsyncDelegate;
        if (asyncWaitForVsyncDelegate2 != null) {
            asyncWaitForVsyncDelegate2.asyncWaitForVsync(j5);
            return;
        }
        throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
    }

    public static Bitmap decodeImage(ByteBuffer byteBuffer, long j5) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return ImageDecoder.decodeBitmap(ImageDecoder.createSource(byteBuffer), new a(j5));
            } catch (IOException e5) {
                Log.e(TAG, "Failed to decode image", e5);
            }
        }
        return null;
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() != this.mainLooper) {
            throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
        }
    }

    @Deprecated
    public static String getObservatoryUri() {
        return vmServiceUri;
    }

    public static String getVMServiceUri() {
        return vmServiceUri;
    }

    private void handlePlatformMessageResponse(int i5, ByteBuffer byteBuffer) {
        PlatformMessageHandler platformMessageHandler2 = this.platformMessageHandler;
        if (platformMessageHandler2 != null) {
            platformMessageHandler2.handlePlatformMessageResponse(i5, byteBuffer);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$decodeImage$0(long j5, ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
        imageDecoder.setAllocator(1);
        Size size = imageInfo.getSize();
        nativeImageHeaderCallback(j5, size.getWidth(), size.getHeight());
    }

    private native long nativeAttach(FlutterJNI flutterJNI);

    private native void nativeCleanupMessageData(long j5);

    private native void nativeDeferredComponentInstallFailure(int i5, String str, boolean z4);

    private native void nativeDestroy(long j5);

    private native void nativeDispatchEmptyPlatformMessage(long j5, String str, int i5);

    private native void nativeDispatchPlatformMessage(long j5, String str, ByteBuffer byteBuffer, int i5, int i6);

    private native void nativeDispatchPointerDataPacket(long j5, ByteBuffer byteBuffer, int i5);

    private native void nativeDispatchSemanticsAction(long j5, int i5, int i6, ByteBuffer byteBuffer, int i7);

    private native boolean nativeFlutterTextUtilsIsEmoji(int i5);

    private native boolean nativeFlutterTextUtilsIsEmojiModifier(int i5);

    private native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i5);

    private native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i5);

    private native boolean nativeFlutterTextUtilsIsVariationSelector(int i5);

    private native Bitmap nativeGetBitmap(long j5);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeImageHeaderCallback(long j5, int i5, int i6);

    private static native void nativeInit(Context context, String[] strArr, String str, String str2, String str3, long j5);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j5, int i5);

    private native void nativeInvokePlatformMessageResponseCallback(long j5, int i5, ByteBuffer byteBuffer, int i6);

    private native void nativeLoadDartDeferredLibrary(long j5, int i5, String[] strArr);

    @Deprecated
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j5);

    private native void nativeMarkTextureFrameAvailable(long j5, long j6);

    private native void nativeNotifyLowMemoryWarning(long j5);

    private native void nativeOnVsync(long j5, long j6, long j7);

    private static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterImageTexture(long j5, long j6, WeakReference<TextureRegistry.ImageTextureEntry> weakReference);

    private native void nativeRegisterTexture(long j5, long j6, WeakReference<SurfaceTextureWrapper> weakReference);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j5, String str, String str2, String str3, AssetManager assetManager, List<String> list);

    private native void nativeSetAccessibilityFeatures(long j5, int i5);

    private native void nativeSetIsRenderingToImageView(long j5, boolean z4);

    private native void nativeSetSemanticsEnabled(long j5, boolean z4);

    private native void nativeSetViewportMetrics(long j5, float f5, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int[] iArr, int[] iArr2, int[] iArr3);

    private native FlutterJNI nativeSpawn(long j5, String str, String str2, String str3, List<String> list);

    private native void nativeSurfaceChanged(long j5, int i5, int i6);

    private native void nativeSurfaceCreated(long j5, Surface surface);

    private native void nativeSurfaceDestroyed(long j5);

    private native void nativeSurfaceWindowChanged(long j5, Surface surface);

    private native void nativeUnregisterTexture(long j5, long j6);

    private native void nativeUpdateDisplayMetrics(long j5);

    private native void nativeUpdateJavaAssetManager(long j5, AssetManager assetManager, String str);

    private native void nativeUpdateRefreshRate(float f5);

    private void onPreEngineRestart() {
        for (FlutterEngine.EngineLifecycleListener onPreEngineRestart : this.engineLifecycleListeners) {
            onPreEngineRestart.onPreEngineRestart();
        }
    }

    private void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        ensureRunningOnMainThread();
        AccessibilityDelegate accessibilityDelegate2 = this.accessibilityDelegate;
        if (accessibilityDelegate2 != null) {
            accessibilityDelegate2.updateCustomAccessibilityActions(byteBuffer, strArr);
        }
    }

    private void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        ensureRunningOnMainThread();
        AccessibilityDelegate accessibilityDelegate2 = this.accessibilityDelegate;
        if (accessibilityDelegate2 != null) {
            accessibilityDelegate2.updateSemantics(byteBuffer, strArr, byteBufferArr);
        }
    }

    public void SetIsRenderingToImageView(boolean z4) {
        nativeSetIsRenderingToImageView(this.nativeShellHolderId.longValue(), z4);
    }

    public void addEngineLifecycleListener(FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(engineLifecycleListener);
    }

    public void addIsDisplayingFlutterUiListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(flutterUiDisplayListener);
    }

    public void attachToNative() {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            this.nativeShellHolderId = Long.valueOf(performNativeAttach(this));
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void cleanupMessageData(long j5) {
        nativeCleanupMessageData(j5);
    }

    public String[] computePlatformResolvedLocale(String[] strArr) {
        if (this.localizationPlugin == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < strArr.length; i5 += 3) {
            String str = strArr[i5 + 0];
            String str2 = strArr[i5 + 1];
            String str3 = strArr[i5 + 2];
            Locale.Builder builder = new Locale.Builder();
            if (!str.isEmpty()) {
                builder.setLanguage(str);
            }
            if (!str2.isEmpty()) {
                builder.setRegion(str2);
            }
            if (!str3.isEmpty()) {
                builder.setScript(str3);
            }
            arrayList.add(builder.build());
        }
        Locale resolveNativeLocale = this.localizationPlugin.resolveNativeLocale(arrayList);
        if (resolveNativeLocale == null) {
            return new String[0];
        }
        return new String[]{resolveNativeLocale.getLanguage(), resolveNativeLocale.getCountry(), resolveNativeLocale.getScript()};
    }

    public FlutterOverlaySurface createOverlaySurface() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            return platformViewsController2.createOverlaySurface();
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    public void deferredComponentInstallFailure(int i5, String str, boolean z4) {
        ensureRunningOnMainThread();
        nativeDeferredComponentInstallFailure(i5, str, z4);
    }

    public void destroyOverlaySurfaces() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.destroyOverlaySurfaces();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
    }

    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            nativeDestroy(this.nativeShellHolderId.longValue());
            this.nativeShellHolderId = null;
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void dispatchEmptyPlatformMessage(String str, int i5) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), str, i5);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i5);
    }

    public void dispatchPlatformMessage(String str, ByteBuffer byteBuffer, int i5, int i6) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), str, byteBuffer, i5, i6);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i6);
    }

    public void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i5) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), byteBuffer, i5);
    }

    public void dispatchSemanticsAction(int i5, int i6, ByteBuffer byteBuffer, int i7) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), i5, i6, byteBuffer, i7);
    }

    public void dispatchSemanticsAction(int i5, AccessibilityBridge.Action action) {
        dispatchSemanticsAction(i5, action, (Object) null);
    }

    public void dispatchSemanticsAction(int i5, AccessibilityBridge.Action action, Object obj) {
        ByteBuffer byteBuffer;
        int i6;
        ensureAttachedToNative();
        if (obj != null) {
            byteBuffer = StandardMessageCodec.INSTANCE.encodeMessage(obj);
            i6 = byteBuffer.position();
        } else {
            byteBuffer = null;
            i6 = 0;
        }
        dispatchSemanticsAction(i5, action.value, byteBuffer, i6);
    }

    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    public float getScaledFontSize(float f5, int i5) {
        DisplayMetrics pastDisplayMetrics = SettingsChannel.getPastDisplayMetrics(i5);
        if (pastDisplayMetrics != null) {
            return TypedValue.applyDimension(2, f5, pastDisplayMetrics) / pastDisplayMetrics.density;
        }
        Log.e(TAG, "getScaledFontSize called with configurationId " + String.valueOf(i5) + ", which can't be found.");
        return -1.0f;
    }

    public void handlePlatformMessage(String str, ByteBuffer byteBuffer, int i5, long j5) {
        PlatformMessageHandler platformMessageHandler2 = this.platformMessageHandler;
        if (platformMessageHandler2 != null) {
            platformMessageHandler2.handleMessageFromDart(str, byteBuffer, i5, j5);
        } else {
            nativeCleanupMessageData(j5);
        }
    }

    public void init(Context context, String[] strArr, String str, String str2, String str3, long j5) {
        if (initCalled) {
            Log.w(TAG, "FlutterJNI.init called more than once");
        }
        nativeInit(context, strArr, str, str2, str3, j5);
        initCalled = true;
    }

    public void invokePlatformMessageEmptyResponseCallback(int i5) {
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), i5);
            } else {
                Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i5);
            }
        } finally {
            this.shellHolderLock.readLock().unlock();
        }
    }

    public void invokePlatformMessageResponseCallback(int i5, ByteBuffer byteBuffer, int i6) {
        if (byteBuffer.isDirect()) {
            this.shellHolderLock.readLock().lock();
            try {
                if (isAttached()) {
                    nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), i5, byteBuffer, i6);
                } else {
                    Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i5);
                }
            } finally {
                this.shellHolderLock.readLock().unlock();
            }
        } else {
            throw new IllegalArgumentException("Expected a direct ByteBuffer.");
        }
    }

    public boolean isAttached() {
        return this.nativeShellHolderId != null;
    }

    public boolean isCodePointEmoji(int i5) {
        return nativeFlutterTextUtilsIsEmoji(i5);
    }

    public boolean isCodePointEmojiModifier(int i5) {
        return nativeFlutterTextUtilsIsEmojiModifier(i5);
    }

    public boolean isCodePointEmojiModifierBase(int i5) {
        return nativeFlutterTextUtilsIsEmojiModifierBase(i5);
    }

    public boolean isCodePointRegionalIndicator(int i5) {
        return nativeFlutterTextUtilsIsRegionalIndicator(i5);
    }

    public boolean isCodePointVariantSelector(int i5) {
        return nativeFlutterTextUtilsIsVariationSelector(i5);
    }

    public void loadDartDeferredLibrary(int i5, String[] strArr) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), i5, strArr);
    }

    public void loadLibrary() {
        if (loadLibraryCalled) {
            Log.w(TAG, "FlutterJNI.loadLibrary called more than once");
        }
        System.loadLibrary("flutter");
        loadLibraryCalled = true;
    }

    public void markTextureFrameAvailable(long j5) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), j5);
    }

    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    public void onBeginFrame() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onBeginFrame();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
    }

    public void onDisplayOverlaySurface(int i5, int i6, int i7, int i8, int i9) {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onDisplayOverlaySurface(i5, i6, i7, i8, i9);
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    public void onDisplayPlatformView(int i5, int i6, int i7, int i8, int i9, int i10, int i11, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onDisplayPlatformView(i5, i6, i7, i8, i9, i10, i11, flutterMutatorsStack);
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
    }

    public void onEndFrame() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onEndFrame();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
    }

    public void onFirstFrame() {
        ensureRunningOnMainThread();
        for (FlutterUiDisplayListener onFlutterUiDisplayed : this.flutterUiDisplayListeners) {
            onFlutterUiDisplayed.onFlutterUiDisplayed();
        }
    }

    /* access modifiers changed from: package-private */
    public void onRenderingStopped() {
        ensureRunningOnMainThread();
        for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : this.flutterUiDisplayListeners) {
            onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
        }
    }

    public void onSurfaceChanged(int i5, int i6) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), i5, i6);
    }

    public void onSurfaceCreated(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), surface);
    }

    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public void onSurfaceWindowChanged(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), surface);
    }

    public void onVsync(long j5, long j6, long j7) {
        nativeOnVsync(j5, j6, j7);
    }

    public long performNativeAttach(FlutterJNI flutterJNI) {
        return nativeAttach(flutterJNI);
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled) {
            Log.w(TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
        }
        nativePrefetchDefaultFontManager();
        prefetchDefaultFontManagerCalled = true;
    }

    public void registerImageTexture(long j5, TextureRegistry.ImageTextureEntry imageTextureEntry) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterImageTexture(this.nativeShellHolderId.longValue(), j5, new WeakReference(imageTextureEntry));
    }

    public void registerTexture(long j5, SurfaceTextureWrapper surfaceTextureWrapper) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativeShellHolderId.longValue(), j5, new WeakReference(surfaceTextureWrapper));
    }

    public void removeEngineLifecycleListener(FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(engineLifecycleListener);
    }

    public void removeIsDisplayingFlutterUiListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
    }

    public void requestDartDeferredLibrary(int i5) {
        DeferredComponentManager deferredComponentManager2 = this.deferredComponentManager;
        if (deferredComponentManager2 != null) {
            deferredComponentManager2.installDeferredComponent(i5, (String) null);
        } else {
            Log.e(TAG, "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
        }
    }

    public void runBundleAndSnapshotFromLibrary(String str, String str2, String str3, AssetManager assetManager, List<String> list) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), str, str2, str3, assetManager, list);
    }

    public void setAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate2) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = accessibilityDelegate2;
    }

    public void setAccessibilityFeatures(int i5) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), i5);
    }

    public void setAsyncWaitForVsyncDelegate(AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2) {
        asyncWaitForVsyncDelegate = asyncWaitForVsyncDelegate2;
    }

    public void setDeferredComponentManager(DeferredComponentManager deferredComponentManager2) {
        ensureRunningOnMainThread();
        this.deferredComponentManager = deferredComponentManager2;
        if (deferredComponentManager2 != null) {
            deferredComponentManager2.setJNI(this);
        }
    }

    public void setLocalizationPlugin(LocalizationPlugin localizationPlugin2) {
        ensureRunningOnMainThread();
        this.localizationPlugin = localizationPlugin2;
    }

    public void setPlatformMessageHandler(PlatformMessageHandler platformMessageHandler2) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = platformMessageHandler2;
    }

    public void setPlatformViewsController(PlatformViewsController platformViewsController2) {
        ensureRunningOnMainThread();
        this.platformViewsController = platformViewsController2;
    }

    public void setRefreshRateFPS(float f5) {
        refreshRateFPS = f5;
        updateRefreshRate();
    }

    public void setSemanticsEnabled(boolean z4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), z4);
    }

    public void setViewportMetrics(float f5, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int[] iArr, int[] iArr2, int[] iArr3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), f5, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, iArr, iArr2, iArr3);
    }

    public FlutterJNI spawn(String str, String str2, String str3, List<String> list) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI nativeSpawn = nativeSpawn(this.nativeShellHolderId.longValue(), str, str2, str3, list);
        Long l5 = nativeSpawn.nativeShellHolderId;
        Preconditions.checkState((l5 == null || l5.longValue() == 0) ? false : true, "Failed to spawn new JNI connected shell from existing shell.");
        return nativeSpawn;
    }

    public void unregisterTexture(long j5) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativeShellHolderId.longValue(), j5);
    }

    public void updateDisplayMetrics(int i5, float f5, float f6, float f7) {
        displayWidth = f5;
        displayHeight = f6;
        displayDensity = f7;
        if (loadLibraryCalled) {
            nativeUpdateDisplayMetrics(this.nativeShellHolderId.longValue());
        }
    }

    public void updateJavaAssetManager(AssetManager assetManager, String str) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), assetManager, str);
    }

    public void updateRefreshRate() {
        if (loadLibraryCalled) {
            nativeUpdateRefreshRate(refreshRateFPS);
        }
    }
}
