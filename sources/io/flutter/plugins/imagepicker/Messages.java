package io.flutter.plugins.imagepicker;

import android.util.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Messages {

    public static final class CacheRetrievalError {
        private String code;
        private String message;

        public static final class Builder {
            private String code;
            private String message;

            public CacheRetrievalError build() {
                CacheRetrievalError cacheRetrievalError = new CacheRetrievalError();
                cacheRetrievalError.setCode(this.code);
                cacheRetrievalError.setMessage(this.message);
                return cacheRetrievalError;
            }

            public Builder setCode(String str) {
                this.code = str;
                return this;
            }

            public Builder setMessage(String str) {
                this.message = str;
                return this;
            }
        }

        CacheRetrievalError() {
        }

        static CacheRetrievalError fromList(ArrayList<Object> arrayList) {
            CacheRetrievalError cacheRetrievalError = new CacheRetrievalError();
            cacheRetrievalError.setCode((String) arrayList.get(0));
            cacheRetrievalError.setMessage((String) arrayList.get(1));
            return cacheRetrievalError;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public void setCode(String str) {
            if (str != null) {
                this.code = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"code\" is null.");
        }

        public void setMessage(String str) {
            this.message = str;
        }

        /* access modifiers changed from: package-private */
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.code);
            arrayList.add(this.message);
            return arrayList;
        }
    }

    public static final class CacheRetrievalResult {
        private CacheRetrievalError error;
        private List<String> paths;
        private CacheRetrievalType type;

        public static final class Builder {
            private CacheRetrievalError error;
            private List<String> paths;
            private CacheRetrievalType type;

            public CacheRetrievalResult build() {
                CacheRetrievalResult cacheRetrievalResult = new CacheRetrievalResult();
                cacheRetrievalResult.setType(this.type);
                cacheRetrievalResult.setError(this.error);
                cacheRetrievalResult.setPaths(this.paths);
                return cacheRetrievalResult;
            }

            public Builder setError(CacheRetrievalError cacheRetrievalError) {
                this.error = cacheRetrievalError;
                return this;
            }

            public Builder setPaths(List<String> list) {
                this.paths = list;
                return this;
            }

            public Builder setType(CacheRetrievalType cacheRetrievalType) {
                this.type = cacheRetrievalType;
                return this;
            }
        }

        CacheRetrievalResult() {
        }

        static CacheRetrievalResult fromList(ArrayList<Object> arrayList) {
            CacheRetrievalResult cacheRetrievalResult = new CacheRetrievalResult();
            Object obj = arrayList.get(0);
            CacheRetrievalError cacheRetrievalError = null;
            cacheRetrievalResult.setType(obj == null ? null : CacheRetrievalType.values()[((Integer) obj).intValue()]);
            Object obj2 = arrayList.get(1);
            if (obj2 != null) {
                cacheRetrievalError = CacheRetrievalError.fromList((ArrayList) obj2);
            }
            cacheRetrievalResult.setError(cacheRetrievalError);
            cacheRetrievalResult.setPaths((List) arrayList.get(2));
            return cacheRetrievalResult;
        }

        public CacheRetrievalError getError() {
            return this.error;
        }

        public List<String> getPaths() {
            return this.paths;
        }

        public CacheRetrievalType getType() {
            return this.type;
        }

        public void setError(CacheRetrievalError cacheRetrievalError) {
            this.error = cacheRetrievalError;
        }

        public void setPaths(List<String> list) {
            if (list != null) {
                this.paths = list;
                return;
            }
            throw new IllegalStateException("Nonnull field \"paths\" is null.");
        }

        public void setType(CacheRetrievalType cacheRetrievalType) {
            if (cacheRetrievalType != null) {
                this.type = cacheRetrievalType;
                return;
            }
            throw new IllegalStateException("Nonnull field \"type\" is null.");
        }

        /* access modifiers changed from: package-private */
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            CacheRetrievalType cacheRetrievalType = this.type;
            ArrayList<Object> arrayList2 = null;
            arrayList.add(cacheRetrievalType == null ? null : Integer.valueOf(cacheRetrievalType.index));
            CacheRetrievalError cacheRetrievalError = this.error;
            if (cacheRetrievalError != null) {
                arrayList2 = cacheRetrievalError.toList();
            }
            arrayList.add(arrayList2);
            arrayList.add(this.paths);
            return arrayList;
        }
    }

    public enum CacheRetrievalType {
        IMAGE(0),
        VIDEO(1);
        
        final int index;

        private CacheRetrievalType(int i5) {
            this.index = i5;
        }
    }

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(String str, String str2, Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public static final class GeneralOptions {
        private Boolean allowMultiple;
        private Boolean usePhotoPicker;

        public static final class Builder {
            private Boolean allowMultiple;
            private Boolean usePhotoPicker;

            public GeneralOptions build() {
                GeneralOptions generalOptions = new GeneralOptions();
                generalOptions.setAllowMultiple(this.allowMultiple);
                generalOptions.setUsePhotoPicker(this.usePhotoPicker);
                return generalOptions;
            }

            public Builder setAllowMultiple(Boolean bool) {
                this.allowMultiple = bool;
                return this;
            }

            public Builder setUsePhotoPicker(Boolean bool) {
                this.usePhotoPicker = bool;
                return this;
            }
        }

        GeneralOptions() {
        }

        static GeneralOptions fromList(ArrayList<Object> arrayList) {
            GeneralOptions generalOptions = new GeneralOptions();
            generalOptions.setAllowMultiple((Boolean) arrayList.get(0));
            generalOptions.setUsePhotoPicker((Boolean) arrayList.get(1));
            return generalOptions;
        }

        public Boolean getAllowMultiple() {
            return this.allowMultiple;
        }

        public Boolean getUsePhotoPicker() {
            return this.usePhotoPicker;
        }

        public void setAllowMultiple(Boolean bool) {
            if (bool != null) {
                this.allowMultiple = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"allowMultiple\" is null.");
        }

        public void setUsePhotoPicker(Boolean bool) {
            if (bool != null) {
                this.usePhotoPicker = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"usePhotoPicker\" is null.");
        }

        /* access modifiers changed from: package-private */
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.allowMultiple);
            arrayList.add(this.usePhotoPicker);
            return arrayList;
        }
    }

    public interface ImagePickerApi {

        /* renamed from: io.flutter.plugins.imagepicker.Messages$ImagePickerApi$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static MessageCodec<Object> a() {
                return ImagePickerApiCodec.INSTANCE;
            }

            public static /* synthetic */ void b(ImagePickerApi imagePickerApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList arrayList = (ArrayList) obj;
                imagePickerApi.pickImages((SourceSpecification) arrayList.get(0), (ImageSelectionOptions) arrayList.get(1), (GeneralOptions) arrayList.get(2), new Result<List<String>>(new ArrayList(), reply) {
                    final /* synthetic */ BasicMessageChannel.Reply val$reply;
                    final /* synthetic */ ArrayList val$wrapped;

                    {
                        this.val$wrapped = r1;
                        this.val$reply = r2;
                    }

                    public void error(Throwable th) {
                        this.val$reply.reply(Messages.wrapError(th));
                    }

                    public void success(List<String> list) {
                        this.val$wrapped.add(0, list);
                        this.val$reply.reply(this.val$wrapped);
                    }
                });
            }

            public static /* synthetic */ void c(ImagePickerApi imagePickerApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList arrayList = (ArrayList) obj;
                imagePickerApi.pickVideos((SourceSpecification) arrayList.get(0), (VideoSelectionOptions) arrayList.get(1), (GeneralOptions) arrayList.get(2), new Result<List<String>>(new ArrayList(), reply) {
                    final /* synthetic */ BasicMessageChannel.Reply val$reply;
                    final /* synthetic */ ArrayList val$wrapped;

                    {
                        this.val$wrapped = r1;
                        this.val$reply = r2;
                    }

                    public void error(Throwable th) {
                        this.val$reply.reply(Messages.wrapError(th));
                    }

                    public void success(List<String> list) {
                        this.val$wrapped.add(0, list);
                        this.val$reply.reply(this.val$wrapped);
                    }
                });
            }

            public static /* synthetic */ void d(ImagePickerApi imagePickerApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList arrayList = (ArrayList) obj;
                imagePickerApi.pickMedia((MediaSelectionOptions) arrayList.get(0), (GeneralOptions) arrayList.get(1), new Result<List<String>>(new ArrayList(), reply) {
                    final /* synthetic */ BasicMessageChannel.Reply val$reply;
                    final /* synthetic */ ArrayList val$wrapped;

                    {
                        this.val$wrapped = r1;
                        this.val$reply = r2;
                    }

                    public void error(Throwable th) {
                        this.val$reply.reply(Messages.wrapError(th));
                    }

                    public void success(List<String> list) {
                        this.val$wrapped.add(0, list);
                        this.val$reply.reply(this.val$wrapped);
                    }
                });
            }

            public static /* synthetic */ void e(ImagePickerApi imagePickerApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList<Object> arrayList = new ArrayList<>();
                try {
                    arrayList.add(0, imagePickerApi.retrieveLostResults());
                } catch (Throwable th) {
                    arrayList = Messages.wrapError(th);
                }
                reply.reply(arrayList);
            }

            public static void f(BinaryMessenger binaryMessenger, ImagePickerApi imagePickerApi) {
                BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.ImagePickerApi.pickImages", a(), binaryMessenger.makeBackgroundTaskQueue());
                if (imagePickerApi != null) {
                    basicMessageChannel.setMessageHandler(new j(imagePickerApi));
                } else {
                    basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.ImagePickerApi.pickVideos", a(), binaryMessenger.makeBackgroundTaskQueue());
                if (imagePickerApi != null) {
                    basicMessageChannel2.setMessageHandler(new k(imagePickerApi));
                } else {
                    basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.ImagePickerApi.pickMedia", a());
                if (imagePickerApi != null) {
                    basicMessageChannel3.setMessageHandler(new l(imagePickerApi));
                } else {
                    basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.ImagePickerApi.retrieveLostResults", a(), binaryMessenger.makeBackgroundTaskQueue());
                if (imagePickerApi != null) {
                    basicMessageChannel4.setMessageHandler(new m(imagePickerApi));
                } else {
                    basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
            }
        }

        void pickImages(SourceSpecification sourceSpecification, ImageSelectionOptions imageSelectionOptions, GeneralOptions generalOptions, Result<List<String>> result);

        void pickMedia(MediaSelectionOptions mediaSelectionOptions, GeneralOptions generalOptions, Result<List<String>> result);

        void pickVideos(SourceSpecification sourceSpecification, VideoSelectionOptions videoSelectionOptions, GeneralOptions generalOptions, Result<List<String>> result);

        CacheRetrievalResult retrieveLostResults();
    }

    private static class ImagePickerApiCodec extends StandardMessageCodec {
        public static final ImagePickerApiCodec INSTANCE = new ImagePickerApiCodec();

        private ImagePickerApiCodec() {
        }

        /* access modifiers changed from: protected */
        public Object readValueOfType(byte b5, ByteBuffer byteBuffer) {
            switch (b5) {
                case Byte.MIN_VALUE:
                    return CacheRetrievalError.fromList((ArrayList) readValue(byteBuffer));
                case -127:
                    return CacheRetrievalResult.fromList((ArrayList) readValue(byteBuffer));
                case -126:
                    return GeneralOptions.fromList((ArrayList) readValue(byteBuffer));
                case -125:
                    return ImageSelectionOptions.fromList((ArrayList) readValue(byteBuffer));
                case -124:
                    return MediaSelectionOptions.fromList((ArrayList) readValue(byteBuffer));
                case -123:
                    return SourceSpecification.fromList((ArrayList) readValue(byteBuffer));
                case -122:
                    return VideoSelectionOptions.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b5, byteBuffer);
            }
        }

        /* access modifiers changed from: protected */
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> list;
            if (obj instanceof CacheRetrievalError) {
                byteArrayOutputStream.write(128);
                list = ((CacheRetrievalError) obj).toList();
            } else if (obj instanceof CacheRetrievalResult) {
                byteArrayOutputStream.write(129);
                list = ((CacheRetrievalResult) obj).toList();
            } else if (obj instanceof GeneralOptions) {
                byteArrayOutputStream.write(130);
                list = ((GeneralOptions) obj).toList();
            } else if (obj instanceof ImageSelectionOptions) {
                byteArrayOutputStream.write(131);
                list = ((ImageSelectionOptions) obj).toList();
            } else if (obj instanceof MediaSelectionOptions) {
                byteArrayOutputStream.write(132);
                list = ((MediaSelectionOptions) obj).toList();
            } else if (obj instanceof SourceSpecification) {
                byteArrayOutputStream.write(133);
                list = ((SourceSpecification) obj).toList();
            } else if (obj instanceof VideoSelectionOptions) {
                byteArrayOutputStream.write(134);
                writeValue(byteArrayOutputStream, ((VideoSelectionOptions) obj).toList());
                return;
            } else {
                super.writeValue(byteArrayOutputStream, obj);
                return;
            }
            writeValue(byteArrayOutputStream, list);
        }
    }

    public static final class ImageSelectionOptions {
        private Double maxHeight;
        private Double maxWidth;
        private Long quality;

        public static final class Builder {
            private Double maxHeight;
            private Double maxWidth;
            private Long quality;

            public ImageSelectionOptions build() {
                ImageSelectionOptions imageSelectionOptions = new ImageSelectionOptions();
                imageSelectionOptions.setMaxWidth(this.maxWidth);
                imageSelectionOptions.setMaxHeight(this.maxHeight);
                imageSelectionOptions.setQuality(this.quality);
                return imageSelectionOptions;
            }

            public Builder setMaxHeight(Double d5) {
                this.maxHeight = d5;
                return this;
            }

            public Builder setMaxWidth(Double d5) {
                this.maxWidth = d5;
                return this;
            }

            public Builder setQuality(Long l5) {
                this.quality = l5;
                return this;
            }
        }

        ImageSelectionOptions() {
        }

        static ImageSelectionOptions fromList(ArrayList<Object> arrayList) {
            Long l5;
            ImageSelectionOptions imageSelectionOptions = new ImageSelectionOptions();
            imageSelectionOptions.setMaxWidth((Double) arrayList.get(0));
            imageSelectionOptions.setMaxHeight((Double) arrayList.get(1));
            Object obj = arrayList.get(2);
            if (obj == null) {
                l5 = null;
            } else {
                l5 = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            imageSelectionOptions.setQuality(l5);
            return imageSelectionOptions;
        }

        public Double getMaxHeight() {
            return this.maxHeight;
        }

        public Double getMaxWidth() {
            return this.maxWidth;
        }

        public Long getQuality() {
            return this.quality;
        }

        public void setMaxHeight(Double d5) {
            this.maxHeight = d5;
        }

        public void setMaxWidth(Double d5) {
            this.maxWidth = d5;
        }

        public void setQuality(Long l5) {
            if (l5 != null) {
                this.quality = l5;
                return;
            }
            throw new IllegalStateException("Nonnull field \"quality\" is null.");
        }

        /* access modifiers changed from: package-private */
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.maxWidth);
            arrayList.add(this.maxHeight);
            arrayList.add(this.quality);
            return arrayList;
        }
    }

    public static final class MediaSelectionOptions {
        private ImageSelectionOptions imageSelectionOptions;

        public static final class Builder {
            private ImageSelectionOptions imageSelectionOptions;

            public MediaSelectionOptions build() {
                MediaSelectionOptions mediaSelectionOptions = new MediaSelectionOptions();
                mediaSelectionOptions.setImageSelectionOptions(this.imageSelectionOptions);
                return mediaSelectionOptions;
            }

            public Builder setImageSelectionOptions(ImageSelectionOptions imageSelectionOptions2) {
                this.imageSelectionOptions = imageSelectionOptions2;
                return this;
            }
        }

        MediaSelectionOptions() {
        }

        static MediaSelectionOptions fromList(ArrayList<Object> arrayList) {
            MediaSelectionOptions mediaSelectionOptions = new MediaSelectionOptions();
            Object obj = arrayList.get(0);
            mediaSelectionOptions.setImageSelectionOptions(obj == null ? null : ImageSelectionOptions.fromList((ArrayList) obj));
            return mediaSelectionOptions;
        }

        public ImageSelectionOptions getImageSelectionOptions() {
            return this.imageSelectionOptions;
        }

        public void setImageSelectionOptions(ImageSelectionOptions imageSelectionOptions2) {
            if (imageSelectionOptions2 != null) {
                this.imageSelectionOptions = imageSelectionOptions2;
                return;
            }
            throw new IllegalStateException("Nonnull field \"imageSelectionOptions\" is null.");
        }

        /* access modifiers changed from: package-private */
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            ImageSelectionOptions imageSelectionOptions2 = this.imageSelectionOptions;
            arrayList.add(imageSelectionOptions2 == null ? null : imageSelectionOptions2.toList());
            return arrayList;
        }
    }

    public interface Result<T> {
        void error(Throwable th);

        void success(T t5);
    }

    public enum SourceCamera {
        REAR(0),
        FRONT(1);
        
        final int index;

        private SourceCamera(int i5) {
            this.index = i5;
        }
    }

    public static final class SourceSpecification {
        private SourceCamera camera;
        private SourceType type;

        public static final class Builder {
            private SourceCamera camera;
            private SourceType type;

            public SourceSpecification build() {
                SourceSpecification sourceSpecification = new SourceSpecification();
                sourceSpecification.setType(this.type);
                sourceSpecification.setCamera(this.camera);
                return sourceSpecification;
            }

            public Builder setCamera(SourceCamera sourceCamera) {
                this.camera = sourceCamera;
                return this;
            }

            public Builder setType(SourceType sourceType) {
                this.type = sourceType;
                return this;
            }
        }

        SourceSpecification() {
        }

        static SourceSpecification fromList(ArrayList<Object> arrayList) {
            SourceSpecification sourceSpecification = new SourceSpecification();
            Object obj = arrayList.get(0);
            SourceCamera sourceCamera = null;
            sourceSpecification.setType(obj == null ? null : SourceType.values()[((Integer) obj).intValue()]);
            Object obj2 = arrayList.get(1);
            if (obj2 != null) {
                sourceCamera = SourceCamera.values()[((Integer) obj2).intValue()];
            }
            sourceSpecification.setCamera(sourceCamera);
            return sourceSpecification;
        }

        public SourceCamera getCamera() {
            return this.camera;
        }

        public SourceType getType() {
            return this.type;
        }

        public void setCamera(SourceCamera sourceCamera) {
            this.camera = sourceCamera;
        }

        public void setType(SourceType sourceType) {
            if (sourceType != null) {
                this.type = sourceType;
                return;
            }
            throw new IllegalStateException("Nonnull field \"type\" is null.");
        }

        /* access modifiers changed from: package-private */
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            SourceType sourceType = this.type;
            Integer num = null;
            arrayList.add(sourceType == null ? null : Integer.valueOf(sourceType.index));
            SourceCamera sourceCamera = this.camera;
            if (sourceCamera != null) {
                num = Integer.valueOf(sourceCamera.index);
            }
            arrayList.add(num);
            return arrayList;
        }
    }

    public enum SourceType {
        CAMERA(0),
        GALLERY(1);
        
        final int index;

        private SourceType(int i5) {
            this.index = i5;
        }
    }

    public static final class VideoSelectionOptions {
        private Long maxDurationSeconds;

        public static final class Builder {
            private Long maxDurationSeconds;

            public VideoSelectionOptions build() {
                VideoSelectionOptions videoSelectionOptions = new VideoSelectionOptions();
                videoSelectionOptions.setMaxDurationSeconds(this.maxDurationSeconds);
                return videoSelectionOptions;
            }

            public Builder setMaxDurationSeconds(Long l5) {
                this.maxDurationSeconds = l5;
                return this;
            }
        }

        static VideoSelectionOptions fromList(ArrayList<Object> arrayList) {
            Long l5;
            VideoSelectionOptions videoSelectionOptions = new VideoSelectionOptions();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l5 = null;
            } else {
                l5 = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            videoSelectionOptions.setMaxDurationSeconds(l5);
            return videoSelectionOptions;
        }

        public Long getMaxDurationSeconds() {
            return this.maxDurationSeconds;
        }

        public void setMaxDurationSeconds(Long l5) {
            this.maxDurationSeconds = l5;
        }

        /* access modifiers changed from: package-private */
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.maxDurationSeconds);
            return arrayList;
        }
    }

    protected static ArrayList<Object> wrapError(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            obj = flutterError.details;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
