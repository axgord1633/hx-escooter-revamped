package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class s1 extends AbstractList<String> implements h0, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final h0 f3660e;

    class a implements ListIterator<String> {

        /* renamed from: e  reason: collision with root package name */
        ListIterator<String> f3661e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f3662f;

        a(int i5) {
            this.f3662f = i5;
            this.f3661e = s1.this.f3660e.listIterator(i5);
        }

        /* renamed from: b */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public String next() {
            return this.f3661e.next();
        }

        /* renamed from: d */
        public String previous() {
            return this.f3661e.previous();
        }

        /* renamed from: e */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.f3661e.hasNext();
        }

        public boolean hasPrevious() {
            return this.f3661e.hasPrevious();
        }

        public int nextIndex() {
            return this.f3661e.nextIndex();
        }

        public int previousIndex() {
            return this.f3661e.previousIndex();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    class b implements Iterator<String> {

        /* renamed from: e  reason: collision with root package name */
        Iterator<String> f3664e;

        b() {
            this.f3664e = s1.this.f3660e.iterator();
        }

        /* renamed from: b */
        public String next() {
            return this.f3664e.next();
        }

        public boolean hasNext() {
            return this.f3664e.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public s1(h0 h0Var) {
        this.f3660e = h0Var;
    }

    public void d(i iVar) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: e */
    public String get(int i5) {
        return (String) this.f3660e.get(i5);
    }

    public h0 g() {
        return this;
    }

    public Object h(int i5) {
        return this.f3660e.h(i5);
    }

    public Iterator<String> iterator() {
        return new b();
    }

    public List<?> j() {
        return this.f3660e.j();
    }

    public ListIterator<String> listIterator(int i5) {
        return new a(i5);
    }

    public int size() {
        return this.f3660e.size();
    }
}
