package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.b0;
import com.google.protobuf.e;
import com.google.protobuf.s0;
import com.google.protobuf.v;
import com.google.protobuf.v1;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class z<MessageType extends z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a<MessageType, BuilderType> {
    private static Map<Object, z<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected int memoizedSerializedSize = -1;
    protected q1 unknownFields = q1.c();

    public static abstract class a<MessageType extends z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.C0063a<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;
        protected boolean isBuilt = false;

        protected a(MessageType messagetype) {
            this.defaultInstance = messagetype;
            this.instance = (z) messagetype.dynamicMethod(f.NEW_MUTABLE_INSTANCE);
        }

        private void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
            e1.a().e(messagetype).a(messagetype, messagetype2);
        }

        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.C0063a.newUninitializedMessageException(buildPartial);
        }

        public MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        }

        public final BuilderType clear() {
            this.instance = (z) this.instance.dynamicMethod(f.NEW_MUTABLE_INSTANCE);
            return this;
        }

        public BuilderType clone() {
            BuilderType newBuilderForType = getDefaultInstanceForType().newBuilderForType();
            newBuilderForType.mergeFrom(buildPartial());
            return newBuilderForType;
        }

        /* access modifiers changed from: protected */
        public final void copyOnWrite() {
            if (this.isBuilt) {
                copyOnWriteInternal();
                this.isBuilt = false;
            }
        }

        /* access modifiers changed from: protected */
        public void copyOnWriteInternal() {
            MessageType messagetype = (z) this.instance.dynamicMethod(f.NEW_MUTABLE_INSTANCE);
            mergeFromInstance(messagetype, this.instance);
            this.instance = messagetype;
        }

        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        /* access modifiers changed from: protected */
        public BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom(messagetype);
        }

        public final boolean isInitialized() {
            return z.isInitialized(this.instance, false);
        }

        public BuilderType mergeFrom(j jVar, q qVar) {
            copyOnWrite();
            try {
                e1.a().e(this.instance).e(this.instance, k.Q(jVar), qVar);
                return this;
            } catch (RuntimeException e5) {
                if (e5.getCause() instanceof IOException) {
                    throw ((IOException) e5.getCause());
                }
                throw e5;
            }
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            mergeFromInstance(this.instance, messagetype);
            return this;
        }

        public BuilderType mergeFrom(byte[] bArr, int i5, int i6) {
            return mergeFrom(bArr, i5, i6, q.b());
        }

        public BuilderType mergeFrom(byte[] bArr, int i5, int i6, q qVar) {
            copyOnWrite();
            try {
                e1.a().e(this.instance).g(this.instance, bArr, i5, i5 + i6, new e.b(qVar));
                return this;
            } catch (c0 e5) {
                throw e5;
            } catch (IndexOutOfBoundsException unused) {
                throw c0.m();
            } catch (IOException e6) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e6);
            }
        }
    }

    protected static class b<T extends z<T, ?>> extends b<T> {

        /* renamed from: b  reason: collision with root package name */
        private final T f3806b;

        public b(T t5) {
            this.f3806b = t5;
        }

        /* renamed from: g */
        public T b(j jVar, q qVar) {
            return z.parsePartialFrom(this.f3806b, jVar, qVar);
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends z<MessageType, BuilderType> implements t0 {

        /* renamed from: e  reason: collision with root package name */
        protected v<d> f3807e = v.h();

        /* access modifiers changed from: package-private */
        public v<d> a() {
            if (this.f3807e.n()) {
                this.f3807e = this.f3807e.clone();
            }
            return this.f3807e;
        }

        public /* bridge */ /* synthetic */ s0 getDefaultInstanceForType() {
            return z.super.getDefaultInstanceForType();
        }

        public /* bridge */ /* synthetic */ s0.a newBuilderForType() {
            return z.super.newBuilderForType();
        }

        public /* bridge */ /* synthetic */ s0.a toBuilder() {
            return z.super.toBuilder();
        }
    }

    static final class d implements v.b<d> {

        /* renamed from: e  reason: collision with root package name */
        final b0.d<?> f3808e;

        /* renamed from: f  reason: collision with root package name */
        final int f3809f;

        /* renamed from: g  reason: collision with root package name */
        final v1.b f3810g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f3811h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f3812i;

        d(b0.d<?> dVar, int i5, v1.b bVar, boolean z4, boolean z5) {
            this.f3808e = dVar;
            this.f3809f = i5;
            this.f3810g = bVar;
            this.f3811h = z4;
            this.f3812i = z5;
        }

        public int a() {
            return this.f3809f;
        }

        public boolean b() {
            return this.f3811h;
        }

        /* renamed from: c */
        public int compareTo(d dVar) {
            return this.f3809f - dVar.f3809f;
        }

        public v1.b d() {
            return this.f3810g;
        }

        public b0.d<?> f() {
            return this.f3808e;
        }

        public s0.a g(s0.a aVar, s0 s0Var) {
            return ((a) aVar).mergeFrom((z) s0Var);
        }

        public v1.c j() {
            return this.f3810g.c();
        }

        public boolean k() {
            return this.f3812i;
        }
    }

    public static class e<ContainingType extends s0, Type> extends o<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        final ContainingType f3813a;

        /* renamed from: b  reason: collision with root package name */
        final Type f3814b;

        /* renamed from: c  reason: collision with root package name */
        final s0 f3815c;

        /* renamed from: d  reason: collision with root package name */
        final d f3816d;

        e(ContainingType containingtype, Type type, s0 s0Var, d dVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (dVar.d() == v1.b.MESSAGE && s0Var == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.f3813a = containingtype;
                this.f3814b = type;
                this.f3815c = s0Var;
                this.f3816d = dVar;
            }
        }

        public v1.b b() {
            return this.f3816d.d();
        }

        public s0 c() {
            return this.f3815c;
        }

        public int d() {
            return this.f3816d.a();
        }

        public boolean e() {
            return this.f3816d.f3811h;
        }
    }

    public enum f {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* access modifiers changed from: private */
    public static <MessageType extends c<MessageType, BuilderType>, BuilderType, T> e<MessageType, T> checkIsLite(o<MessageType, T> oVar) {
        if (oVar.a()) {
            return (e) oVar;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends z<T, ?>> T checkMessageInitialized(T t5) {
        if (t5 == null || t5.isInitialized()) {
            return t5;
        }
        throw t5.newUninitializedMessageException().a().k(t5);
    }

    protected static b0.a emptyBooleanList() {
        return g.m();
    }

    protected static b0.b emptyDoubleList() {
        return n.m();
    }

    protected static b0.f emptyFloatList() {
        return x.m();
    }

    protected static b0.g emptyIntList() {
        return a0.m();
    }

    protected static b0.h emptyLongList() {
        return j0.m();
    }

    protected static <E> b0.i<E> emptyProtobufList() {
        return f1.f();
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == q1.c()) {
            this.unknownFields = q1.n();
        }
    }

    static <T extends z<?, ?>> T getDefaultInstance(Class<T> cls) {
        T t5 = (z) defaultInstanceMap.get(cls);
        if (t5 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t5 = (z) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException("Class initialization cannot fail.", e5);
            }
        }
        if (t5 == null) {
            t5 = ((z) t1.l(cls)).getDefaultInstanceForType();
            if (t5 != null) {
                defaultInstanceMap.put(cls, t5);
            } else {
                throw new IllegalStateException();
            }
        }
        return t5;
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e5);
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e5);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends z<T, ?>> boolean isInitialized(T t5, boolean z4) {
        byte byteValue = ((Byte) t5.dynamicMethod(f.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d5 = e1.a().e(t5).d(t5);
        if (z4) {
            t5.dynamicMethod(f.SET_MEMOIZED_IS_INITIALIZED, d5 ? t5 : null);
        }
        return d5;
    }

    protected static b0.a mutableCopy(b0.a aVar) {
        int size = aVar.size();
        return aVar.a(size == 0 ? 10 : size * 2);
    }

    protected static b0.b mutableCopy(b0.b bVar) {
        int size = bVar.size();
        return bVar.a(size == 0 ? 10 : size * 2);
    }

    protected static b0.f mutableCopy(b0.f fVar) {
        int size = fVar.size();
        return fVar.a(size == 0 ? 10 : size * 2);
    }

    protected static b0.g mutableCopy(b0.g gVar) {
        int size = gVar.size();
        return gVar.a(size == 0 ? 10 : size * 2);
    }

    protected static b0.h mutableCopy(b0.h hVar) {
        int size = hVar.size();
        return hVar.a(size == 0 ? 10 : size * 2);
    }

    protected static <E> b0.i<E> mutableCopy(b0.i<E> iVar) {
        int size = iVar.size();
        return iVar.a(size == 0 ? 10 : size * 2);
    }

    protected static Object newMessageInfo(s0 s0Var, String str, Object[] objArr) {
        return new g1(s0Var, str, objArr);
    }

    public static <ContainingType extends s0, Type> e<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, s0 s0Var, b0.d<?> dVar, int i5, v1.b bVar, boolean z4, Class cls) {
        return new e(containingtype, Collections.emptyList(), s0Var, new d(dVar, i5, bVar, true, z4), cls);
    }

    public static <ContainingType extends s0, Type> e<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, s0 s0Var, b0.d<?> dVar, int i5, v1.b bVar, Class cls) {
        return new e(containingtype, type, s0Var, new d(dVar, i5, bVar, false, false), cls);
    }

    protected static <T extends z<T, ?>> T parseDelimitedFrom(T t5, InputStream inputStream) {
        return checkMessageInitialized(parsePartialDelimitedFrom(t5, inputStream, q.b()));
    }

    protected static <T extends z<T, ?>> T parseDelimitedFrom(T t5, InputStream inputStream, q qVar) {
        return checkMessageInitialized(parsePartialDelimitedFrom(t5, inputStream, qVar));
    }

    protected static <T extends z<T, ?>> T parseFrom(T t5, i iVar) {
        return checkMessageInitialized(parseFrom(t5, iVar, q.b()));
    }

    protected static <T extends z<T, ?>> T parseFrom(T t5, i iVar, q qVar) {
        return checkMessageInitialized(parsePartialFrom(t5, iVar, qVar));
    }

    protected static <T extends z<T, ?>> T parseFrom(T t5, j jVar) {
        return parseFrom(t5, jVar, q.b());
    }

    protected static <T extends z<T, ?>> T parseFrom(T t5, j jVar, q qVar) {
        return checkMessageInitialized(parsePartialFrom(t5, jVar, qVar));
    }

    protected static <T extends z<T, ?>> T parseFrom(T t5, InputStream inputStream) {
        return checkMessageInitialized(parsePartialFrom(t5, j.f(inputStream), q.b()));
    }

    protected static <T extends z<T, ?>> T parseFrom(T t5, InputStream inputStream, q qVar) {
        return checkMessageInitialized(parsePartialFrom(t5, j.f(inputStream), qVar));
    }

    protected static <T extends z<T, ?>> T parseFrom(T t5, ByteBuffer byteBuffer) {
        return parseFrom(t5, byteBuffer, q.b());
    }

    protected static <T extends z<T, ?>> T parseFrom(T t5, ByteBuffer byteBuffer, q qVar) {
        return checkMessageInitialized(parseFrom(t5, j.h(byteBuffer), qVar));
    }

    protected static <T extends z<T, ?>> T parseFrom(T t5, byte[] bArr) {
        return checkMessageInitialized(parsePartialFrom(t5, bArr, 0, bArr.length, q.b()));
    }

    protected static <T extends z<T, ?>> T parseFrom(T t5, byte[] bArr, q qVar) {
        return checkMessageInitialized(parsePartialFrom(t5, bArr, 0, bArr.length, qVar));
    }

    private static <T extends z<T, ?>> T parsePartialDelimitedFrom(T t5, InputStream inputStream, q qVar) {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            j f5 = j.f(new a.C0063a.C0064a(inputStream, j.x(read, inputStream)));
            T parsePartialFrom = parsePartialFrom(t5, f5, qVar);
            try {
                f5.a(0);
                return parsePartialFrom;
            } catch (c0 e5) {
                throw e5.k(parsePartialFrom);
            }
        } catch (c0 e6) {
            e = e6;
            if (e.a()) {
                e = new c0((IOException) e);
            }
            throw e;
        } catch (IOException e7) {
            throw new c0(e7);
        }
    }

    private static <T extends z<T, ?>> T parsePartialFrom(T t5, i iVar, q qVar) {
        T parsePartialFrom;
        try {
            j u5 = iVar.u();
            parsePartialFrom = parsePartialFrom(t5, u5, qVar);
            u5.a(0);
            return parsePartialFrom;
        } catch (c0 e5) {
            throw e5.k(parsePartialFrom);
        } catch (c0 e6) {
            throw e6;
        }
    }

    protected static <T extends z<T, ?>> T parsePartialFrom(T t5, j jVar) {
        return parsePartialFrom(t5, jVar, q.b());
    }

    static <T extends z<T, ?>> T parsePartialFrom(T t5, j jVar, q qVar) {
        T t6 = (z) t5.dynamicMethod(f.NEW_MUTABLE_INSTANCE);
        try {
            i1 e5 = e1.a().e(t6);
            e5.e(t6, k.Q(jVar), qVar);
            e5.c(t6);
            return t6;
        } catch (c0 e6) {
            e = e6;
            if (e.a()) {
                e = new c0((IOException) e);
            }
            throw e.k(t6);
        } catch (IOException e7) {
            if (e7.getCause() instanceof c0) {
                throw ((c0) e7.getCause());
            }
            throw new c0(e7).k(t6);
        } catch (RuntimeException e8) {
            if (e8.getCause() instanceof c0) {
                throw ((c0) e8.getCause());
            }
            throw e8;
        }
    }

    static <T extends z<T, ?>> T parsePartialFrom(T t5, byte[] bArr, int i5, int i6, q qVar) {
        T t6 = (z) t5.dynamicMethod(f.NEW_MUTABLE_INSTANCE);
        try {
            i1 e5 = e1.a().e(t6);
            e5.g(t6, bArr, i5, i5 + i6, new e.b(qVar));
            e5.c(t6);
            if (t6.memoizedHashCode == 0) {
                return t6;
            }
            throw new RuntimeException();
        } catch (c0 e6) {
            e = e6;
            if (e.a()) {
                e = new c0((IOException) e);
            }
            throw e.k(t6);
        } catch (IOException e7) {
            if (e7.getCause() instanceof c0) {
                throw ((c0) e7.getCause());
            }
            throw new c0(e7).k(t6);
        } catch (IndexOutOfBoundsException unused) {
            throw c0.m().k(t6);
        }
    }

    private static <T extends z<T, ?>> T parsePartialFrom(T t5, byte[] bArr, q qVar) {
        return checkMessageInitialized(parsePartialFrom(t5, bArr, 0, bArr.length, qVar));
    }

    protected static <T extends z<?, ?>> void registerDefaultInstance(Class<T> cls, T t5) {
        defaultInstanceMap.put(cls, t5);
    }

    /* access modifiers changed from: package-private */
    public Object buildMessageInfo() {
        return dynamicMethod(f.BUILD_MESSAGE_INFO);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder() {
        return (a) dynamicMethod(f.NEW_BUILDER);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        return createBuilder().mergeFrom(messagetype);
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(f fVar) {
        return dynamicMethod(fVar, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(f fVar, Object obj) {
        return dynamicMethod(fVar, obj, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object dynamicMethod(f fVar, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return e1.a().e(this).f(this, (z) obj);
        }
        return false;
    }

    public final MessageType getDefaultInstanceForType() {
        return (z) dynamicMethod(f.GET_DEFAULT_INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    public final b1<MessageType> getParserForType() {
        return (b1) dynamicMethod(f.GET_PARSER);
    }

    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = e1.a().e(this).h(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i5 = this.memoizedHashCode;
        if (i5 != 0) {
            return i5;
        }
        int j5 = e1.a().e(this).j(this);
        this.memoizedHashCode = j5;
        return j5;
    }

    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    /* access modifiers changed from: protected */
    public void makeImmutable() {
        e1.a().e(this).c(this);
    }

    /* access modifiers changed from: protected */
    public void mergeLengthDelimitedField(int i5, i iVar) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.k(i5, iVar);
    }

    /* access modifiers changed from: protected */
    public final void mergeUnknownFields(q1 q1Var) {
        this.unknownFields = q1.m(this.unknownFields, q1Var);
    }

    /* access modifiers changed from: protected */
    public void mergeVarintField(int i5, int i6) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.l(i5, i6);
    }

    public final BuilderType newBuilderForType() {
        return (a) dynamicMethod(f.NEW_BUILDER);
    }

    /* access modifiers changed from: protected */
    public boolean parseUnknownField(int i5, j jVar) {
        if (v1.b(i5) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.i(i5, jVar);
    }

    /* access modifiers changed from: package-private */
    public void setMemoizedSerializedSize(int i5) {
        this.memoizedSerializedSize = i5;
    }

    public final BuilderType toBuilder() {
        BuilderType buildertype = (a) dynamicMethod(f.NEW_BUILDER);
        buildertype.mergeFrom(this);
        return buildertype;
    }

    public String toString() {
        return u0.e(this, super.toString());
    }

    public void writeTo(l lVar) {
        e1.a().e(this).b(this, m.P(lVar));
    }
}
