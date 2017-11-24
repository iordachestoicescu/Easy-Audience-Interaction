package com.endava.easyaudienceinteraction.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Laurentiu Iordache
 */
public class Crypt {

    private Crypt() {}

    public static String cryptWithMD5(String pass){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            StringBuffer sb = new StringBuffer();

            md.reset();
            byte[] digested = md.digest(pass.getBytes());
            for(int i = 0; i<digested.length; i++){
                sb.append(Integer.toHexString(0xFF & digested[i]));
            }

            return sb.toString();
        }catch(NoSuchAlgorithmException nsae){
            System.out.println("Something went wrong");
        }
        return null;
    }
}
