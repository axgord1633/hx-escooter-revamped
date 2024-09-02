package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry {

    /* renamed from: a  reason: collision with root package name */
    private Random f514a = new Random();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, String> f515b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Map<String, Integer> f516c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, d> f517d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<String> f518e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    final transient Map<String, c<?>> f519f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    final Map<String, Object> f520g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    final Bundle f521h = new Bundle();

    class a extends c<I> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f526a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c.a f527b;

        a(String str, c.a aVar) {
            this.f526a = str;
            this.f527b = aVar;
        }

        public void b(I i5, androidx.core.app.d dVar) {
            Integer num = ActivityResultRegistry.this.f516c.get(this.f526a);
            if (num != null) {
                ActivityResultRegistry.this.f518e.add(this.f526a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f527b, i5, dVar);
                } catch (Exception e5) {
                    ActivityResultRegistry.this.f518e.remove(this.f526a);
                    throw e5;
                }
            } else {
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f527b + " and input " + i5 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            }
        }

        public void c() {
            ActivityResultRegistry.this.l(this.f526a);
        }
    }

    class b extends c<I> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f529a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c.a f530b;

        b(String str, c.a aVar) {
            this.f529a = str;
            this.f530b = aVar;
        }

        public void b(I i5, androidx.core.app.d dVar) {
            Integer num = ActivityResultRegistry.this.f516c.get(this.f529a);
            if (num != null) {
                ActivityResultRegistry.this.f518e.add(this.f529a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f530b, i5, dVar);
                } catch (Exception e5) {
                    ActivityResultRegistry.this.f518e.remove(this.f529a);
                    throw e5;
                }
            } else {
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f530b + " and input " + i5 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            }
        }

        public void c() {
            ActivityResultRegistry.this.l(this.f529a);
        }
    }

    private static class c<O> {

        /* renamed from: a  reason: collision with root package name */
        final b<O> f532a;

        /* renamed from: b  reason: collision with root package name */
        final c.a<?, O> f533b;

        c(b<O> bVar, c.a<?, O> aVar) {
            this.f532a = bVar;
            this.f533b = aVar;
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        final f f534a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<h> f535b = new ArrayList<>();

        d(f fVar) {
            this.f534a = fVar;
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar) {
            this.f534a.a(hVar);
            this.f535b.add(hVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Iterator<h> it = this.f535b.iterator();
            while (it.hasNext()) {
                this.f534a.c(it.next());
            }
            this.f535b.clear();
        }
    }

    private void a(int i5, String str) {
        this.f515b.put(Integer.valueOf(i5), str);
        this.f516c.put(str, Integer.valueOf(i5));
    }

    private <O> void d(String str, int i5, Intent intent, c<O> cVar) {
        if (cVar == null || cVar.f532a == null || !this.f518e.contains(str)) {
            this.f520g.remove(str);
            this.f521h.putParcelable(str, new a(i5, intent));
            return;
        }
        cVar.f532a.a(cVar.f533b.c(i5, intent));
        this.f518e.remove(str);
    }

    private int e() {
        int nextInt = this.f514a.nextInt(2147418112);
        while (true) {
            int i5 = nextInt + 65536;
            if (!this.f515b.containsKey(Integer.valueOf(i5))) {
                return i5;
            }
            nextInt = this.f514a.nextInt(2147418112);
        }
    }

    private void k(String str) {
        if (this.f516c.get(str) == null) {
            a(e(), str);
        }
    }

    public final boolean b(int i5, int i6, Intent intent) {
        String str = this.f515b.get(Integer.valueOf(i5));
        if (str == null) {
            return false;
        }
        d(str, i6, intent, this.f519f.get(str));
        return true;
    }

    public final <O> boolean c(int i5, O o5) {
        b<O> bVar;
        String str = this.f515b.get(Integer.valueOf(i5));
        if (str == null) {
            return false;
        }
        c cVar = this.f519f.get(str);
        if (cVar == null || (bVar = cVar.f532a) == null) {
            this.f521h.remove(str);
            this.f520g.put(str, o5);
            return true;
        } else if (!this.f518e.remove(str)) {
            return true;
        } else {
            bVar.a(o5);
            return true;
        }
    }

    public abstract <I, O> void f(int i5, c.a<I, O> aVar, I i6, androidx.core.app.d dVar);

    public final void g(Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                this.f518e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.f514a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                this.f521h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                for (int i5 = 0; i5 < stringArrayList.size(); i5++) {
                    String str = stringArrayList.get(i5);
                    if (this.f516c.containsKey(str)) {
                        Integer remove = this.f516c.remove(str);
                        if (!this.f521h.containsKey(str)) {
                            this.f515b.remove(remove);
                        }
                    }
                    a(integerArrayList.get(i5).intValue(), stringArrayList.get(i5));
                }
            }
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.f516c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.f516c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.f518e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f521h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f514a);
    }

    public final <I, O> c<I> i(final String str, j jVar, final c.a<I, O> aVar, final b<O> bVar) {
        f lifecycle = jVar.getLifecycle();
        if (!lifecycle.b().f(f.b.STARTED)) {
            k(str);
            d dVar = this.f517d.get(str);
            if (dVar == null) {
                dVar = new d(lifecycle);
            }
            dVar.a(new h() {
                public void a(j jVar, f.a aVar) {
                    if (f.a.ON_START.equals(aVar)) {
                        ActivityResultRegistry.this.f519f.put(str, new c(bVar, aVar));
                        if (ActivityResultRegistry.this.f520g.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f520g.get(str);
                            ActivityResultRegistry.this.f520g.remove(str);
                            bVar.a(obj);
                        }
                        a aVar2 = (a) ActivityResultRegistry.this.f521h.getParcelable(str);
                        if (aVar2 != null) {
                            ActivityResultRegistry.this.f521h.remove(str);
                            bVar.a(aVar.c(aVar2.b(), aVar2.a()));
                        }
                    } else if (f.a.ON_STOP.equals(aVar)) {
                        ActivityResultRegistry.this.f519f.remove(str);
                    } else if (f.a.ON_DESTROY.equals(aVar)) {
                        ActivityResultRegistry.this.l(str);
                    }
                }
            });
            this.f517d.put(str, dVar);
            return new a(str, aVar);
        }
        throw new IllegalStateException("LifecycleOwner " + jVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final <I, O> c<I> j(String str, c.a<I, O> aVar, b<O> bVar) {
        k(str);
        this.f519f.put(str, new c(bVar, aVar));
        if (this.f520g.containsKey(str)) {
            Object obj = this.f520g.get(str);
            this.f520g.remove(str);
            bVar.a(obj);
        }
        a aVar2 = (a) this.f521h.getParcelable(str);
        if (aVar2 != null) {
            this.f521h.remove(str);
            bVar.a(aVar.c(aVar2.b(), aVar2.a()));
        }
        return new b(str, aVar);
    }

    /* access modifiers changed from: package-private */
    public final void l(String str) {
        Integer remove;
        if (!this.f518e.contains(str) && (remove = this.f516c.remove(str)) != null) {
            this.f515b.remove(remove);
        }
        this.f519f.remove(str);
        if (this.f520g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f520g.get(str));
            this.f520g.remove(str);
        }
        if (this.f521h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f521h.getParcelable(str));
            this.f521h.remove(str);
        }
        d dVar = this.f517d.get(str);
        if (dVar != null) {
            dVar.b();
            this.f517d.remove(str);
        }
    }
}
