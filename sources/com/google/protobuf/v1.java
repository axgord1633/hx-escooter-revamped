package com.google.protobuf;

import com.yalantis.ucrop.BuildConfig;
import com.yalantis.ucrop.view.CropImageView;

public final class v1 {

    /* renamed from: a  reason: collision with root package name */
    static final int f3718a = c(1, 3);

    /* renamed from: b  reason: collision with root package name */
    static final int f3719b = c(1, 4);

    /* renamed from: c  reason: collision with root package name */
    static final int f3720c = c(2, 0);

    /* renamed from: d  reason: collision with root package name */
    static final int f3721d = c(3, 2);

    public enum b {
        DOUBLE(c.DOUBLE, 1),
        FLOAT(c.FLOAT, 5),
        INT64(r5, 0),
        UINT64(r5, 0),
        INT32(r11, 0),
        FIXED64(r5, 1),
        FIXED32(r11, 5),
        BOOL(c.BOOLEAN, 0),
        STRING(c.STRING, 2) {
        },
        GROUP(r13, 3) {
        },
        MESSAGE(r13, 2) {
        },
        BYTES(c.BYTE_STRING, 2) {
        },
        UINT32(r11, 0),
        ENUM(c.ENUM, 0),
        SFIXED32(r11, 5),
        SFIXED64(r5, 1),
        SINT32(r11, 0),
        SINT64(r5, 0);
        

        /* renamed from: e  reason: collision with root package name */
        private final c f3741e;

        /* renamed from: f  reason: collision with root package name */
        private final int f3742f;

        private b(c cVar, int i5) {
            this.f3741e = cVar;
            this.f3742f = i5;
        }

        public c c() {
            return this.f3741e;
        }
    }

    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(BuildConfig.FLAVOR),
        BYTE_STRING(i.f3533f),
        ENUM((String) null),
        MESSAGE((String) null);
        

        /* renamed from: e  reason: collision with root package name */
        private final Object f3753e;

        private c(Object obj) {
            this.f3753e = obj;
        }
    }

    public static int a(int i5) {
        return i5 >>> 3;
    }

    public static int b(int i5) {
        return i5 & 7;
    }

    static int c(int i5, int i6) {
        return (i5 << 3) | i6;
    }
}
