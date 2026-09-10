
class Solution {

    public String dayOfTheWeek(int day, int month, int year) {

        String[] week = {
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday"
        };
        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };
        int totalDays = 0;
        for (int y = 1971; y < year; y++) {
            if (isLeapYear(y)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }
        for (int m = 1; m < month; m++) {
            totalDays += days[m - 1];

            if (m == 2 && isLeapYear(year)) {
                totalDays++;
            }
        }
        totalDays += day - 1;
        int dayIndex = (5 + totalDays) % 7;
        return week[dayIndex];
    }
    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}

