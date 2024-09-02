package m4;

import i4.r;
import i4.x;
import java.net.Proxy;

public final class i {
    public static String a(x xVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(xVar.f());
        sb.append(' ');
        boolean b5 = b(xVar, type);
        r h5 = xVar.h();
        if (b5) {
            sb.append(h5);
        } else {
            sb.append(c(h5));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(x xVar, Proxy.Type type) {
        return !xVar.e() && type == Proxy.Type.HTTP;
    }

    public static String c(r rVar) {
        String g5 = rVar.g();
        String i5 = rVar.i();
        if (i5 == null) {
            return g5;
        }
        return g5 + '?' + i5;
    }
}
