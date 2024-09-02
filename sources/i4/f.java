package i4;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import r4.c;

public final class f {

    /* renamed from: c  reason: collision with root package name */
    public static final f f5008c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f5009a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final c f5010b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f5011a = new ArrayList();

        public f a() {
            return new f(new LinkedHashSet(this.f5011a), (c) null);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f5012a;

        /* renamed from: b  reason: collision with root package name */
        final String f5013b;

        /* renamed from: c  reason: collision with root package name */
        final String f5014c;

        /* renamed from: d  reason: collision with root package name */
        final s4.f f5015d;

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            if (!this.f5012a.startsWith("*.")) {
                return str.equals(this.f5013b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f5013b.length()) {
                String str2 = this.f5013b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f5012a.equals(bVar.f5012a) && this.f5014c.equals(bVar.f5014c) && this.f5015d.equals(bVar.f5015d);
            }
        }

        public int hashCode() {
            return ((((527 + this.f5012a.hashCode()) * 31) + this.f5014c.hashCode()) * 31) + this.f5015d.hashCode();
        }

        public String toString() {
            return this.f5014c + this.f5015d.c();
        }
    }

    f(Set<b> set, @Nullable c cVar) {
        this.f5009a = set;
        this.f5010b = cVar;
    }

    public static String c(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + e((X509Certificate) certificate).c();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static s4.f d(X509Certificate x509Certificate) {
        return s4.f.r(x509Certificate.getPublicKey().getEncoded()).u();
    }

    static s4.f e(X509Certificate x509Certificate) {
        return s4.f.r(x509Certificate.getPublicKey().getEncoded()).v();
    }

    public void a(String str, List<Certificate> list) {
        List<b> b5 = b(str);
        if (!b5.isEmpty()) {
            c cVar = this.f5010b;
            if (cVar != null) {
                list = cVar.a(list, str);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i5);
                int size2 = b5.size();
                s4.f fVar = null;
                s4.f fVar2 = null;
                for (int i6 = 0; i6 < size2; i6++) {
                    b bVar = b5.get(i6);
                    if (bVar.f5014c.equals("sha256/")) {
                        if (fVar == null) {
                            fVar = e(x509Certificate);
                        }
                        if (bVar.f5015d.equals(fVar)) {
                            return;
                        }
                    } else if (bVar.f5014c.equals("sha1/")) {
                        if (fVar2 == null) {
                            fVar2 = d(x509Certificate);
                        }
                        if (bVar.f5015d.equals(fVar2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f5014c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i7 = 0; i7 < size3; i7++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i7);
                sb.append("\n    ");
                sb.append(c(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = b5.size();
            for (int i8 = 0; i8 < size4; i8++) {
                sb.append("\n    ");
                sb.append(b5.get(i8));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public List<b> b(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b next : this.f5009a) {
            if (next.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return j4.c.o(this.f5010b, fVar.f5010b) && this.f5009a.equals(fVar.f5009a);
        }
    }

    /* access modifiers changed from: package-private */
    public f f(@Nullable c cVar) {
        return j4.c.o(this.f5010b, cVar) ? this : new f(this.f5009a, cVar);
    }

    public int hashCode() {
        c cVar = this.f5010b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f5009a.hashCode();
    }
}
