package com.google.protobuf;

import com.google.protobuf.b0;
import com.google.protobuf.e0;
import com.google.protobuf.s0;
import com.google.protobuf.v.b;
import com.google.protobuf.v1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class v<T extends b<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final v f3693d = new v(true);

    /* renamed from: a  reason: collision with root package name */
    private final l1<T, Object> f3694a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3695b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3696c;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3697a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3698b;

        /* JADX WARNING: Can't wrap try/catch for region: R(55:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0107 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0111 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x011b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0125 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x012f */
        static {
            /*
                com.google.protobuf.v1$b[] r0 = com.google.protobuf.v1.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3698b = r0
                r1 = 1
                com.google.protobuf.v1$b r2 = com.google.protobuf.v1.b.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f3698b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.v1$b r3 = com.google.protobuf.v1.b.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f3698b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.v1$b r4 = com.google.protobuf.v1.b.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f3698b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.v1$b r5 = com.google.protobuf.v1.b.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f3698b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.v1$b r6 = com.google.protobuf.v1.b.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f3698b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.v1$b r7 = com.google.protobuf.v1.b.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f3698b     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.v1$b r8 = com.google.protobuf.v1.b.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = f3698b     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.v1$b r9 = com.google.protobuf.v1.b.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = f3698b     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.v1$b r10 = com.google.protobuf.v1.b.GROUP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r9 = f3698b     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.v1$b r10 = com.google.protobuf.v1.b.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r11 = 10
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r9 = f3698b     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.v1$b r10 = com.google.protobuf.v1.b.STRING     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11 = 11
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r9 = f3698b     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.v1$b r10 = com.google.protobuf.v1.b.BYTES     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r11 = 12
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r9 = f3698b     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.v1$b r10 = com.google.protobuf.v1.b.UINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r11 = 13
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r9 = f3698b     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.v1$b r10 = com.google.protobuf.v1.b.SFIXED32     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r11 = 14
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r9 = f3698b     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.v1$b r10 = com.google.protobuf.v1.b.SFIXED64     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r11 = 15
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r9 = f3698b     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.v1$b r10 = com.google.protobuf.v1.b.SINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r11 = 16
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r9 = f3698b     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.v1$b r10 = com.google.protobuf.v1.b.SINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r11 = 17
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r9 = f3698b     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.protobuf.v1$b r10 = com.google.protobuf.v1.b.ENUM     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r11 = 18
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                com.google.protobuf.v1$c[] r9 = com.google.protobuf.v1.c.values()
                int r9 = r9.length
                int[] r9 = new int[r9]
                f3697a = r9
                com.google.protobuf.v1$c r10 = com.google.protobuf.v1.c.INT     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r9[r10] = r1     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r1 = f3697a     // Catch:{ NoSuchFieldError -> 0x00f3 }
                com.google.protobuf.v1$c r9 = com.google.protobuf.v1.c.LONG     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r1[r9] = r0     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                int[] r0 = f3697a     // Catch:{ NoSuchFieldError -> 0x00fd }
                com.google.protobuf.v1$c r1 = com.google.protobuf.v1.c.FLOAT     // Catch:{ NoSuchFieldError -> 0x00fd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fd }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fd }
            L_0x00fd:
                int[] r0 = f3697a     // Catch:{ NoSuchFieldError -> 0x0107 }
                com.google.protobuf.v1$c r1 = com.google.protobuf.v1.c.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0107 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0107 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0107 }
            L_0x0107:
                int[] r0 = f3697a     // Catch:{ NoSuchFieldError -> 0x0111 }
                com.google.protobuf.v1$c r1 = com.google.protobuf.v1.c.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0111 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0111 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0111 }
            L_0x0111:
                int[] r0 = f3697a     // Catch:{ NoSuchFieldError -> 0x011b }
                com.google.protobuf.v1$c r1 = com.google.protobuf.v1.c.STRING     // Catch:{ NoSuchFieldError -> 0x011b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011b }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x011b }
            L_0x011b:
                int[] r0 = f3697a     // Catch:{ NoSuchFieldError -> 0x0125 }
                com.google.protobuf.v1$c r1 = com.google.protobuf.v1.c.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x0125 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0125 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0125 }
            L_0x0125:
                int[] r0 = f3697a     // Catch:{ NoSuchFieldError -> 0x012f }
                com.google.protobuf.v1$c r1 = com.google.protobuf.v1.c.ENUM     // Catch:{ NoSuchFieldError -> 0x012f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012f }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x012f }
            L_0x012f:
                int[] r0 = f3697a     // Catch:{ NoSuchFieldError -> 0x0139 }
                com.google.protobuf.v1$c r1 = com.google.protobuf.v1.c.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0139 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0139 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x0139 }
            L_0x0139:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v.a.<clinit>():void");
        }
    }

    public interface b<T extends b<T>> extends Comparable<T> {
        int a();

        boolean b();

        v1.b d();

        s0.a g(s0.a aVar, s0 s0Var);

        v1.c j();

        boolean k();
    }

    private v() {
        this.f3694a = l1.q(16);
    }

    private v(l1<T, Object> l1Var) {
        this.f3694a = l1Var;
        s();
    }

    private v(boolean z4) {
        this(l1.q(0));
        s();
    }

    private static Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    static int d(v1.b bVar, int i5, Object obj) {
        int W = l.W(i5);
        if (bVar == v1.b.GROUP) {
            W *= 2;
        }
        return W + e(bVar, obj);
    }

    static int e(v1.b bVar, Object obj) {
        switch (a.f3698b[bVar.ordinal()]) {
            case 1:
                return l.k(((Double) obj).doubleValue());
            case 2:
                return l.s(((Float) obj).floatValue());
            case 3:
                return l.z(((Long) obj).longValue());
            case 4:
                return l.a0(((Long) obj).longValue());
            case 5:
                return l.x(((Integer) obj).intValue());
            case 6:
                return l.q(((Long) obj).longValue());
            case 7:
                return l.o(((Integer) obj).intValue());
            case 8:
                return l.f(((Boolean) obj).booleanValue());
            case 9:
                return l.u((s0) obj);
            case 10:
                return obj instanceof e0 ? l.C((e0) obj) : l.H((s0) obj);
            case 11:
                return obj instanceof i ? l.i((i) obj) : l.V((String) obj);
            case 12:
                return obj instanceof i ? l.i((i) obj) : l.g((byte[]) obj);
            case 13:
                return l.Y(((Integer) obj).intValue());
            case 14:
                return l.N(((Integer) obj).intValue());
            case 15:
                return l.P(((Long) obj).longValue());
            case 16:
                return l.R(((Integer) obj).intValue());
            case 17:
                return l.T(((Long) obj).longValue());
            case 18:
                return obj instanceof b0.c ? l.m(((b0.c) obj).a()) : l.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b<?> bVar, Object obj) {
        v1.b d5 = bVar.d();
        int a5 = bVar.a();
        if (!bVar.b()) {
            return d(d5, a5, obj);
        }
        int i5 = 0;
        List<Object> list = (List) obj;
        if (bVar.k()) {
            for (Object e5 : list) {
                i5 += e(d5, e5);
            }
            return l.W(a5) + i5 + l.L(i5);
        }
        for (Object d6 : list) {
            i5 += d(d5, a5, d6);
        }
        return i5;
    }

    public static <T extends b<T>> v<T> h() {
        return f3693d;
    }

    private int k(Map.Entry<T, Object> entry) {
        b bVar = (b) entry.getKey();
        Object value = entry.getValue();
        if (bVar.j() != v1.c.MESSAGE || bVar.b() || bVar.k()) {
            return f(bVar, value);
        }
        boolean z4 = value instanceof e0;
        int a5 = ((b) entry.getKey()).a();
        return z4 ? l.A(a5, (e0) value) : l.E(a5, (s0) value);
    }

    private static <T extends b<T>> boolean p(Map.Entry<T, Object> entry) {
        b bVar = (b) entry.getKey();
        if (bVar.j() == v1.c.MESSAGE) {
            boolean b5 = bVar.b();
            Object value = entry.getValue();
            if (b5) {
                for (s0 isInitialized : (List) value) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else if (value instanceof s0) {
                if (!((s0) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof e0) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    private static boolean q(v1.b bVar, Object obj) {
        b0.a(obj);
        switch (a.f3697a[bVar.c().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                return (obj instanceof i) || (obj instanceof byte[]);
            case 8:
                return (obj instanceof Integer) || (obj instanceof b0.c);
            case 9:
                return (obj instanceof s0) || (obj instanceof e0);
            default:
                return false;
        }
    }

    private void u(Map.Entry<T, Object> entry) {
        Object obj;
        l1<T, Object> l1Var;
        Object i5;
        b bVar = (b) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof e0) {
            value = ((e0) value).f();
        }
        if (bVar.b()) {
            Object i6 = i(bVar);
            if (i6 == null) {
                i6 = new ArrayList();
            }
            for (Object c5 : (List) value) {
                ((List) i6).add(c(c5));
            }
            this.f3694a.put(bVar, i6);
            return;
        }
        if (bVar.j() != v1.c.MESSAGE || (i5 = i(bVar)) == null) {
            l1Var = this.f3694a;
            obj = c(value);
        } else {
            obj = bVar.g(((s0) i5).toBuilder(), (s0) value).build();
            l1Var = this.f3694a;
        }
        l1Var.put(bVar, obj);
    }

    public static <T extends b<T>> v<T> v() {
        return new v<>();
    }

    private void x(T t5, Object obj) {
        if (!q(t5.d(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t5.a()), t5.d().c(), obj.getClass().getName()}));
        }
    }

    public void a(T t5, Object obj) {
        List list;
        if (t5.b()) {
            x(t5, obj);
            Object i5 = i(t5);
            if (i5 == null) {
                list = new ArrayList();
                this.f3694a.put(t5, list);
            } else {
                list = (List) i5;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* renamed from: b */
    public v<T> clone() {
        v<T> v5 = v();
        for (int i5 = 0; i5 < this.f3694a.k(); i5++) {
            Map.Entry<T, Object> j5 = this.f3694a.j(i5);
            v5.w((b) j5.getKey(), j5.getValue());
        }
        for (Map.Entry next : this.f3694a.m()) {
            v5.w((b) next.getKey(), next.getValue());
        }
        v5.f3696c = this.f3696c;
        return v5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        return this.f3694a.equals(((v) obj).f3694a);
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<T, Object>> g() {
        return this.f3696c ? new e0.c(this.f3694a.h().iterator()) : this.f3694a.h().iterator();
    }

    public int hashCode() {
        return this.f3694a.hashCode();
    }

    public Object i(T t5) {
        Object obj = this.f3694a.get(t5);
        return obj instanceof e0 ? ((e0) obj).f() : obj;
    }

    public int j() {
        int i5 = 0;
        for (int i6 = 0; i6 < this.f3694a.k(); i6++) {
            i5 += k(this.f3694a.j(i6));
        }
        for (Map.Entry<T, Object> k5 : this.f3694a.m()) {
            i5 += k(k5);
        }
        return i5;
    }

    public int l() {
        int i5 = 0;
        for (int i6 = 0; i6 < this.f3694a.k(); i6++) {
            Map.Entry<T, Object> j5 = this.f3694a.j(i6);
            i5 += f((b) j5.getKey(), j5.getValue());
        }
        for (Map.Entry next : this.f3694a.m()) {
            i5 += f((b) next.getKey(), next.getValue());
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f3694a.isEmpty();
    }

    public boolean n() {
        return this.f3695b;
    }

    public boolean o() {
        for (int i5 = 0; i5 < this.f3694a.k(); i5++) {
            if (!p(this.f3694a.j(i5))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> p5 : this.f3694a.m()) {
            if (!p(p5)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> r() {
        return this.f3696c ? new e0.c(this.f3694a.entrySet().iterator()) : this.f3694a.entrySet().iterator();
    }

    public void s() {
        if (!this.f3695b) {
            this.f3694a.p();
            this.f3695b = true;
        }
    }

    public void t(v<T> vVar) {
        for (int i5 = 0; i5 < vVar.f3694a.k(); i5++) {
            u(vVar.f3694a.j(i5));
        }
        for (Map.Entry<T, Object> u5 : vVar.f3694a.m()) {
            u(u5);
        }
    }

    public void w(T t5, Object obj) {
        if (!t5.b()) {
            x(t5, obj);
        } else if (obj instanceof List) {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.addAll((List) obj);
            for (Object x4 : arrayList) {
                x(t5, x4);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof e0) {
            this.f3696c = true;
        }
        this.f3694a.put(t5, obj);
    }
}
