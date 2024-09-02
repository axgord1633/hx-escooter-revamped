package t0;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import w0.o;
import x0.c;

public final class a extends x0.a {
    public static final Parcelable.Creator<a> CREATOR = new l();

    /* renamed from: i  reason: collision with root package name */
    public static final a f6807i = new a(0);

    /* renamed from: e  reason: collision with root package name */
    final int f6808e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6809f;

    /* renamed from: g  reason: collision with root package name */
    private final PendingIntent f6810g;

    /* renamed from: h  reason: collision with root package name */
    private final String f6811h;

    public a(int i5) {
        this(i5, (PendingIntent) null, (String) null);
    }

    a(int i5, int i6, PendingIntent pendingIntent, String str) {
        this.f6808e = i5;
        this.f6809f = i6;
        this.f6810g = pendingIntent;
        this.f6811h = str;
    }

    public a(int i5, PendingIntent pendingIntent) {
        this(i5, pendingIntent, (String) null);
    }

    public a(int i5, PendingIntent pendingIntent, String str) {
        this(1, i5, pendingIntent, str);
    }

    static String f(int i5) {
        if (i5 == 99) {
            return "UNFINISHED";
        }
        if (i5 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i5) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i5) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i5 + ")";
                }
        }
    }

    public int a() {
        return this.f6809f;
    }

    public String b() {
        return this.f6811h;
    }

    public PendingIntent c() {
        return this.f6810g;
    }

    public boolean d() {
        return (this.f6809f == 0 || this.f6810g == null) ? false : true;
    }

    public boolean e() {
        return this.f6809f == 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f6809f == aVar.f6809f && o.a(this.f6810g, aVar.f6810g) && o.a(this.f6811h, aVar.f6811h);
    }

    public int hashCode() {
        return o.b(Integer.valueOf(this.f6809f), this.f6810g, this.f6811h);
    }

    public String toString() {
        o.a c5 = o.c(this);
        c5.a("statusCode", f(this.f6809f));
        c5.a("resolution", this.f6810g);
        c5.a("message", this.f6811h);
        return c5.toString();
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.g(parcel, 1, this.f6808e);
        c.g(parcel, 2, a());
        c.j(parcel, 3, c(), i5, false);
        c.k(parcel, 4, b(), false);
        c.b(parcel, a5);
    }
}
