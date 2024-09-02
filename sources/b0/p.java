package b0;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import b0.l;
import java.util.ArrayList;
import java.util.Iterator;

public class p extends l {
    private ArrayList<l> M = new ArrayList<>();
    private boolean N = true;
    int O;
    boolean P = false;
    private int Q = 0;

    class a extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f2953a;

        a(l lVar) {
            this.f2953a = lVar;
        }

        public void b(l lVar) {
            this.f2953a.U();
            lVar.Q(this);
        }
    }

    static class b extends m {

        /* renamed from: a  reason: collision with root package name */
        p f2955a;

        b(p pVar) {
            this.f2955a = pVar;
        }

        public void a(l lVar) {
            p pVar = this.f2955a;
            if (!pVar.P) {
                pVar.b0();
                this.f2955a.P = true;
            }
        }

        public void b(l lVar) {
            p pVar = this.f2955a;
            int i5 = pVar.O - 1;
            pVar.O = i5;
            if (i5 == 0) {
                pVar.P = false;
                pVar.q();
            }
            lVar.Q(this);
        }
    }

    private void g0(l lVar) {
        this.M.add(lVar);
        lVar.f2914v = this;
    }

    private void p0() {
        b bVar = new b(this);
        Iterator<l> it = this.M.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.O = this.M.size();
    }

    public void O(View view) {
        super.O(view);
        int size = this.M.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.M.get(i5).O(view);
        }
    }

    public void S(View view) {
        super.S(view);
        int size = this.M.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.M.get(i5).S(view);
        }
    }

    /* access modifiers changed from: protected */
    public void U() {
        if (this.M.isEmpty()) {
            b0();
            q();
            return;
        }
        p0();
        if (!this.N) {
            for (int i5 = 1; i5 < this.M.size(); i5++) {
                this.M.get(i5 - 1).a(new a(this.M.get(i5)));
            }
            l lVar = this.M.get(0);
            if (lVar != null) {
                lVar.U();
                return;
            }
            return;
        }
        Iterator<l> it = this.M.iterator();
        while (it.hasNext()) {
            it.next().U();
        }
    }

    public void W(l.e eVar) {
        super.W(eVar);
        this.Q |= 8;
        int size = this.M.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.M.get(i5).W(eVar);
        }
    }

    public void Y(g gVar) {
        super.Y(gVar);
        this.Q |= 4;
        if (this.M != null) {
            for (int i5 = 0; i5 < this.M.size(); i5++) {
                this.M.get(i5).Y(gVar);
            }
        }
    }

    public void Z(o oVar) {
        super.Z(oVar);
        this.Q |= 2;
        int size = this.M.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.M.get(i5).Z(oVar);
        }
    }

    /* access modifiers changed from: package-private */
    public String c0(String str) {
        String c02 = super.c0(str);
        for (int i5 = 0; i5 < this.M.size(); i5++) {
            StringBuilder sb = new StringBuilder();
            sb.append(c02);
            sb.append("\n");
            sb.append(this.M.get(i5).c0(str + "  "));
            c02 = sb.toString();
        }
        return c02;
    }

    /* renamed from: d0 */
    public p a(l.f fVar) {
        return (p) super.a(fVar);
    }

    /* renamed from: e0 */
    public p b(View view) {
        for (int i5 = 0; i5 < this.M.size(); i5++) {
            this.M.get(i5).b(view);
        }
        return (p) super.b(view);
    }

    public p f0(l lVar) {
        g0(lVar);
        long j5 = this.f2899g;
        if (j5 >= 0) {
            lVar.V(j5);
        }
        if ((this.Q & 1) != 0) {
            lVar.X(t());
        }
        if ((this.Q & 2) != 0) {
            x();
            lVar.Z((o) null);
        }
        if ((this.Q & 4) != 0) {
            lVar.Y(w());
        }
        if ((this.Q & 8) != 0) {
            lVar.W(s());
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void g() {
        super.g();
        int size = this.M.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.M.get(i5).g();
        }
    }

    public void h(s sVar) {
        if (H(sVar.f2960b)) {
            Iterator<l> it = this.M.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (next.H(sVar.f2960b)) {
                    next.h(sVar);
                    sVar.f2961c.add(next);
                }
            }
        }
    }

    public l h0(int i5) {
        if (i5 < 0 || i5 >= this.M.size()) {
            return null;
        }
        return this.M.get(i5);
    }

    public int i0() {
        return this.M.size();
    }

    /* access modifiers changed from: package-private */
    public void j(s sVar) {
        super.j(sVar);
        int size = this.M.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.M.get(i5).j(sVar);
        }
    }

    /* renamed from: j0 */
    public p Q(l.f fVar) {
        return (p) super.Q(fVar);
    }

    public void k(s sVar) {
        if (H(sVar.f2960b)) {
            Iterator<l> it = this.M.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (next.H(sVar.f2960b)) {
                    next.k(sVar);
                    sVar.f2961c.add(next);
                }
            }
        }
    }

    /* renamed from: k0 */
    public p R(View view) {
        for (int i5 = 0; i5 < this.M.size(); i5++) {
            this.M.get(i5).R(view);
        }
        return (p) super.R(view);
    }

    /* renamed from: l0 */
    public p V(long j5) {
        ArrayList<l> arrayList;
        super.V(j5);
        if (this.f2899g >= 0 && (arrayList = this.M) != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.M.get(i5).V(j5);
            }
        }
        return this;
    }

    /* renamed from: m0 */
    public p X(TimeInterpolator timeInterpolator) {
        this.Q |= 1;
        ArrayList<l> arrayList = this.M;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.M.get(i5).X(timeInterpolator);
            }
        }
        return (p) super.X(timeInterpolator);
    }

    /* renamed from: n */
    public l clone() {
        p pVar = (p) super.clone();
        pVar.M = new ArrayList<>();
        int size = this.M.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.g0(this.M.get(i5).clone());
        }
        return pVar;
    }

    public p n0(int i5) {
        if (i5 == 0) {
            this.N = true;
        } else if (i5 == 1) {
            this.N = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i5);
        }
        return this;
    }

    /* renamed from: o0 */
    public p a0(long j5) {
        return (p) super.a0(j5);
    }

    /* access modifiers changed from: protected */
    public void p(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long z4 = z();
        int size = this.M.size();
        for (int i5 = 0; i5 < size; i5++) {
            l lVar = this.M.get(i5);
            if (z4 > 0 && (this.N || i5 == 0)) {
                long z5 = lVar.z();
                if (z5 > 0) {
                    lVar.a0(z5 + z4);
                } else {
                    lVar.a0(z4);
                }
            }
            lVar.p(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }
}
