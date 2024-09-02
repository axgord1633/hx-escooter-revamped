package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;
import androidx.core.view.c;
import androidx.core.view.k0;
import r.c;
import r.d;

final class u {

    class a implements c.C0105c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f1419a;

        a(View view) {
            this.f1419a = view;
        }

        public boolean a(d dVar, int i5, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 25 && (i5 & 1) != 0) {
                try {
                    dVar.d();
                    InputContentInfo inputContentInfo = (InputContentInfo) dVar.e();
                    bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                    bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
                } catch (Exception e5) {
                    Log.w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e5);
                    return false;
                }
            }
            return k0.H(this.f1419a, new c.a(new ClipData(dVar.b(), new ClipData.Item(dVar.a())), 2).d(dVar.c()).b(bundle).a()) == null;
        }
    }

    private static final class b {
        /* JADX INFO: finally extract failed */
        static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
            DragAndDropPermissions unused = activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                k0.H(textView, new c.a(dragEvent.getClipData(), 3).a());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        static boolean b(DragEvent dragEvent, View view, Activity activity) {
            DragAndDropPermissions unused = activity.requestDragAndDropPermissions(dragEvent);
            k0.H(view, new c.a(dragEvent.getClipData(), 3).a());
            return true;
        }
    }

    static c.C0105c a(View view) {
        return new a(view);
    }

    static boolean b(View view, DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null && k0.s(view) != null) {
            Activity d5 = d(view);
            if (d5 == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
                return false;
            } else if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            } else {
                if (dragEvent.getAction() == 3) {
                    return view instanceof TextView ? b.a(dragEvent, (TextView) view, d5) : b.b(dragEvent, view, d5);
                }
            }
        }
        return false;
    }

    static boolean c(TextView textView, int i5) {
        int i6 = 0;
        if ((i5 != 16908322 && i5 != 16908337) || k0.s(textView) == null) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            c.a aVar = new c.a(primaryClip, 1);
            if (i5 != 16908322) {
                i6 = 1;
            }
            k0.H(textView, aVar.c(i6).a());
        }
        return true;
    }

    static Activity d(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
