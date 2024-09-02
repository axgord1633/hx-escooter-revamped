package v4;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import java.io.InputStream;
import java.io.OutputStream;

class a {
    a() {
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ all -> 0x0030 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0030 }
            if (r8 == 0) goto L_0x002a
            boolean r9 = r8.moveToFirst()     // Catch:{ all -> 0x0027 }
            if (r9 == 0) goto L_0x002a
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0027 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ all -> 0x0027 }
            r8.close()
            return r9
        L_0x0027:
            r9 = move-exception
            r7 = r8
            goto L_0x0031
        L_0x002a:
            if (r8 == 0) goto L_0x002f
            r8.close()
        L_0x002f:
            return r7
        L_0x0030:
            r9 = move-exception
        L_0x0031:
            if (r7 == 0) goto L_0x0036
            r7.close()
        L_0x0036:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.a.b(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    private String c(Context context, Uri uri) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (g(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (f(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(documentId)) {
                    try {
                        return b(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), (String) null, (String[]) null);
                    } catch (NumberFormatException unused) {
                        return null;
                    }
                }
            } else if (i(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return b(context, uri2, "_id=?", new String[]{split2[1]});
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return h(uri) ? uri.getLastPathSegment() : b(context, uri, (String) null, (String[]) null);
        } else {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002a */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0031 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x003c A[SYNTHETIC, Splitter:B:30:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0041 A[SYNTHETIC, Splitter:B:34:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x004a A[SYNTHETIC, Splitter:B:42:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x004f A[SYNTHETIC, Splitter:B:46:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String d(android.content.Context r4, android.net.Uri r5) {
        /*
            r0 = 0
            r1 = 0
            android.content.ContentResolver r2 = r4.getContentResolver()     // Catch:{ IOException -> 0x0045, all -> 0x0038 }
            java.io.InputStream r5 = r2.openInputStream(r5)     // Catch:{ IOException -> 0x0045, all -> 0x0038 }
            java.lang.String r2 = "image_picker"
            java.lang.String r3 = "jpg"
            java.io.File r4 = r4.getCacheDir()     // Catch:{ IOException -> 0x0035, all -> 0x0031 }
            java.io.File r4 = java.io.File.createTempFile(r2, r3, r4)     // Catch:{ IOException -> 0x0035, all -> 0x0031 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002f, all -> 0x0031 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x002f, all -> 0x0031 }
            if (r5 == 0) goto L_0x0024
            a(r5, r2)     // Catch:{ IOException -> 0x0048, all -> 0x0022 }
            r3 = 1
            goto L_0x0025
        L_0x0022:
            r4 = move-exception
            goto L_0x0033
        L_0x0024:
            r3 = r0
        L_0x0025:
            if (r5 == 0) goto L_0x002a
            r5.close()     // Catch:{ IOException -> 0x002a }
        L_0x002a:
            r2.close()     // Catch:{ IOException -> 0x0052 }
            r0 = r3
            goto L_0x0052
        L_0x002f:
            r2 = r1
            goto L_0x0048
        L_0x0031:
            r4 = move-exception
            r2 = r1
        L_0x0033:
            r1 = r5
            goto L_0x003a
        L_0x0035:
            r4 = r1
            r2 = r4
            goto L_0x0048
        L_0x0038:
            r4 = move-exception
            r2 = r1
        L_0x003a:
            if (r1 == 0) goto L_0x003f
            r1.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            if (r2 == 0) goto L_0x0044
            r2.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            throw r4
        L_0x0045:
            r4 = r1
            r5 = r4
            r2 = r5
        L_0x0048:
            if (r5 == 0) goto L_0x004d
            r5.close()     // Catch:{ IOException -> 0x004d }
        L_0x004d:
            if (r2 == 0) goto L_0x0052
            r2.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            if (r0 == 0) goto L_0x0058
            java.lang.String r1 = r4.getPath()
        L_0x0058:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.a.d(android.content.Context, android.net.Uri):java.lang.String");
    }

    private static boolean f(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean g(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean h(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    private static boolean i(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* access modifiers changed from: package-private */
    public String e(Context context, Uri uri) {
        String c5 = c(context, uri);
        return c5 == null ? d(context, uri) : c5;
    }
}
