package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.h;
import androidx.appcompat.widget.h0;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.l0;
import androidx.appcompat.widget.m;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.p;
import androidx.appcompat.widget.s;
import androidx.appcompat.widget.t;
import androidx.appcompat.widget.w;
import androidx.appcompat.widget.y;
import androidx.core.view.k0;
import com.yalantis.ucrop.BuildConfig;
import d.j;
import h.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import m.g;

public class k {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?>[] f698b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f699c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f700d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e  reason: collision with root package name */
    private static final g<String, Constructor<? extends View>> f701e = new g<>();

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f702a = new Object[2];

    private static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        private final View f703e;

        /* renamed from: f  reason: collision with root package name */
        private final String f704f;

        /* renamed from: g  reason: collision with root package name */
        private Method f705g;

        /* renamed from: h  reason: collision with root package name */
        private Context f706h;

        public a(View view, String str) {
            this.f703e = view;
            this.f704f = str;
        }

        private void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f704f, new Class[]{View.class})) != null) {
                        this.f705g = method;
                        this.f706h = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f703e.getId();
            if (id == -1) {
                str = BuildConfig.FLAVOR;
            } else {
                str = " with id '" + this.f703e.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f704f + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f703e.getClass() + str);
        }

        public void onClick(View view) {
            if (this.f705g == null) {
                a(this.f703e.getContext());
            }
            try {
                this.f705g.invoke(this.f706h, new Object[]{view});
            } catch (IllegalAccessException e5) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e5);
            } catch (InvocationTargetException e6) {
                throw new IllegalStateException("Could not execute method for android:onClick", e6);
            }
        }
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && k0.x(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f699c);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View r(Context context, String str, String str2) {
        String str3;
        g<String, Constructor<? extends View>> gVar = f701e;
        Constructor<? extends U> constructor = gVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f698b);
            gVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f702a);
    }

    private View s(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        try {
            Object[] objArr = this.f702a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                int i5 = 0;
                while (true) {
                    String[] strArr = f700d;
                    if (i5 < strArr.length) {
                        View r5 = r(context, str, strArr[i5]);
                        if (r5 != null) {
                            return r5;
                        }
                        i5++;
                    } else {
                        Object[] objArr2 = this.f702a;
                        objArr2[0] = null;
                        objArr2[1] = null;
                        return null;
                    }
                }
            } else {
                View r6 = r(context, str, (String) null);
                Object[] objArr3 = this.f702a;
                objArr3[0] = null;
                objArr3[1] = null;
                return r6;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr4 = this.f702a;
            objArr4[0] = null;
            objArr4[1] = null;
        }
    }

    private static Context t(Context context, AttributeSet attributeSet, boolean z4, boolean z5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f4219x3, 0, 0);
        int resourceId = z4 ? obtainStyledAttributes.getResourceId(j.f4224y3, 0) : 0;
        if (z5 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(j.f4229z3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? (!(context instanceof d) || ((d) context).c() != resourceId) ? new d(context, resourceId) : context : context;
    }

    private void u(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    /* access modifiers changed from: protected */
    public androidx.appcompat.widget.d b(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.d(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public f c(Context context, AttributeSet attributeSet) {
        return new f(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public androidx.appcompat.widget.g d(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.g(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public h e(Context context, AttributeSet attributeSet) {
        return new h(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public androidx.appcompat.widget.k f(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.k(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public m g(Context context, AttributeSet attributeSet) {
        return new m(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public o h(Context context, AttributeSet attributeSet) {
        return new o(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public p i(Context context, AttributeSet attributeSet) {
        return new p(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public s j(Context context, AttributeSet attributeSet) {
        return new s(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public t k(Context context, AttributeSet attributeSet) {
        return new t(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public w l(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public y m(Context context, AttributeSet attributeSet) {
        return new y(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public h0 n(Context context, AttributeSet attributeSet) {
        return new h0(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public l0 o(Context context, AttributeSet attributeSet) {
        return new l0(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public View p(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final View q(View view, String str, Context context, AttributeSet attributeSet, boolean z4, boolean z5, boolean z6, boolean z7) {
        View view2;
        Context context2 = (!z4 || view == null) ? context : view.getContext();
        if (z5 || z6) {
            context2 = t(context2, attributeSet, z5, z6);
        }
        if (z7) {
            context2 = h1.b(context2);
        }
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c5 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c5 = 3;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c5 = 4;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c5 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c5 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c5 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c5 = 8;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c5 = 9;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c5 = 10;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c5 = 11;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c5 = 12;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c5 = 13;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                view2 = k(context2, attributeSet);
                break;
            case 1:
                view2 = e(context2, attributeSet);
                break;
            case 2:
                view2 = i(context2, attributeSet);
                break;
            case 3:
                view2 = n(context2, attributeSet);
                break;
            case 4:
                view2 = g(context2, attributeSet);
                break;
            case 5:
                view2 = l(context2, attributeSet);
                break;
            case 6:
                view2 = m(context2, attributeSet);
                break;
            case 7:
                view2 = j(context2, attributeSet);
                break;
            case 8:
                view2 = o(context2, attributeSet);
                break;
            case 9:
                view2 = h(context2, attributeSet);
                break;
            case 10:
                view2 = b(context2, attributeSet);
                break;
            case 11:
                view2 = d(context2, attributeSet);
                break;
            case 12:
                view2 = f(context2, attributeSet);
                break;
            case 13:
                view2 = c(context2, attributeSet);
                break;
            default:
                view2 = p(context2, str, attributeSet);
                break;
        }
        u(view2, str);
        if (view2 == null && context != context2) {
            view2 = s(context2, str, attributeSet);
        }
        if (view2 != null) {
            a(view2, attributeSet);
        }
        return view2;
    }
}
