package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class c extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File("/");
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static final HashMap<String, b> sCache = new HashMap<>();
    private int mResourceId;
    private b mStrategy;

    static class a {
        static File[] a(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    interface b {
        File a(Uri uri);

        Uri b(File file);
    }

    /* renamed from: androidx.core.content.c$c  reason: collision with other inner class name */
    static class C0023c implements b {

        /* renamed from: a  reason: collision with root package name */
        private final String f1637a;

        /* renamed from: b  reason: collision with root package name */
        private final HashMap<String, File> f1638b = new HashMap<>();

        C0023c(String str) {
            this.f1637a = str;
        }

        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f1638b.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            } else {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
        }

        public Uri b(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry next : this.f1638b.entrySet()) {
                    String path = ((File) next.getValue()).getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = next;
                    }
                }
                if (entry != null) {
                    String path2 = ((File) entry.getValue()).getPath();
                    boolean endsWith = path2.endsWith("/");
                    int length = path2.length();
                    if (!endsWith) {
                        length++;
                    }
                    String substring = canonicalPath.substring(length);
                    return new Uri.Builder().scheme("content").authority(this.f1637a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f1638b.put(str, file.getCanonicalFile());
                } catch (IOException e5) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e5);
                }
            } else {
                throw new IllegalArgumentException("Name must not be empty");
            }
        }
    }

    public c() {
        this.mResourceId = 0;
    }

    protected c(int i5) {
        this.mResourceId = i5;
    }

    private static File buildPath(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static Object[] copyOf(Object[] objArr, int i5) {
        Object[] objArr2 = new Object[i5];
        System.arraycopy(objArr, 0, objArr2, 0, i5);
        return objArr2;
    }

    private static String[] copyOf(String[] strArr, int i5) {
        String[] strArr2 = new String[i5];
        System.arraycopy(strArr, 0, strArr2, 0, i5);
        return strArr2;
    }

    static XmlResourceParser getFileProviderPathsMetaData(Context context, String str, ProviderInfo providerInfo, int i5) {
        if (providerInfo != null) {
            if (providerInfo.metaData == null && i5 != 0) {
                Bundle bundle = new Bundle(1);
                providerInfo.metaData = bundle;
                bundle.putInt(META_DATA_FILE_PROVIDER_PATHS, i5);
            }
            XmlResourceParser loadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
            if (loadXmlMetaData != null) {
                return loadXmlMetaData;
            }
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
    }

    private static b getPathStrategy(Context context, String str, int i5) {
        b bVar;
        HashMap<String, b> hashMap = sCache;
        synchronized (hashMap) {
            bVar = hashMap.get(str);
            if (bVar == null) {
                try {
                    bVar = parsePathStrategy(context, str, i5);
                    hashMap.put(str, bVar);
                } catch (IOException e5) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e5);
                } catch (XmlPullParserException e6) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e6);
                }
            }
        }
        return bVar;
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        return getPathStrategy(context, str, 0).b(file);
    }

    public static Uri getUriForFile(Context context, String str, File file, String str2) {
        return getUriForFile(context, str, file).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, str2).build();
    }

    private static int modeToMode(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    private static b parsePathStrategy(Context context, String str, int i5) {
        C0023c cVar = new C0023c(str);
        XmlResourceParser fileProviderPathsMetaData = getFileProviderPathsMetaData(context, str, context.getPackageManager().resolveContentProvider(str, 128), i5);
        while (true) {
            int next = fileProviderPathsMetaData.next();
            if (next == 1) {
                return cVar;
            }
            if (next == 2) {
                String name = fileProviderPathsMetaData.getName();
                File file = null;
                String attributeValue = fileProviderPathsMetaData.getAttributeValue((String) null, ATTR_NAME);
                String attributeValue2 = fileProviderPathsMetaData.getAttributeValue((String) null, ATTR_PATH);
                if (TAG_ROOT_PATH.equals(name)) {
                    file = DEVICE_ROOT;
                } else if (TAG_FILES_PATH.equals(name)) {
                    file = context.getFilesDir();
                } else if (TAG_CACHE_PATH.equals(name)) {
                    file = context.getCacheDir();
                } else if (TAG_EXTERNAL.equals(name)) {
                    file = Environment.getExternalStorageDirectory();
                } else if (TAG_EXTERNAL_FILES.equals(name)) {
                    File[] e5 = a.e(context, (String) null);
                    if (e5.length > 0) {
                        file = e5[0];
                    }
                } else if (TAG_EXTERNAL_CACHE.equals(name)) {
                    File[] d5 = a.d(context);
                    if (d5.length > 0) {
                        file = d5[0];
                    }
                } else if (TAG_EXTERNAL_MEDIA.equals(name)) {
                    File[] a5 = a.a(context);
                    if (a5.length > 0) {
                        file = a5[0];
                    }
                }
                if (file != null) {
                    cVar.c(attributeValue, buildPath(file, attributeValue2));
                }
            }
        }
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            String str = providerInfo.authority.split(";")[0];
            HashMap<String, b> hashMap = sCache;
            synchronized (hashMap) {
                hashMap.remove(str);
            }
            this.mStrategy = getPathStrategy(context, str, this.mResourceId);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.mStrategy.a(uri).delete() ? 1 : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r3 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(r3.getName().substring(r0 + 1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getType(android.net.Uri r3) {
        /*
            r2 = this;
            androidx.core.content.c$b r0 = r2.mStrategy
            java.io.File r3 = r0.a(r3)
            java.lang.String r0 = r3.getName()
            r1 = 46
            int r0 = r0.lastIndexOf(r1)
            if (r0 < 0) goto L_0x0027
            java.lang.String r3 = r3.getName()
            int r0 = r0 + 1
            java.lang.String r3 = r3.substring(r0)
            android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r3 = r0.getMimeTypeFromExtension(r3)
            if (r3 == 0) goto L_0x0027
            return r3
        L_0x0027:
            java.lang.String r3 = "application/octet-stream"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.c.getType(android.net.Uri):java.lang.String");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(this.mStrategy.a(uri), modeToMode(str));
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i5;
        File a5 = this.mStrategy.a(uri);
        String queryParameter = uri.getQueryParameter(DISPLAYNAME_FIELD);
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i6 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i6] = "_display_name";
                i5 = i6 + 1;
                objArr[i6] = queryParameter == null ? a5.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i6] = "_size";
                i5 = i6 + 1;
                objArr[i6] = Long.valueOf(a5.length());
            }
            i6 = i5;
        }
        String[] copyOf = copyOf(strArr3, i6);
        Object[] copyOf2 = copyOf(objArr, i6);
        MatrixCursor matrixCursor = new MatrixCursor(copyOf, 1);
        matrixCursor.addRow(copyOf2);
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
