package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.q1;
import androidx.core.app.j;
import androidx.core.app.x0;
import androidx.fragment.app.e;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;
import androidx.savedstate.a;
import h.b;

public class d extends e implements e, x0.a {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private f mDelegate;
    private Resources mResources;

    class a implements a.c {
        a() {
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            d.this.getDelegate().v(bundle);
            return bundle;
        }
    }

    class b implements b.b {
        b() {
        }

        public void a(Context context) {
            f delegate = d.this.getDelegate();
            delegate.o();
            delegate.r(d.this.getSavedStateRegistry().b(d.DELEGATE_TAG));
        }
    }

    public d() {
        initDelegate();
    }

    public d(int i5) {
        super(i5);
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().h(DELEGATE_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private void initViewTreeOwners() {
        g0.a(getWindow().getDecorView(), this);
        h0.a(getWindow().getDecorView(), this);
        y.e.a(getWindow().getDecorView(), this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r0 = getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean performMenuItemShortcut(android.view.KeyEvent r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L_0x003e
            boolean r0 = r3.isCtrlPressed()
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getMetaState()
            boolean r0 = android.view.KeyEvent.metaStateHasNoModifiers(r0)
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getRepeatCount()
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getKeyCode()
            boolean r0 = android.view.KeyEvent.isModifierKey(r0)
            if (r0 != 0) goto L_0x003e
            android.view.Window r0 = r2.getWindow()
            if (r0 == 0) goto L_0x003e
            android.view.View r1 = r0.getDecorView()
            if (r1 == 0) goto L_0x003e
            android.view.View r0 = r0.getDecorView()
            boolean r3 = r0.dispatchKeyShortcutEvent(r3)
            if (r3 == 0) goto L_0x003e
            r3 = 1
            return r3
        L_0x003e:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.d.performMenuItemShortcut(android.view.KeyEvent):boolean");
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().d(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().f(context));
    }

    public void closeOptionsMenu() {
        a supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.g()) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.p(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public <T extends View> T findViewById(int i5) {
        return getDelegate().i(i5);
    }

    public f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = f.g(this, this);
        }
        return this.mDelegate;
    }

    public b getDrawerToggleDelegate() {
        return getDelegate().k();
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().m();
    }

    public Resources getResources() {
        if (this.mResources == null && q1.c()) {
            this.mResources = new q1(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public a getSupportActionBar() {
        return getDelegate().n();
    }

    public Intent getSupportParentActivityIntent() {
        return j.a(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().p();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        getDelegate().q(configuration);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(x0 x0Var) {
        x0Var.e(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getDelegate().s();
    }

    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i5, keyEvent);
    }

    public final boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.j() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public boolean onMenuOpened(int i5, Menu menu) {
        return super.onMenuOpened(i5, menu);
    }

    /* access modifiers changed from: protected */
    public void onNightModeChanged(int i5) {
    }

    public void onPanelClosed(int i5, Menu menu) {
        super.onPanelClosed(i5, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().t(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        getDelegate().u();
    }

    public void onPrepareSupportNavigateUpTaskStack(x0 x0Var) {
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        getDelegate().w();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().x();
    }

    public void onSupportActionModeFinished(h.b bVar) {
    }

    public void onSupportActionModeStarted(h.b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            x0 i5 = x0.i(this);
            onCreateSupportNavigateUpTaskStack(i5);
            onPrepareSupportNavigateUpTaskStack(i5);
            i5.l();
            try {
                androidx.core.app.b.j(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i5) {
        super.onTitleChanged(charSequence, i5);
        getDelegate().H(charSequence);
    }

    public h.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public void openOptionsMenu() {
        a supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.q()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i5) {
        initViewTreeOwners();
        getDelegate().C(i5);
    }

    public void setContentView(View view) {
        initViewTreeOwners();
        getDelegate().D(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().E(view, layoutParams);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().F(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i5) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z4) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z4) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z4) {
    }

    public void setTheme(int i5) {
        super.setTheme(i5);
        getDelegate().G(i5);
    }

    public h.b startSupportActionMode(b.a aVar) {
        return getDelegate().I(aVar);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().p();
    }

    public void supportNavigateUpTo(Intent intent) {
        j.e(this, intent);
    }

    public boolean supportRequestWindowFeature(int i5) {
        return getDelegate().A(i5);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return j.f(this, intent);
    }
}
