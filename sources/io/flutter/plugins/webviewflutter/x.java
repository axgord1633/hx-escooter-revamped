package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.ArrayList;
import java.util.HashMap;

public final /* synthetic */ class x {
    public static MessageCodec<Object> a() {
        return GeneratedAndroidWebView.WebChromeClientHostApiCodec.INSTANCE;
    }

    public static /* synthetic */ void b(GeneratedAndroidWebView.WebChromeClientHostApi webChromeClientHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Number number2 = (Number) arrayList.get(1);
                if (number2 != null) {
                    webChromeClientHostApi.create(Long.valueOf(number.longValue()), Long.valueOf(number2.longValue()));
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("webViewClientInstanceIdArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static void c(BinaryMessenger binaryMessenger, GeneratedAndroidWebView.WebChromeClientHostApi webChromeClientHostApi) {
        new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebChromeClientHostApi.create", a()).setMessageHandler(webChromeClientHostApi != null ? new w(webChromeClientHostApi) : null);
    }
}
