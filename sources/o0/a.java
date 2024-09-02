package o0;

public enum a {
    denied,
    deniedForever,
    whileInUse,
    always;

    /* renamed from: o0.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0092a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6112a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                o0.a[] r0 = o0.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6112a = r0
                o0.a r1 = o0.a.denied     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6112a     // Catch:{ NoSuchFieldError -> 0x001d }
                o0.a r1 = o0.a.deniedForever     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6112a     // Catch:{ NoSuchFieldError -> 0x0028 }
                o0.a r1 = o0.a.whileInUse     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6112a     // Catch:{ NoSuchFieldError -> 0x0033 }
                o0.a r1 = o0.a.always     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o0.a.C0092a.<clinit>():void");
        }
    }

    public int f() {
        int i5 = C0092a.f6112a[ordinal()];
        if (i5 == 1) {
            return 0;
        }
        if (i5 == 2) {
            return 1;
        }
        if (i5 == 3) {
            return 2;
        }
        if (i5 == 4) {
            return 3;
        }
        throw new IndexOutOfBoundsException();
    }
}
