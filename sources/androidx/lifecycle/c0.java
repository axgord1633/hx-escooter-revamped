package androidx.lifecycle;

import androidx.lifecycle.b0;
import kotlin.jvm.internal.k;
import w.a;

public final /* synthetic */ class c0 {
    public static a0 a(b0.b bVar, Class cls) {
        k.e(cls, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static a0 b(b0.b bVar, Class cls, a aVar) {
        k.e(cls, "modelClass");
        k.e(aVar, "extras");
        return bVar.a(cls);
    }
}
