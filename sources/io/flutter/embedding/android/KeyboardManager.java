package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.KeyboardChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.editing.InputConnectionAdaptor;
import java.util.HashSet;
import java.util.Map;

public class KeyboardManager implements InputConnectionAdaptor.KeyboardDelegate, KeyboardChannel.KeyboardMethodHandler {
    private static final String TAG = "KeyboardManager";
    private final HashSet<KeyEvent> redispatchedEvents = new HashSet<>();
    protected final Responder[] responders;
    private final ViewDelegate viewDelegate;

    public static class CharacterCombiner {
        private int combiningCharacter = 0;

        /* access modifiers changed from: package-private */
        public Character applyCombiningCharacterToBaseCharacter(int i5) {
            char c5 = (char) i5;
            if ((Integer.MIN_VALUE & i5) != 0) {
                int i6 = i5 & Integer.MAX_VALUE;
                int i7 = this.combiningCharacter;
                if (i7 != 0) {
                    i6 = KeyCharacterMap.getDeadChar(i7, i6);
                }
                this.combiningCharacter = i6;
            } else {
                int i8 = this.combiningCharacter;
                if (i8 != 0) {
                    int deadChar = KeyCharacterMap.getDeadChar(i8, i5);
                    if (deadChar > 0) {
                        c5 = (char) deadChar;
                    }
                    this.combiningCharacter = 0;
                }
            }
            return Character.valueOf(c5);
        }
    }

    private class PerEventCallbackBuilder {
        boolean isEventHandled = false;
        final KeyEvent keyEvent;
        int unrepliedCount;

        private class Callback implements Responder.OnKeyEventHandledCallback {
            boolean isCalled;

            private Callback() {
                this.isCalled = false;
            }

            public void onKeyEventHandled(boolean z4) {
                if (!this.isCalled) {
                    this.isCalled = true;
                    PerEventCallbackBuilder perEventCallbackBuilder = PerEventCallbackBuilder.this;
                    int i5 = perEventCallbackBuilder.unrepliedCount - 1;
                    perEventCallbackBuilder.unrepliedCount = i5;
                    boolean z5 = z4 | perEventCallbackBuilder.isEventHandled;
                    perEventCallbackBuilder.isEventHandled = z5;
                    if (i5 == 0 && !z5) {
                        KeyboardManager.this.onUnhandled(perEventCallbackBuilder.keyEvent);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
            }
        }

        PerEventCallbackBuilder(KeyEvent keyEvent2) {
            this.unrepliedCount = KeyboardManager.this.responders.length;
            this.keyEvent = keyEvent2;
        }

        public Responder.OnKeyEventHandledCallback buildCallback() {
            return new Callback();
        }
    }

    public interface Responder {

        public interface OnKeyEventHandledCallback {
            void onKeyEventHandled(boolean z4);
        }

        void handleEvent(KeyEvent keyEvent, OnKeyEventHandledCallback onKeyEventHandledCallback);
    }

    public interface ViewDelegate {
        BinaryMessenger getBinaryMessenger();

        boolean onTextInputKeyEvent(KeyEvent keyEvent);

        void redispatch(KeyEvent keyEvent);
    }

    public KeyboardManager(ViewDelegate viewDelegate2) {
        this.viewDelegate = viewDelegate2;
        this.responders = new Responder[]{new KeyEmbedderResponder(viewDelegate2.getBinaryMessenger()), new KeyChannelResponder(new KeyEventChannel(viewDelegate2.getBinaryMessenger()))};
        new KeyboardChannel(viewDelegate2.getBinaryMessenger()).setKeyboardMethodHandler(this);
    }

    /* access modifiers changed from: private */
    public void onUnhandled(KeyEvent keyEvent) {
        ViewDelegate viewDelegate2 = this.viewDelegate;
        if (viewDelegate2 != null && !viewDelegate2.onTextInputKeyEvent(keyEvent)) {
            this.redispatchedEvents.add(keyEvent);
            this.viewDelegate.redispatch(keyEvent);
            if (this.redispatchedEvents.remove(keyEvent)) {
                Log.w(TAG, "A redispatched key event was consumed before reaching KeyboardManager");
            }
        }
    }

    public void destroy() {
        int size = this.redispatchedEvents.size();
        if (size > 0) {
            Log.w(TAG, "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }

    public Map<Long, Long> getKeyboardState() {
        return ((KeyEmbedderResponder) this.responders[0]).getPressedState();
    }

    public boolean handleEvent(KeyEvent keyEvent) {
        if (this.redispatchedEvents.remove(keyEvent)) {
            return false;
        }
        if (this.responders.length > 0) {
            PerEventCallbackBuilder perEventCallbackBuilder = new PerEventCallbackBuilder(keyEvent);
            for (Responder handleEvent : this.responders) {
                handleEvent.handleEvent(keyEvent, perEventCallbackBuilder.buildCallback());
            }
            return true;
        }
        onUnhandled(keyEvent);
        return true;
    }
}
