package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.s0;
import androidx.core.view.k0;
import androidx.core.widget.NestedScrollView;
import com.yalantis.ucrop.view.CropImageView;
import d.f;
import d.j;
import java.lang.ref.WeakReference;

class AlertController {
    NestedScrollView A;
    private int B = 0;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    int I = -1;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    private int Q = 0;
    Handler R;
    private final View.OnClickListener S = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Context f549a;

    /* renamed from: b  reason: collision with root package name */
    final j f550b;

    /* renamed from: c  reason: collision with root package name */
    private final Window f551c;

    /* renamed from: d  reason: collision with root package name */
    private final int f552d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f553e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f554f;

    /* renamed from: g  reason: collision with root package name */
    ListView f555g;

    /* renamed from: h  reason: collision with root package name */
    private View f556h;

    /* renamed from: i  reason: collision with root package name */
    private int f557i;

    /* renamed from: j  reason: collision with root package name */
    private int f558j;

    /* renamed from: k  reason: collision with root package name */
    private int f559k;

    /* renamed from: l  reason: collision with root package name */
    private int f560l;

    /* renamed from: m  reason: collision with root package name */
    private int f561m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f562n = false;

    /* renamed from: o  reason: collision with root package name */
    Button f563o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f564p;

    /* renamed from: q  reason: collision with root package name */
    Message f565q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f566r;

    /* renamed from: s  reason: collision with root package name */
    Button f567s;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f568t;

    /* renamed from: u  reason: collision with root package name */
    Message f569u;

    /* renamed from: v  reason: collision with root package name */
    private Drawable f570v;

    /* renamed from: w  reason: collision with root package name */
    Button f571w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f572x;

    /* renamed from: y  reason: collision with root package name */
    Message f573y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f574z;

    public static class RecycleListView extends ListView {

        /* renamed from: e  reason: collision with root package name */
        private final int f575e;

        /* renamed from: f  reason: collision with root package name */
        private final int f576f;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f4128f2);
            this.f576f = obtainStyledAttributes.getDimensionPixelOffset(j.f4133g2, -1);
            this.f575e = obtainStyledAttributes.getDimensionPixelOffset(j.f4138h2, -1);
        }

        public void a(boolean z4, boolean z5) {
            if (!z5 || !z4) {
                setPadding(getPaddingLeft(), z4 ? getPaddingTop() : this.f575e, getPaddingRight(), z5 ? getPaddingBottom() : this.f576f);
            }
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            r3 = r0.f573y;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r3) {
            /*
                r2 = this;
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r1 = r0.f563o
                if (r3 != r1) goto L_0x000f
                android.os.Message r1 = r0.f565q
                if (r1 == 0) goto L_0x000f
            L_0x000a:
                android.os.Message r3 = android.os.Message.obtain(r1)
                goto L_0x0026
            L_0x000f:
                android.widget.Button r1 = r0.f567s
                if (r3 != r1) goto L_0x0018
                android.os.Message r1 = r0.f569u
                if (r1 == 0) goto L_0x0018
                goto L_0x000a
            L_0x0018:
                android.widget.Button r1 = r0.f571w
                if (r3 != r1) goto L_0x0025
                android.os.Message r3 = r0.f573y
                if (r3 == 0) goto L_0x0025
                android.os.Message r3 = android.os.Message.obtain(r3)
                goto L_0x0026
            L_0x0025:
                r3 = 0
            L_0x0026:
                if (r3 == 0) goto L_0x002b
                r3.sendToTarget()
            L_0x002b:
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Handler r0 = r3.R
                r1 = 1
                androidx.appcompat.app.j r3 = r3.f550b
                android.os.Message r3 = r0.obtainMessage(r1, r3)
                r3.sendToTarget()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.a.onClick(android.view.View):void");
        }
    }

    public static class b {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;
        public boolean P = true;

        /* renamed from: a  reason: collision with root package name */
        public final Context f578a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f579b;

        /* renamed from: c  reason: collision with root package name */
        public int f580c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f581d;

        /* renamed from: e  reason: collision with root package name */
        public int f582e = 0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f583f;

        /* renamed from: g  reason: collision with root package name */
        public View f584g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f585h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f586i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f587j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f588k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f589l;

        /* renamed from: m  reason: collision with root package name */
        public Drawable f590m;

        /* renamed from: n  reason: collision with root package name */
        public DialogInterface.OnClickListener f591n;

        /* renamed from: o  reason: collision with root package name */
        public CharSequence f592o;

        /* renamed from: p  reason: collision with root package name */
        public Drawable f593p;

        /* renamed from: q  reason: collision with root package name */
        public DialogInterface.OnClickListener f594q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f595r;

        /* renamed from: s  reason: collision with root package name */
        public DialogInterface.OnCancelListener f596s;

        /* renamed from: t  reason: collision with root package name */
        public DialogInterface.OnDismissListener f597t;

        /* renamed from: u  reason: collision with root package name */
        public DialogInterface.OnKeyListener f598u;

        /* renamed from: v  reason: collision with root package name */
        public CharSequence[] f599v;

        /* renamed from: w  reason: collision with root package name */
        public ListAdapter f600w;

        /* renamed from: x  reason: collision with root package name */
        public DialogInterface.OnClickListener f601x;

        /* renamed from: y  reason: collision with root package name */
        public int f602y;

        /* renamed from: z  reason: collision with root package name */
        public View f603z;

        class a extends ArrayAdapter<CharSequence> {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ RecycleListView f604e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Context context, int i5, int i6, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i5, i6, charSequenceArr);
                this.f604e = recycleListView;
            }

            public View getView(int i5, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i5, view, viewGroup);
                boolean[] zArr = b.this.F;
                if (zArr != null && zArr[i5]) {
                    this.f604e.setItemChecked(i5, true);
                }
                return view2;
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$b$b  reason: collision with other inner class name */
        class C0013b extends CursorAdapter {

            /* renamed from: e  reason: collision with root package name */
            private final int f606e;

            /* renamed from: f  reason: collision with root package name */
            private final int f607f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ RecycleListView f608g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ AlertController f609h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0013b(Context context, Cursor cursor, boolean z4, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z4);
                this.f608g = recycleListView;
                this.f609h = alertController;
                Cursor cursor2 = getCursor();
                this.f606e = cursor2.getColumnIndexOrThrow(b.this.L);
                this.f607f = cursor2.getColumnIndexOrThrow(b.this.M);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f606e));
                RecycleListView recycleListView = this.f608g;
                int position = cursor.getPosition();
                boolean z4 = true;
                if (cursor.getInt(this.f607f) != 1) {
                    z4 = false;
                }
                recycleListView.setItemChecked(position, z4);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return b.this.f579b.inflate(this.f609h.M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ AlertController f611e;

            c(AlertController alertController) {
                this.f611e = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                b.this.f601x.onClick(this.f611e.f550b, i5);
                if (!b.this.H) {
                    this.f611e.f550b.dismiss();
                }
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ RecycleListView f613e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ AlertController f614f;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f613e = recycleListView;
                this.f614f = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                boolean[] zArr = b.this.F;
                if (zArr != null) {
                    zArr[i5] = this.f613e.isItemChecked(i5);
                }
                b.this.J.onClick(this.f614f.f550b, i5, this.f613e.isItemChecked(i5));
            }
        }

        public interface e {
            void a(ListView listView);
        }

        public b(Context context) {
            this.f578a = context;
            this.f595r = true;
            this.f579b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v3 */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v24, types: [androidx.appcompat.app.AlertController$b$b] */
        /* JADX WARNING: type inference failed for: r1v25, types: [androidx.appcompat.app.AlertController$b$a] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x009e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(androidx.appcompat.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.f579b
                int r1 = r11.L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r10.G
                r8 = 1
                if (r1 == 0) goto L_0x0035
                android.database.Cursor r1 = r10.K
                if (r1 != 0) goto L_0x0026
                androidx.appcompat.app.AlertController$b$a r9 = new androidx.appcompat.app.AlertController$b$a
                android.content.Context r3 = r10.f578a
                int r4 = r11.M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.f599v
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0026:
                androidx.appcompat.app.AlertController$b$b r9 = new androidx.appcompat.app.AlertController$b$b
                android.content.Context r3 = r10.f578a
                android.database.Cursor r4 = r10.K
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0035:
                boolean r1 = r10.H
                if (r1 == 0) goto L_0x003c
                int r1 = r11.N
                goto L_0x003e
            L_0x003c:
                int r1 = r11.O
            L_0x003e:
                r4 = r1
                android.database.Cursor r1 = r10.K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005d
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.f578a
                android.database.Cursor r5 = r10.K
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r1 = r10.L
                r7 = 0
                r6[r7] = r1
                int[] r1 = new int[r8]
                r1[r7] = r2
                r2 = r9
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x005d:
                android.widget.ListAdapter r9 = r10.f600w
                if (r9 == 0) goto L_0x0062
                goto L_0x006b
            L_0x0062:
                androidx.appcompat.app.AlertController$d r9 = new androidx.appcompat.app.AlertController$d
                android.content.Context r1 = r10.f578a
                java.lang.CharSequence[] r3 = r10.f599v
                r9.<init>(r1, r4, r2, r3)
            L_0x006b:
                androidx.appcompat.app.AlertController$b$e r1 = r10.O
                if (r1 == 0) goto L_0x0072
                r1.a(r0)
            L_0x0072:
                r11.H = r9
                int r1 = r10.I
                r11.I = r1
                android.content.DialogInterface$OnClickListener r1 = r10.f601x
                if (r1 == 0) goto L_0x0085
                androidx.appcompat.app.AlertController$b$c r1 = new androidx.appcompat.app.AlertController$b$c
                r1.<init>(r11)
            L_0x0081:
                r0.setOnItemClickListener(r1)
                goto L_0x008f
            L_0x0085:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.J
                if (r1 == 0) goto L_0x008f
                androidx.appcompat.app.AlertController$b$d r1 = new androidx.appcompat.app.AlertController$b$d
                r1.<init>(r0, r11)
                goto L_0x0081
            L_0x008f:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.N
                if (r1 == 0) goto L_0x0096
                r0.setOnItemSelectedListener(r1)
            L_0x0096:
                boolean r1 = r10.H
                if (r1 == 0) goto L_0x009e
                r0.setChoiceMode(r8)
                goto L_0x00a6
            L_0x009e:
                boolean r1 = r10.G
                if (r1 == 0) goto L_0x00a6
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00a6:
                r11.f555g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.b.b(androidx.appcompat.app.AlertController):void");
        }

        public void a(AlertController alertController) {
            View view = this.f584g;
            if (view != null) {
                alertController.k(view);
            } else {
                CharSequence charSequence = this.f583f;
                if (charSequence != null) {
                    alertController.p(charSequence);
                }
                Drawable drawable = this.f581d;
                if (drawable != null) {
                    alertController.m(drawable);
                }
                int i5 = this.f580c;
                if (i5 != 0) {
                    alertController.l(i5);
                }
                int i6 = this.f582e;
                if (i6 != 0) {
                    alertController.l(alertController.c(i6));
                }
            }
            CharSequence charSequence2 = this.f585h;
            if (charSequence2 != null) {
                alertController.n(charSequence2);
            }
            CharSequence charSequence3 = this.f586i;
            if (!(charSequence3 == null && this.f587j == null)) {
                alertController.j(-1, charSequence3, this.f588k, (Message) null, this.f587j);
            }
            CharSequence charSequence4 = this.f589l;
            if (!(charSequence4 == null && this.f590m == null)) {
                alertController.j(-2, charSequence4, this.f591n, (Message) null, this.f590m);
            }
            CharSequence charSequence5 = this.f592o;
            if (!(charSequence5 == null && this.f593p == null)) {
                alertController.j(-3, charSequence5, this.f594q, (Message) null, this.f593p);
            }
            if (!(this.f599v == null && this.K == null && this.f600w == null)) {
                b(alertController);
            }
            View view2 = this.f603z;
            if (view2 == null) {
                int i7 = this.f602y;
                if (i7 != 0) {
                    alertController.q(i7);
                }
            } else if (this.E) {
                alertController.s(view2, this.A, this.B, this.C, this.D);
            } else {
                alertController.r(view2);
            }
        }
    }

    private static final class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f616a;

        public c(DialogInterface dialogInterface) {
            this.f616a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == -3 || i5 == -2 || i5 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f616a.get(), message.what);
            } else if (i5 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class d extends ArrayAdapter<CharSequence> {
        public d(Context context, int i5, int i6, CharSequence[] charSequenceArr) {
            super(context, i5, i6, charSequenceArr);
        }

        public long getItemId(int i5) {
            return (long) i5;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, j jVar, Window window) {
        this.f549a = context;
        this.f550b = jVar;
        this.f551c = window;
        this.R = new c(jVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, j.F, d.a.f3975n, 0);
        this.J = obtainStyledAttributes.getResourceId(j.G, 0);
        this.K = obtainStyledAttributes.getResourceId(j.I, 0);
        this.L = obtainStyledAttributes.getResourceId(j.K, 0);
        this.M = obtainStyledAttributes.getResourceId(j.L, 0);
        this.N = obtainStyledAttributes.getResourceId(j.N, 0);
        this.O = obtainStyledAttributes.getResourceId(j.J, 0);
        this.P = obtainStyledAttributes.getBoolean(j.M, true);
        this.f552d = obtainStyledAttributes.getDimensionPixelSize(j.H, 0);
        obtainStyledAttributes.recycle();
        jVar.d(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private ViewGroup h(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int i() {
        int i5 = this.K;
        return i5 == 0 ? this.J : this.Q == 1 ? i5 : this.J;
    }

    private void o(ViewGroup viewGroup, View view, int i5, int i6) {
        View findViewById = this.f551c.findViewById(f.f4059v);
        View findViewById2 = this.f551c.findViewById(f.f4058u);
        k0.X(view, i5, i6);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    private void t(ViewGroup viewGroup) {
        boolean z4;
        Button button;
        Button button2 = (Button) viewGroup.findViewById(16908313);
        this.f563o = button2;
        button2.setOnClickListener(this.S);
        boolean z5 = true;
        if (!TextUtils.isEmpty(this.f564p) || this.f566r != null) {
            this.f563o.setText(this.f564p);
            Drawable drawable = this.f566r;
            if (drawable != null) {
                int i5 = this.f552d;
                drawable.setBounds(0, 0, i5, i5);
                this.f563o.setCompoundDrawables(this.f566r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f563o.setVisibility(0);
            z4 = true;
        } else {
            this.f563o.setVisibility(8);
            z4 = false;
        }
        Button button3 = (Button) viewGroup.findViewById(16908314);
        this.f567s = button3;
        button3.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f568t) || this.f570v != null) {
            this.f567s.setText(this.f568t);
            Drawable drawable2 = this.f570v;
            if (drawable2 != null) {
                int i6 = this.f552d;
                drawable2.setBounds(0, 0, i6, i6);
                this.f567s.setCompoundDrawables(this.f570v, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f567s.setVisibility(0);
            z4 |= true;
        } else {
            this.f567s.setVisibility(8);
        }
        Button button4 = (Button) viewGroup.findViewById(16908315);
        this.f571w = button4;
        button4.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f572x) || this.f574z != null) {
            this.f571w.setText(this.f572x);
            Drawable drawable3 = this.f574z;
            if (drawable3 != null) {
                int i7 = this.f552d;
                drawable3.setBounds(0, 0, i7, i7);
                this.f571w.setCompoundDrawables(this.f574z, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f571w.setVisibility(0);
            z4 |= true;
        } else {
            this.f571w.setVisibility(8);
        }
        if (y(this.f549a)) {
            if (z4) {
                button = this.f563o;
            } else if (z4) {
                button = this.f567s;
            } else if (z4) {
                button = this.f571w;
            }
            b(button);
        }
        if (!z4) {
            z5 = false;
        }
        if (!z5) {
            viewGroup.setVisibility(8);
        }
    }

    private void u(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f551c.findViewById(f.f4060w);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f554f;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.A.removeView(this.F);
            if (this.f555g != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.A);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f555g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void v(ViewGroup viewGroup) {
        View view = this.f556h;
        boolean z4 = false;
        if (view == null) {
            view = this.f557i != 0 ? LayoutInflater.from(this.f549a).inflate(this.f557i, viewGroup, false) : null;
        }
        if (view != null) {
            z4 = true;
        }
        if (!z4 || !a(view)) {
            this.f551c.setFlags(131072, 131072);
        }
        if (z4) {
            FrameLayout frameLayout = (FrameLayout) this.f551c.findViewById(f.f4051n);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f562n) {
                frameLayout.setPadding(this.f558j, this.f559k, this.f560l, this.f561m);
            }
            if (this.f555g != null) {
                ((s0.a) viewGroup.getLayoutParams()).weight = CropImageView.DEFAULT_ASPECT_RATIO;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void w(ViewGroup viewGroup) {
        View view;
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            view = this.f551c.findViewById(f.O);
        } else {
            this.D = (ImageView) this.f551c.findViewById(16908294);
            if (!(!TextUtils.isEmpty(this.f553e)) || !this.P) {
                this.f551c.findViewById(f.O).setVisibility(8);
                this.D.setVisibility(8);
                view = viewGroup;
            } else {
                TextView textView = (TextView) this.f551c.findViewById(f.f4047j);
                this.E = textView;
                textView.setText(this.f553e);
                int i5 = this.B;
                if (i5 != 0) {
                    this.D.setImageResource(i5);
                    return;
                }
                Drawable drawable = this.C;
                if (drawable != null) {
                    this.D.setImageDrawable(drawable);
                    return;
                }
                this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
                this.D.setVisibility(8);
                return;
            }
        }
        view.setVisibility(8);
    }

    private void x() {
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f551c.findViewById(f.f4057t);
        int i5 = f.P;
        View findViewById4 = findViewById3.findViewById(i5);
        int i6 = f.f4050m;
        View findViewById5 = findViewById3.findViewById(i6);
        int i7 = f.f4048k;
        View findViewById6 = findViewById3.findViewById(i7);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(f.f4052o);
        v(viewGroup);
        View findViewById7 = viewGroup.findViewById(i5);
        View findViewById8 = viewGroup.findViewById(i6);
        View findViewById9 = viewGroup.findViewById(i7);
        ViewGroup h5 = h(findViewById7, findViewById4);
        ViewGroup h6 = h(findViewById8, findViewById5);
        ViewGroup h7 = h(findViewById9, findViewById6);
        u(h6);
        t(h7);
        w(h5);
        char c5 = 0;
        boolean z4 = viewGroup.getVisibility() != 8;
        boolean z5 = (h5 == null || h5.getVisibility() == 8) ? false : true;
        boolean z6 = (h7 == null || h7.getVisibility() == 8) ? false : true;
        if (!(z6 || h6 == null || (findViewById2 = h6.findViewById(f.K)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z5) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f554f == null && this.f555g == null)) {
                view = h5.findViewById(f.N);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(h6 == null || (findViewById = h6.findViewById(f.L)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f555g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z5, z6);
        }
        if (!z4) {
            View view2 = this.f555g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                if (z6) {
                    c5 = 2;
                }
                o(h6, view2, z5 | c5 ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f555g;
        if (listView2 != null && (listAdapter = this.H) != null) {
            listView2.setAdapter(listAdapter);
            int i8 = this.I;
            if (i8 > -1) {
                listView2.setItemChecked(i8, true);
                listView2.setSelection(i8);
            }
        }
    }

    private static boolean y(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(d.a.f3974m, typedValue, true);
        return typedValue.data != 0;
    }

    public int c(int i5) {
        TypedValue typedValue = new TypedValue();
        this.f549a.getTheme().resolveAttribute(i5, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f555g;
    }

    public void e() {
        this.f550b.setContentView(i());
        x();
    }

    public boolean f(int i5, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.s(keyEvent);
    }

    public boolean g(int i5, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.s(keyEvent);
    }

    public void j(int i5, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i5, onClickListener);
        }
        if (i5 == -3) {
            this.f572x = charSequence;
            this.f573y = message;
            this.f574z = drawable;
        } else if (i5 == -2) {
            this.f568t = charSequence;
            this.f569u = message;
            this.f570v = drawable;
        } else if (i5 == -1) {
            this.f564p = charSequence;
            this.f565q = message;
            this.f566r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void k(View view) {
        this.G = view;
    }

    public void l(int i5) {
        this.C = null;
        this.B = i5;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i5 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }

    public void m(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void n(CharSequence charSequence) {
        this.f554f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void p(CharSequence charSequence) {
        this.f553e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(int i5) {
        this.f556h = null;
        this.f557i = i5;
        this.f562n = false;
    }

    public void r(View view) {
        this.f556h = view;
        this.f557i = 0;
        this.f562n = false;
    }

    public void s(View view, int i5, int i6, int i7, int i8) {
        this.f556h = view;
        this.f557i = 0;
        this.f562n = true;
        this.f558j = i5;
        this.f559k = i6;
        this.f560l = i7;
        this.f561m = i8;
    }
}
