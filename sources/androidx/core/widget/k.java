package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.Spanned;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import q.c;

public final class k {

    static class a {
        static boolean a(TextView textView) {
            return textView.getIncludeFontPadding();
        }

        static int b(TextView textView) {
            return textView.getMaxLines();
        }

        static int c(TextView textView) {
            return textView.getMinLines();
        }
    }

    static class b {
        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        static int b(View view) {
            return view.getLayoutDirection();
        }

        static int c(View view) {
            return view.getTextDirection();
        }

        static Locale d(TextView textView) {
            return textView.getTextLocale();
        }

        static void e(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        static void f(TextView textView, int i5, int i6, int i7, int i8) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i5, i6, i7, i8);
        }

        static void g(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        static void h(View view, int i5) {
            view.setTextDirection(i5);
        }
    }

    static class c {
        static int a(TextView textView) {
            return textView.getBreakStrategy();
        }

        static ColorStateList b(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        static PorterDuff.Mode c(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        static int d(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        static void e(TextView textView, int i5) {
            textView.setBreakStrategy(i5);
        }

        static void f(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        static void g(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        static void h(TextView textView, int i5) {
            textView.setHyphenationFrequency(i5);
        }
    }

    static class d {
        static DecimalFormatSymbols a(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    static class e {
        static String[] a(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        static PrecomputedText.Params b(TextView textView) {
            return textView.getTextMetricsParams();
        }

        static void c(TextView textView, int i5) {
            textView.setFirstBaselineToTopHeight(i5);
        }
    }

    private static class f implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final ActionMode.Callback f2055a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f2056b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f2057c;

        /* renamed from: d  reason: collision with root package name */
        private Method f2058d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2059e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2060f = false;

        f(ActionMode.Callback callback, TextView textView) {
            this.f2055a = callback;
            this.f2056b = textView;
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent putExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !d(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private List<ResolveInfo> c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo next : packageManager.queryIntentActivities(a(), 0)) {
                if (e(next, context)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        private boolean d(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private boolean e(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        private void f(Menu menu) {
            Method method;
            Context context = this.f2056b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f2060f) {
                this.f2060f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f2057c = cls;
                    this.f2058d = cls.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                    this.f2059e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f2057c = null;
                    this.f2058d = null;
                    this.f2059e = false;
                }
            }
            try {
                if (!this.f2059e || !this.f2057c.isInstance(menu)) {
                    method = menu.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                } else {
                    method = this.f2058d;
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        method.invoke(menu, new Object[]{Integer.valueOf(size)});
                    }
                }
                List<ResolveInfo> c5 = c(context, packageManager);
                for (int i5 = 0; i5 < c5.size(); i5++) {
                    ResolveInfo resolveInfo = c5.get(i5);
                    menu.add(0, 0, i5 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f2056b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f2055a.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f2055a.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f2055a.onDestroyActionMode(actionMode);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            f(menu);
            return this.f2055a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static int a(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int b(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    private static int c(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    private static TextDirectionHeuristic d(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z4 = false;
        if (Build.VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (b.b(textView) == 1) {
                z4 = true;
            }
            switch (b.c(textView)) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    return z4 ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        } else {
            byte directionality = Character.getDirectionality(e.a(d.a(b.d(textView)))[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
    }

    public static c.a e(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new c.a(e.b(textView));
        }
        c.a.C0101a aVar = new c.a.C0101a(new TextPaint(textView.getPaint()));
        aVar.b(c.a(textView));
        aVar.c(c.d(textView));
        aVar.d(d(textView));
        return aVar.a();
    }

    public static void f(TextView textView, ColorStateList colorStateList) {
        androidx.core.util.d.h(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            c.f(textView, colorStateList);
        } else if (textView instanceof p) {
            ((p) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    public static void g(TextView textView, PorterDuff.Mode mode) {
        androidx.core.util.d.h(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            c.g(textView, mode);
        } else if (textView instanceof p) {
            ((p) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void h(TextView textView, int i5) {
        androidx.core.util.d.f(i5);
        if (Build.VERSION.SDK_INT >= 28) {
            e.c(textView, i5);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i6 = a.a(textView) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i5 > Math.abs(i6)) {
            textView.setPadding(textView.getPaddingLeft(), i5 + i6, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void i(TextView textView, int i5) {
        androidx.core.util.d.f(i5);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i6 = a.a(textView) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i5 > Math.abs(i6)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i5 - i6);
        }
    }

    public static void j(TextView textView, int i5) {
        androidx.core.util.d.f(i5);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt((Paint.FontMetricsInt) null);
        if (i5 != fontMetricsInt) {
            textView.setLineSpacing((float) (i5 - fontMetricsInt), 1.0f);
        }
    }

    public static void k(TextView textView, q.c cVar) {
        Spanned spanned;
        if (Build.VERSION.SDK_INT >= 29) {
            spanned = cVar.b();
        } else {
            boolean a5 = e(textView).a(cVar.a());
            spanned = cVar;
            if (!a5) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
        }
        textView.setText(spanned);
    }

    public static void l(TextView textView, c.a aVar) {
        b.h(textView, c(aVar.d()));
        textView.getPaint().set(aVar.e());
        c.e(textView, aVar.b());
        c.h(textView, aVar.c());
    }

    public static ActionMode.Callback m(TextView textView, ActionMode.Callback callback) {
        int i5 = Build.VERSION.SDK_INT;
        return (i5 < 26 || i5 > 27 || (callback instanceof f) || callback == null) ? callback : new f(callback, textView);
    }
}
