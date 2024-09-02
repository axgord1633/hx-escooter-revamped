package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.ListPopupWindow;

class InputAwareWebView extends WebView {
    private static final String TAG = "InputAwareWebView";
    /* access modifiers changed from: private */
    public View containerView;
    private ThreadedInputConnectionProxyAdapterView proxyAdapterView;
    private View threadedInputConnectionProxyView;

    InputAwareWebView(Context context, View view) {
        super(context);
        this.containerView = view;
    }

    private boolean isCalledFromListPopupWindowShow() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getClassName().equals(ListPopupWindow.class.getCanonicalName()) && stackTraceElement.getMethodName().equals("show")) {
                return true;
            }
        }
        return false;
    }

    private void resetInputConnection() {
        if (this.proxyAdapterView != null) {
            View view = this.containerView;
            if (view == null) {
                Log.e(TAG, "Can't reset the input connection to the container view because there is none.");
            } else {
                setInputConnectionTarget(view);
            }
        }
    }

    public boolean checkInputConnectionProxy(View view) {
        View view2 = this.threadedInputConnectionProxyView;
        this.threadedInputConnectionProxyView = view;
        if (view2 == view) {
            return super.checkInputConnectionProxy(view);
        }
        View view3 = this.containerView;
        if (view3 == null) {
            Log.e(TAG, "Can't create a proxy view because there's no container view. Text input may not work.");
        } else {
            ThreadedInputConnectionProxyAdapterView threadedInputConnectionProxyAdapterView = new ThreadedInputConnectionProxyAdapterView(view3, view, view.getHandler());
            this.proxyAdapterView = threadedInputConnectionProxyAdapterView;
            setInputConnectionTarget(threadedInputConnectionProxyAdapterView);
        }
        return super.checkInputConnectionProxy(view);
    }

    public void clearFocus() {
        super.clearFocus();
        resetInputConnection();
    }

    /* access modifiers changed from: package-private */
    public void dispose() {
        resetInputConnection();
    }

    /* access modifiers changed from: package-private */
    public void lockInputConnection() {
        ThreadedInputConnectionProxyAdapterView threadedInputConnectionProxyAdapterView = this.proxyAdapterView;
        if (threadedInputConnectionProxyAdapterView != null) {
            threadedInputConnectionProxyAdapterView.setLocked(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z4, int i5, Rect rect) {
        if (Build.VERSION.SDK_INT >= 28 || !isCalledFromListPopupWindowShow() || z4) {
            super.onFocusChanged(z4, i5, rect);
        }
    }

    /* access modifiers changed from: package-private */
    public void setContainerView(View view) {
        this.containerView = view;
        if (this.proxyAdapterView != null) {
            Log.w(TAG, "The containerView has changed while the proxyAdapterView exists.");
            if (view != null) {
                setInputConnectionTarget(this.proxyAdapterView);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setInputConnectionTarget(final View view) {
        if (this.containerView == null) {
            Log.e(TAG, "Can't set the input connection target because there is no containerView to use as a handler.");
            return;
        }
        view.requestFocus();
        this.containerView.post(new Runnable() {
            public void run() {
                if (InputAwareWebView.this.containerView == null) {
                    Log.e(InputAwareWebView.TAG, "Can't set the input connection target because there is no containerView to use as a handler.");
                    return;
                }
                view.onWindowFocusChanged(true);
                ((InputMethodManager) InputAwareWebView.this.getContext().getSystemService("input_method")).isActive(InputAwareWebView.this.containerView);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void unlockInputConnection() {
        ThreadedInputConnectionProxyAdapterView threadedInputConnectionProxyAdapterView = this.proxyAdapterView;
        if (threadedInputConnectionProxyAdapterView != null) {
            threadedInputConnectionProxyAdapterView.setLocked(false);
        }
    }
}
