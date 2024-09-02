package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.system.OsConstants;
import android.util.Log;
import androidx.exifinterface.media.b;
import com.yalantis.ucrop.BuildConfig;
import io.flutter.embedding.android.KeyboardMap;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

public class a {
    public static final int[] A = {8};
    static final byte[] B = {-1, -40, -1};
    private static final byte[] C = {102, 116, 121, 112};
    private static final byte[] D = {109, 105, 102, 49};
    private static final byte[] E = {104, 101, 105, 99};
    private static final byte[] F = {79, 76, 89, 77, 80, 0};
    private static final byte[] G = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] H = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] I = {101, 88, 73, 102};
    private static final byte[] J = {73, 72, 68, 82};
    private static final byte[] K = {73, 69, 78, 68};
    private static final byte[] L = {82, 73, 70, 70};
    private static final byte[] M = {87, 69, 66, 80};
    private static final byte[] N = {69, 88, 73, 70};
    private static final byte[] O = {-99, 1, 42};
    private static final byte[] P = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] Q = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] R = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] S = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] T = "ANMF".getBytes(Charset.defaultCharset());
    private static SimpleDateFormat U;
    private static SimpleDateFormat V;
    static final String[] W = {BuildConfig.FLAVOR, "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] X = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] Y = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final e[] Z;

    /* renamed from: a0  reason: collision with root package name */
    private static final e[] f2061a0;

    /* renamed from: b0  reason: collision with root package name */
    private static final e[] f2062b0;

    /* renamed from: c0  reason: collision with root package name */
    private static final e[] f2063c0;

    /* renamed from: d0  reason: collision with root package name */
    private static final e[] f2064d0;

    /* renamed from: e0  reason: collision with root package name */
    private static final e f2065e0 = new e("StripOffsets", 273, 3);

    /* renamed from: f0  reason: collision with root package name */
    private static final e[] f2066f0;

    /* renamed from: g0  reason: collision with root package name */
    private static final e[] f2067g0;

    /* renamed from: h0  reason: collision with root package name */
    private static final e[] f2068h0;

    /* renamed from: i0  reason: collision with root package name */
    private static final e[] f2069i0;

    /* renamed from: j0  reason: collision with root package name */
    static final e[][] f2070j0;

    /* renamed from: k0  reason: collision with root package name */
    private static final e[] f2071k0 = {new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};

    /* renamed from: l0  reason: collision with root package name */
    private static final HashMap<Integer, e>[] f2072l0;

    /* renamed from: m0  reason: collision with root package name */
    private static final HashMap<String, e>[] f2073m0;

    /* renamed from: n0  reason: collision with root package name */
    private static final HashSet<String> f2074n0 = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));

    /* renamed from: o0  reason: collision with root package name */
    private static final HashMap<Integer, Integer> f2075o0 = new HashMap<>();

    /* renamed from: p0  reason: collision with root package name */
    static final Charset f2076p0;

    /* renamed from: q0  reason: collision with root package name */
    static final byte[] f2077q0;

    /* renamed from: r0  reason: collision with root package name */
    private static final byte[] f2078r0;

    /* renamed from: s0  reason: collision with root package name */
    private static final Pattern f2079s0 = Pattern.compile(".*[1-9].*");

    /* renamed from: t0  reason: collision with root package name */
    private static final Pattern f2080t0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: u0  reason: collision with root package name */
    private static final Pattern f2081u0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: v  reason: collision with root package name */
    private static final boolean f2082v = Log.isLoggable("ExifInterface", 3);

    /* renamed from: v0  reason: collision with root package name */
    private static final Pattern f2083v0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: w  reason: collision with root package name */
    private static final List<Integer> f2084w = Arrays.asList(new Integer[]{1, 6, 3, 8});

    /* renamed from: x  reason: collision with root package name */
    private static final List<Integer> f2085x = Arrays.asList(new Integer[]{2, 7, 4, 5});

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f2086y = {8, 8, 8};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f2087z = {4};

    /* renamed from: a  reason: collision with root package name */
    private String f2088a;

    /* renamed from: b  reason: collision with root package name */
    private FileDescriptor f2089b;

    /* renamed from: c  reason: collision with root package name */
    private AssetManager.AssetInputStream f2090c;

    /* renamed from: d  reason: collision with root package name */
    private int f2091d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2092e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, d>[] f2093f;

    /* renamed from: g  reason: collision with root package name */
    private Set<Integer> f2094g;

    /* renamed from: h  reason: collision with root package name */
    private ByteOrder f2095h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2096i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2097j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2098k;

    /* renamed from: l  reason: collision with root package name */
    private int f2099l;

    /* renamed from: m  reason: collision with root package name */
    private int f2100m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f2101n;

    /* renamed from: o  reason: collision with root package name */
    private int f2102o;

    /* renamed from: p  reason: collision with root package name */
    private int f2103p;

    /* renamed from: q  reason: collision with root package name */
    private int f2104q;

    /* renamed from: r  reason: collision with root package name */
    private int f2105r;

    /* renamed from: s  reason: collision with root package name */
    private int f2106s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f2107t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f2108u;

    /* renamed from: androidx.exifinterface.media.a$a  reason: collision with other inner class name */
    class C0034a extends MediaDataSource {

        /* renamed from: e  reason: collision with root package name */
        long f2109e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ g f2110f;

        C0034a(g gVar) {
            this.f2110f = gVar;
        }

        public void close() {
        }

        public long getSize() {
            return -1;
        }

        public int readAt(long j5, byte[] bArr, int i5, int i6) {
            if (i6 == 0) {
                return 0;
            }
            if (j5 < 0) {
                return -1;
            }
            try {
                long j6 = this.f2109e;
                if (j6 != j5) {
                    if (j6 >= 0 && j5 >= j6 + ((long) this.f2110f.available())) {
                        return -1;
                    }
                    this.f2110f.g(j5);
                    this.f2109e = j5;
                }
                if (i6 > this.f2110f.available()) {
                    i6 = this.f2110f.available();
                }
                int read = this.f2110f.read(bArr, i5, i6);
                if (read >= 0) {
                    this.f2109e += (long) read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f2109e = -1;
            return -1;
        }
    }

    private static class b extends InputStream implements DataInput {

        /* renamed from: i  reason: collision with root package name */
        private static final ByteOrder f2112i = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: j  reason: collision with root package name */
        private static final ByteOrder f2113j = ByteOrder.BIG_ENDIAN;

        /* renamed from: e  reason: collision with root package name */
        final DataInputStream f2114e;

        /* renamed from: f  reason: collision with root package name */
        private ByteOrder f2115f;

        /* renamed from: g  reason: collision with root package name */
        int f2116g;

        /* renamed from: h  reason: collision with root package name */
        private byte[] f2117h;

        b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        b(InputStream inputStream, ByteOrder byteOrder) {
            this.f2115f = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f2114e = dataInputStream;
            dataInputStream.mark(0);
            this.f2116g = 0;
            this.f2115f = byteOrder;
        }

        b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int available() {
            return this.f2114e.available();
        }

        public int b() {
            return this.f2116g;
        }

        public long d() {
            return ((long) readInt()) & KeyboardMap.kValueMask;
        }

        public void e(ByteOrder byteOrder) {
            this.f2115f = byteOrder;
        }

        public void f(int i5) {
            int i6 = 0;
            while (i6 < i5) {
                int i7 = i5 - i6;
                int skip = (int) this.f2114e.skip((long) i7);
                if (skip <= 0) {
                    if (this.f2117h == null) {
                        this.f2117h = new byte[8192];
                    }
                    skip = this.f2114e.read(this.f2117h, 0, Math.min(8192, i7));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i5 + " bytes.");
                    }
                }
                i6 += skip;
            }
            this.f2116g += i6;
        }

        public void mark(int i5) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        public int read() {
            this.f2116g++;
            return this.f2114e.read();
        }

        public int read(byte[] bArr, int i5, int i6) {
            int read = this.f2114e.read(bArr, i5, i6);
            this.f2116g += read;
            return read;
        }

        public boolean readBoolean() {
            this.f2116g++;
            return this.f2114e.readBoolean();
        }

        public byte readByte() {
            this.f2116g++;
            int read = this.f2114e.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        public char readChar() {
            this.f2116g += 2;
            return this.f2114e.readChar();
        }

        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr) {
            this.f2116g += bArr.length;
            this.f2114e.readFully(bArr);
        }

        public void readFully(byte[] bArr, int i5, int i6) {
            this.f2116g += i6;
            this.f2114e.readFully(bArr, i5, i6);
        }

        public int readInt() {
            this.f2116g += 4;
            int read = this.f2114e.read();
            int read2 = this.f2114e.read();
            int read3 = this.f2114e.read();
            int read4 = this.f2114e.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.f2115f;
                if (byteOrder == f2112i) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f2113j) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.f2115f);
            }
            throw new EOFException();
        }

        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        public long readLong() {
            this.f2116g += 8;
            int read = this.f2114e.read();
            int read2 = this.f2114e.read();
            int read3 = this.f2114e.read();
            int read4 = this.f2114e.read();
            int read5 = this.f2114e.read();
            int read6 = this.f2114e.read();
            int read7 = this.f2114e.read();
            int read8 = this.f2114e.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.f2115f;
                if (byteOrder == f2112i) {
                    return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                }
                int i5 = read2;
                if (byteOrder == f2113j) {
                    return (((long) read) << 56) + (((long) i5) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                }
                throw new IOException("Invalid byte order: " + this.f2115f);
            }
            throw new EOFException();
        }

        public short readShort() {
            this.f2116g += 2;
            int read = this.f2114e.read();
            int read2 = this.f2114e.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f2115f;
                if (byteOrder == f2112i) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == f2113j) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.f2115f);
            }
            throw new EOFException();
        }

        public String readUTF() {
            this.f2116g += 2;
            return this.f2114e.readUTF();
        }

        public int readUnsignedByte() {
            this.f2116g++;
            return this.f2114e.readUnsignedByte();
        }

        public int readUnsignedShort() {
            this.f2116g += 2;
            int read = this.f2114e.read();
            int read2 = this.f2114e.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f2115f;
                if (byteOrder == f2112i) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == f2113j) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.f2115f);
            }
            throw new EOFException();
        }

        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        public int skipBytes(int i5) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }
    }

    private static class c extends FilterOutputStream {

        /* renamed from: e  reason: collision with root package name */
        final OutputStream f2118e;

        /* renamed from: f  reason: collision with root package name */
        private ByteOrder f2119f;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f2118e = outputStream;
            this.f2119f = byteOrder;
        }

        public void b(ByteOrder byteOrder) {
            this.f2119f = byteOrder;
        }

        public void d(int i5) {
            this.f2118e.write(i5);
        }

        public void e(int i5) {
            OutputStream outputStream;
            int i6;
            ByteOrder byteOrder = this.f2119f;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f2118e.write((i5 >>> 0) & 255);
                this.f2118e.write((i5 >>> 8) & 255);
                this.f2118e.write((i5 >>> 16) & 255);
                outputStream = this.f2118e;
                i6 = i5 >>> 24;
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f2118e.write((i5 >>> 24) & 255);
                this.f2118e.write((i5 >>> 16) & 255);
                this.f2118e.write((i5 >>> 8) & 255);
                outputStream = this.f2118e;
                i6 = i5 >>> 0;
            } else {
                return;
            }
            outputStream.write(i6 & 255);
        }

        public void f(short s5) {
            OutputStream outputStream;
            int i5;
            ByteOrder byteOrder = this.f2119f;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f2118e.write((s5 >>> 0) & 255);
                outputStream = this.f2118e;
                i5 = s5 >>> 8;
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f2118e.write((s5 >>> 8) & 255);
                outputStream = this.f2118e;
                i5 = s5 >>> 0;
            } else {
                return;
            }
            outputStream.write(i5 & 255);
        }

        public void g(long j5) {
            e((int) j5);
        }

        public void h(int i5) {
            f((short) i5);
        }

        public void write(byte[] bArr) {
            this.f2118e.write(bArr);
        }

        public void write(byte[] bArr, int i5, int i6) {
            this.f2118e.write(bArr, i5, i6);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f2120a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2121b;

        /* renamed from: c  reason: collision with root package name */
        public final long f2122c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f2123d;

        d(int i5, int i6, long j5, byte[] bArr) {
            this.f2120a = i5;
            this.f2121b = i6;
            this.f2122c = j5;
            this.f2123d = bArr;
        }

        d(int i5, int i6, byte[] bArr) {
            this(i5, i6, -1, bArr);
        }

        public static d a(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes = str.getBytes(a.f2076p0);
                return new d(1, bytes.length, bytes);
            }
            return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static d b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new d(12, dArr.length, wrap.array());
        }

        public static d c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new d(9, iArr.length, wrap.array());
        }

        public static d d(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[10] * fVarArr.length)]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f2128a);
                wrap.putInt((int) fVar.f2129b);
            }
            return new d(10, fVarArr.length, wrap.array());
        }

        public static d e(String str) {
            byte[] bytes = (str + 0).getBytes(a.f2076p0);
            return new d(2, bytes.length, bytes);
        }

        public static d f(long j5, ByteOrder byteOrder) {
            return g(new long[]{j5}, byteOrder);
        }

        public static d g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j5 : jArr) {
                wrap.putInt((int) j5);
            }
            return new d(4, jArr.length, wrap.array());
        }

        public static d h(f fVar, ByteOrder byteOrder) {
            return i(new f[]{fVar}, byteOrder);
        }

        public static d i(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[5] * fVarArr.length)]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f2128a);
                wrap.putInt((int) fVar.f2129b);
            }
            return new d(5, fVarArr.length, wrap.array());
        }

        public static d j(int i5, ByteOrder byteOrder) {
            return k(new int[]{i5}, byteOrder);
        }

        public static d k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i5 : iArr) {
                wrap.putShort((short) i5);
            }
            return new d(3, iArr.length, wrap.array());
        }

        public double l(ByteOrder byteOrder) {
            Object o5 = o(byteOrder);
            if (o5 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (o5 instanceof String) {
                return Double.parseDouble((String) o5);
            } else {
                if (o5 instanceof long[]) {
                    long[] jArr = (long[]) o5;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o5 instanceof int[]) {
                    int[] iArr = (int[]) o5;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o5 instanceof double[]) {
                    double[] dArr = (double[]) o5;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o5 instanceof f[]) {
                    f[] fVarArr = (f[]) o5;
                    if (fVarArr.length == 1) {
                        return fVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int m(ByteOrder byteOrder) {
            Object o5 = o(byteOrder);
            if (o5 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (o5 instanceof String) {
                return Integer.parseInt((String) o5);
            } else {
                if (o5 instanceof long[]) {
                    long[] jArr = (long[]) o5;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o5 instanceof int[]) {
                    int[] iArr = (int[]) o5;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String n(ByteOrder byteOrder) {
            Object o5 = o(byteOrder);
            if (o5 == null) {
                return null;
            }
            if (o5 instanceof String) {
                return (String) o5;
            }
            StringBuilder sb = new StringBuilder();
            int i5 = 0;
            if (o5 instanceof long[]) {
                long[] jArr = (long[]) o5;
                while (i5 < jArr.length) {
                    sb.append(jArr[i5]);
                    i5++;
                    if (i5 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (o5 instanceof int[]) {
                int[] iArr = (int[]) o5;
                while (i5 < iArr.length) {
                    sb.append(iArr[i5]);
                    i5++;
                    if (i5 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (o5 instanceof double[]) {
                double[] dArr = (double[]) o5;
                while (i5 < dArr.length) {
                    sb.append(dArr[i5]);
                    i5++;
                    if (i5 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(o5 instanceof f[])) {
                return null;
            } else {
                f[] fVarArr = (f[]) o5;
                while (i5 < fVarArr.length) {
                    sb.append(fVarArr[i5].f2128a);
                    sb.append('/');
                    sb.append(fVarArr[i5].f2129b);
                    i5++;
                    if (i5 != fVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x019b A[SYNTHETIC, Splitter:B:163:0x019b] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object o(java.nio.ByteOrder r11) {
            /*
                r10 = this;
                java.lang.String r0 = "IOException occurred while closing InputStream"
                java.lang.String r1 = "ExifInterface"
                r2 = 0
                androidx.exifinterface.media.a$b r3 = new androidx.exifinterface.media.a$b     // Catch:{ IOException -> 0x0185, all -> 0x0183 }
                byte[] r4 = r10.f2123d     // Catch:{ IOException -> 0x0185, all -> 0x0183 }
                r3.<init>((byte[]) r4)     // Catch:{ IOException -> 0x0185, all -> 0x0183 }
                r3.e(r11)     // Catch:{ IOException -> 0x0181 }
                int r11 = r10.f2120a     // Catch:{ IOException -> 0x0181 }
                r4 = 0
                r5 = 1
                switch(r11) {
                    case 1: goto L_0x0148;
                    case 2: goto L_0x00fd;
                    case 3: goto L_0x00e3;
                    case 4: goto L_0x00c9;
                    case 5: goto L_0x00a6;
                    case 6: goto L_0x0148;
                    case 7: goto L_0x00fd;
                    case 8: goto L_0x008c;
                    case 9: goto L_0x0072;
                    case 10: goto L_0x004d;
                    case 11: goto L_0x0032;
                    case 12: goto L_0x0018;
                    default: goto L_0x0016;
                }     // Catch:{ IOException -> 0x0181 }
            L_0x0016:
                goto L_0x0178
            L_0x0018:
                int r11 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x001c:
                int r5 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x0029
                double r5 = r3.readDouble()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x001c
            L_0x0029:
                r3.close()     // Catch:{ IOException -> 0x002d }
                goto L_0x0031
            L_0x002d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0031:
                return r11
            L_0x0032:
                int r11 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x0036:
                int r5 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x0044
                float r5 = r3.readFloat()     // Catch:{ IOException -> 0x0181 }
                double r5 = (double) r5     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0036
            L_0x0044:
                r3.close()     // Catch:{ IOException -> 0x0048 }
                goto L_0x004c
            L_0x0048:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x004c:
                return r11
            L_0x004d:
                int r11 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                androidx.exifinterface.media.a$f[] r11 = new androidx.exifinterface.media.a.f[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x0051:
                int r5 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x0069
                int r5 = r3.readInt()     // Catch:{ IOException -> 0x0181 }
                long r5 = (long) r5     // Catch:{ IOException -> 0x0181 }
                int r7 = r3.readInt()     // Catch:{ IOException -> 0x0181 }
                long r7 = (long) r7     // Catch:{ IOException -> 0x0181 }
                androidx.exifinterface.media.a$f r9 = new androidx.exifinterface.media.a$f     // Catch:{ IOException -> 0x0181 }
                r9.<init>(r5, r7)     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r9     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0051
            L_0x0069:
                r3.close()     // Catch:{ IOException -> 0x006d }
                goto L_0x0071
            L_0x006d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0071:
                return r11
            L_0x0072:
                int r11 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x0076:
                int r5 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x0083
                int r5 = r3.readInt()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0076
            L_0x0083:
                r3.close()     // Catch:{ IOException -> 0x0087 }
                goto L_0x008b
            L_0x0087:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x008b:
                return r11
            L_0x008c:
                int r11 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x0090:
                int r5 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x009d
                short r5 = r3.readShort()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0090
            L_0x009d:
                r3.close()     // Catch:{ IOException -> 0x00a1 }
                goto L_0x00a5
            L_0x00a1:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00a5:
                return r11
            L_0x00a6:
                int r11 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                androidx.exifinterface.media.a$f[] r11 = new androidx.exifinterface.media.a.f[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x00aa:
                int r5 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x00c0
                long r5 = r3.d()     // Catch:{ IOException -> 0x0181 }
                long r7 = r3.d()     // Catch:{ IOException -> 0x0181 }
                androidx.exifinterface.media.a$f r9 = new androidx.exifinterface.media.a$f     // Catch:{ IOException -> 0x0181 }
                r9.<init>(r5, r7)     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r9     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x00aa
            L_0x00c0:
                r3.close()     // Catch:{ IOException -> 0x00c4 }
                goto L_0x00c8
            L_0x00c4:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00c8:
                return r11
            L_0x00c9:
                int r11 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                long[] r11 = new long[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x00cd:
                int r5 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x00da
                long r5 = r3.d()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x00cd
            L_0x00da:
                r3.close()     // Catch:{ IOException -> 0x00de }
                goto L_0x00e2
            L_0x00de:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00e2:
                return r11
            L_0x00e3:
                int r11 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x00e7:
                int r5 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x00f4
                int r5 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x00e7
            L_0x00f4:
                r3.close()     // Catch:{ IOException -> 0x00f8 }
                goto L_0x00fc
            L_0x00f8:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00fc:
                return r11
            L_0x00fd:
                int r11 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                byte[] r6 = androidx.exifinterface.media.a.Y     // Catch:{ IOException -> 0x0181 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0181 }
                if (r11 < r6) goto L_0x011a
                r11 = r4
            L_0x0105:
                byte[] r6 = androidx.exifinterface.media.a.Y     // Catch:{ IOException -> 0x0181 }
                int r7 = r6.length     // Catch:{ IOException -> 0x0181 }
                if (r11 >= r7) goto L_0x0117
                byte[] r7 = r10.f2123d     // Catch:{ IOException -> 0x0181 }
                byte r7 = r7[r11]     // Catch:{ IOException -> 0x0181 }
                byte r8 = r6[r11]     // Catch:{ IOException -> 0x0181 }
                if (r7 == r8) goto L_0x0114
                r5 = r4
                goto L_0x0117
            L_0x0114:
                int r11 = r11 + 1
                goto L_0x0105
            L_0x0117:
                if (r5 == 0) goto L_0x011a
                int r4 = r6.length     // Catch:{ IOException -> 0x0181 }
            L_0x011a:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0181 }
                r11.<init>()     // Catch:{ IOException -> 0x0181 }
            L_0x011f:
                int r5 = r10.f2121b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x013b
                byte[] r5 = r10.f2123d     // Catch:{ IOException -> 0x0181 }
                byte r5 = r5[r4]     // Catch:{ IOException -> 0x0181 }
                if (r5 != 0) goto L_0x012a
                goto L_0x013b
            L_0x012a:
                r6 = 32
                if (r5 < r6) goto L_0x0133
                char r5 = (char) r5     // Catch:{ IOException -> 0x0181 }
                r11.append(r5)     // Catch:{ IOException -> 0x0181 }
                goto L_0x0138
            L_0x0133:
                r5 = 63
                r11.append(r5)     // Catch:{ IOException -> 0x0181 }
            L_0x0138:
                int r4 = r4 + 1
                goto L_0x011f
            L_0x013b:
                java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0181 }
                r3.close()     // Catch:{ IOException -> 0x0143 }
                goto L_0x0147
            L_0x0143:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0147:
                return r11
            L_0x0148:
                byte[] r11 = r10.f2123d     // Catch:{ IOException -> 0x0181 }
                int r6 = r11.length     // Catch:{ IOException -> 0x0181 }
                if (r6 != r5) goto L_0x0168
                byte r6 = r11[r4]     // Catch:{ IOException -> 0x0181 }
                if (r6 < 0) goto L_0x0168
                if (r6 > r5) goto L_0x0168
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x0181 }
                char[] r5 = new char[r5]     // Catch:{ IOException -> 0x0181 }
                int r6 = r6 + 48
                char r6 = (char) r6     // Catch:{ IOException -> 0x0181 }
                r5[r4] = r6     // Catch:{ IOException -> 0x0181 }
                r11.<init>(r5)     // Catch:{ IOException -> 0x0181 }
                r3.close()     // Catch:{ IOException -> 0x0163 }
                goto L_0x0167
            L_0x0163:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0167:
                return r11
            L_0x0168:
                java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x0181 }
                java.nio.charset.Charset r5 = androidx.exifinterface.media.a.f2076p0     // Catch:{ IOException -> 0x0181 }
                r4.<init>(r11, r5)     // Catch:{ IOException -> 0x0181 }
                r3.close()     // Catch:{ IOException -> 0x0173 }
                goto L_0x0177
            L_0x0173:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0177:
                return r4
            L_0x0178:
                r3.close()     // Catch:{ IOException -> 0x017c }
                goto L_0x0180
            L_0x017c:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0180:
                return r2
            L_0x0181:
                r11 = move-exception
                goto L_0x0187
            L_0x0183:
                r11 = move-exception
                goto L_0x0199
            L_0x0185:
                r11 = move-exception
                r3 = r2
            L_0x0187:
                java.lang.String r4 = "IOException occurred during reading a value"
                android.util.Log.w(r1, r4, r11)     // Catch:{ all -> 0x0197 }
                if (r3 == 0) goto L_0x0196
                r3.close()     // Catch:{ IOException -> 0x0192 }
                goto L_0x0196
            L_0x0192:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0196:
                return r2
            L_0x0197:
                r11 = move-exception
                r2 = r3
            L_0x0199:
                if (r2 == 0) goto L_0x01a3
                r2.close()     // Catch:{ IOException -> 0x019f }
                goto L_0x01a3
            L_0x019f:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x01a3:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.d.o(java.nio.ByteOrder):java.lang.Object");
        }

        public int p() {
            return a.X[this.f2120a] * this.f2121b;
        }

        public String toString() {
            return "(" + a.W[this.f2120a] + ", data length:" + this.f2123d.length + ")";
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f2124a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2125b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2126c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2127d;

        e(String str, int i5, int i6) {
            this.f2125b = str;
            this.f2124a = i5;
            this.f2126c = i6;
            this.f2127d = -1;
        }

        e(String str, int i5, int i6, int i7) {
            this.f2125b = str;
            this.f2124a = i5;
            this.f2126c = i6;
            this.f2127d = i7;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i5) {
            int i6;
            int i7 = this.f2126c;
            if (i7 == 7 || i5 == 7 || i7 == i5 || (i6 = this.f2127d) == i5) {
                return true;
            }
            if ((i7 == 4 || i6 == 4) && i5 == 3) {
                return true;
            }
            if ((i7 == 9 || i6 == 9) && i5 == 8) {
                return true;
            }
            return (i7 == 12 || i6 == 12) && i5 == 11;
        }
    }

    private static class f {

        /* renamed from: a  reason: collision with root package name */
        public final long f2128a;

        /* renamed from: b  reason: collision with root package name */
        public final long f2129b;

        f(double d5) {
            this((long) (d5 * 10000.0d), 10000);
        }

        f(long j5, long j6) {
            if (j6 == 0) {
                this.f2128a = 0;
                this.f2129b = 1;
                return;
            }
            this.f2128a = j5;
            this.f2129b = j6;
        }

        public double a() {
            return ((double) this.f2128a) / ((double) this.f2129b);
        }

        public String toString() {
            return this.f2128a + "/" + this.f2129b;
        }
    }

    private static class g extends b {
        g(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f2114e.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }

        g(byte[] bArr) {
            super(bArr);
            this.f2114e.mark(Integer.MAX_VALUE);
        }

        public void g(long j5) {
            int i5 = this.f2116g;
            if (((long) i5) > j5) {
                this.f2116g = 0;
                this.f2114e.reset();
            } else {
                j5 -= (long) i5;
            }
            f((int) j5);
        }
    }

    static {
        e[] eVarArr = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ImageWidth", 256, 3, 4), new e("ImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        Z = eVarArr;
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f2061a0 = eVarArr2;
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e("GPSLatitude", 2, 5, 10), new e("GPSLongitudeRef", 3, 2), new e("GPSLongitude", 4, 5, 10), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        f2062b0 = eVarArr3;
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        f2063c0 = eVarArr4;
        e[] eVarArr5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ThumbnailImageWidth", 256, 3, 4), new e("ThumbnailImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f2064d0 = eVarArr5;
        e[] eVarArr6 = {new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)};
        f2066f0 = eVarArr6;
        e[] eVarArr7 = {new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)};
        f2067g0 = eVarArr7;
        e[] eVarArr8 = {new e("AspectFrame", 4371, 3)};
        f2068h0 = eVarArr8;
        e[] eVarArr9 = {new e("ColorSpace", 55, 3)};
        f2069i0 = eVarArr9;
        e[][] eVarArr10 = {eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, eVarArr6, eVarArr7, eVarArr8, eVarArr9};
        f2070j0 = eVarArr10;
        f2072l0 = new HashMap[eVarArr10.length];
        f2073m0 = new HashMap[eVarArr10.length];
        Charset forName = Charset.forName("US-ASCII");
        f2076p0 = forName;
        f2077q0 = "Exif\u0000\u0000".getBytes(forName);
        f2078r0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        U = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        V = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i5 = 0;
        while (true) {
            e[][] eVarArr11 = f2070j0;
            if (i5 < eVarArr11.length) {
                f2072l0[i5] = new HashMap<>();
                f2073m0[i5] = new HashMap<>();
                for (e eVar : eVarArr11[i5]) {
                    f2072l0[i5].put(Integer.valueOf(eVar.f2124a), eVar);
                    f2073m0[i5].put(eVar.f2125b, eVar);
                }
                i5++;
            } else {
                HashMap<Integer, Integer> hashMap = f2075o0;
                e[] eVarArr12 = f2071k0;
                hashMap.put(Integer.valueOf(eVarArr12[0].f2124a), 5);
                hashMap.put(Integer.valueOf(eVarArr12[1].f2124a), 1);
                hashMap.put(Integer.valueOf(eVarArr12[2].f2124a), 2);
                hashMap.put(Integer.valueOf(eVarArr12[3].f2124a), 3);
                hashMap.put(Integer.valueOf(eVarArr12[4].f2124a), 7);
                hashMap.put(Integer.valueOf(eVarArr12[5].f2124a), 8);
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(java.io.FileDescriptor r5) {
        /*
            r4 = this;
            r4.<init>()
            androidx.exifinterface.media.a$e[][] r0 = f2070j0
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r4.f2093f = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r4.f2094g = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r4.f2095h = r0
            if (r5 == 0) goto L_0x0057
            r0 = 0
            r4.f2090c = r0
            r4.f2088a = r0
            r1 = 0
            boolean r2 = C(r5)
            if (r2 == 0) goto L_0x0035
            r4.f2089b = r5
            java.io.FileDescriptor r5 = androidx.exifinterface.media.b.a.b(r5)     // Catch:{ Exception -> 0x002c }
            r1 = 1
            goto L_0x0037
        L_0x002c:
            r5 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to duplicate file descriptor"
            r0.<init>(r1, r5)
            throw r0
        L_0x0035:
            r4.f2089b = r0
        L_0x0037:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x004a }
            r2.<init>(r5)     // Catch:{ all -> 0x004a }
            r4.H(r2)     // Catch:{ all -> 0x0048 }
            androidx.exifinterface.media.b.c(r2)
            if (r1 == 0) goto L_0x0047
            androidx.exifinterface.media.b.b(r5)
        L_0x0047:
            return
        L_0x0048:
            r0 = move-exception
            goto L_0x004e
        L_0x004a:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
        L_0x004e:
            androidx.exifinterface.media.b.c(r2)
            if (r1 == 0) goto L_0x0056
            androidx.exifinterface.media.b.b(r5)
        L_0x0056:
            throw r0
        L_0x0057:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "fileDescriptor cannot be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.<init>(java.io.FileDescriptor):void");
    }

    public a(InputStream inputStream) {
        this(inputStream, 0);
    }

    public a(InputStream inputStream, int i5) {
        e[][] eVarArr = f2070j0;
        this.f2093f = new HashMap[eVarArr.length];
        this.f2094g = new HashSet(eVarArr.length);
        this.f2095h = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.f2088a = null;
            if (i5 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f2077q0.length);
                if (!v(bufferedInputStream)) {
                    Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.f2092e = true;
                this.f2090c = null;
                this.f2089b = null;
                inputStream = bufferedInputStream;
            } else {
                if (inputStream instanceof AssetManager.AssetInputStream) {
                    this.f2090c = (AssetManager.AssetInputStream) inputStream;
                } else {
                    if (inputStream instanceof FileInputStream) {
                        FileInputStream fileInputStream = (FileInputStream) inputStream;
                        if (C(fileInputStream.getFD())) {
                            this.f2090c = null;
                            this.f2089b = fileInputStream.getFD();
                        }
                    }
                    this.f2090c = null;
                }
                this.f2089b = null;
            }
            H(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }

    public a(String str) {
        e[][] eVarArr = f2070j0;
        this.f2093f = new HashMap[eVarArr.length];
        this.f2094g = new HashSet(eVarArr.length);
        this.f2095h = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            u(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    private boolean A(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i5 = 0; i5 < bytes.length; i5++) {
            if (bArr[i5] != bytes[i5]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean B(byte[] r4) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.a$b r2 = new androidx.exifinterface.media.a$b     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            java.nio.ByteOrder r4 = r3.K(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r3.f2095h = r4     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r2.e(r4)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1 = 85
            if (r4 != r1) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2.close()
            return r0
        L_0x001d:
            r4 = move-exception
            r1 = r2
            goto L_0x0023
        L_0x0020:
            r1 = r2
            goto L_0x0029
        L_0x0022:
            r4 = move-exception
        L_0x0023:
            if (r1 == 0) goto L_0x0028
            r1.close()
        L_0x0028:
            throw r4
        L_0x0029:
            if (r1 == 0) goto L_0x002e
            r1.close()
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.B(byte[]):boolean");
    }

    private static boolean C(FileDescriptor fileDescriptor) {
        try {
            b.a.c(fileDescriptor, 0, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!f2082v) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    private boolean D(HashMap hashMap) {
        d dVar;
        int m5;
        d dVar2 = (d) hashMap.get("BitsPerSample");
        if (dVar2 != null) {
            int[] iArr = (int[]) dVar2.o(this.f2095h);
            int[] iArr2 = f2086y;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f2091d == 3 && (dVar = (d) hashMap.get("PhotometricInterpretation")) != null && (((m5 = dVar.m(this.f2095h)) == 1 && Arrays.equals(iArr, A)) || (m5 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!f2082v) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    private static boolean E(int i5) {
        return i5 == 4 || i5 == 13 || i5 == 14;
    }

    private boolean F(HashMap hashMap) {
        d dVar = (d) hashMap.get("ImageLength");
        d dVar2 = (d) hashMap.get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            return false;
        }
        return dVar.m(this.f2095h) <= 512 && dVar2.m(this.f2095h) <= 512;
    }

    private boolean G(byte[] bArr) {
        int i5 = 0;
        while (true) {
            byte[] bArr2 = L;
            if (i5 >= bArr2.length) {
                int i6 = 0;
                while (true) {
                    byte[] bArr3 = M;
                    if (i6 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[L.length + i6 + 4] != bArr3[i6]) {
                        return false;
                    }
                    i6++;
                }
            } else if (bArr[i5] != bArr2[i5]) {
                return false;
            } else {
                i5++;
            }
        }
    }

    private void H(InputStream inputStream) {
        if (inputStream != null) {
            int i5 = 0;
            while (i5 < f2070j0.length) {
                try {
                    this.f2093f[i5] = new HashMap<>();
                    i5++;
                } catch (IOException | UnsupportedOperationException e5) {
                    boolean z4 = f2082v;
                    if (z4) {
                        Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e5);
                    }
                    a();
                    if (!z4) {
                        return;
                    }
                } catch (Throwable th) {
                    a();
                    if (f2082v) {
                        J();
                    }
                    throw th;
                }
            }
            if (!this.f2092e) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.f2091d = h(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            if (W(this.f2091d)) {
                g gVar = new g(inputStream);
                if (this.f2092e) {
                    n(gVar);
                } else {
                    int i6 = this.f2091d;
                    if (i6 == 12) {
                        f(gVar);
                    } else if (i6 == 7) {
                        i(gVar);
                    } else if (i6 == 10) {
                        m(gVar);
                    } else {
                        l(gVar);
                    }
                }
                gVar.g((long) this.f2103p);
                V(gVar);
            } else {
                b bVar = new b(inputStream);
                int i7 = this.f2091d;
                if (i7 == 4) {
                    g(bVar, 0, 0);
                } else if (i7 == 13) {
                    j(bVar);
                } else if (i7 == 9) {
                    k(bVar);
                } else if (i7 == 14) {
                    q(bVar);
                }
            }
            a();
            if (!f2082v) {
                return;
            }
            J();
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    private void I(b bVar) {
        ByteOrder K2 = K(bVar);
        this.f2095h = K2;
        bVar.e(K2);
        int readUnsignedShort = bVar.readUnsignedShort();
        int i5 = this.f2091d;
        if (i5 == 7 || i5 == 10 || readUnsignedShort == 42) {
            int readInt = bVar.readInt();
            if (readInt >= 8) {
                int i6 = readInt - 8;
                if (i6 > 0) {
                    bVar.f(i6);
                    return;
                }
                return;
            }
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void J() {
        for (int i5 = 0; i5 < this.f2093f.length; i5++) {
            Log.d("ExifInterface", "The size of tag group[" + i5 + "]: " + this.f2093f[i5].size());
            for (Map.Entry next : this.f2093f[i5].entrySet()) {
                d dVar = (d) next.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) next.getKey()) + ", tagType: " + dVar.toString() + ", tagValue: '" + dVar.n(this.f2095h) + "'");
            }
        }
    }

    private ByteOrder K(b bVar) {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            if (f2082v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (f2082v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void L(byte[] bArr, int i5) {
        g gVar = new g(bArr);
        I(gVar);
        M(gVar, i5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0278  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void M(androidx.exifinterface.media.a.g r30, int r31) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r31
            java.util.Set<java.lang.Integer> r3 = r0.f2094g
            int r4 = r1.f2116g
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            short r3 = r30.readShort()
            boolean r4 = f2082v
            java.lang.String r5 = "ExifInterface"
            if (r4 == 0) goto L_0x002f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "numberOfDirectoryEntry: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r5, r4)
        L_0x002f:
            if (r3 > 0) goto L_0x0032
            return
        L_0x0032:
            r4 = 0
            r6 = r4
        L_0x0034:
            r7 = 5
            if (r6 >= r3) goto L_0x0316
            int r12 = r30.readUnsignedShort()
            int r13 = r30.readUnsignedShort()
            int r15 = r30.readInt()
            int r14 = r30.b()
            long r8 = (long) r14
            r18 = 4
            long r8 = r8 + r18
            java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.a$e>[] r14 = f2072l0
            r14 = r14[r2]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r12)
            java.lang.Object r11 = r14.get(r11)
            androidx.exifinterface.media.a$e r11 = (androidx.exifinterface.media.a.e) r11
            boolean r14 = f2082v
            r10 = 3
            if (r14 == 0) goto L_0x0090
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.Integer r23 = java.lang.Integer.valueOf(r31)
            r7[r4] = r23
            java.lang.Integer r23 = java.lang.Integer.valueOf(r12)
            r21 = 1
            r7[r21] = r23
            if (r11 == 0) goto L_0x0074
            java.lang.String r4 = r11.f2125b
            goto L_0x0075
        L_0x0074:
            r4 = 0
        L_0x0075:
            r22 = 2
            r7[r22] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            r7[r10] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r20 = 4
            r7[r20] = r4
            java.lang.String r4 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String r4 = java.lang.String.format(r4, r7)
            android.util.Log.d(r5, r4)
        L_0x0090:
            r4 = 7
            if (r11 != 0) goto L_0x00ae
            if (r14 == 0) goto L_0x00a9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "Skip the tag entry since tag number is not defined: "
            r7.append(r10)
            r7.append(r12)
        L_0x00a2:
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r5, r7)
        L_0x00a9:
            r10 = r5
            r25 = r6
            goto L_0x0126
        L_0x00ae:
            if (r13 <= 0) goto L_0x010d
            int[] r7 = X
            int r10 = r7.length
            if (r13 < r10) goto L_0x00b6
            goto L_0x010d
        L_0x00b6:
            boolean r10 = r11.a(r13)
            if (r10 != 0) goto L_0x00da
            if (r14 == 0) goto L_0x00a9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "Skip the tag entry since data format ("
            r7.append(r10)
            java.lang.String[] r10 = W
            r10 = r10[r13]
            r7.append(r10)
            java.lang.String r10 = ") is unexpected for tag: "
            r7.append(r10)
            java.lang.String r10 = r11.f2125b
            r7.append(r10)
            goto L_0x00a2
        L_0x00da:
            if (r13 != r4) goto L_0x00de
            int r13 = r11.f2126c
        L_0x00de:
            r10 = r5
            long r4 = (long) r15
            r7 = r7[r13]
            r25 = r6
            long r6 = (long) r7
            long r4 = r4 * r6
            r6 = 0
            int r26 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r26 < 0) goto L_0x00f6
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00f4
            goto L_0x00f6
        L_0x00f4:
            r6 = 1
            goto L_0x0129
        L_0x00f6:
            if (r14 == 0) goto L_0x0128
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip the tag entry since the number of components is invalid: "
            r6.append(r7)
            r6.append(r15)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r10, r6)
            goto L_0x0128
        L_0x010d:
            r10 = r5
            r25 = r6
            if (r14 == 0) goto L_0x0126
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Skip the tag entry since data format is invalid: "
            r4.append(r5)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r10, r4)
        L_0x0126:
            r4 = 0
        L_0x0128:
            r6 = 0
        L_0x0129:
            if (r6 != 0) goto L_0x0133
            r1.g(r8)
            r26 = r3
            r8 = r10
            goto L_0x030d
        L_0x0133:
            int r6 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            java.lang.String r7 = "Compression"
            if (r6 <= 0) goto L_0x01bd
            int r6 = r30.readInt()
            r26 = r3
            if (r14 == 0) goto L_0x0158
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r27 = r8
            java.lang.String r8 = "seek to data offset: "
            r3.append(r8)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r10, r3)
            goto L_0x015a
        L_0x0158:
            r27 = r8
        L_0x015a:
            int r3 = r0.f2091d
            r8 = 7
            if (r3 != r8) goto L_0x01b4
            java.lang.String r3 = r11.f2125b
            java.lang.String r8 = "MakerNote"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x016c
            r0.f2104q = r6
            goto L_0x01b4
        L_0x016c:
            r3 = 6
            if (r2 != r3) goto L_0x01b4
            java.lang.String r8 = r11.f2125b
            java.lang.String r9 = "ThumbnailImage"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x01b4
            r0.f2105r = r6
            r0.f2106s = r15
            java.nio.ByteOrder r8 = r0.f2095h
            androidx.exifinterface.media.a$d r3 = androidx.exifinterface.media.a.d.j(r3, r8)
            int r8 = r0.f2105r
            long r8 = (long) r8
            r18 = r15
            java.nio.ByteOrder r15 = r0.f2095h
            androidx.exifinterface.media.a$d r8 = androidx.exifinterface.media.a.d.f(r8, r15)
            int r9 = r0.f2106s
            r24 = r10
            long r9 = (long) r9
            java.nio.ByteOrder r15 = r0.f2095h
            androidx.exifinterface.media.a$d r9 = androidx.exifinterface.media.a.d.f(r9, r15)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r10 = r0.f2093f
            r15 = 4
            r10 = r10[r15]
            r10.put(r7, r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f2093f
            r3 = r3[r15]
            java.lang.String r10 = "JPEGInterchangeFormat"
            r3.put(r10, r8)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f2093f
            r3 = r3[r15]
            java.lang.String r8 = "JPEGInterchangeFormatLength"
            r3.put(r8, r9)
            goto L_0x01b8
        L_0x01b4:
            r24 = r10
            r18 = r15
        L_0x01b8:
            long r8 = (long) r6
            r1.g(r8)
            goto L_0x01c5
        L_0x01bd:
            r26 = r3
            r27 = r8
            r24 = r10
            r18 = r15
        L_0x01c5:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r3 = f2075o0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            java.lang.Object r3 = r3.get(r6)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r14 == 0) goto L_0x01f2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "nextIfdType: "
            r6.append(r8)
            r6.append(r3)
            java.lang.String r8 = " byteCount: "
            r6.append(r8)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            r8 = r24
            android.util.Log.d(r8, r6)
            goto L_0x01f4
        L_0x01f2:
            r8 = r24
        L_0x01f4:
            r6 = 8
            if (r3 == 0) goto L_0x0295
            r4 = -1
            r7 = 3
            if (r13 == r7) goto L_0x021a
            r7 = 4
            if (r13 == r7) goto L_0x0215
            if (r13 == r6) goto L_0x0210
            r6 = 9
            if (r13 == r6) goto L_0x020b
            r6 = 13
            if (r13 == r6) goto L_0x020b
            goto L_0x021f
        L_0x020b:
            int r4 = r30.readInt()
            goto L_0x021e
        L_0x0210:
            short r4 = r30.readShort()
            goto L_0x021e
        L_0x0215:
            long r4 = r30.d()
            goto L_0x021f
        L_0x021a:
            int r4 = r30.readUnsignedShort()
        L_0x021e:
            long r4 = (long) r4
        L_0x021f:
            if (r14 == 0) goto L_0x0239
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Long r7 = java.lang.Long.valueOf(r4)
            r9 = 0
            r6[r9] = r7
            java.lang.String r7 = r11.f2125b
            r9 = 1
            r6[r9] = r7
            java.lang.String r7 = "Offset: %d, tagName: %s"
            java.lang.String r6 = java.lang.String.format(r7, r6)
            android.util.Log.d(r8, r6)
        L_0x0239:
            r6 = 0
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0278
            java.util.Set<java.lang.Integer> r6 = r0.f2094g
            int r7 = (int) r4
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L_0x0257
            r1.g(r4)
            int r3 = r3.intValue()
            r0.M(r1, r3)
            goto L_0x028e
        L_0x0257:
            if (r14 == 0) goto L_0x028e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip jump into the IFD since it has already been read: IfdType "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = " (at "
            r6.append(r3)
            r6.append(r4)
            java.lang.String r3 = ")"
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            goto L_0x028b
        L_0x0278:
            if (r14 == 0) goto L_0x028e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "Skip jump into the IFD since its offset is invalid: "
            r3.append(r6)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x028b:
            android.util.Log.d(r8, r3)
        L_0x028e:
            r9 = r27
        L_0x0290:
            r1.g(r9)
            goto L_0x030d
        L_0x0295:
            r9 = r27
            int r3 = r30.b()
            int r12 = r0.f2103p
            int r3 = r3 + r12
            int r4 = (int) r4
            byte[] r4 = new byte[r4]
            r1.readFully(r4)
            androidx.exifinterface.media.a$d r5 = new androidx.exifinterface.media.a$d
            long r14 = (long) r3
            r19 = r14
            r14 = r5
            r3 = r18
            r15 = r13
            r16 = r3
            r17 = r19
            r19 = r4
            r14.<init>(r15, r16, r17, r19)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f2093f
            r3 = r3[r2]
            java.lang.String r4 = r11.f2125b
            r3.put(r4, r5)
            java.lang.String r3 = r11.f2125b
            java.lang.String r4 = "DNGVersion"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x02cc
            r3 = 3
            r0.f2091d = r3
        L_0x02cc:
            java.lang.String r3 = r11.f2125b
            java.lang.String r4 = "Make"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x02e0
            java.lang.String r3 = r11.f2125b
            java.lang.String r4 = "Model"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x02ee
        L_0x02e0:
            java.nio.ByteOrder r3 = r0.f2095h
            java.lang.String r3 = r5.n(r3)
            java.lang.String r4 = "PENTAX"
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x0301
        L_0x02ee:
            java.lang.String r3 = r11.f2125b
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x0303
            java.nio.ByteOrder r3 = r0.f2095h
            int r3 = r5.m(r3)
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r3 != r4) goto L_0x0303
        L_0x0301:
            r0.f2091d = r6
        L_0x0303:
            int r3 = r30.b()
            long r3 = (long) r3
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x030d
            goto L_0x0290
        L_0x030d:
            int r6 = r25 + 1
            short r6 = (short) r6
            r5 = r8
            r3 = r26
            r4 = 0
            goto L_0x0034
        L_0x0316:
            r8 = r5
            int r2 = r30.readInt()
            boolean r3 = f2082v
            if (r3 == 0) goto L_0x0332
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "nextIfdOffset: %d"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            android.util.Log.d(r8, r4)
        L_0x0332:
            long r4 = (long) r2
            r9 = 0
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x036f
            java.util.Set<java.lang.Integer> r6 = r0.f2094g
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            boolean r6 = r6.contains(r9)
            if (r6 != 0) goto L_0x0365
            r1.g(r4)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r2 = r0.f2093f
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0357
            r0.M(r1, r3)
            goto L_0x0385
        L_0x0357:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r2 = r0.f2093f
            r2 = r2[r7]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0385
            r0.M(r1, r7)
            goto L_0x0385
        L_0x0365:
            if (r3 == 0) goto L_0x0385
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            goto L_0x0378
        L_0x036f:
            if (r3 == 0) goto L_0x0385
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
        L_0x0378:
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r8, r1)
        L_0x0385:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.M(androidx.exifinterface.media.a$g, int):void");
    }

    private void N(String str) {
        for (int i5 = 0; i5 < f2070j0.length; i5++) {
            this.f2093f[i5].remove(str);
        }
    }

    private void O(int i5, String str, String str2) {
        if (!this.f2093f[i5].isEmpty() && this.f2093f[i5].get(str) != null) {
            HashMap<String, d> hashMap = this.f2093f[i5];
            hashMap.put(str2, hashMap.get(str));
            this.f2093f[i5].remove(str);
        }
    }

    private void P(g gVar, int i5) {
        d dVar = this.f2093f[i5].get("ImageLength");
        d dVar2 = this.f2093f[i5].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            d dVar3 = this.f2093f[i5].get("JPEGInterchangeFormat");
            d dVar4 = this.f2093f[i5].get("JPEGInterchangeFormatLength");
            if (dVar3 != null && dVar4 != null) {
                int m5 = dVar3.m(this.f2095h);
                int m6 = dVar3.m(this.f2095h);
                gVar.g((long) m5);
                byte[] bArr = new byte[m6];
                gVar.read(bArr);
                g(new b(bArr), m5, i5);
            }
        }
    }

    private void R(InputStream inputStream, OutputStream outputStream) {
        if (f2082v) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() == -1) {
            cVar.d(-1);
            if (bVar.readByte() == -40) {
                cVar.d(-40);
                d dVar = null;
                if (d("Xmp") != null && this.f2108u) {
                    dVar = this.f2093f[0].remove("Xmp");
                }
                cVar.d(-1);
                cVar.d(-31);
                a0(cVar);
                if (dVar != null) {
                    this.f2093f[0].put("Xmp", dVar);
                }
                byte[] bArr = new byte[4096];
                while (bVar.readByte() == -1) {
                    byte readByte = bVar.readByte();
                    if (readByte == -39 || readByte == -38) {
                        cVar.d(-1);
                        cVar.d(readByte);
                        b.e(bVar, cVar);
                        return;
                    } else if (readByte != -31) {
                        cVar.d(-1);
                        cVar.d(readByte);
                        int readUnsignedShort = bVar.readUnsignedShort();
                        cVar.h(readUnsignedShort);
                        int i5 = readUnsignedShort - 2;
                        if (i5 >= 0) {
                            while (i5 > 0) {
                                int read = bVar.read(bArr, 0, Math.min(i5, 4096));
                                if (read < 0) {
                                    break;
                                }
                                cVar.write(bArr, 0, read);
                                i5 -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = bVar.readUnsignedShort() - 2;
                        if (readUnsignedShort2 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (readUnsignedShort2 >= 6) {
                                if (bVar.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, f2077q0)) {
                                    bVar.f(readUnsignedShort2 - 6);
                                }
                            }
                            cVar.d(-1);
                            cVar.d(readByte);
                            cVar.h(readUnsignedShort2 + 2);
                            if (readUnsignedShort2 >= 6) {
                                readUnsignedShort2 -= 6;
                                cVar.write(bArr2);
                            }
                            while (readUnsignedShort2 > 0) {
                                int read2 = bVar.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                cVar.write(bArr, 0, read2);
                                readUnsignedShort2 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void S(InputStream inputStream, OutputStream outputStream) {
        if (f2082v) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = H;
        b.f(bVar, cVar, bArr.length);
        int i5 = this.f2103p;
        if (i5 == 0) {
            int readInt = bVar.readInt();
            cVar.e(readInt);
            b.f(bVar, cVar, readInt + 4 + 4);
        } else {
            b.f(bVar, cVar, ((i5 - bArr.length) - 4) - 4);
            bVar.f(bVar.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                a0(cVar2);
                byte[] byteArray = ((ByteArrayOutputStream) cVar2.f2118e).toByteArray();
                cVar.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                cVar.e((int) crc32.getValue());
                b.c(byteArrayOutputStream2);
                b.e(bVar, cVar);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                b.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            b.c(byteArrayOutputStream);
            throw th;
        }
    }

    private void T(InputStream inputStream, OutputStream outputStream) {
        int i5;
        int i6;
        int i7;
        InputStream inputStream2 = inputStream;
        OutputStream outputStream2 = outputStream;
        if (f2082v) {
            Log.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + inputStream2 + ", outputStream: " + outputStream2 + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        b bVar = new b(inputStream2, byteOrder);
        c cVar = new c(outputStream2, byteOrder);
        byte[] bArr = L;
        b.f(bVar, cVar, bArr.length);
        byte[] bArr2 = M;
        bVar.f(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                int i8 = this.f2103p;
                if (i8 != 0) {
                    b.f(bVar, cVar2, ((i8 - ((bArr.length + 4) + bArr2.length)) - 4) - 4);
                    bVar.f(4);
                    int readInt = bVar.readInt();
                    if (readInt % 2 != 0) {
                        readInt++;
                    }
                    bVar.f(readInt);
                } else {
                    byte[] bArr3 = new byte[4];
                    if (bVar.read(bArr3) == 4) {
                        byte[] bArr4 = P;
                        boolean z4 = false;
                        boolean z5 = true;
                        if (Arrays.equals(bArr3, bArr4)) {
                            int readInt2 = bVar.readInt();
                            byte[] bArr5 = new byte[(readInt2 % 2 == 1 ? readInt2 + 1 : readInt2)];
                            bVar.read(bArr5);
                            byte b5 = (byte) (8 | bArr5[0]);
                            bArr5[0] = b5;
                            if (((b5 >> 1) & 1) == 1) {
                                z4 = true;
                            }
                            cVar2.write(bArr4);
                            cVar2.e(readInt2);
                            cVar2.write(bArr5);
                            if (z4) {
                                b(bVar, cVar2, S, (byte[]) null);
                                while (true) {
                                    byte[] bArr6 = new byte[4];
                                    inputStream2.read(bArr6);
                                    if (!Arrays.equals(bArr6, T)) {
                                        break;
                                    }
                                    c(bVar, cVar2, bArr6);
                                }
                            } else {
                                b(bVar, cVar2, R, Q);
                            }
                        } else {
                            byte[] bArr7 = R;
                            if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, Q)) {
                                int readInt3 = bVar.readInt();
                                int i9 = readInt3 % 2 == 1 ? readInt3 + 1 : readInt3;
                                byte[] bArr8 = new byte[3];
                                if (Arrays.equals(bArr3, bArr7)) {
                                    bVar.read(bArr8);
                                    byte[] bArr9 = new byte[3];
                                    if (bVar.read(bArr9) != 3 || !Arrays.equals(O, bArr9)) {
                                        throw new IOException("Encountered error while checking VP8 signature");
                                    }
                                    i7 = bVar.readInt();
                                    i9 -= 10;
                                    i5 = (i7 << 2) >> 18;
                                    i6 = (i7 << 18) >> 18;
                                    z5 = false;
                                } else if (!Arrays.equals(bArr3, Q)) {
                                    i7 = 0;
                                    z5 = false;
                                    i6 = 0;
                                    i5 = 0;
                                } else if (bVar.readByte() == 47) {
                                    i7 = bVar.readInt();
                                    i6 = (i7 & 16383) + 1;
                                    i5 = ((i7 & 268419072) >>> 14) + 1;
                                    if ((i7 & 268435456) == 0) {
                                        z5 = false;
                                    }
                                    i9 -= 5;
                                } else {
                                    throw new IOException("Encountered error while checking VP8L signature");
                                }
                                cVar2.write(bArr4);
                                cVar2.e(10);
                                byte[] bArr10 = new byte[10];
                                if (z5) {
                                    bArr10[0] = (byte) (bArr10[0] | 16);
                                }
                                bArr10[0] = (byte) (bArr10[0] | 8);
                                int i10 = i6 - 1;
                                int i11 = i5 - 1;
                                bArr10[4] = (byte) i10;
                                bArr10[5] = (byte) (i10 >> 8);
                                bArr10[6] = (byte) (i10 >> 16);
                                bArr10[7] = (byte) i11;
                                bArr10[8] = (byte) (i11 >> 8);
                                bArr10[9] = (byte) (i11 >> 16);
                                cVar2.write(bArr10);
                                cVar2.write(bArr3);
                                cVar2.e(readInt3);
                                if (Arrays.equals(bArr3, bArr7)) {
                                    cVar2.write(bArr8);
                                    cVar2.write(O);
                                } else {
                                    if (Arrays.equals(bArr3, Q)) {
                                        cVar2.write(47);
                                    }
                                    b.f(bVar, cVar2, i9);
                                }
                                cVar2.e(i7);
                                b.f(bVar, cVar2, i9);
                            }
                            b.e(bVar, cVar2);
                            int size = byteArrayOutputStream2.size();
                            byte[] bArr11 = M;
                            cVar.e(size + bArr11.length);
                            cVar.write(bArr11);
                            byteArrayOutputStream2.writeTo(cVar);
                            b.c(byteArrayOutputStream2);
                        }
                    } else {
                        throw new IOException("Encountered invalid length while parsing WebP chunk type");
                    }
                }
                a0(cVar2);
                b.e(bVar, cVar2);
                int size2 = byteArrayOutputStream2.size();
                byte[] bArr112 = M;
                cVar.e(size2 + bArr112.length);
                cVar.write(bArr112);
                byteArrayOutputStream2.writeTo(cVar);
                b.c(byteArrayOutputStream2);
            } catch (Exception e5) {
                e = e5;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th) {
                    th = th;
                    b.c(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                b.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            throw new IOException("Failed to save WebP file", e);
        }
    }

    private void V(b bVar) {
        HashMap<String, d> hashMap = this.f2093f[4];
        d dVar = hashMap.get("Compression");
        if (dVar != null) {
            int m5 = dVar.m(this.f2095h);
            this.f2102o = m5;
            if (m5 != 1) {
                if (m5 != 6) {
                    if (m5 != 7) {
                        return;
                    }
                }
            }
            if (D(hashMap)) {
                t(bVar, hashMap);
                return;
            }
            return;
        }
        this.f2102o = 6;
        s(bVar, hashMap);
    }

    private static boolean W(int i5) {
        return (i5 == 4 || i5 == 9 || i5 == 13 || i5 == 14) ? false : true;
    }

    private void X(int i5, int i6) {
        String str;
        if (!this.f2093f[i5].isEmpty() && !this.f2093f[i6].isEmpty()) {
            d dVar = this.f2093f[i5].get("ImageLength");
            d dVar2 = this.f2093f[i5].get("ImageWidth");
            d dVar3 = this.f2093f[i6].get("ImageLength");
            d dVar4 = this.f2093f[i6].get("ImageWidth");
            if (dVar == null || dVar2 == null) {
                if (f2082v) {
                    str = "First image does not contain valid size information";
                } else {
                    return;
                }
            } else if (dVar3 != null && dVar4 != null) {
                int m5 = dVar.m(this.f2095h);
                int m6 = dVar2.m(this.f2095h);
                int m7 = dVar3.m(this.f2095h);
                int m8 = dVar4.m(this.f2095h);
                if (m5 < m7 && m6 < m8) {
                    HashMap<String, d>[] hashMapArr = this.f2093f;
                    HashMap<String, d> hashMap = hashMapArr[i5];
                    hashMapArr[i5] = hashMapArr[i6];
                    hashMapArr[i6] = hashMap;
                    return;
                }
                return;
            } else if (f2082v) {
                str = "Second image does not contain valid size information";
            } else {
                return;
            }
            Log.d("ExifInterface", str);
        } else if (f2082v) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    private void Y(g gVar, int i5) {
        d dVar;
        d dVar2;
        StringBuilder sb;
        String arrays;
        d dVar3 = this.f2093f[i5].get("DefaultCropSize");
        d dVar4 = this.f2093f[i5].get("SensorTopBorder");
        d dVar5 = this.f2093f[i5].get("SensorLeftBorder");
        d dVar6 = this.f2093f[i5].get("SensorBottomBorder");
        d dVar7 = this.f2093f[i5].get("SensorRightBorder");
        if (dVar3 != null) {
            if (dVar3.f2120a == 5) {
                f[] fVarArr = (f[]) dVar3.o(this.f2095h);
                if (fVarArr == null || fVarArr.length != 2) {
                    sb = new StringBuilder();
                    sb.append("Invalid crop size values. cropSize=");
                    arrays = Arrays.toString(fVarArr);
                } else {
                    dVar2 = d.h(fVarArr[0], this.f2095h);
                    dVar = d.h(fVarArr[1], this.f2095h);
                    this.f2093f[i5].put("ImageWidth", dVar2);
                    this.f2093f[i5].put("ImageLength", dVar);
                    return;
                }
            } else {
                int[] iArr = (int[]) dVar3.o(this.f2095h);
                if (iArr == null || iArr.length != 2) {
                    sb = new StringBuilder();
                    sb.append("Invalid crop size values. cropSize=");
                    arrays = Arrays.toString(iArr);
                } else {
                    dVar2 = d.j(iArr[0], this.f2095h);
                    dVar = d.j(iArr[1], this.f2095h);
                    this.f2093f[i5].put("ImageWidth", dVar2);
                    this.f2093f[i5].put("ImageLength", dVar);
                    return;
                }
            }
            sb.append(arrays);
            Log.w("ExifInterface", sb.toString());
        } else if (dVar4 == null || dVar5 == null || dVar6 == null || dVar7 == null) {
            P(gVar, i5);
        } else {
            int m5 = dVar4.m(this.f2095h);
            int m6 = dVar6.m(this.f2095h);
            int m7 = dVar7.m(this.f2095h);
            int m8 = dVar5.m(this.f2095h);
            if (m6 > m5 && m7 > m8) {
                d j5 = d.j(m6 - m5, this.f2095h);
                d j6 = d.j(m7 - m8, this.f2095h);
                this.f2093f[i5].put("ImageLength", j5);
                this.f2093f[i5].put("ImageWidth", j6);
            }
        }
    }

    private void Z() {
        X(0, 5);
        X(0, 4);
        X(5, 4);
        d dVar = this.f2093f[1].get("PixelXDimension");
        d dVar2 = this.f2093f[1].get("PixelYDimension");
        if (!(dVar == null || dVar2 == null)) {
            this.f2093f[0].put("ImageWidth", dVar);
            this.f2093f[0].put("ImageLength", dVar2);
        }
        if (this.f2093f[4].isEmpty() && F(this.f2093f[5])) {
            HashMap<String, d>[] hashMapArr = this.f2093f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!F(this.f2093f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        O(0, "ThumbnailOrientation", "Orientation");
        O(0, "ThumbnailImageLength", "ImageLength");
        O(0, "ThumbnailImageWidth", "ImageWidth");
        O(5, "ThumbnailOrientation", "Orientation");
        O(5, "ThumbnailImageLength", "ImageLength");
        O(5, "ThumbnailImageWidth", "ImageWidth");
        O(4, "Orientation", "ThumbnailOrientation");
        O(4, "ImageLength", "ThumbnailImageLength");
        O(4, "ImageWidth", "ThumbnailImageWidth");
    }

    private void a() {
        String d5 = d("DateTimeOriginal");
        if (d5 != null && d("DateTime") == null) {
            this.f2093f[0].put("DateTime", d.e(d5));
        }
        if (d("ImageWidth") == null) {
            this.f2093f[0].put("ImageWidth", d.f(0, this.f2095h));
        }
        if (d("ImageLength") == null) {
            this.f2093f[0].put("ImageLength", d.f(0, this.f2095h));
        }
        if (d("Orientation") == null) {
            this.f2093f[0].put("Orientation", d.f(0, this.f2095h));
        }
        if (d("LightSource") == null) {
            this.f2093f[1].put("LightSource", d.f(0, this.f2095h));
        }
    }

    private int a0(c cVar) {
        c cVar2 = cVar;
        e[][] eVarArr = f2070j0;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : f2071k0) {
            N(eVar.f2125b);
        }
        if (this.f2096i) {
            if (this.f2097j) {
                N("StripOffsets");
                N("StripByteCounts");
            } else {
                N("JPEGInterchangeFormat");
                N("JPEGInterchangeFormatLength");
            }
        }
        for (int i5 = 0; i5 < f2070j0.length; i5++) {
            for (Object obj : this.f2093f[i5].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f2093f[i5].remove(entry.getKey());
                }
            }
        }
        if (!this.f2093f[1].isEmpty()) {
            this.f2093f[0].put(f2071k0[1].f2125b, d.f(0, this.f2095h));
        }
        if (!this.f2093f[2].isEmpty()) {
            this.f2093f[0].put(f2071k0[2].f2125b, d.f(0, this.f2095h));
        }
        if (!this.f2093f[3].isEmpty()) {
            this.f2093f[1].put(f2071k0[3].f2125b, d.f(0, this.f2095h));
        }
        if (this.f2096i) {
            if (this.f2097j) {
                this.f2093f[4].put("StripOffsets", d.j(0, this.f2095h));
                this.f2093f[4].put("StripByteCounts", d.j(this.f2100m, this.f2095h));
            } else {
                this.f2093f[4].put("JPEGInterchangeFormat", d.f(0, this.f2095h));
                this.f2093f[4].put("JPEGInterchangeFormatLength", d.f((long) this.f2100m, this.f2095h));
            }
        }
        for (int i6 = 0; i6 < f2070j0.length; i6++) {
            int i7 = 0;
            for (Map.Entry<String, d> value : this.f2093f[i6].entrySet()) {
                int p5 = ((d) value.getValue()).p();
                if (p5 > 4) {
                    i7 += p5;
                }
            }
            iArr2[i6] = iArr2[i6] + i7;
        }
        int i8 = 8;
        for (int i9 = 0; i9 < f2070j0.length; i9++) {
            if (!this.f2093f[i9].isEmpty()) {
                iArr[i9] = i8;
                i8 += (this.f2093f[i9].size() * 12) + 2 + 4 + iArr2[i9];
            }
        }
        if (this.f2096i) {
            if (this.f2097j) {
                this.f2093f[4].put("StripOffsets", d.j(i8, this.f2095h));
            } else {
                this.f2093f[4].put("JPEGInterchangeFormat", d.f((long) i8, this.f2095h));
            }
            this.f2099l = i8;
            i8 += this.f2100m;
        }
        if (this.f2091d == 4) {
            i8 += 8;
        }
        if (f2082v) {
            for (int i10 = 0; i10 < f2070j0.length; i10++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(i10), Integer.valueOf(iArr[i10]), Integer.valueOf(this.f2093f[i10].size()), Integer.valueOf(iArr2[i10]), Integer.valueOf(i8)}));
            }
        }
        if (!this.f2093f[1].isEmpty()) {
            this.f2093f[0].put(f2071k0[1].f2125b, d.f((long) iArr[1], this.f2095h));
        }
        if (!this.f2093f[2].isEmpty()) {
            this.f2093f[0].put(f2071k0[2].f2125b, d.f((long) iArr[2], this.f2095h));
        }
        if (!this.f2093f[3].isEmpty()) {
            this.f2093f[1].put(f2071k0[3].f2125b, d.f((long) iArr[3], this.f2095h));
        }
        int i11 = this.f2091d;
        if (i11 == 4) {
            cVar2.h(i8);
            cVar2.write(f2077q0);
        } else if (i11 == 13) {
            cVar2.e(i8);
            cVar2.write(I);
        } else if (i11 == 14) {
            cVar2.write(N);
            cVar2.e(i8);
        }
        cVar2.f(this.f2095h == ByteOrder.BIG_ENDIAN ? (short) 19789 : 18761);
        cVar2.b(this.f2095h);
        cVar2.h(42);
        cVar2.g(8);
        for (int i12 = 0; i12 < f2070j0.length; i12++) {
            if (!this.f2093f[i12].isEmpty()) {
                cVar2.h(this.f2093f[i12].size());
                int size = iArr[i12] + 2 + (this.f2093f[i12].size() * 12) + 4;
                for (Map.Entry next : this.f2093f[i12].entrySet()) {
                    int i13 = f2073m0[i12].get(next.getKey()).f2124a;
                    d dVar = (d) next.getValue();
                    int p6 = dVar.p();
                    cVar2.h(i13);
                    cVar2.h(dVar.f2120a);
                    cVar2.e(dVar.f2121b);
                    if (p6 > 4) {
                        cVar2.g((long) size);
                        size += p6;
                    } else {
                        cVar2.write(dVar.f2123d);
                        if (p6 < 4) {
                            while (p6 < 4) {
                                cVar2.d(0);
                                p6++;
                            }
                        }
                    }
                }
                if (i12 != 0 || this.f2093f[4].isEmpty()) {
                    cVar2.g(0);
                } else {
                    cVar2.g((long) iArr[4]);
                }
                for (Map.Entry<String, d> value2 : this.f2093f[i12].entrySet()) {
                    byte[] bArr = ((d) value2.getValue()).f2123d;
                    if (bArr.length > 4) {
                        cVar2.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.f2096i) {
            cVar2.write(p());
        }
        if (this.f2091d == 14 && i8 % 2 == 1) {
            cVar2.d(0);
        }
        cVar2.b(ByteOrder.BIG_ENDIAN);
        return i8;
    }

    private void b(b bVar, c cVar, byte[] bArr, byte[] bArr2) {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = f2076p0;
                sb.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = BuildConfig.FLAVOR;
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
            c(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void c(b bVar, c cVar, byte[] bArr) {
        int readInt = bVar.readInt();
        cVar.write(bArr);
        cVar.e(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        b.f(bVar, cVar, readInt);
    }

    private d e(String str) {
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                if (f2082v) {
                    Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = "PhotographicSensitivity";
            }
            for (int i5 = 0; i5 < f2070j0.length; i5++) {
                d dVar = this.f2093f[i5].get(str);
                if (dVar != null) {
                    return dVar;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0138, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0141, code lost:
        throw new java.lang.UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0142, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0145, code lost:
        throw r13;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x013a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(androidx.exifinterface.media.a.g r13) {
        /*
            r12 = this;
            java.lang.String r0 = "yes"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x0146
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            androidx.exifinterface.media.a$a r2 = new androidx.exifinterface.media.a$a     // Catch:{ RuntimeException -> 0x013a }
            r2.<init>(r13)     // Catch:{ RuntimeException -> 0x013a }
            androidx.exifinterface.media.b.C0035b.a(r1, r2)     // Catch:{ RuntimeException -> 0x013a }
            r2 = 33
            java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ RuntimeException -> 0x013a }
            r3 = 34
            java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ RuntimeException -> 0x013a }
            r4 = 26
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013a }
            r5 = 17
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x013a }
            boolean r4 = r0.equals(r4)     // Catch:{ RuntimeException -> 0x013a }
            r6 = 0
            if (r4 == 0) goto L_0x0047
            r0 = 29
            java.lang.String r6 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013a }
            r0 = 30
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013a }
            r4 = 31
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013a }
            goto L_0x0062
        L_0x0047:
            boolean r0 = r0.equals(r5)     // Catch:{ RuntimeException -> 0x013a }
            if (r0 == 0) goto L_0x0060
            r0 = 18
            java.lang.String r6 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013a }
            r0 = 19
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013a }
            r4 = 24
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013a }
            goto L_0x0062
        L_0x0060:
            r0 = r6
            r4 = r0
        L_0x0062:
            r5 = 0
            if (r6 == 0) goto L_0x0078
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r7 = r12.f2093f     // Catch:{ RuntimeException -> 0x013a }
            r7 = r7[r5]     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r8 = "ImageWidth"
            int r9 = java.lang.Integer.parseInt(r6)     // Catch:{ RuntimeException -> 0x013a }
            java.nio.ByteOrder r10 = r12.f2095h     // Catch:{ RuntimeException -> 0x013a }
            androidx.exifinterface.media.a$d r9 = androidx.exifinterface.media.a.d.j(r9, r10)     // Catch:{ RuntimeException -> 0x013a }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x013a }
        L_0x0078:
            if (r0 == 0) goto L_0x008d
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r7 = r12.f2093f     // Catch:{ RuntimeException -> 0x013a }
            r7 = r7[r5]     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r8 = "ImageLength"
            int r9 = java.lang.Integer.parseInt(r0)     // Catch:{ RuntimeException -> 0x013a }
            java.nio.ByteOrder r10 = r12.f2095h     // Catch:{ RuntimeException -> 0x013a }
            androidx.exifinterface.media.a$d r9 = androidx.exifinterface.media.a.d.j(r9, r10)     // Catch:{ RuntimeException -> 0x013a }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x013a }
        L_0x008d:
            r7 = 6
            if (r4 == 0) goto L_0x00b7
            r8 = 1
            int r9 = java.lang.Integer.parseInt(r4)     // Catch:{ RuntimeException -> 0x013a }
            r10 = 90
            if (r9 == r10) goto L_0x00a7
            r10 = 180(0xb4, float:2.52E-43)
            if (r9 == r10) goto L_0x00a5
            r10 = 270(0x10e, float:3.78E-43)
            if (r9 == r10) goto L_0x00a2
            goto L_0x00a8
        L_0x00a2:
            r8 = 8
            goto L_0x00a8
        L_0x00a5:
            r8 = 3
            goto L_0x00a8
        L_0x00a7:
            r8 = r7
        L_0x00a8:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r9 = r12.f2093f     // Catch:{ RuntimeException -> 0x013a }
            r9 = r9[r5]     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r10 = "Orientation"
            java.nio.ByteOrder r11 = r12.f2095h     // Catch:{ RuntimeException -> 0x013a }
            androidx.exifinterface.media.a$d r8 = androidx.exifinterface.media.a.d.j(r8, r11)     // Catch:{ RuntimeException -> 0x013a }
            r9.put(r10, r8)     // Catch:{ RuntimeException -> 0x013a }
        L_0x00b7:
            if (r2 == 0) goto L_0x010a
            if (r3 == 0) goto L_0x010a
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ RuntimeException -> 0x013a }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ RuntimeException -> 0x013a }
            if (r3 <= r7) goto L_0x0102
            long r8 = (long) r2     // Catch:{ RuntimeException -> 0x013a }
            r13.g(r8)     // Catch:{ RuntimeException -> 0x013a }
            byte[] r8 = new byte[r7]     // Catch:{ RuntimeException -> 0x013a }
            int r9 = r13.read(r8)     // Catch:{ RuntimeException -> 0x013a }
            if (r9 != r7) goto L_0x00fa
            int r2 = r2 + r7
            int r3 = r3 + -6
            byte[] r7 = f2077q0     // Catch:{ RuntimeException -> 0x013a }
            boolean r7 = java.util.Arrays.equals(r8, r7)     // Catch:{ RuntimeException -> 0x013a }
            if (r7 == 0) goto L_0x00f2
            byte[] r7 = new byte[r3]     // Catch:{ RuntimeException -> 0x013a }
            int r13 = r13.read(r7)     // Catch:{ RuntimeException -> 0x013a }
            if (r13 != r3) goto L_0x00ea
            r12.f2103p = r2     // Catch:{ RuntimeException -> 0x013a }
            r12.L(r7, r5)     // Catch:{ RuntimeException -> 0x013a }
            goto L_0x010a
        L_0x00ea:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "Can't read exif"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013a }
            throw r13     // Catch:{ RuntimeException -> 0x013a }
        L_0x00f2:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "Invalid identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013a }
            throw r13     // Catch:{ RuntimeException -> 0x013a }
        L_0x00fa:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "Can't read identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013a }
            throw r13     // Catch:{ RuntimeException -> 0x013a }
        L_0x0102:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "Invalid exif length"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013a }
            throw r13     // Catch:{ RuntimeException -> 0x013a }
        L_0x010a:
            boolean r13 = f2082v     // Catch:{ RuntimeException -> 0x013a }
            if (r13 == 0) goto L_0x0134
            java.lang.String r13 = "ExifInterface"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x013a }
            r2.<init>()     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r3 = "Heif meta: "
            r2.append(r3)     // Catch:{ RuntimeException -> 0x013a }
            r2.append(r6)     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r3 = "x"
            r2.append(r3)     // Catch:{ RuntimeException -> 0x013a }
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = ", rotation "
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013a }
            r2.append(r4)     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = r2.toString()     // Catch:{ RuntimeException -> 0x013a }
            android.util.Log.d(r13, r0)     // Catch:{ RuntimeException -> 0x013a }
        L_0x0134:
            r1.release()
            return
        L_0x0138:
            r13 = move-exception
            goto L_0x0142
        L_0x013a:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x0138 }
            java.lang.String r0 = "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."
            r13.<init>(r0)     // Catch:{ all -> 0x0138 }
            throw r13     // Catch:{ all -> 0x0138 }
        L_0x0142:
            r1.release()
            throw r13
        L_0x0146:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "Reading EXIF from HEIF files is supported from SDK 28 and above"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.f(androidx.exifinterface.media.a$g):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0184 A[LOOP:0: B:8:0x0038->B:60:0x0184, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x018e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g(androidx.exifinterface.media.a.b r22, int r23, int r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r24
            boolean r3 = f2082v
            java.lang.String r4 = "ExifInterface"
            if (r3 == 0) goto L_0x0020
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "getJpegAttributes starting with: "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r4, r3)
        L_0x0020:
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            r1.e(r3)
            byte r3 = r22.readByte()
            java.lang.String r5 = "Invalid marker: "
            r6 = -1
            if (r3 != r6) goto L_0x01d8
            byte r7 = r22.readByte()
            r8 = -40
            if (r7 != r8) goto L_0x01bd
            r3 = 2
            r5 = r3
        L_0x0038:
            byte r7 = r22.readByte()
            if (r7 != r6) goto L_0x01a0
            r7 = 1
            int r5 = r5 + r7
            byte r8 = r22.readByte()
            boolean r9 = f2082v
            if (r9 == 0) goto L_0x0062
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Found JPEG segment indicator: "
            r10.append(r11)
            r11 = r8 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r4, r10)
        L_0x0062:
            int r5 = r5 + r7
            r10 = -39
            if (r8 == r10) goto L_0x019a
            r10 = -38
            if (r8 != r10) goto L_0x006d
            goto L_0x019a
        L_0x006d:
            int r10 = r22.readUnsignedShort()
            int r10 = r10 - r3
            int r5 = r5 + r3
            if (r9 == 0) goto L_0x009e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = "JPEG segment: "
            r9.append(r11)
            r11 = r8 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r9.append(r11)
            java.lang.String r11 = " (length: "
            r9.append(r11)
            int r11 = r10 + 2
            r9.append(r11)
            java.lang.String r11 = ")"
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r4, r9)
        L_0x009e:
            java.lang.String r9 = "Invalid length"
            if (r10 < 0) goto L_0x0194
            r11 = -31
            r12 = 0
            if (r8 == r11) goto L_0x0121
            r11 = -2
            if (r8 == r11) goto L_0x00f3
            switch(r8) {
                case -64: goto L_0x00ba;
                case -63: goto L_0x00ba;
                case -62: goto L_0x00ba;
                case -61: goto L_0x00ba;
                default: goto L_0x00ad;
            }
        L_0x00ad:
            switch(r8) {
                case -59: goto L_0x00ba;
                case -58: goto L_0x00ba;
                case -57: goto L_0x00ba;
                default: goto L_0x00b0;
            }
        L_0x00b0:
            switch(r8) {
                case -55: goto L_0x00ba;
                case -54: goto L_0x00ba;
                case -53: goto L_0x00ba;
                default: goto L_0x00b3;
            }
        L_0x00b3:
            switch(r8) {
                case -51: goto L_0x00ba;
                case -50: goto L_0x00ba;
                case -49: goto L_0x00ba;
                default: goto L_0x00b6;
            }
        L_0x00b6:
            r20 = r4
            goto L_0x0182
        L_0x00ba:
            r1.f(r7)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r7 = r0.f2093f
            r7 = r7[r2]
            r8 = 4
            if (r2 == r8) goto L_0x00c7
            java.lang.String r11 = "ImageLength"
            goto L_0x00c9
        L_0x00c7:
            java.lang.String r11 = "ThumbnailImageLength"
        L_0x00c9:
            int r12 = r22.readUnsignedShort()
            long r12 = (long) r12
            java.nio.ByteOrder r14 = r0.f2095h
            androidx.exifinterface.media.a$d r12 = androidx.exifinterface.media.a.d.f(r12, r14)
            r7.put(r11, r12)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r7 = r0.f2093f
            r7 = r7[r2]
            if (r2 == r8) goto L_0x00e0
            java.lang.String r8 = "ImageWidth"
            goto L_0x00e2
        L_0x00e0:
            java.lang.String r8 = "ThumbnailImageWidth"
        L_0x00e2:
            int r11 = r22.readUnsignedShort()
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.f2095h
            androidx.exifinterface.media.a$d r11 = androidx.exifinterface.media.a.d.f(r11, r13)
            r7.put(r8, r11)
            int r10 = r10 + -5
            goto L_0x00b6
        L_0x00f3:
            byte[] r8 = new byte[r10]
            int r11 = r1.read(r8)
            if (r11 != r10) goto L_0x0119
            java.lang.String r10 = "UserComment"
            java.lang.String r11 = r0.d(r10)
            if (r11 != 0) goto L_0x0115
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r11 = r0.f2093f
            r7 = r11[r7]
            java.lang.String r11 = new java.lang.String
            java.nio.charset.Charset r13 = f2076p0
            r11.<init>(r8, r13)
            androidx.exifinterface.media.a$d r8 = androidx.exifinterface.media.a.d.e(r11)
            r7.put(r10, r8)
        L_0x0115:
            r20 = r4
            goto L_0x0181
        L_0x0119:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x0121:
            byte[] r8 = new byte[r10]
            r1.readFully(r8)
            int r11 = r5 + r10
            byte[] r13 = f2077q0
            boolean r14 = androidx.exifinterface.media.b.g(r8, r13)
            if (r14 == 0) goto L_0x0147
            int r7 = r13.length
            byte[] r7 = java.util.Arrays.copyOfRange(r8, r7, r10)
            int r5 = r23 + r5
            int r8 = r13.length
            int r5 = r5 + r8
            r0.f2103p = r5
            r0.L(r7, r2)
            androidx.exifinterface.media.a$b r5 = new androidx.exifinterface.media.a$b
            r5.<init>((byte[]) r7)
            r0.V(r5)
            goto L_0x017e
        L_0x0147:
            byte[] r13 = f2078r0
            boolean r14 = androidx.exifinterface.media.b.g(r8, r13)
            if (r14 == 0) goto L_0x017e
            int r14 = r13.length
            int r5 = r5 + r14
            int r13 = r13.length
            byte[] r8 = java.util.Arrays.copyOfRange(r8, r13, r10)
            java.lang.String r10 = "Xmp"
            java.lang.String r13 = r0.d(r10)
            if (r13 != 0) goto L_0x017e
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r13 = r0.f2093f
            r13 = r13[r12]
            androidx.exifinterface.media.a$d r15 = new androidx.exifinterface.media.a$d
            r16 = 1
            int r14 = r8.length
            r20 = r4
            long r3 = (long) r5
            r5 = r14
            r14 = r15
            r6 = r15
            r15 = r16
            r16 = r5
            r17 = r3
            r19 = r8
            r14.<init>(r15, r16, r17, r19)
            r13.put(r10, r6)
            r0.f2108u = r7
            goto L_0x0180
        L_0x017e:
            r20 = r4
        L_0x0180:
            r5 = r11
        L_0x0181:
            r10 = r12
        L_0x0182:
            if (r10 < 0) goto L_0x018e
            r1.f(r10)
            int r5 = r5 + r10
            r4 = r20
            r3 = 2
            r6 = -1
            goto L_0x0038
        L_0x018e:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r9)
            throw r1
        L_0x0194:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r9)
            throw r1
        L_0x019a:
            java.nio.ByteOrder r2 = r0.f2095h
            r1.e(r2)
            return
        L_0x01a0:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid marker:"
            r2.append(r3)
            r3 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01bd:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01d8:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.g(androidx.exifinterface.media.a$b, int, int):void");
    }

    private int h(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (x(bArr)) {
            return 4;
        }
        if (A(bArr)) {
            return 9;
        }
        if (w(bArr)) {
            return 12;
        }
        if (y(bArr)) {
            return 7;
        }
        if (B(bArr)) {
            return 10;
        }
        if (z(bArr)) {
            return 13;
        }
        return G(bArr) ? 14 : 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(androidx.exifinterface.media.a.g r6) {
        /*
            r5 = this;
            r5.l(r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r6 = r5.f2093f
            r0 = 1
            r6 = r6[r0]
            java.lang.String r1 = "MakerNote"
            java.lang.Object r6 = r6.get(r1)
            androidx.exifinterface.media.a$d r6 = (androidx.exifinterface.media.a.d) r6
            if (r6 == 0) goto L_0x00ed
            androidx.exifinterface.media.a$g r1 = new androidx.exifinterface.media.a$g
            byte[] r6 = r6.f2123d
            r1.<init>((byte[]) r6)
            java.nio.ByteOrder r6 = r5.f2095h
            r1.e(r6)
            byte[] r6 = F
            int r2 = r6.length
            byte[] r2 = new byte[r2]
            r1.readFully(r2)
            r3 = 0
            r1.g(r3)
            byte[] r3 = G
            int r4 = r3.length
            byte[] r4 = new byte[r4]
            r1.readFully(r4)
            boolean r6 = java.util.Arrays.equals(r2, r6)
            if (r6 == 0) goto L_0x003f
            r2 = 8
        L_0x003b:
            r1.g(r2)
            goto L_0x0048
        L_0x003f:
            boolean r6 = java.util.Arrays.equals(r4, r3)
            if (r6 == 0) goto L_0x0048
            r2 = 12
            goto L_0x003b
        L_0x0048:
            r6 = 6
            r5.M(r1, r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r6 = r5.f2093f
            r1 = 7
            r6 = r6[r1]
            java.lang.String r2 = "PreviewImageStart"
            java.lang.Object r6 = r6.get(r2)
            androidx.exifinterface.media.a$d r6 = (androidx.exifinterface.media.a.d) r6
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r2 = r5.f2093f
            r1 = r2[r1]
            java.lang.String r2 = "PreviewImageLength"
            java.lang.Object r1 = r1.get(r2)
            androidx.exifinterface.media.a$d r1 = (androidx.exifinterface.media.a.d) r1
            if (r6 == 0) goto L_0x007c
            if (r1 == 0) goto L_0x007c
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r2 = r5.f2093f
            r3 = 5
            r2 = r2[r3]
            java.lang.String r4 = "JPEGInterchangeFormat"
            r2.put(r4, r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r6 = r5.f2093f
            r6 = r6[r3]
            java.lang.String r2 = "JPEGInterchangeFormatLength"
            r6.put(r2, r1)
        L_0x007c:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r6 = r5.f2093f
            r1 = 8
            r6 = r6[r1]
            java.lang.String r1 = "AspectFrame"
            java.lang.Object r6 = r6.get(r1)
            androidx.exifinterface.media.a$d r6 = (androidx.exifinterface.media.a.d) r6
            if (r6 == 0) goto L_0x00ed
            java.nio.ByteOrder r1 = r5.f2095h
            java.lang.Object r6 = r6.o(r1)
            int[] r6 = (int[]) r6
            if (r6 == 0) goto L_0x00d3
            int r1 = r6.length
            r2 = 4
            if (r1 == r2) goto L_0x009b
            goto L_0x00d3
        L_0x009b:
            r1 = 2
            r1 = r6[r1]
            r2 = 0
            r3 = r6[r2]
            if (r1 <= r3) goto L_0x00ed
            r4 = 3
            r4 = r6[r4]
            r6 = r6[r0]
            if (r4 <= r6) goto L_0x00ed
            int r1 = r1 - r3
            int r1 = r1 + r0
            int r4 = r4 - r6
            int r4 = r4 + r0
            if (r1 >= r4) goto L_0x00b4
            int r1 = r1 + r4
            int r4 = r1 - r4
            int r1 = r1 - r4
        L_0x00b4:
            java.nio.ByteOrder r6 = r5.f2095h
            androidx.exifinterface.media.a$d r6 = androidx.exifinterface.media.a.d.j(r1, r6)
            java.nio.ByteOrder r0 = r5.f2095h
            androidx.exifinterface.media.a$d r0 = androidx.exifinterface.media.a.d.j(r4, r0)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r1 = r5.f2093f
            r1 = r1[r2]
            java.lang.String r3 = "ImageWidth"
            r1.put(r3, r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r6 = r5.f2093f
            r6 = r6[r2]
            java.lang.String r1 = "ImageLength"
            r6.put(r1, r0)
            goto L_0x00ed
        L_0x00d3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid aspect frame values. frame="
            r0.append(r1)
            java.lang.String r6 = java.util.Arrays.toString(r6)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "ExifInterface"
            android.util.Log.w(r0, r6)
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.i(androidx.exifinterface.media.a$g):void");
    }

    private void j(b bVar) {
        if (f2082v) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.e(ByteOrder.BIG_ENDIAN);
        byte[] bArr = H;
        bVar.f(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = bVar.readInt();
                int i5 = length + 4;
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int i6 = i5 + 4;
                    if (i6 == 16) {
                        if (!Arrays.equals(bArr2, J)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr2, K)) {
                        if (Arrays.equals(bArr2, I)) {
                            byte[] bArr3 = new byte[readInt];
                            if (bVar.read(bArr3) == readInt) {
                                int readInt2 = bVar.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f2103p = i6;
                                    L(bArr3, 0);
                                    Z();
                                    V(new b(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + b.a(bArr2));
                        }
                        int i7 = readInt + 4;
                        bVar.f(i7);
                        length = i6 + i7;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void k(b bVar) {
        boolean z4 = f2082v;
        if (z4) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.f(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i5 = ByteBuffer.wrap(bArr).getInt();
        int i6 = ByteBuffer.wrap(bArr2).getInt();
        int i7 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i6];
        bVar.f(i5 - bVar.b());
        bVar.read(bArr4);
        g(new b(bArr4), i5, 5);
        bVar.f(i7 - bVar.b());
        bVar.e(ByteOrder.BIG_ENDIAN);
        int readInt = bVar.readInt();
        if (z4) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i8 = 0; i8 < readInt; i8++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f2065e0.f2124a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                d j5 = d.j(readShort, this.f2095h);
                d j6 = d.j(readShort2, this.f2095h);
                this.f2093f[0].put("ImageLength", j5);
                this.f2093f[0].put("ImageWidth", j6);
                if (f2082v) {
                    Log.d("ExifInterface", "Updated to length: " + readShort + ", width: " + readShort2);
                    return;
                }
                return;
            }
            bVar.f(readUnsignedShort2);
        }
    }

    private void l(g gVar) {
        d dVar;
        I(gVar);
        M(gVar, 0);
        Y(gVar, 0);
        Y(gVar, 5);
        Y(gVar, 4);
        Z();
        if (this.f2091d == 8 && (dVar = this.f2093f[1].get("MakerNote")) != null) {
            g gVar2 = new g(dVar.f2123d);
            gVar2.e(this.f2095h);
            gVar2.f(6);
            M(gVar2, 9);
            d dVar2 = this.f2093f[9].get("ColorSpace");
            if (dVar2 != null) {
                this.f2093f[1].put("ColorSpace", dVar2);
            }
        }
    }

    private void m(g gVar) {
        if (f2082v) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + gVar);
        }
        l(gVar);
        d dVar = this.f2093f[0].get("JpgFromRaw");
        if (dVar != null) {
            g(new b(dVar.f2123d), (int) dVar.f2122c, 5);
        }
        d dVar2 = this.f2093f[0].get("ISO");
        d dVar3 = this.f2093f[1].get("PhotographicSensitivity");
        if (dVar2 != null && dVar3 == null) {
            this.f2093f[1].put("PhotographicSensitivity", dVar2);
        }
    }

    private void n(g gVar) {
        byte[] bArr = f2077q0;
        gVar.f(bArr.length);
        byte[] bArr2 = new byte[gVar.available()];
        gVar.readFully(bArr2);
        this.f2103p = bArr.length;
        L(bArr2, 0);
    }

    private void q(b bVar) {
        if (f2082v) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.e(ByteOrder.LITTLE_ENDIAN);
        bVar.f(L.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = M;
        bVar.f(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int readInt2 = bVar.readInt();
                    int i5 = length + 4 + 4;
                    if (Arrays.equals(N, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (bVar.read(bArr3) == readInt2) {
                            this.f2103p = i5;
                            L(bArr3, 0);
                            V(new b(bArr3));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + b.a(bArr2));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i5 + readInt2;
                    if (length != readInt) {
                        if (length <= readInt) {
                            bVar.f(readInt2);
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:68|69|70) */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        java.lang.Double.parseDouble(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015c, code lost:
        return new android.util.Pair<>(12, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0162, code lost:
        return new android.util.Pair<>(2, -1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x014e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<java.lang.Integer, java.lang.Integer> r(java.lang.String r12) {
        /*
            java.lang.String r0 = ","
            boolean r1 = r12.contains(r0)
            r2 = 0
            r3 = 1
            r4 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            if (r1 == 0) goto L_0x00a6
            java.lang.String[] r12 = r12.split(r0, r6)
            r0 = r12[r2]
            android.util.Pair r0 = r(r0)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r4) goto L_0x0029
            return r0
        L_0x0029:
            int r1 = r12.length
            if (r3 >= r1) goto L_0x00a5
            r1 = r12[r3]
            android.util.Pair r1 = r(r1)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x004d
            java.lang.Object r2 = r1.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = r6
            goto L_0x0055
        L_0x004d:
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
        L_0x0055:
            java.lang.Object r4 = r0.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 == r6) goto L_0x0080
            java.lang.Object r4 = r1.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r8 = r0.second
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0077
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r4 = r0.second
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0080
        L_0x0077:
            java.lang.Object r1 = r0.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0081
        L_0x0080:
            r1 = r6
        L_0x0081:
            if (r2 != r6) goto L_0x008b
            if (r1 != r6) goto L_0x008b
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x008b:
            if (r2 != r6) goto L_0x0097
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.<init>(r1, r7)
            goto L_0x00a2
        L_0x0097:
            if (r1 != r6) goto L_0x00a2
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r7)
        L_0x00a2:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x00a5:
            return r0
        L_0x00a6:
            java.lang.String r0 = "/"
            boolean r1 = r12.contains(r0)
            r8 = 0
            if (r1 == 0) goto L_0x0105
            java.lang.String[] r12 = r12.split(r0, r6)
            int r0 = r12.length
            if (r0 != r4) goto L_0x00ff
            r0 = r12[r2]     // Catch:{ NumberFormatException -> 0x00ff }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
            r12 = r12[r3]     // Catch:{ NumberFormatException -> 0x00ff }
            double r2 = java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x00ff }
            long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
            int r12 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r4 = 10
            if (r12 < 0) goto L_0x00f5
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x00d0
            goto L_0x00f5
        L_0x00d0:
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r12 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r0 = 5
            if (r12 > 0) goto L_0x00eb
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 <= 0) goto L_0x00dd
            goto L_0x00eb
        L_0x00dd:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r1, r0)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00eb:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00f5:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00ff:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x0105:
            long r0 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014e }
            long r1 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            r2 = 4
            if (r1 < 0) goto L_0x0130
            long r3 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            r10 = 65535(0xffff, double:3.23786E-319)
            int r1 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r1 > 0) goto L_0x0130
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0130:
            long r0 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0144
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0144:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x014e:
            java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x015d }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x015d }
            r0 = 12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x015d }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x015d }
            return r12
        L_0x015d:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.r(java.lang.String):android.util.Pair");
    }

    private void s(b bVar, HashMap hashMap) {
        d dVar = (d) hashMap.get("JPEGInterchangeFormat");
        d dVar2 = (d) hashMap.get("JPEGInterchangeFormatLength");
        if (dVar != null && dVar2 != null) {
            int m5 = dVar.m(this.f2095h);
            int m6 = dVar2.m(this.f2095h);
            if (this.f2091d == 7) {
                m5 += this.f2104q;
            }
            if (m5 > 0 && m6 > 0) {
                this.f2096i = true;
                if (this.f2088a == null && this.f2090c == null && this.f2089b == null) {
                    byte[] bArr = new byte[m6];
                    bVar.skip((long) m5);
                    bVar.read(bArr);
                    this.f2101n = bArr;
                }
                this.f2099l = m5;
                this.f2100m = m6;
            }
            if (f2082v) {
                Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + m5 + ", length: " + m6);
            }
        }
    }

    private void t(b bVar, HashMap hashMap) {
        b bVar2 = bVar;
        HashMap hashMap2 = hashMap;
        d dVar = (d) hashMap2.get("StripOffsets");
        d dVar2 = (d) hashMap2.get("StripByteCounts");
        if (dVar != null && dVar2 != null) {
            long[] d5 = b.d(dVar.o(this.f2095h));
            long[] d6 = b.d(dVar2.o(this.f2095h));
            if (d5 == null || d5.length == 0) {
                Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            } else if (d6 == null || d6.length == 0) {
                Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            } else if (d5.length != d6.length) {
                Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            } else {
                long j5 = 0;
                for (long j6 : d6) {
                    j5 += j6;
                }
                int i5 = (int) j5;
                byte[] bArr = new byte[i5];
                this.f2098k = true;
                this.f2097j = true;
                this.f2096i = true;
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < d5.length; i8++) {
                    int i9 = (int) d5[i8];
                    int i10 = (int) d6[i8];
                    if (i8 < d5.length - 1 && ((long) (i9 + i10)) != d5[i8 + 1]) {
                        this.f2098k = false;
                    }
                    int i11 = i9 - i6;
                    if (i11 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                        return;
                    }
                    long j7 = (long) i11;
                    if (bVar2.skip(j7) != j7) {
                        Log.d("ExifInterface", "Failed to skip " + i11 + " bytes.");
                        return;
                    }
                    int i12 = i6 + i11;
                    byte[] bArr2 = new byte[i10];
                    if (bVar2.read(bArr2) != i10) {
                        Log.d("ExifInterface", "Failed to read " + i10 + " bytes.");
                        return;
                    }
                    i6 = i12 + i10;
                    System.arraycopy(bArr2, 0, bArr, i7, i10);
                    i7 += i10;
                }
                this.f2101n = bArr;
                if (this.f2098k) {
                    this.f2099l = (int) d5[0];
                    this.f2100m = i5;
                }
            }
        }
    }

    private void u(String str) {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.f2090c = null;
            this.f2088a = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    if (C(fileInputStream2.getFD())) {
                        this.f2089b = fileInputStream2.getFD();
                    } else {
                        this.f2089b = null;
                    }
                    H(fileInputStream2);
                    b.c(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    b.c(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                b.c(fileInputStream);
                throw th;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    private static boolean v(BufferedInputStream bufferedInputStream) {
        byte[] bArr = f2077q0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i5 = 0;
        while (true) {
            byte[] bArr3 = f2077q0;
            if (i5 >= bArr3.length) {
                return true;
            }
            if (bArr2[i5] != bArr3[i5]) {
                return false;
            }
            i5++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0092 A[Catch:{ all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean w(byte[] r15) {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.a$b r2 = new androidx.exifinterface.media.a$b     // Catch:{ Exception -> 0x008d }
            r2.<init>((byte[]) r15)     // Catch:{ Exception -> 0x008d }
            int r1 = r2.readInt()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r1 = 4
            byte[] r5 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r2.read(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            byte[] r6 = C     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r5 = java.util.Arrays.equals(r5, r6)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r5 != 0) goto L_0x001e
            r2.close()
            return r0
        L_0x001e:
            r5 = 1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r8 = 16
            r10 = 8
            if (r7 != 0) goto L_0x0034
            long r3 = r2.readLong()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x0035
            r2.close()
            return r0
        L_0x0034:
            r8 = r10
        L_0x0035:
            int r7 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r12 = (long) r7     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r7 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r7 <= 0) goto L_0x003d
            int r15 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r15
        L_0x003d:
            long r3 = r3 - r8
            int r15 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x0046
            r2.close()
            return r0
        L_0x0046:
            byte[] r15 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r7 = 0
            r9 = r0
            r10 = r9
        L_0x004c:
            r11 = 4
            long r11 = r3 / r11
            int r11 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0081
            int r11 = r2.read(r15)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == r1) goto L_0x005e
            r2.close()
            return r0
        L_0x005e:
            int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r11 != 0) goto L_0x0063
            goto L_0x007f
        L_0x0063:
            byte[] r11 = D     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r12 = 1
            if (r11 == 0) goto L_0x006e
            r9 = r12
            goto L_0x0077
        L_0x006e:
            byte[] r11 = E     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == 0) goto L_0x0077
            r10 = r12
        L_0x0077:
            if (r9 == 0) goto L_0x007f
            if (r10 == 0) goto L_0x007f
            r2.close()
            return r12
        L_0x007f:
            long r7 = r7 + r5
            goto L_0x004c
        L_0x0081:
            r2.close()
            goto L_0x009e
        L_0x0085:
            r15 = move-exception
            r1 = r2
            goto L_0x009f
        L_0x0088:
            r15 = move-exception
            r1 = r2
            goto L_0x008e
        L_0x008b:
            r15 = move-exception
            goto L_0x009f
        L_0x008d:
            r15 = move-exception
        L_0x008e:
            boolean r2 = f2082v     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x0099
            java.lang.String r2 = "ExifInterface"
            java.lang.String r3 = "Exception parsing HEIF file type box."
            android.util.Log.d(r2, r3, r15)     // Catch:{ all -> 0x008b }
        L_0x0099:
            if (r1 == 0) goto L_0x009e
            r1.close()
        L_0x009e:
            return r0
        L_0x009f:
            if (r1 == 0) goto L_0x00a4
            r1.close()
        L_0x00a4:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.w(byte[]):boolean");
    }

    private static boolean x(byte[] bArr) {
        int i5 = 0;
        while (true) {
            byte[] bArr2 = B;
            if (i5 >= bArr2.length) {
                return true;
            }
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
            i5++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean y(byte[] r4) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.a$b r2 = new androidx.exifinterface.media.a$b     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            java.nio.ByteOrder r4 = r3.K(r2)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r3.f2095h = r4     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r2.e(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1 = 20306(0x4f52, float:2.8455E-41)
            if (r4 == r1) goto L_0x001c
            r1 = 21330(0x5352, float:2.989E-41)
            if (r4 != r1) goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r2.close()
            return r0
        L_0x0021:
            r4 = move-exception
            r1 = r2
            goto L_0x0027
        L_0x0024:
            r1 = r2
            goto L_0x002d
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            throw r4
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.y(byte[]):boolean");
    }

    private boolean z(byte[] bArr) {
        int i5 = 0;
        while (true) {
            byte[] bArr2 = H;
            if (i5 >= bArr2.length) {
                return true;
            }
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
            i5++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c7, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c8, code lost:
        r9 = null;
        r1 = r6;
        r6 = r8;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00cd, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ce, code lost:
        r8 = null;
        r9 = null;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d3, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00e4, code lost:
        androidx.exifinterface.media.b.a.c(r13.f2089b, 0, android.system.OsConstants.SEEK_SET);
        r1 = new java.io.FileOutputStream(r13.f2089b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f3, code lost:
        r1 = new java.io.FileOutputStream(r13.f2088a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0145, code lost:
        r2.delete();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d2 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:27:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e4 A[Catch:{ Exception -> 0x010e, all -> 0x010c }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f3 A[Catch:{ Exception -> 0x010e, all -> 0x010c }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0145  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Q() {
        /*
            r13 = this;
            int r0 = r13.f2091d
            boolean r0 = E(r0)
            if (r0 == 0) goto L_0x016a
            java.io.FileDescriptor r0 = r13.f2089b
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = r13.f2088a
            if (r0 == 0) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes for the current input."
            r0.<init>(r1)
            throw r0
        L_0x0019:
            boolean r0 = r13.f2096i
            if (r0 == 0) goto L_0x002e
            boolean r0 = r13.f2097j
            if (r0 == 0) goto L_0x002e
            boolean r0 = r13.f2098k
            if (r0 == 0) goto L_0x0026
            goto L_0x002e
        L_0x0026:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips"
            r0.<init>(r1)
            throw r0
        L_0x002e:
            r0 = 1
            r13.f2107t = r0
            byte[] r1 = r13.o()
            r13.f2101n = r1
            r1 = 0
            java.lang.String r2 = "temp"
            java.lang.String r3 = "tmp"
            java.io.File r2 = java.io.File.createTempFile(r2, r3)     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            java.lang.String r3 = r13.f2088a     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            r4 = 0
            if (r3 == 0) goto L_0x004e
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            java.lang.String r6 = r13.f2088a     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            goto L_0x005c
        L_0x004e:
            java.io.FileDescriptor r3 = r13.f2089b     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            int r6 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            androidx.exifinterface.media.b.a.c(r3, r4, r6)     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            java.io.FileDescriptor r6 = r13.f2089b     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
        L_0x005c:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0151, all -> 0x014d }
            r6.<init>(r2)     // Catch:{ Exception -> 0x0151, all -> 0x014d }
            androidx.exifinterface.media.b.e(r3, r6)     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            androidx.exifinterface.media.b.c(r3)
            androidx.exifinterface.media.b.c(r6)
            r3 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00d6, all -> 0x00d2 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00d6, all -> 0x00d2 }
            java.lang.String r7 = r13.f2088a     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            if (r7 == 0) goto L_0x007c
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            java.lang.String r8 = r13.f2088a     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            goto L_0x008a
        L_0x007c:
            java.io.FileDescriptor r7 = r13.f2089b     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            int r8 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            androidx.exifinterface.media.b.a.c(r7, r4, r8)     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            java.io.FileDescriptor r8 = r13.f2089b     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
        L_0x008a:
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00c7, all -> 0x00d2 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x00c7, all -> 0x00d2 }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00c1, all -> 0x00bd }
            r9.<init>(r7)     // Catch:{ Exception -> 0x00c1, all -> 0x00bd }
            int r10 = r13.f2091d     // Catch:{ Exception -> 0x00b8 }
            r11 = 4
            if (r10 != r11) goto L_0x009d
            r13.R(r8, r9)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00ac
        L_0x009d:
            r11 = 13
            if (r10 != r11) goto L_0x00a5
            r13.S(r8, r9)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00ac
        L_0x00a5:
            r11 = 14
            if (r10 != r11) goto L_0x00ac
            r13.T(r8, r9)     // Catch:{ Exception -> 0x00b8 }
        L_0x00ac:
            androidx.exifinterface.media.b.c(r8)
            androidx.exifinterface.media.b.c(r9)
            r2.delete()
            r13.f2101n = r1
            return
        L_0x00b8:
            r1 = move-exception
            r12 = r6
            r6 = r1
            r1 = r12
            goto L_0x00db
        L_0x00bd:
            r0 = move-exception
            r9 = r1
            goto L_0x013c
        L_0x00c1:
            r9 = move-exception
            r12 = r9
            r9 = r1
            r1 = r6
            r6 = r12
            goto L_0x00db
        L_0x00c7:
            r8 = move-exception
            r9 = r1
            r1 = r6
            r6 = r8
            r8 = r9
            goto L_0x00db
        L_0x00cd:
            r7 = move-exception
            r8 = r1
            r9 = r8
            r1 = r6
            goto L_0x00d9
        L_0x00d2:
            r0 = move-exception
            r9 = r1
            goto L_0x013d
        L_0x00d6:
            r7 = move-exception
            r8 = r1
            r9 = r8
        L_0x00d9:
            r6 = r7
            r7 = r9
        L_0x00db:
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r10.<init>(r2)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r1 = r13.f2088a     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            if (r1 != 0) goto L_0x00f3
            java.io.FileDescriptor r1 = r13.f2089b     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            int r11 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            androidx.exifinterface.media.b.a.c(r1, r4, r11)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            java.io.FileDescriptor r4 = r13.f2089b     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            r1.<init>(r4)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            goto L_0x00fa
        L_0x00f3:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            java.lang.String r4 = r13.f2088a     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            r1.<init>(r4)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
        L_0x00fa:
            r7 = r1
            androidx.exifinterface.media.b.e(r10, r7)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            androidx.exifinterface.media.b.c(r10)     // Catch:{ all -> 0x013b }
            androidx.exifinterface.media.b.c(r7)     // Catch:{ all -> 0x013b }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x013b }
            java.lang.String r1 = "Failed to save new file"
            r0.<init>(r1, r6)     // Catch:{ all -> 0x013b }
            throw r0     // Catch:{ all -> 0x013b }
        L_0x010c:
            r0 = move-exception
            goto L_0x0133
        L_0x010e:
            r1 = move-exception
            goto L_0x0115
        L_0x0110:
            r0 = move-exception
            goto L_0x0134
        L_0x0112:
            r3 = move-exception
            r10 = r1
            r1 = r3
        L_0x0115:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r4.<init>()     // Catch:{ all -> 0x0130 }
            java.lang.String r5 = "Failed to save new file. Original file is stored in "
            r4.append(r5)     // Catch:{ all -> 0x0130 }
            java.lang.String r5 = r2.getAbsolutePath()     // Catch:{ all -> 0x0130 }
            r4.append(r5)     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0130 }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x0130 }
            throw r3     // Catch:{ all -> 0x0130 }
        L_0x0130:
            r1 = move-exception
            r3 = r0
            r0 = r1
        L_0x0133:
            r1 = r10
        L_0x0134:
            androidx.exifinterface.media.b.c(r1)     // Catch:{ all -> 0x013b }
            androidx.exifinterface.media.b.c(r7)     // Catch:{ all -> 0x013b }
            throw r0     // Catch:{ all -> 0x013b }
        L_0x013b:
            r0 = move-exception
        L_0x013c:
            r1 = r8
        L_0x013d:
            androidx.exifinterface.media.b.c(r1)
            androidx.exifinterface.media.b.c(r9)
            if (r3 != 0) goto L_0x0148
            r2.delete()
        L_0x0148:
            throw r0
        L_0x0149:
            r0 = move-exception
            goto L_0x014f
        L_0x014b:
            r0 = move-exception
            goto L_0x0153
        L_0x014d:
            r0 = move-exception
            r6 = r1
        L_0x014f:
            r1 = r3
            goto L_0x0163
        L_0x0151:
            r0 = move-exception
            r6 = r1
        L_0x0153:
            r1 = r3
            goto L_0x015a
        L_0x0155:
            r0 = move-exception
            r6 = r1
            goto L_0x0163
        L_0x0158:
            r0 = move-exception
            r6 = r1
        L_0x015a:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x0162 }
            java.lang.String r3 = "Failed to copy original file to temp file"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0162 }
            throw r2     // Catch:{ all -> 0x0162 }
        L_0x0162:
            r0 = move-exception
        L_0x0163:
            androidx.exifinterface.media.b.c(r1)
            androidx.exifinterface.media.b.c(r6)
            throw r0
        L_0x016a:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface only supports saving attributes for JPEG, PNG, and WebP formats."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.Q():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0326, code lost:
        r3.put(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x028f, code lost:
        r3.put(r1, r4);
        r15 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void U(java.lang.String r18, java.lang.String r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            if (r1 == 0) goto L_0x0333
            java.lang.String r3 = "DateTime"
            boolean r3 = r3.equals(r1)
            java.lang.String r4 = " : "
            java.lang.String r5 = "Invalid value for "
            java.lang.String r6 = "ExifInterface"
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "DateTimeOriginal"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "DateTimeDigitized"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x006d
        L_0x0026:
            if (r2 == 0) goto L_0x006d
            java.util.regex.Pattern r3 = f2081u0
            java.util.regex.Matcher r3 = r3.matcher(r2)
            boolean r3 = r3.find()
            java.util.regex.Pattern r7 = f2083v0
            java.util.regex.Matcher r7 = r7.matcher(r2)
            boolean r7 = r7.find()
            int r8 = r19.length()
            r9 = 19
            if (r8 != r9) goto L_0x0054
            if (r3 != 0) goto L_0x0049
            if (r7 != 0) goto L_0x0049
            goto L_0x0054
        L_0x0049:
            if (r7 == 0) goto L_0x006d
            java.lang.String r3 = "-"
            java.lang.String r7 = ":"
            java.lang.String r2 = r2.replaceAll(r3, r7)
            goto L_0x006d
        L_0x0054:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x0059:
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r6, r1)
            return
        L_0x006d:
            java.lang.String r3 = "ISOSpeedRatings"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            boolean r1 = f2082v
            if (r1 == 0) goto L_0x007e
            java.lang.String r1 = "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY."
            android.util.Log.d(r6, r1)
        L_0x007e:
            java.lang.String r1 = "PhotographicSensitivity"
        L_0x0080:
            r3 = 2
            r7 = 1
            if (r2 == 0) goto L_0x00f4
            java.util.HashSet<java.lang.String> r8 = f2074n0
            boolean r8 = r8.contains(r1)
            if (r8 == 0) goto L_0x00f4
            java.lang.String r8 = "GPSTimeStamp"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x00df
            java.util.regex.Pattern r8 = f2080t0
            java.util.regex.Matcher r8 = r8.matcher(r2)
            boolean r9 = r8.find()
            if (r9 != 0) goto L_0x00a6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x0059
        L_0x00a6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r8.group(r7)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1,"
            r2.append(r4)
            java.lang.String r5 = r8.group(r3)
            int r5 = java.lang.Integer.parseInt(r5)
            r2.append(r5)
            r2.append(r4)
            r4 = 3
            java.lang.String r4 = r8.group(r4)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            goto L_0x00f4
        L_0x00df:
            double r8 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x00ed }
            androidx.exifinterface.media.a$f r10 = new androidx.exifinterface.media.a$f     // Catch:{ NumberFormatException -> 0x00ed }
            r10.<init>(r8)     // Catch:{ NumberFormatException -> 0x00ed }
            java.lang.String r2 = r10.toString()     // Catch:{ NumberFormatException -> 0x00ed }
            goto L_0x00f4
        L_0x00ed:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x0059
        L_0x00f4:
            r4 = 0
            r5 = r4
        L_0x00f6:
            androidx.exifinterface.media.a$e[][] r8 = f2070j0
            int r8 = r8.length
            if (r5 >= r8) goto L_0x0332
            r8 = 4
            if (r5 != r8) goto L_0x0104
            boolean r8 = r0.f2096i
            if (r8 != 0) goto L_0x0104
            goto L_0x032a
        L_0x0104:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$e>[] r8 = f2073m0
            r8 = r8[r5]
            java.lang.Object r8 = r8.get(r1)
            androidx.exifinterface.media.a$e r8 = (androidx.exifinterface.media.a.e) r8
            if (r8 == 0) goto L_0x032a
            if (r2 != 0) goto L_0x011b
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r8 = r0.f2093f
            r8 = r8[r5]
            r8.remove(r1)
            goto L_0x032a
        L_0x011b:
            android.util.Pair r9 = r(r2)
            int r10 = r8.f2126c
            java.lang.Object r11 = r9.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r12 = -1
            if (r10 == r11) goto L_0x01eb
            int r10 = r8.f2126c
            java.lang.Object r11 = r9.second
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 != r11) goto L_0x013a
            goto L_0x01eb
        L_0x013a:
            int r10 = r8.f2127d
            if (r10 == r12) goto L_0x0158
            java.lang.Object r11 = r9.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 == r11) goto L_0x0154
            int r10 = r8.f2127d
            java.lang.Object r11 = r9.second
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 != r11) goto L_0x0158
        L_0x0154:
            int r8 = r8.f2127d
            goto L_0x01ed
        L_0x0158:
            int r10 = r8.f2126c
            if (r10 == r7) goto L_0x01e9
            r11 = 7
            if (r10 == r11) goto L_0x01e9
            if (r10 != r3) goto L_0x0163
            goto L_0x01e9
        L_0x0163:
            boolean r10 = f2082v
            if (r10 == 0) goto L_0x032a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Given tag ("
            r10.append(r11)
            r10.append(r1)
            java.lang.String r11 = ") value didn't match with one of expected formats: "
            r10.append(r11)
            java.lang.String[] r11 = W
            int r13 = r8.f2126c
            r13 = r11[r13]
            r10.append(r13)
            int r13 = r8.f2127d
            java.lang.String r14 = ""
            java.lang.String r15 = ", "
            if (r13 != r12) goto L_0x018c
            r8 = r14
            goto L_0x019f
        L_0x018c:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r15)
            int r8 = r8.f2127d
            r8 = r11[r8]
            r13.append(r8)
            java.lang.String r8 = r13.toString()
        L_0x019f:
            r10.append(r8)
            java.lang.String r8 = " (guess: "
            r10.append(r8)
            java.lang.Object r8 = r9.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r8 = r11[r8]
            r10.append(r8)
            java.lang.Object r8 = r9.second
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r8 != r12) goto L_0x01bf
            goto L_0x01d8
        L_0x01bf:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r15)
            java.lang.Object r9 = r9.second
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r9 = r11[r9]
            r8.append(r9)
            java.lang.String r14 = r8.toString()
        L_0x01d8:
            r10.append(r14)
            java.lang.String r8 = ")"
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            android.util.Log.d(r6, r8)
            goto L_0x032a
        L_0x01e9:
            r8 = r10
            goto L_0x01ed
        L_0x01eb:
            int r8 = r8.f2126c
        L_0x01ed:
            java.lang.String r9 = "/"
            java.lang.String r10 = ","
            switch(r8) {
                case 1: goto L_0x031d;
                case 2: goto L_0x0313;
                case 3: goto L_0x02f0;
                case 4: goto L_0x02cd;
                case 5: goto L_0x0295;
                case 6: goto L_0x01f4;
                case 7: goto L_0x0313;
                case 8: goto L_0x01f4;
                case 9: goto L_0x026f;
                case 10: goto L_0x0234;
                case 11: goto L_0x01f4;
                case 12: goto L_0x020f;
                default: goto L_0x01f4;
            }
        L_0x01f4:
            r15 = r7
            boolean r3 = f2082v
            if (r3 == 0) goto L_0x032b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Data format isn't one of expected formats: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r6, r3)
            goto L_0x032b
        L_0x020f:
            java.lang.String[] r8 = r2.split(r10, r12)
            int r9 = r8.length
            double[] r9 = new double[r9]
            r10 = r4
        L_0x0217:
            int r11 = r8.length
            if (r10 >= r11) goto L_0x0225
            r11 = r8[r10]
            double r11 = java.lang.Double.parseDouble(r11)
            r9[r10] = r11
            int r10 = r10 + 1
            goto L_0x0217
        L_0x0225:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r8 = r0.f2093f
            r8 = r8[r5]
            java.nio.ByteOrder r10 = r0.f2095h
            androidx.exifinterface.media.a$d r9 = androidx.exifinterface.media.a.d.b(r9, r10)
            r8.put(r1, r9)
            goto L_0x032a
        L_0x0234:
            java.lang.String[] r8 = r2.split(r10, r12)
            int r10 = r8.length
            androidx.exifinterface.media.a$f[] r10 = new androidx.exifinterface.media.a.f[r10]
            r11 = r4
        L_0x023c:
            int r13 = r8.length
            if (r11 >= r13) goto L_0x0264
            r13 = r8[r11]
            java.lang.String[] r13 = r13.split(r9, r12)
            androidx.exifinterface.media.a$f r14 = new androidx.exifinterface.media.a$f
            r15 = r13[r4]
            double r3 = java.lang.Double.parseDouble(r15)
            long r3 = (long) r3
            r13 = r13[r7]
            r16 = r8
            double r7 = java.lang.Double.parseDouble(r13)
            long r7 = (long) r7
            r14.<init>(r3, r7)
            r10[r11] = r14
            int r11 = r11 + 1
            r8 = r16
            r3 = 2
            r4 = 0
            r7 = 1
            goto L_0x023c
        L_0x0264:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f2093f
            r3 = r3[r5]
            java.nio.ByteOrder r4 = r0.f2095h
            androidx.exifinterface.media.a$d r4 = androidx.exifinterface.media.a.d.d(r10, r4)
            goto L_0x028f
        L_0x026f:
            java.lang.String[] r3 = r2.split(r10, r12)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r7 = 0
        L_0x0277:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x0285
            r8 = r3[r7]
            int r8 = java.lang.Integer.parseInt(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x0277
        L_0x0285:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f2093f
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.f2095h
            androidx.exifinterface.media.a$d r4 = androidx.exifinterface.media.a.d.c(r4, r7)
        L_0x028f:
            r3.put(r1, r4)
            r15 = 1
            goto L_0x032b
        L_0x0295:
            java.lang.String[] r3 = r2.split(r10, r12)
            int r4 = r3.length
            androidx.exifinterface.media.a$f[] r4 = new androidx.exifinterface.media.a.f[r4]
            r7 = 0
        L_0x029d:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x02c1
            r8 = r3[r7]
            java.lang.String[] r8 = r8.split(r9, r12)
            androidx.exifinterface.media.a$f r10 = new androidx.exifinterface.media.a$f
            r11 = 0
            r13 = r8[r11]
            double r13 = java.lang.Double.parseDouble(r13)
            long r13 = (long) r13
            r15 = 1
            r8 = r8[r15]
            double r11 = java.lang.Double.parseDouble(r8)
            long r11 = (long) r11
            r10.<init>(r13, r11)
            r4[r7] = r10
            int r7 = r7 + 1
            r12 = -1
            goto L_0x029d
        L_0x02c1:
            r15 = 1
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f2093f
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.f2095h
            androidx.exifinterface.media.a$d r4 = androidx.exifinterface.media.a.d.i(r4, r7)
            goto L_0x0326
        L_0x02cd:
            r15 = r7
            r3 = r12
            java.lang.String[] r3 = r2.split(r10, r3)
            int r4 = r3.length
            long[] r4 = new long[r4]
            r7 = 0
        L_0x02d7:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x02e5
            r8 = r3[r7]
            long r8 = java.lang.Long.parseLong(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x02d7
        L_0x02e5:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f2093f
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.f2095h
            androidx.exifinterface.media.a$d r4 = androidx.exifinterface.media.a.d.g(r4, r7)
            goto L_0x0326
        L_0x02f0:
            r15 = r7
            r3 = r12
            java.lang.String[] r3 = r2.split(r10, r3)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r7 = 0
        L_0x02fa:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x0308
            r8 = r3[r7]
            int r8 = java.lang.Integer.parseInt(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x02fa
        L_0x0308:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f2093f
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.f2095h
            androidx.exifinterface.media.a$d r4 = androidx.exifinterface.media.a.d.k(r4, r7)
            goto L_0x0326
        L_0x0313:
            r15 = r7
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f2093f
            r3 = r3[r5]
            androidx.exifinterface.media.a$d r4 = androidx.exifinterface.media.a.d.e(r2)
            goto L_0x0326
        L_0x031d:
            r15 = r7
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f2093f
            r3 = r3[r5]
            androidx.exifinterface.media.a$d r4 = androidx.exifinterface.media.a.d.a(r2)
        L_0x0326:
            r3.put(r1, r4)
            goto L_0x032b
        L_0x032a:
            r15 = r7
        L_0x032b:
            int r5 = r5 + 1
            r7 = r15
            r3 = 2
            r4 = 0
            goto L_0x00f6
        L_0x0332:
            return
        L_0x0333:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "tag shouldn't be null"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.U(java.lang.String, java.lang.String):void");
    }

    public String d(String str) {
        String str2;
        if (str != null) {
            d e5 = e(str);
            if (e5 != null) {
                if (!f2074n0.contains(str)) {
                    return e5.n(this.f2095h);
                }
                if (str.equals("GPSTimeStamp")) {
                    int i5 = e5.f2120a;
                    if (i5 == 5 || i5 == 10) {
                        f[] fVarArr = (f[]) e5.o(this.f2095h);
                        if (fVarArr == null || fVarArr.length != 3) {
                            str2 = "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr);
                        } else {
                            f fVar = fVarArr[0];
                            f fVar2 = fVarArr[1];
                            f fVar3 = fVarArr[2];
                            return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) fVar.f2128a) / ((float) fVar.f2129b))), Integer.valueOf((int) (((float) fVar2.f2128a) / ((float) fVar2.f2129b))), Integer.valueOf((int) (((float) fVar3.f2128a) / ((float) fVar3.f2129b)))});
                        }
                    } else {
                        str2 = "GPS Timestamp format is not rational. format=" + e5.f2120a;
                    }
                    Log.w("ExifInterface", str2);
                    return null;
                }
                try {
                    return Double.toString(e5.l(this.f2095h));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public byte[] o() {
        int i5 = this.f2102o;
        if (i5 == 6 || i5 == 7) {
            return p();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065 A[SYNTHETIC, Splitter:B:34:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082 A[Catch:{ Exception -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] p() {
        /*
            r9 = this;
            java.lang.String r0 = "ExifInterface"
            boolean r1 = r9.f2096i
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            byte[] r1 = r9.f2101n
            if (r1 == 0) goto L_0x000d
            return r1
        L_0x000d:
            android.content.res.AssetManager$AssetInputStream r1 = r9.f2090c     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            if (r1 == 0) goto L_0x002e
            boolean r3 = r1.markSupported()     // Catch:{ Exception -> 0x0029, all -> 0x0025 }
            if (r3 == 0) goto L_0x001c
            r1.reset()     // Catch:{ Exception -> 0x0029, all -> 0x0025 }
        L_0x001a:
            r3 = r2
            goto L_0x004f
        L_0x001c:
            java.lang.String r3 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r0, r3)     // Catch:{ Exception -> 0x0029, all -> 0x0025 }
            androidx.exifinterface.media.b.c(r1)
            return r2
        L_0x0025:
            r0 = move-exception
            r3 = r2
            goto L_0x00a8
        L_0x0029:
            r3 = move-exception
            r4 = r3
            r3 = r2
            goto L_0x0099
        L_0x002e:
            java.lang.String r1 = r9.f2088a     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            if (r1 == 0) goto L_0x003a
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r3 = r9.f2088a     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            goto L_0x001a
        L_0x003a:
            java.io.FileDescriptor r1 = r9.f2089b     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.io.FileDescriptor r1 = androidx.exifinterface.media.b.a.b(r1)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r3 = 0
            int r5 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            androidx.exifinterface.media.b.a.c(r1, r3, r5)     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            r3.<init>(r1)     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            r8 = r3
            r3 = r1
            r1 = r8
        L_0x004f:
            int r4 = r9.f2099l     // Catch:{ Exception -> 0x0088 }
            int r5 = r9.f2103p     // Catch:{ Exception -> 0x0088 }
            int r4 = r4 + r5
            long r4 = (long) r4     // Catch:{ Exception -> 0x0088 }
            long r4 = r1.skip(r4)     // Catch:{ Exception -> 0x0088 }
            int r6 = r9.f2099l     // Catch:{ Exception -> 0x0088 }
            int r7 = r9.f2103p     // Catch:{ Exception -> 0x0088 }
            int r6 = r6 + r7
            long r6 = (long) r6
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            java.lang.String r5 = "Corrupted image"
            if (r4 != 0) goto L_0x0082
            int r4 = r9.f2100m     // Catch:{ Exception -> 0x0088 }
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0088 }
            int r6 = r1.read(r4)     // Catch:{ Exception -> 0x0088 }
            int r7 = r9.f2100m     // Catch:{ Exception -> 0x0088 }
            if (r6 != r7) goto L_0x007c
            r9.f2101n = r4     // Catch:{ Exception -> 0x0088 }
            androidx.exifinterface.media.b.c(r1)
            if (r3 == 0) goto L_0x007b
            androidx.exifinterface.media.b.b(r3)
        L_0x007b:
            return r4
        L_0x007c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ Exception -> 0x0088 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0088 }
            throw r4     // Catch:{ Exception -> 0x0088 }
        L_0x0082:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ Exception -> 0x0088 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0088 }
            throw r4     // Catch:{ Exception -> 0x0088 }
        L_0x0088:
            r4 = move-exception
            goto L_0x0099
        L_0x008a:
            r0 = move-exception
            r3 = r1
            goto L_0x00a9
        L_0x008d:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r2
            goto L_0x0099
        L_0x0092:
            r0 = move-exception
            r3 = r2
            goto L_0x00a9
        L_0x0095:
            r3 = move-exception
            r1 = r2
            r4 = r3
            r3 = r1
        L_0x0099:
            java.lang.String r5 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r0, r5, r4)     // Catch:{ all -> 0x00a7 }
            androidx.exifinterface.media.b.c(r1)
            if (r3 == 0) goto L_0x00a6
            androidx.exifinterface.media.b.b(r3)
        L_0x00a6:
            return r2
        L_0x00a7:
            r0 = move-exception
        L_0x00a8:
            r2 = r1
        L_0x00a9:
            androidx.exifinterface.media.b.c(r2)
            if (r3 == 0) goto L_0x00b1
            androidx.exifinterface.media.b.b(r3)
        L_0x00b1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.p():byte[]");
    }
}
