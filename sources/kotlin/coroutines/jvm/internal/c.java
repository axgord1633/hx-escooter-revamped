package kotlin.coroutines.jvm.internal;

import o3.d;
import o3.g;

public final class c implements d<Object> {

    /* renamed from: e  reason: collision with root package name */
    public static final c f5550e = new c();

    private c() {
    }

    public g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
