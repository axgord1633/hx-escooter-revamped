package com.mr.flutter.plugin.filepicker;

import android.net.Uri;
import java.util.HashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    final String f3850a;

    /* renamed from: b  reason: collision with root package name */
    final String f3851b;

    /* renamed from: c  reason: collision with root package name */
    final Uri f3852c;

    /* renamed from: d  reason: collision with root package name */
    final long f3853d;

    /* renamed from: e  reason: collision with root package name */
    final byte[] f3854e;

    /* renamed from: com.mr.flutter.plugin.filepicker.a$a  reason: collision with other inner class name */
    public static class C0068a {

        /* renamed from: a  reason: collision with root package name */
        private String f3855a;

        /* renamed from: b  reason: collision with root package name */
        private String f3856b;

        /* renamed from: c  reason: collision with root package name */
        private Uri f3857c;

        /* renamed from: d  reason: collision with root package name */
        private long f3858d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f3859e;

        public a a() {
            return new a(this.f3855a, this.f3856b, this.f3857c, this.f3858d, this.f3859e);
        }

        public C0068a b(byte[] bArr) {
            this.f3859e = bArr;
            return this;
        }

        public C0068a c(String str) {
            this.f3856b = str;
            return this;
        }

        public C0068a d(String str) {
            this.f3855a = str;
            return this;
        }

        public C0068a e(long j5) {
            this.f3858d = j5;
            return this;
        }

        public C0068a f(Uri uri) {
            this.f3857c = uri;
            return this;
        }
    }

    public a(String str, String str2, Uri uri, long j5, byte[] bArr) {
        this.f3850a = str;
        this.f3851b = str2;
        this.f3853d = j5;
        this.f3854e = bArr;
        this.f3852c = uri;
    }

    public HashMap<String, Object> a() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("path", this.f3850a);
        hashMap.put("name", this.f3851b);
        hashMap.put("size", Long.valueOf(this.f3853d));
        hashMap.put("bytes", this.f3854e);
        hashMap.put("identifier", this.f3852c.toString());
        return hashMap;
    }
}
