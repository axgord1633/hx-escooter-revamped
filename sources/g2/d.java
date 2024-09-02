package g2;

import g2.a;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.ArrayList;
import java.util.HashMap;

public final /* synthetic */ class d {
    public static MessageCodec<Object> a() {
        return a.d.f4734a;
    }

    public static /* synthetic */ void b(a.c cVar, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            a.b bVar = (a.b) ((ArrayList) obj).get(0);
            if (bVar != null) {
                cVar.a(bVar);
                hashMap.put("result", (Object) null);
                reply.reply(hashMap);
                return;
            }
            throw new NullPointerException("msgArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", a.b(e5));
        }
    }

    public static /* synthetic */ void c(a.c cVar, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", cVar.isEnabled());
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", a.b(e5));
        }
        reply.reply(hashMap);
    }

    public static void d(BinaryMessenger binaryMessenger, a.c cVar) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WakelockApi.toggle", a());
        if (cVar != null) {
            basicMessageChannel.setMessageHandler(new b(cVar));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WakelockApi.isEnabled", a());
        if (cVar != null) {
            basicMessageChannel2.setMessageHandler(new c(cVar));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
