package kotlinx.coroutines.internal;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f5575a = new Object[16];

    /* renamed from: b  reason: collision with root package name */
    private int f5576b;

    /* renamed from: c  reason: collision with root package name */
    private int f5577c;

    private final void b() {
        Object[] objArr = this.f5575a;
        int length = objArr.length;
        Object[] objArr2 = new Object[(length << 1)];
        Object[] objArr3 = objArr2;
        Object[] unused = i.e(objArr, objArr3, 0, this.f5576b, 0, 10, (Object) null);
        Object[] objArr4 = this.f5575a;
        int length2 = objArr4.length;
        int i5 = this.f5576b;
        Object[] unused2 = i.e(objArr4, objArr2, length2 - i5, 0, i5, 4, (Object) null);
        this.f5575a = objArr3;
        this.f5576b = 0;
        this.f5577c = length;
    }

    public final void a(T t5) {
        Object[] objArr = this.f5575a;
        int i5 = this.f5577c;
        objArr[i5] = t5;
        int length = (objArr.length - 1) & (i5 + 1);
        this.f5577c = length;
        if (length == this.f5576b) {
            b();
        }
    }

    public final boolean c() {
        return this.f5576b == this.f5577c;
    }

    public final T d() {
        int i5 = this.f5576b;
        if (i5 == this.f5577c) {
            return null;
        }
        T[] tArr = this.f5575a;
        T t5 = tArr[i5];
        tArr[i5] = null;
        this.f5576b = (i5 + 1) & (tArr.length - 1);
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
