package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f1927a;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<z> f1928b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<z, a> f1929c = new HashMap();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final f f1930a;

        /* renamed from: b  reason: collision with root package name */
        private h f1931b;

        a(f fVar, h hVar) {
            this.f1930a = fVar;
            this.f1931b = hVar;
            fVar.a(hVar);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1930a.c(this.f1931b);
            this.f1931b = null;
        }
    }

    public k(Runnable runnable) {
        this.f1927a = runnable;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(z zVar, j jVar, f.a aVar) {
        if (aVar == f.a.ON_DESTROY) {
            l(zVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(f.b bVar, z zVar, j jVar, f.a aVar) {
        if (aVar == f.a.l(bVar)) {
            c(zVar);
        } else if (aVar == f.a.ON_DESTROY) {
            l(zVar);
        } else if (aVar == f.a.f(bVar)) {
            this.f1928b.remove(zVar);
            this.f1927a.run();
        }
    }

    public void c(z zVar) {
        this.f1928b.add(zVar);
        this.f1927a.run();
    }

    public void d(z zVar, j jVar) {
        c(zVar);
        f lifecycle = jVar.getLifecycle();
        a remove = this.f1929c.remove(zVar);
        if (remove != null) {
            remove.a();
        }
        this.f1929c.put(zVar, new a(lifecycle, new i(this, zVar)));
    }

    public void e(z zVar, j jVar, f.b bVar) {
        f lifecycle = jVar.getLifecycle();
        a remove = this.f1929c.remove(zVar);
        if (remove != null) {
            remove.a();
        }
        this.f1929c.put(zVar, new a(lifecycle, new j(this, bVar, zVar)));
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator<z> it = this.f1928b.iterator();
        while (it.hasNext()) {
            it.next().c(menu, menuInflater);
        }
    }

    public void i(Menu menu) {
        Iterator<z> it = this.f1928b.iterator();
        while (it.hasNext()) {
            it.next().b(menu);
        }
    }

    public boolean j(MenuItem menuItem) {
        Iterator<z> it = this.f1928b.iterator();
        while (it.hasNext()) {
            if (it.next().a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(Menu menu) {
        Iterator<z> it = this.f1928b.iterator();
        while (it.hasNext()) {
            it.next().d(menu);
        }
    }

    public void l(z zVar) {
        this.f1928b.remove(zVar);
        a remove = this.f1929c.remove(zVar);
        if (remove != null) {
            remove.a();
        }
        this.f1927a.run();
    }
}
