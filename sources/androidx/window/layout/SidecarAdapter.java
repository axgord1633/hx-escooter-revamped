package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public final class SidecarAdapter {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final String TAG = SidecarAdapter.class.getSimpleName();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final int getRawSidecarDevicePosture(SidecarDeviceState sidecarDeviceState) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            try {
                return sidecarDeviceState.posture;
            } catch (NoSuchFieldError unused) {
                Object invoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
                if (invoke != null) {
                    return ((Integer) invoke).intValue();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return 0;
            }
        }

        public final int getSidecarDevicePosture$window_release(SidecarDeviceState sidecarDeviceState) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            int rawSidecarDevicePosture = getRawSidecarDevicePosture(sidecarDeviceState);
            if (rawSidecarDevicePosture < 0 || rawSidecarDevicePosture > 4) {
                return 0;
            }
            return rawSidecarDevicePosture;
        }

        public final List<SidecarDisplayFeature> getSidecarDisplayFeatures(SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            k.e(sidecarWindowLayoutInfo, "info");
            try {
                List<SidecarDisplayFeature> list = sidecarWindowLayoutInfo.displayFeatures;
                return list == null ? n.d() : list;
            } catch (NoSuchFieldError unused) {
                Object invoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(sidecarWindowLayoutInfo, new Object[0]);
                if (invoke != null) {
                    return (List) invoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return n.d();
            }
        }

        public final void setSidecarDevicePosture(SidecarDeviceState sidecarDeviceState, int i5) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            try {
                sidecarDeviceState.posture = i5;
            } catch (NoSuchFieldError unused) {
                Class<SidecarDeviceState> cls = SidecarDeviceState.class;
                try {
                    cls.getMethod("setPosture", new Class[]{Integer.TYPE}).invoke(sidecarDeviceState, new Object[]{Integer.valueOf(i5)});
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                }
            }
        }

        public final void setSidecarDisplayFeatures(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, List<SidecarDisplayFeature> list) {
            k.e(sidecarWindowLayoutInfo, "info");
            k.e(list, "displayFeatures");
            try {
                sidecarWindowLayoutInfo.displayFeatures = list;
            } catch (NoSuchFieldError unused) {
                try {
                    SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", new Class[]{List.class}).invoke(sidecarWindowLayoutInfo, new Object[]{list});
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                }
            }
        }

        public final DisplayFeature translate$window_release(SidecarDisplayFeature sidecarDisplayFeature, SidecarDeviceState sidecarDeviceState) {
            HardwareFoldingFeature.Type type;
            FoldingFeature.State state;
            k.e(sidecarDisplayFeature, "feature");
            k.e(sidecarDeviceState, "deviceState");
            Rect rect = sidecarDisplayFeature.getRect();
            k.d(rect, "feature.rect");
            if (rect.width() == 0 && rect.height() == 0) {
                return null;
            }
            if (sidecarDisplayFeature.getType() == 1 && rect.width() != 0 && rect.height() != 0) {
                return null;
            }
            if ((sidecarDisplayFeature.getType() == 2 || sidecarDisplayFeature.getType() == 1) && rect.left != 0 && rect.top != 0) {
                return null;
            }
            int type2 = sidecarDisplayFeature.getType();
            if (type2 == 1) {
                type = HardwareFoldingFeature.Type.Companion.getFOLD();
            } else if (type2 != 2) {
                return null;
            } else {
                type = HardwareFoldingFeature.Type.Companion.getHINGE();
            }
            int sidecarDevicePosture$window_release = getSidecarDevicePosture$window_release(sidecarDeviceState);
            if (!(sidecarDevicePosture$window_release == 0 || sidecarDevicePosture$window_release == 1)) {
                if (sidecarDevicePosture$window_release == 2) {
                    state = FoldingFeature.State.HALF_OPENED;
                } else if (sidecarDevicePosture$window_release == 3 || sidecarDevicePosture$window_release != 4) {
                    state = FoldingFeature.State.FLAT;
                }
                Rect rect2 = sidecarDisplayFeature.getRect();
                k.d(rect2, "feature.rect");
                return new HardwareFoldingFeature(new Bounds(rect2), type, state);
            }
            return null;
        }
    }

    private final boolean isEqualSidecarDisplayFeature(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (k.a(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return k.a(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    private final boolean isEqualSidecarDisplayFeatures(List<SidecarDisplayFeature> list, List<SidecarDisplayFeature> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size() - 1;
        if (size >= 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (!isEqualSidecarDisplayFeature(list.get(i5), list2.get(i5))) {
                    return false;
                }
                if (i6 > size) {
                    break;
                }
                i5 = i6;
            }
        }
        return true;
    }

    public final boolean isEqualSidecarDeviceState(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (k.a(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        Companion companion = Companion;
        return companion.getSidecarDevicePosture$window_release(sidecarDeviceState) == companion.getSidecarDevicePosture$window_release(sidecarDeviceState2);
    }

    public final boolean isEqualSidecarWindowLayoutInfo(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (k.a(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        Companion companion = Companion;
        return isEqualSidecarDisplayFeatures(companion.getSidecarDisplayFeatures(sidecarWindowLayoutInfo), companion.getSidecarDisplayFeatures(sidecarWindowLayoutInfo2));
    }

    public final WindowLayoutInfo translate(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        k.e(sidecarDeviceState, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new WindowLayoutInfo(n.d());
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        Companion companion = Companion;
        companion.setSidecarDevicePosture(sidecarDeviceState2, companion.getSidecarDevicePosture$window_release(sidecarDeviceState));
        return new WindowLayoutInfo(translate(companion.getSidecarDisplayFeatures(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final List<DisplayFeature> translate(List<SidecarDisplayFeature> list, SidecarDeviceState sidecarDeviceState) {
        k.e(list, "sidecarDisplayFeatures");
        k.e(sidecarDeviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        for (SidecarDisplayFeature translate$window_release : list) {
            DisplayFeature translate$window_release2 = Companion.translate$window_release(translate$window_release, sidecarDeviceState);
            if (translate$window_release2 != null) {
                arrayList.add(translate$window_release2);
            }
        }
        return arrayList;
    }
}
