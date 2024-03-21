package hexlet.code.utils;

import java.sql.Timestamp;
import java.util.Date;

public class CurrentTime {
    public static Timestamp currentTime() {
        Date actualDate = new Date();
        Timestamp currentDate =  new Timestamp(actualDate.getTime());
        return currentDate;
    }
}
