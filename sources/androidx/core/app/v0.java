package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;

public final class v0 {

    static class a {
        static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(v0 v0Var) {
            throw null;
        }

        static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    static RemoteInput a(v0 v0Var) {
        return a.b(v0Var);
    }

    static RemoteInput[] b(v0[] v0VarArr) {
        if (v0VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[v0VarArr.length];
        for (int i5 = 0; i5 < v0VarArr.length; i5++) {
            v0 v0Var = v0VarArr[i5];
            remoteInputArr[i5] = a((v0) null);
        }
        return remoteInputArr;
    }
}
