package e0;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import android.webkit.WebView;
import d0.d;
import d0.f;

public class c {

    class a extends WebMessagePort.WebMessageCallback {
        a(d.a aVar) {
        }

        public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
            new n(webMessagePort);
            n.c(webMessage);
            throw null;
        }
    }

    class b extends WebMessagePort.WebMessageCallback {
        b(d.a aVar) {
        }

        public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
            new n(webMessagePort);
            n.c(webMessage);
            throw null;
        }
    }

    /* renamed from: e0.c$c  reason: collision with other inner class name */
    class C0074c extends WebView.VisualStateCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f4452a;

        C0074c(f fVar) {
            this.f4452a = fVar;
        }

        public void onComplete(long j5) {
            this.f4452a.onComplete(j5);
        }
    }

    public static void a(WebMessagePort webMessagePort) {
        webMessagePort.close();
    }

    public static WebMessage b(d0.c cVar) {
        return new WebMessage(cVar.a(), n.b(cVar.b()));
    }

    public static WebMessagePort[] c(WebView webView) {
        return webView.createWebMessageChannel();
    }

    public static d0.c d(WebMessage webMessage) {
        return new d0.c(webMessage.getData(), n.e(webMessage.getPorts()));
    }

    public static CharSequence e(WebResourceError webResourceError) {
        return webResourceError.getDescription();
    }

    public static int f(WebResourceError webResourceError) {
        return webResourceError.getErrorCode();
    }

    public static boolean g(WebSettings webSettings) {
        return webSettings.getOffscreenPreRaster();
    }

    public static void h(WebMessagePort webMessagePort, WebMessage webMessage) {
        webMessagePort.postMessage(webMessage);
    }

    public static void i(WebView webView, long j5, f fVar) {
        webView.postVisualStateCallback(j5, new C0074c(fVar));
    }

    public static void j(WebView webView, WebMessage webMessage, Uri uri) {
        webView.postWebMessage(webMessage, uri);
    }

    public static void k(WebSettings webSettings, boolean z4) {
        webSettings.setOffscreenPreRaster(z4);
    }

    public static void l(WebMessagePort webMessagePort, d.a aVar) {
        webMessagePort.setWebMessageCallback(new a(aVar));
    }

    public static void m(WebMessagePort webMessagePort, d.a aVar, Handler handler) {
        webMessagePort.setWebMessageCallback(new b(aVar), handler);
    }
}
