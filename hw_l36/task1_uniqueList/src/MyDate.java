public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%4d", day, month, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyDate myDate = (MyDate) o;
        return day == myDate.day && month == myDate.month && year == myDate.year;
    }

    @Override
    public int hashCode() {
        int result = day;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }
}
