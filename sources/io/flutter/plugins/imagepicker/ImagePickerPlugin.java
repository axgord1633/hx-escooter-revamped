package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.f;
import androidx.lifecycle.j;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.imagepicker.ImagePickerDelegate;
import io.flutter.plugins.imagepicker.Messages;
import java.util.List;

public class ImagePickerPlugin implements FlutterPlugin, ActivityAware, Messages.ImagePickerApi {
    ActivityState activityState;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;

    /* renamed from: io.flutter.plugins.imagepicker.ImagePickerPlugin$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceCamera;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                io.flutter.plugins.imagepicker.Messages$SourceType[] r0 = io.flutter.plugins.imagepicker.Messages.SourceType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceType = r0
                r1 = 1
                io.flutter.plugins.imagepicker.Messages$SourceType r2 = io.flutter.plugins.imagepicker.Messages.SourceType.GALLERY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.plugins.imagepicker.Messages$SourceType r3 = io.flutter.plugins.imagepicker.Messages.SourceType.CAMERA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                io.flutter.plugins.imagepicker.Messages$SourceCamera[] r2 = io.flutter.plugins.imagepicker.Messages.SourceCamera.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceCamera = r2
                io.flutter.plugins.imagepicker.Messages$SourceCamera r3 = io.flutter.plugins.imagepicker.Messages.SourceCamera.FRONT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceCamera     // Catch:{ NoSuchFieldError -> 0x0038 }
                io.flutter.plugins.imagepicker.Messages$SourceCamera r2 = io.flutter.plugins.imagepicker.Messages.SourceCamera.REAR     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerPlugin.AnonymousClass1.<clinit>():void");
        }
    }

    private class ActivityState {
        private Activity activity;
        private ActivityPluginBinding activityBinding;
        private Application application;
        private ImagePickerDelegate delegate;
        private f lifecycle;
        private BinaryMessenger messenger;
        private LifeCycleObserver observer;

        ActivityState(Application application2, Activity activity2, BinaryMessenger binaryMessenger, Messages.ImagePickerApi imagePickerApi, PluginRegistry.Registrar registrar, ActivityPluginBinding activityPluginBinding) {
            this.application = application2;
            this.activity = activity2;
            this.activityBinding = activityPluginBinding;
            this.messenger = binaryMessenger;
            this.delegate = ImagePickerPlugin.this.constructDelegate(activity2);
            Messages.ImagePickerApi.CC.f(binaryMessenger, imagePickerApi);
            LifeCycleObserver lifeCycleObserver = new LifeCycleObserver(activity2);
            this.observer = lifeCycleObserver;
            if (registrar != null) {
                application2.registerActivityLifecycleCallbacks(lifeCycleObserver);
                registrar.addActivityResultListener(this.delegate);
                registrar.addRequestPermissionsResultListener(this.delegate);
                return;
            }
            activityPluginBinding.addActivityResultListener(this.delegate);
            activityPluginBinding.addRequestPermissionsResultListener(this.delegate);
            f activityLifecycle = FlutterLifecycleAdapter.getActivityLifecycle(activityPluginBinding);
            this.lifecycle = activityLifecycle;
            activityLifecycle.a(this.observer);
        }

        ActivityState(ImagePickerDelegate imagePickerDelegate, Activity activity2) {
            this.activity = activity2;
            this.delegate = imagePickerDelegate;
        }

        /* access modifiers changed from: package-private */
        public Activity getActivity() {
            return this.activity;
        }

        /* access modifiers changed from: package-private */
        public ImagePickerDelegate getDelegate() {
            return this.delegate;
        }

        /* access modifiers changed from: package-private */
        public void release() {
            ActivityPluginBinding activityPluginBinding = this.activityBinding;
            if (activityPluginBinding != null) {
                activityPluginBinding.removeActivityResultListener(this.delegate);
                this.activityBinding.removeRequestPermissionsResultListener(this.delegate);
                this.activityBinding = null;
            }
            f fVar = this.lifecycle;
            if (fVar != null) {
                fVar.c(this.observer);
                this.lifecycle = null;
            }
            Messages.ImagePickerApi.CC.f(this.messenger, (Messages.ImagePickerApi) null);
            Application application2 = this.application;
            if (application2 != null) {
                application2.unregisterActivityLifecycleCallbacks(this.observer);
                this.application = null;
            }
            this.activity = null;
            this.observer = null;
            this.delegate = null;
        }
    }

    private class LifeCycleObserver implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {
        private final Activity thisActivity;

        LifeCycleObserver(Activity activity) {
            this.thisActivity = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.thisActivity == activity && activity.getApplicationContext() != null) {
                ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
            }
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
            if (this.thisActivity == activity) {
                ImagePickerPlugin.this.activityState.getDelegate().saveStateBeforeResult();
            }
        }

        public void onCreate(j jVar) {
        }

        public void onDestroy(j jVar) {
            onActivityDestroyed(this.thisActivity);
        }

        public void onPause(j jVar) {
        }

        public void onResume(j jVar) {
        }

        public void onStart(j jVar) {
        }

        public void onStop(j jVar) {
            onActivityStopped(this.thisActivity);
        }
    }

    public ImagePickerPlugin() {
    }

    ImagePickerPlugin(ImagePickerDelegate imagePickerDelegate, Activity activity) {
        this.activityState = new ActivityState(imagePickerDelegate, activity);
    }

    private ImagePickerDelegate getImagePickerDelegate() {
        ActivityState activityState2 = this.activityState;
        if (activityState2 == null || activityState2.getActivity() == null) {
            return null;
        }
        return this.activityState.getDelegate();
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        if (registrar.activity() != null) {
            Activity activity = registrar.activity();
            new ImagePickerPlugin().setup(registrar.messenger(), (Application) registrar.context().getApplicationContext(), activity, registrar, (ActivityPluginBinding) null);
        }
    }

    private void setCameraDevice(ImagePickerDelegate imagePickerDelegate, Messages.SourceSpecification sourceSpecification) {
        Messages.SourceCamera camera = sourceSpecification.getCamera();
        if (camera != null) {
            imagePickerDelegate.setCameraDevice(AnonymousClass1.$SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceCamera[camera.ordinal()] != 1 ? ImagePickerDelegate.CameraDevice.REAR : ImagePickerDelegate.CameraDevice.FRONT);
        }
    }

    private void setup(BinaryMessenger binaryMessenger, Application application, Activity activity, PluginRegistry.Registrar registrar, ActivityPluginBinding activityPluginBinding) {
        this.activityState = new ActivityState(application, activity, binaryMessenger, this, registrar, activityPluginBinding);
    }

    private void tearDown() {
        ActivityState activityState2 = this.activityState;
        if (activityState2 != null) {
            activityState2.release();
            this.activityState = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final ImagePickerDelegate constructDelegate(Activity activity) {
        return new ImagePickerDelegate(activity, new ImageResizer(activity, new ExifDataCopier()), new ImagePickerCache(activity));
    }

    /* access modifiers changed from: package-private */
    public final ActivityState getActivityState() {
        return this.activityState;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        setup(this.pluginBinding.getBinaryMessenger(), (Application) this.pluginBinding.getApplicationContext(), activityPluginBinding.getActivity(), (PluginRegistry.Registrar) null, activityPluginBinding);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = flutterPluginBinding;
    }

    public void onDetachedFromActivity() {
        tearDown();
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }

    public void pickImages(Messages.SourceSpecification sourceSpecification, Messages.ImageSelectionOptions imageSelectionOptions, Messages.GeneralOptions generalOptions, Messages.Result<List<String>> result) {
        ImagePickerDelegate imagePickerDelegate = getImagePickerDelegate();
        if (imagePickerDelegate == null) {
            result.error(new Messages.FlutterError("no_activity", "image_picker plugin requires a foreground activity.", (Object) null));
            return;
        }
        setCameraDevice(imagePickerDelegate, sourceSpecification);
        if (generalOptions.getAllowMultiple().booleanValue()) {
            imagePickerDelegate.chooseMultiImageFromGallery(imageSelectionOptions, generalOptions.getUsePhotoPicker().booleanValue(), result);
            return;
        }
        int i5 = AnonymousClass1.$SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceType[sourceSpecification.getType().ordinal()];
        if (i5 == 1) {
            imagePickerDelegate.chooseImageFromGallery(imageSelectionOptions, generalOptions.getUsePhotoPicker().booleanValue(), result);
        } else if (i5 == 2) {
            imagePickerDelegate.takeImageWithCamera(imageSelectionOptions, result);
        }
    }

    public void pickMedia(Messages.MediaSelectionOptions mediaSelectionOptions, Messages.GeneralOptions generalOptions, Messages.Result<List<String>> result) {
        ImagePickerDelegate imagePickerDelegate = getImagePickerDelegate();
        if (imagePickerDelegate == null) {
            result.error(new Messages.FlutterError("no_activity", "image_picker plugin requires a foreground activity.", (Object) null));
        } else {
            imagePickerDelegate.chooseMediaFromGallery(mediaSelectionOptions, generalOptions, result);
        }
    }

    public void pickVideos(Messages.SourceSpecification sourceSpecification, Messages.VideoSelectionOptions videoSelectionOptions, Messages.GeneralOptions generalOptions, Messages.Result<List<String>> result) {
        ImagePickerDelegate imagePickerDelegate = getImagePickerDelegate();
        if (imagePickerDelegate == null) {
            result.error(new Messages.FlutterError("no_activity", "image_picker plugin requires a foreground activity.", (Object) null));
            return;
        }
        setCameraDevice(imagePickerDelegate, sourceSpecification);
        if (generalOptions.getAllowMultiple().booleanValue()) {
            result.error(new RuntimeException("Multi-video selection is not implemented"));
            return;
        }
        int i5 = AnonymousClass1.$SwitchMap$io$flutter$plugins$imagepicker$Messages$SourceType[sourceSpecification.getType().ordinal()];
        if (i5 == 1) {
            imagePickerDelegate.chooseVideoFromGallery(videoSelectionOptions, generalOptions.getUsePhotoPicker().booleanValue(), result);
        } else if (i5 == 2) {
            imagePickerDelegate.takeVideoWithCamera(videoSelectionOptions, result);
        }
    }

    public Messages.CacheRetrievalResult retrieveLostResults() {
        ImagePickerDelegate imagePickerDelegate = getImagePickerDelegate();
        if (imagePickerDelegate != null) {
            return imagePickerDelegate.retrieveLostImage();
        }
        throw new Messages.FlutterError("no_activity", "image_picker plugin requires a foreground activity.", (Object) null);
    }
}
