package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;

class m {

    /* renamed from: a  reason: collision with root package name */
    private static Field f708a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f709b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f710c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f711d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f712e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f713f;

    /* renamed from: g  reason: collision with root package name */
    private static Field f714g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f715h;

    static void a(Resources resources) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 28) {
            if (i5 >= 24) {
                c(resources);
            } else {
                b(resources);
            }
        }
    }

    private static void b(Resources resources) {
        if (!f709b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f708a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e5);
            }
            f709b = true;
        }
        Object obj = null;
        Field field = f708a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e6) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e6);
            }
        }
        if (obj != null) {
            d(obj);
        }
    }

    private static void c(Resources resources) {
        Object obj;
        if (!f715h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f714g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e5);
            }
            f715h = true;
        }
        Field field = f714g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e6) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e6);
                obj = null;
            }
            if (obj != null) {
                if (!f709b) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f708a = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException e7) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e7);
                    }
                    f709b = true;
                }
                Field field2 = f708a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e8) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e8);
                    }
                }
                if (obj2 != null) {
                    d(obj2);
                }
            }
        }
    }

    private static void d(Object obj) {
        if (!f711d) {
            try {
                f710c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e5) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e5);
            }
            f711d = true;
        }
        Class<?> cls = f710c;
        if (cls != null) {
            if (!f713f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f712e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e6) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e6);
                }
                f713f = true;
            }
            Field field = f712e;
            if (field != null) {
                LongSparseArray longSparseArray = null;
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e7) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e7);
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
