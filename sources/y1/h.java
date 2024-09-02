package y1;

import android.util.Pair;
import java.util.UUID;

public class h extends Pair<UUID, Integer> {
    public h(UUID uuid, Integer num) {
        super(uuid, num);
    }

    public String toString() {
        return "CharacteristicNotificationId{UUID=" + ((UUID) this.first).toString() + ", instanceId=" + ((Integer) this.second).toString() + '}';
    }
}
