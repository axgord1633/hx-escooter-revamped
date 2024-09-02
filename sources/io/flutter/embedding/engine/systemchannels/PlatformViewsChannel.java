package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlatformViewsChannel {
    private static final String TAG = "PlatformViewsChannel";
    private final MethodChannel channel;
    /* access modifiers changed from: private */
    public PlatformViewsHandler handler;
    private final MethodChannel.MethodCallHandler parsingHandler;

    public interface PlatformViewBufferResized {
        void run(PlatformViewBufferSize platformViewBufferSize);
    }

    public static class PlatformViewBufferSize {
        public final int height;
        public final int width;

        public PlatformViewBufferSize(int i5, int i6) {
            this.width = i5;
            this.height = i6;
        }
    }

    public static class PlatformViewCreationRequest {
        public final int direction;
        public final RequestedDisplayMode displayMode;
        public final double logicalHeight;
        public final double logicalLeft;
        public final double logicalTop;
        public final double logicalWidth;
        public final ByteBuffer params;
        public final int viewId;
        public final String viewType;

        public enum RequestedDisplayMode {
            TEXTURE_WITH_VIRTUAL_FALLBACK,
            TEXTURE_WITH_HYBRID_FALLBACK,
            HYBRID_ONLY
        }

        public PlatformViewCreationRequest(int i5, String str, double d5, double d6, double d7, double d8, int i6, RequestedDisplayMode requestedDisplayMode, ByteBuffer byteBuffer) {
            this.viewId = i5;
            this.viewType = str;
            this.logicalTop = d5;
            this.logicalLeft = d6;
            this.logicalWidth = d7;
            this.logicalHeight = d8;
            this.direction = i6;
            this.displayMode = requestedDisplayMode;
            this.params = byteBuffer;
        }

        public PlatformViewCreationRequest(int i5, String str, double d5, double d6, double d7, double d8, int i6, ByteBuffer byteBuffer) {
            this(i5, str, d5, d6, d7, d8, i6, RequestedDisplayMode.TEXTURE_WITH_VIRTUAL_FALLBACK, byteBuffer);
        }
    }

    public static class PlatformViewResizeRequest {
        public final double newLogicalHeight;
        public final double newLogicalWidth;
        public final int viewId;

        public PlatformViewResizeRequest(int i5, double d5, double d6) {
            this.viewId = i5;
            this.newLogicalWidth = d5;
            this.newLogicalHeight = d6;
        }
    }

    public static class PlatformViewTouch {
        public final int action;
        public final int buttonState;
        public final int deviceId;
        public final Number downTime;
        public final int edgeFlags;
        public final Number eventTime;
        public final int flags;
        public final int metaState;
        public final long motionEventId;
        public final int pointerCount;
        public final Object rawPointerCoords;
        public final Object rawPointerPropertiesList;
        public final int source;
        public final int viewId;
        public final float xPrecision;
        public final float yPrecision;

        public PlatformViewTouch(int i5, Number number, Number number2, int i6, int i7, Object obj, Object obj2, int i8, int i9, float f5, float f6, int i10, int i11, int i12, int i13, long j5) {
            this.viewId = i5;
            this.downTime = number;
            this.eventTime = number2;
            this.action = i6;
            this.pointerCount = i7;
            this.rawPointerPropertiesList = obj;
            this.rawPointerCoords = obj2;
            this.metaState = i8;
            this.buttonState = i9;
            this.xPrecision = f5;
            this.yPrecision = f6;
            this.deviceId = i10;
            this.edgeFlags = i11;
            this.source = i12;
            this.flags = i13;
            this.motionEventId = j5;
        }
    }

    public interface PlatformViewsHandler {
        public static final long NON_TEXTURE_FALLBACK = -2;

        void clearFocus(int i5);

        void createForPlatformViewLayer(PlatformViewCreationRequest platformViewCreationRequest);

        long createForTextureLayer(PlatformViewCreationRequest platformViewCreationRequest);

        void dispose(int i5);

        void offset(int i5, double d5, double d6);

        void onTouch(PlatformViewTouch platformViewTouch);

        void resize(PlatformViewResizeRequest platformViewResizeRequest, PlatformViewBufferResized platformViewBufferResized);

        void setDirection(int i5, int i6);

        void synchronizeToNativeViewHierarchy(boolean z4);
    }

    public PlatformViewsChannel(DartExecutor dartExecutor) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            private void clearFocus(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    PlatformViewsChannel.this.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                    result.success((Object) null);
                } catch (IllegalStateException e5) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e5), (Object) null);
                }
            }

            private void create(MethodCall methodCall, MethodChannel.Result result) {
                MethodChannel.Result result2 = result;
                Map map = (Map) methodCall.arguments();
                boolean z4 = true;
                boolean z5 = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
                ByteBuffer wrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
                if (z5) {
                    try {
                        PlatformViewsChannel.this.handler.createForPlatformViewLayer(new PlatformViewCreationRequest(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), PlatformViewCreationRequest.RequestedDisplayMode.HYBRID_ONLY, wrap));
                    } catch (IllegalStateException e5) {
                        result2.error("error", PlatformViewsChannel.detailedExceptionString(e5), (Object) null);
                        return;
                    }
                } else {
                    if (!map.containsKey("hybridFallback") || !((Boolean) map.get("hybridFallback")).booleanValue()) {
                        z4 = false;
                    }
                    PlatformViewCreationRequest.RequestedDisplayMode requestedDisplayMode = z4 ? PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_HYBRID_FALLBACK : PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_VIRTUAL_FALLBACK;
                    int intValue = ((Integer) map.get("id")).intValue();
                    String str = (String) map.get("viewType");
                    double d5 = 0.0d;
                    double doubleValue = map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d;
                    if (map.containsKey("left")) {
                        d5 = ((Double) map.get("left")).doubleValue();
                    }
                    long createForTextureLayer = PlatformViewsChannel.this.handler.createForTextureLayer(new PlatformViewCreationRequest(intValue, str, doubleValue, d5, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), requestedDisplayMode, wrap));
                    if (createForTextureLayer != -2) {
                        result2.success(Long.valueOf(createForTextureLayer));
                        return;
                    } else if (!z4) {
                        throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                    }
                }
                result2.success((Object) null);
            }

            private void dispose(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    PlatformViewsChannel.this.handler.dispose(((Integer) ((Map) methodCall.arguments()).get("id")).intValue());
                    result.success((Object) null);
                } catch (IllegalStateException e5) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e5), (Object) null);
                }
            }

            /* access modifiers changed from: private */
            public static /* synthetic */ void lambda$resize$0(MethodChannel.Result result, PlatformViewBufferSize platformViewBufferSize) {
                if (platformViewBufferSize == null) {
                    result.error("error", "Failed to resize the platform view", (Object) null);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("width", Double.valueOf((double) platformViewBufferSize.width));
                hashMap.put("height", Double.valueOf((double) platformViewBufferSize.height));
                result.success(hashMap);
            }

            private void offset(MethodCall methodCall, MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewsChannel.this.handler.offset(((Integer) map.get("id")).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                    result.success((Object) null);
                } catch (IllegalStateException e5) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e5), (Object) null);
                }
            }

            private void resize(MethodCall methodCall, MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewsChannel.this.handler.resize(new PlatformViewResizeRequest(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new c(result));
                } catch (IllegalStateException e5) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e5), (Object) null);
                }
            }

            private void setDirection(MethodCall methodCall, MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewsChannel.this.handler.setDirection(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                    result.success((Object) null);
                } catch (IllegalStateException e5) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e5), (Object) null);
                }
            }

            private void synchronizeToNativeViewHierarchy(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    PlatformViewsChannel.this.handler.synchronizeToNativeViewHierarchy(((Boolean) methodCall.arguments()).booleanValue());
                    result.success((Object) null);
                } catch (IllegalStateException e5) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e5), (Object) null);
                }
            }

            private void touch(MethodCall methodCall, MethodChannel.Result result) {
                MethodChannel.Result result2;
                MethodChannel.Result result3 = result;
                List list = (List) methodCall.arguments();
                PlatformViewTouch platformViewTouch = r2;
                PlatformViewTouch platformViewTouch2 = platformViewTouch;
                PlatformViewTouch platformViewTouch3 = new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue());
                try {
                    PlatformViewsChannel.this.handler.onTouch(platformViewTouch);
                    result2 = result;
                    try {
                        result2.success((Object) null);
                    } catch (IllegalStateException e5) {
                        e = e5;
                    }
                } catch (IllegalStateException e6) {
                    e = e6;
                    result2 = result;
                    result2.error("error", PlatformViewsChannel.detailedExceptionString(e), (Object) null);
                }
            }

            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (PlatformViewsChannel.this.handler != null) {
                    Log.v(PlatformViewsChannel.TAG, "Received '" + methodCall.method + "' message.");
                    String str = methodCall.method;
                    str.hashCode();
                    char c5 = 65535;
                    switch (str.hashCode()) {
                        case -1352294148:
                            if (str.equals("create")) {
                                c5 = 0;
                                break;
                            }
                            break;
                        case -1019779949:
                            if (str.equals("offset")) {
                                c5 = 1;
                                break;
                            }
                            break;
                        case -934437708:
                            if (str.equals("resize")) {
                                c5 = 2;
                                break;
                            }
                            break;
                        case -756050293:
                            if (str.equals("clearFocus")) {
                                c5 = 3;
                                break;
                            }
                            break;
                        case -308988850:
                            if (str.equals("synchronizeToNativeViewHierarchy")) {
                                c5 = 4;
                                break;
                            }
                            break;
                        case 110550847:
                            if (str.equals("touch")) {
                                c5 = 5;
                                break;
                            }
                            break;
                        case 576796989:
                            if (str.equals("setDirection")) {
                                c5 = 6;
                                break;
                            }
                            break;
                        case 1671767583:
                            if (str.equals("dispose")) {
                                c5 = 7;
                                break;
                            }
                            break;
                    }
                    switch (c5) {
                        case 0:
                            create(methodCall, result);
                            return;
                        case 1:
                            offset(methodCall, result);
                            return;
                        case 2:
                            resize(methodCall, result);
                            return;
                        case 3:
                            clearFocus(methodCall, result);
                            return;
                        case 4:
                            synchronizeToNativeViewHierarchy(methodCall, result);
                            return;
                        case 5:
                            touch(methodCall, result);
                            return;
                        case 6:
                            setDirection(methodCall, result);
                            return;
                        case 7:
                            dispose(methodCall, result);
                            return;
                        default:
                            result.notImplemented();
                            return;
                    }
                }
            }
        };
        this.parsingHandler = r02;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    /* access modifiers changed from: private */
    public static String detailedExceptionString(Exception exc) {
        return Log.getStackTraceString(exc);
    }

    public void invokeViewFocused(int i5) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("viewFocused", Integer.valueOf(i5));
        }
    }

    public void setPlatformViewsHandler(PlatformViewsHandler platformViewsHandler) {
        this.handler = platformViewsHandler;
    }
}
