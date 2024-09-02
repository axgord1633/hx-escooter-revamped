package h;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import d.i;

public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f4773a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f4774b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f4775c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f4776d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f4777e;

    public d() {
        super((Context) null);
    }

    public d(Context context, int i5) {
        super(context);
        this.f4773a = i5;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f4774b = theme;
    }

    private Resources b() {
        if (this.f4777e == null) {
            Configuration configuration = this.f4776d;
            this.f4777e = configuration == null ? super.getResources() : createConfigurationContext(configuration).getResources();
        }
        return this.f4777e;
    }

    private void d() {
        boolean z4 = this.f4774b == null;
        if (z4) {
            this.f4774b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f4774b.setTo(theme);
            }
        }
        e(this.f4774b, this.f4773a, z4);
    }

    public void a(Configuration configuration) {
        if (this.f4777e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f4776d == null) {
            this.f4776d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f4773a;
    }

    /* access modifiers changed from: protected */
    public void e(Resources.Theme theme, int i5, boolean z4) {
        theme.applyStyle(i5, true);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f4775c == null) {
            this.f4775c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f4775c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f4774b;
        if (theme != null) {
            return theme;
        }
        if (this.f4773a == 0) {
            this.f4773a = i.f4099d;
        }
        d();
        return this.f4774b;
    }

    public void setTheme(int i5) {
        if (this.f4773a != i5) {
            this.f4773a = i5;
            d();
        }
    }
}
