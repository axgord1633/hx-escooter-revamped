package com.signify.hue.flutterreactiveble.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.os.Build;
import android.os.ParcelUuid;
import com.signify.hue.flutterreactiveble.ble.extensions.RxBleConnectionExtensionKt;
import com.signify.hue.flutterreactiveble.converters.ManufacturerDataConverterKt;
import com.signify.hue.flutterreactiveble.model.ScanMode;
import com.signify.hue.flutterreactiveble.model.ScanModeKt;
import com.signify.hue.flutterreactiveble.utils.BleWrapperExtensionsKt;
import com.signify.hue.flutterreactiveble.utils.Duration;
import com.yalantis.ucrop.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import l3.a;
import m2.n;
import m2.r;
import m2.v;
import m3.i;
import p1.c0;
import p1.d0;
import p1.g0;
import p1.n0;
import p1.p0;
import p1.q0;
import p2.b;
import v3.q;
import z1.d;
import z1.f;
import z1.g;

public class ReactiveBleClient implements BleClient {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static Map<String, DeviceConnector> activeConnections = new LinkedHashMap();
    private static final a<ConnectionUpdate> connectionUpdateBehaviorSubject;
    public static g0 rxBleClient;
    private final b allConnections = new b();
    private final ConnectionQueue connectionQueue = new ConnectionQueue();
    private final Context context;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Map<String, DeviceConnector> getActiveConnections$reactive_ble_mobile_release() {
            return ReactiveBleClient.activeConnections;
        }

        public final g0 getRxBleClient() {
            g0 g0Var = ReactiveBleClient.rxBleClient;
            if (g0Var != null) {
                return g0Var;
            }
            k.o("rxBleClient");
            return null;
        }

        public final void setActiveConnections$reactive_ble_mobile_release(Map<String, DeviceConnector> map) {
            k.e(map, "<set-?>");
            ReactiveBleClient.activeConnections = map;
        }

        public final void setRxBleClient$reactive_ble_mobile_release(g0 g0Var) {
            k.e(g0Var, "<set-?>");
            ReactiveBleClient.rxBleClient = g0Var;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[z1.b.values().length];
            iArr[z1.b.LEGACY_UNKNOWN.ordinal()] = 1;
            iArr[z1.b.NOT_CONNECTABLE.ordinal()] = 2;
            iArr[z1.b.CONNECTABLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        a<ConnectionUpdate> Q0 = a.Q0();
        k.d(Q0, "create()");
        connectionUpdateBehaviorSubject = Q0;
    }

    public ReactiveBleClient(Context context2) {
        k.e(context2, "context");
        this.context = context2;
    }

    /* access modifiers changed from: private */
    /* renamed from: connectToDevice$lambda-4  reason: not valid java name */
    public static final void m36connectToDevice$lambda4(String str, EstablishConnectionResult establishConnectionResult) {
        k.e(str, "$deviceId");
        if (!(establishConnectionResult instanceof EstablishedConnection) && (establishConnectionResult instanceof EstablishConnectionFailure)) {
            connectionUpdateBehaviorSubject.d(new ConnectionUpdateError(str, ((EstablishConnectionFailure) establishConnectionResult).getErrorMessage()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: connectToDevice$lambda-5  reason: not valid java name */
    public static final void m37connectToDevice$lambda5(String str, Throwable th) {
        String str2;
        k.e(str, "$deviceId");
        a<ConnectionUpdate> aVar = connectionUpdateBehaviorSubject;
        if (th == null || (str2 = th.getMessage()) == null) {
            str2 = "unknown error";
        }
        aVar.d(new ConnectionUpdateError(str, str2));
    }

    /* access modifiers changed from: private */
    /* renamed from: discoverServices$lambda-7  reason: not valid java name */
    public static final v m38discoverServices$lambda7(EstablishConnectionResult establishConnectionResult) {
        k.e(establishConnectionResult, "connectionResult");
        if (establishConnectionResult instanceof EstablishedConnection) {
            EstablishedConnection establishedConnection = (EstablishedConnection) establishConnectionResult;
            return Companion.getRxBleClient().b(establishedConnection.getDeviceId()).b().getBondState() == 11 ? r.o(new Exception("Bonding is in progress wait for bonding to be finished before executing more operations on the device")) : establishedConnection.getRxConnection().d();
        } else if (establishConnectionResult instanceof EstablishConnectionFailure) {
            return r.o(new Exception(((EstablishConnectionFailure) establishConnectionResult).getErrorMessage()));
        } else {
            throw new i();
        }
    }

    private final void enableDebugLogging() {
        g0.f(new c0.a().b(2).c(2).e(2).d(Boolean.TRUE).a());
    }

    private final r<CharOperationResult> executeWriteOperation(String str, UUID uuid, int i5, byte[] bArr, q<? super n0, ? super BluetoothGattCharacteristic, ? super byte[], ? extends r<byte[]>> qVar) {
        r<CharOperationResult> J = getConnection$default(this, str, (Duration) null, 2, (Object) null).Q(new i0(uuid, i5, str, qVar, bArr)).J(new CharOperationFailed(str, "Writechar timed-out"));
        k.d(J, "getConnection(deviceId)\n…, \"Writechar timed-out\"))");
        return J;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeWriteOperation$lambda-20  reason: not valid java name */
    public static final v m39executeWriteOperation$lambda20(UUID uuid, int i5, String str, q qVar, byte[] bArr, EstablishConnectionResult establishConnectionResult) {
        r<R> u5;
        String str2;
        k.e(uuid, "$characteristicId");
        k.e(str, "$deviceId");
        k.e(qVar, "$bleOperation");
        k.e(bArr, "$value");
        k.e(establishConnectionResult, "connectionResult");
        if (establishConnectionResult instanceof EstablishedConnection) {
            u5 = RxBleConnectionExtensionKt.resolveCharacteristic(((EstablishedConnection) establishConnectionResult).getRxConnection(), uuid, i5).r(new j0(qVar, establishConnectionResult, bArr, str));
            str2 = "{\n                      …  }\n                    }";
        } else if (establishConnectionResult instanceof EstablishConnectionFailure) {
            u5 = r.u(new CharOperationFailed(str, "failed to connect " + ((EstablishConnectionFailure) establishConnectionResult).getErrorMessage()));
            str2 = "{\n                      …  )\n                    }";
        } else {
            throw new i();
        }
        k.d(u5, str2);
        return u5;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeWriteOperation$lambda-20$lambda-19  reason: not valid java name */
    public static final v m40executeWriteOperation$lambda20$lambda19(q qVar, EstablishConnectionResult establishConnectionResult, byte[] bArr, String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        k.e(qVar, "$bleOperation");
        k.e(establishConnectionResult, "$connectionResult");
        k.e(bArr, "$value");
        k.e(str, "$deviceId");
        k.e(bluetoothGattCharacteristic, "characteristic");
        return ((r) qVar.invoke(((EstablishedConnection) establishConnectionResult).getRxConnection(), bluetoothGattCharacteristic, bArr)).v(new x(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: executeWriteOperation$lambda-20$lambda-19$lambda-18  reason: not valid java name */
    public static final CharOperationSuccessful m41executeWriteOperation$lambda20$lambda19$lambda18(String str, byte[] bArr) {
        k.e(str, "$deviceId");
        k.e(bArr, "value");
        return new CharOperationSuccessful(str, i.b(bArr));
    }

    private final m2.k<EstablishConnectionResult> getConnection(String str, Duration duration) {
        p0 b5 = Companion.getRxBleClient().b(str);
        Map<String, DeviceConnector> map = activeConnections;
        DeviceConnector deviceConnector = map.get(str);
        if (deviceConnector == null) {
            k.d(b5, "device");
            deviceConnector = createDeviceConnector$reactive_ble_mobile_release(b5, duration);
            map.put(str, deviceConnector);
        }
        return deviceConnector.getConnection$reactive_ble_mobile_release();
    }

    static /* synthetic */ m2.k getConnection$default(ReactiveBleClient reactiveBleClient, String str, Duration duration, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                duration = new Duration(0, TimeUnit.MILLISECONDS);
            }
            return reactiveBleClient.getConnection(str, duration);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConnection");
    }

    /* access modifiers changed from: private */
    /* renamed from: negotiateMtuSize$lambda-15  reason: not valid java name */
    public static final v m42negotiateMtuSize$lambda15(int i5, String str, EstablishConnectionResult establishConnectionResult) {
        r<R> u5;
        String str2;
        k.e(str, "$deviceId");
        k.e(establishConnectionResult, "connectionResult");
        if (establishConnectionResult instanceof EstablishedConnection) {
            u5 = ((EstablishedConnection) establishConnectionResult).getRxConnection().e(i5).v(new w(str));
            str2 = "connectionResult.rxConne…cesful(deviceId, value) }";
        } else if (establishConnectionResult instanceof EstablishConnectionFailure) {
            u5 = r.u(new MtuNegotiateFailed(str, "failed to connect " + ((EstablishConnectionFailure) establishConnectionResult).getErrorMessage()));
            str2 = "just(\n                  …  )\n                    )";
        } else {
            throw new i();
        }
        k.d(u5, str2);
        return u5;
    }

    /* access modifiers changed from: private */
    /* renamed from: negotiateMtuSize$lambda-15$lambda-14  reason: not valid java name */
    public static final MtuNegotiateSuccesful m43negotiateMtuSize$lambda15$lambda14(String str, Integer num) {
        k.e(str, "$deviceId");
        k.e(num, "value");
        return new MtuNegotiateSuccesful(str, num.intValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: observeBleStatus$lambda-16  reason: not valid java name */
    public static final BleStatus m44observeBleStatus$lambda16(g0.a aVar) {
        k.e(aVar, "it");
        return BleWrapperExtensionsKt.toBleState(aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: readCharacteristic$lambda-11  reason: not valid java name */
    public static final v m45readCharacteristic$lambda11(UUID uuid, int i5, String str, EstablishConnectionResult establishConnectionResult) {
        r<R> u5;
        String str2;
        k.e(uuid, "$characteristicId");
        k.e(str, "$deviceId");
        k.e(establishConnectionResult, "connectionResult");
        if (establishConnectionResult instanceof EstablishedConnection) {
            u5 = RxBleConnectionExtensionKt.resolveCharacteristic(((EstablishedConnection) establishConnectionResult).getRxConnection(), uuid, i5).r(new q(establishConnectionResult, str));
            str2 = "{\n                    co…      }\n                }";
        } else if (establishConnectionResult instanceof EstablishConnectionFailure) {
            u5 = r.u(new CharOperationFailed(str, "failed to connect " + ((EstablishConnectionFailure) establishConnectionResult).getErrorMessage()));
            str2 = "just(\n                  …  )\n                    )";
        } else {
            throw new i();
        }
        k.d(u5, str2);
        return u5;
    }

    /* access modifiers changed from: private */
    /* renamed from: readCharacteristic$lambda-11$lambda-10  reason: not valid java name */
    public static final v m46readCharacteristic$lambda11$lambda10(EstablishConnectionResult establishConnectionResult, String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        k.e(establishConnectionResult, "$connectionResult");
        k.e(str, "$deviceId");
        k.e(bluetoothGattCharacteristic, "c");
        return ((EstablishedConnection) establishConnectionResult).getRxConnection().g(bluetoothGattCharacteristic).A(1, new u()).v(new v(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: readCharacteristic$lambda-11$lambda-10$lambda-8  reason: not valid java name */
    public static final boolean m47readCharacteristic$lambda11$lambda10$lambda8(Throwable th) {
        k.e(th, "it");
        return Build.VERSION.SDK_INT < 26;
    }

    /* access modifiers changed from: private */
    /* renamed from: readCharacteristic$lambda-11$lambda-10$lambda-9  reason: not valid java name */
    public static final CharOperationSuccessful m48readCharacteristic$lambda11$lambda10$lambda9(String str, byte[] bArr) {
        k.e(str, "$deviceId");
        k.e(bArr, "value");
        return new CharOperationSuccessful(str, i.b(bArr));
    }

    /* access modifiers changed from: private */
    /* renamed from: requestConnectionPriority$lambda-24  reason: not valid java name */
    public static final v m49requestConnectionPriority$lambda24(ConnectionPriority connectionPriority, String str, EstablishConnectionResult establishConnectionResult) {
        r t5;
        String str2;
        k.e(connectionPriority, "$priority");
        k.e(str, "$deviceId");
        k.e(establishConnectionResult, "connectionResult");
        if (establishConnectionResult instanceof EstablishedConnection) {
            t5 = ((EstablishedConnection) establishConnectionResult).getRxConnection().c(connectionPriority.getCode(), 2, TimeUnit.SECONDS).p(new c0(str));
            str2 = "connectionResult.rxConne…                        }";
        } else if (establishConnectionResult instanceof EstablishConnectionFailure) {
            t5 = r.t(new d0(str, establishConnectionResult));
            str2 = "fromCallable {\n         …essage)\n                }";
        } else {
            throw new i();
        }
        k.d(t5, str2);
        return t5;
    }

    /* access modifiers changed from: private */
    /* renamed from: requestConnectionPriority$lambda-24$lambda-22  reason: not valid java name */
    public static final RequestConnectionPrioritySuccess m50requestConnectionPriority$lambda24$lambda22(String str) {
        k.e(str, "$deviceId");
        return new RequestConnectionPrioritySuccess(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: requestConnectionPriority$lambda-24$lambda-23  reason: not valid java name */
    public static final RequestConnectionPriorityFailed m51requestConnectionPriority$lambda24$lambda23(String str, EstablishConnectionResult establishConnectionResult) {
        k.e(str, "$deviceId");
        k.e(establishConnectionResult, "$connectionResult");
        return new RequestConnectionPriorityFailed(str, ((EstablishConnectionFailure) establishConnectionResult).getErrorMessage());
    }

    /* access modifiers changed from: private */
    /* renamed from: scanForDevices$lambda-3  reason: not valid java name */
    public static final ScanInfo m52scanForDevices$lambda3(f fVar) {
        Connectable connectable;
        LinkedHashMap linkedHashMap;
        ArrayList arrayList;
        k.e(fVar, "result");
        String c5 = fVar.a().c();
        k.d(c5, "result.bleDevice.macAddress");
        String a5 = fVar.c().a();
        if (a5 == null && (a5 = fVar.a().getName()) == null) {
            a5 = BuildConfig.FLAVOR;
        }
        String str = a5;
        int b5 = fVar.b();
        z1.b d5 = fVar.d();
        int i5 = d5 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[d5.ordinal()];
        if (i5 == -1 || i5 == 1) {
            connectable = Connectable.UNKNOWN;
        } else if (i5 == 2) {
            connectable = Connectable.NOT_CONNECTABLE;
        } else if (i5 == 3) {
            connectable = Connectable.CONNECTABLE;
        } else {
            throw new i();
        }
        Connectable connectable2 = connectable;
        Map<ParcelUuid, byte[]> d6 = fVar.c().d();
        if (d6 != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(d0.a(d6.size()));
            for (Map.Entry entry : d6.entrySet()) {
                UUID uuid = ((ParcelUuid) entry.getKey()).getUuid();
                k.d(uuid, "it.key.uuid");
                linkedHashMap2.put(uuid, entry.getValue());
            }
            linkedHashMap = linkedHashMap2;
        } else {
            linkedHashMap = e0.d();
        }
        List<ParcelUuid> b6 = fVar.c().b();
        if (b6 != null) {
            ArrayList arrayList2 = new ArrayList(o.i(b6, 10));
            for (ParcelUuid uuid2 : b6) {
                arrayList2.add(uuid2.getUuid());
            }
            arrayList = arrayList2;
        } else {
            arrayList = n.d();
        }
        return new ScanInfo(c5, str, b5, connectable2, linkedHashMap, arrayList, ManufacturerDataConverterKt.extractManufacturerData(fVar.c().h()));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupNotification$lambda-12  reason: not valid java name */
    public static final n m53setupNotification$lambda12(ReactiveBleClient reactiveBleClient, UUID uuid, int i5, EstablishConnectionResult establishConnectionResult) {
        k.e(reactiveBleClient, "this$0");
        k.e(uuid, "$characteristicId");
        k.e(establishConnectionResult, "deviceConnection");
        return reactiveBleClient.setupNotificationOrIndication(establishConnectionResult, uuid, i5);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupNotification$lambda-13  reason: not valid java name */
    public static final n m54setupNotification$lambda13(m2.k kVar) {
        k.e(kVar, "notificationObservable");
        return kVar;
    }

    private final m2.k<m2.k<byte[]>> setupNotificationOrIndication(EstablishConnectionResult establishConnectionResult, UUID uuid, int i5) {
        String str;
        m2.k<R> kVar;
        if (establishConnectionResult instanceof EstablishedConnection) {
            EstablishedConnection establishedConnection = (EstablishedConnection) establishConnectionResult;
            kVar = Companion.getRxBleClient().b(establishedConnection.getDeviceId()).b().getBondState() == 11 ? m2.k.G(new Exception("Bonding is in progress wait for bonding to be finished before executing more operations on the device")) : RxBleConnectionExtensionKt.resolveCharacteristic(establishedConnection.getRxConnection(), uuid, i5).s(new b0(establishConnectionResult));
            str = "{\n                if (rx…          }\n            }";
        } else if (establishConnectionResult instanceof EstablishConnectionFailure) {
            kVar = m2.k.Y(m2.k.F());
            str = "{\n                Observ…le.empty())\n            }";
        } else {
            throw new i();
        }
        k.d(kVar, str);
        return kVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: setupNotificationOrIndication$lambda-21  reason: not valid java name */
    public static final n m55setupNotificationOrIndication$lambda21(EstablishConnectionResult establishConnectionResult, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        k.e(establishConnectionResult, "$deviceConnection");
        k.e(bluetoothGattCharacteristic, "characteristic");
        d0 d0Var = bluetoothGattCharacteristic.getDescriptors().isEmpty() ? d0.COMPAT : d0.DEFAULT;
        int properties = bluetoothGattCharacteristic.getProperties() & 16;
        n0 rxConnection = ((EstablishedConnection) establishConnectionResult).getRxConnection();
        return properties > 0 ? rxConnection.b(bluetoothGattCharacteristic, d0Var) : rxConnection.h(bluetoothGattCharacteristic, d0Var);
    }

    public m2.a clearGattCache(String str) {
        m2.a clearGattCache$reactive_ble_mobile_release;
        k.e(str, "deviceId");
        DeviceConnector deviceConnector = activeConnections.get(str);
        if (deviceConnector != null && (clearGattCache$reactive_ble_mobile_release = deviceConnector.clearGattCache$reactive_ble_mobile_release()) != null) {
            return clearGattCache$reactive_ble_mobile_release;
        }
        m2.a f5 = m2.a.f(new IllegalStateException("Device is not connected"));
        k.d(f5, "error(IllegalStateExcept…evice is not connected\"))");
        return f5;
    }

    public void connectToDevice(String str, Duration duration) {
        k.e(str, "deviceId");
        k.e(duration, "timeout");
        this.allConnections.b(getConnection(str, duration).t0(new g0(str), new h0(str)));
    }

    public DeviceConnector createDeviceConnector$reactive_ble_mobile_release(p0 p0Var, Duration duration) {
        k.e(p0Var, "device");
        k.e(duration, "timeout");
        return new DeviceConnector(p0Var, duration, new ReactiveBleClient$createDeviceConnector$1(connectionUpdateBehaviorSubject), this.connectionQueue);
    }

    public void disconnectAllDevices() {
        for (Map.Entry next : activeConnections.entrySet()) {
            ((DeviceConnector) next.getValue()).disconnectDevice$reactive_ble_mobile_release((String) next.getKey());
        }
        this.allConnections.dispose();
    }

    public void disconnectDevice(String str) {
        k.e(str, "deviceId");
        DeviceConnector deviceConnector = activeConnections.get(str);
        if (deviceConnector != null) {
            deviceConnector.disconnectDevice$reactive_ble_mobile_release(str);
        }
        activeConnections.remove(str);
    }

    public r<q0> discoverServices(String str) {
        k.e(str, "deviceId");
        r<q0> L = getConnection$default(this, str, (Duration) null, 2, (Object) null).Q(new t()).L();
        k.d(L, "getConnection(deviceId).…\n        }.firstOrError()");
        return L;
    }

    public a<ConnectionUpdate> getConnectionUpdateSubject() {
        return connectionUpdateBehaviorSubject;
    }

    public void initializeClient() {
        activeConnections = new LinkedHashMap();
        Companion companion = Companion;
        g0 a5 = g0.a(this.context);
        k.d(a5, "create(context)");
        companion.setRxBleClient$reactive_ble_mobile_release(a5);
    }

    public r<MtuNegotiateResult> negotiateMtuSize(String str, int i5) {
        k.e(str, "deviceId");
        r<MtuNegotiateResult> J = getConnection$default(this, str, (Duration) null, 2, (Object) null).Q(new y(i5, str)).J(new MtuNegotiateFailed(str, "negotiate mtu timed out"));
        k.d(J, "getConnection(deviceId).…egotiate mtu timed out\"))");
        return J;
    }

    public m2.k<BleStatus> observeBleStatus() {
        Companion companion = Companion;
        m2.k<R> Z = companion.getRxBleClient().d().r0(companion.getRxBleClient().c()).Z(new r());
        k.d(Z, "rxBleClient.observeState… .map { it.toBleState() }");
        return Z;
    }

    public r<CharOperationResult> readCharacteristic(String str, UUID uuid, int i5) {
        k.e(str, "deviceId");
        k.e(uuid, "characteristicId");
        r<CharOperationResult> J = getConnection$default(this, str, (Duration) null, 2, (Object) null).Q(new z(uuid, i5, str)).J(new CharOperationFailed(str, "read char failed"));
        k.d(J, "getConnection(deviceId).…eId, \"read char failed\"))");
        return J;
    }

    public r<RequestConnectionPriorityResult> requestConnectionPriority(String str, ConnectionPriority connectionPriority) {
        k.e(str, "deviceId");
        k.e(connectionPriority, "priority");
        r<RequestConnectionPriorityResult> J = getConnection$default(this, str, (Duration) null, 2, (Object) null).A0(new a0(connectionPriority, str)).J(new RequestConnectionPriorityFailed(str, "Unknown failure"));
        k.d(J, "getConnection(deviceId).…ceId, \"Unknown failure\"))");
        return J;
    }

    public m2.k<ScanInfo> scanForDevices(List<ParcelUuid> list, ScanMode scanMode, boolean z4) {
        k.e(list, "services");
        k.e(scanMode, "scanMode");
        ArrayList arrayList = new ArrayList(o.i(list, 10));
        for (ParcelUuid j5 : list) {
            arrayList.add(new d.b().j(j5).a());
        }
        Object[] array = arrayList.toArray(new d[0]);
        if (array != null) {
            d[] dVarArr = (d[]) array;
            m2.k<R> Z = Companion.getRxBleClient().e(new g.b().e(ScanModeKt.toScanSettings(scanMode)).d(false).c(1).f(z4).a(), (d[]) Arrays.copyOf(dVarArr, dVarArr.length)).Z(new s());
            k.d(Z, "rxBleClient.scanBleDevic…cificData))\n            }");
            return Z;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public m2.k<byte[]> setupNotification(String str, UUID uuid, int i5) {
        k.e(str, "deviceId");
        k.e(uuid, "characteristicId");
        m2.k<byte[]> M = getConnection$default(this, str, (Duration) null, 2, (Object) null).M(new e0(this, uuid, i5)).M(new f0());
        k.d(M, "getConnection(deviceId)\n…nObservable\n            }");
        return M;
    }

    public r<CharOperationResult> writeCharacteristicWithResponse(String str, UUID uuid, int i5, byte[] bArr) {
        k.e(str, "deviceId");
        k.e(uuid, "characteristicId");
        k.e(bArr, "value");
        return executeWriteOperation(str, uuid, i5, bArr, ReactiveBleClient$writeCharacteristicWithResponse$1.INSTANCE);
    }

    public r<CharOperationResult> writeCharacteristicWithoutResponse(String str, UUID uuid, int i5, byte[] bArr) {
        k.e(str, "deviceId");
        k.e(uuid, "characteristicId");
        k.e(bArr, "value");
        return executeWriteOperation(str, uuid, i5, bArr, ReactiveBleClient$writeCharacteristicWithoutResponse$1.INSTANCE);
    }
}
