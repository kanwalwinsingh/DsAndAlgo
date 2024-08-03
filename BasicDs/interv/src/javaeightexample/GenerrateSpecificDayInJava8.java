package javaeightexample;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class GenerrateSpecificDayInJava8 {
    public static void main(String[] args) {
        //Get the current date
        LocalDate today = LocalDate.now();
        //Calculate the next or today Sunday
        LocalDate nextSaturday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println("Today's date: "+ today);
        System.out.println("Next Saturday: "+ nextSaturday);
        //This will
         nextSaturday = today.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println("Today's date: "+ today);
        System.out.println("Next Saturday: "+ nextSaturday);
    }
}
