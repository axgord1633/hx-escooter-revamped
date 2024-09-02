package y1;

import java.util.Arrays;
import java.util.UUID;

public class g extends h {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f7742a;

    public g(UUID uuid, Integer num, byte[] bArr) {
        super(uuid, num);
        this.f7742a = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return (obj instanceof h) && super.equals(obj);
        }
        if (!super.equals(obj)) {
            return false;
        }
        return Arrays.equals(this.f7742a, ((g) obj).f7742a);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(this.f7742a);
    }

    public String toString() {
        return "CharacteristicChangedEvent{UUID=" + ((UUID) this.first).toString() + ", instanceId=" + ((Integer) this.second).toString() + ", data=" + Arrays.toString(this.f7742a) + '}';
    }
}
