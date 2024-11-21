package aula6;

public class DateYMD {

  int year;
  int month;
  int day;

  public DateYMD(int nyear, int nmonth, int nday) {
    this.year = nyear;
    this.month = nmonth;
    this.day = nday;
  }

  public void date(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  static boolean validMonth(int month) {
    if (1 <= month && month <= 12) {
      return true;
    } else {
      return false;
    }
  }

  static int monthDays(int month, int year) {

    int days = 0;

    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
      days = 31;
    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
      days = 30;
    } else if (month == 2) {
      if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
        days = 29;
      } else {
        days = 28;
      }
    }
    return days;
  }

  static boolean leapYear(int year) {
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
      return true;
    } else {
      return false;
    }
  }

  static boolean valid(int day, int month, int year) {
    boolean validation = false;
    if (year > 0) {
      if (month >= 1 && month <= 12) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
          if (day >= 1 && day <= 31) {
            validation = true;
          } else {
            validation = false;
          }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
          if (day >= 1 && day <= 30) {
            validation = true;
          } else {
            validation = false;
          }
        } else if (month == 2) {
          if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            if (day >= 1 && day <= 29) {
              validation = true;
            } else {
              validation = false;
            }
          } else {
            if (day >= 1 && day <= 28) {
              validation = true;
            } else {
              validation = false;
            }
          }
        }
      }
    } else {
      validation = false;
    }
    return validation;
  }

  @Override
  public String toString() {
    return String.format("%04d-%02d-%02d", year, month, day);
  }

  public String getDate() {
    return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
  }

  public void setDate(int nday, int nmonth, int nyear) {
    if (valid(nday, nmonth, nyear) == true) {
      this.day = nday;
      this.month = nmonth;
      this.year = nyear;
    } else {
      System.out.println("Data inválida.");
    }
  }

  public void incrementDate() {
    day++;
    if (day > monthDays(month, year)) {
      month++;
      day = 1;
      if (month > 12) {
        year++;
        month = 1;
      }
    }
    setDate(day, month, year);
  }

  public void decrementDate() {
    day--;
    if (day < 1) {
      month--;
      day = monthDays(month, year);
      if (month < 1) {
        year--;
        month = 12;
        day = monthDays(month, year);
      }
    }
    setDate(day, month, year);
  }
}
