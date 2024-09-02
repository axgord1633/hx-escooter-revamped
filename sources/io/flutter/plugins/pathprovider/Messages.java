package io.flutter.plugins.pathprovider;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class Messages {

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(String str, String str2, Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public interface PathProviderApi {
        String getApplicationCachePath();

        String getApplicationDocumentsPath();

        String getApplicationSupportPath();

        List<String> getExternalCachePaths();

        String getExternalStoragePath();

        List<String> getExternalStoragePaths(StorageDirectory storageDirectory);

        String getTemporaryPath();
    }

    public enum StorageDirectory {
        ROOT(0),
        MUSIC(1),
        PODCASTS(2),
        RINGTONES(3),
        ALARMS(4),
        NOTIFICATIONS(5),
        PICTURES(6),
        MOVIES(7),
        DOWNLOADS(8),
        DCIM(9),
        DOCUMENTS(10);
        
        final int index;

        private StorageDirectory(int i5) {
            this.index = i5;
        }
    }

    protected static ArrayList<Object> wrapError(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            obj = flutterError.details;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
