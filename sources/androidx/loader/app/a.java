package androidx.loader.app;

import androidx.lifecycle.f0;
import androidx.lifecycle.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {
    public static <T extends j & f0> a b(T t5) {
        return new b(t5, ((f0) t5).getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
