package c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import c.a;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import m3.i;

public class d extends a<androidx.activity.result.f, Uri> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3068a = new a((g) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final ResolveInfo a(Context context) {
            k.e(context, "context");
            return context.getPackageManager().resolveActivity(new Intent("com.google.android.gms.provider.action.PICK_IMAGES"), 1114112);
        }

        public final ResolveInfo b(Context context) {
            k.e(context, "context");
            return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
        }

        public final String c(f fVar) {
            k.e(fVar, "input");
            if (fVar instanceof c) {
                return "image/*";
            }
            if (fVar instanceof e) {
                return "video/*";
            }
            if (fVar instanceof C0057d) {
                return ((C0057d) fVar).a();
            }
            if (fVar instanceof b) {
                return null;
            }
            throw new i();
        }

        public final boolean d(Context context) {
            k.e(context, "context");
            return a(context) != null;
        }

        public final boolean e(Context context) {
            k.e(context, "context");
            return b(context) != null;
        }

        public final boolean f() {
            int i5 = Build.VERSION.SDK_INT;
            return i5 >= 33 || (i5 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2);
        }
    }

    public static final class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public static final b f3069a = new b();

        private b() {
        }
    }

    public static final class c implements f {

        /* renamed from: a  reason: collision with root package name */
        public static final c f3070a = new c();

        private c() {
        }
    }

    /* renamed from: c.d$d  reason: collision with other inner class name */
    public static final class C0057d implements f {

        /* renamed from: a  reason: collision with root package name */
        private final String f3071a;

        public final String a() {
            return this.f3071a;
        }
    }

    public static final class e implements f {

        /* renamed from: a  reason: collision with root package name */
        public static final e f3072a = new e();

        private e() {
        }
    }

    public interface f {
    }

    /* renamed from: d */
    public Intent a(Context context, androidx.activity.result.f fVar) {
        ActivityInfo activityInfo;
        Intent intent;
        k.e(context, "context");
        k.e(fVar, "input");
        a aVar = f3068a;
        if (aVar.f()) {
            Intent intent2 = new Intent("android.provider.action.PICK_IMAGES");
            intent2.setType(aVar.c(fVar.a()));
            return intent2;
        }
        if (aVar.e(context)) {
            ResolveInfo b5 = aVar.b(context);
            if (b5 != null) {
                activityInfo = b5.activityInfo;
                intent = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        } else if (aVar.d(context)) {
            ResolveInfo a5 = aVar.a(context);
            if (a5 != null) {
                activityInfo = a5.activityInfo;
                intent = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        } else {
            Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent3.setType(aVar.c(fVar.a()));
            if (intent3.getType() != null) {
                return intent3;
            }
            intent3.setType("*/*");
            intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return intent3;
        }
        intent.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
        intent.setType(aVar.c(fVar.a()));
        return intent;
    }

    /* renamed from: e */
    public final a.C0056a<Uri> b(Context context, androidx.activity.result.f fVar) {
        k.e(context, "context");
        k.e(fVar, "input");
        return null;
    }

    /* renamed from: f */
    public final Uri c(int i5, Intent intent) {
        if (!(i5 == -1)) {
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        Uri data = intent.getData();
        if (data == null) {
            data = (Uri) v.l(b.f3065a.a(intent));
        }
        return data;
    }
}
