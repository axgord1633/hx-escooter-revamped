package d4;

import android.os.Looper;
import c4.v1;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.internal.r;

public final class a implements r {
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    public v1 b(List<? extends r> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new c(e.a(mainLooper, true), (String) null, 2, (g) null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    public int c() {
        return 1073741823;
    }
}
