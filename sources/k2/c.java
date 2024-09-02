package k2;

import android.view.View;
import io.flutter.util.ViewUtils;

public final /* synthetic */ class c implements ViewUtils.ViewVisitor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class[] f5520a;

    public /* synthetic */ c(Class[] clsArr) {
        this.f5520a = clsArr;
    }

    public final boolean run(View view) {
        return ViewUtils.lambda$hasChildViewOfType$1(this.f5520a, view);
    }
}
