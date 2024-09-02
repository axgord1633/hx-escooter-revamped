package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.c0;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final long f5681a = e0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);

    /* renamed from: b  reason: collision with root package name */
    public static final int f5682b = e0.d("kotlinx.coroutines.scheduler.core.pool.size", f.a(c0.a(), 2), 1, 0, 8, (Object) null);

    /* renamed from: c  reason: collision with root package name */
    public static final int f5683c = e0.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    public static final long f5684d = TimeUnit.SECONDS.toNanos(e0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));

    /* renamed from: e  reason: collision with root package name */
    public static g f5685e = e.f5671a;

    /* renamed from: f  reason: collision with root package name */
    public static final i f5686f = new j(0);

    /* renamed from: g  reason: collision with root package name */
    public static final i f5687g = new j(1);
}
