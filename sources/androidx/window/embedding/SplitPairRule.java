package androidx.window.embedding;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;

public final class SplitPairRule extends SplitRule {
    private final boolean clearTop;
    private final Set<SplitPairFilter> filters;
    private final boolean finishPrimaryWithSecondary;
    private final boolean finishSecondaryWithPrimary;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplitPairRule(Set<SplitPairFilter> set, boolean z4, boolean z5, boolean z6, int i5, int i6, float f5, int i7) {
        super(i5, i6, f5, i7);
        k.e(set, "filters");
        this.finishPrimaryWithSecondary = z4;
        this.finishSecondaryWithPrimary = z5;
        this.clearTop = z6;
        this.filters = v.y(set);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SplitPairRule(java.util.Set r8, boolean r9, boolean r10, boolean r11, int r12, int r13, float r14, int r15, int r16, kotlin.jvm.internal.g r17) {
        /*
            r7 = this;
            r0 = r16
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r9
        L_0x000a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0010
            r3 = 1
            goto L_0x0011
        L_0x0010:
            r3 = r10
        L_0x0011:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r11
        L_0x0018:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r12
        L_0x001f:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = r13
        L_0x0025:
            r6 = r0 & 64
            if (r6 == 0) goto L_0x002c
            r6 = 1056964608(0x3f000000, float:0.5)
            goto L_0x002d
        L_0x002c:
            r6 = r14
        L_0x002d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0033
            r0 = 3
            goto L_0x0034
        L_0x0033:
            r0 = r15
        L_0x0034:
            r9 = r7
            r10 = r8
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r2
            r16 = r6
            r17 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SplitPairRule.<init>(java.util.Set, boolean, boolean, boolean, int, int, float, int, int, kotlin.jvm.internal.g):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairRule) || !super.equals(obj)) {
            return false;
        }
        SplitPairRule splitPairRule = (SplitPairRule) obj;
        return k.a(this.filters, splitPairRule.filters) && this.finishPrimaryWithSecondary == splitPairRule.finishPrimaryWithSecondary && this.finishSecondaryWithPrimary == splitPairRule.finishSecondaryWithPrimary && this.clearTop == splitPairRule.clearTop;
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    public final Set<SplitPairFilter> getFilters() {
        return this.filters;
    }

    public final boolean getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    public final boolean getFinishSecondaryWithPrimary() {
        return this.finishSecondaryWithPrimary;
    }

    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.filters.hashCode()) * 31) + a.a(this.finishPrimaryWithSecondary)) * 31) + a.a(this.finishSecondaryWithPrimary)) * 31) + a.a(this.clearTop);
    }

    public final SplitPairRule plus$window_release(SplitPairFilter splitPairFilter) {
        k.e(splitPairFilter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(splitPairFilter);
        return new SplitPairRule(v.y(linkedHashSet), this.finishPrimaryWithSecondary, this.finishSecondaryWithPrimary, this.clearTop, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }
}
