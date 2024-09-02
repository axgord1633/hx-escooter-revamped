package io.flutter.embedding.engine.plugins.contentprovider;

import android.content.ContentProvider;
import androidx.lifecycle.f;

public interface ContentProviderControlSurface {
    void attachToContentProvider(ContentProvider contentProvider, f fVar);

    void detachFromContentProvider();
}
