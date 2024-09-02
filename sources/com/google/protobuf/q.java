package com.google.protobuf;

import com.google.protobuf.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class q {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3647b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile q f3648c;

    /* renamed from: d  reason: collision with root package name */
    static final q f3649d = new q(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map<a, z.e<?, ?>> f3650a;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f3651a;

        /* renamed from: b  reason: collision with root package name */
        private final int f3652b;

        a(Object obj, int i5) {
            this.f3651a = obj;
            this.f3652b = i5;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3651a == aVar.f3651a && this.f3652b == aVar.f3652b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f3651a) * 65535) + this.f3652b;
        }
    }

    q() {
        this.f3650a = new HashMap();
    }

    q(boolean z4) {
        this.f3650a = Collections.emptyMap();
    }

    public static q b() {
        q qVar = f3648c;
        if (qVar == null) {
            synchronized (q.class) {
                qVar = f3648c;
                if (qVar == null) {
                    qVar = f3647b ? p.a() : f3649d;
                    f3648c = qVar;
                }
            }
        }
        return qVar;
    }

    public <ContainingType extends s0> z.e<ContainingType, ?> a(ContainingType containingtype, int i5) {
        return this.f3650a.get(new a(containingtype, i5));
    }
}
