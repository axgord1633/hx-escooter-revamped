package d2;

import io.flutter.plugin.common.MethodCall;

public class r {
    static Integer a(MethodCall methodCall) {
        return (Integer) methodCall.argument("logLevel");
    }

    static boolean b(int i5) {
        return i5 >= 1;
    }

    static boolean c(int i5) {
        return i5 >= 2;
    }
}
