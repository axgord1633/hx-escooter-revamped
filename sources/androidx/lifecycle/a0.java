package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class a0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f2551a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Set<Closeable> f2552b = new LinkedHashSet();

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f2553c = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f2553c = true;
        Map<String, Object> map = this.f2551a;
        if (map != null) {
            synchronized (map) {
                for (Object b5 : this.f2551a.values()) {
                    b(b5);
                }
            }
        }
        Set<Closeable> set = this.f2552b;
        if (set != null) {
            synchronized (set) {
                for (Closeable b6 : this.f2552b) {
                    b(b6);
                }
            }
        }
        d();
    }

    /* access modifiers changed from: package-private */
    public <T> T c(String str) {
        T t5;
        Map<String, Object> map = this.f2551a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t5 = this.f2551a.get(str);
        }
        return t5;
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    /* access modifiers changed from: package-private */
    public <T> T e(String str, T t5) {
        T t6;
        synchronized (this.f2551a) {
            t6 = this.f2551a.get(str);
            if (t6 == null) {
                this.f2551a.put(str, t5);
            }
        }
        if (t6 != null) {
            t5 = t6;
        }
        if (this.f2553c) {
            b(t5);
        }
        return t5;
    }
}
