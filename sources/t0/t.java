package t0;

import java.lang.ref.WeakReference;

abstract class t extends r {

    /* renamed from: d  reason: collision with root package name */
    private static final WeakReference f6837d = new WeakReference((Object) null);

    /* renamed from: c  reason: collision with root package name */
    private WeakReference f6838c = f6837d;

    t(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public final byte[] e() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f6838c.get();
            if (bArr == null) {
                bArr = z();
                this.f6838c = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] z();
}
