package r;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.d;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f6661a = new String[0];

    private static class a {
        static void a(EditorInfo editorInfo, CharSequence charSequence, int i5) {
            editorInfo.setInitialSurroundingSubText(charSequence, i5);
        }
    }

    public static String[] a(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            return strArr != null ? strArr : f6661a;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return f6661a;
        }
        String[] stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        }
        return stringArray != null ? stringArray : f6661a;
    }

    private static boolean b(CharSequence charSequence, int i5, int i6) {
        if (i6 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i5));
        }
        if (i6 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i5));
    }

    private static boolean c(int i5) {
        int i6 = i5 & 4095;
        return i6 == 129 || i6 == 225 || i6 == 18;
    }

    public static void d(EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }

    public static void e(EditorInfo editorInfo, CharSequence charSequence, int i5) {
        d.h(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            a.a(editorInfo, charSequence, i5);
            return;
        }
        int i6 = editorInfo.initialSelStart;
        int i7 = editorInfo.initialSelEnd;
        int i8 = i6 > i7 ? i7 - i5 : i6 - i5;
        int i9 = i6 > i7 ? i6 - i5 : i7 - i5;
        int length = charSequence.length();
        if (i5 < 0 || i8 < 0 || i9 > length) {
            g(editorInfo, (CharSequence) null, 0, 0);
        } else if (c(editorInfo.inputType)) {
            g(editorInfo, (CharSequence) null, 0, 0);
        } else if (length <= 2048) {
            g(editorInfo, charSequence, i8, i9);
        } else {
            h(editorInfo, charSequence, i8, i9);
        }
    }

    public static void f(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.a(editorInfo, charSequence, 0);
        } else {
            e(editorInfo, charSequence, 0);
        }
    }

    private static void g(EditorInfo editorInfo, CharSequence charSequence, int i5, int i6) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i5);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i6);
    }

    private static void h(EditorInfo editorInfo, CharSequence charSequence, int i5, int i6) {
        int i7 = i6 - i5;
        int i8 = i7 > 1024 ? 0 : i7;
        int i9 = 2048 - i8;
        int min = Math.min(charSequence.length() - i6, i9 - Math.min(i5, (int) (((double) i9) * 0.8d)));
        int min2 = Math.min(i5, i9 - min);
        int i10 = i5 - min2;
        if (b(charSequence, i10, 0)) {
            i10++;
            min2--;
        }
        if (b(charSequence, (i6 + min) - 1, 1)) {
            min--;
        }
        CharSequence concat = i8 != i7 ? TextUtils.concat(new CharSequence[]{charSequence.subSequence(i10, i10 + min2), charSequence.subSequence(i6, min + i6)}) : charSequence.subSequence(i10, min2 + i8 + min + i10);
        int i11 = min2 + 0;
        g(editorInfo, concat, i11, i8 + i11);
    }
}
