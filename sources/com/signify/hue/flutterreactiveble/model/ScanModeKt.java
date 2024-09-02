package com.signify.hue.flutterreactiveble.model;

import kotlin.jvm.internal.k;
import m3.i;

public final class ScanModeKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScanMode.values().length];
            iArr[ScanMode.OPPORTUNISTIC.ordinal()] = 1;
            iArr[ScanMode.LOW_POWER.ordinal()] = 2;
            iArr[ScanMode.BALANCED.ordinal()] = 3;
            iArr[ScanMode.LOW_LATENCY.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ScanMode createScanMode(int i5) {
        if (i5 == -1) {
            return ScanMode.OPPORTUNISTIC;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return ScanMode.BALANCED;
            }
            if (i5 == 2) {
                return ScanMode.LOW_LATENCY;
            }
        }
        return ScanMode.LOW_POWER;
    }

    public static final int toScanSettings(ScanMode scanMode) {
        k.e(scanMode, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[scanMode.ordinal()];
        if (i5 == 1) {
            return -1;
        }
        if (i5 == 2) {
            return 0;
        }
        if (i5 == 3) {
            return 1;
        }
        if (i5 == 4) {
            return 2;
        }
        throw new i();
    }
}
