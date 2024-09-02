package com.signify.hue.flutterreactiveble.channelhandlers;

import android.os.ParcelUuid;
import com.signify.hue.flutterreactiveble.ProtobufModel;
import com.signify.hue.flutterreactiveble.ble.BleClient;
import com.signify.hue.flutterreactiveble.ble.ScanInfo;
import com.signify.hue.flutterreactiveble.converters.ProtobufMessageConverter;
import com.signify.hue.flutterreactiveble.converters.UuidConverter;
import com.signify.hue.flutterreactiveble.model.ScanModeKt;
import io.flutter.plugin.common.EventChannel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import m3.q;
import o2.a;
import p2.c;

public final class ScanDevicesHandler implements EventChannel.StreamHandler {
    public static final Companion Companion = new Companion((g) null);
    private static ScanParameters scanParameters;
    private final BleClient bleClient;
    private final ProtobufMessageConverter converter = new ProtobufMessageConverter();
    private EventChannel.EventSink scanDevicesSink;
    private c scanForDevicesDisposable;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public ScanDevicesHandler(BleClient bleClient2) {
        k.e(bleClient2, "bleClient");
        this.bleClient = bleClient2;
    }

    private final void handleDeviceScanResult(ProtobufModel.DeviceScanInfo deviceScanInfo) {
        EventChannel.EventSink eventSink = this.scanDevicesSink;
        if (eventSink != null) {
            eventSink.success(deviceScanInfo.toByteArray());
        }
    }

    private final void startDeviceScan() {
        q qVar;
        ScanParameters scanParameters2 = scanParameters;
        if (scanParameters2 != null) {
            c t02 = this.bleClient.scanForDevices(scanParameters2.getFilter(), scanParameters2.getMode(), scanParameters2.getLocationServiceIsMandatory()).f0(a.a()).t0(new g(this), new h(this));
            k.d(t02, "bleClient.scanForDevices…  }\n                    )");
            this.scanForDevicesDisposable = t02;
            qVar = q.f5904a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            handleDeviceScanResult(this.converter.convertScanErrorInfo("Scanning parameters are not set"));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startDeviceScan$lambda-3$lambda-1  reason: not valid java name */
    public static final void m63startDeviceScan$lambda3$lambda1(ScanDevicesHandler scanDevicesHandler, ScanInfo scanInfo) {
        k.e(scanDevicesHandler, "this$0");
        ProtobufMessageConverter protobufMessageConverter = scanDevicesHandler.converter;
        k.d(scanInfo, "scanResult");
        scanDevicesHandler.handleDeviceScanResult(protobufMessageConverter.convertScanInfo(scanInfo));
    }

    /* access modifiers changed from: private */
    /* renamed from: startDeviceScan$lambda-3$lambda-2  reason: not valid java name */
    public static final void m64startDeviceScan$lambda3$lambda2(ScanDevicesHandler scanDevicesHandler, Throwable th) {
        k.e(scanDevicesHandler, "this$0");
        scanDevicesHandler.handleDeviceScanResult(scanDevicesHandler.converter.convertScanErrorInfo(th.getMessage()));
    }

    public void onCancel(Object obj) {
        stopDeviceScan();
        this.scanDevicesSink = null;
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        if (eventSink != null) {
            this.scanDevicesSink = eventSink;
            startDeviceScan();
        }
    }

    public final void prepareScan(ProtobufModel.ScanForDevicesRequest scanForDevicesRequest) {
        k.e(scanForDevicesRequest, "scanMessage");
        stopDeviceScan();
        List<ProtobufModel.Uuid> serviceUuidsList = scanForDevicesRequest.getServiceUuidsList();
        k.d(serviceUuidsList, "scanMessage.serviceUuidsList");
        ArrayList arrayList = new ArrayList(o.i(serviceUuidsList, 10));
        for (ProtobufModel.Uuid data : serviceUuidsList) {
            UuidConverter uuidConverter = new UuidConverter();
            byte[] y4 = data.getData().y();
            k.d(y4, "it.data.toByteArray()");
            arrayList.add(new ParcelUuid(uuidConverter.uuidFromByteArray(y4)));
        }
        scanParameters = new ScanParameters(arrayList, ScanModeKt.createScanMode(scanForDevicesRequest.getScanMode()), scanForDevicesRequest.getRequireLocationServicesEnabled());
    }

    public final void stopDeviceScan() {
        c cVar = this.scanForDevicesDisposable;
        if (cVar != null) {
            if (cVar == null) {
                k.o("scanForDevicesDisposable");
                cVar = null;
            }
            if (!cVar.f()) {
                cVar.dispose();
                scanParameters = null;
            }
        }
    }
}
