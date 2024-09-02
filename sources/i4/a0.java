package i4;

import java.io.Closeable;
import javax.annotation.Nullable;
import s4.c;
import s4.e;

public abstract class a0 implements Closeable {

    class a extends a0 {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f4972e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ e f4973f;

        a(t tVar, long j5, e eVar) {
            this.f4972e = j5;
            this.f4973f = eVar;
        }

        public long b() {
            return this.f4972e;
        }

        public e f() {
            return this.f4973f;
        }
    }

    public static a0 d(@Nullable t tVar, long j5, e eVar) {
        if (eVar != null) {
            return new a(tVar, j5, eVar);
        }
        throw new NullPointerException("source == null");
    }

    public static a0 e(@Nullable t tVar, byte[] bArr) {
        return d(tVar, (long) bArr.length, new c().write(bArr));
    }

    public abstract long b();

    public void close() {
        j4.c.e(f());
    }

    public abstract e f();
}
