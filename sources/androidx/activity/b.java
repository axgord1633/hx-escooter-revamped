package androidx.activity;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f497e;

    public /* synthetic */ b(ComponentActivity componentActivity) {
        this.f497e = componentActivity;
    }

    public final void run() {
        this.f497e.invalidateMenu();
    }
}
