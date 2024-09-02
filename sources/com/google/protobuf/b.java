package com.google.protobuf;

import com.google.protobuf.s0;

public abstract class b<MessageType extends s0> implements b1<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    private static final q f3468a = q.b();

    private MessageType c(MessageType messagetype) {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw d(messagetype).a().k(messagetype);
    }

    private o1 d(MessageType messagetype) {
        return messagetype instanceof a ? ((a) messagetype).newUninitializedMessageException() : new o1(messagetype);
    }

    /* renamed from: e */
    public MessageType a(i iVar, q qVar) {
        return c(f(iVar, qVar));
    }

    public MessageType f(i iVar, q qVar) {
        MessageType messagetype;
        try {
            j u5 = iVar.u();
            messagetype = (s0) b(u5, qVar);
            u5.a(0);
            return messagetype;
        } catch (c0 e5) {
            throw e5.k(messagetype);
        } catch (c0 e6) {
            throw e6;
        }
    }
}
