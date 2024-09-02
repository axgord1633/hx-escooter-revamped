package c;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

public class b extends a<String, List<Uri>> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3065a = new a((g) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final List<Uri> a(Intent intent) {
            k.e(intent, "<this>");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Uri data = intent.getData();
            if (data != null) {
                linkedHashSet.add(data);
            }
            ClipData clipData = intent.getClipData();
            if (clipData == null && linkedHashSet.isEmpty()) {
                return n.d();
            }
            if (clipData != null) {
                int itemCount = clipData.getItemCount();
                for (int i5 = 0; i5 < itemCount; i5++) {
                    Uri uri = clipData.getItemAt(i5).getUri();
                    if (uri != null) {
                        linkedHashSet.add(uri);
                    }
                }
            }
            return new ArrayList(linkedHashSet);
        }
    }
}
