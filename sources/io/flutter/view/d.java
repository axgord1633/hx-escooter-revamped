package io.flutter.view;

import io.flutter.util.Predicate;
import io.flutter.view.AccessibilityBridge;

public final /* synthetic */ class d implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccessibilityBridge.SemanticsNode f5416a;

    public /* synthetic */ d(AccessibilityBridge.SemanticsNode semanticsNode) {
        this.f5416a = semanticsNode;
    }

    public final boolean test(Object obj) {
        return AccessibilityBridge.lambda$shouldSetCollectionInfo$0(this.f5416a, (AccessibilityBridge.SemanticsNode) obj);
    }
}
