package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.profileinstaller.j;

public class ProfileInstallReceiver extends BroadcastReceiver {

    class a implements j.c {
        a() {
        }

        public void a(int i5, Object obj) {
            j.f2669b.a(i5, obj);
        }

        public void b(int i5, Object obj) {
            j.f2669b.b(i5, obj);
            ProfileInstallReceiver.this.setResultCode(i5);
        }
    }

    static void a(j.c cVar) {
        int i5;
        if (Build.VERSION.SDK_INT >= 24) {
            Process.sendSignal(Process.myPid(), 10);
            i5 = 12;
        } else {
            i5 = 13;
        }
        cVar.b(i5, (Object) null);
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent != null) {
            String action = intent.getAction();
            if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
                j.k(context, new h(), new a(), true);
            } else if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                    if ("WRITE_SKIP_FILE".equals(string)) {
                        j.l(context, new h(), new a());
                    } else if ("DELETE_SKIP_FILE".equals(string)) {
                        j.c(context, new h(), new a());
                    }
                }
            } else if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
                a(new a());
            } else if ("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) && (extras = intent.getExtras()) != null) {
                String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
                a aVar = new a();
                if ("DROP_SHADER_CACHE".equals(string2)) {
                    a.b(context, aVar);
                } else {
                    aVar.b(16, (Object) null);
                }
            }
        }
    }
}
