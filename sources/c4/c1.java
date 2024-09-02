package c4;

import java.io.Closeable;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import o3.b;
import o3.g;

public abstract class c1 extends c0 implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    public static final a f3108g = new a((g) null);

    public static final class a extends b<c0, c1> {

        /* renamed from: c4.c1$a$a  reason: collision with other inner class name */
        static final class C0060a extends l implements v3.l<g.b, c1> {

            /* renamed from: e  reason: collision with root package name */
            public static final C0060a f3109e = new C0060a();

            C0060a() {
                super(1);
            }

            /* renamed from: a */
            public final c1 invoke(g.b bVar) {
                if (bVar instanceof c1) {
                    return (c1) bVar;
                }
                return null;
            }
        }

        private a() {
            super(c0.f3106f, C0060a.f3109e);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }
}
