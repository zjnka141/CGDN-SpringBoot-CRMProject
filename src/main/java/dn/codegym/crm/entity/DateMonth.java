package dn.codegym.crm.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateMonth {
    private List<Integer> dates;
    private List<Integer> months;
    private List<Integer> years;

    public DateMonth() {
    }

    public List<Integer> getDates() {
        this.dates = new ArrayList<>();
        for(int i=1; i<= 31; i++){
        dates.add(i);
        }
        return dates;
    }

    public void setDates(List<Integer> dates) {
        this.dates = dates;
    }

    public List<Integer> getMonths() {
        this.months = new ArrayList<>() ;
        for(int i= 1 ; i <= 12; i++){
          months.add(i);
        }
        return months;
    }

    public void setMonths(List<Integer> months) {
        this.months = months;
    }

    public List<Integer> getYears() {
        this.years = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        for(int i= 1950; i <= localDate.getYear(); i++){
            years.add(i);
        }

        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public static void main(String[] args) {
        DateMonth dateMonth = new DateMonth();
        List<Integer> dates = dateMonth.getDates();
        for (int date : dates) {
            System.out.println(date);
        }
        for (int month : dateMonth.getMonths()) {
            System.out.println("Thang" + " " + month);
        }
        LocalDate date = LocalDate.now();
        System.out.println(date.getYear());
        for (int year : dateMonth.getYears()) {
            System.out.println("Year" + year);
        }
        LocalDate date1 = LocalDate.of(2019,07,03);
        System.out.println(date1.getDayOfMonth());
    }
}
