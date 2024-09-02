package x3;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.k;

public final class a extends w3.a {
    public Random c() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        k.d(current, "current()");
        return current;
    }
}
