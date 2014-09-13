package ee.bootcamp.assignment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String format(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);
    }
}
