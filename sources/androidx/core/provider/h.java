package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class h {

    private static class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        private String f1835e;

        /* renamed from: f  reason: collision with root package name */
        private int f1836f;

        /* renamed from: androidx.core.provider.h$a$a  reason: collision with other inner class name */
        private static class C0029a extends Thread {

            /* renamed from: e  reason: collision with root package name */
            private final int f1837e;

            C0029a(Runnable runnable, String str, int i5) {
                super(runnable, str);
                this.f1837e = i5;
            }

            public void run() {
                Process.setThreadPriority(this.f1837e);
                super.run();
            }
        }

        a(String str, int i5) {
            this.f1835e = str;
            this.f1836f = i5;
        }

        public Thread newThread(Runnable runnable) {
            return new C0029a(runnable, this.f1835e, this.f1836f);
        }
    }

    private static class b<T> implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        private Callable<T> f1838e;

        /* renamed from: f  reason: collision with root package name */
        private androidx.core.util.a<T> f1839f;

        /* renamed from: g  reason: collision with root package name */
        private Handler f1840g;

        class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ androidx.core.util.a f1841e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Object f1842f;

            a(androidx.core.util.a aVar, Object obj) {
                this.f1841e = aVar;
                this.f1842f = obj;
            }

            public void run() {
                this.f1841e.accept(this.f1842f);
            }
        }

        b(Handler handler, Callable<T> callable, androidx.core.util.a<T> aVar) {
            this.f1838e = callable;
            this.f1839f = aVar;
            this.f1840g = handler;
        }

        public void run() {
            T t5;
            try {
                t5 = this.f1838e.call();
            } catch (Exception unused) {
                t5 = null;
            }
            this.f1840g.post(new a(this.f1839f, t5));
        }
    }

    static ThreadPoolExecutor a(String str, int i5, int i6) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) i6, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i5));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static <T> void b(Executor executor, Callable<T> callable, androidx.core.util.a<T> aVar) {
        executor.execute(new b(b.a(), callable, aVar));
    }

    static <T> T c(ExecutorService executorService, Callable<T> callable, int i5) {
        try {
            return executorService.submit(callable).get((long) i5, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e5) {
            throw new RuntimeException(e5);
        } catch (InterruptedException e6) {
            throw e6;
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
