package y1;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.content.Context;
import android.os.Build;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import r1.q;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7721a;

    public b(Context context) {
        this.f7721a = context;
    }

    private BluetoothGatt b(BluetoothGattCallback bluetoothGattCallback, BluetoothDevice bluetoothDevice, boolean z4) {
        q.p("Connecting without reflection", new Object[0]);
        return bluetoothDevice.connectGatt(this.f7721a, z4, bluetoothGattCallback, 2);
    }

    private static boolean c(BluetoothGatt bluetoothGatt, BluetoothGattCallback bluetoothGattCallback, boolean z4) {
        q.p("Connecting using reflection", new Object[0]);
        h(bluetoothGatt, z4);
        Method declaredMethod = bluetoothGatt.getClass().getDeclaredMethod("connect", new Class[]{Boolean.class, BluetoothGattCallback.class});
        declaredMethod.setAccessible(true);
        return ((Boolean) declaredMethod.invoke(bluetoothGatt, new Object[]{Boolean.TRUE, bluetoothGattCallback})).booleanValue();
    }

    private BluetoothGatt d(Object obj, BluetoothDevice bluetoothDevice) {
        Object newInstance;
        Constructor constructor = BluetoothGatt.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        q.p("Found constructor with args count = " + constructor.getParameterTypes().length, new Object[0]);
        if (constructor.getParameterTypes().length == 4) {
            newInstance = constructor.newInstance(new Object[]{this.f7721a, obj, bluetoothDevice, 2});
        } else {
            newInstance = constructor.newInstance(new Object[]{this.f7721a, obj, bluetoothDevice});
        }
        return (BluetoothGatt) newInstance;
    }

    private static Object e(Object obj) {
        if (obj == null) {
            return null;
        }
        return g(obj.getClass(), "getBluetoothGatt").invoke(obj, new Object[0]);
    }

    private static Object f() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return null;
        }
        return g(defaultAdapter.getClass(), "getBluetoothManager").invoke(defaultAdapter, new Object[0]);
    }

    private static Method g(Class<?> cls, String str) {
        Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    private static void h(BluetoothGatt bluetoothGatt, boolean z4) {
        Field declaredField = bluetoothGatt.getClass().getDeclaredField("mAutoConnect");
        declaredField.setAccessible(true);
        declaredField.setBoolean(bluetoothGatt, z4);
    }

    public BluetoothGatt a(BluetoothDevice bluetoothDevice, boolean z4, BluetoothGattCallback bluetoothGattCallback) {
        if (bluetoothDevice == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24 || !z4) {
            return b(bluetoothGattCallback, bluetoothDevice, z4);
        }
        try {
            q.p("Trying to connectGatt using reflection.", new Object[0]);
            Object e5 = e(f());
            if (e5 == null) {
                q.q("Couldn't get iBluetoothGatt object", new Object[0]);
                return b(bluetoothGattCallback, bluetoothDevice, true);
            }
            BluetoothGatt d5 = d(e5, bluetoothDevice);
            if (d5 == null) {
                q.q("Couldn't create BluetoothGatt object", new Object[0]);
                return b(bluetoothGattCallback, bluetoothDevice, true);
            }
            if (!c(d5, bluetoothGattCallback, true)) {
                q.q("Connection using reflection failed, closing gatt", new Object[0]);
                d5.close();
            }
            return d5;
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e6) {
            q.r(e6, "Error while trying to connect via reflection", new Object[0]);
            return b(bluetoothGattCallback, bluetoothDevice, true);
        }
    }
}
