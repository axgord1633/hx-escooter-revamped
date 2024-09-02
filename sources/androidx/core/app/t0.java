package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import com.yalantis.ucrop.BuildConfig;

public class t0 {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f1619a;

    /* renamed from: b  reason: collision with root package name */
    IconCompat f1620b;

    /* renamed from: c  reason: collision with root package name */
    String f1621c;

    /* renamed from: d  reason: collision with root package name */
    String f1622d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1623e;

    /* renamed from: f  reason: collision with root package name */
    boolean f1624f;

    static class a {
        static t0 a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.a(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        static Person b(t0 t0Var) {
            return new Person.Builder().setName(t0Var.c()).setIcon(t0Var.a() != null ? t0Var.a().o() : null).setUri(t0Var.d()).setKey(t0Var.b()).setBot(t0Var.e()).setImportant(t0Var.f()).build();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        CharSequence f1625a;

        /* renamed from: b  reason: collision with root package name */
        IconCompat f1626b;

        /* renamed from: c  reason: collision with root package name */
        String f1627c;

        /* renamed from: d  reason: collision with root package name */
        String f1628d;

        /* renamed from: e  reason: collision with root package name */
        boolean f1629e;

        /* renamed from: f  reason: collision with root package name */
        boolean f1630f;

        public t0 a() {
            return new t0(this);
        }

        public b b(boolean z4) {
            this.f1629e = z4;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f1626b = iconCompat;
            return this;
        }

        public b d(boolean z4) {
            this.f1630f = z4;
            return this;
        }

        public b e(String str) {
            this.f1628d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f1625a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f1627c = str;
            return this;
        }
    }

    t0(b bVar) {
        this.f1619a = bVar.f1625a;
        this.f1620b = bVar.f1626b;
        this.f1621c = bVar.f1627c;
        this.f1622d = bVar.f1628d;
        this.f1623e = bVar.f1629e;
        this.f1624f = bVar.f1630f;
    }

    public IconCompat a() {
        return this.f1620b;
    }

    public String b() {
        return this.f1622d;
    }

    public CharSequence c() {
        return this.f1619a;
    }

    public String d() {
        return this.f1621c;
    }

    public boolean e() {
        return this.f1623e;
    }

    public boolean f() {
        return this.f1624f;
    }

    public String g() {
        String str = this.f1621c;
        if (str != null) {
            return str;
        }
        if (this.f1619a == null) {
            return BuildConfig.FLAVOR;
        }
        return "name:" + this.f1619a;
    }

    public Person h() {
        return a.b(this);
    }
}
