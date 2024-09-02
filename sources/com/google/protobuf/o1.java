package com.google.protobuf;

import java.util.List;

public class o1 extends RuntimeException {

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f3643e = null;

    public o1(s0 s0Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public c0 a() {
        return new c0(getMessage());
    }
}
