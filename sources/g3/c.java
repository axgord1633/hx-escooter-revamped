package g3;

import java.util.concurrent.atomic.AtomicLong;

public final class c {
    public static long a(AtomicLong atomicLong, long j5) {
        long j6;
        do {
            j6 = atomicLong.get();
            if (j6 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j6, b(j6, j5)));
        return j6;
    }

    public static long b(long j5, long j6) {
        long j7 = j5 + j6;
        if (j7 < 0) {
            return Long.MAX_VALUE;
        }
        return j7;
    }
}
