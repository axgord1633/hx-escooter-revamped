package com.yalantis.ucrop;

import i4.u;

public class OkHttpClientStore {
    public static final OkHttpClientStore INSTANCE = new OkHttpClientStore();
    private u client;

    private OkHttpClientStore() {
    }

    public u getClient() {
        if (this.client == null) {
            this.client = new u();
        }
        return this.client;
    }

    /* access modifiers changed from: package-private */
    public void setClient(u uVar) {
        this.client = uVar;
    }
}
