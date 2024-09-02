package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import androidx.activity.result.f;
import androidx.core.app.b;
import androidx.core.content.a;
import androidx.core.content.c;
import c.d;
import com.yalantis.ucrop.BuildConfig;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.imagepicker.Messages;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImagePickerDelegate implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {
    static final int REQUEST_CAMERA_IMAGE_PERMISSION = 2345;
    static final int REQUEST_CAMERA_VIDEO_PERMISSION = 2355;
    static final int REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY = 2342;
    static final int REQUEST_CODE_CHOOSE_MEDIA_FROM_GALLERY = 2347;
    static final int REQUEST_CODE_CHOOSE_MULTI_IMAGE_FROM_GALLERY = 2346;
    static final int REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY = 2352;
    static final int REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA = 2343;
    static final int REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA = 2353;
    private final Activity activity;
    private final ImagePickerCache cache;
    private CameraDevice cameraDevice;
    private final ExecutorService executor;
    final String fileProviderName;
    private final FileUriResolver fileUriResolver;
    private final FileUtils fileUtils;
    private final ImageResizer imageResizer;
    private PendingCallState pendingCallState;
    private final Object pendingCallStateLock;
    private Uri pendingCameraMediaUri;
    private final PermissionManager permissionManager;

    public enum CameraDevice {
        REAR,
        FRONT
    }

    interface FileUriResolver {
        void getFullImagePath(Uri uri, OnPathReadyListener onPathReadyListener);

        Uri resolveFileProviderUriForFile(String str, File file);
    }

    public class MediaPath {
        final String mimeType;
        final String path;

        public MediaPath(String str, String str2) {
            this.path = str;
            this.mimeType = str2;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public String getPath() {
            return this.path;
        }
    }

    interface OnPathReadyListener {
        void onPathReady(String str);
    }

    private static class PendingCallState {
        public final Messages.ImageSelectionOptions imageOptions;
        public final Messages.Result<List<String>> result;
        public final Messages.VideoSelectionOptions videoOptions;

        PendingCallState(Messages.ImageSelectionOptions imageSelectionOptions, Messages.VideoSelectionOptions videoSelectionOptions, Messages.Result<List<String>> result2) {
            this.imageOptions = imageSelectionOptions;
            this.videoOptions = videoSelectionOptions;
            this.result = result2;
        }
    }

    interface PermissionManager {
        void askForPermission(String str, int i5);

        boolean isPermissionGranted(String str);

        boolean needRequestCameraPermission();
    }

    public ImagePickerDelegate(final Activity activity2, ImageResizer imageResizer2, ImagePickerCache imagePickerCache) {
        this(activity2, imageResizer2, (Messages.ImageSelectionOptions) null, (Messages.VideoSelectionOptions) null, (Messages.Result<List<String>>) null, imagePickerCache, new PermissionManager() {
            public void askForPermission(String str, int i5) {
                b.o(activity2, new String[]{str}, i5);
            }

            public boolean isPermissionGranted(String str) {
                return a.a(activity2, str) == 0;
            }

            public boolean needRequestCameraPermission() {
                return ImagePickerUtils.needRequestCameraPermission(activity2);
            }
        }, new FileUriResolver() {
            public void getFullImagePath(Uri uri, OnPathReadyListener onPathReadyListener) {
                Activity activity = activity2;
                String[] strArr = new String[1];
                strArr[0] = uri != null ? uri.getPath() : BuildConfig.FLAVOR;
                MediaScannerConnection.scanFile(activity, strArr, (String[]) null, new i(onPathReadyListener));
            }

            public Uri resolveFileProviderUriForFile(String str, File file) {
                return c.getUriForFile(activity2, str, file);
            }
        }, new FileUtils(), Executors.newSingleThreadExecutor());
    }

    ImagePickerDelegate(Activity activity2, ImageResizer imageResizer2, Messages.ImageSelectionOptions imageSelectionOptions, Messages.VideoSelectionOptions videoSelectionOptions, Messages.Result<List<String>> result, ImagePickerCache imagePickerCache, PermissionManager permissionManager2, FileUriResolver fileUriResolver2, FileUtils fileUtils2, ExecutorService executorService) {
        this.pendingCallStateLock = new Object();
        this.activity = activity2;
        this.imageResizer = imageResizer2;
        this.fileProviderName = activity2.getPackageName() + ".flutter.image_provider";
        if (result != null) {
            this.pendingCallState = new PendingCallState(imageSelectionOptions, videoSelectionOptions, result);
        }
        this.permissionManager = permissionManager2;
        this.fileUriResolver = fileUriResolver2;
        this.fileUtils = fileUtils2;
        this.cache = imagePickerCache;
        this.executor = executorService;
    }

    private File createTemporaryWritableFile(String str) {
        String uuid = UUID.randomUUID().toString();
        File cacheDir = this.activity.getCacheDir();
        try {
            cacheDir.mkdirs();
            return File.createTempFile(uuid, str, cacheDir);
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }

    private File createTemporaryWritableImageFile() {
        return createTemporaryWritableFile(".jpg");
    }

    private File createTemporaryWritableVideoFile() {
        return createTemporaryWritableFile(".mp4");
    }

    private void finishWithAlreadyActiveError(Messages.Result<List<String>> result) {
        result.error(new Messages.FlutterError("already_active", "Image picker is already active", (Object) null));
    }

    private void finishWithError(String str, String str2) {
        Messages.Result<List<String>> result;
        synchronized (this.pendingCallStateLock) {
            PendingCallState pendingCallState2 = this.pendingCallState;
            result = pendingCallState2 != null ? pendingCallState2.result : null;
            this.pendingCallState = null;
        }
        if (result == null) {
            this.cache.saveResult((ArrayList<String>) null, str, str2);
        } else {
            result.error(new Messages.FlutterError(str, str2, (Object) null));
        }
    }

    private void finishWithListSuccess(ArrayList<String> arrayList) {
        Messages.Result<List<String>> result;
        synchronized (this.pendingCallStateLock) {
            PendingCallState pendingCallState2 = this.pendingCallState;
            result = pendingCallState2 != null ? pendingCallState2.result : null;
            this.pendingCallState = null;
        }
        if (result == null) {
            this.cache.saveResult(arrayList, (String) null, (String) null);
        } else {
            result.success(arrayList);
        }
    }

    private void finishWithSuccess(String str) {
        Messages.Result<List<String>> result;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str);
        }
        synchronized (this.pendingCallStateLock) {
            PendingCallState pendingCallState2 = this.pendingCallState;
            result = pendingCallState2 != null ? pendingCallState2.result : null;
            this.pendingCallState = null;
        }
        if (result != null) {
            result.success(arrayList);
        } else if (!arrayList.isEmpty()) {
            this.cache.saveResult(arrayList, (String) null, (String) null);
        }
    }

    private String getResizedImagePath(String str, Messages.ImageSelectionOptions imageSelectionOptions) {
        return this.imageResizer.resizeImageIfNeeded(str, imageSelectionOptions.getMaxWidth(), imageSelectionOptions.getMaxHeight(), imageSelectionOptions.getQuality().intValue());
    }

    private void grantUriPermissions(Intent intent, Uri uri) {
        for (ResolveInfo resolveInfo : this.activity.getPackageManager().queryIntentActivities(intent, 65536)) {
            this.activity.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleCaptureImageResult */
    public void lambda$onActivityResult$2(int i5) {
        if (i5 == -1) {
            Uri uri = this.pendingCameraMediaUri;
            FileUriResolver fileUriResolver2 = this.fileUriResolver;
            if (uri == null) {
                uri = Uri.parse(this.cache.retrievePendingCameraMediaUriPath());
            }
            fileUriResolver2.getFullImagePath(uri, new g(this));
            return;
        }
        finishWithSuccess((String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleCaptureVideoResult */
    public void lambda$onActivityResult$5(int i5) {
        if (i5 == -1) {
            Uri uri = this.pendingCameraMediaUri;
            FileUriResolver fileUriResolver2 = this.fileUriResolver;
            if (uri == null) {
                uri = Uri.parse(this.cache.retrievePendingCameraMediaUriPath());
            }
            fileUriResolver2.getFullImagePath(uri, new h(this));
            return;
        }
        finishWithSuccess((String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleChooseImageResult */
    public void lambda$onActivityResult$0(int i5, Intent intent) {
        ClipData clipData;
        if (i5 != -1 || intent == null) {
            finishWithSuccess((String) null);
            return;
        }
        Uri data = intent.getData();
        if (data == null && (clipData = intent.getClipData()) != null && clipData.getItemCount() == 1) {
            data = clipData.getItemAt(0).getUri();
        }
        if (data == null) {
            finishWithError("no_valid_image_uri", "Cannot find the selected image.");
        } else {
            handleImageResult(this.fileUtils.getPathFromUri(this.activity, data), false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleChooseMediaResult */
    public void lambda$onActivityResult$3(int i5, Intent intent) {
        if (i5 != -1 || intent == null) {
            finishWithSuccess((String) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (intent.getClipData() != null) {
            for (int i6 = 0; i6 < intent.getClipData().getItemCount(); i6++) {
                Uri uri = intent.getClipData().getItemAt(i6).getUri();
                arrayList.add(new MediaPath(this.fileUtils.getPathFromUri(this.activity, uri), this.activity.getContentResolver().getType(uri)));
            }
        } else {
            arrayList.add(new MediaPath(this.fileUtils.getPathFromUri(this.activity, intent.getData()), (String) null));
        }
        handleMediaResult(arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleChooseMultiImageResult */
    public void lambda$onActivityResult$1(int i5, Intent intent) {
        if (i5 != -1 || intent == null) {
            finishWithSuccess((String) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (intent.getClipData() != null) {
            for (int i6 = 0; i6 < intent.getClipData().getItemCount(); i6++) {
                arrayList.add(new MediaPath(this.fileUtils.getPathFromUri(this.activity, intent.getClipData().getItemAt(i6).getUri()), (String) null));
            }
        } else {
            arrayList.add(new MediaPath(this.fileUtils.getPathFromUri(this.activity, intent.getData()), (String) null));
        }
        handleMediaResult(arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleChooseVideoResult */
    public void lambda$onActivityResult$4(int i5, Intent intent) {
        ClipData clipData;
        if (i5 != -1 || intent == null) {
            finishWithSuccess((String) null);
            return;
        }
        Uri data = intent.getData();
        if (data == null && (clipData = intent.getClipData()) != null && clipData.getItemCount() == 1) {
            data = clipData.getItemAt(0).getUri();
        }
        if (data == null) {
            finishWithError("no_valid_video_uri", "Cannot find the selected video.");
        } else {
            handleVideoResult(this.fileUtils.getPathFromUri(this.activity, data));
        }
    }

    private void handleMediaResult(ArrayList<MediaPath> arrayList) {
        Messages.ImageSelectionOptions imageSelectionOptions;
        synchronized (this.pendingCallStateLock) {
            PendingCallState pendingCallState2 = this.pendingCallState;
            imageSelectionOptions = pendingCallState2 != null ? pendingCallState2.imageOptions : null;
        }
        ArrayList arrayList2 = new ArrayList();
        int i5 = 0;
        if (imageSelectionOptions != null) {
            while (i5 < arrayList.size()) {
                MediaPath mediaPath = arrayList.get(i5);
                String str = mediaPath.path;
                String str2 = mediaPath.mimeType;
                if (str2 == null || !str2.startsWith("video/")) {
                    str = getResizedImagePath(mediaPath.path, imageSelectionOptions);
                }
                arrayList2.add(str);
                i5++;
            }
        } else {
            while (i5 < arrayList.size()) {
                arrayList2.add(arrayList.get(i5).path);
                i5++;
            }
        }
        finishWithListSuccess(arrayList2);
    }

    /* access modifiers changed from: private */
    public void handleVideoResult(String str) {
        finishWithSuccess(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$handleCaptureImageResult$6(String str) {
        handleImageResult(str, true);
    }

    private void launchMultiPickImageFromGalleryIntent(Boolean bool) {
        Intent intent;
        if (bool.booleanValue()) {
            intent = new c.c().a(this.activity, new f.a().b(d.c.f3070a).a());
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        this.activity.startActivityForResult(intent, REQUEST_CODE_CHOOSE_MULTI_IMAGE_FROM_GALLERY);
    }

    private void launchPickImageFromGalleryIntent(Boolean bool) {
        Intent intent;
        if (bool.booleanValue()) {
            intent = new d().a(this.activity, new f.a().b(d.c.f3070a).a());
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
        }
        this.activity.startActivityForResult(intent, REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY);
    }

    private void launchPickMediaFromGalleryIntent(Messages.GeneralOptions generalOptions) {
        Intent intent;
        if (generalOptions.getUsePhotoPicker().booleanValue()) {
            intent = generalOptions.getAllowMultiple().booleanValue() ? new c.c().a(this.activity, new f.a().b(d.b.f3069a).a()) : new d().a(this.activity, new f.a().b(d.b.f3069a).a());
        } else {
            Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
            intent2.setType("*/*");
            intent2.putExtra("CONTENT_TYPE", new String[]{"video/*", "image/*"});
            intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", generalOptions.getAllowMultiple());
            intent = intent2;
        }
        this.activity.startActivityForResult(intent, REQUEST_CODE_CHOOSE_MEDIA_FROM_GALLERY);
    }

    private void launchPickVideoFromGalleryIntent(Boolean bool) {
        Intent intent;
        if (bool.booleanValue()) {
            intent = new d().a(this.activity, new f.a().b(d.e.f3072a).a());
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("video/*");
        }
        this.activity.startActivityForResult(intent, REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void launchTakeImageWithCameraIntent() {
        /*
            r4 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.media.action.IMAGE_CAPTURE"
            r0.<init>(r1)
            io.flutter.plugins.imagepicker.ImagePickerDelegate$CameraDevice r1 = r4.cameraDevice
            io.flutter.plugins.imagepicker.ImagePickerDelegate$CameraDevice r2 = io.flutter.plugins.imagepicker.ImagePickerDelegate.CameraDevice.FRONT
            if (r1 != r2) goto L_0x0010
            r4.useFrontCamera(r0)
        L_0x0010:
            java.io.File r1 = r4.createTemporaryWritableImageFile()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "file:"
            r2.append(r3)
            java.lang.String r3 = r1.getAbsolutePath()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.net.Uri r2 = android.net.Uri.parse(r2)
            r4.pendingCameraMediaUri = r2
            io.flutter.plugins.imagepicker.ImagePickerDelegate$FileUriResolver r2 = r4.fileUriResolver
            java.lang.String r3 = r4.fileProviderName
            android.net.Uri r2 = r2.resolveFileProviderUriForFile(r3, r1)
            java.lang.String r3 = "output"
            r0.putExtra(r3, r2)
            r4.grantUriPermissions(r0, r2)
            android.app.Activity r2 = r4.activity     // Catch:{ ActivityNotFoundException -> 0x0047 }
            r3 = 2343(0x927, float:3.283E-42)
            r2.startActivityForResult(r0, r3)     // Catch:{ ActivityNotFoundException -> 0x0047 }
            goto L_0x0056
        L_0x0047:
            r1.delete()     // Catch:{ SecurityException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004f:
            java.lang.String r0 = "no_available_camera"
            java.lang.String r1 = "No cameras available for taking pictures."
            r4.finishWithError(r0, r1)
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.launchTakeImageWithCameraIntent():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0068 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void launchTakeVideoWithCameraIntent() {
        /*
            r4 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.media.action.VIDEO_CAPTURE"
            r0.<init>(r1)
            java.lang.Object r1 = r4.pendingCallStateLock
            monitor-enter(r1)
            io.flutter.plugins.imagepicker.ImagePickerDelegate$PendingCallState r2 = r4.pendingCallState     // Catch:{ all -> 0x0078 }
            if (r2 == 0) goto L_0x0011
            io.flutter.plugins.imagepicker.Messages$VideoSelectionOptions r2 = r2.videoOptions     // Catch:{ all -> 0x0078 }
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            monitor-exit(r1)     // Catch:{ all -> 0x0078 }
            if (r2 == 0) goto L_0x0028
            java.lang.Long r1 = r2.getMaxDurationSeconds()
            if (r1 == 0) goto L_0x0028
            java.lang.Long r1 = r2.getMaxDurationSeconds()
            int r1 = r1.intValue()
            java.lang.String r2 = "android.intent.extra.durationLimit"
            r0.putExtra(r2, r1)
        L_0x0028:
            io.flutter.plugins.imagepicker.ImagePickerDelegate$CameraDevice r1 = r4.cameraDevice
            io.flutter.plugins.imagepicker.ImagePickerDelegate$CameraDevice r2 = io.flutter.plugins.imagepicker.ImagePickerDelegate.CameraDevice.FRONT
            if (r1 != r2) goto L_0x0031
            r4.useFrontCamera(r0)
        L_0x0031:
            java.io.File r1 = r4.createTemporaryWritableVideoFile()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "file:"
            r2.append(r3)
            java.lang.String r3 = r1.getAbsolutePath()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.net.Uri r2 = android.net.Uri.parse(r2)
            r4.pendingCameraMediaUri = r2
            io.flutter.plugins.imagepicker.ImagePickerDelegate$FileUriResolver r2 = r4.fileUriResolver
            java.lang.String r3 = r4.fileProviderName
            android.net.Uri r2 = r2.resolveFileProviderUriForFile(r3, r1)
            java.lang.String r3 = "output"
            r0.putExtra(r3, r2)
            r4.grantUriPermissions(r0, r2)
            android.app.Activity r2 = r4.activity     // Catch:{ ActivityNotFoundException -> 0x0068 }
            r3 = 2353(0x931, float:3.297E-42)
            r2.startActivityForResult(r0, r3)     // Catch:{ ActivityNotFoundException -> 0x0068 }
            goto L_0x0077
        L_0x0068:
            r1.delete()     // Catch:{ SecurityException -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0070:
            java.lang.String r0 = "no_available_camera"
            java.lang.String r1 = "No cameras available for taking pictures."
            r4.finishWithError(r0, r1)
        L_0x0077:
            return
        L_0x0078:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0078 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.launchTakeVideoWithCameraIntent():void");
    }

    private boolean needRequestCameraPermission() {
        PermissionManager permissionManager2 = this.permissionManager;
        if (permissionManager2 == null) {
            return false;
        }
        return permissionManager2.needRequestCameraPermission();
    }

    private boolean setPendingOptionsAndResult(Messages.ImageSelectionOptions imageSelectionOptions, Messages.VideoSelectionOptions videoSelectionOptions, Messages.Result<List<String>> result) {
        synchronized (this.pendingCallStateLock) {
            if (this.pendingCallState != null) {
                return false;
            }
            this.pendingCallState = new PendingCallState(imageSelectionOptions, videoSelectionOptions, result);
            this.cache.clear();
            return true;
        }
    }

    private void useFrontCamera(Intent intent) {
        int i5 = Build.VERSION.SDK_INT;
        intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
        if (i5 >= 26) {
            intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
        }
    }

    public void chooseImageFromGallery(Messages.ImageSelectionOptions imageSelectionOptions, boolean z4, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(imageSelectionOptions, (Messages.VideoSelectionOptions) null, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickImageFromGalleryIntent(Boolean.valueOf(z4));
        }
    }

    public void chooseMediaFromGallery(Messages.MediaSelectionOptions mediaSelectionOptions, Messages.GeneralOptions generalOptions, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(mediaSelectionOptions.getImageSelectionOptions(), (Messages.VideoSelectionOptions) null, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickMediaFromGalleryIntent(generalOptions);
        }
    }

    public void chooseMultiImageFromGallery(Messages.ImageSelectionOptions imageSelectionOptions, boolean z4, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(imageSelectionOptions, (Messages.VideoSelectionOptions) null, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchMultiPickImageFromGalleryIntent(Boolean.valueOf(z4));
        }
    }

    public void chooseVideoFromGallery(Messages.VideoSelectionOptions videoSelectionOptions, boolean z4, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult((Messages.ImageSelectionOptions) null, videoSelectionOptions, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickVideoFromGalleryIntent(Boolean.valueOf(z4));
        }
    }

    /* access modifiers changed from: package-private */
    public void handleImageResult(String str, boolean z4) {
        Messages.ImageSelectionOptions imageSelectionOptions;
        synchronized (this.pendingCallStateLock) {
            PendingCallState pendingCallState2 = this.pendingCallState;
            imageSelectionOptions = pendingCallState2 != null ? pendingCallState2.imageOptions : null;
        }
        if (imageSelectionOptions != null) {
            String resizedImagePath = getResizedImagePath(str, imageSelectionOptions);
            if (resizedImagePath != null && !resizedImagePath.equals(str) && z4) {
                new File(str).delete();
            }
            finishWithSuccess(resizedImagePath);
            return;
        }
        finishWithSuccess(str);
    }

    public boolean onActivityResult(int i5, int i6, Intent intent) {
        Runnable runnable;
        if (i5 == REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY) {
            runnable = new a(this, i6, intent);
        } else if (i5 == REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA) {
            runnable = new c(this, i6);
        } else if (i5 == REQUEST_CODE_CHOOSE_MULTI_IMAGE_FROM_GALLERY) {
            runnable = new b(this, i6, intent);
        } else if (i5 == REQUEST_CODE_CHOOSE_MEDIA_FROM_GALLERY) {
            runnable = new d(this, i6, intent);
        } else if (i5 == REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY) {
            runnable = new e(this, i6, intent);
        } else if (i5 != REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA) {
            return false;
        } else {
            runnable = new f(this, i6);
        }
        this.executor.execute(runnable);
        return true;
    }

    public boolean onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        boolean z4 = iArr.length > 0 && iArr[0] == 0;
        if (i5 != REQUEST_CAMERA_IMAGE_PERMISSION) {
            if (i5 != REQUEST_CAMERA_VIDEO_PERMISSION) {
                return false;
            }
            if (z4) {
                launchTakeVideoWithCameraIntent();
            }
        } else if (z4) {
            launchTakeImageWithCameraIntent();
        }
        if (!z4 && (i5 == REQUEST_CAMERA_IMAGE_PERMISSION || i5 == REQUEST_CAMERA_VIDEO_PERMISSION)) {
            finishWithError("camera_access_denied", "The user did not allow camera access.");
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public Messages.CacheRetrievalResult retrieveLostImage() {
        Map<String, Object> cacheMap = this.cache.getCacheMap();
        if (cacheMap.isEmpty()) {
            return null;
        }
        Messages.CacheRetrievalResult.Builder builder = new Messages.CacheRetrievalResult.Builder();
        Messages.CacheRetrievalType cacheRetrievalType = (Messages.CacheRetrievalType) cacheMap.get("type");
        if (cacheRetrievalType != null) {
            builder.setType(cacheRetrievalType);
        }
        builder.setError((Messages.CacheRetrievalError) cacheMap.get("error"));
        ArrayList arrayList = (ArrayList) cacheMap.get("pathList");
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Double d5 = (Double) cacheMap.get("maxWidth");
                Double d6 = (Double) cacheMap.get("maxHeight");
                Integer num = (Integer) cacheMap.get("imageQuality");
                arrayList2.add(this.imageResizer.resizeImageIfNeeded(str, d5, d6, num == null ? 100 : num.intValue()));
            }
            builder.setPaths(arrayList2);
        }
        this.cache.clear();
        return builder.build();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000e, code lost:
        if (r1 == null) goto L_0x0013;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        r2 = io.flutter.plugins.imagepicker.ImagePickerCache.CacheType.IMAGE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        r2 = io.flutter.plugins.imagepicker.ImagePickerCache.CacheType.VIDEO;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        r0.saveType(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        if (r1 == null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001a, code lost:
        r3.cache.saveDimensionWithOutputOptions(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001f, code lost:
        r0 = r3.pendingCameraMediaUri;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        r3.cache.savePendingCameraMediaUriPath(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        r0 = r3.cache;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveStateBeforeResult() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.pendingCallStateLock
            monitor-enter(r0)
            io.flutter.plugins.imagepicker.ImagePickerDelegate$PendingCallState r1 = r3.pendingCallState     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return
        L_0x0009:
            io.flutter.plugins.imagepicker.Messages$ImageSelectionOptions r1 = r1.imageOptions     // Catch:{ all -> 0x0029 }
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            io.flutter.plugins.imagepicker.ImagePickerCache r0 = r3.cache
            if (r1 == 0) goto L_0x0013
            io.flutter.plugins.imagepicker.ImagePickerCache$CacheType r2 = io.flutter.plugins.imagepicker.ImagePickerCache.CacheType.IMAGE
            goto L_0x0015
        L_0x0013:
            io.flutter.plugins.imagepicker.ImagePickerCache$CacheType r2 = io.flutter.plugins.imagepicker.ImagePickerCache.CacheType.VIDEO
        L_0x0015:
            r0.saveType(r2)
            if (r1 == 0) goto L_0x001f
            io.flutter.plugins.imagepicker.ImagePickerCache r0 = r3.cache
            r0.saveDimensionWithOutputOptions(r1)
        L_0x001f:
            android.net.Uri r0 = r3.pendingCameraMediaUri
            if (r0 == 0) goto L_0x0028
            io.flutter.plugins.imagepicker.ImagePickerCache r1 = r3.cache
            r1.savePendingCameraMediaUriPath(r0)
        L_0x0028:
            return
        L_0x0029:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.saveStateBeforeResult():void");
    }

    /* access modifiers changed from: package-private */
    public void setCameraDevice(CameraDevice cameraDevice2) {
        this.cameraDevice = cameraDevice2;
    }

    public void takeImageWithCamera(Messages.ImageSelectionOptions imageSelectionOptions, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(imageSelectionOptions, (Messages.VideoSelectionOptions) null, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!needRequestCameraPermission() || this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            launchTakeImageWithCameraIntent();
        } else {
            this.permissionManager.askForPermission("android.permission.CAMERA", REQUEST_CAMERA_IMAGE_PERMISSION);
        }
    }

    public void takeVideoWithCamera(Messages.VideoSelectionOptions videoSelectionOptions, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult((Messages.ImageSelectionOptions) null, videoSelectionOptions, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!needRequestCameraPermission() || this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            launchTakeVideoWithCameraIntent();
        } else {
            this.permissionManager.askForPermission("android.permission.CAMERA", REQUEST_CAMERA_VIDEO_PERMISSION);
        }
    }
}
