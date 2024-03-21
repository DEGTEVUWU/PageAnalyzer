package hexlet.code.utils;

import java.sql.Timestamp;
import java.util.Date;

public class CurrentTime {
    public static Timestamp currentTime() {
        Date actualDate = new Date();
        return new Timestamp(actualDate.getTime());
    }
}
