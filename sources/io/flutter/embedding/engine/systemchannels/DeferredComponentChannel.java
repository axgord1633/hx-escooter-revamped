package io.flutter.embedding.engine.systemchannels;

import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeferredComponentChannel {
    private static final String TAG = "DeferredComponentChannel";
    private final MethodChannel channel;
    /* access modifiers changed from: private */
    public Map<String, List<MethodChannel.Result>> componentNameToResults = new HashMap();
    /* access modifiers changed from: private */
    public DeferredComponentManager deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
    final MethodChannel.MethodCallHandler parsingMethodHandler;

    public DeferredComponentChannel(DartExecutor dartExecutor) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                String str;
                if (DeferredComponentChannel.this.deferredComponentManager != null) {
                    String str2 = methodCall.method;
                    Map map = (Map) methodCall.arguments();
                    Log.v(DeferredComponentChannel.TAG, "Received '" + str2 + "' message.");
                    int intValue = ((Integer) map.get("loadingUnitId")).intValue();
                    String str3 = (String) map.get("componentName");
                    str2.hashCode();
                    char c5 = 65535;
                    switch (str2.hashCode()) {
                        case -1004447972:
                            if (str2.equals("uninstallDeferredComponent")) {
                                c5 = 0;
                                break;
                            }
                            break;
                        case 399701758:
                            if (str2.equals("getDeferredComponentInstallState")) {
                                c5 = 1;
                                break;
                            }
                            break;
                        case 520962947:
                            if (str2.equals("installDeferredComponent")) {
                                c5 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c5) {
                        case 0:
                            DeferredComponentChannel.this.deferredComponentManager.uninstallDeferredComponent(intValue, str3);
                            str = null;
                            break;
                        case 1:
                            str = DeferredComponentChannel.this.deferredComponentManager.getDeferredComponentInstallState(intValue, str3);
                            break;
                        case 2:
                            DeferredComponentChannel.this.deferredComponentManager.installDeferredComponent(intValue, str3);
                            if (!DeferredComponentChannel.this.componentNameToResults.containsKey(str3)) {
                                DeferredComponentChannel.this.componentNameToResults.put(str3, new ArrayList());
                            }
                            ((List) DeferredComponentChannel.this.componentNameToResults.get(str3)).add(result);
                            return;
                        default:
                            result.notImplemented();
                            return;
                    }
                    result.success(str);
                }
            }
        };
        this.parsingMethodHandler = r02;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/deferredcomponent", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    public void completeInstallError(String str, String str2) {
        if (this.componentNameToResults.containsKey(str)) {
            for (MethodChannel.Result error : this.componentNameToResults.get(str)) {
                error.error("DeferredComponent Install failure", str2, (Object) null);
            }
            this.componentNameToResults.get(str).clear();
        }
    }

    public void completeInstallSuccess(String str) {
        if (this.componentNameToResults.containsKey(str)) {
            for (MethodChannel.Result success : this.componentNameToResults.get(str)) {
                success.success((Object) null);
            }
            this.componentNameToResults.get(str).clear();
        }
    }

    public void setDeferredComponentManager(DeferredComponentManager deferredComponentManager2) {
        this.deferredComponentManager = deferredComponentManager2;
    }
}
