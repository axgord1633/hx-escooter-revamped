package d2;

import android.database.Cursor;
import android.util.Log;
import com.yalantis.ucrop.BuildConfig;
import e2.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class e0 {
    public static List<Object> a(Cursor cursor, int i5) {
        String str;
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            Object b5 = b(cursor, i6);
            if (a.f4498c) {
                String str2 = null;
                if (b5 != null) {
                    if (b5.getClass().isArray()) {
                        str2 = "array(" + b5.getClass().getComponentType().getName() + ")";
                    } else {
                        str2 = b5.getClass().getName();
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("column ");
                sb.append(i6);
                sb.append(" ");
                sb.append(cursor.getType(i6));
                sb.append(": ");
                sb.append(b5);
                if (str2 == null) {
                    str = BuildConfig.FLAVOR;
                } else {
                    str = " (" + str2 + ")";
                }
                sb.append(str);
                Log.d("Sqflite", sb.toString());
            }
            arrayList.add(b5);
        }
        return arrayList;
    }

    public static Object b(Cursor cursor, int i5) {
        int type = cursor.getType(i5);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i5));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i5));
        }
        if (type == 3) {
            return cursor.getString(i5);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i5);
    }

    static Locale c(String str) {
        return Locale.forLanguageTag(str);
    }

    static Locale d(String str) {
        return c(str);
    }
}
