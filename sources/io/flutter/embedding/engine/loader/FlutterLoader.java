package io.flutter.embedding.engine.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.util.HandlerCompat;
import io.flutter.util.PathUtils;
import io.flutter.util.TraceSection;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class FlutterLoader {
    static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
    static final String AOT_VMSERVICE_SHARED_LIBRARY_NAME = "aot-vmservice-shared-library-name";
    static final String AUTOMATICALLY_REGISTER_PLUGINS_KEY = "automatically-register-plugins";
    private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
    private static final String DEFAULT_LIBRARY = "libflutter.so";
    private static final String ENABLE_IMPELLER_META_DATA_KEY = "io.flutter.embedding.android.EnableImpeller";
    private static final String ENABLE_VULKAN_VALIDATION_META_DATA_KEY = "io.flutter.embedding.android.EnableVulkanValidation";
    static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
    private static final String IMPELLER_BACKEND_META_DATA_KEY = "io.flutter.embedding.android.ImpellerBackend";
    static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
    private static final String LEAK_VM_META_DATA_KEY = "io.flutter.embedding.android.LeakVM";
    private static final String OLD_GEN_HEAP_SIZE_META_DATA_KEY = "io.flutter.embedding.android.OldGenHeapSize";
    static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
    private static final String TAG = "FlutterLoader";
    private static final String VMSERVICE_SNAPSHOT_LIBRARY = "libvmservice_snapshot.so";
    static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
    private static FlutterLoader instance;
    /* access modifiers changed from: private */
    public ExecutorService executorService;
    private FlutterApplicationInfo flutterApplicationInfo;
    /* access modifiers changed from: private */
    public FlutterJNI flutterJNI;
    Future<InitResult> initResultFuture;
    private long initStartTimestampMillis;
    private boolean initialized;
    private Settings settings;

    private static class InitResult {
        final String appStoragePath;
        final String dataDirPath;
        final String engineCachesPath;

        private InitResult(String str, String str2, String str3) {
            this.appStoragePath = str;
            this.engineCachesPath = str2;
            this.dataDirPath = str3;
        }
    }

    public static class Settings {
        private String logTag;

        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String str) {
            this.logTag = str;
        }
    }

    public FlutterLoader() {
        this(FlutterInjector.instance().getFlutterJNIFactory().provideFlutterJNI());
    }

    public FlutterLoader(FlutterJNI flutterJNI2) {
        this(flutterJNI2, FlutterInjector.instance().executorService());
    }

    public FlutterLoader(FlutterJNI flutterJNI2, ExecutorService executorService2) {
        this.initialized = false;
        this.flutterJNI = flutterJNI2;
        this.executorService = executorService2;
    }

    private static boolean areValidationLayersOnByDefault() {
        return false;
    }

    private String fullAssetPathFrom(String str) {
        return this.flutterApplicationInfo.flutterAssetsDir + File.separator + str;
    }

    /* access modifiers changed from: private */
    public ResourceExtractor initResources(Context context) {
        return null;
    }

    private static boolean isLeakVM(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean(LEAK_VM_META_DATA_KEY, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureInitializationCompleteAsync$0(Context context, String[] strArr, Handler handler, Runnable runnable) {
        ensureInitializationComplete(context.getApplicationContext(), strArr);
        handler.post(runnable);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureInitializationCompleteAsync$1(Context context, String[] strArr, Handler handler, Runnable runnable) {
        try {
            InitResult initResult = this.initResultFuture.get();
            HandlerCompat.createAsyncHandler(Looper.getMainLooper()).post(new a(this, context, strArr, handler, runnable));
        } catch (Exception e5) {
            Log.e(TAG, "Flutter initialization failed.", e5);
            throw new RuntimeException(e5);
        }
    }

    public boolean automaticallyRegisterPlugins() {
        return this.flutterApplicationInfo.automaticallyRegisterPlugins;
    }

    public void ensureInitializationComplete(Context context, String[] strArr) {
        if (!this.initialized) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
            } else if (this.settings != null) {
                TraceSection.begin("FlutterLoader#ensureInitializationComplete");
                try {
                    InitResult initResult = this.initResultFuture.get();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                    StringBuilder sb = new StringBuilder();
                    sb.append("--icu-native-lib-path=");
                    sb.append(this.flutterApplicationInfo.nativeLibraryDir);
                    String str = File.separator;
                    sb.append(str);
                    sb.append(DEFAULT_LIBRARY);
                    arrayList.add(sb.toString());
                    if (strArr != null) {
                        Collections.addAll(arrayList, strArr);
                    }
                    arrayList.add("--aot-shared-library-name=" + this.flutterApplicationInfo.aotSharedLibraryName);
                    arrayList.add("--aot-shared-library-name=" + this.flutterApplicationInfo.nativeLibraryDir + str + this.flutterApplicationInfo.aotSharedLibraryName);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("--cache-dir-path=");
                    sb2.append(initResult.engineCachesPath);
                    arrayList.add(sb2.toString());
                    if (this.flutterApplicationInfo.domainNetworkPolicy != null) {
                        arrayList.add("--domain-network-policy=" + this.flutterApplicationInfo.domainNetworkPolicy);
                    }
                    if (this.settings.getLogTag() != null) {
                        arrayList.add("--log-tag=" + this.settings.getLogTag());
                    }
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    int i5 = bundle != null ? bundle.getInt(OLD_GEN_HEAP_SIZE_META_DATA_KEY) : 0;
                    if (i5 == 0) {
                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                        i5 = (int) ((((double) memoryInfo.totalMem) / 1000000.0d) / 2.0d);
                    }
                    arrayList.add("--old-gen-heap-size=" + i5);
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 12 * 4));
                    arrayList.add("--prefetched-default-font-manager");
                    if (bundle != null) {
                        if (bundle.getBoolean(ENABLE_IMPELLER_META_DATA_KEY, false)) {
                            arrayList.add(FlutterShellArgs.ARG_ENABLE_IMPELLER);
                        }
                        if (bundle.getBoolean(ENABLE_VULKAN_VALIDATION_META_DATA_KEY, areValidationLayersOnByDefault())) {
                            arrayList.add(FlutterShellArgs.ARG_ENABLE_VULKAN_VALIDATION);
                        }
                        String string = bundle.getString(IMPELLER_BACKEND_META_DATA_KEY);
                        if (string != null) {
                            arrayList.add("--impeller-backend=" + string);
                        }
                    }
                    String str2 = isLeakVM(bundle) ? "true" : "false";
                    arrayList.add("--leak-vm=" + str2);
                    this.flutterJNI.init(context, (String[]) arrayList.toArray(new String[0]), (String) null, initResult.appStoragePath, initResult.engineCachesPath, SystemClock.uptimeMillis() - this.initStartTimestampMillis);
                    this.initialized = true;
                    TraceSection.end();
                } catch (Exception e5) {
                    Log.e(TAG, "Flutter initialization failed.", e5);
                    throw new RuntimeException(e5);
                } catch (Throwable th) {
                    TraceSection.end();
                    throw th;
                }
            } else {
                throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
            }
        }
    }

    public void ensureInitializationCompleteAsync(Context context, String[] strArr, Handler handler, Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        } else if (this.settings == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        } else if (this.initialized) {
            handler.post(runnable);
        } else {
            this.executorService.execute(new b(this, context, strArr, handler, runnable));
        }
    }

    public String findAppBundlePath() {
        return this.flutterApplicationInfo.flutterAssetsDir;
    }

    public String getLookupKeyForAsset(String str) {
        return fullAssetPathFrom(str);
    }

    public String getLookupKeyForAsset(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("packages");
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(str);
        return getLookupKeyForAsset(sb.toString());
    }

    public boolean initialized() {
        return this.initialized;
    }

    public void startInitialization(Context context) {
        startInitialization(context, new Settings());
    }

    public void startInitialization(Context context, Settings settings2) {
        if (this.settings == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                TraceSection.begin("FlutterLoader#startInitialization");
                try {
                    final Context applicationContext = context.getApplicationContext();
                    this.settings = settings2;
                    this.initStartTimestampMillis = SystemClock.uptimeMillis();
                    this.flutterApplicationInfo = ApplicationInfoLoader.load(applicationContext);
                    VsyncWaiter.getInstance((DisplayManager) applicationContext.getSystemService("display"), this.flutterJNI).init();
                    this.initResultFuture = this.executorService.submit(new Callable<InitResult>() {
                        /* access modifiers changed from: private */
                        public /* synthetic */ void lambda$call$0() {
                            FlutterLoader.this.flutterJNI.prefetchDefaultFontManager();
                        }

                        public InitResult call() {
                            TraceSection.begin("FlutterLoader initTask");
                            try {
                                ResourceExtractor access$000 = FlutterLoader.this.initResources(applicationContext);
                                FlutterLoader.this.flutterJNI.loadLibrary();
                                FlutterLoader.this.flutterJNI.updateRefreshRate();
                                FlutterLoader.this.executorService.execute(new c(this));
                                if (access$000 != null) {
                                    access$000.waitForCompletion();
                                }
                                return new InitResult(PathUtils.getFilesDir(applicationContext), PathUtils.getCacheDirectory(applicationContext), PathUtils.getDataDirectory(applicationContext));
                            } finally {
                                TraceSection.end();
                            }
                        }
                    });
                } finally {
                    TraceSection.end();
                }
            } else {
                throw new IllegalStateException("startInitialization must be called on the main thread");
            }
        }
    }
}
