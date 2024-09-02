package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.KeyData;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.android.KeyboardMap;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KeyEmbedderResponder implements KeyboardManager.Responder {
    private static final String TAG = "KeyEmbedderResponder";
    private final KeyboardManager.CharacterCombiner characterCombiner = new KeyboardManager.CharacterCombiner();
    private final BinaryMessenger messenger;
    private final HashMap<Long, Long> pressingRecords = new HashMap<>();
    private final HashMap<Long, KeyboardMap.TogglingGoal> togglingGoals = new HashMap<>();

    /* renamed from: io.flutter.embedding.android.KeyEmbedderResponder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$KeyData$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.flutter.embedding.android.KeyData$Type[] r0 = io.flutter.embedding.android.KeyData.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$flutter$embedding$android$KeyData$Type = r0
                io.flutter.embedding.android.KeyData$Type r1 = io.flutter.embedding.android.KeyData.Type.kDown     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$flutter$embedding$android$KeyData$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.embedding.android.KeyData$Type r1 = io.flutter.embedding.android.KeyData.Type.kUp     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$flutter$embedding$android$KeyData$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.flutter.embedding.android.KeyData$Type r1 = io.flutter.embedding.android.KeyData.Type.kRepeat     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.KeyEmbedderResponder.AnonymousClass1.<clinit>():void");
        }
    }

    public KeyEmbedderResponder(BinaryMessenger binaryMessenger) {
        this.messenger = binaryMessenger;
        for (KeyboardMap.TogglingGoal togglingGoal : KeyboardMap.getTogglingGoals()) {
            this.togglingGoals.put(Long.valueOf(togglingGoal.logicalKey), togglingGoal);
        }
    }

    private static KeyData.Type getEventType(KeyEvent keyEvent) {
        boolean z4 = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z4 ? KeyData.Type.kRepeat : KeyData.Type.kDown;
        }
        if (action == 1) {
            return KeyData.Type.kUp;
        }
        throw new AssertionError("Unexpected event type");
    }

    private Long getLogicalKey(KeyEvent keyEvent) {
        Long l5 = KeyboardMap.keyCodeToLogical.get(Long.valueOf((long) keyEvent.getKeyCode()));
        return l5 != null ? l5 : Long.valueOf(keyOfPlane((long) keyEvent.getKeyCode(), KeyboardMap.kAndroidPlane));
    }

    private Long getPhysicalKey(KeyEvent keyEvent) {
        int scanCode;
        long scanCode2 = (long) keyEvent.getScanCode();
        if (scanCode2 == 0) {
            scanCode = keyEvent.getKeyCode();
        } else {
            Long l5 = KeyboardMap.scanCodeToPhysical.get(Long.valueOf(scanCode2));
            if (l5 != null) {
                return l5;
            }
            scanCode = keyEvent.getScanCode();
        }
        return Long.valueOf(keyOfPlane((long) scanCode, KeyboardMap.kAndroidPlane));
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0119 A[LOOP:2: B:53:0x0113->B:55:0x0119, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handleEventImpl(android.view.KeyEvent r18, io.flutter.embedding.android.KeyboardManager.Responder.OnKeyEventHandledCallback r19) {
        /*
            r17 = this;
            r9 = r17
            int r0 = r18.getScanCode()
            r10 = 0
            if (r0 != 0) goto L_0x0010
            int r0 = r18.getKeyCode()
            if (r0 != 0) goto L_0x0010
            return r10
        L_0x0010:
            java.lang.Long r11 = r17.getPhysicalKey(r18)
            java.lang.Long r12 = r17.getLogicalKey(r18)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            io.flutter.embedding.android.KeyboardMap$PressingGoal[] r14 = io.flutter.embedding.android.KeyboardMap.pressingGoals
            int r15 = r14.length
            r8 = r10
        L_0x0021:
            r6 = 1
            if (r8 >= r15) goto L_0x0047
            r1 = r14[r8]
            int r0 = r18.getMetaState()
            int r2 = r1.mask
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0031
            r2 = r6
            goto L_0x0032
        L_0x0031:
            r2 = r10
        L_0x0032:
            long r3 = r12.longValue()
            long r5 = r11.longValue()
            r0 = r17
            r7 = r18
            r16 = r8
            r8 = r13
            r0.synchronizePressingKey(r1, r2, r3, r5, r7, r8)
            int r8 = r16 + 1
            goto L_0x0021
        L_0x0047:
            java.util.HashMap<java.lang.Long, io.flutter.embedding.android.KeyboardMap$TogglingGoal> r0 = r9.togglingGoals
            java.util.Collection r0 = r0.values()
            java.util.Iterator r7 = r0.iterator()
        L_0x0051:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0076
            java.lang.Object r0 = r7.next()
            r1 = r0
            io.flutter.embedding.android.KeyboardMap$TogglingGoal r1 = (io.flutter.embedding.android.KeyboardMap.TogglingGoal) r1
            int r0 = r18.getMetaState()
            int r2 = r1.mask
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0069
            r2 = r6
            goto L_0x006a
        L_0x0069:
            r2 = r10
        L_0x006a:
            long r3 = r12.longValue()
            r0 = r17
            r5 = r18
            r0.synchronizeTogglingKey(r1, r2, r3, r5)
            goto L_0x0051
        L_0x0076:
            int r0 = r18.getAction()
            if (r0 == 0) goto L_0x0081
            if (r0 == r6) goto L_0x007f
            return r10
        L_0x007f:
            r7 = r10
            goto L_0x0082
        L_0x0081:
            r7 = r6
        L_0x0082:
            java.util.HashMap<java.lang.Long, java.lang.Long> r0 = r9.pressingRecords
            java.lang.Object r0 = r0.get(r11)
            r2 = r0
            java.lang.Long r2 = (java.lang.Long) r2
            r8 = 0
            if (r7 == 0) goto L_0x00ca
            if (r2 != 0) goto L_0x0093
        L_0x0090:
            io.flutter.embedding.android.KeyData$Type r0 = io.flutter.embedding.android.KeyData.Type.kDown
            goto L_0x00a8
        L_0x0093:
            int r0 = r18.getRepeatCount()
            if (r0 <= 0) goto L_0x009c
            io.flutter.embedding.android.KeyData$Type r0 = io.flutter.embedding.android.KeyData.Type.kRepeat
            goto L_0x00a8
        L_0x009c:
            r1 = 0
            long r4 = r18.getEventTime()
            r0 = r17
            r3 = r11
            r0.synthesizeEvent(r1, r2, r3, r4)
            goto L_0x0090
        L_0x00a8:
            io.flutter.embedding.android.KeyboardManager$CharacterCombiner r1 = r9.characterCombiner
            int r2 = r18.getUnicodeChar()
            java.lang.Character r1 = r1.applyCombiningCharacterToBaseCharacter(r2)
            char r1 = r1.charValue()
            if (r1 == 0) goto L_0x00cf
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ""
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L_0x00d0
        L_0x00ca:
            if (r2 != 0) goto L_0x00cd
            return r10
        L_0x00cd:
            io.flutter.embedding.android.KeyData$Type r0 = io.flutter.embedding.android.KeyData.Type.kUp
        L_0x00cf:
            r1 = r8
        L_0x00d0:
            io.flutter.embedding.android.KeyData$Type r2 = io.flutter.embedding.android.KeyData.Type.kRepeat
            if (r0 == r2) goto L_0x00da
            if (r7 == 0) goto L_0x00d7
            r8 = r12
        L_0x00d7:
            r9.updatePressingState(r11, r8)
        L_0x00da:
            io.flutter.embedding.android.KeyData$Type r2 = io.flutter.embedding.android.KeyData.Type.kDown
            if (r0 != r2) goto L_0x00ed
            java.util.HashMap<java.lang.Long, io.flutter.embedding.android.KeyboardMap$TogglingGoal> r2 = r9.togglingGoals
            java.lang.Object r2 = r2.get(r12)
            io.flutter.embedding.android.KeyboardMap$TogglingGoal r2 = (io.flutter.embedding.android.KeyboardMap.TogglingGoal) r2
            if (r2 == 0) goto L_0x00ed
            boolean r3 = r2.enabled
            r3 = r3 ^ r6
            r2.enabled = r3
        L_0x00ed:
            io.flutter.embedding.android.KeyData r2 = new io.flutter.embedding.android.KeyData
            r2.<init>()
            long r3 = r18.getEventTime()
            r2.timestamp = r3
            r2.type = r0
            long r3 = r12.longValue()
            r2.logicalKey = r3
            long r3 = r11.longValue()
            r2.physicalKey = r3
            r2.character = r1
            r2.synthesized = r10
            r0 = r19
            r9.sendKeyEvent(r2, r0)
            java.util.Iterator r0 = r13.iterator()
        L_0x0113:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0123
            java.lang.Object r1 = r0.next()
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r1.run()
            goto L_0x0113
        L_0x0123:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.KeyEmbedderResponder.handleEventImpl(android.view.KeyEvent, io.flutter.embedding.android.KeyboardManager$Responder$OnKeyEventHandledCallback):boolean");
    }

    private static long keyOfPlane(long j5, long j6) {
        return (j5 & KeyboardMap.kValueMask) | j6;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendKeyEvent$2(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback, ByteBuffer byteBuffer) {
        Boolean bool = Boolean.FALSE;
        byteBuffer.rewind();
        if (byteBuffer.capacity() != 0) {
            bool = Boolean.valueOf(byteBuffer.get() != 0);
        }
        onKeyEventHandledCallback.onKeyEventHandled(bool.booleanValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$synchronizePressingKey$0(KeyboardMap.KeyPair keyPair, long j5, KeyEvent keyEvent) {
        synthesizeEvent(false, Long.valueOf(keyPair.logicalKey), Long.valueOf(j5), keyEvent.getEventTime());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$synchronizePressingKey$1(KeyboardMap.KeyPair keyPair, KeyEvent keyEvent) {
        synthesizeEvent(false, Long.valueOf(keyPair.logicalKey), Long.valueOf(keyPair.physicalKey), keyEvent.getEventTime());
    }

    private void sendKeyEvent(KeyData keyData, KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.messenger.send(KeyData.CHANNEL, keyData.toBytes(), onKeyEventHandledCallback == null ? null : new l(onKeyEventHandledCallback));
    }

    private void synthesizeEvent(boolean z4, Long l5, Long l6, long j5) {
        KeyData keyData = new KeyData();
        keyData.timestamp = j5;
        keyData.type = z4 ? KeyData.Type.kDown : KeyData.Type.kUp;
        keyData.logicalKey = l5.longValue();
        keyData.physicalKey = l6.longValue();
        keyData.character = null;
        keyData.synthesized = true;
        if (!(l6.longValue() == 0 || l5.longValue() == 0)) {
            if (!z4) {
                l5 = null;
            }
            updatePressingState(l6, l5);
        }
        sendKeyEvent(keyData, (KeyboardManager.Responder.OnKeyEventHandledCallback) null);
    }

    public Map<Long, Long> getPressedState() {
        return Collections.unmodifiableMap(this.pressingRecords);
    }

    public void handleEvent(KeyEvent keyEvent, KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        if (!handleEventImpl(keyEvent, onKeyEventHandledCallback)) {
            synthesizeEvent(true, (Long) null, 0L, 0);
            onKeyEventHandledCallback.onKeyEventHandled(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void synchronizePressingKey(KeyboardMap.PressingGoal pressingGoal, boolean z4, long j5, long j6, KeyEvent keyEvent, ArrayList<Runnable> arrayList) {
        KeyboardMap.PressingGoal pressingGoal2 = pressingGoal;
        ArrayList<Runnable> arrayList2 = arrayList;
        KeyboardMap.KeyPair[] keyPairArr = pressingGoal2.keys;
        boolean[] zArr = new boolean[keyPairArr.length];
        Boolean[] boolArr = new Boolean[keyPairArr.length];
        boolean z5 = false;
        int i5 = 0;
        while (true) {
            KeyboardMap.KeyPair[] keyPairArr2 = pressingGoal2.keys;
            boolean z6 = true;
            if (i5 >= keyPairArr2.length) {
                break;
            }
            KeyboardMap.KeyPair keyPair = keyPairArr2[i5];
            boolean containsKey = this.pressingRecords.containsKey(Long.valueOf(keyPair.physicalKey));
            zArr[i5] = containsKey;
            if (keyPair.logicalKey == j5) {
                int i6 = AnonymousClass1.$SwitchMap$io$flutter$embedding$android$KeyData$Type[getEventType(keyEvent).ordinal()];
                if (i6 != 1) {
                    if (i6 == 2) {
                        KeyEvent keyEvent2 = keyEvent;
                        boolArr[i5] = Boolean.valueOf(zArr[i5]);
                    } else if (i6 != 3) {
                        KeyEvent keyEvent3 = keyEvent;
                    } else {
                        if (!z4) {
                            arrayList2.add(new n(this, keyPair, keyEvent));
                        } else {
                            KeyEvent keyEvent4 = keyEvent;
                        }
                        boolArr[i5] = Boolean.valueOf(zArr[i5]);
                    }
                    i5++;
                } else {
                    KeyEvent keyEvent5 = keyEvent;
                    boolArr[i5] = Boolean.FALSE;
                    if (!z4) {
                        arrayList2.add(new m(this, keyPair, j6, keyEvent));
                    }
                }
            } else {
                KeyEvent keyEvent6 = keyEvent;
                if (!z5 && !containsKey) {
                    z6 = false;
                }
            }
            z5 = z6;
            i5++;
        }
        KeyEvent keyEvent7 = keyEvent;
        if (z4) {
            for (int i7 = 0; i7 < pressingGoal2.keys.length; i7++) {
                if (boolArr[i7] == null) {
                    if (z5) {
                        boolArr[i7] = Boolean.valueOf(zArr[i7]);
                    } else {
                        boolArr[i7] = Boolean.TRUE;
                        z5 = true;
                    }
                }
            }
            if (!z5) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i8 = 0; i8 < pressingGoal2.keys.length; i8++) {
                if (boolArr[i8] == null) {
                    boolArr[i8] = Boolean.FALSE;
                }
            }
        }
        for (int i9 = 0; i9 < pressingGoal2.keys.length; i9++) {
            if (zArr[i9] != boolArr[i9].booleanValue()) {
                KeyboardMap.KeyPair keyPair2 = pressingGoal2.keys[i9];
                synthesizeEvent(boolArr[i9].booleanValue(), Long.valueOf(keyPair2.logicalKey), Long.valueOf(keyPair2.physicalKey), keyEvent.getEventTime());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void synchronizeTogglingKey(KeyboardMap.TogglingGoal togglingGoal, boolean z4, long j5, KeyEvent keyEvent) {
        if (togglingGoal.logicalKey != j5 && togglingGoal.enabled != z4) {
            boolean z5 = !this.pressingRecords.containsKey(Long.valueOf(togglingGoal.physicalKey));
            if (z5) {
                togglingGoal.enabled = !togglingGoal.enabled;
            }
            synthesizeEvent(z5, Long.valueOf(togglingGoal.logicalKey), Long.valueOf(togglingGoal.physicalKey), keyEvent.getEventTime());
            if (!z5) {
                togglingGoal.enabled = !togglingGoal.enabled;
            }
            synthesizeEvent(!z5, Long.valueOf(togglingGoal.logicalKey), Long.valueOf(togglingGoal.physicalKey), keyEvent.getEventTime());
        }
    }

    /* access modifiers changed from: package-private */
    public void updatePressingState(Long l5, Long l6) {
        if (l6 != null) {
            if (this.pressingRecords.put(l5, l6) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (this.pressingRecords.remove(l5) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
