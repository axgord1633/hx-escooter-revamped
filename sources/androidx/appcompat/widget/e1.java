package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.yalantis.ucrop.BuildConfig;
import d.f;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;
import s.c;

class e1 extends c implements View.OnClickListener {
    private int A = -1;
    private int B = -1;
    private int C = -1;

    /* renamed from: p  reason: collision with root package name */
    private final SearchView f1209p;

    /* renamed from: q  reason: collision with root package name */
    private final SearchableInfo f1210q;

    /* renamed from: r  reason: collision with root package name */
    private final Context f1211r;

    /* renamed from: s  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1212s;

    /* renamed from: t  reason: collision with root package name */
    private final int f1213t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f1214u = false;

    /* renamed from: v  reason: collision with root package name */
    private int f1215v = 1;

    /* renamed from: w  reason: collision with root package name */
    private ColorStateList f1216w;

    /* renamed from: x  reason: collision with root package name */
    private int f1217x = -1;

    /* renamed from: y  reason: collision with root package name */
    private int f1218y = -1;

    /* renamed from: z  reason: collision with root package name */
    private int f1219z = -1;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f1220a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1221b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f1222c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f1223d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f1224e;

        public a(View view) {
            this.f1220a = (TextView) view.findViewById(16908308);
            this.f1221b = (TextView) view.findViewById(16908309);
            this.f1222c = (ImageView) view.findViewById(16908295);
            this.f1223d = (ImageView) view.findViewById(16908296);
            this.f1224e = (ImageView) view.findViewById(f.f4054q);
        }
    }

    public e1(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f1209p = searchView;
        this.f1210q = searchableInfo;
        this.f1213t = searchView.getSuggestionCommitIconResId();
        this.f1211r = context;
        this.f1212s = weakHashMap;
    }

    private void A(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable j(String str) {
        Drawable.ConstantState constantState = this.f1212s.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence k(CharSequence charSequence) {
        if (this.f1216w == null) {
            TypedValue typedValue = new TypedValue();
            this.f1211r.getTheme().resolveAttribute(d.a.J, typedValue, true);
            this.f1216w = this.f1211r.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f1216w, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable l(ComponentName componentName) {
        String obj;
        PackageManager packageManager = this.f1211r.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            obj = "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString();
            Log.w("SuggestionsAdapter", obj);
            return null;
        } catch (PackageManager.NameNotFoundException e5) {
            obj = e5.toString();
        }
    }

    private Drawable m(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f1212s.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f1212s.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f1211r.getResources());
        }
        Drawable l5 = l(componentName);
        if (l5 != null) {
            constantState = l5.getConstantState();
        }
        this.f1212s.put(flattenToShortString, constantState);
        return l5;
    }

    public static String n(Cursor cursor, String str) {
        return v(cursor, cursor.getColumnIndex(str));
    }

    private Drawable o() {
        Drawable m5 = m(this.f1210q.getSearchActivity());
        return m5 != null ? m5 : this.f1211r.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable p(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Error closing icon stream for "
            java.lang.String r1 = "SuggestionsAdapter"
            r2 = 0
            java.lang.String r3 = r7.getScheme()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "android.resource"
            boolean r3 = r4.equals(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x002d
            android.graphics.drawable.Drawable r7 = r6.q(r7)     // Catch:{ NotFoundException -> 0x0016 }
            return r7
        L_0x0016:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "Resource does not exist: "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x002d:
            android.content.Context r3 = r6.f1211r     // Catch:{ FileNotFoundException -> 0x0085 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.io.InputStream r3 = r3.openInputStream(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x006e
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromStream(r3, r2)     // Catch:{ all -> 0x0055 }
            r3.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0054
        L_0x0041:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0054:
            return r4
        L_0x0055:
            r4 = move-exception
            r3.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x006d
        L_0x005a:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006d:
            throw r4     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006e:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "Failed to open "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0085:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Icon not found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = ", "
            r3.append(r7)
            java.lang.String r7 = r0.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            android.util.Log.w(r1, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e1.p(android.net.Uri):android.graphics.drawable.Drawable");
    }

    private Drawable r(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1211r.getPackageName() + "/" + parseInt;
            Drawable j5 = j(str2);
            if (j5 != null) {
                return j5;
            }
            Drawable c5 = androidx.core.content.a.c(this.f1211r, parseInt);
            z(str2, c5);
            return c5;
        } catch (NumberFormatException unused) {
            Drawable j6 = j(str);
            if (j6 != null) {
                return j6;
            }
            Drawable p5 = p(Uri.parse(str));
            z(str, p5);
            return p5;
        } catch (Resources.NotFoundException unused2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable s(Cursor cursor) {
        int i5 = this.A;
        if (i5 == -1) {
            return null;
        }
        Drawable r5 = r(cursor.getString(i5));
        return r5 != null ? r5 : o();
    }

    private Drawable t(Cursor cursor) {
        int i5 = this.B;
        if (i5 == -1) {
            return null;
        }
        return r(cursor.getString(i5));
    }

    private static String v(Cursor cursor, int i5) {
        if (i5 == -1) {
            return null;
        }
        try {
            return cursor.getString(i5);
        } catch (Exception e5) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e5);
            return null;
        }
    }

    private void x(ImageView imageView, Drawable drawable, int i5) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i5);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void y(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    private void z(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1212s.put(str, drawable.getConstantState());
        }
    }

    public void a(Cursor cursor) {
        if (this.f1214u) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f1217x = cursor.getColumnIndex("suggest_text_1");
                this.f1218y = cursor.getColumnIndex("suggest_text_2");
                this.f1219z = cursor.getColumnIndex("suggest_text_2_url");
                this.A = cursor.getColumnIndex("suggest_icon_1");
                this.B = cursor.getColumnIndex("suggest_icon_2");
                this.C = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e5) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e5);
        }
    }

    public Cursor c(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? BuildConfig.FLAVOR : charSequence.toString();
        if (this.f1209p.getVisibility() == 0 && this.f1209p.getWindowVisibility() == 0) {
            try {
                Cursor u5 = u(this.f1210q, charSequence2, 50);
                if (u5 != null) {
                    u5.getCount();
                    return u5;
                }
            } catch (RuntimeException e5) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e5);
            }
        }
        return null;
    }

    public CharSequence convertToString(Cursor cursor) {
        String n5;
        String n6;
        if (cursor == null) {
            return null;
        }
        String n7 = n(cursor, "suggest_intent_query");
        if (n7 != null) {
            return n7;
        }
        if (this.f1210q.shouldRewriteQueryFromData() && (n6 = n(cursor, "suggest_intent_data")) != null) {
            return n6;
        }
        if (!this.f1210q.shouldRewriteQueryFromText() || (n5 = n(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return n5;
    }

    public void d(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i5 = this.C;
        int i6 = i5 != -1 ? cursor.getInt(i5) : 0;
        if (aVar.f1220a != null) {
            y(aVar.f1220a, v(cursor, this.f1217x));
        }
        if (aVar.f1221b != null) {
            String v5 = v(cursor, this.f1219z);
            CharSequence k5 = v5 != null ? k(v5) : v(cursor, this.f1218y);
            if (TextUtils.isEmpty(k5)) {
                TextView textView = aVar.f1220a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1220a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1220a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1220a.setMaxLines(1);
                }
            }
            y(aVar.f1221b, k5);
        }
        ImageView imageView = aVar.f1222c;
        if (imageView != null) {
            x(imageView, s(cursor), 4);
        }
        ImageView imageView2 = aVar.f1223d;
        if (imageView2 != null) {
            x(imageView2, t(cursor), 8);
        }
        int i7 = this.f1215v;
        if (i7 == 2 || (i7 == 1 && (i6 & 1) != 0)) {
            aVar.f1224e.setVisibility(0);
            aVar.f1224e.setTag(aVar.f1220a.getText());
            aVar.f1224e.setOnClickListener(this);
            return;
        }
        aVar.f1224e.setVisibility(8);
    }

    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        View g5 = super.g(context, cursor, viewGroup);
        g5.setTag(new a(g5));
        ((ImageView) g5.findViewById(f.f4054q)).setImageResource(this.f1213t);
        return g5;
    }

    public View getDropDownView(int i5, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i5, view, viewGroup);
        } catch (RuntimeException e5) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e5);
            View f5 = f(this.f1211r, b(), viewGroup);
            if (f5 != null) {
                ((a) f5.getTag()).f1220a.setText(e5.toString());
            }
            return f5;
        }
    }

    public View getView(int i5, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i5, view, viewGroup);
        } catch (RuntimeException e5) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e5);
            View g5 = g(this.f1211r, b(), viewGroup);
            if (g5 != null) {
                ((a) g5.getTag()).f1220a.setText(e5.toString());
            }
            return g5;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        A(b());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        A(b());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1209p.Q((CharSequence) tag);
        }
    }

    /* access modifiers changed from: package-private */
    public Drawable q(Uri uri) {
        int i5;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f1211r.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i5 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i5 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i5 != 0) {
                        return resourcesForApplication.getDrawable(i5);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    /* access modifiers changed from: package-private */
    public Cursor u(SearchableInfo searchableInfo, String str, int i5) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query(BuildConfig.FLAVOR).fragment(BuildConfig.FLAVOR);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i5 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i5));
        }
        return this.f1211r.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr2, (String) null);
    }

    public void w(int i5) {
        this.f1215v = i5;
    }
}
