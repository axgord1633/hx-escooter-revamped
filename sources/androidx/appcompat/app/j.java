package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.f;
import h.b;

public class j extends Dialog implements e {

    /* renamed from: e  reason: collision with root package name */
    private f f695e;

    /* renamed from: f  reason: collision with root package name */
    private final f.a f696f = new a();

    class a implements f.a {
        a() {
        }

        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return j.this.c(keyEvent);
        }
    }

    public j(Context context, int i5) {
        super(context, b(context, i5));
        f a5 = a();
        a5.G(b(context, i5));
        a5.r((Bundle) null);
    }

    private static int b(Context context, int i5) {
        if (i5 != 0) {
            return i5;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(d.a.f3986y, typedValue, true);
        return typedValue.resourceId;
    }

    public f a() {
        if (this.f695e == null) {
            this.f695e = f.h(this, this);
        }
        return this.f695e;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().d(view, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean d(int i5) {
        return a().A(i5);
    }

    public void dismiss() {
        super.dismiss();
        a().s();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return f.e(this.f696f, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i5) {
        return a().i(i5);
    }

    public void invalidateOptionsMenu() {
        a().p();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        a().o();
        super.onCreate(bundle);
        a().r(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        a().x();
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public void setContentView(int i5) {
        a().C(i5);
    }

    public void setContentView(View view) {
        a().D(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().E(view, layoutParams);
    }

    public void setTitle(int i5) {
        super.setTitle(i5);
        a().H(getContext().getString(i5));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().H(charSequence);
    }
}
