/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hisu.edusys.utils;

import java.text.SimpleDateFormat;

/**
 *
 * @author numpa
 */
public class Xdate {

    public static SimpleDateFormat formatter = new SimpleDateFormat();

    public static java.sql.Date toDate(String date, String pattern) {
        try {
            formatter.applyPattern(pattern);
            return new java.sql.Date(formatter.parse(date).getTime());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(java.sql.Date date, String pattern) {
        formatter.applyPattern(pattern);
        return formatter.format(date);
    }

    public static java.sql.Date addDays(java.sql.Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }
}
