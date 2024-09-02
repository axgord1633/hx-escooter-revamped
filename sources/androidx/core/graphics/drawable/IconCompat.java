package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.yalantis.ucrop.view.CropImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    static final PorterDuff.Mode f1703k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f1704a;

    /* renamed from: b  reason: collision with root package name */
    Object f1705b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1706c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f1707d;

    /* renamed from: e  reason: collision with root package name */
    public int f1708e;

    /* renamed from: f  reason: collision with root package name */
    public int f1709f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f1710g;

    /* renamed from: h  reason: collision with root package name */
    PorterDuff.Mode f1711h;

    /* renamed from: i  reason: collision with root package name */
    public String f1712i;

    /* renamed from: j  reason: collision with root package name */
    public String f1713j;

    static class a {
        static IconCompat a(Object obj) {
            androidx.core.util.d.h(obj);
            int d5 = d(obj);
            if (d5 == 2) {
                return IconCompat.g((Resources) null, c(obj), b(obj));
            }
            if (d5 == 4) {
                return IconCompat.e(e(obj));
            }
            if (d5 == 6) {
                return IconCompat.c(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f1705b = obj;
            return iconCompat;
        }

        static int b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e5) {
                Log.e("IconCompat", "Unable to get icon resource", e5);
                return 0;
            } catch (InvocationTargetException e6) {
                Log.e("IconCompat", "Unable to get icon resource", e6);
                return 0;
            } catch (NoSuchMethodException e7) {
                Log.e("IconCompat", "Unable to get icon resource", e7);
                return 0;
            }
        }

        static String c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e5) {
                Log.e("IconCompat", "Unable to get icon package", e5);
                return null;
            } catch (InvocationTargetException e6) {
                Log.e("IconCompat", "Unable to get icon package", e6);
                return null;
            } catch (NoSuchMethodException e7) {
                Log.e("IconCompat", "Unable to get icon package", e7);
                return null;
            }
        }

        static int d(Object obj) {
            StringBuilder sb;
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e5) {
                e = e5;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            } catch (InvocationTargetException e6) {
                e = e6;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            } catch (NoSuchMethodException e7) {
                e = e7;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            }
        }

        static Uri e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e5) {
                Log.e("IconCompat", "Unable to get icon uri", e5);
                return null;
            } catch (InvocationTargetException e6) {
                Log.e("IconCompat", "Unable to get icon uri", e6);
                return null;
            } catch (NoSuchMethodException e7) {
                Log.e("IconCompat", "Unable to get icon uri", e7);
                return null;
            }
        }

        static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            if (r0 >= 26) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x006d, code lost:
            r5 = androidx.core.graphics.drawable.IconCompat.b.b(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
            r5 = androidx.core.graphics.drawable.IconCompat.b(r5, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a0, code lost:
            r5 = android.graphics.drawable.Icon.createWithBitmap(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a4, code lost:
            r0 = r4.f1710g;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a6, code lost:
            if (r0 == null) goto L_0x00ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
            r5.setTintList(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
            r4 = r4.f1711h;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00af, code lost:
            if (r4 == androidx.core.graphics.drawable.IconCompat.f1703k) goto L_0x00b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b1, code lost:
            r5.setTintMode(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b4, code lost:
            return r5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static android.graphics.drawable.Icon g(androidx.core.graphics.drawable.IconCompat r4, android.content.Context r5) {
            /*
                int r0 = r4.f1704a
                r1 = 0
                r2 = 26
                switch(r0) {
                    case -1: goto L_0x00b5;
                    case 0: goto L_0x0008;
                    case 1: goto L_0x009c;
                    case 2: goto L_0x0091;
                    case 3: goto L_0x0084;
                    case 4: goto L_0x007b;
                    case 5: goto L_0x0065;
                    case 6: goto L_0x0010;
                    default: goto L_0x0008;
                }
            L_0x0008:
                java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
                java.lang.String r5 = "Unknown type"
                r4.<init>(r5)
                throw r4
            L_0x0010:
                int r0 = android.os.Build.VERSION.SDK_INT
                r3 = 30
                if (r0 < r3) goto L_0x0020
                android.net.Uri r5 = r4.k()
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.d.a(r5)
                goto L_0x00a4
            L_0x0020:
                if (r5 == 0) goto L_0x004a
                java.io.InputStream r5 = r4.l(r5)
                if (r5 == 0) goto L_0x002f
                android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5)
                if (r0 < r2) goto L_0x0076
                goto L_0x006d
            L_0x002f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Cannot load adaptive icon from uri: "
                r0.append(r1)
                android.net.Uri r4 = r4.k()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L_0x004a:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
                r0.append(r1)
                android.net.Uri r4 = r4.k()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L_0x0065:
                int r5 = android.os.Build.VERSION.SDK_INT
                if (r5 < r2) goto L_0x0072
                java.lang.Object r5 = r4.f1705b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L_0x006d:
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.b.b(r5)
                goto L_0x00a4
            L_0x0072:
                java.lang.Object r5 = r4.f1705b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L_0x0076:
                android.graphics.Bitmap r5 = androidx.core.graphics.drawable.IconCompat.b(r5, r1)
                goto L_0x00a0
            L_0x007b:
                java.lang.Object r5 = r4.f1705b
                java.lang.String r5 = (java.lang.String) r5
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithContentUri(r5)
                goto L_0x00a4
            L_0x0084:
                java.lang.Object r5 = r4.f1705b
                byte[] r5 = (byte[]) r5
                int r0 = r4.f1708e
                int r1 = r4.f1709f
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithData(r5, r0, r1)
                goto L_0x00a4
            L_0x0091:
                java.lang.String r5 = r4.i()
                int r0 = r4.f1708e
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithResource(r5, r0)
                goto L_0x00a4
            L_0x009c:
                java.lang.Object r5 = r4.f1705b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L_0x00a0:
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithBitmap(r5)
            L_0x00a4:
                android.content.res.ColorStateList r0 = r4.f1710g
                if (r0 == 0) goto L_0x00ab
                r5.setTintList(r0)
            L_0x00ab:
                android.graphics.PorterDuff$Mode r4 = r4.f1711h
                android.graphics.PorterDuff$Mode r0 = androidx.core.graphics.drawable.IconCompat.f1703k
                if (r4 == r0) goto L_0x00b4
                r5.setTintMode(r4)
            L_0x00b4:
                return r5
            L_0x00b5:
                java.lang.Object r4 = r4.f1705b
                android.graphics.drawable.Icon r4 = (android.graphics.drawable.Icon) r4
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.a.g(androidx.core.graphics.drawable.IconCompat, android.content.Context):android.graphics.drawable.Icon");
        }
    }

    static class b {
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    static class c {
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    static class d {
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f1704a = -1;
        this.f1706c = null;
        this.f1707d = null;
        this.f1708e = 0;
        this.f1709f = 0;
        this.f1710g = null;
        this.f1711h = f1703k;
        this.f1712i = null;
    }

    IconCompat(int i5) {
        this.f1706c = null;
        this.f1707d = null;
        this.f1708e = 0;
        this.f1709f = 0;
        this.f1710g = null;
        this.f1711h = f1703k;
        this.f1712i = null;
        this.f1704a = i5;
    }

    public static IconCompat a(Icon icon) {
        return a.a(icon);
    }

    static Bitmap b(Bitmap bitmap, boolean z4) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f5 = (float) min;
        float f6 = 0.5f * f5;
        float f7 = 0.9166667f * f6;
        if (z4) {
            float f8 = 0.010416667f * f5;
            paint.setColor(0);
            paint.setShadowLayer(f8, CropImageView.DEFAULT_ASPECT_RATIO, f5 * 0.020833334f, 1023410176);
            canvas.drawCircle(f6, f6, f7, paint);
            paint.setShadowLayer(f8, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 503316480);
            canvas.drawCircle(f6, f6, f7, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((float) (-(bitmap.getWidth() - min))) / 2.0f, ((float) (-(bitmap.getHeight() - min))) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f6, f6, f7, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    public static IconCompat c(Uri uri) {
        androidx.core.util.c.c(uri);
        return d(uri.toString());
    }

    public static IconCompat d(String str) {
        androidx.core.util.c.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f1705b = str;
        return iconCompat;
    }

    public static IconCompat e(Uri uri) {
        androidx.core.util.c.c(uri);
        return f(uri.toString());
    }

    public static IconCompat f(String str) {
        androidx.core.util.c.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f1705b = str;
        return iconCompat;
    }

    public static IconCompat g(Resources resources, String str, int i5) {
        androidx.core.util.c.c(str);
        if (i5 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f1708e = i5;
            if (resources != null) {
                try {
                    iconCompat.f1705b = resources.getResourceName(i5);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f1705b = str;
            }
            iconCompat.f1713j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    private static String q(int i5) {
        switch (i5) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int h() {
        int i5 = this.f1704a;
        if (i5 == -1) {
            return a.b(this.f1705b);
        }
        if (i5 == 2) {
            return this.f1708e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String i() {
        int i5 = this.f1704a;
        if (i5 == -1) {
            return a.c(this.f1705b);
        }
        if (i5 == 2) {
            String str = this.f1713j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f1705b).split(":", -1)[0] : this.f1713j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int j() {
        int i5 = this.f1704a;
        return i5 == -1 ? a.d(this.f1705b) : i5;
    }

    public Uri k() {
        int i5 = this.f1704a;
        if (i5 == -1) {
            return a.e(this.f1705b);
        }
        if (i5 == 4 || i5 == 6) {
            return Uri.parse((String) this.f1705b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream l(Context context) {
        String str;
        StringBuilder sb;
        Uri k5 = k();
        String scheme = k5.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(k5);
            } catch (Exception e5) {
                e = e5;
                sb = new StringBuilder();
                str = "Unable to load image from URI: ";
                sb.append(str);
                sb.append(k5);
                Log.w("IconCompat", sb.toString(), e);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f1705b));
            } catch (FileNotFoundException e6) {
                e = e6;
                sb = new StringBuilder();
                str = "Unable to load image from path: ";
                sb.append(str);
                sb.append(k5);
                Log.w("IconCompat", sb.toString(), e);
                return null;
            }
        }
    }

    public void m() {
        Parcelable parcelable;
        this.f1711h = PorterDuff.Mode.valueOf(this.f1712i);
        switch (this.f1704a) {
            case -1:
                parcelable = this.f1707d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 1:
            case 5:
                parcelable = this.f1707d;
                if (parcelable == null) {
                    byte[] bArr = this.f1706c;
                    this.f1705b = bArr;
                    this.f1704a = 3;
                    this.f1708e = 0;
                    this.f1709f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f1706c, Charset.forName("UTF-16"));
                this.f1705b = str;
                if (this.f1704a == 2 && this.f1713j == null) {
                    this.f1713j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f1705b = this.f1706c;
                return;
            default:
                return;
        }
        this.f1705b = parcelable;
    }

    public void n(boolean z4) {
        this.f1712i = this.f1711h.name();
        switch (this.f1704a) {
            case -1:
                if (z4) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 1:
            case 5:
                if (z4) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f1705b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f1706c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f1706c = ((String) this.f1705b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f1706c = (byte[]) this.f1705b;
                return;
            case 4:
            case 6:
                this.f1706c = this.f1705b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            default:
                return;
        }
        this.f1707d = (Parcelable) this.f1705b;
    }

    @Deprecated
    public Icon o() {
        return p((Context) null);
    }

    public Icon p(Context context) {
        return a.g(this, context);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f1704a
            r1 = -1
            if (r0 != r1) goto L_0x000c
            java.lang.Object r0 = r4.f1705b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L_0x000c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f1704a
            java.lang.String r1 = q(r1)
            r0.append(r1)
            int r1 = r4.f1704a
            switch(r1) {
                case 1: goto L_0x006a;
                case 2: goto L_0x0043;
                case 3: goto L_0x002d;
                case 4: goto L_0x0022;
                case 5: goto L_0x006a;
                case 6: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x008a
        L_0x0022:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.f1705b
            r0.append(r1)
            goto L_0x008a
        L_0x002d:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.f1708e
            r0.append(r1)
            int r1 = r4.f1709f
            if (r1 == 0) goto L_0x008a
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f1709f
            goto L_0x0087
        L_0x0043:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.f1713j
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            int r3 = r4.h()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L_0x008a
        L_0x006a:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f1705b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f1705b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
        L_0x0087:
            r0.append(r1)
        L_0x008a:
            android.content.res.ColorStateList r1 = r4.f1710g
            if (r1 == 0) goto L_0x0098
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.f1710g
            r0.append(r1)
        L_0x0098:
            android.graphics.PorterDuff$Mode r1 = r4.f1711h
            android.graphics.PorterDuff$Mode r2 = f1703k
            if (r1 == r2) goto L_0x00a8
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.f1711h
            r0.append(r1)
        L_0x00a8:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }
}
