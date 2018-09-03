/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.eoc.web.client.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.MessageDigest;

public abstract class EncryptionUtil {



    public static String encryptToMD5(String text) {
        try {

            StringBuffer hexString = new StringBuffer();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes());

            byte[] hash = md.digest();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10)
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                else
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
            }

            text = hexString.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;

    }

    public static String encryptToBCrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public static void main(String []a){
        System.out.println(encryptToBCrypt("a"));
    }
}
