package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.res.e;
import androidx.core.content.res.h;
import androidx.core.provider.g;
import m.e;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final j f1700a;

    /* renamed from: b  reason: collision with root package name */
    private static final e<String, Typeface> f1701b = new e<>(16);

    public static class a extends g.c {

        /* renamed from: a  reason: collision with root package name */
        private h.b f1702a;

        public a(h.b bVar) {
            this.f1702a = bVar;
        }

        public void a(int i5) {
            h.b bVar = this.f1702a;
            if (bVar != null) {
                bVar.f(i5);
            }
        }

        public void b(Typeface typeface) {
            h.b bVar = this.f1702a;
            if (bVar != null) {
                bVar.g(typeface);
            }
        }
    }

    static {
        int i5 = Build.VERSION.SDK_INT;
        f1700a = i5 >= 29 ? new i() : i5 >= 28 ? new h() : i5 >= 26 ? new g() : (i5 < 24 || !f.j()) ? new e() : new f();
    }

    public static Typeface a(Context context, Typeface typeface, int i5) {
        if (context != null) {
            return Typeface.create(typeface, i5);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i5) {
        return f1700a.b(context, cancellationSignal, bVarArr, i5);
    }

    public static Typeface c(Context context, e.b bVar, Resources resources, int i5, String str, int i6, int i7, h.b bVar2, Handler handler, boolean z4) {
        Typeface typeface;
        e.b bVar3 = bVar;
        h.b bVar4 = bVar2;
        Handler handler2 = handler;
        if (bVar3 instanceof e.C0024e) {
            e.C0024e eVar = (e.C0024e) bVar3;
            Typeface g5 = g(eVar.c());
            if (g5 != null) {
                if (bVar4 != null) {
                    bVar4.d(g5, handler2);
                }
                return g5;
            }
            typeface = g.a(context, eVar.b(), i7, !z4 ? bVar4 == null : eVar.a() == 0, z4 ? eVar.d() : -1, h.b.e(handler), new a(bVar4));
            Resources resources2 = resources;
            int i8 = i7;
        } else {
            Context context2 = context;
            Resources resources3 = resources;
            typeface = f1700a.a(context, (e.c) bVar3, resources, i7);
            if (bVar4 != null) {
                if (typeface != null) {
                    bVar4.d(typeface, handler2);
                } else {
                    bVar4.c(-3, handler2);
                }
            }
        }
        if (typeface != null) {
            f1701b.d(e(resources, i5, str, i6, i7), typeface);
        }
        return typeface;
    }

    public static Typeface d(Context context, Resources resources, int i5, String str, int i6, int i7) {
        Typeface d5 = f1700a.d(context, resources, i5, str, i7);
        if (d5 != null) {
            f1701b.d(e(resources, i5, str, i6, i7), d5);
        }
        return d5;
    }

    private static String e(Resources resources, int i5, String str, int i6, int i7) {
        return resources.getResourcePackageName(i5) + '-' + str + '-' + i6 + '-' + i5 + '-' + i7;
    }

    public static Typeface f(Resources resources, int i5, String str, int i6, int i7) {
        return f1701b.c(e(resources, i5, str, i6, i7));
    }

    private static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
