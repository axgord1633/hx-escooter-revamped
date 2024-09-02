package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.c;
import w0.p;

public class d {
    public static <L> c<L> a(L l5, Looper looper, String str) {
        p.h(l5, "Listener must not be null");
        p.h(looper, "Looper must not be null");
        p.h(str, "Listener type must not be null");
        return new c<>(looper, l5, str);
    }

    public static <L> c.a<L> b(L l5, String str) {
        p.h(l5, "Listener must not be null");
        p.h(str, "Listener type must not be null");
        p.f(str, "Listener type must not be empty");
        return new c.a<>(l5, str);
    }
}
