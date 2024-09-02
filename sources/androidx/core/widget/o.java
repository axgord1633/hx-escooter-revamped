package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.c;
import androidx.core.view.g0;

public final class o implements g0 {

    private static final class a {
        static CharSequence a(Context context, ClipData.Item item, int i5) {
            if ((i5 & 1) == 0) {
                return item.coerceToStyledText(context);
            }
            CharSequence coerceToText = item.coerceToText(context);
            return coerceToText instanceof Spanned ? coerceToText.toString() : coerceToText;
        }
    }

    private static CharSequence b(Context context, ClipData.Item item, int i5) {
        return a.a(context, item, i5);
    }

    private static void c(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    public c a(View view, c cVar) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + cVar);
        }
        if (cVar.d() == 2) {
            return cVar;
        }
        ClipData b5 = cVar.b();
        int c5 = cVar.c();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z4 = false;
        for (int i5 = 0; i5 < b5.getItemCount(); i5++) {
            CharSequence b6 = b(context, b5.getItemAt(i5), c5);
            if (b6 != null) {
                if (!z4) {
                    c(editable, b6);
                    z4 = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), b6);
                }
            }
        }
        return null;
    }
}
