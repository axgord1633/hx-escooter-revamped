package androidx.core.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f1669a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Object, SparseArray<Object>> f1670b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1671c = new Object();

    static class a {
        static Drawable a(Resources resources, int i5, Resources.Theme theme) {
            return resources.getDrawable(i5, theme);
        }

        static Drawable b(Resources resources, int i5, int i6, Resources.Theme theme) {
            return resources.getDrawableForDensity(i5, i6, theme);
        }
    }

    public static abstract class b {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(int i5, Handler handler) {
            e(handler).post(new j(this, i5));
        }

        public final void d(Typeface typeface, Handler handler) {
            e(handler).post(new i(this, typeface));
        }

        /* renamed from: h */
        public abstract void f(int i5);

        /* renamed from: i */
        public abstract void g(Typeface typeface);
    }

    public static final class c {

        static class a {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f1672a = new Object();

            /* renamed from: b  reason: collision with root package name */
            private static Method f1673b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f1674c;

            static void a(Resources.Theme theme) {
                synchronized (f1672a) {
                    if (!f1674c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f1673b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e5) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e5);
                        }
                        f1674c = true;
                    }
                    Method method = f1673b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e6) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e6);
                            f1673b = null;
                        }
                    }
                }
            }
        }

        static class b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                b.a(theme);
            } else {
                a.a(theme);
            }
        }
    }

    public static Drawable a(Resources resources, int i5, Resources.Theme theme) {
        return a.a(resources, i5, theme);
    }

    public static Typeface b(Context context, int i5, TypedValue typedValue, int i6, b bVar) {
        if (context.isRestricted()) {
            return null;
        }
        return c(context, i5, typedValue, i6, bVar, (Handler) null, true, false);
    }

    private static Typeface c(Context context, int i5, TypedValue typedValue, int i6, b bVar, Handler handler, boolean z4, boolean z5) {
        Resources resources = context.getResources();
        int i7 = i5;
        resources.getValue(i5, typedValue, true);
        Typeface d5 = d(context, resources, typedValue, i5, i6, bVar, handler, z4, z5);
        if (d5 != null || bVar != null || z5) {
            return d5;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i5) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface d(android.content.Context r17, android.content.res.Resources r18, android.util.TypedValue r19, int r20, int r21, androidx.core.content.res.h.b r22, android.os.Handler r23, boolean r24, boolean r25) {
        /*
            r0 = r18
            r1 = r19
            r4 = r20
            r11 = r22
            r12 = r23
            java.lang.String r13 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x00ae
            java.lang.String r14 = r2.toString()
            java.lang.String r2 = "res/"
            boolean r2 = r14.startsWith(r2)
            r15 = -3
            r16 = 0
            if (r2 != 0) goto L_0x0025
            if (r11 == 0) goto L_0x0024
            r11.c(r15, r12)
        L_0x0024:
            return r16
        L_0x0025:
            int r2 = r1.assetCookie
            r7 = r21
            android.graphics.Typeface r2 = androidx.core.graphics.d.f(r0, r4, r14, r2, r7)
            if (r2 == 0) goto L_0x0035
            if (r11 == 0) goto L_0x0034
            r11.d(r2, r12)
        L_0x0034:
            return r2
        L_0x0035:
            if (r25 == 0) goto L_0x0038
            return r16
        L_0x0038:
            java.lang.String r2 = r14.toLowerCase()     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            java.lang.String r3 = ".xml"
            boolean r2 = r2.endsWith(r3)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            if (r2 == 0) goto L_0x006f
            android.content.res.XmlResourceParser r2 = r0.getXml(r4)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            androidx.core.content.res.e$b r2 = androidx.core.content.res.e.b(r2, r0)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            if (r2 != 0) goto L_0x0059
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r13, r0)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            if (r11 == 0) goto L_0x0058
            r11.c(r15, r12)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
        L_0x0058:
            return r16
        L_0x0059:
            int r6 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            r1 = r17
            r3 = r18
            r4 = r20
            r5 = r14
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            android.graphics.Typeface r0 = androidx.core.graphics.d.c(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            return r0
        L_0x006f:
            int r5 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            r1 = r17
            r2 = r18
            r3 = r20
            r4 = r14
            r6 = r21
            android.graphics.Typeface r0 = androidx.core.graphics.d.d(r1, r2, r3, r4, r5, r6)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            if (r11 == 0) goto L_0x0089
            if (r0 == 0) goto L_0x0086
            r11.d(r0, r12)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            goto L_0x0089
        L_0x0086:
            r11.c(r15, r12)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
        L_0x0089:
            return r0
        L_0x008a:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            goto L_0x009b
        L_0x0093:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
        L_0x009b:
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
            if (r11 == 0) goto L_0x00ad
            r11.c(r15, r12)
        L_0x00ad:
            return r16
        L_0x00ae:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r20)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.d(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.h$b, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
