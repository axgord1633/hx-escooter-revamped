package com.signify.hue.flutterreactiveble.utils;

import com.signify.hue.flutterreactiveble.ble.BleStatus;
import com.signify.hue.flutterreactiveble.ble.ConnectionPriority;
import kotlin.jvm.internal.k;
import m3.i;
import p1.g0;

public final class BleWrapperExtensionsKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[g0.a.values().length];
            iArr[g0.a.BLUETOOTH_NOT_AVAILABLE.ordinal()] = 1;
            iArr[g0.a.LOCATION_PERMISSION_NOT_GRANTED.ordinal()] = 2;
            iArr[g0.a.BLUETOOTH_NOT_ENABLED.ordinal()] = 3;
            iArr[g0.a.LOCATION_SERVICES_NOT_ENABLED.ordinal()] = 4;
            iArr[g0.a.READY.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final BleStatus toBleState(g0.a aVar) {
        k.e(aVar, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[aVar.ordinal()];
        if (i5 == 1) {
            return BleStatus.UNSUPPORTED;
        }
        if (i5 == 2) {
            return BleStatus.UNAUTHORIZED;
        }
        if (i5 == 3) {
            return BleStatus.POWERED_OFF;
        }
        if (i5 == 4) {
            return BleStatus.LOCATION_SERVICES_DISABLED;
        }
        if (i5 == 5) {
            return BleStatus.READY;
        }
        throw new i();
    }

    public static final ConnectionPriority toConnectionPriority(int i5) {
        if (i5 != 0) {
            if (i5 == 1) {
                return ConnectionPriority.HIGH_PERFORMACE;
            }
            if (i5 == 2) {
                return ConnectionPriority.LOW_POWER;
            }
        }
        return ConnectionPriority.BALANCED;
    }
}
