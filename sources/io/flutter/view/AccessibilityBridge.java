package io.flutter.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.yalantis.ucrop.BuildConfig;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import io.flutter.util.Predicate;
import io.flutter.util.ViewUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class AccessibilityBridge extends AccessibilityNodeProvider {
    private static final int ACTION_SHOW_ON_SCREEN = 16908342;
    private static final int BOLD_TEXT_WEIGHT_ADJUSTMENT = 300;
    private static int FIRST_RESOURCE_ID = 267386881;
    /* access modifiers changed from: private */
    public static final int FOCUSABLE_FLAGS = (((((((((((Flag.HAS_CHECKED_STATE.value | Flag.IS_CHECKED.value) | Flag.IS_SELECTED.value) | Flag.IS_TEXT_FIELD.value) | Flag.IS_FOCUSED.value) | Flag.HAS_ENABLED_STATE.value) | Flag.IS_ENABLED.value) | Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.value) | Flag.HAS_TOGGLED_STATE.value) | Flag.IS_TOGGLED.value) | Flag.IS_FOCUSABLE.value) | Flag.IS_SLIDER.value);
    private static final int MIN_ENGINE_GENERATED_NODE_ID = 65536;
    private static final int ROOT_NODE_ID = 0;
    /* access modifiers changed from: private */
    public static final int SCROLLABLE_ACTIONS = (((Action.SCROLL_RIGHT.value | Action.SCROLL_LEFT.value) | Action.SCROLL_UP.value) | Action.SCROLL_DOWN.value);
    private static final float SCROLL_EXTENT_FOR_INFINITY = 100000.0f;
    private static final float SCROLL_POSITION_CAP_FOR_INFINITY = 70000.0f;
    private static final String TAG = "AccessibilityBridge";
    static int systemAction = ((Action.DID_GAIN_ACCESSIBILITY_FOCUS.value & Action.DID_LOSE_ACCESSIBILITY_FOCUS.value) & Action.SHOW_ON_SCREEN.value);
    /* access modifiers changed from: private */
    public final AccessibilityChannel accessibilityChannel;
    private int accessibilityFeatureFlags;
    private SemanticsNode accessibilityFocusedSemanticsNode;
    /* access modifiers changed from: private */
    public final AccessibilityManager accessibilityManager;
    /* access modifiers changed from: private */
    public final AccessibilityChannel.AccessibilityMessageHandler accessibilityMessageHandler;
    private final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
    private final AccessibilityViewEmbedder accessibilityViewEmbedder;
    private boolean accessibleNavigation;
    private final ContentObserver animationScaleObserver;
    /* access modifiers changed from: private */
    public final ContentResolver contentResolver;
    private final Map<Integer, CustomAccessibilityAction> customAccessibilityActions;
    private Integer embeddedAccessibilityFocusedNodeId;
    private Integer embeddedInputFocusedNodeId;
    private final List<Integer> flutterNavigationStack;
    private final Map<Integer, SemanticsNode> flutterSemanticsTree;
    private SemanticsNode hoveredObject;
    private SemanticsNode inputFocusedSemanticsNode;
    /* access modifiers changed from: private */
    public boolean isReleased;
    private SemanticsNode lastInputFocusedSemanticsNode;
    private Integer lastLeftFrameInset;
    /* access modifiers changed from: private */
    public OnAccessibilityChangeListener onAccessibilityChangeListener;
    private final PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate;
    private int previousRouteId;
    /* access modifiers changed from: private */
    public final View rootAccessibilityView;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    /* renamed from: io.flutter.view.AccessibilityBridge$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.flutter.view.AccessibilityBridge$StringAttributeType[] r0 = io.flutter.view.AccessibilityBridge.StringAttributeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType = r0
                io.flutter.view.AccessibilityBridge$StringAttributeType r1 = io.flutter.view.AccessibilityBridge.StringAttributeType.SPELLOUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.view.AccessibilityBridge$StringAttributeType r1 = io.flutter.view.AccessibilityBridge.StringAttributeType.LOCALE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.AnonymousClass5.<clinit>():void");
        }
    }

    private enum AccessibilityFeature {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4),
        BOLD_TEXT(8),
        REDUCE_MOTION(16),
        HIGH_CONTRAST(32),
        ON_OFF_SWITCH_LABELS(64);
        
        final int value;

        private AccessibilityFeature(int i5) {
            this.value = i5;
        }
    }

    public enum Action {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(AccessibilityBridge.MIN_ENGINE_GENERATED_NODE_ID),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152);
        
        public final int value;

        private Action(int i5) {
            this.value = i5;
        }
    }

    private static class CustomAccessibilityAction {
        /* access modifiers changed from: private */
        public String hint;
        /* access modifiers changed from: private */
        public int id = -1;
        /* access modifiers changed from: private */
        public String label;
        /* access modifiers changed from: private */
        public int overrideId = -1;
        /* access modifiers changed from: private */
        public int resourceId = -1;

        CustomAccessibilityAction() {
        }
    }

    enum Flag {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(AccessibilityBridge.MIN_ENGINE_GENERATED_NODE_ID),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_MULTILINE(524288),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216),
        IS_CHECK_STATE_MIXED(33554432),
        HAS_EXPANDED_STATE(67108864),
        IS_EXPANDED(134217728);
        
        final int value;

        private Flag(int i5) {
            this.value = i5;
        }
    }

    private static class LocaleStringAttribute extends StringAttribute {
        String locale;

        private LocaleStringAttribute() {
            super();
        }
    }

    public interface OnAccessibilityChangeListener {
        void onAccessibilityChanged(boolean z4, boolean z5);
    }

    private static class SemanticsNode {
        final AccessibilityBridge accessibilityBridge;
        /* access modifiers changed from: private */
        public int actions;
        private float bottom;
        /* access modifiers changed from: private */
        public List<SemanticsNode> childrenInHitTestOrder = new ArrayList();
        /* access modifiers changed from: private */
        public List<SemanticsNode> childrenInTraversalOrder = new ArrayList();
        /* access modifiers changed from: private */
        public int currentValueLength;
        /* access modifiers changed from: private */
        public List<CustomAccessibilityAction> customAccessibilityActions;
        /* access modifiers changed from: private */
        public String decreasedValue;
        /* access modifiers changed from: private */
        public List<StringAttribute> decreasedValueAttributes;
        private int flags;
        /* access modifiers changed from: private */
        public boolean globalGeometryDirty = true;
        private Rect globalRect;
        private float[] globalTransform;
        /* access modifiers changed from: private */
        public boolean hadPreviousConfig = false;
        private String hint;
        private List<StringAttribute> hintAttributes;
        /* access modifiers changed from: private */
        public int id = -1;
        /* access modifiers changed from: private */
        public String increasedValue;
        /* access modifiers changed from: private */
        public List<StringAttribute> increasedValueAttributes;
        private float[] inverseTransform;
        /* access modifiers changed from: private */
        public boolean inverseTransformDirty = true;
        /* access modifiers changed from: private */
        public String label;
        private List<StringAttribute> labelAttributes;
        private float left;
        /* access modifiers changed from: private */
        public int maxValueLength;
        /* access modifiers changed from: private */
        public CustomAccessibilityAction onLongPressOverride;
        /* access modifiers changed from: private */
        public CustomAccessibilityAction onTapOverride;
        /* access modifiers changed from: private */
        public SemanticsNode parent;
        /* access modifiers changed from: private */
        public int platformViewId;
        private int previousActions;
        private int previousFlags;
        private String previousLabel;
        /* access modifiers changed from: private */
        public int previousNodeId = -1;
        private float previousScrollExtentMax;
        private float previousScrollExtentMin;
        private float previousScrollPosition;
        /* access modifiers changed from: private */
        public int previousTextSelectionBase;
        /* access modifiers changed from: private */
        public int previousTextSelectionExtent;
        /* access modifiers changed from: private */
        public String previousValue;
        private float right;
        /* access modifiers changed from: private */
        public int scrollChildren;
        /* access modifiers changed from: private */
        public float scrollExtentMax;
        /* access modifiers changed from: private */
        public float scrollExtentMin;
        /* access modifiers changed from: private */
        public int scrollIndex;
        /* access modifiers changed from: private */
        public float scrollPosition;
        private TextDirection textDirection;
        /* access modifiers changed from: private */
        public int textSelectionBase;
        /* access modifiers changed from: private */
        public int textSelectionExtent;
        /* access modifiers changed from: private */
        public String tooltip;
        private float top;
        private float[] transform;
        /* access modifiers changed from: private */
        public String value;
        /* access modifiers changed from: private */
        public List<StringAttribute> valueAttributes;

        SemanticsNode(AccessibilityBridge accessibilityBridge2) {
            this.accessibilityBridge = accessibilityBridge2;
        }

        static /* synthetic */ int access$2112(SemanticsNode semanticsNode, int i5) {
            int i6 = semanticsNode.textSelectionExtent + i5;
            semanticsNode.textSelectionExtent = i6;
            return i6;
        }

        static /* synthetic */ int access$2120(SemanticsNode semanticsNode, int i5) {
            int i6 = semanticsNode.textSelectionExtent - i5;
            semanticsNode.textSelectionExtent = i6;
            return i6;
        }

        /* access modifiers changed from: private */
        public void collectRoutes(List<SemanticsNode> list) {
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                list.add(this);
            }
            for (SemanticsNode collectRoutes : this.childrenInTraversalOrder) {
                collectRoutes.collectRoutes(list);
            }
        }

        private SpannableString createSpannableString(String str, List<StringAttribute> list) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            if (list != null) {
                for (StringAttribute next : list) {
                    int i5 = AnonymousClass5.$SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType[next.type.ordinal()];
                    if (i5 == 1) {
                        spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), next.start, next.end, 0);
                    } else if (i5 == 2) {
                        spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((LocaleStringAttribute) next).locale)), next.start, next.end, 0);
                    }
                }
            }
            return spannableString;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
            r2 = r3.previousLabel;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean didChangeLabel() {
            /*
                r3 = this;
                java.lang.String r0 = r3.label
                r1 = 0
                if (r0 != 0) goto L_0x000a
                java.lang.String r2 = r3.previousLabel
                if (r2 != 0) goto L_0x000a
                return r1
            L_0x000a:
                if (r0 == 0) goto L_0x0016
                java.lang.String r2 = r3.previousLabel
                if (r2 == 0) goto L_0x0016
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x0017
            L_0x0016:
                r1 = 1
            L_0x0017:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.SemanticsNode.didChangeLabel():boolean");
        }

        /* access modifiers changed from: private */
        public boolean didScroll() {
            return !Float.isNaN(this.scrollPosition) && !Float.isNaN(this.previousScrollPosition) && this.previousScrollPosition != this.scrollPosition;
        }

        private void ensureInverseTransform() {
            if (this.inverseTransformDirty) {
                this.inverseTransformDirty = false;
                if (this.inverseTransform == null) {
                    this.inverseTransform = new float[16];
                }
                if (!Matrix.invertM(this.inverseTransform, 0, this.transform, 0)) {
                    Arrays.fill(this.inverseTransform, CropImageView.DEFAULT_ASPECT_RATIO);
                }
            }
        }

        private SemanticsNode getAncestor(Predicate<SemanticsNode> predicate) {
            for (SemanticsNode semanticsNode = this.parent; semanticsNode != null; semanticsNode = semanticsNode.parent) {
                if (predicate.test(semanticsNode)) {
                    return semanticsNode;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public Rect getGlobalRect() {
            return this.globalRect;
        }

        private CharSequence getHint() {
            return createSpannableString(this.hint, this.hintAttributes);
        }

        private CharSequence getLabel() {
            return createSpannableString(this.label, this.labelAttributes);
        }

        /* access modifiers changed from: private */
        public String getRouteName() {
            String str;
            if (hasFlag(Flag.NAMES_ROUTE) && (str = this.label) != null && !str.isEmpty()) {
                return this.label;
            }
            for (SemanticsNode routeName : this.childrenInTraversalOrder) {
                String routeName2 = routeName.getRouteName();
                if (routeName2 != null && !routeName2.isEmpty()) {
                    return routeName2;
                }
            }
            return null;
        }

        private List<StringAttribute> getStringAttributesFromBuffer(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
            int i5 = byteBuffer.getInt();
            if (i5 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i5);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = byteBuffer.getInt();
                int i8 = byteBuffer.getInt();
                StringAttributeType stringAttributeType = StringAttributeType.values()[byteBuffer.getInt()];
                int i9 = AnonymousClass5.$SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType[stringAttributeType.ordinal()];
                if (i9 == 1) {
                    byteBuffer.getInt();
                    SpellOutStringAttribute spellOutStringAttribute = new SpellOutStringAttribute();
                    spellOutStringAttribute.start = i7;
                    spellOutStringAttribute.end = i8;
                    spellOutStringAttribute.type = stringAttributeType;
                    arrayList.add(spellOutStringAttribute);
                } else if (i9 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    LocaleStringAttribute localeStringAttribute = new LocaleStringAttribute();
                    localeStringAttribute.start = i7;
                    localeStringAttribute.end = i8;
                    localeStringAttribute.type = stringAttributeType;
                    localeStringAttribute.locale = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(localeStringAttribute);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public CharSequence getTextFieldHint() {
            CharSequence[] charSequenceArr = {getLabel(), getHint()};
            CharSequence charSequence = null;
            for (int i5 = 0; i5 < 2; i5++) {
                CharSequence charSequence2 = charSequenceArr[i5];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    if (charSequence == null || charSequence.length() == 0) {
                        charSequence = charSequence2;
                    } else {
                        charSequence = TextUtils.concat(new CharSequence[]{charSequence, ", ", charSequence2});
                    }
                }
            }
            return charSequence;
        }

        /* access modifiers changed from: private */
        public CharSequence getValue() {
            return createSpannableString(this.value, this.valueAttributes);
        }

        /* access modifiers changed from: private */
        public CharSequence getValueLabelHint() {
            CharSequence[] charSequenceArr = {getValue(), getLabel(), getHint()};
            CharSequence charSequence = null;
            for (int i5 = 0; i5 < 3; i5++) {
                CharSequence charSequence2 = charSequenceArr[i5];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    if (charSequence == null || charSequence.length() == 0) {
                        charSequence = charSequence2;
                    } else {
                        charSequence = TextUtils.concat(new CharSequence[]{charSequence, ", ", charSequence2});
                    }
                }
            }
            return charSequence;
        }

        /* access modifiers changed from: private */
        public boolean hadAction(Action action) {
            return (action.value & this.previousActions) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hadFlag(Flag flag) {
            return (flag.value & this.previousFlags) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hasAction(Action action) {
            return (action.value & this.actions) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hasFlag(Flag flag) {
            return (flag.value & this.flags) != 0;
        }

        /* access modifiers changed from: private */
        public SemanticsNode hitTest(float[] fArr, boolean z4) {
            float f5 = fArr[3];
            boolean z5 = false;
            float f6 = fArr[0] / f5;
            float f7 = fArr[1] / f5;
            if (f6 < this.left || f6 >= this.right || f7 < this.top || f7 >= this.bottom) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (SemanticsNode next : this.childrenInHitTestOrder) {
                if (!next.hasFlag(Flag.IS_HIDDEN)) {
                    next.ensureInverseTransform();
                    Matrix.multiplyMV(fArr2, 0, next.inverseTransform, 0, fArr, 0);
                    SemanticsNode hitTest = next.hitTest(fArr2, z4);
                    if (hitTest != null) {
                        return hitTest;
                    }
                }
            }
            if (z4 && this.platformViewId != -1) {
                z5 = true;
            }
            if (isFocusable() || z5) {
                return this;
            }
            return null;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
            r0 = r4.label;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
            r0 = r4.value;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
            r0 = r4.hint;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isFocusable() {
            /*
                r4 = this;
                io.flutter.view.AccessibilityBridge$Flag r0 = io.flutter.view.AccessibilityBridge.Flag.SCOPES_ROUTE
                boolean r0 = r4.hasFlag(r0)
                r1 = 0
                if (r0 == 0) goto L_0x000a
                return r1
            L_0x000a:
                io.flutter.view.AccessibilityBridge$Flag r0 = io.flutter.view.AccessibilityBridge.Flag.IS_FOCUSABLE
                boolean r0 = r4.hasFlag(r0)
                r2 = 1
                if (r0 == 0) goto L_0x0014
                return r2
            L_0x0014:
                int r0 = r4.actions
                int r3 = io.flutter.view.AccessibilityBridge.SCROLLABLE_ACTIONS
                int r3 = ~r3
                r0 = r0 & r3
                if (r0 != 0) goto L_0x0045
                int r0 = r4.flags
                int r3 = io.flutter.view.AccessibilityBridge.FOCUSABLE_FLAGS
                r0 = r0 & r3
                if (r0 != 0) goto L_0x0045
                java.lang.String r0 = r4.label
                if (r0 == 0) goto L_0x0031
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x0045
            L_0x0031:
                java.lang.String r0 = r4.value
                if (r0 == 0) goto L_0x003b
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x0045
            L_0x003b:
                java.lang.String r0 = r4.hint
                if (r0 == 0) goto L_0x0046
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L_0x0046
            L_0x0045:
                r1 = r2
            L_0x0046:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.SemanticsNode.isFocusable():boolean");
        }

        private void log(String str, boolean z4) {
        }

        private float max(float f5, float f6, float f7, float f8) {
            return Math.max(f5, Math.max(f6, Math.max(f7, f8)));
        }

        private float min(float f5, float f6, float f7, float f8) {
            return Math.min(f5, Math.min(f6, Math.min(f7, f8)));
        }

        /* access modifiers changed from: private */
        public static boolean nullableHasAncestor(SemanticsNode semanticsNode, Predicate<SemanticsNode> predicate) {
            return (semanticsNode == null || semanticsNode.getAncestor(predicate) == null) ? false : true;
        }

        private void transformPoint(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f5 = fArr[3];
            fArr[0] = fArr[0] / f5;
            fArr[1] = fArr[1] / f5;
            fArr[2] = fArr[2] / f5;
            fArr[3] = 0.0f;
        }

        /* access modifiers changed from: private */
        public void updateRecursively(float[] fArr, Set<SemanticsNode> set, boolean z4) {
            set.add(this);
            if (this.globalGeometryDirty) {
                z4 = true;
            }
            if (z4) {
                if (this.globalTransform == null) {
                    this.globalTransform = new float[16];
                }
                if (this.transform == null) {
                    this.transform = new float[16];
                }
                Matrix.multiplyMM(this.globalTransform, 0, fArr, 0, this.transform, 0);
                float[] fArr2 = new float[4];
                fArr2[2] = 0.0f;
                fArr2[3] = 1.0f;
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                fArr2[0] = this.left;
                fArr2[1] = this.top;
                transformPoint(fArr3, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.top;
                transformPoint(fArr4, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.bottom;
                transformPoint(fArr5, this.globalTransform, fArr2);
                fArr2[0] = this.left;
                fArr2[1] = this.bottom;
                transformPoint(fArr6, this.globalTransform, fArr2);
                if (this.globalRect == null) {
                    this.globalRect = new Rect();
                }
                this.globalRect.set(Math.round(min(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(min(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(max(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(max(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.globalGeometryDirty = false;
            }
            int i5 = -1;
            for (SemanticsNode next : this.childrenInTraversalOrder) {
                next.previousNodeId = i5;
                i5 = next.id;
                next.updateRecursively(this.globalTransform, set, z4);
            }
        }

        /* access modifiers changed from: private */
        public void updateWith(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            this.hadPreviousConfig = true;
            this.previousValue = this.value;
            this.previousLabel = this.label;
            this.previousFlags = this.flags;
            this.previousActions = this.actions;
            this.previousTextSelectionBase = this.textSelectionBase;
            this.previousTextSelectionExtent = this.textSelectionExtent;
            this.previousScrollPosition = this.scrollPosition;
            this.previousScrollExtentMax = this.scrollExtentMax;
            this.previousScrollExtentMin = this.scrollExtentMin;
            this.flags = byteBuffer.getInt();
            this.actions = byteBuffer.getInt();
            this.maxValueLength = byteBuffer.getInt();
            this.currentValueLength = byteBuffer.getInt();
            this.textSelectionBase = byteBuffer.getInt();
            this.textSelectionExtent = byteBuffer.getInt();
            this.platformViewId = byteBuffer.getInt();
            this.scrollChildren = byteBuffer.getInt();
            this.scrollIndex = byteBuffer.getInt();
            this.scrollPosition = byteBuffer.getFloat();
            this.scrollExtentMax = byteBuffer.getFloat();
            this.scrollExtentMin = byteBuffer.getFloat();
            int i5 = byteBuffer.getInt();
            this.label = i5 == -1 ? null : strArr[i5];
            this.labelAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i6 = byteBuffer.getInt();
            this.value = i6 == -1 ? null : strArr[i6];
            this.valueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i7 = byteBuffer.getInt();
            this.increasedValue = i7 == -1 ? null : strArr[i7];
            this.increasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i8 = byteBuffer.getInt();
            this.decreasedValue = i8 == -1 ? null : strArr[i8];
            this.decreasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i9 = byteBuffer.getInt();
            this.hint = i9 == -1 ? null : strArr[i9];
            this.hintAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i10 = byteBuffer.getInt();
            this.tooltip = i10 == -1 ? null : strArr[i10];
            this.textDirection = TextDirection.fromInt(byteBuffer.getInt());
            this.left = byteBuffer.getFloat();
            this.top = byteBuffer.getFloat();
            this.right = byteBuffer.getFloat();
            this.bottom = byteBuffer.getFloat();
            if (this.transform == null) {
                this.transform = new float[16];
            }
            for (int i11 = 0; i11 < 16; i11++) {
                this.transform[i11] = byteBuffer.getFloat();
            }
            this.inverseTransformDirty = true;
            this.globalGeometryDirty = true;
            int i12 = byteBuffer.getInt();
            this.childrenInTraversalOrder.clear();
            this.childrenInHitTestOrder.clear();
            for (int i13 = 0; i13 < i12; i13++) {
                SemanticsNode access$6900 = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                access$6900.parent = this;
                this.childrenInTraversalOrder.add(access$6900);
            }
            for (int i14 = 0; i14 < i12; i14++) {
                SemanticsNode access$69002 = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                access$69002.parent = this;
                this.childrenInHitTestOrder.add(access$69002);
            }
            int i15 = byteBuffer.getInt();
            if (i15 == 0) {
                this.customAccessibilityActions = null;
                return;
            }
            List<CustomAccessibilityAction> list = this.customAccessibilityActions;
            if (list == null) {
                this.customAccessibilityActions = new ArrayList(i15);
            } else {
                list.clear();
            }
            for (int i16 = 0; i16 < i15; i16++) {
                CustomAccessibilityAction access$7000 = this.accessibilityBridge.getOrCreateAccessibilityAction(byteBuffer.getInt());
                if (access$7000.overrideId == Action.TAP.value) {
                    this.onTapOverride = access$7000;
                } else if (access$7000.overrideId == Action.LONG_PRESS.value) {
                    this.onLongPressOverride = access$7000;
                } else {
                    this.customAccessibilityActions.add(access$7000);
                }
                this.customAccessibilityActions.add(access$7000);
            }
        }
    }

    private static class SpellOutStringAttribute extends StringAttribute {
        private SpellOutStringAttribute() {
            super();
        }
    }

    private static class StringAttribute {
        int end;
        int start;
        StringAttributeType type;

        private StringAttribute() {
        }
    }

    private enum StringAttributeType {
        SPELLOUT,
        LOCALE
    }

    private enum TextDirection {
        UNKNOWN,
        LTR,
        RTL;

        public static TextDirection fromInt(int i5) {
            return i5 != 1 ? i5 != 2 ? UNKNOWN : LTR : RTL;
        }
    }

    public AccessibilityBridge(View view, AccessibilityChannel accessibilityChannel2, AccessibilityManager accessibilityManager2, ContentResolver contentResolver2, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate2) {
        this(view, accessibilityChannel2, accessibilityManager2, contentResolver2, new AccessibilityViewEmbedder(view, MIN_ENGINE_GENERATED_NODE_ID), platformViewsAccessibilityDelegate2);
    }

    public AccessibilityBridge(View view, AccessibilityChannel accessibilityChannel2, final AccessibilityManager accessibilityManager2, ContentResolver contentResolver2, AccessibilityViewEmbedder accessibilityViewEmbedder2, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate2) {
        this.flutterSemanticsTree = new HashMap();
        this.customAccessibilityActions = new HashMap();
        this.accessibilityFeatureFlags = 0;
        this.flutterNavigationStack = new ArrayList();
        this.previousRouteId = 0;
        this.lastLeftFrameInset = 0;
        this.accessibleNavigation = false;
        this.isReleased = false;
        this.accessibilityMessageHandler = new AccessibilityChannel.AccessibilityMessageHandler() {
            public void announce(String str) {
                AccessibilityBridge.this.rootAccessibilityView.announceForAccessibility(str);
            }

            public void onFocus(int i5) {
                AccessibilityBridge.this.sendAccessibilityEvent(i5, 8);
            }

            public void onLongPress(int i5) {
                AccessibilityBridge.this.sendAccessibilityEvent(i5, 2);
            }

            public void onTap(int i5) {
                AccessibilityBridge.this.sendAccessibilityEvent(i5, 1);
            }

            public void onTooltip(String str) {
                if (Build.VERSION.SDK_INT < 28) {
                    AccessibilityEvent access$200 = AccessibilityBridge.this.obtainAccessibilityEvent(0, 32);
                    access$200.getText().add(str);
                    AccessibilityBridge.this.sendAccessibilityEvent(access$200);
                }
            }

            public void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                AccessibilityBridge.this.updateCustomAccessibilityActions(byteBuffer, strArr);
            }

            public void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                for (ByteBuffer order : byteBufferArr) {
                    order.order(ByteOrder.LITTLE_ENDIAN);
                }
                AccessibilityBridge.this.updateSemantics(byteBuffer, strArr, byteBufferArr);
            }
        };
        AnonymousClass2 r12 = new AccessibilityManager.AccessibilityStateChangeListener() {
            public void onAccessibilityStateChanged(boolean z4) {
                if (!AccessibilityBridge.this.isReleased) {
                    AccessibilityBridge accessibilityBridge = AccessibilityBridge.this;
                    if (z4) {
                        accessibilityBridge.accessibilityChannel.setAccessibilityMessageHandler(AccessibilityBridge.this.accessibilityMessageHandler);
                        AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityEnabled();
                    } else {
                        accessibilityBridge.setAccessibleNavigation(false);
                        AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler((AccessibilityChannel.AccessibilityMessageHandler) null);
                        AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityDisabled();
                    }
                    if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                        AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(z4, AccessibilityBridge.this.accessibilityManager.isTouchExplorationEnabled());
                    }
                }
            }
        };
        this.accessibilityStateChangeListener = r12;
        AnonymousClass3 r22 = new ContentObserver(new Handler()) {
            public void onChange(boolean z4) {
                onChange(z4, (Uri) null);
            }

            public void onChange(boolean z4, Uri uri) {
                if (!AccessibilityBridge.this.isReleased) {
                    String string = Settings.Global.getString(AccessibilityBridge.this.contentResolver, "transition_animation_scale");
                    if (string != null && string.equals("0")) {
                        AccessibilityBridge.access$1176(AccessibilityBridge.this, AccessibilityFeature.DISABLE_ANIMATIONS.value);
                    } else {
                        AccessibilityBridge.access$1172(AccessibilityBridge.this, ~AccessibilityFeature.DISABLE_ANIMATIONS.value);
                    }
                    AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
                }
            }
        };
        this.animationScaleObserver = r22;
        this.rootAccessibilityView = view;
        this.accessibilityChannel = accessibilityChannel2;
        this.accessibilityManager = accessibilityManager2;
        this.contentResolver = contentResolver2;
        this.accessibilityViewEmbedder = accessibilityViewEmbedder2;
        this.platformViewsAccessibilityDelegate = platformViewsAccessibilityDelegate2;
        r12.onAccessibilityStateChanged(accessibilityManager2.isEnabled());
        accessibilityManager2.addAccessibilityStateChangeListener(r12);
        int i5 = Build.VERSION.SDK_INT;
        AnonymousClass4 r6 = new AccessibilityManager.TouchExplorationStateChangeListener() {
            public void onTouchExplorationStateChanged(boolean z4) {
                if (!AccessibilityBridge.this.isReleased) {
                    if (!z4) {
                        AccessibilityBridge.this.setAccessibleNavigation(false);
                        AccessibilityBridge.this.onTouchExplorationExit();
                    }
                    if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                        AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(accessibilityManager2.isEnabled(), z4);
                    }
                }
            }
        };
        this.touchExplorationStateChangeListener = r6;
        r6.onTouchExplorationStateChanged(accessibilityManager2.isTouchExplorationEnabled());
        accessibilityManager2.addTouchExplorationStateChangeListener(r6);
        r22.onChange(false);
        contentResolver2.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, r22);
        if (i5 >= 31) {
            setBoldTextFlag();
        }
        platformViewsAccessibilityDelegate2.attachAccessibilityBridge(this);
    }

    static /* synthetic */ int access$1172(AccessibilityBridge accessibilityBridge, int i5) {
        int i6 = i5 & accessibilityBridge.accessibilityFeatureFlags;
        accessibilityBridge.accessibilityFeatureFlags = i6;
        return i6;
    }

    static /* synthetic */ int access$1176(AccessibilityBridge accessibilityBridge, int i5) {
        int i6 = i5 | accessibilityBridge.accessibilityFeatureFlags;
        accessibilityBridge.accessibilityFeatureFlags = i6;
        return i6;
    }

    private AccessibilityEvent createTextChangedEvent(int i5, String str, String str2) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i5, 16);
        obtainAccessibilityEvent.setBeforeText(str);
        obtainAccessibilityEvent.getText().add(str2);
        int i6 = 0;
        while (i6 < str.length() && i6 < str2.length() && str.charAt(i6) == str2.charAt(i6)) {
            i6++;
        }
        if (i6 >= str.length() && i6 >= str2.length()) {
            return null;
        }
        obtainAccessibilityEvent.setFromIndex(i6);
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i6 && length2 >= i6 && str.charAt(length) == str2.charAt(length2)) {
            length--;
            length2--;
        }
        obtainAccessibilityEvent.setRemovedCount((length - i6) + 1);
        obtainAccessibilityEvent.setAddedCount((length2 - i6) + 1);
        return obtainAccessibilityEvent;
    }

    private boolean doesLayoutInDisplayCutoutModeRequireLeftInset() {
        Activity activity = ViewUtils.getActivity(this.rootAccessibilityView.getContext());
        if (activity == null || activity.getWindow() == null) {
            return false;
        }
        int i5 = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
        return i5 == 2 || i5 == 0;
    }

    private Rect getBoundsInScreen(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.rootAccessibilityView.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    /* access modifiers changed from: private */
    public CustomAccessibilityAction getOrCreateAccessibilityAction(int i5) {
        CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i5));
        if (customAccessibilityAction != null) {
            return customAccessibilityAction;
        }
        CustomAccessibilityAction customAccessibilityAction2 = new CustomAccessibilityAction();
        int unused = customAccessibilityAction2.id = i5;
        int unused2 = customAccessibilityAction2.resourceId = FIRST_RESOURCE_ID + i5;
        this.customAccessibilityActions.put(Integer.valueOf(i5), customAccessibilityAction2);
        return customAccessibilityAction2;
    }

    /* access modifiers changed from: private */
    public SemanticsNode getOrCreateSemanticsNode(int i5) {
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i5));
        if (semanticsNode != null) {
            return semanticsNode;
        }
        SemanticsNode semanticsNode2 = new SemanticsNode(this);
        int unused = semanticsNode2.id = i5;
        this.flutterSemanticsTree.put(Integer.valueOf(i5), semanticsNode2);
        return semanticsNode2;
    }

    private SemanticsNode getRootSemanticsNode() {
        return this.flutterSemanticsTree.get(0);
    }

    private void handleTouchExploration(float f5, float f6, boolean z4) {
        SemanticsNode access$4600;
        if (!this.flutterSemanticsTree.isEmpty() && (access$4600 = getRootSemanticsNode().hitTest(new float[]{f5, f6, 0.0f, 1.0f}, z4)) != this.hoveredObject) {
            if (access$4600 != null) {
                sendAccessibilityEvent(access$4600.id, 128);
            }
            SemanticsNode semanticsNode = this.hoveredObject;
            if (semanticsNode != null) {
                sendAccessibilityEvent(semanticsNode.id, 256);
            }
            this.hoveredObject = access$4600;
        }
    }

    private boolean isImportant(SemanticsNode semanticsNode) {
        if (semanticsNode.hasFlag(Flag.SCOPES_ROUTE)) {
            return false;
        }
        if (semanticsNode.getValueLabelHint() != null) {
            return true;
        }
        return (semanticsNode.actions & (~systemAction)) != 0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$shouldSetCollectionInfo$0(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
        return semanticsNode2 == semanticsNode;
    }

    /* access modifiers changed from: private */
    public AccessibilityEvent obtainAccessibilityEvent(int i5, int i6) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i6);
        obtainAccessibilityEvent.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtainAccessibilityEvent.setSource(this.rootAccessibilityView, i5);
        return obtainAccessibilityEvent;
    }

    /* access modifiers changed from: private */
    public void onTouchExplorationExit() {
        SemanticsNode semanticsNode = this.hoveredObject;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 256);
            this.hoveredObject = null;
        }
    }

    private void onWindowNameChange(SemanticsNode semanticsNode) {
        String access$6700 = semanticsNode.getRouteName();
        if (access$6700 == null) {
            access$6700 = " ";
        }
        if (Build.VERSION.SDK_INT >= 28) {
            setAccessibilityPaneTitle(access$6700);
            return;
        }
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode.id, 32);
        obtainAccessibilityEvent.getText().add(access$6700);
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    private boolean performCursorMoveAction(SemanticsNode semanticsNode, int i5, Bundle bundle, boolean z4) {
        int i6 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z5 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int access$2000 = semanticsNode.textSelectionBase;
        int access$2100 = semanticsNode.textSelectionExtent;
        predictCursorMovement(semanticsNode, i6, z4, z5);
        if (!(access$2000 == semanticsNode.textSelectionBase && access$2100 == semanticsNode.textSelectionExtent)) {
            String access$2400 = semanticsNode.value != null ? semanticsNode.value : BuildConfig.FLAVOR;
            AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode.id, 8192);
            obtainAccessibilityEvent.getText().add(access$2400);
            obtainAccessibilityEvent.setFromIndex(semanticsNode.textSelectionBase);
            obtainAccessibilityEvent.setToIndex(semanticsNode.textSelectionExtent);
            obtainAccessibilityEvent.setItemCount(access$2400.length());
            sendAccessibilityEvent(obtainAccessibilityEvent);
        }
        if (i6 == 1) {
            if (z4) {
                Action action = Action.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (semanticsNode.hasAction(action)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i5, action, Boolean.valueOf(z5));
                    return true;
                }
            }
            if (z4) {
                return false;
            }
            Action action2 = Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
            if (!semanticsNode.hasAction(action2)) {
                return false;
            }
            this.accessibilityChannel.dispatchSemanticsAction(i5, action2, Boolean.valueOf(z5));
            return true;
        } else if (i6 != 2) {
            return i6 == 4 || i6 == 8 || i6 == 16;
        } else {
            if (z4) {
                Action action3 = Action.MOVE_CURSOR_FORWARD_BY_WORD;
                if (semanticsNode.hasAction(action3)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i5, action3, Boolean.valueOf(z5));
                    return true;
                }
            }
            if (z4) {
                return false;
            }
            Action action4 = Action.MOVE_CURSOR_BACKWARD_BY_WORD;
            if (!semanticsNode.hasAction(action4)) {
                return false;
            }
            this.accessibilityChannel.dispatchSemanticsAction(i5, action4, Boolean.valueOf(z5));
            return true;
        }
    }

    private boolean performSetText(SemanticsNode semanticsNode, int i5, Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? BuildConfig.FLAVOR : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        this.accessibilityChannel.dispatchSemanticsAction(i5, Action.SET_TEXT, string);
        String unused = semanticsNode.value = string;
        List unused2 = semanticsNode.valueAttributes = null;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        if (r6 != false) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        if (r5.find() != false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
        io.flutter.view.AccessibilityBridge.SemanticsNode.access$2112(r4, r5.start(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008d, code lost:
        if (r5.find() != false) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008f, code lost:
        r5 = r5.start(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c1, code lost:
        if (r5.find() != false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e6, code lost:
        if (r5.find() != false) goto L_0x008f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void predictCursorMovement(io.flutter.view.AccessibilityBridge.SemanticsNode r4, int r5, boolean r6, boolean r7) {
        /*
            r3 = this;
            int r0 = r4.textSelectionExtent
            if (r0 < 0) goto L_0x0111
            int r0 = r4.textSelectionBase
            if (r0 >= 0) goto L_0x000e
            goto L_0x0111
        L_0x000e:
            r0 = 1
            if (r5 == r0) goto L_0x00e9
            r1 = 2
            r2 = 0
            if (r5 == r1) goto L_0x0094
            r1 = 4
            if (r5 == r1) goto L_0x0036
            r0 = 8
            if (r5 == r0) goto L_0x0022
            r0 = 16
            if (r5 == r0) goto L_0x0022
            goto L_0x0108
        L_0x0022:
            if (r6 == 0) goto L_0x0031
        L_0x0024:
            java.lang.String r5 = r4.value
            int r5 = r5.length()
        L_0x002c:
            int unused = r4.textSelectionExtent = r5
            goto L_0x0108
        L_0x0031:
            int unused = r4.textSelectionExtent = r2
            goto L_0x0108
        L_0x0036:
            if (r6 == 0) goto L_0x006b
            int r5 = r4.textSelectionExtent
            java.lang.String r1 = r4.value
            int r1 = r1.length()
            if (r5 >= r1) goto L_0x006b
            java.lang.String r5 = "(?!^)(\\n)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = r4.value
            int r1 = r4.textSelectionExtent
            java.lang.String r6 = r6.substring(r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L_0x0024
        L_0x0062:
            int r5 = r5.start(r0)
            io.flutter.view.AccessibilityBridge.SemanticsNode.access$2112(r4, r5)
            goto L_0x0108
        L_0x006b:
            if (r6 != 0) goto L_0x0108
            int r5 = r4.textSelectionExtent
            if (r5 <= 0) goto L_0x0108
            java.lang.String r5 = "(?s:.*)(\\n)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = r4.value
            int r1 = r4.textSelectionExtent
            java.lang.String r6 = r6.substring(r2, r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L_0x0031
        L_0x008f:
            int r5 = r5.start(r0)
            goto L_0x002c
        L_0x0094:
            if (r6 == 0) goto L_0x00c4
            int r5 = r4.textSelectionExtent
            java.lang.String r1 = r4.value
            int r1 = r1.length()
            if (r5 >= r1) goto L_0x00c4
            java.lang.String r5 = "\\p{L}(\\b)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = r4.value
            int r1 = r4.textSelectionExtent
            java.lang.String r6 = r6.substring(r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            r5.find()
            boolean r6 = r5.find()
            if (r6 == 0) goto L_0x0024
            goto L_0x0062
        L_0x00c4:
            if (r6 != 0) goto L_0x0108
            int r5 = r4.textSelectionExtent
            if (r5 <= 0) goto L_0x0108
            java.lang.String r5 = "(?s:.*)(\\b)\\p{L}"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = r4.value
            int r1 = r4.textSelectionExtent
            java.lang.String r6 = r6.substring(r2, r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L_0x0108
            goto L_0x008f
        L_0x00e9:
            if (r6 == 0) goto L_0x00fd
            int r5 = r4.textSelectionExtent
            java.lang.String r1 = r4.value
            int r1 = r1.length()
            if (r5 >= r1) goto L_0x00fd
            io.flutter.view.AccessibilityBridge.SemanticsNode.access$2112(r4, r0)
            goto L_0x0108
        L_0x00fd:
            if (r6 != 0) goto L_0x0108
            int r5 = r4.textSelectionExtent
            if (r5 <= 0) goto L_0x0108
            io.flutter.view.AccessibilityBridge.SemanticsNode.access$2120(r4, r0)
        L_0x0108:
            if (r7 != 0) goto L_0x0111
            int r5 = r4.textSelectionExtent
            int unused = r4.textSelectionBase = r5
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.predictCursorMovement(io.flutter.view.AccessibilityBridge$SemanticsNode, int, boolean, boolean):void");
    }

    /* access modifiers changed from: private */
    public void sendAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (this.accessibilityManager.isEnabled()) {
            this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, accessibilityEvent);
        }
    }

    /* access modifiers changed from: private */
    public void sendLatestAccessibilityFlagsToFlutter() {
        this.accessibilityChannel.setAccessibilityFeatures(this.accessibilityFeatureFlags);
    }

    private void sendWindowContentChangeEvent(int i5) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i5, 2048);
        obtainAccessibilityEvent.setContentChangeTypes(1);
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    private void setAccessibilityPaneTitle(String str) {
        this.rootAccessibilityView.setAccessibilityPaneTitle(str);
    }

    /* access modifiers changed from: private */
    public void setAccessibleNavigation(boolean z4) {
        if (this.accessibleNavigation != z4) {
            this.accessibleNavigation = z4;
            this.accessibilityFeatureFlags = z4 ? this.accessibilityFeatureFlags | AccessibilityFeature.ACCESSIBLE_NAVIGATION.value : this.accessibilityFeatureFlags & (~AccessibilityFeature.ACCESSIBLE_NAVIGATION.value);
            sendLatestAccessibilityFlagsToFlutter();
        }
    }

    private void setBoldTextFlag() {
        View view = this.rootAccessibilityView;
        if (view != null && view.getResources() != null) {
            int i5 = this.rootAccessibilityView.getResources().getConfiguration().fontWeightAdjustment;
            this.accessibilityFeatureFlags = i5 != Integer.MAX_VALUE && i5 >= BOLD_TEXT_WEIGHT_ADJUSTMENT ? this.accessibilityFeatureFlags | AccessibilityFeature.BOLD_TEXT.value : this.accessibilityFeatureFlags & AccessibilityFeature.BOLD_TEXT.value;
            sendLatestAccessibilityFlagsToFlutter();
        }
    }

    private boolean shouldSetCollectionInfo(SemanticsNode semanticsNode) {
        return semanticsNode.scrollChildren > 0 && (SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new d(semanticsNode)) || !SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new e()));
    }

    private void willRemoveSemanticsNode(SemanticsNode semanticsNode) {
        View platformViewById;
        Integer num;
        SemanticsNode unused = semanticsNode.parent = null;
        if (!(semanticsNode.platformViewId == -1 || (num = this.embeddedAccessibilityFocusedNodeId) == null || this.accessibilityViewEmbedder.platformViewOfNode(num.intValue()) != this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode.platformViewId))) {
            sendAccessibilityEvent(this.embeddedAccessibilityFocusedNodeId.intValue(), MIN_ENGINE_GENERATED_NODE_ID);
            this.embeddedAccessibilityFocusedNodeId = null;
        }
        if (!(semanticsNode.platformViewId == -1 || (platformViewById = this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode.platformViewId)) == null)) {
            platformViewById.setImportantForAccessibility(4);
        }
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 == semanticsNode) {
            sendAccessibilityEvent(semanticsNode2.id, MIN_ENGINE_GENERATED_NODE_ID);
            this.accessibilityFocusedSemanticsNode = null;
        }
        if (this.inputFocusedSemanticsNode == semanticsNode) {
            this.inputFocusedSemanticsNode = null;
        }
        if (this.hoveredObject == semanticsNode) {
            this.hoveredObject = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:216:0x040e  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0421  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0424  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0462  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int r14) {
        /*
            r13 = this;
            r0 = 1
            r13.setAccessibleNavigation(r0)
            r1 = 65536(0x10000, float:9.18355E-41)
            if (r14 < r1) goto L_0x000f
            io.flutter.view.AccessibilityViewEmbedder r0 = r13.accessibilityViewEmbedder
            android.view.accessibility.AccessibilityNodeInfo r14 = r0.createAccessibilityNodeInfo(r14)
            return r14
        L_0x000f:
            r2 = 24
            r3 = -1
            r4 = 0
            if (r14 != r3) goto L_0x0039
            android.view.View r14 = r13.rootAccessibilityView
            android.view.accessibility.AccessibilityNodeInfo r14 = r13.obtainAccessibilityNodeInfo(r14)
            android.view.View r0 = r13.rootAccessibilityView
            r0.onInitializeAccessibilityNodeInfo(r14)
            java.util.Map<java.lang.Integer, io.flutter.view.AccessibilityBridge$SemanticsNode> r0 = r13.flutterSemanticsTree
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0031
            android.view.View r0 = r13.rootAccessibilityView
            r14.addChild(r0, r4)
        L_0x0031:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L_0x0038
            r14.setImportantForAccessibility(r4)
        L_0x0038:
            return r14
        L_0x0039:
            java.util.Map<java.lang.Integer, io.flutter.view.AccessibilityBridge$SemanticsNode> r5 = r13.flutterSemanticsTree
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            java.lang.Object r5 = r5.get(r6)
            io.flutter.view.AccessibilityBridge$SemanticsNode r5 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r5
            r6 = 0
            if (r5 != 0) goto L_0x0049
            return r6
        L_0x0049:
            int r7 = r5.platformViewId
            if (r7 == r3) goto L_0x0077
            io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate r7 = r13.platformViewsAccessibilityDelegate
            int r8 = r5.platformViewId
            boolean r7 = r7.usesVirtualDisplay(r8)
            if (r7 == 0) goto L_0x0077
            io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate r14 = r13.platformViewsAccessibilityDelegate
            int r0 = r5.platformViewId
            android.view.View r14 = r14.getPlatformViewById(r0)
            if (r14 != 0) goto L_0x0068
            return r6
        L_0x0068:
            android.graphics.Rect r0 = r5.getGlobalRect()
            io.flutter.view.AccessibilityViewEmbedder r1 = r13.accessibilityViewEmbedder
            int r2 = r5.id
            android.view.accessibility.AccessibilityNodeInfo r14 = r1.getRootNode(r14, r2, r0)
            return r14
        L_0x0077:
            android.view.View r6 = r13.rootAccessibilityView
            android.view.accessibility.AccessibilityNodeInfo r6 = r13.obtainAccessibilityNodeInfo(r6, r14)
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r2) goto L_0x0088
            boolean r2 = r13.isImportant(r5)
            r6.setImportantForAccessibility(r2)
        L_0x0088:
            java.lang.String r2 = ""
            r6.setViewIdResourceName(r2)
            android.view.View r8 = r13.rootAccessibilityView
            android.content.Context r8 = r8.getContext()
            java.lang.String r8 = r8.getPackageName()
            r6.setPackageName(r8)
            java.lang.String r8 = "android.view.View"
            r6.setClassName(r8)
            android.view.View r8 = r13.rootAccessibilityView
            r6.setSource(r8, r14)
            boolean r8 = r5.isFocusable()
            r6.setFocusable(r8)
            io.flutter.view.AccessibilityBridge$SemanticsNode r8 = r13.inputFocusedSemanticsNode
            if (r8 == 0) goto L_0x00bb
            int r8 = r8.id
            if (r8 != r14) goto L_0x00b7
            r8 = r0
            goto L_0x00b8
        L_0x00b7:
            r8 = r4
        L_0x00b8:
            r6.setFocused(r8)
        L_0x00bb:
            io.flutter.view.AccessibilityBridge$SemanticsNode r8 = r13.accessibilityFocusedSemanticsNode
            if (r8 == 0) goto L_0x00cb
            int r8 = r8.id
            if (r8 != r14) goto L_0x00c7
            r8 = r0
            goto L_0x00c8
        L_0x00c7:
            r8 = r4
        L_0x00c8:
            r6.setAccessibilityFocused(r8)
        L_0x00cb:
            io.flutter.view.AccessibilityBridge$Flag r8 = io.flutter.view.AccessibilityBridge.Flag.IS_TEXT_FIELD
            boolean r9 = r5.hasFlag(r8)
            if (r9 == 0) goto L_0x017a
            io.flutter.view.AccessibilityBridge$Flag r9 = io.flutter.view.AccessibilityBridge.Flag.IS_OBSCURED
            boolean r9 = r5.hasFlag(r9)
            r6.setPassword(r9)
            io.flutter.view.AccessibilityBridge$Flag r9 = io.flutter.view.AccessibilityBridge.Flag.IS_READ_ONLY
            boolean r10 = r5.hasFlag(r9)
            if (r10 != 0) goto L_0x00e9
            java.lang.String r10 = "android.widget.EditText"
            r6.setClassName(r10)
        L_0x00e9:
            boolean r9 = r5.hasFlag(r9)
            r9 = r9 ^ r0
            r6.setEditable(r9)
            int r9 = r5.textSelectionBase
            if (r9 == r3) goto L_0x0108
            int r9 = r5.textSelectionExtent
            if (r9 == r3) goto L_0x0108
            int r9 = r5.textSelectionBase
            int r10 = r5.textSelectionExtent
            r6.setTextSelection(r9, r10)
        L_0x0108:
            io.flutter.view.AccessibilityBridge$SemanticsNode r9 = r13.accessibilityFocusedSemanticsNode
            if (r9 == 0) goto L_0x0115
            int r9 = r9.id
            if (r9 != r14) goto L_0x0115
            r6.setLiveRegion(r0)
        L_0x0115:
            io.flutter.view.AccessibilityBridge$Action r9 = io.flutter.view.AccessibilityBridge.Action.MOVE_CURSOR_FORWARD_BY_CHARACTER
            boolean r9 = r5.hasAction(r9)
            r10 = 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0124
            r6.addAction(r10)
            r9 = r0
            goto L_0x0125
        L_0x0124:
            r9 = r4
        L_0x0125:
            io.flutter.view.AccessibilityBridge$Action r11 = io.flutter.view.AccessibilityBridge.Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER
            boolean r11 = r5.hasAction(r11)
            r12 = 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0134
            r6.addAction(r12)
            r9 = r9 | 1
        L_0x0134:
            io.flutter.view.AccessibilityBridge$Action r11 = io.flutter.view.AccessibilityBridge.Action.MOVE_CURSOR_FORWARD_BY_WORD
            boolean r11 = r5.hasAction(r11)
            if (r11 == 0) goto L_0x0141
            r6.addAction(r10)
            r9 = r9 | 2
        L_0x0141:
            io.flutter.view.AccessibilityBridge$Action r10 = io.flutter.view.AccessibilityBridge.Action.MOVE_CURSOR_BACKWARD_BY_WORD
            boolean r10 = r5.hasAction(r10)
            if (r10 == 0) goto L_0x014e
            r6.addAction(r12)
            r9 = r9 | 2
        L_0x014e:
            r6.setMovementGranularities(r9)
            int r9 = r5.maxValueLength
            if (r9 < 0) goto L_0x017a
            java.lang.String r9 = r5.value
            if (r9 != 0) goto L_0x015f
            r9 = r4
            goto L_0x0167
        L_0x015f:
            java.lang.String r9 = r5.value
            int r9 = r9.length()
        L_0x0167:
            int unused = r5.currentValueLength
            int unused = r5.maxValueLength
            int r10 = r5.currentValueLength
            int r9 = r9 - r10
            int r10 = r5.maxValueLength
            int r9 = r9 + r10
            r6.setMaxTextLength(r9)
        L_0x017a:
            io.flutter.view.AccessibilityBridge$Action r9 = io.flutter.view.AccessibilityBridge.Action.SET_SELECTION
            boolean r9 = r5.hasAction(r9)
            if (r9 == 0) goto L_0x0187
            r9 = 131072(0x20000, float:1.83671E-40)
            r6.addAction(r9)
        L_0x0187:
            io.flutter.view.AccessibilityBridge$Action r9 = io.flutter.view.AccessibilityBridge.Action.COPY
            boolean r9 = r5.hasAction(r9)
            if (r9 == 0) goto L_0x0194
            r9 = 16384(0x4000, float:2.2959E-41)
            r6.addAction(r9)
        L_0x0194:
            io.flutter.view.AccessibilityBridge$Action r9 = io.flutter.view.AccessibilityBridge.Action.CUT
            boolean r9 = r5.hasAction(r9)
            if (r9 == 0) goto L_0x019f
            r6.addAction(r1)
        L_0x019f:
            io.flutter.view.AccessibilityBridge$Action r1 = io.flutter.view.AccessibilityBridge.Action.PASTE
            boolean r1 = r5.hasAction(r1)
            if (r1 == 0) goto L_0x01ad
            r1 = 32768(0x8000, float:4.5918E-41)
            r6.addAction(r1)
        L_0x01ad:
            io.flutter.view.AccessibilityBridge$Action r1 = io.flutter.view.AccessibilityBridge.Action.SET_TEXT
            boolean r1 = r5.hasAction(r1)
            if (r1 == 0) goto L_0x01ba
            r1 = 2097152(0x200000, float:2.938736E-39)
            r6.addAction(r1)
        L_0x01ba:
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.IS_BUTTON
            boolean r1 = r5.hasFlag(r1)
            if (r1 != 0) goto L_0x01ca
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.IS_LINK
            boolean r1 = r5.hasFlag(r1)
            if (r1 == 0) goto L_0x01cf
        L_0x01ca:
            java.lang.String r1 = "android.widget.Button"
            r6.setClassName(r1)
        L_0x01cf:
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.IS_IMAGE
            boolean r1 = r5.hasFlag(r1)
            if (r1 == 0) goto L_0x01dc
            java.lang.String r1 = "android.widget.ImageView"
            r6.setClassName(r1)
        L_0x01dc:
            io.flutter.view.AccessibilityBridge$Action r1 = io.flutter.view.AccessibilityBridge.Action.DISMISS
            boolean r1 = r5.hasAction(r1)
            if (r1 == 0) goto L_0x01ec
            r6.setDismissable(r0)
            r1 = 1048576(0x100000, float:1.469368E-39)
            r6.addAction(r1)
        L_0x01ec:
            io.flutter.view.AccessibilityBridge$SemanticsNode r1 = r5.parent
            if (r1 == 0) goto L_0x0200
            android.view.View r1 = r13.rootAccessibilityView
            io.flutter.view.AccessibilityBridge$SemanticsNode r9 = r5.parent
            int r9 = r9.id
            r6.setParent(r1, r9)
            goto L_0x0205
        L_0x0200:
            android.view.View r1 = r13.rootAccessibilityView
            r6.setParent(r1)
        L_0x0205:
            int r1 = r5.previousNodeId
            if (r1 == r3) goto L_0x0214
            android.view.View r1 = r13.rootAccessibilityView
            int r9 = r5.previousNodeId
            r6.setTraversalAfter(r1, r9)
        L_0x0214:
            android.graphics.Rect r1 = r5.getGlobalRect()
            io.flutter.view.AccessibilityBridge$SemanticsNode r9 = r5.parent
            if (r9 == 0) goto L_0x0238
            io.flutter.view.AccessibilityBridge$SemanticsNode r9 = r5.parent
            android.graphics.Rect r9 = r9.getGlobalRect()
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>(r1)
            int r11 = r9.left
            int r11 = -r11
            int r9 = r9.top
            int r9 = -r9
            r10.offset(r11, r9)
            r6.setBoundsInParent(r10)
            goto L_0x023b
        L_0x0238:
            r6.setBoundsInParent(r1)
        L_0x023b:
            android.graphics.Rect r1 = r13.getBoundsInScreen(r1)
            r6.setBoundsInScreen(r1)
            r6.setVisibleToUser(r0)
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.HAS_ENABLED_STATE
            boolean r1 = r5.hasFlag(r1)
            if (r1 == 0) goto L_0x0258
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.IS_ENABLED
            boolean r1 = r5.hasFlag(r1)
            if (r1 == 0) goto L_0x0256
            goto L_0x0258
        L_0x0256:
            r1 = r4
            goto L_0x0259
        L_0x0258:
            r1 = r0
        L_0x0259:
            r6.setEnabled(r1)
            io.flutter.view.AccessibilityBridge$Action r1 = io.flutter.view.AccessibilityBridge.Action.TAP
            boolean r1 = r5.hasAction(r1)
            if (r1 == 0) goto L_0x0283
            io.flutter.view.AccessibilityBridge$CustomAccessibilityAction r1 = r5.onTapOverride
            r9 = 16
            if (r1 == 0) goto L_0x027d
            android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction r1 = new android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
            io.flutter.view.AccessibilityBridge$CustomAccessibilityAction r10 = r5.onTapOverride
            java.lang.String r10 = r10.hint
            r1.<init>(r9, r10)
            r6.addAction(r1)
            goto L_0x0280
        L_0x027d:
            r6.addAction(r9)
        L_0x0280:
            r6.setClickable(r0)
        L_0x0283:
            io.flutter.view.AccessibilityBridge$Action r1 = io.flutter.view.AccessibilityBridge.Action.LONG_PRESS
            boolean r1 = r5.hasAction(r1)
            if (r1 == 0) goto L_0x02aa
            io.flutter.view.AccessibilityBridge$CustomAccessibilityAction r1 = r5.onLongPressOverride
            r9 = 32
            if (r1 == 0) goto L_0x02a4
            android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction r1 = new android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
            io.flutter.view.AccessibilityBridge$CustomAccessibilityAction r10 = r5.onLongPressOverride
            java.lang.String r10 = r10.hint
            r1.<init>(r9, r10)
            r6.addAction(r1)
            goto L_0x02a7
        L_0x02a4:
            r6.addAction(r9)
        L_0x02a7:
            r6.setLongClickable(r0)
        L_0x02aa:
            io.flutter.view.AccessibilityBridge$Action r1 = io.flutter.view.AccessibilityBridge.Action.SCROLL_LEFT
            boolean r9 = r5.hasAction(r1)
            r10 = 8192(0x2000, float:1.14794E-41)
            r11 = 4096(0x1000, float:5.74E-42)
            if (r9 != 0) goto L_0x02ce
            io.flutter.view.AccessibilityBridge$Action r9 = io.flutter.view.AccessibilityBridge.Action.SCROLL_UP
            boolean r9 = r5.hasAction(r9)
            if (r9 != 0) goto L_0x02ce
            io.flutter.view.AccessibilityBridge$Action r9 = io.flutter.view.AccessibilityBridge.Action.SCROLL_RIGHT
            boolean r9 = r5.hasAction(r9)
            if (r9 != 0) goto L_0x02ce
            io.flutter.view.AccessibilityBridge$Action r9 = io.flutter.view.AccessibilityBridge.Action.SCROLL_DOWN
            boolean r9 = r5.hasAction(r9)
            if (r9 == 0) goto L_0x0335
        L_0x02ce:
            r6.setScrollable(r0)
            io.flutter.view.AccessibilityBridge$Flag r9 = io.flutter.view.AccessibilityBridge.Flag.HAS_IMPLICIT_SCROLLING
            boolean r9 = r5.hasFlag(r9)
            if (r9 == 0) goto L_0x0311
            boolean r9 = r5.hasAction(r1)
            if (r9 != 0) goto L_0x02fa
            io.flutter.view.AccessibilityBridge$Action r9 = io.flutter.view.AccessibilityBridge.Action.SCROLL_RIGHT
            boolean r9 = r5.hasAction(r9)
            if (r9 == 0) goto L_0x02e8
            goto L_0x02fa
        L_0x02e8:
            boolean r9 = r13.shouldSetCollectionInfo(r5)
            if (r9 == 0) goto L_0x02f7
            int r9 = r5.scrollChildren
            android.view.accessibility.AccessibilityNodeInfo$CollectionInfo r9 = android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.obtain(r9, r4, r4)
            goto L_0x0308
        L_0x02f7:
            java.lang.String r9 = "android.widget.ScrollView"
            goto L_0x030e
        L_0x02fa:
            boolean r9 = r13.shouldSetCollectionInfo(r5)
            if (r9 == 0) goto L_0x030c
            int r9 = r5.scrollChildren
            android.view.accessibility.AccessibilityNodeInfo$CollectionInfo r9 = android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.obtain(r4, r9, r4)
        L_0x0308:
            r6.setCollectionInfo(r9)
            goto L_0x0311
        L_0x030c:
            java.lang.String r9 = "android.widget.HorizontalScrollView"
        L_0x030e:
            r6.setClassName(r9)
        L_0x0311:
            boolean r1 = r5.hasAction(r1)
            if (r1 != 0) goto L_0x031f
            io.flutter.view.AccessibilityBridge$Action r1 = io.flutter.view.AccessibilityBridge.Action.SCROLL_UP
            boolean r1 = r5.hasAction(r1)
            if (r1 == 0) goto L_0x0322
        L_0x031f:
            r6.addAction(r11)
        L_0x0322:
            io.flutter.view.AccessibilityBridge$Action r1 = io.flutter.view.AccessibilityBridge.Action.SCROLL_RIGHT
            boolean r1 = r5.hasAction(r1)
            if (r1 != 0) goto L_0x0332
            io.flutter.view.AccessibilityBridge$Action r1 = io.flutter.view.AccessibilityBridge.Action.SCROLL_DOWN
            boolean r1 = r5.hasAction(r1)
            if (r1 == 0) goto L_0x0335
        L_0x0332:
            r6.addAction(r10)
        L_0x0335:
            io.flutter.view.AccessibilityBridge$Action r1 = io.flutter.view.AccessibilityBridge.Action.INCREASE
            boolean r9 = r5.hasAction(r1)
            if (r9 != 0) goto L_0x0345
            io.flutter.view.AccessibilityBridge$Action r9 = io.flutter.view.AccessibilityBridge.Action.DECREASE
            boolean r9 = r5.hasAction(r9)
            if (r9 == 0) goto L_0x035e
        L_0x0345:
            java.lang.String r9 = "android.widget.SeekBar"
            r6.setClassName(r9)
            boolean r1 = r5.hasAction(r1)
            if (r1 == 0) goto L_0x0353
            r6.addAction(r11)
        L_0x0353:
            io.flutter.view.AccessibilityBridge$Action r1 = io.flutter.view.AccessibilityBridge.Action.DECREASE
            boolean r1 = r5.hasAction(r1)
            if (r1 == 0) goto L_0x035e
            r6.addAction(r10)
        L_0x035e:
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.IS_LIVE_REGION
            boolean r1 = r5.hasFlag(r1)
            if (r1 == 0) goto L_0x0369
            r6.setLiveRegion(r0)
        L_0x0369:
            boolean r1 = r5.hasFlag(r8)
            r8 = 28
            if (r1 == 0) goto L_0x0382
            java.lang.CharSequence r1 = r5.getValue()
            r6.setText(r1)
            if (r7 < r8) goto L_0x03b6
            java.lang.CharSequence r1 = r5.getTextFieldHint()
            r6.setHintText(r1)
            goto L_0x03b6
        L_0x0382:
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.SCOPES_ROUTE
            boolean r1 = r5.hasFlag(r1)
            if (r1 != 0) goto L_0x03b6
            java.lang.CharSequence r1 = r5.getValueLabelHint()
            if (r7 >= r8) goto L_0x03b1
            java.lang.String r9 = r5.tooltip
            if (r9 == 0) goto L_0x03b1
            if (r1 == 0) goto L_0x0399
            r2 = r1
        L_0x0399:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r2 = "\n"
            r1.append(r2)
            java.lang.String r2 = r5.tooltip
            r1.append(r2)
            java.lang.String r1 = r1.toString()
        L_0x03b1:
            if (r1 == 0) goto L_0x03b6
            r6.setContentDescription(r1)
        L_0x03b6:
            if (r7 < r8) goto L_0x03c5
            java.lang.String r1 = r5.tooltip
            if (r1 == 0) goto L_0x03c5
            java.lang.String r1 = r5.tooltip
            r6.setTooltipText(r1)
        L_0x03c5:
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.HAS_CHECKED_STATE
            boolean r1 = r5.hasFlag(r1)
            io.flutter.view.AccessibilityBridge$Flag r2 = io.flutter.view.AccessibilityBridge.Flag.HAS_TOGGLED_STATE
            boolean r2 = r5.hasFlag(r2)
            if (r1 != 0) goto L_0x03d7
            if (r2 == 0) goto L_0x03d6
            goto L_0x03d7
        L_0x03d6:
            r0 = r4
        L_0x03d7:
            r6.setCheckable(r0)
            if (r1 == 0) goto L_0x03f3
            io.flutter.view.AccessibilityBridge$Flag r0 = io.flutter.view.AccessibilityBridge.Flag.IS_CHECKED
            boolean r0 = r5.hasFlag(r0)
            r6.setChecked(r0)
            io.flutter.view.AccessibilityBridge$Flag r0 = io.flutter.view.AccessibilityBridge.Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP
            boolean r0 = r5.hasFlag(r0)
            if (r0 == 0) goto L_0x03f0
            java.lang.String r0 = "android.widget.RadioButton"
            goto L_0x0400
        L_0x03f0:
            java.lang.String r0 = "android.widget.CheckBox"
            goto L_0x0400
        L_0x03f3:
            if (r2 == 0) goto L_0x0403
            io.flutter.view.AccessibilityBridge$Flag r0 = io.flutter.view.AccessibilityBridge.Flag.IS_TOGGLED
            boolean r0 = r5.hasFlag(r0)
            r6.setChecked(r0)
            java.lang.String r0 = "android.widget.Switch"
        L_0x0400:
            r6.setClassName(r0)
        L_0x0403:
            io.flutter.view.AccessibilityBridge$Flag r0 = io.flutter.view.AccessibilityBridge.Flag.IS_SELECTED
            boolean r0 = r5.hasFlag(r0)
            r6.setSelected(r0)
            if (r7 < r8) goto L_0x0417
            io.flutter.view.AccessibilityBridge$Flag r0 = io.flutter.view.AccessibilityBridge.Flag.IS_HEADER
            boolean r0 = r5.hasFlag(r0)
            r6.setHeading(r0)
        L_0x0417:
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = r13.accessibilityFocusedSemanticsNode
            if (r0 == 0) goto L_0x0424
            int r0 = r0.id
            if (r0 != r14) goto L_0x0424
            r14 = 128(0x80, float:1.794E-43)
            goto L_0x0426
        L_0x0424:
            r14 = 64
        L_0x0426:
            r6.addAction(r14)
            java.util.List r14 = r5.customAccessibilityActions
            if (r14 == 0) goto L_0x0454
            java.util.List r14 = r5.customAccessibilityActions
            java.util.Iterator r14 = r14.iterator()
        L_0x0437:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x0454
            java.lang.Object r0 = r14.next()
            io.flutter.view.AccessibilityBridge$CustomAccessibilityAction r0 = (io.flutter.view.AccessibilityBridge.CustomAccessibilityAction) r0
            android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction r1 = new android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
            int r2 = r0.resourceId
            java.lang.String r0 = r0.label
            r1.<init>(r2, r0)
            r6.addAction(r1)
            goto L_0x0437
        L_0x0454:
            java.util.List r14 = r5.childrenInTraversalOrder
            java.util.Iterator r14 = r14.iterator()
        L_0x045c:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x049b
            java.lang.Object r0 = r14.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r0
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.IS_HIDDEN
            boolean r1 = r0.hasFlag(r1)
            if (r1 == 0) goto L_0x0471
            goto L_0x045c
        L_0x0471:
            int r1 = r0.platformViewId
            if (r1 == r3) goto L_0x0491
            io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate r1 = r13.platformViewsAccessibilityDelegate
            int r2 = r0.platformViewId
            android.view.View r1 = r1.getPlatformViewById(r2)
            io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate r2 = r13.platformViewsAccessibilityDelegate
            int r4 = r0.platformViewId
            boolean r2 = r2.usesVirtualDisplay(r4)
            if (r2 != 0) goto L_0x0491
            r6.addChild(r1)
            goto L_0x045c
        L_0x0491:
            android.view.View r1 = r13.rootAccessibilityView
            int r0 = r0.id
            r6.addChild(r1, r0)
            goto L_0x045c
        L_0x049b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.createAccessibilityNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    public boolean externalViewRequestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (!this.accessibilityViewEmbedder.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = this.accessibilityViewEmbedder.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.embeddedInputFocusedNodeId = recordFlutterId;
            this.inputFocusedSemanticsNode = null;
            return true;
        } else if (eventType == 128) {
            this.hoveredObject = null;
            return true;
        } else if (eventType == 32768) {
            this.embeddedAccessibilityFocusedNodeId = recordFlutterId;
            this.accessibilityFocusedSemanticsNode = null;
            return true;
        } else if (eventType != MIN_ENGINE_GENERATED_NODE_ID) {
            return true;
        } else {
            this.embeddedInputFocusedNodeId = null;
            this.embeddedAccessibilityFocusedNodeId = null;
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r2 != null) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.accessibility.AccessibilityNodeInfo findFocus(int r2) {
        /*
            r1 = this;
            r0 = 1
            if (r2 == r0) goto L_0x0007
            r0 = 2
            if (r2 == r0) goto L_0x001d
            goto L_0x0027
        L_0x0007:
            io.flutter.view.AccessibilityBridge$SemanticsNode r2 = r1.inputFocusedSemanticsNode
            if (r2 == 0) goto L_0x0014
        L_0x000b:
            int r2 = r2.id
        L_0x000f:
            android.view.accessibility.AccessibilityNodeInfo r2 = r1.createAccessibilityNodeInfo(r2)
            return r2
        L_0x0014:
            java.lang.Integer r2 = r1.embeddedInputFocusedNodeId
            if (r2 == 0) goto L_0x001d
        L_0x0018:
            int r2 = r2.intValue()
            goto L_0x000f
        L_0x001d:
            io.flutter.view.AccessibilityBridge$SemanticsNode r2 = r1.accessibilityFocusedSemanticsNode
            if (r2 == 0) goto L_0x0022
            goto L_0x000b
        L_0x0022:
            java.lang.Integer r2 = r1.embeddedAccessibilityFocusedNodeId
            if (r2 == 0) goto L_0x0027
            goto L_0x0018
        L_0x0027:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.findFocus(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    public boolean getAccessibleNavigation() {
        return this.accessibleNavigation;
    }

    public int getHoveredObjectId() {
        return this.hoveredObject.id;
    }

    public boolean isAccessibilityEnabled() {
        return this.accessibilityManager.isEnabled();
    }

    public boolean isTouchExplorationEnabled() {
        return this.accessibilityManager.isTouchExplorationEnabled();
    }

    public AccessibilityEvent obtainAccessibilityEvent(int i5) {
        return AccessibilityEvent.obtain(i5);
    }

    public AccessibilityNodeInfo obtainAccessibilityNodeInfo(View view) {
        return AccessibilityNodeInfo.obtain(view);
    }

    public AccessibilityNodeInfo obtainAccessibilityNodeInfo(View view, int i5) {
        return AccessibilityNodeInfo.obtain(view, i5);
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent) {
        return onAccessibilityHoverEvent(motionEvent, false);
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent, boolean z4) {
        if (!this.accessibilityManager.isTouchExplorationEnabled() || this.flutterSemanticsTree.isEmpty()) {
            return false;
        }
        SemanticsNode access$4600 = getRootSemanticsNode().hitTest(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z4);
        if (access$4600 == null || access$4600.platformViewId == -1) {
            if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
                handleTouchExploration(motionEvent.getX(), motionEvent.getY(), z4);
            } else if (motionEvent.getAction() == 10) {
                onTouchExplorationExit();
            } else {
                Log.d("flutter", "unexpected accessibility hover event: " + motionEvent);
                return false;
            }
            return true;
        } else if (z4) {
            return false;
        } else {
            return this.accessibilityViewEmbedder.onAccessibilityHoverEvent(access$4600.id, motionEvent);
        }
    }

    public boolean performAction(int i5, int i6, Bundle bundle) {
        int i7;
        if (i5 >= MIN_ENGINE_GENERATED_NODE_ID) {
            boolean performAction = this.accessibilityViewEmbedder.performAction(i5, i6, bundle);
            if (performAction && i6 == 128) {
                this.embeddedAccessibilityFocusedNodeId = null;
            }
            return performAction;
        }
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i5));
        boolean z4 = false;
        if (semanticsNode == null) {
            return false;
        }
        switch (i6) {
            case 16:
                this.accessibilityChannel.dispatchSemanticsAction(i5, Action.TAP);
                return true;
            case R.styleable.AppCompatTheme_actionOverflowButtonStyle:
                this.accessibilityChannel.dispatchSemanticsAction(i5, Action.LONG_PRESS);
                return true;
            case R.styleable.AppCompatTheme_dividerHorizontal:
                if (this.accessibilityFocusedSemanticsNode == null) {
                    this.rootAccessibilityView.invalidate();
                }
                this.accessibilityFocusedSemanticsNode = semanticsNode;
                this.accessibilityChannel.dispatchSemanticsAction(i5, Action.DID_GAIN_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i5, 32768);
                if (semanticsNode.hasAction(Action.INCREASE) || semanticsNode.hasAction(Action.DECREASE)) {
                    sendAccessibilityEvent(i5, 4);
                }
                return true;
            case 128:
                SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
                if (semanticsNode2 != null && semanticsNode2.id == i5) {
                    this.accessibilityFocusedSemanticsNode = null;
                }
                Integer num = this.embeddedAccessibilityFocusedNodeId;
                if (num != null && num.intValue() == i5) {
                    this.embeddedAccessibilityFocusedNodeId = null;
                }
                this.accessibilityChannel.dispatchSemanticsAction(i5, Action.DID_LOSE_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i5, MIN_ENGINE_GENERATED_NODE_ID);
                return true;
            case 256:
                return performCursorMoveAction(semanticsNode, i5, bundle, true);
            case 512:
                return performCursorMoveAction(semanticsNode, i5, bundle, false);
            case 4096:
                Action action = Action.SCROLL_UP;
                if (!semanticsNode.hasAction(action)) {
                    action = Action.SCROLL_LEFT;
                    if (!semanticsNode.hasAction(action)) {
                        action = Action.INCREASE;
                        if (!semanticsNode.hasAction(action)) {
                            return false;
                        }
                        String unused = semanticsNode.value = semanticsNode.increasedValue;
                        List unused2 = semanticsNode.valueAttributes = semanticsNode.increasedValueAttributes;
                        sendAccessibilityEvent(i5, 4);
                    }
                }
                this.accessibilityChannel.dispatchSemanticsAction(i5, action);
                return true;
            case 8192:
                Action action2 = Action.SCROLL_DOWN;
                if (!semanticsNode.hasAction(action2)) {
                    action2 = Action.SCROLL_RIGHT;
                    if (!semanticsNode.hasAction(action2)) {
                        action2 = Action.DECREASE;
                        if (!semanticsNode.hasAction(action2)) {
                            return false;
                        }
                        String unused3 = semanticsNode.value = semanticsNode.decreasedValue;
                        List unused4 = semanticsNode.valueAttributes = semanticsNode.decreasedValueAttributes;
                        sendAccessibilityEvent(i5, 4);
                    }
                }
                this.accessibilityChannel.dispatchSemanticsAction(i5, action2);
                return true;
            case 16384:
                this.accessibilityChannel.dispatchSemanticsAction(i5, Action.COPY);
                return true;
            case 32768:
                this.accessibilityChannel.dispatchSemanticsAction(i5, Action.PASTE);
                return true;
            case MIN_ENGINE_GENERATED_NODE_ID /*65536*/:
                this.accessibilityChannel.dispatchSemanticsAction(i5, Action.CUT);
                return true;
            case 131072:
                HashMap hashMap = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    z4 = true;
                }
                if (z4) {
                    hashMap.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    i7 = bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
                } else {
                    hashMap.put("base", Integer.valueOf(semanticsNode.textSelectionExtent));
                    i7 = semanticsNode.textSelectionExtent;
                }
                hashMap.put("extent", Integer.valueOf(i7));
                this.accessibilityChannel.dispatchSemanticsAction(i5, Action.SET_SELECTION, hashMap);
                SemanticsNode semanticsNode3 = this.flutterSemanticsTree.get(Integer.valueOf(i5));
                int unused5 = semanticsNode3.textSelectionBase = ((Integer) hashMap.get("base")).intValue();
                int unused6 = semanticsNode3.textSelectionExtent = ((Integer) hashMap.get("extent")).intValue();
                return true;
            case 1048576:
                this.accessibilityChannel.dispatchSemanticsAction(i5, Action.DISMISS);
                return true;
            case 2097152:
                return performSetText(semanticsNode, i5, bundle);
            case ACTION_SHOW_ON_SCREEN /*16908342*/:
                this.accessibilityChannel.dispatchSemanticsAction(i5, Action.SHOW_ON_SCREEN);
                return true;
            default:
                CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i6 - FIRST_RESOURCE_ID));
                if (customAccessibilityAction == null) {
                    return false;
                }
                this.accessibilityChannel.dispatchSemanticsAction(i5, Action.CUSTOM_ACTION, Integer.valueOf(customAccessibilityAction.id));
                return true;
        }
    }

    public void release() {
        this.isReleased = true;
        this.platformViewsAccessibilityDelegate.detachAccessibilityBridge();
        setOnAccessibilityChangeListener((OnAccessibilityChangeListener) null);
        this.accessibilityManager.removeAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        this.accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
        this.accessibilityChannel.setAccessibilityMessageHandler((AccessibilityChannel.AccessibilityMessageHandler) null);
    }

    public void reset() {
        this.flutterSemanticsTree.clear();
        SemanticsNode semanticsNode = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, MIN_ENGINE_GENERATED_NODE_ID);
        }
        this.accessibilityFocusedSemanticsNode = null;
        this.hoveredObject = null;
        sendWindowContentChangeEvent(0);
    }

    public void sendAccessibilityEvent(int i5, int i6) {
        if (this.accessibilityManager.isEnabled()) {
            sendAccessibilityEvent(obtainAccessibilityEvent(i5, i6));
        }
    }

    public void setOnAccessibilityChangeListener(OnAccessibilityChangeListener onAccessibilityChangeListener2) {
        this.onAccessibilityChangeListener = onAccessibilityChangeListener2;
    }

    /* access modifiers changed from: package-private */
    public void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            CustomAccessibilityAction orCreateAccessibilityAction = getOrCreateAccessibilityAction(byteBuffer.getInt());
            int unused = orCreateAccessibilityAction.overrideId = byteBuffer.getInt();
            int i5 = byteBuffer.getInt();
            String str = null;
            String unused2 = orCreateAccessibilityAction.label = i5 == -1 ? null : strArr[i5];
            int i6 = byteBuffer.getInt();
            if (i6 != -1) {
                str = strArr[i6];
            }
            String unused3 = orCreateAccessibilityAction.hint = str;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: io.flutter.view.AccessibilityBridge$SemanticsNode} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateSemantics(java.nio.ByteBuffer r9, java.lang.String[] r10, java.nio.ByteBuffer[] r11) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0005:
            boolean r1 = r9.hasRemaining()
            r2 = 0
            if (r1 == 0) goto L_0x0056
            int r1 = r9.getInt()
            io.flutter.view.AccessibilityBridge$SemanticsNode r1 = r8.getOrCreateSemanticsNode(r1)
            r1.updateWith(r9, r10, r11)
            io.flutter.view.AccessibilityBridge$Flag r3 = io.flutter.view.AccessibilityBridge.Flag.IS_HIDDEN
            boolean r3 = r1.hasFlag(r3)
            if (r3 == 0) goto L_0x0020
            goto L_0x0005
        L_0x0020:
            io.flutter.view.AccessibilityBridge$Flag r3 = io.flutter.view.AccessibilityBridge.Flag.IS_FOCUSED
            boolean r3 = r1.hasFlag(r3)
            if (r3 == 0) goto L_0x002a
            r8.inputFocusedSemanticsNode = r1
        L_0x002a:
            boolean r3 = r1.hadPreviousConfig
            if (r3 == 0) goto L_0x0033
            r0.add(r1)
        L_0x0033:
            int r3 = r1.platformViewId
            r4 = -1
            if (r3 == r4) goto L_0x0005
            io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate r3 = r8.platformViewsAccessibilityDelegate
            int r4 = r1.platformViewId
            boolean r3 = r3.usesVirtualDisplay(r4)
            if (r3 != 0) goto L_0x0005
            io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate r3 = r8.platformViewsAccessibilityDelegate
            int r1 = r1.platformViewId
            android.view.View r1 = r3.getPlatformViewById(r1)
            if (r1 == 0) goto L_0x0005
            r1.setImportantForAccessibility(r2)
            goto L_0x0005
        L_0x0056:
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            io.flutter.view.AccessibilityBridge$SemanticsNode r10 = r8.getRootSemanticsNode()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r1 = 1
            if (r10 == 0) goto L_0x00b3
            r3 = 16
            float[] r3 = new float[r3]
            android.opengl.Matrix.setIdentityM(r3, r2)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 28
            if (r4 < r5) goto L_0x0079
            boolean r4 = r8.doesLayoutInDisplayCutoutModeRequireLeftInset()
            goto L_0x007a
        L_0x0079:
            r4 = r1
        L_0x007a:
            if (r4 == 0) goto L_0x00ad
            android.view.View r4 = r8.rootAccessibilityView
            android.view.WindowInsets r4 = r4.getRootWindowInsets()
            if (r4 == 0) goto L_0x00ad
            java.lang.Integer r5 = r8.lastLeftFrameInset
            int r6 = r4.getSystemWindowInsetLeft()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x009a
            boolean unused = r10.globalGeometryDirty = r1
            boolean unused = r10.inverseTransformDirty = r1
        L_0x009a:
            int r4 = r4.getSystemWindowInsetLeft()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r8.lastLeftFrameInset = r4
            int r4 = r4.intValue()
            float r4 = (float) r4
            r5 = 0
            android.opengl.Matrix.translateM(r3, r2, r4, r5, r5)
        L_0x00ad:
            r10.updateRecursively(r3, r9, r2)
            r10.collectRoutes(r11)
        L_0x00b3:
            java.util.Iterator r10 = r11.iterator()
            r3 = 0
            r4 = r3
        L_0x00b9:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto L_0x00d7
            java.lang.Object r5 = r10.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r5 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r5
            java.util.List<java.lang.Integer> r6 = r8.flutterNavigationStack
            int r7 = r5.id
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L_0x00b9
            r4 = r5
            goto L_0x00b9
        L_0x00d7:
            if (r4 != 0) goto L_0x00eb
            int r10 = r11.size()
            if (r10 <= 0) goto L_0x00eb
            int r10 = r11.size()
            int r10 = r10 - r1
            java.lang.Object r10 = r11.get(r10)
            r4 = r10
            io.flutter.view.AccessibilityBridge$SemanticsNode r4 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r4
        L_0x00eb:
            if (r4 == 0) goto L_0x010a
            int r10 = r4.id
            int r5 = r8.previousRouteId
            if (r10 != r5) goto L_0x0101
            int r10 = r11.size()
            java.util.List<java.lang.Integer> r5 = r8.flutterNavigationStack
            int r5 = r5.size()
            if (r10 == r5) goto L_0x010a
        L_0x0101:
            int r10 = r4.id
            r8.previousRouteId = r10
            r8.onWindowNameChange(r4)
        L_0x010a:
            java.util.List<java.lang.Integer> r10 = r8.flutterNavigationStack
            r10.clear()
            java.util.Iterator r10 = r11.iterator()
        L_0x0113:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x012d
            java.lang.Object r11 = r10.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r11
            java.util.List<java.lang.Integer> r4 = r8.flutterNavigationStack
            int r11 = r11.id
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r4.add(r11)
            goto L_0x0113
        L_0x012d:
            java.util.Map<java.lang.Integer, io.flutter.view.AccessibilityBridge$SemanticsNode> r10 = r8.flutterSemanticsTree
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0137:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0156
            java.lang.Object r11 = r10.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r11 = r11.getValue()
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r11
            boolean r4 = r9.contains(r11)
            if (r4 != 0) goto L_0x0137
            r8.willRemoveSemanticsNode(r11)
            r10.remove()
            goto L_0x0137
        L_0x0156:
            r8.sendWindowContentChangeEvent(r2)
            java.util.Iterator r9 = r0.iterator()
        L_0x015d:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0336
            java.lang.Object r10 = r9.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r10 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r10
            boolean r11 = r10.didScroll()
            if (r11 == 0) goto L_0x0228
            int r11 = r10.id
            r0 = 4096(0x1000, float:5.74E-42)
            android.view.accessibility.AccessibilityEvent r11 = r8.obtainAccessibilityEvent(r11, r0)
            float r0 = r10.scrollPosition
            float r4 = r10.scrollExtentMax
            float r5 = r10.scrollExtentMax
            boolean r5 = java.lang.Float.isInfinite(r5)
            r6 = 1200142336(0x4788b800, float:70000.0)
            r7 = 1203982336(0x47c35000, float:100000.0)
            if (r5 == 0) goto L_0x0197
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0196
            r0 = r6
        L_0x0196:
            r4 = r7
        L_0x0197:
            float r5 = r10.scrollExtentMin
            boolean r5 = java.lang.Float.isInfinite(r5)
            if (r5 == 0) goto L_0x01ac
            float r4 = r4 + r7
            r5 = -947341312(0xffffffffc788b800, float:-70000.0)
            int r6 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r6 >= 0) goto L_0x01aa
            r0 = r5
        L_0x01aa:
            float r0 = r0 + r7
            goto L_0x01b6
        L_0x01ac:
            float r5 = r10.scrollExtentMin
            float r4 = r4 - r5
            float r5 = r10.scrollExtentMin
            float r0 = r0 - r5
        L_0x01b6:
            io.flutter.view.AccessibilityBridge$Action r5 = io.flutter.view.AccessibilityBridge.Action.SCROLL_UP
            boolean r5 = r10.hadAction(r5)
            if (r5 != 0) goto L_0x01e0
            io.flutter.view.AccessibilityBridge$Action r5 = io.flutter.view.AccessibilityBridge.Action.SCROLL_DOWN
            boolean r5 = r10.hadAction(r5)
            if (r5 == 0) goto L_0x01c7
            goto L_0x01e0
        L_0x01c7:
            io.flutter.view.AccessibilityBridge$Action r5 = io.flutter.view.AccessibilityBridge.Action.SCROLL_LEFT
            boolean r5 = r10.hadAction(r5)
            if (r5 != 0) goto L_0x01d7
            io.flutter.view.AccessibilityBridge$Action r5 = io.flutter.view.AccessibilityBridge.Action.SCROLL_RIGHT
            boolean r5 = r10.hadAction(r5)
            if (r5 == 0) goto L_0x01e8
        L_0x01d7:
            int r0 = (int) r0
            r11.setScrollX(r0)
            int r0 = (int) r4
            r11.setMaxScrollX(r0)
            goto L_0x01e8
        L_0x01e0:
            int r0 = (int) r0
            r11.setScrollY(r0)
            int r0 = (int) r4
            r11.setMaxScrollY(r0)
        L_0x01e8:
            int r0 = r10.scrollChildren
            if (r0 <= 0) goto L_0x0225
            int r0 = r10.scrollChildren
            r11.setItemCount(r0)
            int r0 = r10.scrollIndex
            r11.setFromIndex(r0)
            java.util.List r0 = r10.childrenInHitTestOrder
            java.util.Iterator r0 = r0.iterator()
            r4 = r2
        L_0x0205:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x021c
            java.lang.Object r5 = r0.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r5 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r5
            io.flutter.view.AccessibilityBridge$Flag r6 = io.flutter.view.AccessibilityBridge.Flag.IS_HIDDEN
            boolean r5 = r5.hasFlag(r6)
            if (r5 != 0) goto L_0x0205
            int r4 = r4 + 1
            goto L_0x0205
        L_0x021c:
            int r0 = r10.scrollIndex
            int r0 = r0 + r4
            int r0 = r0 - r1
            r11.setToIndex(r0)
        L_0x0225:
            r8.sendAccessibilityEvent(r11)
        L_0x0228:
            io.flutter.view.AccessibilityBridge$Flag r11 = io.flutter.view.AccessibilityBridge.Flag.IS_LIVE_REGION
            boolean r11 = r10.hasFlag(r11)
            if (r11 == 0) goto L_0x023d
            boolean r11 = r10.didChangeLabel()
            if (r11 == 0) goto L_0x023d
            int r11 = r10.id
            r8.sendWindowContentChangeEvent(r11)
        L_0x023d:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.accessibilityFocusedSemanticsNode
            if (r11 == 0) goto L_0x0270
            int r11 = r11.id
            int r0 = r10.id
            if (r11 != r0) goto L_0x0270
            io.flutter.view.AccessibilityBridge$Flag r11 = io.flutter.view.AccessibilityBridge.Flag.IS_SELECTED
            boolean r0 = r10.hadFlag(r11)
            if (r0 != 0) goto L_0x0270
            boolean r11 = r10.hasFlag(r11)
            if (r11 == 0) goto L_0x0270
            int r11 = r10.id
            r0 = 4
            android.view.accessibility.AccessibilityEvent r11 = r8.obtainAccessibilityEvent(r11, r0)
            java.util.List r0 = r11.getText()
            java.lang.String r4 = r10.label
            r0.add(r4)
            r8.sendAccessibilityEvent(r11)
        L_0x0270:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.inputFocusedSemanticsNode
            if (r11 == 0) goto L_0x02a0
            int r11 = r11.id
            int r0 = r10.id
            if (r11 != r0) goto L_0x02a0
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.lastInputFocusedSemanticsNode
            if (r11 == 0) goto L_0x028e
            int r11 = r11.id
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = r8.inputFocusedSemanticsNode
            int r0 = r0.id
            if (r11 == r0) goto L_0x02a0
        L_0x028e:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.inputFocusedSemanticsNode
            r8.lastInputFocusedSemanticsNode = r11
            int r11 = r10.id
            r0 = 8
            android.view.accessibility.AccessibilityEvent r11 = r8.obtainAccessibilityEvent(r11, r0)
            r8.sendAccessibilityEvent(r11)
            goto L_0x02a6
        L_0x02a0:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.inputFocusedSemanticsNode
            if (r11 != 0) goto L_0x02a6
            r8.lastInputFocusedSemanticsNode = r3
        L_0x02a6:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.inputFocusedSemanticsNode
            if (r11 == 0) goto L_0x015d
            int r11 = r11.id
            int r0 = r10.id
            if (r11 != r0) goto L_0x015d
            io.flutter.view.AccessibilityBridge$Flag r11 = io.flutter.view.AccessibilityBridge.Flag.IS_TEXT_FIELD
            boolean r0 = r10.hadFlag(r11)
            if (r0 == 0) goto L_0x015d
            boolean r11 = r10.hasFlag(r11)
            if (r11 == 0) goto L_0x015d
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.accessibilityFocusedSemanticsNode
            if (r11 == 0) goto L_0x02d2
            int r11 = r11.id
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = r8.inputFocusedSemanticsNode
            int r0 = r0.id
            if (r11 != r0) goto L_0x015d
        L_0x02d2:
            java.lang.String r11 = r10.previousValue
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x02df
            java.lang.String r11 = r10.previousValue
            goto L_0x02e0
        L_0x02df:
            r11 = r0
        L_0x02e0:
            java.lang.String r4 = r10.value
            if (r4 == 0) goto L_0x02ea
            java.lang.String r0 = r10.value
        L_0x02ea:
            int r4 = r10.id
            android.view.accessibility.AccessibilityEvent r11 = r8.createTextChangedEvent(r4, r11, r0)
            if (r11 == 0) goto L_0x02f7
            r8.sendAccessibilityEvent(r11)
        L_0x02f7:
            int r11 = r10.previousTextSelectionBase
            int r4 = r10.textSelectionBase
            if (r11 != r4) goto L_0x030b
            int r11 = r10.previousTextSelectionExtent
            int r4 = r10.textSelectionExtent
            if (r11 == r4) goto L_0x015d
        L_0x030b:
            int r11 = r10.id
            r4 = 8192(0x2000, float:1.14794E-41)
            android.view.accessibility.AccessibilityEvent r11 = r8.obtainAccessibilityEvent(r11, r4)
            java.util.List r4 = r11.getText()
            r4.add(r0)
            int r4 = r10.textSelectionBase
            r11.setFromIndex(r4)
            int r10 = r10.textSelectionExtent
            r11.setToIndex(r10)
            int r10 = r0.length()
            r11.setItemCount(r10)
            r8.sendAccessibilityEvent(r11)
            goto L_0x015d
        L_0x0336:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.updateSemantics(java.nio.ByteBuffer, java.lang.String[], java.nio.ByteBuffer[]):void");
    }
}
