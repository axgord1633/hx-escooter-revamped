package androidx.core.os;

import android.os.CancellationSignal;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1783a;

    /* renamed from: b  reason: collision with root package name */
    private b f1784b;

    /* renamed from: c  reason: collision with root package name */
    private Object f1785c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1786d;

    static class a {
        static void a(Object obj) {
            ((CancellationSignal) obj).cancel();
        }

        static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    public interface b {
        void onCancel();
    }

    private void d() {
        while (this.f1786d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.onCancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        if (r1 == null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        androidx.core.os.e.a.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.f1786d = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0027, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002b, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r3.f1786d = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0031, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0 == null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f1783a     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0036 }
            return
        L_0x0007:
            r0 = 1
            r3.f1783a = r0     // Catch:{ all -> 0x0036 }
            r3.f1786d = r0     // Catch:{ all -> 0x0036 }
            androidx.core.os.e$b r0 = r3.f1784b     // Catch:{ all -> 0x0036 }
            java.lang.Object r1 = r3.f1785c     // Catch:{ all -> 0x0036 }
            monitor-exit(r3)     // Catch:{ all -> 0x0036 }
            r2 = 0
            if (r0 == 0) goto L_0x001a
            r0.onCancel()     // Catch:{ all -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            r0 = move-exception
            goto L_0x0020
        L_0x001a:
            if (r1 == 0) goto L_0x002b
            androidx.core.os.e.a.a(r1)     // Catch:{ all -> 0x0018 }
            goto L_0x002b
        L_0x0020:
            monitor-enter(r3)
            r3.f1786d = r2     // Catch:{ all -> 0x0028 }
            r3.notifyAll()     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)     // Catch:{ all -> 0x0028 }
            throw r0
        L_0x0028:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0028 }
            throw r0
        L_0x002b:
            monitor-enter(r3)
            r3.f1786d = r2     // Catch:{ all -> 0x0033 }
            r3.notifyAll()     // Catch:{ all -> 0x0033 }
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return
        L_0x0033:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            throw r0
        L_0x0036:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0036 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.os.e.a():void");
    }

    public boolean b() {
        boolean z4;
        synchronized (this) {
            z4 = this.f1783a;
        }
        return z4;
    }

    public void c(b bVar) {
        synchronized (this) {
            d();
            if (this.f1784b != bVar) {
                this.f1784b = bVar;
                if (this.f1783a) {
                    if (bVar != null) {
                        bVar.onCancel();
                    }
                }
            }
        }
    }
}
