package com.google.protobuf;

import com.yalantis.ucrop.BuildConfig;
import com.yalantis.ucrop.view.CropImageView;

public enum d0 {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, BuildConfig.FLAVOR),
    BYTE_STRING(i.class, i.class, i.f3533f),
    ENUM(r1, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f3491e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f3492f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f3493g;

    private d0(Class<?> cls, Class<?> cls2, Object obj) {
        this.f3491e = cls;
        this.f3492f = cls2;
        this.f3493g = obj;
    }

    public Class<?> c() {
        return this.f3492f;
    }
}
