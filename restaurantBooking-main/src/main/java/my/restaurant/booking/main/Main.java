package my.restaurant.booking.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("ok sikeresen lefutott");
        System.out.println( LocalDateTime.parse("2017-09-01 11:30:05", DateTimeFormatter.ofPattern("yyyy-LL-dd HH:mm:ss")));
 
    }
}
