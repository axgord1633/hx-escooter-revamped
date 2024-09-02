package w1;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import m2.q;
import q1.m;

public class v implements s {

    /* renamed from: d  reason: collision with root package name */
    private static final long f7536d = TimeUnit.SECONDS.toMillis(30);

    /* renamed from: a  reason: collision with root package name */
    private final long[] f7537a = new long[5];

    /* renamed from: b  reason: collision with root package name */
    private final t f7538b;

    /* renamed from: c  reason: collision with root package name */
    private final q f7539c;

    public v(t tVar, q qVar) {
        this.f7538b = tVar;
        this.f7539c = qVar;
    }

    private int b() {
        long j5 = Long.MAX_VALUE;
        int i5 = -1;
        for (int i6 = 0; i6 < 5; i6++) {
            long j6 = this.f7537a[i6];
            if (j6 < j5) {
                i5 = i6;
                j5 = j6;
            }
        }
        return i5;
    }

    public void a(boolean z4) {
        this.f7538b.a(z4);
        int b5 = b();
        long j5 = this.f7537a[b5];
        long b6 = this.f7539c.b(TimeUnit.MILLISECONDS);
        long j6 = f7536d;
        if (b6 - j5 >= j6) {
            this.f7537a[b5] = b6;
            return;
        }
        throw new m(2147483646, new Date(j5 + j6));
    }
}
