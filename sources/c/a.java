package c;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.k;

public abstract class a<I, O> {

    /* renamed from: c.a$a  reason: collision with other inner class name */
    public static final class C0056a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f3064a;

        public C0056a(T t5) {
            this.f3064a = t5;
        }

        public final T a() {
            return this.f3064a;
        }
    }

    public abstract Intent a(Context context, I i5);

    public C0056a<O> b(Context context, I i5) {
        k.e(context, "context");
        return null;
    }

    public abstract O c(int i5, Intent intent);
}
