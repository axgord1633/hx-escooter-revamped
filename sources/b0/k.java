package b0;

import android.view.ViewGroup;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f2894a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f2895b;

    public static k b(ViewGroup viewGroup) {
        return (k) viewGroup.getTag(i.f2891b);
    }

    static void c(ViewGroup viewGroup, k kVar) {
        viewGroup.setTag(i.f2891b, kVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f2894a) == this && (runnable = this.f2895b) != null) {
            runnable.run();
        }
    }
}
