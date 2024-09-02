package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.core.content.res.e;
import androidx.core.provider.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<byte[]> f1805a = new c();

    static class a {
        static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    private static List<byte[]> b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (!Arrays.equals(list.get(i5), list2.get(i5))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> d(e eVar, Resources resources) {
        return eVar.b() != null ? eVar.b() : e.c(resources, eVar.c());
    }

    static g.a e(Context context, e eVar, CancellationSignal cancellationSignal) {
        ProviderInfo f5 = f(context.getPackageManager(), eVar, context.getResources());
        return f5 == null ? g.a.a(1, (g.b[]) null) : g.a.a(0, h(context, eVar, f5.authority, cancellationSignal));
    }

    static ProviderInfo f(PackageManager packageManager, e eVar, Resources resources) {
        String e5 = eVar.e();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e5, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + e5);
        } else if (resolveContentProvider.packageName.equals(eVar.f())) {
            List<byte[]> b5 = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(b5, f1805a);
            List<List<byte[]>> d5 = d(eVar, resources);
            for (int i5 = 0; i5 < d5.size(); i5++) {
                ArrayList arrayList = new ArrayList(d5.get(i5));
                Collections.sort(arrayList, f1805a);
                if (c(b5, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + e5 + ", but package was not " + eVar.f());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i5 = 0; i5 < bArr.length; i5++) {
            byte b5 = bArr[i5];
            byte b6 = bArr2[i5];
            if (b5 != b6) {
                return b5 - b6;
            }
        }
        return 0;
    }

    static g.b[] h(Context context, e eVar, String str, CancellationSignal cancellationSignal) {
        boolean z4;
        int i5;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str2).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
        Cursor cursor = null;
        try {
            int i6 = 0;
            cursor = a.a(context.getContentResolver(), build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{eVar.g()}, (String) null, cancellationSignal);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i7 = columnIndex != -1 ? cursor.getInt(columnIndex) : i6;
                    int i8 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : i6;
                    int i9 = i7;
                    Uri withAppendedId = columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    int i10 = columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400;
                    if (columnIndex6 == -1 || cursor.getInt(columnIndex6) != 1) {
                        i5 = i9;
                        z4 = false;
                    } else {
                        i5 = i9;
                        z4 = true;
                    }
                    arrayList2.add(g.b.a(withAppendedId, i8, i10, z4, i5));
                    i6 = 0;
                }
                arrayList = arrayList2;
            }
            return (g.b[]) arrayList.toArray(new g.b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
