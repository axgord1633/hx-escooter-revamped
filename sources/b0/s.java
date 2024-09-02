package b0;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class s {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f2959a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f2960b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<l> f2961c = new ArrayList<>();

    @Deprecated
    public s() {
    }

    public s(View view) {
        this.f2960b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f2960b == sVar.f2960b && this.f2959a.equals(sVar.f2959a);
    }

    public int hashCode() {
        return (this.f2960b.hashCode() * 31) + this.f2959a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2960b + "\n") + "    values:";
        for (String next : this.f2959a.keySet()) {
            str = str + "    " + next + ": " + this.f2959a.get(next) + "\n";
        }
        return str;
    }
}
