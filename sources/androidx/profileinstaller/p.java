package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final androidx.concurrent.futures.c<c> f2677a = androidx.concurrent.futures.c.q();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f2678b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static c f2679c = null;

    private static class a {
        static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f2680a;

        /* renamed from: b  reason: collision with root package name */
        final int f2681b;

        /* renamed from: c  reason: collision with root package name */
        final long f2682c;

        /* renamed from: d  reason: collision with root package name */
        final long f2683d;

        b(int i5, int i6, long j5, long j6) {
            this.f2680a = i5;
            this.f2681b = i6;
            this.f2682c = j5;
            this.f2683d = j6;
        }

        static b a(File file) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        /* access modifiers changed from: package-private */
        public void b(File file) {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f2680a);
                dataOutputStream.writeInt(this.f2681b);
                dataOutputStream.writeLong(this.f2682c);
                dataOutputStream.writeLong(this.f2683d);
                dataOutputStream.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f2681b == bVar.f2681b && this.f2682c == bVar.f2682c && this.f2680a == bVar.f2680a && this.f2683d == bVar.f2683d;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.f2681b), Long.valueOf(this.f2682c), Integer.valueOf(this.f2680a), Long.valueOf(this.f2683d)});
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final int f2684a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2685b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f2686c;

        c(int i5, boolean z4, boolean z5) {
            this.f2684a = i5;
            this.f2686c = z5;
            this.f2685b = z4;
        }
    }

    private static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return (Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context) : packageManager.getPackageInfo(context.getPackageName(), 0)).lastUpdateTime;
    }

    private static c b(int i5, boolean z4, boolean z5) {
        c cVar = new c(i5, z4, z5);
        f2679c = cVar;
        f2677a.o(cVar);
        return f2679c;
    }

    static c c(Context context, boolean z4) {
        b bVar;
        c cVar;
        if (!z4 && (cVar = f2679c) != null) {
            return cVar;
        }
        synchronized (f2678b) {
            if (!z4) {
                c cVar2 = f2679c;
                if (cVar2 != null) {
                    return cVar2;
                }
            }
            int i5 = Build.VERSION.SDK_INT;
            int i6 = 0;
            if (i5 >= 28) {
                if (i5 != 30) {
                    File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                    long length = file.length();
                    boolean z5 = file.exists() && length > 0;
                    File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                    long length2 = file2.length();
                    boolean z6 = file2.exists() && length2 > 0;
                    try {
                        long a5 = a(context);
                        File file3 = new File(context.getFilesDir(), "profileInstalled");
                        b bVar2 = null;
                        if (file3.exists()) {
                            try {
                                bVar2 = b.a(file3);
                            } catch (IOException unused) {
                                return b(131072, z5, z6);
                            }
                        }
                        if (bVar2 != null && bVar2.f2682c == a5) {
                            int i7 = bVar2.f2681b;
                            if (i7 != 2) {
                                i6 = i7;
                                if (z4 && z6 && i6 != 1) {
                                    i6 = 2;
                                }
                                if (bVar2 != null && bVar2.f2681b == 2 && i6 == 1 && length < bVar2.f2683d) {
                                    i6 = 3;
                                }
                                bVar = new b(1, i6, a5, length2);
                                if (bVar2 == null || !bVar2.equals(bVar)) {
                                    bVar.b(file3);
                                }
                                c b5 = b(i6, z5, z6);
                                return b5;
                            }
                        }
                        if (z5) {
                            i6 = 1;
                        } else if (z6) {
                            i6 = 2;
                        }
                        i6 = 2;
                        i6 = 3;
                        bVar = new b(1, i6, a5, length2);
                        try {
                            bVar.b(file3);
                        } catch (IOException unused2) {
                            i6 = 196608;
                        }
                        c b52 = b(i6, z5, z6);
                        return b52;
                    } catch (PackageManager.NameNotFoundException unused3) {
                        return b(65536, z5, z6);
                    }
                }
            }
            c b6 = b(262144, false, false);
            return b6;
        }
    }
}
