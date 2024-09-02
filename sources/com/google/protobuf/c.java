package com.google.protobuf;

import com.google.protobuf.b0;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class c<E> extends AbstractList<E> implements b0.i<E> {

    /* renamed from: e  reason: collision with root package name */
    private boolean f3474e = true;

    c() {
    }

    public boolean add(E e5) {
        c();
        return super.add(e5);
    }

    public boolean addAll(int i5, Collection<? extends E> collection) {
        c();
        return super.addAll(i5, collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        c();
        return super.addAll(collection);
    }

    public final void b() {
        this.f3474e = false;
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (!this.f3474e) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        c();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i5 = 0; i5 < size; i5++) {
            if (!get(i5).equals(list.get(i5))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i5 = 1;
        for (int i6 = 0; i6 < size; i6++) {
            i5 = (i5 * 31) + get(i6).hashCode();
        }
        return i5;
    }

    public boolean k() {
        return this.f3474e;
    }

    public abstract E remove(int i5);

    public boolean remove(Object obj) {
        c();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        c();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        c();
        return super.retainAll(collection);
    }
}
