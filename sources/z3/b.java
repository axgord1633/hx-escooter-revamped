package z3;

import java.util.List;
import java.util.Map;

public interface b<R> extends a {
    R call(Object... objArr);

    R callBy(Map<Object, ? extends Object> map);

    List<Object> getParameters();

    h getReturnType();

    List<Object> getTypeParameters();

    i getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
