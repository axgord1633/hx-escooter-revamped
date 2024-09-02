package v0;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleCallback;

public interface f {
    void a(String str, LifecycleCallback lifecycleCallback);

    <T extends LifecycleCallback> T b(String str, Class<T> cls);

    Activity c();

    void startActivityForResult(Intent intent, int i5);
}
