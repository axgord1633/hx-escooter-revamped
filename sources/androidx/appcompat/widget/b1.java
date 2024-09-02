package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

class b1 extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1150a;

    public b1(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1150a = resources;
    }

    public XmlResourceParser getAnimation(int i5) {
        return this.f1150a.getAnimation(i5);
    }

    public boolean getBoolean(int i5) {
        return this.f1150a.getBoolean(i5);
    }

    public int getColor(int i5) {
        return this.f1150a.getColor(i5);
    }

    public ColorStateList getColorStateList(int i5) {
        return this.f1150a.getColorStateList(i5);
    }

    public Configuration getConfiguration() {
        return this.f1150a.getConfiguration();
    }

    public float getDimension(int i5) {
        return this.f1150a.getDimension(i5);
    }

    public int getDimensionPixelOffset(int i5) {
        return this.f1150a.getDimensionPixelOffset(i5);
    }

    public int getDimensionPixelSize(int i5) {
        return this.f1150a.getDimensionPixelSize(i5);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f1150a.getDisplayMetrics();
    }

    public Drawable getDrawable(int i5) {
        return this.f1150a.getDrawable(i5);
    }

    public Drawable getDrawable(int i5, Resources.Theme theme) {
        return this.f1150a.getDrawable(i5, theme);
    }

    public Drawable getDrawableForDensity(int i5, int i6) {
        return this.f1150a.getDrawableForDensity(i5, i6);
    }

    public Drawable getDrawableForDensity(int i5, int i6, Resources.Theme theme) {
        return this.f1150a.getDrawableForDensity(i5, i6, theme);
    }

    public float getFraction(int i5, int i6, int i7) {
        return this.f1150a.getFraction(i5, i6, i7);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f1150a.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i5) {
        return this.f1150a.getIntArray(i5);
    }

    public int getInteger(int i5) {
        return this.f1150a.getInteger(i5);
    }

    public XmlResourceParser getLayout(int i5) {
        return this.f1150a.getLayout(i5);
    }

    public Movie getMovie(int i5) {
        return this.f1150a.getMovie(i5);
    }

    public String getQuantityString(int i5, int i6) {
        return this.f1150a.getQuantityString(i5, i6);
    }

    public String getQuantityString(int i5, int i6, Object... objArr) {
        return this.f1150a.getQuantityString(i5, i6, objArr);
    }

    public CharSequence getQuantityText(int i5, int i6) {
        return this.f1150a.getQuantityText(i5, i6);
    }

    public String getResourceEntryName(int i5) {
        return this.f1150a.getResourceEntryName(i5);
    }

    public String getResourceName(int i5) {
        return this.f1150a.getResourceName(i5);
    }

    public String getResourcePackageName(int i5) {
        return this.f1150a.getResourcePackageName(i5);
    }

    public String getResourceTypeName(int i5) {
        return this.f1150a.getResourceTypeName(i5);
    }

    public String getString(int i5) {
        return this.f1150a.getString(i5);
    }

    public String getString(int i5, Object... objArr) {
        return this.f1150a.getString(i5, objArr);
    }

    public String[] getStringArray(int i5) {
        return this.f1150a.getStringArray(i5);
    }

    public CharSequence getText(int i5) {
        return this.f1150a.getText(i5);
    }

    public CharSequence getText(int i5, CharSequence charSequence) {
        return this.f1150a.getText(i5, charSequence);
    }

    public CharSequence[] getTextArray(int i5) {
        return this.f1150a.getTextArray(i5);
    }

    public void getValue(int i5, TypedValue typedValue, boolean z4) {
        this.f1150a.getValue(i5, typedValue, z4);
    }

    public void getValue(String str, TypedValue typedValue, boolean z4) {
        this.f1150a.getValue(str, typedValue, z4);
    }

    public void getValueForDensity(int i5, int i6, TypedValue typedValue, boolean z4) {
        this.f1150a.getValueForDensity(i5, i6, typedValue, z4);
    }

    public XmlResourceParser getXml(int i5) {
        return this.f1150a.getXml(i5);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f1150a.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i5) {
        return this.f1150a.obtainTypedArray(i5);
    }

    public InputStream openRawResource(int i5) {
        return this.f1150a.openRawResource(i5);
    }

    public InputStream openRawResource(int i5, TypedValue typedValue) {
        return this.f1150a.openRawResource(i5, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i5) {
        return this.f1150a.openRawResourceFd(i5);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.f1150a.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.f1150a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f1150a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }
}
