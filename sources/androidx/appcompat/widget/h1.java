package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class h1 extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1263c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<WeakReference<h1>> f1264d;

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1265a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources.Theme f1266b;

    private h1(Context context) {
        super(context);
        if (q1.c()) {
            q1 q1Var = new q1(this, context.getResources());
            this.f1265a = q1Var;
            Resources.Theme newTheme = q1Var.newTheme();
            this.f1266b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f1265a = new j1(this, context.getResources());
        this.f1266b = null;
    }

    private static boolean a(Context context) {
        return !(context instanceof h1) && !(context.getResources() instanceof j1) && !(context.getResources() instanceof q1) && q1.c();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f1263c) {
            ArrayList<WeakReference<h1>> arrayList = f1264d;
            if (arrayList == null) {
                f1264d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f1264d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1264d.remove(size);
                    }
                }
                for (int size2 = f1264d.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f1264d.get(size2);
                    h1 h1Var = weakReference2 != null ? (h1) weakReference2.get() : null;
                    if (h1Var != null && h1Var.getBaseContext() == context) {
                        return h1Var;
                    }
                }
            }
            h1 h1Var2 = new h1(context);
            f1264d.add(new WeakReference(h1Var2));
            return h1Var2;
        }
    }

    public AssetManager getAssets() {
        return this.f1265a.getAssets();
    }

    public Resources getResources() {
        return this.f1265a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1266b;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i5) {
        Resources.Theme theme = this.f1266b;
        if (theme == null) {
            super.setTheme(i5);
        } else {
            theme.applyStyle(i5, true);
        }
    }
}
