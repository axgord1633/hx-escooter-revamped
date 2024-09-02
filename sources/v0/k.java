package v0;

import com.google.android.gms.common.api.Status;
import l1.h;
import w0.b;

public class k {
    public static <ResultT> void a(Status status, ResultT resultt, h<ResultT> hVar) {
        if (status.e()) {
            hVar.c(resultt);
        } else {
            hVar.b(b.a(status));
        }
    }

    public static void b(Status status, h<Void> hVar) {
        a(status, (Object) null, hVar);
    }
}
