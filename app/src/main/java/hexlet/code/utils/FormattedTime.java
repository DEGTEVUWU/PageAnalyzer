package hexlet.code.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormattedTime {
    public static String formattedTime(Timestamp fullFormatCurrentTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String formattedDateTime = dateFormat.format(fullFormatCurrentTime);
        return formattedDateTime;
    }
    public static Timestamp currentTime() {
        Date actualDate = new Date();
        Timestamp currentDate =  new Timestamp(actualDate.getTime());
        return currentDate;
    }
}
