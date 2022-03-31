package pl.javastart.tj.daysinmonth;


import java.time.YearMonth;

public class MonthCalculator {

    public int getDayCount(int year, int month) {
        return YearMonth.of(year, month).lengthOfMonth();
    }
}
