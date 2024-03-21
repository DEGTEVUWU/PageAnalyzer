package hexlet.code.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FormattedTime {
    public static String formattedTime(Timestamp fullFormatCurrentTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String formattedDateTime = dateFormat.format(fullFormatCurrentTime);
        return formattedDateTime;
    }
}
