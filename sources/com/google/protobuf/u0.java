package com.google.protobuf;

import com.google.protobuf.z;
import com.yalantis.ucrop.BuildConfig;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class u0 {
    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static boolean b(Object obj) {
        Object obj2;
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue() == CropImageView.DEFAULT_ASPECT_RATIO;
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d;
        }
        if (obj instanceof String) {
            obj2 = BuildConfig.FLAVOR;
        } else if (obj instanceof i) {
            obj2 = i.f3533f;
        } else if (obj instanceof s0) {
            return obj == ((s0) obj).getDefaultInstanceForType();
        } else {
            if (obj instanceof Enum) {
                return ((Enum) obj).ordinal() == 0;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    static final void c(StringBuilder sb, int i5, String str, Object obj) {
        String a5;
        if (obj instanceof List) {
            for (Object c5 : (List) obj) {
                c(sb, i5, str, c5);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry c6 : ((Map) obj).entrySet()) {
                c(sb, i5, str, c6);
            }
        } else {
            sb.append(10);
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                a5 = n1.c((String) obj);
            } else if (obj instanceof i) {
                sb.append(": \"");
                a5 = n1.a((i) obj);
            } else {
                if (obj instanceof z) {
                    sb.append(" {");
                    d((z) obj, sb, i5 + 2);
                    sb.append("\n");
                    while (i6 < i5) {
                        sb.append(' ');
                        i6++;
                    }
                } else if (obj instanceof Map.Entry) {
                    sb.append(" {");
                    Map.Entry entry = (Map.Entry) obj;
                    int i8 = i5 + 2;
                    c(sb, i8, "key", entry.getKey());
                    c(sb, i8, "value", entry.getValue());
                    sb.append("\n");
                    while (i6 < i5) {
                        sb.append(' ');
                        i6++;
                    }
                } else {
                    sb.append(": ");
                    sb.append(obj.toString());
                    return;
                }
                sb.append("}");
                return;
            }
            sb.append(a5);
            sb.append('\"');
        }
    }

    private static void d(s0 s0Var, StringBuilder sb, int i5) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : s0Var.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String substring = str.startsWith("get") ? str.substring(3) : str;
            boolean z4 = true;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String str2 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 4);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    c(sb, i5, a(str2), z.invokeOrDie(method2, s0Var, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String str3 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    c(sb, i5, a(str3), z.invokeOrDie(method3, s0Var, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + substring)) != null) {
                if (substring.endsWith("Bytes")) {
                    if (hashMap.containsKey("get" + substring.substring(0, substring.length() - 5))) {
                    }
                }
                String str4 = substring.substring(0, 1).toLowerCase() + substring.substring(1);
                Method method4 = (Method) hashMap.get("get" + substring);
                Method method5 = (Method) hashMap.get("has" + substring);
                if (method4 != null) {
                    Object invokeOrDie = z.invokeOrDie(method4, s0Var, new Object[0]);
                    if (method5 != null) {
                        z4 = ((Boolean) z.invokeOrDie(method5, s0Var, new Object[0])).booleanValue();
                    } else if (b(invokeOrDie)) {
                        z4 = false;
                    }
                    if (z4) {
                        c(sb, i5, a(str4), invokeOrDie);
                    }
                }
            }
        }
        if (s0Var instanceof z.c) {
            Iterator<Map.Entry<z.d, Object>> r5 = ((z.c) s0Var).f3807e.r();
            while (r5.hasNext()) {
                Map.Entry next = r5.next();
                c(sb, i5, "[" + ((z.d) next.getKey()).a() + "]", next.getValue());
            }
        }
        q1 q1Var = ((z) s0Var).unknownFields;
        if (q1Var != null) {
            q1Var.p(sb, i5);
        }
    }

    static String e(s0 s0Var, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        d(s0Var, sb, 0);
        return sb.toString();
    }
}
