package com.signify.hue.flutterreactiveble.utils;

import c2.a;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;

public final class Duration {
    private final TimeUnit unit;
    private final long value;

    public Duration(long j5, TimeUnit timeUnit) {
        k.e(timeUnit, "unit");
        this.value = j5;
        this.unit = timeUnit;
    }

    public static /* synthetic */ Duration copy$default(Duration duration, long j5, TimeUnit timeUnit, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            j5 = duration.value;
        }
        if ((i5 & 2) != 0) {
            timeUnit = duration.unit;
        }
        return duration.copy(j5, timeUnit);
    }

    public final long component1() {
        return this.value;
    }

    public final TimeUnit component2() {
        return this.unit;
    }

    public final Duration copy(long j5, TimeUnit timeUnit) {
        k.e(timeUnit, "unit");
        return new Duration(j5, timeUnit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.value == duration.value && this.unit == duration.unit;
    }

    public final TimeUnit getUnit() {
        return this.unit;
    }

    public final long getValue() {
        return this.value;
    }

    public int hashCode() {
        return (a.a(this.value) * 31) + this.unit.hashCode();
    }

    public String toString() {
        return "Duration(value=" + this.value + ", unit=" + this.unit + ')';
    }
}
