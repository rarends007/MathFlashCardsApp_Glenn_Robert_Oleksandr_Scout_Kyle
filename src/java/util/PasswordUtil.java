/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

/**
 *
 * @author raren
 */
public class PasswordUtil {
    /*
    This code uses SHA-256. If this algorithm isn't available to you, 
    you can try a weaker level of encryption such as SHA-128. -> pg 532
    */
    public static String hashPassword(String password)
        throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] mdArray = md.digest();
        StringBuilder ab = new StringBuilder(mdArray.length * 2);
        for (byte b: mdArray) {
           int v = b & 0xff; 
           if (v < 16) {
               ab.append('0');
           }
           ab.append(Integer.toHexString(v));
        }
        return ab.toString();
    }
    
    public static String getSalt() {
        Random r = new SecureRandom();
        byte[] saltBytes = new byte[32];
        r.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);

    }
    
    public static String hashAndSaltPassword(String password) //when making a login function, I will need to first extract the hash and then run it through this function, then compare the two hashes to eachother. Since as long as the password and salt are the same, my hashing algo will always gen the same hash
            throws NoSuchAlgorithmException{
        String salt = getSalt();
        String hashedPass =  hashPassword(password + salt);
        
        return hashedPass + "*||SH||*" + salt;
    }
}
