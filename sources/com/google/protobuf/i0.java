package com.google.protobuf;

import com.google.protobuf.b0;
import java.util.Collections;
import java.util.List;

abstract class i0 {

    /* renamed from: a  reason: collision with root package name */
    private static final i0 f3545a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final i0 f3546b = new c();

    private static final class b extends i0 {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?> f3547c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private b() {
            super();
        }

        static <E> List<E> f(Object obj, long j5) {
            return (List) t1.G(obj, j5);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.protobuf.g0} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.protobuf.g0} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.protobuf.g0} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static <L> java.util.List<L> g(java.lang.Object r3, long r4, int r6) {
            /*
                java.util.List r0 = f(r3, r4)
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x002d
                boolean r1 = r0 instanceof com.google.protobuf.h0
                if (r1 == 0) goto L_0x0014
                com.google.protobuf.g0 r0 = new com.google.protobuf.g0
                r0.<init>((int) r6)
                goto L_0x0029
            L_0x0014:
                boolean r1 = r0 instanceof com.google.protobuf.c1
                if (r1 == 0) goto L_0x0024
                boolean r1 = r0 instanceof com.google.protobuf.b0.i
                if (r1 == 0) goto L_0x0024
                com.google.protobuf.b0$i r0 = (com.google.protobuf.b0.i) r0
                com.google.protobuf.b0$i r6 = r0.a(r6)
                r0 = r6
                goto L_0x0029
            L_0x0024:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r6)
            L_0x0029:
                com.google.protobuf.t1.V(r3, r4, r0)
                goto L_0x007a
            L_0x002d:
                java.lang.Class<?> r1 = f3547c
                java.lang.Class r2 = r0.getClass()
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 == 0) goto L_0x004b
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>(r2)
                r1.addAll(r0)
            L_0x0046:
                com.google.protobuf.t1.V(r3, r4, r1)
                r0 = r1
                goto L_0x007a
            L_0x004b:
                boolean r1 = r0 instanceof com.google.protobuf.s1
                if (r1 == 0) goto L_0x005f
                com.google.protobuf.g0 r1 = new com.google.protobuf.g0
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>((int) r2)
                com.google.protobuf.s1 r0 = (com.google.protobuf.s1) r0
                r1.addAll(r0)
                goto L_0x0046
            L_0x005f:
                boolean r1 = r0 instanceof com.google.protobuf.c1
                if (r1 == 0) goto L_0x007a
                boolean r1 = r0 instanceof com.google.protobuf.b0.i
                if (r1 == 0) goto L_0x007a
                r1 = r0
                com.google.protobuf.b0$i r1 = (com.google.protobuf.b0.i) r1
                boolean r2 = r1.k()
                if (r2 != 0) goto L_0x007a
                int r0 = r0.size()
                int r0 = r0 + r6
                com.google.protobuf.b0$i r0 = r1.a(r0)
                goto L_0x0029
            L_0x007a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.i0.b.g(java.lang.Object, long, int):java.util.List");
        }

        /* access modifiers changed from: package-private */
        public void c(Object obj, long j5) {
            Object obj2;
            List list = (List) t1.G(obj, j5);
            if (list instanceof h0) {
                obj2 = ((h0) list).g();
            } else if (!f3547c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof c1) || !(list instanceof b0.i)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    b0.i iVar = (b0.i) list;
                    if (iVar.k()) {
                        iVar.b();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            t1.V(obj, j5, obj2);
        }

        /* access modifiers changed from: package-private */
        public <E> void d(Object obj, Object obj2, long j5) {
            List f5 = f(obj2, j5);
            List g5 = g(obj, j5, f5.size());
            int size = g5.size();
            int size2 = f5.size();
            if (size > 0 && size2 > 0) {
                g5.addAll(f5);
            }
            if (size > 0) {
                f5 = g5;
            }
            t1.V(obj, j5, f5);
        }

        /* access modifiers changed from: package-private */
        public <L> List<L> e(Object obj, long j5) {
            return g(obj, j5, 10);
        }
    }

    private static final class c extends i0 {
        private c() {
            super();
        }

        static <E> b0.i<E> f(Object obj, long j5) {
            return (b0.i) t1.G(obj, j5);
        }

        /* access modifiers changed from: package-private */
        public void c(Object obj, long j5) {
            f(obj, j5).b();
        }

        /* access modifiers changed from: package-private */
        public <E> void d(Object obj, Object obj2, long j5) {
            b0.i f5 = f(obj, j5);
            b0.i f6 = f(obj2, j5);
            int size = f5.size();
            int size2 = f6.size();
            if (size > 0 && size2 > 0) {
                if (!f5.k()) {
                    f5 = f5.a(size2 + size);
                }
                f5.addAll(f6);
            }
            if (size > 0) {
                f6 = f5;
            }
            t1.V(obj, j5, f6);
        }

        /* access modifiers changed from: package-private */
        public <L> List<L> e(Object obj, long j5) {
            b0.i f5 = f(obj, j5);
            if (f5.k()) {
                return f5;
            }
            int size = f5.size();
            b0.i a5 = f5.a(size == 0 ? 10 : size * 2);
            t1.V(obj, j5, a5);
            return a5;
        }
    }

    private i0() {
    }

    static i0 a() {
        return f3545a;
    }

    static i0 b() {
        return f3546b;
    }

    /* access modifiers changed from: package-private */
    public abstract void c(Object obj, long j5);

    /* access modifiers changed from: package-private */
    public abstract <L> void d(Object obj, Object obj2, long j5);

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> e(Object obj, long j5);
}
