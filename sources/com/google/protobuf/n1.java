package com.google.protobuf;

final class n1 {

    static class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f3642a;

        a(i iVar) {
            this.f3642a = iVar;
        }

        public byte a(int i5) {
            return this.f3642a.f(i5);
        }

        public int size() {
            return this.f3642a.size();
        }
    }

    private interface b {
        byte a(int i5);

        int size();
    }

    static String a(i iVar) {
        return b(new a(iVar));
    }

    static String b(b bVar) {
        String str;
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i5 = 0; i5 < bVar.size(); i5++) {
            int a5 = bVar.a(i5);
            if (a5 == 34) {
                str = "\\\"";
            } else if (a5 == 39) {
                str = "\\'";
            } else if (a5 != 92) {
                switch (a5) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (a5 < 32 || a5 > 126) {
                            sb.append('\\');
                            sb.append((char) (((a5 >>> 6) & 3) + 48));
                            sb.append((char) (((a5 >>> 3) & 7) + 48));
                            a5 = (a5 & 7) + 48;
                        }
                        sb.append((char) a5);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    static String c(String str) {
        return a(i.o(str));
    }
}
