package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

final class k implements j {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f1796a;

    k(Object obj) {
        this.f1796a = (LocaleList) obj;
    }

    public Object a() {
        return this.f1796a;
    }

    public boolean equals(Object obj) {
        return this.f1796a.equals(((j) obj).a());
    }

    public Locale get(int i5) {
        return this.f1796a.get(i5);
    }

    public int hashCode() {
        return this.f1796a.hashCode();
    }

    public String toString() {
        return this.f1796a.toString();
    }
}
