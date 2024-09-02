package androidx.window.core;

import com.yalantis.ucrop.BuildConfig;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import m3.e;

public final class Version implements Comparable<Version> {
    /* access modifiers changed from: private */
    public static final Version CURRENT;
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final Version UNKNOWN = new Version(0, 0, 0, BuildConfig.FLAVOR);
    /* access modifiers changed from: private */
    public static final Version VERSION_0_1 = new Version(0, 1, 0, BuildConfig.FLAVOR);
    /* access modifiers changed from: private */
    public static final Version VERSION_1_0;
    private static final String VERSION_PATTERN_STRING = "(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?";
    private final e bigInteger$delegate;
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Version getCURRENT() {
            return Version.CURRENT;
        }

        public final Version getUNKNOWN() {
            return Version.UNKNOWN;
        }

        public final Version getVERSION_0_1() {
            return Version.VERSION_0_1;
        }

        public final Version getVERSION_1_0() {
            return Version.VERSION_1_0;
        }

        public final Version parse(String str) {
            if (str == null || m.j(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile(Version.VERSION_PATTERN_STRING).matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            String group = matcher.group(1);
            Integer valueOf = group == null ? null : Integer.valueOf(Integer.parseInt(group));
            if (valueOf == null) {
                return null;
            }
            int intValue = valueOf.intValue();
            String group2 = matcher.group(2);
            Integer valueOf2 = group2 == null ? null : Integer.valueOf(Integer.parseInt(group2));
            if (valueOf2 == null) {
                return null;
            }
            int intValue2 = valueOf2.intValue();
            String group3 = matcher.group(3);
            Integer valueOf3 = group3 == null ? null : Integer.valueOf(Integer.parseInt(group3));
            if (valueOf3 == null) {
                return null;
            }
            int intValue3 = valueOf3.intValue();
            String group4 = matcher.group(4) != null ? matcher.group(4) : BuildConfig.FLAVOR;
            k.d(group4, "description");
            return new Version(intValue, intValue2, intValue3, group4, (g) null);
        }
    }

    static {
        Version version = new Version(1, 0, 0, BuildConfig.FLAVOR);
        VERSION_1_0 = version;
        CURRENT = version;
    }

    private Version(int i5, int i6, int i7, String str) {
        this.major = i5;
        this.minor = i6;
        this.patch = i7;
        this.description = str;
        this.bigInteger$delegate = g.a(new Version$bigInteger$2(this));
    }

    public /* synthetic */ Version(int i5, int i6, int i7, String str, g gVar) {
        this(i5, i6, i7, str);
    }

    private final BigInteger getBigInteger() {
        Object value = this.bigInteger$delegate.getValue();
        k.d(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    public static final Version parse(String str) {
        return Companion.parse(str);
    }

    public int compareTo(Version version) {
        k.e(version, "other");
        return getBigInteger().compareTo(version.getBigInteger());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        return ((((527 + this.major) * 31) + this.minor) * 31) + this.patch;
    }

    public String toString() {
        String j5 = m.j(this.description) ^ true ? k.j("-", this.description) : BuildConfig.FLAVOR;
        return this.major + '.' + this.minor + '.' + this.patch + j5;
    }
}
