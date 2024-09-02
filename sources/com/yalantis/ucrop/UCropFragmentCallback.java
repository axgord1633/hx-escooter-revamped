package com.yalantis.ucrop;

import com.yalantis.ucrop.UCropFragment;

public interface UCropFragmentCallback {
    void loadingProgress(boolean z4);

    void onCropFinish(UCropFragment.UCropResult uCropResult);
}
