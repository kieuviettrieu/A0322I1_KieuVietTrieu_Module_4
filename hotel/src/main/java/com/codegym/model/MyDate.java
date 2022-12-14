package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MyDate {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date firstDay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastDay;

    public MyDate() {
    }

    public Date getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(Date firstDay) {
        this.firstDay = firstDay;
    }

    public Date getLastDay() {
        return lastDay;
    }

    public void setLastDay(Date lastDay) {
        this.lastDay = lastDay;
    }
}
