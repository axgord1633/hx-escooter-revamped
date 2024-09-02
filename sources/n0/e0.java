package n0;

import android.location.OnNmeaMessageListener;

public final /* synthetic */ class e0 implements OnNmeaMessageListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f0 f6007a;

    public /* synthetic */ e0(f0 f0Var) {
        this.f6007a = f0Var;
    }

    public final void onNmeaMessage(String str, long j5) {
        this.f6007a.c(str, j5);
    }
}
