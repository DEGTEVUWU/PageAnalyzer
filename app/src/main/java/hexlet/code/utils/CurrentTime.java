package hexlet.code.utils;

import java.sql.Timestamp;
import java.util.Date;

public class CurrentTime {
    public static Timestamp currentTime() {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        String formattedDateTime = dateFormat.format(timestamp);
//        return Timestamp.valueOf(formattedDateTime);

        Date actualDate = new Date();
        Timestamp currentDate =  new Timestamp(actualDate.getTime());
        return currentDate;
    }
}
