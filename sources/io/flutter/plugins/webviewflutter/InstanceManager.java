package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public class InstanceManager {
    private static final long CLEAR_FINALIZED_WEAK_REFERENCES_INTERVAL = 30000;
    private static final long MIN_HOST_CREATED_IDENTIFIER = 65536;
    private final FinalizationListener finalizationListener;
    private final Handler handler;
    private final WeakHashMap<Object, Long> identifiers = new WeakHashMap<>();
    private boolean isClosed;
    private long nextIdentifier;
    private final ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
    private final HashMap<Long, Object> strongInstances = new HashMap<>();
    private final HashMap<Long, WeakReference<Object>> weakInstances = new HashMap<>();
    private final HashMap<WeakReference<Object>, Long> weakReferencesToIdentifiers = new HashMap<>();

    public interface FinalizationListener {
        void onFinalize(long j5);
    }

    private InstanceManager(FinalizationListener finalizationListener2) {
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.handler = handler2;
        this.nextIdentifier = MIN_HOST_CREATED_IDENTIFIER;
        this.isClosed = false;
        this.finalizationListener = finalizationListener2;
        handler2.postDelayed(new a2(this), CLEAR_FINALIZED_WEAK_REFERENCES_INTERVAL);
    }

    private void addInstance(Object obj, long j5) {
        if (j5 >= 0) {
            WeakReference weakReference = new WeakReference(obj, this.referenceQueue);
            this.identifiers.put(obj, Long.valueOf(j5));
            this.weakInstances.put(Long.valueOf(j5), weakReference);
            this.weakReferencesToIdentifiers.put(weakReference, Long.valueOf(j5));
            this.strongInstances.put(Long.valueOf(j5), obj);
            return;
        }
        throw new IllegalArgumentException("Identifier must be >= 0.");
    }

    private void assertManagerIsNotClosed() {
        if (this.isClosed) {
            throw new AssertionError("Manager has already been closed.");
        }
    }

    public static InstanceManager open(FinalizationListener finalizationListener2) {
        return new InstanceManager(finalizationListener2);
    }

    /* access modifiers changed from: private */
    public void releaseAllFinalizedInstances() {
        while (true) {
            WeakReference weakReference = (WeakReference) this.referenceQueue.poll();
            if (weakReference != null) {
                Long remove = this.weakReferencesToIdentifiers.remove(weakReference);
                if (remove != null) {
                    this.weakInstances.remove(remove);
                    this.strongInstances.remove(remove);
                    this.finalizationListener.onFinalize(remove.longValue());
                }
            } else {
                this.handler.postDelayed(new a2(this), CLEAR_FINALIZED_WEAK_REFERENCES_INTERVAL);
                return;
            }
        }
    }

    public void addDartCreatedInstance(Object obj, long j5) {
        assertManagerIsNotClosed();
        addInstance(obj, j5);
    }

    public long addHostCreatedInstance(Object obj) {
        assertManagerIsNotClosed();
        long j5 = this.nextIdentifier;
        this.nextIdentifier = 1 + j5;
        addInstance(obj, j5);
        return j5;
    }

    public void close() {
        this.handler.removeCallbacks(new a2(this));
        this.isClosed = true;
    }

    public boolean containsInstance(Object obj) {
        assertManagerIsNotClosed();
        return this.identifiers.containsKey(obj);
    }

    public Long getIdentifierForStrongReference(Object obj) {
        assertManagerIsNotClosed();
        Long l5 = this.identifiers.get(obj);
        if (l5 != null) {
            this.strongInstances.put(l5, obj);
        }
        return l5;
    }

    public <T> T getInstance(long j5) {
        assertManagerIsNotClosed();
        WeakReference weakReference = this.weakInstances.get(Long.valueOf(j5));
        return weakReference != null ? weakReference.get() : this.strongInstances.get(Long.valueOf(j5));
    }

    public <T> T remove(long j5) {
        assertManagerIsNotClosed();
        return this.strongInstances.remove(Long.valueOf(j5));
    }
}
