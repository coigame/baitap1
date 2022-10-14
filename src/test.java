

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TVD
 */
public class test {

    public static void main(String[] args) {
        Date date = new Date();
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("dd/MM/yyyy: " + dateFormat.format(date));
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("MM/dd/yyyy: " + dateFormat.format(date));
        dateFormat = new SimpleDateFormat("hh:mm:ss MM/dd/yyyy");
        System.out.println("hh:mm:ss MM/dd/yyyy: " + dateFormat.format(date));
        dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
        System.out.println("HH:mm:ss MM/dd/yyyy: " + dateFormat.format(date));
        dateFormat = new SimpleDateFormat("HH:mm:ss.SSS MM/dd/yyyy");
        System.out.println("HH:mm:ss.SSS MM/dd/yyyy: " + dateFormat.format(date));
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("HH:mm:ss: " + dateFormat.format(date));

    }

}