package i4;

import j4.c;
import javax.annotation.Nullable;
import s4.d;

public abstract class y {

    class a extends y {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f5233a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ byte[] f5234b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5235c;

        a(t tVar, int i5, byte[] bArr, int i6) {
            this.f5233a = i5;
            this.f5234b = bArr;
            this.f5235c = i6;
        }

        public long a() {
            return (long) this.f5233a;
        }

        @Nullable
        public t b() {
            return null;
        }

        public void e(d dVar) {
            dVar.write(this.f5234b, this.f5235c, this.f5233a);
        }
    }

    public static y c(@Nullable t tVar, byte[] bArr) {
        return d(tVar, bArr, 0, bArr.length);
    }

    public static y d(@Nullable t tVar, byte[] bArr, int i5, int i6) {
        if (bArr != null) {
            c.d((long) bArr.length, (long) i5, (long) i6);
            return new a(tVar, i6, bArr, i5);
        }
        throw new NullPointerException("content == null");
    }

    public abstract long a();

    @Nullable
    public abstract t b();

    public abstract void e(d dVar);
}
