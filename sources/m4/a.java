package m4;

import i4.k;
import i4.l;
import i4.s;
import i4.x;
import i4.y;
import i4.z;
import j4.c;
import j4.d;
import java.util.List;
import s4.j;

public final class a implements s {

    /* renamed from: a  reason: collision with root package name */
    private final l f5905a;

    public a(l lVar) {
        this.f5905a = lVar;
    }

    private String b(List<k> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 > 0) {
                sb.append("; ");
            }
            k kVar = list.get(i5);
            sb.append(kVar.c());
            sb.append('=');
            sb.append(kVar.k());
        }
        return sb.toString();
    }

    public z a(s.a aVar) {
        x e5 = aVar.e();
        x.a g5 = e5.g();
        y a5 = e5.a();
        if (a5 != null) {
            a5.b();
            long a6 = a5.a();
            if (a6 != -1) {
                g5.b("Content-Length", Long.toString(a6));
                g5.e("Transfer-Encoding");
            } else {
                g5.b("Transfer-Encoding", "chunked");
                g5.e("Content-Length");
            }
        }
        boolean z4 = false;
        if (e5.c("Host") == null) {
            g5.b("Host", c.q(e5.h(), false));
        }
        if (e5.c("Connection") == null) {
            g5.b("Connection", "Keep-Alive");
        }
        if (e5.c("Accept-Encoding") == null && e5.c("Range") == null) {
            z4 = true;
            g5.b("Accept-Encoding", "gzip");
        }
        List<k> b5 = this.f5905a.b(e5.h());
        if (!b5.isEmpty()) {
            g5.b("Cookie", b(b5));
        }
        if (e5.c("User-Agent") == null) {
            g5.b("User-Agent", d.a());
        }
        z b6 = aVar.b(g5.a());
        e.e(this.f5905a, e5.h(), b6.j());
        z.a p5 = b6.l().p(e5);
        if (z4 && "gzip".equalsIgnoreCase(b6.g("Content-Encoding")) && e.c(b6)) {
            j jVar = new j(b6.b().f());
            p5.j(b6.j().f().e("Content-Encoding").e("Content-Length").d());
            p5.b(new h(b6.g("Content-Type"), -1, s4.l.b(jVar)));
        }
        return p5.c();
    }
}
