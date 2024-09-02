package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import android.util.DisplayMetrics;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SettingsChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String ALWAYS_USE_24_HOUR_FORMAT = "alwaysUse24HourFormat";
    private static final String BRIEFLY_SHOW_PASSWORD = "brieflyShowPassword";
    public static final String CHANNEL_NAME = "flutter/settings";
    private static final String CONFIGURATION_ID = "configurationId";
    /* access modifiers changed from: private */
    public static final ConfigurationQueue CONFIGURATION_QUEUE = new ConfigurationQueue();
    private static final String NATIVE_SPELL_CHECK_SERVICE_DEFINED = "nativeSpellCheckServiceDefined";
    private static final String PLATFORM_BRIGHTNESS = "platformBrightness";
    private static final String TAG = "SettingsChannel";
    private static final String TEXT_SCALE_FACTOR = "textScaleFactor";
    public final BasicMessageChannel<Object> channel;

    public static class ConfigurationQueue {
        private SentConfiguration currentConfiguration;
        private SentConfiguration previousEnqueuedConfiguration;
        /* access modifiers changed from: private */
        public final ConcurrentLinkedQueue<SentConfiguration> sentQueue = new ConcurrentLinkedQueue<>();

        public static class SentConfiguration {
            private static int nextConfigGeneration = Integer.MIN_VALUE;
            /* access modifiers changed from: private */
            public final DisplayMetrics displayMetrics;
            public final int generationNumber;

            public SentConfiguration(DisplayMetrics displayMetrics2) {
                int i5 = nextConfigGeneration;
                nextConfigGeneration = i5 + 1;
                this.generationNumber = i5;
                this.displayMetrics = displayMetrics2;
            }
        }

        public BasicMessageChannel.Reply enqueueConfiguration(SentConfiguration sentConfiguration) {
            this.sentQueue.add(sentConfiguration);
            final SentConfiguration sentConfiguration2 = this.previousEnqueuedConfiguration;
            this.previousEnqueuedConfiguration = sentConfiguration;
            if (sentConfiguration2 == null) {
                return null;
            }
            return new BasicMessageChannel.Reply() {
                public void reply(Object obj) {
                    ConfigurationQueue.this.sentQueue.remove(sentConfiguration2);
                    if (!ConfigurationQueue.this.sentQueue.isEmpty()) {
                        Log.e(SettingsChannel.TAG, "The queue becomes empty after removing config generation " + String.valueOf(sentConfiguration2.generationNumber));
                    }
                }
            };
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
            r0.append(r6);
            io.flutter.Log.e(io.flutter.embedding.engine.systemchannels.SettingsChannel.TAG, r0.toString());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
            if (r0.generationNumber == r6) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
            r0 = new java.lang.StringBuilder();
            r0.append("Cannot find config with generation: ");
            r0.append(java.lang.String.valueOf(r6));
            r0.append(", the oldest config is now: ");
            r6 = java.lang.String.valueOf(r5.currentConfiguration.generationNumber);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            if (r5.currentConfiguration == null) goto L_0x0004;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r5.currentConfiguration = r5.sentQueue.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
            r0 = r5.currentConfiguration;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (r0 == null) goto L_0x0017;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
            if (r0.generationNumber >= r6) goto L_0x0017;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            if (r0 != null) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
            r0 = new java.lang.StringBuilder();
            r0.append("Cannot find config with generation: ");
            r0.append(java.lang.String.valueOf(r6));
            r6 = ", after exhausting the queue.";
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.flutter.embedding.engine.systemchannels.SettingsChannel.ConfigurationQueue.SentConfiguration getConfiguration(int r6) {
            /*
                r5 = this;
                io.flutter.embedding.engine.systemchannels.SettingsChannel$ConfigurationQueue$SentConfiguration r0 = r5.currentConfiguration
                if (r0 != 0) goto L_0x000e
            L_0x0004:
                java.util.concurrent.ConcurrentLinkedQueue<io.flutter.embedding.engine.systemchannels.SettingsChannel$ConfigurationQueue$SentConfiguration> r0 = r5.sentQueue
                java.lang.Object r0 = r0.poll()
                io.flutter.embedding.engine.systemchannels.SettingsChannel$ConfigurationQueue$SentConfiguration r0 = (io.flutter.embedding.engine.systemchannels.SettingsChannel.ConfigurationQueue.SentConfiguration) r0
                r5.currentConfiguration = r0
            L_0x000e:
                io.flutter.embedding.engine.systemchannels.SettingsChannel$ConfigurationQueue$SentConfiguration r0 = r5.currentConfiguration
                if (r0 == 0) goto L_0x0017
                int r1 = r0.generationNumber
                if (r1 >= r6) goto L_0x0017
                goto L_0x0004
            L_0x0017:
                r1 = 0
                java.lang.String r2 = "Cannot find config with generation: "
                java.lang.String r3 = "SettingsChannel"
                if (r0 != 0) goto L_0x003a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r2)
                java.lang.String r6 = java.lang.String.valueOf(r6)
                r0.append(r6)
                java.lang.String r6 = ", after exhausting the queue."
            L_0x002f:
                r0.append(r6)
                java.lang.String r6 = r0.toString()
                io.flutter.Log.e(r3, r6)
                return r1
            L_0x003a:
                int r4 = r0.generationNumber
                if (r4 == r6) goto L_0x005b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r2)
                java.lang.String r6 = java.lang.String.valueOf(r6)
                r0.append(r6)
                java.lang.String r6 = ", the oldest config is now: "
                r0.append(r6)
                io.flutter.embedding.engine.systemchannels.SettingsChannel$ConfigurationQueue$SentConfiguration r6 = r5.currentConfiguration
                int r6 = r6.generationNumber
                java.lang.String r6 = java.lang.String.valueOf(r6)
                goto L_0x002f
            L_0x005b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.SettingsChannel.ConfigurationQueue.getConfiguration(int):io.flutter.embedding.engine.systemchannels.SettingsChannel$ConfigurationQueue$SentConfiguration");
        }
    }

    public static class MessageBuilder {
        private final BasicMessageChannel<Object> channel;
        private DisplayMetrics displayMetrics;
        private Map<String, Object> message = new HashMap();

        MessageBuilder(BasicMessageChannel<Object> basicMessageChannel) {
            this.channel = basicMessageChannel;
        }

        public void send() {
            Log.v(SettingsChannel.TAG, "Sending message: \ntextScaleFactor: " + this.message.get(SettingsChannel.TEXT_SCALE_FACTOR) + "\nalwaysUse24HourFormat: " + this.message.get(SettingsChannel.ALWAYS_USE_24_HOUR_FORMAT) + "\nplatformBrightness: " + this.message.get(SettingsChannel.PLATFORM_BRIGHTNESS));
            DisplayMetrics displayMetrics2 = this.displayMetrics;
            if (!SettingsChannel.hasNonlinearTextScalingSupport() || displayMetrics2 == null) {
                this.channel.send(this.message);
                return;
            }
            ConfigurationQueue.SentConfiguration sentConfiguration = new ConfigurationQueue.SentConfiguration(displayMetrics2);
            BasicMessageChannel.Reply enqueueConfiguration = SettingsChannel.CONFIGURATION_QUEUE.enqueueConfiguration(sentConfiguration);
            this.message.put(SettingsChannel.CONFIGURATION_ID, Integer.valueOf(sentConfiguration.generationNumber));
            this.channel.send(this.message, enqueueConfiguration);
        }

        public MessageBuilder setBrieflyShowPassword(boolean z4) {
            this.message.put(SettingsChannel.BRIEFLY_SHOW_PASSWORD, Boolean.valueOf(z4));
            return this;
        }

        public MessageBuilder setDisplayMetrics(DisplayMetrics displayMetrics2) {
            this.displayMetrics = displayMetrics2;
            return this;
        }

        public MessageBuilder setNativeSpellCheckServiceDefined(boolean z4) {
            this.message.put(SettingsChannel.NATIVE_SPELL_CHECK_SERVICE_DEFINED, Boolean.valueOf(z4));
            return this;
        }

        public MessageBuilder setPlatformBrightness(PlatformBrightness platformBrightness) {
            this.message.put(SettingsChannel.PLATFORM_BRIGHTNESS, platformBrightness.name);
            return this;
        }

        public MessageBuilder setTextScaleFactor(float f5) {
            this.message.put(SettingsChannel.TEXT_SCALE_FACTOR, Float.valueOf(f5));
            return this;
        }

        public MessageBuilder setUse24HourFormat(boolean z4) {
            this.message.put(SettingsChannel.ALWAYS_USE_24_HOUR_FORMAT, Boolean.valueOf(z4));
            return this;
        }
    }

    public enum PlatformBrightness {
        light("light"),
        dark("dark");
        
        public String name;

        private PlatformBrightness(String str) {
            this.name = str;
        }
    }

    public SettingsChannel(DartExecutor dartExecutor) {
        this.channel = new BasicMessageChannel<>(dartExecutor, CHANNEL_NAME, JSONMessageCodec.INSTANCE);
    }

    public static DisplayMetrics getPastDisplayMetrics(int i5) {
        ConfigurationQueue.SentConfiguration configuration = CONFIGURATION_QUEUE.getConfiguration(i5);
        if (configuration == null) {
            return null;
        }
        return configuration.displayMetrics;
    }

    public static boolean hasNonlinearTextScalingSupport() {
        return Build.VERSION.SDK_INT >= 34;
    }

    public MessageBuilder startMessage() {
        return new MessageBuilder(this.channel);
    }
}
