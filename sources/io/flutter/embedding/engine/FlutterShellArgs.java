package io.flutter.embedding.engine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlutterShellArgs {
    public static final String ARG_CACHE_SKSL = "--cache-sksl";
    public static final String ARG_DART_FLAGS = "--dart-flags";
    public static final String ARG_DISABLE_SERVICE_AUTH_CODES = "--disable-service-auth-codes";
    public static final String ARG_DUMP_SHADER_SKP_ON_SHADER_COMPILATION = "--dump-skp-on-shader-compilation";
    public static final String ARG_ENABLE_DART_PROFILING = "--enable-dart-profiling";
    public static final String ARG_ENABLE_IMPELLER = "--enable-impeller";
    public static final String ARG_ENABLE_SOFTWARE_RENDERING = "--enable-software-rendering";
    public static final String ARG_ENABLE_VULKAN_VALIDATION = "--enable-vulkan-validation";
    public static final String ARG_ENDLESS_TRACE_BUFFER = "--endless-trace-buffer";
    public static final String ARG_KEY_CACHE_SKSL = "cache-sksl";
    public static final String ARG_KEY_DART_FLAGS = "dart-flags";
    public static final String ARG_KEY_DISABLE_SERVICE_AUTH_CODES = "disable-service-auth-codes";
    public static final String ARG_KEY_DUMP_SHADER_SKP_ON_SHADER_COMPILATION = "dump-skp-on-shader-compilation";
    public static final String ARG_KEY_ENABLE_DART_PROFILING = "enable-dart-profiling";
    public static final String ARG_KEY_ENABLE_IMPELLER = "enable-impeller";
    public static final String ARG_KEY_ENABLE_SOFTWARE_RENDERING = "enable-software-rendering";
    public static final String ARG_KEY_ENABLE_VULKAN_VALIDATION = "enable-vulkan-validation";
    public static final String ARG_KEY_ENDLESS_TRACE_BUFFER = "endless-trace-buffer";
    public static final String ARG_KEY_MSAA_SAMPLES = "msaa-samples";
    public static final String ARG_KEY_OBSERVATORY_PORT = "observatory-port";
    public static final String ARG_KEY_PURGE_PERSISTENT_CACHE = "purge-persistent-cache";
    public static final String ARG_KEY_SKIA_DETERMINISTIC_RENDERING = "skia-deterministic-rendering";
    public static final String ARG_KEY_START_PAUSED = "start-paused";
    public static final String ARG_KEY_TRACE_SKIA = "trace-skia";
    public static final String ARG_KEY_TRACE_SKIA_ALLOWLIST = "trace-skia-allowlist";
    public static final String ARG_KEY_TRACE_STARTUP = "trace-startup";
    public static final String ARG_KEY_TRACE_SYSTRACE = "trace-systrace";
    public static final String ARG_KEY_TRACE_TO_FILE = "trace-to-file";
    public static final String ARG_KEY_USE_TEST_FONTS = "use-test-fonts";
    public static final String ARG_KEY_VERBOSE_LOGGING = "verbose-logging";
    public static final String ARG_KEY_VM_SERVICE_PORT = "vm-service-port";
    public static final String ARG_MSAA_SAMPLES = "--msaa-samples";
    public static final String ARG_PURGE_PERSISTENT_CACHE = "--purge-persistent-cache";
    public static final String ARG_SKIA_DETERMINISTIC_RENDERING = "--skia-deterministic-rendering";
    public static final String ARG_START_PAUSED = "--start-paused";
    public static final String ARG_TRACE_SKIA = "--trace-skia";
    public static final String ARG_TRACE_SKIA_ALLOWLIST = "--trace-skia-allowlist=";
    public static final String ARG_TRACE_STARTUP = "--trace-startup";
    public static final String ARG_TRACE_SYSTRACE = "--trace-systrace";
    public static final String ARG_TRACE_TO_FILE = "--trace-to-file";
    public static final String ARG_USE_TEST_FONTS = "--use-test-fonts";
    public static final String ARG_VERBOSE_LOGGING = "--verbose-logging";
    public static final String ARG_VM_SERVICE_PORT = "--vm-service-port=";
    private Set<String> args;

    public FlutterShellArgs(List<String> list) {
        this.args = new HashSet(list);
    }

    public FlutterShellArgs(Set<String> set) {
        this.args = new HashSet(set);
    }

    public FlutterShellArgs(String[] strArr) {
        this.args = new HashSet(Arrays.asList(strArr));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.flutter.embedding.engine.FlutterShellArgs fromIntent(android.content.Intent r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "trace-startup"
            r2 = 0
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0013
            java.lang.String r1 = "--trace-startup"
            r0.add(r1)
        L_0x0013:
            java.lang.String r1 = "start-paused"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0020
            java.lang.String r1 = "--start-paused"
            r0.add(r1)
        L_0x0020:
            java.lang.String r1 = "vm-service-port"
            int r1 = r5.getIntExtra(r1, r2)
            java.lang.String r3 = "--vm-service-port="
            if (r1 <= 0) goto L_0x0041
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L_0x002f:
            r4.append(r3)
            java.lang.String r1 = java.lang.Integer.toString(r1)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r0.add(r1)
            goto L_0x004f
        L_0x0041:
            java.lang.String r1 = "observatory-port"
            int r1 = r5.getIntExtra(r1, r2)
            if (r1 <= 0) goto L_0x004f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L_0x002f
        L_0x004f:
            java.lang.String r1 = "disable-service-auth-codes"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x005c
            java.lang.String r1 = "--disable-service-auth-codes"
            r0.add(r1)
        L_0x005c:
            java.lang.String r1 = "endless-trace-buffer"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0069
            java.lang.String r1 = "--endless-trace-buffer"
            r0.add(r1)
        L_0x0069:
            java.lang.String r1 = "use-test-fonts"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0076
            java.lang.String r1 = "--use-test-fonts"
            r0.add(r1)
        L_0x0076:
            java.lang.String r1 = "enable-dart-profiling"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0083
            java.lang.String r1 = "--enable-dart-profiling"
            r0.add(r1)
        L_0x0083:
            java.lang.String r1 = "enable-software-rendering"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0090
            java.lang.String r1 = "--enable-software-rendering"
            r0.add(r1)
        L_0x0090:
            java.lang.String r1 = "skia-deterministic-rendering"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x009d
            java.lang.String r1 = "--skia-deterministic-rendering"
            r0.add(r1)
        L_0x009d:
            java.lang.String r1 = "trace-skia"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x00aa
            java.lang.String r1 = "--trace-skia"
            r0.add(r1)
        L_0x00aa:
            java.lang.String r1 = "trace-skia-allowlist"
            java.lang.String r1 = r5.getStringExtra(r1)
            if (r1 == 0) goto L_0x00c6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "--trace-skia-allowlist="
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.add(r1)
        L_0x00c6:
            java.lang.String r1 = "trace-systrace"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x00d3
            java.lang.String r1 = "--trace-systrace"
            r0.add(r1)
        L_0x00d3:
            java.lang.String r1 = "trace-to-file"
            boolean r3 = r5.hasExtra(r1)
            if (r3 == 0) goto L_0x00f3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "--trace-to-file="
            r3.append(r4)
            java.lang.String r1 = r5.getStringExtra(r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.add(r1)
        L_0x00f3:
            java.lang.String r1 = "enable-impeller"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0100
            java.lang.String r1 = "--enable-impeller"
            r0.add(r1)
        L_0x0100:
            java.lang.String r1 = "enable-vulkan-validation"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x010d
            java.lang.String r1 = "--enable-vulkan-validation"
            r0.add(r1)
        L_0x010d:
            java.lang.String r1 = "dump-skp-on-shader-compilation"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x011a
            java.lang.String r1 = "--dump-skp-on-shader-compilation"
            r0.add(r1)
        L_0x011a:
            java.lang.String r1 = "cache-sksl"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0127
            java.lang.String r1 = "--cache-sksl"
            r0.add(r1)
        L_0x0127:
            java.lang.String r1 = "purge-persistent-cache"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0134
            java.lang.String r1 = "--purge-persistent-cache"
            r0.add(r1)
        L_0x0134:
            java.lang.String r1 = "verbose-logging"
            boolean r1 = r5.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x0141
            java.lang.String r1 = "--verbose-logging"
            r0.add(r1)
        L_0x0141:
            java.lang.String r1 = "msaa-samples"
            int r1 = r5.getIntExtra(r1, r2)
            r2 = 1
            if (r1 <= r2) goto L_0x0162
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "--msaa-samples="
            r2.append(r3)
            java.lang.String r1 = java.lang.Integer.toString(r1)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.add(r1)
        L_0x0162:
            java.lang.String r1 = "dart-flags"
            boolean r2 = r5.hasExtra(r1)
            if (r2 == 0) goto L_0x0182
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "--dart-flags="
            r2.append(r3)
            java.lang.String r5 = r5.getStringExtra(r1)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r0.add(r5)
        L_0x0182:
            io.flutter.embedding.engine.FlutterShellArgs r5 = new io.flutter.embedding.engine.FlutterShellArgs
            r5.<init>((java.util.List<java.lang.String>) r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.FlutterShellArgs.fromIntent(android.content.Intent):io.flutter.embedding.engine.FlutterShellArgs");
    }

    public void add(String str) {
        this.args.add(str);
    }

    public void remove(String str) {
        this.args.remove(str);
    }

    public String[] toArray() {
        return (String[]) this.args.toArray(new String[this.args.size()]);
    }
}
