package io.flutter.embedding.engine.deferredcomponents;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.yalantis.ucrop.BuildConfig;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.loader.ApplicationInfoLoader;
import io.flutter.embedding.engine.loader.FlutterApplicationInfo;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PlayStoreDeferredComponentManager implements DeferredComponentManager {
    public static final String MAPPING_KEY = (DeferredComponentManager.class.getName() + ".loadingUnitMapping");
    private static final String TAG = "PlayStoreDeferredComponentManager";
    /* access modifiers changed from: private */
    public DeferredComponentChannel channel;
    private Context context;
    private FlutterApplicationInfo flutterApplicationInfo;
    /* access modifiers changed from: private */
    public FlutterJNI flutterJNI;
    private FeatureInstallStateUpdatedListener listener;
    protected SparseArray<String> loadingUnitIdToComponentNames = new SparseArray<>();
    protected SparseArray<String> loadingUnitIdToSharedLibraryNames = new SparseArray<>();
    private Map<String, Integer> nameToSessionId = new HashMap();
    /* access modifiers changed from: private */
    public SparseIntArray sessionIdToLoadingUnitId = new SparseIntArray();
    /* access modifiers changed from: private */
    public SparseArray<String> sessionIdToName = new SparseArray<>();
    /* access modifiers changed from: private */
    public SparseArray<String> sessionIdToState = new SparseArray<>();
    private SplitInstallManager splitInstallManager;

    private class FeatureInstallStateUpdatedListener implements SplitInstallStateUpdatedListener {
        private FeatureInstallStateUpdatedListener() {
        }

        public void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
            SparseArray sparseArray;
            String str;
            int sessionId = splitInstallSessionState.sessionId();
            if (PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId) != null) {
                switch (splitInstallSessionState.status()) {
                    case 1:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install pending.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        sparseArray = PlayStoreDeferredComponentManager.this.sessionIdToState;
                        str = "pending";
                        break;
                    case 2:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) downloading.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        sparseArray = PlayStoreDeferredComponentManager.this.sessionIdToState;
                        str = "downloading";
                        break;
                    case 3:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) downloaded.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        sparseArray = PlayStoreDeferredComponentManager.this.sessionIdToState;
                        str = "downloaded";
                        break;
                    case 4:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) installing.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        sparseArray = PlayStoreDeferredComponentManager.this.sessionIdToState;
                        str = "installing";
                        break;
                    case 5:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install successfully.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager playStoreDeferredComponentManager = PlayStoreDeferredComponentManager.this;
                        playStoreDeferredComponentManager.loadAssets(playStoreDeferredComponentManager.sessionIdToLoadingUnitId.get(sessionId), (String) PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId));
                        if (PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.get(sessionId) > 0) {
                            PlayStoreDeferredComponentManager playStoreDeferredComponentManager2 = PlayStoreDeferredComponentManager.this;
                            playStoreDeferredComponentManager2.loadDartLibrary(playStoreDeferredComponentManager2.sessionIdToLoadingUnitId.get(sessionId), (String) PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId));
                        }
                        if (PlayStoreDeferredComponentManager.this.channel != null) {
                            PlayStoreDeferredComponentManager.this.channel.completeInstallSuccess((String) PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId));
                        }
                        PlayStoreDeferredComponentManager.this.sessionIdToName.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.delete(sessionId);
                        sparseArray = PlayStoreDeferredComponentManager.this.sessionIdToState;
                        str = "installed";
                        break;
                    case 6:
                        Log.e(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install failed with: %s", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId), Integer.valueOf(splitInstallSessionState.errorCode())}));
                        FlutterJNI access$200 = PlayStoreDeferredComponentManager.this.flutterJNI;
                        int i5 = PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.get(sessionId);
                        access$200.deferredComponentInstallFailure(i5, "Module install failed with " + splitInstallSessionState.errorCode(), true);
                        if (PlayStoreDeferredComponentManager.this.channel != null) {
                            PlayStoreDeferredComponentManager.this.channel.completeInstallError((String) PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), "Android Deferred Component failed to install.");
                        }
                        PlayStoreDeferredComponentManager.this.sessionIdToName.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.delete(sessionId);
                        sparseArray = PlayStoreDeferredComponentManager.this.sessionIdToState;
                        str = "failed";
                        break;
                    case 7:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install canceled.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        if (PlayStoreDeferredComponentManager.this.channel != null) {
                            PlayStoreDeferredComponentManager.this.channel.completeInstallError((String) PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), "Android Deferred Component installation canceled.");
                        }
                        PlayStoreDeferredComponentManager.this.sessionIdToName.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.delete(sessionId);
                        sparseArray = PlayStoreDeferredComponentManager.this.sessionIdToState;
                        str = "cancelled";
                        break;
                    case 8:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install requires user confirmation.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        sparseArray = PlayStoreDeferredComponentManager.this.sessionIdToState;
                        str = "requiresUserConfirmation";
                        break;
                    case 9:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install canceling.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        sparseArray = PlayStoreDeferredComponentManager.this.sessionIdToState;
                        str = "canceling";
                        break;
                    default:
                        Log.d(PlayStoreDeferredComponentManager.TAG, "Unknown status: " + splitInstallSessionState.status());
                        return;
                }
                sparseArray.put(sessionId, str);
            }
        }
    }

    public PlayStoreDeferredComponentManager(Context context2, FlutterJNI flutterJNI2) {
        this.context = context2;
        this.flutterJNI = flutterJNI2;
        this.flutterApplicationInfo = ApplicationInfoLoader.load(context2);
        this.splitInstallManager = SplitInstallManagerFactory.create(context2);
        FeatureInstallStateUpdatedListener featureInstallStateUpdatedListener = new FeatureInstallStateUpdatedListener();
        this.listener = featureInstallStateUpdatedListener;
        this.splitInstallManager.registerListener(featureInstallStateUpdatedListener);
        initLoadingUnitMappingToComponentNames();
    }

    private ApplicationInfo getApplicationInfo() {
        try {
            return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e5) {
            throw new RuntimeException(e5);
        }
    }

    private void initLoadingUnitMappingToComponentNames() {
        Bundle bundle;
        ApplicationInfo applicationInfo = getApplicationInfo();
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
            String str = MAPPING_KEY;
            String string = bundle.getString(str, (String) null);
            if (string == null) {
                Log.e(TAG, "No loading unit to dynamic feature module name found. Ensure '" + str + "' is defined in the base module's AndroidManifest.");
            } else if (!string.equals(BuildConfig.FLAVOR)) {
                for (String split : string.split(",")) {
                    String[] split2 = split.split(":", -1);
                    int parseInt = Integer.parseInt(split2[0]);
                    this.loadingUnitIdToComponentNames.put(parseInt, split2[1]);
                    if (split2.length > 2) {
                        this.loadingUnitIdToSharedLibraryNames.put(parseInt, split2[2]);
                    }
                }
            }
        }
    }

    private /* synthetic */ void lambda$installDeferredComponent$0(String str, int i5, Integer num) {
        this.sessionIdToName.put(num.intValue(), str);
        this.sessionIdToLoadingUnitId.put(num.intValue(), i5);
        if (this.nameToSessionId.containsKey(str)) {
            this.sessionIdToState.remove(this.nameToSessionId.get(str).intValue());
        }
        this.nameToSessionId.put(str, num);
        this.sessionIdToState.put(num.intValue(), "Requested");
    }

    private /* synthetic */ void lambda$installDeferredComponent$1(int i5, String str, Exception exc) {
        SplitInstallException splitInstallException = (SplitInstallException) exc;
        int errorCode = splitInstallException.getErrorCode();
        if (errorCode == -6) {
            this.flutterJNI.deferredComponentInstallFailure(i5, String.format("Install of deferred component module \"%s\" failed with a network error", new Object[]{str}), true);
        } else if (errorCode != -2) {
            this.flutterJNI.deferredComponentInstallFailure(i5, String.format("Install of deferred component module \"%s\" failed with error %d: %s", new Object[]{str, Integer.valueOf(splitInstallException.getErrorCode()), splitInstallException.getMessage()}), false);
        } else {
            this.flutterJNI.deferredComponentInstallFailure(i5, String.format("Install of deferred component module \"%s\" failed as it is unavailable", new Object[]{str}), false);
        }
    }

    private boolean verifyJNI() {
        if (this.flutterJNI != null) {
            return true;
        }
        Log.e(TAG, "No FlutterJNI provided. `setJNI` must be called on the DeferredComponentManager before attempting to load dart libraries or invoking with platform channels.");
        return false;
    }

    public void destroy() {
        this.splitInstallManager.unregisterListener(this.listener);
        this.channel = null;
        this.flutterJNI = null;
    }

    public String getDeferredComponentInstallState(int i5, String str) {
        if (str == null) {
            str = this.loadingUnitIdToComponentNames.get(i5);
        }
        if (str == null) {
            Log.e(TAG, "Deferred component name was null and could not be resolved from loading unit id.");
            return "unknown";
        } else if (!this.nameToSessionId.containsKey(str)) {
            return this.splitInstallManager.getInstalledModules().contains(str) ? "installedPendingLoad" : "unknown";
        } else {
            return this.sessionIdToState.get(this.nameToSessionId.get(str).intValue());
        }
    }

    public void installDeferredComponent(int i5, String str) {
        String str2 = str != null ? str : this.loadingUnitIdToComponentNames.get(i5);
        if (str2 == null) {
            Log.e(TAG, "Deferred component name was null and could not be resolved from loading unit id.");
        } else if (!str2.equals(BuildConfig.FLAVOR) || i5 <= 0) {
            this.splitInstallManager.startInstall(SplitInstallRequest.newBuilder().addModule(str2).build()).addOnSuccessListener(new a(this, str2, i5)).addOnFailureListener(new b(this, i5, str));
        } else {
            loadDartLibrary(i5, str2);
        }
    }

    public void loadAssets(int i5, String str) {
        if (verifyJNI()) {
            try {
                Context context2 = this.context;
                Context createPackageContext = context2.createPackageContext(context2.getPackageName(), 0);
                this.context = createPackageContext;
                this.flutterJNI.updateJavaAssetManager(createPackageContext.getAssets(), this.flutterApplicationInfo.flutterAssetsDir);
            } catch (PackageManager.NameNotFoundException e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    public void loadDartLibrary(int i5, String str) {
        if (verifyJNI() && i5 >= 0) {
            String str2 = this.loadingUnitIdToSharedLibraryNames.get(i5);
            if (str2 == null) {
                str2 = this.flutterApplicationInfo.aotSharedLibraryName + "-" + i5 + ".part.so";
            }
            String str3 = Build.SUPPORTED_ABIS[0];
            String replace = str3.replace("-", "_");
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.context.getFilesDir());
            for (String file : this.context.getApplicationInfo().splitSourceDirs) {
                linkedList.add(new File(file));
            }
            while (!linkedList.isEmpty()) {
                File file2 = (File) linkedList.remove();
                if (file2 == null || !file2.isDirectory() || file2.listFiles() == null) {
                    String name = file2.getName();
                    if (name.endsWith(".apk") && ((name.startsWith(str) || name.startsWith("split_config")) && name.contains(replace))) {
                        arrayList.add(file2.getAbsolutePath());
                    } else if (name.equals(str2)) {
                        arrayList2.add(file2.getAbsolutePath());
                    }
                } else {
                    for (File add : file2.listFiles()) {
                        linkedList.add(add);
                    }
                }
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(str2);
            for (String str4 : arrayList) {
                arrayList3.add(str4 + "!lib/" + str3 + "/" + str2);
            }
            for (String add2 : arrayList2) {
                arrayList3.add(add2);
            }
            this.flutterJNI.loadDartDeferredLibrary(i5, (String[]) arrayList3.toArray(new String[arrayList3.size()]));
        }
    }

    public void setDeferredComponentChannel(DeferredComponentChannel deferredComponentChannel) {
        this.channel = deferredComponentChannel;
    }

    public void setJNI(FlutterJNI flutterJNI2) {
        this.flutterJNI = flutterJNI2;
    }

    public boolean uninstallDeferredComponent(int i5, String str) {
        if (str == null) {
            str = this.loadingUnitIdToComponentNames.get(i5);
        }
        if (str == null) {
            Log.e(TAG, "Deferred component name was null and could not be resolved from loading unit id.");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.splitInstallManager.deferredUninstall(arrayList);
        if (this.nameToSessionId.get(str) == null) {
            return true;
        }
        this.sessionIdToState.delete(this.nameToSessionId.get(str).intValue());
        return true;
    }
}
