package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import android.view.WindowMetrics;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.EmbeddingRule;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.jvm.internal.k;

public final class EmbeddingAdapter {
    private final <F, S> F component1(Pair<F, S> pair) {
        k.e(pair, "<this>");
        return pair.first;
    }

    private final <F, S> S component2(Pair<F, S> pair) {
        k.e(pair, "<this>");
        return pair.second;
    }

    private final SplitInfo translate(SplitInfo splitInfo) {
        boolean z4;
        ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        k.d(primaryActivityStack, "splitInfo.primaryActivityStack");
        boolean z5 = false;
        try {
            z4 = primaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused) {
            z4 = false;
        }
        List activities = primaryActivityStack.getActivities();
        k.d(activities, "primaryActivityStack.activities");
        ActivityStack activityStack = new ActivityStack(activities, z4);
        ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        k.d(secondaryActivityStack, "splitInfo.secondaryActivityStack");
        try {
            z5 = secondaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused2) {
        }
        List activities2 = secondaryActivityStack.getActivities();
        k.d(activities2, "secondaryActivityStack.activities");
        return new SplitInfo(activityStack, new ActivityStack(activities2, z5), splitInfo.getSplitRatio());
    }

    /* access modifiers changed from: private */
    /* renamed from: translateActivityIntentPredicates$lambda-3  reason: not valid java name */
    public static final boolean m0translateActivityIntentPredicates$lambda3(EmbeddingAdapter embeddingAdapter, Set set, Pair pair) {
        k.e(embeddingAdapter, "this$0");
        k.e(set, "$splitPairFilters");
        k.d(pair, "(first, second)");
        Activity activity = (Activity) embeddingAdapter.component1(pair);
        Intent intent = (Intent) embeddingAdapter.component2(pair);
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (((SplitPairFilter) it.next()).matchesActivityIntentPair(activity, intent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateActivityPairPredicates$lambda-1  reason: not valid java name */
    public static final boolean m1translateActivityPairPredicates$lambda1(EmbeddingAdapter embeddingAdapter, Set set, Pair pair) {
        k.e(embeddingAdapter, "this$0");
        k.e(set, "$splitPairFilters");
        k.d(pair, "(first, second)");
        Activity activity = (Activity) embeddingAdapter.component1(pair);
        Activity activity2 = (Activity) embeddingAdapter.component2(pair);
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (((SplitPairFilter) it.next()).matchesActivityPair(activity, activity2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateActivityPredicates$lambda-6  reason: not valid java name */
    public static final boolean m2translateActivityPredicates$lambda6(Set set, Activity activity) {
        k.e(set, "$activityFilters");
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            k.d(activity, "activity");
            if (((ActivityFilter) it.next()).matchesActivity(activity)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateIntentPredicates$lambda-8  reason: not valid java name */
    public static final boolean m3translateIntentPredicates$lambda8(Set set, Intent intent) {
        k.e(set, "$activityFilters");
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            k.d(intent, "intent");
            if (((ActivityFilter) it.next()).matchesIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateParentMetricsPredicate$lambda-4  reason: not valid java name */
    public static final boolean m4translateParentMetricsPredicate$lambda4(SplitRule splitRule, WindowMetrics windowMetrics) {
        k.e(splitRule, "$splitRule");
        k.d(windowMetrics, "windowMetrics");
        return splitRule.checkParentMetrics(windowMetrics);
    }

    public final List<SplitInfo> translate(List<? extends SplitInfo> list) {
        k.e(list, "splitInfoList");
        ArrayList arrayList = new ArrayList(o.i(list, 10));
        for (SplitInfo translate : list) {
            arrayList.add(translate(translate));
        }
        return arrayList;
    }

    public final Set<EmbeddingRule> translate(Set<? extends EmbeddingRule> set) {
        SplitPairRule build;
        String str;
        k.e(set, "rules");
        ArrayList arrayList = new ArrayList(o.i(set, 10));
        for (EmbeddingRule embeddingRule : set) {
            if (embeddingRule instanceof SplitPairRule) {
                SplitPairRule splitPairRule = (SplitPairRule) embeddingRule;
                build = new SplitPairRule.Builder(translateActivityPairPredicates(splitPairRule.getFilters()), translateActivityIntentPredicates(splitPairRule.getFilters()), translateParentMetricsPredicate((SplitRule) embeddingRule)).setSplitRatio(splitPairRule.getSplitRatio()).setLayoutDirection(splitPairRule.getLayoutDirection()).setShouldFinishPrimaryWithSecondary(splitPairRule.getFinishPrimaryWithSecondary()).setShouldFinishSecondaryWithPrimary(splitPairRule.getFinishSecondaryWithPrimary()).setShouldClearTop(splitPairRule.getClearTop()).build();
                str = "SplitPairRuleBuilder(\n  …                 .build()";
            } else if (embeddingRule instanceof SplitPlaceholderRule) {
                SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) embeddingRule;
                build = new SplitPlaceholderRule.Builder(splitPlaceholderRule.getPlaceholderIntent(), translateActivityPredicates(splitPlaceholderRule.getFilters()), translateIntentPredicates(splitPlaceholderRule.getFilters()), translateParentMetricsPredicate((SplitRule) embeddingRule)).setSplitRatio(splitPlaceholderRule.getSplitRatio()).setLayoutDirection(splitPlaceholderRule.getLayoutDirection()).build();
                str = "SplitPlaceholderRuleBuil…                 .build()";
            } else if (embeddingRule instanceof ActivityRule) {
                ActivityRule activityRule = (ActivityRule) embeddingRule;
                build = new ActivityRule.Builder(translateActivityPredicates(activityRule.getFilters()), translateIntentPredicates(activityRule.getFilters())).setShouldAlwaysExpand(activityRule.getAlwaysExpand()).build();
                str = "ActivityRuleBuilder(\n   …                 .build()";
            } else {
                throw new IllegalArgumentException("Unsupported rule type");
            }
            k.d(build, str);
            arrayList.add((EmbeddingRule) build);
        }
        return v.y(arrayList);
    }

    public final Predicate<Pair<Activity, Intent>> translateActivityIntentPredicates(Set<SplitPairFilter> set) {
        k.e(set, "splitPairFilters");
        return new b(this, set);
    }

    public final Predicate<Pair<Activity, Activity>> translateActivityPairPredicates(Set<SplitPairFilter> set) {
        k.e(set, "splitPairFilters");
        return new f(this, set);
    }

    public final Predicate<Activity> translateActivityPredicates(Set<ActivityFilter> set) {
        k.e(set, "activityFilters");
        return new c(set);
    }

    public final Predicate<Intent> translateIntentPredicates(Set<ActivityFilter> set) {
        k.e(set, "activityFilters");
        return new e(set);
    }

    public final Predicate<WindowMetrics> translateParentMetricsPredicate(SplitRule splitRule) {
        k.e(splitRule, "splitRule");
        return new d(splitRule);
    }
}
