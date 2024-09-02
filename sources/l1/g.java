package l1;

import java.util.concurrent.Executor;

public abstract class g<TResult> {
    public abstract g<TResult> a(Executor executor, c<TResult> cVar);

    public abstract g<TResult> b(c<TResult> cVar);

    public abstract g<TResult> c(d dVar);

    public abstract g<TResult> d(e<? super TResult> eVar);

    public abstract <TContinuationResult> g<TContinuationResult> e(Executor executor, a<TResult, TContinuationResult> aVar);

    public abstract Exception f();

    public abstract TResult g();

    public abstract boolean h();

    public abstract boolean i();

    public abstract boolean j();
}
