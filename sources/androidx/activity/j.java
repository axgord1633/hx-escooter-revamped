package androidx.activity;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.k;
import m3.q;
import v3.a;

public abstract class j {
    private final CopyOnWriteArrayList<a> cancellables = new CopyOnWriteArrayList<>();
    private a<q> enabledChangedCallback;
    private boolean isEnabled;

    public j(boolean z4) {
        this.isEnabled = z4;
    }

    public final void addCancellable(a aVar) {
        k.e(aVar, "cancellable");
        this.cancellables.add(aVar);
    }

    public final a<q> getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    public abstract void handleOnBackPressed();

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void remove() {
        for (a cancel : this.cancellables) {
            cancel.cancel();
        }
    }

    public final void removeCancellable(a aVar) {
        k.e(aVar, "cancellable");
        this.cancellables.remove(aVar);
    }

    public final void setEnabled(boolean z4) {
        this.isEnabled = z4;
        a<q> aVar = this.enabledChangedCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(a<q> aVar) {
        this.enabledChangedCallback = aVar;
    }
}
