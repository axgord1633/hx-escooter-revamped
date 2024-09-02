package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.d;

final class z {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1480a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f1481b;

    z(TextView textView) {
        this.f1480a = (TextView) d.h(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f1481b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1480a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    public void b(TextClassifier textClassifier) {
        this.f1481b = textClassifier;
    }
}
