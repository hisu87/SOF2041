/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hisu.edusys.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author numpa
 */
public class Ximage {

    public static Image getAppIcon() {
        URL url = new Ximage().getClass().getResource("/com/hisu/edusys/icons/fpt.png");
        return new ImageIcon(url).getImage();
    }

    public static void save(File src){
        File dir = new File("logos",src.getName());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try{
            Path source = Paths.get(src.getAbsolutePath());
            Path destination = Paths.get(dir.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static ImageIcon read(String filename){
        File path = new File("logos",filename);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
    }
}
