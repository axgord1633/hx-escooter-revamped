package org.chromium.support_lib_boundary;

import java.io.OutputStream;
import java.util.Collection;
import java.util.concurrent.Executor;

public interface TracingControllerBoundaryInterface {
    boolean isTracing();

    void start(int i5, Collection<String> collection, int i6);

    boolean stop(OutputStream outputStream, Executor executor);
}
