package com.google.android.gms.common.api.internal;

import a1.a;
import android.os.SystemClock;
import com.google.android.gms.common.api.Status;
import com.yalantis.ucrop.R;
import l1.c;
import l1.g;
import v0.b;
import w0.f;
import w0.n;
import w0.q;
import w0.r;

final class w implements c {

    /* renamed from: a  reason: collision with root package name */
    private final b f3413a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3414b;

    /* renamed from: c  reason: collision with root package name */
    private final b f3415c;

    /* renamed from: d  reason: collision with root package name */
    private final long f3416d;

    /* renamed from: e  reason: collision with root package name */
    private final long f3417e;

    w(b bVar, int i5, b bVar2, long j5, long j6, String str, String str2) {
        this.f3413a = bVar;
        this.f3414b = i5;
        this.f3415c = bVar2;
        this.f3416d = j5;
        this.f3417e = j6;
    }

    static w b(b bVar, int i5, b bVar2) {
        boolean z4;
        if (!bVar.f()) {
            return null;
        }
        r a5 = q.b().a();
        if (a5 == null) {
            z4 = true;
        } else if (!a5.c()) {
            return null;
        } else {
            z4 = a5.d();
            r w4 = bVar.w(bVar2);
            if (w4 != null) {
                if (!(w4.v() instanceof w0.c)) {
                    return null;
                }
                w0.c cVar = (w0.c) w4.v();
                if (cVar.I() && !cVar.i()) {
                    f c5 = c(w4, cVar, i5);
                    if (c5 == null) {
                        return null;
                    }
                    w4.G();
                    z4 = c5.e();
                }
            }
        }
        return new w(bVar, i5, bVar2, z4 ? System.currentTimeMillis() : 0, z4 ? SystemClock.elapsedRealtime() : 0, (String) null, (String) null);
    }

    private static f c(r rVar, w0.c cVar, int i5) {
        int[] b5;
        int[] c5;
        f G = cVar.G();
        if (G == null || !G.d() || ((b5 = G.b()) != null ? !a.a(b5, i5) : !((c5 = G.c()) == null || !a.a(c5, i5))) || rVar.s() >= G.a()) {
            return null;
        }
        return G;
    }

    public final void a(g gVar) {
        r w4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long j5;
        long j6;
        if (this.f3413a.f()) {
            r a5 = q.b().a();
            if ((a5 == null || a5.c()) && (w4 = this.f3413a.w(this.f3415c)) != null && (w4.v() instanceof w0.c)) {
                w0.c cVar = (w0.c) w4.v();
                boolean z4 = true;
                int i10 = 0;
                boolean z5 = this.f3416d > 0;
                int y4 = cVar.y();
                if (a5 != null) {
                    boolean d5 = z5 & a5.d();
                    int a6 = a5.a();
                    int b5 = a5.b();
                    i7 = a5.e();
                    if (cVar.I() && !cVar.i()) {
                        f c5 = c(w4, cVar, this.f3414b);
                        if (c5 != null) {
                            if (!c5.e() || this.f3416d <= 0) {
                                z4 = false;
                            }
                            b5 = c5.a();
                            d5 = z4;
                        } else {
                            return;
                        }
                    }
                    i6 = a6;
                    i5 = b5;
                } else {
                    i7 = 0;
                    i5 = 100;
                    i6 = 5000;
                }
                b bVar = this.f3413a;
                if (gVar.j()) {
                    i8 = 0;
                } else {
                    if (gVar.h()) {
                        i10 = 100;
                    } else {
                        Exception f5 = gVar.f();
                        if (f5 instanceof u0.b) {
                            Status a7 = ((u0.b) f5).a();
                            int b6 = a7.b();
                            t0.a a8 = a7.a();
                            i8 = a8 == null ? -1 : a8.a();
                            i10 = b6;
                        } else {
                            i10 = R.styleable.AppCompatTheme_switchStyle;
                        }
                    }
                    i8 = -1;
                }
                if (z5) {
                    long j7 = this.f3416d;
                    long currentTimeMillis = System.currentTimeMillis();
                    i9 = (int) (SystemClock.elapsedRealtime() - this.f3417e);
                    j6 = j7;
                    j5 = currentTimeMillis;
                } else {
                    j6 = 0;
                    j5 = 0;
                    i9 = -1;
                }
                bVar.G(new n(this.f3414b, i10, i8, j6, j5, (String) null, (String) null, y4, i9), i7, (long) i6, i5);
            }
        }
    }
}
