package e1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.a;

public final class i extends a {
    @Deprecated
    public static Intent i(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (!g.a()) {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, true != g.a() ? 0 : 2);
    }
}
