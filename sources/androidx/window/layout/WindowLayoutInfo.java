package androidx.window.layout;

import java.util.List;
import kotlin.jvm.internal.k;
import v3.l;

public final class WindowLayoutInfo {
    private final List<DisplayFeature> displayFeatures;

    public WindowLayoutInfo(List<? extends DisplayFeature> list) {
        k.e(list, "displayFeatures");
        this.displayFeatures = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !k.a(WindowLayoutInfo.class, obj.getClass())) {
            return false;
        }
        return k.a(this.displayFeatures, ((WindowLayoutInfo) obj).displayFeatures);
    }

    public final List<DisplayFeature> getDisplayFeatures() {
        return this.displayFeatures;
    }

    public int hashCode() {
        return this.displayFeatures.hashCode();
    }

    public String toString() {
        return v.p(this.displayFeatures, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, (CharSequence) null, (l) null, 56, (Object) null);
    }
}
