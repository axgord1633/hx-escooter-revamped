package io.flutter.plugin.common;

import java.nio.ByteBuffer;

public interface BinaryMessenger {

    public interface BinaryMessageHandler {
        void onMessage(ByteBuffer byteBuffer, BinaryReply binaryReply);
    }

    public interface BinaryReply {
        void reply(ByteBuffer byteBuffer);
    }

    public interface TaskQueue {
    }

    public static class TaskQueueOptions {
        private boolean isSerial = true;

        public boolean getIsSerial() {
            return this.isSerial;
        }

        public TaskQueueOptions setIsSerial(boolean z4) {
            this.isSerial = z4;
            return this;
        }
    }

    void disableBufferingIncomingMessages();

    void enableBufferingIncomingMessages();

    TaskQueue makeBackgroundTaskQueue();

    TaskQueue makeBackgroundTaskQueue(TaskQueueOptions taskQueueOptions);

    void send(String str, ByteBuffer byteBuffer);

    void send(String str, ByteBuffer byteBuffer, BinaryReply binaryReply);

    void setMessageHandler(String str, BinaryMessageHandler binaryMessageHandler);

    void setMessageHandler(String str, BinaryMessageHandler binaryMessageHandler, TaskQueue taskQueue);
}
