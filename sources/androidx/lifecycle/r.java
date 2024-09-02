package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.f;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public class r extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    public static final b f2598f = new b((g) null);

    /* renamed from: e  reason: collision with root package name */
    private a f2599e;

    public interface a {
        void a();

        void onResume();

        void onStart();
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final void a(Activity activity, f.a aVar) {
            k.e(activity, "activity");
            k.e(aVar, "event");
            if (activity instanceof l) {
                ((l) activity).getLifecycle().h(aVar);
            } else if (activity instanceof j) {
                f lifecycle = ((j) activity).getLifecycle();
                if (lifecycle instanceof k) {
                    ((k) lifecycle).h(aVar);
                }
            }
        }

        public final void b(Activity activity) {
            k.e(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                c.Companion.a(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new r(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a((g) null);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(g gVar) {
                this();
            }

            public final void a(Activity activity) {
                k.e(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.a(activity);
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            k.e(activity, "activity");
        }

        public void onActivityDestroyed(Activity activity) {
            k.e(activity, "activity");
        }

        public void onActivityPaused(Activity activity) {
            k.e(activity, "activity");
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            k.e(activity, "activity");
            r.f2598f.a(activity, f.a.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            k.e(activity, "activity");
            r.f2598f.a(activity, f.a.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            k.e(activity, "activity");
            r.f2598f.a(activity, f.a.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            k.e(activity, "activity");
            r.f2598f.a(activity, f.a.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            k.e(activity, "activity");
            r.f2598f.a(activity, f.a.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            k.e(activity, "activity");
            r.f2598f.a(activity, f.a.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
            k.e(activity, "activity");
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            k.e(activity, "activity");
            k.e(bundle, "bundle");
        }

        public void onActivityStarted(Activity activity) {
            k.e(activity, "activity");
        }

        public void onActivityStopped(Activity activity) {
            k.e(activity, "activity");
        }
    }

    private final void a(f.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            b bVar = f2598f;
            Activity activity = getActivity();
            k.d(activity, "activity");
            bVar.a(activity, aVar);
        }
    }

    private final void b(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void c(a aVar) {
        if (aVar != null) {
            aVar.onResume();
        }
    }

    private final void d(a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    public static final void e(Activity activity) {
        f2598f.b(activity);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f2599e);
        a(f.a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        a(f.a.ON_DESTROY);
        this.f2599e = null;
    }

    public void onPause() {
        super.onPause();
        a(f.a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        c(this.f2599e);
        a(f.a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        d(this.f2599e);
        a(f.a.ON_START);
    }

    public void onStop() {
        super.onStop();
        a(f.a.ON_STOP);
    }
}
