package n0;

import java.util.Map;

public class z {

    /* renamed from: a  reason: collision with root package name */
    private final l f6056a;

    /* renamed from: b  reason: collision with root package name */
    private final long f6057b;

    /* renamed from: c  reason: collision with root package name */
    private final long f6058c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f6059d;

    private z(l lVar, long j5, long j6, boolean z4) {
        this.f6056a = lVar;
        this.f6057b = j5;
        this.f6058c = j6;
        this.f6059d = z4;
    }

    public static z e(Map<String, Object> map) {
        if (map == null) {
            return new z(l.best, 0, 5000, false);
        }
        Integer num = (Integer) map.get("accuracy");
        Integer num2 = (Integer) map.get("distanceFilter");
        Integer num3 = (Integer) map.get("timeInterval");
        Boolean bool = (Boolean) map.get("useMSLAltitude");
        l lVar = l.best;
        boolean z4 = true;
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 0) {
                lVar = l.lowest;
            } else if (intValue == 1) {
                lVar = l.low;
            } else if (intValue == 2) {
                lVar = l.medium;
            } else if (intValue == 3) {
                lVar = l.high;
            } else if (intValue == 5) {
                lVar = l.bestForNavigation;
            }
        }
        l lVar2 = lVar;
        long intValue2 = num2 != null ? (long) num2.intValue() : 0;
        long intValue3 = num3 != null ? (long) num3.intValue() : 5000;
        if (bool == null || !bool.booleanValue()) {
            z4 = false;
        }
        return new z(lVar2, intValue2, intValue3, z4);
    }

    public l a() {
        return this.f6056a;
    }

    public long b() {
        return this.f6057b;
    }

    public long c() {
        return this.f6058c;
    }

    public boolean d() {
        return this.f6059d;
    }
}
