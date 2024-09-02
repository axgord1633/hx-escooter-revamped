package com.signify.hue.flutterreactiveble.debugutils;

import kotlin.jvm.internal.k;
import m3.j;

public final class PerformanceAnalyzer {
    public static final PerformanceAnalyzer INSTANCE = new PerformanceAnalyzer();
    private static j<Long, Long> timer = new j<>(0L, 0L);

    private PerformanceAnalyzer() {
    }

    public final void end(long j5) {
        timer = j.d(timer, (Object) null, Long.valueOf(j5), 1, (Object) null);
    }

    public final j<Long, Long> getTimer() {
        return timer;
    }

    public final void setTimer(j<Long, Long> jVar) {
        k.e(jVar, "<set-?>");
        timer = jVar;
    }

    public final void start(long j5) {
        timer = j.d(timer, Long.valueOf(j5), (Object) null, 2, (Object) null);
    }

    public final long timeElapsed() {
        return timer.f().longValue() - timer.e().longValue();
    }
}
