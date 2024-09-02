package com.signify.hue.flutterreactiveble.channelhandlers;

import android.os.ParcelUuid;
import com.signify.hue.flutterreactiveble.model.ScanMode;
import java.util.List;
import kotlin.jvm.internal.k;

final class ScanParameters {
    private final List<ParcelUuid> filter;
    private final boolean locationServiceIsMandatory;
    private final ScanMode mode;

    public ScanParameters(List<ParcelUuid> list, ScanMode scanMode, boolean z4) {
        k.e(list, "filter");
        k.e(scanMode, "mode");
        this.filter = list;
        this.mode = scanMode;
        this.locationServiceIsMandatory = z4;
    }

    public static /* synthetic */ ScanParameters copy$default(ScanParameters scanParameters, List<ParcelUuid> list, ScanMode scanMode, boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = scanParameters.filter;
        }
        if ((i5 & 2) != 0) {
            scanMode = scanParameters.mode;
        }
        if ((i5 & 4) != 0) {
            z4 = scanParameters.locationServiceIsMandatory;
        }
        return scanParameters.copy(list, scanMode, z4);
    }

    public final List<ParcelUuid> component1() {
        return this.filter;
    }

    public final ScanMode component2() {
        return this.mode;
    }

    public final boolean component3() {
        return this.locationServiceIsMandatory;
    }

    public final ScanParameters copy(List<ParcelUuid> list, ScanMode scanMode, boolean z4) {
        k.e(list, "filter");
        k.e(scanMode, "mode");
        return new ScanParameters(list, scanMode, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScanParameters)) {
            return false;
        }
        ScanParameters scanParameters = (ScanParameters) obj;
        return k.a(this.filter, scanParameters.filter) && this.mode == scanParameters.mode && this.locationServiceIsMandatory == scanParameters.locationServiceIsMandatory;
    }

    public final List<ParcelUuid> getFilter() {
        return this.filter;
    }

    public final boolean getLocationServiceIsMandatory() {
        return this.locationServiceIsMandatory;
    }

    public final ScanMode getMode() {
        return this.mode;
    }

    public int hashCode() {
        int hashCode = ((this.filter.hashCode() * 31) + this.mode.hashCode()) * 31;
        boolean z4 = this.locationServiceIsMandatory;
        if (z4) {
            z4 = true;
        }
        return hashCode + (z4 ? 1 : 0);
    }

    public String toString() {
        return "ScanParameters(filter=" + this.filter + ", mode=" + this.mode + ", locationServiceIsMandatory=" + this.locationServiceIsMandatory + ')';
    }
}
