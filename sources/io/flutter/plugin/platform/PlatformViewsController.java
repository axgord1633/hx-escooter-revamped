package io.flutter.plugin.platform;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PlatformViewsController implements PlatformViewsAccessibilityDelegate {
    private static final String TAG = "PlatformViewsController";
    /* access modifiers changed from: private */
    public static Class[] VIEW_TYPES_REQUIRE_VIRTUAL_DISPLAY = {SurfaceView.class};
    private static boolean enableHardwareBufferRenderingTarget = false;
    private final AccessibilityEventsDelegate accessibilityEventsDelegate = new AccessibilityEventsDelegate();
    private AndroidTouchProcessor androidTouchProcessor;
    private final PlatformViewsChannel.PlatformViewsHandler channelHandler = new PlatformViewsChannel.PlatformViewsHandler() {
        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$resize$0(VirtualDisplayController virtualDisplayController, float f5, PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
            PlatformViewsController.this.unlockInputConnection(virtualDisplayController);
            if (PlatformViewsController.this.context != null) {
                f5 = PlatformViewsController.this.getDisplayDensity();
            }
            platformViewBufferResized.run(new PlatformViewsChannel.PlatformViewBufferSize(PlatformViewsController.this.toLogicalPixels((double) virtualDisplayController.getRenderTargetWidth(), f5), PlatformViewsController.this.toLogicalPixels((double) virtualDisplayController.getRenderTargetHeight(), f5)));
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x004e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void clearFocus(int r4) {
            /*
                r3 = this;
                io.flutter.plugin.platform.PlatformViewsController r0 = io.flutter.plugin.platform.PlatformViewsController.this
                boolean r0 = r0.usesVirtualDisplay(r4)
                java.lang.String r1 = "PlatformViewsController"
                if (r0 == 0) goto L_0x001d
                io.flutter.plugin.platform.PlatformViewsController r0 = io.flutter.plugin.platform.PlatformViewsController.this
                java.util.HashMap<java.lang.Integer, io.flutter.plugin.platform.VirtualDisplayController> r0 = r0.vdControllers
                java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
                java.lang.Object r0 = r0.get(r2)
                io.flutter.plugin.platform.VirtualDisplayController r0 = (io.flutter.plugin.platform.VirtualDisplayController) r0
                android.view.View r0 = r0.getView()
                goto L_0x0044
            L_0x001d:
                io.flutter.plugin.platform.PlatformViewsController r0 = io.flutter.plugin.platform.PlatformViewsController.this
                android.util.SparseArray r0 = r0.platformViews
                java.lang.Object r0 = r0.get(r4)
                io.flutter.plugin.platform.PlatformView r0 = (io.flutter.plugin.platform.PlatformView) r0
                if (r0 != 0) goto L_0x0040
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Clearing focus on an unknown view with id: "
            L_0x0032:
                r0.append(r2)
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                io.flutter.Log.e(r1, r4)
                return
            L_0x0040:
                android.view.View r0 = r0.getView()
            L_0x0044:
                if (r0 != 0) goto L_0x004e
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Clearing focus on a null view with id: "
                goto L_0x0032
            L_0x004e:
                r0.clearFocus()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.platform.PlatformViewsController.AnonymousClass1.clearFocus(int):void");
        }

        public void createForPlatformViewLayer(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            PlatformViewsController.this.enforceMinimumAndroidApiVersion(19);
            PlatformViewsController.this.ensureValidRequest(platformViewCreationRequest);
            PlatformViewsController.this.configureForHybridComposition(PlatformViewsController.this.createPlatformView(platformViewCreationRequest, false), platformViewCreationRequest);
        }

        public long createForTextureLayer(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            PlatformViewsController.this.ensureValidRequest(platformViewCreationRequest);
            int i5 = platformViewCreationRequest.viewId;
            if (PlatformViewsController.this.viewWrappers.get(i5) != null) {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + i5);
            } else if (PlatformViewsController.this.textureRegistry == null) {
                throw new IllegalStateException("Texture registry is null. This means that platform views controller was detached, view id: " + i5);
            } else if (PlatformViewsController.this.flutterView != null) {
                boolean z4 = true;
                PlatformView createPlatformView = PlatformViewsController.this.createPlatformView(platformViewCreationRequest, true);
                View view = createPlatformView.getView();
                if (view.getParent() == null) {
                    if (ViewUtils.hasChildViewOfType(view, PlatformViewsController.VIEW_TYPES_REQUIRE_VIRTUAL_DISPLAY)) {
                        z4 = false;
                    }
                    if (!z4) {
                        if (platformViewCreationRequest.displayMode == PlatformViewsChannel.PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_HYBRID_FALLBACK) {
                            PlatformViewsController.this.configureForHybridComposition(createPlatformView, platformViewCreationRequest);
                            return -2;
                        } else if (!PlatformViewsController.this.usesSoftwareRendering) {
                            return PlatformViewsController.this.configureForVirtualDisplay(createPlatformView, platformViewCreationRequest);
                        }
                    }
                    return PlatformViewsController.this.configureForTextureLayerComposition(createPlatformView, platformViewCreationRequest);
                }
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            } else {
                throw new IllegalStateException("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: " + i5);
            }
        }

        public void dispose(int i5) {
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i5);
            if (platformView == null) {
                Log.e(PlatformViewsController.TAG, "Disposing unknown platform view with id: " + i5);
                return;
            }
            if (platformView.getView() != null) {
                View view = platformView.getView();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            }
            PlatformViewsController.this.platformViews.remove(i5);
            try {
                platformView.dispose();
            } catch (RuntimeException e5) {
                Log.e(PlatformViewsController.TAG, "Disposing platform view threw an exception", e5);
            }
            if (PlatformViewsController.this.usesVirtualDisplay(i5)) {
                VirtualDisplayController virtualDisplayController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i5));
                View view2 = virtualDisplayController.getView();
                if (view2 != null) {
                    PlatformViewsController.this.contextToEmbeddedView.remove(view2.getContext());
                }
                virtualDisplayController.dispose();
                PlatformViewsController.this.vdControllers.remove(Integer.valueOf(i5));
                return;
            }
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i5);
            if (platformViewWrapper != null) {
                platformViewWrapper.removeAllViews();
                platformViewWrapper.release();
                platformViewWrapper.unsetOnDescendantFocusChangeListener();
                ViewGroup viewGroup2 = (ViewGroup) platformViewWrapper.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(platformViewWrapper);
                }
                PlatformViewsController.this.viewWrappers.remove(i5);
                return;
            }
            FlutterMutatorView flutterMutatorView = (FlutterMutatorView) PlatformViewsController.this.platformViewParent.get(i5);
            if (flutterMutatorView != null) {
                flutterMutatorView.removeAllViews();
                flutterMutatorView.unsetOnDescendantFocusChangeListener();
                ViewGroup viewGroup3 = (ViewGroup) flutterMutatorView.getParent();
                if (viewGroup3 != null) {
                    viewGroup3.removeView(flutterMutatorView);
                }
                PlatformViewsController.this.platformViewParent.remove(i5);
            }
        }

        public void offset(int i5, double d5, double d6) {
            if (!PlatformViewsController.this.usesVirtualDisplay(i5)) {
                PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i5);
                if (platformViewWrapper == null) {
                    Log.e(PlatformViewsController.TAG, "Setting offset for unknown platform view with id: " + i5);
                    return;
                }
                int access$1100 = PlatformViewsController.this.toPhysicalPixels(d5);
                int access$11002 = PlatformViewsController.this.toPhysicalPixels(d6);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) platformViewWrapper.getLayoutParams();
                layoutParams.topMargin = access$1100;
                layoutParams.leftMargin = access$11002;
                platformViewWrapper.setLayoutParams(layoutParams);
            }
        }

        public void onTouch(PlatformViewsChannel.PlatformViewTouch platformViewTouch) {
            int i5 = platformViewTouch.viewId;
            float f5 = PlatformViewsController.this.context.getResources().getDisplayMetrics().density;
            if (PlatformViewsController.this.usesVirtualDisplay(i5)) {
                PlatformViewsController.this.vdControllers.get(Integer.valueOf(i5)).dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(f5, platformViewTouch, true));
                return;
            }
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i5);
            if (platformView == null) {
                Log.e(PlatformViewsController.TAG, "Sending touch to an unknown view with id: " + i5);
                return;
            }
            View view = platformView.getView();
            if (view == null) {
                Log.e(PlatformViewsController.TAG, "Sending touch to a null view with id: " + i5);
                return;
            }
            view.dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(f5, platformViewTouch, false));
        }

        public void resize(PlatformViewsChannel.PlatformViewResizeRequest platformViewResizeRequest, PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
            int access$1100 = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalWidth);
            int access$11002 = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalHeight);
            int i5 = platformViewResizeRequest.viewId;
            if (PlatformViewsController.this.usesVirtualDisplay(i5)) {
                float access$1200 = PlatformViewsController.this.getDisplayDensity();
                VirtualDisplayController virtualDisplayController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i5));
                PlatformViewsController.this.lockInputConnection(virtualDisplayController);
                virtualDisplayController.resize(access$1100, access$11002, new k(this, virtualDisplayController, access$1200, platformViewBufferResized));
                return;
            }
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i5);
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i5);
            if (platformView == null || platformViewWrapper == null) {
                Log.e(PlatformViewsController.TAG, "Resizing unknown platform view with id: " + i5);
                return;
            }
            if (access$1100 > platformViewWrapper.getRenderTargetWidth() || access$11002 > platformViewWrapper.getRenderTargetHeight()) {
                platformViewWrapper.resizeRenderTarget(access$1100, access$11002);
            }
            ViewGroup.LayoutParams layoutParams = platformViewWrapper.getLayoutParams();
            layoutParams.width = access$1100;
            layoutParams.height = access$11002;
            platformViewWrapper.setLayoutParams(layoutParams);
            View view = platformView.getView();
            if (view != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.width = access$1100;
                layoutParams2.height = access$11002;
                view.setLayoutParams(layoutParams2);
            }
            platformViewBufferResized.run(new PlatformViewsChannel.PlatformViewBufferSize(PlatformViewsController.this.toLogicalPixels((double) platformViewWrapper.getRenderTargetWidth()), PlatformViewsController.this.toLogicalPixels((double) platformViewWrapper.getRenderTargetHeight())));
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0054  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setDirection(int r4, int r5) {
            /*
                r3 = this;
                boolean r0 = io.flutter.plugin.platform.PlatformViewsController.validateDirection(r5)
                if (r0 == 0) goto L_0x0058
                io.flutter.plugin.platform.PlatformViewsController r0 = io.flutter.plugin.platform.PlatformViewsController.this
                boolean r0 = r0.usesVirtualDisplay(r4)
                java.lang.String r1 = "PlatformViewsController"
                if (r0 == 0) goto L_0x0023
                io.flutter.plugin.platform.PlatformViewsController r0 = io.flutter.plugin.platform.PlatformViewsController.this
                java.util.HashMap<java.lang.Integer, io.flutter.plugin.platform.VirtualDisplayController> r0 = r0.vdControllers
                java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
                java.lang.Object r0 = r0.get(r2)
                io.flutter.plugin.platform.VirtualDisplayController r0 = (io.flutter.plugin.platform.VirtualDisplayController) r0
                android.view.View r0 = r0.getView()
                goto L_0x004a
            L_0x0023:
                io.flutter.plugin.platform.PlatformViewsController r0 = io.flutter.plugin.platform.PlatformViewsController.this
                android.util.SparseArray r0 = r0.platformViews
                java.lang.Object r0 = r0.get(r4)
                io.flutter.plugin.platform.PlatformView r0 = (io.flutter.plugin.platform.PlatformView) r0
                if (r0 != 0) goto L_0x0046
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r0 = "Setting direction to an unknown view with id: "
            L_0x0038:
                r5.append(r0)
                r5.append(r4)
                java.lang.String r4 = r5.toString()
                io.flutter.Log.e(r1, r4)
                return
            L_0x0046:
                android.view.View r0 = r0.getView()
            L_0x004a:
                if (r0 != 0) goto L_0x0054
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r0 = "Setting direction to a null view with id: "
                goto L_0x0038
            L_0x0054:
                r0.setLayoutDirection(r5)
                return
            L_0x0058:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Trying to set unknown direction value: "
                r1.append(r2)
                r1.append(r5)
                java.lang.String r5 = "(view id: "
                r1.append(r5)
                r1.append(r4)
                java.lang.String r4 = ")"
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.platform.PlatformViewsController.AnonymousClass1.setDirection(int, int):void");
        }

        public void synchronizeToNativeViewHierarchy(boolean z4) {
            boolean unused = PlatformViewsController.this.synchronizeToNativeViewHierarchy = z4;
        }
    };
    /* access modifiers changed from: private */
    public Context context;
    final HashMap<Context, View> contextToEmbeddedView = new HashMap<>();
    private final HashSet<Integer> currentFrameUsedOverlayLayerIds = new HashSet<>();
    private final HashSet<Integer> currentFrameUsedPlatformViewIds = new HashSet<>();
    /* access modifiers changed from: private */
    public FlutterView flutterView;
    private boolean flutterViewConvertedToImageView = false;
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();
    private int nextOverlayLayerId = 0;
    private final SparseArray<PlatformOverlayView> overlayLayerViews = new SparseArray<>();
    /* access modifiers changed from: private */
    public final SparseArray<FlutterMutatorView> platformViewParent = new SparseArray<>();
    /* access modifiers changed from: private */
    public final SparseArray<PlatformView> platformViews = new SparseArray<>();
    private PlatformViewsChannel platformViewsChannel;
    private final PlatformViewRegistryImpl registry = new PlatformViewRegistryImpl();
    /* access modifiers changed from: private */
    public boolean synchronizeToNativeViewHierarchy = true;
    private TextInputPlugin textInputPlugin;
    /* access modifiers changed from: private */
    public TextureRegistry textureRegistry;
    /* access modifiers changed from: private */
    public boolean usesSoftwareRendering = false;
    final HashMap<Integer, VirtualDisplayController> vdControllers = new HashMap<>();
    /* access modifiers changed from: private */
    public final SparseArray<PlatformViewWrapper> viewWrappers = new SparseArray<>();

    /* access modifiers changed from: private */
    public void configureForHybridComposition(PlatformView platformView, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        enforceMinimumAndroidApiVersion(19);
        Log.i(TAG, "Using hybrid composition for platform view: " + platformViewCreationRequest.viewId);
    }

    /* access modifiers changed from: private */
    public long configureForVirtualDisplay(PlatformView platformView, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        enforceMinimumAndroidApiVersion(20);
        Log.i(TAG, "Hosting view in a virtual display for platform view: " + platformViewCreationRequest.viewId);
        PlatformViewRenderTarget makePlatformViewRenderTarget = makePlatformViewRenderTarget(this.textureRegistry);
        PlatformView platformView2 = platformView;
        PlatformViewRenderTarget platformViewRenderTarget = makePlatformViewRenderTarget;
        VirtualDisplayController create = VirtualDisplayController.create(this.context, this.accessibilityEventsDelegate, platformView2, platformViewRenderTarget, toPhysicalPixels(platformViewCreationRequest.logicalWidth), toPhysicalPixels(platformViewCreationRequest.logicalHeight), platformViewCreationRequest.viewId, (Object) null, new j(this, platformViewCreationRequest));
        if (create != null) {
            this.vdControllers.put(Integer.valueOf(platformViewCreationRequest.viewId), create);
            View view = platformView.getView();
            this.contextToEmbeddedView.put(view.getContext(), view);
            return makePlatformViewRenderTarget.getId();
        }
        throw new IllegalStateException("Failed creating virtual display for a " + platformViewCreationRequest.viewType + " with id: " + platformViewCreationRequest.viewId);
    }

    private void diposeAllViews() {
        while (this.platformViews.size() > 0) {
            this.channelHandler.dispose(this.platformViews.keyAt(0));
        }
    }

    /* access modifiers changed from: private */
    public void enforceMinimumAndroidApiVersion(int i5) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < i5) {
            throw new IllegalStateException("Trying to use platform views with API " + i6 + ", required API level is: " + i5);
        }
    }

    /* access modifiers changed from: private */
    public void ensureValidRequest(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        if (!validateDirection(platformViewCreationRequest.direction)) {
            throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + ")");
        }
    }

    private void finishFrame(boolean z4) {
        for (int i5 = 0; i5 < this.overlayLayerViews.size(); i5++) {
            int keyAt = this.overlayLayerViews.keyAt(i5);
            PlatformOverlayView valueAt = this.overlayLayerViews.valueAt(i5);
            if (this.currentFrameUsedOverlayLayerIds.contains(Integer.valueOf(keyAt))) {
                this.flutterView.attachOverlaySurfaceToRender(valueAt);
                z4 &= valueAt.acquireLatestImage();
            } else {
                if (!this.flutterViewConvertedToImageView) {
                    valueAt.detachFromRenderer();
                }
                valueAt.setVisibility(8);
                this.flutterView.removeView(valueAt);
            }
        }
        for (int i6 = 0; i6 < this.platformViewParent.size(); i6++) {
            int keyAt2 = this.platformViewParent.keyAt(i6);
            View view = this.platformViewParent.get(keyAt2);
            if (!this.currentFrameUsedPlatformViewIds.contains(Integer.valueOf(keyAt2)) || (!z4 && this.synchronizeToNativeViewHierarchy)) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public float getDisplayDensity() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    private void initializeRootImageViewIfNeeded() {
        if (this.synchronizeToNativeViewHierarchy && !this.flutterViewConvertedToImageView) {
            this.flutterView.convertToImageView();
            this.flutterViewConvertedToImageView = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$configureForTextureLayerComposition$1(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z4) {
        if (z4) {
            this.platformViewsChannel.invokeViewFocused(platformViewCreationRequest.viewId);
            return;
        }
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.clearPlatformViewClient(platformViewCreationRequest.viewId);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$configureForVirtualDisplay$0(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z4) {
        if (z4) {
            this.platformViewsChannel.invokeViewFocused(platformViewCreationRequest.viewId);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlatformViewIfNeeded$2(int i5, View view, boolean z4) {
        if (z4) {
            this.platformViewsChannel.invokeViewFocused(i5);
            return;
        }
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.clearPlatformViewClient(i5);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onEndFrame$3() {
        finishFrame(false);
    }

    /* access modifiers changed from: private */
    public void lockInputConnection(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.lockPlatformViewInputConnection();
            virtualDisplayController.onInputConnectionLocked();
        }
    }

    private static PlatformViewRenderTarget makePlatformViewRenderTarget(TextureRegistry textureRegistry2) {
        return (!enableHardwareBufferRenderingTarget || Build.VERSION.SDK_INT < 29) ? new SurfaceTexturePlatformViewRenderTarget(textureRegistry2.createSurfaceTexture()) : new ImageReaderPlatformViewRenderTarget(textureRegistry2.createImageTexture());
    }

    private void maybeInvokeOnFlutterViewAttached(PlatformView platformView) {
        FlutterView flutterView2 = this.flutterView;
        if (flutterView2 == null) {
            Log.i(TAG, "null flutterView");
        } else {
            platformView.onFlutterViewAttached(flutterView2);
        }
    }

    private static MotionEvent.PointerCoords parsePointerCoords(Object obj, float f5) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f5;
        pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f5;
        pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f5;
        pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f5;
        pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f5;
        pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f5;
        return pointerCoords;
    }

    private static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object obj, float f5) {
        ArrayList arrayList = new ArrayList();
        for (Object parsePointerCoords : (List) obj) {
            arrayList.add(parsePointerCoords(parsePointerCoords, f5));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties parsePointerProperties(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    private static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object parsePointerProperties : (List) obj) {
            arrayList.add(parsePointerProperties(parsePointerProperties));
        }
        return arrayList;
    }

    private void removeOverlaySurfaces() {
        if (this.flutterView == null) {
            Log.e(TAG, "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i5 = 0; i5 < this.overlayLayerViews.size(); i5++) {
            this.flutterView.removeView(this.overlayLayerViews.valueAt(i5));
        }
        this.overlayLayerViews.clear();
    }

    /* access modifiers changed from: private */
    public int toLogicalPixels(double d5) {
        return toLogicalPixels(d5, getDisplayDensity());
    }

    /* access modifiers changed from: private */
    public int toLogicalPixels(double d5, float f5) {
        return (int) Math.round(d5 / ((double) f5));
    }

    /* access modifiers changed from: private */
    public int toPhysicalPixels(double d5) {
        return (int) Math.round(d5 * ((double) getDisplayDensity()));
    }

    /* access modifiers changed from: private */
    public void unlockInputConnection(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.unlockPlatformViewInputConnection();
            virtualDisplayController.onInputConnectionUnlocked();
        }
    }

    /* access modifiers changed from: private */
    public static boolean validateDirection(int i5) {
        return i5 == 0 || i5 == 1;
    }

    public void attach(Context context2, TextureRegistry textureRegistry2, DartExecutor dartExecutor) {
        if (this.context == null) {
            this.context = context2;
            this.textureRegistry = textureRegistry2;
            PlatformViewsChannel platformViewsChannel2 = new PlatformViewsChannel(dartExecutor);
            this.platformViewsChannel = platformViewsChannel2;
            platformViewsChannel2.setPlatformViewsHandler(this.channelHandler);
            return;
        }
        throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    }

    public void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge) {
        this.accessibilityEventsDelegate.setAccessibilityBridge(accessibilityBridge);
    }

    public void attachTextInputPlugin(TextInputPlugin textInputPlugin2) {
        this.textInputPlugin = textInputPlugin2;
    }

    public void attachToFlutterRenderer(FlutterRenderer flutterRenderer) {
        this.androidTouchProcessor = new AndroidTouchProcessor(flutterRenderer, true);
    }

    public void attachToView(FlutterView flutterView2) {
        this.flutterView = flutterView2;
        for (int i5 = 0; i5 < this.viewWrappers.size(); i5++) {
            this.flutterView.addView(this.viewWrappers.valueAt(i5));
        }
        for (int i6 = 0; i6 < this.platformViewParent.size(); i6++) {
            this.flutterView.addView(this.platformViewParent.valueAt(i6));
        }
        for (int i7 = 0; i7 < this.platformViews.size(); i7++) {
            this.platformViews.valueAt(i7).onFlutterViewAttached(this.flutterView);
        }
    }

    public boolean checkInputConnectionProxy(View view) {
        if (view == null || !this.contextToEmbeddedView.containsKey(view.getContext())) {
            return false;
        }
        View view2 = this.contextToEmbeddedView.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    public long configureForTextureLayerComposition(PlatformView platformView, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        long j5;
        PlatformViewWrapper platformViewWrapper;
        enforceMinimumAndroidApiVersion(23);
        Log.i(TAG, "Hosting view in view hierarchy for platform view: " + platformViewCreationRequest.viewId);
        int physicalPixels = toPhysicalPixels(platformViewCreationRequest.logicalWidth);
        int physicalPixels2 = toPhysicalPixels(platformViewCreationRequest.logicalHeight);
        if (this.usesSoftwareRendering) {
            platformViewWrapper = new PlatformViewWrapper(this.context);
            j5 = -1;
        } else {
            PlatformViewRenderTarget makePlatformViewRenderTarget = makePlatformViewRenderTarget(this.textureRegistry);
            PlatformViewWrapper platformViewWrapper2 = new PlatformViewWrapper(this.context, makePlatformViewRenderTarget);
            long id = makePlatformViewRenderTarget.getId();
            platformViewWrapper = platformViewWrapper2;
            j5 = id;
        }
        platformViewWrapper.setTouchProcessor(this.androidTouchProcessor);
        platformViewWrapper.resizeRenderTarget(physicalPixels, physicalPixels2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(physicalPixels, physicalPixels2);
        int physicalPixels3 = toPhysicalPixels(platformViewCreationRequest.logicalTop);
        int physicalPixels4 = toPhysicalPixels(platformViewCreationRequest.logicalLeft);
        layoutParams.topMargin = physicalPixels3;
        layoutParams.leftMargin = physicalPixels4;
        platformViewWrapper.setLayoutParams(layoutParams);
        View view = platformView.getView();
        view.setLayoutParams(new FrameLayout.LayoutParams(physicalPixels, physicalPixels2));
        view.setImportantForAccessibility(4);
        platformViewWrapper.addView(view);
        platformViewWrapper.setOnDescendantFocusChangeListener(new h(this, platformViewCreationRequest));
        this.flutterView.addView(platformViewWrapper);
        this.viewWrappers.append(platformViewCreationRequest.viewId, platformViewWrapper);
        maybeInvokeOnFlutterViewAttached(platformView);
        return j5;
    }

    public FlutterOverlaySurface createOverlaySurface() {
        return createOverlaySurface(new PlatformOverlayView(this.flutterView.getContext(), this.flutterView.getWidth(), this.flutterView.getHeight(), this.accessibilityEventsDelegate));
    }

    public FlutterOverlaySurface createOverlaySurface(PlatformOverlayView platformOverlayView) {
        int i5 = this.nextOverlayLayerId;
        this.nextOverlayLayerId = i5 + 1;
        this.overlayLayerViews.put(i5, platformOverlayView);
        return new FlutterOverlaySurface(i5, platformOverlayView.getSurface());
    }

    public PlatformView createPlatformView(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, boolean z4) {
        PlatformViewFactory factory = this.registry.getFactory(platformViewCreationRequest.viewType);
        if (factory != null) {
            Object obj = null;
            if (platformViewCreationRequest.params != null) {
                obj = factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params);
            }
            PlatformView create = factory.create(z4 ? new MutableContextWrapper(this.context) : this.context, platformViewCreationRequest.viewId, obj);
            View view = create.getView();
            if (view != null) {
                view.setLayoutDirection(platformViewCreationRequest.direction);
                this.platformViews.put(platformViewCreationRequest.viewId, create);
                maybeInvokeOnFlutterViewAttached(create);
                return create;
            }
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
    }

    public void destroyOverlaySurfaces() {
        for (int i5 = 0; i5 < this.overlayLayerViews.size(); i5++) {
            PlatformOverlayView valueAt = this.overlayLayerViews.valueAt(i5);
            valueAt.detachFromRenderer();
            valueAt.closeImageReader();
        }
    }

    public void detach() {
        PlatformViewsChannel platformViewsChannel2 = this.platformViewsChannel;
        if (platformViewsChannel2 != null) {
            platformViewsChannel2.setPlatformViewsHandler((PlatformViewsChannel.PlatformViewsHandler) null);
        }
        destroyOverlaySurfaces();
        this.platformViewsChannel = null;
        this.context = null;
        this.textureRegistry = null;
    }

    public void detachAccessibilityBridge() {
        this.accessibilityEventsDelegate.setAccessibilityBridge((AccessibilityBridge) null);
    }

    public void detachFromView() {
        for (int i5 = 0; i5 < this.viewWrappers.size(); i5++) {
            this.flutterView.removeView(this.viewWrappers.valueAt(i5));
        }
        for (int i6 = 0; i6 < this.platformViewParent.size(); i6++) {
            this.flutterView.removeView(this.platformViewParent.valueAt(i6));
        }
        destroyOverlaySurfaces();
        removeOverlaySurfaces();
        this.flutterView = null;
        this.flutterViewConvertedToImageView = false;
        for (int i7 = 0; i7 < this.platformViews.size(); i7++) {
            this.platformViews.valueAt(i7).onFlutterViewDetached();
        }
    }

    public void detachTextInputPlugin() {
        this.textInputPlugin = null;
    }

    public void disposePlatformView(int i5) {
        this.channelHandler.dispose(i5);
    }

    public SparseArray<PlatformOverlayView> getOverlayLayerViews() {
        return this.overlayLayerViews;
    }

    public View getPlatformViewById(int i5) {
        if (usesVirtualDisplay(i5)) {
            return this.vdControllers.get(Integer.valueOf(i5)).getView();
        }
        PlatformView platformView = this.platformViews.get(i5);
        if (platformView == null) {
            return null;
        }
        return platformView.getView();
    }

    public PlatformViewRegistry getRegistry() {
        return this.registry;
    }

    /* access modifiers changed from: package-private */
    public void initializePlatformViewIfNeeded(int i5) {
        PlatformView platformView = this.platformViews.get(i5);
        if (platformView == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        } else if (this.platformViewParent.get(i5) == null) {
            View view = platformView.getView();
            if (view == null) {
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            } else if (view.getParent() == null) {
                Context context2 = this.context;
                FlutterMutatorView flutterMutatorView = new FlutterMutatorView(context2, context2.getResources().getDisplayMetrics().density, this.androidTouchProcessor);
                flutterMutatorView.setOnDescendantFocusChangeListener(new g(this, i5));
                this.platformViewParent.put(i5, flutterMutatorView);
                view.setImportantForAccessibility(4);
                flutterMutatorView.addView(view);
                this.flutterView.addView(flutterMutatorView);
            } else {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
        }
    }

    public void onAttachedToJNI() {
    }

    public void onBeginFrame() {
        this.currentFrameUsedOverlayLayerIds.clear();
        this.currentFrameUsedPlatformViewIds.clear();
    }

    public void onDetachedFromJNI() {
        diposeAllViews();
    }

    public void onDisplayOverlaySurface(int i5, int i6, int i7, int i8, int i9) {
        if (this.overlayLayerViews.get(i5) != null) {
            initializeRootImageViewIfNeeded();
            PlatformOverlayView platformOverlayView = this.overlayLayerViews.get(i5);
            if (platformOverlayView.getParent() == null) {
                this.flutterView.addView(platformOverlayView);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i8, i9);
            layoutParams.leftMargin = i6;
            layoutParams.topMargin = i7;
            platformOverlayView.setLayoutParams(layoutParams);
            platformOverlayView.setVisibility(0);
            platformOverlayView.bringToFront();
            this.currentFrameUsedOverlayLayerIds.add(Integer.valueOf(i5));
            return;
        }
        throw new IllegalStateException("The overlay surface (id:" + i5 + ") doesn't exist");
    }

    public void onDisplayPlatformView(int i5, int i6, int i7, int i8, int i9, int i10, int i11, FlutterMutatorsStack flutterMutatorsStack) {
        initializeRootImageViewIfNeeded();
        initializePlatformViewIfNeeded(i5);
        FlutterMutatorView flutterMutatorView = this.platformViewParent.get(i5);
        flutterMutatorView.readyToDisplay(flutterMutatorsStack, i6, i7, i8, i9);
        flutterMutatorView.setVisibility(0);
        flutterMutatorView.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i10, i11);
        View view = this.platformViews.get(i5).getView();
        if (view != null) {
            view.setLayoutParams(layoutParams);
            view.bringToFront();
        }
        this.currentFrameUsedPlatformViewIds.add(Integer.valueOf(i5));
    }

    public void onEndFrame() {
        boolean z4 = false;
        if (!this.flutterViewConvertedToImageView || !this.currentFrameUsedPlatformViewIds.isEmpty()) {
            if (this.flutterViewConvertedToImageView && this.flutterView.acquireLatestImageViewFrame()) {
                z4 = true;
            }
            finishFrame(z4);
            return;
        }
        this.flutterViewConvertedToImageView = false;
        this.flutterView.revertImageView(new i(this));
    }

    public void onPreEngineRestart() {
        diposeAllViews();
    }

    public void setSoftwareRendering(boolean z4) {
        this.usesSoftwareRendering = z4;
    }

    public MotionEvent toMotionEvent(float f5, PlatformViewsChannel.PlatformViewTouch platformViewTouch, boolean z4) {
        PlatformViewsChannel.PlatformViewTouch platformViewTouch2 = platformViewTouch;
        MotionEvent pop = this.motionEventTracker.pop(MotionEventTracker.MotionEventId.from(platformViewTouch2.motionEventId));
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) parsePointerPropertiesList(platformViewTouch2.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch2.pointerCount]);
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) parsePointerCoordsList(platformViewTouch2.rawPointerCoords, f5).toArray(new MotionEvent.PointerCoords[platformViewTouch2.pointerCount]);
        if (!z4 && pop != null) {
            return MotionEvent.obtain(pop.getDownTime(), pop.getEventTime(), platformViewTouch2.action, platformViewTouch2.pointerCount, pointerPropertiesArr, pointerCoordsArr, pop.getMetaState(), pop.getButtonState(), pop.getXPrecision(), pop.getYPrecision(), pop.getDeviceId(), pop.getEdgeFlags(), pop.getSource(), pop.getFlags());
        }
        return MotionEvent.obtain(platformViewTouch2.downTime.longValue(), platformViewTouch2.eventTime.longValue(), platformViewTouch2.action, platformViewTouch2.pointerCount, pointerPropertiesArr, pointerCoordsArr, platformViewTouch2.metaState, platformViewTouch2.buttonState, platformViewTouch2.xPrecision, platformViewTouch2.yPrecision, platformViewTouch2.deviceId, platformViewTouch2.edgeFlags, platformViewTouch2.source, platformViewTouch2.flags);
    }

    public boolean usesVirtualDisplay(int i5) {
        return this.vdControllers.containsKey(Integer.valueOf(i5));
    }
}
