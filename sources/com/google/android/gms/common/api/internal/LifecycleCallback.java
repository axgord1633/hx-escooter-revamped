package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import v0.e;
import v0.f;
import v0.i0;
import v0.k0;
import w0.p;

public class LifecycleCallback {

    /* renamed from: e  reason: collision with root package name */
    protected final f f3301e;

    protected LifecycleCallback(f fVar) {
        this.f3301e = fVar;
    }

    public static f c(Activity activity) {
        return d(new e(activity));
    }

    protected static f d(e eVar) {
        if (eVar.d()) {
            return k0.f(eVar.b());
        }
        if (eVar.c()) {
            return i0.f(eVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    private static f getChimeraLifecycleFragmentImpl(e eVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity b() {
        Activity c5 = this.f3301e.c();
        p.g(c5);
        return c5;
    }

    public void e(int i5, int i6, Intent intent) {
    }

    public void f(Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Bundle bundle) {
    }

    public void j() {
    }

    public void k() {
    }
}
