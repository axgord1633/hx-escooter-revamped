package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;

public class c extends j {

    /* renamed from: g  reason: collision with root package name */
    final AlertController f618g = new AlertController(getContext(), this, getWindow());

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.b f619a;

        /* renamed from: b  reason: collision with root package name */
        private final int f620b;

        public a(Context context) {
            this(context, c.f(context, 0));
        }

        public a(Context context, int i5) {
            this.f619a = new AlertController.b(new ContextThemeWrapper(context, c.f(context, i5)));
            this.f620b = i5;
        }

        public c a() {
            c cVar = new c(this.f619a.f578a, this.f620b);
            this.f619a.a(cVar.f618g);
            cVar.setCancelable(this.f619a.f595r);
            if (this.f619a.f595r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f619a.f596s);
            cVar.setOnDismissListener(this.f619a.f597t);
            DialogInterface.OnKeyListener onKeyListener = this.f619a.f598u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        public Context b() {
            return this.f619a.f578a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f619a;
            bVar.f600w = listAdapter;
            bVar.f601x = onClickListener;
            return this;
        }

        public a d(View view) {
            this.f619a.f584g = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.f619a.f581d = drawable;
            return this;
        }

        public a f(DialogInterface.OnKeyListener onKeyListener) {
            this.f619a.f598u = onKeyListener;
            return this;
        }

        public a g(ListAdapter listAdapter, int i5, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f619a;
            bVar.f600w = listAdapter;
            bVar.f601x = onClickListener;
            bVar.I = i5;
            bVar.H = true;
            return this;
        }

        public a h(CharSequence charSequence) {
            this.f619a.f583f = charSequence;
            return this;
        }
    }

    protected c(Context context, int i5) {
        super(context, f(context, i5));
    }

    static int f(Context context, int i5) {
        if (((i5 >>> 24) & 255) >= 1) {
            return i5;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(d.a.f3976o, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f618g.d();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f618g.e();
    }

    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        if (this.f618g.f(i5, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i5, keyEvent);
    }

    public boolean onKeyUp(int i5, KeyEvent keyEvent) {
        if (this.f618g.g(i5, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i5, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f618g.p(charSequence);
    }
}
