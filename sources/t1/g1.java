package t1;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.DeadObjectException;
import java.util.concurrent.TimeUnit;
import m2.l;
import m2.q;
import m2.r;
import p1.b0;
import p1.d0;
import p1.n0;
import p1.o0;
import p1.q0;
import q1.e;
import q1.f;
import r1.i;
import r1.j;
import v1.k;
import x1.d;
import y1.e0;

public class g1 implements n0 {

    /* renamed from: a  reason: collision with root package name */
    private final d f6879a;

    /* renamed from: b  reason: collision with root package name */
    final i1 f6880b;

    /* renamed from: c  reason: collision with root package name */
    final BluetoothGatt f6881c;

    /* renamed from: d  reason: collision with root package name */
    private final k f6882d;

    /* renamed from: e  reason: collision with root package name */
    private final h0.a<Object> f6883e;

    /* renamed from: f  reason: collision with root package name */
    final q f6884f;

    /* renamed from: g  reason: collision with root package name */
    private final k1 f6885g;

    /* renamed from: h  reason: collision with root package name */
    private final d1 f6886h;

    /* renamed from: i  reason: collision with root package name */
    private final n0 f6887i;

    /* renamed from: j  reason: collision with root package name */
    private final u f6888j;

    /* renamed from: k  reason: collision with root package name */
    private final b0 f6889k;

    class a extends j<T> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ o0 f6890e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ i f6891f;

        /* renamed from: t1.g1$a$a  reason: collision with other inner class name */
        class C0111a implements r2.a {
            C0111a() {
            }

            public void run() {
                g1.this.f6880b.r((BluetoothGattCallback) null);
                g1.this.f6880b.q((b0) null);
            }
        }

        a(o0 o0Var, i iVar) {
            this.f6890e = o0Var;
            this.f6891f = iVar;
        }

        private r2.a l() {
            return new C0111a();
        }

        public i e() {
            return this.f6891f;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        public void f(l<T> lVar, x1.i iVar) {
            try {
                o0 o0Var = this.f6890e;
                g1 g1Var = g1.this;
                m2.k a5 = o0Var.a(g1Var.f6881c, g1Var.f6880b, g1Var.f6884f);
                if (a5 != null) {
                    a5.B(l()).g(new e0(lVar, iVar));
                    return;
                }
                iVar.release();
                throw new IllegalArgumentException("The custom operation asObservable method must return a non-null observable");
            } catch (Throwable th) {
                iVar.release();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public f i(DeadObjectException deadObjectException) {
            return new e(deadObjectException, g1.this.f6881c.getDevice().getAddress(), -1);
        }
    }

    public g1(d dVar, i1 i1Var, BluetoothGatt bluetoothGatt, k1 k1Var, d1 d1Var, n0 n0Var, u uVar, k kVar, h0.a<Object> aVar, q qVar, b0 b0Var) {
        this.f6879a = dVar;
        this.f6880b = i1Var;
        this.f6881c = bluetoothGatt;
        this.f6885g = k1Var;
        this.f6886h = d1Var;
        this.f6887i = n0Var;
        this.f6888j = uVar;
        this.f6882d = kVar;
        this.f6883e = aVar;
        this.f6884f = qVar;
        this.f6889k = b0Var;
    }

    public <T> m2.k<T> a(o0<T> o0Var) {
        return i(o0Var, i.f6683c);
    }

    public m2.k<m2.k<byte[]>> b(BluetoothGattCharacteristic bluetoothGattCharacteristic, d0 d0Var) {
        return this.f6889k.a(bluetoothGattCharacteristic, 16).d(this.f6886h.x(bluetoothGattCharacteristic, d0Var, false));
    }

    public m2.a c(int i5, long j5, TimeUnit timeUnit) {
        if (i5 == 2 || i5 == 0 || i5 == 1) {
            return j5 <= 0 ? m2.a.f(new IllegalArgumentException("Delay must be bigger than 0")) : this.f6879a.a(this.f6882d.d(i5, j5, timeUnit)).W();
        }
        return m2.a.f(new IllegalArgumentException("Connection priority must have valid value from BluetoothGatt (received " + i5 + ")"));
    }

    public r<q0> d() {
        return this.f6885g.a(20, TimeUnit.SECONDS);
    }

    public r<Integer> e(int i5) {
        return this.f6879a.a(this.f6882d.a(i5)).L();
    }

    public r<byte[]> f(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return this.f6889k.a(bluetoothGattCharacteristic, 76).d(this.f6879a.a(this.f6882d.c(bluetoothGattCharacteristic, bArr))).L();
    }

    public r<byte[]> g(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return this.f6889k.a(bluetoothGattCharacteristic, 2).d(this.f6879a.a(this.f6882d.f(bluetoothGattCharacteristic))).L();
    }

    public m2.k<m2.k<byte[]>> h(BluetoothGattCharacteristic bluetoothGattCharacteristic, d0 d0Var) {
        return this.f6889k.a(bluetoothGattCharacteristic, 32).d(this.f6886h.x(bluetoothGattCharacteristic, d0Var, true));
    }

    public <T> m2.k<T> i(o0<T> o0Var, i iVar) {
        return this.f6879a.a(new a(o0Var, iVar));
    }
}
