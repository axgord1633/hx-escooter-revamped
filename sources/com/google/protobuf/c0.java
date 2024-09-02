package com.google.protobuf;

import java.io.IOException;

public class c0 extends IOException {

    /* renamed from: e  reason: collision with root package name */
    private s0 f3475e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3476f;

    public static class a extends c0 {
        public a(String str) {
            super(str);
        }
    }

    public c0(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public c0(String str) {
        super(str);
    }

    static c0 b() {
        return new c0("Protocol message end-group tag did not match expected tag.");
    }

    static c0 c() {
        return new c0("Protocol message contained an invalid tag (zero).");
    }

    static c0 d() {
        return new c0("Protocol message had invalid UTF-8.");
    }

    static a e() {
        return new a("Protocol message tag had invalid wire type.");
    }

    static c0 f() {
        return new c0("CodedInputStream encountered a malformed varint.");
    }

    static c0 g() {
        return new c0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static c0 h() {
        return new c0("Failed to parse the message.");
    }

    static c0 i() {
        return new c0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static c0 l() {
        return new c0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static c0 m() {
        return new c0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f3476f;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f3476f = true;
    }

    public c0 k(s0 s0Var) {
        this.f3475e = s0Var;
        return this;
    }
}
