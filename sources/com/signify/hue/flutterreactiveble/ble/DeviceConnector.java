package com.signify.hue.flutterreactiveble.ble;

import android.bluetooth.BluetoothGatt;
import com.signify.hue.flutterreactiveble.model.ConnectionState;
import com.signify.hue.flutterreactiveble.utils.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import l3.a;
import m2.n;
import m2.r;
import m3.e;
import m3.i;
import m3.q;
import p1.n0;
import p1.p0;
import p2.c;
import t1.i1;
import v3.l;

public final class DeviceConnector {
    public static final Companion Companion = new Companion((g) null);
    private static final long delayMsAfterClearingCache = 300;
    private static final long minTimeMsBeforeDisconnectingIsAllowed = 200;
    /* access modifiers changed from: private */
    public final a<EstablishConnectionResult> connectDeviceSubject;
    private final e connection$delegate;
    private c connectionDisposable;
    private final ConnectionQueue connectionQueue;
    private final e connectionStatusUpdates$delegate = g.a(new DeviceConnector$connectionStatusUpdates$2(this));
    private final Duration connectionTimeout;
    /* access modifiers changed from: private */
    public final p0 device;
    private final e<a<EstablishConnectionResult>> lazyConnection;
    private long timestampEstablishConnection;
    /* access modifiers changed from: private */
    public final l<ConnectionUpdate, q> updateListeners;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public DeviceConnector(p0 p0Var, Duration duration, l<? super ConnectionUpdate, q> lVar, ConnectionQueue connectionQueue2) {
        k.e(p0Var, "device");
        k.e(duration, "connectionTimeout");
        k.e(lVar, "updateListeners");
        k.e(connectionQueue2, "connectionQueue");
        this.device = p0Var;
        this.connectionTimeout = duration;
        this.updateListeners = lVar;
        this.connectionQueue = connectionQueue2;
        a<EstablishConnectionResult> Q0 = a.Q0();
        k.d(Q0, "create<EstablishConnectionResult>()");
        this.connectDeviceSubject = Q0;
        e<a<EstablishConnectionResult>> a5 = g.a(new DeviceConnector$lazyConnection$1(this));
        this.lazyConnection = a5;
        this.connection$delegate = a5;
    }

    private final m2.a clearGattCache(n0 n0Var) {
        m2.a W = n0Var.a(new d()).W();
        k.d(W, "connection.queue(operation).ignoreElements()");
        return W;
    }

    /* access modifiers changed from: private */
    /* renamed from: clearGattCache$lambda-11  reason: not valid java name */
    public static final m2.k m20clearGattCache$lambda11(BluetoothGatt bluetoothGatt, i1 i1Var, m2.q qVar) {
        try {
            Object invoke = bluetoothGatt.getClass().getMethod("refresh", new Class[0]).invoke(bluetoothGatt, new Object[0]);
            k.c(invoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) invoke).booleanValue() ? m2.k.F().p(delayMsAfterClearingCache, TimeUnit.MILLISECONDS) : m2.k.G(new RuntimeException("BluetoothGatt.refresh() returned false"));
        } catch (ReflectiveOperationException e5) {
            return m2.k.G(e5);
        }
    }

    private final m2.k<n0> connectDevice(p0 p0Var, boolean z4) {
        m2.k<R> j5 = p0Var.a(z4).j(new a(z4, this));
        k.d(j5, "rxBleDevice.establishCon…  }\n                    }");
        return j5;
    }

    /* access modifiers changed from: private */
    /* renamed from: connectDevice$lambda-9  reason: not valid java name */
    public static final n m21connectDevice$lambda9(boolean z4, DeviceConnector deviceConnector, m2.k kVar) {
        k.e(deviceConnector, "this$0");
        k.e(kVar, "it");
        return z4 ? kVar : kVar.G0(m2.k.I0(deviceConnector.connectionTimeout.getValue(), deviceConnector.connectionTimeout.getUnit()), new c());
    }

    /* access modifiers changed from: private */
    /* renamed from: connectDevice$lambda-9$lambda-8  reason: not valid java name */
    public static final m2.k m22connectDevice$lambda9$lambda8(n0 n0Var) {
        k.e(n0Var, "it");
        return m2.k.e0();
    }

    /* access modifiers changed from: private */
    /* renamed from: disconnectDevice$lambda-0  reason: not valid java name */
    public static final void m23disconnectDevice$lambda0(DeviceConnector deviceConnector, String str) {
        k.e(deviceConnector, "this$0");
        k.e(str, "$deviceId");
        deviceConnector.sendDisconnectedUpdate(str);
        deviceConnector.disposeSubscriptions();
    }

    private final void disposeSubscriptions() {
        c cVar = this.connectionDisposable;
        if (cVar != null) {
            cVar.dispose();
        }
        this.connectDeviceSubject.a();
        getConnectionStatusUpdates().dispose();
    }

    /* access modifiers changed from: private */
    public final c establishConnection(p0 p0Var) {
        String c5 = p0Var.c();
        boolean z4 = this.connectionTimeout.getValue() <= 0;
        ConnectionQueue connectionQueue2 = this.connectionQueue;
        k.d(c5, "deviceId");
        connectionQueue2.addToQueue(c5);
        this.updateListeners.invoke(new ConnectionUpdateSuccess(c5, ConnectionState.CONNECTING.getCode()));
        c t02 = waitUntilFirstOfQueue(c5).y0(new f(c5, this, p0Var, z4)).h0(new g(p0Var)).z(new h(this, c5)).x(new i(this, c5)).t0(new j(this), new k(this));
        k.d(t02, "waitUntilFirstOfQueue(de…ect.onError(throwable) })");
        return t02;
    }

    /* access modifiers changed from: private */
    /* renamed from: establishConnection$lambda-2  reason: not valid java name */
    public static final n m24establishConnection$lambda2(String str, DeviceConnector deviceConnector, p0 p0Var, boolean z4, List list) {
        k.e(deviceConnector, "this$0");
        k.e(p0Var, "$rxBleDevice");
        k.e(list, "queue");
        if (list.contains(str)) {
            return deviceConnector.connectDevice(p0Var, z4).Z(new e(p0Var));
        }
        k.d(str, "deviceId");
        return m2.k.Y(new EstablishConnectionFailure(str, "Device is not in queue"));
    }

    /* access modifiers changed from: private */
    /* renamed from: establishConnection$lambda-2$lambda-1  reason: not valid java name */
    public static final EstablishConnectionResult m25establishConnection$lambda2$lambda1(p0 p0Var, n0 n0Var) {
        k.e(p0Var, "$rxBleDevice");
        k.e(n0Var, "it");
        String c5 = p0Var.c();
        k.d(c5, "rxBleDevice.macAddress");
        return new EstablishedConnection(c5, n0Var);
    }

    /* access modifiers changed from: private */
    /* renamed from: establishConnection$lambda-3  reason: not valid java name */
    public static final EstablishConnectionResult m26establishConnection$lambda3(p0 p0Var, Throwable th) {
        k.e(p0Var, "$rxBleDevice");
        k.e(th, "error");
        String c5 = p0Var.c();
        k.d(c5, "rxBleDevice.macAddress");
        String message = th.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        return new EstablishConnectionFailure(c5, message);
    }

    /* access modifiers changed from: private */
    /* renamed from: establishConnection$lambda-4  reason: not valid java name */
    public static final void m27establishConnection$lambda4(DeviceConnector deviceConnector, String str, EstablishConnectionResult establishConnectionResult) {
        k.e(deviceConnector, "this$0");
        deviceConnector.getConnectionStatusUpdates();
        deviceConnector.timestampEstablishConnection = System.currentTimeMillis();
        ConnectionQueue connectionQueue2 = deviceConnector.connectionQueue;
        k.d(str, "deviceId");
        connectionQueue2.removeFromQueue(str);
        if (establishConnectionResult instanceof EstablishConnectionFailure) {
            deviceConnector.updateListeners.invoke(new ConnectionUpdateError(str, ((EstablishConnectionFailure) establishConnectionResult).getErrorMessage()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: establishConnection$lambda-5  reason: not valid java name */
    public static final void m28establishConnection$lambda5(DeviceConnector deviceConnector, String str, Throwable th) {
        k.e(deviceConnector, "this$0");
        ConnectionQueue connectionQueue2 = deviceConnector.connectionQueue;
        k.d(str, "deviceId");
        connectionQueue2.removeFromQueue(str);
        l<ConnectionUpdate, q> lVar = deviceConnector.updateListeners;
        String message = th.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        lVar.invoke(new ConnectionUpdateError(str, message));
    }

    /* access modifiers changed from: private */
    /* renamed from: establishConnection$lambda-6  reason: not valid java name */
    public static final void m29establishConnection$lambda6(DeviceConnector deviceConnector, EstablishConnectionResult establishConnectionResult) {
        k.e(deviceConnector, "this$0");
        deviceConnector.connectDeviceSubject.d(establishConnectionResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: establishConnection$lambda-7  reason: not valid java name */
    public static final void m30establishConnection$lambda7(DeviceConnector deviceConnector, Throwable th) {
        k.e(deviceConnector, "this$0");
        deviceConnector.connectDeviceSubject.onError(th);
    }

    public static /* synthetic */ void getConnectionDisposable$reactive_ble_mobile_release$annotations() {
    }

    private final c getConnectionStatusUpdates() {
        return (c) this.connectionStatusUpdates$delegate.getValue();
    }

    private final EstablishConnectionResult getCurrentConnection() {
        if (this.lazyConnection.isInitialized()) {
            return getConnection$reactive_ble_mobile_release().S0();
        }
        return null;
    }

    private final void sendDisconnectedUpdate(String str) {
        this.updateListeners.invoke(new ConnectionUpdateSuccess(str, ConnectionState.DISCONNECTED.getCode()));
    }

    private final m2.k<List<String>> waitUntilFirstOfQueue(String str) {
        return this.connectionQueue.observeQueue().I(new m(str)).E0(new b(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: waitUntilFirstOfQueue$lambda-12  reason: not valid java name */
    public static final boolean m31waitUntilFirstOfQueue$lambda12(String str, List list) {
        k.e(str, "$deviceId");
        k.e(list, "queue");
        return k.a(v.l(list), str) || !list.contains(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: waitUntilFirstOfQueue$lambda-13  reason: not valid java name */
    public static final boolean m32waitUntilFirstOfQueue$lambda13(String str, List list) {
        k.e(str, "$deviceId");
        k.e(list, "it");
        return list.isEmpty() || k.a(v.k(list), str);
    }

    public final m2.a clearGattCache$reactive_ble_mobile_release() {
        m2.a aVar;
        EstablishConnectionResult currentConnection = getCurrentConnection();
        if (currentConnection != null) {
            if (currentConnection instanceof EstablishedConnection) {
                aVar = clearGattCache(((EstablishedConnection) currentConnection).getRxConnection());
            } else if (currentConnection instanceof EstablishConnectionFailure) {
                aVar = m2.a.f(new Throwable(((EstablishConnectionFailure) currentConnection).getErrorMessage()));
                k.d(aVar, "error(Throwable(connection.errorMessage))");
            } else {
                throw new i();
            }
            if (aVar != null) {
                return aVar;
            }
        }
        m2.a f5 = m2.a.f(new IllegalStateException("Connection is not established"));
        k.d(f5, "error(IllegalStateExcept…ion is not established\"))");
        return f5;
    }

    public final void disconnectDevice$reactive_ble_mobile_release(String str) {
        k.e(str, "deviceId");
        long currentTimeMillis = System.currentTimeMillis() - this.timestampEstablishConnection;
        if (currentTimeMillis < minTimeMsBeforeDisconnectingIsAllowed) {
            r.H(minTimeMsBeforeDisconnectingIsAllowed - currentTimeMillis, TimeUnit.MILLISECONDS).k(new l(this, str)).B();
            return;
        }
        sendDisconnectedUpdate(str);
        disposeSubscriptions();
    }

    public final a<EstablishConnectionResult> getConnection$reactive_ble_mobile_release() {
        return (a) this.connection$delegate.getValue();
    }

    public final c getConnectionDisposable$reactive_ble_mobile_release() {
        return this.connectionDisposable;
    }

    public final void setConnectionDisposable$reactive_ble_mobile_release(c cVar) {
        this.connectionDisposable = cVar;
    }
}
