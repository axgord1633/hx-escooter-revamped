package com.yalantis.ucrop.util;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

public class FileUtils {
    private static final String TAG = "FileUtils";

    private FileUtils() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r9v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFile(android.content.Context r8, android.net.Uri r9, android.net.Uri r10) {
        /*
            boolean r0 = r9.equals(r10)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ all -> 0x004f }
            java.io.InputStream r9 = r1.openInputStream(r9)     // Catch:{ all -> 0x004f }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ all -> 0x004a }
            java.io.OutputStream r0 = r8.openOutputStream(r10)     // Catch:{ all -> 0x004a }
            boolean r8 = r9 instanceof java.io.FileInputStream     // Catch:{ all -> 0x004a }
            if (r8 == 0) goto L_0x0042
            boolean r8 = r0 instanceof java.io.FileOutputStream     // Catch:{ all -> 0x004a }
            if (r8 == 0) goto L_0x0042
            r8 = r9
            java.io.FileInputStream r8 = (java.io.FileInputStream) r8     // Catch:{ all -> 0x004a }
            java.nio.channels.FileChannel r1 = r8.getChannel()     // Catch:{ all -> 0x004a }
            r8 = r0
            java.io.FileOutputStream r8 = (java.io.FileOutputStream) r8     // Catch:{ all -> 0x004a }
            java.nio.channels.FileChannel r6 = r8.getChannel()     // Catch:{ all -> 0x004a }
            r2 = 0
            long r4 = r1.size()     // Catch:{ all -> 0x004a }
            r1.transferTo(r2, r4, r6)     // Catch:{ all -> 0x004a }
            if (r9 == 0) goto L_0x003c
            r9.close()
        L_0x003c:
            if (r0 == 0) goto L_0x0041
            r0.close()
        L_0x0041:
            return
        L_0x0042:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x004a }
            java.lang.String r10 = "The input or output URI don't represent a file. uCrop requires then to represent files in order to work properly."
            r8.<init>(r10)     // Catch:{ all -> 0x004a }
            throw r8     // Catch:{ all -> 0x004a }
        L_0x004a:
            r8 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x0051
        L_0x004f:
            r8 = move-exception
            r9 = r0
        L_0x0051:
            if (r0 == 0) goto L_0x0056
            r0.close()
        L_0x0056:
            if (r9 == 0) goto L_0x005b
            r9.close()
        L_0x005b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.FileUtils.copyFile(android.content.Context, android.net.Uri, android.net.Uri):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFile(java.lang.String r10, java.lang.String r11) {
        /*
            boolean r0 = r10.equalsIgnoreCase(r11)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x003d }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x003d }
            r2.<init>(r10)     // Catch:{ all -> 0x003d }
            r1.<init>(r2)     // Catch:{ all -> 0x003d }
            java.nio.channels.FileChannel r10 = r1.getChannel()     // Catch:{ all -> 0x003d }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0038 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0038 }
            r2.<init>(r11)     // Catch:{ all -> 0x0038 }
            r1.<init>(r2)     // Catch:{ all -> 0x0038 }
            java.nio.channels.FileChannel r0 = r1.getChannel()     // Catch:{ all -> 0x0038 }
            r4 = 0
            long r6 = r10.size()     // Catch:{ all -> 0x0038 }
            r3 = r10
            r8 = r0
            r3.transferTo(r4, r6, r8)     // Catch:{ all -> 0x0038 }
            r10.close()
            if (r0 == 0) goto L_0x0037
            r0.close()
        L_0x0037:
            return
        L_0x0038:
            r11 = move-exception
            r9 = r0
            r0 = r10
            r10 = r9
            goto L_0x003f
        L_0x003d:
            r11 = move-exception
            r10 = r0
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            if (r10 == 0) goto L_0x0049
            r10.close()
        L_0x0049:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.FileUtils.copyFile(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r8 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r8 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x0031, all -> 0x002f }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x0031, all -> 0x002f }
            if (r8 == 0) goto L_0x0029
            boolean r9 = r8.moveToFirst()     // Catch:{ IllegalArgumentException -> 0x0027 }
            if (r9 == 0) goto L_0x0029
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ IllegalArgumentException -> 0x0027 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ IllegalArgumentException -> 0x0027 }
            r8.close()
            return r9
        L_0x0027:
            r9 = move-exception
            goto L_0x0033
        L_0x0029:
            if (r8 == 0) goto L_0x004f
        L_0x002b:
            r8.close()
            goto L_0x004f
        L_0x002f:
            r9 = move-exception
            goto L_0x0052
        L_0x0031:
            r9 = move-exception
            r8 = r7
        L_0x0033:
            java.lang.String r10 = "FileUtils"
            java.util.Locale r11 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0050 }
            java.lang.String r0 = "getDataColumn: _data - [%s]"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0050 }
            r2 = 0
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0050 }
            r1[r2] = r9     // Catch:{ all -> 0x0050 }
            java.lang.String r9 = java.lang.String.format(r11, r0, r1)     // Catch:{ all -> 0x0050 }
            android.util.Log.i(r10, r9)     // Catch:{ all -> 0x0050 }
            if (r8 == 0) goto L_0x004f
            goto L_0x002b
        L_0x004f:
            return r7
        L_0x0050:
            r9 = move-exception
            r7 = r8
        L_0x0052:
            if (r7 == 0) goto L_0x0057
            r7.close()
        L_0x0057:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.FileUtils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(documentId)) {
                    try {
                        return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), (String) null, (String[]) null);
                    } catch (NumberFormatException e5) {
                        Log.i(TAG, e5.getMessage());
                        return null;
                    }
                }
            } else if (isMediaDocument(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return isGooglePhotosUri(uri) ? uri.getLastPathSegment() : getDataColumn(context, uri, (String) null, (String[]) null);
        } else {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
