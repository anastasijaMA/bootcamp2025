package module4.activity;

import java.util.Date;

public class DateActivity   {
    Date d;
    public static void main(String[] args) {
        Date date = getDate();
        System.out.println("Today’s date: " + date.toString());
    }

    public static Date getDate() {
       return new Date();
    }

}
