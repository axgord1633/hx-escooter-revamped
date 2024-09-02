package io.flutter.plugins.pathprovider;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.pathprovider.Messages;
import java.util.ArrayList;

public final /* synthetic */ class h {
    public static MessageCodec<Object> a() {
        return new StandardMessageCodec();
    }

    public static /* synthetic */ void b(Messages.PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, pathProviderApi.getTemporaryPath());
        } catch (Throwable th) {
            arrayList = Messages.wrapError(th);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void c(Messages.PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, pathProviderApi.getApplicationSupportPath());
        } catch (Throwable th) {
            arrayList = Messages.wrapError(th);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void d(Messages.PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, pathProviderApi.getApplicationDocumentsPath());
        } catch (Throwable th) {
            arrayList = Messages.wrapError(th);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void e(Messages.PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, pathProviderApi.getApplicationCachePath());
        } catch (Throwable th) {
            arrayList = Messages.wrapError(th);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void f(Messages.PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, pathProviderApi.getExternalStoragePath());
        } catch (Throwable th) {
            arrayList = Messages.wrapError(th);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void g(Messages.PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, pathProviderApi.getExternalCachePaths());
        } catch (Throwable th) {
            arrayList = Messages.wrapError(th);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void h(Messages.PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, pathProviderApi.getExternalStoragePaths(arrayList2.get(0) == null ? null : Messages.StorageDirectory.values()[((Integer) arrayList2.get(0)).intValue()]));
        } catch (Throwable th) {
            arrayList = Messages.wrapError(th);
        }
        reply.reply(arrayList);
    }

    public static void i(BinaryMessenger binaryMessenger, Messages.PathProviderApi pathProviderApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getTemporaryPath", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (pathProviderApi != null) {
            basicMessageChannel.setMessageHandler(new a(pathProviderApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getApplicationSupportPath", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (pathProviderApi != null) {
            basicMessageChannel2.setMessageHandler(new b(pathProviderApi));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getApplicationDocumentsPath", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (pathProviderApi != null) {
            basicMessageChannel3.setMessageHandler(new c(pathProviderApi));
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getApplicationCachePath", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (pathProviderApi != null) {
            basicMessageChannel4.setMessageHandler(new d(pathProviderApi));
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePath", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (pathProviderApi != null) {
            basicMessageChannel5.setMessageHandler(new e(pathProviderApi));
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getExternalCachePaths", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (pathProviderApi != null) {
            basicMessageChannel6.setMessageHandler(new f(pathProviderApi));
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePaths", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (pathProviderApi != null) {
            basicMessageChannel7.setMessageHandler(new g(pathProviderApi));
        } else {
            basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
