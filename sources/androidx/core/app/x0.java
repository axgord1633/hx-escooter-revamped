package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class x0 implements Iterable<Intent> {

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<Intent> f1633e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private final Context f1634f;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private x0(Context context) {
        this.f1634f = context;
    }

    public static x0 i(Context context) {
        return new x0(context);
    }

    public x0 c(Intent intent) {
        this.f1633e.add(intent);
        return this;
    }

    public x0 e(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = j.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f1634f.getPackageManager());
            }
            f(component);
            c(supportParentActivityIntent);
        }
        return this;
    }

    public x0 f(ComponentName componentName) {
        int size = this.f1633e.size();
        try {
            Context context = this.f1634f;
            while (true) {
                Intent b5 = j.b(context, componentName);
                if (b5 == null) {
                    return this;
                }
                this.f1633e.add(size, b5);
                context = this.f1634f;
                componentName = b5.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e5) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e5);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1633e.iterator();
    }

    public void l() {
        m((Bundle) null);
    }

    public void m(Bundle bundle) {
        if (!this.f1633e.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.f1633e.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!androidx.core.content.a.g(this.f1634f, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f1634f.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
