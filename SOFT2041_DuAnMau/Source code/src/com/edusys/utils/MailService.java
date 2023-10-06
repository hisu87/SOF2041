/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author numpa
 */
public class MailService {
    public static void MailService(String subject, String body){
        
    try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", "587");

            String accountName = "numpadagain@gmail.com";
            String accountPass = "qymrtzigkqkcigss";

            Session s = Session.getInstance(p, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(accountName, accountPass);
                }
            });

            String from = accountName;
            String to = "hisu3309@gmail.com";
//            String subject = subject;
//            String body = body;

            MimeMessage ms = new MimeMessage(s);
            ms.setFrom(new InternetAddress(from));
            ms.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//            ms.setRecipients(Message.RecipientType.CC, InternetAddress.parse("hisu3309@gmail.com"));

            MimeBodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(body, "text/html; charset=utf-8");
            ms.setSubject(subject);
            ms.setText(body);

            MimeBodyPart filePart = new MimeBodyPart();

//            File file = new File(path);
//
//            FileDataSource fds = new FileDataSource(file);
//            filePart.setDataHandler(new DataHandler(fds));
//            filePart.setFileName(file.getName());

            MimeMultipart mp = new MimeMultipart();
            mp.addBodyPart(contentPart);
//            mp.addBodyPart(filePart);
            ms.setContent(mp);

            Transport.send(ms);
//            String manv = Auth.user.getMaNV();
//             Auth.user.setMatKhau("123");
//            dao.update(Auth.user);
            JOptionPane.showMessageDialog(null, "Reset Success");

        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}