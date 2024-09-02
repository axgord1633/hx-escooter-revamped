package c;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class f extends a<Intent, androidx.activity.result.a> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3074a = new a((g) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* renamed from: d */
    public Intent a(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "input");
        return intent;
    }

    /* renamed from: e */
    public androidx.activity.result.a c(int i5, Intent intent) {
        return new androidx.activity.result.a(i5, intent);
    }
}
