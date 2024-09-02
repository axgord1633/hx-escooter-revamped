package j0;

import android.util.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;

public final class b implements FlutterPlugin {

    /* renamed from: a  reason: collision with root package name */
    private c f5428a;

    /* renamed from: b  reason: collision with root package name */
    private a f5429b;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        a aVar = new a(flutterPluginBinding.getApplicationContext());
        this.f5429b = aVar;
        c cVar = new c(aVar);
        this.f5428a = cVar;
        cVar.c(flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        c cVar = this.f5428a;
        if (cVar == null) {
            Log.wtf("GeocodingPlugin", "Already detached from the engine.");
            return;
        }
        cVar.d();
        this.f5428a = null;
        this.f5429b = null;
    }
}
