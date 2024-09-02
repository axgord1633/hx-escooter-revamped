package u3;

import kotlin.jvm.internal.d;
import kotlin.jvm.internal.k;
import z3.c;

public final class a {
    public static final <T> Class<T> a(c<T> cVar) {
        k.e(cVar, "<this>");
        Class<?> b5 = ((d) cVar).b();
        k.c(b5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return b5;
    }

    public static final <T> Class<T> b(c<T> cVar) {
        k.e(cVar, "<this>");
        Class b5 = ((d) cVar).b();
        if (!b5.isPrimitive()) {
            k.c(b5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return b5;
        }
        String name = b5.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    b5 = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    b5 = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    b5 = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    b5 = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    b5 = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    b5 = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    b5 = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    b5 = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    b5 = Short.class;
                    break;
                }
                break;
        }
        k.c(b5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return b5;
    }
}
