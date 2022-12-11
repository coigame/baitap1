package vpbank.ThreadBai2.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date toDate(String Date){
        DateFormat dateFormat = new SimpleDateFormat(Constant.DATE_FORMAT);
        try {
            return dateFormat.parse(Date);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
