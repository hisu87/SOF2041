package com.hisu.edusys.utils;

import com.hisu.edusys.entity.nhanvien;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author numpa
 */
public class auth {

    public static nhanvien user = null;

    public static void clear() {
        auth.user = null;
    }

    public static boolean isLogin() {
        return auth.user != null;
    }

    public static boolean isManager() {
        return auth.isLogin() && user.isVaiTro();
    }

}