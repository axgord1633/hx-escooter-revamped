package com.mr.flutter.plugin.filepicker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.mr.flutter.plugin.filepicker.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class c {
    public static boolean a(Context context) {
        try {
            File[] listFiles = new File(context.getCacheDir() + "/file_picker/").listFiles();
            if (listFiles == null) {
                return true;
            }
            for (File delete : listFiles) {
                delete.delete();
            }
            return true;
        } catch (Exception e5) {
            Log.e("FilePickerUtils", "There was an error while clearing cached files: " + e5.toString());
            return false;
        }
    }

    private static String b(Class<?> cls, Object obj) {
        try {
            if (Build.VERSION.SDK_INT < 30) {
                return (String) cls.getMethod("getPath", new Class[0]).invoke(obj, new Object[0]);
            }
            File file = (File) cls.getMethod("getDirectory", new Class[0]).invoke(obj, new Object[0]);
            if (file != null) {
                return file.getPath();
            }
            return null;
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r2 = r2[1];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(android.net.Uri r2) {
        /*
            java.lang.String r2 = android.provider.DocumentsContract.getTreeDocumentId(r2)
            java.lang.String r0 = ":"
            java.lang.String[] r2 = r2.split(r0)
            int r0 = r2.length
            r1 = 2
            if (r0 < r1) goto L_0x0014
            r0 = 1
            r2 = r2[r0]
            if (r2 == 0) goto L_0x0014
            return r2
        L_0x0014:
            java.lang.String r2 = java.io.File.separator
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mr.flutter.plugin.filepicker.c.c(android.net.Uri):java.lang.String");
    }

    public static String d(Uri uri, Context context) {
        Cursor query;
        String str = null;
        try {
            if (uri.getScheme().equals("content")) {
                query = context.getContentResolver().query(uri, new String[]{"_display_name"}, (String) null, (String[]) null, (String) null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_display_name"));
                    }
                }
                query.close();
            }
            if (str != null) {
                return str;
            }
            String path = uri.getPath();
            int lastIndexOf = path.lastIndexOf(47);
            return lastIndexOf != -1 ? path.substring(lastIndexOf + 1) : path;
        } catch (Exception e5) {
            Log.e("FilePickerUtils", "Failed to handle file name: " + e5.toString());
            return null;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    public static String e(Uri uri, Context context) {
        if (uri == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 30 || !i(uri)) {
            String h5 = h(g(uri), context);
            new a.C0068a();
            if (h5 == null) {
                return File.separator;
            }
            String str = File.separator;
            if (h5.endsWith(str)) {
                h5 = h5.substring(0, h5.length() - 1);
            }
            String c5 = c(uri);
            if (c5.endsWith(str)) {
                c5 = c5.substring(0, c5.length() - 1);
            }
            if (c5.length() <= 0) {
                return h5;
            }
            if (c5.startsWith(str)) {
                return h5 + c5;
            }
            return h5 + str + c5;
        }
        String documentId = DocumentsContract.getDocumentId(uri);
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        if (documentId.equals("downloads")) {
            return path;
        }
        if (documentId.matches("^ms[df]\\:.*")) {
            String d5 = d(uri, context);
            return path + "/" + d5;
        } else if (documentId.startsWith("raw:")) {
            return documentId.split(":")[1];
        } else {
            return null;
        }
    }

    public static String[] f(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            String str = arrayList.get(i5);
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
            if (mimeTypeFromExtension == null) {
                Log.w("FilePickerUtils", "Custom file type " + arrayList.get(i5) + " is unsupported and will be ignored.");
            } else {
                arrayList2.add(mimeTypeFromExtension);
                if (str.equals("csv")) {
                    arrayList2.add("text/csv");
                }
            }
        }
        Log.d("FilePickerUtils", "Allowed file extensions mimes: " + arrayList2);
        return (String[]) arrayList2.toArray(new String[0]);
    }

    private static String g(Uri uri) {
        String[] split = DocumentsContract.getTreeDocumentId(uri).split(":");
        if (split.length > 0) {
            return split[0];
        }
        return null;
    }

    private static String h(String str, Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getUuid", new Class[0]);
            Method method3 = cls.getMethod("isPrimary", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            if (invoke == null) {
                return null;
            }
            int length = Array.getLength(invoke);
            for (int i5 = 0; i5 < length; i5++) {
                Object obj = Array.get(invoke, i5);
                String str2 = (String) method2.invoke(obj, new Object[0]);
                if (((Boolean) method3.invoke(obj, new Object[0])) != null && "primary".equals(str)) {
                    return b(cls, obj);
                }
                if (str2 != null && str2.equals(str)) {
                    return b(cls, obj);
                }
            }
            return null;
        } catch (Exception unused) {
        }
    }

    private static boolean i(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static void j(File file, a.C0068a aVar) {
        String str;
        try {
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                bufferedInputStream.read(bArr, 0, length);
                bufferedInputStream.close();
            } catch (FileNotFoundException e5) {
                str = "File not found: " + e5.getMessage();
            } catch (IOException e6) {
                str = "Failed to close file streams: " + e6.getMessage();
            }
            aVar.b(bArr);
            Log.e("FilePickerUtils", str, (Throwable) null);
            aVar.b(bArr);
        } catch (Exception e7) {
            Log.e("FilePickerUtils", "Failed to load bytes into memory with error " + e7.toString() + ". Probably the file is too big to fit device memory. Bytes won't be added to the file this time.");
        }
    }

    public static a k(Context context, Uri uri, boolean z4) {
        FileOutputStream fileOutputStream;
        StringBuilder sb;
        String str;
        Log.i("FilePickerUtils", "Caching from URI: " + uri.toString());
        a.C0068a aVar = new a.C0068a();
        String d5 = d(uri, context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getCacheDir().getAbsolutePath());
        sb2.append("/file_picker/");
        sb2.append(d5 != null ? d5 : Long.valueOf(System.currentTimeMillis()));
        String sb3 = sb2.toString();
        File file = new File(sb3);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(sb3);
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    fileOutputStream.getFD().sync();
                } catch (Exception e5) {
                    e = e5;
                    try {
                        fileOutputStream.close();
                        sb = new StringBuilder();
                        str = "Failed to retrieve path: ";
                    } catch (IOException | NullPointerException unused) {
                        sb = new StringBuilder();
                        str = "Failed to close file streams: ";
                    }
                    sb.append(str);
                    sb.append(e.getMessage());
                    Log.e("FilePickerUtils", sb.toString(), (Throwable) null);
                    return null;
                } catch (Throwable th) {
                    fileOutputStream.getFD().sync();
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                fileOutputStream.close();
                sb = new StringBuilder();
                str = "Failed to retrieve path: ";
                sb.append(str);
                sb.append(e.getMessage());
                Log.e("FilePickerUtils", sb.toString(), (Throwable) null);
                return null;
            }
        }
        Log.d("FilePickerUtils", "File loaded and cached at:" + sb3);
        if (z4) {
            j(file, aVar);
        }
        aVar.d(sb3).c(d5).f(uri).e(Long.parseLong(String.valueOf(file.length())));
        return aVar.a();
    }
}
