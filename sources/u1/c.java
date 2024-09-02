package u1;

import a2.b;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import p1.q0;
import r1.q;
import y1.i;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final i f7103a;

    c(i iVar) {
        this.f7103a = iVar;
    }

    private static void a(StringBuilder sb, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        sb.append(10);
        sb.append(9);
        sb.append("* ");
        sb.append(i(bluetoothGattCharacteristic));
        sb.append(" (");
        sb.append(b.g(bluetoothGattCharacteristic.getUuid()));
        sb.append(")");
    }

    private void b(StringBuilder sb, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        sb.append(10);
        sb.append(9);
        sb.append("  ");
        sb.append("Properties: ");
        sb.append(this.f7103a.c(bluetoothGattCharacteristic.getProperties()));
    }

    private static void c(StringBuilder sb, BluetoothGattDescriptor bluetoothGattDescriptor) {
        sb.append(10);
        sb.append(9);
        sb.append(9);
        sb.append("* ");
        sb.append(j(bluetoothGattDescriptor));
        sb.append(" (");
        sb.append(b.g(bluetoothGattDescriptor.getUuid()));
        sb.append(")");
    }

    private static void d(StringBuilder sb, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (!bluetoothGattCharacteristic.getDescriptors().isEmpty()) {
            e(sb);
            for (BluetoothGattDescriptor c5 : bluetoothGattCharacteristic.getDescriptors()) {
                c(sb, c5);
            }
        }
    }

    private static void e(StringBuilder sb) {
        sb.append(10);
        sb.append(9);
        sb.append("  ");
        sb.append("-> Descriptors: ");
    }

    private static void f(BluetoothDevice bluetoothDevice, StringBuilder sb) {
        sb.append("--------------- ====== Printing peripheral content ====== ---------------\n");
        sb.append(b.d(bluetoothDevice.getAddress()));
        sb.append(10);
        sb.append("PERIPHERAL NAME: ");
        sb.append(bluetoothDevice.getName());
        sb.append(10);
        sb.append("-------------------------------------------------------------------------");
    }

    private void g(StringBuilder sb, BluetoothGattService bluetoothGattService) {
        h(sb, bluetoothGattService);
        sb.append("-> Characteristics:");
        for (BluetoothGattCharacteristic next : bluetoothGattService.getCharacteristics()) {
            a(sb, next);
            b(sb, next);
            d(sb, next);
        }
    }

    private static void h(StringBuilder sb, BluetoothGattService bluetoothGattService) {
        sb.append("\n");
        sb.append(l(bluetoothGattService));
        sb.append(" - ");
        sb.append(k(bluetoothGattService));
        sb.append(" (");
        sb.append(b.g(bluetoothGattService.getUuid()));
        sb.append(")\n");
        sb.append("Instance ID: ");
        sb.append(bluetoothGattService.getInstanceId());
        sb.append(10);
    }

    private static String i(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        String a5 = b.a(bluetoothGattCharacteristic.getUuid());
        return a5 == null ? "Unknown characteristic" : a5;
    }

    private static String j(BluetoothGattDescriptor bluetoothGattDescriptor) {
        String b5 = b.b(bluetoothGattDescriptor.getUuid());
        return b5 == null ? "Unknown descriptor" : b5;
    }

    private static String k(BluetoothGattService bluetoothGattService) {
        String c5 = b.c(bluetoothGattService.getUuid());
        return c5 == null ? "Unknown service" : c5;
    }

    private static String l(BluetoothGattService bluetoothGattService) {
        return bluetoothGattService.getType() == 0 ? "Primary Service" : "Secondary Service";
    }

    private String n(q0 q0Var, BluetoothDevice bluetoothDevice) {
        StringBuilder sb = new StringBuilder();
        f(bluetoothDevice, sb);
        for (BluetoothGattService g5 : q0Var.a()) {
            sb.append(10);
            g(sb, g5);
        }
        sb.append("\n--------------- ====== Finished peripheral content ====== ---------------");
        return sb.toString();
    }

    public void m(q0 q0Var, BluetoothDevice bluetoothDevice) {
        if (q.l(2)) {
            q.p("Preparing services description", new Object[0]);
            q.p(n(q0Var, bluetoothDevice), new Object[0]);
        }
    }
}
