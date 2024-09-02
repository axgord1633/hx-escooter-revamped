package n0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import io.flutter.plugin.common.EventChannel;

public class b0 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final EventChannel.EventSink f5997a;

    /* renamed from: b  reason: collision with root package name */
    private h0 f5998b;

    public b0(EventChannel.EventSink eventSink) {
        this.f5997a = eventSink;
    }

    public void onReceive(Context context, Intent intent) {
        h0 h0Var;
        if ("android.location.PROVIDERS_CHANGED".equals(intent.getAction())) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
            boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
            if (isProviderEnabled || isProviderEnabled2) {
                h0 h0Var2 = this.f5998b;
                if (h0Var2 == null || h0Var2 == h0.disabled) {
                    h0Var = h0.enabled;
                } else {
                    return;
                }
            } else {
                h0 h0Var3 = this.f5998b;
                if (h0Var3 == null || h0Var3 == h0.enabled) {
                    h0Var = h0.disabled;
                } else {
                    return;
                }
            }
            this.f5998b = h0Var;
            this.f5997a.success(Integer.valueOf(h0Var.ordinal()));
        }
    }
}
