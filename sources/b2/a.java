package b2;

import com.signify.hue.flutterreactiveble.ble.extensions.RxBleConnectionExtensionKt;
import java.util.UUID;
import p1.q0;
import r2.f;

public final /* synthetic */ class a implements f {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ UUID f2970e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f2971f;

    public /* synthetic */ a(UUID uuid, int i5) {
        this.f2970e = uuid;
        this.f2971f = i5;
    }

    public final Object apply(Object obj) {
        return RxBleConnectionExtensionKt.m56resolveCharacteristic$lambda2(this.f2970e, this.f2971f, (q0) obj);
    }
}
