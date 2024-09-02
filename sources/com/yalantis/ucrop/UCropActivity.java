package com.yalantis.ucrop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.appcompat.app.f;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.a;
import b0.b;
import b0.l;
import b0.n;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.CropImageView;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class UCropActivity extends d {
    public static final int ALL = 3;
    private static final long CONTROLS_ANIMATION_DURATION = 50;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    private static final String TAG = "UCropActivity";
    private int mActiveControlsWidgetColor;
    private int[] mAllowedGestures = {1, 2, 3};
    /* access modifiers changed from: private */
    public View mBlockingView;
    private Bitmap.CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    private int mCompressQuality = 90;
    private l mControlsTransition;
    /* access modifiers changed from: private */
    public List<ViewGroup> mCropAspectRatioViews = new ArrayList();
    /* access modifiers changed from: private */
    public GestureCropImageView mGestureCropImageView;
    private TransformImageView.TransformImageListener mImageListener = new TransformImageView.TransformImageListener() {
        public void onLoadComplete() {
            UCropActivity.this.mUCropView.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.mBlockingView.setClickable(false);
            boolean unused = UCropActivity.this.mShowLoader = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        public void onLoadFailure(Exception exc) {
            UCropActivity.this.setResultError(exc);
            UCropActivity.this.finish();
        }

        public void onRotate(float f5) {
            UCropActivity.this.setAngleText(f5);
        }

        public void onScale(float f5) {
            UCropActivity.this.setScaleText(f5);
        }
    };
    private ViewGroup mLayoutAspectRatio;
    private ViewGroup mLayoutRotate;
    private ViewGroup mLayoutScale;
    private int mLogoColor;
    private OverlayView mOverlayView;
    private int mRootViewBackgroundColor;
    private boolean mShowBottomControls;
    /* access modifiers changed from: private */
    public boolean mShowLoader = true;
    private final View.OnClickListener mStateClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropActivity.this.setWidgetState(view.getId());
            }
        }
    };
    private int mStatusBarColor;
    private TextView mTextViewRotateAngle;
    private TextView mTextViewScalePercent;
    private int mToolbarCancelDrawable;
    private int mToolbarColor;
    private int mToolbarCropDrawable;
    private String mToolbarTitle;
    private int mToolbarWidgetColor;
    /* access modifiers changed from: private */
    public UCropView mUCropView;
    private ViewGroup mWrapperStateAspectRatio;
    private ViewGroup mWrapperStateRotate;
    private ViewGroup mWrapperStateScale;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    static {
        f.B(true);
    }

    private void addBlockingView() {
        if (this.mBlockingView == null) {
            this.mBlockingView = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.mBlockingView.setLayoutParams(layoutParams);
            this.mBlockingView.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
    }

    private void changeSelectedTab(int i5) {
        n.a((ViewGroup) findViewById(R.id.ucrop_photobox), this.mControlsTransition);
        int i6 = 0;
        this.mWrapperStateScale.findViewById(R.id.text_view_scale).setVisibility(i5 == R.id.state_scale ? 0 : 8);
        this.mWrapperStateAspectRatio.findViewById(R.id.text_view_crop).setVisibility(i5 == R.id.state_aspect_ratio ? 0 : 8);
        View findViewById = this.mWrapperStateRotate.findViewById(R.id.text_view_rotate);
        if (i5 != R.id.state_rotate) {
            i6 = 8;
        }
        findViewById.setVisibility(i6);
    }

    private void initiateRootViews() {
        UCropView uCropView = (UCropView) findViewById(R.id.ucrop);
        this.mUCropView = uCropView;
        this.mGestureCropImageView = uCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
        int i5 = R.id.ucrop_frame;
        findViewById(i5).setBackgroundColor(this.mRootViewBackgroundColor);
        if (!this.mShowBottomControls) {
            ((RelativeLayout.LayoutParams) findViewById(i5).getLayoutParams()).bottomMargin = 0;
            findViewById(i5).requestLayout();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0137, code lost:
        if (java.lang.Float.isNaN(r0) != false) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x015d, code lost:
        if (java.lang.Float.isNaN(r0) != false) goto L_0x0161;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processOptions(android.content.Intent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "com.yalantis.ucrop.CompressionFormatName"
            java.lang.String r0 = r8.getStringExtra(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0011
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.valueOf(r0)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0016
            android.graphics.Bitmap$CompressFormat r0 = DEFAULT_COMPRESS_FORMAT
        L_0x0016:
            r7.mCompressFormat = r0
            r0 = 90
            java.lang.String r1 = "com.yalantis.ucrop.CompressionQuality"
            int r0 = r8.getIntExtra(r1, r0)
            r7.mCompressQuality = r0
            java.lang.String r0 = "com.yalantis.ucrop.AllowedGestures"
            int[] r0 = r8.getIntArrayExtra(r0)
            if (r0 == 0) goto L_0x0030
            int r1 = r0.length
            r2 = 3
            if (r1 != r2) goto L_0x0030
            r7.mAllowedGestures = r0
        L_0x0030:
            com.yalantis.ucrop.view.GestureCropImageView r0 = r7.mGestureCropImageView
            java.lang.String r1 = "com.yalantis.ucrop.MaxBitmapSize"
            r2 = 0
            int r1 = r8.getIntExtra(r1, r2)
            r0.setMaxBitmapSize(r1)
            com.yalantis.ucrop.view.GestureCropImageView r0 = r7.mGestureCropImageView
            r1 = 1092616192(0x41200000, float:10.0)
            java.lang.String r3 = "com.yalantis.ucrop.MaxScaleMultiplier"
            float r1 = r8.getFloatExtra(r3, r1)
            r0.setMaxScaleMultiplier(r1)
            com.yalantis.ucrop.view.GestureCropImageView r0 = r7.mGestureCropImageView
            r1 = 500(0x1f4, float:7.0E-43)
            java.lang.String r3 = "com.yalantis.ucrop.ImageToCropBoundsAnimDuration"
            int r1 = r8.getIntExtra(r3, r1)
            long r3 = (long) r1
            r0.setImageToWrapCropBoundsAnimDuration(r3)
            com.yalantis.ucrop.view.OverlayView r0 = r7.mOverlayView
            java.lang.String r1 = "com.yalantis.ucrop.FreeStyleCrop"
            boolean r1 = r8.getBooleanExtra(r1, r2)
            r0.setFreestyleCropEnabled(r1)
            com.yalantis.ucrop.view.OverlayView r0 = r7.mOverlayView
            android.content.res.Resources r1 = r7.getResources()
            int r3 = com.yalantis.ucrop.R.color.ucrop_color_default_dimmed
            int r1 = r1.getColor(r3)
            java.lang.String r3 = "com.yalantis.ucrop.DimmedLayerColor"
            int r1 = r8.getIntExtra(r3, r1)
            r0.setDimmedColor(r1)
            com.yalantis.ucrop.view.OverlayView r0 = r7.mOverlayView
            java.lang.String r1 = "com.yalantis.ucrop.CircleDimmedLayer"
            boolean r1 = r8.getBooleanExtra(r1, r2)
            r0.setCircleDimmedLayer(r1)
            com.yalantis.ucrop.view.OverlayView r0 = r7.mOverlayView
            java.lang.String r1 = "com.yalantis.ucrop.ShowCropFrame"
            r3 = 1
            boolean r1 = r8.getBooleanExtra(r1, r3)
            r0.setShowCropFrame(r1)
            com.yalantis.ucrop.view.OverlayView r0 = r7.mOverlayView
            android.content.res.Resources r1 = r7.getResources()
            int r4 = com.yalantis.ucrop.R.color.ucrop_color_default_crop_frame
            int r1 = r1.getColor(r4)
            java.lang.String r4 = "com.yalantis.ucrop.CropFrameColor"
            int r1 = r8.getIntExtra(r4, r1)
            r0.setCropFrameColor(r1)
            com.yalantis.ucrop.view.OverlayView r0 = r7.mOverlayView
            android.content.res.Resources r1 = r7.getResources()
            int r4 = com.yalantis.ucrop.R.dimen.ucrop_default_crop_frame_stoke_width
            int r1 = r1.getDimensionPixelSize(r4)
            java.lang.String r4 = "com.yalantis.ucrop.CropFrameStrokeWidth"
            int r1 = r8.getIntExtra(r4, r1)
            r0.setCropFrameStrokeWidth(r1)
            com.yalantis.ucrop.view.OverlayView r0 = r7.mOverlayView
            java.lang.String r1 = "com.yalantis.ucrop.ShowCropGrid"
            boolean r1 = r8.getBooleanExtra(r1, r3)
            r0.setShowCropGrid(r1)
            com.yalantis.ucrop.view.OverlayView r0 = r7.mOverlayView
            java.lang.String r1 = "com.yalantis.ucrop.CropGridRowCount"
            r3 = 2
            int r1 = r8.getIntExtra(r1, r3)
            r0.setCropGridRowCount(r1)
            com.yalantis.ucrop.view.OverlayView r0 = r7.mOverlayView
            java.lang.String r1 = "com.yalantis.ucrop.CropGridColumnCount"
            int r1 = r8.getIntExtra(r1, r3)
            r0.setCropGridColumnCount(r1)
            com.yalantis.ucrop.view.OverlayView r0 = r7.mOverlayView
            android.content.res.Resources r1 = r7.getResources()
            int r3 = com.yalantis.ucrop.R.color.ucrop_color_default_crop_grid
            int r1 = r1.getColor(r3)
            java.lang.String r3 = "com.yalantis.ucrop.CropGridColor"
            int r1 = r8.getIntExtra(r3, r1)
            r0.setCropGridColor(r1)
            com.yalantis.ucrop.view.OverlayView r0 = r7.mOverlayView
            android.content.res.Resources r1 = r7.getResources()
            int r3 = com.yalantis.ucrop.R.dimen.ucrop_default_crop_grid_stoke_width
            int r1 = r1.getDimensionPixelSize(r3)
            java.lang.String r3 = "com.yalantis.ucrop.CropGridStrokeWidth"
            int r1 = r8.getIntExtra(r3, r1)
            r0.setCropGridStrokeWidth(r1)
            java.lang.String r0 = "com.yalantis.ucrop.AspectRatioX"
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r0 = r8.getFloatExtra(r0, r1)
            java.lang.String r3 = "com.yalantis.ucrop.AspectRatioY"
            float r1 = r8.getFloatExtra(r3, r1)
            java.lang.String r3 = "com.yalantis.ucrop.AspectRatioSelectedByDefault"
            int r3 = r8.getIntExtra(r3, r2)
            java.lang.String r4 = "com.yalantis.ucrop.AspectRatioOptions"
            java.util.ArrayList r4 = r8.getParcelableArrayListExtra(r4)
            r5 = 0
            int r6 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r6 < 0) goto L_0x013a
            int r6 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r6 < 0) goto L_0x013a
            android.view.ViewGroup r3 = r7.mWrapperStateAspectRatio
            if (r3 == 0) goto L_0x0130
            r4 = 8
            r3.setVisibility(r4)
        L_0x0130:
            float r0 = r0 / r1
            com.yalantis.ucrop.view.GestureCropImageView r1 = r7.mGestureCropImageView
            boolean r3 = java.lang.Float.isNaN(r0)
            if (r3 == 0) goto L_0x0160
            goto L_0x0161
        L_0x013a:
            if (r4 == 0) goto L_0x0165
            int r0 = r4.size()
            if (r3 >= r0) goto L_0x0165
            java.lang.Object r0 = r4.get(r3)
            com.yalantis.ucrop.model.AspectRatio r0 = (com.yalantis.ucrop.model.AspectRatio) r0
            float r0 = r0.getAspectRatioX()
            java.lang.Object r1 = r4.get(r3)
            com.yalantis.ucrop.model.AspectRatio r1 = (com.yalantis.ucrop.model.AspectRatio) r1
            float r1 = r1.getAspectRatioY()
            float r0 = r0 / r1
            com.yalantis.ucrop.view.GestureCropImageView r1 = r7.mGestureCropImageView
            boolean r3 = java.lang.Float.isNaN(r0)
            if (r3 == 0) goto L_0x0160
            goto L_0x0161
        L_0x0160:
            r5 = r0
        L_0x0161:
            r1.setTargetAspectRatio(r5)
            goto L_0x016a
        L_0x0165:
            com.yalantis.ucrop.view.GestureCropImageView r0 = r7.mGestureCropImageView
            r0.setTargetAspectRatio(r5)
        L_0x016a:
            java.lang.String r0 = "com.yalantis.ucrop.MaxSizeX"
            int r0 = r8.getIntExtra(r0, r2)
            java.lang.String r1 = "com.yalantis.ucrop.MaxSizeY"
            int r8 = r8.getIntExtra(r1, r2)
            if (r0 <= 0) goto L_0x0184
            if (r8 <= 0) goto L_0x0184
            com.yalantis.ucrop.view.GestureCropImageView r1 = r7.mGestureCropImageView
            r1.setMaxResultImageSizeX(r0)
            com.yalantis.ucrop.view.GestureCropImageView r0 = r7.mGestureCropImageView
            r0.setMaxResultImageSizeY(r8)
        L_0x0184:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.UCropActivity.processOptions(android.content.Intent):void");
    }

    /* access modifiers changed from: private */
    public void resetRotation() {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    /* access modifiers changed from: private */
    public void rotateByAngle(int i5) {
        this.mGestureCropImageView.postRotate((float) i5);
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    private void setAllowedGestures(int i5) {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        int i6 = this.mAllowedGestures[i5];
        boolean z4 = false;
        gestureCropImageView.setScaleEnabled(i6 == 3 || i6 == 1);
        GestureCropImageView gestureCropImageView2 = this.mGestureCropImageView;
        int i7 = this.mAllowedGestures[i5];
        if (i7 == 3 || i7 == 2) {
            z4 = true;
        }
        gestureCropImageView2.setRotateEnabled(z4);
    }

    /* access modifiers changed from: private */
    public void setAngleText(float f5) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", new Object[]{Float.valueOf(f5)}));
        }
    }

    private void setAngleTextColor(int i5) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setTextColor(i5);
        }
    }

    private void setImageData(Intent intent) {
        Throwable e5;
        Uri uri = (Uri) intent.getParcelableExtra(UCrop.EXTRA_INPUT_URI);
        Uri uri2 = (Uri) intent.getParcelableExtra(UCrop.EXTRA_OUTPUT_URI);
        processOptions(intent);
        if (uri == null || uri2 == null) {
            e5 = new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent));
        } else {
            try {
                this.mGestureCropImageView.setImageUri(uri, uri2);
                return;
            } catch (Exception e6) {
                e5 = e6;
            }
        }
        setResultError(e5);
        finish();
    }

    private void setInitialState() {
        if (this.mShowBottomControls) {
            setWidgetState(this.mWrapperStateAspectRatio.getVisibility() == 0 ? R.id.state_aspect_ratio : R.id.state_scale);
        } else {
            setAllowedGestures(0);
        }
    }

    /* access modifiers changed from: private */
    public void setScaleText(float f5) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf((int) (f5 * 100.0f))}));
        }
    }

    private void setScaleTextColor(int i5) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setTextColor(i5);
        }
    }

    private void setStatusBarColor(int i5) {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i5);
        }
    }

    /* access modifiers changed from: private */
    public void setWidgetState(int i5) {
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = this.mWrapperStateAspectRatio;
            int i6 = R.id.state_aspect_ratio;
            viewGroup.setSelected(i5 == i6);
            ViewGroup viewGroup2 = this.mWrapperStateRotate;
            int i7 = R.id.state_rotate;
            viewGroup2.setSelected(i5 == i7);
            ViewGroup viewGroup3 = this.mWrapperStateScale;
            int i8 = R.id.state_scale;
            viewGroup3.setSelected(i5 == i8);
            int i9 = 8;
            this.mLayoutAspectRatio.setVisibility(i5 == i6 ? 0 : 8);
            this.mLayoutRotate.setVisibility(i5 == i7 ? 0 : 8);
            ViewGroup viewGroup4 = this.mLayoutScale;
            if (i5 == i8) {
                i9 = 0;
            }
            viewGroup4.setVisibility(i9);
            changeSelectedTab(i5);
            if (i5 == i8) {
                setAllowedGestures(0);
            } else if (i5 == i7) {
                setAllowedGestures(1);
            } else {
                setAllowedGestures(2);
            }
        }
    }

    private void setupAppBar() {
        setStatusBarColor(this.mStatusBarColor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.mToolbarColor);
        toolbar.setTitleTextColor(this.mToolbarWidgetColor);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.mToolbarWidgetColor);
        textView.setText(this.mToolbarTitle);
        Drawable mutate = a.c(this, this.mToolbarCancelDrawable).mutate();
        mutate.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(mutate);
        setSupportActionBar(toolbar);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.s(false);
        }
    }

    private void setupAspectRatioWidget(Intent intent) {
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            intExtra = 2;
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio((String) null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.mActiveControlsWidgetColor);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.mCropAspectRatioViews.add(frameLayout);
        }
        this.mCropAspectRatioViews.get(intExtra).setSelected(true);
        for (ViewGroup onClickListener : this.mCropAspectRatioViews) {
            onClickListener.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    UCropActivity.this.mGestureCropImageView.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
                    UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
                    if (!view.isSelected()) {
                        for (ViewGroup viewGroup : UCropActivity.this.mCropAspectRatioViews) {
                            viewGroup.setSelected(viewGroup == view);
                        }
                    }
                }
            });
        }
    }

    private void setupRotateWidget() {
        this.mTextViewRotateAngle = (TextView) findViewById(R.id.text_view_rotate);
        int i5 = R.id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i5)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() {
            public void onScroll(float f5, float f6) {
                UCropActivity.this.mGestureCropImageView.postRotate(f5 / 42.0f);
            }

            public void onScrollEnd() {
                UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            public void onScrollStart() {
                UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) findViewById(i5)).setMiddleLineColor(this.mActiveControlsWidgetColor);
        findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UCropActivity.this.resetRotation();
            }
        });
        findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UCropActivity.this.rotateByAngle(90);
            }
        });
        setAngleTextColor(this.mActiveControlsWidgetColor);
    }

    private void setupScaleWidget() {
        this.mTextViewScalePercent = (TextView) findViewById(R.id.text_view_scale);
        int i5 = R.id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i5)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() {
            public void onScroll(float f5, float f6) {
                if (f5 > CropImageView.DEFAULT_ASPECT_RATIO) {
                    UCropActivity.this.mGestureCropImageView.zoomInImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f5 * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                } else {
                    UCropActivity.this.mGestureCropImageView.zoomOutImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f5 * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                }
            }

            public void onScrollEnd() {
                UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            public void onScrollStart() {
                UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) findViewById(i5)).setMiddleLineColor(this.mActiveControlsWidgetColor);
        setScaleTextColor(this.mActiveControlsWidgetColor);
    }

    private void setupStatesWrapper() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.mActiveControlsWidgetColor));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.mActiveControlsWidgetColor));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.mActiveControlsWidgetColor));
    }

    private void setupViews(Intent intent) {
        this.mStatusBarColor = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, a.b(this, R.color.ucrop_color_statusbar));
        this.mToolbarColor = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, a.b(this, R.color.ucrop_color_toolbar));
        this.mActiveControlsWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, a.b(this, R.color.ucrop_color_active_controls_color));
        this.mToolbarWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, a.b(this, R.color.ucrop_color_toolbar_widget));
        this.mToolbarCancelDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, R.drawable.ucrop_ic_cross);
        this.mToolbarCropDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_DRAWABLE, R.drawable.ucrop_ic_done);
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_TOOLBAR);
        this.mToolbarTitle = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.mToolbarTitle = stringExtra;
        this.mLogoColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_LOGO_COLOR, a.b(this, R.color.ucrop_color_default_logo));
        this.mShowBottomControls = !intent.getBooleanExtra(UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, false);
        this.mRootViewBackgroundColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, a.b(this, R.color.ucrop_color_crop_background));
        setupAppBar();
        initiateRootViews();
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            LayoutInflater.from(this).inflate(R.layout.ucrop_controls, viewGroup, true);
            b bVar = new b();
            this.mControlsTransition = bVar;
            bVar.V(CONTROLS_ANIMATION_DURATION);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.mWrapperStateAspectRatio = viewGroup2;
            viewGroup2.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.state_rotate);
            this.mWrapperStateRotate = viewGroup3;
            viewGroup3.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R.id.state_scale);
            this.mWrapperStateScale = viewGroup4;
            viewGroup4.setOnClickListener(this.mStateClickListener);
            this.mLayoutAspectRatio = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.mLayoutRotate = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.mLayoutScale = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            setupAspectRatioWidget(intent);
            setupRotateWidget();
            setupScaleWidget();
            setupStatesWrapper();
        }
    }

    /* access modifiers changed from: protected */
    public void cropAndSaveImage() {
        this.mBlockingView.setClickable(true);
        this.mShowLoader = true;
        supportInvalidateOptionsMenu();
        this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback() {
            public void onBitmapCropped(Uri uri, int i5, int i6, int i7, int i8) {
                UCropActivity uCropActivity = UCropActivity.this;
                uCropActivity.setResultUri(uri, uCropActivity.mGestureCropImageView.getTargetAspectRatio(), i5, i6, i7, i8);
                UCropActivity.this.finish();
            }

            public void onCropFailure(Throwable th) {
                UCropActivity.this.setResultError(th);
                UCropActivity.this.finish();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ucrop_activity_photobox);
        Intent intent = getIntent();
        setupViews(intent);
        setImageData(intent);
        setInitialState();
        addBlockingView();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(R.id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (IllegalStateException e5) {
                Log.i(TAG, String.format("%s - %s", new Object[]{e5.getMessage(), getString(R.string.ucrop_mutate_exception_hint)}));
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R.id.menu_crop);
        Drawable c5 = a.c(this, this.mToolbarCropDrawable);
        if (c5 != null) {
            c5.mutate();
            c5.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
            findItem2.setIcon(c5);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            cropAndSaveImage();
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            onBackPressed();
            return true;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.mShowLoader);
        menu.findItem(R.id.menu_loader).setVisible(this.mShowLoader);
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        if (gestureCropImageView != null) {
            gestureCropImageView.cancelAllAnimations();
        }
    }

    /* access modifiers changed from: protected */
    public void setResultError(Throwable th) {
        setResult(96, new Intent().putExtra(UCrop.EXTRA_ERROR, th));
    }

    /* access modifiers changed from: protected */
    public void setResultUri(Uri uri, float f5, int i5, int i6, int i7, int i8) {
        setResult(-1, new Intent().putExtra(UCrop.EXTRA_OUTPUT_URI, uri).putExtra(UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, f5).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, i7).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, i8).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, i5).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, i6));
    }
}
