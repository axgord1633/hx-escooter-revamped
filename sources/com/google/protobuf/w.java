package com.google.protobuf;

import java.lang.reflect.Type;

public enum w {
    DOUBLE(0, r4, r8),
    FLOAT(1, r4, r10),
    INT64(2, r4, r5),
    UINT64(3, r4, r5),
    INT32(4, r4, r15),
    FIXED64(5, r4, r12),
    FIXED32(6, r4, r15),
    BOOL(7, r4, r19),
    STRING(8, r4, r21),
    MESSAGE(9, r4, r23),
    BYTES(10, r4, r25),
    UINT32(11, r4, r15),
    ENUM(12, r4, r28),
    SFIXED32(13, r4, r15),
    SFIXED64(14, r4, r12),
    SINT32(15, r4, r15),
    SINT64(16, r4, r12),
    GROUP(17, r4, r23),
    DOUBLE_LIST(18, r4, r8),
    FLOAT_LIST(19, r4, r10),
    INT64_LIST(20, r4, r5),
    UINT64_LIST(21, r4, r5),
    INT32_LIST(22, r4, r15),
    FIXED64_LIST(23, r4, r12),
    FIXED32_LIST(24, r4, r15),
    BOOL_LIST(25, r4, r19),
    STRING_LIST(26, r4, r21),
    MESSAGE_LIST(27, r4, r23),
    BYTES_LIST(28, r4, r25),
    UINT32_LIST(29, r4, r15),
    ENUM_LIST(30, r4, r28),
    SFIXED32_LIST(31, r4, r15),
    SFIXED64_LIST(32, r4, r12),
    SINT32_LIST(33, r4, r15),
    SINT64_LIST(34, r4, r12),
    DOUBLE_LIST_PACKED(35, r4, r8),
    FLOAT_LIST_PACKED(36, r4, r10),
    INT64_LIST_PACKED(37, r4, r5),
    UINT64_LIST_PACKED(38, r4, r5),
    INT32_LIST_PACKED(39, r4, r15),
    FIXED64_LIST_PACKED(40, r4, r12),
    FIXED32_LIST_PACKED(41, r4, r15),
    BOOL_LIST_PACKED(42, r4, r19),
    UINT32_LIST_PACKED(43, r4, r15),
    ENUM_LIST_PACKED(44, r4, r28),
    SFIXED32_LIST_PACKED(45, r4, r15),
    SFIXED64_LIST_PACKED(46, r4, r12),
    SINT32_LIST_PACKED(47, r4, r15),
    SINT64_LIST_PACKED(48, r4, r12),
    GROUP_LIST(49, r34, r23),
    MAP(50, b.MAP, d0.VOID);
    

    /* renamed from: i0  reason: collision with root package name */
    private static final w[] f3762i0 = null;

    /* renamed from: j0  reason: collision with root package name */
    private static final Type[] f3764j0 = null;

    /* renamed from: e  reason: collision with root package name */
    private final d0 f3782e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3783f;

    /* renamed from: g  reason: collision with root package name */
    private final b f3784g;

    /* renamed from: h  reason: collision with root package name */
    private final Class<?> f3785h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f3786i;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3787a = null;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3788b = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.google.protobuf.d0[] r0 = com.google.protobuf.d0.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3788b = r0
                r1 = 1
                com.google.protobuf.d0 r2 = com.google.protobuf.d0.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f3788b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.d0 r3 = com.google.protobuf.d0.MESSAGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f3788b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.d0 r4 = com.google.protobuf.d0.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.google.protobuf.w$b[] r3 = com.google.protobuf.w.b.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f3787a = r3
                com.google.protobuf.w$b r4 = com.google.protobuf.w.b.MAP     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f3787a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.google.protobuf.w$b r3 = com.google.protobuf.w.b.VECTOR     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f3787a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.google.protobuf.w$b r1 = com.google.protobuf.w.b.SCALAR     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.w.a.<clinit>():void");
        }
    }

    enum b {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);
        

        /* renamed from: e  reason: collision with root package name */
        private final boolean f3794e;

        private b(boolean z4) {
            this.f3794e = z4;
        }
    }

    static {
        int i5;
        f3764j0 = new Type[0];
        w[] values = values();
        f3762i0 = new w[values.length];
        for (w wVar : values) {
            f3762i0[wVar.f3783f] = wVar;
        }
    }

    private w(int i5, b bVar, d0 d0Var) {
        int i6;
        this.f3783f = i5;
        this.f3784g = bVar;
        this.f3782e = d0Var;
        int i7 = a.f3787a[bVar.ordinal()];
        boolean z4 = true;
        this.f3785h = (i7 == 1 || i7 == 2) ? d0Var.c() : null;
        this.f3786i = (bVar != b.SCALAR || (i6 = a.f3788b[d0Var.ordinal()]) == 1 || i6 == 2 || i6 == 3) ? false : z4;
    }

    public int c() {
        return this.f3783f;
    }
}
