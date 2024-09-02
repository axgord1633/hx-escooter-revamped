package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.res.e;
import androidx.core.provider.g;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

class j {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Long, e.c> f1730a = new ConcurrentHashMap<>();

    class a implements b<g.b> {
        a() {
        }

        /* renamed from: c */
        public int a(g.b bVar) {
            return bVar.e();
        }

        /* renamed from: d */
        public boolean b(g.b bVar) {
            return bVar.f();
        }
    }

    private interface b<T> {
        int a(T t5);

        boolean b(T t5);
    }

    j() {
    }

    private static <T> T e(T[] tArr, int i5, b<T> bVar) {
        return f(tArr, (i5 & 1) == 0 ? 400 : 700, (i5 & 2) != 0, bVar);
    }

    private static <T> T f(T[] tArr, int i5, boolean z4, b<T> bVar) {
        T t5 = null;
        int i6 = Integer.MAX_VALUE;
        for (T t6 : tArr) {
            int abs = (Math.abs(bVar.a(t6) - i5) * 2) + (bVar.b(t6) == z4 ? 0 : 1);
            if (t5 == null || i6 > abs) {
                t5 = t6;
                i6 = abs;
            }
        }
        return t5;
    }

    public Typeface a(Context context, e.c cVar, Resources resources, int i5) {
        throw null;
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i5) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public Typeface c(Context context, InputStream inputStream) {
        File e5 = k.e(context);
        if (e5 == null) {
            return null;
        }
        try {
            if (!k.d(e5, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e5.getPath());
            e5.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e5.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i5, String str, int i6) {
        File e5 = k.e(context);
        if (e5 == null) {
            return null;
        }
        try {
            if (!k.c(e5, resources, i5)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e5.getPath());
            e5.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e5.delete();
        }
    }

    /* access modifiers changed from: protected */
    public g.b g(g.b[] bVarArr, int i5) {
        return (g.b) e(bVarArr, i5, new a());
    }
}
