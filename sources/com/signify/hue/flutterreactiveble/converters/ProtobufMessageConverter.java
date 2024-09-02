package com.signify.hue.flutterreactiveble.converters;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.google.protobuf.i;
import com.google.protobuf.z;
import com.signify.hue.flutterreactiveble.ProtobufModel;
import com.signify.hue.flutterreactiveble.ble.ConnectionUpdateSuccess;
import com.signify.hue.flutterreactiveble.ble.MtuNegotiateFailed;
import com.signify.hue.flutterreactiveble.ble.MtuNegotiateResult;
import com.signify.hue.flutterreactiveble.ble.MtuNegotiateSuccesful;
import com.signify.hue.flutterreactiveble.ble.RequestConnectionPriorityFailed;
import com.signify.hue.flutterreactiveble.ble.RequestConnectionPriorityResult;
import com.signify.hue.flutterreactiveble.ble.RequestConnectionPrioritySuccess;
import com.signify.hue.flutterreactiveble.ble.ScanInfo;
import com.signify.hue.flutterreactiveble.model.CharacteristicErrorType;
import com.signify.hue.flutterreactiveble.model.ClearGattCacheErrorType;
import com.signify.hue.flutterreactiveble.model.ConnectionErrorType;
import com.signify.hue.flutterreactiveble.model.ConnectionState;
import com.signify.hue.flutterreactiveble.model.NegotiateMtuErrorType;
import com.signify.hue.flutterreactiveble.model.ScanErrorType;
import com.yalantis.ucrop.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import p1.q0;

public final class ProtobufMessageConverter {
    public static final Companion Companion = new Companion((g) null);
    private static final int positionLeastSignificantBit = 3;
    private static final int positionMostSignificantBit = 2;
    private final UuidConverter uuidConverter = new UuidConverter();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    private final ProtobufModel.DiscoveredService convertInternalService(BluetoothGattService bluetoothGattService) {
        ProtobufModel.DiscoveredService.Builder newBuilder = ProtobufModel.DiscoveredService.newBuilder();
        UUID uuid = bluetoothGattService.getUuid();
        k.d(uuid, "gattService.uuid");
        ProtobufModel.DiscoveredService.Builder serviceUuid = newBuilder.setServiceUuid(createUuidFromParcelUuid(uuid));
        List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
        k.d(characteristics, "gattService.characteristics");
        ArrayList arrayList = new ArrayList(o.i(characteristics, 10));
        for (BluetoothGattCharacteristic uuid2 : characteristics) {
            UUID uuid3 = uuid2.getUuid();
            k.d(uuid3, "it.uuid");
            arrayList.add(createUuidFromParcelUuid(uuid3));
        }
        ProtobufModel.DiscoveredService.Builder addAllCharacteristicUuids = serviceUuid.addAllCharacteristicUuids(arrayList);
        List<BluetoothGattService> includedServices = bluetoothGattService.getIncludedServices();
        k.d(includedServices, "gattService.includedServices");
        ArrayList arrayList2 = new ArrayList(o.i(includedServices, 10));
        for (BluetoothGattService bluetoothGattService2 : includedServices) {
            k.d(bluetoothGattService2, "it");
            arrayList2.add(convertInternalService(bluetoothGattService2));
        }
        z build = addAllCharacteristicUuids.addAllIncludedServices(arrayList2).build();
        k.d(build, "root.addAllIncludedServices(children).build()");
        return (ProtobufModel.DiscoveredService) build;
    }

    private final ProtobufModel.CharacteristicAddress.Builder createCharacteristicAddress(ProtobufModel.CharacteristicAddress characteristicAddress) {
        return ProtobufModel.CharacteristicAddress.newBuilder().setDeviceId(characteristicAddress.getDeviceId()).setServiceUuid(characteristicAddress.getServiceUuid()).setServiceInstanceId(characteristicAddress.getServiceInstanceId()).setCharacteristicInstanceId(characteristicAddress.getCharacteristicInstanceId()).setCharacteristicUuid(characteristicAddress.getCharacteristicUuid());
    }

    private final List<ProtobufModel.ServiceDataEntry> createServiceDataEntry(Map<UUID, byte[]> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            z build = ProtobufModel.ServiceDataEntry.newBuilder().setServiceUuid(createUuidFromParcelUuid((UUID) next.getKey())).setData(i.m((byte[]) next.getValue())).build();
            k.d(build, "newBuilder()\n           …                 .build()");
            arrayList.add(build);
        }
        return arrayList;
    }

    private final List<ProtobufModel.Uuid> createServiceUuids(List<UUID> list) {
        ArrayList arrayList = new ArrayList(o.i(list, 10));
        for (UUID createUuidFromParcelUuid : list) {
            arrayList.add(createUuidFromParcelUuid(createUuidFromParcelUuid));
        }
        return arrayList;
    }

    private final ProtobufModel.Uuid createUuidFromParcelUuid(UUID uuid) {
        z build = ProtobufModel.Uuid.newBuilder().setData(i.m(this.uuidConverter.byteArrayFromUuid(uuid))).build();
        k.d(build, "newBuilder().setData(Byt…m(convertedUuid)).build()");
        return (ProtobufModel.Uuid) build;
    }

    private final ProtobufModel.DiscoveredService fromBluetoothGattService(BluetoothGattService bluetoothGattService) {
        ProtobufModel.DiscoveredService.Builder newBuilder = ProtobufModel.DiscoveredService.newBuilder();
        UUID uuid = bluetoothGattService.getUuid();
        k.d(uuid, "gattService.uuid");
        ProtobufModel.DiscoveredService.Builder serviceInstanceId = newBuilder.setServiceUuid(createUuidFromParcelUuid(uuid)).setServiceInstanceId(String.valueOf(bluetoothGattService.getInstanceId()));
        List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
        k.d(characteristics, "gattService.characteristics");
        ArrayList arrayList = new ArrayList(o.i(characteristics, 10));
        for (BluetoothGattCharacteristic uuid2 : characteristics) {
            UUID uuid3 = uuid2.getUuid();
            k.d(uuid3, "it.uuid");
            arrayList.add(createUuidFromParcelUuid(uuid3));
        }
        ProtobufModel.DiscoveredService.Builder addAllCharacteristicUuids = serviceInstanceId.addAllCharacteristicUuids(arrayList);
        List<BluetoothGattCharacteristic> characteristics2 = bluetoothGattService.getCharacteristics();
        k.d(characteristics2, "gattService.characteristics");
        ArrayList arrayList2 = new ArrayList(o.i(characteristics2, 10));
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics2) {
            int properties = bluetoothGattCharacteristic.getProperties();
            boolean z4 = true;
            boolean z5 = (properties & 2) > 0;
            boolean z6 = (properties & 8) > 0;
            boolean z7 = (properties & 4) > 0;
            boolean z8 = (properties & 16) > 0;
            if ((properties & 32) <= 0) {
                z4 = false;
            }
            ProtobufModel.DiscoveredCharacteristic.Builder newBuilder2 = ProtobufModel.DiscoveredCharacteristic.newBuilder();
            UUID uuid4 = bluetoothGattCharacteristic.getUuid();
            k.d(uuid4, "it.uuid");
            ProtobufModel.DiscoveredCharacteristic.Builder characteristicInstanceId = newBuilder2.setCharacteristicId(createUuidFromParcelUuid(uuid4)).setCharacteristicInstanceId(String.valueOf(bluetoothGattCharacteristic.getInstanceId()));
            UUID uuid5 = bluetoothGattCharacteristic.getService().getUuid();
            k.d(uuid5, "it.service.uuid");
            arrayList2.add((ProtobufModel.DiscoveredCharacteristic) characteristicInstanceId.setServiceId(createUuidFromParcelUuid(uuid5)).setIsReadable(z5).setIsWritableWithResponse(z6).setIsWritableWithoutResponse(z7).setIsNotifiable(z8).setIsIndicatable(z4).build());
        }
        ProtobufModel.DiscoveredService.Builder addAllCharacteristics = addAllCharacteristicUuids.addAllCharacteristics(arrayList2);
        List<BluetoothGattService> includedServices = bluetoothGattService.getIncludedServices();
        k.d(includedServices, "gattService.includedServices");
        ArrayList arrayList3 = new ArrayList(o.i(includedServices, 10));
        for (BluetoothGattService bluetoothGattService2 : includedServices) {
            k.d(bluetoothGattService2, "it");
            arrayList3.add(convertInternalService(bluetoothGattService2));
        }
        z build = addAllCharacteristics.addAllIncludedServices(arrayList3).build();
        k.d(build, "newBuilder()\n           …\n                .build()");
        return (ProtobufModel.DiscoveredService) build;
    }

    public final ProtobufModel.CharacteristicValueInfo convertCharacteristicError(ProtobufModel.CharacteristicAddress characteristicAddress, String str) {
        k.e(characteristicAddress, "request");
        ProtobufModel.CharacteristicAddress.Builder createCharacteristicAddress = createCharacteristicAddress(characteristicAddress);
        ProtobufModel.GenericFailure.Builder code = ProtobufModel.GenericFailure.newBuilder().setCode(CharacteristicErrorType.UNKNOWN.getCode());
        if (str == null) {
            str = "Unknown error";
        }
        z build = ProtobufModel.CharacteristicValueInfo.newBuilder().setCharacteristic(createCharacteristicAddress).setFailure(code.setMessage(str)).build();
        k.d(build, "newBuilder()\n           …\n                .build()");
        return (ProtobufModel.CharacteristicValueInfo) build;
    }

    public final ProtobufModel.CharacteristicValueInfo convertCharacteristicInfo(ProtobufModel.CharacteristicAddress characteristicAddress, byte[] bArr) {
        k.e(characteristicAddress, "request");
        k.e(bArr, "value");
        z build = ProtobufModel.CharacteristicValueInfo.newBuilder().setCharacteristic(createCharacteristicAddress(characteristicAddress)).setValue(i.m(bArr)).build();
        k.d(build, "newBuilder()\n           …\n                .build()");
        return (ProtobufModel.CharacteristicValueInfo) build;
    }

    public final ProtobufModel.ClearGattCacheInfo convertClearGattCacheError(ClearGattCacheErrorType clearGattCacheErrorType, String str) {
        k.e(clearGattCacheErrorType, "code");
        ProtobufModel.GenericFailure.Builder code = ProtobufModel.GenericFailure.newBuilder().setCode(clearGattCacheErrorType.getCode());
        if (str != null) {
            k.d(code, "failure");
            code.setMessage(str);
        }
        z build = ProtobufModel.ClearGattCacheInfo.newBuilder().setFailure(code).build();
        k.d(build, "newBuilder().setFailure(failure).build()");
        return (ProtobufModel.ClearGattCacheInfo) build;
    }

    public final ProtobufModel.DeviceInfo convertConnectionErrorToDeviceInfo(String str, String str2) {
        k.e(str, "deviceId");
        ProtobufModel.DeviceInfo.Builder connectionState = ProtobufModel.DeviceInfo.newBuilder().setId(str).setConnectionState(ConnectionState.DISCONNECTED.getCode());
        ProtobufModel.GenericFailure.Builder code = ProtobufModel.GenericFailure.newBuilder().setCode(ConnectionErrorType.FAILEDTOCONNECT.getCode());
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        z build = connectionState.setFailure((ProtobufModel.GenericFailure) code.setMessage(str2).build()).build();
        k.d(build, "newBuilder()\n           …\n                .build()");
        return (ProtobufModel.DeviceInfo) build;
    }

    public final ProtobufModel.DiscoverServicesInfo convertDiscoverServicesInfo(String str, q0 q0Var) {
        k.e(str, "deviceId");
        k.e(q0Var, "services");
        ProtobufModel.DiscoverServicesInfo.Builder deviceId = ProtobufModel.DiscoverServicesInfo.newBuilder().setDeviceId(str);
        List<BluetoothGattService> a5 = q0Var.a();
        k.d(a5, "services.bluetoothGattServices");
        ArrayList arrayList = new ArrayList(o.i(a5, 10));
        for (BluetoothGattService bluetoothGattService : a5) {
            k.d(bluetoothGattService, "it");
            arrayList.add(fromBluetoothGattService(bluetoothGattService));
        }
        z build = deviceId.addAllServices(arrayList).build();
        k.d(build, "newBuilder()\n           …\n                .build()");
        return (ProtobufModel.DiscoverServicesInfo) build;
    }

    public final ProtobufModel.NegotiateMtuInfo convertNegotiateMtuInfo(MtuNegotiateResult mtuNegotiateResult) {
        z build;
        String str;
        k.e(mtuNegotiateResult, "result");
        if (mtuNegotiateResult instanceof MtuNegotiateSuccesful) {
            MtuNegotiateSuccesful mtuNegotiateSuccesful = (MtuNegotiateSuccesful) mtuNegotiateResult;
            build = ProtobufModel.NegotiateMtuInfo.newBuilder().setDeviceId(mtuNegotiateSuccesful.getDeviceId()).setMtuSize(mtuNegotiateSuccesful.getSize()).build();
            str = "newBuilder()\n           …                 .build()";
        } else if (mtuNegotiateResult instanceof MtuNegotiateFailed) {
            MtuNegotiateFailed mtuNegotiateFailed = (MtuNegotiateFailed) mtuNegotiateResult;
            build = ProtobufModel.NegotiateMtuInfo.newBuilder().setDeviceId(mtuNegotiateFailed.getDeviceId()).setFailure((ProtobufModel.GenericFailure) ProtobufModel.GenericFailure.newBuilder().setCode(NegotiateMtuErrorType.UNKNOWN.getCode()).setMessage(mtuNegotiateFailed.getErrorMessage()).build()).build();
            str = "{\n\n                    v…build()\n                }";
        } else {
            throw new m3.i();
        }
        k.d(build, str);
        return (ProtobufModel.NegotiateMtuInfo) build;
    }

    public final ProtobufModel.ChangeConnectionPriorityInfo convertRequestConnectionPriorityInfo(RequestConnectionPriorityResult requestConnectionPriorityResult) {
        z build;
        String str;
        k.e(requestConnectionPriorityResult, "result");
        if (requestConnectionPriorityResult instanceof RequestConnectionPrioritySuccess) {
            build = ProtobufModel.ChangeConnectionPriorityInfo.newBuilder().setDeviceId(((RequestConnectionPrioritySuccess) requestConnectionPriorityResult).getDeviceId()).build();
            str = "newBuilder()\n           …                 .build()";
        } else if (requestConnectionPriorityResult instanceof RequestConnectionPriorityFailed) {
            RequestConnectionPriorityFailed requestConnectionPriorityFailed = (RequestConnectionPriorityFailed) requestConnectionPriorityResult;
            build = ProtobufModel.ChangeConnectionPriorityInfo.newBuilder().setDeviceId(requestConnectionPriorityFailed.getDeviceId()).setFailure((ProtobufModel.GenericFailure) ProtobufModel.GenericFailure.newBuilder().setCode(0).setMessage(requestConnectionPriorityFailed.getErrorMessage()).build()).build();
            str = "{\n                val fa…   .build()\n            }";
        } else {
            throw new m3.i();
        }
        k.d(build, str);
        return (ProtobufModel.ChangeConnectionPriorityInfo) build;
    }

    public final ProtobufModel.DeviceScanInfo convertScanErrorInfo(String str) {
        ProtobufModel.DeviceScanInfo.Builder newBuilder = ProtobufModel.DeviceScanInfo.newBuilder();
        ProtobufModel.GenericFailure.Builder code = ProtobufModel.GenericFailure.newBuilder().setCode(ScanErrorType.UNKNOWN.getCode());
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        z build = newBuilder.setFailure((ProtobufModel.GenericFailure) code.setMessage(str).build()).build();
        k.d(build, "newBuilder()\n           …                 .build()");
        return (ProtobufModel.DeviceScanInfo) build;
    }

    public final ProtobufModel.DeviceScanInfo convertScanInfo(ScanInfo scanInfo) {
        k.e(scanInfo, "scanInfo");
        z build = ProtobufModel.DeviceScanInfo.newBuilder().setId(scanInfo.getDeviceId()).setName(scanInfo.getName()).setRssi(scanInfo.getRssi()).setIsConnectable((ProtobufModel.IsConnectable) ProtobufModel.IsConnectable.newBuilder().setCode(scanInfo.getConnectable().getCode()).build()).addAllServiceData(createServiceDataEntry(scanInfo.getServiceData())).addAllServiceUuids(createServiceUuids(scanInfo.getServiceUuids())).setManufacturerData(i.m(scanInfo.getManufacturerData())).build();
        k.d(build, "newBuilder()\n           …                 .build()");
        return (ProtobufModel.DeviceScanInfo) build;
    }

    public final ProtobufModel.DeviceInfo convertToDeviceInfo(ConnectionUpdateSuccess connectionUpdateSuccess) {
        k.e(connectionUpdateSuccess, "connection");
        z build = ProtobufModel.DeviceInfo.newBuilder().setId(connectionUpdateSuccess.getDeviceId()).setConnectionState(connectionUpdateSuccess.getConnectionState()).build();
        k.d(build, "newBuilder()\n           …                 .build()");
        return (ProtobufModel.DeviceInfo) build;
    }

    public final ProtobufModel.WriteCharacteristicInfo convertWriteCharacteristicInfo(ProtobufModel.WriteCharacteristicRequest writeCharacteristicRequest, String str) {
        k.e(writeCharacteristicRequest, "request");
        ProtobufModel.WriteCharacteristicInfo.Builder characteristic = ProtobufModel.WriteCharacteristicInfo.newBuilder().setCharacteristic(writeCharacteristicRequest.getCharacteristic());
        if (str != null) {
            characteristic.setFailure(ProtobufModel.GenericFailure.newBuilder().setCode(CharacteristicErrorType.UNKNOWN.getCode()).setMessage(str));
        }
        z build = characteristic.build();
        k.d(build, "builder.build()");
        return (ProtobufModel.WriteCharacteristicInfo) build;
    }
}
