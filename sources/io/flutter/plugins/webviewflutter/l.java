package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.ArrayList;
import java.util.HashMap;

public final /* synthetic */ class l {
    public static MessageCodec<Object> a() {
        return GeneratedAndroidWebView.FlutterAssetManagerHostApiCodec.INSTANCE;
    }

    public static /* synthetic */ void b(GeneratedAndroidWebView.FlutterAssetManagerHostApi flutterAssetManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            String str = (String) ((ArrayList) obj).get(0);
            if (str != null) {
                hashMap.put("result", flutterAssetManagerHostApi.list(str));
                reply.reply(hashMap);
                return;
            }
            throw new NullPointerException("pathArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void c(GeneratedAndroidWebView.FlutterAssetManagerHostApi flutterAssetManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            String str = (String) ((ArrayList) obj).get(0);
            if (str != null) {
                hashMap.put("result", flutterAssetManagerHostApi.getAssetFilePathByName(str));
                reply.reply(hashMap);
                return;
            }
            throw new NullPointerException("nameArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static void d(BinaryMessenger binaryMessenger, GeneratedAndroidWebView.FlutterAssetManagerHostApi flutterAssetManagerHostApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.FlutterAssetManagerHostApi.list", a());
        if (flutterAssetManagerHostApi != null) {
            basicMessageChannel.setMessageHandler(new j(flutterAssetManagerHostApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.FlutterAssetManagerHostApi.getAssetFilePathByName", a());
        if (flutterAssetManagerHostApi != null) {
            basicMessageChannel2.setMessageHandler(new k(flutterAssetManagerHostApi));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
