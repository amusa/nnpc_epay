/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Ayemi
 */
public class DateDiff {

    private int weekDiff;
    private int yearDiff;
    private int monthDiff;

    public DateDiff(Date d1, Date d2) {
        try {
            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar1.setTime(d1);
            calendar2.setTime(d2);
            long ldate1 = d1.getTime() + calendar1.get(Calendar.ZONE_OFFSET) + calendar1.get(Calendar.DST_OFFSET);
            long ldate2 = d2.getTime() + calendar2.get(Calendar.ZONE_OFFSET) + calendar2.get(Calendar.DST_OFFSET);

            // Use integer calculation, truncate the decimals
            int hr1 = (int) (ldate1 / 3600000); //60*60*1000
            int hr2 = (int) (ldate2 / 3600000);

            int days1 = (int) hr1 / 24;
            int days2 = (int) hr2 / 24;

            int dateDiff = days2 - days1;
            int weekOffset = (calendar2.get(Calendar.DAY_OF_WEEK) - calendar1.get(Calendar.DAY_OF_WEEK)) < 0 ? 1 : 0;
            weekDiff = dateDiff / 7 + weekOffset;
            yearDiff = calendar2.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR);
            monthDiff = yearDiff * 12 + calendar2.get(Calendar.MONTH) - calendar1.get(Calendar.MONTH);
        } catch (NullPointerException npe) {
        }

    }

    public int getMonthDiff() {
        return monthDiff;
    }

    public int getWeekDiff() {
        return weekDiff;
    }

    public int getYearDiff() {
        return yearDiff;
    }
}
