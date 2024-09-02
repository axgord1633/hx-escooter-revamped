package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.ArrayList;
import java.util.HashMap;

public final /* synthetic */ class i {
    public static MessageCodec<Object> a() {
        return GeneratedAndroidWebView.DownloadListenerHostApiCodec.INSTANCE;
    }

    public static /* synthetic */ void b(GeneratedAndroidWebView.DownloadListenerHostApi downloadListenerHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number != null) {
                downloadListenerHostApi.create(Long.valueOf(number.longValue()));
                hashMap.put("result", (Object) null);
                reply.reply(hashMap);
                return;
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static void c(BinaryMessenger binaryMessenger, GeneratedAndroidWebView.DownloadListenerHostApi downloadListenerHostApi) {
        new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.DownloadListenerHostApi.create", a()).setMessageHandler(downloadListenerHostApi != null ? new h(downloadListenerHostApi) : null);
    }
}
