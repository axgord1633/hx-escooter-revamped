package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.ArrayList;
import java.util.HashMap;

public final /* synthetic */ class m0 {
    public static MessageCodec<Object> a() {
        return GeneratedAndroidWebView.WebSettingsHostApiCodec.INSTANCE;
    }

    public static /* synthetic */ void b(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Number number2 = (Number) arrayList.get(1);
                if (number2 != null) {
                    webSettingsHostApi.create(Long.valueOf(number.longValue()), Long.valueOf(number2.longValue()));
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("webViewInstanceIdArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void c(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number != null) {
                webSettingsHostApi.dispose(Long.valueOf(number.longValue()));
                hashMap.put("result", (Object) null);
                reply.reply(hashMap);
                return;
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void d(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Boolean bool = (Boolean) arrayList.get(1);
                if (bool != null) {
                    webSettingsHostApi.setUseWideViewPort(Long.valueOf(number.longValue()), bool);
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("useArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void e(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Boolean bool = (Boolean) arrayList.get(1);
                if (bool != null) {
                    webSettingsHostApi.setDisplayZoomControls(Long.valueOf(number.longValue()), bool);
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("enabledArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void f(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Boolean bool = (Boolean) arrayList.get(1);
                if (bool != null) {
                    webSettingsHostApi.setBuiltInZoomControls(Long.valueOf(number.longValue()), bool);
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("enabledArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void g(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Boolean bool = (Boolean) arrayList.get(1);
                if (bool != null) {
                    webSettingsHostApi.setAllowFileAccess(Long.valueOf(number.longValue()), bool);
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("enabledArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void h(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Boolean bool = (Boolean) arrayList.get(1);
                if (bool != null) {
                    webSettingsHostApi.setDomStorageEnabled(Long.valueOf(number.longValue()), bool);
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("flagArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void i(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Boolean bool = (Boolean) arrayList.get(1);
                if (bool != null) {
                    webSettingsHostApi.setJavaScriptCanOpenWindowsAutomatically(Long.valueOf(number.longValue()), bool);
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("flagArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void j(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Boolean bool = (Boolean) arrayList.get(1);
                if (bool != null) {
                    webSettingsHostApi.setSupportMultipleWindows(Long.valueOf(number.longValue()), bool);
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("supportArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void k(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Boolean bool = (Boolean) arrayList.get(1);
                if (bool != null) {
                    webSettingsHostApi.setJavaScriptEnabled(Long.valueOf(number.longValue()), bool);
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("flagArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void l(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                webSettingsHostApi.setUserAgentString(Long.valueOf(number.longValue()), (String) arrayList.get(1));
                hashMap.put("result", (Object) null);
                reply.reply(hashMap);
                return;
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void m(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Boolean bool = (Boolean) arrayList.get(1);
                if (bool != null) {
                    webSettingsHostApi.setMediaPlaybackRequiresUserGesture(Long.valueOf(number.longValue()), bool);
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("requireArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void n(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Boolean bool = (Boolean) arrayList.get(1);
                if (bool != null) {
                    webSettingsHostApi.setSupportZoom(Long.valueOf(number.longValue()), bool);
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("supportArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static /* synthetic */ void o(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            Number number = (Number) arrayList.get(0);
            if (number != null) {
                Boolean bool = (Boolean) arrayList.get(1);
                if (bool != null) {
                    webSettingsHostApi.setLoadWithOverviewMode(Long.valueOf(number.longValue()), bool);
                    hashMap.put("result", (Object) null);
                    reply.reply(hashMap);
                    return;
                }
                throw new NullPointerException("overviewArg unexpectedly null.");
            }
            throw new NullPointerException("instanceIdArg unexpectedly null.");
        } catch (Error | RuntimeException e5) {
            hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
        }
    }

    public static void p(BinaryMessenger binaryMessenger, GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.create", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel.setMessageHandler(new y(webSettingsHostApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.dispose", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel2.setMessageHandler(new h0(webSettingsHostApi));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.setDomStorageEnabled", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel3.setMessageHandler(new i0(webSettingsHostApi));
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.setJavaScriptCanOpenWindowsAutomatically", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel4.setMessageHandler(new j0(webSettingsHostApi));
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.setSupportMultipleWindows", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel5.setMessageHandler(new k0(webSettingsHostApi));
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.setJavaScriptEnabled", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel6.setMessageHandler(new l0(webSettingsHostApi));
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.setUserAgentString", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel7.setMessageHandler(new z(webSettingsHostApi));
        } else {
            basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.setMediaPlaybackRequiresUserGesture", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel8.setMessageHandler(new a0(webSettingsHostApi));
        } else {
            basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.setSupportZoom", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel9.setMessageHandler(new b0(webSettingsHostApi));
        } else {
            basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.setLoadWithOverviewMode", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel10.setMessageHandler(new c0(webSettingsHostApi));
        } else {
            basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.setUseWideViewPort", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel11.setMessageHandler(new d0(webSettingsHostApi));
        } else {
            basicMessageChannel11.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.setDisplayZoomControls", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel12.setMessageHandler(new e0(webSettingsHostApi));
        } else {
            basicMessageChannel12.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.setBuiltInZoomControls", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel13.setMessageHandler(new f0(webSettingsHostApi));
        } else {
            basicMessageChannel13.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebSettingsHostApi.setAllowFileAccess", a());
        if (webSettingsHostApi != null) {
            basicMessageChannel14.setMessageHandler(new g0(webSettingsHostApi));
        } else {
            basicMessageChannel14.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
