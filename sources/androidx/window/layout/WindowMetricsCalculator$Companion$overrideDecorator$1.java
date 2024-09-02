package androidx.window.layout;

import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import v3.l;

/* synthetic */ class WindowMetricsCalculator$Companion$overrideDecorator$1 extends j implements l<WindowMetricsCalculator, WindowMetricsCalculator> {
    WindowMetricsCalculator$Companion$overrideDecorator$1(Object obj) {
        super(1, obj, WindowMetricsCalculatorDecorator.class, "decorate", "decorate(Landroidx/window/layout/WindowMetricsCalculator;)Landroidx/window/layout/WindowMetricsCalculator;", 0);
    }

    public final WindowMetricsCalculator invoke(WindowMetricsCalculator windowMetricsCalculator) {
        k.e(windowMetricsCalculator, "p0");
        return ((WindowMetricsCalculatorDecorator) this.receiver).decorate(windowMetricsCalculator);
    }
}
