package q;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

public class c implements Spannable {

    /* renamed from: h  reason: collision with root package name */
    private static final Object f6590h = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final Spannable f6591e;

    /* renamed from: f  reason: collision with root package name */
    private final a f6592f;

    /* renamed from: g  reason: collision with root package name */
    private final PrecomputedText f6593g;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f6594a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f6595b;

        /* renamed from: c  reason: collision with root package name */
        private final int f6596c;

        /* renamed from: d  reason: collision with root package name */
        private final int f6597d;

        /* renamed from: e  reason: collision with root package name */
        final PrecomputedText.Params f6598e;

        /* renamed from: q.c$a$a  reason: collision with other inner class name */
        public static class C0101a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f6599a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f6600b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            /* renamed from: c  reason: collision with root package name */
            private int f6601c = 1;

            /* renamed from: d  reason: collision with root package name */
            private int f6602d = 1;

            public C0101a(TextPaint textPaint) {
                this.f6599a = textPaint;
            }

            public a a() {
                return new a(this.f6599a, this.f6600b, this.f6601c, this.f6602d);
            }

            public C0101a b(int i5) {
                this.f6601c = i5;
                return this;
            }

            public C0101a c(int i5) {
                this.f6602d = i5;
                return this;
            }

            public C0101a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f6600b = textDirectionHeuristic;
                return this;
            }
        }

        public a(PrecomputedText.Params params) {
            this.f6594a = params.getTextPaint();
            this.f6595b = params.getTextDirection();
            this.f6596c = params.getBreakStrategy();
            this.f6597d = params.getHyphenationFrequency();
            this.f6598e = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i5, int i6) {
            this.f6598e = Build.VERSION.SDK_INT >= 29 ? new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i5).setHyphenationFrequency(i6).setTextDirection(textDirectionHeuristic).build() : null;
            this.f6594a = textPaint;
            this.f6595b = textDirectionHeuristic;
            this.f6596c = i5;
            this.f6597d = i6;
        }

        public boolean a(a aVar) {
            int i5 = Build.VERSION.SDK_INT;
            if (this.f6596c != aVar.b() || this.f6597d != aVar.c() || this.f6594a.getTextSize() != aVar.e().getTextSize() || this.f6594a.getTextScaleX() != aVar.e().getTextScaleX() || this.f6594a.getTextSkewX() != aVar.e().getTextSkewX() || this.f6594a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f6594a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) || this.f6594a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i5 >= 24) {
                if (!this.f6594a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (!this.f6594a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            return this.f6594a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f6594a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.f6596c;
        }

        public int c() {
            return this.f6597d;
        }

        public TextDirectionHeuristic d() {
            return this.f6595b;
        }

        public TextPaint e() {
            return this.f6594a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f6595b == aVar.d();
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return androidx.core.util.c.b(Float.valueOf(this.f6594a.getTextSize()), Float.valueOf(this.f6594a.getTextScaleX()), Float.valueOf(this.f6594a.getTextSkewX()), Float.valueOf(this.f6594a.getLetterSpacing()), Integer.valueOf(this.f6594a.getFlags()), this.f6594a.getTextLocales(), this.f6594a.getTypeface(), Boolean.valueOf(this.f6594a.isElegantTextHeight()), this.f6595b, Integer.valueOf(this.f6596c), Integer.valueOf(this.f6597d));
            }
            return androidx.core.util.c.b(Float.valueOf(this.f6594a.getTextSize()), Float.valueOf(this.f6594a.getTextScaleX()), Float.valueOf(this.f6594a.getTextSkewX()), Float.valueOf(this.f6594a.getLetterSpacing()), Integer.valueOf(this.f6594a.getFlags()), this.f6594a.getTextLocale(), this.f6594a.getTypeface(), Boolean.valueOf(this.f6594a.isElegantTextHeight()), this.f6595b, Integer.valueOf(this.f6596c), Integer.valueOf(this.f6597d));
        }

        public String toString() {
            StringBuilder sb;
            Object textLocale;
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.f6594a.getTextSize());
            sb2.append(", textScaleX=" + this.f6594a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f6594a.getTextSkewX());
            int i5 = Build.VERSION.SDK_INT;
            sb2.append(", letterSpacing=" + this.f6594a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f6594a.isElegantTextHeight());
            if (i5 >= 24) {
                sb = new StringBuilder();
                sb.append(", textLocale=");
                textLocale = this.f6594a.getTextLocales();
            } else {
                sb = new StringBuilder();
                sb.append(", textLocale=");
                textLocale = this.f6594a.getTextLocale();
            }
            sb.append(textLocale);
            sb2.append(sb.toString());
            sb2.append(", typeface=" + this.f6594a.getTypeface());
            if (i5 >= 26) {
                sb2.append(", variationSettings=" + this.f6594a.getFontVariationSettings());
            }
            sb2.append(", textDir=" + this.f6595b);
            sb2.append(", breakStrategy=" + this.f6596c);
            sb2.append(", hyphenationFrequency=" + this.f6597d);
            sb2.append("}");
            return sb2.toString();
        }
    }

    public a a() {
        return this.f6592f;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f6591e;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public char charAt(int i5) {
        return this.f6591e.charAt(i5);
    }

    public int getSpanEnd(Object obj) {
        return this.f6591e.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f6591e.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f6591e.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i5, int i6, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? this.f6593g.getSpans(i5, i6, cls) : this.f6591e.getSpans(i5, i6, cls);
    }

    public int length() {
        return this.f6591e.length();
    }

    public int nextSpanTransition(int i5, int i6, Class cls) {
        return this.f6591e.nextSpanTransition(i5, i6, cls);
    }

    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f6593g.removeSpan(obj);
        } else {
            this.f6591e.removeSpan(obj);
        }
    }

    public void setSpan(Object obj, int i5, int i6, int i7) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f6593g.setSpan(obj, i5, i6, i7);
        } else {
            this.f6591e.setSpan(obj, i5, i6, i7);
        }
    }

    public CharSequence subSequence(int i5, int i6) {
        return this.f6591e.subSequence(i5, i6);
    }

    public String toString() {
        return this.f6591e.toString();
    }
}
