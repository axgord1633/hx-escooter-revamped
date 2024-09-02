package d2;

import android.database.sqlite.SQLiteProgram;
import com.yalantis.ucrop.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d0 {

    /* renamed from: a  reason: collision with root package name */
    private final String f4265a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Object> f4266b;

    public d0(String str, List<Object> list) {
        this.f4265a = str;
        this.f4266b = list == null ? new ArrayList<>() : list;
    }

    private Object[] e(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Object f5 : list) {
                arrayList.add(f(f5));
            }
        }
        return arrayList.toArray(new Object[0]);
    }

    private static Object f(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            return obj;
        }
        List list = (List) obj;
        byte[] bArr = new byte[list.size()];
        for (int i5 = 0; i5 < list.size(); i5++) {
            bArr[i5] = (byte) ((Integer) list.get(i5)).intValue();
        }
        return bArr;
    }

    public void a(SQLiteProgram sQLiteProgram) {
        long j5;
        List<Object> list = this.f4266b;
        if (list != null) {
            int size = list.size();
            int i5 = 0;
            while (i5 < size) {
                Object f5 = f(this.f4266b.get(i5));
                int i6 = i5 + 1;
                if (f5 == null) {
                    sQLiteProgram.bindNull(i6);
                } else if (f5 instanceof byte[]) {
                    sQLiteProgram.bindBlob(i6, (byte[]) f5);
                } else if (f5 instanceof Double) {
                    sQLiteProgram.bindDouble(i6, ((Double) f5).doubleValue());
                } else {
                    if (f5 instanceof Integer) {
                        j5 = (long) ((Integer) f5).intValue();
                    } else if (f5 instanceof Long) {
                        j5 = ((Long) f5).longValue();
                    } else if (f5 instanceof String) {
                        sQLiteProgram.bindString(i6, (String) f5);
                    } else if (f5 instanceof Boolean) {
                        j5 = ((Boolean) f5).booleanValue() ? 1 : 0;
                    } else {
                        throw new IllegalArgumentException("Could not bind " + f5 + " from index " + i5 + ": Supported types are null, byte[], double, long, boolean and String");
                    }
                    sQLiteProgram.bindLong(i6, j5);
                }
                i5 = i6;
            }
        }
    }

    public List<Object> b() {
        return this.f4266b;
    }

    public String c() {
        return this.f4265a;
    }

    public Object[] d() {
        return e(this.f4266b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        String str = this.f4265a;
        if (str != null) {
            if (!str.equals(d0Var.f4265a)) {
                return false;
            }
        } else if (d0Var.f4265a != null) {
            return false;
        }
        if (this.f4266b.size() != d0Var.f4266b.size()) {
            return false;
        }
        for (int i5 = 0; i5 < this.f4266b.size(); i5++) {
            if (!(this.f4266b.get(i5) instanceof byte[]) || !(d0Var.f4266b.get(i5) instanceof byte[])) {
                if (!this.f4266b.get(i5).equals(d0Var.f4266b.get(i5))) {
                    return false;
                }
            } else if (!Arrays.equals((byte[]) this.f4266b.get(i5), (byte[]) d0Var.f4266b.get(i5))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.f4265a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4265a);
        List<Object> list = this.f4266b;
        if (list == null || list.isEmpty()) {
            str = BuildConfig.FLAVOR;
        } else {
            str = " " + this.f4266b;
        }
        sb.append(str);
        return sb.toString();
    }
}
