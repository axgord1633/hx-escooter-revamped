package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.yalantis.ucrop.view.CropImageView;
import i.e;

public abstract class r0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: e  reason: collision with root package name */
    private final float f1388e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1389f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1390g;

    /* renamed from: h  reason: collision with root package name */
    final View f1391h;

    /* renamed from: i  reason: collision with root package name */
    private Runnable f1392i;

    /* renamed from: j  reason: collision with root package name */
    private Runnable f1393j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1394k;

    /* renamed from: l  reason: collision with root package name */
    private int f1395l;

    /* renamed from: m  reason: collision with root package name */
    private final int[] f1396m = new int[2];

    private class a implements Runnable {
        a() {
        }

        public void run() {
            ViewParent parent = r0.this.f1391h.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            r0.this.e();
        }
    }

    public r0(View view) {
        this.f1391h = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1388e = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1389f = tapTimeout;
        this.f1390g = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f1393j;
        if (runnable != null) {
            this.f1391h.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1392i;
        if (runnable2 != null) {
            this.f1391h.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        p0 p0Var;
        View view = this.f1391h;
        e b5 = b();
        if (b5 == null || !b5.b() || (p0Var = (p0) b5.f()) == null || !p0Var.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(p0Var, obtainNoHistory);
        boolean e5 = p0Var.e(obtainNoHistory, this.f1395l);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return e5 && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1391h
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.f1395l
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1388e
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.a()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.f1395l = r6
            java.lang.Runnable r6 = r5.f1392i
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.r0$a r6 = new androidx.appcompat.widget.r0$a
            r6.<init>()
            r5.f1392i = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.f1392i
            int r1 = r5.f1389f
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1393j
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.r0$b r6 = new androidx.appcompat.widget.r0$b
            r6.<init>()
            r5.f1393j = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.f1393j
            int r1 = r5.f1390g
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.r0.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f5, float f6, float f7) {
        float f8 = -f7;
        return f5 >= f8 && f6 >= f8 && f5 < ((float) (view.getRight() - view.getLeft())) + f7 && f6 < ((float) (view.getBottom() - view.getTop())) + f7;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1396m;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1396m;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    public abstract e b();

    /* access modifiers changed from: protected */
    public abstract boolean c();

    /* access modifiers changed from: protected */
    public boolean d() {
        e b5 = b();
        if (b5 == null || !b5.b()) {
            return true;
        }
        b5.dismiss();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a();
        View view = this.f1391h;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1394k = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z4;
        boolean z5 = this.f1394k;
        if (z5) {
            z4 = f(motionEvent) || !d();
        } else {
            z4 = g(motionEvent) && c();
            if (z4) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
                this.f1391h.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f1394k = z4;
        return z4 || z5;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f1394k = false;
        this.f1395l = -1;
        Runnable runnable = this.f1392i;
        if (runnable != null) {
            this.f1391h.removeCallbacks(runnable);
        }
    }
}
