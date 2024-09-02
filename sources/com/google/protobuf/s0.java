package com.google.protobuf;

public interface s0 extends t0 {

    public interface a extends t0, Cloneable {
        s0 build();

        s0 buildPartial();

        a mergeFrom(s0 s0Var);
    }

    b1<? extends s0> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    i toByteString();

    void writeTo(l lVar);
}
