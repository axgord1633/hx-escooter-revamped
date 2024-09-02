package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import java.util.ArrayList;
import java.util.Iterator;

class ListenableEditingState extends SpannableStringBuilder {
    private static final String TAG = "ListenableEditingState";
    private int mBatchEditNestDepth = 0;
    private ArrayList<TextEditingDelta> mBatchTextEditingDeltas = new ArrayList<>();
    private int mChangeNotificationDepth = 0;
    private int mComposingEndWhenBeginBatchEdit;
    private int mComposingStartWhenBeginBatchEdit;
    private BaseInputConnection mDummyConnection;
    private ArrayList<EditingStateWatcher> mListeners = new ArrayList<>();
    private ArrayList<EditingStateWatcher> mPendingListeners = new ArrayList<>();
    private int mSelectionEndWhenBeginBatchEdit;
    private int mSelectionStartWhenBeginBatchEdit;
    private String mTextWhenBeginBatchEdit;
    private String mToStringCache;

    interface EditingStateWatcher {
        void didChangeEditingState(boolean z4, boolean z5, boolean z6);
    }

    public ListenableEditingState(TextInputChannel.TextEditState textEditState, View view) {
        this.mDummyConnection = new BaseInputConnection(view, true) {
            public Editable getEditable() {
                return this;
            }
        };
        if (textEditState != null) {
            setEditingState(textEditState);
        }
    }

    private void notifyListener(EditingStateWatcher editingStateWatcher, boolean z4, boolean z5, boolean z6) {
        this.mChangeNotificationDepth++;
        editingStateWatcher.didChangeEditingState(z4, z5, z6);
        this.mChangeNotificationDepth--;
    }

    private void notifyListenersIfNeeded(boolean z4, boolean z5, boolean z6) {
        if (z4 || z5 || z6) {
            Iterator<EditingStateWatcher> it = this.mListeners.iterator();
            while (it.hasNext()) {
                notifyListener(it.next(), z4, z5, z6);
            }
        }
    }

    public void addEditingStateListener(EditingStateWatcher editingStateWatcher) {
        ArrayList<EditingStateWatcher> arrayList;
        if (this.mChangeNotificationDepth > 0) {
            Log.e(TAG, "adding a listener " + editingStateWatcher.toString() + " in a listener callback");
        }
        if (this.mBatchEditNestDepth > 0) {
            Log.w(TAG, "a listener was added to EditingState while a batch edit was in progress");
            arrayList = this.mPendingListeners;
        } else {
            arrayList = this.mListeners;
        }
        arrayList.add(editingStateWatcher);
    }

    public void beginBatchEdit() {
        this.mBatchEditNestDepth++;
        if (this.mChangeNotificationDepth > 0) {
            Log.e(TAG, "editing state should not be changed in a listener callback");
        }
        if (this.mBatchEditNestDepth == 1 && !this.mListeners.isEmpty()) {
            this.mTextWhenBeginBatchEdit = toString();
            this.mSelectionStartWhenBeginBatchEdit = getSelectionStart();
            this.mSelectionEndWhenBeginBatchEdit = getSelectionEnd();
            this.mComposingStartWhenBeginBatchEdit = getComposingStart();
            this.mComposingEndWhenBeginBatchEdit = getComposingEnd();
        }
    }

    public void clearBatchDeltas() {
        this.mBatchTextEditingDeltas.clear();
    }

    public void endBatchEdit() {
        int i5 = this.mBatchEditNestDepth;
        if (i5 == 0) {
            Log.e(TAG, "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i5 == 1) {
            Iterator<EditingStateWatcher> it = this.mPendingListeners.iterator();
            while (it.hasNext()) {
                notifyListener(it.next(), true, true, true);
            }
            if (!this.mListeners.isEmpty()) {
                Log.v(TAG, "didFinishBatchEdit with " + String.valueOf(this.mListeners.size()) + " listener(s)");
                boolean equals = toString().equals(this.mTextWhenBeginBatchEdit) ^ true;
                boolean z4 = false;
                boolean z5 = (this.mSelectionStartWhenBeginBatchEdit == getSelectionStart() && this.mSelectionEndWhenBeginBatchEdit == getSelectionEnd()) ? false : true;
                if (!(this.mComposingStartWhenBeginBatchEdit == getComposingStart() && this.mComposingEndWhenBeginBatchEdit == getComposingEnd())) {
                    z4 = true;
                }
                notifyListenersIfNeeded(equals, z5, z4);
            }
        }
        this.mListeners.addAll(this.mPendingListeners);
        this.mPendingListeners.clear();
        this.mBatchEditNestDepth--;
    }

    public ArrayList<TextEditingDelta> extractBatchTextEditingDeltas() {
        ArrayList<TextEditingDelta> arrayList = new ArrayList<>(this.mBatchTextEditingDeltas);
        this.mBatchTextEditingDeltas.clear();
        return arrayList;
    }

    public final int getComposingEnd() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public final int getComposingStart() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    public final int getSelectionEnd() {
        return Selection.getSelectionEnd(this);
    }

    public final int getSelectionStart() {
        return Selection.getSelectionStart(this);
    }

    public void removeEditingStateListener(EditingStateWatcher editingStateWatcher) {
        if (this.mChangeNotificationDepth > 0) {
            Log.e(TAG, "removing a listener " + editingStateWatcher.toString() + " in a listener callback");
        }
        this.mListeners.remove(editingStateWatcher);
        if (this.mBatchEditNestDepth > 0) {
            this.mPendingListeners.remove(editingStateWatcher);
        }
    }

    public SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence, int i7, int i8) {
        boolean z4;
        boolean z5;
        if (this.mChangeNotificationDepth > 0) {
            Log.e(TAG, "editing state should not be changed in a listener callback");
        }
        String listenableEditingState = toString();
        int i9 = i6 - i5;
        boolean z6 = i9 != i8 - i7;
        for (int i10 = 0; i10 < i9 && !z6; i10++) {
            z6 |= charAt(i5 + i10) != charSequence.charAt(i7 + i10);
        }
        CharSequence charSequence2 = charSequence;
        if (z6) {
            this.mToStringCache = null;
        }
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        int composingStart = getComposingStart();
        int composingEnd = getComposingEnd();
        SpannableStringBuilder replace = super.replace(i5, i6, charSequence, i7, i8);
        TextEditingDelta textEditingDelta = r1;
        boolean z7 = z6;
        int i11 = composingEnd;
        TextEditingDelta textEditingDelta2 = new TextEditingDelta(listenableEditingState, i5, i6, charSequence, getSelectionStart(), getSelectionEnd(), getComposingStart(), getComposingEnd());
        this.mBatchTextEditingDeltas.add(textEditingDelta);
        if (this.mBatchEditNestDepth > 0) {
            return replace;
        }
        boolean z8 = (getSelectionStart() == selectionStart && getSelectionEnd() == selectionEnd) ? false : true;
        if (getComposingStart() == composingStart && getComposingEnd() == i11) {
            z4 = z7;
            z5 = false;
        } else {
            z4 = z7;
            z5 = true;
        }
        notifyListenersIfNeeded(z4, z8, z5);
        return replace;
    }

    public void setComposingRange(int i5, int i6) {
        if (i5 < 0 || i5 >= i6) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.mDummyConnection.setComposingRegion(i5, i6);
        }
    }

    public void setEditingState(TextInputChannel.TextEditState textEditState) {
        beginBatchEdit();
        replace(0, length(), textEditState.text);
        if (textEditState.hasSelection()) {
            Selection.setSelection(this, textEditState.selectionStart, textEditState.selectionEnd);
        } else {
            Selection.removeSelection(this);
        }
        setComposingRange(textEditState.composingStart, textEditState.composingEnd);
        clearBatchDeltas();
        endBatchEdit();
    }

    public void setSpan(Object obj, int i5, int i6, int i7) {
        super.setSpan(obj, i5, i6, i7);
        this.mBatchTextEditingDeltas.add(new TextEditingDelta(toString(), getSelectionStart(), getSelectionEnd(), getComposingStart(), getComposingEnd()));
    }

    public String toString() {
        String str = this.mToStringCache;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.mToStringCache = spannableStringBuilder;
        return spannableStringBuilder;
    }
}
