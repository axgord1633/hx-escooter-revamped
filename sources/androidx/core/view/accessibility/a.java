package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {

    /* renamed from: e  reason: collision with root package name */
    private final int f1852e;

    /* renamed from: f  reason: collision with root package name */
    private final f f1853f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1854g;

    public a(int i5, f fVar, int i6) {
        this.f1852e = i5;
        this.f1853f = fVar;
        this.f1854g = i6;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1852e);
        this.f1853f.F(this.f1854g, bundle);
    }
}
