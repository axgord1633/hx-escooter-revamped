package v4;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.preference.PreferenceManager;
import com.yalantis.ucrop.BuildConfig;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.view.CropImageView;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class b implements PluginRegistry.ActivityResultListener {

    /* renamed from: e  reason: collision with root package name */
    private final Activity f7276e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedPreferences f7277f;

    /* renamed from: g  reason: collision with root package name */
    private MethodChannel.Result f7278g;

    /* renamed from: h  reason: collision with root package name */
    private a f7279h = new a();

    public b(Activity activity) {
        this.f7276e = activity;
        this.f7277f = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
    }

    private void a(String str) {
        SharedPreferences.Editor edit = this.f7277f.edit();
        edit.putString("imagecropper.FILENAME_CACHE_KEY", str);
        edit.apply();
    }

    private void b() {
        this.f7278g = null;
    }

    private int c(int i5) {
        float[] fArr = new float[3];
        Color.colorToHSV(i5, fArr);
        fArr[2] = fArr[2] * 0.8f;
        return Color.HSVToColor(fArr);
    }

    private void d(String str, String str2, Throwable th) {
        MethodChannel.Result result = this.f7278g;
        if (result != null) {
            result.error(str, str2, th);
            b();
        }
    }

    private void e(String str) {
        MethodChannel.Result result = this.f7278g;
        if (result != null) {
            result.success(str);
            b();
        }
    }

    private String f() {
        if (!this.f7277f.contains("imagecropper.FILENAME_CACHE_KEY")) {
            return null;
        }
        String string = this.f7277f.getString("imagecropper.FILENAME_CACHE_KEY", BuildConfig.FLAVOR);
        SharedPreferences.Editor edit = this.f7277f.edit();
        edit.remove("imagecropper.FILENAME_CACHE_KEY");
        edit.apply();
        return string;
    }

    private AspectRatio g(String str) {
        return "square".equals(str) ? new AspectRatio((String) null, 1.0f, 1.0f) : "original".equals(str) ? new AspectRatio(this.f7276e.getString(R.string.ucrop_label_original).toUpperCase(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) : "3x2".equals(str) ? new AspectRatio((String) null, 3.0f, 2.0f) : "4x3".equals(str) ? new AspectRatio((String) null, 4.0f, 3.0f) : "5x3".equals(str) ? new AspectRatio((String) null, 5.0f, 3.0f) : "5x4".equals(str) ? new AspectRatio((String) null, 5.0f, 4.0f) : "7x5".equals(str) ? new AspectRatio((String) null, 7.0f, 5.0f) : "16x9".equals(str) ? new AspectRatio((String) null, 16.0f, 9.0f) : new AspectRatio(this.f7276e.getString(R.string.ucrop_label_original).toUpperCase(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.yalantis.ucrop.UCrop.Options i(com.yalantis.ucrop.UCrop.Options r19, io.flutter.plugin.common.MethodCall r20) {
        /*
            r18 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "android.toolbar_title"
            java.lang.Object r2 = r1.argument(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "android.toolbar_color"
            java.lang.Object r3 = r1.argument(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            java.lang.String r4 = "android.statusbar_color"
            java.lang.Object r4 = r1.argument(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.String r5 = "android.toolbar_widget_color"
            java.lang.Object r5 = r1.argument(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.String r6 = "android.background_color"
            java.lang.Object r6 = r1.argument(r6)
            java.lang.Integer r6 = (java.lang.Integer) r6
            java.lang.String r7 = "android.active_controls_widget_color"
            java.lang.Object r7 = r1.argument(r7)
            java.lang.Integer r7 = (java.lang.Integer) r7
            java.lang.String r8 = "android.dimmed_layer_color"
            java.lang.Object r8 = r1.argument(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            java.lang.String r9 = "android.crop_frame_color"
            java.lang.Object r9 = r1.argument(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.String r10 = "android.crop_grid_color"
            java.lang.Object r10 = r1.argument(r10)
            java.lang.Integer r10 = (java.lang.Integer) r10
            java.lang.String r11 = "android.crop_frame_stroke_width"
            java.lang.Object r11 = r1.argument(r11)
            java.lang.Integer r11 = (java.lang.Integer) r11
            java.lang.String r12 = "android.crop_grid_row_count"
            java.lang.Object r12 = r1.argument(r12)
            java.lang.Integer r12 = (java.lang.Integer) r12
            java.lang.String r13 = "android.crop_grid_column_count"
            java.lang.Object r13 = r1.argument(r13)
            java.lang.Integer r13 = (java.lang.Integer) r13
            java.lang.String r14 = "android.crop_grid_stroke_width"
            java.lang.Object r14 = r1.argument(r14)
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.String r15 = "android.show_crop_grid"
            java.lang.Object r15 = r1.argument(r15)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            r16 = r15
            java.lang.String r15 = "android.lock_aspect_ratio"
            java.lang.Object r15 = r1.argument(r15)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            r17 = r15
            java.lang.String r15 = "android.hide_bottom_controls"
            java.lang.Object r1 = r1.argument(r15)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            if (r2 == 0) goto L_0x008d
            r0.setToolbarTitle(r2)
        L_0x008d:
            if (r3 == 0) goto L_0x0096
            int r2 = r3.intValue()
            r0.setToolbarColor(r2)
        L_0x0096:
            if (r4 == 0) goto L_0x00a0
            int r2 = r4.intValue()
            r0.setStatusBarColor(r2)
            goto L_0x00b0
        L_0x00a0:
            if (r3 == 0) goto L_0x00b0
            int r2 = r3.intValue()
            r3 = r18
            int r2 = r3.c(r2)
            r0.setStatusBarColor(r2)
            goto L_0x00b2
        L_0x00b0:
            r3 = r18
        L_0x00b2:
            if (r5 == 0) goto L_0x00bb
            int r2 = r5.intValue()
            r0.setToolbarWidgetColor(r2)
        L_0x00bb:
            if (r6 == 0) goto L_0x00c4
            int r2 = r6.intValue()
            r0.setRootViewBackgroundColor(r2)
        L_0x00c4:
            if (r7 == 0) goto L_0x00cd
            int r2 = r7.intValue()
            r0.setActiveControlsWidgetColor(r2)
        L_0x00cd:
            if (r8 == 0) goto L_0x00d6
            int r2 = r8.intValue()
            r0.setDimmedLayerColor(r2)
        L_0x00d6:
            if (r9 == 0) goto L_0x00df
            int r2 = r9.intValue()
            r0.setCropFrameColor(r2)
        L_0x00df:
            if (r10 == 0) goto L_0x00e8
            int r2 = r10.intValue()
            r0.setCropGridColor(r2)
        L_0x00e8:
            if (r11 == 0) goto L_0x00f1
            int r2 = r11.intValue()
            r0.setCropFrameStrokeWidth(r2)
        L_0x00f1:
            if (r12 == 0) goto L_0x00fa
            int r2 = r12.intValue()
            r0.setCropGridRowCount(r2)
        L_0x00fa:
            if (r13 == 0) goto L_0x0103
            int r2 = r13.intValue()
            r0.setCropGridColumnCount(r2)
        L_0x0103:
            if (r14 == 0) goto L_0x010c
            int r2 = r14.intValue()
            r0.setCropGridStrokeWidth(r2)
        L_0x010c:
            if (r16 == 0) goto L_0x0115
            boolean r2 = r16.booleanValue()
            r0.setShowCropGrid(r2)
        L_0x0115:
            if (r17 == 0) goto L_0x0120
            boolean r2 = r17.booleanValue()
            r2 = r2 ^ 1
            r0.setFreeStyleCropEnabled(r2)
        L_0x0120:
            if (r1 == 0) goto L_0x0129
            boolean r1 = r1.booleanValue()
            r0.setHideBottomControls(r1)
        L_0x0129:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.b.i(com.yalantis.ucrop.UCrop$Options, io.flutter.plugin.common.MethodCall):com.yalantis.ucrop.UCrop$Options");
    }

    public void h(MethodCall methodCall, MethodChannel.Result result) {
        result.success(f());
    }

    public void j(MethodCall methodCall, MethodChannel.Result result) {
        Double d5;
        Integer num;
        Double d6;
        File file;
        MethodCall methodCall2 = methodCall;
        String str = (String) methodCall2.argument("source_path");
        Integer num2 = (Integer) methodCall2.argument("max_width");
        Integer num3 = (Integer) methodCall2.argument("max_height");
        Double d7 = (Double) methodCall2.argument("ratio_x");
        Double d8 = (Double) methodCall2.argument("ratio_y");
        String str2 = (String) methodCall2.argument("crop_style");
        String str3 = (String) methodCall2.argument("compress_format");
        Integer num4 = (Integer) methodCall2.argument("compress_quality");
        ArrayList arrayList = (ArrayList) methodCall2.argument("aspect_ratio_presets");
        String str4 = (String) methodCall2.argument("android.init_aspect_ratio");
        this.f7278g = result;
        File cacheDir = this.f7276e.getCacheDir();
        if ("png".equals(str3)) {
            d6 = d8;
            StringBuilder sb = new StringBuilder();
            sb.append("image_cropper_");
            num = num3;
            d5 = d7;
            sb.append(new Date().getTime());
            sb.append(".png");
            file = new File(cacheDir, sb.toString());
        } else {
            num = num3;
            d5 = d7;
            d6 = d8;
            file = new File(cacheDir, "image_cropper_" + new Date().getTime() + ".jpg");
        }
        Uri fromFile = Uri.fromFile(new File(str));
        Uri fromFile2 = Uri.fromFile(file);
        UCrop.Options options = new UCrop.Options();
        options.setCompressionFormat("png".equals(str3) ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG);
        options.setCompressionQuality(num4 != null ? num4.intValue() : 90);
        if ("circle".equals(str2)) {
            options.setCircleDimmedLayer(true);
        }
        i(options, methodCall2);
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            int i5 = 0;
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                String str5 = (String) arrayList.get(i6);
                if (str5 != null) {
                    arrayList2.add(g(str5));
                    if (str5.equals(str4)) {
                        i5 = i6;
                    }
                }
            }
            options.setAspectRatioOptions(i5, (AspectRatio[]) arrayList2.toArray(new AspectRatio[0]));
        }
        UCrop withOptions = UCrop.of(fromFile, fromFile2).withOptions(options);
        if (!(num2 == null || num == null)) {
            withOptions.withMaxResultSize(num2.intValue(), num.intValue());
        }
        if (!(d5 == null || d6 == null)) {
            withOptions.withAspectRatio(d5.floatValue(), d6.floatValue());
        }
        Activity activity = this.f7276e;
        activity.startActivityForResult(withOptions.getIntent(activity), 69);
    }

    public boolean onActivityResult(int i5, int i6, Intent intent) {
        if (i5 != 69) {
            return false;
        }
        if (i6 == -1) {
            String e5 = this.f7279h.e(this.f7276e, UCrop.getOutput(intent));
            a(e5);
            e(e5);
            return true;
        } else if (i6 == 96) {
            Throwable error = UCrop.getError(intent);
            d("crop_error", error.getLocalizedMessage(), error);
            return true;
        } else {
            MethodChannel.Result result = this.f7278g;
            if (result == null) {
                return false;
            }
            result.success((Object) null);
            b();
            return true;
        }
    }
}
