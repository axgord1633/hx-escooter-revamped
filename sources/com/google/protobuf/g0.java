package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class g0 extends c<String> implements h0, RandomAccess {

    /* renamed from: g  reason: collision with root package name */
    private static final g0 f3526g;

    /* renamed from: h  reason: collision with root package name */
    public static final h0 f3527h;

    /* renamed from: f  reason: collision with root package name */
    private final List<Object> f3528f;

    static {
        g0 g0Var = new g0();
        f3526g = g0Var;
        g0Var.b();
        f3527h = g0Var;
    }

    public g0() {
        this(10);
    }

    public g0(int i5) {
        this((ArrayList<Object>) new ArrayList(i5));
    }

    private g0(ArrayList<Object> arrayList) {
        this.f3528f = arrayList;
    }

    private static String f(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof i ? ((i) obj).C() : b0.j((byte[]) obj);
    }

    public boolean addAll(int i5, Collection<? extends String> collection) {
        c();
        if (collection instanceof h0) {
            collection = ((h0) collection).j();
        }
        boolean addAll = this.f3528f.addAll(i5, collection);
        this.modCount++;
        return addAll;
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public void clear() {
        c();
        this.f3528f.clear();
        this.modCount++;
    }

    public void d(i iVar) {
        c();
        this.f3528f.add(iVar);
        this.modCount++;
    }

    /* renamed from: e */
    public void add(int i5, String str) {
        c();
        this.f3528f.add(i5, str);
        this.modCount++;
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public h0 g() {
        return k() ? new s1(this) : this;
    }

    public Object h(int i5) {
        return this.f3528f.get(i5);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public String get(int i5) {
        Object obj = this.f3528f.get(i5);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            String C = iVar.C();
            if (iVar.r()) {
                this.f3528f.set(i5, C);
            }
            return C;
        }
        byte[] bArr = (byte[]) obj;
        String j5 = b0.j(bArr);
        if (b0.g(bArr)) {
            this.f3528f.set(i5, j5);
        }
        return j5;
    }

    public List<?> j() {
        return Collections.unmodifiableList(this.f3528f);
    }

    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    /* renamed from: l */
    public g0 a(int i5) {
        if (i5 >= size()) {
            ArrayList arrayList = new ArrayList(i5);
            arrayList.addAll(this.f3528f);
            return new g0((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: m */
    public String remove(int i5) {
        c();
        Object remove = this.f3528f.remove(i5);
        this.modCount++;
        return f(remove);
    }

    /* renamed from: n */
    public String set(int i5, String str) {
        c();
        return f(this.f3528f.set(i5, str));
    }

    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public int size() {
        return this.f3528f.size();
    }
}
