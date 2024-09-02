package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

final class b0 extends Writer {

    /* renamed from: e  reason: collision with root package name */
    private final String f2196e;

    /* renamed from: f  reason: collision with root package name */
    private StringBuilder f2197f = new StringBuilder(128);

    b0(String str) {
        this.f2196e = str;
    }

    private void b() {
        if (this.f2197f.length() > 0) {
            Log.d(this.f2196e, this.f2197f.toString());
            StringBuilder sb = this.f2197f;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        b();
    }

    public void flush() {
        b();
    }

    public void write(char[] cArr, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            char c5 = cArr[i5 + i7];
            if (c5 == 10) {
                b();
            } else {
                this.f2197f.append(c5);
            }
        }
    }
}
