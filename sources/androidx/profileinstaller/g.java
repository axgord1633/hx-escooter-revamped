package androidx.profileinstaller;

enum g {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);
    

    /* renamed from: e  reason: collision with root package name */
    private final long f2664e;

    private g(long j5) {
        this.f2664e = j5;
    }

    public long f() {
        return this.f2664e;
    }
}
