package l4;

import j4.c;
import java.io.IOException;

public final class e extends RuntimeException {

    /* renamed from: e  reason: collision with root package name */
    private IOException f5790e;

    /* renamed from: f  reason: collision with root package name */
    private IOException f5791f;

    public e(IOException iOException) {
        super(iOException);
        this.f5790e = iOException;
        this.f5791f = iOException;
    }

    public void a(IOException iOException) {
        c.a(this.f5790e, iOException);
        this.f5791f = iOException;
    }

    public IOException b() {
        return this.f5790e;
    }

    public IOException c() {
        return this.f5791f;
    }
}
