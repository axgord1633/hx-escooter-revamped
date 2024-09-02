package com.yalantis.ucrop.model;

public class ExifInfo {
    private int mExifDegrees;
    private int mExifOrientation;
    private int mExifTranslation;

    public ExifInfo(int i5, int i6, int i7) {
        this.mExifOrientation = i5;
        this.mExifDegrees = i6;
        this.mExifTranslation = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExifInfo exifInfo = (ExifInfo) obj;
        if (this.mExifOrientation == exifInfo.mExifOrientation && this.mExifDegrees == exifInfo.mExifDegrees) {
            return this.mExifTranslation == exifInfo.mExifTranslation;
        }
        return false;
    }

    public int getExifDegrees() {
        return this.mExifDegrees;
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public int getExifTranslation() {
        return this.mExifTranslation;
    }

    public int hashCode() {
        return (((this.mExifOrientation * 31) + this.mExifDegrees) * 31) + this.mExifTranslation;
    }

    public void setExifDegrees(int i5) {
        this.mExifDegrees = i5;
    }

    public void setExifOrientation(int i5) {
        this.mExifOrientation = i5;
    }

    public void setExifTranslation(int i5) {
        this.mExifTranslation = i5;
    }
}
