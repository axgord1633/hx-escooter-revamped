package kotlinx.coroutines.internal;

import c4.v1;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final s f5630a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f5631b = c0.e("kotlinx.coroutines.fast.service.loader", true);

    /* renamed from: c  reason: collision with root package name */
    public static final v1 f5632c;

    static {
        s sVar = new s();
        f5630a = sVar;
        f5632c = sVar.a();
    }

    private s() {
    }

    private final v1 a() {
        T t5;
        v1 e5;
        Class<r> cls = r.class;
        try {
            List<r> c5 = f5631b ? h.f5602a.c() : h.e(f.a(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
            Iterator<T> it = c5.iterator();
            if (!it.hasNext()) {
                t5 = null;
            } else {
                t5 = it.next();
                if (it.hasNext()) {
                    int c6 = ((r) t5).c();
                    do {
                        T next = it.next();
                        int c7 = ((r) next).c();
                        if (c6 < c7) {
                            t5 = next;
                            c6 = c7;
                        }
                    } while (it.hasNext());
                }
            }
            r rVar = (r) t5;
            return (rVar == null || (e5 = t.e(rVar, c5)) == null) ? t.b((Throwable) null, (String) null, 3, (Object) null) : e5;
        } catch (Throwable th) {
            return t.b(th, (String) null, 2, (Object) null);
        }
    }
}
