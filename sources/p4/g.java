package p4;

import i4.v;
import j4.c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

class g extends i {

    /* renamed from: c  reason: collision with root package name */
    private final Method f6577c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f6578d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f6579e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f6580f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f6581g;

    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f6582a;

        /* renamed from: b  reason: collision with root package name */
        boolean f6583b;

        /* renamed from: c  reason: collision with root package name */
        String f6584c;

        a(List<String> list) {
            this.f6582a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = c.f5476b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f6583b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f6582a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                    Object obj3 = objArr[0];
                    if (obj3 instanceof List) {
                        List list = (List) obj3;
                        int size = list.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= size) {
                                obj2 = this.f6582a.get(0);
                                break;
                            } else if (this.f6582a.contains(list.get(i5))) {
                                obj2 = list.get(i5);
                                break;
                            } else {
                                i5++;
                            }
                        }
                        String str = (String) obj2;
                        this.f6584c = str;
                        return str;
                    }
                }
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f6584c = (String) objArr[0];
                return null;
            }
        }
    }

    g(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f6577c = method;
        this.f6578d = method2;
        this.f6579e = method3;
        this.f6580f = cls;
        this.f6581g = cls2;
    }

    public static i u() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            return new g(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    public void a(SSLSocket sSLSocket) {
        try {
            this.f6579e.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw c.b("unable to remove alpn", e5);
        }
    }

    public void g(SSLSocket sSLSocket, String str, List<v> list) {
        List<String> b5 = i.b(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(i.class.getClassLoader(), new Class[]{this.f6580f, this.f6581g}, new a(b5));
            this.f6577c.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw c.b("unable to set alpn", e5);
        }
    }

    @Nullable
    public String n(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f6578d.invoke((Object) null, new Object[]{sSLSocket}));
            boolean z4 = aVar.f6583b;
            if (!z4 && aVar.f6584c == null) {
                i.l().s(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (z4) {
                return null;
            } else {
                return aVar.f6584c;
            }
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw c.b("unable to get selected protocol", e5);
        }
    }
}
