package androidx.concurrent.futures;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class a<V> implements m1.a<V> {

    /* renamed from: h  reason: collision with root package name */
    static final boolean f1486h = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: i  reason: collision with root package name */
    private static final Logger f1487i = Logger.getLogger(a.class.getName());

    /* renamed from: j  reason: collision with root package name */
    static final b f1488j;

    /* renamed from: k  reason: collision with root package name */
    private static final Object f1489k = new Object();

    /* renamed from: e  reason: collision with root package name */
    volatile Object f1490e;

    /* renamed from: f  reason: collision with root package name */
    volatile e f1491f;

    /* renamed from: g  reason: collision with root package name */
    volatile i f1492g;

    private static abstract class b {
        private b() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a(a<?> aVar, e eVar, e eVar2);

        /* access modifiers changed from: package-private */
        public abstract boolean b(a<?> aVar, Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract boolean c(a<?> aVar, i iVar, i iVar2);

        /* access modifiers changed from: package-private */
        public abstract void d(i iVar, i iVar2);

        /* access modifiers changed from: package-private */
        public abstract void e(i iVar, Thread thread);
    }

    private static final class c {

        /* renamed from: c  reason: collision with root package name */
        static final c f1493c;

        /* renamed from: d  reason: collision with root package name */
        static final c f1494d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f1495a;

        /* renamed from: b  reason: collision with root package name */
        final Throwable f1496b;

        static {
            if (a.f1486h) {
                f1494d = null;
                f1493c = null;
                return;
            }
            f1494d = new c(false, (Throwable) null);
            f1493c = new c(true, (Throwable) null);
        }

        c(boolean z4, Throwable th) {
            this.f1495a = z4;
            this.f1496b = th;
        }
    }

    private static final class d {

        /* renamed from: b  reason: collision with root package name */
        static final d f1497b = new d(new C0020a("Failure occurred while trying to finish a future."));

        /* renamed from: a  reason: collision with root package name */
        final Throwable f1498a;

        /* renamed from: androidx.concurrent.futures.a$d$a  reason: collision with other inner class name */
        class C0020a extends Throwable {
            C0020a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.f1498a = (Throwable) a.d(th);
        }
    }

    private static final class e {

        /* renamed from: d  reason: collision with root package name */
        static final e f1499d = new e((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        final Runnable f1500a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f1501b;

        /* renamed from: c  reason: collision with root package name */
        e f1502c;

        e(Runnable runnable, Executor executor) {
            this.f1500a = runnable;
            this.f1501b = executor;
        }
    }

    private static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, Thread> f1503a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, i> f1504b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, i> f1505c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, e> f1506d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f1507e;

        f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f1503a = atomicReferenceFieldUpdater;
            this.f1504b = atomicReferenceFieldUpdater2;
            this.f1505c = atomicReferenceFieldUpdater3;
            this.f1506d = atomicReferenceFieldUpdater4;
            this.f1507e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            return b.a(this.f1506d, aVar, eVar, eVar2);
        }

        /* access modifiers changed from: package-private */
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            return b.a(this.f1507e, aVar, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            return b.a(this.f1505c, aVar, iVar, iVar2);
        }

        /* access modifiers changed from: package-private */
        public void d(i iVar, i iVar2) {
            this.f1504b.lazySet(iVar, iVar2);
        }

        /* access modifiers changed from: package-private */
        public void e(i iVar, Thread thread) {
            this.f1503a.lazySet(iVar, thread);
        }
    }

    private static final class g<V> implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final a<V> f1508e;

        /* renamed from: f  reason: collision with root package name */
        final m1.a<? extends V> f1509f;

        public void run() {
            if (this.f1508e.f1490e == this) {
                if (a.f1488j.b(this.f1508e, this, a.i(this.f1509f))) {
                    a.f(this.f1508e);
                }
            }
        }
    }

    private static final class h extends b {
        h() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f1491f != eVar) {
                    return false;
                }
                aVar.f1491f = eVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f1490e != obj) {
                    return false;
                }
                aVar.f1490e = obj2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f1492g != iVar) {
                    return false;
                }
                aVar.f1492g = iVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void d(i iVar, i iVar2) {
            iVar.f1512b = iVar2;
        }

        /* access modifiers changed from: package-private */
        public void e(i iVar, Thread thread) {
            iVar.f1511a = thread;
        }
    }

    private static final class i {

        /* renamed from: c  reason: collision with root package name */
        static final i f1510c = new i(false);

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f1511a;

        /* renamed from: b  reason: collision with root package name */
        volatile i f1512b;

        i() {
            a.f1488j.e(this, Thread.currentThread());
        }

        i(boolean z4) {
        }

        /* access modifiers changed from: package-private */
        public void a(i iVar) {
            a.f1488j.d(this, iVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Thread thread = this.f1511a;
            if (thread != null) {
                this.f1511a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.concurrent.futures.a$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.concurrent.futures.a$h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: androidx.concurrent.futures.a$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.concurrent.futures.a$f} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.concurrent.futures.a$i> r0 = androidx.concurrent.futures.a.i.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            f1486h = r1
            java.lang.Class<androidx.concurrent.futures.a> r1 = androidx.concurrent.futures.a.class
            java.lang.String r1 = r1.getName()
            java.util.logging.Logger r1 = java.util.logging.Logger.getLogger(r1)
            f1487i = r1
            androidx.concurrent.futures.a$f r1 = new androidx.concurrent.futures.a$f     // Catch:{ all -> 0x004e }
            java.lang.Class<java.lang.Thread> r2 = java.lang.Thread.class
            java.lang.String r3 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r3)     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r2)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.concurrent.futures.a> r2 = androidx.concurrent.futures.a.class
            java.lang.String r5 = "g"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r2, r0, r5)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.concurrent.futures.a> r0 = androidx.concurrent.futures.a.class
            java.lang.Class<androidx.concurrent.futures.a$e> r2 = androidx.concurrent.futures.a.e.class
            java.lang.String r6 = "f"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r6)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.concurrent.futures.a> r0 = androidx.concurrent.futures.a.class
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            java.lang.String r7 = "e"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r7)     // Catch:{ all -> 0x004e }
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x004e }
            r0 = 0
            goto L_0x0054
        L_0x004e:
            r0 = move-exception
            androidx.concurrent.futures.a$h r1 = new androidx.concurrent.futures.a$h
            r1.<init>()
        L_0x0054:
            f1488j = r1
            java.lang.Class<java.util.concurrent.locks.LockSupport> r1 = java.util.concurrent.locks.LockSupport.class
            if (r0 == 0) goto L_0x0063
            java.util.logging.Logger r1 = f1487i
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x0063:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            f1489k = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.a.<clinit>():void");
    }

    protected a() {
    }

    private void a(StringBuilder sb) {
        String str = "]";
        try {
            Object j5 = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(p(j5));
            sb.append(str);
            return;
        } catch (ExecutionException e5) {
            sb.append("FAILURE, cause=[");
            sb.append(e5.getCause());
        } catch (CancellationException unused) {
            str = "CANCELLED";
        } catch (RuntimeException e6) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e6.getClass());
            str = " thrown from get()]";
        }
        sb.append(str);
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T d(T t5) {
        t5.getClass();
        return t5;
    }

    private e e(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f1491f;
        } while (!f1488j.a(this, eVar2, e.f1499d));
        e eVar3 = eVar2;
        e eVar4 = eVar;
        e eVar5 = eVar3;
        while (eVar5 != null) {
            e eVar6 = eVar5.f1502c;
            eVar5.f1502c = eVar4;
            eVar4 = eVar5;
            eVar5 = eVar6;
        }
        return eVar4;
    }

    static void f(a<?> aVar) {
        e eVar = null;
        a<V> aVar2 = aVar;
        while (true) {
            aVar2.m();
            aVar2.b();
            e e5 = aVar2.e(eVar);
            while (true) {
                if (e5 != null) {
                    eVar = e5.f1502c;
                    Runnable runnable = e5.f1500a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        a<V> aVar3 = gVar.f1508e;
                        if (aVar3.f1490e == gVar) {
                            if (f1488j.b(aVar3, gVar, i(gVar.f1509f))) {
                                aVar2 = aVar3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        g(runnable, e5.f1501b);
                    }
                    e5 = eVar;
                } else {
                    return;
                }
            }
        }
    }

    private static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e5) {
            Logger logger = f1487i;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e5);
        }
    }

    private V h(Object obj) {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f1496b);
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f1498a);
        } else if (obj == f1489k) {
            return null;
        } else {
            return obj;
        }
    }

    static Object i(m1.a<?> aVar) {
        if (aVar instanceof a) {
            Object obj = ((a) aVar).f1490e;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f1495a ? cVar.f1496b != null ? new c(false, cVar.f1496b) : c.f1494d : obj;
        }
        boolean isCancelled = aVar.isCancelled();
        if ((!f1486h) && isCancelled) {
            return c.f1494d;
        }
        try {
            Object j5 = j(aVar);
            return j5 == null ? f1489k : j5;
        } catch (ExecutionException e5) {
            return new d(e5.getCause());
        } catch (CancellationException e6) {
            if (isCancelled) {
                return new c(false, e6);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + aVar, e6));
        } catch (Throwable th) {
            return new d(th);
        }
    }

    static <V> V j(Future<V> future) {
        V v5;
        boolean z4 = false;
        while (true) {
            try {
                v5 = future.get();
                break;
            } catch (InterruptedException unused) {
                z4 = true;
            } catch (Throwable th) {
                if (z4) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
        return v5;
    }

    private void m() {
        i iVar;
        do {
            iVar = this.f1492g;
        } while (!f1488j.c(this, iVar, i.f1510c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f1512b;
        }
    }

    private void n(i iVar) {
        iVar.f1511a = null;
        while (true) {
            i iVar2 = this.f1492g;
            if (iVar2 != i.f1510c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.f1512b;
                    if (iVar2.f1511a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.f1512b = iVar4;
                        if (iVar3.f1511a == null) {
                        }
                    } else if (!f1488j.c(this, iVar2, iVar4)) {
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    private String p(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, m1.a<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f1490e
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r2
        L_0x0009:
            boolean r4 = r0 instanceof androidx.concurrent.futures.a.g
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = f1486h
            if (r3 == 0) goto L_0x001f
            androidx.concurrent.futures.a$c r3 = new androidx.concurrent.futures.a$c
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.concurrent.futures.a$c r3 = androidx.concurrent.futures.a.c.f1493c
            goto L_0x0026
        L_0x0024:
            androidx.concurrent.futures.a$c r3 = androidx.concurrent.futures.a.c.f1494d
        L_0x0026:
            r4 = r7
            r5 = r2
        L_0x0028:
            androidx.concurrent.futures.a$b r6 = f1488j
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.k()
        L_0x0035:
            f(r4)
            boolean r4 = r0 instanceof androidx.concurrent.futures.a.g
            if (r4 == 0) goto L_0x0062
            androidx.concurrent.futures.a$g r0 = (androidx.concurrent.futures.a.g) r0
            m1.a<? extends V> r0 = r0.f1509f
            boolean r4 = r0 instanceof androidx.concurrent.futures.a
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.concurrent.futures.a r4 = (androidx.concurrent.futures.a) r4
            java.lang.Object r0 = r4.f1490e
            if (r0 != 0) goto L_0x004d
            r5 = r1
            goto L_0x004e
        L_0x004d:
            r5 = r2
        L_0x004e:
            boolean r6 = r0 instanceof androidx.concurrent.futures.a.g
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = r1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.f1490e
            boolean r6 = r0 instanceof androidx.concurrent.futures.a.g
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.a.cancel(boolean):boolean");
    }

    public final V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f1490e;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return h(obj2);
            }
            i iVar = this.f1492g;
            if (iVar != i.f1510c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f1488j.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f1490e;
                            } else {
                                n(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return h(obj);
                    }
                    iVar = this.f1492g;
                } while (iVar != i.f1510c);
            }
            return h(this.f1490e);
        }
        throw new InterruptedException();
    }

    public final V get(long j5, TimeUnit timeUnit) {
        long j6 = j5;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j6);
        if (!Thread.interrupted()) {
            Object obj = this.f1490e;
            if ((obj != null) && (!(obj instanceof g))) {
                return h(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                i iVar = this.f1492g;
                if (iVar != i.f1510c) {
                    i iVar2 = new i();
                    do {
                        iVar2.a(iVar);
                        if (f1488j.c(this, iVar, iVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f1490e;
                                    if ((obj2 != null) && (!(obj2 instanceof g))) {
                                        return h(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    n(iVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            n(iVar2);
                        } else {
                            iVar = this.f1492g;
                        }
                    } while (iVar != i.f1510c);
                }
                return h(this.f1490e);
            }
            while (nanos > 0) {
                Object obj3 = this.f1490e;
                if ((obj3 != null) && (!(obj3 instanceof g))) {
                    return h(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String aVar = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
            String str = "Waited " + j6 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j7 = -nanos;
                long convert = timeUnit2.convert(j7, TimeUnit.NANOSECONDS);
                long nanos2 = j7 - timeUnit2.toNanos(convert);
                int i5 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z4 = i5 == 0 || nanos2 > 1000;
                if (i5 > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z4) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z4) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + aVar);
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.f1490e instanceof c;
    }

    public final boolean isDone() {
        Object obj = this.f1490e;
        return (!(obj instanceof g)) & (obj != null);
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    /* access modifiers changed from: protected */
    public String l() {
        Object obj = this.f1490e;
        if (obj instanceof g) {
            return "setFuture=[" + p(((g) obj).f1509f) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    /* access modifiers changed from: protected */
    public boolean o(V v5) {
        if (v5 == null) {
            v5 = f1489k;
        }
        if (!f1488j.b(this, (Object) null, v5)) {
            return false;
        }
        f(this);
        return true;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            str2 = "CANCELLED";
        } else {
            if (!isDone()) {
                try {
                    str = l();
                } catch (RuntimeException e5) {
                    str = "Exception thrown from implementation: " + e5.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str);
                    sb.append("]");
                    sb.append("]");
                    return sb.toString();
                } else if (!isDone()) {
                    str2 = "PENDING";
                }
            }
            a(sb);
            sb.append("]");
            return sb.toString();
        }
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}
