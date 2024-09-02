package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.res.e;
import androidx.core.provider.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class e extends j {

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f1714b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Constructor<?> f1715c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Method f1716d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Method f1717e = null;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f1718f = false;

    e() {
    }

    private static boolean h(Object obj, String str, int i5, boolean z4) {
        k();
        try {
            return ((Boolean) f1716d.invoke(obj, new Object[]{str, Integer.valueOf(i5), Boolean.valueOf(z4)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    private static Typeface i(Object obj) {
        k();
        try {
            Object newInstance = Array.newInstance(f1714b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f1717e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    private File j(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void k() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f1718f) {
            f1718f = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e5) {
                Log.e("TypefaceCompatApi21Impl", e5.getClass().getName(), e5);
                method2 = null;
                cls = null;
                method = null;
            }
            f1715c = constructor;
            f1714b = cls;
            f1716d = method;
            f1717e = method2;
        }
    }

    private static Object l() {
        k();
        try {
            return f1715c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    public Typeface a(Context context, e.c cVar, Resources resources, int i5) {
        Object l5 = l();
        e.d[] a5 = cVar.a();
        int length = a5.length;
        int i6 = 0;
        while (i6 < length) {
            e.d dVar = a5[i6];
            File e5 = k.e(context);
            if (e5 == null) {
                return null;
            }
            try {
                if (!k.c(e5, resources, dVar.b())) {
                    e5.delete();
                    return null;
                } else if (!h(l5, e5.getPath(), dVar.e(), dVar.f())) {
                    return null;
                } else {
                    i6++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e5.delete();
            }
        }
        return i(l5);
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i5) {
        FileInputStream fileInputStream;
        if (bVarArr.length < 1) {
            return null;
        }
        g.b g5 = g(bVarArr, i5);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(g5.d(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File j5 = j(openFileDescriptor);
                if (j5 != null) {
                    if (j5.canRead()) {
                        Typeface createFromFile = Typeface.createFromFile(j5);
                        openFileDescriptor.close();
                        return createFromFile;
                    }
                }
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                Typeface c5 = super.c(context, fileInputStream);
                fileInputStream.close();
                openFileDescriptor.close();
                return c5;
            } catch (Throwable th) {
                openFileDescriptor.close();
                throw th;
            }
        } catch (IOException unused) {
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
