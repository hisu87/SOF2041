/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hisu.edusys.utils;

/**
 *
 * @author numpa
 */
public class msgbox {

    public static void alert(String message) {
        javax.swing.JOptionPane.showMessageDialog(null, message);
    }

    public static boolean confirm(String message) {
        int result = javax.swing.JOptionPane.showConfirmDialog(null, message);
        return result == javax.swing.JOptionPane.YES_OPTION;
    }

    public static String prompt(String message) {
        return javax.swing.JOptionPane.showInputDialog(null, message);
    }
}
