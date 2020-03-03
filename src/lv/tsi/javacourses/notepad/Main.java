package lv.tsi.javacourses.notepad;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy  HH:mm", Locale.ENGLISH);

    public static void main(String[] args) {
        printFlightInfo(
                "28-Feb-2020 23:55", "Europe/London",
                "01-Mar-2020 12:03", "Australia/Sydney"
    );
    }
    // for (var z : ZoneId.getAvailableZoneIds()) {
    //    System.out.println(z);
    //


    //printFlightInfo(
    // "28-Feb-2020 23:55", depZone:"Europe/London",
    //  arrTime"01-Mar-2020 12:03", arrZone: "Australia/Sydney");

    //  "28-Feb-2020 23:55""Europe/London",
    //"01-Mar-2020 12:03 "Australia/Sydney""

    private static void printFlightInfo(String depTime, String depZone,
                                        String arrTime, String arrZone) {
        var depZonedTime = createZonedDateTime(depTime, depZone);
        var arrZonedTime = createZonedDateTime(arrTime, arrZone);
        Duration dur = Duration.between(depZonedTime, arrZonedTime);
        System.out.println(dur);
    }


    private static ZonedDateTime createZonedDateTime(String strTime, String strZone) {
        LocalDateTime dt = LocalDateTime.parse(strTime, format);
        ZoneId z = ZoneId.of(strZone);
        return ZonedDateTime.of(dt, z);
    }
}
