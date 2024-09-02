package e1;

import android.os.Handler;
import android.os.Looper;

public class k extends Handler {
    public k(Looper looper) {
        super(looper);
    }

    public k(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
