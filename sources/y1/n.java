package y1;

import android.content.Context;
import android.os.Process;
import java.util.HashSet;
import java.util.Set;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7762a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<String> f7763b = new HashSet();

    n(Context context) {
        this.f7762a = context;
    }

    private boolean b(String str) {
        if (str != null) {
            boolean z4 = true;
            if (this.f7763b.contains(str)) {
                return true;
            }
            if (this.f7762a.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                z4 = false;
            }
            if (z4) {
                this.f7763b.add(str);
            }
            return z4;
        }
        throw new IllegalArgumentException("permission is null");
    }

    /* access modifiers changed from: package-private */
    public boolean a(String[] strArr) {
        for (String b5 : strArr) {
            if (b(b5)) {
                return true;
            }
        }
        return false;
    }
}
