package com.hisu.edusys.dao;

import com.hisu.edusys.entity.hocvien;
import com.hisu.edusys.utils.Xjdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author numpa
 */
public class hocvienDAO  extends EduSYSDAO<hocvien, String>{
    
    String INSERT_SQL = "INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (?, ?, ?, ?) ";
    String UPDATE_SQL = "UPDATE HocVien Set MaKH=?, MaNH=?, Diem=? WHERE MaHV=?";
    String DELETE_SQL = "DELETE FROM HocVien WHERE MaHV=?";
    String SELECT_ALL_SQL = "SELECT * FROM HocVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM HocVien WHERE MaHV=?";

    @Override
    public void insert(hocvien entity) {
        Xjdbc.executeUpdate(INSERT_SQL,
                entity.getMaKH(),
                entity.getMaNH(),
                entity.getDiem());
    }


    @Override 
    public void update(hocvien entity) {
        Xjdbc.executeUpdate(UPDATE_SQL,
                entity.getMaKH(),
                entity.getMaNH(),
                entity.getDiem(),
                entity.getMaHV());
    }

    @Override
    public void delete(String id) {
        Xjdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public hocvien selectById(String id) {
        List<hocvien> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<hocvien> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    
}
