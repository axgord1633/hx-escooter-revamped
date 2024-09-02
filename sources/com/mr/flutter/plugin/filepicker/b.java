package com.mr.flutter.plugin.filepicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class b implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {

    /* renamed from: m  reason: collision with root package name */
    private static final int f3860m = ((FilePickerPlugin.class.hashCode() + 43) & 65535);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Activity f3861e;

    /* renamed from: f  reason: collision with root package name */
    private final d f3862f;

    /* renamed from: g  reason: collision with root package name */
    private MethodChannel.Result f3863g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3864h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f3865i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f3866j;

    /* renamed from: k  reason: collision with root package name */
    private String[] f3867k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public EventChannel.EventSink f3868l;

    class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f3869a;

        a(Activity activity) {
            this.f3869a = activity;
        }

        public void askForPermission(String str, int i5) {
            androidx.core.app.b.o(this.f3869a, new String[]{str}, i5);
        }

        public boolean isPermissionGranted(String str) {
            return androidx.core.content.a.a(this.f3869a, str) == 0;
        }
    }

    /* renamed from: com.mr.flutter.plugin.filepicker.b$b  reason: collision with other inner class name */
    class C0069b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Intent f3870e;

        C0069b(Intent intent) {
            this.f3870e = intent;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x013b, code lost:
            r2 = (android.net.Uri) r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                android.content.Intent r0 = r9.f3870e
                java.lang.String r1 = "Unknown activity error, please fill an issue."
                java.lang.String r2 = "unknown_activity"
                if (r0 == 0) goto L_0x0176
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                android.content.Intent r3 = r9.f3870e
                android.content.ClipData r3 = r3.getClipData()
                java.lang.String r4 = " - URI: "
                java.lang.String r5 = "[MultiFilePick] File #"
                r6 = 0
                java.lang.String r7 = "FilePickerDelegate"
                if (r3 == 0) goto L_0x006a
                android.content.Intent r1 = r9.f3870e
                android.content.ClipData r1 = r1.getClipData()
                int r1 = r1.getItemCount()
            L_0x0026:
                if (r6 >= r1) goto L_0x00f5
                android.content.Intent r2 = r9.f3870e
                android.content.ClipData r2 = r2.getClipData()
                android.content.ClipData$Item r2 = r2.getItemAt(r6)
                android.net.Uri r2 = r2.getUri()
                com.mr.flutter.plugin.filepicker.b r3 = com.mr.flutter.plugin.filepicker.b.this
                android.app.Activity r3 = r3.f3861e
                com.mr.flutter.plugin.filepicker.b r8 = com.mr.flutter.plugin.filepicker.b.this
                boolean r8 = r8.f3865i
                com.mr.flutter.plugin.filepicker.a r3 = com.mr.flutter.plugin.filepicker.c.k(r3, r2, r8)
                if (r3 == 0) goto L_0x0067
                r0.add(r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r5)
                r3.append(r6)
                r3.append(r4)
                java.lang.String r2 = r2.getPath()
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                android.util.Log.d(r7, r2)
            L_0x0067:
                int r6 = r6 + 1
                goto L_0x0026
            L_0x006a:
                android.content.Intent r3 = r9.f3870e
                android.net.Uri r3 = r3.getData()
                java.lang.String r8 = "unknown_path"
                if (r3 == 0) goto L_0x0105
                android.content.Intent r1 = r9.f3870e
                android.net.Uri r1 = r1.getData()
                com.mr.flutter.plugin.filepicker.b r2 = com.mr.flutter.plugin.filepicker.b.this
                java.lang.String r2 = r2.f3866j
                java.lang.String r3 = "dir"
                boolean r2 = r2.equals(r3)
                if (r2 == 0) goto L_0x00c2
                java.lang.String r0 = android.provider.DocumentsContract.getTreeDocumentId(r1)
                android.net.Uri r0 = android.provider.DocumentsContract.buildDocumentUriUsingTree(r1, r0)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "[SingleFilePick] File URI:"
                r1.append(r2)
                java.lang.String r2 = r0.toString()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                android.util.Log.d(r7, r1)
                com.mr.flutter.plugin.filepicker.b r1 = com.mr.flutter.plugin.filepicker.b.this
                android.app.Activity r1 = r1.f3861e
                java.lang.String r0 = com.mr.flutter.plugin.filepicker.c.e(r0, r1)
                if (r0 == 0) goto L_0x00ba
                com.mr.flutter.plugin.filepicker.b r1 = com.mr.flutter.plugin.filepicker.b.this
                r1.l(r0)
                goto L_0x00c1
            L_0x00ba:
                com.mr.flutter.plugin.filepicker.b r0 = com.mr.flutter.plugin.filepicker.b.this
                java.lang.String r1 = "Failed to retrieve directory path."
                r0.k(r8, r1)
            L_0x00c1:
                return
            L_0x00c2:
                com.mr.flutter.plugin.filepicker.b r2 = com.mr.flutter.plugin.filepicker.b.this
                android.app.Activity r2 = r2.f3861e
                com.mr.flutter.plugin.filepicker.b r3 = com.mr.flutter.plugin.filepicker.b.this
                boolean r3 = r3.f3865i
                com.mr.flutter.plugin.filepicker.a r1 = com.mr.flutter.plugin.filepicker.c.k(r2, r1, r3)
                if (r1 == 0) goto L_0x00d7
                r0.add(r1)
            L_0x00d7:
                boolean r1 = r0.isEmpty()
                if (r1 != 0) goto L_0x00fc
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "File path:"
                r1.append(r2)
                java.lang.String r2 = r0.toString()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                android.util.Log.d(r7, r1)
            L_0x00f5:
                com.mr.flutter.plugin.filepicker.b r1 = com.mr.flutter.plugin.filepicker.b.this
                r1.l(r0)
                goto L_0x017b
            L_0x00fc:
                com.mr.flutter.plugin.filepicker.b r0 = com.mr.flutter.plugin.filepicker.b.this
                java.lang.String r1 = "Failed to retrieve path."
            L_0x0100:
                r0.k(r8, r1)
                goto L_0x017b
            L_0x0105:
                android.content.Intent r3 = r9.f3870e
                android.os.Bundle r3 = r3.getExtras()
                if (r3 == 0) goto L_0x0176
                android.content.Intent r1 = r9.f3870e
                android.os.Bundle r1 = r1.getExtras()
                java.util.Set r2 = r1.keySet()
                java.lang.String r3 = "selectedItems"
                boolean r2 = r2.contains(r3)
                if (r2 == 0) goto L_0x0171
                com.mr.flutter.plugin.filepicker.b r2 = com.mr.flutter.plugin.filepicker.b.this
                java.util.ArrayList r1 = r2.m(r1)
                if (r1 == 0) goto L_0x00f5
                java.util.Iterator r1 = r1.iterator()
            L_0x012b:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x00f5
                java.lang.Object r2 = r1.next()
                android.os.Parcelable r2 = (android.os.Parcelable) r2
                boolean r3 = r2 instanceof android.net.Uri
                if (r3 == 0) goto L_0x016e
                android.net.Uri r2 = (android.net.Uri) r2
                com.mr.flutter.plugin.filepicker.b r3 = com.mr.flutter.plugin.filepicker.b.this
                android.app.Activity r3 = r3.f3861e
                com.mr.flutter.plugin.filepicker.b r8 = com.mr.flutter.plugin.filepicker.b.this
                boolean r8 = r8.f3865i
                com.mr.flutter.plugin.filepicker.a r3 = com.mr.flutter.plugin.filepicker.c.k(r3, r2, r8)
                if (r3 == 0) goto L_0x016e
                r0.add(r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r5)
                r3.append(r6)
                r3.append(r4)
                java.lang.String r2 = r2.getPath()
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                android.util.Log.d(r7, r2)
            L_0x016e:
                int r6 = r6 + 1
                goto L_0x012b
            L_0x0171:
                com.mr.flutter.plugin.filepicker.b r0 = com.mr.flutter.plugin.filepicker.b.this
                java.lang.String r1 = "Failed to retrieve path from bundle."
                goto L_0x0100
            L_0x0176:
                com.mr.flutter.plugin.filepicker.b r0 = com.mr.flutter.plugin.filepicker.b.this
                r0.k(r2, r1)
            L_0x017b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mr.flutter.plugin.filepicker.b.C0069b.run():void");
        }
    }

    class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f3872a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Looper looper, boolean z4) {
            super(looper);
            this.f3872a = z4;
        }

        public void handleMessage(Message message) {
            b.this.f3868l.success(Boolean.valueOf(this.f3872a));
        }
    }

    interface d {
        void askForPermission(String str, int i5);

        boolean isPermissionGranted(String str);
    }

    public b(Activity activity) {
        this(activity, (MethodChannel.Result) null, new a(activity));
    }

    b(Activity activity, MethodChannel.Result result, d dVar) {
        this.f3864h = false;
        this.f3865i = false;
        this.f3861e = activity;
        this.f3863g = result;
        this.f3862f = dVar;
    }

    private void h() {
        this.f3863g = null;
    }

    private void i(boolean z4) {
        if (this.f3868l != null && !this.f3866j.equals("dir")) {
            new c(Looper.getMainLooper(), z4).obtainMessage().sendToTarget();
        }
    }

    private static void j(MethodChannel.Result result) {
        result.error("already_active", "File picker is already active", (Object) null);
    }

    /* access modifiers changed from: private */
    public void k(String str, String str2) {
        if (this.f3863g != null) {
            i(false);
            this.f3863g.error(str, str2, (Object) null);
            h();
        }
    }

    /* access modifiers changed from: private */
    public void l(Object obj) {
        i(false);
        if (this.f3863g != null) {
            if (obj != null && !(obj instanceof String)) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    arrayList.add(((a) it.next()).a());
                }
                obj = arrayList;
            }
            this.f3863g.success(obj);
            h();
        }
    }

    /* access modifiers changed from: private */
    public ArrayList<Parcelable> m(Bundle bundle) {
        return Build.VERSION.SDK_INT >= 33 ? bundle.getParcelableArrayList("selectedItems", Parcelable.class) : bundle.getParcelableArrayList("selectedItems");
    }

    private boolean o(MethodChannel.Result result) {
        if (this.f3863g != null) {
            return false;
        }
        this.f3863g = result;
        return true;
    }

    private void p() {
        Intent intent;
        String str = this.f3866j;
        if (str != null) {
            if (str.equals("dir")) {
                intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            } else {
                if (this.f3866j.equals("image/*")) {
                    intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                } else {
                    intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                }
                Uri parse = Uri.parse(Environment.getExternalStorageDirectory().getPath() + File.separator);
                Log.d("FilePickerDelegate", "Selected type " + this.f3866j);
                intent.setDataAndType(parse, this.f3866j);
                intent.setType(this.f3866j);
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", this.f3864h);
                intent.putExtra("multi-pick", this.f3864h);
                if (this.f3866j.contains(",")) {
                    this.f3867k = this.f3866j.split(",");
                }
                String[] strArr = this.f3867k;
                if (strArr != null) {
                    intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
                }
            }
            if (intent.resolveActivity(this.f3861e.getPackageManager()) != null) {
                this.f3861e.startActivityForResult(intent, f3860m);
                return;
            }
            Log.e("FilePickerDelegate", "Can't find a valid activity to handle the request. Make sure you've a file explorer installed.");
            k("invalid_format_type", "Can't handle the provided file type.");
        }
    }

    public void n(EventChannel.EventSink eventSink) {
        this.f3868l = eventSink;
    }

    public boolean onActivityResult(int i5, int i6, Intent intent) {
        if (this.f3866j == null) {
            return false;
        }
        int i7 = f3860m;
        if (i5 == i7 && i6 == -1) {
            i(true);
            new Thread(new C0069b(intent)).start();
            return true;
        } else if (i5 == i7 && i6 == 0) {
            Log.i("FilePickerDelegate", "User cancelled the picker request");
            l((Object) null);
            return true;
        } else {
            if (i5 == i7) {
                k("unknown_activity", "Unknown activity error, please fill an issue.");
            }
            return false;
        }
    }

    public boolean onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        boolean z4 = false;
        if (f3860m != i5) {
            return false;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            z4 = true;
        }
        if (z4) {
            p();
        } else {
            k("read_external_storage_denied", "User did not allow reading external storage");
        }
        return true;
    }

    public void q(String str, boolean z4, boolean z5, String[] strArr, MethodChannel.Result result) {
        if (!o(result)) {
            j(result);
            return;
        }
        this.f3866j = str;
        this.f3864h = z4;
        this.f3865i = z5;
        this.f3867k = strArr;
        if (Build.VERSION.SDK_INT >= 33 || this.f3862f.isPermissionGranted("android.permission.READ_EXTERNAL_STORAGE")) {
            p();
        } else {
            this.f3862f.askForPermission("android.permission.READ_EXTERNAL_STORAGE", f3860m);
        }
    }
}
