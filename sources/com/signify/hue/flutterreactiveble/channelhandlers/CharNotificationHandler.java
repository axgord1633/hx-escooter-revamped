package com.signify.hue.flutterreactiveble.channelhandlers;

import com.signify.hue.flutterreactiveble.ProtobufModel;
import com.signify.hue.flutterreactiveble.ble.BleClient;
import com.signify.hue.flutterreactiveble.converters.ProtobufMessageConverter;
import com.signify.hue.flutterreactiveble.converters.UuidConverter;
import com.yalantis.ucrop.BuildConfig;
import io.flutter.plugin.common.EventChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import o2.a;
import p2.c;
import q1.e;

public final class CharNotificationHandler implements EventChannel.StreamHandler {
    public static final Companion Companion = new Companion((g) null);
    private static EventChannel.EventSink charNotificationSink;
    private static final Map<ProtobufModel.CharacteristicAddress, c> subscriptionMap = new LinkedHashMap();
    private final BleClient bleClient;
    private final ProtobufMessageConverter protobufConverter = new ProtobufMessageConverter();
    private final UuidConverter uuidConverter = new UuidConverter();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public CharNotificationHandler(BleClient bleClient2) {
        k.e(bleClient2, "bleClient");
        this.bleClient = bleClient2;
    }

    private final void handleNotificationError(ProtobufModel.CharacteristicAddress characteristicAddress, Throwable th) {
        ProtobufMessageConverter protobufMessageConverter = this.protobufConverter;
        String message = th.getMessage();
        if (message == null) {
            message = BuildConfig.FLAVOR;
        }
        ProtobufModel.CharacteristicValueInfo convertCharacteristicError = protobufMessageConverter.convertCharacteristicError(characteristicAddress, message);
        EventChannel.EventSink eventSink = charNotificationSink;
        if (eventSink != null) {
            eventSink.success(convertCharacteristicError.toByteArray());
        }
    }

    private final void handleNotificationValue(ProtobufModel.CharacteristicAddress characteristicAddress, byte[] bArr) {
        ProtobufModel.CharacteristicValueInfo convertCharacteristicInfo = this.protobufConverter.convertCharacteristicInfo(characteristicAddress, bArr);
        EventChannel.EventSink eventSink = charNotificationSink;
        if (eventSink != null) {
            eventSink.success(convertCharacteristicInfo.toByteArray());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToNotifications$lambda-1  reason: not valid java name */
    public static final void m60subscribeToNotifications$lambda1(CharNotificationHandler charNotificationHandler, ProtobufModel.NotifyCharacteristicRequest notifyCharacteristicRequest, byte[] bArr) {
        k.e(charNotificationHandler, "this$0");
        k.e(notifyCharacteristicRequest, "$request");
        ProtobufModel.CharacteristicAddress characteristic = notifyCharacteristicRequest.getCharacteristic();
        k.d(characteristic, "request.characteristic");
        k.d(bArr, "value");
        charNotificationHandler.handleNotificationValue(characteristic, bArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToNotifications$lambda-2  reason: not valid java name */
    public static final void m61subscribeToNotifications$lambda2(ProtobufModel.NotifyCharacteristicRequest notifyCharacteristicRequest, CharNotificationHandler charNotificationHandler, Throwable th) {
        k.e(notifyCharacteristicRequest, "$request");
        k.e(charNotificationHandler, "this$0");
        if (th instanceof e) {
            c remove = subscriptionMap.remove(notifyCharacteristicRequest.getCharacteristic());
            if (remove != null) {
                remove.dispose();
                return;
            }
            return;
        }
        ProtobufModel.CharacteristicAddress characteristic = notifyCharacteristicRequest.getCharacteristic();
        k.d(characteristic, "request.characteristic");
        k.d(th, "it");
        charNotificationHandler.handleNotificationError(characteristic, th);
    }

    private final void unsubscribeFromAllNotifications() {
        charNotificationSink = null;
        for (Map.Entry<ProtobufModel.CharacteristicAddress, c> value : subscriptionMap.entrySet()) {
            ((c) value.getValue()).dispose();
        }
    }

    public final void addSingleErrorToStream(ProtobufModel.CharacteristicAddress characteristicAddress, String str) {
        k.e(characteristicAddress, "subscriptionRequest");
        k.e(str, "error");
        ProtobufModel.CharacteristicValueInfo convertCharacteristicError = this.protobufConverter.convertCharacteristicError(characteristicAddress, str);
        EventChannel.EventSink eventSink = charNotificationSink;
        if (eventSink != null) {
            eventSink.success(convertCharacteristicError.toByteArray());
        }
    }

    public final void addSingleReadToStream(ProtobufModel.CharacteristicValueInfo characteristicValueInfo) {
        k.e(characteristicValueInfo, "charInfo");
        ProtobufModel.CharacteristicAddress characteristic = characteristicValueInfo.getCharacteristic();
        k.d(characteristic, "charInfo.characteristic");
        byte[] y4 = characteristicValueInfo.getValue().y();
        k.d(y4, "charInfo.value.toByteArray()");
        handleNotificationValue(characteristic, y4);
    }

    public void onCancel(Object obj) {
        unsubscribeFromAllNotifications();
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        if (eventSink != null) {
            charNotificationSink = eventSink;
        }
    }

    public final void subscribeToNotifications(ProtobufModel.NotifyCharacteristicRequest notifyCharacteristicRequest) {
        k.e(notifyCharacteristicRequest, "request");
        UuidConverter uuidConverter2 = this.uuidConverter;
        byte[] y4 = notifyCharacteristicRequest.getCharacteristic().getCharacteristicUuid().getData().y();
        k.d(y4, "request.characteristic.c…icUuid.data.toByteArray()");
        UUID uuidFromByteArray = uuidConverter2.uuidFromByteArray(y4);
        BleClient bleClient2 = this.bleClient;
        String deviceId = notifyCharacteristicRequest.getCharacteristic().getDeviceId();
        k.d(deviceId, "request.characteristic.deviceId");
        String characteristicInstanceId = notifyCharacteristicRequest.getCharacteristic().getCharacteristicInstanceId();
        k.d(characteristicInstanceId, "request.characteristic.characteristicInstanceId");
        c t02 = bleClient2.setupNotification(deviceId, uuidFromByteArray, Integer.parseInt(characteristicInstanceId)).f0(a.a()).t0(new d(this, notifyCharacteristicRequest), new e(notifyCharacteristicRequest, this));
        Map<ProtobufModel.CharacteristicAddress, c> map = subscriptionMap;
        ProtobufModel.CharacteristicAddress characteristic = notifyCharacteristicRequest.getCharacteristic();
        k.d(characteristic, "request.characteristic");
        k.d(t02, "subscription");
        map.put(characteristic, t02);
    }

    public final void unsubscribeFromNotifications(ProtobufModel.NotifyNoMoreCharacteristicRequest notifyNoMoreCharacteristicRequest) {
        k.e(notifyNoMoreCharacteristicRequest, "request");
        c remove = subscriptionMap.remove(notifyNoMoreCharacteristicRequest.getCharacteristic());
        if (remove != null) {
            remove.dispose();
        }
    }
}
