package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.a.C0063a;
import com.google.protobuf.i;
import com.google.protobuf.s0;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0063a<MessageType, BuilderType>> implements s0 {
    protected int memoizedHashCode = 0;

    /* renamed from: com.google.protobuf.a$a  reason: collision with other inner class name */
    public static abstract class C0063a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0063a<MessageType, BuilderType>> implements s0.a {

        /* renamed from: com.google.protobuf.a$a$a  reason: collision with other inner class name */
        static final class C0064a extends FilterInputStream {

            /* renamed from: e  reason: collision with root package name */
            private int f3463e;

            C0064a(InputStream inputStream, int i5) {
                super(inputStream);
                this.f3463e = i5;
            }

            public int available() {
                return Math.min(super.available(), this.f3463e);
            }

            public int read() {
                if (this.f3463e <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f3463e--;
                }
                return read;
            }

            public int read(byte[] bArr, int i5, int i6) {
                int i7 = this.f3463e;
                if (i7 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i5, Math.min(i6, i7));
                if (read >= 0) {
                    this.f3463e -= read;
                }
                return read;
            }

            public long skip(long j5) {
                long skip = super.skip(Math.min(j5, (long) this.f3463e));
                if (skip >= 0) {
                    this.f3463e = (int) (((long) this.f3463e) - skip);
                }
                return skip;
            }
        }

        @Deprecated
        protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            addAll(iterable, (List) collection);
        }

        protected static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            b0.a(iterable);
            if (iterable instanceof h0) {
                List<?> j5 = ((h0) iterable).j();
                h0 h0Var = (h0) list;
                int size = list.size();
                for (Object next : j5) {
                    if (next == null) {
                        String str = "Element at index " + (h0Var.size() - size) + " is null.";
                        for (int size2 = h0Var.size() - 1; size2 >= size; size2--) {
                            h0Var.remove(size2);
                        }
                        throw new NullPointerException(str);
                    } else if (next instanceof i) {
                        h0Var.d((i) next);
                    } else {
                        h0Var.add((String) next);
                    }
                }
            } else if (iterable instanceof c1) {
                list.addAll((Collection) iterable);
            } else {
                addAllCheckingNulls(iterable, list);
            }
        }

        private static <T> void addAllCheckingNulls(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T next : iterable) {
                if (next == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(next);
            }
        }

        private String getReadingExceptionMessage(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        protected static o1 newUninitializedMessageException(s0 s0Var) {
            return new o1(s0Var);
        }

        public abstract BuilderType clone();

        /* access modifiers changed from: protected */
        public abstract BuilderType internalMergeFrom(MessageType messagetype);

        public boolean mergeDelimitedFrom(InputStream inputStream) {
            return mergeDelimitedFrom(inputStream, q.b());
        }

        public boolean mergeDelimitedFrom(InputStream inputStream, q qVar) {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new C0064a(inputStream, j.x(read, inputStream)), qVar);
            return true;
        }

        public BuilderType mergeFrom(i iVar) {
            try {
                j u5 = iVar.u();
                mergeFrom(u5);
                u5.a(0);
                return this;
            } catch (c0 e5) {
                throw e5;
            } catch (IOException e6) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e6);
            }
        }

        public BuilderType mergeFrom(i iVar, q qVar) {
            try {
                j u5 = iVar.u();
                mergeFrom(u5, qVar);
                u5.a(0);
                return this;
            } catch (c0 e5) {
                throw e5;
            } catch (IOException e6) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e6);
            }
        }

        public BuilderType mergeFrom(j jVar) {
            return mergeFrom(jVar, q.b());
        }

        public abstract BuilderType mergeFrom(j jVar, q qVar);

        public BuilderType mergeFrom(s0 s0Var) {
            if (getDefaultInstanceForType().getClass().isInstance(s0Var)) {
                return internalMergeFrom((a) s0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        public BuilderType mergeFrom(InputStream inputStream) {
            j f5 = j.f(inputStream);
            mergeFrom(f5);
            f5.a(0);
            return this;
        }

        public BuilderType mergeFrom(InputStream inputStream, q qVar) {
            j f5 = j.f(inputStream);
            mergeFrom(f5, qVar);
            f5.a(0);
            return this;
        }

        public BuilderType mergeFrom(byte[] bArr) {
            return mergeFrom(bArr, 0, bArr.length);
        }

        public BuilderType mergeFrom(byte[] bArr, int i5, int i6) {
            try {
                j k5 = j.k(bArr, i5, i6);
                mergeFrom(k5);
                k5.a(0);
                return this;
            } catch (c0 e5) {
                throw e5;
            } catch (IOException e6) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e6);
            }
        }

        public BuilderType mergeFrom(byte[] bArr, int i5, int i6, q qVar) {
            try {
                j k5 = j.k(bArr, i5, i6);
                mergeFrom(k5, qVar);
                k5.a(0);
                return this;
            } catch (c0 e5) {
                throw e5;
            } catch (IOException e6) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e6);
            }
        }

        public BuilderType mergeFrom(byte[] bArr, q qVar) {
            return mergeFrom(bArr, 0, bArr.length, qVar);
        }
    }

    @Deprecated
    protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        C0063a.addAll(iterable, (List) collection);
    }

    protected static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        C0063a.addAll(iterable, list);
    }

    protected static void checkByteStringIsUtf8(i iVar) {
        if (!iVar.r()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    /* access modifiers changed from: package-private */
    public int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int getSerializedSize(i1 i1Var) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int h5 = i1Var.h(this);
        setMemoizedSerializedSize(h5);
        return h5;
    }

    /* access modifiers changed from: package-private */
    public o1 newUninitializedMessageException() {
        return new o1(this);
    }

    /* access modifiers changed from: package-private */
    public void setMemoizedSerializedSize(int i5) {
        throw new UnsupportedOperationException();
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            l h02 = l.h0(bArr);
            writeTo(h02);
            h02.d();
            return bArr;
        } catch (IOException e5) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e5);
        }
    }

    public i toByteString() {
        try {
            i.h t5 = i.t(getSerializedSize());
            writeTo(t5.b());
            return t5.a();
        } catch (IOException e5) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e5);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) {
        int serializedSize = getSerializedSize();
        l g02 = l.g0(outputStream, l.J(l.L(serializedSize) + serializedSize));
        g02.H0(serializedSize);
        writeTo(g02);
        g02.d0();
    }

    public void writeTo(OutputStream outputStream) {
        l g02 = l.g0(outputStream, l.J(getSerializedSize()));
        writeTo(g02);
        g02.d0();
    }
}
