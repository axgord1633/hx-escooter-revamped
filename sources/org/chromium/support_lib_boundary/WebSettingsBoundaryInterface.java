package org.chromium.support_lib_boundary;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface WebSettingsBoundaryInterface {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ForceDarkBehavior {
        public static final int FORCE_DARK_ONLY = 0;
        public static final int MEDIA_QUERY_ONLY = 1;
        public static final int PREFER_MEDIA_QUERY_OVER_FORCE_DARK = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestedWithHeaderMode {
        public static final int APP_PACKAGE_NAME = 1;
        public static final int NO_HEADER = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface WebAuthnSupport {
        public static final int APP = 1;
        public static final int BROWSER = 2;
        public static final int NONE = 0;
    }

    int getDisabledActionModeMenuItems();

    boolean getEnterpriseAuthenticationAppLinkPolicyEnabled();

    int getForceDark();

    int getForceDarkBehavior();

    boolean getOffscreenPreRaster();

    int getRequestedWithHeaderMode();

    boolean getSafeBrowsingEnabled();

    int getWebAuthnSupport();

    boolean getWillSuppressErrorPage();

    boolean isAlgorithmicDarkeningAllowed();

    void setAlgorithmicDarkeningAllowed(boolean z4);

    void setDisabledActionModeMenuItems(int i5);

    void setEnterpriseAuthenticationAppLinkPolicyEnabled(boolean z4);

    void setForceDark(int i5);

    void setForceDarkBehavior(int i5);

    void setOffscreenPreRaster(boolean z4);

    void setRequestedWithHeaderMode(int i5);

    void setSafeBrowsingEnabled(boolean z4);

    void setWebAuthnSupport(int i5);

    void setWillSuppressErrorPage(boolean z4);
}
