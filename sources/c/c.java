package c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.activity.result.f;
import c.a;
import c.d;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public class c extends a<f, List<Uri>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f3066b = new a((g) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f3067a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final int a() {
            if (d.f3068a.f()) {
                return MediaStore.getPickImagesMaxLimit();
            }
            return Integer.MAX_VALUE;
        }
    }

    public c() {
        this(0, 1, (g) null);
    }

    public c(int i5) {
        this.f3067a = i5;
        if (!(i5 <= 1 ? false : true)) {
            throw new IllegalArgumentException("Max items must be higher than 1".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i5, int i6, g gVar) {
        this((i6 & 1) != 0 ? f3066b.a() : i5);
    }

    /* renamed from: d */
    public Intent a(Context context, f fVar) {
        k.e(context, "context");
        k.e(fVar, "input");
        d.a aVar = d.f3068a;
        boolean z4 = true;
        if (aVar.f()) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(aVar.c(fVar.a()));
            if (this.f3067a > MediaStore.getPickImagesMaxLimit()) {
                z4 = false;
            }
            if (z4) {
                intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.f3067a);
                return intent;
            }
            throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
        } else if (aVar.e(context)) {
            ResolveInfo b5 = aVar.b(context);
            if (b5 != null) {
                ActivityInfo activityInfo = b5.activityInfo;
                Intent intent2 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent2.setType(aVar.c(fVar.a()));
                intent2.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.f3067a);
                return intent2;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } else if (aVar.d(context)) {
            ResolveInfo a5 = aVar.a(context);
            if (a5 != null) {
                ActivityInfo activityInfo2 = a5.activityInfo;
                Intent intent3 = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
                intent3.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
                intent3.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.f3067a);
                return intent3;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } else {
            Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent4.setType(aVar.c(fVar.a()));
            intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if (intent4.getType() != null) {
                return intent4;
            }
            intent4.setType("*/*");
            intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return intent4;
        }
    }

    /* renamed from: e */
    public final a.C0056a<List<Uri>> b(Context context, f fVar) {
        k.e(context, "context");
        k.e(fVar, "input");
        return null;
    }

    /* renamed from: f */
    public final List<Uri> c(int i5, Intent intent) {
        List<Uri> a5;
        if (!(i5 == -1)) {
            intent = null;
        }
        return (intent == null || (a5 = b.f3065a.a(intent)) == null) ? n.d() : a5;
    }
}
