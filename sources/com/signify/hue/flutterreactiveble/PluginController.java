package com.signify.hue.flutterreactiveble;

import android.content.Context;
import com.signify.hue.flutterreactiveble.ProtobufModel;
import com.signify.hue.flutterreactiveble.ble.BleClient;
import com.signify.hue.flutterreactiveble.ble.CharOperationFailed;
import com.signify.hue.flutterreactiveble.ble.CharOperationResult;
import com.signify.hue.flutterreactiveble.ble.CharOperationSuccessful;
import com.signify.hue.flutterreactiveble.ble.MtuNegotiateFailed;
import com.signify.hue.flutterreactiveble.ble.MtuNegotiateResult;
import com.signify.hue.flutterreactiveble.ble.ReactiveBleClient;
import com.signify.hue.flutterreactiveble.ble.RequestConnectionPriorityFailed;
import com.signify.hue.flutterreactiveble.ble.RequestConnectionPriorityResult;
import com.signify.hue.flutterreactiveble.channelhandlers.BleStatusHandler;
import com.signify.hue.flutterreactiveble.channelhandlers.CharNotificationHandler;
import com.signify.hue.flutterreactiveble.channelhandlers.DeviceConnectionHandler;
import com.signify.hue.flutterreactiveble.channelhandlers.ScanDevicesHandler;
import com.signify.hue.flutterreactiveble.converters.ProtobufMessageConverter;
import com.signify.hue.flutterreactiveble.converters.UuidConverter;
import com.signify.hue.flutterreactiveble.model.ClearGattCacheErrorType;
import com.signify.hue.flutterreactiveble.utils.BleWrapperExtensionsKt;
import com.signify.hue.flutterreactiveble.utils.DiscardKt;
import com.yalantis.ucrop.BuildConfig;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.k;
import m2.r;
import m3.n;
import m3.q;
import o2.a;
import p1.q0;
import v3.p;
import v3.s;

public final class PluginController {
    private BleClient bleClient;
    private EventChannel charNotificationChannel;
    private CharNotificationHandler charNotificationHandler;
    private EventChannel deviceConnectionChannel;
    private DeviceConnectionHandler deviceConnectionHandler;
    private final Map<String, p<MethodCall, MethodChannel.Result, q>> pluginMethods = e0.e(n.a("initialize", new PluginController$pluginMethods$1(this)), n.a("deinitialize", new PluginController$pluginMethods$2(this)), n.a("scanForDevices", new PluginController$pluginMethods$3(this)), n.a("connectToDevice", new PluginController$pluginMethods$4(this)), n.a("clearGattCache", new PluginController$pluginMethods$5(this)), n.a("disconnectFromDevice", new PluginController$pluginMethods$6(this)), n.a("readCharacteristic", new PluginController$pluginMethods$7(this)), n.a("writeCharacteristicWithResponse", new PluginController$pluginMethods$8(this)), n.a("writeCharacteristicWithoutResponse", new PluginController$pluginMethods$9(this)), n.a("readNotifications", new PluginController$pluginMethods$10(this)), n.a("stopNotifications", new PluginController$pluginMethods$11(this)), n.a("negotiateMtuSize", new PluginController$pluginMethods$12(this)), n.a("requestConnectionPriority", new PluginController$pluginMethods$13(this)), n.a("discoverServices", new PluginController$pluginMethods$14(this)), n.a("getDiscoveredServices", new PluginController$pluginMethods$15(this)));
    private final ProtobufMessageConverter protoConverter = new ProtobufMessageConverter();
    private ScanDevicesHandler scanDevicesHandler;
    private EventChannel scanchannel;
    private final UuidConverter uuidConverter = new UuidConverter();

    /* access modifiers changed from: private */
    public final void clearGattCache(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        k.c(obj, "null cannot be cast to non-null type kotlin.ByteArray");
        ProtobufModel.ClearGattCacheRequest parseFrom = ProtobufModel.ClearGattCacheRequest.parseFrom((byte[]) obj);
        BleClient bleClient2 = this.bleClient;
        if (bleClient2 == null) {
            k.o("bleClient");
            bleClient2 = null;
        }
        String deviceId = parseFrom.getDeviceId();
        k.d(deviceId, "args.deviceId");
        DiscardKt.discard(bleClient2.clearGattCache(deviceId).h(a.a()).l(new b(result), new c(this, result)));
    }

    /* access modifiers changed from: private */
    /* renamed from: clearGattCache$lambda-0  reason: not valid java name */
    public static final void m8clearGattCache$lambda0(MethodChannel.Result result) {
        k.e(result, "$result");
        result.success(ProtobufModel.ClearGattCacheInfo.getDefaultInstance().toByteArray());
    }

    /* access modifiers changed from: private */
    /* renamed from: clearGattCache$lambda-1  reason: not valid java name */
    public static final void m9clearGattCache$lambda1(PluginController pluginController, MethodChannel.Result result, Throwable th) {
        k.e(pluginController, "this$0");
        k.e(result, "$result");
        result.success(pluginController.protoConverter.convertClearGattCacheError(ClearGattCacheErrorType.UNKNOWN, th.getMessage()).toByteArray());
    }

    /* access modifiers changed from: private */
    public final void connectToDevice(MethodCall methodCall, MethodChannel.Result result) {
        DeviceConnectionHandler deviceConnectionHandler2 = null;
        result.success((Object) null);
        Object obj = methodCall.arguments;
        k.c(obj, "null cannot be cast to non-null type kotlin.ByteArray");
        ProtobufModel.ConnectToDeviceRequest parseFrom = ProtobufModel.ConnectToDeviceRequest.parseFrom((byte[]) obj);
        DeviceConnectionHandler deviceConnectionHandler3 = this.deviceConnectionHandler;
        if (deviceConnectionHandler3 == null) {
            k.o("deviceConnectionHandler");
        } else {
            deviceConnectionHandler2 = deviceConnectionHandler3;
        }
        k.d(parseFrom, "connectDeviceMessage");
        deviceConnectionHandler2.connectToDevice(parseFrom);
    }

    /* access modifiers changed from: private */
    public final void deinitializeClient(MethodCall methodCall, MethodChannel.Result result) {
        deinitialize$reactive_ble_mobile_release();
        result.success((Object) null);
    }

    /* access modifiers changed from: private */
    public final void disconnectFromDevice(MethodCall methodCall, MethodChannel.Result result) {
        DeviceConnectionHandler deviceConnectionHandler2 = null;
        result.success((Object) null);
        Object obj = methodCall.arguments;
        k.c(obj, "null cannot be cast to non-null type kotlin.ByteArray");
        ProtobufModel.DisconnectFromDeviceRequest parseFrom = ProtobufModel.DisconnectFromDeviceRequest.parseFrom((byte[]) obj);
        DeviceConnectionHandler deviceConnectionHandler3 = this.deviceConnectionHandler;
        if (deviceConnectionHandler3 == null) {
            k.o("deviceConnectionHandler");
        } else {
            deviceConnectionHandler2 = deviceConnectionHandler3;
        }
        String deviceId = parseFrom.getDeviceId();
        k.d(deviceId, "connectDeviceMessage.deviceId");
        deviceConnectionHandler2.disconnectDevice(deviceId);
    }

    /* access modifiers changed from: private */
    public final void discoverServices(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        k.c(obj, "null cannot be cast to non-null type kotlin.ByteArray");
        ProtobufModel.DiscoverServicesRequest parseFrom = ProtobufModel.DiscoverServicesRequest.parseFrom((byte[]) obj);
        BleClient bleClient2 = this.bleClient;
        if (bleClient2 == null) {
            k.o("bleClient");
            bleClient2 = null;
        }
        String deviceId = parseFrom.getDeviceId();
        k.d(deviceId, "request.deviceId");
        DiscardKt.discard(bleClient2.discoverServices(deviceId).z(a.a()).C(new a(result, this, parseFrom), new d(result)));
    }

    /* access modifiers changed from: private */
    /* renamed from: discoverServices$lambda-10  reason: not valid java name */
    public static final void m10discoverServices$lambda10(MethodChannel.Result result, PluginController pluginController, ProtobufModel.DiscoverServicesRequest discoverServicesRequest, q0 q0Var) {
        k.e(result, "$result");
        k.e(pluginController, "this$0");
        ProtobufMessageConverter protobufMessageConverter = pluginController.protoConverter;
        String deviceId = discoverServicesRequest.getDeviceId();
        k.d(deviceId, "request.deviceId");
        k.d(q0Var, "discoverResult");
        result.success(protobufMessageConverter.convertDiscoverServicesInfo(deviceId, q0Var).toByteArray());
    }

    /* access modifiers changed from: private */
    /* renamed from: discoverServices$lambda-11  reason: not valid java name */
    public static final void m11discoverServices$lambda11(MethodChannel.Result result, Throwable th) {
        k.e(result, "$result");
        String th2 = th.toString();
        StackTraceElement[] stackTrace = th.getStackTrace();
        k.d(stackTrace, "throwable.stackTrace");
        result.error("service_discovery_failure", th2, j.v(stackTrace).toString());
    }

    private final void executeWriteAndPropagateResultToChannel(MethodCall methodCall, MethodChannel.Result result, s<? super BleClient, ? super String, ? super UUID, ? super Integer, ? super byte[], ? extends r<CharOperationResult>> sVar) {
        Object obj = methodCall.arguments;
        k.c(obj, "null cannot be cast to non-null type kotlin.ByteArray");
        ProtobufModel.WriteCharacteristicRequest parseFrom = ProtobufModel.WriteCharacteristicRequest.parseFrom((byte[]) obj);
        BleClient bleClient2 = this.bleClient;
        if (bleClient2 == null) {
            k.o("bleClient");
            bleClient2 = null;
        }
        BleClient bleClient3 = bleClient2;
        String deviceId = parseFrom.getCharacteristic().getDeviceId();
        k.d(deviceId, "writeCharMessage.characteristic.deviceId");
        UuidConverter uuidConverter2 = this.uuidConverter;
        byte[] y4 = parseFrom.getCharacteristic().getCharacteristicUuid().getData().y();
        k.d(y4, "writeCharMessage.charact…icUuid.data.toByteArray()");
        UUID uuidFromByteArray = uuidConverter2.uuidFromByteArray(y4);
        String characteristicInstanceId = parseFrom.getCharacteristic().getCharacteristicInstanceId();
        k.d(characteristicInstanceId, "writeCharMessage.charact….characteristicInstanceId");
        Integer valueOf = Integer.valueOf(Integer.parseInt(characteristicInstanceId));
        byte[] y5 = parseFrom.getValue().y();
        k.d(y5, "writeCharMessage.value.toByteArray()");
        DiscardKt.discard(((r) sVar.invoke(bleClient3, deviceId, uuidFromByteArray, valueOf, y5)).z(a.a()).C(new k(result, this, parseFrom), new l(result, this, parseFrom)));
    }

    /* access modifiers changed from: private */
    /* renamed from: executeWriteAndPropagateResultToChannel$lambda-4  reason: not valid java name */
    public static final void m12executeWriteAndPropagateResultToChannel$lambda4(MethodChannel.Result result, PluginController pluginController, ProtobufModel.WriteCharacteristicRequest writeCharacteristicRequest, CharOperationResult charOperationResult) {
        k.e(result, "$result");
        k.e(pluginController, "this$0");
        if (charOperationResult instanceof CharOperationSuccessful) {
            ProtobufMessageConverter protobufMessageConverter = pluginController.protoConverter;
            k.d(writeCharacteristicRequest, "writeCharMessage");
            result.success(protobufMessageConverter.convertWriteCharacteristicInfo(writeCharacteristicRequest, (String) null).toByteArray());
        } else if (charOperationResult instanceof CharOperationFailed) {
            ProtobufMessageConverter protobufMessageConverter2 = pluginController.protoConverter;
            k.d(writeCharacteristicRequest, "writeCharMessage");
            result.success(protobufMessageConverter2.convertWriteCharacteristicInfo(writeCharacteristicRequest, ((CharOperationFailed) charOperationResult).getErrorMessage()).toByteArray());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: executeWriteAndPropagateResultToChannel$lambda-5  reason: not valid java name */
    public static final void m13executeWriteAndPropagateResultToChannel$lambda5(MethodChannel.Result result, PluginController pluginController, ProtobufModel.WriteCharacteristicRequest writeCharacteristicRequest, Throwable th) {
        k.e(result, "$result");
        k.e(pluginController, "this$0");
        ProtobufMessageConverter protobufMessageConverter = pluginController.protoConverter;
        k.d(writeCharacteristicRequest, "writeCharMessage");
        result.success(protobufMessageConverter.convertWriteCharacteristicInfo(writeCharacteristicRequest, th.getMessage()).toByteArray());
    }

    /* access modifiers changed from: private */
    public final void initializeClient(MethodCall methodCall, MethodChannel.Result result) {
        BleClient bleClient2 = this.bleClient;
        if (bleClient2 == null) {
            k.o("bleClient");
            bleClient2 = null;
        }
        bleClient2.initializeClient();
        result.success((Object) null);
    }

    /* access modifiers changed from: private */
    public final void negotiateMtuSize(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        k.c(obj, "null cannot be cast to non-null type kotlin.ByteArray");
        ProtobufModel.NegotiateMtuRequest parseFrom = ProtobufModel.NegotiateMtuRequest.parseFrom((byte[]) obj);
        BleClient bleClient2 = this.bleClient;
        if (bleClient2 == null) {
            k.o("bleClient");
            bleClient2 = null;
        }
        String deviceId = parseFrom.getDeviceId();
        k.d(deviceId, "request.deviceId");
        DiscardKt.discard(bleClient2.negotiateMtuSize(deviceId, parseFrom.getMtuSize()).z(a.a()).C(new e(result, this), new f(result, this, parseFrom)));
    }

    /* access modifiers changed from: private */
    /* renamed from: negotiateMtuSize$lambda-6  reason: not valid java name */
    public static final void m14negotiateMtuSize$lambda6(MethodChannel.Result result, PluginController pluginController, MtuNegotiateResult mtuNegotiateResult) {
        k.e(result, "$result");
        k.e(pluginController, "this$0");
        ProtobufMessageConverter protobufMessageConverter = pluginController.protoConverter;
        k.d(mtuNegotiateResult, "mtuResult");
        result.success(protobufMessageConverter.convertNegotiateMtuInfo(mtuNegotiateResult).toByteArray());
    }

    /* access modifiers changed from: private */
    /* renamed from: negotiateMtuSize$lambda-7  reason: not valid java name */
    public static final void m15negotiateMtuSize$lambda7(MethodChannel.Result result, PluginController pluginController, ProtobufModel.NegotiateMtuRequest negotiateMtuRequest, Throwable th) {
        k.e(result, "$result");
        k.e(pluginController, "this$0");
        ProtobufMessageConverter protobufMessageConverter = pluginController.protoConverter;
        String deviceId = negotiateMtuRequest.getDeviceId();
        k.d(deviceId, "request.deviceId");
        String message = th.getMessage();
        if (message == null) {
            message = BuildConfig.FLAVOR;
        }
        result.success(protobufMessageConverter.convertNegotiateMtuInfo(new MtuNegotiateFailed(deviceId, message)).toByteArray());
    }

    /* access modifiers changed from: private */
    public final void readCharacteristic(MethodCall methodCall, MethodChannel.Result result) {
        BleClient bleClient2 = null;
        result.success((Object) null);
        Object obj = methodCall.arguments;
        k.c(obj, "null cannot be cast to non-null type kotlin.ByteArray");
        ProtobufModel.ReadCharacteristicRequest parseFrom = ProtobufModel.ReadCharacteristicRequest.parseFrom((byte[]) obj);
        String deviceId = parseFrom.getCharacteristic().getDeviceId();
        UuidConverter uuidConverter2 = this.uuidConverter;
        byte[] y4 = parseFrom.getCharacteristic().getCharacteristicUuid().getData().y();
        k.d(y4, "readCharMessage.characte…icUuid.data.toByteArray()");
        UUID uuidFromByteArray = uuidConverter2.uuidFromByteArray(y4);
        String characteristicInstanceId = parseFrom.getCharacteristic().getCharacteristicInstanceId();
        k.d(characteristicInstanceId, "readCharMessage.characte….characteristicInstanceId");
        int parseInt = Integer.parseInt(characteristicInstanceId);
        BleClient bleClient3 = this.bleClient;
        if (bleClient3 == null) {
            k.o("bleClient");
        } else {
            bleClient2 = bleClient3;
        }
        k.d(deviceId, "deviceId");
        DiscardKt.discard(bleClient2.readCharacteristic(deviceId, uuidFromByteArray, parseInt).z(a.a()).C(new g(this, parseFrom), new h(this, parseFrom)));
    }

    /* access modifiers changed from: private */
    /* renamed from: readCharacteristic$lambda-2  reason: not valid java name */
    public static final void m16readCharacteristic$lambda2(PluginController pluginController, ProtobufModel.ReadCharacteristicRequest readCharacteristicRequest, CharOperationResult charOperationResult) {
        k.e(pluginController, "this$0");
        CharNotificationHandler charNotificationHandler2 = null;
        if (charOperationResult instanceof CharOperationSuccessful) {
            ProtobufMessageConverter protobufMessageConverter = pluginController.protoConverter;
            ProtobufModel.CharacteristicAddress characteristic = readCharacteristicRequest.getCharacteristic();
            k.d(characteristic, "readCharMessage.characteristic");
            ProtobufModel.CharacteristicValueInfo convertCharacteristicInfo = protobufMessageConverter.convertCharacteristicInfo(characteristic, v.t(((CharOperationSuccessful) charOperationResult).getValue()));
            CharNotificationHandler charNotificationHandler3 = pluginController.charNotificationHandler;
            if (charNotificationHandler3 == null) {
                k.o("charNotificationHandler");
            } else {
                charNotificationHandler2 = charNotificationHandler3;
            }
            charNotificationHandler2.addSingleReadToStream(convertCharacteristicInfo);
        } else if (charOperationResult instanceof CharOperationFailed) {
            ProtobufMessageConverter protobufMessageConverter2 = pluginController.protoConverter;
            ProtobufModel.CharacteristicAddress characteristic2 = readCharacteristicRequest.getCharacteristic();
            k.d(characteristic2, "readCharMessage.characteristic");
            protobufMessageConverter2.convertCharacteristicError(characteristic2, "Failed to connect");
            CharNotificationHandler charNotificationHandler4 = pluginController.charNotificationHandler;
            if (charNotificationHandler4 == null) {
                k.o("charNotificationHandler");
            } else {
                charNotificationHandler2 = charNotificationHandler4;
            }
            ProtobufModel.CharacteristicAddress characteristic3 = readCharacteristicRequest.getCharacteristic();
            k.d(characteristic3, "readCharMessage.characteristic");
            charNotificationHandler2.addSingleErrorToStream(characteristic3, ((CharOperationFailed) charOperationResult).getErrorMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: readCharacteristic$lambda-3  reason: not valid java name */
    public static final void m17readCharacteristic$lambda3(PluginController pluginController, ProtobufModel.ReadCharacteristicRequest readCharacteristicRequest, Throwable th) {
        k.e(pluginController, "this$0");
        ProtobufMessageConverter protobufMessageConverter = pluginController.protoConverter;
        ProtobufModel.CharacteristicAddress characteristic = readCharacteristicRequest.getCharacteristic();
        k.d(characteristic, "readCharMessage.characteristic");
        protobufMessageConverter.convertCharacteristicError(characteristic, th.getMessage());
        CharNotificationHandler charNotificationHandler2 = pluginController.charNotificationHandler;
        if (charNotificationHandler2 == null) {
            k.o("charNotificationHandler");
            charNotificationHandler2 = null;
        }
        ProtobufModel.CharacteristicAddress characteristic2 = readCharacteristicRequest.getCharacteristic();
        k.d(characteristic2, "readCharMessage.characteristic");
        String message = th.getMessage();
        if (message == null) {
            message = "Failure";
        }
        charNotificationHandler2.addSingleErrorToStream(characteristic2, message);
    }

    /* access modifiers changed from: private */
    public final void readNotifications(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        k.c(obj, "null cannot be cast to non-null type kotlin.ByteArray");
        ProtobufModel.NotifyCharacteristicRequest parseFrom = ProtobufModel.NotifyCharacteristicRequest.parseFrom((byte[]) obj);
        CharNotificationHandler charNotificationHandler2 = this.charNotificationHandler;
        if (charNotificationHandler2 == null) {
            k.o("charNotificationHandler");
            charNotificationHandler2 = null;
        }
        k.d(parseFrom, "request");
        charNotificationHandler2.subscribeToNotifications(parseFrom);
        result.success((Object) null);
    }

    /* access modifiers changed from: private */
    public final void requestConnectionPriority(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        k.c(obj, "null cannot be cast to non-null type kotlin.ByteArray");
        ProtobufModel.ChangeConnectionPriorityRequest parseFrom = ProtobufModel.ChangeConnectionPriorityRequest.parseFrom((byte[]) obj);
        BleClient bleClient2 = this.bleClient;
        if (bleClient2 == null) {
            k.o("bleClient");
            bleClient2 = null;
        }
        String deviceId = parseFrom.getDeviceId();
        k.d(deviceId, "request.deviceId");
        DiscardKt.discard(bleClient2.requestConnectionPriority(deviceId, BleWrapperExtensionsKt.toConnectionPriority(parseFrom.getPriority())).z(a.a()).C(new i(result, this), new j(result, this, parseFrom)));
    }

    /* access modifiers changed from: private */
    /* renamed from: requestConnectionPriority$lambda-8  reason: not valid java name */
    public static final void m18requestConnectionPriority$lambda8(MethodChannel.Result result, PluginController pluginController, RequestConnectionPriorityResult requestConnectionPriorityResult) {
        k.e(result, "$result");
        k.e(pluginController, "this$0");
        ProtobufMessageConverter protobufMessageConverter = pluginController.protoConverter;
        k.d(requestConnectionPriorityResult, "requestResult");
        result.success(protobufMessageConverter.convertRequestConnectionPriorityInfo(requestConnectionPriorityResult).toByteArray());
    }

    /* access modifiers changed from: private */
    /* renamed from: requestConnectionPriority$lambda-9  reason: not valid java name */
    public static final void m19requestConnectionPriority$lambda9(MethodChannel.Result result, PluginController pluginController, ProtobufModel.ChangeConnectionPriorityRequest changeConnectionPriorityRequest, Throwable th) {
        String str;
        k.e(result, "$result");
        k.e(pluginController, "this$0");
        ProtobufMessageConverter protobufMessageConverter = pluginController.protoConverter;
        String deviceId = changeConnectionPriorityRequest.getDeviceId();
        k.d(deviceId, "request.deviceId");
        if (th == null || (str = th.getMessage()) == null) {
            str = "Unknown error";
        }
        result.success(protobufMessageConverter.convertRequestConnectionPriorityInfo(new RequestConnectionPriorityFailed(deviceId, str)).toByteArray());
    }

    /* access modifiers changed from: private */
    public final void scanForDevices(MethodCall methodCall, MethodChannel.Result result) {
        ScanDevicesHandler scanDevicesHandler2 = this.scanDevicesHandler;
        if (scanDevicesHandler2 == null) {
            k.o("scanDevicesHandler");
            scanDevicesHandler2 = null;
        }
        Object obj = methodCall.arguments;
        k.c(obj, "null cannot be cast to non-null type kotlin.ByteArray");
        ProtobufModel.ScanForDevicesRequest parseFrom = ProtobufModel.ScanForDevicesRequest.parseFrom((byte[]) obj);
        k.d(parseFrom, "parseFrom(call.arguments as ByteArray)");
        scanDevicesHandler2.prepareScan(parseFrom);
        result.success((Object) null);
    }

    /* access modifiers changed from: private */
    public final void stopNotifications(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        k.c(obj, "null cannot be cast to non-null type kotlin.ByteArray");
        ProtobufModel.NotifyNoMoreCharacteristicRequest parseFrom = ProtobufModel.NotifyNoMoreCharacteristicRequest.parseFrom((byte[]) obj);
        CharNotificationHandler charNotificationHandler2 = this.charNotificationHandler;
        if (charNotificationHandler2 == null) {
            k.o("charNotificationHandler");
            charNotificationHandler2 = null;
        }
        k.d(parseFrom, "request");
        charNotificationHandler2.unsubscribeFromNotifications(parseFrom);
        result.success((Object) null);
    }

    /* access modifiers changed from: private */
    public final void writeCharacteristicWithResponse(MethodCall methodCall, MethodChannel.Result result) {
        executeWriteAndPropagateResultToChannel(methodCall, result, PluginController$writeCharacteristicWithResponse$1.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void writeCharacteristicWithoutResponse(MethodCall methodCall, MethodChannel.Result result) {
        executeWriteAndPropagateResultToChannel(methodCall, result, PluginController$writeCharacteristicWithoutResponse$1.INSTANCE);
    }

    public final void deinitialize$reactive_ble_mobile_release() {
        ScanDevicesHandler scanDevicesHandler2 = this.scanDevicesHandler;
        DeviceConnectionHandler deviceConnectionHandler2 = null;
        if (scanDevicesHandler2 == null) {
            k.o("scanDevicesHandler");
            scanDevicesHandler2 = null;
        }
        scanDevicesHandler2.stopDeviceScan();
        DeviceConnectionHandler deviceConnectionHandler3 = this.deviceConnectionHandler;
        if (deviceConnectionHandler3 == null) {
            k.o("deviceConnectionHandler");
        } else {
            deviceConnectionHandler2 = deviceConnectionHandler3;
        }
        deviceConnectionHandler2.disconnectAll();
    }

    public final void execute$reactive_ble_mobile_release(MethodCall methodCall, MethodChannel.Result result) {
        q qVar;
        k.e(methodCall, "call");
        k.e(result, "result");
        p pVar = this.pluginMethods.get(methodCall.method);
        if (pVar != null) {
            pVar.invoke(methodCall, result);
            qVar = q.f5904a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            result.notImplemented();
        }
    }

    public final void initialize$reactive_ble_mobile_release(BinaryMessenger binaryMessenger, Context context) {
        k.e(binaryMessenger, "messenger");
        k.e(context, "context");
        this.bleClient = new ReactiveBleClient(context);
        this.scanchannel = new EventChannel(binaryMessenger, "flutter_reactive_ble_scan");
        this.deviceConnectionChannel = new EventChannel(binaryMessenger, "flutter_reactive_ble_connected_device");
        this.charNotificationChannel = new EventChannel(binaryMessenger, "flutter_reactive_ble_char_update");
        EventChannel eventChannel = new EventChannel(binaryMessenger, "flutter_reactive_ble_status");
        BleClient bleClient2 = this.bleClient;
        CharNotificationHandler charNotificationHandler2 = null;
        if (bleClient2 == null) {
            k.o("bleClient");
            bleClient2 = null;
        }
        this.scanDevicesHandler = new ScanDevicesHandler(bleClient2);
        BleClient bleClient3 = this.bleClient;
        if (bleClient3 == null) {
            k.o("bleClient");
            bleClient3 = null;
        }
        this.deviceConnectionHandler = new DeviceConnectionHandler(bleClient3);
        BleClient bleClient4 = this.bleClient;
        if (bleClient4 == null) {
            k.o("bleClient");
            bleClient4 = null;
        }
        this.charNotificationHandler = new CharNotificationHandler(bleClient4);
        BleClient bleClient5 = this.bleClient;
        if (bleClient5 == null) {
            k.o("bleClient");
            bleClient5 = null;
        }
        BleStatusHandler bleStatusHandler = new BleStatusHandler(bleClient5);
        EventChannel eventChannel2 = this.scanchannel;
        if (eventChannel2 == null) {
            k.o("scanchannel");
            eventChannel2 = null;
        }
        ScanDevicesHandler scanDevicesHandler2 = this.scanDevicesHandler;
        if (scanDevicesHandler2 == null) {
            k.o("scanDevicesHandler");
            scanDevicesHandler2 = null;
        }
        eventChannel2.setStreamHandler(scanDevicesHandler2);
        EventChannel eventChannel3 = this.deviceConnectionChannel;
        if (eventChannel3 == null) {
            k.o("deviceConnectionChannel");
            eventChannel3 = null;
        }
        DeviceConnectionHandler deviceConnectionHandler2 = this.deviceConnectionHandler;
        if (deviceConnectionHandler2 == null) {
            k.o("deviceConnectionHandler");
            deviceConnectionHandler2 = null;
        }
        eventChannel3.setStreamHandler(deviceConnectionHandler2);
        EventChannel eventChannel4 = this.charNotificationChannel;
        if (eventChannel4 == null) {
            k.o("charNotificationChannel");
            eventChannel4 = null;
        }
        CharNotificationHandler charNotificationHandler3 = this.charNotificationHandler;
        if (charNotificationHandler3 == null) {
            k.o("charNotificationHandler");
        } else {
            charNotificationHandler2 = charNotificationHandler3;
        }
        eventChannel4.setStreamHandler(charNotificationHandler2);
        eventChannel.setStreamHandler(bleStatusHandler);
    }
}
