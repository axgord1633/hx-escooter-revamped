package io.flutter.plugin.common;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class JSONMessageCodec implements MessageCodec<Object> {
    public static final JSONMessageCodec INSTANCE = new JSONMessageCodec();

    private JSONMessageCodec() {
    }

    public Object decodeMessage(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(StringCodec.INSTANCE.decodeMessage(byteBuffer));
            Object nextValue = jSONTokener.nextValue();
            if (!jSONTokener.more()) {
                return nextValue;
            }
            throw new IllegalArgumentException("Invalid JSON");
        } catch (JSONException e5) {
            throw new IllegalArgumentException("Invalid JSON", e5);
        }
    }

    public ByteBuffer encodeMessage(Object obj) {
        StringCodec stringCodec;
        String obj2;
        if (obj == null) {
            return null;
        }
        Object wrap = JSONUtil.wrap(obj);
        if (wrap instanceof String) {
            stringCodec = StringCodec.INSTANCE;
            obj2 = JSONObject.quote((String) wrap);
        } else {
            stringCodec = StringCodec.INSTANCE;
            obj2 = wrap.toString();
        }
        return stringCodec.encodeMessage(obj2);
    }
}
