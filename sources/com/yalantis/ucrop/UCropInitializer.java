package com.yalantis.ucrop;

import i4.u;

public class UCropInitializer {
    public UCropInitializer setOkHttpClient(u uVar) {
        OkHttpClientStore.INSTANCE.setClient(uVar);
        return this;
    }
}
