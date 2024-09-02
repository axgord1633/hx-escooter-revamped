package g1;

import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import i1.v;

final class a0 extends v {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final w f4668b;

    a0(w wVar) {
        this.f4668b = wVar;
    }

    /* access modifiers changed from: package-private */
    public final void A() {
        this.f4668b.f().a();
    }

    public final void i(LocationAvailability locationAvailability) {
        this.f4668b.f().c(new y(this, locationAvailability));
    }

    public final void p() {
        this.f4668b.f().c(new z(this));
    }

    public final void y(LocationResult locationResult) {
        this.f4668b.f().c(new x(this, locationResult));
    }

    /* access modifiers changed from: package-private */
    public final a0 z(c cVar) {
        this.f4668b.e(cVar);
        return this;
    }
}
