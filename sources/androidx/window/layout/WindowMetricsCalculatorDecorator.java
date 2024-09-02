package androidx.window.layout;

public interface WindowMetricsCalculatorDecorator {
    WindowMetricsCalculator decorate(WindowMetricsCalculator windowMetricsCalculator);
}
