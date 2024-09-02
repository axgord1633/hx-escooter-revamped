package com.signify.hue.flutterreactiveble;

import com.signify.hue.flutterreactiveble.ble.BleClient;
import com.signify.hue.flutterreactiveble.ble.CharOperationResult;
import java.util.UUID;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import m2.r;
import v3.s;

/* synthetic */ class PluginController$writeCharacteristicWithoutResponse$1 extends j implements s<BleClient, String, UUID, Integer, byte[], r<CharOperationResult>> {
    public static final PluginController$writeCharacteristicWithoutResponse$1 INSTANCE = new PluginController$writeCharacteristicWithoutResponse$1();

    PluginController$writeCharacteristicWithoutResponse$1() {
        super(5, BleClient.class, "writeCharacteristicWithoutResponse", "writeCharacteristicWithoutResponse(Ljava/lang/String;Ljava/util/UUID;I[B)Lio/reactivex/Single;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke((BleClient) obj, (String) obj2, (UUID) obj3, ((Number) obj4).intValue(), (byte[]) obj5);
    }

    public final r<CharOperationResult> invoke(BleClient bleClient, String str, UUID uuid, int i5, byte[] bArr) {
        k.e(bleClient, "p0");
        k.e(str, "p1");
        k.e(uuid, "p2");
        k.e(bArr, "p4");
        return bleClient.writeCharacteristicWithoutResponse(str, uuid, i5, bArr);
    }
}
