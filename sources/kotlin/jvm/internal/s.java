package kotlin.jvm.internal;

import z3.c;
import z3.d;
import z3.e;
import z3.f;

public class s {
    public e a(i iVar) {
        return iVar;
    }

    public c b(Class cls) {
        return new e(cls);
    }

    public d c(Class cls, String str) {
        return new m(cls, str);
    }

    public f d(n nVar) {
        return nVar;
    }

    public String e(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String f(l lVar) {
        return e(lVar);
    }
}
