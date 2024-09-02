package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AspectRatio implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new Parcelable.Creator<AspectRatio>() {
        public AspectRatio createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        public AspectRatio[] newArray(int i5) {
            return new AspectRatio[i5];
        }
    };
    private final String mAspectRatioTitle;
    private final float mAspectRatioX;
    private final float mAspectRatioY;

    protected AspectRatio(Parcel parcel) {
        this.mAspectRatioTitle = parcel.readString();
        this.mAspectRatioX = parcel.readFloat();
        this.mAspectRatioY = parcel.readFloat();
    }

    public AspectRatio(String str, float f5, float f6) {
        this.mAspectRatioTitle = str;
        this.mAspectRatioX = f5;
        this.mAspectRatioY = f6;
    }

    public int describeContents() {
        return 0;
    }

    public String getAspectRatioTitle() {
        return this.mAspectRatioTitle;
    }

    public float getAspectRatioX() {
        return this.mAspectRatioX;
    }

    public float getAspectRatioY() {
        return this.mAspectRatioY;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.mAspectRatioTitle);
        parcel.writeFloat(this.mAspectRatioX);
        parcel.writeFloat(this.mAspectRatioY);
    }
}
