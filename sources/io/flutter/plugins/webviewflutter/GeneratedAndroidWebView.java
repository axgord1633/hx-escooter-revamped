package io.flutter.plugins.webviewflutter;

import android.util.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneratedAndroidWebView {

    public interface CookieManagerHostApi {

        /* renamed from: io.flutter.plugins.webviewflutter.GeneratedAndroidWebView$CookieManagerHostApi$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static MessageCodec<Object> a() {
                return CookieManagerHostApiCodec.INSTANCE;
            }

            public static /* synthetic */ void b(CookieManagerHostApi cookieManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    cookieManagerHostApi.clearCookies(new Result<Boolean>(hashMap, reply) {
                        final /* synthetic */ BasicMessageChannel.Reply val$reply;
                        final /* synthetic */ Map val$wrapped;

                        {
                            this.val$wrapped = r1;
                            this.val$reply = r2;
                        }

                        public void error(Throwable th) {
                            this.val$wrapped.put("error", GeneratedAndroidWebView.wrapError(th));
                            this.val$reply.reply(this.val$wrapped);
                        }

                        public void success(Boolean bool) {
                            this.val$wrapped.put("result", bool);
                            this.val$reply.reply(this.val$wrapped);
                        }
                    });
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                    reply.reply(hashMap);
                }
            }

            public static /* synthetic */ void c(CookieManagerHostApi cookieManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    String str = (String) arrayList.get(0);
                    if (str != null) {
                        String str2 = (String) arrayList.get(1);
                        if (str2 != null) {
                            cookieManagerHostApi.setCookie(str, str2);
                            hashMap.put("result", (Object) null);
                            reply.reply(hashMap);
                            return;
                        }
                        throw new NullPointerException("valueArg unexpectedly null.");
                    }
                    throw new NullPointerException("urlArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static void d(BinaryMessenger binaryMessenger, CookieManagerHostApi cookieManagerHostApi) {
                BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.CookieManagerHostApi.clearCookies", a());
                if (cookieManagerHostApi != null) {
                    basicMessageChannel.setMessageHandler(new d(cookieManagerHostApi));
                } else {
                    basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.CookieManagerHostApi.setCookie", a());
                if (cookieManagerHostApi != null) {
                    basicMessageChannel2.setMessageHandler(new e(cookieManagerHostApi));
                } else {
                    basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
            }
        }

        void clearCookies(Result<Boolean> result);

        void setCookie(String str, String str2);
    }

    private static class CookieManagerHostApiCodec extends StandardMessageCodec {
        public static final CookieManagerHostApiCodec INSTANCE = new CookieManagerHostApiCodec();

        private CookieManagerHostApiCodec() {
        }
    }

    public static class DownloadListenerFlutterApi {
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t5);
        }

        public DownloadListenerFlutterApi(BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        static MessageCodec<Object> getCodec() {
            return DownloadListenerFlutterApiCodec.INSTANCE;
        }

        public void dispose(Long l5, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.DownloadListenerFlutterApi.dispose", getCodec()).send(new ArrayList(Arrays.asList(new Long[]{l5})), new g(reply));
        }

        public void onDownloadStart(Long l5, String str, String str2, String str3, String str4, Long l6, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.DownloadListenerFlutterApi.onDownloadStart", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l5, str, str2, str3, str4, l6})), new f(reply));
        }
    }

    private static class DownloadListenerFlutterApiCodec extends StandardMessageCodec {
        public static final DownloadListenerFlutterApiCodec INSTANCE = new DownloadListenerFlutterApiCodec();

        private DownloadListenerFlutterApiCodec() {
        }
    }

    public interface DownloadListenerHostApi {
        void create(Long l5);
    }

    private static class DownloadListenerHostApiCodec extends StandardMessageCodec {
        public static final DownloadListenerHostApiCodec INSTANCE = new DownloadListenerHostApiCodec();

        private DownloadListenerHostApiCodec() {
        }
    }

    public interface FlutterAssetManagerHostApi {
        String getAssetFilePathByName(String str);

        List<String> list(String str);
    }

    private static class FlutterAssetManagerHostApiCodec extends StandardMessageCodec {
        public static final FlutterAssetManagerHostApiCodec INSTANCE = new FlutterAssetManagerHostApiCodec();

        private FlutterAssetManagerHostApiCodec() {
        }
    }

    public static class JavaObjectFlutterApi {
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t5);
        }

        public JavaObjectFlutterApi(BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        static MessageCodec<Object> getCodec() {
            return JavaObjectFlutterApiCodec.INSTANCE;
        }

        public void dispose(Long l5, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.JavaObjectFlutterApi.dispose", getCodec()).send(new ArrayList(Arrays.asList(new Long[]{l5})), new m(reply));
        }
    }

    private static class JavaObjectFlutterApiCodec extends StandardMessageCodec {
        public static final JavaObjectFlutterApiCodec INSTANCE = new JavaObjectFlutterApiCodec();

        private JavaObjectFlutterApiCodec() {
        }
    }

    public interface JavaObjectHostApi {
        void dispose(Long l5);
    }

    private static class JavaObjectHostApiCodec extends StandardMessageCodec {
        public static final JavaObjectHostApiCodec INSTANCE = new JavaObjectHostApiCodec();

        private JavaObjectHostApiCodec() {
        }
    }

    public static class JavaScriptChannelFlutterApi {
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t5);
        }

        public JavaScriptChannelFlutterApi(BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        static MessageCodec<Object> getCodec() {
            return JavaScriptChannelFlutterApiCodec.INSTANCE;
        }

        public void dispose(Long l5, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.JavaScriptChannelFlutterApi.dispose", getCodec()).send(new ArrayList(Arrays.asList(new Long[]{l5})), new q(reply));
        }

        public void postMessage(Long l5, String str, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.JavaScriptChannelFlutterApi.postMessage", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l5, str})), new p(reply));
        }
    }

    private static class JavaScriptChannelFlutterApiCodec extends StandardMessageCodec {
        public static final JavaScriptChannelFlutterApiCodec INSTANCE = new JavaScriptChannelFlutterApiCodec();

        private JavaScriptChannelFlutterApiCodec() {
        }
    }

    public interface JavaScriptChannelHostApi {
        void create(Long l5, String str);
    }

    private static class JavaScriptChannelHostApiCodec extends StandardMessageCodec {
        public static final JavaScriptChannelHostApiCodec INSTANCE = new JavaScriptChannelHostApiCodec();

        private JavaScriptChannelHostApiCodec() {
        }
    }

    public interface Result<T> {
        void error(Throwable th);

        void success(T t5);
    }

    public static class WebChromeClientFlutterApi {
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t5);
        }

        public WebChromeClientFlutterApi(BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        static MessageCodec<Object> getCodec() {
            return WebChromeClientFlutterApiCodec.INSTANCE;
        }

        public void dispose(Long l5, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.WebChromeClientFlutterApi.dispose", getCodec()).send(new ArrayList(Arrays.asList(new Long[]{l5})), new u(reply));
        }

        public void onProgressChanged(Long l5, Long l6, Long l7, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.WebChromeClientFlutterApi.onProgressChanged", getCodec()).send(new ArrayList(Arrays.asList(new Long[]{l5, l6, l7})), new v(reply));
        }
    }

    private static class WebChromeClientFlutterApiCodec extends StandardMessageCodec {
        public static final WebChromeClientFlutterApiCodec INSTANCE = new WebChromeClientFlutterApiCodec();

        private WebChromeClientFlutterApiCodec() {
        }
    }

    public interface WebChromeClientHostApi {
        void create(Long l5, Long l6);
    }

    private static class WebChromeClientHostApiCodec extends StandardMessageCodec {
        public static final WebChromeClientHostApiCodec INSTANCE = new WebChromeClientHostApiCodec();

        private WebChromeClientHostApiCodec() {
        }
    }

    public static class WebResourceErrorData {
        private String description;
        private Long errorCode;

        public static final class Builder {
            private String description;
            private Long errorCode;

            public WebResourceErrorData build() {
                WebResourceErrorData webResourceErrorData = new WebResourceErrorData();
                webResourceErrorData.setErrorCode(this.errorCode);
                webResourceErrorData.setDescription(this.description);
                return webResourceErrorData;
            }

            public Builder setDescription(String str) {
                this.description = str;
                return this;
            }

            public Builder setErrorCode(Long l5) {
                this.errorCode = l5;
                return this;
            }
        }

        private WebResourceErrorData() {
        }

        static WebResourceErrorData fromMap(Map<String, Object> map) {
            Long l5;
            WebResourceErrorData webResourceErrorData = new WebResourceErrorData();
            Object obj = map.get("errorCode");
            if (obj == null) {
                l5 = null;
            } else {
                l5 = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            webResourceErrorData.setErrorCode(l5);
            webResourceErrorData.setDescription((String) map.get("description"));
            return webResourceErrorData;
        }

        public String getDescription() {
            return this.description;
        }

        public Long getErrorCode() {
            return this.errorCode;
        }

        public void setDescription(String str) {
            if (str != null) {
                this.description = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"description\" is null.");
        }

        public void setErrorCode(Long l5) {
            if (l5 != null) {
                this.errorCode = l5;
                return;
            }
            throw new IllegalStateException("Nonnull field \"errorCode\" is null.");
        }

        /* access modifiers changed from: package-private */
        public Map<String, Object> toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", this.errorCode);
            hashMap.put("description", this.description);
            return hashMap;
        }
    }

    public static class WebResourceRequestData {
        private Boolean hasGesture;
        private Boolean isForMainFrame;
        private Boolean isRedirect;
        private String method;
        private Map<String, String> requestHeaders;
        private String url;

        public static final class Builder {
            private Boolean hasGesture;
            private Boolean isForMainFrame;
            private Boolean isRedirect;
            private String method;
            private Map<String, String> requestHeaders;
            private String url;

            public WebResourceRequestData build() {
                WebResourceRequestData webResourceRequestData = new WebResourceRequestData();
                webResourceRequestData.setUrl(this.url);
                webResourceRequestData.setIsForMainFrame(this.isForMainFrame);
                webResourceRequestData.setIsRedirect(this.isRedirect);
                webResourceRequestData.setHasGesture(this.hasGesture);
                webResourceRequestData.setMethod(this.method);
                webResourceRequestData.setRequestHeaders(this.requestHeaders);
                return webResourceRequestData;
            }

            public Builder setHasGesture(Boolean bool) {
                this.hasGesture = bool;
                return this;
            }

            public Builder setIsForMainFrame(Boolean bool) {
                this.isForMainFrame = bool;
                return this;
            }

            public Builder setIsRedirect(Boolean bool) {
                this.isRedirect = bool;
                return this;
            }

            public Builder setMethod(String str) {
                this.method = str;
                return this;
            }

            public Builder setRequestHeaders(Map<String, String> map) {
                this.requestHeaders = map;
                return this;
            }

            public Builder setUrl(String str) {
                this.url = str;
                return this;
            }
        }

        private WebResourceRequestData() {
        }

        static WebResourceRequestData fromMap(Map<String, Object> map) {
            WebResourceRequestData webResourceRequestData = new WebResourceRequestData();
            webResourceRequestData.setUrl((String) map.get("url"));
            webResourceRequestData.setIsForMainFrame((Boolean) map.get("isForMainFrame"));
            webResourceRequestData.setIsRedirect((Boolean) map.get("isRedirect"));
            webResourceRequestData.setHasGesture((Boolean) map.get("hasGesture"));
            webResourceRequestData.setMethod((String) map.get("method"));
            webResourceRequestData.setRequestHeaders((Map) map.get("requestHeaders"));
            return webResourceRequestData;
        }

        public Boolean getHasGesture() {
            return this.hasGesture;
        }

        public Boolean getIsForMainFrame() {
            return this.isForMainFrame;
        }

        public Boolean getIsRedirect() {
            return this.isRedirect;
        }

        public String getMethod() {
            return this.method;
        }

        public Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }

        public String getUrl() {
            return this.url;
        }

        public void setHasGesture(Boolean bool) {
            if (bool != null) {
                this.hasGesture = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"hasGesture\" is null.");
        }

        public void setIsForMainFrame(Boolean bool) {
            if (bool != null) {
                this.isForMainFrame = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"isForMainFrame\" is null.");
        }

        public void setIsRedirect(Boolean bool) {
            this.isRedirect = bool;
        }

        public void setMethod(String str) {
            if (str != null) {
                this.method = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"method\" is null.");
        }

        public void setRequestHeaders(Map<String, String> map) {
            if (map != null) {
                this.requestHeaders = map;
                return;
            }
            throw new IllegalStateException("Nonnull field \"requestHeaders\" is null.");
        }

        public void setUrl(String str) {
            if (str != null) {
                this.url = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"url\" is null.");
        }

        /* access modifiers changed from: package-private */
        public Map<String, Object> toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("url", this.url);
            hashMap.put("isForMainFrame", this.isForMainFrame);
            hashMap.put("isRedirect", this.isRedirect);
            hashMap.put("hasGesture", this.hasGesture);
            hashMap.put("method", this.method);
            hashMap.put("requestHeaders", this.requestHeaders);
            return hashMap;
        }
    }

    public interface WebSettingsHostApi {
        void create(Long l5, Long l6);

        void dispose(Long l5);

        void setAllowFileAccess(Long l5, Boolean bool);

        void setBuiltInZoomControls(Long l5, Boolean bool);

        void setDisplayZoomControls(Long l5, Boolean bool);

        void setDomStorageEnabled(Long l5, Boolean bool);

        void setJavaScriptCanOpenWindowsAutomatically(Long l5, Boolean bool);

        void setJavaScriptEnabled(Long l5, Boolean bool);

        void setLoadWithOverviewMode(Long l5, Boolean bool);

        void setMediaPlaybackRequiresUserGesture(Long l5, Boolean bool);

        void setSupportMultipleWindows(Long l5, Boolean bool);

        void setSupportZoom(Long l5, Boolean bool);

        void setUseWideViewPort(Long l5, Boolean bool);

        void setUserAgentString(Long l5, String str);
    }

    private static class WebSettingsHostApiCodec extends StandardMessageCodec {
        public static final WebSettingsHostApiCodec INSTANCE = new WebSettingsHostApiCodec();

        private WebSettingsHostApiCodec() {
        }
    }

    public interface WebStorageHostApi {
        void create(Long l5);

        void deleteAllData(Long l5);
    }

    private static class WebStorageHostApiCodec extends StandardMessageCodec {
        public static final WebStorageHostApiCodec INSTANCE = new WebStorageHostApiCodec();

        private WebStorageHostApiCodec() {
        }
    }

    public static class WebViewClientFlutterApi {
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t5);
        }

        public WebViewClientFlutterApi(BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        static MessageCodec<Object> getCodec() {
            return WebViewClientFlutterApiCodec.INSTANCE;
        }

        public void dispose(Long l5, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.WebViewClientFlutterApi.dispose", getCodec()).send(new ArrayList(Arrays.asList(new Long[]{l5})), new t0(reply));
        }

        public void onPageFinished(Long l5, Long l6, String str, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.WebViewClientFlutterApi.onPageFinished", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l5, l6, str})), new v0(reply));
        }

        public void onPageStarted(Long l5, Long l6, String str, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.WebViewClientFlutterApi.onPageStarted", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l5, l6, str})), new s0(reply));
        }

        public void onReceivedError(Long l5, Long l6, Long l7, String str, String str2, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.WebViewClientFlutterApi.onReceivedError", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l5, l6, l7, str, str2})), new w0(reply));
        }

        public void onReceivedRequestError(Long l5, Long l6, WebResourceRequestData webResourceRequestData, WebResourceErrorData webResourceErrorData, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.WebViewClientFlutterApi.onReceivedRequestError", getCodec()).send(new ArrayList(Arrays.asList(new Object[]{l5, l6, webResourceRequestData, webResourceErrorData})), new q0(reply));
        }

        public void requestLoading(Long l5, Long l6, WebResourceRequestData webResourceRequestData, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.WebViewClientFlutterApi.requestLoading", getCodec()).send(new ArrayList(Arrays.asList(new Object[]{l5, l6, webResourceRequestData})), new r0(reply));
        }

        public void urlLoading(Long l5, Long l6, String str, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.WebViewClientFlutterApi.urlLoading", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l5, l6, str})), new u0(reply));
        }
    }

    private static class WebViewClientFlutterApiCodec extends StandardMessageCodec {
        public static final WebViewClientFlutterApiCodec INSTANCE = new WebViewClientFlutterApiCodec();

        private WebViewClientFlutterApiCodec() {
        }

        /* access modifiers changed from: protected */
        public Object readValueOfType(byte b5, ByteBuffer byteBuffer) {
            return b5 != Byte.MIN_VALUE ? b5 != -127 ? super.readValueOfType(b5, byteBuffer) : WebResourceRequestData.fromMap((Map) readValue(byteBuffer)) : WebResourceErrorData.fromMap((Map) readValue(byteBuffer));
        }

        /* access modifiers changed from: protected */
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            Map<String, Object> map;
            if (obj instanceof WebResourceErrorData) {
                byteArrayOutputStream.write(128);
                map = ((WebResourceErrorData) obj).toMap();
            } else if (obj instanceof WebResourceRequestData) {
                byteArrayOutputStream.write(129);
                map = ((WebResourceRequestData) obj).toMap();
            } else {
                super.writeValue(byteArrayOutputStream, obj);
                return;
            }
            writeValue(byteArrayOutputStream, map);
        }
    }

    public interface WebViewClientHostApi {
        void create(Long l5, Boolean bool);
    }

    private static class WebViewClientHostApiCodec extends StandardMessageCodec {
        public static final WebViewClientHostApiCodec INSTANCE = new WebViewClientHostApiCodec();

        private WebViewClientHostApiCodec() {
        }
    }

    public interface WebViewHostApi {

        /* renamed from: io.flutter.plugins.webviewflutter.GeneratedAndroidWebView$WebViewHostApi$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static /* synthetic */ void A(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    Number number = (Number) ((ArrayList) obj).get(0);
                    if (number != null) {
                        hashMap.put("result", webViewHostApi.canGoForward(Long.valueOf(number.longValue())));
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void B(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    Number number = (Number) ((ArrayList) obj).get(0);
                    if (number != null) {
                        webViewHostApi.goBack(Long.valueOf(number.longValue()));
                        hashMap.put("result", (Object) null);
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static void C(BinaryMessenger binaryMessenger, WebViewHostApi webViewHostApi) {
                BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.create", a());
                if (webViewHostApi != null) {
                    basicMessageChannel.setMessageHandler(new z0(webViewHostApi));
                } else {
                    basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.dispose", a());
                if (webViewHostApi != null) {
                    basicMessageChannel2.setMessageHandler(new b1(webViewHostApi));
                } else {
                    basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.loadData", a());
                if (webViewHostApi != null) {
                    basicMessageChannel3.setMessageHandler(new j1(webViewHostApi));
                } else {
                    basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.loadDataWithBaseUrl", a());
                if (webViewHostApi != null) {
                    basicMessageChannel4.setMessageHandler(new l1(webViewHostApi));
                } else {
                    basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.loadUrl", a());
                if (webViewHostApi != null) {
                    basicMessageChannel5.setMessageHandler(new m1(webViewHostApi));
                } else {
                    basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.postUrl", a());
                if (webViewHostApi != null) {
                    basicMessageChannel6.setMessageHandler(new n1(webViewHostApi));
                } else {
                    basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.getUrl", a());
                if (webViewHostApi != null) {
                    basicMessageChannel7.setMessageHandler(new o1(webViewHostApi));
                } else {
                    basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.canGoBack", a());
                if (webViewHostApi != null) {
                    basicMessageChannel8.setMessageHandler(new p1(webViewHostApi));
                } else {
                    basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.canGoForward", a());
                if (webViewHostApi != null) {
                    basicMessageChannel9.setMessageHandler(new q1(webViewHostApi));
                } else {
                    basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.goBack", a());
                if (webViewHostApi != null) {
                    basicMessageChannel10.setMessageHandler(new r1(webViewHostApi));
                } else {
                    basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.goForward", a());
                if (webViewHostApi != null) {
                    basicMessageChannel11.setMessageHandler(new k1(webViewHostApi));
                } else {
                    basicMessageChannel11.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.reload", a());
                if (webViewHostApi != null) {
                    basicMessageChannel12.setMessageHandler(new s1(webViewHostApi));
                } else {
                    basicMessageChannel12.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.clearCache", a());
                if (webViewHostApi != null) {
                    basicMessageChannel13.setMessageHandler(new t1(webViewHostApi));
                } else {
                    basicMessageChannel13.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.evaluateJavascript", a());
                if (webViewHostApi != null) {
                    basicMessageChannel14.setMessageHandler(new u1(webViewHostApi));
                } else {
                    basicMessageChannel14.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel15 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.getTitle", a());
                if (webViewHostApi != null) {
                    basicMessageChannel15.setMessageHandler(new v1(webViewHostApi));
                } else {
                    basicMessageChannel15.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel16 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.scrollTo", a());
                if (webViewHostApi != null) {
                    basicMessageChannel16.setMessageHandler(new w1(webViewHostApi));
                } else {
                    basicMessageChannel16.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel17 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.scrollBy", a());
                if (webViewHostApi != null) {
                    basicMessageChannel17.setMessageHandler(new x1(webViewHostApi));
                } else {
                    basicMessageChannel17.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel18 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.getScrollX", a());
                if (webViewHostApi != null) {
                    basicMessageChannel18.setMessageHandler(new y1(webViewHostApi));
                } else {
                    basicMessageChannel18.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel19 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.getScrollY", a());
                if (webViewHostApi != null) {
                    basicMessageChannel19.setMessageHandler(new z1(webViewHostApi));
                } else {
                    basicMessageChannel19.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel20 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.getScrollPosition", a());
                if (webViewHostApi != null) {
                    basicMessageChannel20.setMessageHandler(new a1(webViewHostApi));
                } else {
                    basicMessageChannel20.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel21 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.setWebContentsDebuggingEnabled", a());
                if (webViewHostApi != null) {
                    basicMessageChannel21.setMessageHandler(new c1(webViewHostApi));
                } else {
                    basicMessageChannel21.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel22 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.setWebViewClient", a());
                if (webViewHostApi != null) {
                    basicMessageChannel22.setMessageHandler(new d1(webViewHostApi));
                } else {
                    basicMessageChannel22.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel23 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.addJavaScriptChannel", a());
                if (webViewHostApi != null) {
                    basicMessageChannel23.setMessageHandler(new e1(webViewHostApi));
                } else {
                    basicMessageChannel23.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel24 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.removeJavaScriptChannel", a());
                if (webViewHostApi != null) {
                    basicMessageChannel24.setMessageHandler(new f1(webViewHostApi));
                } else {
                    basicMessageChannel24.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel25 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.setDownloadListener", a());
                if (webViewHostApi != null) {
                    basicMessageChannel25.setMessageHandler(new g1(webViewHostApi));
                } else {
                    basicMessageChannel25.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel26 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.setWebChromeClient", a());
                if (webViewHostApi != null) {
                    basicMessageChannel26.setMessageHandler(new h1(webViewHostApi));
                } else {
                    basicMessageChannel26.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel27 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WebViewHostApi.setBackgroundColor", a());
                if (webViewHostApi != null) {
                    basicMessageChannel27.setMessageHandler(new i1(webViewHostApi));
                } else {
                    basicMessageChannel27.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
            }

            public static MessageCodec<Object> a() {
                return WebViewHostApiCodec.INSTANCE;
            }

            public static /* synthetic */ void b(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        Boolean bool = (Boolean) arrayList.get(1);
                        if (bool != null) {
                            webViewHostApi.create(Long.valueOf(number.longValue()), bool);
                            hashMap.put("result", (Object) null);
                            reply.reply(hashMap);
                            return;
                        }
                        throw new NullPointerException("useHybridCompositionArg unexpectedly null.");
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void c(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    Number number = (Number) ((ArrayList) obj).get(0);
                    if (number != null) {
                        webViewHostApi.dispose(Long.valueOf(number.longValue()));
                        hashMap.put("result", (Object) null);
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void d(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    Number number = (Number) ((ArrayList) obj).get(0);
                    if (number != null) {
                        webViewHostApi.goForward(Long.valueOf(number.longValue()));
                        hashMap.put("result", (Object) null);
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void e(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    Number number = (Number) ((ArrayList) obj).get(0);
                    if (number != null) {
                        webViewHostApi.reload(Long.valueOf(number.longValue()));
                        hashMap.put("result", (Object) null);
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void f(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        Boolean bool = (Boolean) arrayList.get(1);
                        if (bool != null) {
                            webViewHostApi.clearCache(Long.valueOf(number.longValue()), bool);
                            hashMap.put("result", (Object) null);
                            reply.reply(hashMap);
                            return;
                        }
                        throw new NullPointerException("includeDiskFilesArg unexpectedly null.");
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void g(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        String str = (String) arrayList.get(1);
                        if (str != null) {
                            webViewHostApi.evaluateJavascript(Long.valueOf(number.longValue()), str, new Result<String>(hashMap, reply) {
                                final /* synthetic */ BasicMessageChannel.Reply val$reply;
                                final /* synthetic */ Map val$wrapped;

                                {
                                    this.val$wrapped = r1;
                                    this.val$reply = r2;
                                }

                                public void error(Throwable th) {
                                    this.val$wrapped.put("error", GeneratedAndroidWebView.wrapError(th));
                                    this.val$reply.reply(this.val$wrapped);
                                }

                                public void success(String str) {
                                    this.val$wrapped.put("result", str);
                                    this.val$reply.reply(this.val$wrapped);
                                }
                            });
                            return;
                        }
                        throw new NullPointerException("javascriptStringArg unexpectedly null.");
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                    reply.reply(hashMap);
                }
            }

            public static /* synthetic */ void h(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    Number number = (Number) ((ArrayList) obj).get(0);
                    if (number != null) {
                        hashMap.put("result", webViewHostApi.getTitle(Long.valueOf(number.longValue())));
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void i(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        Number number2 = (Number) arrayList.get(1);
                        if (number2 != null) {
                            Number number3 = (Number) arrayList.get(2);
                            if (number3 != null) {
                                webViewHostApi.scrollTo(Long.valueOf(number.longValue()), Long.valueOf(number2.longValue()), Long.valueOf(number3.longValue()));
                                hashMap.put("result", (Object) null);
                                reply.reply(hashMap);
                                return;
                            }
                            throw new NullPointerException("yArg unexpectedly null.");
                        }
                        throw new NullPointerException("xArg unexpectedly null.");
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void j(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        Number number2 = (Number) arrayList.get(1);
                        if (number2 != null) {
                            Number number3 = (Number) arrayList.get(2);
                            if (number3 != null) {
                                webViewHostApi.scrollBy(Long.valueOf(number.longValue()), Long.valueOf(number2.longValue()), Long.valueOf(number3.longValue()));
                                hashMap.put("result", (Object) null);
                                reply.reply(hashMap);
                                return;
                            }
                            throw new NullPointerException("yArg unexpectedly null.");
                        }
                        throw new NullPointerException("xArg unexpectedly null.");
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void k(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    Number number = (Number) ((ArrayList) obj).get(0);
                    if (number != null) {
                        hashMap.put("result", webViewHostApi.getScrollX(Long.valueOf(number.longValue())));
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void l(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    Number number = (Number) ((ArrayList) obj).get(0);
                    if (number != null) {
                        hashMap.put("result", webViewHostApi.getScrollY(Long.valueOf(number.longValue())));
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void m(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    Number number = (Number) ((ArrayList) obj).get(0);
                    if (number != null) {
                        hashMap.put("result", webViewHostApi.getScrollPosition(Long.valueOf(number.longValue())));
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void n(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        String str = (String) arrayList.get(1);
                        if (str != null) {
                            webViewHostApi.loadData(Long.valueOf(number.longValue()), str, (String) arrayList.get(2), (String) arrayList.get(3));
                            hashMap.put("result", (Object) null);
                            reply.reply(hashMap);
                            return;
                        }
                        throw new NullPointerException("dataArg unexpectedly null.");
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void o(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    Boolean bool = (Boolean) ((ArrayList) obj).get(0);
                    if (bool != null) {
                        webViewHostApi.setWebContentsDebuggingEnabled(bool);
                        hashMap.put("result", (Object) null);
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("enabledArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void p(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        Number number2 = (Number) arrayList.get(1);
                        if (number2 != null) {
                            webViewHostApi.setWebViewClient(Long.valueOf(number.longValue()), Long.valueOf(number2.longValue()));
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

            public static /* synthetic */ void q(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        Number number2 = (Number) arrayList.get(1);
                        if (number2 != null) {
                            webViewHostApi.addJavaScriptChannel(Long.valueOf(number.longValue()), Long.valueOf(number2.longValue()));
                            hashMap.put("result", (Object) null);
                            reply.reply(hashMap);
                            return;
                        }
                        throw new NullPointerException("javaScriptChannelInstanceIdArg unexpectedly null.");
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void r(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        Number number2 = (Number) arrayList.get(1);
                        if (number2 != null) {
                            webViewHostApi.removeJavaScriptChannel(Long.valueOf(number.longValue()), Long.valueOf(number2.longValue()));
                            hashMap.put("result", (Object) null);
                            reply.reply(hashMap);
                            return;
                        }
                        throw new NullPointerException("javaScriptChannelInstanceIdArg unexpectedly null.");
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void s(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        Number number2 = (Number) arrayList.get(1);
                        webViewHostApi.setDownloadListener(Long.valueOf(number.longValue()), number2 == null ? null : Long.valueOf(number2.longValue()));
                        hashMap.put("result", (Object) null);
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void t(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        Number number2 = (Number) arrayList.get(1);
                        webViewHostApi.setWebChromeClient(Long.valueOf(number.longValue()), number2 == null ? null : Long.valueOf(number2.longValue()));
                        hashMap.put("result", (Object) null);
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void u(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        Number number2 = (Number) arrayList.get(1);
                        if (number2 != null) {
                            webViewHostApi.setBackgroundColor(Long.valueOf(number.longValue()), Long.valueOf(number2.longValue()));
                            hashMap.put("result", (Object) null);
                            reply.reply(hashMap);
                            return;
                        }
                        throw new NullPointerException("colorArg unexpectedly null.");
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void v(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        String str = (String) arrayList.get(1);
                        String str2 = (String) arrayList.get(2);
                        if (str2 != null) {
                            WebViewHostApi webViewHostApi2 = webViewHostApi;
                            webViewHostApi2.loadDataWithBaseUrl(Long.valueOf(number.longValue()), str, str2, (String) arrayList.get(3), (String) arrayList.get(4), (String) arrayList.get(5));
                            hashMap.put("result", (Object) null);
                            reply.reply(hashMap);
                            return;
                        }
                        throw new NullPointerException("dataArg unexpectedly null.");
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void w(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        String str = (String) arrayList.get(1);
                        if (str != null) {
                            Map map = (Map) arrayList.get(2);
                            if (map != null) {
                                webViewHostApi.loadUrl(Long.valueOf(number.longValue()), str, map);
                                hashMap.put("result", (Object) null);
                                reply.reply(hashMap);
                                return;
                            }
                            throw new NullPointerException("headersArg unexpectedly null.");
                        }
                        throw new NullPointerException("urlArg unexpectedly null.");
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void x(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    Number number = (Number) arrayList.get(0);
                    if (number != null) {
                        String str = (String) arrayList.get(1);
                        if (str != null) {
                            byte[] bArr = (byte[]) arrayList.get(2);
                            if (bArr != null) {
                                webViewHostApi.postUrl(Long.valueOf(number.longValue()), str, bArr);
                                hashMap.put("result", (Object) null);
                                reply.reply(hashMap);
                                return;
                            }
                            throw new NullPointerException("dataArg unexpectedly null.");
                        }
                        throw new NullPointerException("urlArg unexpectedly null.");
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void y(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    Number number = (Number) ((ArrayList) obj).get(0);
                    if (number != null) {
                        hashMap.put("result", webViewHostApi.getUrl(Long.valueOf(number.longValue())));
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }

            public static /* synthetic */ void z(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    Number number = (Number) ((ArrayList) obj).get(0);
                    if (number != null) {
                        hashMap.put("result", webViewHostApi.canGoBack(Long.valueOf(number.longValue())));
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("instanceIdArg unexpectedly null.");
                } catch (Error | RuntimeException e5) {
                    hashMap.put("error", GeneratedAndroidWebView.wrapError(e5));
                }
            }
        }

        void addJavaScriptChannel(Long l5, Long l6);

        Boolean canGoBack(Long l5);

        Boolean canGoForward(Long l5);

        void clearCache(Long l5, Boolean bool);

        void create(Long l5, Boolean bool);

        void dispose(Long l5);

        void evaluateJavascript(Long l5, String str, Result<String> result);

        WebViewPoint getScrollPosition(Long l5);

        Long getScrollX(Long l5);

        Long getScrollY(Long l5);

        String getTitle(Long l5);

        String getUrl(Long l5);

        void goBack(Long l5);

        void goForward(Long l5);

        void loadData(Long l5, String str, String str2, String str3);

        void loadDataWithBaseUrl(Long l5, String str, String str2, String str3, String str4, String str5);

        void loadUrl(Long l5, String str, Map<String, String> map);

        void postUrl(Long l5, String str, byte[] bArr);

        void reload(Long l5);

        void removeJavaScriptChannel(Long l5, Long l6);

        void scrollBy(Long l5, Long l6, Long l7);

        void scrollTo(Long l5, Long l6, Long l7);

        void setBackgroundColor(Long l5, Long l6);

        void setDownloadListener(Long l5, Long l6);

        void setWebChromeClient(Long l5, Long l6);

        void setWebContentsDebuggingEnabled(Boolean bool);

        void setWebViewClient(Long l5, Long l6);
    }

    private static class WebViewHostApiCodec extends StandardMessageCodec {
        public static final WebViewHostApiCodec INSTANCE = new WebViewHostApiCodec();

        private WebViewHostApiCodec() {
        }

        /* access modifiers changed from: protected */
        public Object readValueOfType(byte b5, ByteBuffer byteBuffer) {
            return b5 != Byte.MIN_VALUE ? super.readValueOfType(b5, byteBuffer) : WebViewPoint.fromMap((Map) readValue(byteBuffer));
        }

        /* access modifiers changed from: protected */
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof WebViewPoint) {
                byteArrayOutputStream.write(128);
                writeValue(byteArrayOutputStream, ((WebViewPoint) obj).toMap());
                return;
            }
            super.writeValue(byteArrayOutputStream, obj);
        }
    }

    public static class WebViewPoint {

        /* renamed from: x  reason: collision with root package name */
        private Long f5341x;

        /* renamed from: y  reason: collision with root package name */
        private Long f5342y;

        public static final class Builder {

            /* renamed from: x  reason: collision with root package name */
            private Long f5343x;

            /* renamed from: y  reason: collision with root package name */
            private Long f5344y;

            public WebViewPoint build() {
                WebViewPoint webViewPoint = new WebViewPoint();
                webViewPoint.setX(this.f5343x);
                webViewPoint.setY(this.f5344y);
                return webViewPoint;
            }

            public Builder setX(Long l5) {
                this.f5343x = l5;
                return this;
            }

            public Builder setY(Long l5) {
                this.f5344y = l5;
                return this;
            }
        }

        private WebViewPoint() {
        }

        static WebViewPoint fromMap(Map<String, Object> map) {
            Long l5;
            WebViewPoint webViewPoint = new WebViewPoint();
            Object obj = map.get("x");
            Long l6 = null;
            if (obj == null) {
                l5 = null;
            } else {
                l5 = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            webViewPoint.setX(l5);
            Object obj2 = map.get("y");
            if (obj2 != null) {
                l6 = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            webViewPoint.setY(l6);
            return webViewPoint;
        }

        public Long getX() {
            return this.f5341x;
        }

        public Long getY() {
            return this.f5342y;
        }

        public void setX(Long l5) {
            if (l5 != null) {
                this.f5341x = l5;
                return;
            }
            throw new IllegalStateException("Nonnull field \"x\" is null.");
        }

        public void setY(Long l5) {
            if (l5 != null) {
                this.f5342y = l5;
                return;
            }
            throw new IllegalStateException("Nonnull field \"y\" is null.");
        }

        /* access modifiers changed from: package-private */
        public Map<String, Object> toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("x", this.f5341x);
            hashMap.put("y", this.f5342y);
            return hashMap;
        }
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> wrapError(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return hashMap;
    }
}
