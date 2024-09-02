package com.signify.hue.flutterreactiveble.channelhandlers;

import com.signify.hue.flutterreactiveble.ProtobufModel;
import com.signify.hue.flutterreactiveble.ble.BleClient;
import com.signify.hue.flutterreactiveble.ble.ConnectionUpdate;
import com.signify.hue.flutterreactiveble.ble.ConnectionUpdateError;
import com.signify.hue.flutterreactiveble.ble.ConnectionUpdateSuccess;
import com.signify.hue.flutterreactiveble.converters.ProtobufMessageConverter;
import com.signify.hue.flutterreactiveble.utils.Duration;
import io.flutter.plugin.common.EventChannel;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import o2.a;
import p2.c;

public final class DeviceConnectionHandler implements EventChannel.StreamHandler {
    private final BleClient bleClient;
    private EventChannel.EventSink connectDeviceSink;
    private c connectionUpdatesDisposable;
    private final ProtobufMessageConverter converter = new ProtobufMessageConverter();

    public DeviceConnectionHandler(BleClient bleClient2) {
        k.e(bleClient2, "bleClient");
        this.bleClient = bleClient2;
    }

    private final void handleDeviceConnectionUpdateResult(ProtobufModel.DeviceInfo deviceInfo) {
        EventChannel.EventSink eventSink = this.connectDeviceSink;
        if (eventSink != null) {
            eventSink.success(deviceInfo.toByteArray());
        }
    }

    private final c listenToConnectionChanges() {
        return this.bleClient.getConnectionUpdateSubject().f0(a.a()).s0(new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: listenToConnectionChanges$lambda-1  reason: not valid java name */
    public static final void m62listenToConnectionChanges$lambda1(DeviceConnectionHandler deviceConnectionHandler, ConnectionUpdate connectionUpdate) {
        ProtobufModel.DeviceInfo convertConnectionErrorToDeviceInfo;
        k.e(deviceConnectionHandler, "this$0");
        if (connectionUpdate instanceof ConnectionUpdateSuccess) {
            ProtobufMessageConverter protobufMessageConverter = deviceConnectionHandler.converter;
            k.d(connectionUpdate, "update");
            convertConnectionErrorToDeviceInfo = protobufMessageConverter.convertToDeviceInfo((ConnectionUpdateSuccess) connectionUpdate);
        } else if (connectionUpdate instanceof ConnectionUpdateError) {
            ConnectionUpdateError connectionUpdateError = (ConnectionUpdateError) connectionUpdate;
            convertConnectionErrorToDeviceInfo = deviceConnectionHandler.converter.convertConnectionErrorToDeviceInfo(connectionUpdateError.getDeviceId(), connectionUpdateError.getErrorMessage());
        } else {
            return;
        }
        deviceConnectionHandler.handleDeviceConnectionUpdateResult(convertConnectionErrorToDeviceInfo);
    }

    public final void connectToDevice(ProtobufModel.ConnectToDeviceRequest connectToDeviceRequest) {
        k.e(connectToDeviceRequest, "connectToDeviceMessage");
        BleClient bleClient2 = this.bleClient;
        String deviceId = connectToDeviceRequest.getDeviceId();
        k.d(deviceId, "connectToDeviceMessage.deviceId");
        bleClient2.connectToDevice(deviceId, new Duration((long) connectToDeviceRequest.getTimeoutInMs(), TimeUnit.MILLISECONDS));
    }

    public final void disconnectAll() {
        this.connectDeviceSink = null;
        this.bleClient.disconnectAllDevices();
    }

    public final void disconnectDevice(String str) {
        k.e(str, "deviceId");
        this.bleClient.disconnectDevice(str);
    }

    public void onCancel(Object obj) {
        disconnectAll();
        c cVar = this.connectionUpdatesDisposable;
        if (cVar == null) {
            k.o("connectionUpdatesDisposable");
            cVar = null;
        }
        cVar.dispose();
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        if (eventSink != null) {
            this.connectDeviceSink = eventSink;
            c listenToConnectionChanges = listenToConnectionChanges();
            k.d(listenToConnectionChanges, "listenToConnectionChanges()");
            this.connectionUpdatesDisposable = listenToConnectionChanges;
        }
    }
}
