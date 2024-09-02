package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.k0;
import com.yalantis.ucrop.BuildConfig;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends s0 implements h.c {

    /* renamed from: u0  reason: collision with root package name */
    static final n f1039u0 = (Build.VERSION.SDK_INT < 29 ? new n() : null);
    final ImageView A;
    private final View B;
    private p C;
    private Rect D;
    private Rect E;
    private int[] F;
    private int[] G;
    private final ImageView H;
    private final Drawable I;
    private final int J;
    private final int K;
    private final Intent L;
    private final Intent M;
    private final CharSequence N;
    private l O;
    private k P;
    View.OnFocusChangeListener Q;
    private m R;
    private View.OnClickListener S;
    private boolean T;
    private boolean U;
    s.a V;
    private boolean W;

    /* renamed from: a0  reason: collision with root package name */
    private CharSequence f1040a0;

    /* renamed from: b0  reason: collision with root package name */
    private boolean f1041b0;

    /* renamed from: c0  reason: collision with root package name */
    private boolean f1042c0;

    /* renamed from: d0  reason: collision with root package name */
    private int f1043d0;

    /* renamed from: e0  reason: collision with root package name */
    private boolean f1044e0;

    /* renamed from: f0  reason: collision with root package name */
    private CharSequence f1045f0;

    /* renamed from: g0  reason: collision with root package name */
    private CharSequence f1046g0;

    /* renamed from: h0  reason: collision with root package name */
    private boolean f1047h0;

    /* renamed from: i0  reason: collision with root package name */
    private int f1048i0;

    /* renamed from: j0  reason: collision with root package name */
    SearchableInfo f1049j0;

    /* renamed from: k0  reason: collision with root package name */
    private Bundle f1050k0;

    /* renamed from: l0  reason: collision with root package name */
    private final Runnable f1051l0;

    /* renamed from: m0  reason: collision with root package name */
    private Runnable f1052m0;

    /* renamed from: n0  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1053n0;

    /* renamed from: o0  reason: collision with root package name */
    private final View.OnClickListener f1054o0;

    /* renamed from: p0  reason: collision with root package name */
    View.OnKeyListener f1055p0;

    /* renamed from: q0  reason: collision with root package name */
    private final TextView.OnEditorActionListener f1056q0;

    /* renamed from: r0  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f1057r0;

    /* renamed from: s0  reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f1058s0;

    /* renamed from: t  reason: collision with root package name */
    final SearchAutoComplete f1059t;

    /* renamed from: t0  reason: collision with root package name */
    private TextWatcher f1060t0;

    /* renamed from: u  reason: collision with root package name */
    private final View f1061u;

    /* renamed from: v  reason: collision with root package name */
    private final View f1062v;

    /* renamed from: w  reason: collision with root package name */
    private final View f1063w;

    /* renamed from: x  reason: collision with root package name */
    final ImageView f1064x;

    /* renamed from: y  reason: collision with root package name */
    final ImageView f1065y;

    /* renamed from: z  reason: collision with root package name */
    final ImageView f1066z;

    public static class SearchAutoComplete extends d {

        /* renamed from: h  reason: collision with root package name */
        private int f1067h;

        /* renamed from: i  reason: collision with root package name */
        private SearchView f1068i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f1069j;

        /* renamed from: k  reason: collision with root package name */
        final Runnable f1070k;

        class a implements Runnable {
            a() {
            }

            public void run() {
                SearchAutoComplete.this.c();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, d.a.f3977p);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i5) {
            super(context, attributeSet, i5);
            this.f1070k = new a();
            this.f1067h = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i5 = configuration.screenWidthDp;
            int i6 = configuration.screenHeightDp;
            if (i5 >= 960 && i6 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i5 < 600) {
                return (i5 < 640 || i6 < 480) ? 160 : 192;
            }
            return 192;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.f1039u0.c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (this.f1069j) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1069j = false;
            }
        }

        public boolean enoughToFilter() {
            return this.f1067h <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1069j) {
                removeCallbacks(this.f1070k);
                post(this.f1070k);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z4, int i5, Rect rect) {
            super.onFocusChanged(z4, i5, rect);
            this.f1068i.V();
        }

        public boolean onKeyPreIme(int i5, KeyEvent keyEvent) {
            if (i5 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1068i.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i5, keyEvent);
        }

        public void onWindowFocusChanged(boolean z4) {
            super.onWindowFocusChanged(z4);
            if (z4 && this.f1068i.hasFocus() && getVisibility() == 0) {
                this.f1069j = true;
                if (SearchView.I(getContext())) {
                    a();
                }
            }
        }

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z4) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z4) {
                this.f1069j = false;
                removeCallbacks(this.f1070k);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f1069j = false;
                removeCallbacks(this.f1070k);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f1069j = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.f1068i = searchView;
        }

        public void setThreshold(int i5) {
            super.setThreshold(i5);
            this.f1067h = i5;
        }
    }

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }

        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            SearchView.this.U(charSequence);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            SearchView.this.b0();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            s.a aVar = SearchView.this.V;
            if (aVar instanceof e1) {
                aVar.a((Cursor) null);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        public void onFocusChange(View view, boolean z4) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.Q;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z4);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {
        e() {
        }

        public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            SearchView.this.x();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f1064x) {
                searchView.R();
            } else if (view == searchView.f1066z) {
                searchView.N();
            } else if (view == searchView.f1065y) {
                searchView.S();
            } else if (view == searchView.A) {
                searchView.W();
            } else if (view == searchView.f1059t) {
                searchView.D();
            }
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        public boolean onKey(View view, int i5, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f1049j0 == null) {
                return false;
            }
            if (searchView.f1059t.isPopupShowing() && SearchView.this.f1059t.getListSelection() != -1) {
                return SearchView.this.T(view, i5, keyEvent);
            }
            if (SearchView.this.f1059t.b() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i5 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.L(0, (String) null, searchView2.f1059t.getText().toString());
            return true;
        }
    }

    class h implements TextView.OnEditorActionListener {
        h() {
        }

        public boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
            SearchView.this.S();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
            SearchView.this.O(i5, 0, (String) null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i5, long j5) {
            SearchView.this.P(i5);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public interface k {
        boolean a();
    }

    public interface l {
        boolean a(String str);

        boolean b(String str);
    }

    public interface m {
        boolean a(int i5);

        boolean b(int i5);
    }

    private static class n {

        /* renamed from: a  reason: collision with root package name */
        private Method f1082a = null;

        /* renamed from: b  reason: collision with root package name */
        private Method f1083b = null;

        /* renamed from: c  reason: collision with root package name */
        private Method f1084c = null;

        n() {
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1082a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1083b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1084c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        /* access modifiers changed from: package-private */
        public void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1083b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1082a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1084c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.TRUE});
                } catch (Exception unused) {
                }
            }
        }
    }

    static class o extends t.a {
        public static final Parcelable.Creator<o> CREATOR = new a();

        /* renamed from: g  reason: collision with root package name */
        boolean f1085g;

        class a implements Parcelable.ClassLoaderCreator<o> {
            a() {
            }

            /* renamed from: a */
            public o createFromParcel(Parcel parcel) {
                return new o(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }

            /* renamed from: c */
            public o[] newArray(int i5) {
                return new o[i5];
            }
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1085g = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1085g + "}";
        }

        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeValue(Boolean.valueOf(this.f1085g));
        }
    }

    private static class p extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f1086a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f1087b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final Rect f1088c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        private final Rect f1089d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        private final int f1090e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1091f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1090e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f1086a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f1087b.set(rect);
            this.f1089d.set(rect);
            Rect rect3 = this.f1089d;
            int i5 = this.f1090e;
            rect3.inset(-i5, -i5);
            this.f1088c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r9) {
            /*
                r8 = this;
                float r0 = r9.getX()
                int r0 = (int) r0
                float r1 = r9.getY()
                int r1 = (int) r1
                int r2 = r9.getAction()
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x0033
                if (r2 == r4) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003f
            L_0x001b:
                boolean r2 = r8.f1091f
                r8.f1091f = r5
                goto L_0x002f
            L_0x0020:
                boolean r2 = r8.f1091f
                if (r2 == 0) goto L_0x002f
                android.graphics.Rect r6 = r8.f1089d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x002f
                r4 = r2
                r2 = r5
                goto L_0x0041
            L_0x002f:
                r7 = r4
                r4 = r2
                r2 = r7
                goto L_0x0041
            L_0x0033:
                android.graphics.Rect r2 = r8.f1087b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003f
                r8.f1091f = r4
                r2 = r4
                goto L_0x0041
            L_0x003f:
                r2 = r4
                r4 = r5
            L_0x0041:
                if (r4 == 0) goto L_0x0070
                if (r2 == 0) goto L_0x005d
                android.graphics.Rect r2 = r8.f1088c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x005d
                android.view.View r0 = r8.f1086a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r8.f1086a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                goto L_0x0066
            L_0x005d:
                android.graphics.Rect r2 = r8.f1088c
                int r3 = r2.left
                int r0 = r0 - r3
                float r0 = (float) r0
                int r2 = r2.top
                int r1 = r1 - r2
            L_0x0066:
                float r1 = (float) r1
                r9.setLocation(r0, r1)
                android.view.View r0 = r8.f1086a
                boolean r5 = r0.dispatchTouchEvent(r9)
            L_0x0070:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.p.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.G);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.D = new Rect();
        this.E = new Rect();
        this.F = new int[2];
        this.G = new int[2];
        this.f1051l0 = new b();
        this.f1052m0 = new c();
        this.f1053n0 = new WeakHashMap<>();
        f fVar = new f();
        this.f1054o0 = fVar;
        this.f1055p0 = new g();
        h hVar = new h();
        this.f1056q0 = hVar;
        i iVar = new i();
        this.f1057r0 = iVar;
        j jVar = new j();
        this.f1058s0 = jVar;
        this.f1060t0 = new a();
        k1 u5 = k1.u(context, attributeSet, d.j.f4143i2, i5, 0);
        LayoutInflater.from(context).inflate(u5.m(d.j.f4193s2, d.g.f4081r), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(d.f.D);
        this.f1059t = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1061u = findViewById(d.f.f4063z);
        View findViewById = findViewById(d.f.C);
        this.f1062v = findViewById;
        View findViewById2 = findViewById(d.f.J);
        this.f1063w = findViewById2;
        ImageView imageView = (ImageView) findViewById(d.f.f4061x);
        this.f1064x = imageView;
        ImageView imageView2 = (ImageView) findViewById(d.f.A);
        this.f1065y = imageView2;
        ImageView imageView3 = (ImageView) findViewById(d.f.f4062y);
        this.f1066z = imageView3;
        ImageView imageView4 = (ImageView) findViewById(d.f.E);
        this.A = imageView4;
        ImageView imageView5 = (ImageView) findViewById(d.f.B);
        this.H = imageView5;
        k0.P(findViewById, u5.f(d.j.f4198t2));
        k0.P(findViewById2, u5.f(d.j.f4218x2));
        int i6 = d.j.f4213w2;
        imageView.setImageDrawable(u5.f(i6));
        imageView2.setImageDrawable(u5.f(d.j.f4183q2));
        imageView3.setImageDrawable(u5.f(d.j.f4168n2));
        imageView4.setImageDrawable(u5.f(d.j.f4228z2));
        imageView5.setImageDrawable(u5.f(i6));
        this.I = u5.f(d.j.f4208v2);
        n1.a(imageView, getResources().getString(d.h.f4095l));
        this.J = u5.m(d.j.f4223y2, d.g.f4080q);
        this.K = u5.m(d.j.f4173o2, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f1060t0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f1055p0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(u5.a(d.j.f4188r2, true));
        int e5 = u5.e(d.j.f4153k2, -1);
        if (e5 != -1) {
            setMaxWidth(e5);
        }
        this.N = u5.o(d.j.f4178p2);
        this.f1040a0 = u5.o(d.j.f4203u2);
        int j5 = u5.j(d.j.f4163m2, -1);
        if (j5 != -1) {
            setImeOptions(j5);
        }
        int j6 = u5.j(d.j.f4158l2, -1);
        if (j6 != -1) {
            setInputType(j6);
        }
        setFocusable(u5.a(d.j.f4148j2, true));
        u5.v();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.L = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.M = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.B = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        g0(this.T);
        c0();
    }

    private Intent A(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1050k0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i5 = 1;
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i5 = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i5);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent B(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void C() {
        this.f1059t.dismissDropDown();
    }

    private void E(View view, Rect rect) {
        view.getLocationInWindow(this.F);
        getLocationInWindow(this.G);
        int[] iArr = this.F;
        int i5 = iArr[1];
        int[] iArr2 = this.G;
        int i6 = i5 - iArr2[1];
        int i7 = iArr[0] - iArr2[0];
        rect.set(i7, i6, view.getWidth() + i7, view.getHeight() + i6);
    }

    private CharSequence F(CharSequence charSequence) {
        if (!this.T || this.I == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1059t.getTextSize()) * 1.25d);
        this.I.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.I), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean G() {
        SearchableInfo searchableInfo = this.f1049j0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1049j0.getVoiceSearchLaunchWebSearch()) {
            intent = this.L;
        } else if (this.f1049j0.getVoiceSearchLaunchRecognizer()) {
            intent = this.M;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean I(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean J() {
        return (this.W || this.f1044e0) && !H();
    }

    private void K(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e5) {
                Log.e("SearchView", "Failed launch activity: " + intent, e5);
            }
        }
    }

    private boolean M(int i5, int i6, String str) {
        Cursor b5 = this.V.b();
        if (b5 == null || !b5.moveToPosition(i5)) {
            return false;
        }
        K(z(b5, i6, str));
        return true;
    }

    private void X() {
        post(this.f1051l0);
    }

    private void Y(int i5) {
        CharSequence convertToString;
        Editable text = this.f1059t.getText();
        Cursor b5 = this.V.b();
        if (b5 != null) {
            if (!b5.moveToPosition(i5) || (convertToString = this.V.convertToString(b5)) == null) {
                setQuery(text);
            } else {
                setQuery(convertToString);
            }
        }
    }

    private void a0() {
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f1059t.getText());
        int i5 = 0;
        if (!z5 && (!this.T || this.f1047h0)) {
            z4 = false;
        }
        ImageView imageView = this.f1066z;
        if (!z4) {
            i5 = 8;
        }
        imageView.setVisibility(i5);
        Drawable drawable = this.f1066z.getDrawable();
        if (drawable != null) {
            drawable.setState(z5 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void c0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1059t;
        if (queryHint == null) {
            queryHint = BuildConfig.FLAVOR;
        }
        searchAutoComplete.setHint(F(queryHint));
    }

    private void d0() {
        this.f1059t.setThreshold(this.f1049j0.getSuggestThreshold());
        this.f1059t.setImeOptions(this.f1049j0.getImeOptions());
        int inputType = this.f1049j0.getInputType();
        int i5 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1049j0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f1059t.setInputType(inputType);
        s.a aVar = this.V;
        if (aVar != null) {
            aVar.a((Cursor) null);
        }
        if (this.f1049j0.getSuggestAuthority() != null) {
            e1 e1Var = new e1(getContext(), this, this.f1049j0, this.f1053n0);
            this.V = e1Var;
            this.f1059t.setAdapter(e1Var);
            e1 e1Var2 = (e1) this.V;
            if (this.f1041b0) {
                i5 = 2;
            }
            e1Var2.w(i5);
        }
    }

    private void e0() {
        this.f1063w.setVisibility((!J() || !(this.f1065y.getVisibility() == 0 || this.A.getVisibility() == 0)) ? 8 : 0);
    }

    private void f0(boolean z4) {
        this.f1065y.setVisibility((!this.W || !J() || !hasFocus() || (!z4 && this.f1044e0)) ? 8 : 0);
    }

    private void g0(boolean z4) {
        this.U = z4;
        int i5 = 0;
        int i6 = z4 ? 0 : 8;
        boolean z5 = !TextUtils.isEmpty(this.f1059t.getText());
        this.f1064x.setVisibility(i6);
        f0(z5);
        this.f1061u.setVisibility(z4 ? 8 : 0);
        if (this.H.getDrawable() == null || this.T) {
            i5 = 8;
        }
        this.H.setVisibility(i5);
        a0();
        h0(!z5);
        e0();
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(d.d.f4003g);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(d.d.f4004h);
    }

    private void h0(boolean z4) {
        int i5 = 8;
        if (this.f1044e0 && !H() && z4) {
            this.f1065y.setVisibility(8);
            i5 = 0;
        }
        this.A.setVisibility(i5);
    }

    private void setQuery(CharSequence charSequence) {
        this.f1059t.setText(charSequence);
        this.f1059t.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private Intent y(String str, Uri uri, String str2, String str3, int i5, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1046g0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1050k0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i5 != 0) {
            intent.putExtra("action_key", i5);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1049j0.getSearchActivity());
        return intent;
    }

    private Intent z(Cursor cursor, int i5, String str) {
        int i6;
        String n5;
        try {
            String n6 = e1.n(cursor, "suggest_intent_action");
            if (n6 == null) {
                n6 = this.f1049j0.getSuggestIntentAction();
            }
            if (n6 == null) {
                n6 = "android.intent.action.SEARCH";
            }
            String str2 = n6;
            String n7 = e1.n(cursor, "suggest_intent_data");
            if (n7 == null) {
                n7 = this.f1049j0.getSuggestIntentData();
            }
            if (!(n7 == null || (n5 = e1.n(cursor, "suggest_intent_data_id")) == null)) {
                n7 = n7 + "/" + Uri.encode(n5);
            }
            return y(str2, n7 == null ? null : Uri.parse(n7), e1.n(cursor, "suggest_intent_extra_data"), e1.n(cursor, "suggest_intent_query"), i5, str);
        } catch (RuntimeException e5) {
            try {
                i6 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i6 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i6 + " returned exception.", e5);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void D() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1059t.refreshAutoCompleteResults();
            return;
        }
        n nVar = f1039u0;
        nVar.b(this.f1059t);
        nVar.a(this.f1059t);
    }

    public boolean H() {
        return this.U;
    }

    /* access modifiers changed from: package-private */
    public void L(int i5, String str, String str2) {
        getContext().startActivity(y("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i5, str));
    }

    /* access modifiers changed from: package-private */
    public void N() {
        if (!TextUtils.isEmpty(this.f1059t.getText())) {
            this.f1059t.setText(BuildConfig.FLAVOR);
            this.f1059t.requestFocus();
            this.f1059t.setImeVisibility(true);
        } else if (this.T) {
            k kVar = this.P;
            if (kVar == null || !kVar.a()) {
                clearFocus();
                g0(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean O(int i5, int i6, String str) {
        m mVar = this.R;
        if (mVar != null && mVar.b(i5)) {
            return false;
        }
        M(i5, 0, (String) null);
        this.f1059t.setImeVisibility(false);
        C();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean P(int i5) {
        m mVar = this.R;
        if (mVar != null && mVar.a(i5)) {
            return false;
        }
        Y(i5);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void Q(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void R() {
        g0(false);
        this.f1059t.requestFocus();
        this.f1059t.setImeVisibility(true);
        View.OnClickListener onClickListener = this.S;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void S() {
        Editable text = this.f1059t.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            l lVar = this.O;
            if (lVar == null || !lVar.b(text.toString())) {
                if (this.f1049j0 != null) {
                    L(0, (String) null, text.toString());
                }
                this.f1059t.setImeVisibility(false);
                C();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean T(View view, int i5, KeyEvent keyEvent) {
        if (this.f1049j0 != null && this.V != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i5 == 66 || i5 == 84 || i5 == 61) {
                return O(this.f1059t.getListSelection(), 0, (String) null);
            }
            if (i5 == 21 || i5 == 22) {
                this.f1059t.setSelection(i5 == 21 ? 0 : this.f1059t.length());
                this.f1059t.setListSelection(0);
                this.f1059t.clearListSelection();
                this.f1059t.a();
                return true;
            } else if (i5 == 19) {
                this.f1059t.getListSelection();
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void U(CharSequence charSequence) {
        Editable text = this.f1059t.getText();
        this.f1046g0 = text;
        boolean z4 = !TextUtils.isEmpty(text);
        f0(z4);
        h0(!z4);
        a0();
        e0();
        if (this.O != null && !TextUtils.equals(charSequence, this.f1045f0)) {
            this.O.a(charSequence.toString());
        }
        this.f1045f0 = charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    public void V() {
        g0(H());
        X();
        if (this.f1059t.hasFocus()) {
            D();
        }
    }

    /* access modifiers changed from: package-private */
    public void W() {
        Intent A2;
        SearchableInfo searchableInfo = this.f1049j0;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    A2 = B(this.L, searchableInfo);
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    A2 = A(this.M, searchableInfo);
                } else {
                    return;
                }
                getContext().startActivity(A2);
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    public void Z(CharSequence charSequence, boolean z4) {
        this.f1059t.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1059t;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f1046g0 = charSequence;
        }
        if (z4 && !TextUtils.isEmpty(charSequence)) {
            S();
        }
    }

    /* access modifiers changed from: package-private */
    public void b0() {
        int[] iArr = this.f1059t.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f1062v.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1063w.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public void clearFocus() {
        this.f1042c0 = true;
        super.clearFocus();
        this.f1059t.clearFocus();
        this.f1059t.setImeVisibility(false);
        this.f1042c0 = false;
    }

    public int getImeOptions() {
        return this.f1059t.getImeOptions();
    }

    public int getInputType() {
        return this.f1059t.getInputType();
    }

    public int getMaxWidth() {
        return this.f1043d0;
    }

    public CharSequence getQuery() {
        return this.f1059t.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f1040a0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1049j0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.N : getContext().getText(this.f1049j0.getHintId());
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.K;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.J;
    }

    public s.a getSuggestionsAdapter() {
        return this.V;
    }

    public void onActionViewCollapsed() {
        Z(BuildConfig.FLAVOR, false);
        clearFocus();
        g0(true);
        this.f1059t.setImeOptions(this.f1048i0);
        this.f1047h0 = false;
    }

    public void onActionViewExpanded() {
        if (!this.f1047h0) {
            this.f1047h0 = true;
            int imeOptions = this.f1059t.getImeOptions();
            this.f1048i0 = imeOptions;
            this.f1059t.setImeOptions(imeOptions | 33554432);
            this.f1059t.setText(BuildConfig.FLAVOR);
            setIconified(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1051l0);
        post(this.f1052m0);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        if (z4) {
            E(this.f1059t, this.D);
            Rect rect = this.E;
            Rect rect2 = this.D;
            rect.set(rect2.left, 0, rect2.right, i8 - i6);
            p pVar = this.C;
            if (pVar == null) {
                p pVar2 = new p(this.E, this.D, this.f1059t);
                this.C = pVar2;
                setTouchDelegate(pVar2);
                return;
            }
            pVar.a(this.E, this.D);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r0 <= 0) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.H()
            if (r0 == 0) goto L_0x000a
            super.onMeasure(r4, r5)
            return
        L_0x000a:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L_0x002c
            if (r0 == 0) goto L_0x0022
            if (r0 == r2) goto L_0x001d
            goto L_0x0039
        L_0x001d:
            int r0 = r3.f1043d0
            if (r0 <= 0) goto L_0x0039
            goto L_0x0030
        L_0x0022:
            int r4 = r3.f1043d0
            if (r4 <= 0) goto L_0x0027
            goto L_0x0039
        L_0x0027:
            int r4 = r3.getPreferredWidth()
            goto L_0x0039
        L_0x002c:
            int r0 = r3.f1043d0
            if (r0 <= 0) goto L_0x0031
        L_0x0030:
            goto L_0x0035
        L_0x0031:
            int r0 = r3.getPreferredWidth()
        L_0x0035:
            int r4 = java.lang.Math.min(r0, r4)
        L_0x0039:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L_0x004b
            if (r0 == 0) goto L_0x0046
            goto L_0x0053
        L_0x0046:
            int r5 = r3.getPreferredHeight()
            goto L_0x0053
        L_0x004b:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L_0x0053:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.a());
        g0(oVar.f1085g);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.f1085g = H();
        return oVar;
    }

    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        X();
    }

    public boolean requestFocus(int i5, Rect rect) {
        if (this.f1042c0 || !isFocusable()) {
            return false;
        }
        if (H()) {
            return super.requestFocus(i5, rect);
        }
        boolean requestFocus = this.f1059t.requestFocus(i5, rect);
        if (requestFocus) {
            g0(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1050k0 = bundle;
    }

    public void setIconified(boolean z4) {
        if (z4) {
            N();
        } else {
            R();
        }
    }

    public void setIconifiedByDefault(boolean z4) {
        if (this.T != z4) {
            this.T = z4;
            g0(z4);
            c0();
        }
    }

    public void setImeOptions(int i5) {
        this.f1059t.setImeOptions(i5);
    }

    public void setInputType(int i5) {
        this.f1059t.setInputType(i5);
    }

    public void setMaxWidth(int i5) {
        this.f1043d0 = i5;
        requestLayout();
    }

    public void setOnCloseListener(k kVar) {
        this.P = kVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.Q = onFocusChangeListener;
    }

    public void setOnQueryTextListener(l lVar) {
        this.O = lVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.S = onClickListener;
    }

    public void setOnSuggestionListener(m mVar) {
        this.R = mVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1040a0 = charSequence;
        c0();
    }

    public void setQueryRefinementEnabled(boolean z4) {
        this.f1041b0 = z4;
        s.a aVar = this.V;
        if (aVar instanceof e1) {
            ((e1) aVar).w(z4 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1049j0 = searchableInfo;
        if (searchableInfo != null) {
            d0();
            c0();
        }
        boolean G2 = G();
        this.f1044e0 = G2;
        if (G2) {
            this.f1059t.setPrivateImeOptions("nm");
        }
        g0(H());
    }

    public void setSubmitButtonEnabled(boolean z4) {
        this.W = z4;
        g0(H());
    }

    public void setSuggestionsAdapter(s.a aVar) {
        this.V = aVar;
        this.f1059t.setAdapter(aVar);
    }

    /* access modifiers changed from: package-private */
    public void x() {
        if (this.B.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1062v.getPaddingLeft();
            Rect rect = new Rect();
            boolean b5 = r1.b(this);
            int dimensionPixelSize = this.T ? resources.getDimensionPixelSize(d.d.f4001e) + resources.getDimensionPixelSize(d.d.f4002f) : 0;
            this.f1059t.getDropDownBackground().getPadding(rect);
            int i5 = rect.left;
            this.f1059t.setDropDownHorizontalOffset(b5 ? -i5 : paddingLeft - (i5 + dimensionPixelSize));
            this.f1059t.setDropDownWidth((((this.B.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }
}
