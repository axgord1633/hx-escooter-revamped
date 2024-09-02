package com.signify.hue.flutterreactiveble;

import com.google.protobuf.a;
import com.google.protobuf.b0;
import com.google.protobuf.b1;
import com.google.protobuf.i;
import com.google.protobuf.j;
import com.google.protobuf.q;
import com.google.protobuf.s0;
import com.google.protobuf.t0;
import com.google.protobuf.z;
import com.yalantis.ucrop.BuildConfig;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class ProtobufModel {

    /* renamed from: com.signify.hue.flutterreactiveble.ProtobufModel$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.z$f[] r0 = com.google.protobuf.z.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.protobuf.z$f r1 = com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.z$f r1 = com.google.protobuf.z.f.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.z$f r1 = com.google.protobuf.z.f.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.z$f r1 = com.google.protobuf.z.f.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.z$f r1 = com.google.protobuf.z.f.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.z$f r1 = com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.z$f r1 = com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.signify.hue.flutterreactiveble.ProtobufModel.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class BleStatusInfo extends z<BleStatusInfo, Builder> implements BleStatusInfoOrBuilder {
        /* access modifiers changed from: private */
        public static final BleStatusInfo DEFAULT_INSTANCE;
        private static volatile b1<BleStatusInfo> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 1;
        private int status_;

        public static final class Builder extends z.a<BleStatusInfo, Builder> implements BleStatusInfoOrBuilder {
            private Builder() {
                super(BleStatusInfo.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((BleStatusInfo) this.instance).clearStatus();
                return this;
            }

            public int getStatus() {
                return ((BleStatusInfo) this.instance).getStatus();
            }

            public Builder setStatus(int i5) {
                copyOnWrite();
                ((BleStatusInfo) this.instance).setStatus(i5);
                return this;
            }
        }

        static {
            BleStatusInfo bleStatusInfo = new BleStatusInfo();
            DEFAULT_INSTANCE = bleStatusInfo;
            z.registerDefaultInstance(BleStatusInfo.class, bleStatusInfo);
        }

        private BleStatusInfo() {
        }

        /* access modifiers changed from: private */
        public void clearStatus() {
            this.status_ = 0;
        }

        public static BleStatusInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(BleStatusInfo bleStatusInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(bleStatusInfo);
        }

        public static BleStatusInfo parseDelimitedFrom(InputStream inputStream) {
            return (BleStatusInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BleStatusInfo parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (BleStatusInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static BleStatusInfo parseFrom(i iVar) {
            return (BleStatusInfo) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static BleStatusInfo parseFrom(i iVar, q qVar) {
            return (BleStatusInfo) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static BleStatusInfo parseFrom(j jVar) {
            return (BleStatusInfo) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static BleStatusInfo parseFrom(j jVar, q qVar) {
            return (BleStatusInfo) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static BleStatusInfo parseFrom(InputStream inputStream) {
            return (BleStatusInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BleStatusInfo parseFrom(InputStream inputStream, q qVar) {
            return (BleStatusInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static BleStatusInfo parseFrom(ByteBuffer byteBuffer) {
            return (BleStatusInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static BleStatusInfo parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (BleStatusInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static BleStatusInfo parseFrom(byte[] bArr) {
            return (BleStatusInfo) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BleStatusInfo parseFrom(byte[] bArr, q qVar) {
            return (BleStatusInfo) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<BleStatusInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setStatus(int i5) {
            this.status_ = i5;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new BleStatusInfo();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"status_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<BleStatusInfo> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (BleStatusInfo.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public int getStatus() {
            return this.status_;
        }
    }

    public interface BleStatusInfoOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        int getStatus();

        /* synthetic */ boolean isInitialized();
    }

    public static final class ChangeConnectionPriorityInfo extends z<ChangeConnectionPriorityInfo, Builder> implements ChangeConnectionPriorityInfoOrBuilder {
        /* access modifiers changed from: private */
        public static final ChangeConnectionPriorityInfo DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 1;
        public static final int FAILURE_FIELD_NUMBER = 2;
        private static volatile b1<ChangeConnectionPriorityInfo> PARSER;
        private String deviceId_ = BuildConfig.FLAVOR;
        private GenericFailure failure_;

        public static final class Builder extends z.a<ChangeConnectionPriorityInfo, Builder> implements ChangeConnectionPriorityInfoOrBuilder {
            private Builder() {
                super(ChangeConnectionPriorityInfo.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((ChangeConnectionPriorityInfo) this.instance).clearDeviceId();
                return this;
            }

            public Builder clearFailure() {
                copyOnWrite();
                ((ChangeConnectionPriorityInfo) this.instance).clearFailure();
                return this;
            }

            public String getDeviceId() {
                return ((ChangeConnectionPriorityInfo) this.instance).getDeviceId();
            }

            public i getDeviceIdBytes() {
                return ((ChangeConnectionPriorityInfo) this.instance).getDeviceIdBytes();
            }

            public GenericFailure getFailure() {
                return ((ChangeConnectionPriorityInfo) this.instance).getFailure();
            }

            public boolean hasFailure() {
                return ((ChangeConnectionPriorityInfo) this.instance).hasFailure();
            }

            public Builder mergeFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((ChangeConnectionPriorityInfo) this.instance).mergeFailure(genericFailure);
                return this;
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((ChangeConnectionPriorityInfo) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(i iVar) {
                copyOnWrite();
                ((ChangeConnectionPriorityInfo) this.instance).setDeviceIdBytes(iVar);
                return this;
            }

            public Builder setFailure(GenericFailure.Builder builder) {
                copyOnWrite();
                ((ChangeConnectionPriorityInfo) this.instance).setFailure((GenericFailure) builder.build());
                return this;
            }

            public Builder setFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((ChangeConnectionPriorityInfo) this.instance).setFailure(genericFailure);
                return this;
            }
        }

        static {
            ChangeConnectionPriorityInfo changeConnectionPriorityInfo = new ChangeConnectionPriorityInfo();
            DEFAULT_INSTANCE = changeConnectionPriorityInfo;
            z.registerDefaultInstance(ChangeConnectionPriorityInfo.class, changeConnectionPriorityInfo);
        }

        private ChangeConnectionPriorityInfo() {
        }

        /* access modifiers changed from: private */
        public void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        /* access modifiers changed from: private */
        public void clearFailure() {
            this.failure_ = null;
        }

        public static ChangeConnectionPriorityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            GenericFailure genericFailure2 = this.failure_;
            if (!(genericFailure2 == null || genericFailure2 == GenericFailure.getDefaultInstance())) {
                genericFailure = (GenericFailure) ((GenericFailure.Builder) GenericFailure.newBuilder(this.failure_).mergeFrom(genericFailure)).buildPartial();
            }
            this.failure_ = genericFailure;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ChangeConnectionPriorityInfo changeConnectionPriorityInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(changeConnectionPriorityInfo);
        }

        public static ChangeConnectionPriorityInfo parseDelimitedFrom(InputStream inputStream) {
            return (ChangeConnectionPriorityInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ChangeConnectionPriorityInfo parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (ChangeConnectionPriorityInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ChangeConnectionPriorityInfo parseFrom(i iVar) {
            return (ChangeConnectionPriorityInfo) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static ChangeConnectionPriorityInfo parseFrom(i iVar, q qVar) {
            return (ChangeConnectionPriorityInfo) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static ChangeConnectionPriorityInfo parseFrom(j jVar) {
            return (ChangeConnectionPriorityInfo) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static ChangeConnectionPriorityInfo parseFrom(j jVar, q qVar) {
            return (ChangeConnectionPriorityInfo) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static ChangeConnectionPriorityInfo parseFrom(InputStream inputStream) {
            return (ChangeConnectionPriorityInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ChangeConnectionPriorityInfo parseFrom(InputStream inputStream, q qVar) {
            return (ChangeConnectionPriorityInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ChangeConnectionPriorityInfo parseFrom(ByteBuffer byteBuffer) {
            return (ChangeConnectionPriorityInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ChangeConnectionPriorityInfo parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (ChangeConnectionPriorityInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static ChangeConnectionPriorityInfo parseFrom(byte[] bArr) {
            return (ChangeConnectionPriorityInfo) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ChangeConnectionPriorityInfo parseFrom(byte[] bArr, q qVar) {
            return (ChangeConnectionPriorityInfo) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<ChangeConnectionPriorityInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setDeviceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.deviceId_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            this.failure_ = genericFailure;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new ChangeConnectionPriorityInfo();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"deviceId_", "failure_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<ChangeConnectionPriorityInfo> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (ChangeConnectionPriorityInfo.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public String getDeviceId() {
            return this.deviceId_;
        }

        public i getDeviceIdBytes() {
            return i.o(this.deviceId_);
        }

        public GenericFailure getFailure() {
            GenericFailure genericFailure = this.failure_;
            return genericFailure == null ? GenericFailure.getDefaultInstance() : genericFailure;
        }

        public boolean hasFailure() {
            return this.failure_ != null;
        }
    }

    public interface ChangeConnectionPriorityInfoOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        String getDeviceId();

        i getDeviceIdBytes();

        GenericFailure getFailure();

        boolean hasFailure();

        /* synthetic */ boolean isInitialized();
    }

    public static final class ChangeConnectionPriorityRequest extends z<ChangeConnectionPriorityRequest, Builder> implements ChangeConnectionPriorityRequestOrBuilder {
        /* access modifiers changed from: private */
        public static final ChangeConnectionPriorityRequest DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 1;
        private static volatile b1<ChangeConnectionPriorityRequest> PARSER = null;
        public static final int PRIORITY_FIELD_NUMBER = 2;
        private String deviceId_ = BuildConfig.FLAVOR;
        private int priority_;

        public static final class Builder extends z.a<ChangeConnectionPriorityRequest, Builder> implements ChangeConnectionPriorityRequestOrBuilder {
            private Builder() {
                super(ChangeConnectionPriorityRequest.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((ChangeConnectionPriorityRequest) this.instance).clearDeviceId();
                return this;
            }

            public Builder clearPriority() {
                copyOnWrite();
                ((ChangeConnectionPriorityRequest) this.instance).clearPriority();
                return this;
            }

            public String getDeviceId() {
                return ((ChangeConnectionPriorityRequest) this.instance).getDeviceId();
            }

            public i getDeviceIdBytes() {
                return ((ChangeConnectionPriorityRequest) this.instance).getDeviceIdBytes();
            }

            public int getPriority() {
                return ((ChangeConnectionPriorityRequest) this.instance).getPriority();
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((ChangeConnectionPriorityRequest) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(i iVar) {
                copyOnWrite();
                ((ChangeConnectionPriorityRequest) this.instance).setDeviceIdBytes(iVar);
                return this;
            }

            public Builder setPriority(int i5) {
                copyOnWrite();
                ((ChangeConnectionPriorityRequest) this.instance).setPriority(i5);
                return this;
            }
        }

        static {
            ChangeConnectionPriorityRequest changeConnectionPriorityRequest = new ChangeConnectionPriorityRequest();
            DEFAULT_INSTANCE = changeConnectionPriorityRequest;
            z.registerDefaultInstance(ChangeConnectionPriorityRequest.class, changeConnectionPriorityRequest);
        }

        private ChangeConnectionPriorityRequest() {
        }

        /* access modifiers changed from: private */
        public void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        /* access modifiers changed from: private */
        public void clearPriority() {
            this.priority_ = 0;
        }

        public static ChangeConnectionPriorityRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ChangeConnectionPriorityRequest changeConnectionPriorityRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(changeConnectionPriorityRequest);
        }

        public static ChangeConnectionPriorityRequest parseDelimitedFrom(InputStream inputStream) {
            return (ChangeConnectionPriorityRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ChangeConnectionPriorityRequest parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (ChangeConnectionPriorityRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ChangeConnectionPriorityRequest parseFrom(i iVar) {
            return (ChangeConnectionPriorityRequest) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static ChangeConnectionPriorityRequest parseFrom(i iVar, q qVar) {
            return (ChangeConnectionPriorityRequest) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static ChangeConnectionPriorityRequest parseFrom(j jVar) {
            return (ChangeConnectionPriorityRequest) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static ChangeConnectionPriorityRequest parseFrom(j jVar, q qVar) {
            return (ChangeConnectionPriorityRequest) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static ChangeConnectionPriorityRequest parseFrom(InputStream inputStream) {
            return (ChangeConnectionPriorityRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ChangeConnectionPriorityRequest parseFrom(InputStream inputStream, q qVar) {
            return (ChangeConnectionPriorityRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ChangeConnectionPriorityRequest parseFrom(ByteBuffer byteBuffer) {
            return (ChangeConnectionPriorityRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ChangeConnectionPriorityRequest parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (ChangeConnectionPriorityRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static ChangeConnectionPriorityRequest parseFrom(byte[] bArr) {
            return (ChangeConnectionPriorityRequest) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ChangeConnectionPriorityRequest parseFrom(byte[] bArr, q qVar) {
            return (ChangeConnectionPriorityRequest) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<ChangeConnectionPriorityRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setDeviceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.deviceId_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setPriority(int i5) {
            this.priority_ = i5;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new ChangeConnectionPriorityRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0004", new Object[]{"deviceId_", "priority_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<ChangeConnectionPriorityRequest> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (ChangeConnectionPriorityRequest.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public String getDeviceId() {
            return this.deviceId_;
        }

        public i getDeviceIdBytes() {
            return i.o(this.deviceId_);
        }

        public int getPriority() {
            return this.priority_;
        }
    }

    public interface ChangeConnectionPriorityRequestOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        String getDeviceId();

        i getDeviceIdBytes();

        int getPriority();

        /* synthetic */ boolean isInitialized();
    }

    public static final class CharacteristicAddress extends z<CharacteristicAddress, Builder> implements CharacteristicAddressOrBuilder {
        public static final int CHARACTERISTICINSTANCEID_FIELD_NUMBER = 5;
        public static final int CHARACTERISTICUUID_FIELD_NUMBER = 3;
        /* access modifiers changed from: private */
        public static final CharacteristicAddress DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 1;
        private static volatile b1<CharacteristicAddress> PARSER = null;
        public static final int SERVICEINSTANCEID_FIELD_NUMBER = 4;
        public static final int SERVICEUUID_FIELD_NUMBER = 2;
        private String characteristicInstanceId_ = BuildConfig.FLAVOR;
        private Uuid characteristicUuid_;
        private String deviceId_ = BuildConfig.FLAVOR;
        private String serviceInstanceId_ = BuildConfig.FLAVOR;
        private Uuid serviceUuid_;

        public static final class Builder extends z.a<CharacteristicAddress, Builder> implements CharacteristicAddressOrBuilder {
            private Builder() {
                super(CharacteristicAddress.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearCharacteristicInstanceId() {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).clearCharacteristicInstanceId();
                return this;
            }

            public Builder clearCharacteristicUuid() {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).clearCharacteristicUuid();
                return this;
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).clearDeviceId();
                return this;
            }

            public Builder clearServiceInstanceId() {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).clearServiceInstanceId();
                return this;
            }

            public Builder clearServiceUuid() {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).clearServiceUuid();
                return this;
            }

            public String getCharacteristicInstanceId() {
                return ((CharacteristicAddress) this.instance).getCharacteristicInstanceId();
            }

            public i getCharacteristicInstanceIdBytes() {
                return ((CharacteristicAddress) this.instance).getCharacteristicInstanceIdBytes();
            }

            public Uuid getCharacteristicUuid() {
                return ((CharacteristicAddress) this.instance).getCharacteristicUuid();
            }

            public String getDeviceId() {
                return ((CharacteristicAddress) this.instance).getDeviceId();
            }

            public i getDeviceIdBytes() {
                return ((CharacteristicAddress) this.instance).getDeviceIdBytes();
            }

            public String getServiceInstanceId() {
                return ((CharacteristicAddress) this.instance).getServiceInstanceId();
            }

            public i getServiceInstanceIdBytes() {
                return ((CharacteristicAddress) this.instance).getServiceInstanceIdBytes();
            }

            public Uuid getServiceUuid() {
                return ((CharacteristicAddress) this.instance).getServiceUuid();
            }

            public boolean hasCharacteristicUuid() {
                return ((CharacteristicAddress) this.instance).hasCharacteristicUuid();
            }

            public boolean hasServiceUuid() {
                return ((CharacteristicAddress) this.instance).hasServiceUuid();
            }

            public Builder mergeCharacteristicUuid(Uuid uuid) {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).mergeCharacteristicUuid(uuid);
                return this;
            }

            public Builder mergeServiceUuid(Uuid uuid) {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).mergeServiceUuid(uuid);
                return this;
            }

            public Builder setCharacteristicInstanceId(String str) {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).setCharacteristicInstanceId(str);
                return this;
            }

            public Builder setCharacteristicInstanceIdBytes(i iVar) {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).setCharacteristicInstanceIdBytes(iVar);
                return this;
            }

            public Builder setCharacteristicUuid(Uuid.Builder builder) {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).setCharacteristicUuid((Uuid) builder.build());
                return this;
            }

            public Builder setCharacteristicUuid(Uuid uuid) {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).setCharacteristicUuid(uuid);
                return this;
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(i iVar) {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).setDeviceIdBytes(iVar);
                return this;
            }

            public Builder setServiceInstanceId(String str) {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).setServiceInstanceId(str);
                return this;
            }

            public Builder setServiceInstanceIdBytes(i iVar) {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).setServiceInstanceIdBytes(iVar);
                return this;
            }

            public Builder setServiceUuid(Uuid.Builder builder) {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).setServiceUuid((Uuid) builder.build());
                return this;
            }

            public Builder setServiceUuid(Uuid uuid) {
                copyOnWrite();
                ((CharacteristicAddress) this.instance).setServiceUuid(uuid);
                return this;
            }
        }

        static {
            CharacteristicAddress characteristicAddress = new CharacteristicAddress();
            DEFAULT_INSTANCE = characteristicAddress;
            z.registerDefaultInstance(CharacteristicAddress.class, characteristicAddress);
        }

        private CharacteristicAddress() {
        }

        /* access modifiers changed from: private */
        public void clearCharacteristicInstanceId() {
            this.characteristicInstanceId_ = getDefaultInstance().getCharacteristicInstanceId();
        }

        /* access modifiers changed from: private */
        public void clearCharacteristicUuid() {
            this.characteristicUuid_ = null;
        }

        /* access modifiers changed from: private */
        public void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        /* access modifiers changed from: private */
        public void clearServiceInstanceId() {
            this.serviceInstanceId_ = getDefaultInstance().getServiceInstanceId();
        }

        /* access modifiers changed from: private */
        public void clearServiceUuid() {
            this.serviceUuid_ = null;
        }

        public static CharacteristicAddress getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeCharacteristicUuid(Uuid uuid) {
            uuid.getClass();
            Uuid uuid2 = this.characteristicUuid_;
            if (!(uuid2 == null || uuid2 == Uuid.getDefaultInstance())) {
                uuid = (Uuid) ((Uuid.Builder) Uuid.newBuilder(this.characteristicUuid_).mergeFrom(uuid)).buildPartial();
            }
            this.characteristicUuid_ = uuid;
        }

        /* access modifiers changed from: private */
        public void mergeServiceUuid(Uuid uuid) {
            uuid.getClass();
            Uuid uuid2 = this.serviceUuid_;
            if (!(uuid2 == null || uuid2 == Uuid.getDefaultInstance())) {
                uuid = (Uuid) ((Uuid.Builder) Uuid.newBuilder(this.serviceUuid_).mergeFrom(uuid)).buildPartial();
            }
            this.serviceUuid_ = uuid;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(CharacteristicAddress characteristicAddress) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(characteristicAddress);
        }

        public static CharacteristicAddress parseDelimitedFrom(InputStream inputStream) {
            return (CharacteristicAddress) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CharacteristicAddress parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (CharacteristicAddress) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static CharacteristicAddress parseFrom(i iVar) {
            return (CharacteristicAddress) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static CharacteristicAddress parseFrom(i iVar, q qVar) {
            return (CharacteristicAddress) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static CharacteristicAddress parseFrom(j jVar) {
            return (CharacteristicAddress) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static CharacteristicAddress parseFrom(j jVar, q qVar) {
            return (CharacteristicAddress) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static CharacteristicAddress parseFrom(InputStream inputStream) {
            return (CharacteristicAddress) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CharacteristicAddress parseFrom(InputStream inputStream, q qVar) {
            return (CharacteristicAddress) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static CharacteristicAddress parseFrom(ByteBuffer byteBuffer) {
            return (CharacteristicAddress) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static CharacteristicAddress parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (CharacteristicAddress) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static CharacteristicAddress parseFrom(byte[] bArr) {
            return (CharacteristicAddress) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CharacteristicAddress parseFrom(byte[] bArr, q qVar) {
            return (CharacteristicAddress) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<CharacteristicAddress> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setCharacteristicInstanceId(String str) {
            str.getClass();
            this.characteristicInstanceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setCharacteristicInstanceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.characteristicInstanceId_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setCharacteristicUuid(Uuid uuid) {
            uuid.getClass();
            this.characteristicUuid_ = uuid;
        }

        /* access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setDeviceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.deviceId_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setServiceInstanceId(String str) {
            str.getClass();
            this.serviceInstanceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setServiceInstanceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.serviceInstanceId_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setServiceUuid(Uuid uuid) {
            uuid.getClass();
            this.serviceUuid_ = uuid;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new CharacteristicAddress();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003\t\u0004Ȉ\u0005Ȉ", new Object[]{"deviceId_", "serviceUuid_", "characteristicUuid_", "serviceInstanceId_", "characteristicInstanceId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<CharacteristicAddress> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (CharacteristicAddress.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public String getCharacteristicInstanceId() {
            return this.characteristicInstanceId_;
        }

        public i getCharacteristicInstanceIdBytes() {
            return i.o(this.characteristicInstanceId_);
        }

        public Uuid getCharacteristicUuid() {
            Uuid uuid = this.characteristicUuid_;
            return uuid == null ? Uuid.getDefaultInstance() : uuid;
        }

        public String getDeviceId() {
            return this.deviceId_;
        }

        public i getDeviceIdBytes() {
            return i.o(this.deviceId_);
        }

        public String getServiceInstanceId() {
            return this.serviceInstanceId_;
        }

        public i getServiceInstanceIdBytes() {
            return i.o(this.serviceInstanceId_);
        }

        public Uuid getServiceUuid() {
            Uuid uuid = this.serviceUuid_;
            return uuid == null ? Uuid.getDefaultInstance() : uuid;
        }

        public boolean hasCharacteristicUuid() {
            return this.characteristicUuid_ != null;
        }

        public boolean hasServiceUuid() {
            return this.serviceUuid_ != null;
        }
    }

    public interface CharacteristicAddressOrBuilder extends t0 {
        String getCharacteristicInstanceId();

        i getCharacteristicInstanceIdBytes();

        Uuid getCharacteristicUuid();

        /* synthetic */ s0 getDefaultInstanceForType();

        String getDeviceId();

        i getDeviceIdBytes();

        String getServiceInstanceId();

        i getServiceInstanceIdBytes();

        Uuid getServiceUuid();

        boolean hasCharacteristicUuid();

        boolean hasServiceUuid();

        /* synthetic */ boolean isInitialized();
    }

    public static final class CharacteristicValueInfo extends z<CharacteristicValueInfo, Builder> implements CharacteristicValueInfoOrBuilder {
        public static final int CHARACTERISTIC_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final CharacteristicValueInfo DEFAULT_INSTANCE;
        public static final int FAILURE_FIELD_NUMBER = 3;
        private static volatile b1<CharacteristicValueInfo> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 2;
        private CharacteristicAddress characteristic_;
        private GenericFailure failure_;
        private i value_ = i.f3533f;

        public static final class Builder extends z.a<CharacteristicValueInfo, Builder> implements CharacteristicValueInfoOrBuilder {
            private Builder() {
                super(CharacteristicValueInfo.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearCharacteristic() {
                copyOnWrite();
                ((CharacteristicValueInfo) this.instance).clearCharacteristic();
                return this;
            }

            public Builder clearFailure() {
                copyOnWrite();
                ((CharacteristicValueInfo) this.instance).clearFailure();
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((CharacteristicValueInfo) this.instance).clearValue();
                return this;
            }

            public CharacteristicAddress getCharacteristic() {
                return ((CharacteristicValueInfo) this.instance).getCharacteristic();
            }

            public GenericFailure getFailure() {
                return ((CharacteristicValueInfo) this.instance).getFailure();
            }

            public i getValue() {
                return ((CharacteristicValueInfo) this.instance).getValue();
            }

            public boolean hasCharacteristic() {
                return ((CharacteristicValueInfo) this.instance).hasCharacteristic();
            }

            public boolean hasFailure() {
                return ((CharacteristicValueInfo) this.instance).hasFailure();
            }

            public Builder mergeCharacteristic(CharacteristicAddress characteristicAddress) {
                copyOnWrite();
                ((CharacteristicValueInfo) this.instance).mergeCharacteristic(characteristicAddress);
                return this;
            }

            public Builder mergeFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((CharacteristicValueInfo) this.instance).mergeFailure(genericFailure);
                return this;
            }

            public Builder setCharacteristic(CharacteristicAddress.Builder builder) {
                copyOnWrite();
                ((CharacteristicValueInfo) this.instance).setCharacteristic((CharacteristicAddress) builder.build());
                return this;
            }

            public Builder setCharacteristic(CharacteristicAddress characteristicAddress) {
                copyOnWrite();
                ((CharacteristicValueInfo) this.instance).setCharacteristic(characteristicAddress);
                return this;
            }

            public Builder setFailure(GenericFailure.Builder builder) {
                copyOnWrite();
                ((CharacteristicValueInfo) this.instance).setFailure((GenericFailure) builder.build());
                return this;
            }

            public Builder setFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((CharacteristicValueInfo) this.instance).setFailure(genericFailure);
                return this;
            }

            public Builder setValue(i iVar) {
                copyOnWrite();
                ((CharacteristicValueInfo) this.instance).setValue(iVar);
                return this;
            }
        }

        static {
            CharacteristicValueInfo characteristicValueInfo = new CharacteristicValueInfo();
            DEFAULT_INSTANCE = characteristicValueInfo;
            z.registerDefaultInstance(CharacteristicValueInfo.class, characteristicValueInfo);
        }

        private CharacteristicValueInfo() {
        }

        /* access modifiers changed from: private */
        public void clearCharacteristic() {
            this.characteristic_ = null;
        }

        /* access modifiers changed from: private */
        public void clearFailure() {
            this.failure_ = null;
        }

        /* access modifiers changed from: private */
        public void clearValue() {
            this.value_ = getDefaultInstance().getValue();
        }

        public static CharacteristicValueInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeCharacteristic(CharacteristicAddress characteristicAddress) {
            characteristicAddress.getClass();
            CharacteristicAddress characteristicAddress2 = this.characteristic_;
            if (!(characteristicAddress2 == null || characteristicAddress2 == CharacteristicAddress.getDefaultInstance())) {
                characteristicAddress = (CharacteristicAddress) ((CharacteristicAddress.Builder) CharacteristicAddress.newBuilder(this.characteristic_).mergeFrom(characteristicAddress)).buildPartial();
            }
            this.characteristic_ = characteristicAddress;
        }

        /* access modifiers changed from: private */
        public void mergeFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            GenericFailure genericFailure2 = this.failure_;
            if (!(genericFailure2 == null || genericFailure2 == GenericFailure.getDefaultInstance())) {
                genericFailure = (GenericFailure) ((GenericFailure.Builder) GenericFailure.newBuilder(this.failure_).mergeFrom(genericFailure)).buildPartial();
            }
            this.failure_ = genericFailure;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(CharacteristicValueInfo characteristicValueInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(characteristicValueInfo);
        }

        public static CharacteristicValueInfo parseDelimitedFrom(InputStream inputStream) {
            return (CharacteristicValueInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CharacteristicValueInfo parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (CharacteristicValueInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static CharacteristicValueInfo parseFrom(i iVar) {
            return (CharacteristicValueInfo) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static CharacteristicValueInfo parseFrom(i iVar, q qVar) {
            return (CharacteristicValueInfo) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static CharacteristicValueInfo parseFrom(j jVar) {
            return (CharacteristicValueInfo) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static CharacteristicValueInfo parseFrom(j jVar, q qVar) {
            return (CharacteristicValueInfo) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static CharacteristicValueInfo parseFrom(InputStream inputStream) {
            return (CharacteristicValueInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CharacteristicValueInfo parseFrom(InputStream inputStream, q qVar) {
            return (CharacteristicValueInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static CharacteristicValueInfo parseFrom(ByteBuffer byteBuffer) {
            return (CharacteristicValueInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static CharacteristicValueInfo parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (CharacteristicValueInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static CharacteristicValueInfo parseFrom(byte[] bArr) {
            return (CharacteristicValueInfo) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CharacteristicValueInfo parseFrom(byte[] bArr, q qVar) {
            return (CharacteristicValueInfo) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<CharacteristicValueInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setCharacteristic(CharacteristicAddress characteristicAddress) {
            characteristicAddress.getClass();
            this.characteristic_ = characteristicAddress;
        }

        /* access modifiers changed from: private */
        public void setFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            this.failure_ = genericFailure;
        }

        /* access modifiers changed from: private */
        public void setValue(i iVar) {
            iVar.getClass();
            this.value_ = iVar;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new CharacteristicValueInfo();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\n\u0003\t", new Object[]{"characteristic_", "value_", "failure_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<CharacteristicValueInfo> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (CharacteristicValueInfo.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public CharacteristicAddress getCharacteristic() {
            CharacteristicAddress characteristicAddress = this.characteristic_;
            return characteristicAddress == null ? CharacteristicAddress.getDefaultInstance() : characteristicAddress;
        }

        public GenericFailure getFailure() {
            GenericFailure genericFailure = this.failure_;
            return genericFailure == null ? GenericFailure.getDefaultInstance() : genericFailure;
        }

        public i getValue() {
            return this.value_;
        }

        public boolean hasCharacteristic() {
            return this.characteristic_ != null;
        }

        public boolean hasFailure() {
            return this.failure_ != null;
        }
    }

    public interface CharacteristicValueInfoOrBuilder extends t0 {
        CharacteristicAddress getCharacteristic();

        /* synthetic */ s0 getDefaultInstanceForType();

        GenericFailure getFailure();

        i getValue();

        boolean hasCharacteristic();

        boolean hasFailure();

        /* synthetic */ boolean isInitialized();
    }

    public static final class ClearGattCacheInfo extends z<ClearGattCacheInfo, Builder> implements ClearGattCacheInfoOrBuilder {
        /* access modifiers changed from: private */
        public static final ClearGattCacheInfo DEFAULT_INSTANCE;
        public static final int FAILURE_FIELD_NUMBER = 1;
        private static volatile b1<ClearGattCacheInfo> PARSER;
        private GenericFailure failure_;

        public static final class Builder extends z.a<ClearGattCacheInfo, Builder> implements ClearGattCacheInfoOrBuilder {
            private Builder() {
                super(ClearGattCacheInfo.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearFailure() {
                copyOnWrite();
                ((ClearGattCacheInfo) this.instance).clearFailure();
                return this;
            }

            public GenericFailure getFailure() {
                return ((ClearGattCacheInfo) this.instance).getFailure();
            }

            public boolean hasFailure() {
                return ((ClearGattCacheInfo) this.instance).hasFailure();
            }

            public Builder mergeFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((ClearGattCacheInfo) this.instance).mergeFailure(genericFailure);
                return this;
            }

            public Builder setFailure(GenericFailure.Builder builder) {
                copyOnWrite();
                ((ClearGattCacheInfo) this.instance).setFailure((GenericFailure) builder.build());
                return this;
            }

            public Builder setFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((ClearGattCacheInfo) this.instance).setFailure(genericFailure);
                return this;
            }
        }

        static {
            ClearGattCacheInfo clearGattCacheInfo = new ClearGattCacheInfo();
            DEFAULT_INSTANCE = clearGattCacheInfo;
            z.registerDefaultInstance(ClearGattCacheInfo.class, clearGattCacheInfo);
        }

        private ClearGattCacheInfo() {
        }

        /* access modifiers changed from: private */
        public void clearFailure() {
            this.failure_ = null;
        }

        public static ClearGattCacheInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            GenericFailure genericFailure2 = this.failure_;
            if (!(genericFailure2 == null || genericFailure2 == GenericFailure.getDefaultInstance())) {
                genericFailure = (GenericFailure) ((GenericFailure.Builder) GenericFailure.newBuilder(this.failure_).mergeFrom(genericFailure)).buildPartial();
            }
            this.failure_ = genericFailure;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ClearGattCacheInfo clearGattCacheInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(clearGattCacheInfo);
        }

        public static ClearGattCacheInfo parseDelimitedFrom(InputStream inputStream) {
            return (ClearGattCacheInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClearGattCacheInfo parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (ClearGattCacheInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ClearGattCacheInfo parseFrom(i iVar) {
            return (ClearGattCacheInfo) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static ClearGattCacheInfo parseFrom(i iVar, q qVar) {
            return (ClearGattCacheInfo) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static ClearGattCacheInfo parseFrom(j jVar) {
            return (ClearGattCacheInfo) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static ClearGattCacheInfo parseFrom(j jVar, q qVar) {
            return (ClearGattCacheInfo) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static ClearGattCacheInfo parseFrom(InputStream inputStream) {
            return (ClearGattCacheInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClearGattCacheInfo parseFrom(InputStream inputStream, q qVar) {
            return (ClearGattCacheInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ClearGattCacheInfo parseFrom(ByteBuffer byteBuffer) {
            return (ClearGattCacheInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ClearGattCacheInfo parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (ClearGattCacheInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static ClearGattCacheInfo parseFrom(byte[] bArr) {
            return (ClearGattCacheInfo) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ClearGattCacheInfo parseFrom(byte[] bArr, q qVar) {
            return (ClearGattCacheInfo) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<ClearGattCacheInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            this.failure_ = genericFailure;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new ClearGattCacheInfo();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"failure_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<ClearGattCacheInfo> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (ClearGattCacheInfo.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public GenericFailure getFailure() {
            GenericFailure genericFailure = this.failure_;
            return genericFailure == null ? GenericFailure.getDefaultInstance() : genericFailure;
        }

        public boolean hasFailure() {
            return this.failure_ != null;
        }
    }

    public interface ClearGattCacheInfoOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        GenericFailure getFailure();

        boolean hasFailure();

        /* synthetic */ boolean isInitialized();
    }

    public static final class ClearGattCacheRequest extends z<ClearGattCacheRequest, Builder> implements ClearGattCacheRequestOrBuilder {
        /* access modifiers changed from: private */
        public static final ClearGattCacheRequest DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 1;
        private static volatile b1<ClearGattCacheRequest> PARSER;
        private String deviceId_ = BuildConfig.FLAVOR;

        public static final class Builder extends z.a<ClearGattCacheRequest, Builder> implements ClearGattCacheRequestOrBuilder {
            private Builder() {
                super(ClearGattCacheRequest.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((ClearGattCacheRequest) this.instance).clearDeviceId();
                return this;
            }

            public String getDeviceId() {
                return ((ClearGattCacheRequest) this.instance).getDeviceId();
            }

            public i getDeviceIdBytes() {
                return ((ClearGattCacheRequest) this.instance).getDeviceIdBytes();
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((ClearGattCacheRequest) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(i iVar) {
                copyOnWrite();
                ((ClearGattCacheRequest) this.instance).setDeviceIdBytes(iVar);
                return this;
            }
        }

        static {
            ClearGattCacheRequest clearGattCacheRequest = new ClearGattCacheRequest();
            DEFAULT_INSTANCE = clearGattCacheRequest;
            z.registerDefaultInstance(ClearGattCacheRequest.class, clearGattCacheRequest);
        }

        private ClearGattCacheRequest() {
        }

        /* access modifiers changed from: private */
        public void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        public static ClearGattCacheRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ClearGattCacheRequest clearGattCacheRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(clearGattCacheRequest);
        }

        public static ClearGattCacheRequest parseDelimitedFrom(InputStream inputStream) {
            return (ClearGattCacheRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClearGattCacheRequest parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (ClearGattCacheRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ClearGattCacheRequest parseFrom(i iVar) {
            return (ClearGattCacheRequest) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static ClearGattCacheRequest parseFrom(i iVar, q qVar) {
            return (ClearGattCacheRequest) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static ClearGattCacheRequest parseFrom(j jVar) {
            return (ClearGattCacheRequest) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static ClearGattCacheRequest parseFrom(j jVar, q qVar) {
            return (ClearGattCacheRequest) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static ClearGattCacheRequest parseFrom(InputStream inputStream) {
            return (ClearGattCacheRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClearGattCacheRequest parseFrom(InputStream inputStream, q qVar) {
            return (ClearGattCacheRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ClearGattCacheRequest parseFrom(ByteBuffer byteBuffer) {
            return (ClearGattCacheRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ClearGattCacheRequest parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (ClearGattCacheRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static ClearGattCacheRequest parseFrom(byte[] bArr) {
            return (ClearGattCacheRequest) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ClearGattCacheRequest parseFrom(byte[] bArr, q qVar) {
            return (ClearGattCacheRequest) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<ClearGattCacheRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setDeviceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.deviceId_ = iVar.C();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new ClearGattCacheRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"deviceId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<ClearGattCacheRequest> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (ClearGattCacheRequest.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public String getDeviceId() {
            return this.deviceId_;
        }

        public i getDeviceIdBytes() {
            return i.o(this.deviceId_);
        }
    }

    public interface ClearGattCacheRequestOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        String getDeviceId();

        i getDeviceIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    public static final class ConnectToDeviceRequest extends z<ConnectToDeviceRequest, Builder> implements ConnectToDeviceRequestOrBuilder {
        /* access modifiers changed from: private */
        public static final ConnectToDeviceRequest DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 1;
        private static volatile b1<ConnectToDeviceRequest> PARSER = null;
        public static final int SERVICESWITHCHARACTERISTICSTODISCOVER_FIELD_NUMBER = 2;
        public static final int TIMEOUTINMS_FIELD_NUMBER = 3;
        private String deviceId_ = BuildConfig.FLAVOR;
        private ServicesWithCharacteristics servicesWithCharacteristicsToDiscover_;
        private int timeoutInMs_;

        public static final class Builder extends z.a<ConnectToDeviceRequest, Builder> implements ConnectToDeviceRequestOrBuilder {
            private Builder() {
                super(ConnectToDeviceRequest.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((ConnectToDeviceRequest) this.instance).clearDeviceId();
                return this;
            }

            public Builder clearServicesWithCharacteristicsToDiscover() {
                copyOnWrite();
                ((ConnectToDeviceRequest) this.instance).clearServicesWithCharacteristicsToDiscover();
                return this;
            }

            public Builder clearTimeoutInMs() {
                copyOnWrite();
                ((ConnectToDeviceRequest) this.instance).clearTimeoutInMs();
                return this;
            }

            public String getDeviceId() {
                return ((ConnectToDeviceRequest) this.instance).getDeviceId();
            }

            public i getDeviceIdBytes() {
                return ((ConnectToDeviceRequest) this.instance).getDeviceIdBytes();
            }

            public ServicesWithCharacteristics getServicesWithCharacteristicsToDiscover() {
                return ((ConnectToDeviceRequest) this.instance).getServicesWithCharacteristicsToDiscover();
            }

            public int getTimeoutInMs() {
                return ((ConnectToDeviceRequest) this.instance).getTimeoutInMs();
            }

            public boolean hasServicesWithCharacteristicsToDiscover() {
                return ((ConnectToDeviceRequest) this.instance).hasServicesWithCharacteristicsToDiscover();
            }

            public Builder mergeServicesWithCharacteristicsToDiscover(ServicesWithCharacteristics servicesWithCharacteristics) {
                copyOnWrite();
                ((ConnectToDeviceRequest) this.instance).mergeServicesWithCharacteristicsToDiscover(servicesWithCharacteristics);
                return this;
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((ConnectToDeviceRequest) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(i iVar) {
                copyOnWrite();
                ((ConnectToDeviceRequest) this.instance).setDeviceIdBytes(iVar);
                return this;
            }

            public Builder setServicesWithCharacteristicsToDiscover(ServicesWithCharacteristics.Builder builder) {
                copyOnWrite();
                ((ConnectToDeviceRequest) this.instance).setServicesWithCharacteristicsToDiscover((ServicesWithCharacteristics) builder.build());
                return this;
            }

            public Builder setServicesWithCharacteristicsToDiscover(ServicesWithCharacteristics servicesWithCharacteristics) {
                copyOnWrite();
                ((ConnectToDeviceRequest) this.instance).setServicesWithCharacteristicsToDiscover(servicesWithCharacteristics);
                return this;
            }

            public Builder setTimeoutInMs(int i5) {
                copyOnWrite();
                ((ConnectToDeviceRequest) this.instance).setTimeoutInMs(i5);
                return this;
            }
        }

        static {
            ConnectToDeviceRequest connectToDeviceRequest = new ConnectToDeviceRequest();
            DEFAULT_INSTANCE = connectToDeviceRequest;
            z.registerDefaultInstance(ConnectToDeviceRequest.class, connectToDeviceRequest);
        }

        private ConnectToDeviceRequest() {
        }

        /* access modifiers changed from: private */
        public void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        /* access modifiers changed from: private */
        public void clearServicesWithCharacteristicsToDiscover() {
            this.servicesWithCharacteristicsToDiscover_ = null;
        }

        /* access modifiers changed from: private */
        public void clearTimeoutInMs() {
            this.timeoutInMs_ = 0;
        }

        public static ConnectToDeviceRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeServicesWithCharacteristicsToDiscover(ServicesWithCharacteristics servicesWithCharacteristics) {
            servicesWithCharacteristics.getClass();
            ServicesWithCharacteristics servicesWithCharacteristics2 = this.servicesWithCharacteristicsToDiscover_;
            if (!(servicesWithCharacteristics2 == null || servicesWithCharacteristics2 == ServicesWithCharacteristics.getDefaultInstance())) {
                servicesWithCharacteristics = (ServicesWithCharacteristics) ((ServicesWithCharacteristics.Builder) ServicesWithCharacteristics.newBuilder(this.servicesWithCharacteristicsToDiscover_).mergeFrom(servicesWithCharacteristics)).buildPartial();
            }
            this.servicesWithCharacteristicsToDiscover_ = servicesWithCharacteristics;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ConnectToDeviceRequest connectToDeviceRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(connectToDeviceRequest);
        }

        public static ConnectToDeviceRequest parseDelimitedFrom(InputStream inputStream) {
            return (ConnectToDeviceRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConnectToDeviceRequest parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (ConnectToDeviceRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ConnectToDeviceRequest parseFrom(i iVar) {
            return (ConnectToDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static ConnectToDeviceRequest parseFrom(i iVar, q qVar) {
            return (ConnectToDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static ConnectToDeviceRequest parseFrom(j jVar) {
            return (ConnectToDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static ConnectToDeviceRequest parseFrom(j jVar, q qVar) {
            return (ConnectToDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static ConnectToDeviceRequest parseFrom(InputStream inputStream) {
            return (ConnectToDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConnectToDeviceRequest parseFrom(InputStream inputStream, q qVar) {
            return (ConnectToDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ConnectToDeviceRequest parseFrom(ByteBuffer byteBuffer) {
            return (ConnectToDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ConnectToDeviceRequest parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (ConnectToDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static ConnectToDeviceRequest parseFrom(byte[] bArr) {
            return (ConnectToDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ConnectToDeviceRequest parseFrom(byte[] bArr, q qVar) {
            return (ConnectToDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<ConnectToDeviceRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setDeviceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.deviceId_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setServicesWithCharacteristicsToDiscover(ServicesWithCharacteristics servicesWithCharacteristics) {
            servicesWithCharacteristics.getClass();
            this.servicesWithCharacteristicsToDiscover_ = servicesWithCharacteristics;
        }

        /* access modifiers changed from: private */
        public void setTimeoutInMs(int i5) {
            this.timeoutInMs_ = i5;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new ConnectToDeviceRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003\u0004", new Object[]{"deviceId_", "servicesWithCharacteristicsToDiscover_", "timeoutInMs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<ConnectToDeviceRequest> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (ConnectToDeviceRequest.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public String getDeviceId() {
            return this.deviceId_;
        }

        public i getDeviceIdBytes() {
            return i.o(this.deviceId_);
        }

        public ServicesWithCharacteristics getServicesWithCharacteristicsToDiscover() {
            ServicesWithCharacteristics servicesWithCharacteristics = this.servicesWithCharacteristicsToDiscover_;
            return servicesWithCharacteristics == null ? ServicesWithCharacteristics.getDefaultInstance() : servicesWithCharacteristics;
        }

        public int getTimeoutInMs() {
            return this.timeoutInMs_;
        }

        public boolean hasServicesWithCharacteristicsToDiscover() {
            return this.servicesWithCharacteristicsToDiscover_ != null;
        }
    }

    public interface ConnectToDeviceRequestOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        String getDeviceId();

        i getDeviceIdBytes();

        ServicesWithCharacteristics getServicesWithCharacteristicsToDiscover();

        int getTimeoutInMs();

        boolean hasServicesWithCharacteristicsToDiscover();

        /* synthetic */ boolean isInitialized();
    }

    public static final class DeviceInfo extends z<DeviceInfo, Builder> implements DeviceInfoOrBuilder {
        public static final int CONNECTIONSTATE_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final DeviceInfo DEFAULT_INSTANCE;
        public static final int FAILURE_FIELD_NUMBER = 3;
        public static final int ID_FIELD_NUMBER = 1;
        private static volatile b1<DeviceInfo> PARSER;
        private int connectionState_;
        private GenericFailure failure_;
        private String id_ = BuildConfig.FLAVOR;

        public static final class Builder extends z.a<DeviceInfo, Builder> implements DeviceInfoOrBuilder {
            private Builder() {
                super(DeviceInfo.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearConnectionState() {
                copyOnWrite();
                ((DeviceInfo) this.instance).clearConnectionState();
                return this;
            }

            public Builder clearFailure() {
                copyOnWrite();
                ((DeviceInfo) this.instance).clearFailure();
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((DeviceInfo) this.instance).clearId();
                return this;
            }

            public int getConnectionState() {
                return ((DeviceInfo) this.instance).getConnectionState();
            }

            public GenericFailure getFailure() {
                return ((DeviceInfo) this.instance).getFailure();
            }

            public String getId() {
                return ((DeviceInfo) this.instance).getId();
            }

            public i getIdBytes() {
                return ((DeviceInfo) this.instance).getIdBytes();
            }

            public boolean hasFailure() {
                return ((DeviceInfo) this.instance).hasFailure();
            }

            public Builder mergeFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((DeviceInfo) this.instance).mergeFailure(genericFailure);
                return this;
            }

            public Builder setConnectionState(int i5) {
                copyOnWrite();
                ((DeviceInfo) this.instance).setConnectionState(i5);
                return this;
            }

            public Builder setFailure(GenericFailure.Builder builder) {
                copyOnWrite();
                ((DeviceInfo) this.instance).setFailure((GenericFailure) builder.build());
                return this;
            }

            public Builder setFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((DeviceInfo) this.instance).setFailure(genericFailure);
                return this;
            }

            public Builder setId(String str) {
                copyOnWrite();
                ((DeviceInfo) this.instance).setId(str);
                return this;
            }

            public Builder setIdBytes(i iVar) {
                copyOnWrite();
                ((DeviceInfo) this.instance).setIdBytes(iVar);
                return this;
            }
        }

        static {
            DeviceInfo deviceInfo = new DeviceInfo();
            DEFAULT_INSTANCE = deviceInfo;
            z.registerDefaultInstance(DeviceInfo.class, deviceInfo);
        }

        private DeviceInfo() {
        }

        /* access modifiers changed from: private */
        public void clearConnectionState() {
            this.connectionState_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearFailure() {
            this.failure_ = null;
        }

        /* access modifiers changed from: private */
        public void clearId() {
            this.id_ = getDefaultInstance().getId();
        }

        public static DeviceInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            GenericFailure genericFailure2 = this.failure_;
            if (!(genericFailure2 == null || genericFailure2 == GenericFailure.getDefaultInstance())) {
                genericFailure = (GenericFailure) ((GenericFailure.Builder) GenericFailure.newBuilder(this.failure_).mergeFrom(genericFailure)).buildPartial();
            }
            this.failure_ = genericFailure;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DeviceInfo deviceInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(deviceInfo);
        }

        public static DeviceInfo parseDelimitedFrom(InputStream inputStream) {
            return (DeviceInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeviceInfo parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (DeviceInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DeviceInfo parseFrom(i iVar) {
            return (DeviceInfo) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static DeviceInfo parseFrom(i iVar, q qVar) {
            return (DeviceInfo) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static DeviceInfo parseFrom(j jVar) {
            return (DeviceInfo) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static DeviceInfo parseFrom(j jVar, q qVar) {
            return (DeviceInfo) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static DeviceInfo parseFrom(InputStream inputStream) {
            return (DeviceInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeviceInfo parseFrom(InputStream inputStream, q qVar) {
            return (DeviceInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DeviceInfo parseFrom(ByteBuffer byteBuffer) {
            return (DeviceInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DeviceInfo parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (DeviceInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static DeviceInfo parseFrom(byte[] bArr) {
            return (DeviceInfo) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DeviceInfo parseFrom(byte[] bArr, q qVar) {
            return (DeviceInfo) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<DeviceInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setConnectionState(int i5) {
            this.connectionState_ = i5;
        }

        /* access modifiers changed from: private */
        public void setFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            this.failure_ = genericFailure;
        }

        /* access modifiers changed from: private */
        public void setId(String str) {
            str.getClass();
            this.id_ = str;
        }

        /* access modifiers changed from: private */
        public void setIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.id_ = iVar.C();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new DeviceInfo();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\t", new Object[]{"id_", "connectionState_", "failure_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<DeviceInfo> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (DeviceInfo.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public int getConnectionState() {
            return this.connectionState_;
        }

        public GenericFailure getFailure() {
            GenericFailure genericFailure = this.failure_;
            return genericFailure == null ? GenericFailure.getDefaultInstance() : genericFailure;
        }

        public String getId() {
            return this.id_;
        }

        public i getIdBytes() {
            return i.o(this.id_);
        }

        public boolean hasFailure() {
            return this.failure_ != null;
        }
    }

    public interface DeviceInfoOrBuilder extends t0 {
        int getConnectionState();

        /* synthetic */ s0 getDefaultInstanceForType();

        GenericFailure getFailure();

        String getId();

        i getIdBytes();

        boolean hasFailure();

        /* synthetic */ boolean isInitialized();
    }

    public static final class DeviceScanInfo extends z<DeviceScanInfo, Builder> implements DeviceScanInfoOrBuilder {
        /* access modifiers changed from: private */
        public static final DeviceScanInfo DEFAULT_INSTANCE;
        public static final int FAILURE_FIELD_NUMBER = 3;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int ISCONNECTABLE_FIELD_NUMBER = 8;
        public static final int MANUFACTURERDATA_FIELD_NUMBER = 6;
        public static final int NAME_FIELD_NUMBER = 2;
        private static volatile b1<DeviceScanInfo> PARSER = null;
        public static final int RSSI_FIELD_NUMBER = 5;
        public static final int SERVICEDATA_FIELD_NUMBER = 4;
        public static final int SERVICEUUIDS_FIELD_NUMBER = 7;
        private GenericFailure failure_;
        private String id_ = BuildConfig.FLAVOR;
        private IsConnectable isConnectable_;
        private i manufacturerData_ = i.f3533f;
        private String name_ = BuildConfig.FLAVOR;
        private int rssi_;
        private b0.i<ServiceDataEntry> serviceData_ = z.emptyProtobufList();
        private b0.i<Uuid> serviceUuids_ = z.emptyProtobufList();

        public static final class Builder extends z.a<DeviceScanInfo, Builder> implements DeviceScanInfoOrBuilder {
            private Builder() {
                super(DeviceScanInfo.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder addAllServiceData(Iterable<? extends ServiceDataEntry> iterable) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).addAllServiceData(iterable);
                return this;
            }

            public Builder addAllServiceUuids(Iterable<? extends Uuid> iterable) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).addAllServiceUuids(iterable);
                return this;
            }

            public Builder addServiceData(int i5, ServiceDataEntry.Builder builder) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).addServiceData(i5, (ServiceDataEntry) builder.build());
                return this;
            }

            public Builder addServiceData(int i5, ServiceDataEntry serviceDataEntry) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).addServiceData(i5, serviceDataEntry);
                return this;
            }

            public Builder addServiceData(ServiceDataEntry.Builder builder) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).addServiceData((ServiceDataEntry) builder.build());
                return this;
            }

            public Builder addServiceData(ServiceDataEntry serviceDataEntry) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).addServiceData(serviceDataEntry);
                return this;
            }

            public Builder addServiceUuids(int i5, Uuid.Builder builder) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).addServiceUuids(i5, (Uuid) builder.build());
                return this;
            }

            public Builder addServiceUuids(int i5, Uuid uuid) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).addServiceUuids(i5, uuid);
                return this;
            }

            public Builder addServiceUuids(Uuid.Builder builder) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).addServiceUuids((Uuid) builder.build());
                return this;
            }

            public Builder addServiceUuids(Uuid uuid) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).addServiceUuids(uuid);
                return this;
            }

            public Builder clearFailure() {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).clearFailure();
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).clearId();
                return this;
            }

            public Builder clearIsConnectable() {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).clearIsConnectable();
                return this;
            }

            public Builder clearManufacturerData() {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).clearManufacturerData();
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).clearName();
                return this;
            }

            public Builder clearRssi() {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).clearRssi();
                return this;
            }

            public Builder clearServiceData() {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).clearServiceData();
                return this;
            }

            public Builder clearServiceUuids() {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).clearServiceUuids();
                return this;
            }

            public GenericFailure getFailure() {
                return ((DeviceScanInfo) this.instance).getFailure();
            }

            public String getId() {
                return ((DeviceScanInfo) this.instance).getId();
            }

            public i getIdBytes() {
                return ((DeviceScanInfo) this.instance).getIdBytes();
            }

            public IsConnectable getIsConnectable() {
                return ((DeviceScanInfo) this.instance).getIsConnectable();
            }

            public i getManufacturerData() {
                return ((DeviceScanInfo) this.instance).getManufacturerData();
            }

            public String getName() {
                return ((DeviceScanInfo) this.instance).getName();
            }

            public i getNameBytes() {
                return ((DeviceScanInfo) this.instance).getNameBytes();
            }

            public int getRssi() {
                return ((DeviceScanInfo) this.instance).getRssi();
            }

            public ServiceDataEntry getServiceData(int i5) {
                return ((DeviceScanInfo) this.instance).getServiceData(i5);
            }

            public int getServiceDataCount() {
                return ((DeviceScanInfo) this.instance).getServiceDataCount();
            }

            public List<ServiceDataEntry> getServiceDataList() {
                return Collections.unmodifiableList(((DeviceScanInfo) this.instance).getServiceDataList());
            }

            public Uuid getServiceUuids(int i5) {
                return ((DeviceScanInfo) this.instance).getServiceUuids(i5);
            }

            public int getServiceUuidsCount() {
                return ((DeviceScanInfo) this.instance).getServiceUuidsCount();
            }

            public List<Uuid> getServiceUuidsList() {
                return Collections.unmodifiableList(((DeviceScanInfo) this.instance).getServiceUuidsList());
            }

            public boolean hasFailure() {
                return ((DeviceScanInfo) this.instance).hasFailure();
            }

            public boolean hasIsConnectable() {
                return ((DeviceScanInfo) this.instance).hasIsConnectable();
            }

            public Builder mergeFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).mergeFailure(genericFailure);
                return this;
            }

            public Builder mergeIsConnectable(IsConnectable isConnectable) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).mergeIsConnectable(isConnectable);
                return this;
            }

            public Builder removeServiceData(int i5) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).removeServiceData(i5);
                return this;
            }

            public Builder removeServiceUuids(int i5) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).removeServiceUuids(i5);
                return this;
            }

            public Builder setFailure(GenericFailure.Builder builder) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setFailure((GenericFailure) builder.build());
                return this;
            }

            public Builder setFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setFailure(genericFailure);
                return this;
            }

            public Builder setId(String str) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setId(str);
                return this;
            }

            public Builder setIdBytes(i iVar) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setIdBytes(iVar);
                return this;
            }

            public Builder setIsConnectable(IsConnectable.Builder builder) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setIsConnectable((IsConnectable) builder.build());
                return this;
            }

            public Builder setIsConnectable(IsConnectable isConnectable) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setIsConnectable(isConnectable);
                return this;
            }

            public Builder setManufacturerData(i iVar) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setManufacturerData(iVar);
                return this;
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setName(str);
                return this;
            }

            public Builder setNameBytes(i iVar) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setNameBytes(iVar);
                return this;
            }

            public Builder setRssi(int i5) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setRssi(i5);
                return this;
            }

            public Builder setServiceData(int i5, ServiceDataEntry.Builder builder) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setServiceData(i5, (ServiceDataEntry) builder.build());
                return this;
            }

            public Builder setServiceData(int i5, ServiceDataEntry serviceDataEntry) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setServiceData(i5, serviceDataEntry);
                return this;
            }

            public Builder setServiceUuids(int i5, Uuid.Builder builder) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setServiceUuids(i5, (Uuid) builder.build());
                return this;
            }

            public Builder setServiceUuids(int i5, Uuid uuid) {
                copyOnWrite();
                ((DeviceScanInfo) this.instance).setServiceUuids(i5, uuid);
                return this;
            }
        }

        static {
            DeviceScanInfo deviceScanInfo = new DeviceScanInfo();
            DEFAULT_INSTANCE = deviceScanInfo;
            z.registerDefaultInstance(DeviceScanInfo.class, deviceScanInfo);
        }

        private DeviceScanInfo() {
        }

        /* access modifiers changed from: private */
        public void addAllServiceData(Iterable<? extends ServiceDataEntry> iterable) {
            ensureServiceDataIsMutable();
            a.addAll(iterable, this.serviceData_);
        }

        /* access modifiers changed from: private */
        public void addAllServiceUuids(Iterable<? extends Uuid> iterable) {
            ensureServiceUuidsIsMutable();
            a.addAll(iterable, this.serviceUuids_);
        }

        /* access modifiers changed from: private */
        public void addServiceData(int i5, ServiceDataEntry serviceDataEntry) {
            serviceDataEntry.getClass();
            ensureServiceDataIsMutable();
            this.serviceData_.add(i5, serviceDataEntry);
        }

        /* access modifiers changed from: private */
        public void addServiceData(ServiceDataEntry serviceDataEntry) {
            serviceDataEntry.getClass();
            ensureServiceDataIsMutable();
            this.serviceData_.add(serviceDataEntry);
        }

        /* access modifiers changed from: private */
        public void addServiceUuids(int i5, Uuid uuid) {
            uuid.getClass();
            ensureServiceUuidsIsMutable();
            this.serviceUuids_.add(i5, uuid);
        }

        /* access modifiers changed from: private */
        public void addServiceUuids(Uuid uuid) {
            uuid.getClass();
            ensureServiceUuidsIsMutable();
            this.serviceUuids_.add(uuid);
        }

        /* access modifiers changed from: private */
        public void clearFailure() {
            this.failure_ = null;
        }

        /* access modifiers changed from: private */
        public void clearId() {
            this.id_ = getDefaultInstance().getId();
        }

        /* access modifiers changed from: private */
        public void clearIsConnectable() {
            this.isConnectable_ = null;
        }

        /* access modifiers changed from: private */
        public void clearManufacturerData() {
            this.manufacturerData_ = getDefaultInstance().getManufacturerData();
        }

        /* access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* access modifiers changed from: private */
        public void clearRssi() {
            this.rssi_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearServiceData() {
            this.serviceData_ = z.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearServiceUuids() {
            this.serviceUuids_ = z.emptyProtobufList();
        }

        private void ensureServiceDataIsMutable() {
            b0.i<ServiceDataEntry> iVar = this.serviceData_;
            if (!iVar.k()) {
                this.serviceData_ = z.mutableCopy(iVar);
            }
        }

        private void ensureServiceUuidsIsMutable() {
            b0.i<Uuid> iVar = this.serviceUuids_;
            if (!iVar.k()) {
                this.serviceUuids_ = z.mutableCopy(iVar);
            }
        }

        public static DeviceScanInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            GenericFailure genericFailure2 = this.failure_;
            if (!(genericFailure2 == null || genericFailure2 == GenericFailure.getDefaultInstance())) {
                genericFailure = (GenericFailure) ((GenericFailure.Builder) GenericFailure.newBuilder(this.failure_).mergeFrom(genericFailure)).buildPartial();
            }
            this.failure_ = genericFailure;
        }

        /* access modifiers changed from: private */
        public void mergeIsConnectable(IsConnectable isConnectable) {
            isConnectable.getClass();
            IsConnectable isConnectable2 = this.isConnectable_;
            if (!(isConnectable2 == null || isConnectable2 == IsConnectable.getDefaultInstance())) {
                isConnectable = (IsConnectable) ((IsConnectable.Builder) IsConnectable.newBuilder(this.isConnectable_).mergeFrom(isConnectable)).buildPartial();
            }
            this.isConnectable_ = isConnectable;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DeviceScanInfo deviceScanInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(deviceScanInfo);
        }

        public static DeviceScanInfo parseDelimitedFrom(InputStream inputStream) {
            return (DeviceScanInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeviceScanInfo parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (DeviceScanInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DeviceScanInfo parseFrom(i iVar) {
            return (DeviceScanInfo) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static DeviceScanInfo parseFrom(i iVar, q qVar) {
            return (DeviceScanInfo) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static DeviceScanInfo parseFrom(j jVar) {
            return (DeviceScanInfo) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static DeviceScanInfo parseFrom(j jVar, q qVar) {
            return (DeviceScanInfo) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static DeviceScanInfo parseFrom(InputStream inputStream) {
            return (DeviceScanInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeviceScanInfo parseFrom(InputStream inputStream, q qVar) {
            return (DeviceScanInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DeviceScanInfo parseFrom(ByteBuffer byteBuffer) {
            return (DeviceScanInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DeviceScanInfo parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (DeviceScanInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static DeviceScanInfo parseFrom(byte[] bArr) {
            return (DeviceScanInfo) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DeviceScanInfo parseFrom(byte[] bArr, q qVar) {
            return (DeviceScanInfo) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<DeviceScanInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void removeServiceData(int i5) {
            ensureServiceDataIsMutable();
            this.serviceData_.remove(i5);
        }

        /* access modifiers changed from: private */
        public void removeServiceUuids(int i5) {
            ensureServiceUuidsIsMutable();
            this.serviceUuids_.remove(i5);
        }

        /* access modifiers changed from: private */
        public void setFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            this.failure_ = genericFailure;
        }

        /* access modifiers changed from: private */
        public void setId(String str) {
            str.getClass();
            this.id_ = str;
        }

        /* access modifiers changed from: private */
        public void setIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.id_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setIsConnectable(IsConnectable isConnectable) {
            isConnectable.getClass();
            this.isConnectable_ = isConnectable;
        }

        /* access modifiers changed from: private */
        public void setManufacturerData(i iVar) {
            iVar.getClass();
            this.manufacturerData_ = iVar;
        }

        /* access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* access modifiers changed from: private */
        public void setNameBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.name_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setRssi(int i5) {
            this.rssi_ = i5;
        }

        /* access modifiers changed from: private */
        public void setServiceData(int i5, ServiceDataEntry serviceDataEntry) {
            serviceDataEntry.getClass();
            ensureServiceDataIsMutable();
            this.serviceData_.set(i5, serviceDataEntry);
        }

        /* access modifiers changed from: private */
        public void setServiceUuids(int i5, Uuid uuid) {
            uuid.getClass();
            ensureServiceUuidsIsMutable();
            this.serviceUuids_.set(i5, uuid);
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new DeviceScanInfo();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003\t\u0004\u001b\u0005\u0004\u0006\n\u0007\u001b\b\t", new Object[]{"id_", "name_", "failure_", "serviceData_", ServiceDataEntry.class, "rssi_", "manufacturerData_", "serviceUuids_", Uuid.class, "isConnectable_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<DeviceScanInfo> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (DeviceScanInfo.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public GenericFailure getFailure() {
            GenericFailure genericFailure = this.failure_;
            return genericFailure == null ? GenericFailure.getDefaultInstance() : genericFailure;
        }

        public String getId() {
            return this.id_;
        }

        public i getIdBytes() {
            return i.o(this.id_);
        }

        public IsConnectable getIsConnectable() {
            IsConnectable isConnectable = this.isConnectable_;
            return isConnectable == null ? IsConnectable.getDefaultInstance() : isConnectable;
        }

        public i getManufacturerData() {
            return this.manufacturerData_;
        }

        public String getName() {
            return this.name_;
        }

        public i getNameBytes() {
            return i.o(this.name_);
        }

        public int getRssi() {
            return this.rssi_;
        }

        public ServiceDataEntry getServiceData(int i5) {
            return this.serviceData_.get(i5);
        }

        public int getServiceDataCount() {
            return this.serviceData_.size();
        }

        public List<ServiceDataEntry> getServiceDataList() {
            return this.serviceData_;
        }

        public ServiceDataEntryOrBuilder getServiceDataOrBuilder(int i5) {
            return this.serviceData_.get(i5);
        }

        public List<? extends ServiceDataEntryOrBuilder> getServiceDataOrBuilderList() {
            return this.serviceData_;
        }

        public Uuid getServiceUuids(int i5) {
            return this.serviceUuids_.get(i5);
        }

        public int getServiceUuidsCount() {
            return this.serviceUuids_.size();
        }

        public List<Uuid> getServiceUuidsList() {
            return this.serviceUuids_;
        }

        public UuidOrBuilder getServiceUuidsOrBuilder(int i5) {
            return this.serviceUuids_.get(i5);
        }

        public List<? extends UuidOrBuilder> getServiceUuidsOrBuilderList() {
            return this.serviceUuids_;
        }

        public boolean hasFailure() {
            return this.failure_ != null;
        }

        public boolean hasIsConnectable() {
            return this.isConnectable_ != null;
        }
    }

    public interface DeviceScanInfoOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        GenericFailure getFailure();

        String getId();

        i getIdBytes();

        IsConnectable getIsConnectable();

        i getManufacturerData();

        String getName();

        i getNameBytes();

        int getRssi();

        ServiceDataEntry getServiceData(int i5);

        int getServiceDataCount();

        List<ServiceDataEntry> getServiceDataList();

        Uuid getServiceUuids(int i5);

        int getServiceUuidsCount();

        List<Uuid> getServiceUuidsList();

        boolean hasFailure();

        boolean hasIsConnectable();

        /* synthetic */ boolean isInitialized();
    }

    public static final class DisconnectFromDeviceRequest extends z<DisconnectFromDeviceRequest, Builder> implements DisconnectFromDeviceRequestOrBuilder {
        /* access modifiers changed from: private */
        public static final DisconnectFromDeviceRequest DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 1;
        private static volatile b1<DisconnectFromDeviceRequest> PARSER;
        private String deviceId_ = BuildConfig.FLAVOR;

        public static final class Builder extends z.a<DisconnectFromDeviceRequest, Builder> implements DisconnectFromDeviceRequestOrBuilder {
            private Builder() {
                super(DisconnectFromDeviceRequest.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((DisconnectFromDeviceRequest) this.instance).clearDeviceId();
                return this;
            }

            public String getDeviceId() {
                return ((DisconnectFromDeviceRequest) this.instance).getDeviceId();
            }

            public i getDeviceIdBytes() {
                return ((DisconnectFromDeviceRequest) this.instance).getDeviceIdBytes();
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((DisconnectFromDeviceRequest) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(i iVar) {
                copyOnWrite();
                ((DisconnectFromDeviceRequest) this.instance).setDeviceIdBytes(iVar);
                return this;
            }
        }

        static {
            DisconnectFromDeviceRequest disconnectFromDeviceRequest = new DisconnectFromDeviceRequest();
            DEFAULT_INSTANCE = disconnectFromDeviceRequest;
            z.registerDefaultInstance(DisconnectFromDeviceRequest.class, disconnectFromDeviceRequest);
        }

        private DisconnectFromDeviceRequest() {
        }

        /* access modifiers changed from: private */
        public void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        public static DisconnectFromDeviceRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DisconnectFromDeviceRequest disconnectFromDeviceRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(disconnectFromDeviceRequest);
        }

        public static DisconnectFromDeviceRequest parseDelimitedFrom(InputStream inputStream) {
            return (DisconnectFromDeviceRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DisconnectFromDeviceRequest parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (DisconnectFromDeviceRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DisconnectFromDeviceRequest parseFrom(i iVar) {
            return (DisconnectFromDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static DisconnectFromDeviceRequest parseFrom(i iVar, q qVar) {
            return (DisconnectFromDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static DisconnectFromDeviceRequest parseFrom(j jVar) {
            return (DisconnectFromDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static DisconnectFromDeviceRequest parseFrom(j jVar, q qVar) {
            return (DisconnectFromDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static DisconnectFromDeviceRequest parseFrom(InputStream inputStream) {
            return (DisconnectFromDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DisconnectFromDeviceRequest parseFrom(InputStream inputStream, q qVar) {
            return (DisconnectFromDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DisconnectFromDeviceRequest parseFrom(ByteBuffer byteBuffer) {
            return (DisconnectFromDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DisconnectFromDeviceRequest parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (DisconnectFromDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static DisconnectFromDeviceRequest parseFrom(byte[] bArr) {
            return (DisconnectFromDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DisconnectFromDeviceRequest parseFrom(byte[] bArr, q qVar) {
            return (DisconnectFromDeviceRequest) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<DisconnectFromDeviceRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setDeviceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.deviceId_ = iVar.C();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new DisconnectFromDeviceRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"deviceId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<DisconnectFromDeviceRequest> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (DisconnectFromDeviceRequest.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public String getDeviceId() {
            return this.deviceId_;
        }

        public i getDeviceIdBytes() {
            return i.o(this.deviceId_);
        }
    }

    public interface DisconnectFromDeviceRequestOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        String getDeviceId();

        i getDeviceIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    public static final class DiscoverServicesInfo extends z<DiscoverServicesInfo, Builder> implements DiscoverServicesInfoOrBuilder {
        /* access modifiers changed from: private */
        public static final DiscoverServicesInfo DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 1;
        private static volatile b1<DiscoverServicesInfo> PARSER = null;
        public static final int SERVICES_FIELD_NUMBER = 2;
        private String deviceId_ = BuildConfig.FLAVOR;
        private b0.i<DiscoveredService> services_ = z.emptyProtobufList();

        public static final class Builder extends z.a<DiscoverServicesInfo, Builder> implements DiscoverServicesInfoOrBuilder {
            private Builder() {
                super(DiscoverServicesInfo.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder addAllServices(Iterable<? extends DiscoveredService> iterable) {
                copyOnWrite();
                ((DiscoverServicesInfo) this.instance).addAllServices(iterable);
                return this;
            }

            public Builder addServices(int i5, DiscoveredService.Builder builder) {
                copyOnWrite();
                ((DiscoverServicesInfo) this.instance).addServices(i5, (DiscoveredService) builder.build());
                return this;
            }

            public Builder addServices(int i5, DiscoveredService discoveredService) {
                copyOnWrite();
                ((DiscoverServicesInfo) this.instance).addServices(i5, discoveredService);
                return this;
            }

            public Builder addServices(DiscoveredService.Builder builder) {
                copyOnWrite();
                ((DiscoverServicesInfo) this.instance).addServices((DiscoveredService) builder.build());
                return this;
            }

            public Builder addServices(DiscoveredService discoveredService) {
                copyOnWrite();
                ((DiscoverServicesInfo) this.instance).addServices(discoveredService);
                return this;
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((DiscoverServicesInfo) this.instance).clearDeviceId();
                return this;
            }

            public Builder clearServices() {
                copyOnWrite();
                ((DiscoverServicesInfo) this.instance).clearServices();
                return this;
            }

            public String getDeviceId() {
                return ((DiscoverServicesInfo) this.instance).getDeviceId();
            }

            public i getDeviceIdBytes() {
                return ((DiscoverServicesInfo) this.instance).getDeviceIdBytes();
            }

            public DiscoveredService getServices(int i5) {
                return ((DiscoverServicesInfo) this.instance).getServices(i5);
            }

            public int getServicesCount() {
                return ((DiscoverServicesInfo) this.instance).getServicesCount();
            }

            public List<DiscoveredService> getServicesList() {
                return Collections.unmodifiableList(((DiscoverServicesInfo) this.instance).getServicesList());
            }

            public Builder removeServices(int i5) {
                copyOnWrite();
                ((DiscoverServicesInfo) this.instance).removeServices(i5);
                return this;
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((DiscoverServicesInfo) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(i iVar) {
                copyOnWrite();
                ((DiscoverServicesInfo) this.instance).setDeviceIdBytes(iVar);
                return this;
            }

            public Builder setServices(int i5, DiscoveredService.Builder builder) {
                copyOnWrite();
                ((DiscoverServicesInfo) this.instance).setServices(i5, (DiscoveredService) builder.build());
                return this;
            }

            public Builder setServices(int i5, DiscoveredService discoveredService) {
                copyOnWrite();
                ((DiscoverServicesInfo) this.instance).setServices(i5, discoveredService);
                return this;
            }
        }

        static {
            DiscoverServicesInfo discoverServicesInfo = new DiscoverServicesInfo();
            DEFAULT_INSTANCE = discoverServicesInfo;
            z.registerDefaultInstance(DiscoverServicesInfo.class, discoverServicesInfo);
        }

        private DiscoverServicesInfo() {
        }

        /* access modifiers changed from: private */
        public void addAllServices(Iterable<? extends DiscoveredService> iterable) {
            ensureServicesIsMutable();
            a.addAll(iterable, this.services_);
        }

        /* access modifiers changed from: private */
        public void addServices(int i5, DiscoveredService discoveredService) {
            discoveredService.getClass();
            ensureServicesIsMutable();
            this.services_.add(i5, discoveredService);
        }

        /* access modifiers changed from: private */
        public void addServices(DiscoveredService discoveredService) {
            discoveredService.getClass();
            ensureServicesIsMutable();
            this.services_.add(discoveredService);
        }

        /* access modifiers changed from: private */
        public void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        /* access modifiers changed from: private */
        public void clearServices() {
            this.services_ = z.emptyProtobufList();
        }

        private void ensureServicesIsMutable() {
            b0.i<DiscoveredService> iVar = this.services_;
            if (!iVar.k()) {
                this.services_ = z.mutableCopy(iVar);
            }
        }

        public static DiscoverServicesInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DiscoverServicesInfo discoverServicesInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(discoverServicesInfo);
        }

        public static DiscoverServicesInfo parseDelimitedFrom(InputStream inputStream) {
            return (DiscoverServicesInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DiscoverServicesInfo parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (DiscoverServicesInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DiscoverServicesInfo parseFrom(i iVar) {
            return (DiscoverServicesInfo) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static DiscoverServicesInfo parseFrom(i iVar, q qVar) {
            return (DiscoverServicesInfo) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static DiscoverServicesInfo parseFrom(j jVar) {
            return (DiscoverServicesInfo) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static DiscoverServicesInfo parseFrom(j jVar, q qVar) {
            return (DiscoverServicesInfo) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static DiscoverServicesInfo parseFrom(InputStream inputStream) {
            return (DiscoverServicesInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DiscoverServicesInfo parseFrom(InputStream inputStream, q qVar) {
            return (DiscoverServicesInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DiscoverServicesInfo parseFrom(ByteBuffer byteBuffer) {
            return (DiscoverServicesInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DiscoverServicesInfo parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (DiscoverServicesInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static DiscoverServicesInfo parseFrom(byte[] bArr) {
            return (DiscoverServicesInfo) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DiscoverServicesInfo parseFrom(byte[] bArr, q qVar) {
            return (DiscoverServicesInfo) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<DiscoverServicesInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void removeServices(int i5) {
            ensureServicesIsMutable();
            this.services_.remove(i5);
        }

        /* access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setDeviceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.deviceId_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setServices(int i5, DiscoveredService discoveredService) {
            discoveredService.getClass();
            ensureServicesIsMutable();
            this.services_.set(i5, discoveredService);
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new DiscoverServicesInfo();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"deviceId_", "services_", DiscoveredService.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<DiscoverServicesInfo> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (DiscoverServicesInfo.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public String getDeviceId() {
            return this.deviceId_;
        }

        public i getDeviceIdBytes() {
            return i.o(this.deviceId_);
        }

        public DiscoveredService getServices(int i5) {
            return this.services_.get(i5);
        }

        public int getServicesCount() {
            return this.services_.size();
        }

        public List<DiscoveredService> getServicesList() {
            return this.services_;
        }

        public DiscoveredServiceOrBuilder getServicesOrBuilder(int i5) {
            return this.services_.get(i5);
        }

        public List<? extends DiscoveredServiceOrBuilder> getServicesOrBuilderList() {
            return this.services_;
        }
    }

    public interface DiscoverServicesInfoOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        String getDeviceId();

        i getDeviceIdBytes();

        DiscoveredService getServices(int i5);

        int getServicesCount();

        List<DiscoveredService> getServicesList();

        /* synthetic */ boolean isInitialized();
    }

    public static final class DiscoverServicesRequest extends z<DiscoverServicesRequest, Builder> implements DiscoverServicesRequestOrBuilder {
        /* access modifiers changed from: private */
        public static final DiscoverServicesRequest DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 1;
        private static volatile b1<DiscoverServicesRequest> PARSER;
        private String deviceId_ = BuildConfig.FLAVOR;

        public static final class Builder extends z.a<DiscoverServicesRequest, Builder> implements DiscoverServicesRequestOrBuilder {
            private Builder() {
                super(DiscoverServicesRequest.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((DiscoverServicesRequest) this.instance).clearDeviceId();
                return this;
            }

            public String getDeviceId() {
                return ((DiscoverServicesRequest) this.instance).getDeviceId();
            }

            public i getDeviceIdBytes() {
                return ((DiscoverServicesRequest) this.instance).getDeviceIdBytes();
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((DiscoverServicesRequest) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(i iVar) {
                copyOnWrite();
                ((DiscoverServicesRequest) this.instance).setDeviceIdBytes(iVar);
                return this;
            }
        }

        static {
            DiscoverServicesRequest discoverServicesRequest = new DiscoverServicesRequest();
            DEFAULT_INSTANCE = discoverServicesRequest;
            z.registerDefaultInstance(DiscoverServicesRequest.class, discoverServicesRequest);
        }

        private DiscoverServicesRequest() {
        }

        /* access modifiers changed from: private */
        public void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        public static DiscoverServicesRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DiscoverServicesRequest discoverServicesRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(discoverServicesRequest);
        }

        public static DiscoverServicesRequest parseDelimitedFrom(InputStream inputStream) {
            return (DiscoverServicesRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DiscoverServicesRequest parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (DiscoverServicesRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DiscoverServicesRequest parseFrom(i iVar) {
            return (DiscoverServicesRequest) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static DiscoverServicesRequest parseFrom(i iVar, q qVar) {
            return (DiscoverServicesRequest) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static DiscoverServicesRequest parseFrom(j jVar) {
            return (DiscoverServicesRequest) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static DiscoverServicesRequest parseFrom(j jVar, q qVar) {
            return (DiscoverServicesRequest) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static DiscoverServicesRequest parseFrom(InputStream inputStream) {
            return (DiscoverServicesRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DiscoverServicesRequest parseFrom(InputStream inputStream, q qVar) {
            return (DiscoverServicesRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DiscoverServicesRequest parseFrom(ByteBuffer byteBuffer) {
            return (DiscoverServicesRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DiscoverServicesRequest parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (DiscoverServicesRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static DiscoverServicesRequest parseFrom(byte[] bArr) {
            return (DiscoverServicesRequest) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DiscoverServicesRequest parseFrom(byte[] bArr, q qVar) {
            return (DiscoverServicesRequest) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<DiscoverServicesRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setDeviceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.deviceId_ = iVar.C();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new DiscoverServicesRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"deviceId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<DiscoverServicesRequest> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (DiscoverServicesRequest.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public String getDeviceId() {
            return this.deviceId_;
        }

        public i getDeviceIdBytes() {
            return i.o(this.deviceId_);
        }
    }

    public interface DiscoverServicesRequestOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        String getDeviceId();

        i getDeviceIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    public static final class DiscoveredCharacteristic extends z<DiscoveredCharacteristic, Builder> implements DiscoveredCharacteristicOrBuilder {
        public static final int CHARACTERISTICID_FIELD_NUMBER = 1;
        public static final int CHARACTERISTICINSTANCEID_FIELD_NUMBER = 8;
        /* access modifiers changed from: private */
        public static final DiscoveredCharacteristic DEFAULT_INSTANCE;
        public static final int ISINDICATABLE_FIELD_NUMBER = 7;
        public static final int ISNOTIFIABLE_FIELD_NUMBER = 6;
        public static final int ISREADABLE_FIELD_NUMBER = 3;
        public static final int ISWRITABLEWITHOUTRESPONSE_FIELD_NUMBER = 5;
        public static final int ISWRITABLEWITHRESPONSE_FIELD_NUMBER = 4;
        private static volatile b1<DiscoveredCharacteristic> PARSER = null;
        public static final int SERVICEID_FIELD_NUMBER = 2;
        private Uuid characteristicId_;
        private String characteristicInstanceId_ = BuildConfig.FLAVOR;
        private boolean isIndicatable_;
        private boolean isNotifiable_;
        private boolean isReadable_;
        private boolean isWritableWithResponse_;
        private boolean isWritableWithoutResponse_;
        private Uuid serviceId_;

        public static final class Builder extends z.a<DiscoveredCharacteristic, Builder> implements DiscoveredCharacteristicOrBuilder {
            private Builder() {
                super(DiscoveredCharacteristic.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearCharacteristicId() {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).clearCharacteristicId();
                return this;
            }

            public Builder clearCharacteristicInstanceId() {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).clearCharacteristicInstanceId();
                return this;
            }

            public Builder clearIsIndicatable() {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).clearIsIndicatable();
                return this;
            }

            public Builder clearIsNotifiable() {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).clearIsNotifiable();
                return this;
            }

            public Builder clearIsReadable() {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).clearIsReadable();
                return this;
            }

            public Builder clearIsWritableWithResponse() {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).clearIsWritableWithResponse();
                return this;
            }

            public Builder clearIsWritableWithoutResponse() {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).clearIsWritableWithoutResponse();
                return this;
            }

            public Builder clearServiceId() {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).clearServiceId();
                return this;
            }

            public Uuid getCharacteristicId() {
                return ((DiscoveredCharacteristic) this.instance).getCharacteristicId();
            }

            public String getCharacteristicInstanceId() {
                return ((DiscoveredCharacteristic) this.instance).getCharacteristicInstanceId();
            }

            public i getCharacteristicInstanceIdBytes() {
                return ((DiscoveredCharacteristic) this.instance).getCharacteristicInstanceIdBytes();
            }

            public boolean getIsIndicatable() {
                return ((DiscoveredCharacteristic) this.instance).getIsIndicatable();
            }

            public boolean getIsNotifiable() {
                return ((DiscoveredCharacteristic) this.instance).getIsNotifiable();
            }

            public boolean getIsReadable() {
                return ((DiscoveredCharacteristic) this.instance).getIsReadable();
            }

            public boolean getIsWritableWithResponse() {
                return ((DiscoveredCharacteristic) this.instance).getIsWritableWithResponse();
            }

            public boolean getIsWritableWithoutResponse() {
                return ((DiscoveredCharacteristic) this.instance).getIsWritableWithoutResponse();
            }

            public Uuid getServiceId() {
                return ((DiscoveredCharacteristic) this.instance).getServiceId();
            }

            public boolean hasCharacteristicId() {
                return ((DiscoveredCharacteristic) this.instance).hasCharacteristicId();
            }

            public boolean hasServiceId() {
                return ((DiscoveredCharacteristic) this.instance).hasServiceId();
            }

            public Builder mergeCharacteristicId(Uuid uuid) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).mergeCharacteristicId(uuid);
                return this;
            }

            public Builder mergeServiceId(Uuid uuid) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).mergeServiceId(uuid);
                return this;
            }

            public Builder setCharacteristicId(Uuid.Builder builder) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).setCharacteristicId((Uuid) builder.build());
                return this;
            }

            public Builder setCharacteristicId(Uuid uuid) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).setCharacteristicId(uuid);
                return this;
            }

            public Builder setCharacteristicInstanceId(String str) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).setCharacteristicInstanceId(str);
                return this;
            }

            public Builder setCharacteristicInstanceIdBytes(i iVar) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).setCharacteristicInstanceIdBytes(iVar);
                return this;
            }

            public Builder setIsIndicatable(boolean z4) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).setIsIndicatable(z4);
                return this;
            }

            public Builder setIsNotifiable(boolean z4) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).setIsNotifiable(z4);
                return this;
            }

            public Builder setIsReadable(boolean z4) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).setIsReadable(z4);
                return this;
            }

            public Builder setIsWritableWithResponse(boolean z4) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).setIsWritableWithResponse(z4);
                return this;
            }

            public Builder setIsWritableWithoutResponse(boolean z4) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).setIsWritableWithoutResponse(z4);
                return this;
            }

            public Builder setServiceId(Uuid.Builder builder) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).setServiceId((Uuid) builder.build());
                return this;
            }

            public Builder setServiceId(Uuid uuid) {
                copyOnWrite();
                ((DiscoveredCharacteristic) this.instance).setServiceId(uuid);
                return this;
            }
        }

        static {
            DiscoveredCharacteristic discoveredCharacteristic = new DiscoveredCharacteristic();
            DEFAULT_INSTANCE = discoveredCharacteristic;
            z.registerDefaultInstance(DiscoveredCharacteristic.class, discoveredCharacteristic);
        }

        private DiscoveredCharacteristic() {
        }

        /* access modifiers changed from: private */
        public void clearCharacteristicId() {
            this.characteristicId_ = null;
        }

        /* access modifiers changed from: private */
        public void clearCharacteristicInstanceId() {
            this.characteristicInstanceId_ = getDefaultInstance().getCharacteristicInstanceId();
        }

        /* access modifiers changed from: private */
        public void clearIsIndicatable() {
            this.isIndicatable_ = false;
        }

        /* access modifiers changed from: private */
        public void clearIsNotifiable() {
            this.isNotifiable_ = false;
        }

        /* access modifiers changed from: private */
        public void clearIsReadable() {
            this.isReadable_ = false;
        }

        /* access modifiers changed from: private */
        public void clearIsWritableWithResponse() {
            this.isWritableWithResponse_ = false;
        }

        /* access modifiers changed from: private */
        public void clearIsWritableWithoutResponse() {
            this.isWritableWithoutResponse_ = false;
        }

        /* access modifiers changed from: private */
        public void clearServiceId() {
            this.serviceId_ = null;
        }

        public static DiscoveredCharacteristic getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeCharacteristicId(Uuid uuid) {
            uuid.getClass();
            Uuid uuid2 = this.characteristicId_;
            if (!(uuid2 == null || uuid2 == Uuid.getDefaultInstance())) {
                uuid = (Uuid) ((Uuid.Builder) Uuid.newBuilder(this.characteristicId_).mergeFrom(uuid)).buildPartial();
            }
            this.characteristicId_ = uuid;
        }

        /* access modifiers changed from: private */
        public void mergeServiceId(Uuid uuid) {
            uuid.getClass();
            Uuid uuid2 = this.serviceId_;
            if (!(uuid2 == null || uuid2 == Uuid.getDefaultInstance())) {
                uuid = (Uuid) ((Uuid.Builder) Uuid.newBuilder(this.serviceId_).mergeFrom(uuid)).buildPartial();
            }
            this.serviceId_ = uuid;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DiscoveredCharacteristic discoveredCharacteristic) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(discoveredCharacteristic);
        }

        public static DiscoveredCharacteristic parseDelimitedFrom(InputStream inputStream) {
            return (DiscoveredCharacteristic) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DiscoveredCharacteristic parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (DiscoveredCharacteristic) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DiscoveredCharacteristic parseFrom(i iVar) {
            return (DiscoveredCharacteristic) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static DiscoveredCharacteristic parseFrom(i iVar, q qVar) {
            return (DiscoveredCharacteristic) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static DiscoveredCharacteristic parseFrom(j jVar) {
            return (DiscoveredCharacteristic) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static DiscoveredCharacteristic parseFrom(j jVar, q qVar) {
            return (DiscoveredCharacteristic) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static DiscoveredCharacteristic parseFrom(InputStream inputStream) {
            return (DiscoveredCharacteristic) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DiscoveredCharacteristic parseFrom(InputStream inputStream, q qVar) {
            return (DiscoveredCharacteristic) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DiscoveredCharacteristic parseFrom(ByteBuffer byteBuffer) {
            return (DiscoveredCharacteristic) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DiscoveredCharacteristic parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (DiscoveredCharacteristic) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static DiscoveredCharacteristic parseFrom(byte[] bArr) {
            return (DiscoveredCharacteristic) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DiscoveredCharacteristic parseFrom(byte[] bArr, q qVar) {
            return (DiscoveredCharacteristic) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<DiscoveredCharacteristic> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setCharacteristicId(Uuid uuid) {
            uuid.getClass();
            this.characteristicId_ = uuid;
        }

        /* access modifiers changed from: private */
        public void setCharacteristicInstanceId(String str) {
            str.getClass();
            this.characteristicInstanceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setCharacteristicInstanceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.characteristicInstanceId_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setIsIndicatable(boolean z4) {
            this.isIndicatable_ = z4;
        }

        /* access modifiers changed from: private */
        public void setIsNotifiable(boolean z4) {
            this.isNotifiable_ = z4;
        }

        /* access modifiers changed from: private */
        public void setIsReadable(boolean z4) {
            this.isReadable_ = z4;
        }

        /* access modifiers changed from: private */
        public void setIsWritableWithResponse(boolean z4) {
            this.isWritableWithResponse_ = z4;
        }

        /* access modifiers changed from: private */
        public void setIsWritableWithoutResponse(boolean z4) {
            this.isWritableWithoutResponse_ = z4;
        }

        /* access modifiers changed from: private */
        public void setServiceId(Uuid uuid) {
            uuid.getClass();
            this.serviceId_ = uuid;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new DiscoveredCharacteristic();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\t\u0002\t\u0003\u0007\u0004\u0007\u0005\u0007\u0006\u0007\u0007\u0007\bȈ", new Object[]{"characteristicId_", "serviceId_", "isReadable_", "isWritableWithResponse_", "isWritableWithoutResponse_", "isNotifiable_", "isIndicatable_", "characteristicInstanceId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<DiscoveredCharacteristic> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (DiscoveredCharacteristic.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public Uuid getCharacteristicId() {
            Uuid uuid = this.characteristicId_;
            return uuid == null ? Uuid.getDefaultInstance() : uuid;
        }

        public String getCharacteristicInstanceId() {
            return this.characteristicInstanceId_;
        }

        public i getCharacteristicInstanceIdBytes() {
            return i.o(this.characteristicInstanceId_);
        }

        public boolean getIsIndicatable() {
            return this.isIndicatable_;
        }

        public boolean getIsNotifiable() {
            return this.isNotifiable_;
        }

        public boolean getIsReadable() {
            return this.isReadable_;
        }

        public boolean getIsWritableWithResponse() {
            return this.isWritableWithResponse_;
        }

        public boolean getIsWritableWithoutResponse() {
            return this.isWritableWithoutResponse_;
        }

        public Uuid getServiceId() {
            Uuid uuid = this.serviceId_;
            return uuid == null ? Uuid.getDefaultInstance() : uuid;
        }

        public boolean hasCharacteristicId() {
            return this.characteristicId_ != null;
        }

        public boolean hasServiceId() {
            return this.serviceId_ != null;
        }
    }

    public interface DiscoveredCharacteristicOrBuilder extends t0 {
        Uuid getCharacteristicId();

        String getCharacteristicInstanceId();

        i getCharacteristicInstanceIdBytes();

        /* synthetic */ s0 getDefaultInstanceForType();

        boolean getIsIndicatable();

        boolean getIsNotifiable();

        boolean getIsReadable();

        boolean getIsWritableWithResponse();

        boolean getIsWritableWithoutResponse();

        Uuid getServiceId();

        boolean hasCharacteristicId();

        boolean hasServiceId();

        /* synthetic */ boolean isInitialized();
    }

    public static final class DiscoveredService extends z<DiscoveredService, Builder> implements DiscoveredServiceOrBuilder {
        public static final int CHARACTERISTICS_FIELD_NUMBER = 4;
        public static final int CHARACTERISTICUUIDS_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final DiscoveredService DEFAULT_INSTANCE;
        public static final int INCLUDEDSERVICES_FIELD_NUMBER = 3;
        private static volatile b1<DiscoveredService> PARSER = null;
        public static final int SERVICEINSTANCEID_FIELD_NUMBER = 5;
        public static final int SERVICEUUID_FIELD_NUMBER = 1;
        private b0.i<Uuid> characteristicUuids_ = z.emptyProtobufList();
        private b0.i<DiscoveredCharacteristic> characteristics_ = z.emptyProtobufList();
        private b0.i<DiscoveredService> includedServices_ = z.emptyProtobufList();
        private String serviceInstanceId_ = BuildConfig.FLAVOR;
        private Uuid serviceUuid_;

        public static final class Builder extends z.a<DiscoveredService, Builder> implements DiscoveredServiceOrBuilder {
            private Builder() {
                super(DiscoveredService.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder addAllCharacteristicUuids(Iterable<? extends Uuid> iterable) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addAllCharacteristicUuids(iterable);
                return this;
            }

            public Builder addAllCharacteristics(Iterable<? extends DiscoveredCharacteristic> iterable) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addAllCharacteristics(iterable);
                return this;
            }

            public Builder addAllIncludedServices(Iterable<? extends DiscoveredService> iterable) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addAllIncludedServices(iterable);
                return this;
            }

            public Builder addCharacteristicUuids(int i5, Uuid.Builder builder) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addCharacteristicUuids(i5, (Uuid) builder.build());
                return this;
            }

            public Builder addCharacteristicUuids(int i5, Uuid uuid) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addCharacteristicUuids(i5, uuid);
                return this;
            }

            public Builder addCharacteristicUuids(Uuid.Builder builder) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addCharacteristicUuids((Uuid) builder.build());
                return this;
            }

            public Builder addCharacteristicUuids(Uuid uuid) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addCharacteristicUuids(uuid);
                return this;
            }

            public Builder addCharacteristics(int i5, DiscoveredCharacteristic.Builder builder) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addCharacteristics(i5, (DiscoveredCharacteristic) builder.build());
                return this;
            }

            public Builder addCharacteristics(int i5, DiscoveredCharacteristic discoveredCharacteristic) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addCharacteristics(i5, discoveredCharacteristic);
                return this;
            }

            public Builder addCharacteristics(DiscoveredCharacteristic.Builder builder) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addCharacteristics((DiscoveredCharacteristic) builder.build());
                return this;
            }

            public Builder addCharacteristics(DiscoveredCharacteristic discoveredCharacteristic) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addCharacteristics(discoveredCharacteristic);
                return this;
            }

            public Builder addIncludedServices(int i5, Builder builder) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addIncludedServices(i5, (DiscoveredService) builder.build());
                return this;
            }

            public Builder addIncludedServices(int i5, DiscoveredService discoveredService) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addIncludedServices(i5, discoveredService);
                return this;
            }

            public Builder addIncludedServices(Builder builder) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addIncludedServices((DiscoveredService) builder.build());
                return this;
            }

            public Builder addIncludedServices(DiscoveredService discoveredService) {
                copyOnWrite();
                ((DiscoveredService) this.instance).addIncludedServices(discoveredService);
                return this;
            }

            public Builder clearCharacteristicUuids() {
                copyOnWrite();
                ((DiscoveredService) this.instance).clearCharacteristicUuids();
                return this;
            }

            public Builder clearCharacteristics() {
                copyOnWrite();
                ((DiscoveredService) this.instance).clearCharacteristics();
                return this;
            }

            public Builder clearIncludedServices() {
                copyOnWrite();
                ((DiscoveredService) this.instance).clearIncludedServices();
                return this;
            }

            public Builder clearServiceInstanceId() {
                copyOnWrite();
                ((DiscoveredService) this.instance).clearServiceInstanceId();
                return this;
            }

            public Builder clearServiceUuid() {
                copyOnWrite();
                ((DiscoveredService) this.instance).clearServiceUuid();
                return this;
            }

            public Uuid getCharacteristicUuids(int i5) {
                return ((DiscoveredService) this.instance).getCharacteristicUuids(i5);
            }

            public int getCharacteristicUuidsCount() {
                return ((DiscoveredService) this.instance).getCharacteristicUuidsCount();
            }

            public List<Uuid> getCharacteristicUuidsList() {
                return Collections.unmodifiableList(((DiscoveredService) this.instance).getCharacteristicUuidsList());
            }

            public DiscoveredCharacteristic getCharacteristics(int i5) {
                return ((DiscoveredService) this.instance).getCharacteristics(i5);
            }

            public int getCharacteristicsCount() {
                return ((DiscoveredService) this.instance).getCharacteristicsCount();
            }

            public List<DiscoveredCharacteristic> getCharacteristicsList() {
                return Collections.unmodifiableList(((DiscoveredService) this.instance).getCharacteristicsList());
            }

            public DiscoveredService getIncludedServices(int i5) {
                return ((DiscoveredService) this.instance).getIncludedServices(i5);
            }

            public int getIncludedServicesCount() {
                return ((DiscoveredService) this.instance).getIncludedServicesCount();
            }

            public List<DiscoveredService> getIncludedServicesList() {
                return Collections.unmodifiableList(((DiscoveredService) this.instance).getIncludedServicesList());
            }

            public String getServiceInstanceId() {
                return ((DiscoveredService) this.instance).getServiceInstanceId();
            }

            public i getServiceInstanceIdBytes() {
                return ((DiscoveredService) this.instance).getServiceInstanceIdBytes();
            }

            public Uuid getServiceUuid() {
                return ((DiscoveredService) this.instance).getServiceUuid();
            }

            public boolean hasServiceUuid() {
                return ((DiscoveredService) this.instance).hasServiceUuid();
            }

            public Builder mergeServiceUuid(Uuid uuid) {
                copyOnWrite();
                ((DiscoveredService) this.instance).mergeServiceUuid(uuid);
                return this;
            }

            public Builder removeCharacteristicUuids(int i5) {
                copyOnWrite();
                ((DiscoveredService) this.instance).removeCharacteristicUuids(i5);
                return this;
            }

            public Builder removeCharacteristics(int i5) {
                copyOnWrite();
                ((DiscoveredService) this.instance).removeCharacteristics(i5);
                return this;
            }

            public Builder removeIncludedServices(int i5) {
                copyOnWrite();
                ((DiscoveredService) this.instance).removeIncludedServices(i5);
                return this;
            }

            public Builder setCharacteristicUuids(int i5, Uuid.Builder builder) {
                copyOnWrite();
                ((DiscoveredService) this.instance).setCharacteristicUuids(i5, (Uuid) builder.build());
                return this;
            }

            public Builder setCharacteristicUuids(int i5, Uuid uuid) {
                copyOnWrite();
                ((DiscoveredService) this.instance).setCharacteristicUuids(i5, uuid);
                return this;
            }

            public Builder setCharacteristics(int i5, DiscoveredCharacteristic.Builder builder) {
                copyOnWrite();
                ((DiscoveredService) this.instance).setCharacteristics(i5, (DiscoveredCharacteristic) builder.build());
                return this;
            }

            public Builder setCharacteristics(int i5, DiscoveredCharacteristic discoveredCharacteristic) {
                copyOnWrite();
                ((DiscoveredService) this.instance).setCharacteristics(i5, discoveredCharacteristic);
                return this;
            }

            public Builder setIncludedServices(int i5, Builder builder) {
                copyOnWrite();
                ((DiscoveredService) this.instance).setIncludedServices(i5, (DiscoveredService) builder.build());
                return this;
            }

            public Builder setIncludedServices(int i5, DiscoveredService discoveredService) {
                copyOnWrite();
                ((DiscoveredService) this.instance).setIncludedServices(i5, discoveredService);
                return this;
            }

            public Builder setServiceInstanceId(String str) {
                copyOnWrite();
                ((DiscoveredService) this.instance).setServiceInstanceId(str);
                return this;
            }

            public Builder setServiceInstanceIdBytes(i iVar) {
                copyOnWrite();
                ((DiscoveredService) this.instance).setServiceInstanceIdBytes(iVar);
                return this;
            }

            public Builder setServiceUuid(Uuid.Builder builder) {
                copyOnWrite();
                ((DiscoveredService) this.instance).setServiceUuid((Uuid) builder.build());
                return this;
            }

            public Builder setServiceUuid(Uuid uuid) {
                copyOnWrite();
                ((DiscoveredService) this.instance).setServiceUuid(uuid);
                return this;
            }
        }

        static {
            DiscoveredService discoveredService = new DiscoveredService();
            DEFAULT_INSTANCE = discoveredService;
            z.registerDefaultInstance(DiscoveredService.class, discoveredService);
        }

        private DiscoveredService() {
        }

        /* access modifiers changed from: private */
        public void addAllCharacteristicUuids(Iterable<? extends Uuid> iterable) {
            ensureCharacteristicUuidsIsMutable();
            a.addAll(iterable, this.characteristicUuids_);
        }

        /* access modifiers changed from: private */
        public void addAllCharacteristics(Iterable<? extends DiscoveredCharacteristic> iterable) {
            ensureCharacteristicsIsMutable();
            a.addAll(iterable, this.characteristics_);
        }

        /* access modifiers changed from: private */
        public void addAllIncludedServices(Iterable<? extends DiscoveredService> iterable) {
            ensureIncludedServicesIsMutable();
            a.addAll(iterable, this.includedServices_);
        }

        /* access modifiers changed from: private */
        public void addCharacteristicUuids(int i5, Uuid uuid) {
            uuid.getClass();
            ensureCharacteristicUuidsIsMutable();
            this.characteristicUuids_.add(i5, uuid);
        }

        /* access modifiers changed from: private */
        public void addCharacteristicUuids(Uuid uuid) {
            uuid.getClass();
            ensureCharacteristicUuidsIsMutable();
            this.characteristicUuids_.add(uuid);
        }

        /* access modifiers changed from: private */
        public void addCharacteristics(int i5, DiscoveredCharacteristic discoveredCharacteristic) {
            discoveredCharacteristic.getClass();
            ensureCharacteristicsIsMutable();
            this.characteristics_.add(i5, discoveredCharacteristic);
        }

        /* access modifiers changed from: private */
        public void addCharacteristics(DiscoveredCharacteristic discoveredCharacteristic) {
            discoveredCharacteristic.getClass();
            ensureCharacteristicsIsMutable();
            this.characteristics_.add(discoveredCharacteristic);
        }

        /* access modifiers changed from: private */
        public void addIncludedServices(int i5, DiscoveredService discoveredService) {
            discoveredService.getClass();
            ensureIncludedServicesIsMutable();
            this.includedServices_.add(i5, discoveredService);
        }

        /* access modifiers changed from: private */
        public void addIncludedServices(DiscoveredService discoveredService) {
            discoveredService.getClass();
            ensureIncludedServicesIsMutable();
            this.includedServices_.add(discoveredService);
        }

        /* access modifiers changed from: private */
        public void clearCharacteristicUuids() {
            this.characteristicUuids_ = z.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearCharacteristics() {
            this.characteristics_ = z.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearIncludedServices() {
            this.includedServices_ = z.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearServiceInstanceId() {
            this.serviceInstanceId_ = getDefaultInstance().getServiceInstanceId();
        }

        /* access modifiers changed from: private */
        public void clearServiceUuid() {
            this.serviceUuid_ = null;
        }

        private void ensureCharacteristicUuidsIsMutable() {
            b0.i<Uuid> iVar = this.characteristicUuids_;
            if (!iVar.k()) {
                this.characteristicUuids_ = z.mutableCopy(iVar);
            }
        }

        private void ensureCharacteristicsIsMutable() {
            b0.i<DiscoveredCharacteristic> iVar = this.characteristics_;
            if (!iVar.k()) {
                this.characteristics_ = z.mutableCopy(iVar);
            }
        }

        private void ensureIncludedServicesIsMutable() {
            b0.i<DiscoveredService> iVar = this.includedServices_;
            if (!iVar.k()) {
                this.includedServices_ = z.mutableCopy(iVar);
            }
        }

        public static DiscoveredService getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeServiceUuid(Uuid uuid) {
            uuid.getClass();
            Uuid uuid2 = this.serviceUuid_;
            if (!(uuid2 == null || uuid2 == Uuid.getDefaultInstance())) {
                uuid = (Uuid) ((Uuid.Builder) Uuid.newBuilder(this.serviceUuid_).mergeFrom(uuid)).buildPartial();
            }
            this.serviceUuid_ = uuid;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DiscoveredService discoveredService) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(discoveredService);
        }

        public static DiscoveredService parseDelimitedFrom(InputStream inputStream) {
            return (DiscoveredService) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DiscoveredService parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (DiscoveredService) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DiscoveredService parseFrom(i iVar) {
            return (DiscoveredService) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static DiscoveredService parseFrom(i iVar, q qVar) {
            return (DiscoveredService) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static DiscoveredService parseFrom(j jVar) {
            return (DiscoveredService) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static DiscoveredService parseFrom(j jVar, q qVar) {
            return (DiscoveredService) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static DiscoveredService parseFrom(InputStream inputStream) {
            return (DiscoveredService) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DiscoveredService parseFrom(InputStream inputStream, q qVar) {
            return (DiscoveredService) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static DiscoveredService parseFrom(ByteBuffer byteBuffer) {
            return (DiscoveredService) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DiscoveredService parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (DiscoveredService) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static DiscoveredService parseFrom(byte[] bArr) {
            return (DiscoveredService) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DiscoveredService parseFrom(byte[] bArr, q qVar) {
            return (DiscoveredService) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<DiscoveredService> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void removeCharacteristicUuids(int i5) {
            ensureCharacteristicUuidsIsMutable();
            this.characteristicUuids_.remove(i5);
        }

        /* access modifiers changed from: private */
        public void removeCharacteristics(int i5) {
            ensureCharacteristicsIsMutable();
            this.characteristics_.remove(i5);
        }

        /* access modifiers changed from: private */
        public void removeIncludedServices(int i5) {
            ensureIncludedServicesIsMutable();
            this.includedServices_.remove(i5);
        }

        /* access modifiers changed from: private */
        public void setCharacteristicUuids(int i5, Uuid uuid) {
            uuid.getClass();
            ensureCharacteristicUuidsIsMutable();
            this.characteristicUuids_.set(i5, uuid);
        }

        /* access modifiers changed from: private */
        public void setCharacteristics(int i5, DiscoveredCharacteristic discoveredCharacteristic) {
            discoveredCharacteristic.getClass();
            ensureCharacteristicsIsMutable();
            this.characteristics_.set(i5, discoveredCharacteristic);
        }

        /* access modifiers changed from: private */
        public void setIncludedServices(int i5, DiscoveredService discoveredService) {
            discoveredService.getClass();
            ensureIncludedServicesIsMutable();
            this.includedServices_.set(i5, discoveredService);
        }

        /* access modifiers changed from: private */
        public void setServiceInstanceId(String str) {
            str.getClass();
            this.serviceInstanceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setServiceInstanceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.serviceInstanceId_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setServiceUuid(Uuid uuid) {
            uuid.getClass();
            this.serviceUuid_ = uuid;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            Class<DiscoveredService> cls = DiscoveredService.class;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new DiscoveredService();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0003\u0000\u0001\t\u0002\u001b\u0003\u001b\u0004\u001b\u0005Ȉ", new Object[]{"serviceUuid_", "characteristicUuids_", Uuid.class, "includedServices_", cls, "characteristics_", DiscoveredCharacteristic.class, "serviceInstanceId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<DiscoveredService> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (cls) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public Uuid getCharacteristicUuids(int i5) {
            return this.characteristicUuids_.get(i5);
        }

        public int getCharacteristicUuidsCount() {
            return this.characteristicUuids_.size();
        }

        public List<Uuid> getCharacteristicUuidsList() {
            return this.characteristicUuids_;
        }

        public UuidOrBuilder getCharacteristicUuidsOrBuilder(int i5) {
            return this.characteristicUuids_.get(i5);
        }

        public List<? extends UuidOrBuilder> getCharacteristicUuidsOrBuilderList() {
            return this.characteristicUuids_;
        }

        public DiscoveredCharacteristic getCharacteristics(int i5) {
            return this.characteristics_.get(i5);
        }

        public int getCharacteristicsCount() {
            return this.characteristics_.size();
        }

        public List<DiscoveredCharacteristic> getCharacteristicsList() {
            return this.characteristics_;
        }

        public DiscoveredCharacteristicOrBuilder getCharacteristicsOrBuilder(int i5) {
            return this.characteristics_.get(i5);
        }

        public List<? extends DiscoveredCharacteristicOrBuilder> getCharacteristicsOrBuilderList() {
            return this.characteristics_;
        }

        public DiscoveredService getIncludedServices(int i5) {
            return this.includedServices_.get(i5);
        }

        public int getIncludedServicesCount() {
            return this.includedServices_.size();
        }

        public List<DiscoveredService> getIncludedServicesList() {
            return this.includedServices_;
        }

        public DiscoveredServiceOrBuilder getIncludedServicesOrBuilder(int i5) {
            return this.includedServices_.get(i5);
        }

        public List<? extends DiscoveredServiceOrBuilder> getIncludedServicesOrBuilderList() {
            return this.includedServices_;
        }

        public String getServiceInstanceId() {
            return this.serviceInstanceId_;
        }

        public i getServiceInstanceIdBytes() {
            return i.o(this.serviceInstanceId_);
        }

        public Uuid getServiceUuid() {
            Uuid uuid = this.serviceUuid_;
            return uuid == null ? Uuid.getDefaultInstance() : uuid;
        }

        public boolean hasServiceUuid() {
            return this.serviceUuid_ != null;
        }
    }

    public interface DiscoveredServiceOrBuilder extends t0 {
        Uuid getCharacteristicUuids(int i5);

        int getCharacteristicUuidsCount();

        List<Uuid> getCharacteristicUuidsList();

        DiscoveredCharacteristic getCharacteristics(int i5);

        int getCharacteristicsCount();

        List<DiscoveredCharacteristic> getCharacteristicsList();

        /* synthetic */ s0 getDefaultInstanceForType();

        DiscoveredService getIncludedServices(int i5);

        int getIncludedServicesCount();

        List<DiscoveredService> getIncludedServicesList();

        String getServiceInstanceId();

        i getServiceInstanceIdBytes();

        Uuid getServiceUuid();

        boolean hasServiceUuid();

        /* synthetic */ boolean isInitialized();
    }

    public static final class GenericFailure extends z<GenericFailure, Builder> implements GenericFailureOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final GenericFailure DEFAULT_INSTANCE;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        private static volatile b1<GenericFailure> PARSER;
        private int code_;
        private String message_ = BuildConfig.FLAVOR;

        public static final class Builder extends z.a<GenericFailure, Builder> implements GenericFailureOrBuilder {
            private Builder() {
                super(GenericFailure.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearCode() {
                copyOnWrite();
                ((GenericFailure) this.instance).clearCode();
                return this;
            }

            public Builder clearMessage() {
                copyOnWrite();
                ((GenericFailure) this.instance).clearMessage();
                return this;
            }

            public int getCode() {
                return ((GenericFailure) this.instance).getCode();
            }

            public String getMessage() {
                return ((GenericFailure) this.instance).getMessage();
            }

            public i getMessageBytes() {
                return ((GenericFailure) this.instance).getMessageBytes();
            }

            public Builder setCode(int i5) {
                copyOnWrite();
                ((GenericFailure) this.instance).setCode(i5);
                return this;
            }

            public Builder setMessage(String str) {
                copyOnWrite();
                ((GenericFailure) this.instance).setMessage(str);
                return this;
            }

            public Builder setMessageBytes(i iVar) {
                copyOnWrite();
                ((GenericFailure) this.instance).setMessageBytes(iVar);
                return this;
            }
        }

        static {
            GenericFailure genericFailure = new GenericFailure();
            DEFAULT_INSTANCE = genericFailure;
            z.registerDefaultInstance(GenericFailure.class, genericFailure);
        }

        private GenericFailure() {
        }

        /* access modifiers changed from: private */
        public void clearCode() {
            this.code_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearMessage() {
            this.message_ = getDefaultInstance().getMessage();
        }

        public static GenericFailure getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GenericFailure genericFailure) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(genericFailure);
        }

        public static GenericFailure parseDelimitedFrom(InputStream inputStream) {
            return (GenericFailure) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GenericFailure parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (GenericFailure) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static GenericFailure parseFrom(i iVar) {
            return (GenericFailure) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static GenericFailure parseFrom(i iVar, q qVar) {
            return (GenericFailure) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static GenericFailure parseFrom(j jVar) {
            return (GenericFailure) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static GenericFailure parseFrom(j jVar, q qVar) {
            return (GenericFailure) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static GenericFailure parseFrom(InputStream inputStream) {
            return (GenericFailure) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GenericFailure parseFrom(InputStream inputStream, q qVar) {
            return (GenericFailure) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static GenericFailure parseFrom(ByteBuffer byteBuffer) {
            return (GenericFailure) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static GenericFailure parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (GenericFailure) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static GenericFailure parseFrom(byte[] bArr) {
            return (GenericFailure) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GenericFailure parseFrom(byte[] bArr, q qVar) {
            return (GenericFailure) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<GenericFailure> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setCode(int i5) {
            this.code_ = i5;
        }

        /* access modifiers changed from: private */
        public void setMessage(String str) {
            str.getClass();
            this.message_ = str;
        }

        /* access modifiers changed from: private */
        public void setMessageBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.message_ = iVar.C();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new GenericFailure();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"code_", "message_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<GenericFailure> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (GenericFailure.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public int getCode() {
            return this.code_;
        }

        public String getMessage() {
            return this.message_;
        }

        public i getMessageBytes() {
            return i.o(this.message_);
        }
    }

    public interface GenericFailureOrBuilder extends t0 {
        int getCode();

        /* synthetic */ s0 getDefaultInstanceForType();

        String getMessage();

        i getMessageBytes();

        /* synthetic */ boolean isInitialized();
    }

    public static final class IsConnectable extends z<IsConnectable, Builder> implements IsConnectableOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final IsConnectable DEFAULT_INSTANCE;
        private static volatile b1<IsConnectable> PARSER;
        private int code_;

        public static final class Builder extends z.a<IsConnectable, Builder> implements IsConnectableOrBuilder {
            private Builder() {
                super(IsConnectable.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearCode() {
                copyOnWrite();
                ((IsConnectable) this.instance).clearCode();
                return this;
            }

            public int getCode() {
                return ((IsConnectable) this.instance).getCode();
            }

            public Builder setCode(int i5) {
                copyOnWrite();
                ((IsConnectable) this.instance).setCode(i5);
                return this;
            }
        }

        static {
            IsConnectable isConnectable = new IsConnectable();
            DEFAULT_INSTANCE = isConnectable;
            z.registerDefaultInstance(IsConnectable.class, isConnectable);
        }

        private IsConnectable() {
        }

        /* access modifiers changed from: private */
        public void clearCode() {
            this.code_ = 0;
        }

        public static IsConnectable getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(IsConnectable isConnectable) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(isConnectable);
        }

        public static IsConnectable parseDelimitedFrom(InputStream inputStream) {
            return (IsConnectable) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IsConnectable parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (IsConnectable) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static IsConnectable parseFrom(i iVar) {
            return (IsConnectable) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static IsConnectable parseFrom(i iVar, q qVar) {
            return (IsConnectable) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static IsConnectable parseFrom(j jVar) {
            return (IsConnectable) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static IsConnectable parseFrom(j jVar, q qVar) {
            return (IsConnectable) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static IsConnectable parseFrom(InputStream inputStream) {
            return (IsConnectable) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IsConnectable parseFrom(InputStream inputStream, q qVar) {
            return (IsConnectable) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static IsConnectable parseFrom(ByteBuffer byteBuffer) {
            return (IsConnectable) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static IsConnectable parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (IsConnectable) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static IsConnectable parseFrom(byte[] bArr) {
            return (IsConnectable) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IsConnectable parseFrom(byte[] bArr, q qVar) {
            return (IsConnectable) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<IsConnectable> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setCode(int i5) {
            this.code_ = i5;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new IsConnectable();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"code_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<IsConnectable> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (IsConnectable.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public int getCode() {
            return this.code_;
        }
    }

    public interface IsConnectableOrBuilder extends t0 {
        int getCode();

        /* synthetic */ s0 getDefaultInstanceForType();

        /* synthetic */ boolean isInitialized();
    }

    public static final class NegotiateMtuInfo extends z<NegotiateMtuInfo, Builder> implements NegotiateMtuInfoOrBuilder {
        /* access modifiers changed from: private */
        public static final NegotiateMtuInfo DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 1;
        public static final int FAILURE_FIELD_NUMBER = 3;
        public static final int MTUSIZE_FIELD_NUMBER = 2;
        private static volatile b1<NegotiateMtuInfo> PARSER;
        private String deviceId_ = BuildConfig.FLAVOR;
        private GenericFailure failure_;
        private int mtuSize_;

        public static final class Builder extends z.a<NegotiateMtuInfo, Builder> implements NegotiateMtuInfoOrBuilder {
            private Builder() {
                super(NegotiateMtuInfo.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((NegotiateMtuInfo) this.instance).clearDeviceId();
                return this;
            }

            public Builder clearFailure() {
                copyOnWrite();
                ((NegotiateMtuInfo) this.instance).clearFailure();
                return this;
            }

            public Builder clearMtuSize() {
                copyOnWrite();
                ((NegotiateMtuInfo) this.instance).clearMtuSize();
                return this;
            }

            public String getDeviceId() {
                return ((NegotiateMtuInfo) this.instance).getDeviceId();
            }

            public i getDeviceIdBytes() {
                return ((NegotiateMtuInfo) this.instance).getDeviceIdBytes();
            }

            public GenericFailure getFailure() {
                return ((NegotiateMtuInfo) this.instance).getFailure();
            }

            public int getMtuSize() {
                return ((NegotiateMtuInfo) this.instance).getMtuSize();
            }

            public boolean hasFailure() {
                return ((NegotiateMtuInfo) this.instance).hasFailure();
            }

            public Builder mergeFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((NegotiateMtuInfo) this.instance).mergeFailure(genericFailure);
                return this;
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((NegotiateMtuInfo) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(i iVar) {
                copyOnWrite();
                ((NegotiateMtuInfo) this.instance).setDeviceIdBytes(iVar);
                return this;
            }

            public Builder setFailure(GenericFailure.Builder builder) {
                copyOnWrite();
                ((NegotiateMtuInfo) this.instance).setFailure((GenericFailure) builder.build());
                return this;
            }

            public Builder setFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((NegotiateMtuInfo) this.instance).setFailure(genericFailure);
                return this;
            }

            public Builder setMtuSize(int i5) {
                copyOnWrite();
                ((NegotiateMtuInfo) this.instance).setMtuSize(i5);
                return this;
            }
        }

        static {
            NegotiateMtuInfo negotiateMtuInfo = new NegotiateMtuInfo();
            DEFAULT_INSTANCE = negotiateMtuInfo;
            z.registerDefaultInstance(NegotiateMtuInfo.class, negotiateMtuInfo);
        }

        private NegotiateMtuInfo() {
        }

        /* access modifiers changed from: private */
        public void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        /* access modifiers changed from: private */
        public void clearFailure() {
            this.failure_ = null;
        }

        /* access modifiers changed from: private */
        public void clearMtuSize() {
            this.mtuSize_ = 0;
        }

        public static NegotiateMtuInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            GenericFailure genericFailure2 = this.failure_;
            if (!(genericFailure2 == null || genericFailure2 == GenericFailure.getDefaultInstance())) {
                genericFailure = (GenericFailure) ((GenericFailure.Builder) GenericFailure.newBuilder(this.failure_).mergeFrom(genericFailure)).buildPartial();
            }
            this.failure_ = genericFailure;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(NegotiateMtuInfo negotiateMtuInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(negotiateMtuInfo);
        }

        public static NegotiateMtuInfo parseDelimitedFrom(InputStream inputStream) {
            return (NegotiateMtuInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static NegotiateMtuInfo parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (NegotiateMtuInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static NegotiateMtuInfo parseFrom(i iVar) {
            return (NegotiateMtuInfo) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static NegotiateMtuInfo parseFrom(i iVar, q qVar) {
            return (NegotiateMtuInfo) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static NegotiateMtuInfo parseFrom(j jVar) {
            return (NegotiateMtuInfo) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static NegotiateMtuInfo parseFrom(j jVar, q qVar) {
            return (NegotiateMtuInfo) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static NegotiateMtuInfo parseFrom(InputStream inputStream) {
            return (NegotiateMtuInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static NegotiateMtuInfo parseFrom(InputStream inputStream, q qVar) {
            return (NegotiateMtuInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static NegotiateMtuInfo parseFrom(ByteBuffer byteBuffer) {
            return (NegotiateMtuInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static NegotiateMtuInfo parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (NegotiateMtuInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static NegotiateMtuInfo parseFrom(byte[] bArr) {
            return (NegotiateMtuInfo) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static NegotiateMtuInfo parseFrom(byte[] bArr, q qVar) {
            return (NegotiateMtuInfo) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<NegotiateMtuInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setDeviceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.deviceId_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            this.failure_ = genericFailure;
        }

        /* access modifiers changed from: private */
        public void setMtuSize(int i5) {
            this.mtuSize_ = i5;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new NegotiateMtuInfo();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\t", new Object[]{"deviceId_", "mtuSize_", "failure_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<NegotiateMtuInfo> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (NegotiateMtuInfo.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public String getDeviceId() {
            return this.deviceId_;
        }

        public i getDeviceIdBytes() {
            return i.o(this.deviceId_);
        }

        public GenericFailure getFailure() {
            GenericFailure genericFailure = this.failure_;
            return genericFailure == null ? GenericFailure.getDefaultInstance() : genericFailure;
        }

        public int getMtuSize() {
            return this.mtuSize_;
        }

        public boolean hasFailure() {
            return this.failure_ != null;
        }
    }

    public interface NegotiateMtuInfoOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        String getDeviceId();

        i getDeviceIdBytes();

        GenericFailure getFailure();

        int getMtuSize();

        boolean hasFailure();

        /* synthetic */ boolean isInitialized();
    }

    public static final class NegotiateMtuRequest extends z<NegotiateMtuRequest, Builder> implements NegotiateMtuRequestOrBuilder {
        /* access modifiers changed from: private */
        public static final NegotiateMtuRequest DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 1;
        public static final int MTUSIZE_FIELD_NUMBER = 2;
        private static volatile b1<NegotiateMtuRequest> PARSER;
        private String deviceId_ = BuildConfig.FLAVOR;
        private int mtuSize_;

        public static final class Builder extends z.a<NegotiateMtuRequest, Builder> implements NegotiateMtuRequestOrBuilder {
            private Builder() {
                super(NegotiateMtuRequest.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((NegotiateMtuRequest) this.instance).clearDeviceId();
                return this;
            }

            public Builder clearMtuSize() {
                copyOnWrite();
                ((NegotiateMtuRequest) this.instance).clearMtuSize();
                return this;
            }

            public String getDeviceId() {
                return ((NegotiateMtuRequest) this.instance).getDeviceId();
            }

            public i getDeviceIdBytes() {
                return ((NegotiateMtuRequest) this.instance).getDeviceIdBytes();
            }

            public int getMtuSize() {
                return ((NegotiateMtuRequest) this.instance).getMtuSize();
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((NegotiateMtuRequest) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(i iVar) {
                copyOnWrite();
                ((NegotiateMtuRequest) this.instance).setDeviceIdBytes(iVar);
                return this;
            }

            public Builder setMtuSize(int i5) {
                copyOnWrite();
                ((NegotiateMtuRequest) this.instance).setMtuSize(i5);
                return this;
            }
        }

        static {
            NegotiateMtuRequest negotiateMtuRequest = new NegotiateMtuRequest();
            DEFAULT_INSTANCE = negotiateMtuRequest;
            z.registerDefaultInstance(NegotiateMtuRequest.class, negotiateMtuRequest);
        }

        private NegotiateMtuRequest() {
        }

        /* access modifiers changed from: private */
        public void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        /* access modifiers changed from: private */
        public void clearMtuSize() {
            this.mtuSize_ = 0;
        }

        public static NegotiateMtuRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(NegotiateMtuRequest negotiateMtuRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(negotiateMtuRequest);
        }

        public static NegotiateMtuRequest parseDelimitedFrom(InputStream inputStream) {
            return (NegotiateMtuRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static NegotiateMtuRequest parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (NegotiateMtuRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static NegotiateMtuRequest parseFrom(i iVar) {
            return (NegotiateMtuRequest) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static NegotiateMtuRequest parseFrom(i iVar, q qVar) {
            return (NegotiateMtuRequest) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static NegotiateMtuRequest parseFrom(j jVar) {
            return (NegotiateMtuRequest) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static NegotiateMtuRequest parseFrom(j jVar, q qVar) {
            return (NegotiateMtuRequest) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static NegotiateMtuRequest parseFrom(InputStream inputStream) {
            return (NegotiateMtuRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static NegotiateMtuRequest parseFrom(InputStream inputStream, q qVar) {
            return (NegotiateMtuRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static NegotiateMtuRequest parseFrom(ByteBuffer byteBuffer) {
            return (NegotiateMtuRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static NegotiateMtuRequest parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (NegotiateMtuRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static NegotiateMtuRequest parseFrom(byte[] bArr) {
            return (NegotiateMtuRequest) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static NegotiateMtuRequest parseFrom(byte[] bArr, q qVar) {
            return (NegotiateMtuRequest) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<NegotiateMtuRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        /* access modifiers changed from: private */
        public void setDeviceIdBytes(i iVar) {
            a.checkByteStringIsUtf8(iVar);
            this.deviceId_ = iVar.C();
        }

        /* access modifiers changed from: private */
        public void setMtuSize(int i5) {
            this.mtuSize_ = i5;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new NegotiateMtuRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0004", new Object[]{"deviceId_", "mtuSize_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<NegotiateMtuRequest> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (NegotiateMtuRequest.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public String getDeviceId() {
            return this.deviceId_;
        }

        public i getDeviceIdBytes() {
            return i.o(this.deviceId_);
        }

        public int getMtuSize() {
            return this.mtuSize_;
        }
    }

    public interface NegotiateMtuRequestOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        String getDeviceId();

        i getDeviceIdBytes();

        int getMtuSize();

        /* synthetic */ boolean isInitialized();
    }

    public static final class NotifyCharacteristicRequest extends z<NotifyCharacteristicRequest, Builder> implements NotifyCharacteristicRequestOrBuilder {
        public static final int CHARACTERISTIC_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final NotifyCharacteristicRequest DEFAULT_INSTANCE;
        private static volatile b1<NotifyCharacteristicRequest> PARSER;
        private CharacteristicAddress characteristic_;

        public static final class Builder extends z.a<NotifyCharacteristicRequest, Builder> implements NotifyCharacteristicRequestOrBuilder {
            private Builder() {
                super(NotifyCharacteristicRequest.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearCharacteristic() {
                copyOnWrite();
                ((NotifyCharacteristicRequest) this.instance).clearCharacteristic();
                return this;
            }

            public CharacteristicAddress getCharacteristic() {
                return ((NotifyCharacteristicRequest) this.instance).getCharacteristic();
            }

            public boolean hasCharacteristic() {
                return ((NotifyCharacteristicRequest) this.instance).hasCharacteristic();
            }

            public Builder mergeCharacteristic(CharacteristicAddress characteristicAddress) {
                copyOnWrite();
                ((NotifyCharacteristicRequest) this.instance).mergeCharacteristic(characteristicAddress);
                return this;
            }

            public Builder setCharacteristic(CharacteristicAddress.Builder builder) {
                copyOnWrite();
                ((NotifyCharacteristicRequest) this.instance).setCharacteristic((CharacteristicAddress) builder.build());
                return this;
            }

            public Builder setCharacteristic(CharacteristicAddress characteristicAddress) {
                copyOnWrite();
                ((NotifyCharacteristicRequest) this.instance).setCharacteristic(characteristicAddress);
                return this;
            }
        }

        static {
            NotifyCharacteristicRequest notifyCharacteristicRequest = new NotifyCharacteristicRequest();
            DEFAULT_INSTANCE = notifyCharacteristicRequest;
            z.registerDefaultInstance(NotifyCharacteristicRequest.class, notifyCharacteristicRequest);
        }

        private NotifyCharacteristicRequest() {
        }

        /* access modifiers changed from: private */
        public void clearCharacteristic() {
            this.characteristic_ = null;
        }

        public static NotifyCharacteristicRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeCharacteristic(CharacteristicAddress characteristicAddress) {
            characteristicAddress.getClass();
            CharacteristicAddress characteristicAddress2 = this.characteristic_;
            if (!(characteristicAddress2 == null || characteristicAddress2 == CharacteristicAddress.getDefaultInstance())) {
                characteristicAddress = (CharacteristicAddress) ((CharacteristicAddress.Builder) CharacteristicAddress.newBuilder(this.characteristic_).mergeFrom(characteristicAddress)).buildPartial();
            }
            this.characteristic_ = characteristicAddress;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(NotifyCharacteristicRequest notifyCharacteristicRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(notifyCharacteristicRequest);
        }

        public static NotifyCharacteristicRequest parseDelimitedFrom(InputStream inputStream) {
            return (NotifyCharacteristicRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static NotifyCharacteristicRequest parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (NotifyCharacteristicRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static NotifyCharacteristicRequest parseFrom(i iVar) {
            return (NotifyCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static NotifyCharacteristicRequest parseFrom(i iVar, q qVar) {
            return (NotifyCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static NotifyCharacteristicRequest parseFrom(j jVar) {
            return (NotifyCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static NotifyCharacteristicRequest parseFrom(j jVar, q qVar) {
            return (NotifyCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static NotifyCharacteristicRequest parseFrom(InputStream inputStream) {
            return (NotifyCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static NotifyCharacteristicRequest parseFrom(InputStream inputStream, q qVar) {
            return (NotifyCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static NotifyCharacteristicRequest parseFrom(ByteBuffer byteBuffer) {
            return (NotifyCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static NotifyCharacteristicRequest parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (NotifyCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static NotifyCharacteristicRequest parseFrom(byte[] bArr) {
            return (NotifyCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static NotifyCharacteristicRequest parseFrom(byte[] bArr, q qVar) {
            return (NotifyCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<NotifyCharacteristicRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setCharacteristic(CharacteristicAddress characteristicAddress) {
            characteristicAddress.getClass();
            this.characteristic_ = characteristicAddress;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new NotifyCharacteristicRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"characteristic_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<NotifyCharacteristicRequest> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (NotifyCharacteristicRequest.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public CharacteristicAddress getCharacteristic() {
            CharacteristicAddress characteristicAddress = this.characteristic_;
            return characteristicAddress == null ? CharacteristicAddress.getDefaultInstance() : characteristicAddress;
        }

        public boolean hasCharacteristic() {
            return this.characteristic_ != null;
        }
    }

    public interface NotifyCharacteristicRequestOrBuilder extends t0 {
        CharacteristicAddress getCharacteristic();

        /* synthetic */ s0 getDefaultInstanceForType();

        boolean hasCharacteristic();

        /* synthetic */ boolean isInitialized();
    }

    public static final class NotifyNoMoreCharacteristicRequest extends z<NotifyNoMoreCharacteristicRequest, Builder> implements NotifyNoMoreCharacteristicRequestOrBuilder {
        public static final int CHARACTERISTIC_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final NotifyNoMoreCharacteristicRequest DEFAULT_INSTANCE;
        private static volatile b1<NotifyNoMoreCharacteristicRequest> PARSER;
        private CharacteristicAddress characteristic_;

        public static final class Builder extends z.a<NotifyNoMoreCharacteristicRequest, Builder> implements NotifyNoMoreCharacteristicRequestOrBuilder {
            private Builder() {
                super(NotifyNoMoreCharacteristicRequest.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearCharacteristic() {
                copyOnWrite();
                ((NotifyNoMoreCharacteristicRequest) this.instance).clearCharacteristic();
                return this;
            }

            public CharacteristicAddress getCharacteristic() {
                return ((NotifyNoMoreCharacteristicRequest) this.instance).getCharacteristic();
            }

            public boolean hasCharacteristic() {
                return ((NotifyNoMoreCharacteristicRequest) this.instance).hasCharacteristic();
            }

            public Builder mergeCharacteristic(CharacteristicAddress characteristicAddress) {
                copyOnWrite();
                ((NotifyNoMoreCharacteristicRequest) this.instance).mergeCharacteristic(characteristicAddress);
                return this;
            }

            public Builder setCharacteristic(CharacteristicAddress.Builder builder) {
                copyOnWrite();
                ((NotifyNoMoreCharacteristicRequest) this.instance).setCharacteristic((CharacteristicAddress) builder.build());
                return this;
            }

            public Builder setCharacteristic(CharacteristicAddress characteristicAddress) {
                copyOnWrite();
                ((NotifyNoMoreCharacteristicRequest) this.instance).setCharacteristic(characteristicAddress);
                return this;
            }
        }

        static {
            NotifyNoMoreCharacteristicRequest notifyNoMoreCharacteristicRequest = new NotifyNoMoreCharacteristicRequest();
            DEFAULT_INSTANCE = notifyNoMoreCharacteristicRequest;
            z.registerDefaultInstance(NotifyNoMoreCharacteristicRequest.class, notifyNoMoreCharacteristicRequest);
        }

        private NotifyNoMoreCharacteristicRequest() {
        }

        /* access modifiers changed from: private */
        public void clearCharacteristic() {
            this.characteristic_ = null;
        }

        public static NotifyNoMoreCharacteristicRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeCharacteristic(CharacteristicAddress characteristicAddress) {
            characteristicAddress.getClass();
            CharacteristicAddress characteristicAddress2 = this.characteristic_;
            if (!(characteristicAddress2 == null || characteristicAddress2 == CharacteristicAddress.getDefaultInstance())) {
                characteristicAddress = (CharacteristicAddress) ((CharacteristicAddress.Builder) CharacteristicAddress.newBuilder(this.characteristic_).mergeFrom(characteristicAddress)).buildPartial();
            }
            this.characteristic_ = characteristicAddress;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(NotifyNoMoreCharacteristicRequest notifyNoMoreCharacteristicRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(notifyNoMoreCharacteristicRequest);
        }

        public static NotifyNoMoreCharacteristicRequest parseDelimitedFrom(InputStream inputStream) {
            return (NotifyNoMoreCharacteristicRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static NotifyNoMoreCharacteristicRequest parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (NotifyNoMoreCharacteristicRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static NotifyNoMoreCharacteristicRequest parseFrom(i iVar) {
            return (NotifyNoMoreCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static NotifyNoMoreCharacteristicRequest parseFrom(i iVar, q qVar) {
            return (NotifyNoMoreCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static NotifyNoMoreCharacteristicRequest parseFrom(j jVar) {
            return (NotifyNoMoreCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static NotifyNoMoreCharacteristicRequest parseFrom(j jVar, q qVar) {
            return (NotifyNoMoreCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static NotifyNoMoreCharacteristicRequest parseFrom(InputStream inputStream) {
            return (NotifyNoMoreCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static NotifyNoMoreCharacteristicRequest parseFrom(InputStream inputStream, q qVar) {
            return (NotifyNoMoreCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static NotifyNoMoreCharacteristicRequest parseFrom(ByteBuffer byteBuffer) {
            return (NotifyNoMoreCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static NotifyNoMoreCharacteristicRequest parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (NotifyNoMoreCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static NotifyNoMoreCharacteristicRequest parseFrom(byte[] bArr) {
            return (NotifyNoMoreCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static NotifyNoMoreCharacteristicRequest parseFrom(byte[] bArr, q qVar) {
            return (NotifyNoMoreCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<NotifyNoMoreCharacteristicRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setCharacteristic(CharacteristicAddress characteristicAddress) {
            characteristicAddress.getClass();
            this.characteristic_ = characteristicAddress;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new NotifyNoMoreCharacteristicRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"characteristic_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<NotifyNoMoreCharacteristicRequest> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (NotifyNoMoreCharacteristicRequest.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public CharacteristicAddress getCharacteristic() {
            CharacteristicAddress characteristicAddress = this.characteristic_;
            return characteristicAddress == null ? CharacteristicAddress.getDefaultInstance() : characteristicAddress;
        }

        public boolean hasCharacteristic() {
            return this.characteristic_ != null;
        }
    }

    public interface NotifyNoMoreCharacteristicRequestOrBuilder extends t0 {
        CharacteristicAddress getCharacteristic();

        /* synthetic */ s0 getDefaultInstanceForType();

        boolean hasCharacteristic();

        /* synthetic */ boolean isInitialized();
    }

    public static final class ReadCharacteristicRequest extends z<ReadCharacteristicRequest, Builder> implements ReadCharacteristicRequestOrBuilder {
        public static final int CHARACTERISTIC_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final ReadCharacteristicRequest DEFAULT_INSTANCE;
        private static volatile b1<ReadCharacteristicRequest> PARSER;
        private CharacteristicAddress characteristic_;

        public static final class Builder extends z.a<ReadCharacteristicRequest, Builder> implements ReadCharacteristicRequestOrBuilder {
            private Builder() {
                super(ReadCharacteristicRequest.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearCharacteristic() {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).clearCharacteristic();
                return this;
            }

            public CharacteristicAddress getCharacteristic() {
                return ((ReadCharacteristicRequest) this.instance).getCharacteristic();
            }

            public boolean hasCharacteristic() {
                return ((ReadCharacteristicRequest) this.instance).hasCharacteristic();
            }

            public Builder mergeCharacteristic(CharacteristicAddress characteristicAddress) {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).mergeCharacteristic(characteristicAddress);
                return this;
            }

            public Builder setCharacteristic(CharacteristicAddress.Builder builder) {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).setCharacteristic((CharacteristicAddress) builder.build());
                return this;
            }

            public Builder setCharacteristic(CharacteristicAddress characteristicAddress) {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).setCharacteristic(characteristicAddress);
                return this;
            }
        }

        static {
            ReadCharacteristicRequest readCharacteristicRequest = new ReadCharacteristicRequest();
            DEFAULT_INSTANCE = readCharacteristicRequest;
            z.registerDefaultInstance(ReadCharacteristicRequest.class, readCharacteristicRequest);
        }

        private ReadCharacteristicRequest() {
        }

        /* access modifiers changed from: private */
        public void clearCharacteristic() {
            this.characteristic_ = null;
        }

        public static ReadCharacteristicRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeCharacteristic(CharacteristicAddress characteristicAddress) {
            characteristicAddress.getClass();
            CharacteristicAddress characteristicAddress2 = this.characteristic_;
            if (!(characteristicAddress2 == null || characteristicAddress2 == CharacteristicAddress.getDefaultInstance())) {
                characteristicAddress = (CharacteristicAddress) ((CharacteristicAddress.Builder) CharacteristicAddress.newBuilder(this.characteristic_).mergeFrom(characteristicAddress)).buildPartial();
            }
            this.characteristic_ = characteristicAddress;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadCharacteristicRequest readCharacteristicRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(readCharacteristicRequest);
        }

        public static ReadCharacteristicRequest parseDelimitedFrom(InputStream inputStream) {
            return (ReadCharacteristicRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadCharacteristicRequest parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (ReadCharacteristicRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ReadCharacteristicRequest parseFrom(i iVar) {
            return (ReadCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static ReadCharacteristicRequest parseFrom(i iVar, q qVar) {
            return (ReadCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static ReadCharacteristicRequest parseFrom(j jVar) {
            return (ReadCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static ReadCharacteristicRequest parseFrom(j jVar, q qVar) {
            return (ReadCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static ReadCharacteristicRequest parseFrom(InputStream inputStream) {
            return (ReadCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadCharacteristicRequest parseFrom(InputStream inputStream, q qVar) {
            return (ReadCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ReadCharacteristicRequest parseFrom(ByteBuffer byteBuffer) {
            return (ReadCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadCharacteristicRequest parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (ReadCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static ReadCharacteristicRequest parseFrom(byte[] bArr) {
            return (ReadCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadCharacteristicRequest parseFrom(byte[] bArr, q qVar) {
            return (ReadCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<ReadCharacteristicRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setCharacteristic(CharacteristicAddress characteristicAddress) {
            characteristicAddress.getClass();
            this.characteristic_ = characteristicAddress;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new ReadCharacteristicRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"characteristic_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<ReadCharacteristicRequest> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (ReadCharacteristicRequest.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public CharacteristicAddress getCharacteristic() {
            CharacteristicAddress characteristicAddress = this.characteristic_;
            return characteristicAddress == null ? CharacteristicAddress.getDefaultInstance() : characteristicAddress;
        }

        public boolean hasCharacteristic() {
            return this.characteristic_ != null;
        }
    }

    public interface ReadCharacteristicRequestOrBuilder extends t0 {
        CharacteristicAddress getCharacteristic();

        /* synthetic */ s0 getDefaultInstanceForType();

        boolean hasCharacteristic();

        /* synthetic */ boolean isInitialized();
    }

    public static final class ScanForDevicesRequest extends z<ScanForDevicesRequest, Builder> implements ScanForDevicesRequestOrBuilder {
        /* access modifiers changed from: private */
        public static final ScanForDevicesRequest DEFAULT_INSTANCE;
        private static volatile b1<ScanForDevicesRequest> PARSER = null;
        public static final int REQUIRELOCATIONSERVICESENABLED_FIELD_NUMBER = 3;
        public static final int SCANMODE_FIELD_NUMBER = 2;
        public static final int SERVICEUUIDS_FIELD_NUMBER = 1;
        private boolean requireLocationServicesEnabled_;
        private int scanMode_;
        private b0.i<Uuid> serviceUuids_ = z.emptyProtobufList();

        public static final class Builder extends z.a<ScanForDevicesRequest, Builder> implements ScanForDevicesRequestOrBuilder {
            private Builder() {
                super(ScanForDevicesRequest.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder addAllServiceUuids(Iterable<? extends Uuid> iterable) {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).addAllServiceUuids(iterable);
                return this;
            }

            public Builder addServiceUuids(int i5, Uuid.Builder builder) {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).addServiceUuids(i5, (Uuid) builder.build());
                return this;
            }

            public Builder addServiceUuids(int i5, Uuid uuid) {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).addServiceUuids(i5, uuid);
                return this;
            }

            public Builder addServiceUuids(Uuid.Builder builder) {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).addServiceUuids((Uuid) builder.build());
                return this;
            }

            public Builder addServiceUuids(Uuid uuid) {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).addServiceUuids(uuid);
                return this;
            }

            public Builder clearRequireLocationServicesEnabled() {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).clearRequireLocationServicesEnabled();
                return this;
            }

            public Builder clearScanMode() {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).clearScanMode();
                return this;
            }

            public Builder clearServiceUuids() {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).clearServiceUuids();
                return this;
            }

            public boolean getRequireLocationServicesEnabled() {
                return ((ScanForDevicesRequest) this.instance).getRequireLocationServicesEnabled();
            }

            public int getScanMode() {
                return ((ScanForDevicesRequest) this.instance).getScanMode();
            }

            public Uuid getServiceUuids(int i5) {
                return ((ScanForDevicesRequest) this.instance).getServiceUuids(i5);
            }

            public int getServiceUuidsCount() {
                return ((ScanForDevicesRequest) this.instance).getServiceUuidsCount();
            }

            public List<Uuid> getServiceUuidsList() {
                return Collections.unmodifiableList(((ScanForDevicesRequest) this.instance).getServiceUuidsList());
            }

            public Builder removeServiceUuids(int i5) {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).removeServiceUuids(i5);
                return this;
            }

            public Builder setRequireLocationServicesEnabled(boolean z4) {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).setRequireLocationServicesEnabled(z4);
                return this;
            }

            public Builder setScanMode(int i5) {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).setScanMode(i5);
                return this;
            }

            public Builder setServiceUuids(int i5, Uuid.Builder builder) {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).setServiceUuids(i5, (Uuid) builder.build());
                return this;
            }

            public Builder setServiceUuids(int i5, Uuid uuid) {
                copyOnWrite();
                ((ScanForDevicesRequest) this.instance).setServiceUuids(i5, uuid);
                return this;
            }
        }

        static {
            ScanForDevicesRequest scanForDevicesRequest = new ScanForDevicesRequest();
            DEFAULT_INSTANCE = scanForDevicesRequest;
            z.registerDefaultInstance(ScanForDevicesRequest.class, scanForDevicesRequest);
        }

        private ScanForDevicesRequest() {
        }

        /* access modifiers changed from: private */
        public void addAllServiceUuids(Iterable<? extends Uuid> iterable) {
            ensureServiceUuidsIsMutable();
            a.addAll(iterable, this.serviceUuids_);
        }

        /* access modifiers changed from: private */
        public void addServiceUuids(int i5, Uuid uuid) {
            uuid.getClass();
            ensureServiceUuidsIsMutable();
            this.serviceUuids_.add(i5, uuid);
        }

        /* access modifiers changed from: private */
        public void addServiceUuids(Uuid uuid) {
            uuid.getClass();
            ensureServiceUuidsIsMutable();
            this.serviceUuids_.add(uuid);
        }

        /* access modifiers changed from: private */
        public void clearRequireLocationServicesEnabled() {
            this.requireLocationServicesEnabled_ = false;
        }

        /* access modifiers changed from: private */
        public void clearScanMode() {
            this.scanMode_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearServiceUuids() {
            this.serviceUuids_ = z.emptyProtobufList();
        }

        private void ensureServiceUuidsIsMutable() {
            b0.i<Uuid> iVar = this.serviceUuids_;
            if (!iVar.k()) {
                this.serviceUuids_ = z.mutableCopy(iVar);
            }
        }

        public static ScanForDevicesRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ScanForDevicesRequest scanForDevicesRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(scanForDevicesRequest);
        }

        public static ScanForDevicesRequest parseDelimitedFrom(InputStream inputStream) {
            return (ScanForDevicesRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ScanForDevicesRequest parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (ScanForDevicesRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ScanForDevicesRequest parseFrom(i iVar) {
            return (ScanForDevicesRequest) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static ScanForDevicesRequest parseFrom(i iVar, q qVar) {
            return (ScanForDevicesRequest) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static ScanForDevicesRequest parseFrom(j jVar) {
            return (ScanForDevicesRequest) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static ScanForDevicesRequest parseFrom(j jVar, q qVar) {
            return (ScanForDevicesRequest) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static ScanForDevicesRequest parseFrom(InputStream inputStream) {
            return (ScanForDevicesRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ScanForDevicesRequest parseFrom(InputStream inputStream, q qVar) {
            return (ScanForDevicesRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ScanForDevicesRequest parseFrom(ByteBuffer byteBuffer) {
            return (ScanForDevicesRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ScanForDevicesRequest parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (ScanForDevicesRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static ScanForDevicesRequest parseFrom(byte[] bArr) {
            return (ScanForDevicesRequest) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ScanForDevicesRequest parseFrom(byte[] bArr, q qVar) {
            return (ScanForDevicesRequest) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<ScanForDevicesRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void removeServiceUuids(int i5) {
            ensureServiceUuidsIsMutable();
            this.serviceUuids_.remove(i5);
        }

        /* access modifiers changed from: private */
        public void setRequireLocationServicesEnabled(boolean z4) {
            this.requireLocationServicesEnabled_ = z4;
        }

        /* access modifiers changed from: private */
        public void setScanMode(int i5) {
            this.scanMode_ = i5;
        }

        /* access modifiers changed from: private */
        public void setServiceUuids(int i5, Uuid uuid) {
            uuid.getClass();
            ensureServiceUuidsIsMutable();
            this.serviceUuids_.set(i5, uuid);
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new ScanForDevicesRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002\u0004\u0003\u0007", new Object[]{"serviceUuids_", Uuid.class, "scanMode_", "requireLocationServicesEnabled_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<ScanForDevicesRequest> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (ScanForDevicesRequest.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public boolean getRequireLocationServicesEnabled() {
            return this.requireLocationServicesEnabled_;
        }

        public int getScanMode() {
            return this.scanMode_;
        }

        public Uuid getServiceUuids(int i5) {
            return this.serviceUuids_.get(i5);
        }

        public int getServiceUuidsCount() {
            return this.serviceUuids_.size();
        }

        public List<Uuid> getServiceUuidsList() {
            return this.serviceUuids_;
        }

        public UuidOrBuilder getServiceUuidsOrBuilder(int i5) {
            return this.serviceUuids_.get(i5);
        }

        public List<? extends UuidOrBuilder> getServiceUuidsOrBuilderList() {
            return this.serviceUuids_;
        }
    }

    public interface ScanForDevicesRequestOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        boolean getRequireLocationServicesEnabled();

        int getScanMode();

        Uuid getServiceUuids(int i5);

        int getServiceUuidsCount();

        List<Uuid> getServiceUuidsList();

        /* synthetic */ boolean isInitialized();
    }

    public static final class ServiceDataEntry extends z<ServiceDataEntry, Builder> implements ServiceDataEntryOrBuilder {
        public static final int DATA_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final ServiceDataEntry DEFAULT_INSTANCE;
        private static volatile b1<ServiceDataEntry> PARSER = null;
        public static final int SERVICEUUID_FIELD_NUMBER = 1;
        private i data_ = i.f3533f;
        private Uuid serviceUuid_;

        public static final class Builder extends z.a<ServiceDataEntry, Builder> implements ServiceDataEntryOrBuilder {
            private Builder() {
                super(ServiceDataEntry.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearData() {
                copyOnWrite();
                ((ServiceDataEntry) this.instance).clearData();
                return this;
            }

            public Builder clearServiceUuid() {
                copyOnWrite();
                ((ServiceDataEntry) this.instance).clearServiceUuid();
                return this;
            }

            public i getData() {
                return ((ServiceDataEntry) this.instance).getData();
            }

            public Uuid getServiceUuid() {
                return ((ServiceDataEntry) this.instance).getServiceUuid();
            }

            public boolean hasServiceUuid() {
                return ((ServiceDataEntry) this.instance).hasServiceUuid();
            }

            public Builder mergeServiceUuid(Uuid uuid) {
                copyOnWrite();
                ((ServiceDataEntry) this.instance).mergeServiceUuid(uuid);
                return this;
            }

            public Builder setData(i iVar) {
                copyOnWrite();
                ((ServiceDataEntry) this.instance).setData(iVar);
                return this;
            }

            public Builder setServiceUuid(Uuid.Builder builder) {
                copyOnWrite();
                ((ServiceDataEntry) this.instance).setServiceUuid((Uuid) builder.build());
                return this;
            }

            public Builder setServiceUuid(Uuid uuid) {
                copyOnWrite();
                ((ServiceDataEntry) this.instance).setServiceUuid(uuid);
                return this;
            }
        }

        static {
            ServiceDataEntry serviceDataEntry = new ServiceDataEntry();
            DEFAULT_INSTANCE = serviceDataEntry;
            z.registerDefaultInstance(ServiceDataEntry.class, serviceDataEntry);
        }

        private ServiceDataEntry() {
        }

        /* access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        /* access modifiers changed from: private */
        public void clearServiceUuid() {
            this.serviceUuid_ = null;
        }

        public static ServiceDataEntry getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeServiceUuid(Uuid uuid) {
            uuid.getClass();
            Uuid uuid2 = this.serviceUuid_;
            if (!(uuid2 == null || uuid2 == Uuid.getDefaultInstance())) {
                uuid = (Uuid) ((Uuid.Builder) Uuid.newBuilder(this.serviceUuid_).mergeFrom(uuid)).buildPartial();
            }
            this.serviceUuid_ = uuid;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ServiceDataEntry serviceDataEntry) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(serviceDataEntry);
        }

        public static ServiceDataEntry parseDelimitedFrom(InputStream inputStream) {
            return (ServiceDataEntry) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceDataEntry parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (ServiceDataEntry) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ServiceDataEntry parseFrom(i iVar) {
            return (ServiceDataEntry) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static ServiceDataEntry parseFrom(i iVar, q qVar) {
            return (ServiceDataEntry) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static ServiceDataEntry parseFrom(j jVar) {
            return (ServiceDataEntry) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static ServiceDataEntry parseFrom(j jVar, q qVar) {
            return (ServiceDataEntry) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static ServiceDataEntry parseFrom(InputStream inputStream) {
            return (ServiceDataEntry) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceDataEntry parseFrom(InputStream inputStream, q qVar) {
            return (ServiceDataEntry) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ServiceDataEntry parseFrom(ByteBuffer byteBuffer) {
            return (ServiceDataEntry) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ServiceDataEntry parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (ServiceDataEntry) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static ServiceDataEntry parseFrom(byte[] bArr) {
            return (ServiceDataEntry) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ServiceDataEntry parseFrom(byte[] bArr, q qVar) {
            return (ServiceDataEntry) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<ServiceDataEntry> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setData(i iVar) {
            iVar.getClass();
            this.data_ = iVar;
        }

        /* access modifiers changed from: private */
        public void setServiceUuid(Uuid uuid) {
            uuid.getClass();
            this.serviceUuid_ = uuid;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new ServiceDataEntry();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\n", new Object[]{"serviceUuid_", "data_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<ServiceDataEntry> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (ServiceDataEntry.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public i getData() {
            return this.data_;
        }

        public Uuid getServiceUuid() {
            Uuid uuid = this.serviceUuid_;
            return uuid == null ? Uuid.getDefaultInstance() : uuid;
        }

        public boolean hasServiceUuid() {
            return this.serviceUuid_ != null;
        }
    }

    public interface ServiceDataEntryOrBuilder extends t0 {
        i getData();

        /* synthetic */ s0 getDefaultInstanceForType();

        Uuid getServiceUuid();

        boolean hasServiceUuid();

        /* synthetic */ boolean isInitialized();
    }

    public static final class ServiceWithCharacteristics extends z<ServiceWithCharacteristics, Builder> implements ServiceWithCharacteristicsOrBuilder {
        public static final int CHARACTERISTICS_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final ServiceWithCharacteristics DEFAULT_INSTANCE;
        private static volatile b1<ServiceWithCharacteristics> PARSER = null;
        public static final int SERVICEID_FIELD_NUMBER = 1;
        private b0.i<Uuid> characteristics_ = z.emptyProtobufList();
        private Uuid serviceId_;

        public static final class Builder extends z.a<ServiceWithCharacteristics, Builder> implements ServiceWithCharacteristicsOrBuilder {
            private Builder() {
                super(ServiceWithCharacteristics.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder addAllCharacteristics(Iterable<? extends Uuid> iterable) {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).addAllCharacteristics(iterable);
                return this;
            }

            public Builder addCharacteristics(int i5, Uuid.Builder builder) {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).addCharacteristics(i5, (Uuid) builder.build());
                return this;
            }

            public Builder addCharacteristics(int i5, Uuid uuid) {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).addCharacteristics(i5, uuid);
                return this;
            }

            public Builder addCharacteristics(Uuid.Builder builder) {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).addCharacteristics((Uuid) builder.build());
                return this;
            }

            public Builder addCharacteristics(Uuid uuid) {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).addCharacteristics(uuid);
                return this;
            }

            public Builder clearCharacteristics() {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).clearCharacteristics();
                return this;
            }

            public Builder clearServiceId() {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).clearServiceId();
                return this;
            }

            public Uuid getCharacteristics(int i5) {
                return ((ServiceWithCharacteristics) this.instance).getCharacteristics(i5);
            }

            public int getCharacteristicsCount() {
                return ((ServiceWithCharacteristics) this.instance).getCharacteristicsCount();
            }

            public List<Uuid> getCharacteristicsList() {
                return Collections.unmodifiableList(((ServiceWithCharacteristics) this.instance).getCharacteristicsList());
            }

            public Uuid getServiceId() {
                return ((ServiceWithCharacteristics) this.instance).getServiceId();
            }

            public boolean hasServiceId() {
                return ((ServiceWithCharacteristics) this.instance).hasServiceId();
            }

            public Builder mergeServiceId(Uuid uuid) {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).mergeServiceId(uuid);
                return this;
            }

            public Builder removeCharacteristics(int i5) {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).removeCharacteristics(i5);
                return this;
            }

            public Builder setCharacteristics(int i5, Uuid.Builder builder) {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).setCharacteristics(i5, (Uuid) builder.build());
                return this;
            }

            public Builder setCharacteristics(int i5, Uuid uuid) {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).setCharacteristics(i5, uuid);
                return this;
            }

            public Builder setServiceId(Uuid.Builder builder) {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).setServiceId((Uuid) builder.build());
                return this;
            }

            public Builder setServiceId(Uuid uuid) {
                copyOnWrite();
                ((ServiceWithCharacteristics) this.instance).setServiceId(uuid);
                return this;
            }
        }

        static {
            ServiceWithCharacteristics serviceWithCharacteristics = new ServiceWithCharacteristics();
            DEFAULT_INSTANCE = serviceWithCharacteristics;
            z.registerDefaultInstance(ServiceWithCharacteristics.class, serviceWithCharacteristics);
        }

        private ServiceWithCharacteristics() {
        }

        /* access modifiers changed from: private */
        public void addAllCharacteristics(Iterable<? extends Uuid> iterable) {
            ensureCharacteristicsIsMutable();
            a.addAll(iterable, this.characteristics_);
        }

        /* access modifiers changed from: private */
        public void addCharacteristics(int i5, Uuid uuid) {
            uuid.getClass();
            ensureCharacteristicsIsMutable();
            this.characteristics_.add(i5, uuid);
        }

        /* access modifiers changed from: private */
        public void addCharacteristics(Uuid uuid) {
            uuid.getClass();
            ensureCharacteristicsIsMutable();
            this.characteristics_.add(uuid);
        }

        /* access modifiers changed from: private */
        public void clearCharacteristics() {
            this.characteristics_ = z.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearServiceId() {
            this.serviceId_ = null;
        }

        private void ensureCharacteristicsIsMutable() {
            b0.i<Uuid> iVar = this.characteristics_;
            if (!iVar.k()) {
                this.characteristics_ = z.mutableCopy(iVar);
            }
        }

        public static ServiceWithCharacteristics getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeServiceId(Uuid uuid) {
            uuid.getClass();
            Uuid uuid2 = this.serviceId_;
            if (!(uuid2 == null || uuid2 == Uuid.getDefaultInstance())) {
                uuid = (Uuid) ((Uuid.Builder) Uuid.newBuilder(this.serviceId_).mergeFrom(uuid)).buildPartial();
            }
            this.serviceId_ = uuid;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ServiceWithCharacteristics serviceWithCharacteristics) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(serviceWithCharacteristics);
        }

        public static ServiceWithCharacteristics parseDelimitedFrom(InputStream inputStream) {
            return (ServiceWithCharacteristics) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceWithCharacteristics parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (ServiceWithCharacteristics) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ServiceWithCharacteristics parseFrom(i iVar) {
            return (ServiceWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static ServiceWithCharacteristics parseFrom(i iVar, q qVar) {
            return (ServiceWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static ServiceWithCharacteristics parseFrom(j jVar) {
            return (ServiceWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static ServiceWithCharacteristics parseFrom(j jVar, q qVar) {
            return (ServiceWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static ServiceWithCharacteristics parseFrom(InputStream inputStream) {
            return (ServiceWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceWithCharacteristics parseFrom(InputStream inputStream, q qVar) {
            return (ServiceWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ServiceWithCharacteristics parseFrom(ByteBuffer byteBuffer) {
            return (ServiceWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ServiceWithCharacteristics parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (ServiceWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static ServiceWithCharacteristics parseFrom(byte[] bArr) {
            return (ServiceWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ServiceWithCharacteristics parseFrom(byte[] bArr, q qVar) {
            return (ServiceWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<ServiceWithCharacteristics> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void removeCharacteristics(int i5) {
            ensureCharacteristicsIsMutable();
            this.characteristics_.remove(i5);
        }

        /* access modifiers changed from: private */
        public void setCharacteristics(int i5, Uuid uuid) {
            uuid.getClass();
            ensureCharacteristicsIsMutable();
            this.characteristics_.set(i5, uuid);
        }

        /* access modifiers changed from: private */
        public void setServiceId(Uuid uuid) {
            uuid.getClass();
            this.serviceId_ = uuid;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new ServiceWithCharacteristics();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\t\u0002\u001b", new Object[]{"serviceId_", "characteristics_", Uuid.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<ServiceWithCharacteristics> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (ServiceWithCharacteristics.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public Uuid getCharacteristics(int i5) {
            return this.characteristics_.get(i5);
        }

        public int getCharacteristicsCount() {
            return this.characteristics_.size();
        }

        public List<Uuid> getCharacteristicsList() {
            return this.characteristics_;
        }

        public UuidOrBuilder getCharacteristicsOrBuilder(int i5) {
            return this.characteristics_.get(i5);
        }

        public List<? extends UuidOrBuilder> getCharacteristicsOrBuilderList() {
            return this.characteristics_;
        }

        public Uuid getServiceId() {
            Uuid uuid = this.serviceId_;
            return uuid == null ? Uuid.getDefaultInstance() : uuid;
        }

        public boolean hasServiceId() {
            return this.serviceId_ != null;
        }
    }

    public interface ServiceWithCharacteristicsOrBuilder extends t0 {
        Uuid getCharacteristics(int i5);

        int getCharacteristicsCount();

        List<Uuid> getCharacteristicsList();

        /* synthetic */ s0 getDefaultInstanceForType();

        Uuid getServiceId();

        boolean hasServiceId();

        /* synthetic */ boolean isInitialized();
    }

    public static final class ServicesWithCharacteristics extends z<ServicesWithCharacteristics, Builder> implements ServicesWithCharacteristicsOrBuilder {
        /* access modifiers changed from: private */
        public static final ServicesWithCharacteristics DEFAULT_INSTANCE;
        public static final int ITEMS_FIELD_NUMBER = 1;
        private static volatile b1<ServicesWithCharacteristics> PARSER;
        private b0.i<ServiceWithCharacteristics> items_ = z.emptyProtobufList();

        public static final class Builder extends z.a<ServicesWithCharacteristics, Builder> implements ServicesWithCharacteristicsOrBuilder {
            private Builder() {
                super(ServicesWithCharacteristics.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder addAllItems(Iterable<? extends ServiceWithCharacteristics> iterable) {
                copyOnWrite();
                ((ServicesWithCharacteristics) this.instance).addAllItems(iterable);
                return this;
            }

            public Builder addItems(int i5, ServiceWithCharacteristics.Builder builder) {
                copyOnWrite();
                ((ServicesWithCharacteristics) this.instance).addItems(i5, (ServiceWithCharacteristics) builder.build());
                return this;
            }

            public Builder addItems(int i5, ServiceWithCharacteristics serviceWithCharacteristics) {
                copyOnWrite();
                ((ServicesWithCharacteristics) this.instance).addItems(i5, serviceWithCharacteristics);
                return this;
            }

            public Builder addItems(ServiceWithCharacteristics.Builder builder) {
                copyOnWrite();
                ((ServicesWithCharacteristics) this.instance).addItems((ServiceWithCharacteristics) builder.build());
                return this;
            }

            public Builder addItems(ServiceWithCharacteristics serviceWithCharacteristics) {
                copyOnWrite();
                ((ServicesWithCharacteristics) this.instance).addItems(serviceWithCharacteristics);
                return this;
            }

            public Builder clearItems() {
                copyOnWrite();
                ((ServicesWithCharacteristics) this.instance).clearItems();
                return this;
            }

            public ServiceWithCharacteristics getItems(int i5) {
                return ((ServicesWithCharacteristics) this.instance).getItems(i5);
            }

            public int getItemsCount() {
                return ((ServicesWithCharacteristics) this.instance).getItemsCount();
            }

            public List<ServiceWithCharacteristics> getItemsList() {
                return Collections.unmodifiableList(((ServicesWithCharacteristics) this.instance).getItemsList());
            }

            public Builder removeItems(int i5) {
                copyOnWrite();
                ((ServicesWithCharacteristics) this.instance).removeItems(i5);
                return this;
            }

            public Builder setItems(int i5, ServiceWithCharacteristics.Builder builder) {
                copyOnWrite();
                ((ServicesWithCharacteristics) this.instance).setItems(i5, (ServiceWithCharacteristics) builder.build());
                return this;
            }

            public Builder setItems(int i5, ServiceWithCharacteristics serviceWithCharacteristics) {
                copyOnWrite();
                ((ServicesWithCharacteristics) this.instance).setItems(i5, serviceWithCharacteristics);
                return this;
            }
        }

        static {
            ServicesWithCharacteristics servicesWithCharacteristics = new ServicesWithCharacteristics();
            DEFAULT_INSTANCE = servicesWithCharacteristics;
            z.registerDefaultInstance(ServicesWithCharacteristics.class, servicesWithCharacteristics);
        }

        private ServicesWithCharacteristics() {
        }

        /* access modifiers changed from: private */
        public void addAllItems(Iterable<? extends ServiceWithCharacteristics> iterable) {
            ensureItemsIsMutable();
            a.addAll(iterable, this.items_);
        }

        /* access modifiers changed from: private */
        public void addItems(int i5, ServiceWithCharacteristics serviceWithCharacteristics) {
            serviceWithCharacteristics.getClass();
            ensureItemsIsMutable();
            this.items_.add(i5, serviceWithCharacteristics);
        }

        /* access modifiers changed from: private */
        public void addItems(ServiceWithCharacteristics serviceWithCharacteristics) {
            serviceWithCharacteristics.getClass();
            ensureItemsIsMutable();
            this.items_.add(serviceWithCharacteristics);
        }

        /* access modifiers changed from: private */
        public void clearItems() {
            this.items_ = z.emptyProtobufList();
        }

        private void ensureItemsIsMutable() {
            b0.i<ServiceWithCharacteristics> iVar = this.items_;
            if (!iVar.k()) {
                this.items_ = z.mutableCopy(iVar);
            }
        }

        public static ServicesWithCharacteristics getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ServicesWithCharacteristics servicesWithCharacteristics) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(servicesWithCharacteristics);
        }

        public static ServicesWithCharacteristics parseDelimitedFrom(InputStream inputStream) {
            return (ServicesWithCharacteristics) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServicesWithCharacteristics parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (ServicesWithCharacteristics) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ServicesWithCharacteristics parseFrom(i iVar) {
            return (ServicesWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static ServicesWithCharacteristics parseFrom(i iVar, q qVar) {
            return (ServicesWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static ServicesWithCharacteristics parseFrom(j jVar) {
            return (ServicesWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static ServicesWithCharacteristics parseFrom(j jVar, q qVar) {
            return (ServicesWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static ServicesWithCharacteristics parseFrom(InputStream inputStream) {
            return (ServicesWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServicesWithCharacteristics parseFrom(InputStream inputStream, q qVar) {
            return (ServicesWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static ServicesWithCharacteristics parseFrom(ByteBuffer byteBuffer) {
            return (ServicesWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ServicesWithCharacteristics parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (ServicesWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static ServicesWithCharacteristics parseFrom(byte[] bArr) {
            return (ServicesWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ServicesWithCharacteristics parseFrom(byte[] bArr, q qVar) {
            return (ServicesWithCharacteristics) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<ServicesWithCharacteristics> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void removeItems(int i5) {
            ensureItemsIsMutable();
            this.items_.remove(i5);
        }

        /* access modifiers changed from: private */
        public void setItems(int i5, ServiceWithCharacteristics serviceWithCharacteristics) {
            serviceWithCharacteristics.getClass();
            ensureItemsIsMutable();
            this.items_.set(i5, serviceWithCharacteristics);
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new ServicesWithCharacteristics();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"items_", ServiceWithCharacteristics.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<ServicesWithCharacteristics> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (ServicesWithCharacteristics.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public ServiceWithCharacteristics getItems(int i5) {
            return this.items_.get(i5);
        }

        public int getItemsCount() {
            return this.items_.size();
        }

        public List<ServiceWithCharacteristics> getItemsList() {
            return this.items_;
        }

        public ServiceWithCharacteristicsOrBuilder getItemsOrBuilder(int i5) {
            return this.items_.get(i5);
        }

        public List<? extends ServiceWithCharacteristicsOrBuilder> getItemsOrBuilderList() {
            return this.items_;
        }
    }

    public interface ServicesWithCharacteristicsOrBuilder extends t0 {
        /* synthetic */ s0 getDefaultInstanceForType();

        ServiceWithCharacteristics getItems(int i5);

        int getItemsCount();

        List<ServiceWithCharacteristics> getItemsList();

        /* synthetic */ boolean isInitialized();
    }

    public static final class Uuid extends z<Uuid, Builder> implements UuidOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final Uuid DEFAULT_INSTANCE;
        private static volatile b1<Uuid> PARSER;
        private i data_ = i.f3533f;

        public static final class Builder extends z.a<Uuid, Builder> implements UuidOrBuilder {
            private Builder() {
                super(Uuid.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearData() {
                copyOnWrite();
                ((Uuid) this.instance).clearData();
                return this;
            }

            public i getData() {
                return ((Uuid) this.instance).getData();
            }

            public Builder setData(i iVar) {
                copyOnWrite();
                ((Uuid) this.instance).setData(iVar);
                return this;
            }
        }

        static {
            Uuid uuid = new Uuid();
            DEFAULT_INSTANCE = uuid;
            z.registerDefaultInstance(Uuid.class, uuid);
        }

        private Uuid() {
        }

        /* access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        public static Uuid getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Uuid uuid) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(uuid);
        }

        public static Uuid parseDelimitedFrom(InputStream inputStream) {
            return (Uuid) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Uuid parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (Uuid) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static Uuid parseFrom(i iVar) {
            return (Uuid) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static Uuid parseFrom(i iVar, q qVar) {
            return (Uuid) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static Uuid parseFrom(j jVar) {
            return (Uuid) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static Uuid parseFrom(j jVar, q qVar) {
            return (Uuid) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static Uuid parseFrom(InputStream inputStream) {
            return (Uuid) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Uuid parseFrom(InputStream inputStream, q qVar) {
            return (Uuid) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static Uuid parseFrom(ByteBuffer byteBuffer) {
            return (Uuid) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Uuid parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (Uuid) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static Uuid parseFrom(byte[] bArr) {
            return (Uuid) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Uuid parseFrom(byte[] bArr, q qVar) {
            return (Uuid) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<Uuid> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setData(i iVar) {
            iVar.getClass();
            this.data_ = iVar;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new Uuid();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"data_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<Uuid> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (Uuid.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public i getData() {
            return this.data_;
        }
    }

    public interface UuidOrBuilder extends t0 {
        i getData();

        /* synthetic */ s0 getDefaultInstanceForType();

        /* synthetic */ boolean isInitialized();
    }

    public static final class WriteCharacteristicInfo extends z<WriteCharacteristicInfo, Builder> implements WriteCharacteristicInfoOrBuilder {
        public static final int CHARACTERISTIC_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final WriteCharacteristicInfo DEFAULT_INSTANCE;
        public static final int FAILURE_FIELD_NUMBER = 3;
        private static volatile b1<WriteCharacteristicInfo> PARSER;
        private CharacteristicAddress characteristic_;
        private GenericFailure failure_;

        public static final class Builder extends z.a<WriteCharacteristicInfo, Builder> implements WriteCharacteristicInfoOrBuilder {
            private Builder() {
                super(WriteCharacteristicInfo.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearCharacteristic() {
                copyOnWrite();
                ((WriteCharacteristicInfo) this.instance).clearCharacteristic();
                return this;
            }

            public Builder clearFailure() {
                copyOnWrite();
                ((WriteCharacteristicInfo) this.instance).clearFailure();
                return this;
            }

            public CharacteristicAddress getCharacteristic() {
                return ((WriteCharacteristicInfo) this.instance).getCharacteristic();
            }

            public GenericFailure getFailure() {
                return ((WriteCharacteristicInfo) this.instance).getFailure();
            }

            public boolean hasCharacteristic() {
                return ((WriteCharacteristicInfo) this.instance).hasCharacteristic();
            }

            public boolean hasFailure() {
                return ((WriteCharacteristicInfo) this.instance).hasFailure();
            }

            public Builder mergeCharacteristic(CharacteristicAddress characteristicAddress) {
                copyOnWrite();
                ((WriteCharacteristicInfo) this.instance).mergeCharacteristic(characteristicAddress);
                return this;
            }

            public Builder mergeFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((WriteCharacteristicInfo) this.instance).mergeFailure(genericFailure);
                return this;
            }

            public Builder setCharacteristic(CharacteristicAddress.Builder builder) {
                copyOnWrite();
                ((WriteCharacteristicInfo) this.instance).setCharacteristic((CharacteristicAddress) builder.build());
                return this;
            }

            public Builder setCharacteristic(CharacteristicAddress characteristicAddress) {
                copyOnWrite();
                ((WriteCharacteristicInfo) this.instance).setCharacteristic(characteristicAddress);
                return this;
            }

            public Builder setFailure(GenericFailure.Builder builder) {
                copyOnWrite();
                ((WriteCharacteristicInfo) this.instance).setFailure((GenericFailure) builder.build());
                return this;
            }

            public Builder setFailure(GenericFailure genericFailure) {
                copyOnWrite();
                ((WriteCharacteristicInfo) this.instance).setFailure(genericFailure);
                return this;
            }
        }

        static {
            WriteCharacteristicInfo writeCharacteristicInfo = new WriteCharacteristicInfo();
            DEFAULT_INSTANCE = writeCharacteristicInfo;
            z.registerDefaultInstance(WriteCharacteristicInfo.class, writeCharacteristicInfo);
        }

        private WriteCharacteristicInfo() {
        }

        /* access modifiers changed from: private */
        public void clearCharacteristic() {
            this.characteristic_ = null;
        }

        /* access modifiers changed from: private */
        public void clearFailure() {
            this.failure_ = null;
        }

        public static WriteCharacteristicInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeCharacteristic(CharacteristicAddress characteristicAddress) {
            characteristicAddress.getClass();
            CharacteristicAddress characteristicAddress2 = this.characteristic_;
            if (!(characteristicAddress2 == null || characteristicAddress2 == CharacteristicAddress.getDefaultInstance())) {
                characteristicAddress = (CharacteristicAddress) ((CharacteristicAddress.Builder) CharacteristicAddress.newBuilder(this.characteristic_).mergeFrom(characteristicAddress)).buildPartial();
            }
            this.characteristic_ = characteristicAddress;
        }

        /* access modifiers changed from: private */
        public void mergeFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            GenericFailure genericFailure2 = this.failure_;
            if (!(genericFailure2 == null || genericFailure2 == GenericFailure.getDefaultInstance())) {
                genericFailure = (GenericFailure) ((GenericFailure.Builder) GenericFailure.newBuilder(this.failure_).mergeFrom(genericFailure)).buildPartial();
            }
            this.failure_ = genericFailure;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(WriteCharacteristicInfo writeCharacteristicInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(writeCharacteristicInfo);
        }

        public static WriteCharacteristicInfo parseDelimitedFrom(InputStream inputStream) {
            return (WriteCharacteristicInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WriteCharacteristicInfo parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (WriteCharacteristicInfo) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static WriteCharacteristicInfo parseFrom(i iVar) {
            return (WriteCharacteristicInfo) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static WriteCharacteristicInfo parseFrom(i iVar, q qVar) {
            return (WriteCharacteristicInfo) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static WriteCharacteristicInfo parseFrom(j jVar) {
            return (WriteCharacteristicInfo) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static WriteCharacteristicInfo parseFrom(j jVar, q qVar) {
            return (WriteCharacteristicInfo) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static WriteCharacteristicInfo parseFrom(InputStream inputStream) {
            return (WriteCharacteristicInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WriteCharacteristicInfo parseFrom(InputStream inputStream, q qVar) {
            return (WriteCharacteristicInfo) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static WriteCharacteristicInfo parseFrom(ByteBuffer byteBuffer) {
            return (WriteCharacteristicInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static WriteCharacteristicInfo parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (WriteCharacteristicInfo) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static WriteCharacteristicInfo parseFrom(byte[] bArr) {
            return (WriteCharacteristicInfo) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WriteCharacteristicInfo parseFrom(byte[] bArr, q qVar) {
            return (WriteCharacteristicInfo) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<WriteCharacteristicInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setCharacteristic(CharacteristicAddress characteristicAddress) {
            characteristicAddress.getClass();
            this.characteristic_ = characteristicAddress;
        }

        /* access modifiers changed from: private */
        public void setFailure(GenericFailure genericFailure) {
            genericFailure.getClass();
            this.failure_ = genericFailure;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new WriteCharacteristicInfo();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\t\u0003\t", new Object[]{"characteristic_", "failure_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<WriteCharacteristicInfo> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (WriteCharacteristicInfo.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public CharacteristicAddress getCharacteristic() {
            CharacteristicAddress characteristicAddress = this.characteristic_;
            return characteristicAddress == null ? CharacteristicAddress.getDefaultInstance() : characteristicAddress;
        }

        public GenericFailure getFailure() {
            GenericFailure genericFailure = this.failure_;
            return genericFailure == null ? GenericFailure.getDefaultInstance() : genericFailure;
        }

        public boolean hasCharacteristic() {
            return this.characteristic_ != null;
        }

        public boolean hasFailure() {
            return this.failure_ != null;
        }
    }

    public interface WriteCharacteristicInfoOrBuilder extends t0 {
        CharacteristicAddress getCharacteristic();

        /* synthetic */ s0 getDefaultInstanceForType();

        GenericFailure getFailure();

        boolean hasCharacteristic();

        boolean hasFailure();

        /* synthetic */ boolean isInitialized();
    }

    public static final class WriteCharacteristicRequest extends z<WriteCharacteristicRequest, Builder> implements WriteCharacteristicRequestOrBuilder {
        public static final int CHARACTERISTIC_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final WriteCharacteristicRequest DEFAULT_INSTANCE;
        private static volatile b1<WriteCharacteristicRequest> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 2;
        private CharacteristicAddress characteristic_;
        private i value_ = i.f3533f;

        public static final class Builder extends z.a<WriteCharacteristicRequest, Builder> implements WriteCharacteristicRequestOrBuilder {
            private Builder() {
                super(WriteCharacteristicRequest.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearCharacteristic() {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).clearCharacteristic();
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).clearValue();
                return this;
            }

            public CharacteristicAddress getCharacteristic() {
                return ((WriteCharacteristicRequest) this.instance).getCharacteristic();
            }

            public i getValue() {
                return ((WriteCharacteristicRequest) this.instance).getValue();
            }

            public boolean hasCharacteristic() {
                return ((WriteCharacteristicRequest) this.instance).hasCharacteristic();
            }

            public Builder mergeCharacteristic(CharacteristicAddress characteristicAddress) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).mergeCharacteristic(characteristicAddress);
                return this;
            }

            public Builder setCharacteristic(CharacteristicAddress.Builder builder) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setCharacteristic((CharacteristicAddress) builder.build());
                return this;
            }

            public Builder setCharacteristic(CharacteristicAddress characteristicAddress) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setCharacteristic(characteristicAddress);
                return this;
            }

            public Builder setValue(i iVar) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setValue(iVar);
                return this;
            }
        }

        static {
            WriteCharacteristicRequest writeCharacteristicRequest = new WriteCharacteristicRequest();
            DEFAULT_INSTANCE = writeCharacteristicRequest;
            z.registerDefaultInstance(WriteCharacteristicRequest.class, writeCharacteristicRequest);
        }

        private WriteCharacteristicRequest() {
        }

        /* access modifiers changed from: private */
        public void clearCharacteristic() {
            this.characteristic_ = null;
        }

        /* access modifiers changed from: private */
        public void clearValue() {
            this.value_ = getDefaultInstance().getValue();
        }

        public static WriteCharacteristicRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeCharacteristic(CharacteristicAddress characteristicAddress) {
            characteristicAddress.getClass();
            CharacteristicAddress characteristicAddress2 = this.characteristic_;
            if (!(characteristicAddress2 == null || characteristicAddress2 == CharacteristicAddress.getDefaultInstance())) {
                characteristicAddress = (CharacteristicAddress) ((CharacteristicAddress.Builder) CharacteristicAddress.newBuilder(this.characteristic_).mergeFrom(characteristicAddress)).buildPartial();
            }
            this.characteristic_ = characteristicAddress;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(WriteCharacteristicRequest writeCharacteristicRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(writeCharacteristicRequest);
        }

        public static WriteCharacteristicRequest parseDelimitedFrom(InputStream inputStream) {
            return (WriteCharacteristicRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WriteCharacteristicRequest parseDelimitedFrom(InputStream inputStream, q qVar) {
            return (WriteCharacteristicRequest) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static WriteCharacteristicRequest parseFrom(i iVar) {
            return (WriteCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, iVar);
        }

        public static WriteCharacteristicRequest parseFrom(i iVar, q qVar) {
            return (WriteCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
        }

        public static WriteCharacteristicRequest parseFrom(j jVar) {
            return (WriteCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, jVar);
        }

        public static WriteCharacteristicRequest parseFrom(j jVar, q qVar) {
            return (WriteCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
        }

        public static WriteCharacteristicRequest parseFrom(InputStream inputStream) {
            return (WriteCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WriteCharacteristicRequest parseFrom(InputStream inputStream, q qVar) {
            return (WriteCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
        }

        public static WriteCharacteristicRequest parseFrom(ByteBuffer byteBuffer) {
            return (WriteCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static WriteCharacteristicRequest parseFrom(ByteBuffer byteBuffer, q qVar) {
            return (WriteCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
        }

        public static WriteCharacteristicRequest parseFrom(byte[] bArr) {
            return (WriteCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WriteCharacteristicRequest parseFrom(byte[] bArr, q qVar) {
            return (WriteCharacteristicRequest) z.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
        }

        public static b1<WriteCharacteristicRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setCharacteristic(CharacteristicAddress characteristicAddress) {
            characteristicAddress.getClass();
            this.characteristic_ = characteristicAddress;
        }

        /* access modifiers changed from: private */
        public void setValue(i iVar) {
            iVar.getClass();
            this.value_ = iVar;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[fVar.ordinal()]) {
                case 1:
                    return new WriteCharacteristicRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\n", new Object[]{"characteristic_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    b1<WriteCharacteristicRequest> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (WriteCharacteristicRequest.class) {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        }
                    }
                    return b1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public CharacteristicAddress getCharacteristic() {
            CharacteristicAddress characteristicAddress = this.characteristic_;
            return characteristicAddress == null ? CharacteristicAddress.getDefaultInstance() : characteristicAddress;
        }

        public i getValue() {
            return this.value_;
        }

        public boolean hasCharacteristic() {
            return this.characteristic_ != null;
        }
    }

    public interface WriteCharacteristicRequestOrBuilder extends t0 {
        CharacteristicAddress getCharacteristic();

        /* synthetic */ s0 getDefaultInstanceForType();

        i getValue();

        boolean hasCharacteristic();

        /* synthetic */ boolean isInitialized();
    }

    private ProtobufModel() {
    }

    public static void registerAllExtensions(q qVar) {
    }
}
