package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

public class AndroidTouchProcessor {
    static final int BYTES_PER_FIELD = 8;
    static final int DEFAULT_HORIZONTAL_SCROLL_FACTOR = 48;
    static final int DEFAULT_VERTICAL_SCROLL_FACTOR = 48;
    private static final Matrix IDENTITY_TRANSFORM = new Matrix();
    private static final int POINTER_DATA_FIELD_COUNT = 35;
    private static final int POINTER_DATA_FLAG_BATCHED = 1;
    private int cachedVerticalScrollFactor;
    private final MotionEventTracker motionEventTracker;
    private final Map<Integer, float[]> ongoingPans = new HashMap();
    private final FlutterRenderer renderer;
    private final boolean trackMotionEvents;

    public @interface PointerChange {
        public static final int ADD = 1;
        public static final int CANCEL = 0;
        public static final int DOWN = 4;
        public static final int HOVER = 3;
        public static final int MOVE = 5;
        public static final int PAN_ZOOM_END = 9;
        public static final int PAN_ZOOM_START = 7;
        public static final int PAN_ZOOM_UPDATE = 8;
        public static final int REMOVE = 2;
        public static final int UP = 6;
    }

    public @interface PointerDeviceKind {
        public static final int INVERTED_STYLUS = 3;
        public static final int MOUSE = 1;
        public static final int STYLUS = 2;
        public static final int TOUCH = 0;
        public static final int TRACKPAD = 4;
        public static final int UNKNOWN = 5;
    }

    public @interface PointerSignalKind {
        public static final int NONE = 0;
        public static final int SCALE = 3;
        public static final int SCROLL = 1;
        public static final int SCROLL_INERTIA_CANCEL = 2;
        public static final int UNKNOWN = 4;
    }

    public AndroidTouchProcessor(FlutterRenderer flutterRenderer, boolean z4) {
        this.renderer = flutterRenderer;
        this.motionEventTracker = MotionEventTracker.getInstance();
        this.trackMotionEvents = z4;
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i5, int i6, int i7, Matrix matrix, ByteBuffer byteBuffer) {
        addPointerForIndex(motionEvent, i5, i6, i7, matrix, byteBuffer, (Context) null);
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i5, int i6, int i7, Matrix matrix, ByteBuffer byteBuffer, Context context) {
        long j5;
        long j6;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        InputDevice.MotionRange motionRange;
        MotionEvent motionEvent2 = motionEvent;
        int i8 = i5;
        int i9 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        Context context2 = context;
        int i10 = -1;
        if (i9 != -1) {
            int pointerId = motionEvent.getPointerId(i5);
            int pointerDeviceTypeForToolType = getPointerDeviceTypeForToolType(motionEvent.getToolType(i5));
            float[] fArr = {motionEvent.getX(i5), motionEvent.getY(i5)};
            matrix.mapPoints(fArr);
            if (pointerDeviceTypeForToolType == 1) {
                j5 = (long) (motionEvent.getButtonState() & 31);
                if (j5 == 0 && motionEvent.getSource() == 8194 && i9 == 4) {
                    this.ongoingPans.put(Integer.valueOf(pointerId), fArr);
                }
            } else {
                j5 = pointerDeviceTypeForToolType == 2 ? (long) ((motionEvent.getButtonState() >> 4) & 15) : 0;
            }
            boolean containsKey = this.ongoingPans.containsKey(Integer.valueOf(pointerId));
            if (containsKey) {
                int pointerChangeForPanZoom = getPointerChangeForPanZoom(i9);
                if (pointerChangeForPanZoom != -1) {
                    i10 = pointerChangeForPanZoom;
                } else {
                    return;
                }
            }
            long id = this.trackMotionEvents ? this.motionEventTracker.track(motionEvent2).getId() : 0;
            int i11 = motionEvent.getActionMasked() == 8 ? 1 : 0;
            byteBuffer2.putLong(id);
            byteBuffer2.putLong(motionEvent.getEventTime() * 1000);
            int i12 = i10;
            if (containsKey) {
                byteBuffer2.putLong((long) i12);
                j6 = 4;
            } else {
                byteBuffer2.putLong((long) i9);
                j6 = (long) pointerDeviceTypeForToolType;
            }
            byteBuffer2.putLong(j6);
            byteBuffer2.putLong((long) i11);
            byteBuffer2.putLong((long) pointerId);
            byteBuffer2.putLong(0);
            if (containsKey) {
                float[] fArr2 = this.ongoingPans.get(Integer.valueOf(pointerId));
                byteBuffer2.putDouble((double) fArr2[0]);
                d5 = (double) fArr2[1];
            } else {
                byteBuffer2.putDouble((double) fArr[0]);
                d5 = (double) fArr[1];
            }
            byteBuffer2.putDouble(d5);
            byteBuffer2.putDouble(0.0d);
            byteBuffer2.putDouble(0.0d);
            byteBuffer2.putLong(j5);
            byteBuffer2.putLong(0);
            byteBuffer2.putLong(0);
            byteBuffer2.putDouble((double) motionEvent.getPressure(i5));
            if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
                d7 = 1.0d;
                d6 = 0.0d;
            } else {
                d6 = (double) motionRange.getMin();
                d7 = (double) motionRange.getMax();
            }
            byteBuffer2.putDouble(d6);
            byteBuffer2.putDouble(d7);
            if (pointerDeviceTypeForToolType == 2) {
                byteBuffer2.putDouble((double) motionEvent2.getAxisValue(24, i8));
                d8 = 0.0d;
            } else {
                d8 = 0.0d;
                byteBuffer2.putDouble(0.0d);
            }
            byteBuffer2.putDouble(d8);
            byteBuffer2.putDouble((double) motionEvent.getSize(i5));
            byteBuffer2.putDouble((double) motionEvent.getToolMajor(i5));
            byteBuffer2.putDouble((double) motionEvent.getToolMinor(i5));
            byteBuffer2.putDouble(d8);
            byteBuffer2.putDouble(d8);
            byteBuffer2.putDouble((double) motionEvent2.getAxisValue(8, i8));
            if (pointerDeviceTypeForToolType == 2) {
                byteBuffer2.putDouble((double) motionEvent2.getAxisValue(25, i8));
            } else {
                byteBuffer2.putDouble(d8);
            }
            byteBuffer2.putLong((long) i7);
            if (i11 == 1) {
                double d11 = 48.0d;
                Context context3 = context;
                if (context3 != null) {
                    d11 = (double) getHorizontalScrollFactor(context3);
                    d10 = (double) getVerticalScrollFactor(context3);
                } else {
                    d10 = 48.0d;
                }
                byteBuffer2.putDouble(d11 * ((double) (-motionEvent2.getAxisValue(10, i8))));
                byteBuffer2.putDouble(d10 * ((double) (-motionEvent2.getAxisValue(9, i8))));
            } else {
                byteBuffer2.putDouble(0.0d);
                byteBuffer2.putDouble(0.0d);
            }
            if (containsKey) {
                float[] fArr3 = this.ongoingPans.get(Integer.valueOf(pointerId));
                byteBuffer2.putDouble((double) (fArr[0] - fArr3[0]));
                byteBuffer2.putDouble((double) (fArr[1] - fArr3[1]));
                d9 = 0.0d;
            } else {
                d9 = 0.0d;
                byteBuffer2.putDouble(0.0d);
                byteBuffer2.putDouble(0.0d);
            }
            byteBuffer2.putDouble(d9);
            byteBuffer2.putDouble(d9);
            byteBuffer2.putDouble(1.0d);
            byteBuffer2.putDouble(d9);
            if (containsKey && i12 == 9) {
                this.ongoingPans.remove(Integer.valueOf(pointerId));
            }
        }
    }

    private float getHorizontalScrollFactor(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? ViewConfiguration.get(context).getScaledHorizontalScrollFactor() : (float) getVerticalScrollFactorPre26(context);
    }

    private int getPointerChangeForAction(int i5) {
        if (i5 == 0) {
            return 4;
        }
        if (i5 == 1) {
            return 6;
        }
        if (i5 == 5) {
            return 4;
        }
        if (i5 == 6) {
            return 6;
        }
        if (i5 == 2) {
            return 5;
        }
        if (i5 == 7) {
            return 3;
        }
        if (i5 == 3) {
            return 0;
        }
        return i5 == 8 ? 3 : -1;
    }

    private int getPointerChangeForPanZoom(int i5) {
        if (i5 == 4) {
            return 7;
        }
        if (i5 == 5) {
            return 8;
        }
        return (i5 == 6 || i5 == 0) ? 9 : -1;
    }

    private int getPointerDeviceTypeForToolType(int i5) {
        if (i5 == 1) {
            return 0;
        }
        if (i5 == 2) {
            return 2;
        }
        if (i5 != 3) {
            return i5 != 4 ? 5 : 3;
        }
        return 1;
    }

    private float getVerticalScrollFactor(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? getVerticalScrollFactorAbove26(context) : (float) getVerticalScrollFactorPre26(context);
    }

    private float getVerticalScrollFactorAbove26(Context context) {
        return ViewConfiguration.get(context).getScaledVerticalScrollFactor();
    }

    private int getVerticalScrollFactorPre26(Context context) {
        if (this.cachedVerticalScrollFactor == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 48;
            }
            this.cachedVerticalScrollFactor = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.cachedVerticalScrollFactor;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent, Context context) {
        boolean z4 = motionEvent.isFromSource(2);
        boolean z5 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!z4 || !z5) {
            return false;
        }
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 35 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, IDENTITY_TRANSFORM, allocateDirect, context);
        if (allocateDirect.position() % 280 == 0) {
            this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
            return true;
        }
        throw new AssertionError("Packet position is not on field boundary.");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return onTouchEvent(motionEvent, IDENTITY_TRANSFORM);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r13, android.graphics.Matrix r14) {
        /*
            r12 = this;
            int r0 = r13.getPointerCount()
            int r1 = r0 * 35
            int r1 = r1 * 8
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r1)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            r1.order(r2)
            int r2 = r13.getActionMasked()
            int r3 = r13.getActionMasked()
            int r9 = r12.getPointerChangeForAction(r3)
            r3 = 0
            r10 = 1
            if (r2 == 0) goto L_0x0027
            r4 = 5
            if (r2 != r4) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r4 = r3
            goto L_0x0028
        L_0x0027:
            r4 = r10
        L_0x0028:
            if (r4 != 0) goto L_0x0031
            if (r2 == r10) goto L_0x002f
            r5 = 6
            if (r2 != r5) goto L_0x0031
        L_0x002f:
            r2 = r10
            goto L_0x0032
        L_0x0031:
            r2 = r3
        L_0x0032:
            if (r4 == 0) goto L_0x0042
        L_0x0034:
            int r4 = r13.getActionIndex()
            r6 = 0
            r2 = r12
            r3 = r13
            r5 = r9
            r7 = r14
            r8 = r1
            r2.addPointerForIndex(r3, r4, r5, r6, r7, r8)
            goto L_0x006f
        L_0x0042:
            r11 = r3
            if (r2 == 0) goto L_0x0060
        L_0x0045:
            if (r11 >= r0) goto L_0x0034
            int r2 = r13.getActionIndex()
            if (r11 == r2) goto L_0x005d
            int r2 = r13.getToolType(r11)
            if (r2 != r10) goto L_0x005d
            r5 = 5
            r6 = 1
            r2 = r12
            r3 = r13
            r4 = r11
            r7 = r14
            r8 = r1
            r2.addPointerForIndex(r3, r4, r5, r6, r7, r8)
        L_0x005d:
            int r11 = r11 + 1
            goto L_0x0045
        L_0x0060:
            if (r11 >= r0) goto L_0x006f
            r6 = 0
            r2 = r12
            r3 = r13
            r4 = r11
            r5 = r9
            r7 = r14
            r8 = r1
            r2.addPointerForIndex(r3, r4, r5, r6, r7, r8)
            int r11 = r11 + 1
            goto L_0x0060
        L_0x006f:
            int r13 = r1.position()
            int r13 = r13 % 280
            if (r13 != 0) goto L_0x0081
            io.flutter.embedding.engine.renderer.FlutterRenderer r13 = r12.renderer
            int r14 = r1.position()
            r13.dispatchPointerDataPacket(r1, r14)
            return r10
        L_0x0081:
            java.lang.AssertionError r13 = new java.lang.AssertionError
            java.lang.String r14 = "Packet position is not on field boundary"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.AndroidTouchProcessor.onTouchEvent(android.view.MotionEvent, android.graphics.Matrix):boolean");
    }
}
