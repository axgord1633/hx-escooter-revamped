package h;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class k implements Window.Callback {

    /* renamed from: e  reason: collision with root package name */
    final Window.Callback f4835e;

    public k(Window.Callback callback) {
        if (callback != null) {
            this.f4835e = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public final Window.Callback a() {
        return this.f4835e;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f4835e.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f4835e.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f4835e.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f4835e.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f4835e.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f4835e.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f4835e.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f4835e.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f4835e.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f4835e.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i5, Menu menu) {
        return this.f4835e.onCreatePanelMenu(i5, menu);
    }

    public View onCreatePanelView(int i5) {
        return this.f4835e.onCreatePanelView(i5);
    }

    public void onDetachedFromWindow() {
        this.f4835e.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        return this.f4835e.onMenuItemSelected(i5, menuItem);
    }

    public boolean onMenuOpened(int i5, Menu menu) {
        return this.f4835e.onMenuOpened(i5, menu);
    }

    public void onPanelClosed(int i5, Menu menu) {
        this.f4835e.onPanelClosed(i5, menu);
    }

    public void onPointerCaptureChanged(boolean z4) {
        this.f4835e.onPointerCaptureChanged(z4);
    }

    public boolean onPreparePanel(int i5, View view, Menu menu) {
        return this.f4835e.onPreparePanel(i5, view, menu);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i5) {
        this.f4835e.onProvideKeyboardShortcuts(list, menu, i5);
    }

    public boolean onSearchRequested() {
        return this.f4835e.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f4835e.onSearchRequested(searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f4835e.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z4) {
        this.f4835e.onWindowFocusChanged(z4);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f4835e.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i5) {
        return this.f4835e.onWindowStartingActionMode(callback, i5);
    }
}
