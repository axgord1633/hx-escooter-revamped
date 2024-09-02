package com.signify.hue.flutterreactiveble;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import m3.q;
import v3.p;

/* synthetic */ class PluginController$pluginMethods$8 extends j implements p<MethodCall, MethodChannel.Result, q> {
    PluginController$pluginMethods$8(Object obj) {
        super(2, obj, PluginController.class, "writeCharacteristicWithResponse", "writeCharacteristicWithResponse(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((MethodCall) obj, (MethodChannel.Result) obj2);
        return q.f5904a;
    }

    public final void invoke(MethodCall methodCall, MethodChannel.Result result) {
        k.e(methodCall, "p0");
        k.e(result, "p1");
        ((PluginController) this.receiver).writeCharacteristicWithResponse(methodCall, result);
    }
}
