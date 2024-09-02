package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.l;
import androidx.core.graphics.drawable.IconCompat;

class g0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1540a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f1541b = new Object();

    static Bundle a(l.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat d5 = aVar.d();
        bundle.putInt("icon", d5 != null ? d5.h() : 0);
        bundle.putCharSequence("title", aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    private static Bundle b(v0 v0Var) {
        new Bundle();
        throw null;
    }

    private static Bundle[] c(v0[] v0VarArr) {
        if (v0VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[v0VarArr.length];
        for (int i5 = 0; i5 < v0VarArr.length; i5++) {
            v0 v0Var = v0VarArr[i5];
            bundleArr[i5] = b((v0) null);
        }
        return bundleArr;
    }
}
