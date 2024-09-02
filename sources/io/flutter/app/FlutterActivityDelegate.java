package io.flutter.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.yalantis.ucrop.view.CropImageView;
import io.flutter.Log;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.util.Preconditions;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterRunArguments;
import io.flutter.view.FlutterView;

@Deprecated
public final class FlutterActivityDelegate implements FlutterActivityEvents, FlutterView.Provider, PluginRegistry {
    private static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.app.android.SplashScreenUntilFirstFrame";
    private static final String TAG = "FlutterActivityDelegate";
    private static final WindowManager.LayoutParams matchParent = new WindowManager.LayoutParams(-1, -1);
    private final Activity activity;
    /* access modifiers changed from: private */
    public FlutterView flutterView;
    /* access modifiers changed from: private */
    public View launchView;
    private final ViewFactory viewFactory;

    public interface ViewFactory {
        FlutterNativeView createFlutterNativeView();

        FlutterView createFlutterView(Context context);

        boolean retainFlutterNativeView();
    }

    public FlutterActivityDelegate(Activity activity2, ViewFactory viewFactory2) {
        this.activity = (Activity) Preconditions.checkNotNull(activity2);
        this.viewFactory = (ViewFactory) Preconditions.checkNotNull(viewFactory2);
    }

    private void addLaunchView() {
        View view = this.launchView;
        if (view != null) {
            this.activity.addContentView(view, matchParent);
            this.flutterView.addFirstFrameListener(new FlutterView.FirstFrameListener() {
                public void onFirstFrame() {
                    FlutterActivityDelegate.this.launchView.animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).setListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            ((ViewGroup) FlutterActivityDelegate.this.launchView.getParent()).removeView(FlutterActivityDelegate.this.launchView);
                            View unused = FlutterActivityDelegate.this.launchView = null;
                        }
                    });
                    FlutterActivityDelegate.this.flutterView.removeFirstFrameListener(this);
                }
            });
            this.activity.setTheme(16973833);
        }
    }

    private View createLaunchView() {
        Drawable launchScreenDrawableFromActivityTheme;
        if (!showSplashScreenUntilFirstFrame().booleanValue() || (launchScreenDrawableFromActivityTheme = getLaunchScreenDrawableFromActivityTheme()) == null) {
            return null;
        }
        View view = new View(this.activity);
        view.setLayoutParams(matchParent);
        view.setBackground(launchScreenDrawableFromActivityTheme);
        return view;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String[] getArgsFromIntent(android.content.Intent r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "trace-startup"
            r2 = 0
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0013
            java.lang.String r1 = "--trace-startup"
            r0.add(r1)
        L_0x0013:
            java.lang.String r1 = "start-paused"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0020
            java.lang.String r1 = "--start-paused"
            r0.add(r1)
        L_0x0020:
            java.lang.String r1 = "disable-service-auth-codes"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = "--disable-service-auth-codes"
            r0.add(r1)
        L_0x002d:
            java.lang.String r1 = "use-test-fonts"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x003a
            java.lang.String r1 = "--use-test-fonts"
            r0.add(r1)
        L_0x003a:
            java.lang.String r1 = "enable-dart-profiling"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = "--enable-dart-profiling"
            r0.add(r1)
        L_0x0047:
            java.lang.String r1 = "enable-software-rendering"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0054
            java.lang.String r1 = "--enable-software-rendering"
            r0.add(r1)
        L_0x0054:
            java.lang.String r1 = "skia-deterministic-rendering"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0061
            java.lang.String r1 = "--skia-deterministic-rendering"
            r0.add(r1)
        L_0x0061:
            java.lang.String r1 = "trace-skia"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x006e
            java.lang.String r1 = "--trace-skia"
            r0.add(r1)
        L_0x006e:
            java.lang.String r1 = "trace-systrace"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x007b
            java.lang.String r1 = "--trace-systrace"
            r0.add(r1)
        L_0x007b:
            java.lang.String r1 = "trace-to-file"
            boolean r3 = r5.hasExtra(r1)
            if (r3 == 0) goto L_0x009b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "--trace-to-file="
            r3.append(r4)
            java.lang.String r1 = r5.getStringExtra(r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.add(r1)
        L_0x009b:
            java.lang.String r1 = "dump-skp-on-shader-compilation"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x00a8
            java.lang.String r1 = "--dump-skp-on-shader-compilation"
            r0.add(r1)
        L_0x00a8:
            java.lang.String r1 = "cache-sksl"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x00b5
            java.lang.String r1 = "--cache-sksl"
            r0.add(r1)
        L_0x00b5:
            java.lang.String r1 = "purge-persistent-cache"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x00c2
            java.lang.String r1 = "--purge-persistent-cache"
            r0.add(r1)
        L_0x00c2:
            java.lang.String r1 = "verbose-logging"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x00cf
            java.lang.String r1 = "--verbose-logging"
            r0.add(r1)
        L_0x00cf:
            java.lang.String r1 = "vm-service-port"
            int r1 = r5.getIntExtra(r1, r2)
            java.lang.String r3 = "--vm-service-port="
            if (r1 <= 0) goto L_0x00f0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L_0x00de:
            r4.append(r3)
            java.lang.String r1 = java.lang.Integer.toString(r1)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r0.add(r1)
            goto L_0x00fe
        L_0x00f0:
            java.lang.String r1 = "observatory-port"
            int r1 = r5.getIntExtra(r1, r2)
            if (r1 <= 0) goto L_0x00fe
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L_0x00de
        L_0x00fe:
            java.lang.String r1 = "endless-trace-buffer"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x010b
            java.lang.String r1 = "--endless-trace-buffer"
            r0.add(r1)
        L_0x010b:
            java.lang.String r1 = "dart-flags"
            boolean r2 = r5.hasExtra(r1)
            if (r2 == 0) goto L_0x012b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "--dart-flags="
            r2.append(r3)
            java.lang.String r5 = r5.getStringExtra(r1)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r0.add(r5)
        L_0x012b:
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x013e
            int r5 = r0.size()
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.Object[] r5 = r0.toArray(r5)
            java.lang.String[] r5 = (java.lang.String[]) r5
            return r5
        L_0x013e:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.app.FlutterActivityDelegate.getArgsFromIntent(android.content.Intent):java.lang.String[]");
    }

    private Drawable getLaunchScreenDrawableFromActivityTheme() {
        TypedValue typedValue = new TypedValue();
        if (!this.activity.getTheme().resolveAttribute(16842836, typedValue, true) || typedValue.resourceId == 0) {
            return null;
        }
        try {
            return this.activity.getResources().getDrawable(typedValue.resourceId);
        } catch (Resources.NotFoundException unused) {
            Log.e(TAG, "Referenced launch screen windowBackground resource does not exist");
            return null;
        }
    }

    private boolean isDebuggable() {
        return (this.activity.getApplicationInfo().flags & 2) != 0;
    }

    private boolean loadIntent(Intent intent) {
        if (!"android.intent.action.RUN".equals(intent.getAction())) {
            return false;
        }
        String stringExtra = intent.getStringExtra("route");
        String dataString = intent.getDataString();
        if (dataString == null) {
            dataString = FlutterMain.findAppBundlePath();
        }
        if (stringExtra != null) {
            this.flutterView.setInitialRoute(stringExtra);
        }
        runBundle(dataString);
        return true;
    }

    private void runBundle(String str) {
        if (!this.flutterView.getFlutterNativeView().isApplicationRunning()) {
            FlutterRunArguments flutterRunArguments = new FlutterRunArguments();
            flutterRunArguments.bundlePath = str;
            flutterRunArguments.entrypoint = "main";
            this.flutterView.runFromBundle(flutterRunArguments);
        }
    }

    private Boolean showSplashScreenUntilFirstFrame() {
        try {
            Bundle bundle = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128).metaData;
            return Boolean.valueOf(bundle != null && bundle.getBoolean(SPLASH_SCREEN_META_DATA_KEY));
        } catch (PackageManager.NameNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    public FlutterView getFlutterView() {
        return this.flutterView;
    }

    public boolean hasPlugin(String str) {
        return this.flutterView.getPluginRegistry().hasPlugin(str);
    }

    public boolean onActivityResult(int i5, int i6, Intent intent) {
        return this.flutterView.getPluginRegistry().onActivityResult(i5, i6, intent);
    }

    public boolean onBackPressed() {
        FlutterView flutterView2 = this.flutterView;
        if (flutterView2 == null) {
            return false;
        }
        flutterView2.popRoute();
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onCreate(Bundle bundle) {
        String findAppBundlePath;
        Window window = this.activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(1073741824);
        window.getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        FlutterMain.ensureInitializationComplete(this.activity.getApplicationContext(), getArgsFromIntent(this.activity.getIntent()));
        FlutterView createFlutterView = this.viewFactory.createFlutterView(this.activity);
        this.flutterView = createFlutterView;
        if (createFlutterView == null) {
            FlutterView flutterView2 = new FlutterView(this.activity, (AttributeSet) null, this.viewFactory.createFlutterNativeView());
            this.flutterView = flutterView2;
            flutterView2.setLayoutParams(matchParent);
            this.activity.setContentView(this.flutterView);
            View createLaunchView = createLaunchView();
            this.launchView = createLaunchView;
            if (createLaunchView != null) {
                addLaunchView();
            }
        }
        if (!loadIntent(this.activity.getIntent()) && (findAppBundlePath = FlutterMain.findAppBundlePath()) != null) {
            runBundle(findAppBundlePath);
        }
    }

    public void onDestroy() {
        Application application = (Application) this.activity.getApplicationContext();
        if (application instanceof FlutterApplication) {
            FlutterApplication flutterApplication = (FlutterApplication) application;
            if (this.activity.equals(flutterApplication.getCurrentActivity())) {
                flutterApplication.setCurrentActivity((Activity) null);
            }
        }
        FlutterView flutterView2 = this.flutterView;
        if (flutterView2 == null) {
            return;
        }
        if (flutterView2.getPluginRegistry().onViewDestroy(this.flutterView.getFlutterNativeView()) || this.viewFactory.retainFlutterNativeView()) {
            this.flutterView.detach();
        } else {
            this.flutterView.destroy();
        }
    }

    public void onLowMemory() {
        this.flutterView.onMemoryPressure();
    }

    public void onNewIntent(Intent intent) {
        if (!isDebuggable() || !loadIntent(intent)) {
            this.flutterView.getPluginRegistry().onNewIntent(intent);
        }
    }

    public void onPause() {
        Application application = (Application) this.activity.getApplicationContext();
        if (application instanceof FlutterApplication) {
            FlutterApplication flutterApplication = (FlutterApplication) application;
            if (this.activity.equals(flutterApplication.getCurrentActivity())) {
                flutterApplication.setCurrentActivity((Activity) null);
            }
        }
        FlutterView flutterView2 = this.flutterView;
        if (flutterView2 != null) {
            flutterView2.onPause();
        }
    }

    public void onPostResume() {
        FlutterView flutterView2 = this.flutterView;
        if (flutterView2 != null) {
            flutterView2.onPostResume();
        }
    }

    public boolean onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        return this.flutterView.getPluginRegistry().onRequestPermissionsResult(i5, strArr, iArr);
    }

    public void onResume() {
        Application application = (Application) this.activity.getApplicationContext();
        if (application instanceof FlutterApplication) {
            ((FlutterApplication) application).setCurrentActivity(this.activity);
        }
    }

    public void onStart() {
        FlutterView flutterView2 = this.flutterView;
        if (flutterView2 != null) {
            flutterView2.onStart();
        }
    }

    public void onStop() {
        this.flutterView.onStop();
    }

    public void onTrimMemory(int i5) {
        if (i5 == 10) {
            this.flutterView.onMemoryPressure();
        }
    }

    public void onUserLeaveHint() {
        this.flutterView.getPluginRegistry().onUserLeaveHint();
    }

    public void onWindowFocusChanged(boolean z4) {
        this.flutterView.getPluginRegistry().onWindowFocusChanged(z4);
    }

    public PluginRegistry.Registrar registrarFor(String str) {
        return this.flutterView.getPluginRegistry().registrarFor(str);
    }

    public <T> T valuePublishedByPlugin(String str) {
        return this.flutterView.getPluginRegistry().valuePublishedByPlugin(str);
    }
}
