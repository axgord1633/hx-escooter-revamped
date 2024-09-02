package h;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.widget.k1;
import androidx.appcompat.widget.o0;
import androidx.core.view.y;
import d.j;
import i.c;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    static final Class<?>[] f4791e;

    /* renamed from: f  reason: collision with root package name */
    static final Class<?>[] f4792f;

    /* renamed from: a  reason: collision with root package name */
    final Object[] f4793a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f4794b;

    /* renamed from: c  reason: collision with root package name */
    Context f4795c;

    /* renamed from: d  reason: collision with root package name */
    private Object f4796d;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?>[] f4797c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        private Object f4798a;

        /* renamed from: b  reason: collision with root package name */
        private Method f4799b;

        public a(Object obj, String str) {
            this.f4798a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f4799b = cls.getMethod(str, f4797c);
            } catch (Exception e5) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e5);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f4799b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f4799b.invoke(this.f4798a, new Object[]{menuItem})).booleanValue();
                }
                this.f4799b.invoke(this.f4798a, new Object[]{menuItem});
                return true;
            } catch (Exception e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    private class b {
        androidx.core.view.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f4800a;

        /* renamed from: b  reason: collision with root package name */
        private int f4801b;

        /* renamed from: c  reason: collision with root package name */
        private int f4802c;

        /* renamed from: d  reason: collision with root package name */
        private int f4803d;

        /* renamed from: e  reason: collision with root package name */
        private int f4804e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f4805f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f4806g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f4807h;

        /* renamed from: i  reason: collision with root package name */
        private int f4808i;

        /* renamed from: j  reason: collision with root package name */
        private int f4809j;

        /* renamed from: k  reason: collision with root package name */
        private CharSequence f4810k;

        /* renamed from: l  reason: collision with root package name */
        private CharSequence f4811l;

        /* renamed from: m  reason: collision with root package name */
        private int f4812m;

        /* renamed from: n  reason: collision with root package name */
        private char f4813n;

        /* renamed from: o  reason: collision with root package name */
        private int f4814o;

        /* renamed from: p  reason: collision with root package name */
        private char f4815p;

        /* renamed from: q  reason: collision with root package name */
        private int f4816q;

        /* renamed from: r  reason: collision with root package name */
        private int f4817r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f4818s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f4819t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f4820u;

        /* renamed from: v  reason: collision with root package name */
        private int f4821v;

        /* renamed from: w  reason: collision with root package name */
        private int f4822w;

        /* renamed from: x  reason: collision with root package name */
        private String f4823x;

        /* renamed from: y  reason: collision with root package name */
        private String f4824y;

        /* renamed from: z  reason: collision with root package name */
        private String f4825z;

        public b(Menu menu) {
            this.f4800a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f4795c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e5) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e5);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z4 = false;
            menuItem.setChecked(this.f4818s).setVisible(this.f4819t).setEnabled(this.f4820u).setCheckable(this.f4817r >= 1).setTitleCondensed(this.f4811l).setIcon(this.f4812m);
            int i5 = this.f4821v;
            if (i5 >= 0) {
                menuItem.setShowAsAction(i5);
            }
            if (this.f4825z != null) {
                if (!g.this.f4795c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f4825z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f4817r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof c) {
                    ((c) menuItem).h(true);
                }
            }
            String str = this.f4823x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f4791e, g.this.f4793a));
                z4 = true;
            }
            int i6 = this.f4822w;
            if (i6 > 0) {
                if (!z4) {
                    menuItem.setActionView(i6);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            androidx.core.view.b bVar = this.A;
            if (bVar != null) {
                y.a(menuItem, bVar);
            }
            y.c(menuItem, this.B);
            y.g(menuItem, this.C);
            y.b(menuItem, this.f4813n, this.f4814o);
            y.f(menuItem, this.f4815p, this.f4816q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                y.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                y.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f4807h = true;
            i(this.f4800a.add(this.f4801b, this.f4808i, this.f4809j, this.f4810k));
        }

        public SubMenu b() {
            this.f4807h = true;
            SubMenu addSubMenu = this.f4800a.addSubMenu(this.f4801b, this.f4808i, this.f4809j, this.f4810k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f4807h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f4795c.obtainStyledAttributes(attributeSet, j.f4187r1);
            this.f4801b = obtainStyledAttributes.getResourceId(j.f4197t1, 0);
            this.f4802c = obtainStyledAttributes.getInt(j.f4207v1, 0);
            this.f4803d = obtainStyledAttributes.getInt(j.f4212w1, 0);
            this.f4804e = obtainStyledAttributes.getInt(j.f4217x1, 0);
            this.f4805f = obtainStyledAttributes.getBoolean(j.f4202u1, true);
            this.f4806g = obtainStyledAttributes.getBoolean(j.f4192s1, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            k1 t5 = k1.t(g.this.f4795c, attributeSet, j.f4222y1);
            this.f4808i = t5.m(j.B1, 0);
            this.f4809j = (t5.j(j.E1, this.f4802c) & -65536) | (t5.j(j.F1, this.f4803d) & 65535);
            this.f4810k = t5.o(j.G1);
            this.f4811l = t5.o(j.H1);
            this.f4812m = t5.m(j.f4227z1, 0);
            this.f4813n = c(t5.n(j.I1));
            this.f4814o = t5.j(j.P1, 4096);
            this.f4815p = c(t5.n(j.J1));
            this.f4816q = t5.j(j.T1, 4096);
            int i5 = j.K1;
            this.f4817r = t5.r(i5) ? t5.a(i5, false) : this.f4804e;
            this.f4818s = t5.a(j.C1, false);
            this.f4819t = t5.a(j.D1, this.f4805f);
            this.f4820u = t5.a(j.A1, this.f4806g);
            this.f4821v = t5.j(j.U1, -1);
            this.f4825z = t5.n(j.L1);
            this.f4822w = t5.m(j.M1, 0);
            this.f4823x = t5.n(j.O1);
            String n5 = t5.n(j.N1);
            this.f4824y = n5;
            boolean z4 = n5 != null;
            if (z4 && this.f4822w == 0 && this.f4823x == null) {
                this.A = (androidx.core.view.b) e(n5, g.f4792f, g.this.f4794b);
            } else {
                if (z4) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = t5.o(j.Q1);
            this.C = t5.o(j.V1);
            int i6 = j.S1;
            if (t5.r(i6)) {
                this.E = o0.c(t5.j(i6, -1), this.E);
            } else {
                this.E = null;
            }
            int i7 = j.R1;
            if (t5.r(i7)) {
                this.D = t5.c(i7);
            } else {
                this.D = null;
            }
            t5.v();
            this.f4807h = false;
        }

        public void h() {
            this.f4801b = 0;
            this.f4802c = 0;
            this.f4803d = 0;
            this.f4804e = 0;
            this.f4805f = true;
            this.f4806g = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            f4791e = r0
            f4792f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.g.<clinit>():void");
    }

    public g(Context context) {
        super(context);
        this.f4795c = context;
        Object[] objArr = {context};
        this.f4793a = objArr;
        this.f4794b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z4 = false;
        boolean z5 = false;
        while (!z4) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z5 && name2.equals(str)) {
                            str = null;
                            z5 = false;
                        } else if (name2.equals("group")) {
                            bVar.h();
                        } else if (name2.equals("item")) {
                            if (!bVar.d()) {
                                androidx.core.view.b bVar2 = bVar.A;
                                if (bVar2 == null || !bVar2.a()) {
                                    bVar.a();
                                } else {
                                    bVar.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z4 = true;
                        }
                    }
                } else if (!z5) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.f(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.g(attributeSet);
                    } else if (name3.equals("menu")) {
                        c(xmlPullParser, attributeSet, bVar.b());
                    } else {
                        str = name3;
                        z5 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object b() {
        if (this.f4796d == null) {
            this.f4796d = a(this.f4795c);
        }
        return this.f4796d;
    }

    public void inflate(int i5, Menu menu) {
        if (!(menu instanceof o.a)) {
            super.inflate(i5, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f4795c.getResources().getLayout(i5);
            c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e5) {
            throw new InflateException("Error inflating menu XML", e5);
        } catch (IOException e6) {
            throw new InflateException("Error inflating menu XML", e6);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
