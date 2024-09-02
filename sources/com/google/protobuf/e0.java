package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

public class e0 extends f0 {

    /* renamed from: f  reason: collision with root package name */
    private final s0 f3502f;

    static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: e  reason: collision with root package name */
        private Map.Entry<K, e0> f3503e;

        private b(Map.Entry<K, e0> entry) {
            this.f3503e = entry;
        }

        public e0 a() {
            return this.f3503e.getValue();
        }

        public K getKey() {
            return this.f3503e.getKey();
        }

        public Object getValue() {
            e0 value = this.f3503e.getValue();
            if (value == null) {
                return null;
            }
            return value.f();
        }

        public Object setValue(Object obj) {
            if (obj instanceof s0) {
                return this.f3503e.getValue().d((s0) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: e  reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f3504e;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f3504e = it;
        }

        /* renamed from: b */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f3504e.next();
            return next.getValue() instanceof e0 ? new b(next) : next;
        }

        public boolean hasNext() {
            return this.f3504e.hasNext();
        }

        public void remove() {
            this.f3504e.remove();
        }
    }

    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public s0 f() {
        return c(this.f3502f);
    }

    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
