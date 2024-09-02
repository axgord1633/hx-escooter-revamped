package j4;

import i4.b0;
import i4.i;
import i4.j;
import i4.q;
import i4.z;
import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import l4.c;
import l4.d;
import l4.g;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f5473a;

    public abstract void a(q.a aVar, String str);

    public abstract void b(q.a aVar, String str, String str2);

    public abstract void c(j jVar, SSLSocket sSLSocket, boolean z4);

    public abstract int d(z.a aVar);

    public abstract boolean e(i iVar, c cVar);

    public abstract Socket f(i iVar, i4.a aVar, g gVar);

    public abstract boolean g(i4.a aVar, i4.a aVar2);

    public abstract c h(i iVar, i4.a aVar, g gVar, b0 b0Var);

    public abstract void i(i iVar, c cVar);

    public abstract d j(i iVar);

    @Nullable
    public abstract IOException k(i4.d dVar, @Nullable IOException iOException);
}
