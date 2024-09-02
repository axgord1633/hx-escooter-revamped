package androidx.core.widget;

import android.widget.ListView;

public final class i {

    static class a {
        static boolean a(ListView listView, int i5) {
            return listView.canScrollList(i5);
        }

        static void b(ListView listView, int i5) {
            listView.scrollListBy(i5);
        }
    }

    public static void a(ListView listView, int i5) {
        a.b(listView, i5);
    }
}
