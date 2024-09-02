package d2;

public final /* synthetic */ class n {

    class a implements j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f4298a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f4299b;

        a(o oVar, i iVar) {
            this.f4299b = oVar;
            this.f4298a = iVar;
        }

        public int a() {
            return this.f4298a.f4276c;
        }

        public boolean b() {
            return this.f4298a.F();
        }
    }

    public static void a(o oVar, i iVar, Runnable runnable) {
        oVar.c(new k(iVar == null ? null : new a(oVar, iVar), runnable));
    }

    public static o b(String str, int i5, int i6) {
        return i5 == 1 ? new s(str, i6) : new q(str, i5, i6);
    }
}
