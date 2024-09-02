package d2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import com.yalantis.ucrop.BuildConfig;
import f2.e;
import f2.g;
import f2.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class i {

    /* renamed from: n  reason: collision with root package name */
    private static Boolean f4273n;

    /* renamed from: a  reason: collision with root package name */
    final boolean f4274a;

    /* renamed from: b  reason: collision with root package name */
    final String f4275b;

    /* renamed from: c  reason: collision with root package name */
    final int f4276c;

    /* renamed from: d  reason: collision with root package name */
    final int f4277d;

    /* renamed from: e  reason: collision with root package name */
    final Context f4278e;

    /* renamed from: f  reason: collision with root package name */
    final List<g> f4279f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    final Map<Integer, t> f4280g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public o f4281h;

    /* renamed from: i  reason: collision with root package name */
    SQLiteDatabase f4282i;

    /* renamed from: j  reason: collision with root package name */
    private int f4283j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f4284k = 0;

    /* renamed from: l  reason: collision with root package name */
    private Integer f4285l;

    /* renamed from: m  reason: collision with root package name */
    private int f4286m = 0;

    class a implements DatabaseErrorHandler {
        a() {
        }

        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        }
    }

    i(Context context, String str, int i5, boolean z4, int i6) {
        this.f4278e = context;
        this.f4275b = str;
        this.f4274a = z4;
        this.f4276c = i5;
        this.f4277d = i6;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(e eVar) {
        Boolean d5 = eVar.d();
        boolean z4 = Boolean.TRUE.equals(d5) && eVar.f();
        if (z4) {
            int i5 = this.f4284k + 1;
            this.f4284k = i5;
            this.f4285l = Integer.valueOf(i5);
        }
        if (!w(eVar)) {
            if (z4) {
                this.f4285l = null;
            }
        } else if (z4) {
            HashMap hashMap = new HashMap();
            hashMap.put("transactionId", this.f4285l);
            eVar.success(hashMap);
        } else {
            if (Boolean.FALSE.equals(d5)) {
                this.f4285l = null;
            }
            eVar.success((Object) null);
        }
    }

    /* access modifiers changed from: private */
    public void Q() {
        while (!this.f4279f.isEmpty() && this.f4285l == null) {
            this.f4279f.get(0).a();
            this.f4279f.remove(0);
        }
    }

    private void S(e eVar, Runnable runnable) {
        Integer e5 = eVar.e();
        Integer num = this.f4285l;
        if (num == null) {
            runnable.run();
        } else if (e5 == null || (!e5.equals(num) && e5.intValue() != -1)) {
            this.f4279f.add(new g(eVar, runnable));
        } else {
            runnable.run();
            if (this.f4285l == null && !this.f4279f.isEmpty()) {
                this.f4281h.a(this, new h(this));
            }
        }
    }

    protected static boolean i(Context context, String str, boolean z4) {
        try {
            String packageName = context.getPackageName();
            return (Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(128)) : y(context, packageName, 128)).metaData.getBoolean(str, z4);
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        }
    }

    protected static boolean j(Context context) {
        return i(context, "com.tekartik.sqflite.wal_enabled", false);
    }

    private void l(int i5) {
        t tVar = this.f4280g.get(Integer.valueOf(i5));
        if (tVar != null) {
            m(tVar);
        }
    }

    private void m(t tVar) {
        try {
            int i5 = tVar.f4313a;
            if (r.c(this.f4277d)) {
                Log.d("Sqflite", A() + "closing cursor " + i5);
            }
            this.f4280g.remove(Integer.valueOf(i5));
            tVar.f4315c.close();
        } catch (Exception unused) {
        }
    }

    private Map<String, Object> n(Cursor cursor, Integer num) {
        HashMap hashMap = null;
        int i5 = 0;
        ArrayList arrayList = null;
        while (cursor.moveToNext()) {
            if (hashMap == null) {
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap2 = new HashMap();
                i5 = cursor.getColumnCount();
                hashMap2.put("columns", Arrays.asList(cursor.getColumnNames()));
                hashMap2.put("rows", arrayList2);
                HashMap hashMap3 = hashMap2;
                arrayList = arrayList2;
                hashMap = hashMap3;
            }
            arrayList.add(e0.a(cursor, i5));
            if (num != null && arrayList.size() >= num.intValue()) {
                break;
            }
        }
        return hashMap == null ? new HashMap() : hashMap;
    }

    static void o(String str) {
        SQLiteDatabase.deleteDatabase(new File(str));
    }

    private boolean p(e eVar) {
        if (!w(eVar)) {
            return false;
        }
        eVar.success((Object) null);
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf  */
    /* renamed from: q */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean I(f2.e r10) {
        /*
            r9 = this;
            boolean r0 = r9.w(r10)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r10.c()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0014
            r10.success(r2)
            return r3
        L_0x0014:
            java.lang.String r0 = "SELECT changes(), last_insert_rowid()"
            android.database.sqlite.SQLiteDatabase r4 = r9.C()     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
            android.database.Cursor r0 = r4.rawQuery(r0, r2)     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
            java.lang.String r4 = "Sqflite"
            if (r0 == 0) goto L_0x009b
            int r5 = r0.getCount()     // Catch:{ Exception -> 0x0099 }
            if (r5 <= 0) goto L_0x009b
            boolean r5 = r0.moveToFirst()     // Catch:{ Exception -> 0x0099 }
            if (r5 == 0) goto L_0x009b
            int r5 = r0.getInt(r1)     // Catch:{ Exception -> 0x0099 }
            if (r5 != 0) goto L_0x0067
            int r5 = r9.f4277d     // Catch:{ Exception -> 0x0099 }
            boolean r5 = d2.r.b(r5)     // Catch:{ Exception -> 0x0099 }
            if (r5 == 0) goto L_0x0060
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r5.<init>()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = r9.A()     // Catch:{ Exception -> 0x0099 }
            r5.append(r6)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = "no changes (id was "
            r5.append(r6)     // Catch:{ Exception -> 0x0099 }
            long r6 = r0.getLong(r3)     // Catch:{ Exception -> 0x0099 }
            r5.append(r6)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0099 }
            android.util.Log.d(r4, r5)     // Catch:{ Exception -> 0x0099 }
        L_0x0060:
            r10.success(r2)     // Catch:{ Exception -> 0x0099 }
            r0.close()
            return r3
        L_0x0067:
            long r5 = r0.getLong(r3)     // Catch:{ Exception -> 0x0099 }
            int r2 = r9.f4277d     // Catch:{ Exception -> 0x0099 }
            boolean r2 = d2.r.b(r2)     // Catch:{ Exception -> 0x0099 }
            if (r2 == 0) goto L_0x008e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r2.<init>()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r7 = r9.A()     // Catch:{ Exception -> 0x0099 }
            r2.append(r7)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r7 = "inserted "
            r2.append(r7)     // Catch:{ Exception -> 0x0099 }
            r2.append(r5)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0099 }
            android.util.Log.d(r4, r2)     // Catch:{ Exception -> 0x0099 }
        L_0x008e:
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x0099 }
            r10.success(r2)     // Catch:{ Exception -> 0x0099 }
            r0.close()
            return r3
        L_0x0099:
            r2 = move-exception
            goto L_0x00c2
        L_0x009b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r5.<init>()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = r9.A()     // Catch:{ Exception -> 0x0099 }
            r5.append(r6)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = "fail to read changes for Insert"
            r5.append(r6)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0099 }
            android.util.Log.e(r4, r5)     // Catch:{ Exception -> 0x0099 }
            r10.success(r2)     // Catch:{ Exception -> 0x0099 }
            if (r0 == 0) goto L_0x00bb
            r0.close()
        L_0x00bb:
            return r3
        L_0x00bc:
            r10 = move-exception
            goto L_0x00cd
        L_0x00be:
            r0 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
        L_0x00c2:
            r9.D(r2, r10)     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x00ca
            r0.close()
        L_0x00ca:
            return r1
        L_0x00cb:
            r10 = move-exception
            r2 = r0
        L_0x00cd:
            if (r2 == 0) goto L_0x00d2
            r2.close()
        L_0x00d2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.i.I(f2.e):boolean");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0098 A[Catch:{ all -> 0x00a3 }] */
    /* renamed from: r */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean J(f2.e r10) {
        /*
            r9 = this;
            java.lang.String r0 = "cursorPageSize"
            java.lang.Object r0 = r10.a(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            d2.d0 r1 = r10.b()
            int r2 = r9.f4277d
            boolean r2 = d2.r.b(r2)
            if (r2 == 0) goto L_0x002c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r9.A()
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Sqflite"
            android.util.Log.d(r3, r2)
        L_0x002c:
            r2 = 0
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r9.z()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            d2.f r5 = new d2.f     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.lang.String[] r6 = d2.a.f4233a     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            android.database.Cursor r1 = r4.rawQueryWithFactory(r5, r1, r6, r2)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.util.Map r4 = r9.n(r1, r0)     // Catch:{ Exception -> 0x008c }
            r5 = 1
            if (r0 == 0) goto L_0x0056
            boolean r6 = r1.isLast()     // Catch:{ Exception -> 0x008c }
            if (r6 != 0) goto L_0x0056
            boolean r6 = r1.isAfterLast()     // Catch:{ Exception -> 0x008c }
            if (r6 != 0) goto L_0x0056
            r6 = r5
            goto L_0x0057
        L_0x0056:
            r6 = r3
        L_0x0057:
            if (r6 == 0) goto L_0x0081
            int r6 = r9.f4286m     // Catch:{ Exception -> 0x008c }
            int r6 = r6 + r5
            r9.f4286m = r6     // Catch:{ Exception -> 0x008c }
            java.lang.String r7 = "cursorId"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x008c }
            r4.put(r7, r8)     // Catch:{ Exception -> 0x008c }
            d2.t r7 = new d2.t     // Catch:{ Exception -> 0x008c }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x008c }
            r7.<init>(r6, r0, r1)     // Catch:{ Exception -> 0x008c }
            java.util.Map<java.lang.Integer, d2.t> r0 = r9.f4280g     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            r0.put(r2, r7)     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            r2 = r7
            goto L_0x0081
        L_0x007b:
            r10 = move-exception
            r2 = r7
            goto L_0x00a4
        L_0x007e:
            r0 = move-exception
            r2 = r7
            goto L_0x0093
        L_0x0081:
            r10.success(r4)     // Catch:{ Exception -> 0x008c }
            if (r2 != 0) goto L_0x008b
            if (r1 == 0) goto L_0x008b
            r1.close()
        L_0x008b:
            return r5
        L_0x008c:
            r0 = move-exception
            goto L_0x0093
        L_0x008e:
            r10 = move-exception
            r1 = r2
            goto L_0x00a4
        L_0x0091:
            r0 = move-exception
            r1 = r2
        L_0x0093:
            r9.D(r0, r10)     // Catch:{ all -> 0x00a3 }
            if (r2 == 0) goto L_0x009b
            r9.m(r2)     // Catch:{ all -> 0x00a3 }
        L_0x009b:
            if (r2 != 0) goto L_0x00a2
            if (r1 == 0) goto L_0x00a2
            r1.close()
        L_0x00a2:
            return r3
        L_0x00a3:
            r10 = move-exception
        L_0x00a4:
            if (r2 != 0) goto L_0x00ab
            if (r1 == 0) goto L_0x00ab
            r1.close()
        L_0x00ab:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.i.J(f2.e):boolean");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b6 A[Catch:{ all -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ba  */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean K(f2.e r10) {
        /*
            r9 = this;
            java.lang.String r0 = "cursorId"
            java.lang.Object r1 = r10.a(r0)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.String r3 = "cancel"
            java.lang.Object r3 = r10.a(r3)
            boolean r2 = r2.equals(r3)
            int r3 = r9.f4277d
            boolean r3 = d2.r.c(r3)
            if (r3 == 0) goto L_0x0047
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r9.A()
            r3.append(r4)
            java.lang.String r4 = "cursor "
            r3.append(r4)
            r3.append(r1)
            if (r2 == 0) goto L_0x0039
            java.lang.String r4 = " cancel"
            goto L_0x003b
        L_0x0039:
            java.lang.String r4 = " next"
        L_0x003b:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "Sqflite"
            android.util.Log.d(r4, r3)
        L_0x0047:
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0052
            r9.l(r1)
            r10.success(r3)
            return r4
        L_0x0052:
            java.util.Map<java.lang.Integer, d2.t> r2 = r9.f4280g
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            java.lang.Object r2 = r2.get(r5)
            d2.t r2 = (d2.t) r2
            r5 = 0
            if (r2 == 0) goto L_0x0095
            android.database.Cursor r6 = r2.f4315c     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            int r7 = r2.f4314b     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            java.util.Map r7 = r9.n(r6, r7)     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            boolean r8 = r6.isLast()     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            if (r8 != 0) goto L_0x007b
            boolean r6 = r6.isAfterLast()     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            if (r6 != 0) goto L_0x007b
            r6 = r4
            goto L_0x007c
        L_0x007b:
            r6 = r5
        L_0x007c:
            if (r6 == 0) goto L_0x0085
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x008e }
            r7.put(r0, r1)     // Catch:{ Exception -> 0x008e }
        L_0x0085:
            r10.success(r7)     // Catch:{ Exception -> 0x008e }
            if (r6 != 0) goto L_0x008d
            r9.m(r2)
        L_0x008d:
            return r4
        L_0x008e:
            r0 = move-exception
            goto L_0x00b1
        L_0x0090:
            r10 = move-exception
            goto L_0x00c5
        L_0x0092:
            r0 = move-exception
            r6 = r5
            goto L_0x00b1
        L_0x0095:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            r4.<init>()     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            java.lang.String r6 = "Cursor "
            r4.append(r6)     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            r4.append(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            java.lang.String r1 = " not found"
            r4.append(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            throw r0     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
        L_0x00b1:
            r9.D(r0, r10)     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x00ba
            r9.m(r2)     // Catch:{ all -> 0x00c3 }
            goto L_0x00bb
        L_0x00ba:
            r3 = r2
        L_0x00bb:
            if (r6 != 0) goto L_0x00c2
            if (r3 == 0) goto L_0x00c2
            r9.m(r3)
        L_0x00c2:
            return r5
        L_0x00c3:
            r10 = move-exception
            r5 = r6
        L_0x00c5:
            if (r5 != 0) goto L_0x00cc
            if (r2 == 0) goto L_0x00cc
            r9.m(r2)
        L_0x00cc:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.i.K(f2.e):boolean");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0095  */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean L(f2.e r8) {
        /*
            r7 = this;
            boolean r0 = r7.w(r8)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r8.c()
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0014
            r8.success(r3)
            return r2
        L_0x0014:
            android.database.sqlite.SQLiteDatabase r0 = r7.C()     // Catch:{ Exception -> 0x0089 }
            java.lang.String r4 = "SELECT changes()"
            android.database.Cursor r0 = r0.rawQuery(r4, r3)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r4 = "Sqflite"
            if (r0 == 0) goto L_0x0066
            int r5 = r0.getCount()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            if (r5 <= 0) goto L_0x0066
            boolean r5 = r0.moveToFirst()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            if (r5 == 0) goto L_0x0066
            int r3 = r0.getInt(r1)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            int r5 = r7.f4277d     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            boolean r5 = d2.r.b(r5)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            if (r5 == 0) goto L_0x0055
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r5.<init>()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r6 = r7.A()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r5.append(r6)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r6 = "changed "
            r5.append(r6)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r5.append(r3)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            android.util.Log.d(r4, r5)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
        L_0x0055:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r8.success(r3)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r0.close()
            return r2
        L_0x0060:
            r8 = move-exception
            r3 = r0
            goto L_0x0093
        L_0x0063:
            r2 = move-exception
            r3 = r0
            goto L_0x008a
        L_0x0066:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r5.<init>()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r6 = r7.A()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r5.append(r6)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r6 = "fail to read changes for Update/Delete"
            r5.append(r6)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            android.util.Log.e(r4, r5)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r8.success(r3)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            if (r0 == 0) goto L_0x0086
            r0.close()
        L_0x0086:
            return r2
        L_0x0087:
            r8 = move-exception
            goto L_0x0093
        L_0x0089:
            r2 = move-exception
        L_0x008a:
            r7.D(r2, r8)     // Catch:{ all -> 0x0087 }
            if (r3 == 0) goto L_0x0092
            r3.close()
        L_0x0092:
            return r1
        L_0x0093:
            if (r3 == 0) goto L_0x0098
            r3.close()
        L_0x0098:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.i.L(f2.e):boolean");
    }

    private boolean w(e eVar) {
        d0 b5 = eVar.b();
        if (r.b(this.f4277d)) {
            Log.d("Sqflite", A() + b5);
        }
        Boolean d5 = eVar.d();
        try {
            C().execSQL(b5.c(), b5.d());
            u(d5);
            return true;
        } catch (Exception e5) {
            D(e5, eVar);
            return false;
        }
    }

    public static boolean x(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    static ApplicationInfo y(Context context, String str, int i5) {
        return context.getPackageManager().getApplicationInfo(str, i5);
    }

    /* access modifiers changed from: package-private */
    public String A() {
        return "[" + B() + "] ";
    }

    /* access modifiers changed from: package-private */
    public String B() {
        Thread currentThread = Thread.currentThread();
        return BuildConfig.FLAVOR + this.f4276c + "," + currentThread.getName() + "(" + currentThread.getId() + ")";
    }

    public SQLiteDatabase C() {
        return this.f4282i;
    }

    /* access modifiers changed from: package-private */
    public void D(Exception exc, e eVar) {
        String message;
        Map<String, Object> a5;
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            message = "open_failed " + this.f4275b;
            a5 = null;
        } else {
            boolean z4 = exc instanceof SQLException;
            message = exc.getMessage();
            a5 = h.a(eVar);
        }
        eVar.error("sqlite_error", message, a5);
    }

    public void E(e eVar) {
        S(eVar, new d(this, eVar));
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean F() {
        return this.f4283j > 0;
    }

    public void M() {
        if (f4273n == null) {
            Boolean valueOf = Boolean.valueOf(j(this.f4278e));
            f4273n = valueOf;
            if (valueOf.booleanValue() && r.c(this.f4277d)) {
                Log.d("Sqflite", A() + "[sqflite] WAL enabled");
            }
        }
        this.f4282i = SQLiteDatabase.openDatabase(this.f4275b, (SQLiteDatabase.CursorFactory) null, f4273n.booleanValue() ? 805306368 : 268435456);
    }

    public void N() {
        this.f4282i = SQLiteDatabase.openDatabase(this.f4275b, (SQLiteDatabase.CursorFactory) null, 1, new a());
    }

    public void O(e eVar) {
        S(eVar, new e(this, eVar));
    }

    public void P(e eVar) {
        S(eVar, new b(this, eVar));
    }

    public void R(e eVar) {
        S(eVar, new g(this, eVar));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ba, code lost:
        r5.q(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c1, code lost:
        r5.p(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(io.flutter.plugin.common.MethodCall r9, io.flutter.plugin.common.MethodChannel.Result r10) {
        /*
            r8 = this;
            f2.d r0 = new f2.d
            r0.<init>(r9, r10)
            boolean r9 = r0.c()
            boolean r1 = r0.i()
            java.lang.String r2 = "operations"
            java.lang.Object r0 = r0.a(r2)
            java.util.List r0 = (java.util.List) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x001e:
            boolean r3 = r0.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x00ca
            java.lang.Object r3 = r0.next()
            java.util.Map r3 = (java.util.Map) r3
            f2.c r5 = new f2.c
            r5.<init>(r3, r9)
            java.lang.String r3 = r5.getMethod()
            r3.hashCode()
            r6 = -1
            int r7 = r3.hashCode()
            switch(r7) {
                case -1319569547: goto L_0x0061;
                case -1183792455: goto L_0x0056;
                case -838846263: goto L_0x004b;
                case 107944136: goto L_0x0040;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x006b
        L_0x0040:
            java.lang.String r7 = "query"
            boolean r7 = r3.equals(r7)
            if (r7 != 0) goto L_0x0049
            goto L_0x006b
        L_0x0049:
            r6 = 3
            goto L_0x006b
        L_0x004b:
            java.lang.String r7 = "update"
            boolean r7 = r3.equals(r7)
            if (r7 != 0) goto L_0x0054
            goto L_0x006b
        L_0x0054:
            r6 = 2
            goto L_0x006b
        L_0x0056:
            java.lang.String r7 = "insert"
            boolean r7 = r3.equals(r7)
            if (r7 != 0) goto L_0x005f
            goto L_0x006b
        L_0x005f:
            r6 = 1
            goto L_0x006b
        L_0x0061:
            java.lang.String r7 = "execute"
            boolean r7 = r3.equals(r7)
            if (r7 != 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r6 = 0
        L_0x006b:
            switch(r6) {
                case 0: goto L_0x00b4;
                case 1: goto L_0x00a6;
                case 2: goto L_0x0098;
                case 3: goto L_0x008a;
                default: goto L_0x006e;
            }
        L_0x006e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Batch method '"
            r9.append(r0)
            r9.append(r3)
            java.lang.String r0 = "' not supported"
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = "bad_param"
            r10.error(r0, r9, r4)
            return
        L_0x008a:
            boolean r3 = r8.J(r5)
            if (r3 == 0) goto L_0x0091
            goto L_0x00ba
        L_0x0091:
            if (r1 == 0) goto L_0x0094
            goto L_0x00af
        L_0x0094:
            r5.o(r10)
            return
        L_0x0098:
            boolean r3 = r8.L(r5)
            if (r3 == 0) goto L_0x009f
            goto L_0x00ba
        L_0x009f:
            if (r1 == 0) goto L_0x00a2
            goto L_0x00af
        L_0x00a2:
            r5.o(r10)
            return
        L_0x00a6:
            boolean r3 = r8.I(r5)
            if (r3 == 0) goto L_0x00ad
            goto L_0x00ba
        L_0x00ad:
            if (r1 == 0) goto L_0x00b0
        L_0x00af:
            goto L_0x00c1
        L_0x00b0:
            r5.o(r10)
            return
        L_0x00b4:
            boolean r3 = r8.p(r5)
            if (r3 == 0) goto L_0x00bf
        L_0x00ba:
            r5.q(r2)
            goto L_0x001e
        L_0x00bf:
            if (r1 == 0) goto L_0x00c6
        L_0x00c1:
            r5.p(r2)
            goto L_0x001e
        L_0x00c6:
            r5.o(r10)
            return
        L_0x00ca:
            if (r9 == 0) goto L_0x00d0
            r10.success(r4)
            goto L_0x00d3
        L_0x00d0:
            r10.success(r2)
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.i.h(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public void k() {
        if (!this.f4280g.isEmpty() && r.b(this.f4277d)) {
            Log.d("Sqflite", A() + this.f4280g.size() + " cursor(s) are left opened");
        }
        this.f4282i.close();
    }

    /* access modifiers changed from: package-private */
    public synchronized void u(Boolean bool) {
        if (Boolean.TRUE.equals(bool)) {
            this.f4283j++;
        } else if (Boolean.FALSE.equals(bool)) {
            this.f4283j--;
        }
    }

    public void v(e eVar) {
        S(eVar, new c(this, eVar));
    }

    public SQLiteDatabase z() {
        return this.f4282i;
    }
}
