package android.text;

import android.annotation.NonNull;

public /* synthetic */ class PrecomputedText implements Spannable {

    public final /* synthetic */ class Params {

        public /* synthetic */ class Builder {
            static {
                throw new NoClassDefFoundError();
            }

            public /* synthetic */ Builder(@NonNull TextPaint textPaint) {
            }

            @NonNull
            public native /* synthetic */ Params build();

            public native /* synthetic */ Builder setBreakStrategy(int i5);

            public native /* synthetic */ Builder setHyphenationFrequency(int i5);

            public native /* synthetic */ Builder setTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic);
        }

        static {
            throw new NoClassDefFoundError();
        }

        public native /* synthetic */ int getBreakStrategy();

        public native /* synthetic */ int getHyphenationFrequency();

        @NonNull
        public native /* synthetic */ TextDirectionHeuristic getTextDirection();

        @NonNull
        public native /* synthetic */ TextPaint getTextPaint();
    }

    static {
        throw new NoClassDefFoundError();
    }

    public native /* synthetic */ <T> T[] getSpans(int i5, int i6, Class<T> cls);

    public native /* synthetic */ void removeSpan(Object obj);

    public native /* synthetic */ void setSpan(Object obj, int i5, int i6, int i7);
}
