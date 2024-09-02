package io.flutter.embedding.engine.deferredcomponents;

import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;

public interface DeferredComponentManager {
    void destroy();

    String getDeferredComponentInstallState(int i5, String str);

    void installDeferredComponent(int i5, String str);

    void loadAssets(int i5, String str);

    void loadDartLibrary(int i5, String str);

    void setDeferredComponentChannel(DeferredComponentChannel deferredComponentChannel);

    void setJNI(FlutterJNI flutterJNI);

    boolean uninstallDeferredComponent(int i5, String str);
}
